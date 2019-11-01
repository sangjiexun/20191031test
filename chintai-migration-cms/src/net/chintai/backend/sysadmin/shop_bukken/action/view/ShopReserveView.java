/*
 * $Id: ShopSearchView.java 3853 2008-03-10 05:43:48Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.pager.PagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;

/**
 * 店舗予約のViewHelper
 *
 * @version $Revision: 3853 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopReserveView extends PagerViewHelper {

	/**
	 * コンストラクター
	 * @param condition
	 */
	public ShopReserveView(final PagerCondition condition) {
		super(condition);
	}

	private String startYear;

	private String shopCd;

	private String kaishaMeiBushoMei;

	private String rendoCd;

	private String applyFrom;
	private String applyDtFromYear;
	private String applyDtFromMonth;
	private String applyDtFromDay;
	private String applyDtFromTime;
	private String applyTo;
	private String applyDtToYear;
	private String applyDtToMonth;
	private String applyDtToDay;
	private String applyDtToTime;
	private String reserveFrom;
	private String reserveDtFromYear;
	private String reserveDtFromMonth;
	private String reserveDtFromDay;
	private String reserveDtFromTime;
	private String reserveTo;
	private String reserveDtToYear;
	private String reserveDtToMonth;
	private String reserveDtToDay;
	private String reserveDtToTime;

	private String reserveKbn;

	public String getShopCd() {
		return shopCd;
	}

	public void setShopCd(String shopCd) {
		this.shopCd = shopCd;
	}

	public String getKaishaMeiBushoMei() {
		return kaishaMeiBushoMei;
	}

	public void setKaishaMeiBushoMei(String kaishaMeiBushoMei) {
		this.kaishaMeiBushoMei = kaishaMeiBushoMei;
	}

	public String getRendoCd() {
		return rendoCd;
	}

	public void setRendoCd(String rendoCd) {
		this.rendoCd = rendoCd;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getApplyFrom() {
		return applyFrom;
	}

	public void setApplyFrom(String applyFrom) {
		this.applyFrom = applyFrom;
	}

	public String getApplyDtFromYear() {
		return applyDtFromYear;
	}

	public void setApplyDtFromYear(String applyDtFromYear) {
		this.applyDtFromYear = applyDtFromYear;
	}

	public String getApplyDtFromMonth() {
		return applyDtFromMonth;
	}

	public void setApplyDtFromMonth(String applyDtFromMonth) {
		this.applyDtFromMonth = applyDtFromMonth;
	}

	public String getApplyDtFromDay() {
		return applyDtFromDay;
	}

	public void setApplyDtFromDay(String applyDtFromDay) {
		this.applyDtFromDay = applyDtFromDay;
	}

	public String getApplyDtFromTime() {
		return applyDtFromTime;
	}

	public void setApplyDtFromTime(String applyDtFromTime) {
		this.applyDtFromTime = applyDtFromTime;
	}

	public String getApplyTo() {
		return applyTo;
	}

	public void setApplyTo(String applyTo) {
		this.applyTo = applyTo;
	}

	public String getApplyDtToYear() {
		return applyDtToYear;
	}

	public void setApplyDtToYear(String applyDtToYear) {
		this.applyDtToYear = applyDtToYear;
	}

	public String getApplyDtToMonth() {
		return applyDtToMonth;
	}

	public void setApplyDtToMonth(String applyDtToMonth) {
		this.applyDtToMonth = applyDtToMonth;
	}

	public String getApplyDtToDay() {
		return applyDtToDay;
	}

	public void setApplyDtToDay(String applyDtToDay) {
		this.applyDtToDay = applyDtToDay;
	}

	public String getApplyDtToTime() {
		return applyDtToTime;
	}

	public void setApplyDtToTime(String applyDtToTime) {
		this.applyDtToTime = applyDtToTime;
	}

	public String getReserveFrom() {
		return reserveFrom;
	}

	public void setReserveFrom(String reserveFrom) {
		this.reserveFrom = reserveFrom;
	}

	public String getReserveDtFromYear() {
		return reserveDtFromYear;
	}

	public void setReserveDtFromYear(String reserveDtFromYear) {
		this.reserveDtFromYear = reserveDtFromYear;
	}

	public String getReserveDtFromMonth() {
		return reserveDtFromMonth;
	}

	public void setReserveDtFromMonth(String reserveDtFromMonth) {
		this.reserveDtFromMonth = reserveDtFromMonth;
	}

	public String getReserveDtFromDay() {
		return reserveDtFromDay;
	}

	public void setReserveDtFromDay(String reserveDtFromDay) {
		this.reserveDtFromDay = reserveDtFromDay;
	}

	public String getReserveDtFromTime() {
		return reserveDtFromTime;
	}

	public void setReserveDtFromTime(String reserveDtFromTime) {
		this.reserveDtFromTime = reserveDtFromTime;
	}

	public String getReserveTo() {
		return reserveTo;
	}

	public void setReserveTo(String reserveTo) {
		this.reserveTo = reserveTo;
	}

	public String getReserveDtToYear() {
		return reserveDtToYear;
	}

	public void setReserveDtToYear(String reserveDtToYear) {
		this.reserveDtToYear = reserveDtToYear;
	}

	public String getReserveDtToMonth() {
		return reserveDtToMonth;
	}

	public void setReserveDtToMonth(String reserveDtToMonth) {
		this.reserveDtToMonth = reserveDtToMonth;
	}

	public String getReserveDtToDay() {
		return reserveDtToDay;
	}

	public void setReserveDtToDay(String reserveDtToDay) {
		this.reserveDtToDay = reserveDtToDay;
	}

	public String getReserveDtToTime() {
		return reserveDtToTime;
	}

	public void setReserveDtToTime(String reserveDtToTime) {
		this.reserveDtToTime = reserveDtToTime;
	}

	public String getReserveKbn() {
		return reserveKbn;
	}

	public void setReserveKbn(String reserveKbn) {
		this.reserveKbn = reserveKbn;
	}


}
