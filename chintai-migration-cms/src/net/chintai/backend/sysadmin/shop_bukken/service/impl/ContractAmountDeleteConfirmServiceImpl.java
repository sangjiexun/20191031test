package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDeleteConfirmDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDeleteConfirmParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ContractAmountDomain;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountDeleteConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountDeleteConfirmOutServiceBean;

/**
 * ContractAmountDeleteConfrimServiceの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountDeleteConfirmServiceImpl implements
        ContractAmountDeleteConfirmService {

    /** 契約明細詳細(契約数量あり)設定情報削除確認DAO */
    ContractAmountDeleteConfirmDao contractAmountDeleteConfirmDao;

    /**
     * 契約明細詳細(契約数量あり)設定情報削除確認DAOを設定します。
     * @param contractAmountDeleteConfirmDao 契約明細詳細(契約数量あり)設定情報削除確認DAO
     */
    public void setContractAmountDeleteConfirmDao(ContractAmountDeleteConfirmDao contractAmountDeleteConfirmDao) {
        this.contractAmountDeleteConfirmDao = contractAmountDeleteConfirmDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.serviec.ContractAmountDeleteConfrimService#getContractAmountForDelete(net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountDeleteConfirmInServiceBean)
     */
    public List<ContractAmountDeleteConfirmOutServiceBean> getContractAmountForDelete(
            ContractAmountDeleteConfirmInServiceBean inBean) {

        ContractAmountDeleteConfirmParamBean paramBean =
                new ContractAmountDeleteConfirmParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        List<ContractAmountDomain> rsList =
                contractAmountDeleteConfirmDao
                        .getContractAmountForDelete(paramBean);

        List<ContractAmountDeleteConfirmOutServiceBean> returnList =
                new ArrayList<ContractAmountDeleteConfirmOutServiceBean>();

        ContractAmountDeleteConfirmOutServiceBean outBean;
        for (int i=0; i<rsList.size(); i++ ) {
            outBean = new ContractAmountDeleteConfirmOutServiceBean();
            try {
                BeanUtils.copyProperties(outBean, rsList.get(i));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            returnList.add(outBean);
        }


        return returnList;
    }
}
