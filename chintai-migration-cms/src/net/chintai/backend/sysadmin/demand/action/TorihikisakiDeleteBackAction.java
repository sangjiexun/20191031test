/*
 * $Id: TorihikisakiDeleteBackAction.java 3680 2007-12-20 05:07:48Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
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
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiSearchView;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiSearchView.TorihikisakiSearchDetailView;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiSearchService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiSearchOutServiceBean;


/**
 * 取引先削除確認ページの戻るボタンのアクション<br>
 *
 * 検索結果の削除ボタン押下時のValidationCheckに
 * 引っ掛かったった場合もこのアクションが実行されます。
 * @author lee-hosup
 * @version $Revision: 3680 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiDeleteBackAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {


        // セッションから検索条件を取得
        TorihikisakiSearchInServiceBean inBean =
                (TorihikisakiSearchInServiceBean) context.getSessionBean().getSearchConditionMap()
                        .get(SessionSearchKey.DEMAND_TORIHIKISAKI_SEARCH);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        TorihikisakiSearchService service =
                (TorihikisakiSearchService) ac.getBean("torihikisakiSearchService");

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.parseInt(SystemProperties
                .getProperty("C_TORIHIKISAKI_SEARCH_DISPLAY_LIMIT")));
        condition.setOffset(inBean.getOffSet());

        // 検索開始
        List<TorihikisakiSearchOutServiceBean> rsList =
                service.getTorihikisakiList(inBean, condition);


        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        String[] delFlgList = (String[]) form.get("delFlgList");

        // viewHelper設定
        TorihikisakiSearchView view = new TorihikisakiSearchView(condition);
        if (rsList.size() > 0) {
            List<TorihikisakiSearchDetailView> detailList =
                    new ArrayList<TorihikisakiSearchDetailView>();
            for (int i = 0; i < rsList.size(); i++) {
                TorihikisakiSearchDetailView detailView = view.new TorihikisakiSearchDetailView();
                BeanUtils.copyProperties(detailView, rsList.get(i));
                detailList.add(detailView);

                if (this.checkArray(detailView.getTorihikisakiSeq(), delFlgList) ) {
                    detailView.setDelFlg("checked");
                }
            }
            view.setDetailList(detailList);
        } else {
            context.setError("WARN.M.DEMAND.0055");
        }

        // 検索条件をViewに設定
        BeanUtils.copyProperties(view, inBean);

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


    /**
     * 削除チェックフラグを設定します。
     * @param seq 取引先シーケンス番号
     * @param delFlgList 削除チェックされた取引先シーケンス番号の配列
     * @return 該当シーケンス番号が削除フラグリストに含まれているとTrueを
     *         含まれていないとFalseを返します。
     */
    public boolean checkArray(String seq, String[]delFlgList){
        boolean checkFlg = false;

        for (int i = 0; i < delFlgList.length; i++) {
            if (delFlgList[i].equals(seq)){
                checkFlg = true;
                return checkFlg;
            }
        }
        return checkFlg;
    }
}
