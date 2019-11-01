/*
 * $Id: FudousanDetailInfoSearchInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/27     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 不動産会社詳細サービスを提供します。
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanDetailInfoSearchInServiceBean {

    /** 不動産会社コード */
    private String fudosanCd;

    /**
     * 不動産会社コードを取得します
     * @return 不動産会社コード
     */
    public String getFudosanCd() {
        return fudosanCd;
    }

    /**
     * 不動産会社コードを設定します
     * @param fudosanCd 不動産会社コード
     */
    public void setFudosanCd(String fudosanCd) {
        this.fudosanCd = fudosanCd;
    }

}
