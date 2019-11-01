package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;


/**
 * 名寄せ処理対象外店舗一覧ダウンロードサービスクラス
 *
 * @author e-ishii
 * @version $Revision: 4567 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface NayoseSkipShopCsvDownloadService {

    /**
     * CSV出力の対象データ取得
     *
     * @param bean CVS出力用パラメータ
     * @throws ApplicationException
     */
    void createNayoseSkipShopCsv(CsvStatusBean bean) throws ApplicationException;

    /**
     * CSV出力の対象データ取得件数取得
     * @return CSV出力の対象データ
     */
    int getNayoseSkipShopCount();

}
