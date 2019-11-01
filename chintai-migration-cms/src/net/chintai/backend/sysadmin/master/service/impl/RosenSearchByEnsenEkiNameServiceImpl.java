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

import net.chintai.backend.sysadmin.master.dao.RosenNameSearchDao;
import net.chintai.backend.sysadmin.master.dao.RosenNameSearchParamBean;
import net.chintai.backend.sysadmin.master.domain.RosenListDomain;
import net.chintai.backend.sysadmin.master.service.RosenSearchByEnsenEkiNameService;
import net.chintai.backend.sysadmin.master.service.bean.RosenNameSearchInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.RosenNameSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * RosenSearchByEnsenEkiNameServiceの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenSearchByEnsenEkiNameServiceImpl implements RosenSearchByEnsenEkiNameService {

    /** 沿線検索DAO */
    private RosenNameSearchDao rosenNameSearchDao = null;

    /**
     * rosenNameSearchDaoを設定する
     * @param rosenNameSearchDao
     */
    public void setRosenNameSearchDao(RosenNameSearchDao rosenNameSearchDao) {
        this.rosenNameSearchDao = rosenNameSearchDao;
    }

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.master.service.RosenSearchByEnsenEkiNameService#rosenSearchByEnsenEkiName(net.chintai.backend.sysadmin.master.service.bean.RosenSearchInServiceBean)
	 */
	public List<RosenNameSearchOutServiceBean> rosenSearchByEnsenEkiName(
			RosenNameSearchInServiceBean inServiceBean) throws Exception {
		// 検索条件データを取得
        RosenNameSearchParamBean paramBean = new RosenNameSearchParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // エリアから検索
        List rsList = rosenNameSearchDao.selectEnsenByEnsenEkiName(paramBean);
        List<RosenNameSearchOutServiceBean> rosenSearchList =
                new ArrayList<RosenNameSearchOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            RosenListDomain RosenInfo = (RosenListDomain) rsList.get(i);

            RosenNameSearchOutServiceBean rosenNameSearchOutServiceBean = new RosenNameSearchOutServiceBean();
            BeanUtils.copyProperties(rosenNameSearchOutServiceBean, RosenInfo);

            rosenSearchList.add(rosenNameSearchOutServiceBean);
        }

        return rosenSearchList;
	}
}