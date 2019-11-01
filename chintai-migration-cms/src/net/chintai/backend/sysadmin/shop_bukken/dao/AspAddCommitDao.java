/*
 * $Id: AspAddCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import net.chintai.backend.sysadmin.shop_bukken.domain.AspAreaInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspContractInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspInfo;

/**
 * 不動産ASP設定情報登録するDao
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspAddCommitDao {

    /**
     * 不動産ASP設定情報(基本情報)登録する
     * 
     * @param aspInfo 登録する不動産ASP設定情報(基本情報)
     */
    public Long insertAspAddCommit(AspInfo aspInfo);

    /**
     * 不動産ASP設定情報(エリア情報)登録する
     * 
     * @param aspAreaInfo 登録する不動産ASP設定情報(エリア情報)
     */
    public void insertAspAreaAddCommit(AspAreaInfo aspAreaInfo);

    /**
     * 不動産ASP設定情報(契約情報)登録する
     *
     * @param aspAreaInfo 登録する不動産ASP設定情報(契約情報)
     */
    public void insertAspContractAddCommit(AspContractInfo aspContractInfo);

    /**
     * 不動産ASP設定情報(過去契約情報)更新する
     *
     * @param aspAreaInfo 登録する不動産ASP設定情報(契約情報)
     */
    public void updateAspContractModifyCommit(AspContractInfo aspContractInfo);


}
