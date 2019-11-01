/*
 * $Id: AspShopInfoService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoAndAspInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoInServiceBean;

/**
 * 不動産ASPを設定するときに使用する店舗基本情報を照会するサビースクラス。
 * 又、登録された不動産ASP情報がある場合は不動産ASP情報を照会するサビースクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspShopInfoService {

    /**
     * 不動産ASPを設定するときに使用する店舗基本情報を照会する。 登録された不動産ASP情報を照会する。
     *
     * @param inServiceBean 店舗コード
     * @return 店舗基本情報, 不動産ASP情報
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public AspShopInfoAndAspInfoOutServiceBean aspShopInfoSearchByShopCd(
            AspShopInfoInServiceBean inServiceBean) throws Exception;

    /**
     * 不動産ASPグループリストを照会する。
     * @param inServiceBean 店舗コード
     * @return グループ店舗情報
     * @throws ApplicationException
     */
    public List<AspGroupInfoOutServiceBean> aspGroupList(AspShopInfoInServiceBean inServiceBean)
            throws ApplicationException;

}
