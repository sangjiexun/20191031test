/*
 * $Id: ShikutyosonClientSettingInfoServiceImpl.java 4809 2014-01-10 06:49:08Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/27     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingDao;
import net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingParamBean;
import net.chintai.backend.sysadmin.dataoutput.domain.MstCityDomain;
import net.chintai.backend.sysadmin.dataoutput.domain.ShikutyosonClientSettingDomain;
import net.chintai.backend.sysadmin.dataoutput.service.ShikutyosonClientSettingInfoService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstCityOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoOutServiceBean;


/**
 * ShikutyosonClientSettingInfoServiceの実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4809 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonClientSettingInfoServiceImpl implements ShikutyosonClientSettingInfoService{

    private ShikutyosonClientSettingDao shikutyosonClientSettingDao;

    public void setShikutyosonClientSettingDao(ShikutyosonClientSettingDao shikutyosonClientSettingDao){
        this.shikutyosonClientSettingDao = shikutyosonClientSettingDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.ShikutyosonClientSettingInfoService#getShikutyosonClienSettingInfoList(net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoInServiceBean)
     */
    public List<ShikutyosonClientSettingInfoOutServiceBean> getShikutyosonClienSettingInfoList(
            ShikutyosonClientSettingInfoInServiceBean inServiceBean) {
        List<ShikutyosonClientSettingInfoOutServiceBean> resultList = new ArrayList<ShikutyosonClientSettingInfoOutServiceBean>();
        ShikutyosonClientSettingParamBean paramBean = new ShikutyosonClientSettingParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inServiceBean);

        List<ShikutyosonClientSettingDomain> ekiClientList = shikutyosonClientSettingDao.getShikutyosonClientSettingList(paramBean);

        // 市区町村別データ元出力設定の検索結果リスト分繰り返し、返却用のリストを作成する
        for (ShikutyosonClientSettingDomain domain : ekiClientList){
            ShikutyosonClientSettingInfoOutServiceBean outBean = new ShikutyosonClientSettingInfoOutServiceBean();
            BeanUtilsWrapper.copyProperties(outBean, domain);
            resultList.add(outBean);
        }
        return resultList;

    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.ShikutyosonClientSettingInfoService#getMstCityList(net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoInServiceBean)
     */
    public List<MstCityOutBean> getMstCityList(
            ShikutyosonClientSettingInfoInServiceBean inServiceBean) {
        List<MstCityOutBean> resultList = new ArrayList<MstCityOutBean>();
        ShikutyosonClientSettingParamBean paramBean = new ShikutyosonClientSettingParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inServiceBean);

        List<MstCityDomain> mstCityList = shikutyosonClientSettingDao.getMstCityList(paramBean);

        // MST_CITYの検索結果リスト分繰り返し、返却用のリストを作成する
        for (MstCityDomain domain : mstCityList){
            MstCityOutBean outBean = new MstCityOutBean();
            BeanUtilsWrapper.copyProperties(outBean, domain);
            resultList.add(outBean);
        }
        return resultList;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.ShikutyosonClientSettingInfoService#getPrefClientTypeList(net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoInServiceBean)
     */
    public List<String> getPrefClientTypeList(
            ShikutyosonClientSettingInfoInServiceBean inServiceBean) {
        ShikutyosonClientSettingParamBean paramBean = new ShikutyosonClientSettingParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inServiceBean);

        List<String> prefClientList = shikutyosonClientSettingDao.getPrefClinetList(paramBean);
        return prefClientList;
    }

}
