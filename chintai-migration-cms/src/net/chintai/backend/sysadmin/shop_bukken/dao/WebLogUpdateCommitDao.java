/*
 * $Id: WebLogUpdateCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * Webログ利用可否完了DAO
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface WebLogUpdateCommitDao {
    /**
     * Webログ利用可否完了
     * @param paramBean
     * @return int
     */
    public int webLogUpdateCommit(WebLogUpdateCommitParamBean paramBean);
}