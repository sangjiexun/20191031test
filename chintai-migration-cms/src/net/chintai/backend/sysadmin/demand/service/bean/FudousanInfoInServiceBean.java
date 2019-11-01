/*
 * $Id: FudousanInfoInServiceBean.java 3630 2007-12-18 06:12:29Z y-takahashi $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/28     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 取引先情報詳細
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3630 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class FudousanInfoInServiceBean {

    /** 不動産会社コード */
    private String fudousanCd;

    /**
     * @return fudousanCd
     */
    public String getFudousanCd() {
        return fudousanCd;
    }

    /**
     * @param fudousanCd 設定する fudousanCd
     */
    public void setFudousanCd(String fudousanCd) {
        this.fudousanCd = fudousanCd;
    }

}
