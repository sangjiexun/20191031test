package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ContractAmountInfoDomain;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInfoOutServiceBean;
import net.chintai.batch.common.util.CryptUtils;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 契約情報詳細
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountInfoServiceImpl implements ContractAmountInfoService {

    /** 契約情報取得DAO */
    private ContractAmountInfoDao contractAmountInfoDao;

    /**
     * 契約情報取得DAOを設定します。
     * @param contractAmountInfoDao 取引先詳細取得DAO
     */
    public void setContractAmountInfoDao(ContractAmountInfoDao contractAmountInfoDao) {
        this.contractAmountInfoDao = contractAmountInfoDao;
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountInfoService#getContractInfo(net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInfoInServiceBean)
     */
    public ContractAmountInfoOutServiceBean getContractInfo(
            ContractAmountInfoInServiceBean inBean) throws ApplicationException {

        // 検索条件設定
        ContractAmountInfoParamBean paramBean = new ContractAmountInfoParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 契約詳細検索開始
        ContractAmountInfoDomain domain = contractAmountInfoDao.getContractInfo(paramBean);

        // 店舗情報が取得できない場合
        if (domain == null) {
            throw new RuntimeException();
        }

        List<String> lstAmount = new ArrayList<String>();

        // 戻り値設定
        ContractAmountInfoOutServiceBean outBean = new ContractAmountInfoOutServiceBean();

        if (domain.getStrAmountList() != null) {
            String[] arrayStrAmount = domain.getStrAmountList().split("\\,",-1);
            for (String str  :arrayStrAmount) {
                if ("".equals(str.trim())) {
                    outBean.setTextBoxFlg("on");
                }

                //数値変換してエラーにならなければリストに追加（エラーになった場合は、テキストボックスに登録）
                try {
                    Integer.parseInt(str);
                    lstAmount.add(str);
                } catch (Exception e) {
                    //数値じゃなかったら、その他項目を設定
                    outBean.setTextBoxFlg("on");
                    outBean.setTextBoxName(str);
                }
            }
        } else {
            outBean.setTextBoxFlg("on");
        }

        try {
            BeanUtils.copyProperties(outBean, domain);
            outBean.setPassword(CryptUtils.decypt(outBean.getPassword()));
            outBean.setListAmount(lstAmount);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return outBean;
    }

}
