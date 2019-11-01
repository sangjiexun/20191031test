/*
 * $Id: AuthorityId.java 4583 2013-08-01 04:54:01Z k-taneichi $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/20     BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.common;

/**
 * 権限IDの取扱いを簡易にするための Enum です。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 4583 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public enum AuthorityId {

    /**
     * 権限IDのエイリアス定義
     */
    SHOP_BUKKEN("01"),
    CONTENTS("02"),
    COUNT("03"),
    CRS("04"),
    REVIEW("05"),
    SHOP_INQUIRY("06"),
    CJN_INQUIRY("07"),
    MASTER("08"),
    USER("09"),
    OTHERS("10"),
    DEMAND("11"),
    AD("12"),
    WEBLOG_CT("13"),
    WEBLOG_ADMIN("15"), // 14 は欠番
    SHOP_LISTING("16"),      //2009.02.06 李ホソップ追加
    ADDATA_MATCHING("17"),   //2009.08.21 e-ishii追加
    LOGREPORT_DOWNLOAD("18"),  //2011.08.29 e-ishii追加
    DATA_OUTPUT("19"); //2013.06.25 e-ishii追加

    /** 権限ID */
    private final String id;

    /**
     * コンストラクタ
     * @param id
     */
    private AuthorityId(String id) {
        this.id = id;
    }

    /**
     * 権限IDを戻します。
     * @see java.lang.Enum#toString()
     */
    public String toString() {
        return id;
    }
}