/*
 * $Id: AspEnsenTypeInfo.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.domain;

/**
 * 不動産ASP設定で使用する沿線タイプ用Domain
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspEnsenTypeInfo {

    /** 沿線タイプコード */
    private String ensenTypeCd;

    /** 沿線タイプ名 */
    private String ensenTypeName;

    /** 沿線タイプソートキー */
    private String ensenTypeSortKey;

    /**
     * 沿線タイプコードを取得します。
     * @return ensenTypeCd 沿線タイプコード
     */
    public String getEnsenTypeCd() {
        return ensenTypeCd;
    }

    /**
     * 沿線タイプコードを設定します。
     * @param ensenTypeCd 沿線タイプコード
     */
    public void setEnsenTypeCd(String ensenTypeCd) {
        this.ensenTypeCd = ensenTypeCd;
    }

    /**
     * 沿線タイプ名を取得します。
     * @return ensenTypeName 沿線タイプ名
     */
    public String getEnsenTypeName() {
        return ensenTypeName;
    }

    /**
     * 沿線タイプ名を設定します。
     * @param ensenTypeName 沿線タイプ名
     */
    public void setEnsenTypeName(String ensenTypeName) {
        this.ensenTypeName = ensenTypeName;
    }

    /**
     * 沿線タイプソートキーを取得します。
     * @return ensenTypeSortKey 沿線タイプソートキー
     */
    public String getEnsenTypeSortKey() {
        return ensenTypeSortKey;
    }

    /**
     * 沿線タイプソートキーを設定します。
     * @param ensenTypeSortKey 沿線タイプソートキー
     */
    public void setEnsenTypeSortKey(String ensenTypeSortKey) {
        this.ensenTypeSortKey = ensenTypeSortKey;
    }

}
