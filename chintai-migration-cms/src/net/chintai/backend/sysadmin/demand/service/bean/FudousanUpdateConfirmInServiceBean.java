/*
 * $Id: FudousanUpdateConfirmInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/04     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 不動産会社更新確認
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanUpdateConfirmInServiceBean {

    /** 不動産会社コード */
    private String fudousanCd;

    /** 不動産会社名 */
    private String fudousanName;

    /** 不動産電話番号 */
    private String tel;

    /**
     * @return fudousanName
     */
    public String getFudousanName() {
        return fudousanName;
    }

    /**
     * @param fudousanName 設定する fudousanName
     */
    public void setFudousanName(String fudousanName) {
        this.fudousanName = fudousanName;
    }

    /**
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel 設定する tel
     */
    public void setTel(String tel) {
        this.tel = tel;
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
