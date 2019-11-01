package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractInfoParameterBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractNormalUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractNormalUpdateCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ContractInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractNormalUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractNormalUpdateCommitInServiceBean;
import net.chintai.batch.common.domain.ShopKanri;
import net.chintai.batch.common.persistence.mapper.ShopKanriMapper;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ContractNormalUpdateCommitService の実装クラス。
 *
 * @author m-kashiyama
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractNormalUpdateCommitServiceImpl implements ContractNormalUpdateCommitService {

    /** 契約明細設定（数量なし）完了DAO */
    private ContractNormalUpdateCommitDao contractNormalUpdateCommitDao = null;

    /** 契約明細設定（数量なし）チェックDAO */
    private ContractInfoDao contractInfoDao = null;

    /** 未契約*/
    private static final String KEIYAKU_STOP = "0";

    /** 契約済*/
    private static final String KEIYAKU_SUMI = "1";

    // 排他制御用処理追加
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopKanriMapper shopKanrilMapper;

    // 排他制御用処理追加

    /**
     * ContractNormalUpdateCommitDaoを設定する
     * @param contractNormalUpdateCommitDao
     */
    public void setContractNormalUpdateCommitDao(ContractNormalUpdateCommitDao contractNormalUpdateCommitDao) {
        this.contractNormalUpdateCommitDao = contractNormalUpdateCommitDao;
    }

    /**
     * ContractInfoDaoを設定します。
     * @param contractInfoDao  contractInfoDao
     */
    public void setContractInfoDao(ContractInfoDao contractInfoDao) {
        this.contractInfoDao = contractInfoDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ContractNormalUpdateCommitService#contractNormalkUpdateCommit(net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractNormalUpdateCommitInServiceBean)
     */
    public void contractNormalkUpdateCommit(ContractNormalUpdateCommitInServiceBean inServiceBean)
            throws ApplicationException {

        ContractNormalUpdateCommitParamBean paramBean = new ContractNormalUpdateCommitParamBean();
        ContractInfoParameterBean selectParamBean = new ContractInfoParameterBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
            BeanUtils.copyProperties(selectParamBean, inServiceBean);

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 契約更新件数のチェック
        ContractInfo contractInfo = contractInfoDao.selectShopContractInfo(selectParamBean);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
            Date startDate = sdf.parse(inServiceBean.getShopKanriUpdDt());

            shopService.checkAndLockShopKanri(inServiceBean.getShopCd(),startDate);
        } catch (InProcessingException e) {
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0014", e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        if (contractInfo.getKeiyakuNo() != null) {

            paramBean.setKeiyakuNo(contractInfo.getKeiyakuNo());

            // 過去契約を終了する。
            int affected = contractNormalUpdateCommitDao.contractNormalUpdateCommit(paramBean);

            if (affected == 0){
                throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0014");
            }
        }

        if (KEIYAKU_SUMI.equals(inServiceBean.getKeiyakuFlag())) {
            // 新規契約情報を登録する。
            contractNormalUpdateCommitDao.contractNormalAddCommit(paramBean);
        }

        ShopKanri shopKanri = shopService.selectShopKanriByPrimaryKey(inServiceBean.getShopCd());
        shopKanri.setAdminUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdId(inServiceBean.getOperUserId());
        shopKanri.setUpdPg(inServiceBean.getUpdPg());
        shopKanrilMapper.updateByPrimaryKey(shopKanri);
    }
}