/*
 * $Id: TorihikisakiWakuMaintenanceDownloadServiceImpl.java 4666 2013-10-09 08:46:35Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/09/19     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceDownloadParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiWakuMaintenanceDownloadDomain;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuMaintenanceDownloadService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuMaintenanceDownloadInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuMaintenanceDownloadOutServiceBean;


/**
 * TorihikisakiWakuMaintenanceDownloadService実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4666 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuMaintenanceDownloadServiceImpl implements TorihikisakiWakuMaintenanceDownloadService{

    /** 物件枠・リスティング枠メンテナンスCsvファイル情報取得DAO */
    private TorihikisakiWakuMaintenanceDao torihikisakiWakuMaintenanceDao = null;

    /**
     * torihikisakiWakuMaintenanceDaoを設定する
     * @param torihikisakiWakuMaintenanceDao
     */
    public void setTorihikisakiWakuMaintenanceDao(TorihikisakiWakuMaintenanceDao torihikisakiWakuMaintenanceDao) {
        this.torihikisakiWakuMaintenanceDao = torihikisakiWakuMaintenanceDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuMaintenanceDownloadService#torihikisakiWakuCsvDownLoad(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuMaintenanceInServiceBean)
     */
    public List<TorihikisakiWakuMaintenanceDownloadOutServiceBean> torihikisakiWakuCsvDownLoad(
            TorihikisakiWakuMaintenanceDownloadInServiceBean inServiceBean) throws ApplicationException {

        TorihikisakiWakuMaintenanceDownloadParamBean paramBean = new TorihikisakiWakuMaintenanceDownloadParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 入力内容に対応した検索結果のリストを取得
        List<TorihikisakiWakuMaintenanceDownloadDomain> rsList = torihikisakiWakuMaintenanceDao.getTorihikisakiWakuMaintenanceList(paramBean);
        List<TorihikisakiWakuMaintenanceDownloadOutServiceBean> torihikisakiWakuMaintenanceSearchList = new ArrayList<TorihikisakiWakuMaintenanceDownloadOutServiceBean>();

        // 検索結果を出力用のBaen設定
        for (TorihikisakiWakuMaintenanceDownloadDomain torihikiGetList : rsList){

            TorihikisakiWakuMaintenanceDownloadOutServiceBean torihikisakiWakuMaintenanceOutServiceBean = new TorihikisakiWakuMaintenanceDownloadOutServiceBean();

            try {
                BeanUtils.copyProperties(torihikisakiWakuMaintenanceOutServiceBean, torihikiGetList);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            torihikisakiWakuMaintenanceSearchList.add(torihikisakiWakuMaintenanceOutServiceBean);
        }

        return torihikisakiWakuMaintenanceSearchList;
    }

}
