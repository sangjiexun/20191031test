/*
 * $Id: BukkenQueryIdSearchInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 問合せ番号で検索InServiceBean
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenQueryIdSearchInServiceBean {

    /** 受付番号 */
    private String uketukeCd;

    /**
     * 受付番号を取得します。
     * @return 受付番号
     */
    public String getUketukeCd() {
        return uketukeCd;
    }

    /**
     * 受付番号を設定します。
     * @param uketukeCd 受付番号
     */
    public void setUketukeCd(String uketukeCd) {
        this.uketukeCd = uketukeCd;
    }
}