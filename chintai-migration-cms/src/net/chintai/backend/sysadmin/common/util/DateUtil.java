/*
 * $Id: DateUtil.java 4639 2013-10-07 08:26:15Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/07/31  BGT)李昊燮   新規作成
 * 2007/08/01  BGT)児島     リファクタリング実施
 *                          時間(hour)関係の処理を追加
 *                          コメントを修正
 * 2007/08/03  BGT)児島     String 配列の可視性を private に変更し、
 *                          代わりに配列取得用の public メソッドを実装
 * 2007/08/13  BGT)児島     C_DROPDOWNLIST_START_YEAR の定義を
 *                          SystemProperties クラスに移動
 * 2013/09/10  BGT)亀田     電話反響件数にて、getSpecifyDate追加
 */
package net.chintai.backend.sysadmin.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;

/**
 * 日付処理に関するユーティリティクラス。
 *
 * @author lee-hosup
 * @author KOJIMA Takanori
 * @version $Revision: 4639 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class DateUtil {

    /** デフォルト日付フォーマット */
    private static final String C_DEFAULT_DATE_FORMAT = "yyyyMMdd";

    /** 時間リスト */
    // "00" から開始、"24" は使わない
    private static final String[] C_HOURS_LIST = {
        "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
        "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
        "20", "21", "22", "23" };

    /** 日付リスト */
    private static final String[] C_DAYS_LIST = {
        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
        "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
        "31" };

    /** 月リスト */
    private static final String[] C_MONTHS_LIST = {
        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
        "11", "12" };

    /**
     * 外部からのインスタンス化はできません。
     */
    private DateUtil() {
    }

    /**
     * 秒リストを取得します。
     * @return
     */
    public static String[] getSecondsList() {
    	String[] secondsList = new String[60];
        for (int i = 0; i < 60; i++) {
        	if(i < 10){
        		secondsList[i] = "0" + i;
        	}else{
        		secondsList[i] = String.valueOf(i);
        	}
        }
        return secondsList;
    }

    /**
     * 分リストを取得します。
     * @return
     */
    public static String[] getMinutesList() {
    	String[] minutesList = new String[60];
        for (int i = 0; i < 60; i++) {
        	if(i < 10){
        		minutesList[i] = "0" + i;
        	}else{
        		minutesList[i] = String.valueOf(i);
        	}
        }
        return minutesList;
    }

    /**
     * 時間リストを取得します。
     * @return 時間リスト
     */
    public static String[] getHoursList() {
        String[] list = new String[C_HOURS_LIST.length];
        for (int i = 0; i < C_HOURS_LIST.length; i++) {
            list[i] = C_HOURS_LIST[i];
        }
        return list;
    }

    /**
     * 日リストを取得します。
     * @return 日リスト
     */
    public static String[] getDaysList() {
        String[] list = new String[C_DAYS_LIST.length];
        for (int i = 0; i < C_DAYS_LIST.length; i++) {
            list[i] = C_DAYS_LIST[i];
        }
        return list;
    }

    /**
     * 月リストを取得します。
     * @return 月リスト
     */
    public static String[] getMonthsList() {
        String[] list = new String[C_MONTHS_LIST.length];
        for (int i = 0; i < C_MONTHS_LIST.length; i++) {
            list[i] = C_MONTHS_LIST[i];
        }
        return list;
    }

    /**
     * 年リストを取得します。
     * @return 年リスト
     */
    public static String[] getYearsList() {
        int currentYear = getDate().get(Calendar.YEAR);

        int startYear = new Integer(SystemProperties.getProperty("C_DROPDOWNLIST_START_YEAR"));
        StringBuilder builder = new StringBuilder();
        for (int i = startYear; i <= currentYear; i++) {
            builder.append(i);
            builder.append(",");
        }
        return builder.toString().split(",");
    }

    /**
     * 現在時間を取得します。
     * @return 現在時間
     */
    public static String getCurrentHour() {
        return String.valueOf(getDate().get(Calendar.HOUR_OF_DAY));
    }

    /**
     * 現在日を取得します。
     * @return 現在日
     */
    public static String getCurrentDay() {
        return String.valueOf(getDate().get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 現在月を取得します。
     * @return 現在月
     */
    public static String getCurrentMonth() {
        return String.valueOf(getDate().get(Calendar.MONTH) + 1);
    }

    /**
     * 現在年を取得します。
     * @return 現在年
     */
    public static String getCurrentYear() {
        return String.valueOf(getDate().get(Calendar.YEAR));
    }

    /**
     * 現在日付(年月日)を取得する内部メソッドです。
     * @return 年月日
     */
    private static Calendar getDate() {
        return Calendar.getInstance();
    }

    /**
     * 渡された日付文字列が当日の日付もしくは前日の日付と一致するかどうか、判定します。<br>
     * 日付文字列は yyyyMMdd 形式とします。
     * @param postDate 検証する日付文字列
     * @return 検証結果 true(どちらかに一致する) / false(両方とも一致しない)
     */
    public static boolean isValidDate(String postDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();

        String today = sdf.format(calendar.getTime());

        calendar.add(Calendar.DATE, -1);
        String yesterday = sdf.format(calendar.getTime());

        if (StringUtils.equals(postDate, today) || StringUtils.equals(postDate, yesterday)) {
            return true;
        }
        return false;
    }

    /**
     * このメソッドは isNotValidDate メソッドとは逆の結果を返します。 日付文字列は yyyyMMdd 形式とします。<br>
     * @param postDate 検証する日付文字列
     * @return 検証結果 true(両方とも一致しない) / false(どちらかに一致する)
     */
    public static boolean isNotValidDate(String postDate) {
        return !isValidDate(postDate);
    }

    /**
     * 現在のシステム日付を基準として、昨日の日付を取得します。<br>
     * 返却フォーマットは "yyyyMMdd" です。
     * @return 昨日の日付文字列
     */
    public static String getYesterday() {
        return getYesterday(C_DEFAULT_DATE_FORMAT);
    }

    /**
     * 現在のシステム日付を基準として、昨日の日付を取得します。<br>
     * @param dateFormat 返却する日付のフォーマット文字列
     * @return 昨日の日付文字列
     */
    public static String getYesterday(String dateFormat) {
        Date date = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    /**
     * 現在のシステム日付を基準として、今日の日付を取得します。<br>
     * 返却フォーマットは "yyyyMMdd" です。
     * @return 今日の日付文字列
     */
    public static String getToday() {
        return getToday(C_DEFAULT_DATE_FORMAT);
    }

    /**
     * 現在のシステム日付を基準として、今日の日付を取得します。<br>
     * @param dateFormat 返却する日付のフォーマット文字列
     * @return 今日の日付文字列
     */
    public static String getToday(String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(new Date());
    }

    /**
     * 現在のシステム日付を基準として、明日の日付を取得します。<br>
     * 返却フォーマットは "yyyyMMdd" です。
     * @return 明日の日付文字列
     */
    public static String getTomorrow() {
        return getTomorrow(C_DEFAULT_DATE_FORMAT);
    }

    /**
     * 現在のシステム日付を基準として、明日の日付を取得します。<br>
     * @param dateFormat 返却する日付のフォーマット文字列
     * @return 明日の日付文字列
     */
    public static String getTomorrow(String dateFormat) {
        Date date = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    /**
     * 年リストを取得します。
     * @param addYear 最終年補正値
     * @return 年リスト
     */
    public static String[] getYearsList(String sYear, String addYear) {
        int startYear;
        int currentYear = getDate().get(Calendar.YEAR);

        if (StringUtils.isNotEmpty(addYear)) {
            currentYear = currentYear + Integer.parseInt(addYear);
        }

        if (StringUtils.isNotEmpty(sYear)) {
            startYear = new Integer(sYear);
        } else {
            startYear = new Integer(SystemProperties.getProperty("C_DROPDOWNLIST_START_YEAR"));
        }

        StringBuilder builder = new StringBuilder();
        for (int i = startYear; i <= currentYear; i++) {
            builder.append(i);
            builder.append(",");
        }
        return builder.toString().split(",");
    }

    /**
     * 指定した年月日の数ヶ月後を返します
     * (例)引数("2013","1","2","3")を指定した場合「20130402」が返される
     * @param year 指定年
     * @param mouth 指定月
     * @param day 指定日
     * @param nextNumber 何ヶ月を指定
     * @return 年月日の数ヶ月後
     * @throws ParseException
     */
    public static String getSpecifyDate(String year, String mouth, String day, int nextNumber) throws ParseException {
        String originYears = year + mouth + day;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
        Date date = format1.parse(originYears);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, nextNumber);
        date = cal.getTime();
        String nextYears = format1.format(date);

        return nextYears;
    }

    /**
     * 指定した年月の末日を設定した日付を返します。
     * @param year 指定年
     * @param mouth 指定月
     * @return 末日日付
     */
    public static Calendar getLastDay(String year, String mouth){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        cal.set(Calendar.MONTH, Integer.parseInt(mouth)-1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
        return cal;

    }
}
