/*
 * $Id: TorihikisakiListPagingAction.java 3626 2007-12-18 02:27:17Z y-takahashi $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/03  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import java.util.ArrayList;
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
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiListView;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiListView.TorihikisakiListDetailView;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiListService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiListInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiListOutServiceBean;

/**
 * 取引先リストページングアクション
 *
 * @author lee-hosup
 * @version $Revision: 3626 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiListPagingAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // セッションから検索条件を取得
        TorihikisakiListInServiceBean inBean =
                (TorihikisakiListInServiceBean) context.getSessionBean().getSearchConditionMap()
                        .get(SessionSearchKey.DEMAND_TORIHIKISAKI_LIST);

        // ページングで遷移してきた場合画面から選択ページング情報を取得
        // offSetがヌル=パンくずなど、 offsetがヌルではない=ページング
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        if (form.get("offSet") != null) {
            inBean.setOffSet((Integer) form.get("offSet"));
        }

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.parseInt(SystemProperties
                .getProperty("C_SHOP_BIND_SEARCH_DISPLAY_LIMIT")));
        condition.setOffset(inBean.getOffSet());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        TorihikisakiListService service =
                (TorihikisakiListService) ac.getBean("torihikisakiListService");

        //検索開始
        List<TorihikisakiListOutServiceBean> rsList =
                service.getTorihikisakiList(inBean, condition);

        // viewHelper設定
        TorihikisakiListView view = new TorihikisakiListView(condition);

        // 検索条件コピー
        BeanUtils.copyProperties(view, inBean);

        // 画面出力
        if (rsList.size() == 0) {
            context.setError("WARN.M.REVIEW.0014");
        } else {
            List<TorihikisakiListDetailView> detailList =
                    new ArrayList<TorihikisakiListDetailView>();
            for (int i = 0; i < rsList.size(); i++) {
                TorihikisakiListDetailView detailView = view.new TorihikisakiListDetailView();
                detailView.setTorihikisakiCd1(rsList.get(i).getFudousanCd());
                detailView.setTorihikisakiCd2(rsList.get(i).getTorihikisakiCd());
                detailView.setFudousanName(rsList.get(i).getFudousanName());
                detailView.setTorihikisakiName(rsList.get(i).getTorihikisakiName());
                detailView.setPrefName(rsList.get(i).getTPrefName());
                detailView.setAddress1(rsList.get(i).getTAddress1());
                detailView.setAddress2(rsList.get(i).getTAddress2());
                detailView.setTorihikisakiSeq(rsList.get(i).getTorihikisakiSeq());
                detailList.add(detailView);
            }
            view.setDetailList(detailList);
        }
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
