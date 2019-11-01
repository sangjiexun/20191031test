/*
 * $Id: FudousanDeleteConfirmInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/04     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 削除対象不動産会社
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanDeleteConfirmInServiceBean {

    /** 不動産会社コードのリスト */
    private String[] fudousanCd;

    /**
     * @return fudousanCd
     */
    public String[] getFudousanCd() {
        return fudousanCd;
    }

    /**
     * @param fudousanCd 設定する fudousanCd
     */
    public void setFudousanCd(String[] fudousanCd) {
        this.fudousanCd = fudousanCd;
    }

}
