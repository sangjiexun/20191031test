package net.chintai.backend.sysadmin.shop_inquiry.service.rowhandler;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.rowhandler.StringArrayConverter;
import net.chintai.backend.sysadmin.shop_inquiry.domain.InquiryRecent;


/**
 * 問合せＣＳＶコンバーター
 *
 * @author e-ishii
 * @version $Revision: 4467 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryRecentConverter implements StringArrayConverter {

    private Map<String,String> inqFlgMap;

    private Map<String, String> sysFlgMap;

    private Map<String, String> carrierTypeMap;

    /**
     * コンストラクター
     */
    public InquiryRecentConverter() {

        inqFlgMap = new HashMap<String, String>();
        sysFlgMap = new HashMap<String, String>();
        carrierTypeMap = new HashMap<String, String>();

        setMap(inqFlgMap, "FLG_INQ_VALUE", "FLG_INQ_NAME");
        setMap(sysFlgMap, "SYS_FLG_VALUE","SYS_FLG_NAME");
        setMap(carrierTypeMap, "CARRIER_TYPE_VALUE","CARRIER_TYPE_NAME");

    }

    /**
     * SystemPropertiesからとってきた値をマップにセットする
     * @param map
     * @param code
     * @param value
     */
    public void setMap(Map<String, String> map, String code, String value) {

        String[] codes = SystemProperties.getProperties(code);
        String[] values = SystemProperties.getProperties(value);

        for (int i = 0; i < codes.length; i++) {
            map.put(codes[i], values[i]);
        }
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.rowhandler.StringArrayConverter#toStringArray(java.lang.Object)
     */
    public String[] toStringArray(Object obj) {

        InquiryRecent inquiryRecent = (InquiryRecent)obj;

        return new String[] {
            inquiryRecent.getShopCd(),
            getCompanyAndBumon(inquiryRecent),
            inquiryRecent.getInqId(),
            inquiryRecent.getInqFlgName(),
            inquiryRecent.getSysFlgName(),
            inquiryRecent.getSiteTypeName(),
            //StringUtils.isNotEmpty(inquiryRecent.getCarrierType())? inquiryRecent.getCarrierTypeName(): "",
            (StringUtils.isNotEmpty(inquiryRecent.getUpInquiry())?inquiryRecent.getUpInquiry().replaceAll("\r\n|\n|\r", ""):""),
            inquiryRecent.getInsDt(),
            //inquiryRecent.getSchoolId(),
            //inquiryRecent.getSchoolName(),
            (StringUtils.isNotEmpty(inquiryRecent.getBkInfo())?inquiryRecent.getBkInfo().replaceAll("\r\n|\n|\r", ""):"")
         };
    }

    /**
     * nullの場合、空を返す
     *
     * @param str
     * @return
     */
    private String changeNullToEmpty(String str) {

        if(StringUtils.isEmpty(str)) {
            return "";
        } else {
            return str;
        }
    }

    /**
     * 会社名と部門を連結する。
     * @param inquiryRecent
     * @return
     */
    private String getCompanyAndBumon(InquiryRecent inquiryRecent) {

        StringBuilder companyAndBumon = new StringBuilder();
        companyAndBumon.append(inquiryRecent.getCompany());
        if(StringUtils.isNotEmpty(inquiryRecent.getBumon())) {
            companyAndBumon.append(" ");
            companyAndBumon.append(inquiryRecent.getBumon());
        }

        return companyAndBumon.toString();
    }

    /**
     * キーをもとに、mapから値を取得する。
     * @param map
     * @param key
     * @return
     */
    private String codeToValueConvert(Map<String, String> map, String key) {
        return map.get(key);
    }

    /**
     * キャリアタイプの場合のmapからの値取得
     * @param sysFlg
     * @param carrierType
     * @return
     */
    private String carrierTypeConvert(String sysFlg, String carrierType) {

        if(StringUtils.equals(sysFlg, "2")) {
            return codeToValueConvert(carrierTypeMap,carrierType);
        }
        return "";
    }

}
