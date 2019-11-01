/*
 * $Id: CouponEditCompleteDao.java 4248 2009-03-24 01:59:32Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/05     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

/**
 * クーポン情報編集DAO。
 *
 * @author Lee Hosup
 * @version $Revision: 4248 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CouponEditCompleteDao {

    /**
     * クーポン情報を更新します。
     * @param paramBean
     * @return
     */
    public void updateCouponInfo(CouponEditCompleteParamBean paramBean);

    /**
     * クーポン情報を登録します。
     *
     * @param paramBean
     * @return pk
     */
    public String registerCouponInfo(CouponEditCompleteParamBean paramBean);

}
