/*
 * $Id: TorihikisakiWakuInfoDeleteConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDeleteConfirmDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDeleteConfirmParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiWakuInfoDomain;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoDeleteConfirmService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoDeleteConfirmOutServiceBean;

/**
 * TorihikisakiWakuInfoDeleteConfrimServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoDeleteConfirmServiceImpl implements
        TorihikisakiWakuInfoDeleteConfirmService {

    /** 取引先物件枠設定情報削除確認DAO */
    TorihikisakiWakuInfoDeleteConfirmDao torihikisakiWakuInfoDeleteConfirmDao;

    /**
     * 取引先物件枠設定情報削除確認DAOを設定します。
     * @param torihikisakiWakuInfoDeleteConfirmDao 取引先物件枠設定情報削除確認DAO
     */
    public void setTorihikisakiWakuInfoDeleteConfirmDao(TorihikisakiWakuInfoDeleteConfirmDao torihikisakiWakuInfoDeleteConfirmDao) {
        this.torihikisakiWakuInfoDeleteConfirmDao = torihikisakiWakuInfoDeleteConfirmDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.serviec.TorihikisakiWakuInfoDeleteConfrimService#getTorihikisakiWakuInfoForDelete(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoDeleteConfirmInServiceBean)
     */
    public List<TorihikisakiWakuInfoDeleteConfirmOutServiceBean> getTorihikisakiWakuInfoForDelete(
            TorihikisakiWakuInfoDeleteConfirmInServiceBean inBean) {

        TorihikisakiWakuInfoDeleteConfirmParamBean paramBean =
                new TorihikisakiWakuInfoDeleteConfirmParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        List<TorihikisakiWakuInfoDomain> rsList =
                torihikisakiWakuInfoDeleteConfirmDao
                        .getTorihikisakiWakuInfoForDelete(paramBean);

        List<TorihikisakiWakuInfoDeleteConfirmOutServiceBean> returnList =
                new ArrayList<TorihikisakiWakuInfoDeleteConfirmOutServiceBean>();

        TorihikisakiWakuInfoDeleteConfirmOutServiceBean outBean;
        for (int i=0; i<rsList.size(); i++ ) {
            outBean = new TorihikisakiWakuInfoDeleteConfirmOutServiceBean();
            try {
                BeanUtils.copyProperties(outBean, rsList.get(i));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            returnList.add(outBean);
        }


        return returnList;
    }
}
