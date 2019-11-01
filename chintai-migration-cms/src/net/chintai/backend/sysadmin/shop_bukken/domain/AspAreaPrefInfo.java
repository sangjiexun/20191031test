/*
 * $Id: AspAreaPrefInfo.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.domain;

/**
 * 不動産ASP設定で使用するエリアと都道府県用Dao
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspAreaPrefInfo {

    /** エリアコード */
    private String areaCd;

    /** エリア名 */
    private String areaName;

    /** 都道府県コード */
    private String prefCd;

    /** 都道府県名 */
    private String prefName;

    /** エリア都道府県のコード名 */
    private String prefCodeName;

    /**
     * エリアコードを取得します。
     * @return areaCd エリアコード
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * エリアコードを設定します。
     * @param areaCd エリアコード
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    /**
     * エリア名を取得します。
     * @return areaName エリア名
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * エリア名を設定します。
     * @param areaName エリア名
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 都道府県コードを取得します。
     * @return prefCd 都道府県コード
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県コードを設定します。
     * @param prefCd 都道府県コード
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

    /**
     * エリア都道府県のコード名を取得します。
     * @return prefCodeName エリア都道府県のコード名
     */
    public String getPrefCodeName() {
        return prefCodeName;
    }

    /**
     * エリア都道府県のコード名を設定します。
     * @param prefCodeName エリア都道府県のコード名
     */
    public void setPrefCodeName(String prefCodeName) {
        this.prefCodeName = prefCodeName;
    }

    /**
     * 都道府県コードを取得します。
     * @return prefName 都道府県コード
     */
    public String getPrefName() {
        return prefName;
    }

    /**
     * 都道府県名を設定します。
     * @param prefName 都道府県名
     */
    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }

}
