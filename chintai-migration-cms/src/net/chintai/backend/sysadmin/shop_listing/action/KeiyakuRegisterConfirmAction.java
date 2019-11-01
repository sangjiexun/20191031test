/*
 * $Id: KeiyakuRegisterConfirmAction.java 4316 2009-07-14 12:09:04Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/18  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 *
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.common.util.ValidatorUtils;
import net.chintai.backend.sysadmin.shop_listing.action.view.KeiyakuRegisterView;
import net.chintai.backend.sysadmin.shop_listing.service.ShopBasicInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopBasicInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 契約情報登録確認画面アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4316 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuRegisterConfirmAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#
     * doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        String shopCd = form.getString("shopCd");

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // 店舗基本情報取得
        ShopBasicInfoService service = (ShopBasicInfoService) ac.getBean("shopBasicInfoService");

        // 契約店舗詳細情報を取得
        ShopBasicInfoOutServiceBean outBean = service.searchShopBasicInfo(shopCd);

        // viewHelper設定
        KeiyakuRegisterView view = new KeiyakuRegisterView();
        BeanUtils.copyProperties(view, outBean);
        BeanUtils.copyProperties(view, form);

        // エラーチェック

        boolean chkFlg = true;

        // 契約種別がCHINTAIの場合のエラーチェック
        if (ConstValues.KEIYAKU_CHINTAI.equals(view.getKeiyakuShubetsu())) {

            // 基本契約開始年月の必須チェック
            if (GenericValidator.isBlankOrNull(view.getKeiyakuStartYm())) {
                context.setError("WARN.M.SHOP_LISTING.0008", ApplicationResources
                        .getProperty("shop_listing.keiyakuStartYm"));
                chkFlg = false;
            }

            // 基本契約開始年月が有効な日付であるのか確認
            if (!ValidatorUtils.isValidDate(view.getKeiyakuStartYm(), ConstValues.YYYYMM)) {
                context.setError("WARN.M.SHOP_LISTING.0006", ApplicationResources
                        .getProperty("shop_listing.keiyakuStartYm"));
                chkFlg = false;
            }

            // 基本契約終了年月が有効な日付であるのか確認
            if (!ValidatorUtils.isValidDate(view.getKeiyakuEndYm(), ConstValues.YYYYMM)) {
                context.setError("WARN.M.SHOP_LISTING.0006", ApplicationResources
                        .getProperty("shop_listing.keiyakuEndYm"));
                chkFlg = false;
            }

            // 基本契約期間の矛盾チェック
            if (!ValidatorUtils.isValidDates(view.getKeiyakuStartYm(), view.getKeiyakuEndYm(),
                    ConstValues.YYYYMM)) {
                context.setError("WARN.M.SHOP_LISTING.0007", ApplicationResources
                        .getProperty("shop_listing.keiyakuYm"));
                chkFlg = false;
            }

            // クーポン契約：契約するを選択した場合のチェック
            if (ConstValues.KEIYAKU_ON.equals(view.getCouponKeiyakuFlg())) {

                // クーポン契約開始年月の必須チェック
                if (GenericValidator.isBlankOrNull(view.getCouponStartYm())) {
                    context.setError("WARN.M.SHOP_LISTING.0012", ApplicationResources
                            .getProperty("shop_listing.couponStartYm"));
                    chkFlg = false;
                }

                // クーポン契約開始年月が有効な日付であるのか確認
                if (!ValidatorUtils.isValidDate(view.getCouponStartYm(), ConstValues.YYYYMM)) {
                    context.setError("WARN.M.SHOP_LISTING.0009", ApplicationResources
                            .getProperty("shop_listing.couponStartYm"));
                    chkFlg = false;
                }

                // クーポン契約終了年月が有効な日付であるのか確認
                if (!ValidatorUtils.isValidDate(view.getCouponEndYm(), ConstValues.YYYYMM)) {
                    context.setError("WARN.M.SHOP_LISTING.0010", ApplicationResources
                            .getProperty("shop_listing.couponEndYm"));
                    chkFlg = false;
                }

                // クーポン契約期間の矛盾チェック
                if (!ValidatorUtils.isValidDates(view.getCouponStartYm(), view.getCouponEndYm(),
                        ConstValues.YYYYMM)) {
                    context.setError("WARN.M.SHOP_LISTING.0011", ApplicationResources
                            .getProperty("shop_listing.couponYm"));
                    chkFlg = false;
                }

                // クーポン契約開始年月が基本契約期間内である事をチェック
                boolean isValidKeiyakuYm =
                    StringUtils.isNotEmpty(view.getKeiyakuStartYm()) &&
                    ValidatorUtils.isValidDate(view.getKeiyakuStartYm(), ConstValues.YYYYMM) &&
                    ValidatorUtils.isValidDate(view.getKeiyakuEndYm(), ConstValues.YYYYMM);

                boolean isValidCouponYm =
                    ValidatorUtils.isValidDate(view.getCouponStartYm(), ConstValues.YYYYMM) &&
                    ValidatorUtils.isValidDate(view.getCouponEndYm(), ConstValues.YYYYMM);

                boolean isVaildCouponStartYm =
                    ValidatorUtils.isValidDates(view.getKeiyakuStartYm(), view.getCouponStartYm(),
                            ConstValues.YYYYMM);

                // クーポン契約終了年月が基本契約期間内である事をチェック
                boolean isVaildCouponEndYm =
                    ValidatorUtils.isValidDates(view.getCouponEndYm(), view.getKeiyakuEndYm(),
                            ConstValues.YYYYMM);

                // 外部リンク契約契約が基本契約期間内であるのかチェック
                if ((isValidKeiyakuYm && isValidCouponYm) &&
                        (!isVaildCouponStartYm || !isVaildCouponEndYm ||
                        (StringUtils.isNotEmpty(view.getKeiyakuEndYm()) &&
                                StringUtils.isEmpty(view.getCouponEndYm())))) {
                    // エラーメッセージ表示用
                    String[] placeHolder =
                            new String[] {
                                    ApplicationResources
                                            .getProperty("shop_listing.couponStartEndYm"),
                                    ApplicationResources
                                            .getProperty("shop_listing.couponStartEndYm"),
                                    ApplicationResources.getProperty("shop_listing.keiyakuYm") };
                    context.setError("WARN.M.SHOP_LISTING.0080", placeHolder);
                    chkFlg = false;
                }

            }

            // 外部リンク表示：契約するを選択した場合のチェック
            if (ConstValues.KEIYAKU_ON.equals(view.getLinkKeiyakuFlg())) {

                // 外部リンク表示開始年月の必須チェック
                if (GenericValidator.isBlankOrNull(view.getLinkStartYm())) {
                    context.setError("WARN.M.SHOP_LISTING.0016", ApplicationResources
                            .getProperty("shop_listing.linkStartYm"));
                    chkFlg = false;
                }

                // 外部リンク表示開始年月の日付チェック
                if (!ValidatorUtils.isValidDate(view.getLinkStartYm(), ConstValues.YYYYMM)) {
                    context.setError("WARN.M.SHOP_LISTING.0013", ApplicationResources
                            .getProperty("shop_listing.linkStartYm"));
                    chkFlg = false;
                }

                // 外部リンク表示終了年月の日付チェック
                if (!ValidatorUtils.isValidDate(view.getLinkEndYm(), ConstValues.YYYYMM)) {
                    context.setError("WARN.M.SHOP_LISTING.0014", ApplicationResources
                            .getProperty("shop_listing.linkEndYm"));
                    chkFlg = false;
                }

                // 外部リンク表示契約期間の矛盾チェック
                if (!ValidatorUtils.isValidDates(view.getLinkStartYm(), view.getLinkEndYm(),
                        ConstValues.YYYYMM)) {
                    context.setError("WARN.M.SHOP_LISTING.0015", ApplicationResources
                            .getProperty("shop_listing.linkStartEndYm"));
                    chkFlg = false;
                }

                // 外部リンク表示契約開始年月が基本契約期間内である事をチェック
                boolean isValidKeiyakuYm =
                    StringUtils.isNotEmpty(view.getKeiyakuStartYm()) &&
                    ValidatorUtils.isValidDate(view.getKeiyakuStartYm(), ConstValues.YYYYMM) &&
                    ValidatorUtils.isValidDate(view.getKeiyakuEndYm(), ConstValues.YYYYMM);

                boolean isValidLinkYm =
                    ValidatorUtils.isValidDate(view.getLinkStartYm(), ConstValues.YYYYMM) &&
                    ValidatorUtils.isValidDate(view.getLinkEndYm(), ConstValues.YYYYMM);

                boolean isVaildLinkStartYm = ValidatorUtils.isValidDates(
                        view.getKeiyakuStartYm(),view.getLinkStartYm(), ConstValues.YYYYMM);

                // 外部リンク表示契約終了年月が基本契約期間内である事をチェック
                boolean isVaildLinkEndYm = ValidatorUtils.isValidDates(
                        view.getLinkEndYm(), view.getKeiyakuEndYm(), ConstValues.YYYYMM);

                // 外部リンク契約契約が基本契約期間内であるのかチェック
                if ((isValidKeiyakuYm && isValidLinkYm) &&
                        (!isVaildLinkStartYm || !isVaildLinkEndYm ||
                        (StringUtils.isNotEmpty(view.getKeiyakuEndYm()) &&
                                StringUtils.isEmpty(view.getLinkEndYm())))) {
                    // エラーメッセージ表示用
                    String[] placeHolder =
                            new String[] {
                                    ApplicationResources.getProperty("shop_listing.linkStartEndYm"),
                                    ApplicationResources.getProperty("shop_listing.linkStartEndYm"),
                                    ApplicationResources.getProperty("shop_listing.keiyakuYm") };
                    context.setError("WARN.M.SHOP_LISTING.0081", placeHolder);
                    chkFlg = false;
                }

            }
        }

        // 備考のクロスサイドスクリプトチェック
        if (!ValidatorUtils.validateScripting(view.getNote())) {
            context.setError("WARN.M.SHOP_LISTING.0018", ApplicationResources
                    .getProperty("shop_listing.note"));
            chkFlg = false;
        }

        // 備考の長さチェック
        int noteLimit = Integer.parseInt(ApplicationResources.getProperty("shop_listing.noteLimit"));
        if (StringUtils.isNotEmpty(view.getNote())
                && view.getNote().replace("\r\n","\n").length() > noteLimit) {
            context.setError("WARN.M.SHOP_LISTING.0017",
                    ApplicationResources.getProperty("shop_listing.note"),
                    ApplicationResources.getProperty("shop_listing.noteLimit"));
            chkFlg = false;
        }

        // 出稿対象駅上限数の文字種チェック
        if (ValidatorUtils.isNotHalfSizeNumber(view.getEkiCnt())) {
            String[] placeHolder =
                    new String[] { ApplicationResources.getProperty("shop_listing.ekiCnt"),
                            ApplicationResources.getProperty("shop_listing.ekiCntValue") };
            context.setError("WARN.M.SHOP_LISTING.0087", placeHolder);
            chkFlg = false;
        }

        // 出稿対象市区町村上限数の文字種チェック
        if (ValidatorUtils.isNotHalfSizeNumber(view.getCityCnt())) {
            String[] placeHolder =
                    new String[] { ApplicationResources.getProperty("shop_listing.cityCnt"),
                            ApplicationResources.getProperty("shop_listing.cityCntValue") };
            context.setError("WARN.M.SHOP_LISTING.0088", placeHolder);
            chkFlg = false;
        }
        // 2009/06 李昊燮追加終了

        if (chkFlg) {

            // 二重更新防止トークンをセット
            saveToken(context.getRequest());

            // 現在日付を設定
            view.setToday(DateUtil.getToday(ConstValues.YYYYMM));

            context.setForward("success", view);

        } else {
            context.setForward("fail", view);
        }
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#
     * isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_LISTING);
    }

}
