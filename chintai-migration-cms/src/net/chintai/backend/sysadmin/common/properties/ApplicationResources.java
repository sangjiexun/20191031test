/*
 * $Id: ApplicationResources.java 3741 2008-01-10 09:55:23Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/14   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.properties;

import java.util.ResourceBundle;

/**
 * ApplicationResources のプロパティを取扱うクラスです。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3741 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ApplicationResources {

    /** リソースバンドル */
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/ApplicationResources");

    /**
     * このクラスはインスタンス化できません。
     */
    private ApplicationResources() {
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
