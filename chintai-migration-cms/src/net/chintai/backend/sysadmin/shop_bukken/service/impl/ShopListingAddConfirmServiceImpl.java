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
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingAddConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingAddConfirmInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

/**
 * ShopListingAddConfirmServiceの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingAddConfirmServiceImpl implements
    ShopListingAddConfirmService {

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

            if(StringUtils.isNotEmpty(inputEndDt)){//開始日・終了日ともに入力ありの場合
            	if(SystemProperties.getProperty("LAST_DT").equals(keiyakuEndDt)){
            		if(i > 0){
            			keiyakuEndDt = list.get(i - 1).getKeiyakuStartDt();
            		}else{
            			keiyakuEndDt = keiyakuStartDt;
            		}

                	if((inputStartDt.compareTo(keiyakuStartDt) <= 0 && inputEndDt.compareTo(keiyakuStartDt) >= 0) || (inputStartDt.compareTo(keiyakuEndDt) <= 0 && inputEndDt.compareTo(keiyakuEndDt) >= 0)){
                		isError = true;
                	}
                }else{
	            	if((inputStartDt.compareTo(keiyakuStartDt) >= 0 && inputStartDt.compareTo(keiyakuEndDt) <= 0) || (inputEndDt.compareTo(keiyakuStartDt) >= 0 && inputEndDt.compareTo(keiyakuEndDt) <= 0) || (inputStartDt.compareTo(keiyakuStartDt) <= 0 && inputEndDt.compareTo(keiyakuEndDt) >= 0)){
	            		isError = true;
	            	}
                }
            }else{
            	//開始日のみ入力の場合
            	if(SystemProperties.getProperty("LAST_DT").equals(keiyakuEndDt)){
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
    public void countApplyYmdh(ShopListingAddConfirmInServiceBean inBean)
            throws ApplicationException {

        ShopListingAddConfirmParamBean paramBean =
                new ShopListingAddConfirmParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 入力された開始日と終了日
        String inputStartDt = paramBean.getKeiyakuStartYear() + paramBean.getKeiyakuStartMonth() + paramBean.getKeiyakuStartDay() + paramBean.getKeiyakuStartHour()  + paramBean.getKeiyakuStartMinute() + paramBean.getKeiyakuStartSecond();
        String inputEndDt = StringUtils.isNotEmpty(paramBean.getKeiyakuEndYear()) ? (paramBean.getKeiyakuEndYear() + paramBean.getKeiyakuEndMonth() + paramBean.getKeiyakuEndDay() + paramBean.getKeiyakuEndHour()  + paramBean.getKeiyakuEndMinute() + paramBean.getKeiyakuEndSecond()): "";

        List<ShopListingKikanChkBean> list = shopListingAddConfirmDao.checkKeiyakuEndDt(paramBean);

        boolean isError = chk(inputStartDt, inputEndDt, list);

        if (isError) {
            throw new ApplicationException("WARN.M.SHOP_BUKKEN.0268", new String[] {
                    ApplicationResources.getProperty("shop_bukken.keiyakuYm"),
                    ApplicationResources.getProperty("shop_bukken.keiyakuKikan"),
                    ApplicationResources.getProperty("shop_bukken.keiyakuDuplicate")});
        }

        boolean isDateError = false;
        //契約開始日<VSKK.KEIYAKU_START_DT（YYYYMMDDHH0000）の場合、エラー
        ShopListingKikanChkBean data = shopListingAddConfirmDao.viewCheck(paramBean);
        if(data != null){
        	String viewStartDt = data.getKeiyakuStartDt();
        	if(inputStartDt.compareTo(viewStartDt) <= 0){
        		isDateError = true;
        	}
        }

        if (isDateError) {
            throw new ApplicationException("WARN.M.SHOP_BUKKEN.0260", new String[] {
                    ApplicationResources.getProperty("shop_bukken.keiyakuYm"),
                    ApplicationResources.getProperty("shop_bukken.keiyakuApply")});
        }
    }
}
