/*
 * $Id: BukkenListOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 物件コード検索OutServiceBean
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenListOutServiceBean {
	/** 部屋キー */
	private String roomKey;

    /** 受付番号 */
    private String uketukeCd;

    /** 店舗コード */
    private String shopCd;

    /** 物件コード */
    private String bkCd;

    /** 部屋連番 */
    private String roomNo;

    /** 物件名称 */
    private String bkName;

    /** 物件名称(カタカナ) */
    private String bkKana;

    /** 会社名 */
    private String company;

    /** 事務署名 */
    private String bumon;

    /** 店舗メールアドレス */
    private String email1;

    /** 店舗メールアドレス */
    private String email2;

    /** 店舗メールアドレス */
    private String email3;

    /** 店舗メールアドレス */
    private String email4;

    /** 店舗メールアドレス */
    private String email5;

    /** Ｅ－ＭＡＩＬアドレス用途区分1 */
    private String emailUseKbn1;

    /** Ｅ－ＭＡＩＬアドレス用途区分2 */
    private String emailUseKbn2;

    /** Ｅ－ＭＡＩＬアドレス用途区分3 */
    private String emailUseKbn3;

    /** Ｅ－ＭＡＩＬアドレス用途区分4 */
    private String emailUseKbn4;

    /** Ｅ－ＭＡＩＬアドレス用途区分5 */
    private String emailUseKbn5;

    /** 管理最終更新日時 */
    private String bukkenAdminUpdDt;

    /** 入稿状態 */
    private String insKbn;

    /** 入稿登録日時 */
    private String insDt;

    /** フロント反映状態 */
    private String frontFlg;

    /** フロント反映目安日時 */
    private String frontRefDt;

    /** ＣＨＩＮＴＡＩ掲載停止日時 */
    private String ctStopDt;

    /** エイブル掲載停止日時 */
    private String ablStopDt;

    /** 受配信ステータス */
    private String recSendStatus;

    /** レコード更新日時 */
    private String updDt;

    /**
     * 受付番号を取得します。
     * @return 受付番号
     */
    public String getUketukeCd() {
        return uketukeCd;
    }

    /**
     * 受付番号を設定します。
     * @param uketukeCd 受付番号
     */
    public void setUketukeCd(String uketukeCd) {
        this.uketukeCd = uketukeCd;
    }

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
     * 物件名称を取得します。
     * @return 物件名称
     */
    public String getBkName() {
        return bkName;
    }

    /**
     * 物件名称を設定します。
     * @param bkName 物件名称
     */
    public void setBkName(String bkName) {
        this.bkName = bkName;
    }

    /**
     * 物件名称(カタカナ)を取得します。
     * @return 物件名称(カタカナ)
     */
    public String getBkKana() {
        return bkKana;
    }

    /**
     * 物件名称(カタカナ)を設定します。
     * @param bkKana 物件名称(カタカナ)
     */
    public void setBkKana(String bkKana) {
        this.bkKana = bkKana;
    }

    /**
     * 会社名を取得します。
     * @return 会社名
     */
    public String getCompany() {
        return company;
    }

    /**
     * 会社名を設定します。
     * @param company 会社名
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 事務署名を取得します。
     * @return 事務署名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 事務署名を設定します。
     * @param bumon 事務署名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * 管理最終更新日時を取得します。
     * @return 管理最終更新日時
     */
    public String getBukkenAdminUpdDt() {
        return bukkenAdminUpdDt;
    }

    /**
     * 管理最終更新日時を設定します。
     * @param bukkenAdminUpdDt 管理最終更新日時
     */
    public void setBukkenAdminUpdDt(String bukkenAdminUpdDt) {
        this.bukkenAdminUpdDt = bukkenAdminUpdDt;
    }

    /**
     * 入稿状態を取得します。
     * @return 入稿状態
     */
    public String getInsKbn() {
        return insKbn;
    }

    /**
     * 入稿状態を設定します。
     * @param insKbn 入稿状態
     */
    public void setInsKbn(String insKbn) {
        this.insKbn = insKbn;
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
     * フロント反映状態を取得します。
     * @return フロント反映状態
     */
    public String getFrontFlg() {
        return frontFlg;
    }

    /**
     * フロント反映状態を設定します。
     * @param frontFlg フロント反映状態
     */
    public void setFrontFlg(String frontFlg) {
        this.frontFlg = frontFlg;
    }

    /**
     * フロント反映目安日時を取得します。
     * @return フロント反映目安日時
     */
    public String getFrontRefDt() {
        return frontRefDt;
    }

    /**
     * フロント反映目安日時を設定します。
     * @param frontRefDt フロント反映目安日時
     */
    public void setFrontRefDt(String frontRefDt) {
        this.frontRefDt = frontRefDt;
    }

	/**
	 * @return ctStopDt
	 */
	public String getCtStopDt() {
		return ctStopDt;
	}

	/**
	 * @param ctStopDt セットする ctStopDt
	 */
	public void setCtStopDt(String ctStopDt) {
		this.ctStopDt = ctStopDt;
	}

	/**
	 * @return ablStopDt
	 */
	public String getAblStopDt() {
		return ablStopDt;
	}

	/**
	 * @param ablStopDt セットする ablStopDt
	 */
	public void setAblStopDt(String ablStopDt) {
		this.ablStopDt = ablStopDt;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return updDt;
	}

	/**
	 * @param updDt セットする updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * @return email1
	 */
	public String getEmail1() {
		return email1;
	}

	/**
	 * @param email1 セットする email1
	 */
	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	/**
	 * @return email2
	 */
	public String getEmail2() {
		return email2;
	}

	/**
	 * @param email2 セットする email2
	 */
	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	/**
	 * @return email3
	 */
	public String getEmail3() {
		return email3;
	}

	/**
	 * @param email3 セットする email3
	 */
	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	/**
	 * @return email4
	 */
	public String getEmail4() {
		return email4;
	}

	/**
	 * @param email4 セットする email4
	 */
	public void setEmail4(String email4) {
		this.email4 = email4;
	}

	/**
	 * @return email5
	 */
	public String getEmail5() {
		return email5;
	}

	/**
	 * @param email5 セットする email5
	 */
	public void setEmail5(String email5) {
		this.email5 = email5;
	}

	/**
	 * @return emailUseKbn1
	 */
	public String getEmailUseKbn1() {
		return emailUseKbn1;
	}

	/**
	 * @param emailUseKbn1 セットする emailUseKbn1
	 */
	public void setEmailUseKbn1(String emailUseKbn1) {
		this.emailUseKbn1 = emailUseKbn1;
	}

	/**
	 * @return emailUseKbn2
	 */
	public String getEmailUseKbn2() {
		return emailUseKbn2;
	}

	/**
	 * @param emailUseKbn2 セットする emailUseKbn2
	 */
	public void setEmailUseKbn2(String emailUseKbn2) {
		this.emailUseKbn2 = emailUseKbn2;
	}

	/**
	 * @return emailUseKbn3
	 */
	public String getEmailUseKbn3() {
		return emailUseKbn3;
	}

	/**
	 * @param emailUseKbn3 セットする emailUseKbn3
	 */
	public void setEmailUseKbn3(String emailUseKbn3) {
		this.emailUseKbn3 = emailUseKbn3;
	}

	/**
	 * @return emailUseKbn4
	 */
	public String getEmailUseKbn4() {
		return emailUseKbn4;
	}

	/**
	 * @param emailUseKbn4 セットする emailUseKbn4
	 */
	public void setEmailUseKbn4(String emailUseKbn4) {
		this.emailUseKbn4 = emailUseKbn4;
	}

	/**
	 * @return emailUseKbn5
	 */
	public String getEmailUseKbn5() {
		return emailUseKbn5;
	}

	/**
	 * @param emailUseKbn5 セットする emailUseKbn5
	 */
	public void setEmailUseKbn5(String emailUseKbn5) {
		this.emailUseKbn5 = emailUseKbn5;
	}

	/**
	 * @return roomKey
	 */
	public String getRoomKey() {
		return roomKey;
	}

	/**
	 * @param roomKey セットする roomKey
	 */
	public void setRoomKey(String roomKey) {
		this.roomKey = roomKey;
	}

}