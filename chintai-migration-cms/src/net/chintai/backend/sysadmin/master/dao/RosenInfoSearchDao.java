/*
 * $Id: RosenInfoSearchDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/14  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao;

import java.util.List;

/**
 * 沿線詳細を検索するDao
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface RosenInfoSearchDao {

    /**
     * 沿線コードで、沿線詳細を検索する。
     * @param paramBean 沿線コード
     * @return 沿線詳細
     */
    public List selectRosenInfoByEnsenCd(RosenInfoSearchParamBean paramBean);

}
