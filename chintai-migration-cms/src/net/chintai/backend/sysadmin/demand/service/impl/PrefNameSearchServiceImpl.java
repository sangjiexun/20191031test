/*
 * $Id: PrefNameSearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import net.chintai.backend.sysadmin.demand.dao.PrefNameSearchDao;
import net.chintai.backend.sysadmin.demand.dao.PrefNameSearchParamBean;
import net.chintai.backend.sysadmin.demand.domain.PrefNameSearchDomain;
import net.chintai.backend.sysadmin.demand.service.PrefNameSearchService;
import net.chintai.backend.sysadmin.demand.service.bean.PrefNameSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.PrefNameSearchOutServiceBean;


/**
 * PrefNameSearchServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefNameSearchServiceImpl implements PrefNameSearchService {

    /** 都道府県名称取得DAO */
    private PrefNameSearchDao prefNameSearchDao;

    /**
     * 都道府県名称取得DAOを設定します。
     * @param prefNameSearchDao 都道府県名称取得DAO
     */
    public void setPrefNameSearchDao(PrefNameSearchDao prefNameSearchDao) {
        this.prefNameSearchDao = prefNameSearchDao;
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.PrefNameSearchService#getPrefName(net.chintai.backend.sysadmin.demand.service.bean.PrefNameSearchInServiceBean)
     */
    public PrefNameSearchOutServiceBean getPrefName(PrefNameSearchInServiceBean inBean) {

        PrefNameSearchParamBean paramBean = new PrefNameSearchParamBean();
        paramBean.setPrefCd(inBean.getPrefCd());

        PrefNameSearchDomain domain = prefNameSearchDao.getPrefName(paramBean);

        PrefNameSearchOutServiceBean outBean = new PrefNameSearchOutServiceBean();
        outBean.setPrefName(domain.getPrefName());

        return outBean;
    }

}
