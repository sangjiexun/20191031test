/*
 * LoginDao.java
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/15  BGT)児島   新規作成
 *
 */
package net.chintai.backend.sysadmin.login.dao;


/**
 * ユーザーテーブルの DAO です。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MngSessionDao {

    /**
     * ログインに成功した場合管理機能セッション管理テーブルに登録をする。
     * @param user ユーザ情報
     */
    public Long insertMngSession(MngSessionParamBean sessionBean);


    /**
     * ログアウト時に管理機能セッション管理テーブルから削除する。
     */
    public void deleteMngSession(Long paramBean);


}