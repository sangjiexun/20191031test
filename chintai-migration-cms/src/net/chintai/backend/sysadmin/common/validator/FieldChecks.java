package net.chintai.backend.sysadmin.common.validator;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

import net.chintai.receive.crsplus.validator.Patterns;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericTypeValidator;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;

/**
 * 広告管理チーム提供のバリデータクラス。
 *
 * @author CHINTAI ad Team
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FieldChecks extends org.apache.struts.validator.FieldChecks {

    /** serialVersionUID */
    private static final long serialVersionUID = -6126288492449363402L;

    public static final String FIELD_TEST_CONTAIN = "CONTAIN";

    public static final String FIELD_TEST_NOT_CONTAIN = "NOTCONTAIN";

    /**
     * 値が１かどうかのチェック 個人情報保護のラジオボタンのチェック
     *
     * @param bean The bean validation is being performed on.
     * @param va The <code>ValidatorAction</code> that is currently being
     *        performed.
     * @param field The <code>Field</code> object associated with the current
     *        field being validated.
     * @param errors The <code>ActionMessages</code> object to add errors to
     *        if any validation errors occur.
     * @param validator The <code>Validator</code> instance, used to access
     *        other field values.
     * @param request Current request object.
     * @return true if meets stated requirements, false otherwise.
     */
    public static boolean validateIs1(final Object bean, final ValidatorAction va, final Field field,
            final ActionMessages errors, final Validator validator, final HttpServletRequest request) {
        if (!validateRequired(bean, va, field, errors, validator, request)) {
            return false;
        } else {
            if (!"1".equals(evaluateBean(bean, field))) {
                errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));

                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * ロカールバリデート用にjsメッセージ生成 これ自体は、何もしません。 javascript function validateOverride
     * をオーバーライドしてください
     * @param bean
     * @param va
     * @param field
     * @param errors
     * @param validator
     * @param request
     * @return boolean
     */
    public static boolean validateOverride(final Object bean, final ValidatorAction va, final Field field,
            final ActionMessages errors, final Validator validator, final HttpServletRequest request) {
        return true;
    }

    /**
     * validateRequiredIfのＡＲＲＡＹバージョン
     *
     * @param bean The bean validation is being performed on.
     * @param va The <code>ValidatorAction</code> that is currently being
     *        performed.
     * @param field The <code>Field</code> object associated with the current
     *        field being validated.
     * @param errors The <code>ActionMessages</code> object to add errors to
     *        if any validation errors occur.
     * @param validator The <code>Validator</code> instance, used to access
     *        other field values.
     * @param request Current request object.
     * @return true if meets stated requirements, false otherwise.
     */
    public static boolean validateRequiredIfContain(Object bean, ValidatorAction va, Field field,
            ActionMessages errors, Validator validator, HttpServletRequest request) {
        Object form = validator.getParameterValue(org.apache.commons.validator.Validator.BEAN_PARAM);
        String value = null;
        boolean required = false;

        value = evaluateBean(bean, field);

        int i = 0;
        String fieldJoin = "AND";

        if (!GenericValidator.isBlankOrNull(field.getVarValue("fieldJoin"))) {
            fieldJoin = field.getVarValue("fieldJoin");
        }

        if (fieldJoin.equalsIgnoreCase("AND")) {
            required = true;
        }

        while (!GenericValidator.isBlankOrNull(field.getVarValue("field[" + i + "]"))) {
            String dependProp = field.getVarValue("field[" + i + "]");
            String dependTest = field.getVarValue("fieldTest[" + i + "]");
            String dependTestValue = field.getVarValue("fieldContain[" + i + "]");

            String[] dependVal = null;
            boolean thisRequired = false;

            try {
                dependVal = BeanUtils.getArrayProperty(form, dependProp);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.toString() + " " + field.getProperty() + "is not Array.");
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.toString() + " " + field.getProperty() + "is not Array.");
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e.toString() + " " + field.getProperty() + "is not Array.");
            }

            if (dependTest.equals(FIELD_TEST_NULL)) {
                if ((dependVal != null) && (dependVal.length > 0)) {
                    thisRequired = false;
                } else {
                    thisRequired = true;
                }
            }

            if (dependTest.equals(FIELD_TEST_NOTNULL)) {
                if ((dependVal != null) && (dependVal.length > 0)) {
                    thisRequired = true;
                } else {
                    thisRequired = false;
                }
            }

            if (dependTest.equals(FIELD_TEST_CONTAIN)) {
                thisRequired = ArrayUtils.contains(dependVal, dependTestValue);
            }

            if (dependTest.equals(FIELD_TEST_NOT_CONTAIN)) {
                thisRequired = !ArrayUtils.contains(dependVal, dependTestValue);
            }

            if (fieldJoin.equalsIgnoreCase("AND")) {
                required = required && thisRequired;
            } else {
                required = required || thisRequired;
            }

            i++;
        }

        if (required) {
            if (GenericValidator.isBlankOrNull(value)) {
                errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));

                return false;
            } else {
                return true;
            }
        }

        return true;
    }

    /**
     * 日付の開始日チェック 入力値の日付が、システム日付を調整した日付以降ならOK
     *
     * @param bean The bean validation is being performed on.
     * @param va The <code>ValidatorAction</code> that is currently being
     *        performed.
     * @param field The <code>Field</code> object associated with the current
     *        field being validated.
     * @param errors The <code>ActionMessages</code> object to add errors to
     *        if any validation errors occur.
     * @param validator The <code>Validator</code> instance, used to access
     *        other field values.
     * @param request Current request object.
     * @return true if meets stated requirements, false otherwise.
     */
    public static boolean validateDateFrom(final Object bean, final ValidatorAction va, final Field field,
            final ActionMessages errors, final Validator validator, final HttpServletRequest request) {

        final String value = evaluateBean(bean, field);

        if (GenericValidator.isBlankOrNull(value)) {
            return true;
        }

        final String datePattern = field.getVarValue("datePattern");
        final String daysAddFrom = field.getVarValue("daysAddFrom");

        final Date nowDate = new Date();
        // 同日をOKにする為に-１
        final Date fromDate = adjustDate(nowDate, daysAddFrom, -1);
        final Date valueDate = GenericTypeValidator.formatDate(value, datePattern, false);

        if (fromDate != null) {
            if (!fromDate.after(valueDate)) {
                errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
                return false;
            }
        }

        return true;
    }

    /**
     * 日付の終了日チェック 入力値の日付が、システム日付を調整した日付以内ならOK
     *
     * @param bean The bean validation is being performed on.
     * @param va The <code>ValidatorAction</code> that is currently being
     *        performed.
     * @param field The <code>Field</code> object associated with the current
     *        field being validated.
     * @param errors The <code>ActionMessages</code> object to add errors to
     *        if any validation errors occur.
     * @param validator The <code>Validator</code> instance, used to access
     *        other field values.
     * @param request Current request object.
     * @return true if meets stated requirements, false otherwise.
     */
    public static boolean validateDateTo(final Object bean, final ValidatorAction va, final Field field,
            final ActionMessages errors, final Validator validator, final HttpServletRequest request) {

        final String value = evaluateBean(bean, field);

        if (GenericValidator.isBlankOrNull(value)) {
            return true;
        }

        final String datePattern = field.getVarValue("datePattern");
        final String daysAddTo = field.getVarValue("daysAddTo");

        final Date nowDate = new Date();
        // 同日をOKにする為に+１
        final Date toDate = adjustDate(nowDate, daysAddTo, 1);
        final Date valueDate = GenericTypeValidator.formatDate(value, datePattern, false);

        if (toDate != null) {
            if (!toDate.before(valueDate)) {
                errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
                return false;
            }
        }

        return true;
    }

    /**
     * クロスサイドスクリプティングチェック
     *
     * @param bean The bean validation is being performed on.
     * @param va The <code>ValidatorAction</code> that is currently being
     *        performed.
     * @param field The <code>Field</code> object associated with the current
     *        field being validated.
     * @param errors The <code>ActionMessages</code> object to add errors to
     *        if any validation errors occur.
     * @param validator The <code>Validator</code> instance, used to access
     *        other field values.
     * @param request Current request object.
     * @return true if meets stated requirements, false otherwise.
     */
    public static boolean validateScripting(final Object bean, final ValidatorAction va, final Field field,
            final ActionMessages errors, final Validator validator, final HttpServletRequest request) {

        final String value = evaluateBean(bean, field);

        if (GenericValidator.isBlankOrNull(value)) {
            return true;
        }

        if (value.matches(".*<[^>]*script[^>]*>.*") || value.matches(".*<[^>]*[^>a-zA-Z]*document\\.[^>]*>.*")
                || value.matches(".*<[^>]*[^>a-zA-Z]+on[a-zA-Z]+[ \t\n\r\f]*=[^>]*>.*")) {
            errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
            return false;
        }

        return true;
    }

    public static boolean validateEmail(Object bean, ValidatorAction va, Field field, ActionMessages errors, Validator validator, HttpServletRequest request)
    {
    	final String value = evaluateBean(bean, field);

        if (GenericValidator.isBlankOrNull(value)) {
            return true;
        }

        if(!value.matches(Patterns.C_EMAIL))
        {
           errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
           return false;
        } else
        {  return true;
        }
    }

    private static String evaluateBean(final Object bean, final Field field) {
        String value;

        if (isString(bean)) {
            value = (String) bean;
        } else {
            value = ValidatorUtils.getValueAsString(bean, field.getProperty());
        }

        return value;
    }

    private static Date adjustDate(final Date nowDate, final String daysAdd, final int checkAdjust) {

        if (daysAdd != null && daysAdd.length() > 0) {
            final Calendar calendar = new GregorianCalendar();

            calendar.setTime(nowDate);

            // 時間をクリア
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            final int days = Integer.parseInt(daysAdd) + checkAdjust;

            // 日付を加算（マイナスあり）
            calendar.add(Calendar.DAY_OF_MONTH, days);

            return calendar.getTime();
        } else {
            return null;
        }
    }
}
