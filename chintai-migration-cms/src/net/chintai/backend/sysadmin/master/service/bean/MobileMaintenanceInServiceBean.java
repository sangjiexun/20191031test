/*
 * $Id: MobileMaintenanceInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.bean;

import java.util.List;

/**
 * 携帯ゲーム対応機種メンテナンスinServiceBean
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MobileMaintenanceInServiceBean {

    /** アップロードリスト */
    private List<String[]> uploadList;

    /**
     * アップロードリストを取得します。
     * @return アップロードリスト
     */
    public List<String[]> getUploadList() {
        return uploadList;
    }

    /**
     * アップロードリストを設定します。
     * @param uploadList アップロードリスト
     */
    public void setUploadList(List<String[]> uploadList) {
        this.uploadList = uploadList;
    }

}
