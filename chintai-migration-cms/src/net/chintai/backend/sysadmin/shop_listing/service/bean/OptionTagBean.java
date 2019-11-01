/*
 * $Id: OptionTagBean.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/14     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

/**
 * 出稿情報登録/編集画面の選択済プルダウン生成用。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class OptionTagBean {

    /** Optionタグのコード値 */
    private String key;

    /** Optionタグの名 */
    private String value;

    /**
     * Optionタグのコード値を取得します。
     * @return Optionタグのコード値
     */
    public String getKey() {
        return key;
    }

    /**
     * Optionタグのコード値を設定します。
     * @param key Optionタグのコード値
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Optionタグの名を取得します。
     * @return Optionタグの名
     */
    public String getValue() {
        return value;
    }

    /**
     * Optionタグの名を設定します。
     * @param value Optionタグの名
     */
    public void setValue(String value) {
        this.value = value;
    }

}
