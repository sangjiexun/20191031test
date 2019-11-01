package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountUpdatePageDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountUpdatePageParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ContractAmountDomain;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountUpdagePageService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountUpdatePageOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ContractAmountUpdagePageServiceの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountUpdatePageServiceImpl implements
        ContractAmountUpdagePageService {

    /** 契約明細詳細(契約数量あり)設定情報取得DAO */
    ContractAmountUpdatePageDao contractAmountUpdatePageDao;

    /**
     * 契約明細詳細(契約数量あり)設定情報取得DAOを設定します。
     * @param contractAmountUpdatePageDao 契約明細詳細(契約数量あり)設定情報取得DAO
     */
    public void setContractAmountUpdatePageDao(
            ContractAmountUpdatePageDao contractAmountUpdatePageDao) {
        this.contractAmountUpdatePageDao = contractAmountUpdatePageDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountUpdagePageService#getContractAmount(net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountUpdatePageInServiceBean)
     */
    public ContractAmountUpdatePageOutServiceBean getContractAmount(
            ContractAmountUpdatePageInServiceBean inBean) {

        ContractAmountUpdatePageParamBean paramBean =
                new ContractAmountUpdatePageParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        ContractAmountDomain domain =
                contractAmountUpdatePageDao.getContractAmount(paramBean);

        ContractAmountUpdatePageOutServiceBean outBean =
                new ContractAmountUpdatePageOutServiceBean();

        try {
            BeanUtils.copyProperties(outBean, domain);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return outBean;
    }
}
