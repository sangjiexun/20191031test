package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingAddConfirmDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingAddConfirmParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingKikanChkBean;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingUpdateConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingUpdateConfirmInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

/**
 * ShopListingAddConfirmServiceの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingUpdateConfirmServiceImpl implements
        ShopListingUpdateConfirmService {

    /** 店舗リスティング設定情報確認DAO */
    ShopListingAddConfirmDao shopListingAddConfirmDao;

    /**
     * 店舗リスティング設定情報確認DAOを設定します。
     * @param shopListingAddConfirmDao 店舗リスティング設定情報確認DAO
     */
    public void setShopListingAddConfirmDao(
            ShopListingAddConfirmDao shopListingAddConfirmDao) {
        this.shopListingAddConfirmDao = shopListingAddConfirmDao;
    }

    public boolean chk(String inputStartDt, String inputEndDt, List<ShopListingKikanChkBean> list){
    	boolean isError = false;

    	for(int i = 0; i < list.size(); i++){
        	ShopListingKikanChkBean data = list.get(i);

        	String keiyakuStartDt = data.getKeiyakuStartDt();
        	String keiyakuEndDt = data.getKeiyakuEndDt();

            if(StringUtils.isNotEmpty(keiyakuEndDt)){//開始日・終了日ともに入力ありの場合
            	if(i > 0 && SystemProperties.getProperty("LAST_DT").equals(keiyakuEndDt)){
                	keiyakuEndDt = list.get(i - 1).getKeiyakuStartDt();

                	if((inputStartDt.compareTo(keiyakuStartDt) <= 0 && inputEndDt.compareTo(keiyakuStartDt) >= 0) || (inputStartDt.compareTo(keiyakuEndDt) <= 0 && inputEndDt.compareTo(keiyakuEndDt) >= 0)){
                		isError = true;
                	}
                }else{
	            	if((inputStartDt.compareTo(keiyakuStartDt) >= 0 && inputStartDt.compareTo(keiyakuEndDt) <= 0) || (inputEndDt.compareTo(keiyakuStartDt) >= 0 && inputEndDt.compareTo(keiyakuEndDt) <= 0)){
	            		isError = true;
	            	}
                }
            }else{
            	//開始日のみ入力の場合
            	if(i > 0 && SystemProperties.getProperty("LAST_DT").equals(keiyakuEndDt)){
                	keiyakuEndDt = list.get(i - 1).getKeiyakuStartDt();

                	if(inputStartDt.equals(keiyakuStartDt)){
                		isError = true;
                	}
                }else{
	            	if((inputStartDt.compareTo(keiyakuStartDt) >= 0 && inputStartDt.compareTo(keiyakuEndDt) <= 0)){
	            		isError = true;
	            	}
                }
            }
        }
    	return isError;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopListingAddConfirmService#checkAppliyYm(net.chintai.backend.sysadmin.shop_bukken.service.ShopListingAddConfirmService)
     */
    public void countApplyYmdh(ShopListingUpdateConfirmInServiceBean inBean)
            throws ApplicationException {
/*
 * 入力と更新で共通サービスクラスにしたいので
 * ShopListingAddConfirmServiceImplを使ってください。
 *
        ShopListingAddConfirmParamBean paramBean =
                new ShopListingAddConfirmParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 現在適用中の物件枠を探す為、現在年月日時を取得
        String nowTimestamp = DateUtil.getToday("yyyyMMddHH") + "0000";

        // 入力された開始日と終了日
        String inputStartDt = paramBean.getKeiyakuStartYear() + paramBean.getKeiyakuStartMonth() + paramBean.getKeiyakuStartDay() + paramBean.getKeiyakuStartHour()  + "0000";
        String inputEndDt = paramBean.getKeiyakuEndYear() + paramBean.getKeiyakuEndMonth() + paramBean.getKeiyakuEndDay() + paramBean.getKeiyakuEndHour()  + "0000";

        List<ShopListingKikanChkBean> list = shopListingAddConfirmDao.checkKeiyakuEndDt(paramBean);

        boolean isError = chk(inputStartDt, inputEndDt, list);



        //int cnt = 0;

        //for(ShopListingKikanChkBean chkList: list){
        	//chkList.setKeiyakuStartYear(paramBean.getKeiyakuStartYear());
        	//chkList.setKeiyakuStartMonth(paramBean.getKeiyakuStartMonth());
        	//chkList.setKeiyakuStartDay(paramBean.getKeiyakuStartDay());
        	//chkList.setKeiyakuStartHour(paramBean.getKeiyakuStartHour());

        	//chkList.setKeiyakuEndYear(paramBean.getKeiyakuEndYear());
        	//chkList.setKeiyakuEndMonth(paramBean.getKeiyakuEndMonth());
        	//chkList.setKeiyakuEndDay(paramBean.getKeiyakuEndDay());
        	//chkList.setKeiyakuEndHour(paramBean.getKeiyakuEndHour());

        	//cnt = cnt + shopListingAddConfirmDao.checkAppliyYmdh(chkList);
        //}

        if (isError) {
            throw new ApplicationException("WARN.M.SHOP_BUKKEN.0269", new String[] {
                    ApplicationResources.getProperty("shop_bukken.keiyakuYm"),
                    ApplicationResources.getProperty("shop_bukken.keiyakuKikan"),
                    ApplicationResources.getProperty("shop_bukken.keiyakuDuplicate")});
        }
*/
    }
}
