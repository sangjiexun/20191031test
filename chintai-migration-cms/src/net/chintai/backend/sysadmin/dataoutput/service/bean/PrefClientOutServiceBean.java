package net.chintai.backend.sysadmin.dataoutput.service.bean;

/**
 *
 * 都道府県表示Bean
 *
 * @author e-ishii
 * @version $Revision: 4585 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientOutServiceBean {

    /** 都道府県コード*/
    private String prefcd;
    
    /** 都道府県名*/
    private String prefname;

    /** 都道府県出力フラグ */
    private String prefOutFlg;

    /** 更新日*/
    private String updDt;

	/**
	 * prefCdを取得します。
	 * @return prefCd
	 */
	public String getPrefcd() {
	    return prefcd;
	}
	/**
	 * prefCdを設定します。
	 * @param prefCd prefCd
	 */
	public void setPrefcd(String prefcd) {
	    this.prefcd = prefcd;
	}
	/**
	 * prefnameを取得します。
	 * @return prefname
	 */
	public String getPrefname() {
	    return prefname;
	}
	/**
	 * prefnameを設定します。
	 * @param prefname prefname
	 */
	public void setPrefname(String prefname) {
	    this.prefname = prefname;
	}
	/**
	 * prefOutFlgを取得します。
	 * @return prefOutFlg
	 */
	public String getPrefOutFlg() {
	    return prefOutFlg;
	}
	/**
	 * prefOutFlgを設定します。
	 * @param prefOutFlg prefOutFlg
	 */
	public void setPrefOutFlg(String prefOutFlg) {
	    this.prefOutFlg = prefOutFlg;
	}
	/**
	 * updDtを取得します。
	 * @return updDt
	 */
	public String getUpdDt() {
	    return updDt;
	}
	/**
	 * updDtを設定します。
	 * @param updDt updDt
	 */
	public void setUpdDt(String updDt) {
	    this.updDt = updDt;
	}


}
