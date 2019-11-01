/*
 * $Id: CjnUserUpdateCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

/**
 * 問い合せユーザ更新DAO。
 * 
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnUserUpdateCommitDao {

    /**
     * 問い合せ管理システム利用ユーザの情報を更新します。
     * @param paramBean 更新情報
     * @return 更新成功件数 (0 の場合は失敗)
     */
    public int updateCjnUser(CjnUserUpdateCommitParamBean paramBean);
}
