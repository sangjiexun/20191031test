/*
 * $Id: EkiClientSettingCommitServiceImpl.java 4806 2014-01-10 06:19:16Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/20     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingCommitDao;
import net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingCommitParamBean;
import net.chintai.backend.sysadmin.dataoutput.service.EkiClientSettingCommitService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingCommitInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSystemCommitListBean;


/**
 * EkiClientSettingCommitService実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4806 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EkiClientSettingCommitServiceImpl implements EkiClientSettingCommitService{

    private EkiClientSettingCommitDao ekiClientSettingCommitDao;

    public void setEkiClientSettingCommitDao(EkiClientSettingCommitDao ekiClientSettingCommitDao){
        this.ekiClientSettingCommitDao = ekiClientSettingCommitDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.EkiClientSettingCommitService#ekiClientUpdateCommit(net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingCommitInServiceBean)
     */
    public void ekiClientSettingCommit(EkiClientSettingCommitInServiceBean inServiceBean) {
        List<EkiClientSettingCommitParamBean> insertParamBean = new ArrayList<EkiClientSettingCommitParamBean>();

        List<EkiClientSystemCommitListBean> commitList = inServiceBean.getCommitList();

        // Actionで作成した、Insert用のリスト分繰り返す
        for (EkiClientSystemCommitListBean inBean : commitList){
            // Insert用ParamBean作成
            EkiClientSettingCommitParamBean paramBean = new EkiClientSettingCommitParamBean();
            BeanUtilsWrapper.copyProperties(paramBean, inBean);
            insertParamBean.add(paramBean);
        }

        // Delete用のParamBeanにdcoType設定
        EkiClientSettingCommitParamBean deleteParamBean = new EkiClientSettingCommitParamBean();
        deleteParamBean.setDcoType(inServiceBean.getDcoType());
        deleteParamBean.setEnsenCd(inServiceBean.getEnsenCd());

        ekiClientSettingCommitDao.deleteEkiSkipConfig(deleteParamBean);

        ekiClientSettingCommitDao.insertEkiSkipConfig(insertParamBean);

        // 親データ(沿線)削除用文字列がある場合、親データ(沿線)削除処理をする
        if (StringUtils.isNotEmpty(inServiceBean.getParentalType())){
            deleteParamBean.setParentalType(inServiceBean.getParentalType());

            ekiClientSettingCommitDao.deleteEnsenSkipConfig(deleteParamBean);
        }

    }

}
