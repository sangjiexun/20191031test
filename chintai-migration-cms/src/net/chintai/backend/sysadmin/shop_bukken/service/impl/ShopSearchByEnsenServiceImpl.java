/*
 * $Id: ShopSearchByEnsenServiceImpl.java 3835 2008-02-27 04:09:23Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopSearchInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopSearchByEnsenService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ShopSearchByEnsenServiceの実装クラス
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3835 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSearchByEnsenServiceImpl implements ShopSearchByEnsenService {

    /** 店舗検索DAO */
    private ShopSearchDao shopSearchDao = null;

    /**
     * shopSearchDaoを設定する
     * @param shopSearchDao
     */
    public void setShopSearchDao(ShopSearchDao shopSearchDao) {
        this.shopSearchDao = shopSearchDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopSearchByEnsenService#shopSearchByEnsen(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchInServiceBean)
     */
    public List<ShopSearchOutServiceBean> shopSearchByEnsen(ShopSearchInServiceBean inServiceBean, BasePagerCondition condition) {

        // 検索条件データを取得
        ShopSearchParamBean paramBean = new ShopSearchParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 店舗情報から検索の結果件数
        int resultCount = shopSearchDao.selectShopSearchByEnsenCount(paramBean);
        condition.setCount(resultCount);

        // offset が総件数より大きい場合、offset-limit を設定
        if (resultCount <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // 線路から検索
        List rsList = shopSearchDao.selectShopSearchByEnsen(paramBean, condition);
        List<ShopSearchOutServiceBean> shopSearchList = new ArrayList<ShopSearchOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            ShopSearchInfo shopInfo = (ShopSearchInfo) rsList.get(i);

            ShopSearchOutServiceBean shopOutServiceBean = new ShopSearchOutServiceBean();
            try {
                BeanUtils.copyProperties(shopOutServiceBean, shopInfo);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            shopSearchList.add(shopOutServiceBean);
        }

        return shopSearchList;
    }

}
