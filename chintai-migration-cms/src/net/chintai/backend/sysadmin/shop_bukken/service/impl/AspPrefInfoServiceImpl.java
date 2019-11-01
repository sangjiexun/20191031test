/*
 * $Id: AspPrefInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspAreaPrefInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.AspPrefInfoService;

/**
 * AspPrefInfoServiceの実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspPrefInfoServiceImpl implements AspPrefInfoService {

    /** 不動産ASPの店舗情報DAO */
    private AspAreaPrefInfoDao aspAreaPrefInfoDao = null;

    /**
     * 不動産ASPの店舗情報DAOを設定する
     * @param aspAreaPrefInfoDao 不動産ASPの店舗情報DAO
     */
    public void setAspAreaPrefInfoDao(AspAreaPrefInfoDao aspAreaPrefInfoDao) {
        this.aspAreaPrefInfoDao = aspAreaPrefInfoDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.AspPrefInfoService#aspAreaPrefInfoSearch()
     */
    public List<AspPrefInfo> aspAreaPrefInfoSearch() throws Exception {
        // 不動産ASPの店舗情報を取得
        List<AspPrefInfo> rsAspShopInfo = aspAreaPrefInfoDao.selectAspPrefInfo();

        return rsAspShopInfo;
    }

}
