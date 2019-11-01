/*
 * $Id: ValidatorUtils.java 4313 2009-07-14 08:48:32Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.util;

import net.chintai.backend.sysadmin.common.properties.ApplicationResources;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.GenericValidator;

/**
 * 入力値検証Utilityクラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4313 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ValidatorUtils {

    /** GIF拡張子 */
    private static final String EXTENSION_GIF = ".GIF";

    /** JPG拡張子 */
    private static final String EXTENSION_JPG = ".JPG";

    /** 半角数字 */
    private static final String HALF_SIZE_NUMBER = "^[0-9]+$";


    /**
     * クロスサイドスクリプティング対策としてタグ開始特集文字を置換します。
     *
     * @param input 入力文字列。
     * @return 置換済の文字列。
     */
    public static String replaceTag(String input) {
        String returnValue = "";
        if (StringUtils.isEmpty(input))
            return input;

        returnValue = input.replaceAll(">", "&gt;");
        returnValue = returnValue.replaceAll("<", "&lt;");
        returnValue = returnValue.replaceAll("'", "\\'");
        return returnValue;
    }

    /**
     * クロスサイドスクリプティングチェック
     *
     * @param value 入力文字列。
     * @return チェック結果。
     */
    public static boolean validateScripting(String value) {
        if (GenericValidator.isBlankOrNull(value)) {
            return true;
        }
        if (value.matches(".*<[^>]*script[^>]*>.*")
                || value.matches(".*<[^>]*[^>a-zA-Z]*document\\.[^>]*>.*")
                || value.matches(".*<[^>]*[^>a-zA-Z]+on[a-zA-Z]+[ \t\n\r\f]*=[^>]*>.*")) {

            return false;
        }
        return true;
    }

    /**
     * 有効な日付であるのかを確認。
     *
     * @param date
     * @param datePattern
     */
    public static boolean isValidDate(String date, String datePattern) {

        if (StringUtils.isEmpty(date)) {
            return true;
        }

        return GenericValidator.isDate(date, datePattern, true);
    }

    /**
     * 開始日と終了日の矛盾チェックを行う。
     *
     * @param startYm
     * @param endYm
     * @return 開始日<=終了日：true
     *         開始日>終了日：false
     */
    public static boolean isValidDates(String startYm, String endYm, String datePattern) {

        if (StringUtils.isEmpty(startYm) || StringUtils.isEmpty(endYm)) {
            return true;
        }

        // 開始日、終了日が両方とも正常の場合たけ、範囲チェックを行う。
        if (!ValidatorUtils.isValidDate(startYm, datePattern)
                || !ValidatorUtils.isValidDate(endYm, datePattern)) {
            return true;
        }

        if (startYm.compareTo(endYm) <= 0) {
            return true;
        }

        return false;
    }

    /**
     * ファイル拡張子チェック。
     *
     * @param fileName
     * @return 拡張子がGIF:true 拡張子がGIF以外：false
     */
    public static boolean isGIF(String fileName) {

        boolean flg = false;

        if (fileName.toUpperCase().endsWith(EXTENSION_GIF)) {
            flg = true;
        }

        return flg;
    }

    /**
     * ファイル拡張子チェック
     *
     * @param fileName
     * @return 拡張子がGIF:false 拡張子がGIF以外：true
     */
    public static boolean isNotGIF(String fileName) {

        return !ValidatorUtils.isGIF(fileName);
    }

    /**
     * ファイル拡張子チェック
     *
     * @param fileName
     * @return 拡張子がJPG:true 拡張子がJPG以外：false
     */
    public static boolean isJPG(String fileName) {

        boolean flg = false;

        if (fileName.toUpperCase().endsWith(EXTENSION_JPG)) {
            flg = true;
        }

        return flg;
    }

    /**
     * ファイル拡張子チェック
     *
     * @param fileName
     * @return 拡張子がJPG:false 拡張子がJPG以外：true
     */
    public static boolean isNotJPG(String fileName) {

        return !ValidatorUtils.isJPG(fileName);
    }

    /**
     * 店舗地図画像のファイルサイズをチェックします。
     *
     * @param fileSize
     * @return 設定ファイルの最大サイズ以下：true 設定ファイルの最大サイズ超過：false
     */
    public static boolean isValidMapFileSize(int fileSize) {

        boolean flg = false;

        int mapFileMaxSize =
                Integer.parseInt(ApplicationResources.getProperty("shop.mapFileMaxSize"));

        if (fileSize < mapFileMaxSize) {
            flg = true;
        }

        return flg;
    }

    /**
     * 店舗地図画像のファイルサイズをチェックします。
     *
     * @param fileSize
     * @return 設定ファイルの最大サイズ以下：false 設定ファイルの最大サイズ超過：ture
     */
    public static boolean isInvalidMapFileSize(int fileSize) {
        return !ValidatorUtils.isValidMapFileSize(fileSize);
    }

    /**
     * 店舗画像のファイルサイズをチェックします。
     *
     * @param fileSize
     * @return 設定ファイルの最大サイズ以下：true 設定ファイルの最大サイズ超過：false
     */
    public static boolean isValidShopPhotoFileSize(int fileSize) {

        boolean flg = false;

        int mapFileMaxSize =
                Integer.parseInt(ApplicationResources.getProperty("shop.photoPhotoFileMaxSize"));

        if (fileSize < mapFileMaxSize) {
            flg = true;
        }

        return flg;
    }

    /**
     * 店舗画像のファイルサイズをチェックします。
     *
     * @param fileSize
     * @return 設定ファイルの最大サイズ以下：false 設定ファイルの最大サイズ超過：ture
     */
    public static boolean isInvalidShopPhotoFileSize(int fileSize) {
        return !ValidatorUtils.isValidShopPhotoFileSize(fileSize);
    }

    /**
     * 半角数字であるのかをチェック
     *
     * @param input
     * @return 半角数字:false
     *         半額数字以外：true
     */
    public static boolean isNotHalfSizeNumber(String input) {

        if (StringUtils.isEmpty(input)) {
            return false;
        }

        return !input.matches(HALF_SIZE_NUMBER);
    }
}
