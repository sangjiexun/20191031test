/*
 * $Id: AspUpdateConfirmService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateConfirmOutServiceBean;

/**
 * 不動産ASP設定情報更新の入力されたエリア設定、沿線設定情報を整列する。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspUpdateConfirmService {

    /**
     * 不動産ASP設定情報更新の入力されたエリア設定、沿線設定情報をチェックする。 チェックするは実際に入力されたエリア設定、沿線設定の値を対象にして
     * それぞれの該当エリア名、沿線名をマチングする。マチングされた後整列を行う。
     * 
     * @param inServiceBean 不動産ASP設定情報更新確認画面用InServiceBean
     * @return 不動産ASP設定情報更新確認のOutServiceBean
     * @throws Exception
     */
    public AspUpdateConfirmOutServiceBean aspAreaEnsenCheck(
            AspUpdateConfirmInServiceBean inServiceBean) throws Exception;

}
