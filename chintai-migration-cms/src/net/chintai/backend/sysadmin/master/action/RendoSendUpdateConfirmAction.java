package net.chintai.backend.sysadmin.master.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.master.action.view.RendoSendUpdateView;
import net.chintai.backend.sysadmin.master.service.RendoSendService;
import net.chintai.backend.sysadmin.master.service.bean.RendoSendInServiceBean;
import net.chintai.batch.common.GenericFlg;
import net.chintai.batch.common.domain.MstRendo;
import net.chintai.batch.common.domain.MstShopKeiyakuKanri;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


/**
 * 連動元出稿許可情報の更新確認
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RendoSendUpdateConfirmAction extends BaseActionSupport {

	@Autowired
	MasterService masterService;

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        RendoSendInServiceBean inBean = new RendoSendInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // injection
        ApplicationContext ac = getWebApplicationContext();
        RendoSendService service = (RendoSendService) ac.getBean("rendoSendService");

        // viewHelper設定
        RendoSendUpdateView view = new RendoSendUpdateView();
        BeanUtils.copyProperties(view, form);
        MstShopKeiyakuKanri mstShopKeiyakuKanri = masterService.selectMstShopKeiyakuKanriByPrimaryKey(inBean.getKeiyakuCd(), inBean.getKeiyakuSubCd());
		if (mstShopKeiyakuKanri == null || mstShopKeiyakuKanri.getRendoSendKanriFlg().equals(GenericFlg.OFF.getValue())) {
			throw new ApplicationException("FETAL.M.SYSTEM.0001");
		}
		view.setKeiyakuName(mstShopKeiyakuKanri.getRendoSendDispName());
		MstRendo mstRendo = masterService.selectMstRendoByPrimaryKey(inBean.getRendoCd());
		if (mstRendo == null || mstRendo.getSendKanriFlg().equals(GenericFlg.OFF.getValue())) {
			throw new ApplicationException("FETAL.M.SYSTEM.0001");
		}
		BeanUtils.copyProperties(view, mstRendo);

        view.setNowDate(DateUtil.getToday("yyyyMMddHHmmss"));
        view.setApplyYearList(DemandUtils.getYearList());
        view.setPermitStartDtForDisplay(DemandUtils.convertDateAll(view.getPermitStartDt()));
        view.setPermitEndDtForDisplay(DemandUtils.convertDateAll(view.getPermitEndDt()));
        saveToken(context.getRequest());

        // 許可期間チェック
        try {
        	service.chkRendoSendDt(inBean);
        	saveToken(context.getRequest());
        	context.setForward("success",view);
        } catch (ApplicationException e) {
        	context.setError(e.getErrorId(), e.getPlaceHolders());
        	context.setForward("fail");
        }
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

}
