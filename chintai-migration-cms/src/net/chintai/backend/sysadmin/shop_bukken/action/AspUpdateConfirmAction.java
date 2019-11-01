/*
 * $Id: AspUpdateConfirmAction.java 3857 2008-03-10 05:48:16Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)沈鍾沿     新規作成
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
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspUpdateConfirmView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspUpdateConfirmView.EnsenTypeListDetailView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.AspUpdateConfirmView.PrefListDetailView;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspShopImgInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.AspPrefInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.AspShopImageService;
import net.chintai.backend.sysadmin.shop_bukken.service.AspUpdateConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateConfirmOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

/**
 * 不動産ASP設定更新の確認画面へ遷移するアクション。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3857 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspUpdateConfirmAction extends BaseActionSupport {

    /** ロゴ表示フラグ */

	private static final String C_LOGO_FLG = "1";

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
        AspUpdateConfirmInServiceBean aspUpdateConfirmInServiceBean = new AspUpdateConfirmInServiceBean();
        BeanUtils.copyProperties(aspUpdateConfirmInServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ShopInfoService shopInfoService = (ShopInfoService) ac.getBean("shopInfoService");

        // 不動産ASP設定情報の為に店舗コードを設定
        AspShopInfoInServiceBean shopInfoInServiceBean = new AspShopInfoInServiceBean();
        shopInfoInServiceBean.setShopCd(aspUpdateConfirmInServiceBean.getShopCd());

        // 店舗基本情報を取得
        AspShopInfoOutServiceBean rsShopInfo = shopInfoService.aspShopInfoSearchByShopCd(shopInfoInServiceBean);

        // 店舗基本情報をaspAddConfirmInServiceBeanに設定
        BeanUtils.copyProperties(aspUpdateConfirmInServiceBean, rsShopInfo);

        // Injection
        AspPrefInfoService aspPrefInfoService = (AspPrefInfoService) ac.getBean("aspPrefInfoService");

        // 取得したマスタ都道府県リストをaspAddConfirmInServiceBeanに設定
        aspUpdateConfirmInServiceBean.setPrefList(aspPrefInfoService.aspAreaPrefInfoSearch());

        // Injection
        AspUpdateConfirmService aspAddConfirmService = (AspUpdateConfirmService) ac.getBean("aspUpdateConfirmService");

        // requestから登録される不動産ASP設定情報を取得
        SortedMap<String, String[]> sortedMap = new TreeMap<String, String[]>(context.getRequest().getParameterMap());

        aspUpdateConfirmInServiceBean.setSortedMap(sortedMap);

        // 都道府県、沿線タイプの整列を行う
        AspUpdateConfirmOutServiceBean outServiceBean =
                aspAddConfirmService.aspAreaEnsenCheck(aspUpdateConfirmInServiceBean);

        // 整列された結果をViewHelperに設定
        AspUpdateConfirmView confirmView = new AspUpdateConfirmView();
        BeanUtils.copyProperties(confirmView, outServiceBean);

        List<AspUpdateConfirmView.PrefListDetailView> prefListDetailViewList =
                new ArrayList<AspUpdateConfirmView.PrefListDetailView>();
        // 整列された都道府県を設定
        for (int i = 0; i < outServiceBean.getPrefList().size(); i++) {
            AspUpdateConfirmOutServiceBean.PrefListDetailView prefListDetailView = outServiceBean.getPrefList().get(i);
            AspUpdateConfirmView.PrefListDetailView pref = confirmView.new PrefListDetailView();
            BeanUtils.copyProperties(pref, prefListDetailView);

            prefListDetailViewList.add(pref);
        }
        confirmView.setPrefList(prefListDetailViewList);

        // 整列されたエリアを設定
        List<AspUpdateConfirmView.EnsenTypeListDetailView> ensenTypeListDetailViewList =
                new ArrayList<AspUpdateConfirmView.EnsenTypeListDetailView>();
        for (int i = 0; i < outServiceBean.getEnsenTypeList().size(); i++) {
            AspUpdateConfirmOutServiceBean.EnsenTypeListDetailView ensenTypeListDetailView =
                    outServiceBean.getEnsenTypeList().get(i);
            AspUpdateConfirmView.EnsenTypeListDetailView ensen = confirmView.new EnsenTypeListDetailView();
            BeanUtils.copyProperties(ensen, ensenTypeListDetailView);

            ensenTypeListDetailViewList.add(ensen);
        }
        confirmView.setEnsenTypeList(ensenTypeListDetailViewList);

        // エラーフラグ設定
        boolean errFlg = true;
        boolean errUploadFlg = true;

        // 都道府県重複チェック
        for (int i = 0; i < confirmView.getPrefList().size() - 1; i++) {
            int currentPrefSortKey =
                    Integer.valueOf(((PrefListDetailView) confirmView.getPrefList().get(i)).getPrefSortKey());

            int nextPrefSortKey =
                    Integer.valueOf(((PrefListDetailView) confirmView.getPrefList().get(i + 1)).getPrefSortKey());

            if (currentPrefSortKey == nextPrefSortKey) {
                context.setError("WARN.M.SHOP_BUKKEN.0047", ApplicationResources.getProperty("shop.aspPref"));
                errFlg = false;
                break;
            }
        }

        // エリア重複チェック
        for (int i = 0; i < confirmView.getEnsenTypeList().size() - 1; i++) {
            int currentEnsenSortKey =
                    Integer
                            .valueOf(((EnsenTypeListDetailView) confirmView.getEnsenTypeList().get(i))
                                    .getEnsenSortKey());

            int nextEnsenSortKey =
                    Integer.valueOf(((EnsenTypeListDetailView) confirmView.getEnsenTypeList().get(i + 1))
                            .getEnsenSortKey());

            if (currentEnsenSortKey == nextEnsenSortKey) {
                context.setError("WARN.M.SHOP_BUKKEN.0048", ApplicationResources.getProperty("shop.aspEnsen"));
                errFlg = false;
                break;
            }
        }


        // 会社ロゴをアップロード
        FormFile uploadFile = (FormFile) form.get("logoFlgImage");
        String imgId = (String)form.getString("imgId");
        if ("1".equals(aspUpdateConfirmInServiceBean.getLogoFlg())
                && !StringUtils.isEmpty((uploadFile.getFileName()))) {
            // 画像のサイズが0byte、又はパスが正しいかどうかをチェックする。
            if (uploadFile.getFileSize() == 0) {
                context.setError("WARN.M.SHOP_BUKKEN.0071",
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
                context.setError("WARN.M.SHOP_BUKKEN.0338");
                errUploadFlg = false;
            }

            // 画像ファイルのサイズをチェック。
            if (uploadFile.getFileSize() == 0) {
                context.setError("WARN.M.SHOP_BUKKEN.0055", ApplicationResources.getProperty("shop.aspAdd"));
                errUploadFlg = false;
            }

            // 格チェック後、エラーが発生する場合はエラーメッセージを表示させる。
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
            aspShopImg.setShopCd(aspUpdateConfirmInServiceBean.getShopCd());
            aspShopImg.setImgFileType(logoImageType);
            aspShopImg.setImgId(imgId);
            confirmView.setImgKbn(form.getString("imgKbn"));

            aspShopImageService.uploadImage(aspShopImg);
            BeanUtils.copyProperties(confirmView, aspShopImg);
        } else {
            confirmView.setImgRealPath(form.getString("imgRealPath"));
            confirmView.setImgUrlPath(form.getString("imgUrlPath"));
            confirmView.setImgFileNm(form.getString("imgFileNm"));
            confirmView.setImgFileType(form.getString("imgFileType"));
            confirmView.setImgKbn(form.getString("imgKbn"));
            confirmView.setImgId(imgId);
        }
        confirmView.setShopKanriUpdDt(form.getString("shopKanriUpdDt"));
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
            context.setForward("success", confirmView);
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