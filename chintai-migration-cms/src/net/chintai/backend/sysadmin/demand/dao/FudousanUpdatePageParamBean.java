/*
 * $Id: FudousanUpdatePageParamBean.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/29     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

/**
 * 不動産会社更新条件
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3667 $ Copyright:
 * (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanUpdatePageParamBean {

    /** 不動産会社コード */
    private String fudousanCd;

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

}
