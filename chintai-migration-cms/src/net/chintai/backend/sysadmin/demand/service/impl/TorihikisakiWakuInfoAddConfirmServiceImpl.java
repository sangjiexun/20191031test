/*
 * $Id: TorihikisakiWakuInfoAddConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/13  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoAddConfirmDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoAddConfirmParamBean;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoAddConfirmService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoAddConfirmInServiceBean;

/**
 * TorihikisakiWakuInfoAddConfirmServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoAddConfirmServiceImpl implements
        TorihikisakiWakuInfoAddConfirmService {

    /** 取引先物件枠設定情報確認DAO */
    TorihikisakiWakuInfoAddConfirmDao torihikisakiWakuInfoAddConfirmDao;

    /**
     * 取引先物件枠設定情報確認DAOを設定します。
     * @param torihikisakiWakuInfoAddConfirmDao 取引先物件枠設定情報確認DAO
     */
    public void setTorihikisakiWakuInfoAddConfirmDao(
            TorihikisakiWakuInfoAddConfirmDao torihikisakiWakuInfoAddConfirmDao) {
        this.torihikisakiWakuInfoAddConfirmDao = torihikisakiWakuInfoAddConfirmDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoAddConfirmService#checkAppliyYm(net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoAddConfirmService)
     */
    public void checkAppliyYm(TorihikisakiWakuInfoAddConfirmInServiceBean inBean)
            throws ApplicationException {

        TorihikisakiWakuInfoAddConfirmParamBean paramBean =
                new TorihikisakiWakuInfoAddConfirmParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        int cnt = torihikisakiWakuInfoAddConfirmDao.checkAppliyYm(paramBean);

        if (cnt != 0) {
            throw new ApplicationException("WARN.M.DEMAND.0133", ApplicationResources
                    .getProperty("demand.applyYm"));
        }
    }
}
