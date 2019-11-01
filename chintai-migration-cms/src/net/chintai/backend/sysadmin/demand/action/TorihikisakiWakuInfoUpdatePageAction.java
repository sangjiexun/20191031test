/*
 * $Id: TorihikisakiWakuInfoUpdatePageAction.java 3677 2007-12-20 04:40:32Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiWakuInfoUpdateView;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiInfoService;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoUpdagePageService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoOutServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoUpdatePageOutServiceBean;

/**
 * 取引先物件枠設定情報更新
 *
 * @author lee-hosup
 * @version $Revision: 3677 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoUpdatePageAction extends BaseActionSupport {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        String torihikisakiSeq   = context.getRequest().getParameter("torihikisakiSeq");
        String startYm           = context.getRequest().getParameter("startYm");
        String torihikisakiUpdDt = context.getRequest().getParameter("torihikisakiUpdDt");

        TorihikisakiInfoInServiceBean inBean = new TorihikisakiInfoInServiceBean();
        inBean.setTorihikisakiSeq(torihikisakiSeq);

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

        // 物件枠設定情報照会
        TorihikisakiWakuInfoUpdatePageInServiceBean wakuInfoInBean =
                new TorihikisakiWakuInfoUpdatePageInServiceBean();
        wakuInfoInBean.setTorihikisakiSeq(torihikisakiSeq);
        wakuInfoInBean.setStartYm(startYm);

        TorihikisakiWakuInfoUpdagePageService wakuInfoService =
                (TorihikisakiWakuInfoUpdagePageService) ac
                        .getBean("torihikisakiWakuInfoUpdatePageService");

        TorihikisakiWakuInfoUpdatePageOutServiceBean wakuOutBean =
                wakuInfoService.getTorihikisakiWakuInfo(wakuInfoInBean);

        // viewHelper設定(取引先詳細)
        TorihikisakiWakuInfoUpdateView view = new TorihikisakiWakuInfoUpdateView();
        BeanUtils.copyProperties(view, outBean);
        view.setBukkenCnt(wakuOutBean.getBukkenCnt());
        view.setTokusenCnt(wakuOutBean.getTokusenCnt());

        view.setStartYm(startYm);
        view.setStartYmForDisplay(DemandUtils.convertDate(startYm));
        view.setTorihikisakiUpdDt(torihikisakiUpdDt);

        // チェックボックス初期表示のための処理
        this.checkCntValues(view);

        // 郵便番号画面表示形式に編集
        view.setZipCd(DemandUtils.convertZipCd(view.getZipCd()));

        context.setForward("success", view);
    }

    /**
     * DBの物件枠、物件リスティングデータに基づいて<br>
     * 画面のチェックボックス状態を設定します。
     * @param view
     */
    private void checkCntValues(TorihikisakiWakuInfoUpdateView view) {

        List bukkenCntValues =
                Arrays.asList((SystemProperties.getProperty("demand.bukkenCntValues")).split(","));
        List tokusenCntValues =
            Arrays.asList((SystemProperties.getProperty("demand.tokusenCntValues")).split(","));

        if (!(bukkenCntValues.contains(view.getBukkenCnt()))) {
            view.setBukkenCntNote(view.getBukkenCnt());
            view.setBukkenCnt("999999");
        }

        if (!(tokusenCntValues.contains(view.getTokusenCnt()))) {
            view.setTokusenCntNote(view.getTokusenCnt());
            view.setTokusenCnt("999999");
        }
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
