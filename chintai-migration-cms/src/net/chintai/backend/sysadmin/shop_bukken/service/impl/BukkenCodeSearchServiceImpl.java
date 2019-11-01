/*
 * $Id: BukkenCodeSearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenCodeSearchDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenCodeSearchParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.Bukken;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenCodeSearchService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenCodeSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenListOutServiceBean;

/**
 * BukkenCodeSearchService の実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenCodeSearchServiceImpl implements BukkenCodeSearchService {

    /** 物件コード検索DAO */
    private BukkenCodeSearchDao bukkenCodeSearchDao = null;

    /**
     * 物件コード検索DAOを設定します。
     * @param bukkenCodeSearchDao 物件コード検索DAO
     */
    public void setBukkenCodeSearchDao(BukkenCodeSearchDao bukkenCodeSearchDao) {
        this.bukkenCodeSearchDao = bukkenCodeSearchDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.BukkenCodeSearchService#bukkenCodeSearch(net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenCodeSearchInServiceBean)
     */
    public List bukkenCodeSearch(BukkenCodeSearchInServiceBean inServiceBean) throws InvocationTargetException,
            IllegalAccessException {

        // 検索条件をParamBeanに設定
        BukkenCodeSearchParamBean paramBean = new BukkenCodeSearchParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        if(StringUtils.isNotEmpty(paramBean.getShopCd()) || StringUtils.isNotEmpty(paramBean.getUketukeCd())){
        	paramBean.setShopCdorUketukeCd("1");
        }

        // 検索DAOを行う
        List bukkenList = bukkenCodeSearchDao.bukkenCodeSearch(paramBean);
        List<BukkenListOutServiceBean> newList = new ArrayList<BukkenListOutServiceBean>();

        // Domainにある検索結果をOutServiceBeanに設定
        for (int i = 0; i < bukkenList.size(); i++) {
            BukkenListOutServiceBean outServiceBean = new BukkenListOutServiceBean();
            Bukken bukken = (Bukken) bukkenList.get(i);
            BeanUtils.copyProperties(outServiceBean, bukken);

            newList.add(outServiceBean);
        }
        return newList;
    }
}