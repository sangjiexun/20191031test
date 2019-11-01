/*
 * $Id: CjnInquiryTypeInfoUsersOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.bean;

/**
 * 問い合せ種別詳細照会(閲覧可能ユーザ一覧)
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeInfoUsersOutServiceBean {

    /** 閲覧可否 */
    private boolean exists;

    /** 名前 */
    private String userName;

    /**
     * 閲覧可否を取得します。
     * @return 閲覧可否
     */
    public boolean getExists() {
        return exists;
    }

    /**
     * 閲覧可否を設定します。
     * @param exists 閲覧可否
     */
    public void setExists(boolean exists) {
        this.exists = exists;
    }

    /**
     * 名前を取得します。
     * @return 名前
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 名前を設定します。
     * @param userName 名前
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
