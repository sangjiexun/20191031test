/*
 * $Id: DemandUtils.java 4649 2013-10-09 07:58:02Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.chintai.backend.sysadmin.common.util.DateUtil;


/**
 * 物件枠機能のUtilクラス。
 *
 * @author lee-hosup
 * @version $Revision: 4649 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBukkenUtils {

    /**
     * 月リストを取得します(適用月プルダウン用)。<BR>
     * @return 適用月プルダウン用データ
     */
    public static List<String[]> getMonthsList() {

        List<String[]> returnList = new ArrayList<String[]>();
        String[] monthValues = DateUtil.getMonthsList();
        for (int i = 0; i < monthValues.length; i++) {
            returnList.add(new String[]{monthValues[i],monthValues[i]});
        }

        return returnList;
    }

    /**
     * 年度リストを取得します(適用月プルダウン用)。<BR>
     * @return 現在年度+3年後までのプルダウン用データを返す
     *         例)2007年現在2007年から2010年までのデータを返します
     */
    public static List<String[]> getYearList() {

        List<String[]> returnList = new ArrayList<String[]>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = currentYear; i < currentYear+4; i++) {
            returnList.add(
                    new String[]{String.valueOf(i),String.valueOf(i)});
        }

        return returnList;
    }

    /**
     * 日付表示形式を変換します。<BR>
     * @param date YYYYMMDDHHMMSS形式の日付
     * @return YYYY/MM/DD HH:mm:ss時形式の日付
     */
    public static String convertDateAll(String date) {
        if(date == null || date.length() < 14){
            return date;
        }
        String newDate = date.substring(0,4) + "-"
                        +date.substring(4,6) + "-"
                        +date.substring(6,8) + " "
                        +date.substring(8,10) + ":"
                        +date.substring(10,12) + ":"
        				+date.substring(12,14);
        return newDate;
    }

    /**
     * 日付表示形式を変換します。<BR>
     * @param date YYYYMMDD形式の日付
     * @return YYYY年MM月DD日形式の日付
     */
    public static String convertDate(String date) {
        if(date == null || date.length() < 6){
            return date;
        }
        String newDate = date.substring(0,4) + "年"
                        +date.substring(4,6) + "月";
        return newDate;
    }

    /**
     * 日付表示形式を変換します。<BR>
     * @param date YYYYMMDDHH形式の日付
     * @return YYYY/MM/DD HH:mm時形式の日付
     */
    public static String convertDateYMDH(String date) {
        if(date == null || date.length() < 6){
            return date;
        }
        String newDate = date.substring(0,4) + "年"
                        +date.substring(4,6) + "月"
                        +date.substring(6,8) + "日"
                        +date.substring(8,10) + "時";
        return newDate;
    }

    /**
     * 郵便番号表示形式を変換します。<BR>
     * @param zipCd '-'が含まれてない0000000形式の郵便番号
     * @return 000-0000形式の郵便番号
     */
    public static String convertZipCd(String zipCd) {
        if(zipCd == null || zipCd.length() < 7){
            return zipCd;
        }
        String newZipCd = zipCd.substring(0,3) + "-"
                         +zipCd.substring(3);
        return newZipCd;
    }

    /**
     * 概要：文字列が指定したファーマットの日付で正しいかどうかをチェック フォーマットが正しい場合は<code>true</code>を返します。
     *
     * @param str
     *          文字列
     * @param format
     *          日付フォーマット
     * @return チェック結果（フォーマットが正しい場合は<code>true</code>）
     */
    public static boolean isDataFormat(String str, String format) {

        boolean result = true;

        if (str == null || format == null) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);

        ParsePosition position = new ParsePosition(0);
        sdf.parse(str, position);

        if (position.getErrorIndex() != -1) {
            // パース失敗
            result = false;
        } else {
            // パース成功
            if (position.getIndex() != str.length() || format.length() != str.length()) {
                // 厳密には失敗
                result = false;
            } else {
                sdf.getCalendar().getTime();
                result = true;
            }
        }

        return result;
    }

}
