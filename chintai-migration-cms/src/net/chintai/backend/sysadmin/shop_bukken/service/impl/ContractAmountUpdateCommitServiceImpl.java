package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountUpdateCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountUpdateCommitInServiceBean;
import net.chintai.batch.common.domain.ShopKanri;
import net.chintai.batch.common.persistence.mapper.ShopKanriMapper;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ContractAmountUpdateCommitServiceの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountUpdateCommitServiceImpl implements
        ContractAmountUpdateCommitService {

    /** 契約明細詳細(契約数量あり)設定情報更新DAO */
    ContractAmountUpdateCommitDao contractAmountUpdateCommitDao;

    // 排他制御用処理追加
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopKanriMapper shopKanrilMapper;

    // 排他制御用処理追加

    /**
     * 契約明細詳細(契約数量あり)設定情報更新DAOを設定します。
     * @param contractAmountUpdateCommitDao 契約明細詳細(契約数量あり)設定情報更新DAO
     */
    public void setContractAmountUpdateCommitDao(ContractAmountUpdateCommitDao contractAmountUpdateCommitDao) {
        this.contractAmountUpdateCommitDao = contractAmountUpdateCommitDao;
    }


    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountUpdateCommitService#updateContractAmount(net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountUpdateCommitInServiceBean)
     */
    public void updateContractAmount(ContractAmountUpdateCommitInServiceBean inBean)
            throws ApplicationException {

        ContractAmountUpdateCommitParamBean paramBean =
                new ContractAmountUpdateCommitParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
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

        int updateCnt = contractAmountUpdateCommitDao.updateContractAmount(paramBean);

        if (updateCnt == 0) {
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0014");
        }

        ShopKanri shopKanri = shopService.selectShopKanriByPrimaryKey(inBean.getShopCd());
        shopKanri.setAdminUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdId(inBean.getUpdId());
        shopKanri.setUpdPg(inBean.getUpdPg());

        shopKanrilMapper.updateByPrimaryKey(shopKanri);
    }
}
