/*
 * $Id: TorihikisakiWakuInfoUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdatePageDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdatePageParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiWakuInfoDomain;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoUpdagePageService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoUpdatePageOutServiceBean;

/**
 * TorihikisakiWakuInfoUpdagePageServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoUpdatePageServiceImpl implements
        TorihikisakiWakuInfoUpdagePageService {

    /** 取引先物件枠設定情報取得DAO */
    TorihikisakiWakuInfoUpdatePageDao torihikisakiWakuInfoUpdatePageDao;

    /**
     * 取引先物件枠設定情報取得DAOを設定します。
     * @param torihikisakiWakuInfoUpdatePageDao 取引先物件枠設定情報取得DAO
     */
    public void setTorihikisakiWakuInfoUpdatePageDao(
            TorihikisakiWakuInfoUpdatePageDao torihikisakiWakuInfoUpdatePageDao) {
        this.torihikisakiWakuInfoUpdatePageDao = torihikisakiWakuInfoUpdatePageDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoUpdagePageService#getTorihikisakiWakuInfo(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoUpdatePageInServiceBean)
     */
    public TorihikisakiWakuInfoUpdatePageOutServiceBean getTorihikisakiWakuInfo(
            TorihikisakiWakuInfoUpdatePageInServiceBean inBean) {

        TorihikisakiWakuInfoUpdatePageParamBean paramBean =
                new TorihikisakiWakuInfoUpdatePageParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        TorihikisakiWakuInfoDomain domain =
                torihikisakiWakuInfoUpdatePageDao.getTorihikisakiWakuInfo(paramBean);

        TorihikisakiWakuInfoUpdatePageOutServiceBean outBean =
                new TorihikisakiWakuInfoUpdatePageOutServiceBean();

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
