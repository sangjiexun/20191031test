/*
 * $Id: TorihikisakiDeleteConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiDeleteConfirmDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiDeleteConfirmParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiDeleteConfirmDomain;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiDeleteConfirmService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiDeleteConfirmOutServiceBean;

/**
 * TorihikisakiDeleteConfirmServicenの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiDeleteConfirmServiceImpl implements TorihikisakiDeleteConfirmService {

    /** 取引先削除確認DAO */
    TorihikisakiDeleteConfirmDao torihikisakiDeleteConfirmDao;

    /**
     * 取引先削除確認DAOを設定します。
     * @param torihikisakiDeleteConfirmDao 取引先削除確認DAO
     */
    public void setTorihikisakiDeleteConfirmDao(
            TorihikisakiDeleteConfirmDao torihikisakiDeleteConfirmDao) {
        this.torihikisakiDeleteConfirmDao = torihikisakiDeleteConfirmDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiDeleteConfirmService#getTorihikisakiInfoForDel(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiDeleteConfirmInServiceBean)
     */
    public List<TorihikisakiDeleteConfirmOutServiceBean> getTorihikisakiInfoForDel(
            TorihikisakiDeleteConfirmInServiceBean inBean) {

        TorihikisakiDeleteConfirmParamBean paramBean = new TorihikisakiDeleteConfirmParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        List<TorihikisakiDeleteConfirmDomain> domainList =
                torihikisakiDeleteConfirmDao.getTorihikisakiInfoForDel(paramBean);

        List<TorihikisakiDeleteConfirmOutServiceBean> returnList =
                new ArrayList<TorihikisakiDeleteConfirmOutServiceBean>();

        TorihikisakiDeleteConfirmOutServiceBean outBean;
        for (int i = 0; i < domainList.size(); i++) {
            TorihikisakiDeleteConfirmDomain domain = domainList.get(i);
            outBean = new TorihikisakiDeleteConfirmOutServiceBean();
            try {
                BeanUtils.copyProperties(outBean, domain);
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
