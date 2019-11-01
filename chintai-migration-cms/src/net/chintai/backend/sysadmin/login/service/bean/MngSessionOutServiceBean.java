/*
 * LoginServiceBean.java
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/15  BGT)児島   新規作成
 * 2007/08/08  BGT)児島   グループIDを削除
 */
package net.chintai.backend.sysadmin.login.service.bean;

/**
 * セッション情報管理の Bean
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MngSessionOutServiceBean {

    /*** ログインキー */
    private String loginKey;

    /** シーケンス */
    private Long sidId;

    /**
     * シーケンスを返します。
     * @return シーケンス
     */
    public Long getSidId() {
        return sidId;
    }

    /**
     * シーケンスを設定します。
     * @param sid  シーケンス
     */
    public void setSid(Long sidId) {
        this.sidId = sidId;
    }

    /**
     * ログインキーを返します。
     * @return ログインキー
     */
    public String getLoginKey() {
        return loginKey;
    }

    /**
     * ログインキーを設定します。
     * @param loginKey  ログインキー
     */
    public void setLoginKey(String loginKey) {
        this.loginKey = loginKey;
    }


}
