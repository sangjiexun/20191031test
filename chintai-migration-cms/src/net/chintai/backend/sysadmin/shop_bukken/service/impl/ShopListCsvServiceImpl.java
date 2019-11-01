/*
 * $Id: ShopListCsvServiceImpl.java 3858 2008-03-10 05:48:53Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2008/02/27   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.CodeConvertService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListCsvService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchOutServiceBean;

/**
 * ShopListCsvService の実装クラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3858 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListCsvServiceImpl implements ShopListCsvService, InitializingBean {

    // コードマップ(キャッシュ)
    private Map<String, String> ensenTypeMap;
    private Map<String, String> shopStatusMap;
    private Map<String, String> ctFlgMap;
    private Map<String, String> ablFlgMap;
    private Map<String, String> clientSystemTypeMap;
    private Map<String, String> fmKbnMap;
    private Map<String, String> certifyFlgMap;
    private Map<String, String> shopSiteRoleMap;
    private Map<String, String> pickUpCntMap;
    private Map<String, String> aspCntMap;
    private Map<String, String> adparkSendFlgMap;
    private Map<String, String> webLogFlgMap;
    private Map<String, String> imgKbnMap;

    // コンバータ
    private CodeConvertService convertService;

    public void setCodeConvertService(CodeConvertService service) {
        convertService = service;
    }

    /*
     * (非 Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception {
        initMap();
    }

    /**
     * コードマップを初期化します。
     */
    private void initMap() {
        ensenTypeMap = convertService.getCodeMap("SHOPBUKKEN_ENSENTYPE_VALUE", "SHOPBUKKEN_ENSENTYPE_NAME");
        shopStatusMap = convertService.getCodeMap("SHOPBUKKEN_SHOP_STATUS_VALUE", "SHOPBUKKEN_SHOP_STATUS_NAME");
        ctFlgMap = convertService.getCodeMap("SHOPBUKKEN_CT_FLG_VALUE", "SHOPBUKKEN_CT_FLG_NAME");
        ablFlgMap = convertService.getCodeMap("SHOPBUKKEN_ABL_FLG_VALUE", "SHOPBUKKEN_ABL_FLG_NAME");
        clientSystemTypeMap = convertService.getCodeMap("CLIENTSYSTEM_VALUE", "CLIENTSYSTEM_NAME");
        fmKbnMap = convertService.getCodeMap("SHOPBUKKEN_FM_KBN_VALUE", "SHOPBUKKEN_FM_KBN_NAME");
        certifyFlgMap = convertService.getCodeMap("SHOPBUKKEN_CERTIFY_FLG_VALUE", "SHOPBUKKEN_CERTIFY_FLG_NAME");
        shopSiteRoleMap = convertService.getCodeMap("SHOP_SITE_ROLE_VALUE", "SHOP_SITE_ROLE_NAME");
        pickUpCntMap = convertService.getCodeMap("SHOPBUKKEN_PICKUP_STATUS_FLG_VALUE", "SHOPBUKKEN_PICKUP_STATUS_FLG_NAME");
        aspCntMap = convertService.getCodeMap("SHOPBUKKEN_ASP_FLG_VALUE", "SHOPBUKKEN_ASP_FLG_NAME");
        adparkSendFlgMap = convertService.getCodeMap("SHOPBUKKEN_ADPARK_SEND_FLG_VALUE", "SHOPBUKKEN_ADPARK_SEND_FLG_NAME");
        webLogFlgMap = convertService.getCodeMap("WEB_LOG_FLG_VALUE", "WEB_LOG_FLG_NAME");
        imgKbnMap = convertService.getCodeMap("SHOPBUKKEN_IMG_KBN_VALUE", "SHOPBUKKEN_IMG_KBN_NAME");
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopListCsvService#createShopListCsv()
     */
    public List<String[]> createShopListCsv(List<ShopSearchOutServiceBean> rsShopList) {
        List<String[]> csvList = new ArrayList<String[]>();
//
//        // Header設定
//        csvList.add(SystemProperties.getProperties("ShopSearch.Header"));
//
//        // CSVフォーマットに変換
//        for (ShopSearchOutServiceBean tmp : rsShopList) {
//            csvList.add(new String[] {
//                    tmp.getShopCd(),
//                    tmp.getPassword(),
//                    事業者区分
//                    連動元
//
//                    tmp.getCompany(),
//                    tmp.getBumon(),
//                    tmp.getDantai(),
//                    tmp.getLicTrust(),
//                    tmp.getGroupName(),
//                    tmp.getZip(),
//                    tmp.getAddress1(),
//                    tmp.getAddress2(), //10(J列)
//                    tmp.getTel(),
//                    フリーコール番号
//                    店舗反響用電話番号
//                    店舗フリーコール電話番号
//
//                    tmp.getFax(),
//                    tmp.getAreaCd(),
//                    tmp.getAreaName(),
//                    tmp.getPrefCd(),
//                    tmp.getPrefName(),
//                    tmp.getCityCd(),
//                    tmp.getCityName(),
//                    沿線駅
//
////                    tmp.getEnsenType(),
////                    ensenTypeConvert(tmp.getEnsenType()), //20(T列)
////                    tmp.getEnsenCd(),
////                    tmp.getEnsenName(),
////                    tmp.getEkiCd(),
////                    tmp.getEkiName(),
//                    tmp.getLicNum(),
//                    tmp.getLicEntry(),
//                    tmp.getLicValid(),
//                    tmp.getLicChief(),
//                    tmp.getTantou(),
//                    ＨＰ名称１
//                    ＨＰ名称２
//                    ＨＰ名称３
//                    ＨＰ名称４
//                    ＨＰ名称５
//                    ＨＰＵＲＬ１
//                    ＨＰＵＲＬ２
//                    ＨＰＵＲＬ３
//                    ＨＰＵＲＬ４
//                    ＨＰＵＲＬ５
//                    Ｅ－Ｍａｉｌアドレス１
//                    Ｅ－Ｍａｉｌアドレス２
//                    Ｅ－Ｍａｉｌアドレス３
//                    Ｅ－Ｍａｉｌアドレス４
//                    Ｅ－Ｍａｉｌアドレス５
//                    Ｅ－Ｍａｉｌアドレス用途区分１
//                    Ｅ－Ｍａｉｌアドレス用途区分２
//                    Ｅ－Ｍａｉｌアドレス用途区分３
//                    Ｅ－Ｍａｉｌアドレス用途区分４
//                    Ｅ－Ｍａｉｌアドレス用途区分５
//
////                    tmp.getHpName(), //30(AD列)
////                    tmp.getHpUrl(),
////                    tmp.getEmail(),
//                    fmKbnConvert(tmp.getFmKbn()),
//                    営業時間
//                    定休日
//                    混雑時間帯コメント
//
////                    tmp.getLastLoginDt(),
//                    tmp.getShopUpdDt(),
//                    certifyFlgConvert(tmp.getCertifyFlg()),
//                    shopStatusConvert(tmp.getShopStatus()),
//                    ctFlgConvert(tmp.getCtFlg()),
//                    ablFlgConvert(tmp.getAblFlg()),
//                    clientSystemTypeConvert(tmp.getClientsystemType()), //40(AN列)
//                    shopSiteRoleConvert(tmp.getShopSiteRole()),
//                    tmp.getBumonKana(),
//                    tmp.getAdminNote(),
//                    tmp.getAdminUpdDt(),
//                    pickUpCntConvert(tmp.getPickUpCnt()),
//                    aspCntConvert(tmp.getAspCnt()),
//                    adparkSendFlgConvert(tmp.getAdparkSendFlg()),
//                    weblogFlgConvert(tmp.getWebLogFlg()),
//                    tmp.getChintaiBukkenCount(),
//                    tmp.getAbleBukkenCount(), //50(AX列)
//                    imgKbnConvert(tmp.getShopMapPctFlg()),
//                    imgKbnConvert(tmp.getShopPhoto1Flg()),
//                    imgKbnConvert(tmp.getShopPhoto2Flg())
//            });
//        }
        return csvList;
    }

    /*----- Converter -----*/

    private String ensenTypeConvert(String key) {
        return ensenTypeMap.get(key);
    }

    private String shopStatusConvert(String key) {
        return shopStatusMap.get(key);
    }

    private String ctFlgConvert(String key) {
        return ctFlgMap.get(key);
    }

    private String ablFlgConvert(String key) {
        return ablFlgMap.get(key);
    }

    private String clientSystemTypeConvert(String key) {
        return clientSystemTypeMap.get(key);
    }

    private String fmKbnConvert(String key) {
        return fmKbnMap.get(key);
    }

    private String certifyFlgConvert(String key) {
        return certifyFlgMap.get(key);
    }

    private String shopSiteRoleConvert(String key) {
        return shopSiteRoleMap.get(key);
    }

    private String pickUpCntConvert(String key) {
        return pickUpCntMap.get(key);
    }

    private String aspCntConvert(String key) {
        return aspCntMap.get(key);
    }

    private String adparkSendFlgConvert(String key) {
        return adparkSendFlgMap.get(key);
    }

    private String weblogFlgConvert(String key) {
        return webLogFlgMap.get(key);
    }

    private String imgKbnConvert(String key) {
        return imgKbnMap.get(key);
    }
}
