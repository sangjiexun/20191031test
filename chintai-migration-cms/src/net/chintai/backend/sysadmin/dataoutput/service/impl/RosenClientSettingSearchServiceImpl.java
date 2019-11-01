/*
 * $Id: RosenClientSettingSearchServiceImpl.java 4808 2014-01-10 06:33:03Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/31     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.dataoutput.dao.RosenClientSettingParamBean;
import net.chintai.backend.sysadmin.dataoutput.dao.RosenClientSettingSearchDao;
import net.chintai.backend.sysadmin.dataoutput.domain.MstEnsenDomain;
import net.chintai.backend.sysadmin.dataoutput.domain.RosenClientSettingDomain;
import net.chintai.backend.sysadmin.dataoutput.service.RosenClientSettingSearchService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstEnsenOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingSearchInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingSearchOutServiceBean;


/**
 * RosenClientSettingSearchService実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4808 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenClientSettingSearchServiceImpl implements RosenClientSettingSearchService{

    private RosenClientSettingSearchDao rosenClientSettingSearchDao;

    public void setRosenClientSettingSearchDao(RosenClientSettingSearchDao rosenClientSettingSearchDao){
        this.rosenClientSettingSearchDao = rosenClientSettingSearchDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.RosenOutSettingInfoService#getRosenOutSetingList(net.chintai.backend.sysadmin.dataoutput.service.bean.RosenOutSettingInfoInServiceBean)
     */
    public List<RosenClientSettingSearchOutServiceBean> getRosenOutSetingList(
            RosenClientSettingSearchInServiceBean inServiceBean) {
        List<RosenClientSettingSearchOutServiceBean> resultList = new ArrayList<RosenClientSettingSearchOutServiceBean>();
        RosenClientSettingParamBean paramBean = new RosenClientSettingParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inServiceBean);

        List<RosenClientSettingDomain> rosenClientList = rosenClientSettingSearchDao.getRosenOutSettingList(paramBean);

        // 沿線別データ元出力設定検索結果リスト分繰り返し、返却用のリストを作成する
        for (RosenClientSettingDomain domain : rosenClientList){
            RosenClientSettingSearchOutServiceBean outBean = new RosenClientSettingSearchOutServiceBean();
            BeanUtilsWrapper.copyProperties(outBean, domain);
            resultList.add(outBean);
        }
        return resultList;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.RosenClientSettingSearchService#getMstEnsen(net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingSearchInServiceBean)
     */
    public List<MstEnsenOutBean> getMstEnsen(RosenClientSettingSearchInServiceBean inServiceBean) {
        List<MstEnsenOutBean> resultList = new ArrayList<MstEnsenOutBean>();
        RosenClientSettingParamBean paramBean = new RosenClientSettingParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inServiceBean);

        List<MstEnsenDomain> mstEnsenList = rosenClientSettingSearchDao.getMstEnsenList(paramBean);

        // MST_ENSENの検索結果リスト分繰り返し、返却用のリストを作成する
        for (MstEnsenDomain domain : mstEnsenList){
            MstEnsenOutBean outBean = new MstEnsenOutBean();
            BeanUtilsWrapper.copyProperties(outBean, domain);
            resultList.add(outBean);
        }
        return resultList;
    }

}
