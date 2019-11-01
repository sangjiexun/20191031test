/*
 * $Id: ReviewBukkenSearchAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.review.action.view.ReviewBukkenSearchView;
import net.chintai.backend.sysadmin.review.action.view.ReviewBukkenSearchView.ReviewBukkenSearchDetailView;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenSearchService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenSearchInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenSearchOutServiceBean;

/**
 * 物件検索アクション
 * @author Lee Hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenSearchAction extends BaseActionSupport {

    /** 画面表示用 */
    // ReviewBukkenSearchPagingAction,ReviewShopBukkenSearchActionもこれを使ってます。
    static final String C_APPEND_STR = "<br>削除予定";

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.REVIEW);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ReviewBukkenSearchInServiceBean inBean = new ReviewBukkenSearchInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        final String bkKanri = (String) form.get("bkKanri");
        if(StringUtils.isNotEmpty(bkKanri)){
            //ハイフンを取り除く
            final String replaceBkKanri = bkKanri.replaceAll("-", "");
            if(StringUtils.isNotEmpty(replaceBkKanri) && replaceBkKanri.length() == 28){
                final String bkKanriShopcd = replaceBkKanri.substring(0,  9);
                final String bkKanriBkcd = replaceBkKanri.substring(9,  24);
                final String bkKanriRoomno = replaceBkKanri.substring(24,  28);

                inBean.setBkKanriShopcd(bkKanriShopcd);
                inBean.setBkKanriBkcd(bkKanriBkcd);
                inBean.setBkKanriRoomno(bkKanriRoomno);
            }
        }

        // 検索ボタンで実行される場合セッションに検索条件を格納
        context.getSessionBean().getSearchConditionMap()
                .put(SessionSearchKey.REVIEW_BUKKEN_SEARCH, inBean);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.valueOf(SystemProperties
                .getProperty("C_SHINSA_BUKKEN_SEARCH_DISPLAY_LIMIT")));
        condition.setOffset(((Integer) form.get("offSet")).intValue());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ReviewBukkenSearchService service =
                (ReviewBukkenSearchService) ac.getBean("reviewBukkenSearchService");
/*
        if(StringUtils.isNotEmpty(inBean.getShinsaStartDtTo()) || StringUtils.isNotEmpty(inBean.getShinsaStartDtFrom())){
        	//CT_KEISAI_BUKKENを結合して検索
        	inBean.setChkFlgShinsaStartDt("1");
        }
*/
        List<ReviewBukkenSearchOutServiceBean> rsList =
                service.getBukkenSearchList(inBean, condition);

        ReviewBukkenSearchView view = new ReviewBukkenSearchView(condition);

        // 検索条件コピー
        BeanUtils.copyProperties(view, form);

        List<ReviewBukkenSearchDetailView> detailList =
                new ArrayList<ReviewBukkenSearchDetailView>();
        if (rsList.size() > 0) {
            for (int i = 0; i < rsList.size(); i++) {
                ReviewBukkenSearchDetailView detailView = view.new ReviewBukkenSearchDetailView();
                BeanUtils.copyProperties(detailView, rsList.get(i));
                /*
                if (detailView.getSyokaiSyoriKbn().length() > 2) {
                    detailView.setSyokaiSyoriKbn(rsList.get(i).getSyokaiSyoriKbn() + C_APPEND_STR);
                }
                if (detailView.getTeikiSyoriKbn().length() > 2) {
                    detailView.setTeikiSyoriKbn(rsList.get(i).getTeikiSyoriKbn() + C_APPEND_STR);
                }
                */
                detailList.add(detailView);
            }
        } else {
            context.setError("WARN.M.REVIEW.0014");
        }
        view.setBukkenList(detailList);
        context.setForward("success", view);
    }
}
