/*
 * $Id: DcoTypeServiceImpl.java 4774 2014-01-09 08:12:36Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/11/08     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.dwr.dao.DcoTypeDao;
import net.chintai.backend.sysadmin.common.dwr.domain.DcoType;
import net.chintai.backend.sysadmin.common.dwr.service.DcoTypeService;
import net.chintai.backend.sysadmin.common.dwr.service.bean.DcoTypeBean;


/**
 * DcoTypeServiceの実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4774 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class DcoTypeServiceImpl implements DcoTypeService {

    /** 連携対象マスタを取得Dao */
    private DcoTypeDao dcoTypeDao;

    /**
     * dcoTypeDaoを設定
     * @param dcoTypeDao
     */
    public void setDcoTypeDao(DcoTypeDao dcoTypeDao){
        this.dcoTypeDao = dcoTypeDao;
    }
    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dwr.service.DcoTypeService#getDcoTypeList()
     */
    public List<DcoTypeBean> getDcoTypeList(String dcoTypes) {
        List<DcoType> rsList = dcoTypeDao.selectDcoTypeList(dcoTypes);
        List<DcoTypeBean> beanList = new ArrayList<DcoTypeBean>();
        DcoTypeBean skipSet = new DcoTypeBean("","");
        beanList.add(skipSet);

        if (rsList != null){
            for (int i = 0; i < rsList.size(); i++) {
                DcoTypeBean dcoTypeBean =
                    new DcoTypeBean(rsList.get(i).getDcoType(), rsList.get(i).getDcoName());
                beanList.add(dcoTypeBean);
            }
        }
        return beanList;
    }

}
