package net.chintai.backend.sysadmin.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.master.dao.RosenInfoSearchDao;
import net.chintai.backend.sysadmin.master.dao.RosenInfoSearchParamBean;
import net.chintai.backend.sysadmin.master.domain.RosenInfoDomain;
import net.chintai.backend.sysadmin.master.service.RosenInfoSearchByEnsenCdService;
import net.chintai.backend.sysadmin.master.service.bean.RosenInfoInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.RosenInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * RosenInfoSearchByEnsenCdServiceの実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenInfoSearchByEnsenCdServiceImpl implements RosenInfoSearchByEnsenCdService {

    /** 沿線詳細DAO */
    private RosenInfoSearchDao rosenInfoSearchDao = null;

    /**
     * rosenInfoSearchDaoを設定する
     * @param rosenInfoSearchDao
     */
    public void setRosenInfoSearchDao(RosenInfoSearchDao rosenInfoSearchDao) {
        this.rosenInfoSearchDao = rosenInfoSearchDao;
    }

    public List<RosenInfoOutServiceBean> rosenSearchByAreaCdRosenType(
            RosenInfoInServiceBean inServiceBean) throws Exception {
        // 検索条件データを取得
        RosenInfoSearchParamBean paramBean = new RosenInfoSearchParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // 沿線詳細検索
        List rsList = rosenInfoSearchDao.selectRosenInfoByEnsenCd(paramBean);
        List<RosenInfoOutServiceBean> rosenInfoList = new ArrayList<RosenInfoOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            RosenInfoDomain rosenInfo = (RosenInfoDomain) rsList.get(i);

            RosenInfoOutServiceBean rosenInfoOutServiceBean = new RosenInfoOutServiceBean();
            BeanUtils.copyProperties(rosenInfoOutServiceBean, rosenInfo);

            rosenInfoList.add(rosenInfoOutServiceBean);
        }

        return rosenInfoList;
    }

}
