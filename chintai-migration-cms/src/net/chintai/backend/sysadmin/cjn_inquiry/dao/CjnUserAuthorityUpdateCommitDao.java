/*
 * $Id: CjnUserAuthorityUpdateCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

/**
 * 閲覧可能問い合せ権限更新Dao
 * 
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnUserAuthorityUpdateCommitDao {

    /**
     * 閲覧可能問い合せ権限全データを削除
     * @param paramBean
     */
    public int deleteUserAuthority(CjnUserAuthorityUpdateParamBean paramBean);

    /**
     * 閲覧可能問い合せ権限更新情報をInsert
     * @param paramBean
     */
    public void insertUserAuthority(CjnUserAuthorityUpdateParamBean paramBean);
    
    /**
     * 削除するための最終更新日時を取得
     * @param paramBean
     */
    public String selectUserAuthorityLastUpdateDt(CjnUserAuthorityUpdateParamBean paramBean);

}
