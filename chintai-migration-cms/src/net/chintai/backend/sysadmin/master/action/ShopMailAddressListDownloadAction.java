/*
 * $Id: ShopMailAddressListDownloadAction.java 3725 2008-01-09 02:27:12Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/11/20   BGT)沈鍾沿    新規作成
 * 2008/01/09   BGT)児島      CSV項目追加(仕様変更)
 */
package net.chintai.backend.sysadmin.master.action;

import static net.chintai.backend.sysadmin.common.properties.SystemProperties.getProperty;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.CsvExportUtil;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.master.service.ShopMailSearchForCsvService;
import net.chintai.backend.sysadmin.master.service.bean.ShopMailSearchForCsvOutServiceBean;

import org.springframework.context.ApplicationContext;

/**
 * 不動産会社メールアドレスのCSVをダウンロードするアクション。
 *
 * @author Sim-JongYeon
 * @author KOJIMA Takanori
 * @version $Revision: 3725 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopMailAddressListDownloadAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // Service呼び出し
        ShopMailSearchForCsvService service = (ShopMailSearchForCsvService) ac.getBean("shopMailSearchForCsvService");

        List<ShopMailSearchForCsvOutServiceBean> shopMailOutList = service.shopMailSearchForCsv();

        // csvデータ取得
        if (shopMailOutList.size() > 0) {
            List<String[]> csvList = this.makeCsvList(shopMailOutList);

            // csv出力に必要な情報をstatusBeanに設定
            CsvStatusBean csvStatusBean = new CsvStatusBean();
            csvStatusBean.setFileName(this.getCsvFileName());
            csvStatusBean.setResponse(context.getResponse());

            // ダウンロード処理
            CsvExportUtil.export(csvStatusBean, csvList);

            context.setForward(null);
        } else {
            context.setError("WARN.M.MASTER.0019");
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
        return getProperty("MasterShopMailAddress.Filename") + ".csv";
    }

    /**
     * BeanリストをCSV出力形式リストに変換する内部メソッド。
     * @param list Beanリスト
     * @return CSV出力形式のリスト
     */
    private List<String[]> makeCsvList(List<ShopMailSearchForCsvOutServiceBean> list) {
        List<String[]> csvList = new ArrayList<String[]>();

        // Header設定
        csvList.add(getProperty("MasterShopMailAddress.Header").split(","));

        // CSVフォーマットの変換
        for (int i = 0; i < list.size(); i++) {
            ShopMailSearchForCsvOutServiceBean bean = list.get(i);

            csvList.add(new String[] {
                    bean.getAreaCd(),
                    bean.getAreaName(),
                    bean.getPrefCd(),
                    bean.getPrefName(),
                    bean.getShopCd(),
                    bean.getCompany(),
                    bean.getBumon(),
                    bean.getZip(),
                    bean.getAddress1(),
                    bean.getAddress2(),
                    bean.getTel(),
                    bean.getFax(),
                    bean.getEmail1(),
                    bean.getEmail2(),
                    bean.getEmail3(),
                    bean.getEmail4(),
                    bean.getEmail5(),
                    bean.getLicTrust(),
                    bean.getTantou(),
                    bean.getClientsystemType(),
                    bean.getShopStatus()
                });
        }
        return csvList;
    }

}
