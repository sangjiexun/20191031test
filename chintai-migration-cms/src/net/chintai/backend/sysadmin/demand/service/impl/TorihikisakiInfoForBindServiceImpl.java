/*
 * $Id: TorihikisakiInfoForBindServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/27  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiInfoForBindDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiInfoForBindParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiInfoForBindDomain;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiInfoForBindService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoForBindInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoForBindOutServiceBean;

/**
 * TorihikisakiInfoForBindServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiInfoForBindServiceImpl implements TorihikisakiInfoForBindService {

    /** 取引先詳細取得DAO */
    private TorihikisakiInfoForBindDao torihikisakiInfoForBindDao;

    /**
     * 取引先詳細取得DAOを設定します。
     * @param torihikisakiInfoForBindDao 取引先詳細取得DAO
     */
    public void setTorihikisakiInfoForBindDao(TorihikisakiInfoForBindDao torihikisakiInfoForBindDao) {
        this.torihikisakiInfoForBindDao = torihikisakiInfoForBindDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiInfoService#getTorihikisakiDetailInfo(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoInServiceBean)
     */
    public TorihikisakiInfoForBindOutServiceBean getTorihikisakiDetailInfo(
            TorihikisakiInfoForBindInServiceBean inBean) throws ApplicationException {

        // 検索条件設定
        TorihikisakiInfoForBindParamBean paramBean = new TorihikisakiInfoForBindParamBean();
        paramBean.setTorihikisakiSeq(inBean.getTorihikisakiSeq());

        // 取引先情報検索開始
        TorihikisakiInfoForBindDomain domain = torihikisakiInfoForBindDao.getTorihikisakiDetailInfo(paramBean);

        if (domain == null) {
            throw new ApplicationException("ERROR.M.DEMAND.0130");
        }

        // 戻り値設定
        TorihikisakiInfoForBindOutServiceBean outBean = new TorihikisakiInfoForBindOutServiceBean();
        try {
            BeanUtils.copyProperties(outBean, domain);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return outBean;
    }
}
