/*
 * $Id: MatchingDataDownloadAction.java 4437 2010-01-26 05:27:27Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/27     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.addata_matching.service.MatchingDataDownloadService;
import net.chintai.backend.sysadmin.addata_matching.service.bean.MatchingDataDownloadInServiceBean;
import net.chintai.backend.sysadmin.addata_matching.service.bean.MatchingDataDownloadOutServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.CsvExportUtil;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;

/**
 * 照合結果ダウンロード実行アクション。
 * @author e-ishii
 * @version $Revision: 4437 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MatchingDataDownloadAction extends BaseActionSupport {

    /** ログインスタンス */
    private static Log log = LogFactory.getLog(MatchingDataDownloadAction.class);

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai
     * .backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        ApplicationContext ac = getWebApplicationContext();

        MatchingDataDownloadService service =
                (MatchingDataDownloadService) ac.getBean("matchingDataDownloadService");

        // パラメータ設定
        MatchingDataDownloadInServiceBean bean = new MatchingDataDownloadInServiceBean();
        bean.setTaisyoYm(form.getString("taisyoYm"));

        List<MatchingDataDownloadOutServiceBean> outList = service.matchingDataCsvDownload(bean);

        // csvデータ取得
        if (outList.size() > 0) {
            List<String[]> csvList = this.makeCsvList(outList);

            // csv出力に必要な情報をstatusBeanに設定
            CsvStatusBean csvStatusBean = new CsvStatusBean();
            csvStatusBean.setFileName(this.getCsvFileName(form.getString("taisyoYm")));
            csvStatusBean.setResponse(context.getResponse());

            // ダウンロード処理
            CsvExportUtil.export(csvStatusBean, csvList);
            context.setForward(null);

        } else {
            context.setError("WARN.M.ADDATA_MATCHING.0004");
            context.setForward("failure");
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
        return auth.authenticate(userId, AuthorityId.ADDATA_MATCHING);
    }

    /**
     * BeanリストをCSV出力可能な形式に変換する内部メソッド。
     * @param outList Beanリスト
     * @return CSV出力形式に変換されたリスト
     */
    private List<String[]> makeCsvList(List<MatchingDataDownloadOutServiceBean> outList) {
        List<String[]> csvList = new ArrayList<String[]>();

        // Header設定
        csvList.add(SystemProperties.getProperty("AdDataMatching.Header").split(","));

        // CSVフォマットの変換
        for (int i = 0; i < outList.size() - 1; i++) {
            MatchingDataDownloadOutServiceBean matchingData = outList.get(i);
            csvList.add(new String[] {
                    matchingData.getGroupName(),
                    matchingData.getAreaCd(),
                    matchingData.getAreaName(),
                    matchingData.getShopCd(),
                    matchingData.getBumon(),
                    matchingData.getTorihikiNo(),
                    matchingData.getBkcd(),
                    matchingData.getRoomCd(),
                    matchingData.getRoomType(),
                    matchingData.getTorihikiShubetsu(),
                    matchingData.getTorihikiName(),
                    matchingData.getChinryo(),
                    matchingData.getTorihikiSakuseiDate(),
                    matchingData.getCmInsGaku(),
                    matchingData.getCmInsDt(),
                    matchingData.getAdInsCnt(),
                    matchingData.getAdInsGaku(),
                    matchingData.getAdInsDt(),
                    matchingData.getKashiCm(),
                    matchingData.getKariCm(),
                    matchingData.getCmMitsu(),
                    matchingData.getCmMitsuAd(),
                    matchingData.getTantouCd(),
                    matchingData.getTantouName(),
                    matchingData.getKashiCd(),
                    matchingData.getDataType(),
                    matchingData.getLastChinryo(),
                    matchingData.getLastHassinDate(),
                    matchingData.getUnMatchiFlg(),
                    matchingData.getCampaignNameSimple()});
        }
        // 最終行に広告料をセット
        MatchingDataDownloadOutServiceBean matchingDatalast = outList.get(outList.size() - 1);
        csvList.add(new String[] { matchingDatalast.getKoukokuSum() });
        return csvList;
    }

    /**
     * CSVファイル名を取得します。
     * @return CSVファイル名
     */
    private String getCsvFileName(String taisyoYm) {

        StringBuilder fileName = new StringBuilder();
        fileName.append(taisyoYm);
        fileName.append("_");
        fileName.append(SystemProperties.getProperty("AdDataMatching.Filename"));
        fileName.append(".csv");

        return fileName.toString();
    }
}
