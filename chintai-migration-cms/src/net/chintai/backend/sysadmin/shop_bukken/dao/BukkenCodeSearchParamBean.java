/*
 * $Id: BukkenCodeSearchParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 物件検索（物件コード）ParamBean
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenCodeSearchParamBean {

    /** 店舗コード */
    private String shopCd;

    /** 物件コード */
    private String bkCd;

    /** 部屋連番 */
    private String roomNo;

    /** 号室 */
    private String roomCd;

    /** 受付番号 */
    private String uketukeCd;

    /** 物件管理コード */
    private String bkKanri;

    /** 物件名 */
    private String bkName;

    /** 店舗コード（物件管理コード） */
    private String bkKanriShopcd;

    /** 物件コード（物件管理コード） */
    private String bkKanriBkcd;

    /** 部屋連番（物件管理コード） */
    private String bkKanriRoomno;

    private String searchType;

    private String shopCdorUketukeCd;

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd 店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 物件コードを取得します。
     * @return 物件コード
     */
    public String getBkCd() {
        return bkCd;
    }

    /**
     * 物件コードを設定します。
     * @param bkCd 物件コード
     */
    public void setBkCd(String bkCd) {
        this.bkCd = bkCd;
    }

    /**
     * 部屋連番を取得します。
     * @return 部屋連番
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * 部屋連番を設定します。
     * @param roomNo 部屋連番
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

	/**
	 * @return roomCd
	 */
	public String getRoomCd() {
		return roomCd;
	}

	/**
	 * @param roomCd セットする roomCd
	 */
	public void setRoomCd(String roomCd) {
		this.roomCd = roomCd;
	}

	/**
	 * @return uketukeCd
	 */
	public String getUketukeCd() {
		return uketukeCd;
	}

	/**
	 * @param uketukeCd セットする uketukeCd
	 */
	public void setUketukeCd(String uketukeCd) {
		this.uketukeCd = uketukeCd;
	}

	/**
	 * @return bkKanri
	 */
	public String getBkKanri() {
		return bkKanri;
	}

	/**
	 * @param bkKanri セットする bkKanri
	 */
	public void setBkKanri(String bkKanri) {
		this.bkKanri = bkKanri;
	}

	/**
	 * @return bkName
	 */
	public String getBkName() {
		return bkName;
	}

	/**
	 * @param bkName セットする bkName
	 */
	public void setBkName(String bkName) {
		this.bkName = bkName;
	}

	/**
	 * @return bkKanriShopcd
	 */
	public String getBkKanriShopcd() {
		return bkKanriShopcd;
	}

	/**
	 * @param bkKanriShopcd セットする bkKanriShopcd
	 */
	public void setBkKanriShopcd(String bkKanriShopcd) {
		this.bkKanriShopcd = bkKanriShopcd;
	}

	/**
	 * @return bkKanriBkcd
	 */
	public String getBkKanriBkcd() {
		return bkKanriBkcd;
	}

	/**
	 * @param bkKanriBkcd セットする bkKanriBkcd
	 */
	public void setBkKanriBkcd(String bkKanriBkcd) {
		this.bkKanriBkcd = bkKanriBkcd;
	}

	/**
	 * @return bkKanriRoomno
	 */
	public String getBkKanriRoomno() {
		return bkKanriRoomno;
	}

	/**
	 * @param bkKanriRoomno セットする bkKanriRoomno
	 */
	public void setBkKanriRoomno(String bkKanriRoomno) {
		this.bkKanriRoomno = bkKanriRoomno;
	}

	/**
	 * @return searchType
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * @param searchType セットする searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getShopCdorUketukeCd() {
		return shopCdorUketukeCd;
	}

	public void setShopCdorUketukeCd(String shopCdorUketukeCd) {
		this.shopCdorUketukeCd = shopCdorUketukeCd;
	}
}