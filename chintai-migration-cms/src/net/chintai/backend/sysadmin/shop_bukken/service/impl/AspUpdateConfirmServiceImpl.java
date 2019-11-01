/*
 * $Id: AspUpdateConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.Map.Entry;

import net.chintai.backend.sysadmin.shop_bukken.domain.AspEnsenTypeInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.AspUpdateConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateConfirmOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * AspUpdateConfirmServiceの実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspUpdateConfirmServiceImpl implements AspUpdateConfirmService {

    /** 不動産ASP設定の都道府県のリクエストパラメータ名 */
    private static final String C_PREF_PARAM = "pref";

    /** 不動産ASP設定の沿線タイプのリクエストパラメータ名 */
    private static final String C_ENSEN_TYPE_PARAM = "ensenCd";

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.AspUpdateConfirmService#aspAreaEnsenCheck(net.chintai.backend.sysadmin.shop_bukken.service.bean.AspAddConfirmInServiceBean)
     */
    public AspUpdateConfirmOutServiceBean aspAreaEnsenCheck(
            AspUpdateConfirmInServiceBean inServiceBean) throws Exception {

        // 登録された不動産ASP設定情報を取得
        SortedMap<String, String[]> sortedMap = inServiceBean.getSortedMap();

        // 都道府県リストを取得
        List prefList = inServiceBean.getPrefList();

        // 都道府県マップ
        Map<String, AspPrefInfo> prefMap = new HashMap<String, AspPrefInfo>();

        // 登録されたエリア設定情報
        AspPrefInfo aspPrefInfo = null;

        // 登録された沿線タイプ設定情報
        AspEnsenTypeInfo aspEnsenTypeInfo = null;

        // 都道府県のリスト
        List<AspPrefInfo> aspPrefInfoList = new ArrayList<AspPrefInfo>();

        // 沿線タイプのリスト
        List<AspEnsenTypeInfo> aspEnsenTypeInfoList = new ArrayList<AspEnsenTypeInfo>();

        // 都道府県マップを生成
        for (int i = 0; i < prefList.size(); i++) {
            // AspAreaPrefInfo
            AspPrefInfo asprefInfo = (AspPrefInfo) prefList.get(i);
            prefMap.put(asprefInfo.getPrefCd(), asprefInfo);
        }

        // requestから都道府県、沿線タイプを区別して、リスト化する。
        Iterator it = sortedMap.entrySet().iterator();
        Entry entry = null;
        String key = null;
        while (it.hasNext()) {
            entry = (Entry) it.next();
            key = (String) entry.getKey();

            if (key.length() == 6) {
                if (C_PREF_PARAM.equals(key.substring(0, 4))) {
                    String prefCode = key.substring(4, 6);
                    String prefName = prefMap.get(prefCode).getPrefName();
                    String prefSortKey = sortedMap.get(key)[0];

                    if (prefSortKey != null && prefSortKey.length() > 0) {
                        aspPrefInfo = new AspPrefInfo();

                        aspPrefInfo.setPrefCd(prefCode);
                        aspPrefInfo.setPrefName(prefName);
                        aspPrefInfo.setSortKey(prefSortKey);

                        aspPrefInfoList.add(aspPrefInfo);
                    }
                }
            }

            if (key.length() == 8) {// ensenType4
                if (C_ENSEN_TYPE_PARAM.equals(key.substring(0, 7))) {
                    String ensenTypeCode = key.substring(7, 8);
                    String ensenTypeSortKey = sortedMap.get(key)[0];

                    if (ensenTypeSortKey != null && ensenTypeSortKey.length() > 0) {
                        aspEnsenTypeInfo = new AspEnsenTypeInfo();

                        aspEnsenTypeInfo.setEnsenTypeCd(ensenTypeCode);
                        aspEnsenTypeInfo.setEnsenTypeSortKey(ensenTypeSortKey);

                        aspEnsenTypeInfoList.add(aspEnsenTypeInfo);
                    }
                }
            }
        }

        // 都道府県整列
        for (int i = 0; i < aspPrefInfoList.size(); i++) {
            int currentPrefSortKey =
                    Integer.valueOf(((AspPrefInfo) aspPrefInfoList.get(i)).getSortKey());

            for (int k = i; k < aspPrefInfoList.size(); k++) {
                int nextPrefSortKey =
                        Integer.valueOf(((AspPrefInfo) aspPrefInfoList.get(k)).getSortKey());

                if (currentPrefSortKey > nextPrefSortKey) {
                    AspPrefInfo aspPrefInfoTmp = (AspPrefInfo) aspPrefInfoList.get(i);
                    aspPrefInfoList.set(i, (AspPrefInfo) aspPrefInfoList.get(k));
                    aspPrefInfoList.set(k, aspPrefInfoTmp);

                    currentPrefSortKey =
                            Integer.valueOf(((AspPrefInfo) aspPrefInfoList.get(i)).getSortKey());
                }
            }
        }

        // 沿線タイプ整列
        for (int i = 0; i < aspEnsenTypeInfoList.size(); i++) {
            int currentEnsenTypeSortKey =
                    Integer.valueOf(((AspEnsenTypeInfo) aspEnsenTypeInfoList.get(i))
                            .getEnsenTypeSortKey());

            for (int k = i; k < aspEnsenTypeInfoList.size(); k++) {
                int nextEnsenTypeSortKey =
                        Integer.valueOf(((AspEnsenTypeInfo) aspEnsenTypeInfoList.get(k))
                                .getEnsenTypeSortKey());

                if (currentEnsenTypeSortKey > nextEnsenTypeSortKey) {
                    AspEnsenTypeInfo aspEnsenTypeInfoTmp =
                            (AspEnsenTypeInfo) aspEnsenTypeInfoList.get(i);
                    aspEnsenTypeInfoList.set(i, (AspEnsenTypeInfo) aspEnsenTypeInfoList.get(k));
                    aspEnsenTypeInfoList.set(k, aspEnsenTypeInfoTmp);

                    currentEnsenTypeSortKey =
                            Integer.valueOf(((AspEnsenTypeInfo) aspEnsenTypeInfoList.get(i))
                                    .getEnsenTypeSortKey());
                }
            }
        }

        // 整列された都道府県、沿線タイプをAspUpdateConfirmOutServiceBeanに設定
        AspUpdateConfirmOutServiceBean aspUpdateConfirmOutServiceBean =
                new AspUpdateConfirmOutServiceBean();
        BeanUtils.copyProperties(aspUpdateConfirmOutServiceBean, inServiceBean);

        // 都道府県を設定。
        List<AspUpdateConfirmOutServiceBean.PrefListDetailView> prefListDetailViewList =
                new ArrayList<AspUpdateConfirmOutServiceBean.PrefListDetailView>();
        for (int i = 0; i < aspPrefInfoList.size(); i++) {
            AspPrefInfo aspPref = aspPrefInfoList.get(i);
            AspUpdateConfirmOutServiceBean.PrefListDetailView prefListDetailView =
                    aspUpdateConfirmOutServiceBean.new PrefListDetailView();
            BeanUtils.copyProperties(prefListDetailView, aspPref);
            prefListDetailView.setPrefSortKey(aspPref.getSortKey());

            prefListDetailViewList.add(prefListDetailView);
        }
        aspUpdateConfirmOutServiceBean.setPrefList(prefListDetailViewList);

        // 沿線タイプを設定。
        List<AspUpdateConfirmOutServiceBean.EnsenTypeListDetailView> ensenTypeListDetailViewList =
                new ArrayList<AspUpdateConfirmOutServiceBean.EnsenTypeListDetailView>();
        for (int i = 0; i < aspEnsenTypeInfoList.size(); i++) {
            AspEnsenTypeInfo aspEnsenType = aspEnsenTypeInfoList.get(i);
            AspUpdateConfirmOutServiceBean.EnsenTypeListDetailView ensenTypeListDetailView =
                    aspUpdateConfirmOutServiceBean.new EnsenTypeListDetailView();
            ensenTypeListDetailView.setEnsenCd(aspEnsenType.getEnsenTypeCd());
            ensenTypeListDetailView.setEnsenName(aspEnsenType.getEnsenTypeName());
            ensenTypeListDetailView.setEnsenSortKey(aspEnsenType.getEnsenTypeSortKey());

            ensenTypeListDetailViewList.add(ensenTypeListDetailView);
        }
        aspUpdateConfirmOutServiceBean.setEnsenTypeList(ensenTypeListDetailViewList);

        return aspUpdateConfirmOutServiceBean;
    }

}
