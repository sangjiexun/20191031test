/*
 * $Id: MatchingDataDownloadPageAction.java 4373 2009-09-07 05:50:05Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/24     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.addata_matching.action.view.MatchingDataListView;
import net.chintai.backend.sysadmin.addata_matching.service.MatchingDataListService;
import net.chintai.backend.sysadmin.addata_matching.service.bean.MatchingDataListInServiceBean;
import net.chintai.backend.sysadmin.addata_matching.service.bean.MatchingDataListOutServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.context.ApplicationContext;

/**
 * 照合結果ダウンロード画面アクション
 * @author e-ishii
 * @version $Revision: 4373 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MatchingDataDownloadPageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai
     * .backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        MatchingDataListInServiceBean inServiceBean = new MatchingDataListInServiceBean();

        // セッションに検索条件を保存
        context.getSessionBean().getSearchConditionMap().put(SessionSearchKey.MATCHING_DATA_LIST,
                inServiceBean);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.parseInt(SystemProperties
                .getProperty("C_MATCHING_DATA_LIST_DISPLAY_LIMIT")));

        // 開始位置
        condition.setOffset(inServiceBean.getOffSet());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        MatchingDataListService matchingDataListService =
                (MatchingDataListService) ac.getBean("matchingDataListService");

        // 照合結果一覧の取得
        List<MatchingDataListOutServiceBean> matchingDataList =
                matchingDataListService.getMatchingDataList(inServiceBean, condition);

        // viewHelper設定
        List<MatchingDataListView.MatchingDataListDetailView> viewList =
                new ArrayList<MatchingDataListView.MatchingDataListDetailView>();

        MatchingDataListView view = new MatchingDataListView(condition);

        if (CollectionUtils.isEmpty(matchingDataList)) {
            context.setError("WARN.M.ADDATA_MATCHING.0004");
        } else {
            for (int i = 0; i < matchingDataList.size(); i++) {
                MatchingDataListView.MatchingDataListDetailView matchingDetail =
                        view.new MatchingDataListDetailView();

                BeanUtilsWrapper.copyProperties(matchingDetail, matchingDataList.get(i));

                viewList.add(matchingDetail);
            }
            view.setMatchingDataList(viewList);
        }
        context.setForward("success", view);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java
     * .lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.ADDATA_MATCHING);
    }

}