/*
 * $Id: MobileMaintenanceCsvDownloadAction.java 3644 2007-12-18 13:12:19Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.CsvExportUtil;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.master.service.MobileMaintenanceService;
import net.chintai.backend.sysadmin.master.service.bean.MobileMaintenanceOutServiceBean;

import org.springframework.context.ApplicationContext;

/**
 * 携帯ゲーム対応機種メンテナンスアクション(CSV ファイルのダウンロード)
 * 
 * @author Yang-EunMi
 * @version $Revision: 3644 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MobileMaintenanceCsvDownloadAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // Service呼び出し
        MobileMaintenanceService service = (MobileMaintenanceService) ac.getBean("mobileMaintenanceService");

        List<MobileMaintenanceOutServiceBean> outList = service.mobileCsvDownLoad();

        // csvデータ取得
        if (outList.size() > 0) {
            List<String[]> csvList = this.makeCsvList(outList);

            // csv出力に必要な情報をstatusBeanに設定
            CsvStatusBean csvStatusBean = new CsvStatusBean();
            csvStatusBean.setFileName(this.getCsvFileName());
            csvStatusBean.setResponse(context.getResponse());
            csvStatusBean.setQuoteChar('\u0000');

            // ダウンロード処理
            CsvExportUtil.export(csvStatusBean, csvList);
            context.setForward(null);

        } else {
            context.setError("WARN.M.MASTER.0017");
            context.setForward("failure");
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
        return auth.authenticate(userId, AuthorityId.MASTER);
    }

    /**
     * CSVファイル名を取得
     * @return CSVファイル名
     */
    private String getCsvFileName() {
        return SystemProperties.getProperty("MasterMobile.Filename") + ".csv";
    }

    /**
     * BeanリストをCSV出力可能な形式に変換する内部メソッド。
     * @param outList Beanリスト
     * @return CSV出力形式に変換されたリスト
     */
    private List<String[]> makeCsvList(List<MobileMaintenanceOutServiceBean> outList) {
        List<String[]> csvList = new ArrayList<String[]>();

        // Header設定
        csvList.add(SystemProperties.getProperty("MasterMobile.Header").split(","));

        // CSVフォマットの変換
        for (int i = 0; i < outList.size(); i++) {
            MobileMaintenanceOutServiceBean tmp = outList.get(i);
            csvList.add(new String[] {
                    tmp.getDlSeq(),
                    tmp.getItemCd(),
                    tmp.getCarrierType(),
                    tmp.getUserAgent(),
                    tmp.getFileName(),
                    tmp.getDiscription(),
                    tmp.getUpdDt()
                    });
        }
        return csvList;
    }

}
