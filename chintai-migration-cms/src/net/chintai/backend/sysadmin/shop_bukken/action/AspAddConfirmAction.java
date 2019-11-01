/*
 * $Id: AspAddConfirmAction.java 3857 2008-03-10 05:48:16Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspAddConfirmView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspAddConfirmView.EnsenTypeListView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspAddConfirmView.PrefListDetailView;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspShopImgInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.AspAddConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.AspPrefInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.AspShopImageService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspAddConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspAddConfirmOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 不動産ASP設定情報登録確認画面へ遷移するアクション
 *
 * @author Sim-JongYeon
 * @version $Revision: 3857 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspAddConfirmAction extends BaseActionSupport {


	@Autowired
	private MasterService masterService;

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        AspAddConfirmInServiceBean aspAddConfirmInServiceBean = new AspAddConfirmInServiceBean();
        BeanUtils.copyProperties(aspAddConfirmInServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ShopInfoService shopInfoService = (ShopInfoService) ac.getBean("shopInfoService");

        // 不動産ASP設定情報の為に店舗コードを設定
        AspShopInfoInServiceBean shopInfoInServiceBean = new AspShopInfoInServiceBean();
        shopInfoInServiceBean.setShopCd(aspAddConfirmInServiceBean.getShopCd());

        // 店舗基本情報を取得
        AspShopInfoOutServiceBean rsShopInfo =
                shopInfoService.aspShopInfoSearchByShopCd(shopInfoInServiceBean);

        // 店舗基本情報をaspAddConfirmInServiceBeanに設定
        BeanUtils.copyProperties(aspAddConfirmInServiceBean, rsShopInfo);

        // Injection
        AspPrefInfoService aspPrefInfoService = (AspPrefInfoService) ac.getBean("aspPrefInfoService");

        // 取得したマスタ都道府県リストをaspAddConfirmInServiceBeanに設定
        aspAddConfirmInServiceBean.setPrefList(aspPrefInfoService.aspAreaPrefInfoSearch());

        // Injection
        AspAddConfirmService aspAddConfirmService =
                (AspAddConfirmService) ac.getBean("aspAddConfirmService");

        // requestから登録される不動産ASP設定情報を取得
        SortedMap<String, String[]> sortedMap =
                new TreeMap<String, String[]>(context.getRequest().getParameterMap());

        aspAddConfirmInServiceBean.setSortedMap(sortedMap);

        // 都道府県、沿線タイプの整列を行う
        AspAddConfirmOutServiceBean outServiceBean =
                aspAddConfirmService.aspAreaEnsenCheck(aspAddConfirmInServiceBean);

        // 整列された結果をViewHelperに設定
        AspAddConfirmView view = new AspAddConfirmView();
        BeanUtils.copyProperties(view, form);
        BeanUtils.copyProperties(view, outServiceBean);

        List<AspAddConfirmView.PrefListDetailView> prefListDetailViewList = new ArrayList<AspAddConfirmView.PrefListDetailView>();
        // 整列された都道府県を設定
        for(int i = 0; i < outServiceBean.getPrefList().size(); i++) {
            AspAddConfirmOutServiceBean.PrefListDetailView prefListDetailView = outServiceBean.getPrefList().get(i);
            AspAddConfirmView.PrefListDetailView pref = view.new PrefListDetailView();
            BeanUtils.copyProperties(pref, prefListDetailView);

            prefListDetailViewList.add(pref);
        }
        view.setPrefList(prefListDetailViewList);

        // 整列されたエリアを設定
        List<AspAddConfirmView.EnsenTypeListView> ensenTypeListDetailViewList = new ArrayList<AspAddConfirmView.EnsenTypeListView>();
        for(int i = 0; i < outServiceBean.getEnsenTypeList().size(); i++){
            AspAddConfirmOutServiceBean.EnsenTypeListDetailView ensenTypeListDetailView = outServiceBean.getEnsenTypeList().get(i);
            AspAddConfirmView.EnsenTypeListView ensen = view.new EnsenTypeListView();
            BeanUtils.copyProperties(ensen, ensenTypeListDetailView);

            ensenTypeListDetailViewList.add(ensen);
        }
        view.setEnsenTypeList(ensenTypeListDetailViewList);

        // エラーフラグ設定
        boolean errFlg = true;
        boolean errUploadFlg = true;

        // 都道府県重複チェック
        for (int i = 0; i < view.getPrefList().size() - 1; i++) {
            int currentPrefSortKey = Integer.valueOf(((PrefListDetailView) view.getPrefList().get(i)).getPrefSortKey());
            int nextPrefSortKey = Integer.valueOf(((PrefListDetailView) view.getPrefList().get(i + 1)).getPrefSortKey());

            if (currentPrefSortKey == nextPrefSortKey) {
                context.setError("WARN.M.SHOP_BUKKEN.0047", ApplicationResources.getProperty("shop.aspPref"));
                errFlg = false;
                break;
            }
        }

        // エリア重複チェック
        for (int i = 0; i < view.getEnsenTypeList().size() - 1; i++) {
            int currentEnsenSortKey = Integer.valueOf(((EnsenTypeListView) view.getEnsenTypeList().get(i)).getEnsenSortKey());
            int nextEnsenSortKey = Integer.valueOf(((EnsenTypeListView) view.getEnsenTypeList().get(i + 1)).getEnsenSortKey());

            if (currentEnsenSortKey == nextEnsenSortKey) {
                context.setError("WARN.M.SHOP_BUKKEN.0048", ApplicationResources.getProperty("shop.aspEnsen"));
                errFlg = false;
                break;
            }
        }

        // 会社ロゴをアップロード
        FormFile uploadFile = (FormFile) form.get("logoFlgImage");
        if (uploadFile != null) {
            // 画像のサイズが0byte、又はパスが正しいかどうかをチェックする。
            if (uploadFile.getFileSize() == 0) {
                context.setError("WARN.M.SHOP_BUKKEN.0070",
                        ApplicationResources.getProperty("shop.common.img"),
                        ApplicationResources.getProperty("shop.common.img"));
                errUploadFlg = false;
            }
            String clientFileName = uploadFile.getFileName();
            String logoImageType =
                    clientFileName.substring(clientFileName.lastIndexOf(".") + 1, clientFileName.length());
            logoImageType = logoImageType.toUpperCase();

            // 画像ファイル形式をチェックする。(許可ファイル形式:GIF,JPG,PNG)
            boolean boolMstContentType = masterService.getMstContentTypeByPrimaryKey(uploadFile.getContentType())  == null  ? false :true;

            if (!boolMstContentType) {
                context.setError("WARN.M.SHOP_BUKKEN.0337");
                errUploadFlg = false;
            }

            // 画像ファイルのサイズをチェック。
            if (uploadFile.getFileSize() == 0) {
                context.setError("WARN.M.SHOP_BUKKEN.0055", ApplicationResources.getProperty("shop.aspAdd"));
                errUploadFlg = false;
            }

            // 各チェック後、エラーが発生する場合はエラーメッセージを表示させる。
            if (!errUploadFlg) {
                context.setForward("fail");
                return;
            }

            // Injection
            AspShopImageService aspShopImageService =
                    (AspShopImageService) ac.getBean("aspShopImageService");
            AspShopImgInfo aspShopImg = new AspShopImgInfo();
            aspShopImg.setFile(uploadFile);
            aspShopImg.setImgRealPath(this.getServletContext().getRealPath("/tmp/img/"));
            aspShopImg.setShopCd(aspAddConfirmInServiceBean.getShopCd());
            aspShopImg.setImgFileType(logoImageType);
            aspShopImg.setImgId(aspAddConfirmInServiceBean.getImgId());
            aspShopImageService.uploadImage(aspShopImg);
            BeanUtils.copyProperties(view, aspShopImg);
            view.setImgId(aspAddConfirmInServiceBean.getImgId());
        }

        if (!errFlg) {
            context.setForward("fail");
            return;
        } else if (!errUploadFlg) {
            context.setError("ERROR.M.SHOP_BUKKEN.0006");
            context.setForward("fail");
            return;
        } else {
            // 二重更新防止トークンをセット
            saveToken(context.getRequest());
            context.setForward("success", view);
        }
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