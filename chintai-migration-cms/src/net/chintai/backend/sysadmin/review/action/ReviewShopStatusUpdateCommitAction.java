/*
 * $Id: ReviewShopStatusUpdateCommitAction.java 4342 2009-08-19 04:33:40Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import jp.co.interoffice.util.Utils;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.crnwl.aop.IdHolder;
import net.chintai.backend.sysadmin.crnwl.dto.Shop;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.review.service.ReviewShopStatusUpdateCommitService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopStatusUpdateCommitInServiceBean;
import net.chintai.batch.common.aop.PgHolder;
import net.chintai.batch.common.domain.ShopRireki;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 店舗対象外設定更新アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4342 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopStatusUpdateCommitAction extends BaseActionSupport {
	@Autowired
	private ShopService shopService;
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

        // 画面データを取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ReviewShopStatusUpdateCommitInServiceBean inBean =
                new ReviewShopStatusUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);
        inBean.setUpdId(context.getSessionBean().getUserId());

        // プログラムID設定
        inBean.setUpdPg(this.getClass().getName());

        // injection
        ApplicationContext ac = getWebApplicationContext();

        // 画面リロード対策
        if (isTokenValid(context.getRequest())) {

            resetToken(context.getRequest());

            ReviewShopStatusUpdateCommitService service =
                    (ReviewShopStatusUpdateCommitService) ac
                            .getBean("reviewShopStatusUpdateCommitService");

            // 操作ログ記録サービス
            OperationLoggingService loggingService =
                    (OperationLoggingService) ac.getBean("operationLoggingService");

            try {
                // 店舗管理テーブル更新
                //service.updateShopStatus(inBean);

                final Shop dto = new Shop();
                dto.setShopcd(inBean.getShopCd());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                dto.setShopKanriUpdDt(sdf.parse(inBean.getUpdDt()));

        		ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(inBean.getShopCd());
        		shopRireki.setSyokaiShinsaSkipFlg(inBean.getSyokaiShinsaSkipFlg());
        		shopRireki.setTeikiShinsaSkipFlg(inBean.getTeikiShinsaSkipFlg());
        		shopRireki.setMailSendSkipFlg(inBean.getMailSendSkipFlg());
        		shopRireki.setAutodelSkipFlg(inBean.getAutoDelSkipFlg());
        		shopRireki.setShinsaSkipBikou(inBean.getShinsaSkipBikou());

        		dto.setShopRireki(shopRireki);

        		PgHolder.setPg(inBean.getUpdPg());
    			IdHolder.setId(inBean.getUpdId());
        		final Integer pkShopRireki = this.shopService.updateShopRireki(dto);
        		PgHolder.resetPg();
    			IdHolder.resetId();

                // 更新成功ログ、メッセージ設定
                loggingService.write("05001", inBean.getUpdId(), SessionStatus.SUCCESS,
                        ApplicationResources.getProperty("review.shopCd") + inBean.getShopCd(), this.getClass().getName());
                context.setMessage("INFO.M.REVIEW.0013", ApplicationResources
                        .getProperty("review.shopStatus"));

            } catch (/* ApplicationException */final Exception e) {
                // 更新失敗ログ
                loggingService.write("05001", inBean.getUpdId(), SessionStatus.FAILURE,
                        ApplicationResources.getProperty("review.shopCd") + inBean.getShopCd(), this.getClass().getName());

             // エラーメッセージをセット
                context.setError("ERROR.M.REVIEW.0081");
            }

        }

        context.setForward("success");
    }

}
