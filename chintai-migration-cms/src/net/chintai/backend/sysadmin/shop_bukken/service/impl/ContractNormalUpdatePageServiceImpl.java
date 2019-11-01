package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.shop_bukken.dao.ContractNormalUpdatePageDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractNormalUpdatePageParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ContractNormal;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractNormalUpdatePageService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractNormalUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractNormalUpdatePageOutServiceBean;
import net.chintai.batch.common.util.CryptUtils;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ContractNormalUpdatePageServiceの実装クラス
 *
 * @author m-kashiyama
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractNormalUpdatePageServiceImpl implements ContractNormalUpdatePageService {

    /** 契約明細設定（数量なし）画面に遷移DAO */
    private ContractNormalUpdatePageDao contractNormalUpdatePageDao = null;

    /**
     * ContractNormalUpdatePageDaoを設定する
     * @param contractNormalUpdatePageDao
     */
    public void setContractNormalUpdatePageDao(ContractNormalUpdatePageDao contractNormalUpdatePageDao) {
        this.contractNormalUpdatePageDao = contractNormalUpdatePageDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ContractNormalUpdatePageService#contractUpdatePage(net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractNormalUpdatePageInServiceBean)
     */
    public ContractNormalUpdatePageOutServiceBean contractUpdatePage(ContractNormalUpdatePageInServiceBean inServiceBean)
            throws InvocationTargetException, IllegalAccessException {

        // 店舗コードをParamBeanに設定
        ContractNormalUpdatePageParamBean paramBean = new ContractNormalUpdatePageParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // アドパーク詳細情報を取得
        ContractNormal contractNormal = contractNormalUpdatePageDao.contractNormalkUpdatePage(paramBean);

        // 取得した情報をOutServiceBeanに設定
        ContractNormalUpdatePageOutServiceBean outServiceBean = new ContractNormalUpdatePageOutServiceBean();
        BeanUtils.copyProperties(outServiceBean, contractNormal);
        outServiceBean.setPassword(CryptUtils.decypt(outServiceBean.getPassword()));


        return outServiceBean;
    }
}