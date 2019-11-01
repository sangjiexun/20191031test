/*
 * $Id: TorihikisakiWakuInfoServiceImpl.java 3576 2007-12-14 11:39:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/08  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiWakuInfoDomain;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoOutServiceBean;

/**
 * TorihikisakiWakuInfoServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3576 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoServiceImpl implements TorihikisakiWakuInfoService {

    /** 取引先物件枠情報取得DAO */
    TorihikisakiWakuInfoDao torihikisakiWakuInfoDao;

    /**
     * 取引先物件枠情報取得DAOを設定します。
     * @param torihikisakiWakuInfoDao 取引先物件枠情報取得DAO
     */
    public void setTorihikisakiWakuInfoDao(TorihikisakiWakuInfoDao torihikisakiWakuInfoDao) {
        this.torihikisakiWakuInfoDao = torihikisakiWakuInfoDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoService#getTorihikisakiWakuInfo(net.chintai.backend.sysadmin.demand.service.bean.TorhikisakiWakuInfoInServiceBean)
     */
    public List<TorihikisakiWakuInfoOutServiceBean> getTorihikisakiWakuInfo(
            TorihikisakiWakuInfoInServiceBean inBean) {

        // 検索条件設定
        TorihikisakiWakuInfoParamBean paramBean = new TorihikisakiWakuInfoParamBean();
        paramBean.setTorihikisakiSeq(inBean.getTorihikisakiSeq());

        // 検索開始
        List<TorihikisakiWakuInfoDomain> rsList =
                torihikisakiWakuInfoDao.getTorihikisakiWakuInfo(paramBean);

        // 戻り値設定
        List<TorihikisakiWakuInfoOutServiceBean> returnList =
                new ArrayList<TorihikisakiWakuInfoOutServiceBean>();

        TorihikisakiWakuInfoOutServiceBean outBean = null;

        // 現在適用中の物件枠を探す為、現在年月を取得
        String nowDate = DateUtil.getToday("yyyyMM");

        //
        boolean checkFlg = true;

        for (int i = 0; i < rsList.size(); i++) {

            outBean = new TorihikisakiWakuInfoOutServiceBean();

            try {
                BeanUtils.copyProperties(outBean, rsList.get(i));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

            /* 現在適用中の取引先を判断
             * 物件枠情報検索時、適用月の降順にソートされた結果をかえす。
             * だから現在日付 >= 適用月の中で最初のものを
             * 適用中の適用月と判断、フラグを立てる。
             * 現在日付 ＜ 適用月の場合削除可能フラグを立てる
             */
            if (nowDate.compareTo(outBean.getStartYm()) >= 0) {
                if (checkFlg) {
                    outBean.setAppliedFlg("FFFF99");
                    checkFlg = false;
                }
            } else {
                outBean.setDelFlg("on");
            }

            // 現在日付を含めて未来の適用月は更新リンクを活性化
            if (nowDate.compareTo(outBean.getStartYm()) <= 0) {
                outBean.setLinkFlg("on");
            }

            returnList.add(outBean);        }

        return returnList;
    }
}
