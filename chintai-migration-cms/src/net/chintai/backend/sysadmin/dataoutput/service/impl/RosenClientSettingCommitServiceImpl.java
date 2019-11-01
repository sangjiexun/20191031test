/*
 * $Id: RosenClientSettingCommitServiceImpl.java 4831 2014-01-15 02:54:35Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/11/07     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.dataoutput.dao.RosenClientSettingCommitDao;
import net.chintai.backend.sysadmin.dataoutput.dao.RosenClientSettingCommitParamBean;
import net.chintai.backend.sysadmin.dataoutput.service.RosenClientSettingCommitService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingCommitInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSystemCommitListBean;


/**
 * RosenClientSettingCommitService実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4831 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenClientSettingCommitServiceImpl implements RosenClientSettingCommitService{

    /** 沿線別データ元除外設定更新用Dao */
    private RosenClientSettingCommitDao rosenClientSettingCommitDao;

    /**
     * rosenClientSettingCommitDaoの設定
     * @param rosenClientSettingCommitDao
     */
    public void setRosenClientSettingCommitDao(RosenClientSettingCommitDao rosenClientSettingCommitDao){
        this.rosenClientSettingCommitDao = rosenClientSettingCommitDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.RosenClientSettingCommitService#rosenClientUpdateCommit(net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingCommitInServiceBean)
     */
    public void rosenClientSettingCommit(RosenClientSettingCommitInServiceBean inServiceBean) {
        List<RosenClientSettingCommitParamBean> insertParamBean = new ArrayList<RosenClientSettingCommitParamBean>();

        List<RosenClientSystemCommitListBean> commitList = inServiceBean.getCommitList();

        // Actionで作成した、Insert用のリスト分繰り返す
        for (RosenClientSystemCommitListBean inBean : commitList){
            // Insert用ParamBean作成
            RosenClientSettingCommitParamBean paramBean = new RosenClientSettingCommitParamBean();
            BeanUtilsWrapper.copyProperties(paramBean, inBean);
            insertParamBean.add(paramBean);
        }

        // Delete用のParamBeanにdcoType設定
        RosenClientSettingCommitParamBean deleteParamBean = new RosenClientSettingCommitParamBean();
        deleteParamBean.setDcoType(inServiceBean.getDcoType());
        deleteParamBean.setAreaCd(inServiceBean.getAreaCd());
        deleteParamBean.setEnsenType(inServiceBean.getEnsenType());

        rosenClientSettingCommitDao.deleteEnsenSkipConfig(deleteParamBean);

        rosenClientSettingCommitDao.insertEnsenSkipConfig(insertParamBean);
    }

}
