/*
 * $Id: FudousanUpdateCommitDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/01     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import net.chintai.backend.sysadmin.demand.dao.FudousanUpdateCommitParamBean;

/**
 * 不動産会社更新DAO
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanUpdateCommitDao {

    /**
     * 不動産会社情報を更新します
     * @param paramBean 不動産会社情報
     * @return 更新件数
     */
    public int updateFudousan(FudousanUpdateCommitParamBean paramBean);

}
