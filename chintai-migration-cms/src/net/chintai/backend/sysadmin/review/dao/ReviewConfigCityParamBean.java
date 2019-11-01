/*
 * $Id: ReviewConfigCityParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

/**
 * 市区町村別比較対象設定内容検索条件
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewConfigCityParamBean {

    /** 都道府県コード */
    private String prefCd;

    /**
     * 都道府県コードを取得
     * @return prefCd
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県コードを設定する
     * @param prefCd
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }
}
