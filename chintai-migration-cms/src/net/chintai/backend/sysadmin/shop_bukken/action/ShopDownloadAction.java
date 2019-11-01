/*
 * $Id: ContractAmountMaintenanceDownloadAction.java 4698 2013-10-25 02:43:37Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 *
 */

package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.service.CodeConvertService;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.common.util.CsvExportUtil;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.demand.action.view.ContractAmountMaintenanceView;
import net.chintai.backend.sysadmin.demand.service.ContractAmountMaintenanceDownloadService;
import net.chintai.backend.sysadmin.demand.service.bean.ContractAmountMaintenanceDownloadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopDownloadView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopDetailInfoSearchService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDownloadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDownloadOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 物件枠数・物件リスティング枠数のCSVダウンロードアクション
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopDownloadAction extends BaseActionSupport {


    /** ログインスタンス */
    private static Log log = LogFactory.getLog(ShopDownloadAction.class);

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai
     * .backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ShopDownloadInServiceBean inServiceBean =
                new ShopDownloadInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();

        // 取得した検索条件とページング状態をViewHelperにセットする。
        ShopDownloadView view = new ShopDownloadView(condition);
        BeanUtils.copyProperties(view, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // Service呼び出し
        ShopDetailInfoSearchService service =
                (ShopDetailInfoSearchService) ac.getBean("shopDetailInfoSearchService");

        List<ShopDownloadOutServiceBean> outList = new ArrayList<ShopDownloadOutServiceBean>();
        if("1".equals(form.getString("reserveFlg"))){
        	outList = service.selectShopReserveForDownload(inServiceBean);
        }else{
        	outList = service.selectShopForDownload(inServiceBean);
        }

        // csvデータ取得
        if (outList.size() > 0) {
            List<String[]> csvList = this.makeCsvList(outList);

            // csv出力に必要な情報をstatusBeanに設定
            CsvStatusBean csvStatusBean = new CsvStatusBean();
            csvStatusBean.setFileName(this.getCsvFileName());
            csvStatusBean.setResponse(context.getResponse());

            try {
                // ダウンロード処理
                CsvExportUtil.export(csvStatusBean, csvList);
            } catch (CsvException e) {
                String errorId = "ERROR.M.DEMAND.0001";
                log.error(errorId, e);
                context.setError(errorId);
                context.setForward("failure", view);
            }
            context.setForward("success", view);

        } else {
            context.setError("WARN.M.DEMAND.0003");
            context.setForward("failure", view);
        }

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java
     * .lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

    /**
     * CSVファイル名を取得
     * @return CSVファイル名
     */
    private String getCsvFileName() {
        String date = DateUtil.getToday();

        String fileName = SystemProperties.getProperty("ShopDownload.Filename");
        String ck = "\\{0\\}";
        String newFileName = fileName.replaceAll(ck, date);

        return newFileName;

    }

    //コンバータ
    private CodeConvertService convertService;

    public void setCodeConvertService(CodeConvertService service) {
        convertService = service;
    }

    private Map<String, String> clientSystemTypeMap;

    private String clientSystemTypeConvert(String key) {
        return clientSystemTypeMap.get(key);
    }

    /**
     * BeanリストをCSV出力可能な形式に変換する内部メソッド。
     * @param outList Beanリスト
     * @return CSV出力形式に変換されたリスト
     */
    private List<String[]> makeCsvList(
            List<ShopDownloadOutServiceBean> outList) {
        List<String[]> csvList = new ArrayList<String[]>();

        // Header設定
        csvList.add(SystemProperties.getProperty("ShopDownload.Header").split(","));

        clientSystemTypeMap = convertService.getCodeMap("CLIENTSYSTEM_SEARCH_VALUE", "CLIENTSYSTEM_SEARCH_NAME");

        // CSVフォマットの変換
        for (int i = 0; i < outList.size(); i++) {
        	ShopDownloadOutServiceBean tmp = outList.get(i);
            csvList.add(new String[] { tmp.getReserveNo(), tmp.getReserveKbn(), tmp.getShopCd(),
            		clientSystemTypeConvert(tmp.getClientsystemType()),tmp.getCompany(), tmp.getBumon(), tmp.getPrefName(), tmp.getCityName(),
                    tmp.getAddress1(), null, tmp.getApplyDt(), tmp.getBusinessHours(), tmp.getHoliday(), tmp.getCertifyFlg(),
                    tmp.getCtStatus(), tmp.getAblStatus(), tmp.getShopStatus(), tmp.getRendoCd() });
        }
        return csvList;
    }

}
