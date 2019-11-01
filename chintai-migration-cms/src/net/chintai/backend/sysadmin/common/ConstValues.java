/*
 * $Id: ConstValues.java 4406 2009-10-14 01:56:40Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/13  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     shop_listingパッケージから移動
 */
package net.chintai.backend.sysadmin.common;

/**
 * 定数定義クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4406 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class ConstValues {

    /**
     * コンストラクター インスタンス化禁止。
     */
    private ConstValues() {
    }

    /** 汎用フラグ：ON */
    public static final String FLG_ON = "1";

    /** 汎用フラグ：OFF */
    public static final String FLG_OFF = "0";

    /** 半角空白 */
    public static final String SPACE = " ";

    /** スラシュー */
    public static final Object SLASH = "/";

    /** 出力先：画面 */
    public static final Object OUT_PUT_GAMEN = "gamen";

    /** 出力先：CVS */
    public static final Object OUT_PUT_CSV = "csv";

    /** 画像区分エラー */
    public static final String IMG_KBN_ERR = "-1";

    /** 契約種別：CHINTAI */
    public static final String KEIYAKU_CHINTAI = "0";

    /** 契約種別：エイブル */
    public static final String KEIYAKU_ABLE = "1";

    /** 汎用フラグ：契約する */
    public static final String KEIYAKU_ON = "1";

    /** 汎用フラグ：契約しない */
    public static final String KEIYAKU_OFF = "0";

    /** 日付表示形式 */
    public static final String YYYYMM = "yyyyMM";
}
