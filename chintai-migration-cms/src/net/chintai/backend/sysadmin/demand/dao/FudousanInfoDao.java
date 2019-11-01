/*
 * $Id: FudousanInfoDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/28     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import net.chintai.backend.sysadmin.demand.domain.FudousanDomain;

/**
 * 不動産会社詳細情報取得DAO
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanInfoDao {

    /**
     * 不動産会社詳細情報を取得する
     * @param paramBean 不動産会社コード
     * @return 不動産会社詳細情報
     */
    public FudousanDomain fudousanInfo(FudousanInfoParamBean paramBean);

}
