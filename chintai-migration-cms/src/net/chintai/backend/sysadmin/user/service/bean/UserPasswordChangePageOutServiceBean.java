/*
 * $Id: UserPasswordChangePageOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * ユーザパスワード変更画面に遷移OutServiceBean
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserPasswordChangePageOutServiceBean {

    /** 更新日時 */
    private String updDt;

    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 更新日時を設定します。
     * @param updDt 更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }
}