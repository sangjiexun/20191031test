/*
 * $Id: FudousanInfoAction.java 3850 2008-03-10 05:40:33Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/29     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.action.view.FudousanInfoView;
import net.chintai.backend.sysadmin.demand.action.view.FudousanInfoView.TorihikisakiListDetailView;
import net.chintai.backend.sysadmin.demand.service.FudousanInfoService;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiListService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanInfoInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanInfoOutServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiListInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiListOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

/**
 * 不動産会社詳細
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3850 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanInfoAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

    protected void doExecute(BusinessContext context) throws Exception {

        // パラメータから不動産会社コードを取得
        String fudousanCd = context.getRequest().getParameter("fudousanCd");

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // 取引先一覧
        TorihikisakiListInServiceBean inBean = new TorihikisakiListInServiceBean();
        inBean.setTorihikisakiCd1(fudousanCd);

        TorihikisakiListService service =
                (TorihikisakiListService) ac.getBean("torihikisakiListService");

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.parseInt(SystemProperties
                .getProperty("C_TORIHIKISAKI_LIST_FOR_FUDOUSAN_DISPLAY_LIMIT")));
        condition.setOffset(inBean.getOffSet());

        // 取引先一覧検索
        List<TorihikisakiListOutServiceBean> rsList =
                service.getTorihikisakiList(inBean, condition);

        // viewHelper設定
        FudousanInfoView view = new FudousanInfoView(condition);
        if (rsList.size() > 0) {
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

        // ページング情報
        view.setOffset(inBean.getOffSet());

        // 不動産会社詳細
        FudousanInfoInServiceBean inServiceBean = new FudousanInfoInServiceBean();
        inServiceBean.setFudousanCd(fudousanCd);

        FudousanInfoService fudousanInfoService =
                (FudousanInfoService) ac.getBean("fudousanInfoService");

        // 不動産会社情報を検索
        FudousanInfoOutServiceBean outBean = null;
        try {
            outBean = fudousanInfoService.fudousanInfo(inServiceBean);
        } catch (ApplicationException e) {
            context.setForward("fail");
            context.setError("ERROR.M.DEMAND.0125");
            return;
        }

        // 不動産詳細情報をViewHelperに設定
        BeanUtils.copyProperties(view, outBean);

        context.setForward("success", view);
    }

}
