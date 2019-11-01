/*
 * $Id: CouponEditPageServiceImpl.java 4259 2009-03-25 06:22:41Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/05     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.shop_listing.dao.CouponEditPageDao;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingCouponDomain;
import net.chintai.backend.sysadmin.shop_listing.service.CouponEditPageService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.CouponEditPageOutServiceBean;

/**
 * CouponEidtPageServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4259 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CouponEditPageServiceImpl implements CouponEditPageService {

    /** クーポン情報取得DAO */
    private CouponEditPageDao couponEditPageDao;

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.service.CouponEidtPageService#
     * searchCouponInfo(java.lang.String)
     */
    public CouponEditPageOutServiceBean searchCouponInfo(String shopCd) {

        // クーポン情報取得
        List<ShopListingCouponDomain> domainList = couponEditPageDao.searchCouponInfo(shopCd);

        // domain -> outBean 詰め替え
        CouponEditPageOutServiceBean outBean = new CouponEditPageOutServiceBean();
        int displayLimit =
                Integer.parseInt(SystemProperties.getProperty("COUPON_INFO_DISPLAY_LIMIT"));
        String[] couponSeqs = new String[displayLimit];
        String[] startYears = new String[displayLimit];
        String[] startMonths = new String[displayLimit];
        String[] startDays = new String[displayLimit];
        String[] endYears = new String[displayLimit];
        String[] endMonths = new String[displayLimit];
        String[] endDays = new String[displayLimit];
        String[] riyouTaisyo = new String[displayLimit];
        String[] riyouTaisyoCustom = new String[displayLimit];
        String[] riyouTaisyoType = new String[displayLimit];
        String[] tokuten = new String[displayLimit];
        String[] tokutenCustom = new String[displayLimit];
        String[] tokutenType = new String[displayLimit];
        String[] jouken = new String[displayLimit];
        String[] joukenCustom = new String[displayLimit];
        String[] joukenType = new String[displayLimit];
        String[] sortKeys = new String[displayLimit];
        String[] delFlgs = new String[displayLimit];
        String[] updDts = new String[displayLimit];

        List<String> riyouTaisyoOptions =
                Arrays.asList(SystemProperties.getProperty("SHOP_LISTING_RIYOU_TAISYO")
                        .split("[,]"));
        List<String> tokutenOptions =
                Arrays.asList(SystemProperties.getProperty("SHOP_LISTING_TOKUTEN").split("[|]"));
        List<String> joukenOptions =
                Arrays.asList(SystemProperties.getProperty("SHOP_LISTING_JOUKEN").split("[,]"));

        for (int i = 0; i < displayLimit && i < domainList.size(); i++) {
            ShopListingCouponDomain domain = domainList.get(i);

            couponSeqs[i] = domain.getShopListingCouponSeq();
            startYears[i] = domain.getCouponStartYmd().substring(0, 4);
            startMonths[i] = domain.getCouponStartYmd().substring(4, 6);
            startDays[i] = domain.getCouponStartYmd().substring(6);
            if (StringUtils.isNotEmpty(domain.getCouponEndYmd())) {
                endYears[i] = domain.getCouponEndYmd().substring(0, 4);
            } else {
                endYears[i] = "";
            }
            if (StringUtils.isNotEmpty(domain.getCouponEndYmd())) {
                endMonths[i] = domain.getCouponEndYmd().substring(4, 6);
            } else {
                endMonths[i] = "";
            }
            if (StringUtils.isNotEmpty(domain.getCouponEndYmd())) {
                endDays[i] = domain.getCouponEndYmd().substring(6);
            } else {
                endDays[i] = "";
            }

            sortKeys[i] = domain.getSortKey();
            delFlgs[i] = domain.getDelKbn();
            updDts[i] = domain.getUpdDt();

            if (riyouTaisyoOptions.contains(domain.getCouponRiyouTaisyo())) {
                riyouTaisyo[i] = domain.getCouponRiyouTaisyo();
                riyouTaisyoCustom[i] = "";
                riyouTaisyoType[i] = "1";
            } else {
                riyouTaisyo[i] = "";
                riyouTaisyoCustom[i] = domain.getCouponRiyouTaisyo();
                riyouTaisyoType[i] = "2";
            }

            if (tokutenOptions.contains(domain.getCouponTokuten())) {
                tokuten[i] = domain.getCouponTokuten();
                tokutenCustom[i] = "";
                tokutenType[i] = "1";
            } else {
                tokuten[i] = "";
                tokutenCustom[i] = domain.getCouponTokuten();
                tokutenType[i] = "2";
            }

            if (joukenOptions.contains(domain.getCouponJouken())) {
                jouken[i] = domain.getCouponJouken();
                joukenCustom[i] = "";
                joukenType[i] = "1";
            } else {
                jouken[i] = "";
                joukenCustom[i] = domain.getCouponJouken();
                joukenType[i] = "2";
            }
        }
        outBean.setCouponSeqs(couponSeqs);
        outBean.setStartYears(startYears);
        outBean.setStartMonths(startMonths);
        outBean.setStartDays(startDays);
        outBean.setEndYears(endYears);
        outBean.setEndMonths(endMonths);
        outBean.setEndDays(endDays);
        outBean.setRiyouTaisyo(riyouTaisyo);
        outBean.setRiyouTaisyoCustom(riyouTaisyoCustom);
        outBean.setRiyouTaisyoType(riyouTaisyoType);
        outBean.setTokuten(tokuten);
        outBean.setTokutenCustom(tokutenCustom);
        outBean.setTokutenType(tokutenType);
        outBean.setJouken(jouken);
        outBean.setJoukenCustom(joukenCustom);
        outBean.setJoukenType(joukenType);
        outBean.setDelFlgs(delFlgs);
        outBean.setSortKeys(sortKeys);
        outBean.setUpdDt(updDts);

        return outBean;
    }

    /**
     * クーポン情報取得DAOを設定します。
     * @param couponEditPageDao クーポン情報取得DAO
     */
    public void setCouponEditPageDao(CouponEditPageDao couponEditPageDao) {
        this.couponEditPageDao = couponEditPageDao;
    }

}
