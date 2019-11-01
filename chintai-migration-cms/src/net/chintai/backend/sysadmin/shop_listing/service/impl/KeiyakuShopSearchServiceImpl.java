/*
 * $Id: KeiyakuShopSearchServiceImpl.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/19     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopSearchDao;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopSearchParamBean;
import net.chintai.backend.sysadmin.shop_listing.domain.KeiyakuShopSearchDomain;
import net.chintai.backend.sysadmin.shop_listing.service.KeiyakuShopSearchService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuShopSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuShopSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

/**
 * KeiyakuShopSearchServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuShopSearchServiceImpl implements KeiyakuShopSearchService {

    /** 契約店舗検索DAO */
    private KeiyakuShopSearchDao keiyakuShopSearchDao;

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.service.KeiyakuShopSearchService
     * # searchShopList(net.chintai.backend.sysadmin.shop_listing.service.bean.
     * KeiyakuShopSearchInServiceBean,
     * net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    public List<KeiyakuShopSearchOutServiceBean> searchShopList(
            KeiyakuShopSearchInServiceBean inBean, BasePagerCondition condition) {

        // paramBean設定
        KeiyakuShopSearchParamBean paramBean = new KeiyakuShopSearchParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 基本契約検索条件を編集
        if (StringUtils.isNotEmpty(paramBean.getKeiyaku())
                && StringUtils.isNotEmpty(paramBean.getMikeiyaku())
                && StringUtils.isNotEmpty(paramBean.getKigengire())) {
            // 全てチェックされている場合、条件を指定しない
            paramBean.setKeiyaku(null);
            paramBean.setMikeiyaku(null);
            paramBean.setKigengire(null);
        }

        if (condition.getLimit() > 0) { // 以下出力先が画面の場合の処理
            // ページング処理のため総件数取得
            int totalCnt = keiyakuShopSearchDao.searchTotalCnt(paramBean);
            condition.setCount(totalCnt);

            // offset が総件数より大きい場合、offset-limit を設定
            if (totalCnt <= condition.getOffset()) {
                condition.setOffset(condition.getOffset() - condition.getLimit());
            }
        }

        // 契約店舗検索を行う
        List<KeiyakuShopSearchDomain> rsList =
                keiyakuShopSearchDao.searchShopList(paramBean, condition);

        // 戻り値格納用
        List<KeiyakuShopSearchOutServiceBean> returnList =
                new ArrayList<KeiyakuShopSearchOutServiceBean>();

        // DomainをOutServiceBeanに詰め替えてリターン
        for (KeiyakuShopSearchDomain domain : rsList) {
            KeiyakuShopSearchOutServiceBean outBean = new KeiyakuShopSearchOutServiceBean();
            try {
                BeanUtils.copyProperties(outBean, domain);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            returnList.add(outBean);
        }

        return returnList;
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.service.KeiyakuShopSearchService
     * #searchSysdate()
     */
    public Date searchSysdate() {
        return keiyakuShopSearchDao.searchSysdate();
    }

    /**
     * 契約店舗検索DAOを設定します。
     * @param keiyakuShopSearchDao 契約店舗検索DAO
     */
    public void setKeiyakuShopSearchDao(KeiyakuShopSearchDao keiyakuShopSearchDao) {
        this.keiyakuShopSearchDao = keiyakuShopSearchDao;
    }

}
