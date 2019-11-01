/*
 * $Id: EkiInfoSearchParamBean.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

/**
 * 出稿対象駅情報を検索する時の引数を格納。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EkiInfoSearchParamBean {

    /** 沿線コード */
    private String ensenCd;

    /** 駅コード */
    private String ekiCd;

    /**
     * 沿線コードを取得します。
     * @return 沿線コード
     */
    public String getEnsenCd() {
        return ensenCd;
    }

    /**
     * 沿線コードを設定します。
     * @param ensenCd 沿線コード
     */
    public void setEnsenCd(String ensenCd) {
        this.ensenCd = ensenCd;
    }

    /**
     * 駅コードを取得します。
     * @return 駅コード
     */
    public String getEkiCd() {
        return ekiCd;
    }

    /**
     * 駅コードを設定します。
     * @param ekiCd 駅コード
     */
    public void setEkiCd(String ekiCd) {
        this.ekiCd = ekiCd;
    }

}
