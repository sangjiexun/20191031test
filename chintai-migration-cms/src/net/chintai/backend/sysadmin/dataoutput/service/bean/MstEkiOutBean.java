/*
 * $Id: MstEkiOutBean.java 4804 2014-01-10 05:49:32Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/19     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.bean;


/**
 * MST_EKI情報用OutBean
 * @author KAMEDA Takuma
 * @version $Revision: 4804 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MstEkiOutBean {

    /** 駅コード */
    private String ekiCd;

    /** 駅名 */
    private String ekiName;

    /**
     * 駅コードを取得します。
     * @return 駅コード
     */
    public String getEkiCd() {
        return ekiCd;
    }

    /**
     * 駅コードを設定します。
     * @param ekiCd 駅コード
     */
    public void setEkiCd(String ekiCd) {
        this.ekiCd = ekiCd;
    }

    /**
     * 駅名を取得します。
     * @return 駅名
     */
    public String getEkiName() {
        return ekiName;
    }

    /**
     * 駅名を設定します。
     * @param ekiName 駅名
     */
    public void setEkiName(String ekiName) {
        this.ekiName = ekiName;
    }

}
