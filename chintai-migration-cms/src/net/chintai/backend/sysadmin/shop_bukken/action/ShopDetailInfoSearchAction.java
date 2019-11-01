/*
 * $Id: ShopDetailInfoSearchAction.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/02  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.CodeProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopDetailInfoSearchView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopDetailInfoSearchService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDetailInfoSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDetailInfoSearchOutServiceBean;
import net.chintai.batch.common.domain.ShopReserve;
import net.chintai.batch.common.domain.ShopRireki;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

/**
 * 店舗詳細画面を表示するアクション
 *
 * @author Sim-JongYeon
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopDetailInfoSearchAction extends BaseActionSupport {


    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ShopDetailInfoSearchInServiceBean inBean = new ShopDetailInfoSearchInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ShopDetailInfoSearchService service =
                (ShopDetailInfoSearchService) ac.getBean("shopDetailInfoSearchService");

        // 店舗詳細取得
        ShopDetailInfoSearchOutServiceBean outBean = service.shopSearchByShopCd(inBean);
/*
        // マスタ画像パスを取得用InServiceBeanを設定。
        ImageUrlFromMasterServerInServiceBean imgUrlInServiceBean =
                new ImageUrlFromMasterServerInServiceBean();

        // 画像別作業コードを取得。
        String mapPctWorkCode = ApplicationResources.getProperty("shop.mapPctWorkCode");
        String photo1WorkCode = ApplicationResources.getProperty("shop.photo1WorkCode");
        String photo2WorkCode = ApplicationResources.getProperty("shop.photo2WorkCode");
        String photo3WorkCode = ApplicationResources.getProperty("shop.photo3WorkCode");
        String photo4WorkCode = ApplicationResources.getProperty("shop.photo4WorkCode");

        List<String> inWorkCdList = new ArrayList<String>();

        if (ConstValues.FLG_ON.equals(outBean.getShopMapPctFlgOrg())) {
            inWorkCdList.add(mapPctWorkCode);
        }
        if (ConstValues.FLG_ON.equals(outBean.getShopPhoto1FlgOrg())) {
            inWorkCdList.add(photo1WorkCode);
        }
        if (ConstValues.FLG_ON.equals(outBean.getShopPhoto2FlgOrg())) {
            inWorkCdList.add(photo2WorkCode);
        }
        if (ConstValues.FLG_ON.equals(outBean.getShopPhoto3FlgOrg())) {
            inWorkCdList.add(photo3WorkCode);
        }
        if (ConstValues.FLG_ON.equals(outBean.getShopPhoto4FlgOrg())) {
            inWorkCdList.add(photo4WorkCode);
        }


        imgUrlInServiceBean.setShopCd(inBean.getShopCd());
        imgUrlInServiceBean.setWorkCdList(inWorkCdList);

        // マスタ画像サーバーの画像パスを取得するInjection
        ImageUrlFromMasterServerService imageUrlFromMasterServerService =
                (ImageUrlFromMasterServerService) ac.getBean("imageUrlFromMasterServerService");

        imgUrlInServiceBean.setWorkCdList(inWorkCdList);

     // マスタ画像サーバーパスを取得。
        ImageUrlFromMasterServerOutServiceBean imgUrlOutServiceBean =
                imageUrlFromMasterServerService.imageUrlFromMasterServer(imgUrlInServiceBean);
*/
        // 店舗詳細をViewHelperに設定
        ShopDetailInfoSearchView view = new ShopDetailInfoSearchView();
        BeanUtils.copyProperties(view, outBean);
/*
        // 取得された画像パスをViewHelperに設定。
        List<String> outWorkCdList = imgUrlOutServiceBean.getWorkCdList();
        for (int i = 0; i < outWorkCdList.size(); i++) {
            String outWorkCd = outWorkCdList.get(i);
            if (mapPctWorkCode.equals(outWorkCd)) {
                view.setShopMapPctFilePath(imgUrlOutServiceBean.getImageUrlPathList().get(i));
            }
            if (photo1WorkCode.equals(outWorkCd)) {
                view.setShopPhoto1FilePath(imgUrlOutServiceBean.getImageUrlPathList().get(i));
            }
            if (photo2WorkCode.equals(outWorkCd)) {
                view.setShopPhoto2FilePath(imgUrlOutServiceBean.getImageUrlPathList().get(i));
            }
            if (photo3WorkCode.equals(outWorkCd)) {
                view.setShopPhoto3FilePath(imgUrlOutServiceBean.getImageUrlPathList().get(i));
            }
            if (photo4WorkCode.equals(outWorkCd)) {
                view.setShopPhoto4FilePath(imgUrlOutServiceBean.getImageUrlPathList().get(i));
            }
        }
*/

        final ShopRireki shopRireki = outBean.getShopRireki();

        final List<ShopReserve> shopReserveList = outBean.getShopReserve();
        boolean isSystemStatusUpdate = false;
        boolean isKeisaiUpdate = false;
        boolean isShopApprovalUpdate = false;
        boolean isShopUpdate = false;

        if(shopReserveList != null && shopReserveList.size() > 0){
        	for(ShopReserve shopReserve: shopReserveList){
        		String shopStatus = shopReserve.getShopStatus();
        		String certifyFlg = shopReserve.getCertifyFlg();
        		String ablStatus = shopReserve.getAblStatus();
        		String ctStatus = shopReserve.getCtStatus();

        		if(!shopRireki.getShopStatus().equals(shopStatus)){
        			isSystemStatusUpdate = true;
        		}

        		if(!shopRireki.getCtStatus().equals(ctStatus) || !shopRireki.getAblStatus().equals(ablStatus)){
        			isKeisaiUpdate = true;
        		}

        		if(!shopRireki.getCertifyFlg().equals(certifyFlg)){
        			isShopApprovalUpdate = true;
        		}

        		if(shopRireki.getShopStatus().equals(shopStatus) &&
        			shopRireki.getCtStatus().equals(ctStatus) &&
        			shopRireki.getAblStatus().equals(ablStatus) &&
        			shopRireki.getCertifyFlg().equals(certifyFlg)){
        			isShopUpdate = true;
        		}
        	}
        }

        if(isSystemStatusUpdate){
        	saveMsg(context, "INFO.M.SHOP_BUKKEN.0032");
        }
        if(isKeisaiUpdate){
        	saveMsg(context, "INFO.M.SHOP_BUKKEN.0033");
        }
        if(isShopApprovalUpdate){
        	saveMsg(context, "INFO.M.SHOP_BUKKEN.0034");
        }
        if(isShopUpdate){
        	saveMsg(context, "INFO.M.SHOP_BUKKEN.0035");
        }

        context.getRequest().setAttribute("userId", context.getSessionBean().getUserId());
        context.setForward("success", view);
    }

    protected void saveMsg(BusinessContext context, final String messageId, final String... placeHolders) {
		final String messageKey = CodeProperties.getProperty(messageId);

		ActionMessages errors = (ActionMessages)context.getRequest().getSession().getAttribute(Globals.MESSAGE_KEY);
		if(errors == null){
			errors = new ActionMessages();
		}
		final ActionMessage error = new ActionMessage(messageKey, placeHolders);
		errors.add(error.getKey(), error);
		//redirectAttrs.addFlashAttribute(Globals.MESSAGE_KEY, errors);
		context.getRequest().getSession().setAttribute(Globals.MESSAGE_KEY, errors);
	}

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

}
