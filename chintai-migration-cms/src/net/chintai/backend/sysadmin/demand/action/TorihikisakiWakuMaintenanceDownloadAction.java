package net.chintai.backend.sysadmin.demand.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.common.util.CsvExportUtil;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiWakuMaintenanceView;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuMaintenanceDownloadService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuMaintenanceDownloadInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuMaintenanceDownloadOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/*
 * $Id: TorihikisakiWakuMaintenanceDownloadAction.java 4698 2013-10-25 02:43:37Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/09/18     BGT)亀田       新規作成
 *
 */

/**
 * 物件枠数・物件リスティング枠数のCSVダウンロードアクション
 * @author KAMEDA Takuma
 * @version $Revision: 4698 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuMaintenanceDownloadAction extends BaseActionSupport {


    /** ログインスタンス */
    private static Log log = LogFactory.getLog(TorihikisakiWakuMaintenanceUploadAction.class);

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
        TorihikisakiWakuMaintenanceDownloadInServiceBean inServiceBean =
                new TorihikisakiWakuMaintenanceDownloadInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();

        // 取得した検索条件とページング状態をViewHelperにセットする。
        TorihikisakiWakuMaintenanceView view = new TorihikisakiWakuMaintenanceView(condition);
        BeanUtils.copyProperties(view, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // Service呼び出し
        TorihikisakiWakuMaintenanceDownloadService service =
                (TorihikisakiWakuMaintenanceDownloadService) ac
                        .getBean("TorihikisakiWakuMaintenanceDownloadService");

        List<TorihikisakiWakuMaintenanceDownloadOutServiceBean> outList =
                service.torihikisakiWakuCsvDownLoad(inServiceBean);


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
                String errorId = "ERROR.M.DEMAND.0144";
                log.error(errorId, e);
                context.setError(errorId);
                context.setForward("failure", view);
            }
            context.setForward("success", view);

        } else {
            context.setError("WARN.M.DEMAND.0135");
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

        String fileName = SystemProperties.getProperty("TorihikisakiWakuMaintenance.Filename");
        String ck = "\\{0\\}";
        String newFileName = fileName.replaceAll(ck, date);

        return newFileName;

    }

    /**
     * BeanリストをCSV出力可能な形式に変換する内部メソッド。
     * @param outList Beanリスト
     * @return CSV出力形式に変換されたリスト
     */
    private List<String[]> makeCsvList(
            List<TorihikisakiWakuMaintenanceDownloadOutServiceBean> outList) {
        List<String[]> csvList = new ArrayList<String[]>();

        // Header設定
        csvList.add(SystemProperties.getProperty("TorihikisakiWakuMaintenance.Header").split(","));

        // CSVフォマットの変換
        for (int i = 0; i < outList.size(); i++) {
            TorihikisakiWakuMaintenanceDownloadOutServiceBean tmp = outList.get(i);
            csvList.add(new String[] { tmp.getTorihikisakiSeq(), tmp.getTorihikisakiCd(), tmp.getFudousanKaisyaName(), 
                    tmp.getTorihikisakiName(),tmp.getStartYm(), tmp.getBukkenCount(), tmp.getTokusenCount(), null,});
        }
        return csvList;
    }

}
