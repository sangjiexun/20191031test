/*
 * $Id: FudousanUpdatePageInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/29     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 不動産会社情報更新Bean
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanUpdatePageInServiceBean {

    /** 不動産会社コード */
    private String fudousanCd;

    /** 詳細画面の現在位置 */
    private int offSet;

    /**
     * @return offSet
     */
    public int getOffSet() {
        return offSet;
    }

    /**
     * @param offSet 設定する offSet
     */
    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

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
