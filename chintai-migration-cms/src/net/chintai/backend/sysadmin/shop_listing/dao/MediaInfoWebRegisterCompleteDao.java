/*
 * $Id: MediaInfoWebRegisterCompleteDao.java 4259 2009-03-25 06:22:41Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/15     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

/**
 * 出稿情報本番反映完了DAO
 *
 * @author Lee Hosup
 * @version $Revision: 4259 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MediaInfoWebRegisterCompleteDao {

    /**
     * 店舗リスティングデータテーブルの情報を論理削除します。
     *
     * @param paramBean 削除条件
     */
    void logicalDeleteMediaInfoData(MediaInfoWebRegisterCompleteParamBean paramBean);

    /**
     * 店舗リスティング駅テーブルの情報を論理削除します。
     *
     * @param paramBean 削除条件
     */
    void logicalDeleteMediaInfoEki(MediaInfoWebRegisterCompleteParamBean paramBean);

    /**
     * 店舗リスティング市区町村テーブルの情報を論理削除します。
     *
     * @param paramBean 削除条件
     */
    void logicalDeleteMediaInfoCity(MediaInfoWebRegisterCompleteParamBean paramBean);

    /**
     * 店舗リスティングアイコンテーブルの情報を論理削除します。
     *
     * @param paramBean 削除条件
     */
    void logicalDeleteMediaInfoIcon(MediaInfoWebRegisterCompleteParamBean paramBean);

    /**
     * 店舗リスティングデータテーブルを更新します。
     *
     * @param paramBean 更新条件
     */
    void updateMediaInfoData(MediaInfoWebRegisterCompleteParamBean paramBean);

    /**
     * 店舗リスティング駅テーブルを更新します。
     *
     * @param paramBean 更新条件
     */
    void updateMediaInfoEki(MediaInfoWebRegisterCompleteParamBean paramBean);

    /**
     * 店舗リスティング市区町村テーブルを更新します。
     *
     * @param paramBean 更新条件
     */
    void updateMediaInfoCity(MediaInfoWebRegisterCompleteParamBean paramBean);

    /**
     * 店舗リスティングアイコンテーブルを更新します。
     *
     * @param paramBean 更新条件
     */
    void updateMediaInfoIcon(MediaInfoWebRegisterCompleteParamBean paramBean);

}
