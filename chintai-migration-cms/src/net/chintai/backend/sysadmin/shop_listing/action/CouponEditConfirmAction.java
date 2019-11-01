/*
 * $Id: CouponEditConfirmAction.java 4257 2009-03-25 05:34:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/19     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_listing.action.view.CouponEditView;
import net.chintai.backend.sysadmin.shop_listing.service.ShopBasicInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopBasicInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * クーポン情報編集確認アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4257 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CouponEditConfirmAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport
     * #doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        String shopCd = form.getString("shopCd");

        // クーポン情報の最大表示件数取得
        String limit = SystemProperties.getProperty("COUPON_INFO_DISPLAY_LIMIT");

        // ViewHelper
        CouponEditView view = new CouponEditView(limit);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // 店舗基本情報取得
        ShopBasicInfoService service = (ShopBasicInfoService) ac.getBean("shopBasicInfoService");

        // 契約店舗詳細情報を取得
        ShopBasicInfoOutServiceBean outBean = service.searchShopBasicInfo(shopCd);
        BeanUtils.copyProperties(view, outBean);
        BeanUtils.copyProperties(view, form);

        // 非表示チェックボックスの値を編集
        String[] tmp = view.getDelFlgs();
        String[] delFlgs = new String[Integer.parseInt(limit)];
        for (int i = 0; i < tmp.length; i++) {
            int tmpPosition = Integer.parseInt(tmp[i]) - 1;
            delFlgs[tmpPosition] = tmp[i];
        }
        view.setDelFlgs(delFlgs);

        // 整合性チェック
        String fwd = "success";

        String[] couponSeqs = view.getCouponSeqs();
        String[] startYears = view.getStartYears();
        String[] startMonths = view.getStartMonths();
        String[] startDays = view.getStartDays();
        String[] endYears = view.getEndYears();
        String[] endMonths = view.getEndMonths();
        String[] endDays = view.getEndDays();
        String[] riyouTaisyo = view.getRiyouTaisyo();
        String[] riyouTaisyoCustom = view.getRiyouTaisyoCustom();
        String[] riyouTaisyoType = view.getRiyouTaisyoType();
        String[] tokuten = view.getTokuten();
        String[] tokutenCustom = view.getTokutenCustom();
        String[] tokutenType = view.getTokutenType();
        String[] jouken = view.getJouken();
        String[] joukenCustom = view.getJoukenCustom();
        String[] joukenType = view.getJoukenType();
        String[] sortKeys = view.getSortKeys();

        // 全体未入力チェックのための変数
        String allEmpty = "";

        for (int i = 0; i < Integer.parseInt(view.getDisplayLimit()); i++) {

            // 項番
            String num = "クーポン" + String.valueOf(i + 1);

            // 開始日
            String startYm = startYears[i] + startMonths[i] + startDays[i];

            allEmpty = allEmpty + startYm;

            // 更新の場合開始年月日の必須チェックを行う
            if (StringUtils.isNotEmpty(couponSeqs[i])) {

                if (GenericValidator.isBlankOrNull(startYm)) {
                    context.setError("WARN.M.SHOP_LISTING.0084", num + "の開始年月日");
                    fwd = "fail";
                }
            }

            // 以下、更新/登録 共通チェック
            if (StringUtils.isNotEmpty(startYm)) {

                // 開始日のチェック
                if (!this.isValidDate(startYm)) {
                    context.setError("WARN.M.SHOP_LISTING.0061", num + "の開始年月日");
                    fwd = "fail";
                }
                // 終了日のチェック
                String endYm = endYears[i] + endMonths[i] + endDays[i];
                if (StringUtils.isNotEmpty(endYm) && !this.isValidDate(endYm)) {
                    context.setError("WARN.M.SHOP_LISTING.0062", num + "の終了年月日");
                    fwd = "fail";
                }

                // 開始日と終了日の矛盾チェック
                if (!this.isValidDate(startYm, endYm)) {
                    context.setError("WARN.M.SHOP_LISTING.0063", num + "の開始終了期間");
                    fwd = "fail";
                }

                // ソート順の必須チェック
                if (GenericValidator.isBlankOrNull(sortKeys[i])) {
                    context.setError("WARN.M.SHOP_LISTING.0067", num + "のソート順");
                    fwd = "fail";
                }

                // ソートキーチェック
                if (!GenericValidator.matchRegexp(sortKeys[i], "^[0-9]{0,4}$")) {
                    context.setError("WARN.M.SHOP_LISTING.0078",
                            new String[] { num + "のソート順", "4" });
                    fwd = "fail";
                }

                // 利用対象の必須チェック
                if (riyouTaisyoType[i].endsWith("1")) {
                    if (GenericValidator.isBlankOrNull(riyouTaisyo[i])) {
                        context.setError("WARN.M.SHOP_LISTING.0064", num + "の利用対象");
                        fwd = "fail";
                    }
                } else if (riyouTaisyoType[i].endsWith("2")) {
                    if (GenericValidator.isBlankOrNull(riyouTaisyoCustom[i])) {
                        context.setError("WARN.M.SHOP_LISTING.0064", num + "の利用対象");
                        fwd = "fail";
                    }
                    if (!this.validateScripting(riyouTaisyoCustom[i])) {
                        context.setError("WARN.M.SHOP_LISTING.0073", num + "の利用対象");
                        riyouTaisyoCustom[i] = this.replaceTag(riyouTaisyoCustom[i]);
                        view.setRiyouTaisyoCustom(riyouTaisyoCustom);
                        fwd = "fail";
                    }
                }

                // 特典の必須チェック
                if (tokutenType[i].endsWith("1")) {
                    if (GenericValidator.isBlankOrNull(tokuten[i])) {
                        context.setError("WARN.M.SHOP_LISTING.0065", num + "の特典");
                        fwd = "fail";
                    }
                } else if (tokutenType[i].endsWith("2")) {
                    if (GenericValidator.isBlankOrNull(tokutenCustom[i])) {
                        context.setError("WARN.M.SHOP_LISTING.0065", num + "の特典");
                        fwd = "fail";
                    }
                    if (!this.validateScripting(tokutenCustom[i])) {
                        context.setError("WARN.M.SHOP_LISTING.0075", num + "の特典");
                        tokutenCustom[i] = this.replaceTag(tokutenCustom[i]);
                        view.setTokutenCustom(tokutenCustom);
                        fwd = "fail";
                    }
                }

                // 提示条件の必須チェック
                if (joukenType[i].endsWith("1")) {
                    if (GenericValidator.isBlankOrNull(jouken[i])) {
                        context.setError("WARN.M.SHOP_LISTING.0066", num + "の提示条件");
                        fwd = "fail";
                    }
                } else if (joukenType[i].endsWith("2")) {
                    if (GenericValidator.isBlankOrNull(joukenCustom[i])) {
                        context.setError("WARN.M.SHOP_LISTING.0066", num + "の提示条件");
                        fwd = "fail";
                    }
                    if (!this.validateScripting(joukenCustom[i])) {
                        context.setError("WARN.M.SHOP_LISTING.0077", num + "の提示条件");
                        joukenCustom[i] = this.replaceTag(joukenCustom[i]);
                        view.setJoukenCustom(joukenCustom);
                        fwd = "fail";
                    }

                }
            }
        }

        if (GenericValidator.isBlankOrNull(allEmpty) && context.getErrors() == null) {
            context.setError("WARN.M.SHOP_LISTING.0079", "登録するクーポン情報");
            fwd = "fail";
        }

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());

        context.setForward(fwd, view);

    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport
     * #isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_LISTING);
    }

    /**
     * クロスサイドスクリプティング対策としてタグ開始特集文字を置換します。
     *
     * @param input 入力文字列。
     * @return 置換済の文字列。
     */
    private String replaceTag(String input) {
        String returnValue = "";
        if (StringUtils.isEmpty(input))
            return input;

        returnValue = input.replaceAll(">", "&gt;");
        returnValue = returnValue.replaceAll("<", "&lt;");
        returnValue = returnValue.replaceAll("'", "\\'");
        return returnValue;
    }

    /**
     * クロスサイドスクリプティングチェック
     *
     * @param value 入力文字列。
     * @return チェック結果。
     */
    private boolean validateScripting(String value) {
        if (GenericValidator.isBlankOrNull(value)) {
            return true;
        }
        if (value.matches(".*<[^>]*script[^>]*>.*")
                || value.matches(".*<[^>]*[^>a-zA-Z]*document\\.[^>]*>.*")
                || value.matches(".*<[^>]*[^>a-zA-Z]+on[a-zA-Z]+[ \t\n\r\f]*=[^>]*>.*")) {

            return false;
        }
        return true;
    }

    /**
     * 有効な日付であるのかを確認。
     *
     * @param date
     */
    private boolean isValidDate(String date) {

        if (StringUtils.isEmpty(date)) {
            return true;
        }
        return GenericValidator.isDate(date, "yyyyMMdd", true);
    }

    /**
     * 開始日と終了日の矛盾チェックを行う。
     *
     * @param startYm
     * @param endYm
     * @return
     */
    private boolean isValidDate(String startYm, String endYm) {

        if (StringUtils.isEmpty(startYm) || StringUtils.isEmpty(endYm)) {
            return true;
        }

        // 開始日、終了日が両方とも正常の場合たけ、範囲チェックを行う。
        if (!this.isValidDate(startYm) || !this.isValidDate(endYm)) {
            return true;
        }

        if (startYm.compareTo(endYm) <= 0) {
            return true;
        }

        return false;
    }
}
