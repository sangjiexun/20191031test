/*
 * $Id: TetudoGaishaSearchPagingAction.java 4076 2008-11-19 09:33:13Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/10/08  BGT)長谷川正一 新規作成
 *
 */
package net.chintai.backend.sysadmin.master.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.master.action.view.TetudoGaishaSearchView;
import net.chintai.backend.sysadmin.master.service.TetudoGaishaSearchService;
import net.chintai.backend.sysadmin.master.service.bean.TetudoGaishaInSearchrviceBean;
import net.chintai.backend.sysadmin.master.service.bean.TetudoGaishaOutSearchServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 鉄道会社検索ページのページングアクション
 * 
 * @author S.HASEGAWA
 * @version $Revision: 4076 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class TetudoGaishaSearchPagingAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        // セッションから検索条件を取得
        TetudoGaishaInSearchrviceBean inServiceBean =
                (TetudoGaishaInSearchrviceBean) context.getSessionBean().getSearchConditionMap().get(
                        SessionSearchKey.TETUDO_GAISHA_SEARCH);
        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.valueOf((String) inServiceBean.getDisplayNum()));
        condition.setOffset(((Integer) form.get("offSet")).intValue());

        TetudoGaishaSearchView view = new TetudoGaishaSearchView(condition);

        // 鉄道会社取得サービスの宣言
        ApplicationContext ac = getWebApplicationContext();
        TetudoGaishaSearchService tetudoGaishaSearchService =
                (TetudoGaishaSearchService) ac.getBean("tetudoGaishaSearchService");

        // 鉄道会社リストを取得
        List<TetudoGaishaOutSearchServiceBean> rsTetudoGaishaList = null;
        rsTetudoGaishaList = tetudoGaishaSearchService.tetudoGaishaSearch(inServiceBean, condition);

        // 鉄道会社検索結果リスト
        List<TetudoGaishaSearchView.TetudoGaishaSearchDetailView> tetudoGaishaList =
                new ArrayList<TetudoGaishaSearchView.TetudoGaishaSearchDetailView>();

        // 鉄道会社検索結果リストが1件も存在しなかった場合、エラー
        if (rsTetudoGaishaList.isEmpty()) {
            context.setError("WARN.M.MASTER.0041");
        }

        // 鉄道会社検索結果リストに取得した鉄道会社情報をセットする
        for (int i = 0; i < rsTetudoGaishaList.size(); i++) {
            TetudoGaishaOutSearchServiceBean serviceBean = (TetudoGaishaOutSearchServiceBean) rsTetudoGaishaList.get(i);

            TetudoGaishaSearchView.TetudoGaishaSearchDetailView detailView = view.new TetudoGaishaSearchDetailView();
            BeanUtils.copyProperties(detailView, serviceBean);

            tetudoGaishaList.add(detailView);
        }
        // viewに鉄道会社検索結果リストをセットする
        view.setTetudoGaishaSearchList(tetudoGaishaList);

        // 検索条件をviewにセット
        BeanUtils.copyProperties(view, inServiceBean);
        context.setForward("success", view);

    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        // 鉄道会社CSVファイル名を取得
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.MASTER);
    }

}
