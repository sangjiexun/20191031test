/*
 * $Id: AdDataUploadView.java 4359 2009-08-31 08:10:09Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/31     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.action.view;

import net.chintai.backend.sysadmin.common.ViewHelper;


/**
 * ADデータアップロードビュー
 *
 * @author Lee Hosup
 * @version $Revision: 4359 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AdDataUploadView implements ViewHelper {

    /** 対象年 */
    private  String uploadYear;


    /** 対象月 */
    private String uploadMonth;


    /**
     * 対象年を取得します。
     * @return 対象年
     */
    public String getUploadYear() {
        return uploadYear;
    }


    /**
     * 対象年を設定します。
     * @param uploadYear 対象年
     */
    public void setUploadYear(String uploadYear) {
        this.uploadYear = uploadYear;
    }


    /**
     * 対象月を取得します。
     * @return 対象月
     */
    public String getUploadMonth() {
        return uploadMonth;
    }


    /**
     * 対象月を設定します。
     * @param uploadMonth 対象月
     */
    public void setUploadMonth(String uploadMonth) {
        this.uploadMonth = uploadMonth;
    }
}
