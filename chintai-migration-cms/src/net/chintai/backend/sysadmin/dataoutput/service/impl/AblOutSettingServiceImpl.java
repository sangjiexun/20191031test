/*
 * $Id: AblOutSettingServiceImpl.java 4725 2013-11-05 07:59:30Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/11     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.dataoutput.service.AblOutSettingService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.AblOutSettingOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.dao.AblOutSettingDao;
import net.chintai.backend.sysadmin.dataoutput.domain.AblOutSettingDomain;


/**
 * AblOutSettingService実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4725 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AblOutSettingServiceImpl implements AblOutSettingService{

    /** エイブル担当店/取扱店出力情報取得Dao */
    private AblOutSettingDao ablOutSettingDao;

    /**
     * ablOutSettingDaoを設定
     * @param ablOutSettingDao
     */
    public void setAblOutSettingDao(AblOutSettingDao ablOutSettingDao){
        this.ablOutSettingDao = ablOutSettingDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.AblOutSettingService#getAblOutDateList()
     */
    public List<AblOutSettingOutServiceBean> getAblOutDateList() {
        List<AblOutSettingOutServiceBean> resultList = new ArrayList<AblOutSettingOutServiceBean>();
        List<AblOutSettingDomain> ablOutSettingDateList = ablOutSettingDao.getAblOutSettingInfo();

        // 取得結果リスト分繰り返す
        for (AblOutSettingDomain domain : ablOutSettingDateList){
            AblOutSettingOutServiceBean outBean = new AblOutSettingOutServiceBean();
            BeanUtilsWrapper.copyProperties(outBean, domain);
            resultList.add(outBean);
        }
        return resultList;
    }

}
