package net.chintai.backend.sysadmin.shop_bukken.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopListingUpdateView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingUpdateConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingUpdateConfirmInServiceBean;
import net.chintai.batch.common.domain.MstShopKeiyakuKanri;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 店舗リスティング設定情報更新
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingUpdateCommitAction extends BaseActionSupport {

	@Autowired
	private MasterService masterService;

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        context.setForward("success");

        // 画面リロード対策
        if (!isTokenValid(context.getRequest())) {
            return;
        }
        resetToken(context.getRequest());

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ShopListingUpdateCommitInServiceBean inBean =
                new ShopListingUpdateCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();

        // 操作ログ記録サービス
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        ShopListingUpdateConfirmService checkService =
                (ShopListingUpdateConfirmService) ac
                        .getBean("shopListingUpdateConfirmService");

        ShopListingUpdateConfirmInServiceBean inCheckBean
            = new ShopListingUpdateConfirmInServiceBean();

        // 更新者ID、更新プログラム設定
        inBean.setUserId(context.getSessionBean().getUserId());
        inBean.setPgName(this.getClass().getName());

        // viewHelper設定(店舗リスティング)
        ShopListingUpdateView view = new ShopListingUpdateView();

        // 操作ログ記録為、更新取引先のシーケンス番号を設定
        String updTarget ="店舗コード " + inBean.getShopCd() +
                          " 契約コード "+ inBean.getKeiyakuCd() +
                          " 契約サブコード " + inBean.getKeiyakuSubCd();

        // 日付重複チェック
        try {
            BeanUtils.copyProperties(inCheckBean, form);
            checkService.countApplyYmdh(inCheckBean);
        } catch (ApplicationException e) {
            // 更新失敗ログ、メッセージ設定
            loggingService.write("01018", inBean.getUserId(), SessionStatus.FAILURE, updTarget,this.getClass().getName());

            context.setError("ERROR.M.SHOP_BUKKEN.0018");
            return;
        }

        ShopListingUpdateCommitService service =
                (ShopListingUpdateCommitService) ac
                        .getBean("shopListingUpdateCommitService");

        final MstShopKeiyakuKanri mstShopKeiyakuKanri = masterService.selectMstShopKeiyakuKanriByPrimaryKey(inBean.getKeiyakuCd(), inBean.getKeiyakuSubCd());
        String keiyakuName = "";
        if(mstShopKeiyakuKanri != null){
        	keiyakuName = mstShopKeiyakuKanri.getKeiyakuName();
        }

        // 更新開始
        try {
            service.updateShopListing(inBean);

            // 更新成功ログ、メッセージ設定
            loggingService.write("01018", inBean.getUserId(), SessionStatus.SUCCESS, updTarget,this.getClass().getName());

            context.setMessage("INFO.M.SHOP_BUKKEN.0025", keiyakuName);

        } catch (ApplicationException e) {

            // 更新失敗ログ、メッセージ設定
            loggingService.write("01018", inBean.getUserId(), SessionStatus.FAILURE, updTarget,this.getClass().getName());

            context.setError("ERROR.M.SHOP_BUKKEN.0018");
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
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

}
