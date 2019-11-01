/*
 * $Id: SessionSearchKey.java 4600 2013-09-10 05:06:57Z t-kameda $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/12/01   BGT)児島      新規作成
 * 2013/9/10    BGT)亀田      電話反響件数対応にて、フリーコール検索/一覧追加
 */
package net.chintai.backend.sysadmin.common.session;

/**
 * セッションに保持する検索条件のキー文字列を定義する定数クラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 4600 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public final class SessionSearchKey {

    /*
     * キー文字列を追加するとき、他のキーと重複することのないように注意すること。
     */

    /** 店舗検索・店舗情報から検索 */
    public static final String SHOP_BUKKEN_SEARCH_BY_SHOPINFO = "shopSearchByShopInfo";

    /** 店舗検索・地域・沿線から検索 */
    public static final String SHOP_BUKKEN_SEARCH_BY_AREA = "shopSearchByArea";

    /** CHINTAI問い合せ管理・問い合せ検索 */
    public static final String CJN_INQUIRY_SEARCH = "cjnInquirySearch";

    /** CHINTAI問い合せ管理・システム操作履歴検索 */
    public static final String CJN_LOGOPERATION = "cjnLogOperation";

    /** Web審査・店舗検索 */
    public static final String REVIEW_SHOP_SEARCH = "reviewShopSearch";

    /** Web審査・物件検索 */
    public static final String REVIEW_BUKKEN_SEARCH = "reviewBukkenSearch";

    /** Web審査・店舗別出稿状況集計検索 */
    public static final String REVIEW_SHOP_MEDIA_COUNT = "reviewShopMediaCount";

    /** Web審査・警告対象物件一覧 */
    public static final String REVIEW_BUKKEN_ALERT_COUNT = "reviewBukkenAlertCount";

    /** 物件枠・店舗コード紐付検索 */
    public static final String DEMAND_SHOP_BIND_SEARCH = "demandShopBindSearch";

    /** 物件枠・取引先検索(店舗コード紐付機能用) */
    public static final String DEMAND_TORIHIKISAKI_SEARCH_FOR_BIND = "demandTorihikisakiSearchForBind";

    /** 物件枠・取引先一覧 */
    public static final String DEMAND_TORIHIKISAKI_LIST = "demandTorihikisakiList";

    /** 物件枠・不動産会社メンテナンス検索 */
    public static final String DEMAND_FUDOUSAN_SEARCH = "demandFudousanSearch";

    /** 物件枠・取引先検索(取引先メンテナンス) */
    public static final String DEMAND_TORIHIKISAKI_SEARCH = "demandTorihikisakiSearch";

    /** 物件枠・不動産会社検索(取引先新規登録用) */
    public static final String DEMAND_FUDOUSAN_SEARCH_FOR_REF = "demandFudousanSearchForRef";

    /** 不動産会社に探してもらう・消費者検索 */
    public static final String REQUEST_CUSTOMER_SEARCH = "resuestCustomer";

    /** 不動産会社に探してもらう・店舗検索(通常) */
    public static final String REQUEST_SHOP_SEARCH = "requestShop";

    /** 不動産会社に探してもらう・店舗検索(ランキング) */
    public static final String REQUEST_SHOP_RANKING = "requestRanking";

    /** リンクカウント・検索 */
    public static final String LINKCOUNT = "linkCount";

    /** マスタ管理・沿線駅検索 */
    public static final String MASTER_ROSEN_SEARCH = "masterRosenSearch";

    /** 店舗/物件問い合せ・問い合せ履歴検索 */
    public static final String SHOP_INQUIRY_RECENT = "shopInquiryRecent";

    /** 店舗/物件問い合せ・システム操作履歴検索 */
    public static final String SHOP_INQUIRY_LOGOPERATION = "shopInquiryLogOperation";

    /** ユーザ管理・操作ログ検索 */
    public static final String USER_LOGOPERATION = "userLogOperation";

    /** 鉄道会社検索 */
    public static final String TETUDO_GAISHA_SEARCH = "tetudoGaishaSearch";

    /** 契約管理：契約店舗検索 */
    public static final String CONTRACT_SHOP_SEARCH = "contractShopSearch";

    /** ADデータと物件データ照合：照合結果一覧 */
    public static final String MATCHING_DATA_LIST = "matchingdataList";

    /** フリーコール検索/一覧 */
    public static final String CALL_COUNT_SEARCH = "callCountSerch";

    /**
     * このクラスはインスタンス化できません。
     */
    private SessionSearchKey() {
    }
}
