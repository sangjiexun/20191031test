/*
 * $Id: ShisyaDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/14  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.common.tags.domain;

/**
 * 担当支社プルダウンデータ取得用
 * 
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShisyaDomain {

    /** 支社名 */
    private String optionName;

    /** 支社コード */
    private String optionValue;

    /**
     * 支社名を取得します。
     * @return 支社名
     */
    public String getOptionName() {
        return optionName;
    }

    /**
     * 支社名を設定します。
     * @param optionName 支社名
     */
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    /**
     * 支社コードを取得します。
     * @return 支社コード
     */
    public String getOptionValue() {
        return optionValue;
    }

    /**
     * 支社コードを設定します。
     * @param optionValue 支社コード
     */
    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
}
