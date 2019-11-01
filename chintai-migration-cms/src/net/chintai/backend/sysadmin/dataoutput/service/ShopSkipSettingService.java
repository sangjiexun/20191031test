package net.chintai.backend.sysadmin.dataoutput.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShopSkipSettingDownloadInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShopSkipSettingDownloadOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShopSkipSettingUploadInServiceBean;

/**
 * 店舗別除外設定サービスクラス
 * @author watanabe
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopSkipSettingService {
	/**
	 * 店舗別出力設定を取得する
	 * @param inServiceBean 入力情報 
	 * @return 取得情報
	 * @throws ApplicationException 
	 */
	public ShopSkipSettingDownloadOutServiceBean selectShopSkipSetting(ShopSkipSettingDownloadInServiceBean inServiceBean) throws ApplicationException;

	/**
	 * 店舗別出力設定を取得する
	 * @param inServiceBean 入力情報
	 * @throws ApplicationException 
	 */
	public void commitShopSkipSetting(ShopSkipSettingUploadInServiceBean inServiceBean) throws ApplicationException;
}
