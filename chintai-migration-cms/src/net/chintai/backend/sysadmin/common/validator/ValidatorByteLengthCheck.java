/*
 * $Id: ValidatorByteLengthCheck.java 4448 2010-02-09 15:02:12Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.validator;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;

/**
 * 入力文字列のByte数をチェックします。
 *
 * @author Lee Hosup
 * @version $Revision: 4448 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ValidatorByteLengthCheck implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -144412499696213674L;

    /**
     * DefaultConstructor
     */
    public ValidatorByteLengthCheck() {
    }

    /**
     * 入力値の長さをバイト単位でチェック
     *
     * @param bean Object
     * @param va ValidatorAction
     * @param field Field
     * @param errors ActionMessages
     * @param validator
     * @param request HttpServletRequest
     * @return チェック結果
     */
    public static boolean byteMaxLength(Object bean, ValidatorAction va, Field field,
            ActionMessages errors, Validator validator, HttpServletRequest request) {

        String fieldValue = evaluateBean(bean, field);

        if (GenericValidator.isBlankOrNull(fieldValue))
            return true;

        int maxLength = Integer.parseInt(field.getVarValue("maxLength"));

        int fieldsLength;
        try {
            fieldsLength = fieldValue.getBytes("MS932").length;
        } catch (UnsupportedEncodingException e) {
            return false;
        }

        if (fieldsLength <= maxLength) {
            return true;
        }

        errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
        return false;
    }

    /**
     * 入力値の長さをバイト単位でチェック(CSVファイルのチェック用)
     * @param value
     * @param maxLength
     * @return
     */
    public static boolean byteMaxLengthforCsv(String value , String maxLen) {

        if (GenericValidator.isBlankOrNull(value)) return true;

        int maxLength = Integer.parseInt(maxLen);

        int fieldsLength;
        try {
            fieldsLength = value.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException e) {
            return false;
        }

        if (fieldsLength <= maxLength) {
            return true;
        }
        return false;
    }

    /**
     * 入力値の長さをバイト単位でチェック（CSVファイルのチェック用）
     * lenと同じ長さであるかチェックする
     * @param value
     * @param len
     * @return
     */
    public static boolean byteLengthforCsv(String value , String len) {

        if (GenericValidator.isBlankOrNull(value)) return true;

        int length = Integer.parseInt(len);

        int fieldsLength;
        try {
            fieldsLength = value.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException e) {
            return false;
        }

        if (fieldsLength == length) {
            return true;
        }
        return false;

    }

    /**
     * ビーンから特定の Field 値を抜き出し、取得します。
     * @param bean ビーン
     * @param fieldProperty Field名
     * @return field値
     */
    private static String evaluateBean(Object bean, Field field) {
        String value = null;
        if (isString(bean)) {
            value = (String) bean;
        } else {
            value = ValidatorUtils.getValueAsString(bean, field.getProperty());
        }
        return value;
    }

    /**
     * 渡された Object が文字列かどうかをチェックします。
     * @param obj Object
     * @return チェック結果
     */
    protected static boolean isString(Object obj) {
        return (obj == null) ? true : String.class.isInstance(obj);
    }

}
