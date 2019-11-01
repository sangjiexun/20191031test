/*
 * $Id: FudousanRegisterConfirmInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 不動産会社登録確認
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanRegisterConfirmInServiceBean {

    /** 不動産会社名 */
    private String fudousanName;

    /** 不動産電話番号 */
    private String tel;

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
	 * 不動産電話番号を取得します。
	 * @return 不動産電話番号
	 */
	public String getTel() {
	    return tel;
	}

	/**
	 * 不動産電話番号を設定します。
	 * @param tel 不動産電話番号
	 */
	public void setTel(String tel) {
	    this.tel = tel;
	}

}
