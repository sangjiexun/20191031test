/*
 * $Id: ValidatorCompareDate.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者        内容
 * ---------------------------------------------------------
 * 2007/07/27  BGT)劉 俊秀   新規作成
 * 2007/08/03  BGT)劉 俊秀   コメント追加
 * 2007/08/03  BGT)児島      コメント追加修正、リファクタリング実施
 * 2007/10/30  BGT)児島      引数の中に不正日付がある場合、範囲矛盾チェックしないように修正
 */
package net.chintai.backend.sysadmin.common.validator;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;

/**
 * 日付チェックを行う拡張 Validator です。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ValidatorCompareDate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ
     */
    public ValidatorCompareDate() {
    }

    /**
     * 開始日と終了日の前後関係が正しいかどうかチェックします。
     * @param bean Object
     * @param va ValidatorAction
     * @param field Field
     * @param errors ActionMessages
     * @param validator
     * @param request HttpServletRequest
     * @return チェック結果
     */
    public static Object compareDate(Object bean, ValidatorAction va,
            Field field, ActionMessages errors, Validator validator,
            HttpServletRequest request) {
        Object result = null;
        String startDate = null;
        String endDate = null;
        String datePattern = null;

        startDate = evaluateBean(bean, field.getVarValue("startDate"));
        endDate = evaluateBean(bean, field.getVarValue("endDate"));
        datePattern = field.getVarValue("datePattern");

        // datePattern未指定の場合yyyyMMdd形式でチェック
        if(GenericValidator.isBlankOrNull(datePattern)){
            datePattern = "yyyyMMdd";
        }

        // 範囲矛盾チェック対象であるか判断
        if(!isValid(startDate,endDate,datePattern)){
            return true;
        }

        // 開始日>終了日、範囲エラーを出力
        if (startDate.compareTo(endDate) <= 0 ) {
            result = Boolean.TRUE;
        } else {
            result = Boolean.FALSE;
            errors.add(field.getKey(), Resources.getActionMessage(validator,
                    request, va, field));
        }
        return result;
    }

    /**
     * ビーンから特定の Field 値を抜き出し、取得します。
     * @param bean ビーン
     * @param fieldProperty Field名
     * @return field値
     */
    private static String evaluateBean(Object bean, String fieldProperty) {
        String value = null;
        if (isString(bean)) {
            value = (String) bean;
        } else {
            value = ValidatorUtils.getValueAsString(bean, fieldProperty);
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

    /**
     * 範囲矛盾チェック対象であるのかを判断<br>
     * @param String startDate 開始日
     * @param String endDate 終了日
     * @param String datePattern 日付入力パターン
     * @return チェック結果
     */
    private static boolean isValid(String startDate, String endDate, String datePattern) {

        // 開始日と終了日どちかが未入力の場合範囲矛盾チェックしない
        if(GenericValidator.isBlankOrNull(startDate) || GenericValidator.isBlankOrNull(endDate)){
            return false;
        }

        // 開始日或いは終了日が不正日付の場合範囲矛盾チェックしない
        if(!GenericValidator.isBlankOrNull(startDate)
                && !GenericValidator.isDate(startDate, datePattern, true)){
            return false;
        }
        if(!GenericValidator.isBlankOrNull(endDate)
                &&!GenericValidator.isDate(endDate, datePattern, true)){
            return false;
        }
        return true;
    }
}
