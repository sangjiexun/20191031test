package net.chintai.backend.sysadmin.dataoutput.service.bean;

/**
 * データ元別出力設定表示Bean
 *
 * @author e-ishii
 * @version $Revision: 4585 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientDataOutServiceBean {

    /** ユーザ利用システム種類 */
    private String clientsystemType;

    /** 都道府県名*/
    private String prefcd;



    /**
     * ユーザ利用システム種類を取得します。
     * @return ユーザ利用システム種類
     */
    public String getClientsystemType() {
        return clientsystemType;
    }

    /**
     * ユーザ利用システム種類を設定します。
     * @param clientsystemType ユーザ利用システム種類
     */
    public void setClientsystemType(String clientsystemType) {
        this.clientsystemType = clientsystemType;
    }

    /**
     * 都道府県名を取得します。
     * @return 都道府県名
     */
    public String getPrefcd() {
        return prefcd;
    }

    /**
     * 都道府県名を設定します。
     * @param prefcd 都道府県名
     */
    public void setPrefcd(String prefcd) {
        this.prefcd = prefcd;
    }





}
