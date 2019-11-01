package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountAddConfirmDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountAddConfirmParamBean;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountAddConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountAddConfirmInServiceBean;

/**
 * ContractAmountAddConfirmServiceの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountAddConfirmServiceImpl implements
        ContractAmountAddConfirmService {

    /** 契約明細詳細(契約数量あり)設定情報確認DAO */
    ContractAmountAddConfirmDao contractAmountAddConfirmDao;

    /**
     * 契約明細詳細(契約数量あり)設定情報確認DAOを設定します。
     * @param contractAmountAddConfirmDao 契約明細詳細(契約数量あり)設定情報確認DAO
     */
    public void setContractAmountAddConfirmDao(
            ContractAmountAddConfirmDao contractAmountAddConfirmDao) {
        this.contractAmountAddConfirmDao = contractAmountAddConfirmDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountAddConfirmService#checkAppliyYm(net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountAddConfirmService)
     */
    public void countApplyYmdh(ContractAmountAddConfirmInServiceBean inBean)
            throws ApplicationException {

        ContractAmountAddConfirmParamBean paramBean =
                new ContractAmountAddConfirmParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        int cnt = contractAmountAddConfirmDao.checkAppliyYmdh(paramBean);

        if (cnt != 0) {
            throw new ApplicationException("WARN.M.SHOP_BUKKEN.0139", ApplicationResources
                    .getProperty("shop_bukken.applyYm"));
        }
    }
}
