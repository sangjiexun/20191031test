/*
 * $Id: ReviewTodofukenMediaCountInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.bean;

/**
 * 都道府県別出稿状況集計条件
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewTodofukenMediaCountInServiceBean {

    /** 検索開始年 */
    private String sumYmdFromYear;

    /** 検索開始月 */
    private String sumYmdFromMonth;

    /** 都道府県コード */
    private String prefCd;

    /** 出力先 */
    private String outPut;

    /**
     * 検索開始月を取得
     * @return sumYmdFromMonth
     */
    public String getSumYmdFromMonth() {
        return sumYmdFromMonth;
    }

    /**
     * 検索開始月を設定する
     * @param sumYmdFromMonth
     */
    public void setSumYmdFromMonth(String sumYmdFromMonth) {
        this.sumYmdFromMonth = sumYmdFromMonth;
    }

    /**
     * 都道府県コードを取得
     * @return sumYmdFromYear
     */
    public String getSumYmdFromYear() {
        return sumYmdFromYear;
    }

    /**
     * 都道府県コードを設定する
     * @param sumYmdFromYear
     */
    public void setSumYmdFromYear(String sumYmdFromYear) {
        this.sumYmdFromYear = sumYmdFromYear;
    }

	/**
	 * 都道府県コードを取得します。
	 * @return 都道府県コード
	 */
	public String getPrefCd() {
	    return prefCd;
	}

	/**
	 * 都道府県コードを設定します。
	 * @param prefCd 都道府県コード
	 */
	public void setPrefCd(String prefCd) {
	    this.prefCd = prefCd;
	}

	/**
	 * 出力先を取得します。
	 * @return 出力先
	 */
	public String getOutPut() {
	    return outPut;
	}

	/**
	 * 出力先を設定します。
	 * @param outPut 出力先
	 */
	public void setOutPut(String outPut) {
	    this.outPut = outPut;
	}

}
