/*
 * $Id: RosenEkiCsvDownloadAction.java 3708 2007-12-26 05:42:31Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/17  BGT)沈鍾沿     新規作成
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
import net.chintai.backend.sysadmin.master.service.RosenEkiSearchForCsvService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

/**
 * 沿線、駅メンテナンスアクション(CSV ファイルのダウンロード)
 *
 * @author Sim-JongYeon
 * @version $Revision: 3708 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenEkiCsvDownloadAction extends BaseActionSupport {

    /** ログインスタンス */
    private static Log log = LogFactory.getLog(RosenEkiCsvDownloadAction.class);

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // Service呼び出し
        RosenEkiSearchForCsvService service = (RosenEkiSearchForCsvService) ac.getBean("rosenEkiSearchForCsvService");

        List rosenEkiSearchForCsvList = service.rosenEkiSearchForCsv();

        if(rosenEkiSearchForCsvList.size() > 0){
	        CsvStatusBean csvStatusBean = new CsvStatusBean();
	        csvStatusBean.setFileName(this.getCsvFileName());
	        csvStatusBean.setResponse(context.getResponse());

	        // CSV出力処理
	        try {
	            service.createEnsenEkiCsv(csvStatusBean);

	        } catch (ApplicationException e) {
	            if (log.isErrorEnabled()) {
	                log.error(e.getErrorId(), e);
	            }
	        }
	        context.setForward(null);
        }else{
        	 context.setError("WARN.M.MASTER.0016");
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
        return SystemProperties.getProperty("RosenEki.Filename") + ".csv";
    }
}
