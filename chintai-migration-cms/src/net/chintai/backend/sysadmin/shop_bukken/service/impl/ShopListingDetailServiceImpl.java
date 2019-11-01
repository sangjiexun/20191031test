package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDetailDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDetailParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopListingDetailDomain;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingDetailService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

/**
 * ShopListingDetailServiceの実装クラス。
 *
 * @author
 * @version $Revision: $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDetailServiceImpl implements ShopListingDetailService {

    /** 店舗リスティング情報取得DAO */
    ShopListingDetailDao shopListingDetailDao;

    /**
     * 店舗リスティング情報取得DAOを設定します。
     *
     * @param shopListingDao
     *            店舗リスティング情報取得DAO
     */
    public void setShopListingDetailDao(
            ShopListingDetailDao shopListingDetailDao) {
        this.shopListingDetailDao = shopListingDetailDao;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopListingDetailServiceImpl#getShopListingDetail(net.chintai.backend.sysadmin.
     * shop_bukken.service.bean.TorhikisakiWakuInfoInServiceBean)
     */
    public List<ShopListingOutServiceBean> getShopListingDetail(
            ShopListingInServiceBean inBean) {

        // 検索条件設定
        ShopListingDetailParamBean paramBean = new ShopListingDetailParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 検索開始
        List<ShopListingDetailDomain> rsList = (List<ShopListingDetailDomain>)shopListingDetailDao
                .getShopListingDetail(paramBean);

        // 戻り値設定
        List<ShopListingOutServiceBean> returnList = new ArrayList<ShopListingOutServiceBean>();

        ShopListingOutServiceBean outBean = null;

        // 現在適用中の契約情報を探す為、現在年月日時を取得
        //String nowTimestamp = DateUtil.getToday("yyyyMMddHH") + "0000";
        String nowTimestamp = DateUtil.getToday("yyyyMMddHHmmss");


        if (rsList == null) {
            return null;
        }

        boolean isNotFoundApplyDt = true;
        for (int i = 0; i < rsList.size(); i++) {

            outBean = new ShopListingOutServiceBean();

            try {
                BeanUtils.copyProperties(outBean, rsList.get(i));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }


            if (outBean.getKeiyakuStartDt().compareTo(nowTimestamp) > 0 ) {
                outBean.setDelFlg("on");
            }

            String keiyakuStartDt = outBean.getKeiyakuStartDt();
        	String keiyakuEndDt = outBean.getKeiyakuEndDt();

        	if(i > 0 && SystemProperties.getProperty("LAST_DT").equals(keiyakuEndDt)){
        		keiyakuEndDt = rsList.get(i - 1).getKeiyakuStartDt();
        	}

        	if(isNotFoundApplyDt){
        		if (keiyakuEndDt.compareTo(nowTimestamp) >= 0 ) {
            		outBean.setLinkFlg("on");
            	}
	    		if(keiyakuEndDt.compareTo(nowTimestamp) >= 0 && nowTimestamp.compareTo(keiyakuStartDt) >= 0){
	    			outBean.setAppliedFlg("FFFF99");
	    		}

	    		if(keiyakuEndDt.compareTo(nowTimestamp) >= 0 && nowTimestamp.compareTo(keiyakuStartDt) >= 0){
	    			isNotFoundApplyDt = false;
	    		}
        	}

            returnList.add(outBean);
        }

        return returnList;
    }
}
