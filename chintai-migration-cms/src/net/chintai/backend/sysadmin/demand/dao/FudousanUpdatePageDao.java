/*
 * $Id: FudousanUpdatePageDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/29     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import net.chintai.backend.sysadmin.demand.domain.FudousanDomain;

/**
 * 不動産会社更新画面情報取得DAO
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanUpdatePageDao {

    /**
     * 不動産会社情報を検索
     * @param paramBean 検索パラメータ（不動産会社コード）
     * @return 不動産会社情報
     */
    public FudousanDomain fudousanUpdatePage(FudousanUpdatePageParamBean paramBean);
}
