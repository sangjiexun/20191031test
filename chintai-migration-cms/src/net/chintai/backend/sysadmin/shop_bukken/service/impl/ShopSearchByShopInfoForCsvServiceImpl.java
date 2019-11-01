/*
 * $Id: ShopSearchByShopInfoForCsvServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/05  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopSearchInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopSearchByShopInfoForCsvService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;


/**
 * ShopSearchByShopInfoForCsvServiceの実装クラス
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSearchByShopInfoForCsvServiceImpl implements ShopSearchByShopInfoForCsvService {

    /** 店舗検索DAO */
    private ShopSearchDao shopSearchDao = null;

    /**
     * shopSearchDaoを設定する
     * @param shopSearchDao
     */
    public void setShopSearchDao(ShopSearchDao shopSearchDao) {
        this.shopSearchDao = shopSearchDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopSearchByShopInfoForCsvService#shopSearchByShopInfoForCsv(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchInServiceBean)
     */
    public List<ShopSearchOutServiceBean> shopSearchByShopInfoForCsv(ShopSearchInServiceBean inServiceBean) throws Exception {

        // 検索条件データを取得
        ShopSearchParamBean paramBean = new ShopSearchParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);
        
        // kewordList設定
        String keyword = inServiceBean.getCompanyBumonName();
        String[] keywords = keyword.split(" ");
        List<String> keywordList = new ArrayList<String>();
        for (int i = 0; i < keywords.length; i++) {
            keywordList.add(keywords[i]);
        }
        paramBean.setKeywordList(keywordList);
        
        // 店舗情報から検索
        List rsList = shopSearchDao.selectShopSearchByShopInfoForCsv(paramBean);
        List<ShopSearchOutServiceBean> shopSearchList = new ArrayList<ShopSearchOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            ShopSearchInfo shopInfo = (ShopSearchInfo) rsList.get(i);

            ShopSearchOutServiceBean shopOutServiceBean = new ShopSearchOutServiceBean();
            BeanUtils.copyProperties(shopOutServiceBean, shopInfo);

            shopSearchList.add(shopOutServiceBean);
        }

        return shopSearchList;

    }

}
