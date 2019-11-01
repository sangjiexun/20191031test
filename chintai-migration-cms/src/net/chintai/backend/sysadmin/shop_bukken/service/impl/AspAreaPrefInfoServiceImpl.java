/*
 * $Id: AspAreaPrefInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspAreaPrefInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspAreaPrefInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.AspAreaPrefInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspAreaPrefInfoOutServiceBean;

/**
 * AspAreaPrefInfoServiceの実装クラス
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspAreaPrefInfoServiceImpl implements AspAreaPrefInfoService {

    /** 不動産ASPの店舗情報DAO */
    private AspAreaPrefInfoDao aspAreaPrefInfoDao = null;

    /**
     * 不動産ASPの店舗情報DAOを設定する
     * @param aspAreaPrefInfoDao 不動産ASPの店舗情報DAO
     */
    public void setAspAreaPrefInfoDao(AspAreaPrefInfoDao aspAreaPrefInfoDao) {
        this.aspAreaPrefInfoDao = aspAreaPrefInfoDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.AspAreaPrefInfoService#aspAreaPrefInfoSearch()
     */
    public List<AspAreaPrefInfoOutServiceBean> aspAreaPrefInfoSearch() throws Exception {

        // 不動産ASPの店舗情報を取得
        List rsAspShopInfo = aspAreaPrefInfoDao.selectAspAreaPrefInfo();

        List<AspAreaPrefInfoOutServiceBean> areaPrefOutServiceBeanList =
                new ArrayList<AspAreaPrefInfoOutServiceBean>();

        AspAreaPrefInfoOutServiceBean areaPrefInfo = null;
        AspAreaPrefInfoOutServiceBean.AspAreaPrefInfoOutServiceDetailBean areaPrefDeatilInfo = null;
        List<AspAreaPrefInfoOutServiceBean.AspAreaPrefInfoOutServiceDetailBean> areaPrefList = null;

        String preAreaCd = "";
        int indexCount = 0;
        int indexMaxCount = 0;

        // Daoから取得したダータをOutServiceBeanListに設定
        for (int i = 0; i < rsAspShopInfo.size(); i++) {
            AspAreaPrefInfo rsAspAreaPrefInfo = (AspAreaPrefInfo) rsAspShopInfo.get(i);

            if (!preAreaCd.equals(rsAspAreaPrefInfo.getAreaCd())) {
                areaPrefList =
                        new ArrayList<AspAreaPrefInfoOutServiceBean.AspAreaPrefInfoOutServiceDetailBean>();
                areaPrefInfo = new AspAreaPrefInfoOutServiceBean();
                areaPrefInfo.setAreaCd(rsAspAreaPrefInfo.getAreaCd());
                areaPrefInfo.setAreaName(rsAspAreaPrefInfo.getAreaName());

                areaPrefInfo.setPrefList(areaPrefList);
                areaPrefOutServiceBeanList.add(areaPrefInfo);
            }
            areaPrefDeatilInfo = areaPrefInfo.new AspAreaPrefInfoOutServiceDetailBean();

            areaPrefDeatilInfo.setPrefCd(rsAspAreaPrefInfo.getPrefCd());
            areaPrefDeatilInfo.setPrefName(rsAspAreaPrefInfo.getPrefName());
            areaPrefDeatilInfo.setPrefCodeName(rsAspAreaPrefInfo.getPrefCodeName());
            areaPrefList.add(areaPrefDeatilInfo);
            
            if (preAreaCd.equals(rsAspAreaPrefInfo.getAreaCd())) {
                indexCount = indexCount + 1;
            }else{
                if(indexCount>indexMaxCount){
                    indexMaxCount = indexCount;
                }
                indexCount = 0;
            }
            
            preAreaCd = rsAspAreaPrefInfo.getAreaCd();
        }
        
        return areaPrefOutServiceBeanList;

    }

}
