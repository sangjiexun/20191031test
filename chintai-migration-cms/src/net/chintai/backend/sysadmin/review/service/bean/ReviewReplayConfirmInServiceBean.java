/*
 * $Id: ReviewReplayConfirmInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.bean;

/**
 * 返信入力確認画面に表示する物件情報検索条件
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewReplayConfirmInServiceBean {
	private String roomKey;

    /** 店舗コード */
    private String shopCd;

    /** 物件コード */
    private String bkCd;

    /** 部屋番号 */
    private String roomNo;

    /** Web審査警告履歴連番 */
    private String warningRirekiSeq;

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
     * 部屋番号を取得します。
     * @return 部屋番号
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * 部屋番号を設定します。
     * @param roomNo 部屋番号
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * Web審査警告履歴連番を取得します。
     * @return Web審査警告履歴連番
     */
    public String getWarningRirekiSeq() {
        return warningRirekiSeq;
    }

    /**
     * Web審査警告履歴連番を設定します。
     * @param warningRirekiSeq Web審査警告履歴連番
     */
    public void setWarningRirekiSeq(String warningRirekiSeq) {
        this.warningRirekiSeq = warningRirekiSeq;
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
