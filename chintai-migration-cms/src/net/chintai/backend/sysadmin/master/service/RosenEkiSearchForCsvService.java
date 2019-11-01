/*
 * $Id: RosenEkiSearchForCsvService.java 3707 2007-12-26 05:42:05Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/17  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
/**
 * CSV ファイルのダウンロード用沿線・駅を検索するService。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3707 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface RosenEkiSearchForCsvService {

    /**
     * 沿線・駅データをCSVとして出力します。
     * @param bean 出力するCSVの様式を決めるメタデータ
     * @throws ApplicationException CSV出力時に問題が発生した場合スローされる
     */
    public void createEnsenEkiCsv(CsvStatusBean bean) throws ApplicationException;

    /**
     * @return
     * @throws Exception
     */
    public List rosenEkiSearchForCsv() throws Exception;

}
