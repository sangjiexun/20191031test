/*
 * $Id: ShopBindSearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.dao.ShopBindSearchDao;
import net.chintai.backend.sysadmin.demand.dao.ShopBindSearchParamBean;
import net.chintai.backend.sysadmin.demand.domain.ShopBindSearchDomain;
import net.chintai.backend.sysadmin.demand.service.ShopBindSearchService;
import net.chintai.backend.sysadmin.demand.service.bean.ShopBindSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.ShopBindSearchOutServiceBean;


/**
 * ShopBindSearchSerivceの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBindSearchServiceImpl implements ShopBindSearchService {

    /** 店舗コード紐付検索DAO */
    private ShopBindSearchDao shopBindSearchDao;

    /**
     * 店舗コード紐付検索DAOを設定します。
     * @param shopBindSearchDao 店舗コード紐付検索DAO
     */
    public void setShopBindSearchDao(ShopBindSearchDao shopBindSearchDao) {
        this.shopBindSearchDao = shopBindSearchDao;
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.ShopBindSearchService#getShopInfo(net.chintai.backend.sysadmin.demand.service.bean.ShopBindSearchInServiceBean, net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    public List<ShopBindSearchOutServiceBean> getShopInfo(ShopBindSearchInServiceBean inBean,
            BasePagerCondition condition) {

        // 検索条件設定
        ShopBindSearchParamBean paramBean = new ShopBindSearchParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 総件数取得＆設定
        int resultCnt = shopBindSearchDao.selectTotalCount(paramBean);
        condition.setCount(resultCnt);
        // offset が総件数より大きい場合、offset-limit を設定
        if (resultCnt <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // 検索開始
        List<ShopBindSearchDomain> rsList =
                shopBindSearchDao.selectAlertBukken(paramBean, condition);

        // 戻り値設定
        List<ShopBindSearchOutServiceBean> returnList = new ArrayList<ShopBindSearchOutServiceBean>();
        for (int i=0; i < rsList.size(); i++) {
            ShopBindSearchOutServiceBean rsBean = new ShopBindSearchOutServiceBean();
            try {
                BeanUtils.copyProperties(rsBean, rsList.get(i));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            returnList.add(rsBean);
        }

        return returnList;
    }
}
