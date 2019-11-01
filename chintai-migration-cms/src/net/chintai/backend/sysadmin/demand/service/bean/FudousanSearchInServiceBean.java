/*
 * $Id: FudousanSearchInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/21  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;

/**
 * 不動産会社検索
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanSearchInServiceBean implements SessionSearchCondition{

    /** serialVersionUID */
    private static final long serialVersionUID = 2827139897212813158L;

    /** 不動産会社コード */
    private String fudousanCd;

    /** 不動産会社名 */
    private String fudousanName;

    /** ページング情報 */
    private int offSet;

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
	 * ページング情報を取得します。
	 * @return ページング情報
	 */
	public int getOffSet() {
	    return offSet;
	}

	/**
	 * ページング情報を設定します。
	 * @param offSet ページング情報
	 */
	public void setOffSet(int offSet) {
	    this.offSet = offSet;
	}

}
