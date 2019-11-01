/*
 * $Id: TorihikisakiWakuInfoAddConfirmAction.java 3591 2007-12-17 04:09:45Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiWakuInfoAddView;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiInfoService;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoAddConfirmService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoOutServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoAddConfirmInServiceBean;

/**
 * 取引先物件枠設定情報登録
 *
 * @author lee-hosup
 * @version $Revision: 3591 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoAddConfirmAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        TorihikisakiInfoInServiceBean infoInBean = new TorihikisakiInfoInServiceBean();
        infoInBean.setTorihikisakiSeq(context.getRequest().getParameter("torihikisakiSeq"));

        // injection
        ApplicationContext ac = getWebApplicationContext();
        TorihikisakiInfoService infoService =
                (TorihikisakiInfoService) ac.getBean("torihikisakiInfoService");

        // 取引先詳細照会
        TorihikisakiInfoOutServiceBean outBean = infoService.getTorihikisakiDetailInfo(infoInBean);

        // viewHelper設定(取引先詳細)
        TorihikisakiWakuInfoAddView view = new TorihikisakiWakuInfoAddView();
        BeanUtils.copyProperties(view, outBean);

        // 適用年月プルダウン生成に使うデータを設定
        view.setApplyYearList(DemandUtils.getYearList());
        view.setApplyMonthList(DemandUtils.getMonthsList());

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        BeanUtils.copyProperties(view, form);

        // 郵便番号画面表示形式に編集
        view.setZipCd(DemandUtils.convertZipCd(view.getZipCd()));

        // 入力データ検証(既に同じ適用月のデータ登録されているかをチェック)
        TorihikisakiWakuInfoAddConfirmInServiceBean inBean =
                new TorihikisakiWakuInfoAddConfirmInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        TorihikisakiWakuInfoAddConfirmService service =
                (TorihikisakiWakuInfoAddConfirmService) ac
                        .getBean("torihikisakiWakuInfoAddConfirmService");

        try {
            service.checkAppliyYm(inBean);
        } catch (ApplicationException e) {
            context.setForward("fail", view);
            context.setError("WARN.M.DEMAND.0133", ApplicationResources
                    .getProperty("demand.applyYm"));
            return;
        }

        // 適用月のValidationCheckのため現在日付をViewに設定
        String nowDate = DateUtil.getToday("yyyyMM");
        view.setNowDate(nowDate);

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
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

}
