/*
 * $Id: KeiyakuRegisterCompleteDao.java 4282 2009-07-06 12:17:41Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/24  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

/**
 * 契約情報登録完了DAO。
 *
 * @author Lee Hosup
 * @version $Revision: 4282 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface KeiyakuRegisterCompleteDao {

    /**
     * 契約情報テーブルの登録処理を行います。
     *
     * @param paramBean
     * @return
     */
    public String registerKeiyakuInfo(KeiyakuRegisterCompleteParamBean paramBean);

    /**
     * 契約情報履歴テーブルの登録処理を行います。
     *
     * @param paramBean
     * @return
     */
    public String registerKeiyakuHistoryInfo(KeiyakuRegisterCompleteParamBean paramBean);

    /**
     * 契約テーブルに該当店舗が登録されているのかを確認。
     *
     * @param paramBean
     * @return
     */
    public int countTotalCnt(KeiyakuRegisterCompleteParamBean paramBean);

    /**
     * 契約情報テーブルの更新処理を行います。
     * @param paramBean
     * @return なし
     */
    public void updateKeiyakuInfo(KeiyakuRegisterCompleteParamBean paramBean);

}
