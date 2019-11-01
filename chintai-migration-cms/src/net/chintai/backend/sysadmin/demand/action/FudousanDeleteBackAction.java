/*
 * $Id: FudousanDeleteBackAction.java 3675 2007-12-20 04:00:35Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/13     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.demand.action.view.FudousanSearchView;
import net.chintai.backend.sysadmin.demand.action.view.FudousanSearchView.FudousanSearchDetailView;
import net.chintai.backend.sysadmin.demand.service.FudousanSearchService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanSearchOutServiceBean;

/**
 * 不動産会社削除確認ページの戻るボタンのアクション<br>
 * @author TAKAHASHI Yuki
 * @version $Revision: 3675 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanDeleteBackAction extends BaseActionSupport {

    private static final String C_CHECKBOX_CHECKED = "checked";

    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // セッションから検索条件を取得
        FudousanSearchInServiceBean inBean =
                (FudousanSearchInServiceBean) context.getSessionBean().getSearchConditionMap().get(
                        SessionSearchKey.DEMAND_FUDOUSAN_SEARCH);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        FudousanSearchService service = (FudousanSearchService) ac.getBean("fudousanSearchService");

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.parseInt(SystemProperties
                .getProperty("C_FUDOUSAN_SEARCH_DISPLAY_LIMIT")));
        condition.setOffset(inBean.getOffSet());

        // 検索開始
        List<FudousanSearchOutServiceBean> rsList = service.getFudousanList(inBean, condition);

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        String[] fudousanCds = (String[]) form.get("fudousanCd");
        List<String> fudousanCdList = null;
        if (fudousanCds != null && fudousanCds.length > 0) {
            fudousanCdList = Arrays.asList(fudousanCds);
        }

        // ViewHelper設定
        FudousanSearchView view = new FudousanSearchView(condition);
        if (rsList.size() > 0) {
            List<FudousanSearchDetailView> detailList = new ArrayList<FudousanSearchDetailView>();
            for (int i = 0; i < rsList.size(); i++) {
                FudousanSearchDetailView detailView = view.new FudousanSearchDetailView();
                BeanUtils.copyProperties(detailView, rsList.get(i));
                detailList.add(detailView);

                // 削除確認画面からの遷移の場合、
                // 削除対象不動産会社のチェックボックスを「選択」状態にする
                if (fudousanCdList != null && fudousanCdList.size() > 0
                        && fudousanCdList.contains(rsList.get(i).getFudousanCd())) {
                    detailView.setDelKbn(C_CHECKBOX_CHECKED);

                }
                view.setDetailList(detailList);
            }
        } else {
            context.setError("WARN.M.DEMAND.0021");
        }

        // 検索条件をViewに設定
        BeanUtils.copyProperties(view, inBean);
        context.setForward("success", view);

    }

    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

}
