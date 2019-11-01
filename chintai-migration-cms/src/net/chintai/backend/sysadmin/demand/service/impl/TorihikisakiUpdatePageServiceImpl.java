/*
 * $Id: TorihikisakiUpdatePageServiceImpl.java 3850 2008-03-10 05:40:33Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/05  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiUpdatePageDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiUpdatePageParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiUpdatePageDomain;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiUpdatePageService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiUpdatePageOutServiceBean;

/**
 * TorihikisakiUpdatePageServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3850 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiUpdatePageServiceImpl implements TorihikisakiUpdatePageService {

    /** 更新用、取引先情報取得DAO */
    TorihikisakiUpdatePageDao torihikisakiUpdatePageDao;

    /**
     * 更新用、取引先情報取得DAOを設定します。
     * @param torihikisakiUpdatePageDao 更新用、取引先情報取得DAO
     */
    public void setTorihikisakiUpdatePageDao(TorihikisakiUpdatePageDao torihikisakiUpdatePageDao) {
        this.torihikisakiUpdatePageDao = torihikisakiUpdatePageDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiUpdatePageService#getTorihikisaki(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiUpdatePageInServiceBean)
     */
    public TorihikisakiUpdatePageOutServiceBean getTorihikisaki(TorihikisakiUpdatePageInServiceBean inBean)
            throws ApplicationException {

        TorihikisakiUpdatePageParamBean paramBean = new TorihikisakiUpdatePageParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        TorihikisakiUpdatePageDomain domain = torihikisakiUpdatePageDao.getTorihikisakiInfo(paramBean);

        if (domain == null) {
            throw new ApplicationException("ERROR.M.DEMAND.0129");
        }

        TorihikisakiUpdatePageOutServiceBean outBean = new TorihikisakiUpdatePageOutServiceBean();

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
