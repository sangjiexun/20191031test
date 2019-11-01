/*
 * $Id: PrefClientSettingServiceImpl.java 4807 2014-01-10 06:23:54Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/23     BGT)亀田       E-0070 建物名表示に関する改修
 * 2014/01/07     BGT)亀田       E-0053_スマイティ用データ抽出　市区・駅対応
 */
package net.chintai.backend.sysadmin.dataoutput.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.dataoutput.dao.PrefClientSettingDao;
import net.chintai.backend.sysadmin.dataoutput.dao.PrefClientSettingParamBean;
import net.chintai.backend.sysadmin.dataoutput.domain.MstPrefDomain;
import net.chintai.backend.sysadmin.dataoutput.domain.PrefClientDataDomain;
import net.chintai.backend.sysadmin.dataoutput.service.PrefClientSettingService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstPrefOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.PrefClientDataOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.PrefClientSettingInServiceBean;


/**
 * PrefClientSettingServiceの実装クラス
 * @author e-ishii
 * @version $Revision: 4807 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientSettingServiceImpl implements PrefClientSettingService{


	/** データ元別出力設定情報取得Dao */
	private PrefClientSettingDao prefClientSettingDao;


    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.PrefClientSettingService#getPrefClientDataList()
     */
    public List<PrefClientDataOutServiceBean> getPrefClientDataList(PrefClientSettingInServiceBean inServiceBean) {

        List<PrefClientDataOutServiceBean> resultList = new  ArrayList<PrefClientDataOutServiceBean>();
        // 検索条件用のparamBeanを設定 2013/10/24 追加
        PrefClientSettingParamBean paramBean = new PrefClientSettingParamBean();
        paramBean.setDcoType(inServiceBean.getDcoType());
        // daoメソッドの呼び出し引数に検索条件用のparamBeanを設定 2013/10/24 追加
        List<PrefClientDataDomain> prefClientDataList = prefClientSettingDao.getPrefClientDataList(paramBean);

        for (PrefClientDataDomain domain : prefClientDataList) {
            PrefClientDataOutServiceBean outBean = new PrefClientDataOutServiceBean();
            BeanUtilsWrapper.copyProperties(outBean, domain);
            resultList.add(outBean);
        }
        return resultList;

    }

    /**
     * prefClientSettingDaoを設定します。
     * @param prefClientSettingDao prefClientSettingDao
     */
    public void setPrefClientSettingDao(PrefClientSettingDao prefClientSettingDao) {
        this.prefClientSettingDao = prefClientSettingDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.PrefClientSettingService#getMstPref()
     */
    public List<MstPrefOutBean> getMstPref(PrefClientSettingInServiceBean inServiceBean) {

        List<MstPrefOutBean> resultList = new ArrayList<MstPrefOutBean>();

        // 検索条件を追加　2014/1/7
        PrefClientSettingParamBean paramBean = new PrefClientSettingParamBean();
        paramBean.setDcoType(inServiceBean.getDcoType());

        List<MstPrefDomain> mstPrefList = prefClientSettingDao.getMstPref(paramBean);

        for (MstPrefDomain domain : mstPrefList) {
            MstPrefOutBean bean = new MstPrefOutBean();
            BeanUtilsWrapper.copyProperties(bean, domain);
            resultList.add(bean);

        }
        return resultList;
    }





}
