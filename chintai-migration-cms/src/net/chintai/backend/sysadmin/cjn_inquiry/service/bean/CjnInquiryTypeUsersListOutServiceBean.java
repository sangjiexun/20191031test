/*
 * $Id: CjnInquiryTypeUsersListOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.bean;

/**
 * 問い合せ種別一覧の閲覧可能ユーザ情報
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeUsersListOutServiceBean {

    /** 閲覧可能ユーザ */
    private String userName;

    /**
     * 閲覧可能ユーザを取得します。
     * @return 閲覧可能ユーザ
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 閲覧可能ユーザを設定します。
     * @param userName 閲覧可能ユーザ
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
