/*
 * $Id: RosenSearchByAreaCdRosenTypeServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.master.dao.RosenSearchDao;
import net.chintai.backend.sysadmin.master.dao.RosenSearchParamBean;
import net.chintai.backend.sysadmin.master.domain.RosenListDomain;
import net.chintai.backend.sysadmin.master.service.RosenSearchByAreaCdRosenTypeService;
import net.chintai.backend.sysadmin.master.service.bean.RosenSearchInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.RosenSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * RosenSearchByAreaCdRosenTypeServiceの実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenSearchByAreaCdRosenTypeServiceImpl implements RosenSearchByAreaCdRosenTypeService {

    /** 沿線検索DAO */
    private RosenSearchDao rosenSearchDao = null;

    /**
     * rosenSearchDaoを設定する
     * @param rosenSearchDao
     */
    public void setRosenSearchDao(RosenSearchDao rosenSearchDao) {
        this.rosenSearchDao = rosenSearchDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.RosenSearchByAreaCdRosenTypeService#rosenSearchByAreaCdRosenType(net.chintai.backend.sysadmin.master.service.bean.RosenSearchInServiceBean)
     */
    public List<RosenSearchOutServiceBean> rosenSearchByAreaCdRosenType(
            RosenSearchInServiceBean inServiceBean) throws Exception {

        // 検索条件データを取得
        RosenSearchParamBean paramBean = new RosenSearchParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // エリアから検索
        List rsList = rosenSearchDao.selectEnsenByAreaCdRosenType(paramBean);
        List<RosenSearchOutServiceBean> rosenSearchList =
                new ArrayList<RosenSearchOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            RosenListDomain RosenInfo = (RosenListDomain) rsList.get(i);

            RosenSearchOutServiceBean rosenSearchOutServiceBean = new RosenSearchOutServiceBean();
            BeanUtils.copyProperties(rosenSearchOutServiceBean, RosenInfo);

            rosenSearchList.add(rosenSearchOutServiceBean);
        }

        return rosenSearchList;
    }
}