/*
 * $Id: BukkenRirekiInfoOutServiceBean.java 4535 2011-11-04 05:46:53Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/05/27  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 入稿履歴検索結果
 *
 * @author Lee Hosup
 * @version $Revision: 4535 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenRirekiInfoOutServiceBean {

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

    private String brInsPg;
    private String bskInsPg;
    private String brUpdPg;
    private String bskUpdPg;
    private String formatTypeCd;
    private String rendoCd;
    private String rendoName;

    /**
     * 部屋止めフラグを取得します。
     * @return 部屋止めフラグ
     */
    public String getHeyadomeKbn() {
        return heyadomeKbn;
    }

    /**
     * 部屋止めフラグを設定します。
     * @param heyadomeKbn 部屋止めフラグ
     */
    public void setHeyadomeKbn(String heyadomeKbn) {
        this.heyadomeKbn = heyadomeKbn;
    }

    /**
     * 部屋状況を取得します。
     * @return 部屋状況
     */
    public String getHeyaJokyo() {
        return heyaJokyo;
    }

    /**
     * 部屋状況を設定します。
     * @param heyaJokyo 部屋状況
     */
    public void setHeyaJokyo(String heyaJokyo) {
        this.heyaJokyo = heyaJokyo;
    }

    /**
     * 入稿登録日時を取得します。
     * @return 入稿登録日時
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * 入稿登録日時を設定します。
     * @param insDt 入稿登録日時
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
    }

    /**
     * 入稿状況を取得します。
     * @return 入稿状況
     */
    public String getInsKbn() {
        return insKbn;
    }

    /**
     * 入稿状況を設定します。
     * @param insKbn 入稿状況
     */
    public void setInsKbn(String insKbn) {
        this.insKbn = insKbn;
    }

    /**
     * 座標情報(番地レベルのX座標)を取得します。
     * @return 座標情報(番地レベルのX座標)
     */
    public String getLocBX() {
        return locBX;
    }

    /**
     * 座標情報(番地レベルのX座標)を設定します。
     * @param locBX 座標情報(番地レベルのX座標)
     */
    public void setLocBX(String locBX) {
        this.locBX = locBX;
    }

    /**
     * 座標情報(番地レベルのY座標)を取得します。
     * @return 座標情報(番地レベルのY座標)
     */
    public String getLocBY() {
        return locBY;
    }

    /**
     * 座標情報(番地レベルのY座標)を設定します。
     * @param locBY 座標情報(番地レベルのY座標)
     */
    public void setLocBY(String locBY) {
        this.locBY = locBY;
    }

    /**
     * 座標情報(号レベルのX座標)を取得します。
     * @return 座標情報(号レベルのX座標)
     */
    public String getLocMX() {
        return locMX;
    }

    /**
     * 座標情報(号レベルのX座標)を設定します。
     * @param locMX 座標情報(号レベルのX座標)
     */
    public void setLocMX(String locMX) {
        this.locMX = locMX;
    }

    /**
     * 座標情報(号レベルのY座標)を取得します。
     * @return 座標情報(号レベルのY座標)
     */
    public String getLocMY() {
        return locMY;
    }

    /**
     * 座標情報(号レベルのY座標)を設定します。
     * @param locMY 座標情報(号レベルのY座標)
     */
    public void setLocMY(String locMY) {
        this.locMY = locMY;
    }

    /**
     * 座標情報(町丁レベルのX座標)を取得します。
     * @return 座標情報(町丁レベルのX座標)
     */
    public String getLocTX() {
        return locTX;
    }

    /**
     * 座標情報(町丁レベルのX座標)を設定します。
     * @param locTX 座標情報(町丁レベルのX座標)
     */
    public void setLocTX(String locTX) {
        this.locTX = locTX;
    }

    /**
     * 座標情報(町丁レベルのY座標)を取得します。
     * @return 座標情報(町丁レベルのY座標)
     */
    public String getLocTY() {
        return locTY;
    }

    /**
     * 座標情報(町丁レベルのY座標)を設定します。
     * @param locTY 座標情報(町丁レベルのY座標)
     */
    public void setLocTY(String locTY) {
        this.locTY = locTY;
    }

    /**
     * 取引を取得します。
     * @return 取引
     */
    public String getTorihiki() {
        return torihiki;
    }

    /**
     * 取引を設定します。
     * @param torihiki 取引
     */
    public void setTorihiki(String torihiki) {
        this.torihiki = torihiki;
    }

    /**
     * 取引形態を取得します。
     * @return 取引形態
     */
    public String getTorihikiKeitai() {
        return torihikiKeitai;
    }

    /**
     * 取引形態を設定します。
     * @param torihikiKeitai 取引形態
     */
    public void setTorihikiKeitai(String torihikiKeitai) {
        this.torihikiKeitai = torihikiKeitai;
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
