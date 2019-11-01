package net.chintai.backend.sysadmin.master.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.service.OperationLoggingService;
import net.chintai.backend.sysadmin.master.action.view.RendoSendUpdateView;
import net.chintai.backend.sysadmin.master.service.RendoSendService;
import net.chintai.backend.sysadmin.master.service.bean.RendoSendInServiceBean;
import net.chintai.batch.common.GenericFlg;
import net.chintai.batch.common.domain.MstShopKeiyakuKanri;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 連動元許可情報更新
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RendoSendUpdateCommitAction extends BaseActionSupport {

	@Autowired
	private MasterService masterService;

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面リロード対策
    	RendoSendUpdateView view = new RendoSendUpdateView();
    	BeanUtils.copyProperties(view, context.getForm());
    	context.setViewHelper(view);
        if (!isTokenValid(context.getRequest(), true)) {
        	context.setForward("success");
        	return;
        }

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        RendoSendInServiceBean inBean = new RendoSendInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();

        // 操作ログ記録サービス
        OperationLoggingService loggingService =(OperationLoggingService) ac.getBean("operationLoggingService");

        RendoSendService service =(RendoSendService) ac.getBean("rendoSendService");

        // 契約名取得
        MstShopKeiyakuKanri mstShopKeiyakuKanri = masterService.selectMstShopKeiyakuKanriByPrimaryKey(inBean.getKeiyakuCd(), inBean.getKeiyakuSubCd());
		if (mstShopKeiyakuKanri == null || mstShopKeiyakuKanri.getRendoSendKanriFlg().equals(GenericFlg.OFF.getValue())) {
			throw new ApplicationException("FETAL.M.SYSTEM.0001");
		}
        // 更新者ID、更新プログラム設定
        inBean.setUserId(context.getSessionBean().getUserId());
        inBean.setPgName(this.getClass().getName());

        // 操作ログ記録為、更新取引先のシーケンス番号を設定
        String updTarget ="連動元コード " + inBean.getRendoCd() +
                          " 契約コード "+ inBean.getKeiyakuCd() +
                          " 契約サブコード " + inBean.getKeiyakuSubCd();

        // 更新開始
        try {
            service.updateRendoSend(inBean);

            // 更新成功ログ、メッセージ設定
            loggingService.write("08006", inBean.getUserId(), SessionStatus.SUCCESS, updTarget,this.getClass().getName());
            if (inBean.getProcKbn().equals("update")) {
            	context.setMessage("INFO.M.MASTER.0010", mstShopKeiyakuKanri.getRendoSendDispName());
            } else if (inBean.getProcKbn().equals("insert")) {
            	context.setMessage("INFO.M.MASTER.0011", mstShopKeiyakuKanri.getRendoSendDispName());
            } else if (inBean.getProcKbn().equals("delete")) {
            	context.setMessage("INFO.M.MASTER.0012", mstShopKeiyakuKanri.getRendoSendDispName());
            }
            context.setForward("success");
        } catch (ApplicationException e) {
            // 更新失敗ログ、メッセージ設定
            loggingService.write("08006", inBean.getUserId(), SessionStatus.FAILURE, updTarget,this.getClass().getName());
            context.setError(e.getErrorId(), e.getPlaceHolders());
            context.setForward("fail");
            throw new ApplicationException(e.getErrorId(), e.getPlaceHolders());
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
