/*
 * $Id: TorihikisakiUpdateCommitServiceImpl.java 3598 2007-12-17 06:00:37Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiUpdateCommitDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiUpdateCommitParamBean;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiUpdateCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiUpdateCommitInServiceBean;

/**
 * TorihikisakiUpdateCommitServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3598 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiUpdateCommitServiceImpl implements TorihikisakiUpdateCommitService {

    /** 取引先情報更新DAO */
    TorihikisakiUpdateCommitDao torihikisakiUpdateCommitDao;

    /**
     * 取引先情報更新DAOを設定します。
     * @param torihikisakiUpdateCommitDao 取引先情報更新DAO
     */
    public void setTorihikisakiUpdateCommitDao(
            TorihikisakiUpdateCommitDao torihikisakiUpdateCommitDao) {
        this.torihikisakiUpdateCommitDao = torihikisakiUpdateCommitDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiUpdateCommitService#updateTorihikisakiInfo(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiUpdateCommitInServiceBean)
     */
    public String updateTorihikisakiInfo(TorihikisakiUpdateCommitInServiceBean inBean)
            throws ApplicationException {

        TorihikisakiUpdateCommitParamBean paramBean = new TorihikisakiUpdateCommitParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        } catch (InvocationTargetException e) {
            throw new RuntimeException();
        }

        // 不動産会社情報に変更があるかを判断
        String oldFudousanCd = inBean.getOldFudousanCd();

        // 戻り値。不動産会社が変更された場合、新しく生成された取引先番号を格納。
        String newTorihikisakiCd = "";

        // 不動産会社情報が変更があったら新しい取引先コードを取得
        if (!(oldFudousanCd.equals(inBean.getFudousanCd()))) {
            newTorihikisakiCd =
                    torihikisakiUpdateCommitDao.getNewTorihikisakiCd(inBean.getFudousanCd());

            if (newTorihikisakiCd == null) {
                // 不動産会社に不動産コードが存在しない場合
                throw new ApplicationException("WARN.M.DEMAND.0087", new String[] {
                        ApplicationResources.getProperty("demand.fudousan"),
                        ApplicationResources.getProperty("demand.choiceFudousan") });
            }
            paramBean.setTorihikisakiCd(newTorihikisakiCd);
            inBean.setTorihikisakiCd(newTorihikisakiCd);
        } else {

            // 不動産会社情報に変更がない場合取引先コードをヌルにして
            // ibatisで取引先コードと不動産会社情報を更新しない。
            paramBean.setTorihikisakiCd(null);
        }

        // 取引先情報を更新します。
        int updateCnt = torihikisakiUpdateCommitDao.updateTorihikisakiInfo(paramBean);

        if (updateCnt != 1) {
            throw new ApplicationException("ERROR.M.DEMAND.0102");
        }

        return newTorihikisakiCd;
    }
}
