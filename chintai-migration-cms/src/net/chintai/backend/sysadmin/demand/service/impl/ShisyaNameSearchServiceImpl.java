/*
 * $Id: ShisyaNameSearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/03  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import net.chintai.backend.sysadmin.demand.dao.ShisyaNameSearchDao;
import net.chintai.backend.sysadmin.demand.dao.ShisyaNameSearchParamBean;
import net.chintai.backend.sysadmin.demand.domain.ShisyaNameSearchDomain;
import net.chintai.backend.sysadmin.demand.service.ShisyaNameSearchService;
import net.chintai.backend.sysadmin.demand.service.bean.ShisyaNameSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.ShisyaNameSearchOutServiceBean;

/**
 * ShisyaNameSearchServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShisyaNameSearchServiceImpl implements ShisyaNameSearchService {

    /** 支社名称取得DAO */
    ShisyaNameSearchDao shisyaNameSearchDao;

    /**
     * 支社名称取得DAOを設定します。
     * @param shisyaNameSearchDao 支社名称取得DAO
     */
    public void setShisyaNameSearchDao(ShisyaNameSearchDao shisyaNameSearchDao) {
        this.shisyaNameSearchDao = shisyaNameSearchDao;
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.ShisyaNameSearchService#getShisyaName(net.chintai.backend.sysadmin.demand.service.bean.ShisyaNameSearchInServiceBean)
     */
    public ShisyaNameSearchOutServiceBean getShisyaName(ShisyaNameSearchInServiceBean inBean) {

        // 検索条件設定
        ShisyaNameSearchParamBean paramBean = new ShisyaNameSearchParamBean();
        paramBean.setShisyaCd(inBean.getShisyaCd());

        // 検索開始
        ShisyaNameSearchDomain domain = shisyaNameSearchDao.getShisyaName(paramBean);

        // 戻り値設定
        ShisyaNameSearchOutServiceBean outBean = new ShisyaNameSearchOutServiceBean();
        outBean.setShisyaName(domain.getShisyaName());

        return outBean;
    }
}
