/*
 * $Id: CjnUserUpdatePageDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnUserInfo;

/**
 * 問い合せユーザ更新ページDAO
 * 
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnUserUpdatePageDao {

    /**
     * 問い合せユーザ情報を取得します。
     * @return CjnUserInfo
     */
    public CjnUserInfo selectUpdateCjnUser(String cjnAccountSeq);
}
