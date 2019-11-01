/*
 * $Id: AspShopInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspGroupInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.AspShopInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoAndAspInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoInServiceBean;
import net.chintai.batch.common.util.CryptUtils;

import org.apache.commons.beanutils.BeanUtils;

/**
 * AspShopInfoServiceの実装クラス
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspShopInfoServiceImpl implements AspShopInfoService {

    /** 検索条件付加項目1のコード名 */
    private static final String C_SEARCH_ITEM_CODE_0 = "0";

    /** 検索条件付加項目2のコード名 */
    private static final String C_SEARCH_ITEM_CODE_1 = "1";

    /** 不動産ASPの店舗情報DAO */
    private AspShopInfoDao aspShopInfoDao = null;

    /**
     * 不動産ASPの店舗情報DAOを設定する
     * @param aspShopInfoDao
     */
    public void setAspShopInfoDao(AspShopInfoDao aspShopInfoDao) {
        this.aspShopInfoDao = aspShopInfoDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.AspShopInfoService#bukkenInfo(net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoInService)
     */
    @SuppressWarnings("unchecked")
    public AspShopInfoAndAspInfoOutServiceBean aspShopInfoSearchByShopCd(
            AspShopInfoInServiceBean inServiceBean) throws Exception {

        // 店舗コードをParamBeanに設定
        AspShopInfoParamBean paramBean = new AspShopInfoParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // 取得した店舗情報をOutServiceBeanに設定
        AspShopInfoAndAspInfoOutServiceBean outServiceBean =
                new AspShopInfoAndAspInfoOutServiceBean();

        // 不動産ASP情報を取得
        AspInfo rsAspRegisteredInfo = (AspInfo) aspShopInfoDao.selectAspRegisteredInfo(paramBean);

        // 取得した不動産ASP情報をOutServiceBeanに設定
        if (rsAspRegisteredInfo != null) {
            BeanUtils.copyProperties(outServiceBean, rsAspRegisteredInfo);

            // 検索条件付加項目をOutServiceBeanに設定
            String searchItemResult = null;
            String searchItem1 = rsAspRegisteredInfo.getSearchItem1();
            String searchItem2 = rsAspRegisteredInfo.getSearchItem2();

            if (C_SEARCH_ITEM_CODE_0.equals(searchItem1)
                    && C_SEARCH_ITEM_CODE_0.equals(searchItem2)) {
                searchItemResult = "0";
            } else if (C_SEARCH_ITEM_CODE_1.equals(searchItem1)
                    && C_SEARCH_ITEM_CODE_0.equals(searchItem2)) {
                searchItemResult = "1";
            } else if (C_SEARCH_ITEM_CODE_1.equals(searchItem1)
                    && C_SEARCH_ITEM_CODE_1.equals(searchItem2)) {
                searchItemResult = "2";
            } else if (C_SEARCH_ITEM_CODE_0.equals(searchItem1)
                    && (C_SEARCH_ITEM_CODE_1.equals(searchItem2))) {
                searchItemResult = "3";
            }

            outServiceBean.setSearchItem(searchItemResult);

            // 沿線タイプ1,2,3,4を設定
            List<AspShopInfoAndAspInfoOutServiceBean.EnsenTypeListDetailView> ensenTypeList =
                    new ArrayList<AspShopInfoAndAspInfoOutServiceBean.EnsenTypeListDetailView>();

            AspShopInfoAndAspInfoOutServiceBean aspInfo = new AspShopInfoAndAspInfoOutServiceBean();
            AspShopInfoAndAspInfoOutServiceBean.EnsenTypeListDetailView ensenDetailInfo = null;

            ensenDetailInfo = aspInfo.new EnsenTypeListDetailView();
            ensenDetailInfo.setEnsenCd(rsAspRegisteredInfo.getEnsenType1());
            ensenTypeList.add(ensenDetailInfo);

            ensenDetailInfo = aspInfo.new EnsenTypeListDetailView();
            ensenDetailInfo.setEnsenCd(rsAspRegisteredInfo.getEnsenType2());
            ensenTypeList.add(ensenDetailInfo);

            ensenDetailInfo = aspInfo.new EnsenTypeListDetailView();
            ensenDetailInfo.setEnsenCd(rsAspRegisteredInfo.getEnsenType3());
            ensenTypeList.add(ensenDetailInfo);

            outServiceBean.setEnsenTypeList(ensenTypeList);
        }

        // 不動産ASPのエリア情報を取得
        List<AspPrefInfo> rsAspAreaRegisteredList =
                aspShopInfoDao.selectAspAreaRegisteredInfo(paramBean);

        // 取得した不動産ASPのエリア情報をOutServiceBeanに設定
        if (rsAspAreaRegisteredList.size() != 0) {
            // 都道府県整列
            for (int i = 0; i < rsAspAreaRegisteredList.size(); i++) {
                int currentPrefSortKey =
                        Integer
                                .valueOf(((AspPrefInfo) rsAspAreaRegisteredList.get(i))
                                        .getSortKey());

                for (int k = i; k < rsAspAreaRegisteredList.size(); k++) {
                    int nextPrefSortKey =
                            Integer.valueOf(((AspPrefInfo) rsAspAreaRegisteredList.get(k))
                                    .getSortKey());

                    if (currentPrefSortKey > nextPrefSortKey) {
                        AspPrefInfo aspPrefInfoTmp = (AspPrefInfo) rsAspAreaRegisteredList.get(i);
                        rsAspAreaRegisteredList
                                .set(i, (AspPrefInfo) rsAspAreaRegisteredList.get(k));
                        rsAspAreaRegisteredList.set(k, aspPrefInfoTmp);

                        currentPrefSortKey =
                                Integer.valueOf(((AspPrefInfo) rsAspAreaRegisteredList.get(i))
                                        .getSortKey());
                    }
                }
            }

            // 整列済みのエリアをOutServiceBeanに設定。
            List<AspShopInfoAndAspInfoOutServiceBean.PrefListDetailView> prefListDetailViewList =
                    new ArrayList<AspShopInfoAndAspInfoOutServiceBean.PrefListDetailView>();

            for (int i = 0; i < rsAspAreaRegisteredList.size(); i++) {
                AspPrefInfo aspPrefInfo = rsAspAreaRegisteredList.get(i);
                AspShopInfoAndAspInfoOutServiceBean.PrefListDetailView prefListDetailView =
                        outServiceBean.new PrefListDetailView();

                BeanUtils.copyProperties(prefListDetailView, aspPrefInfo);
                prefListDetailView.setPrefSortKey(aspPrefInfo.getSortKey());

                prefListDetailViewList.add(prefListDetailView);
            }

            outServiceBean.setPrefList(prefListDetailViewList);
        }

        // 店舗情報を取得及び設定
        Object rsAspShopInfo = aspShopInfoDao.selectAspShopInfo(paramBean);
        BeanUtils.copyProperties(outServiceBean, rsAspShopInfo);

        // 暗号化複合化
        outServiceBean.setPassword(CryptUtils.decypt(outServiceBean.getPassword()));

        return outServiceBean;

    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.AspShopInfoService#AspGroupList(net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoInService)
     */
    public List<AspGroupInfoOutServiceBean> aspGroupList(AspShopInfoInServiceBean inServiceBean)
            throws ApplicationException {

        String shopCd = inServiceBean.getShopCd();

        List<AspGroupInfo> groupList = aspShopInfoDao.selectAspGroupList(shopCd);

        List<AspGroupInfoOutServiceBean> outList = new ArrayList<AspGroupInfoOutServiceBean>();

        if (groupList.size() > 0) {
            for (int i = 0; i < groupList.size(); i++) {
                AspGroupInfoOutServiceBean groupOutBean = new AspGroupInfoOutServiceBean();
                try {
                    BeanUtils.copyProperties(groupOutBean, groupList.get(i));
                    outList.add(groupOutBean);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return outList;
    }
}
