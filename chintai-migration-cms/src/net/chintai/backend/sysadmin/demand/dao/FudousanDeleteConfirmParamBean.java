/*
 * $Id: FudousanDeleteConfirmParamBean.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/04     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;


/**
 * 不動産会社削除確認
 *
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanDeleteConfirmParamBean {

    /** 不動産会社コードのリスト */
    private String[] fudousanCd;

    /**
     * 不動産会社コードのリストを取得します。
     * @return 不動産会社コードのリスト
     */
    public String[] getFudousanCd() {
        return fudousanCd;
    }

    /**
     * 不動産会社コードのリストを設定します。
     * @param fudousanCd 不動産会社コードのリスト
     */
    public void setFudousanCd(String[] fudousanCd) {
        this.fudousanCd = fudousanCd;
    }

}
