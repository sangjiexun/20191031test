/*
 * $Id: TorihikisakiInfoForBindAction.java 3850 2008-03-10 05:40:33Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiInfoForBindView;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiInfoForBindView.TorihikisakiInfoForBindDetailView;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiInfoForBindService;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoForBindInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoForBindOutServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoOutServiceBean;

/**
 * 取引先詳細(店舗コード紐付：取引先検索用)
 * 
 * @author lee-hosup
 * @version $Revision: 3850 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiInfoForBindAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        TorihikisakiInfoForBindInServiceBean inBean = new TorihikisakiInfoForBindInServiceBean();
        inBean.setTorihikisakiSeq(context.getRequest().getParameter("torihikisakiSeq"));

        // injection
        ApplicationContext ac = getWebApplicationContext();
        TorihikisakiInfoForBindService service =
                (TorihikisakiInfoForBindService) ac.getBean("torihikisakiInfoForBindService");

        // 取引先詳細照会
        TorihikisakiInfoForBindOutServiceBean outBean;
        try {
            outBean = service.getTorihikisakiDetailInfo(inBean);
        } catch (ApplicationException e) {
            context.setForward("fail");
            context.setError("ERROR.M.DEMAND.0130");
            return;
        }

        // 取引先物件枠情報照会
        TorihikisakiWakuInfoInServiceBean wakuInBean = new TorihikisakiWakuInfoInServiceBean();
        wakuInBean.setTorihikisakiSeq(outBean.getTorihikisakiSeq());

        TorihikisakiWakuInfoService wakuInfoService =
                (TorihikisakiWakuInfoService) ac.getBean("torihikisakiWakuInfoService");
        List<TorihikisakiWakuInfoOutServiceBean> wakuList =
                (List<TorihikisakiWakuInfoOutServiceBean>) wakuInfoService.getTorihikisakiWakuInfo(wakuInBean);

        // viewHelper設定(取引先詳細)
        TorihikisakiInfoForBindView view = new TorihikisakiInfoForBindView();
        BeanUtils.copyProperties(view, outBean);

        // viewHelper設定(物件枠詳細)
        List<TorihikisakiInfoForBindDetailView> detailList = new ArrayList<TorihikisakiInfoForBindDetailView>();

        for (int i = 0; i < wakuList.size(); i++) {
            TorihikisakiInfoForBindDetailView detailView = view.new TorihikisakiInfoForBindDetailView();
            BeanUtils.copyProperties(detailView, wakuList.get(i));

            // 適用月(画面出力用)設定
            detailView.setStartYm(DemandUtils.convertDate(detailView.getStartYm()));
            detailList.add(detailView);
        }

        view.setWakuInfoList(detailList);
        view.setZipCd(DemandUtils.convertZipCd(view.getZipCd()));
        context.setForward("success", view);
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

}
