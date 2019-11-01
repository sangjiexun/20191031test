/*
 * $Id: CustomTagService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/11  BGT)李昊燮   新規作成
 * 2007/11/02  BGT)劉俊秀   Q&Aカテゴリ取得処理追加
 */
package net.chintai.backend.sysadmin.common.service;

import java.util.List;

/**
 * カスタムタグに出力する内容を取得するサービス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CustomTagService {

    /**
     * 都道府県リストを取得します。
     * @return 都道府県リスト
     */
    public List todofukenListService();

    /**
     * グループリストを取得します。
     * @return グループリスト
     */
    public List userGroupListService();

    /**
     * 操作内容リストを取得します。
     * @return グループリスト
     */
    public List getAuthorityService();

    /**
     * エリア情報を取得します。
     * @return グループリスト
     */
    public List getAreaInfoService();

    /**
     * Q&Aカテゴリを取得します。
     * @return Q&Aカテゴリリスト
     */
    public List getMngMstQaCategoryService();

    /**
     * 問い合せ種別情報を取得します。
     * @return 問い合せ種別リスト
     */
    public List getInquiryInfo();

    /**
     * 支社情報を取得します。
     * @return 支社情報リスト
     */
    public List getShisyaInfo();

    /**
     * 問合せ用区分値マスタ情報を取得します。
     * @return 問合せ用区分値マスタ情報リスト
     */
    public List getMstInquiryKbn(final String inqKbnColName);

    /**
     * 連動元マスタ取得
     * @return
     */
    public List getMstRendo();
}
