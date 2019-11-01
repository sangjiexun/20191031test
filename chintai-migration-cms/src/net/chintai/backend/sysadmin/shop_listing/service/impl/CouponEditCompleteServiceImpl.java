/*
 * $Id: CouponEditCompleteServiceImpl.java 4283 2009-07-06 12:20:29Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/05     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDao;
import net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDaoParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.CouponEditCompleteDao;
import net.chintai.backend.sysadmin.shop_listing.dao.CouponEditCompleteParamBean;
import net.chintai.backend.sysadmin.shop_listing.service.CouponEditCompleteService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.CouponEditCompleteInServiceBean;

/**
 * CouponEditCompleteServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4283 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CouponEditCompleteServiceImpl implements CouponEditCompleteService {

    /** クーポン情報編集DAO */
    CouponEditCompleteDao couponEditCompleteDao;

    /** プロシージャDAO */
    private CallProcedureDao callProcedureDao;

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.service.CouponEditCompleteService
     * # editCouponInfo(net.chintai.backend.sysadmin.shop_listing.service.bean.
     * CouponEditCompleteInServiceBean)
     */
    public void editCouponInfo(CouponEditCompleteInServiceBean inBean) {

        // 編集DAOに渡すパラメータ編集
        String shopCd = inBean.getShopCd();
        String[] couponSeqs = inBean.getCouponSeqs();
        String[] startYears = inBean.getStartYears();
        String[] startMonths = inBean.getStartMonths();
        String[] startDays = inBean.getStartDays();
        String[] endYears = inBean.getEndYears();
        String[] endMonths = inBean.getEndMonths();
        String[] endDays = inBean.getEndDays();
        String[] riyouTaisyoType = inBean.getRiyouTaisyoType();
        String[] riyouTaisyo = inBean.getRiyouTaisyo();
        String[] riyouTaisyoCustom = inBean.getRiyouTaisyoCustom();
        String[] tokutenType = inBean.getTokutenType();
        String[] tokuten = inBean.getTokuten();
        String[] tokutenCustom = inBean.getTokutenCustom();
        String[] joukenType = inBean.getJoukenType();
        String[] jouken = inBean.getJouken();
        String[] joukenCustom = inBean.getJoukenCustom();
        String[] sortKeys = inBean.getSortKeys();
        String[] delFlgs = inBean.getDelFlgs();
        String[] updDts = inBean.getUpdDt();

        for (int i = 0; i < couponSeqs.length; i++) {
            CouponEditCompleteParamBean paramBean = new CouponEditCompleteParamBean();
            paramBean.setShopCd(shopCd);
            paramBean.setShopListingCouponSeq(couponSeqs[i]);
            paramBean.setCouponStartYmd(startYears[i] + startMonths[i] + startDays[i]);
            paramBean.setCouponEndYmd(endYears[i] + endMonths[i] + endDays[i]);

            if (riyouTaisyoType[i].equals("1")) {
                paramBean.setCouponRiyouTaisyo(riyouTaisyo[i]);
            } else if (riyouTaisyoType[i].equals("2")) {
                paramBean.setCouponRiyouTaisyo(riyouTaisyoCustom[i]);
            }

            if (tokutenType[i].equals("1")) {
                paramBean.setCouponTokuten(tokuten[i]);
            } else if (tokutenType[i].equals("2")) {
                paramBean.setCouponTokuten(tokutenCustom[i]);
            }

            if (joukenType[i].equals("1")) {
                paramBean.setCouponJouken(jouken[i]);
            } else if (joukenType[i].equals("2")) {
                paramBean.setCouponJouken(joukenCustom[i]);
            }

            paramBean.setSortKey(sortKeys[i]);
            paramBean.setUpdDt(updDts[i]);
            paramBean.setInsId(inBean.getInsId());
            paramBean.setInsPg(inBean.getInsPg());
            paramBean.setUpdId(inBean.getUpdId());
            paramBean.setUpdPg(inBean.getUpdPg());
            if (StringUtils.isEmpty(delFlgs[i])) {
                paramBean.setDelKbn(ConstValues.FLG_OFF);
            } else {
                paramBean.setDelKbn(ConstValues.FLG_ON);
            }

            if (StringUtils.isNotEmpty(paramBean.getCouponStartYmd())) {
                if (StringUtils.isEmpty(couponSeqs[i])) {
                    // 登録処理
                    couponEditCompleteDao.registerCouponInfo(paramBean);
                } else {
                    // 更新処理
                    couponEditCompleteDao.updateCouponInfo(paramBean);
                }
            }
        }

        // プロシージャを呼び出す。
        CallProcedureDaoParamBean procedureParamBean = new CallProcedureDaoParamBean();
        BeanUtilsWrapper.copyProperties(procedureParamBean, inBean);
        callProcedureDao.callKihonYukoFlgUpdate(procedureParamBean);
        callProcedureDao.callCouponYukoFlgUpdate(procedureParamBean);
        callProcedureDao.callLinkYukoFlgUpdate(procedureParamBean);

    }

    /**
     * クーポン情報編集DAOを設定します。
     * @param couponEditCompleteDao クーポン情報編集DAO
     */
    public void setCouponEditCompleteDao(CouponEditCompleteDao couponEditCompleteDao) {
        this.couponEditCompleteDao = couponEditCompleteDao;
    }

    /**
     * プロシージャDAOを設定します。
     * @param callProcedureDao プロシージャDAO
     */
    public void setCallProcedureDao(CallProcedureDao callProcedureDao) {
        this.callProcedureDao = callProcedureDao;
    }

}
