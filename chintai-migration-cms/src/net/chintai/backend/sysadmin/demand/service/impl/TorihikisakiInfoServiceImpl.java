/*
 * $Id: TorihikisakiInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiInfoDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiInfoParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiInfoDomain;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiInfoService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoOutServiceBean;

/**
 * 取引先詳細
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiInfoServiceImpl implements TorihikisakiInfoService {

    /** 取引先詳細取得DAO */
    private TorihikisakiInfoDao torihikisakiInfoDao;

    /**
     * 取引先詳細取得DAOを設定します。
     * @param torihikisakiInfoDao 取引先詳細取得DAO
     */
    public void setTorihikisakiInfoDao(TorihikisakiInfoDao torihikisakiInfoDao) {
        this.torihikisakiInfoDao = torihikisakiInfoDao;
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiInfoService#getTorihikisakiDetailInfo(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoInServiceBean)
     */
    public TorihikisakiInfoOutServiceBean getTorihikisakiDetailInfo(
            TorihikisakiInfoInServiceBean inBean) throws ApplicationException {

        // 検索条件設定
        TorihikisakiInfoParamBean paramBean = new TorihikisakiInfoParamBean();
        paramBean.setTorihikisakiSeq(inBean.getTorihikisakiSeq());

        // 取引先情報検索開始
        TorihikisakiInfoDomain domain = torihikisakiInfoDao.getTorihikisakiDetailInfo(paramBean);

        if (domain == null) {
            throw new ApplicationException("ERROR.M.DEMAND.0129");
        }

        // 戻り値設定
        TorihikisakiInfoOutServiceBean outBean = new TorihikisakiInfoOutServiceBean();
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
