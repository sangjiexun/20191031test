/*
 * $Id: BukkenRirekiInfoCsvDownloadAction.java 4558 2012-12-10 01:09:25Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/05/27  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import au.com.bytecode.opencsv.CSVWriter;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ServerProperties;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.common.util.CsvExportUtil;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.common.util.ZipStatusBean;
import net.chintai.backend.sysadmin.common.util.ZipUtil;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.shop_bukken.domain.ImgCntEachCategory;
import net.chintai.backend.sysadmin.shop_bukken.domain.SystemNameBean;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenRirekiInfoCsvDownloadService;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenRirekiInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenRirekiInfoCsvDownloadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenRirekiInfoCsvDownloadOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadShopInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ImgCntEachCategoryInServiceBean;
import net.chintai.batch.common.domain.MstFormatType;
import net.chintai.batch.common.domain.MstImgCategory;

/**
 *
 * 入稿履歴一覧CSV出力アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4558 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenRirekiInfoCsvDownloadAction extends BaseActionSupport {
	@Autowired
	private MasterService masterService;

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データを取得
        //String roomKey = context.getRequest().getParameter("roomKey");

        final DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        final String roomKey = (String)form.get("roomKey");
        final String[] tableNo = (String[])form.get("tableNo");

        BukkenRirekiInfoCsvDownloadInServiceBean inBean =
                new BukkenRirekiInfoCsvDownloadInServiceBean();
        inBean.setRoomKey(roomKey);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        BukkenRirekiInfoCsvDownloadService service =
                (BukkenRirekiInfoCsvDownloadService) ac
                        .getBean("bukkenRirekiInfoCsvDownloadService");

        BukkenRirekiInfoService bukkenInfoService =
                (BukkenRirekiInfoService)ac.getBean("bukkenRirekiInfoService");

        List<BukkenRirekiInfoCsvDownloadOutServiceBean> rsList =
                service.getBukkenRirekiInfo(inBean);

        // Map＜テーブル名, CSV＞
        final Map<String, List<String[]>> csvDownloadTableMap = new LinkedHashMap<String, List<String[]>>();

        // csvデータ取得
        final List<String[]> csvList = this.makeCsvList(rsList, bukkenInfoService, service);

        // 入稿履歴
        csvDownloadTableMap.put("NYUKOU_RIREKI", csvList);

        //プロパティファイルに定義されている全テーブル
        final Map<String,String> allTableMap = getAllTableMap();

        //抽出するテーブル
        final Map<String,String> tableMap = new LinkedHashMap<String,String>();
        for(String str: tableNo){
        	if(allTableMap.containsKey(str)){
        		tableMap.put(str, allTableMap.get(str));
        	}
        }

        //PK_BUKKEN_LISTのリストを作成
        final List<String> pkBukkenRirekiList = new ArrayList<String>();
        //SHOPCD||BKCD||ROOMNOのリストを作成
        final List<String> shopcdBkcdRoomnoList = new ArrayList<String>();
        for(final BukkenRirekiInfoCsvDownloadOutServiceBean data: rsList){
        	if(StringUtils.isNotEmpty(data.getPkBukkenRireki())){
        		pkBukkenRirekiList.add(data.getPkBukkenRireki());
        	}
        	if(StringUtils.isNotEmpty(data.getShopcd())
        			&& StringUtils.isNotEmpty(data.getBkcd())
        			&& StringUtils.isNotEmpty(data.getRoomno())
        			&& !shopcdBkcdRoomnoList.contains(data.getShopcd() + data.getBkcd() + data.getRoomno())){
        		shopcdBkcdRoomnoList.add(data.getShopcd() + data.getBkcd() + data.getRoomno());
        	}
        }

        final CsvDownloadInServiceBean bean = new CsvDownloadInServiceBean();
        bean.setPkBukkenRireki(pkBukkenRirekiList.toArray(new String[0]));

        //最新の店舗の履歴を取得
        final CsvDownloadShopInServiceBean shopBean = new CsvDownloadShopInServiceBean();
        for(final BukkenRirekiInfoCsvDownloadOutServiceBean data: rsList){
        	if(StringUtils.isNotEmpty(data.getShopcd())){
        		shopBean.setShopcd(data.getShopcd());
        		break;
        	}
        }

        //テーブル毎に繰り返しCSV取得
        for(final String key: tableMap.keySet()){
        	final String tableName = tableMap.get(key);
        	csvDownloadTableMap.put(tableName, service.getCsvDownloadTable(tableName, bean, shopBean));
        }

        // csv出力に必要な情報をstatusBeanに設定
        CsvStatusBean csvStatusBean = new CsvStatusBean();
        //csvStatusBean.setFileName(this.getCsvFileName());
        //csvStatusBean.setResponse(context.getResponse());

        final List<File> fileList = new ArrayList<File>();

        for(final String tableName: csvDownloadTableMap.keySet()){
	        final File file = new File(ServerProperties.getProperty("csvFilesDir") + convertCsvDownloadTable(tableName) + ".csv");

	        // CSV 出力
	        CSVWriter csvWriter = null;
	        try {
	            csvWriter =
	                    new CSVWriter(//new BufferedWriter(new OutputStreamWriter(bean.getResponse().getOutputStream(), bean.getCharset())),
	                    			new OutputStreamWriter(new FileOutputStream(file), csvStatusBean.getCharset()),
	                    			csvStatusBean.getSeparator(),
	                    			csvStatusBean.getQuoteChar(),
	                    			csvStatusBean.getLineEnd());
	            csvWriter.writeAll(csvDownloadTableMap.get(tableName));
	            csvWriter.close();

	        } catch (IOException e) {
	            // ClientAbortException は無視します。
	            if (!StringUtils.contains(e.toString(), "ClientAbortException")) {
	                throw new CsvException(e);
	            }

	        } catch (IllegalStateException e) {
	            if (csvStatusBean.getResponse().isCommitted()) {
	                // no-op
	            } else {
	                throw e;
	            }
	        }

	        fileList.add(file);
        }

        //CSVファイルをZIP圧縮
        final ZipStatusBean zipStatusBean = new ZipStatusBean();
        zipStatusBean.setFileName("NYUKOU_RIREKI"+ "_" + DateUtil.getToday("yyyyMMdd") + ".zip");
        zipStatusBean.setResponse(context.getResponse());
        ZipUtil.compress(zipStatusBean, fileList.toArray(new File[0]), null);

        context.setForward(null);

    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        // 権限チェック
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return (auth.authenticate(userId, AuthorityId.SHOP_BUKKEN)
                || auth.authenticate(userId, AuthorityId.REVIEW));

    }

    /**
     * CSVフォマットに変換
     * @param 検索結果
     * @return CSVデータ
     */
    private List<String[]> makeCsvList(List<BukkenRirekiInfoCsvDownloadOutServiceBean> rsList, BukkenRirekiInfoService bukkenInfoService, BukkenRirekiInfoCsvDownloadService service) {
        List<String[]> csvList = new ArrayList<String[]>();
        BukkenRirekiInfoCsvDownloadOutServiceBean tmp;

        //写真 ヘッダーに表示するカテゴリー名
        final List<MstImgCategory> imgCategoryList = masterService.selectMstImgCategoryByShopBukkenKbn("2");
        String imgCategoryName = "";
        for(final MstImgCategory data: imgCategoryList){
        	imgCategoryName = imgCategoryName + data.getImgCategoryName() + ",";
        }

        final String header = SystemProperties.getProperty("BukkenRirekiInfo.Header").replaceAll("IMG_CATEGORY,", imgCategoryName);

        // Header設定
        csvList.add(header.split(","));

        //登録機能が「項目補完」かどうかの判定用
        List<MstFormatType> mstFormatTypeList = masterService.selectMstFormatTypeByItemComplementHasshinFlgOn();

        // CSVフォマットの変換
        for (int i = 0; i < rsList.size(); i++) {
            tmp = rsList.get(i);

          //カテゴリー毎の写真枚数検索
            final List<String> imgCategoryCntList = new ArrayList<String>();
            if(StringUtils.isNotEmpty(tmp.getPkBukkenRireki())){
            	final ImgCntEachCategoryInServiceBean imgCntBean = new ImgCntEachCategoryInServiceBean();
            	imgCntBean.setPkBukkenRireki(tmp.getPkBukkenRireki());
            	final List<ImgCntEachCategory> imgCntFileNmNotEmptyList = service.selectImgCntEachCategory(imgCntBean);

            	for(final ImgCntEachCategory data: imgCntFileNmNotEmptyList){
            		imgCategoryCntList.add(data.getKeisaiCnt() + "/" + data.getAllCnt());
            	}
            }else{
            	for(int j = 0; j < imgCategoryList.size(); j++){
            		imgCategoryCntList.add("0/0");
            	}
            }

            final SystemNameBean systemNameBean = bukkenInfoService.getSystemName(tmp.getBrInsPg(), tmp.getBskInsPg(), tmp.getBrUpdPg(), tmp.getBskUpdPg(), mstFormatTypeList.contains(tmp.getFormatTypeCd()), tmp.getRendoName());

            final List<String> list = new ArrayList<String>();
            list.add(tmp.getPkBukkenRireki());
            list.add(tmp.getInsDt());
            list.add("true".equals(bukkenInfoService.isNyukoSystem(tmp.getBrInsPg(), tmp.getBskInsPg(), tmp.getBrUpdPg(), tmp.getBskUpdPg()))?convertInsKbn(tmp.getInsKbn()): "");
            list.add(convertRecSendStatus(tmp.getRecSendStatus(), tmp.getImgBaseDt()));
            list.add(convertCtFrontSendResultKbn(tmp.getCtFrontSendResultKbn()));
            list.add(convertAblFrontSendResultKbn(tmp.getAblFrontSendResultKbn()));
            list.add(systemNameBean.getCategoryName());
            list.add(systemNameBean.getSystemName());
            list.add(convertHeyadomeKbn(tmp.getHeyadomeKbn()));
            list.add(tmp.getHeyaJokyo());
            list.add(tmp.getTorihiki());
            list.add(convertWebTorihiki(tmp.getTorihikiKeitai()));

            for(final String imgCategoryCnt: imgCategoryCntList){
            	list.add(imgCategoryCnt);
            }

            list.add((StringUtils.isNotEmpty(tmp.getLocX()) && StringUtils.isNotEmpty(tmp.getLocY())? "付与済":"－"));

            csvList.add(list.toArray(new String[0]));
/*
            csvList.add(new String[] {
            		tmp.getInsDt(),
            		convertInsKbn(tmp.getInsKbn()),
            		convertRecSendStatus(tmp.getRecSendStatus(), tmp.getImgBaseDt()),
            		convertCtFrontSendResultKbn(tmp.getCtFrontSendResultKbn()),
            		convertAblFrontSendResultKbn(tmp.getAblFrontSendResultKbn()),
            		tmp.getPkBukkenRireki(),
            		systemNameBean.getCategoryName(),
            		systemNameBean.getSystemName(),
            		convertHeyadomeKbn(tmp.getHeyadomeKbn()),
            		tmp.getHeyaJokyo(),
            		tmp.getTorihiki(),
            		convertWebTorihiki(tmp.getTorihikiKeitai()),
            		(Integer.parseInt(tmp.getImgCnt()) > 0? "あり":"なし"),
            		tmp.getAllImgCnt() + "枚",
            		(StringUtils.isNotEmpty(tmp.getLocX()) && StringUtils.isNotEmpty(tmp.getLocY())? "付与済":"－")
                    });
*/

        }
        return csvList;
    }

    private String convertCsvDownloadTable(String code){

    	// 戻り値
        String returnValue = null;

	    final String[] names = SystemProperties.getProperties("CSV_DOWNLOAD_TABLE_JPN_NAME");
	    final String[] values = SystemProperties.getProperties("CSV_DOWNLOAD_TABLE_ENG_NAME");

	    for (int i = 0; i < values.length; i++) {
            if (StringUtils.isNotEmpty(values[i]) && values[i].equals(code)) {
                returnValue = names[i];
            }
        }

	    if("NYUKOU_RIREKI".equals(code)){
	    	return "入稿履歴";
	    }

        return returnValue;
    }

    private String convertCtFrontSendResultKbn(String code) {

        // 戻り値
        String returnValue = null;

        String[] names = SystemProperties.getProperties("CT_FRONT_SEND_RESULT_KBN_NAME");
        String[] values = SystemProperties.getProperties("CT_FRONT_SEND_RESULT_KBN_VALUE");

        for (int i = 0; i < values.length; i++) {
            if (StringUtils.isNotEmpty(values[i]) && values[i].equals(code)) {
                returnValue = names[i];
            }
        }

        return returnValue;
    }

    private String convertAblFrontSendResultKbn(String code) {

        // 戻り値
        String returnValue = null;

        String[] names = SystemProperties.getProperties("ABL_FRONT_SEND_RESULT_KBN_NAME");
        String[] values = SystemProperties.getProperties("ABL_FRONT_SEND_RESULT_KBN_VALUE");

        for (int i = 0; i < values.length; i++) {
            if (StringUtils.isNotEmpty(values[i]) && values[i].equals(code)) {
                returnValue = names[i];
            }
        }

        return returnValue;
    }

    private String convertRecSendStatus(String recSendStatus, String imgBaseDt) {
    	// 戻り値
        String returnValue = null;

    	if(("10".equals(recSendStatus) || "11".equals(recSendStatus)) && (imgBaseDt != null)){
    		returnValue = "画像同期待ち";
    	}else{
    		String[] names = SystemProperties.getProperties("REC_SEND_STATUS_NAME");
            String[] values = SystemProperties.getProperties("REC_SEND_STATUS_VALUE");

            for (int i = 0; i < values.length; i++) {
                if (StringUtils.isNotEmpty(values[i]) && values[i].equals(recSendStatus)) {
                    returnValue = names[i];
                }
            }
    	}

    	return returnValue;
    }

    private String convertInsKbn(String code) {

        // 戻り値
        String returnValue = null;

        String[] names = SystemProperties.getProperties("INS_KBN_NAME");
        String[] values = SystemProperties.getProperties("INS_KBN_VALUE");

        for (int i = 0; i < values.length; i++) {
            if (StringUtils.isNotEmpty(values[i]) && values[i].equals(code)) {
                returnValue = names[i];
            }
        }

        return returnValue;
    }

    private String convertHeyadomeKbn(String code) {

        // 戻り値
        String returnValue = null;

        String[] names = SystemProperties.getProperties("HEYADOME_KBN_NAME");
        String[] values = SystemProperties.getProperties("HEYADOME_KBN_VALUE");

        for (int i = 0; i < values.length; i++) {
            if (StringUtils.isNotEmpty(values[i]) && values[i].equals(code)) {
                returnValue = names[i];
            }
        }

        return returnValue;
    }

    private String convertWebTorihiki(String code) {

        // 戻り値
        String returnValue = null;

        String[] names = SystemProperties.getProperties("WEB_TORIHIKI_NAME");
        String[] values = SystemProperties.getProperties("WEB_TORIHIKI_VALUE");

        for (int i = 0; i < values.length; i++) {
            if (StringUtils.isNotEmpty(values[i]) && values[i].equals(code)) {
                returnValue = names[i];
            }
        }

        return returnValue;
    }

    /**
     * CSVファイル名を取得
     * @param なし
     * @return CSVファイル名
     */
    private String getCsvFileName() {
        String fileName =
                SystemProperties.getProperty("BukkenRirekiInfo.Filename") + "_"
                        + DateUtil.getToday("yyyyMMdd") + ".csv";
        return fileName;
    }

    /**
     * CSVダウンロードテーブル
     * @return
     */
    private Map<String,String> getAllTableMap(){
    	final Map<String,String> tableMap = new LinkedHashMap<String,String>();

        final String[] names = SystemProperties.getProperties("CSV_DOWNLOAD_TABLE_ENG_NAME");
        final String[] values = SystemProperties.getProperties("CSV_DOWNLOAD_TABLE_VALUE");

        for (int i = 0; i < values.length; i++) {
        	tableMap.put(values[i], names[i]);
        }

        return tableMap;
    }

}
