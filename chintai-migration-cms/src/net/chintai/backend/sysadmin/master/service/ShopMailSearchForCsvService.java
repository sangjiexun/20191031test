/*
 * $Id: ShopMailSearchForCsvService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service;

import java.util.List;

import net.chintai.backend.sysadmin.master.service.bean.ShopMailSearchForCsvOutServiceBean;

/**
 * CSV ファイルのダウンロード用不動産会社メールアドレスを検索するService。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopMailSearchForCsvService {

    /**
     * メールアドレスリストを取得します。
     * @return メールアドレス一覧
     * @throws Exception メールアドレス取得処理中にエラーが発生した場合にスローされます。
     */
    public List<ShopMailSearchForCsvOutServiceBean> shopMailSearchForCsv() throws Exception;

}
