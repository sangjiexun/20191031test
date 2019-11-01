/*
 * $Id: ShopSearchByShopInfoService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchOutServiceBean;


/**
 * 店舗検索(店舗情報から検索)を提供するサービスクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopSearchByShopInfoService {

    /**
     * 店舗情報から検索
     * 
     * @param inServiceBean 検索条件
     * @return 検索結果(店舗リスト)
     * @throws ApplicationException
     */
    public List<ShopSearchOutServiceBean> shopSearchByShopInfo(ShopSearchInServiceBean inServiceBean, BasePagerCondition condition)
    throws ApplicationException ;

}
