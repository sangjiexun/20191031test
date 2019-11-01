/*
 * $Id: ShopBasicInfoUpdateConfirmOutServiceBean.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 店舗基本情報更新確認画面データ取得用
 *
 * @author Lee Hosup
 * @version $Revision: 4295 $ Copyright:
 * (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBasicInfoUpdateConfirmOutServiceBean {

    /** 沿線エリア名 */
    private String ensenAreaName;

    /** 沿線タイプコード */
    private String ensenType;

    /** 沿線名 */
    private String ensenName;

    /** 駅名 */
    private String ekiName;

    /**
     * 沿線エリア名を取得します。
     * @return 沿線エリア名
     */
    public String getEnsenAreaName() {
        return ensenAreaName;
    }

    /**
     * 沿線エリア名を設定します。
     * @param ensenAreaName 沿線エリア名
     */
    public void setEnsenAreaName(String ensenAreaName) {
        this.ensenAreaName = ensenAreaName;
    }

    /**
     * 沿線タイプコードを取得します。
     * @return 沿線タイプコード
     */
    public String getEnsenType() {
        return ensenType;
    }

    /**
     * 沿線タイプコードを設定します。
     * @param ensenType 沿線タイプコード
     */
    public void setEnsenType(String ensenType) {
        this.ensenType = ensenType;
    }

    /**
     * 沿線名を取得します。
     * @return 沿線名
     */
    public String getEnsenName() {
        return ensenName;
    }

    /**
     * 沿線名を設定します。
     * @param ensenName 沿線名
     */
    public void setEnsenName(String ensenName) {
        this.ensenName = ensenName;
    }

    /**
     * 駅名を取得します。
     * @return 駅名
     */
    public String getEkiName() {
        return ekiName;
    }

    /**
     * 駅名を設定します。
     * @param ekiName 駅名
     */
    public void setEkiName(String ekiName) {
        this.ekiName = ekiName;
    }

}
