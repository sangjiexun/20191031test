/*
 * $Id: AspUpdateForPrefServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.AspUpdateForPrefService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspAreaPrefInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateInServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * AspUpdateForPrefServiceの実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspUpdateForPrefServiceImpl implements AspUpdateForPrefService {

    /** 不動産ASPの店舗情報DAO */
    private AspUpdateDao aspUpdateDao = null;

    /**
     * 不動産ASPの店舗情報DAOを設定する
     * @param aspUpdateDao 不動産ASPの店舗情報DAO
     */
    public void setAspUpdateDao(AspUpdateDao aspUpdateDao) {
        this.aspUpdateDao = aspUpdateDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.AspUpdateForPrefService#aspAreaRegisteredInfoSearchByShopCd(java.util.List,
     *      net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateInServiceBean)
     */
    public List<AspAreaPrefInfoOutServiceBean> aspAreaRegisteredInfoSearchByShopCd(List<AspAreaPrefInfoOutServiceBean> aspAreaPrefInfoList,
            AspUpdateInServiceBean inServiceBean) throws Exception {

        // 店舗コードをParamBeanに設定
        AspShopInfoParamBean paramBean = new AspShopInfoParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // 登録された不動産ASPのエリア情報を取得
        List rsAspAreaRegisteredList = aspUpdateDao.selectAspAreaRegisteredInfo(paramBean);

        Map<String, AspPrefInfo> registeredPrefMap = new HashMap<String, AspPrefInfo>();
        for (int i = 0; i < rsAspAreaRegisteredList.size(); i++) {
            String prefCd = ((AspPrefInfo) rsAspAreaRegisteredList.get(i)).getPrefCd();

            registeredPrefMap.put(prefCd, (AspPrefInfo) rsAspAreaRegisteredList.get(i));
        }

        // 画面用不動産ASPのエリアリストに
        // 登録された不動産ASPのエリアソートキーを設定
        AspAreaPrefInfoOutServiceBean areaPrefInfo = null;
        AspAreaPrefInfoOutServiceBean.AspAreaPrefInfoOutServiceDetailBean prefInfo = null;
        List<AspAreaPrefInfoOutServiceBean.AspAreaPrefInfoOutServiceDetailBean> prefInfoList = null;

        for (int i = 0; i < aspAreaPrefInfoList.size(); i++) {
            areaPrefInfo = (AspAreaPrefInfoOutServiceBean) aspAreaPrefInfoList.get(i);
            prefInfoList = areaPrefInfo.getPrefList();

            for (int k = 0; k < prefInfoList.size(); k++) {
                prefInfo = prefInfoList.get(k);
                String prefCd = prefInfo.getPrefCd();

                if (registeredPrefMap.containsKey(prefCd)) {
                    String sortKey = ((AspPrefInfo) registeredPrefMap.get(prefCd)).getSortKey();
                    String updDt = ((AspPrefInfo) registeredPrefMap.get(prefCd)).getUpdDt();
                    prefInfo.setPrefSortKey(sortKey);
                    prefInfo.setUpdDt(updDt);
                }
            }
        }

        return aspAreaPrefInfoList;
    }

}
