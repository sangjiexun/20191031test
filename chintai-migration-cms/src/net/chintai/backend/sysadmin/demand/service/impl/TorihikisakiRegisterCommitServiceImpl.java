/*
 * $Id: TorihikisakiRegisterCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/04  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiRegisterCommitDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiRegisterCommitParamBean;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiRegisterCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiRegisterCommitInServiceBean;

/**
 * TorihikisakiRegisterCommitInServiceの実装クラス。<br>
 *
 * 二つの登録作業トランザクション処理 applicationContext-demand.xml参照
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiRegisterCommitServiceImpl implements TorihikisakiRegisterCommitService {

    /** 取引先新規登録DAO */
    TorihikisakiRegisterCommitDao torihikisakiRegisterCommitDao;

    /**
     * 取引先新規登録DAOを設定します。
     * @param torihikisakiRegisterCommitDao 取引先新規登録DAO
     */
    public void setTorihikisakiRegisterCommitDao(
            TorihikisakiRegisterCommitDao torihikisakiRegisterCommitDao) {
        this.torihikisakiRegisterCommitDao = torihikisakiRegisterCommitDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiRegisterCommitService#insertTorihikisaki(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiRegisterCommitInServiceBean)
     */
    public String insertTorihikisaki(TorihikisakiRegisterCommitInServiceBean inBean)
            throws Exception {

        TorihikisakiRegisterCommitParamBean paramBean = new TorihikisakiRegisterCommitParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 取引先コードを取得、設定
        String torihikisakiCd =
                torihikisakiRegisterCommitDao.getTorihikisakiCd(paramBean.getFudousanCd());
        if (torihikisakiCd == null) {
            // 不動産会社に不動産コードが存在しない場合
            throw new ApplicationException("WARN.M.DEMAND.0078", new String[] {
                    ApplicationResources.getProperty("demand.fudousan"),
                    ApplicationResources.getProperty("demand.choiceFudousan") });
        }
        paramBean.setTorihikisakiCd(torihikisakiCd);

        String returnValue = "";

        try {
            // USK_TORIHIKISAKIテーブルに登録
            int torihikisakiSeq = torihikisakiRegisterCommitDao.insertTorihikisaki(paramBean);
            paramBean.setTorihikisakiSeq(torihikisakiSeq);

            // USK_TORIHIKISAKI_RYOUKINテーブルに登録
            torihikisakiRegisterCommitDao.insertTorihikisakiRyoukin(paramBean);

            // 操作ログのためPKを戻り値に設定
            returnValue = String.valueOf(torihikisakiSeq);

        } catch (Exception e) {
            throw e;
        }

        return returnValue;
    }
}
