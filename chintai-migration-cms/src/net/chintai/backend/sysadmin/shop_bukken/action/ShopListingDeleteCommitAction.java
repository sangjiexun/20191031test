package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.Arrays;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingDeleteCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingDeleteCommitInServiceBean;
import net.chintai.batch.common.domain.MstShopKeiyakuKanri;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 店舗リスティん設定情報削除
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDeleteCommitAction extends BaseActionSupport {

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
        ShopListingDeleteCommitInServiceBean inBean =
                new ShopListingDeleteCommitInServiceBean();
        BeanUtils.copyProperties(inBean, form);


        inBean.setUpdId(context.getSessionBean().getUserId());
        inBean.setUpdPg(this.getClass().getName());

        // injenction
        ApplicationContext ac = getWebApplicationContext();
        ShopListingDeleteCommitService service =
                (ShopListingDeleteCommitService) ac
                        .getBean("shopListingDeleteCommitService");

        // 操作ログ記録為、削除IDを設定
        String delIdList = Arrays.asList(inBean.getDelFlgList()).toString();

        // 操作ログ記録サービス
        OperationLoggingService loggingService =
                (OperationLoggingService) ac.getBean("operationLoggingService");

        String updTarget =
                "店舗コード" +  inBean.getShopCd()  +
                " 契約コード" +  inBean.getKeiyakuCd() +
                " 契約サブコード" + inBean.getKeiyakuSubCd();

        final MstShopKeiyakuKanri mstShopKeiyakuKanri = masterService.selectMstShopKeiyakuKanriByPrimaryKey(inBean.getKeiyakuCd(), inBean.getKeiyakuSubCd());
        String keiyakuName = "";
        if(mstShopKeiyakuKanri != null){
        	keiyakuName = mstShopKeiyakuKanri.getKeiyakuName();
        }

        try {
            // 店舗管理テーブル更新
            service.deleteKeiyakuInfo(inBean);

            // 更新成功ログ、メッセージ設定
            loggingService.write("01019", inBean.getUpdId(), SessionStatus.SUCCESS, updTarget, this.getClass().getName());
            context.setMessage("INFO.M.SHOP_BUKKEN.0029",  keiyakuName);

        } catch (ApplicationException e) {
            // 更新失敗ログ、メッセージ設定
            loggingService.write("01019", inBean.getUpdId(), SessionStatus.FAILURE, updTarget, this.getClass().getName());

            context.setError(e.getErrorId(),e.getPlaceHolders());
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
