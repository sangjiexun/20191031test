/*
 * $Id: ShikutyosonAddDao.java 4294 2009-07-07 12:42:15Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/14  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao;

/**
 * 市区町村登録DAO
 * @author Yang-EunMi
 * @version $Revision: 4294 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShikutyosonAddDao {

    /**
     * MST_CITYテーブルのデータを全国都道府県JISコードでチェックします。
     * @param paramBean 検索パラメータ(全国都道府県JISコード)
     * @return 検索結果件数
     */
    public int selectMstCity(ShikutyosonAddParamBean paramBean);

    /**
     * MST_CITYテーブルに新規データ追加します。
     * @param paramBean 登録する市区町村情報
     */
    public void insertMstCity(ShikutyosonAddParamBean paramBean);

    /**
     * MST_ZIPCODEテーブルのデータを全国都道府県JISコード、郵便番号でチェックします。
     * @param paramBean 検索パラメータ(全国都道府県JISコード、郵便番号)
     * @return 検索結果件数
     */
    public int selectMstZipCode(ShikutyosonAddParamBean paramBean);

    /**
     * MST_ZIPCODEテーブルに新規データ登録します。
     * @param paramBean 登録する市区町村情報
     */
    public void insertMstZipCode(ShikutyosonAddParamBean paramBean);

    /**
     * MST_ZIPCODEテーブルに更新します。
     * @param paramBean 更新する郵便番号情報
     */
    public void updateMstZipCode(ShikutyosonAddParamBean paramBean);

    /**
     * MST_ZIPCODEテーブルから削除します。
     * @param paramBean 更新する郵便番号情報
     */
    public void deleteMstZipCode(ShikutyosonAddParamBean paramBean);

    /**
     * MST_CITYテーブル更新。
     *
     * @param paramBean 更新する市区町村情報
     * @author lee-hosup
     * @since 2009.06.04 追加
     */
    public void updateMstCity(ShikutyosonAddParamBean paramBean);

}
