/*
 * $Id: AspAreaPrefInfoDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.domain.AspAreaPrefInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo;

/**
 * 不動産ASP設定でエリア設定の基本情報を照会するDAO。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspAreaPrefInfoDao {

    /**
     * エリアと都道府県を照会する。
     * 
     * @return エリアと都道府県のリスト
     */
    public List<AspAreaPrefInfo> selectAspAreaPrefInfo();

    /**
     * 都道府県を照会する。
     * 
     * @return 都道府県のリスト
     */
    public List<AspPrefInfo> selectAspPrefInfo();

}
