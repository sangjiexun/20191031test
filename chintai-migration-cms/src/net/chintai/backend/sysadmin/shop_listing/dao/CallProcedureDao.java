/*
 * $Id: CallProcedureDao.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/15     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

/**
 * プロシージャを呼び出すDAO
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CallProcedureDao {

    /**
     * 基本契約有効フラグを更新するプロシージャを呼び出す。
     *
     * @param paramBean
     */
    void callKihonYukoFlgUpdate(CallProcedureDaoParamBean paramBean);

    /**
     * クーポン契約有効フラグを更新するプロシージャを呼び出す。
     *
     * @param paramBean
     */
    void callCouponYukoFlgUpdate(CallProcedureDaoParamBean paramBean);

    /**
     * 外部リンク契約有効フラグを更新するプロシージャを呼び出す。
     *
     * @param paramBean
     */
    void callLinkYukoFlgUpdate(CallProcedureDaoParamBean paramBean);
}
