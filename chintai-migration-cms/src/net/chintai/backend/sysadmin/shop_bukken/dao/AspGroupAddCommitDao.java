/*
 * $Id: AspGroupAddCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/24  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 不動産ASPグループ登録DAO
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspGroupAddCommitDao {
    
    /**
     * グループ登録する
     * @param paramBean
     */
    public void insertAspGroup(AspGroupAddCommitParamBean paramBean);

}
