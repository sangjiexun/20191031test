/*
 * $Id: MatchingDataDownloadPagingAction.java 4381 2009-09-08 02:33:31Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/26     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

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


/**
 * 照合結果一覧画面ページング処理
 * @author e-ishii
 * @version $Revision: 4381 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MatchingDataDownloadPagingAction extends BaseActionSupport {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.
     * BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    protected void doExecute(BusinessContext context) throws Exception {

        // セッションから検索条件取得
        MatchingDataListInServiceBean inBean =
                (MatchingDataListInServiceBean) context.getSessionBean().getSearchConditionMap()
                        .get(SessionSearchKey.MATCHING_DATA_LIST);


        // ページングで遷移してきた場合画面から選択ページング情報を取得
        // offSetがヌル=パンくずなど、 offsetがヌルではない=ページング
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        if (form.get("offSet") != null) {
            inBean.setOffSet((Integer) form.get("offSet"));
        }

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.parseInt(SystemProperties
                .getProperty("C_MATCHING_DATA_LIST_DISPLAY_LIMIT")));
        condition.setOffset(inBean.getOffSet());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        MatchingDataListService service =
                (MatchingDataListService) ac.getBean("matchingDataListService");

        //検索開始
        List<MatchingDataListOutServiceBean> matchingDataList =
            service.getMatchingDataList(inBean,condition);

        // viewHelper設定
        List<MatchingDataListView.MatchingDataListDetailView> viewList =
                new ArrayList<MatchingDataListView.MatchingDataListDetailView>();

        MatchingDataListView view = new MatchingDataListView(condition);

        if(CollectionUtils.isEmpty(matchingDataList)) {
            context.setError("WARN.M.ADDATA_MATCHING.0004");
        }
        else {
            for (int i = 0; i < matchingDataList.size(); i++) {
                MatchingDataListView.MatchingDataListDetailView matchingDetail
                                                = view.new MatchingDataListDetailView();

                BeanUtilsWrapper.copyProperties(matchingDetail,matchingDataList.get(i));

                viewList.add(matchingDetail);
            }
            view.setMatchingDataList(viewList);
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