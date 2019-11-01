/*
 * $Id: ReviewUtils.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review;

import java.util.List;
import java.util.ArrayList;


/**
 * Web審査機能で使うUtilityクラス。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewUtils {


    /**
     * 検索開始日付に基づいて画面表示用日付リストを作成。
     *
     * @param sYear 検索開始年
     * @param sMonth 検索開始月
     * @return 集計年月リスト
     */
    public static List<String> getDateList(String sYear, String sMonth){
        List<String> dateList = new ArrayList<String>();

        int year = Integer.parseInt(sYear);
        int month = Integer.parseInt(sMonth);

        String date = "";
        for (int i = 0; i < 12; i++) {
            date = String.valueOf(year) + "年<BR>";
            date = date + String.valueOf(month) + "月";
            dateList.add(date);
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
        return dateList;
    }

    /**
     * 日付表示形式を変換します。<BR>
     * @param date YYYYMMDD形式の日付
     * @return YYYY年MM月DD日形式の日付
     */
    public static String convertDate(String date) {
        if(date == null || date.length() < 8){
            return date;
        }
        String newDate = date.substring(0,4) + "年"
                        +date.substring(4,6) + "月"
                        +date.substring(6,8) + "日";
        return newDate;
    }

    /**
     * 築年表示形式を変換します。<BR>
     * @param chikunen YYYYMMDD形式の日付
     * @return YY/MM形式の日付
     */
    public static String convertChikunen(String chikunen) {
        if(chikunen == null || chikunen.length() != 6){
            return chikunen;
        }
        return chikunen.substring(2,4) + "/" + chikunen.substring(4,6);
    }
}
