/*
 * $Id: AspShopInfoDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.domain.AspGroupInfo;

/**
 * 不動産ASPを設定するときに使用するDAO。
 * 
 * @author Sim-JongYeon
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspShopInfoDao {

    /**
     * 不動産ASPを設定するときに使用する店舗基本情報を照会する。
     * 
     * @param paramBean 店舗コード
     * @return 店舗基本情報
     */
    public Object selectAspShopInfo(AspShopInfoParamBean paramBean);

    /**
     * 不動産ASPを設定するときに登録された不動産ASP情報を照会する。
     * 
     * @param paramBean 店舗コード
     * @return 不動産ASP情報
     */
    public Object selectAspRegisteredInfo(AspShopInfoParamBean paramBean);

    /**
     * 不動産ASPを設定するときに登録された不動産ASPの都道府県情報を照会する。
     * 
     * @param paramBean 店舗コード
     * @return 不動産ASPのエリア情報
     */
    public List selectAspAreaRegisteredInfo(AspShopInfoParamBean paramBean);
    
    
    
    /**
     * 不動産ASPグループリスト
     * @param shopCd 店舗コード
     * @return グループリスト
     */
    public List<AspGroupInfo> selectAspGroupList(String shopCd);
}
