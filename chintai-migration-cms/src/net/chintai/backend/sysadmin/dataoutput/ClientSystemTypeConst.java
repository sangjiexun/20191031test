package net.chintai.backend.sysadmin.dataoutput;

import java.util.ArrayList;
import java.util.List;



/**
 * クライアントシステム情報の定義クラス
 *
 * @author e-ishii
 * @version $Revision: 4581 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class ClientSystemTypeConst {

    /**
     * コンストラクタ
     */
    private ClientSystemTypeConst(){}

    /** CRS */
    public static final String CRS = "1";

    /** ANS */
    public static final String ANS = "2";

    /** 直営店 */
    public static final String ABLE = "3";

    /** 手書き */
    public static final String MAGAZINE = "4";

    /** キャンパスライフ */
    //public static final String CAMPUS = "5";

    /** CRS＋ */
    //public static final String CRS_PLUS = "6";

    /** クライアントシステムタイプが格納 */
    public static final List<String> constList = new ArrayList<String>();

    static {
        constList.add(ClientSystemTypeConst.CRS);
        constList.add(ClientSystemTypeConst.ANS);
        constList.add(ClientSystemTypeConst.ABLE);
        constList.add(ClientSystemTypeConst.MAGAZINE);
        //constList.add(ClientSystemTypeConst.CAMPUS);
        //constList.add(ClientSystemTypeConst.CRS_PLUS);
    }

}