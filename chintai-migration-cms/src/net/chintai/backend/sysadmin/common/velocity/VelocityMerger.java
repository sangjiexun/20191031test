/*
 * $Id: VelocityMerger.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/25   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.velocity;

import java.util.Map;

/**
 * Velocity Template への情報のマージを行うクラスです。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface VelocityMerger {

    /**
     * テンプレートに変数をマージして、その結果を取得します。
     * @param templatePath テンプレートファイルのパス
     * @param map 変数 : (変数名, 値) のペア
     * @return マージ後の内容
     */
    public String merge(String templatePath, Map<String, Object> map);
    
    /**
     * サイドバーテンプレート(広告チーム用)に変数をマージして、その結果を出力します。
     * @param map 変数 : (変数名, 値) のペア
     * @return マージ後の内容
     */
    public String mergeTemplateMenuForAd(Map<String, Object> map);
    
    /**
     * サイドバーテンプレート(統合チーム用)に変数をマージして、その結果を出力します。
     * @param map 変数 : (変数名, 値) のペア
     * @return マージ後の内容
     */
    public String mergeTemplateMenuForTogo(Map<String, Object> map);
    
}
