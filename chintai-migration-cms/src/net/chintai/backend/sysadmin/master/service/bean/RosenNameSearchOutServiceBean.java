/*
 * $Id: RosenSearchOutServiceBean.java 4062 2008-11-12 05:49:12Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.bean;

/**
 * 沿線・駅検索情報Bean
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 4062 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class RosenNameSearchOutServiceBean {

    /** 沿線コード */
    private String ensenCd;

    /** 沿線名称 */
    private String ensenName;

    /** 沿線かな */
    private String ensenKana;

    /** タイプ */
    private String ensenType;

    /** 沿線シーケンス番号（Webソートキー） */
    private String ensenSeq;

    /** エリアコード */
    private String areaCd;

    /** 会社名 */
    private String railwaycoName;

    /** エリア */
    private String areaName;

    /** 削除（沿線） */
    private String ensenDelFlg;

    /** 沿線配布停止区分 */
    private String ensenUseStopFlg;

    /** 沿線略称 */
    private String ensennameShort;

    /** 沿線略称かな */
    private String ensenkanaShort;

    /**
     * 沿線コードを取得します。
     * @return 沿線コード
     */
    public String getEnsenCd() {
        return ensenCd;
    }

    /**
     * 沿線コードを設定します。
     * @param ensenCd 沿線コード
     */
    public void setEnsenCd(String ensenCd) {
        this.ensenCd = ensenCd;
    }

    /**
     * 沿線名称を取得します。
     * @return 沿線名称
     */
    public String getEnsenName() {
        return ensenName;
    }

    /**
     * 沿線名称を設定します。
     * @param ensenName 沿線名称
     */
    public void setEnsenName(String ensenName) {
        this.ensenName = ensenName;
    }

    /**
     * 沿線かなを取得します。
     * @return 沿線かな
     */
    public String getEnsenKana() {
        return ensenKana;
    }

    /**
     * 沿線かなを設定します。
     * @param ensenKana 沿線かな
     */
    public void setEnsenKana(String ensenKana) {
        this.ensenKana = ensenKana;
    }

    /**
     * タイプを取得します。
     * @return タイプ
     */
    public String getEnsenType() {
        return ensenType;
    }

    /**
     * タイプを設定します。
     * @param ensenType タイプ
     */
    public void setEnsenType(String ensenType) {
        this.ensenType = ensenType;
    }

    /**
     * 沿線シーケンス番号（Webソートキー）を取得します。
     * @return タイプ
     */
    public String getEnsenSeq() {
        return ensenSeq;
    }

    /**
     * 沿線シーケンス番号（Webソートキー）を設定します。
     * @param ensenSeq タイプ
     */
    public void setEnsenSeq(String ensenSeq) {
        this.ensenSeq = ensenSeq;
    }

    /**
     * エリアコードを取得します。
     * @return エリアコード
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * エリアコードを設定します。
     * @param areaCd エリアコード
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    /**
     * エリアを取得します。
     * @return エリア
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * エリアを設定します。
     * @param areaName エリア
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 会社名を取得します。
     * @return 会社名
     */
    public String getRailwaycoName() {
        return railwaycoName;
    }

    /**
     * 会社名を設定します。
     * @param railwaycoName 会社名
     */
    public void setRailwaycoName(String railwaycoName) {
        this.railwaycoName = railwaycoName;
    }

    /**
     * 削除（沿線）を取得します。
     * @return 削除（沿線）
     */
    public String getEnsenDelFlg() {
        return ensenDelFlg;
    }

    /**
     * 削除（沿線）を設定します。
     * @param ensenDelFlg 削除（沿線）
     */
    public void setEnsenDelFlg(String ensenDelFlg) {
        this.ensenDelFlg = ensenDelFlg;
    }

    /**
     * 沿線配布停止区分を取得します。
     * @return 沿線配布停止区分
     */
    public String getEnsenUseStopFlg() {
        return ensenUseStopFlg;
    }

    /**
     * 沿線配布停止区分を設定します。
     * @param ensenUseStopFlg 沿線配布停止区分
     */
    public void setEnsenUseStopFlg(String ensenUseStopFlg) {
        this.ensenUseStopFlg = ensenUseStopFlg;
    }

	public String getEnsennameShort() {
		return ensennameShort;
	}

	public void setEnsennameShort(String ensennameShort) {
		this.ensennameShort = ensennameShort;
	}

	public String getEnsenkanaShort() {
		return ensenkanaShort;
	}

	public void setEnsenkanaShort(String ensenkanaShort) {
		this.ensenkanaShort = ensenkanaShort;
	}

}
