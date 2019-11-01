/*
 * $Id: CustomTagDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/11  BGT)李昊燮   新規作成
 * 2007/11/02  BGT)劉俊秀   Q&Aカテゴリ取得処理追加
 */
package net.chintai.backend.sysadmin.common.dao;

import java.util.List;

/**
 * カスタムタグ用DAOクラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CustomTagDao {

    /**
     * エリア情報付きで都道府県の一覧を取得します。
     * @return 都道府県一覧
     */
    public List selectAreaTotal();

    /**
     * グループ一覧を取得します。
     * @return グループ一覧
     */
    public List selectUserGroup();

    /**
     * 操作内容リストを取得します。
     * @return 操作内容リスト
     */
    public List selectAuthority();

    /**
     * エリア情報を取得します。
     * @return エリア情報
     */
    public List selectAreaInfo();

    /**
     * Q&Aカテゴリを取得します。
     * @return Q&Aカテゴリ
     */
    public List selectQaCategory();

    /**
     * エリア情報を取得します。
     * @return エリア情報
     */
    public List selectInquiryInfo();

    /**
     * 支社情報を取得します。
     * @return 支社情報
     */
    public List selectShisyaInfo();

    /**
     * 問合せ用区分値マスタ情報を取得します。
     * @return 問合せ用区分値マスタ情報リスト
     */
    public List selectMstInquiryKbn(final String inqKbnColName);

    /**
     * 連動元マスタ取得
     * @return
     */
    public List selectMstRendo();
}
