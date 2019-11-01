package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountAddCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountAddCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractInfoParameterBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ContractInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountAddCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountAddCommitInServiceBean;
import net.chintai.batch.common.domain.ShopKanri;
import net.chintai.batch.common.persistence.mapper.ShopKanriMapper;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ContractAmountAddCommitServiceの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountAddCommitServiceImpl implements
        ContractAmountAddCommitService {

    /** 契約明細詳細(契約数量あり)設定情報更新DAO */
    ContractAmountAddCommitDao contractAmountAddCommitDao;

    /** 契約明細設定チェックDAO */
    ContractInfoDao contractInfoDao = null;

    // 排他制御用処理追加
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopKanriMapper shopKanrilMapper;

    // 排他制御用処理追加

    /**
     * 契約明細詳細(契約数量あり)設定情報更新DAOを設定します。
     * @param contractAmountAddCommitDao 契約明細詳細(契約数量あり)設定情報更新DAO
     */
    public void setContractAmountAddCommitDao(
            ContractAmountAddCommitDao contractAmountAddCommitDao) {
        this.contractAmountAddCommitDao = contractAmountAddCommitDao;
    }

    /**
     * ContractInfoDaoを設定します。
     * @param contractInfoDao  contractInfoDao
     */
    public void setContractInfoDao(ContractInfoDao contractInfoDao) {
        this.contractInfoDao = contractInfoDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountAddCommitService#insertContractAmount(net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountAddCommitInServiceBean)
     */
    public void insertContractAmount(ContractAmountAddCommitInServiceBean inBean)
            throws ApplicationException {

        ContractAmountAddCommitParamBean paramInsertDetailBean =
                new ContractAmountAddCommitParamBean();
        ContractInfoParameterBean selectParamBean = new ContractInfoParameterBean();
        try {
            BeanUtils.copyProperties(paramInsertDetailBean, inBean);
            BeanUtils.copyProperties(selectParamBean, inBean);

            String keiyakuStartDt =inBean.getKeiyakuStartYear()
                    + inBean.getKeiyakuStartMonth()
                    + inBean.getKeiyakuStartDay()
                    + inBean.getKeiyakuStartHour()
                    + "0000";

	        String keiyakuEndDt = inBean.getKeiyakuEndYear()
	                    + inBean.getKeiyakuEndMonth()
	                    + inBean.getKeiyakuEndDay()
	                    + inBean.getKeiyakuEndHour()
	                    + "0000";

	        if (keiyakuEndDt == null || "0000".equals(keiyakuEndDt)) {
	            keiyakuEndDt = "99999999999999";
	        }

	        paramInsertDetailBean.setKeiyakuStartDt(keiyakuStartDt);
	        paramInsertDetailBean.setKeiyakuEndDt(keiyakuEndDt);

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
            Date startDate = sdf.parse(inBean.getShopKanriUpdDt());

            shopService.checkAndLockShopKanri(inBean.getShopCd(),startDate);
        } catch (InProcessingException e) {
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0014", e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
       }

        // 契約更新件数のチェック
        ContractInfo contractInfo = contractInfoDao.selectShopContractInfo(selectParamBean);

        if (contractInfo.getKeiyakuNo() == null) {
            contractAmountAddCommitDao.insertContractAmount(paramInsertDetailBean);
        }

        contractAmountAddCommitDao.insertContractAmountDetail(paramInsertDetailBean);

        ShopKanri shopKanri = shopService.selectShopKanriByPrimaryKey(inBean.getShopCd());
        shopKanri.setAdminUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdId(inBean.getUserId());
        shopKanri.setUpdPg(inBean.getPgName());

        shopKanrilMapper.updateByPrimaryKey(shopKanri);
    }
}
