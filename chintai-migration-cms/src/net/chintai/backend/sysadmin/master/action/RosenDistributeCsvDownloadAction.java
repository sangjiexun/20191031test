/*
 * $Id: RosenDistributeCsvDownloadAction.java 3714 2007-12-26 06:23:19Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/12/26   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.master.action;

import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.master.service.RosenDistributeCsvDownloadService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

/**
 * 配布用の沿線CSVダウンロードを行うアクション。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3714 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenDistributeCsvDownloadAction extends BaseActionSupport {

    private static Log log = LogFactory.getLog(RosenDistributeCsvDownloadAction.class);

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // Service呼び出し
        RosenDistributeCsvDownloadService service =
                (RosenDistributeCsvDownloadService) ac.getBean("rosenDistributeCsvDownloadService");

        List rosenEnsenSearchForCsvList = service.rosenEnsenSearchForCsv();

        if(rosenEnsenSearchForCsvList.size() > 0){
	        CsvStatusBean csvStatusBean = new CsvStatusBean();
	        csvStatusBean.setFileName(this.getCsvFileName());
	        csvStatusBean.setResponse(context.getResponse());

	        // CSV出力処理
	        try {
	            service.createEnsenCsv(csvStatusBean);

	        } catch (ApplicationException e) {
	            if (log.isErrorEnabled()) {
	                log.error(e.getErrorId(), e);
	            }
	        }
	        context.setForward(null);
        }else{
	       	 context.setError("WARN.M.MASTER.0055");
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
     * CSVファイル名を取得します。
     * @return CSVファイル名
     */
    private String getCsvFileName() {
        return SystemProperties.getProperty("RosenEki.DistributeEnsenCsv");
    }

}
