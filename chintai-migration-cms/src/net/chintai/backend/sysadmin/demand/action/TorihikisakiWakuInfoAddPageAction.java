/*
 * $Id: TorihikisakiWakuInfoAddPageAction.java 3618 2007-12-17 12:08:24Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/08  BGT)李昊燮   新規作成
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
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiWakuInfoAddView;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiInfoService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoOutServiceBean;

/**
 * 物件枠情報を登録
 *
 * @author lee-hosup
 * @version $Revision: 3618 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoAddPageAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        TorihikisakiInfoInServiceBean inBean = new TorihikisakiInfoInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        TorihikisakiInfoService service =
                (TorihikisakiInfoService) ac.getBean("torihikisakiInfoService");

        // 取引先詳細照会
        TorihikisakiInfoOutServiceBean outBean;
        try {
            outBean = service.getTorihikisakiDetailInfo(inBean);
        } catch (ApplicationException e) {
            context.setForward("fail");
            context.setError("ERROR.M.DEMAND.0129");
            return;
        }

        // ViewHelper設定
        TorihikisakiWakuInfoAddView view = new TorihikisakiWakuInfoAddView();
        BeanUtils.copyProperties(view, form);
        BeanUtils.copyProperties(view, outBean);

        // 適用年月プルダウン生成に使うデータを設定
        view.setApplyYearList(DemandUtils.getYearList());
        view.setApplyMonthList(DemandUtils.getMonthsList());

        // 郵便番号画面表示形式に編集
        view.setZipCd(DemandUtils.convertZipCd(view.getZipCd()));

        // 適用月のValidationCheckのため現在日付をViewに設定
        String nowDate = DateUtil.getToday("yyyyMM");
        view.setNowDate(nowDate);

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
