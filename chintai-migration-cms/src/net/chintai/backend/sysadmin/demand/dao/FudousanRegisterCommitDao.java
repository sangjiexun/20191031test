/*
 * $Id: FudousanRegisterCommitDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;


/**
 * 不動産会社新規登録DAO
 *
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanRegisterCommitDao {

    /**
     * 新しい不動産会社情報を登録します
     * @param paramBean 登録パラメータ（不動産会社情報）
     * */
    public void insertFudousanInfo(FudousanRegisterCommitParamBean paramBean);
}
