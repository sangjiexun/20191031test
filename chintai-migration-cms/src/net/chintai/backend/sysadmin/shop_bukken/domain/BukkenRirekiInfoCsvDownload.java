/*
 * $Id: BukkenRirekiInfoCsvDownload.java 4558 2012-12-10 01:09:25Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/05/27  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.domain;

/**
 * 物件入稿履歴情報Bean(CSV出力用)
 *
 * @author Lee Hosup
 * @version $Revision: 4558 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenRirekiInfoCsvDownload {

	/** 入稿登録日時 */
    private String insDt;

    /** 入稿状況 */
    private String insKbn;

    /** 部屋止めフラグ */
    private String heyadomeKbn;

    /** 部屋状況 */
    private String heyaJokyo;

    /** 取引 */
    private String torihiki;

    /** 取引形態 */
    private String torihikiKeitai;

    /** 座標情報(町丁レベルのX座標) */
    private String locTX;

    /** 座標情報(町丁レベルのY座標) */
    private String locTY;

    /** 座標情報(番地レベルのX座標) */
    private String locBX;

    /** 座標情報(番地レベルのY座標) */
    private String locBY;

    /** 座標情報(号レベルのX座標) */
    private String locMX;

    /** 座標情報(号レベルのY座標) */
    private String locMY;

    private String imgCnt;

    private String allImgCnt;

    private String locX;
    private String locY;

    private String imgBaseDt;
    private String recSendStatus;
    private String ctFrontSendResultKbn;
    private String ablFrontSendResultKbn;

    private String pkBukkenRireki;

    private String shopcd;
    private String bkcd;
    private String roomno;

    private String brInsPg;
    private String bskInsPg;
    private String brUpdPg;
    private String bskUpdPg;
    private String formatTypeCd;
    private String rendoCd;
    private String rendoName;

	/**
	 * @return insDt
	 */
	public String getInsDt() {
		return insDt;
	}

	/**
	 * @param insDt セットする insDt
	 */
	public void setInsDt(String insDt) {
		this.insDt = insDt;
	}

	/**
	 * @return insKbn
	 */
	public String getInsKbn() {
		return insKbn;
	}

	/**
	 * @param insKbn セットする insKbn
	 */
	public void setInsKbn(String insKbn) {
		this.insKbn = insKbn;
	}

	/**
	 * @return heyadomeKbn
	 */
	public String getHeyadomeKbn() {
		return heyadomeKbn;
	}

	/**
	 * @param heyadomeKbn セットする heyadomeKbn
	 */
	public void setHeyadomeKbn(String heyadomeKbn) {
		this.heyadomeKbn = heyadomeKbn;
	}

	/**
	 * @return heyaJokyo
	 */
	public String getHeyaJokyo() {
		return heyaJokyo;
	}

	/**
	 * @param heyaJokyo セットする heyaJokyo
	 */
	public void setHeyaJokyo(String heyaJokyo) {
		this.heyaJokyo = heyaJokyo;
	}

	/**
	 * @return torihiki
	 */
	public String getTorihiki() {
		return torihiki;
	}

	/**
	 * @param torihiki セットする torihiki
	 */
	public void setTorihiki(String torihiki) {
		this.torihiki = torihiki;
	}

	/**
	 * @return torihikiKeitai
	 */
	public String getTorihikiKeitai() {
		return torihikiKeitai;
	}

	/**
	 * @param torihikiKeitai セットする torihikiKeitai
	 */
	public void setTorihikiKeitai(String torihikiKeitai) {
		this.torihikiKeitai = torihikiKeitai;
	}

	/**
	 * @return locTX
	 */
	public String getLocTX() {
		return locTX;
	}

	/**
	 * @param locTX セットする locTX
	 */
	public void setLocTX(String locTX) {
		this.locTX = locTX;
	}

	/**
	 * @return locTY
	 */
	public String getLocTY() {
		return locTY;
	}

	/**
	 * @param locTY セットする locTY
	 */
	public void setLocTY(String locTY) {
		this.locTY = locTY;
	}

	/**
	 * @return locBX
	 */
	public String getLocBX() {
		return locBX;
	}

	/**
	 * @param locBX セットする locBX
	 */
	public void setLocBX(String locBX) {
		this.locBX = locBX;
	}

	/**
	 * @return locBY
	 */
	public String getLocBY() {
		return locBY;
	}

	/**
	 * @param locBY セットする locBY
	 */
	public void setLocBY(String locBY) {
		this.locBY = locBY;
	}

	/**
	 * @return locMX
	 */
	public String getLocMX() {
		return locMX;
	}

	/**
	 * @param locMX セットする locMX
	 */
	public void setLocMX(String locMX) {
		this.locMX = locMX;
	}

	/**
	 * @return locMY
	 */
	public String getLocMY() {
		return locMY;
	}

	/**
	 * @param locMY セットする locMY
	 */
	public void setLocMY(String locMY) {
		this.locMY = locMY;
	}

	/**
	 * @return imgCnt
	 */
	public String getImgCnt() {
		return imgCnt;
	}

	/**
	 * @param imgCnt セットする imgCnt
	 */
	public void setImgCnt(String imgCnt) {
		this.imgCnt = imgCnt;
	}

	/**
	 * @return allImgCnt
	 */
	public String getAllImgCnt() {
		return allImgCnt;
	}

	/**
	 * @param allImgCnt セットする allImgCnt
	 */
	public void setAllImgCnt(String allImgCnt) {
		this.allImgCnt = allImgCnt;
	}

	/**
	 * @return locX
	 */
	public String getLocX() {
		return locX;
	}

	/**
	 * @param locX セットする locX
	 */
	public void setLocX(String locX) {
		this.locX = locX;
	}

	/**
	 * @return locY
	 */
	public String getLocY() {
		return locY;
	}

	/**
	 * @param locY セットする locY
	 */
	public void setLocY(String locY) {
		this.locY = locY;
	}

	/**
	 * @return imgBaseDt
	 */
	public String getImgBaseDt() {
		return imgBaseDt;
	}

	/**
	 * @param imgBaseDt セットする imgBaseDt
	 */
	public void setImgBaseDt(String imgBaseDt) {
		this.imgBaseDt = imgBaseDt;
	}

	/**
	 * @return recSendStatus
	 */
	public String getRecSendStatus() {
		return recSendStatus;
	}

	/**
	 * @param recSendStatus セットする recSendStatus
	 */
	public void setRecSendStatus(String recSendStatus) {
		this.recSendStatus = recSendStatus;
	}

	/**
	 * @return ctFrontSendResultKbn
	 */
	public String getCtFrontSendResultKbn() {
		return ctFrontSendResultKbn;
	}

	/**
	 * @param ctFrontSendResultKbn セットする ctFrontSendResultKbn
	 */
	public void setCtFrontSendResultKbn(String ctFrontSendResultKbn) {
		this.ctFrontSendResultKbn = ctFrontSendResultKbn;
	}

	/**
	 * @return ablFrontSendResultKbn
	 */
	public String getAblFrontSendResultKbn() {
		return ablFrontSendResultKbn;
	}

	/**
	 * @param ablFrontSendResultKbn セットする ablFrontSendResultKbn
	 */
	public void setAblFrontSendResultKbn(String ablFrontSendResultKbn) {
		this.ablFrontSendResultKbn = ablFrontSendResultKbn;
	}

	public String getPkBukkenRireki() {
		return pkBukkenRireki;
	}

	public void setPkBukkenRireki(String pkBukkenRireki) {
		this.pkBukkenRireki = pkBukkenRireki;
	}

	public String getShopcd() {
		return shopcd;
	}

	public void setShopcd(String shopcd) {
		this.shopcd = shopcd;
	}

	public String getBkcd() {
		return bkcd;
	}

	public void setBkcd(String bkcd) {
		this.bkcd = bkcd;
	}

	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}

	public String getBrInsPg() {
		return brInsPg;
	}

	public void setBrInsPg(String brInsPg) {
		this.brInsPg = brInsPg;
	}

	public String getBskInsPg() {
		return bskInsPg;
	}

	public void setBskInsPg(String bskInsPg) {
		this.bskInsPg = bskInsPg;
	}

	public String getBrUpdPg() {
		return brUpdPg;
	}

	public void setBrUpdPg(String brUpdPg) {
		this.brUpdPg = brUpdPg;
	}

	public String getBskUpdPg() {
		return bskUpdPg;
	}

	public void setBskUpdPg(String bskUpdPg) {
		this.bskUpdPg = bskUpdPg;
	}

	public String getFormatTypeCd() {
		return formatTypeCd;
	}

	public void setFormatTypeCd(String formatTypeCd) {
		this.formatTypeCd = formatTypeCd;
	}

	public String getRendoCd() {
		return rendoCd;
	}

	public void setRendoCd(String rendoCd) {
		this.rendoCd = rendoCd;
	}

	public String getRendoName() {
		return rendoName;
	}

	public void setRendoName(String rendoName) {
		this.rendoName = rendoName;
	}
}