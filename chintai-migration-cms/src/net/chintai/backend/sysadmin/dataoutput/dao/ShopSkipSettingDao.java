package net.chintai.backend.sysadmin.dataoutput.dao;

import java.util.Date;
import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.domain.ShopSkipSettingDomain;

/**
 * 店舗別除外設定Dao
 * @author watanabe
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopSkipSettingDao {
	
	/**
	 * 店舗別出力設定を取得
	 * @param paramBean 検索条件 
	 * @return 取得結果
	 */
	public List<ShopSkipSettingDomain> getShopSkipSetting(ShopSkipSettingParamBean paramBean);
	
	/**
	 * 店舗別出力設定を削除
	 * @param paramBean 検索条件 
	 */	
	public void deleteShopSkipConfig(ShopSkipSettingParamBean paramBean);
	
	 /**
	  * 店舗別出力設定を挿入
	  * @param paramBean 検索条件 
	  */
	public void insertShopSkipConfig(ShopSkipSettingParamBean paramBean);
	
	/**
	 * 店舗別出力設定バックアップを削除
	 * @param param
	 */
	public void deleteBkShopSkipConfig(Date param);
	
	/**
	 * 店舗別出力設定バックアップを挿入
	 * @param paramBean 
	 */
	public void insertBkShopSkipConfig(ShopSkipSettingParamBean paramBean);
}
