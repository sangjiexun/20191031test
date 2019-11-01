/*
 * $Id: CjnUserListDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnUserList;

/**
 * 問い合せユーザ一覧を取得するDAO。
 * 
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnUserListDao {

    /**
     * 問い合せユーザ一覧を取得します。
     * @return 問い合せユーザ一覧リスト
     */
    public List<CjnUserList> selectCjnUserList();
}
