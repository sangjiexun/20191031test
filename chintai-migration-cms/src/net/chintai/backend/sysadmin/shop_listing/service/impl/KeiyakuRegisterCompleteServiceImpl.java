/*
 * $Id: KeiyakuRegisterCompleteServiceImpl.java 4284 2009-07-06 12:25:15Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/24     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDao;
import net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDaoParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuRegisterCompleteDao;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuRegisterCompleteParamBean;
import net.chintai.backend.sysadmin.shop_listing.service.KeiyakuRegisterCompleteService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuRegisterCompleteInServiceBean;

import org.apache.commons.lang.StringUtils;

/**
 * KeiyakuRegisterCompleteServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4284 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuRegisterCompleteServiceImpl implements KeiyakuRegisterCompleteService {

    /** 契約登録完了DAO */
    private KeiyakuRegisterCompleteDao keiyakuRegisterCompleteDao;

    /** プロシージャDAO */
    private CallProcedureDao callProcedureDao;

    /*
     * (非 Javadoc)
     *
     * @seenet.chintai.backend.sysadmin.shop_listing.service.
     * KeiyakuRegisterCompleteService# registerKiyakuInfo(
     * net.chintai.backend.sysadmin
     * .shop_listing.service.bean.KeiyakuRegisterCompleteInServiceBean)
     */
    public String registerKiyakuInfo(KeiyakuRegisterCompleteInServiceBean inBean) {

        // paramBean設定
        KeiyakuRegisterCompleteParamBean paramBean = new KeiyakuRegisterCompleteParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inBean);

        // 契約種別がエイブルの場合、契約種別・契約開始年月・備考以外の入力値を初期化。
        if (ConstValues.KEIYAKU_ABLE.equals(paramBean.getKeiyakuShubetsu())) {
            paramBean.setKihonKeiyakuFlg(ConstValues.KEIYAKU_OFF);
            paramBean.setKeiyakuStartYm(inBean.getToday());
            paramBean.setKeiyakuEndYm("");
            paramBean.setCouponKeiyakuFlg(ConstValues.KEIYAKU_OFF);
            paramBean.setCouponStartYm("");
            paramBean.setCouponEndYm("");
            paramBean.setLinkKeiyakuFlg(ConstValues.KEIYAKU_OFF);
            paramBean.setLinkStartYm("");
            paramBean.setLinkEndYm("");
        }

        // 契約情報テーブル登録。
        int cnt = keiyakuRegisterCompleteDao.countTotalCnt(paramBean);

        if (cnt < 1) {
            keiyakuRegisterCompleteDao.registerKeiyakuInfo(paramBean);
        } else {
            keiyakuRegisterCompleteDao.updateKeiyakuInfo(paramBean);
        }

        // 契約情報履歴テーブル登録を行う。
        String rirekiSeq = keiyakuRegisterCompleteDao.registerKeiyakuHistoryInfo(paramBean);

        // プロシージャを呼び出す。
        if (StringUtils.isNotEmpty(rirekiSeq)) {
            CallProcedureDaoParamBean procedureParamBean = new CallProcedureDaoParamBean();
            BeanUtilsWrapper.copyProperties(procedureParamBean, paramBean);
            callProcedureDao.callKihonYukoFlgUpdate(procedureParamBean);
            callProcedureDao.callCouponYukoFlgUpdate(procedureParamBean);
            callProcedureDao.callLinkYukoFlgUpdate(procedureParamBean);
        }

        return rirekiSeq;

    }

    /**
     * 契約登録完了DAOを設定します。
     * @param keiyakuRegisterCompleteDao 契約登録完了DAO
     */
    public void setKeiyakuRegisterCompleteDao(KeiyakuRegisterCompleteDao keiyakuRegisterCompleteDao) {
        this.keiyakuRegisterCompleteDao = keiyakuRegisterCompleteDao;
    }

    /**
     * プロシージャDAOを設定します。
     * @param callProcedureDao プロシージャDAO
     */
    public void setCallProcedureDao(CallProcedureDao callProcedureDao) {
        this.callProcedureDao = callProcedureDao;
    }

}
