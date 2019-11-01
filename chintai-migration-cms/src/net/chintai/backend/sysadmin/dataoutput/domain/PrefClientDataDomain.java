package net.chintai.backend.sysadmin.dataoutput.domain;

/**
 * 都道府県別出力設定Domain
 *
 * @author e-ishii
 * @version $Revision: 4585 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientDataDomain {

    /** 都道府県コード*/
    private String prefcd;

    /** 都道府県名*/
    private String prefname;

    /** クライアントシステムタイプ */
    private String clientsystemType;

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
     * クライアントシステムタイプを取得します。
     * @return クライアントシステムタイプ
     */
    public String getClientsystemType() {
        return clientsystemType;
    }
    /**
     * クライアントシステムタイプを設定します。
     * @param clientsystemType クライアントシステムタイプ
     */
    public void setClientsystemType(String clientsystemType) {
        this.clientsystemType = clientsystemType;
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
