/*
 * $Id: ShikutyosonClientSettingCommitServiceImpl.java 4832 2014-01-15 02:58:16Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2014/01/06     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingCommitDao;
import net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingCommitParamBean;
import net.chintai.backend.sysadmin.dataoutput.service.ShikutyosonClientSettingCommitService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingCommitInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSystemCommitListBean;

import org.apache.commons.lang.StringUtils;


/**
 * ShikutyosonClientSettingCommitServiceの実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4832 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonClientSettingCommitServiceImpl implements ShikutyosonClientSettingCommitService{

    private ShikutyosonClientSettingCommitDao shikutyosonClientSettingCommitDao;

    public void setShikutyosonClientSettingCommitDao(ShikutyosonClientSettingCommitDao shikutyosonClientSettingCommitDao){
        this.shikutyosonClientSettingCommitDao = shikutyosonClientSettingCommitDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.ShikutyosonClientSettingCommitService#cityClientSettingCommit(net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingCommitInServiceBean)
     */
    public void cityClientSettingCommit(ShikutyosonClientSettingCommitInServiceBean inServiceBean) {
        List<ShikutyosonClientSettingCommitParamBean> insertParamBean = new ArrayList<ShikutyosonClientSettingCommitParamBean>();

        List<ShikutyosonClientSystemCommitListBean> commitList = inServiceBean.getCommitList();

        // Actionで作成した、Insert用のリスト分繰り返す
        for (ShikutyosonClientSystemCommitListBean inBean : commitList){
            // Insert用ParamBean作成
            ShikutyosonClientSettingCommitParamBean paramBean = new ShikutyosonClientSettingCommitParamBean();
            BeanUtilsWrapper.copyProperties(paramBean, inBean);
            insertParamBean.add(paramBean);
        }

        // Delete用のParamBeanにdcoType設定
        ShikutyosonClientSettingCommitParamBean deleteParamBean = new ShikutyosonClientSettingCommitParamBean();
        deleteParamBean.setDcoType(inServiceBean.getDcoType());
        deleteParamBean.setPrefCd(inServiceBean.getPrefCd());
        deleteParamBean.setCityCd(inServiceBean.getCityCd());

        shikutyosonClientSettingCommitDao.deleteShikutyosonSkipConfig(deleteParamBean);

        shikutyosonClientSettingCommitDao.insertShikutyosonSkipConfig(insertParamBean);

        // 親データ(都道府県)削除用文字列がある場合、親データ(沿線)削除処理をする
        if (StringUtils.isNotEmpty(inServiceBean.getParentalType())){
            deleteParamBean.setParentalType(inServiceBean.getParentalType());

            shikutyosonClientSettingCommitDao.deletePrefSkipConfig(deleteParamBean);
        }
    }

}
