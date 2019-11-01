package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDetailDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDetailParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ContractAmountDomain;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountDetailService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ContractAmountDetailServiceの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountDetailServiceImpl implements ContractAmountDetailService {

    /** 契約明細詳細(契約数量あり)情報取得DAO */
    ContractAmountDetailDao contractAmountDetailDao;

    /**
     * 契約明細詳細(契約数量あり)情報取得DAOを設定します。
     * @param contractAmountDao 契約明細詳細(契約数量あり)情報取得DAO
     */
    public void setContractAmountDetailDao(ContractAmountDetailDao contractAmountDetailDao) {
        this.contractAmountDetailDao = contractAmountDetailDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountDetailServiceImpl#getContractAmountDetail(net.chintai.backend.sysadmin.shop_bukken.service.bean.TorhikisakiWakuInfoInServiceBean)
     */
    public List<ContractAmountOutServiceBean> getContractAmountDetail(
            ContractAmountInServiceBean inBean) {

        // 検索条件設定
        ContractAmountDetailParamBean paramBean = new ContractAmountDetailParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 検索開始
        List<ContractAmountDomain> rsList =
                contractAmountDetailDao.getContractAmountDetail(paramBean);

        // 戻り値設定
        List<ContractAmountOutServiceBean> returnList =
                new ArrayList<ContractAmountOutServiceBean>();

        ContractAmountOutServiceBean outBean = null;

        // 現在適用中の物件枠を探す為、現在年月日時を取得
        String nowTimestamp = DateUtil.getToday("yyyyMMddHH") + "0000";

        // 現在適用中の物件枠を探す為、現在年月日時を取得
        String nowMonth = DateUtil.getToday("yyyyMMddHH") + "0000";

        if (rsList == null) {
            return null;
        }

        for (int i = 0; i < rsList.size(); i++) {

            outBean = new ContractAmountOutServiceBean();

            try {
                BeanUtils.copyProperties(outBean, rsList.get(i));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

            if (outBean.getKeiyakuStartDt().compareTo(nowMonth) > 0 ) {
                outBean.setDelFlg("on");
            }
            if (outBean.getKeiyakuEndDt().compareTo(nowMonth) >= 0 ) {
                outBean.setLinkFlg("on");
            }

            String keiyakuEndDt = outBean.getKeiyakuEndDt();
            if(i > 0 && SystemProperties.getProperty("LAST_DT").equals(keiyakuEndDt)){
            	keiyakuEndDt = rsList.get(i - 1).getKeiyakuStartDt();
            }
            if (outBean.getKeiyakuEndDt().compareTo(nowTimestamp) >= 0
                    && (nowTimestamp.compareTo(outBean.getKeiyakuStartDt()) >= 0)) {
                    outBean.setAppliedFlg("FFFF99");
            }
            returnList.add(outBean);
        }

        return returnList;
    }
}
