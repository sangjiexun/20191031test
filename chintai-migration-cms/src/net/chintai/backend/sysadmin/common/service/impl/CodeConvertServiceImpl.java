/*
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 * $Id: CodeConvertServiceImpl.java 3841 2008-02-27 07:01:05Z t-kojima $
 */
package net.chintai.backend.sysadmin.common.service.impl;

import java.util.HashMap;
import java.util.Map;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.CodeConvertService;

import org.apache.commons.lang.ArrayUtils;

/**
 * {@link CodeConvertService} の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3841 $
 */
public class CodeConvertServiceImpl implements CodeConvertService {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.service.CodeConvertService#getCode(java.lang.String,
     *      java.lang.String, java.lang.String)
     */
    public String getCode(String codeKey, String valueKey, String value) {
        String[] codes = SystemProperties.getProperties(codeKey);
        String[] values = SystemProperties.getProperties(valueKey);

        int idx = ArrayUtils.indexOf(values, value);
        return (codes.length > idx) ? codes[idx] : "";
    }

    /*
     * 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.service.CodeConvertService#getCodeMap(java.lang.String,
     *      java.lang.String)
     */
    public Map<String, String> getCodeMap(String codeKey, String valueKey) {
        String[] codes = SystemProperties.getProperties(codeKey);
        String[] values = SystemProperties.getProperties(valueKey);

        Map<String, String> codeMap = new HashMap<String, String>();
        int minIdx = (codes.length <= values.length) ? codes.length : values.length; // 小さい方を採用

        for (int i = 0; i < minIdx; i++) {
            codeMap.put(codes[i], values[i]);
        }
        return codeMap;
    }

    /*
     * 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.service.CodeConvertService#getValue(java.lang.String,
     *      java.lang.String, java.lang.String)
     */
    public String getValue(String codeKey, String valueKey, String code) {
        String[] codes = SystemProperties.getProperties(codeKey);
        String[] values = SystemProperties.getProperties(valueKey);

        int idx = ArrayUtils.indexOf(codes, code);
        return (values.length > idx) ? values[idx] : "";
    }

}
