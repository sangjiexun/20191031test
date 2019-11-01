/*
 * $Id: SevendaysMenuAction.java 4517 2011-09-13 00:16:51Z e-ishii $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/15   BGT)児島      新規作成
 * 2008/01/30   BGT)児島      掲載物件リストメニュー生成処理を追加
 */
package net.chintai.backend.sysadmin.external.sevendays.action;

import static net.chintai.backend.sysadmin.common.properties.ServerProperties.getProperty;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.external.sevendays.service.SevendaysMenuService;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;
import org.springframework.web.struts.ActionSupport;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * サンスイ 7days のメニューリストを返すアクションです。<br>
 * このアクションは 7days から呼び出されます。<br>
 * このアクションは text/plain を返却する特殊な Action なので、<br>
 * 共通基底クラス BaseActionSupport を利用していません。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 4517 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class SevendaysMenuAction extends ActionSupport {

    /** メニューの出力エンコーディング */
    private static final String C_OUTPUT_ENCODING = "Shift_JIS";

    /** ロギングオブジェクト */
    private static Log log = LogFactory.getLog(SevendaysMenuAction.class);

    /*
     * (非 Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
     *      org.apache.struts.action.ActionForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    public final ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        CSVWriter csvWriter = null;
        PrintWriter printWriter = null;

        response.setContentType("text/plain; charset=" + C_OUTPUT_ENCODING);
        response.flushBuffer();
        printWriter = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), C_OUTPUT_ENCODING));
        printWriter.write("");
        printWriter.close();
/*
        try {
            DynaValidatorForm dynaForm = (DynaValidatorForm) form;
            String shopCode = dynaForm.getString("shopcd");

            // 店舗コードのチェック
            // 先頭1文字が '0' であることが条件 (== エイブル直営店)
            if (StringUtils.isEmpty(shopCode)) {
                throw new ApplicationException("ERROR.M.APP.0004");
            } else if (shopCode.charAt(0) != '0') {
                throw new ApplicationException("ERROR.M.APP.0004");
            }

            ApplicationContext ac = getWebApplicationContext();
            SevendaysMenuService service = (SevendaysMenuService) ac.getBean("sevendaysMenuService");

            // メニュー情報格納用List
            List<String[]> csvLines = new ArrayList<String[]>();

            // 物件詳細ログ分析(CHINTAI)メニュー情報生成
            if (service.isEnabledChintaiLogAnalysis(shopCode)) {
                String[] tokens = new String[3];
                tokens[0] = getProperty("7days.linkRef.chintaiLogAnalysis");
                tokens[1] = getProperty("7days.linkName.chintaiLogAnalysis");
                tokens[2] = getProperty("7days.windowName.chintaiLogAnalysis");
                csvLines.add(tokens);
            }

            // CHINTAI物件リスティングメニュー情報生成
            if (service.isEnabledChintaiBukkenListing(shopCode)) {
                String[] tokens = new String[3];
                tokens[0] = getProperty("7days.linkRef.chintaiBukkenListing");
                tokens[1] = getProperty("7days.linkName.chintaiBukkenListing");
                tokens[2] = getProperty("7days.windowName.chintaiBukkenListing");
                csvLines.add(tokens);
            }

            // 掲載物件リストメニュー情報生成
            if (service.isEnabledKeisaiList(shopCode)) {
                String[] tokens = new String[3];
                tokens[0] = getProperty("7days.linkRef.keisaiList");
                tokens[1] = getProperty("7days.linkName.keisaiList");
                tokens[2] = getProperty("7days.windowName.keisaiList");
                csvLines.add(tokens);
            }

            // キャンペーン広告管理メニュー情報生成
            if (service.isEnabledCampaign(shopCode)) {
                String[] tokens = new String[3];
                tokens[0] = getProperty("7days.linkRef.Campaign");
                tokens[1] = getProperty("7days.linkName.Campaign");
                tokens[2] = getProperty("7days.windowName.Campaig");
                csvLines.add(tokens);

            }

            // 検索条件ログレポートダウンロード情報生成
            if (service.isEnabledLogReportDownload(shopCode)) {
                String[] tokens = new String[3];
                tokens[0] = getProperty("7days.linkRef.logRepotrDownload");
                tokens[1] = getProperty("7days.linkName.logRepotrDownload");
                tokens[2] = getProperty("7days.windowName.logRepotrDownload");
                csvLines.add(tokens);
            }


            csvWriter =
                    new CSVWriter(
                            new OutputStreamWriter(response.getOutputStream(),C_OUTPUT_ENCODING),
                            CSVWriter.DEFAULT_SEPARATOR,
                            CSVWriter.NO_QUOTE_CHARACTER);

            csvWriter.writeAll(csvLines);
            csvWriter.close();

        } catch (Exception e) {
            // error announce
            printWriter = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), C_OUTPUT_ENCODING));
            printWriter.write("error");
            printWriter.close();

            // logging
            // アプリケーションエラーは意図的に無視
            if (!(e instanceof ApplicationException)) {
                log.error("ERROR.M.APP.0004", e);
            }

        } finally {
            // release resources
            if (csvWriter != null) {
                csvWriter.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }
        }
*/
        return null;
    }
}
