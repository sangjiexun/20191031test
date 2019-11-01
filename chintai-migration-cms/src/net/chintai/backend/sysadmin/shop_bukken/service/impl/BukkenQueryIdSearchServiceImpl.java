/*
 * $Id: BukkenQueryIdSearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
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

import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenQueryIdSearchDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenQueryIdSearchParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.Bukken;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenQueryIdSearchService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenListOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenQueryIdSearchInServiceBean;

/**
 * BukkenQueryIdSearchService の実装クラス。
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenQueryIdSearchServiceImpl implements BukkenQueryIdSearchService {

    /** 問合せ番号で検索DAO */
    private BukkenQueryIdSearchDao bukkenQueryIdSearchDao = null;

    /**
     * 問合せ番号で検索DAOを設定します。
     * @param bukkenQueryIdSearchDao 問合せ番号で検索DAO
     */
    public void setBukkenQueryIdSearchDao(BukkenQueryIdSearchDao bukkenQueryIdSearchDao) {
        this.bukkenQueryIdSearchDao = bukkenQueryIdSearchDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.BukkenQueryIdSearchService#bukkenQueryIdSearch(net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenQueryIdSearchInServiceBean)
     */
    public List bukkenQueryIdSearch(BukkenQueryIdSearchInServiceBean inServiceBean) throws InvocationTargetException,
            IllegalAccessException {

        // 検索条件をParamBeanに設定
        BukkenQueryIdSearchParamBean paramBean = new BukkenQueryIdSearchParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // 検索DAOを行う
        List bukkenList = bukkenQueryIdSearchDao.bukkenQueryIdSearch(paramBean);
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