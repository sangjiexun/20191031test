/*
 * $Id: ServerProperties.java 3774 2008-01-30 07:21:01Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/11/27   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.properties;

import java.util.ResourceBundle;

/**
 * 環境依存の設定値に関するプロパティを取扱うクラスです。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3774 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ServerProperties {

    /** リソースバンドル */
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/server");

    /**
     * このクラスはインスタンス化できません。
     */
    private ServerProperties() {
    }

    /**
     * 指定したプロパティの値を取得します。
     * @param key プロパティのキー値
     * @return キーに対応するプロパティ値
     */
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

    /**
     * 指定したプロパティの値リストを取得します。
     * @param key プロパティのキー値
     * @return キーに対応するプロパティ値
     */
    public static String[] getProperties(String key) {
        return resourceBundle.getString(key).split(",");
    }
}
