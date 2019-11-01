/*
 * $Id: CjnUserAuthorityUpdatePageDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnUserAuthorityUpdateInfo;

/**
 * 問い合わせ閲覧可能権限を取得するDao
 * 
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnUserAuthorityUpdatePageDao {

    /**
     * ユーザの問い合せ種別利用権限一覧を取得します。
     * @param cjnAccountSeq
     * @return 問い合せ閲覧可能権限一覧
     */
    public List<CjnUserAuthorityUpdateInfo> selectCjnAccountLevelList(String cjnAccountSeq);
    
    /**
     * 最終更新日時を取得
     * @param cjnAccountSeq
     * @return 最終更新日時(問い合せ閲覧可能権限の中で最大のもの)
     */
    public String selectLastUpdateDt(String cjnAccountSeq);
}
