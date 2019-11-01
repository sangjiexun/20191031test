/*
 * $Id: ReviewTodofukenMediaCountParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

/**
 * 都道府県別出稿状況集計検索条件
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewTodofukenMediaCountParamBean {

    /** 検索開始年月 */
    private String sumYmdFrom;

    /** 検索終了年月 */
    private String sumYmdTo;

    /** 検索年月詳細 */
    private String[] dates;

    /** 都道府県コード */
    private String prefCd;
    
    /** 出力先 */
    private String outPut;

    /**
	 * 検索開始年月を取得します。
	 * @return 検索開始年月
	 */
	public String getSumYmdFrom() {
	    return sumYmdFrom;
	}

	/**
	 * 検索開始年月を設定します。
	 * @param sumYmdFrom 検索開始年月
	 */
	public void setSumYmdFrom(String sumYmdFrom) {
	    this.sumYmdFrom = sumYmdFrom;
	}

	/**
	 * 検索終了年月を取得します。
	 * @return 検索終了年月
	 */
	public String getSumYmdTo() {
	    return sumYmdTo;
	}

	/**
	 * 検索終了年月を設定します。
	 * @param sumYmdTo 検索終了年月
	 */
	public void setSumYmdTo(String sumYmdTo) {
	    this.sumYmdTo = sumYmdTo;
	}

	/**
     * ReviewTodofukenMediaCountParamBean.javaを取得
     * @return dates
     */
    public String[] getDates() {
        return dates;
    }

    /**
     * datesを設定する
     * @param dates
     */
    public void setDates(String[] dates) {
        this.dates = dates;
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
