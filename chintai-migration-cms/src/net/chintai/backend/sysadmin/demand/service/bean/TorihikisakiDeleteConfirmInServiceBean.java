/*
 * $Id: TorihikisakiDeleteConfirmInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 取引先削除確認
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiDeleteConfirmInServiceBean {

    /** 削除チェックされた取引先のシーケンス番号 */
    private String[] delFlgList;

    /**
     * 削除チェックされた取引先のシーケンス番号を取得します。
     * @return 削除チェックされた取引先のシーケンス番号
     */
    public String[] getDelFlgList() {
        return delFlgList;
    }

    /**
     * 削除チェックされた取引先のシーケンス番号を設定します。
     * @param delFlgList 削除チェックされた取引先のシーケンス番号
     */
    public void setDelFlgList(String[] delFlgList) {
        this.delFlgList = delFlgList;
    }
}
