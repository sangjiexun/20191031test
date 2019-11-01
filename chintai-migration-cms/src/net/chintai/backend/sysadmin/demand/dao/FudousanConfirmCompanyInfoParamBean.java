/*
 * $Id: FudousanConfirmCompanyInfoParamBean.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

/**
 * 不動産会社重複登録確認
 *
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanConfirmCompanyInfoParamBean {

    /** 不動産会社コード */
    private String fudousanCd;

    /** 不動産会社名 */
    private String fudousanName;

    /** 不動産会社電話番号 */
    private String tel;

    /**
     * 不動産会社コードを取得します。
     * @return 不動産会社コード
     */
    public String getFudousanCd() {
        return fudousanCd;
    }

    /**
     * 不動産会社コードを設定します。
     * @param fudousanCd 不動産会社コード
     */
    public void setFudousanCd(String fudousanCd) {
        this.fudousanCd = fudousanCd;
    }

    /**
     * 不動産会社名を取得します。
     * @return 不動産会社名
     */
    public String getFudousanName() {
        return fudousanName;
    }

    /**
     * 不動産会社名を設定します。
     * @param fudousanName 不動産会社名
     */
    public void setFudousanName(String fudousanName) {
        this.fudousanName = fudousanName;
    }

    /**
     * 不動産会社電話番号を取得します。
     * @return 不動産会社電話番号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 不動産会社電話番号を設定します。
     * @param tel 不動産会社電話番号
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

}
