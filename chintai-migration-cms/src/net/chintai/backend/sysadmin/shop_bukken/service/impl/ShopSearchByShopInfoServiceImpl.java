/*
 * $Id: ShopSearchByShopInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchParamBean.KeiyakuKey;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopSearchInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopSearchByShopInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.CollectionUtils;

/**
 * ShopSearchByShopInfoServiceの実装クラス
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSearchByShopInfoServiceImpl implements ShopSearchByShopInfoService {

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
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopSearchByShopInfoService#shopSearchByShopInfo(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchInServiceBean)
     */
    public List<ShopSearchOutServiceBean> shopSearchByShopInfo(ShopSearchInServiceBean inServiceBean,
            BasePagerCondition condition) throws ApplicationException {

        // 検索条件データを取得
        ShopSearchParamBean paramBean = new ShopSearchParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // kewordList設定
        String keyword = inServiceBean.getCompanyBumonName();
        String[] keywords = keyword.split(" ");
        List<String> keywordList = new ArrayList<String>();
        for (int i = 0; i < keywords.length; i++) {
            keywordList.add(keywords[i]);
        }
        paramBean.setKeywordList(keywordList);

        if(!CollectionUtils.isEmpty(inServiceBean.getShopKeiyakus())){
        	Map<ShopSearchParamBean.KeiyakuKey,String> m = new HashMap<>(inServiceBean.getShopKeiyakus().size());
        	for(Map.Entry<String, String> e : inServiceBean.getShopKeiyakus().entrySet()){
        		KeiyakuKey key = new KeiyakuKey();
        		String[] s = e.getKey().split("\\|");
        		String keiyakuCd = s[0];
        		String keiyakuSubCd = s[1];
        		key.setKeiyakuCd(keiyakuCd);
				key.setKeiyakuSubCd(keiyakuSubCd);
				m.put(key , e.getValue());
        	}
        	paramBean.setShopKeiyakusEntries(new ArrayList<>(m.entrySet()));
        }

        // 店舗情報から検索の結果件数
        int resultCount = shopSearchDao.selectShopSearchByShopInfoCount(paramBean);
        condition.setCount(resultCount);

        // offset が総件数より大きい場合、offset-limit を設定
        if (resultCount <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // 店舗情報から検索
        List rsList = shopSearchDao.selectShopSearchByShopInfo(paramBean, condition);
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
