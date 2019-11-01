/*
 * $Id: ShopSearchByAreaService.java 3834 2008-02-27 04:08:43Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchOutServiceBean;


/**
 * 店舗検索(地域から検索)を提供するサービスクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3834 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopSearchByAreaService {

    /**
     * 地域から検索
     * @param inServiceBean 検索条件
     * @return 検索結果(店舗リスト)
     */
    public List<ShopSearchOutServiceBean> shopSearchByArea(ShopSearchInServiceBean inServiceBean, BasePagerCondition condition);
}
