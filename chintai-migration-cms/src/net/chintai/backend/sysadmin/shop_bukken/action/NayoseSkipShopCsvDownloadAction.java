/*
 * $Id: NayoseSkipShopCsvDownloadAction.java 4567 2013-01-28 04:43:59Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/24     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;




import java.text.SimpleDateFormat;
import java.util.Date;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.shop_bukken.service.NayoseSkipShopCsvDownloadService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;


/**
 * 名寄せ処理対象外店舗一覧のダウンロード
 * @author e-ishii
 * @version $Revision: 4567 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class NayoseSkipShopCsvDownloadAction extends BaseActionSupport {

    /** ログインスタンス */
    private static Log log = LogFactory.getLog(NayoseSkipShopCsvDownloadAction.class);

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.
     * BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        NayoseSkipShopCsvDownloadService service = (NayoseSkipShopCsvDownloadService) ac.getBean("nayoseSkipShopCsvDownloadService");

        int nayoseSkipShopCount = service.getNayoseSkipShopCount();

        // 0件の場合メッセージ
        if (nayoseSkipShopCount == 0) {
            context.setError("WARN.M.NAYOSESKIPDOWNLOAD.0002");
            context.setForward("success");
            return;
        }

        CsvStatusBean csvStatusBean = new CsvStatusBean();
        csvStatusBean.setFileName(this.getCsvFileName());
        csvStatusBean.setResponse(context.getResponse());

        try {
            service.createNayoseSkipShopCsv(csvStatusBean);

        } catch (ApplicationException e) {
            if (log.isErrorEnabled()) {
                log.error(e.getErrorId(), e);
            }
        }

        context.setForward(null);

    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.
     * BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

    /**
     * CSVファイル名を取得
     * @return CSVファイル名
     */
    private String getCsvFileName() {

        Date nowDate = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        String date = sdf.format(nowDate);

        StringBuffer sb = new StringBuffer();
        sb.append(SystemProperties.getProperty("NayoseSkipShop.Filename"));
        sb.append(date);
        sb.append(".csv");

        return sb.toString();

    }

}
