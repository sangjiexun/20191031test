/*
 * $Id: MailMagazineDownloadAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)沈鍾沿     新規作成
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
import net.chintai.backend.sysadmin.master.service.MailMagazineSearchForCsvService;
import net.chintai.backend.sysadmin.master.service.bean.MailMagazineSearchForCsvOutServiceBean;

import org.springframework.context.ApplicationContext;

/**
 * メールマガジン用メールアドレスのCSVをダウンロードするアクション。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MailMagazineDownloadAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // Service呼び出し
        MailMagazineSearchForCsvService service =
                (MailMagazineSearchForCsvService) ac.getBean("mailMagazineSearchForCsvService");

        List<MailMagazineSearchForCsvOutServiceBean> mailMagazineOutList = service.mailMagazineSearchForCsv();
        // csvデータ取得
        if (mailMagazineOutList.size() > 0) {
            List<String[]> csvList = this.makeCsvList(mailMagazineOutList);

            // csv出力に必要な情報をstatusBeanに設定
            CsvStatusBean csvStatusBean = new CsvStatusBean();
            csvStatusBean.setFileName(this.getCsvFileName());
            csvStatusBean.setResponse(context.getResponse());
            csvStatusBean.setQuoteChar('\u0000');

            // ダウンロード処理
            CsvExportUtil.export(csvStatusBean, csvList);
            context.setForward(null);
            
        } else {
            context.setError("WARN.M.MASTER.0018");
            context.setForward("fail");
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
        return SystemProperties.getProperty("MasterMailMagazine.Filename") + ".csv";
    }

    /**
     * CSVフォマットに変換
     * @param 検索結果
     * @return CSVデータ
     */
    private List<String[]> makeCsvList(List<MailMagazineSearchForCsvOutServiceBean> outList) {
        List<String[]> csvList = new ArrayList<String[]>();
        MailMagazineSearchForCsvOutServiceBean tmp;

        // Header設定
        csvList.add(SystemProperties.getProperty("MasterMailMagazine.Header").split(","));

        // CSVフォマットの変換
        for (int i = 0; i < outList.size(); i++) {
            tmp = outList.get(i);
            csvList.add(new String[] { tmp.getMagazineMailAddress() });
        }
        return csvList;
    }

}
