/*
 * $Id: ReviewAutoDelInfoParamBean.java 3672 2007-12-20 02:19:39Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/28  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

/**
 * 自動削除期間検索条件
 *
 * @author lee-hosup
 * @version $Revision: 3672 $ Copyright:
 * (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewAutoDelInfoParamBean {

    /** 審査コード */
    private String shinsaCd;

    /**
     * 審査コードを取得します。
     * @return 審査コード
     */
    public String getShinsaCd() {
        return shinsaCd;
    }

    /**
     * 審査コードを設定します。
     * @param shinsaCd 審査コード
     */
    public void setShinsaCd(String shinsaCd) {
        this.shinsaCd = shinsaCd;
    }
}
