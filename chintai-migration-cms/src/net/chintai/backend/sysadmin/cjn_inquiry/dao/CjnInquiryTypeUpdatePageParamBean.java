/*
 * $Id: CjnInquiryTypeUpdatePageParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

/**
 * 問い合せ種別編集情報照会用検索パラメータ
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeUpdatePageParamBean {

    /** 問い合せ種別シーケンス */
    private int cjnInqKindSeq;

    /**
     * 問い合せ種別シーケンスを取得します。
     * @return 問い合せ種別シーケンス
     */
    public int getCjnInqKindSeq() {
        return cjnInqKindSeq;
    }

    /**
     * 問い合せ種別シーケンスを設定します。
     * @param cjnInqKindSeq 問い合せ種別シーケンス
     */
    public void setCjnInqKindSeq(int cjnInqKindSeq) {
        this.cjnInqKindSeq = cjnInqKindSeq;
    }

}
