package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopListingAddView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingAddConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingAddConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingCheckServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

/**
 * 店舗リスティング設定情報登録
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingAddConfirmAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ShopListingInfoInServiceBean inServiceBean = new ShopListingInfoInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        ShopListingInfoService infoService =
                (ShopListingInfoService) ac.getBean("shopListingInfoService");

        // 契約情報照会
        ShopListingInfoOutServiceBean outBean = infoService.getContractInfo(inServiceBean);

        // viewHelper設定(店舗リスティング)
        ShopListingAddView view = new ShopListingAddView();
        BeanUtils.copyProperties(view, outBean);

        // 画面データ取得
        BeanUtils.copyProperties(view, form);

        // 入力データ検証(既に同じ契約期間にのデータ登録されているかをチェック)
        ShopListingAddConfirmInServiceBean inBean =
                new ShopListingAddConfirmInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 適用月のValidationCheckのため現在日付をViewに設定
        String nowDate = DateUtil.getToday("yyyyMMddHH") + "0000";
        //String nowDate = DateUtil.getToday("yyyyMMddHHmmss");
        view.setNowDate(nowDate);

        view.setApplyYearList(DemandUtils.getYearList());

        ShopListingAddConfirmService service =
                (ShopListingAddConfirmService) ac
                        .getBean("shopListingAddConfirmService");
        try {
            service.countApplyYmdh(inBean);
        } catch (ApplicationException e) {
            context.setForward("fail", view);
            context.setError(e.getErrorId(),e.getPlaceHolders());
            // 二重更新防止トークンをセット
            saveToken(context.getRequest());
            return;
        }
        // 排他用の店舗管理更新日付は、formを引き継ぐ
        view.setShopKanriUpdDt(form.getString("shopKanriUpdDt"));

        int maxCnt = Integer.valueOf(form.getString("maxNum").length());
        Pattern p = Pattern.compile("^[0-9]*$");

        String checkWaku = "";
        if ("-1".equals(form.getString("wakuCnt"))) {
        	checkWaku = form.getString("wakuCntNote");
        } else {
        	checkWaku = form.getString("wakuCnt");
        }

        Matcher m = p.matcher(checkWaku);
        if (!m.find()) {
            context.setForward("fail", view);
            context.setError("WARN.M.DEMAND.0001",
                    ApplicationResources.getProperty("shop_bukken.cnt"),
                    new Integer(maxCnt).toString());
            return;
       }

        int inputCntLength = new Integer(checkWaku.length());
        if (inputCntLength > maxCnt) {
            context.setForward("fail", view);
            context.setError("WARN.M.DEMAND.0001",
                    ApplicationResources.getProperty("shop_bukken.cnt"),
                    new Integer(maxCnt).toString());
            return;
        }

        //枠数がある場合のみチェック
        final String isWakuDisp = form.getString("isWakuDisp");
        if("true".equals(isWakuDisp)){
        	if("-1".equals(form.getString("wakuCnt")) && StringUtils.isEmpty(form.getString("wakuCntNote"))){
        		context.setForward("fail", view);
                context.setError("WARN.M.SHOP_BUKKEN.0136",
                        ApplicationResources.getProperty("shop_bukken.cnt"),
                        new Integer(maxCnt).toString());
                return;
        	}
        }

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());
        context.setForward("success", view);

    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

}
