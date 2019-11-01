/*
 * $Id: AspUpdateForPrefService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspAreaPrefInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateInServiceBean;

/**
 * 不動産ASP更新画面でエリア情報を表示する為に、
 * 表示用エリア情報と実際に登録されたエリア情報をセットするService。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspUpdateForPrefService {

    /**
     * 表示用エリア情報に登録されたエリア情報をセットする。
     * 
     * @param aspAreaPrefInfoList 店舗ドード
     * @param inServiceBean 画面用不動産ASPのエリア情報リスト
     * @return 更新する不動産ASPのエリア情報
     * @throws Exception
     */
    public List<AspAreaPrefInfoOutServiceBean> aspAreaRegisteredInfoSearchByShopCd(List<AspAreaPrefInfoOutServiceBean> aspAreaPrefInfoList,
            AspUpdateInServiceBean inServiceBean) throws Exception;

}
