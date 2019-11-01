/*
 * $Id: KeiyakuUpdateCompleteServiceImpl.java 4306 2009-07-13 11:54:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/25  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDao;
import net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDaoParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuRegisterCompleteDao;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuRegisterCompleteParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuUpdateCompleteDao;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuUpdateCompleteParamBean;
import net.chintai.backend.sysadmin.shop_listing.service.KeiyakuUpdateCompleteService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuUpdateCompleteInServiceBean;

/**
 * KeiyakuUpdateCompleteServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4306 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuUpdateCompleteServiceImpl implements KeiyakuUpdateCompleteService {

    /** 契約情報更新DAO */
    private KeiyakuUpdateCompleteDao keiyakuUpdateCompleteDao;

    /** 契約登録完了DAO */
    private KeiyakuRegisterCompleteDao keiyakuRegisterCompleteDao;

    /** プロシージャDAO */
    private CallProcedureDao callProcedureDao;

    /*
     * (非 Javadoc)
     *
     * @seenet.chintai.backend.sysadmin.shop_listing.service.
     * KeiyakuUpdateCompleteService# updateKeiyakuInfo(
     * net.chintai.backend.sysadmin
     * .shop_listing.service.bean.KeiyakuUpdateCompleteInServiceBean)
     */
    public void updateKeiyakuInfo(KeiyakuUpdateCompleteInServiceBean inBean) {

        // 店舗リスティング契約情報テーブルの更新
        KeiyakuRegisterCompleteParamBean keiyakuParamBean = new KeiyakuRegisterCompleteParamBean();
        BeanUtilsWrapper.copyProperties(keiyakuParamBean, inBean);
        keiyakuParamBean.setUpdDt(inBean.getShopListingKeiyakuUpdDt());
        keiyakuRegisterCompleteDao.updateKeiyakuInfo(keiyakuParamBean);

        // 店舗リスティング契約情報履歴テーブル更新OR登録
        KeiyakuUpdateCompleteParamBean paramBean = new KeiyakuUpdateCompleteParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inBean);

        // 契約情報履歴テーブルを登録/更新
        if (inBean.getKeiyakuShubetsu().equals(inBean.getKeiyakuShubetsuBefore())) {

            // 契約種別:エイブルの場合はパラメータを初期化
            if (inBean.getKeiyakuShubetsu().equals(ConstValues.KEIYAKU_ABLE)) {
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

            // 契約種別変化なしの場合：更新
            keiyakuUpdateCompleteDao.updateKeiykuInfo(paramBean);

        } else if (ConstValues.KEIYAKU_CHINTAI.equals(inBean.getKeiyakuShubetsu())) {

            // エイブル → CHINTAIに契約種別変化の場合：ユーザ入力値で登録
            keiyakuRegisterCompleteDao.registerKeiyakuHistoryInfo(keiyakuParamBean);

        } else {

            // CHINTAI → エイブルに契約種別変化の場合：初期値で登録
            keiyakuParamBean.setKihonKeiyakuFlg(ConstValues.KEIYAKU_OFF);
            keiyakuParamBean.setKeiyakuStartYm(inBean.getToday());
            keiyakuParamBean.setKeiyakuEndYm("");
            keiyakuParamBean.setCouponKeiyakuFlg(ConstValues.KEIYAKU_OFF);
            keiyakuParamBean.setCouponStartYm("");
            keiyakuParamBean.setCouponEndYm("");
            keiyakuParamBean.setLinkKeiyakuFlg(ConstValues.KEIYAKU_OFF);
            keiyakuParamBean.setLinkStartYm("");
            keiyakuParamBean.setLinkEndYm("");

            keiyakuRegisterCompleteDao.registerKeiyakuHistoryInfo(keiyakuParamBean);
        }

        // プロシージャを呼び出す。
        CallProcedureDaoParamBean procedureParamBean = new CallProcedureDaoParamBean();
        BeanUtilsWrapper.copyProperties(procedureParamBean, paramBean);
        callProcedureDao.callKihonYukoFlgUpdate(procedureParamBean);
        callProcedureDao.callCouponYukoFlgUpdate(procedureParamBean);
        callProcedureDao.callLinkYukoFlgUpdate(procedureParamBean);
    }

    /**
     * 契約情報更新DAOを設定します。
     * @param keiyakuUpdateCompleteDao 契約情報更新DAO
     */
    public void setKeiyakuUpdateCompleteDao(KeiyakuUpdateCompleteDao keiyakuUpdateCompleteDao) {
        this.keiyakuUpdateCompleteDao = keiyakuUpdateCompleteDao;
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
