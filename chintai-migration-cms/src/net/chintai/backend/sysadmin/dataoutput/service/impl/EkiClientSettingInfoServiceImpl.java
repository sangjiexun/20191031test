/*
 * $Id: EkiClientSettingInfoServiceImpl.java 4806 2014-01-10 06:19:16Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingInfoDao;
import net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingParamBean;
import net.chintai.backend.sysadmin.dataoutput.domain.EkiClientSettingDomain;
import net.chintai.backend.sysadmin.dataoutput.domain.MstEkiDomain;
import net.chintai.backend.sysadmin.dataoutput.service.EkiClientSettingInfoService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstEkiOutBean;


/**
 * EkiClientSettingInfoService実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4806 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EkiClientSettingInfoServiceImpl implements EkiClientSettingInfoService{


    private EkiClientSettingInfoDao ekiClientSettingInfoDao;

    public void setEkiClientSettingInfoDao(EkiClientSettingInfoDao ekiClientSettingInfoDao){
        this.ekiClientSettingInfoDao = ekiClientSettingInfoDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.EkiClientSettingInfoService#getEkiClienSettingInfoList(net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoInServiceBean)
     */
    public List<EkiClientSettingInfoOutServiceBean> getEkiClienSettingInfoList(EkiClientSettingInfoInServiceBean inServiceBean) {
        List<EkiClientSettingInfoOutServiceBean> resultList = new ArrayList<EkiClientSettingInfoOutServiceBean>();
        EkiClientSettingParamBean paramBean = new EkiClientSettingParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inServiceBean);

        List<EkiClientSettingDomain> ekiClientList = ekiClientSettingInfoDao.getEkiOutSettingList(paramBean);

        // 駅別データ元出力設定検索結果リスト分繰り返し、返却用のリストを作成する
        for (EkiClientSettingDomain domain : ekiClientList){
            EkiClientSettingInfoOutServiceBean outBean = new EkiClientSettingInfoOutServiceBean();
            BeanUtilsWrapper.copyProperties(outBean, domain);
            resultList.add(outBean);
        }
        return resultList;

    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.EkiClientSettingInfoService#getMstEkiList(net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoInServiceBean)
     */
    public List<MstEkiOutBean> getMstEkiList(EkiClientSettingInfoInServiceBean inServiceBean) {
        List<MstEkiOutBean> resultList = new ArrayList<MstEkiOutBean>();
        EkiClientSettingParamBean paramBean = new EkiClientSettingParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inServiceBean);

        List<MstEkiDomain> mstEkiList = ekiClientSettingInfoDao.getMstEkiList(paramBean);

        // MST_EKIの検索結果リスト分繰り返し、返却用のリストを作成する
        for (MstEkiDomain domain : mstEkiList){
            MstEkiOutBean outBean = new MstEkiOutBean();
            BeanUtilsWrapper.copyProperties(outBean, domain);
            resultList.add(outBean);
        }
        return resultList;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.EkiClientSettingInfoService#geEnsenClientTypeList(net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoInServiceBean)
     */
    public List<String> getEnsenClientTypeList(EkiClientSettingInfoInServiceBean inServiceBean) {
        EkiClientSettingParamBean paramBean = new EkiClientSettingParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inServiceBean);

        List<String> ensenClientList = ekiClientSettingInfoDao.getEnsenClientList(paramBean);

        return ensenClientList;
    }
}
