/*
 * $Id: RosenUpdateCommitServiceImpl.java 4059 2008-11-12 02:29:20Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/21  BGT)金東珍     新規作成
 * 2007/12/09  BGT)児島       CSVデータフォーマットのチェック処理を追加
 * 2008/01/09  BGT)児島       登録処理ルーチンの変更に伴い全面的に書き直し
 */
package net.chintai.backend.sysadmin.master.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ServerProperties;
import net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao;
import net.chintai.backend.sysadmin.master.domain.EkiDomain;
import net.chintai.backend.sysadmin.master.domain.EnsenDomain;
import net.chintai.backend.sysadmin.master.service.RosenUpdateCommitService;
import net.chintai.backend.sysadmin.master.service.bean.RosenUpdateCommitInServiceBean;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

/**
 * RosenUpdateCommitServiceの実装クラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 4059 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class RosenUpdateCommitServiceImpl implements RosenUpdateCommitService {
	private static final Logger logger = Logger.getLogger(RosenUpdateCommitServiceImpl.class);

    // CSVの項目名とカラム位置の対応
    private static final int C_ENSENCD = 0;

    private static final int C_ENSENNAME = 1;

    private static final int C_ENSENTYPE = 2;

    private static final int C_AREACD = 3;

    private static final int C_ENSEN_SORT_KEY = 4;

    private static final int C_ENSEN_USE_STOP_FLG = 5;

    private static final int C_EKICD = 6;

    private static final int C_EKINAME = 7;

    private static final int C_EKI_SORT_KEY = 8;

    private static final int C_STOP_FLG = 9;

    private static final int C_EKI_USE_STOP_FLG = 10;

    private static final int C_ENSENKANA = 11;

    private static final int C_RAILWAYCO_NO = 12;

    private static final int C_ENSENSEQ = 13;

    private static final int C_EKINO = 14;

    private static final int C_STARTEKI_FLG = 15;

    private static final int C_EKISEQ = 16;

    private static final int C_ENSENNAME_SHORT = 17;

    private static final int C_ENSENKANA_SHORT = 18;

    /** 沿線・駅の登録/変更/削除処理 DAO */
    private RosenUpdateCommitDao rosenUpdateCommitDao = null;

    /**
     * RosenUpdateCommitDaoを設定する。
     * @param rosenUpdateCommitDao
     */
    public void setRosenUpdateCommitDao(RosenUpdateCommitDao rosenUpdateCommitDao) {
        this.rosenUpdateCommitDao = rosenUpdateCommitDao;
    }

    public void crsPlusCacheClear() throws ApplicationException {
    	final String crsPlusMachine1 = ServerProperties.getProperty("crsPlusMachine1");
    	final String crsPlusMachine2 = ServerProperties.getProperty("crsPlusMachine2");
    	final String crsPlusMachine3 = ServerProperties.getProperty("crsPlusMachine3");
    	final String crsPlusMachine4 = ServerProperties.getProperty("crsPlusMachine4");

    	final List<String> machines = new ArrayList<String>();
    	if(StringUtils.isNotEmpty(crsPlusMachine1)){
    		machines.add(crsPlusMachine1);
    	}
    	if(StringUtils.isNotEmpty(crsPlusMachine2)){
    		machines.add(crsPlusMachine2);
    	}
    	if(StringUtils.isNotEmpty(crsPlusMachine3)){
    		machines.add(crsPlusMachine3);
    	}
    	if(StringUtils.isNotEmpty(crsPlusMachine4)){
    		machines.add(crsPlusMachine4);
    	}
    	for(final String url: machines){
    		crsPlusCacheClear(url);
    	}
    }

    public void crsPlusCacheClear(final String url) throws ApplicationException {
    	HttpConnectionManagerParams params = new HttpConnectionManagerParams();
		params.setConnectionTimeout(5000); // コネクションタイムアウトmsec
		params.setSoTimeout(5000); // ソケットタイムアウトmsec
		HttpConnectionManager manager = new SimpleHttpConnectionManager();
		manager.setParams(params);
		//Create an instance of HttpClient.
        final HttpClient client = new HttpClient(manager);

        // Create a method instance.
        final GetMethod method = new GetMethod(new StringBuilder(url).toString());
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

        try {
            // Execute the method.
            final int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                logger.error("Method failed: " + method.getStatusLine());
            }
        } catch (final HttpException e) {
            logger.error(e);
        } catch (final IOException e) {
            logger.error(e);
        } finally {
            // Release the connection.
            method.releaseConnection();
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.RosenUpdateCommService#rosenUpdateCommit(net.chintai.backend.sysadmin.master.service.bean.RosenUpdateCommitInServiceBean)
     */
    public void rosenUpdateCommit(RosenUpdateCommitInServiceBean inServiceBean) throws ApplicationException {

        // DB更新用レコードの構築
        Map<String, EnsenDomain> ensenMap = new LinkedHashMap<String, EnsenDomain>();
        Map<String, EkiDomain> ekiMap = new LinkedHashMap<String, EkiDomain>();

        List<String[]> csvList = inServiceBean.getUploadList();

        for (int i = 0; i < csvList.size(); i++) {
            String[] line = csvList.get(i);

            String lineNumber = String.valueOf(i + 1);

            validate(line, lineNumber);

            if (ensenMap.containsKey(line[C_ENSENCD])) {
                if (!isValidEnsenData(ensenMap.get(line[C_ENSENCD]), line)) {
                    String[] msg = { lineNumber, "沿線コード", line[C_ENSENCD] };
                    throw new ApplicationException("WARN.M.MASTER.0030", msg);
                }
            } else {
                ensenMap.put(line[C_ENSENCD], arrayToEnsenBean(line, inServiceBean, lineNumber));
            }

            // Map のキーとして使うために、駅データのPrimaryKeyを結合
            String ekiKey = generateEkiKey(line[C_ENSENCD], line[C_EKICD]);

            if (ekiMap.containsKey(ekiKey)) {
                String[] msg = { lineNumber, "駅コード", ekiKey };
                throw new ApplicationException("WARN.M.MASTER.0029", msg);
            } else {
                ekiMap.put(ekiKey, arrayToEkiBean(line, inServiceBean));
            }
        }

        // DB更新実行
        setAllEnsenRecords(ensenMap);
        setAllEkiRecords(ekiMap);
    }

    /*
     * private methods
     */

    // ----- データチェック --------------------
    /**
     * DBに登録するデータの形式をチェックする内部メソッド。
     * @param line データ1行分を表すString配列
     * @param lineNumber 行番号
     * @throws ApplicationException データ形式が不正な場合にスローされる
     */
    private void validate(String[] line, String lineNumber) throws ApplicationException {

        // null チェック
        if (line == null) {

            throw new ApplicationException("ERROR.M.MASTER.0003");
        }

        // 行全体のカラム数
        if (line.length != 19) {

            String[] msg = { lineNumber };
            throw new ApplicationException("WARN.M.MASTER.0031", msg);
        }

        if (StringUtils.isEmpty(line[C_ENSENCD])) {

            String[] msg = { lineNumber, "沿線コード" };
            throw new ApplicationException("WARN.M.MASTER.0032", msg);

        }

        if (line[C_ENSENCD].length() != 6 || !StringUtils.isAlphanumeric(line[C_ENSENCD])) {

            String[] msg = { lineNumber, "沿線コード", line[C_ENSENCD] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (line[C_ENSENCD].getBytes().length != 6) {

            String[] msg = { lineNumber, "沿線コード", line[C_ENSENCD] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (StringUtils.isEmpty(line[C_ENSENNAME])) {

            String[] msg = { lineNumber, "沿線名称" };
            throw new ApplicationException("WARN.M.MASTER.0032", msg);
        }

        if (line[C_ENSENNAME].length() > 64) {

            String[] msg = { lineNumber, "沿線名称", line[C_ENSENNAME] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (StringUtils.isEmpty(line[C_ENSENTYPE])) {

            String[] msg = { lineNumber, "沿線タイプ" };
            throw new ApplicationException("WARN.M.MASTER.0032", msg);
        }

        if (line[C_ENSENTYPE].length() > 1 || !StringUtils.isNumeric(line[C_ENSENTYPE])) {

            String[] msg = { lineNumber, "沿線タイプ", line[C_ENSENTYPE] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (StringUtils.isEmpty(line[C_AREACD])) {

            String[] msg = { lineNumber, "エリアコード" };
            throw new ApplicationException("WARN.M.MASTER.0032", msg);
        }

        if (line[C_AREACD].length() != 4) {

            String[] msg = { lineNumber, "エリアコード", line[C_AREACD] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (line[C_ENSEN_SORT_KEY] != null && line[C_ENSEN_SORT_KEY].length() > 4) {

            String[] msg = { lineNumber, "沿線ソートキー", line[C_ENSEN_SORT_KEY] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (!StringUtils.isNumeric(line[C_ENSEN_SORT_KEY])) {

            String[] msg = { lineNumber, "沿線ソートキー", line[C_ENSEN_SORT_KEY] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (line[C_ENSEN_USE_STOP_FLG] != null && line[C_ENSEN_USE_STOP_FLG].length() > 1) {
            String[] msg = { lineNumber, "沿線配布停止区分", line[C_ENSEN_USE_STOP_FLG] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        } else if (StringUtils.isEmpty(line[C_ENSEN_USE_STOP_FLG])) {
            line[C_ENSEN_USE_STOP_FLG] = "0"; // 値が設定されなかった場合は強制的に「0:有効なレコード」に読み替え
        }

        if (!StringUtils.isNumeric(line[C_ENSEN_USE_STOP_FLG])) {
            String[] msg = { lineNumber, "沿線配布停止区分", line[C_ENSEN_USE_STOP_FLG] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (StringUtils.isEmpty(line[C_EKICD])) {

            String[] msg = { lineNumber, "駅コード" };
            throw new ApplicationException("WARN.M.MASTER.0032", msg);
        }

        if (line[C_EKICD].length() != 3 || !StringUtils.isNumeric(line[C_EKICD])) {

            String[] msg = { lineNumber, "駅コード", line[C_EKICD] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (StringUtils.isEmpty(line[C_EKINAME])) {

            String[] msg = { lineNumber, "駅名称" };
            throw new ApplicationException("WARN.M.MASTER.0032", msg);
        }

        if (line[C_EKINAME].length() > 64) {

            String[] msg = { lineNumber, "駅名称", line[C_EKINAME] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (line[C_EKI_SORT_KEY] != null && line[C_EKI_SORT_KEY].length() > 4) {

            String[] msg = { lineNumber, "駅ソートキー", line[C_EKI_SORT_KEY] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (!StringUtils.isNumeric(line[C_EKI_SORT_KEY])) {

            String[] msg = { lineNumber, "駅ソートキー", line[C_EKI_SORT_KEY] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (StringUtils.isEmpty(line[C_STOP_FLG])) {

            String[] msg = { lineNumber, "駅停車種類フラグ" };
            throw new ApplicationException("WARN.M.MASTER.0032", msg);
        }

        if (line[C_STOP_FLG].length() > 1 || !StringUtils.isNumeric(line[C_STOP_FLG])) {

            String[] msg = { lineNumber, "駅停車種類フラグ", line[C_STOP_FLG] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (line[C_EKI_USE_STOP_FLG] != null && line[C_EKI_USE_STOP_FLG].length() > 1) {

            String[] msg = { lineNumber, "駅配布停止区分", line[C_EKI_USE_STOP_FLG] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        } else if (StringUtils.isEmpty(line[C_EKI_USE_STOP_FLG])) {
            line[C_EKI_USE_STOP_FLG] = "0"; // 値が設定されなかった場合は強制的に「0:有効なレコード」に読み替え
        }

        if (!StringUtils.isNumeric(line[C_EKI_USE_STOP_FLG])) {
            String[] msg = { lineNumber, "駅配布停止区分", line[C_EKI_USE_STOP_FLG] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        // 沿線名称かな
        if (line[C_ENSENKANA].length() > 64) {
            String[] msg = { lineNumber, "沿線名称かな", line[C_ENSENKANA] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        } else if (line[C_ENSENTYPE].equalsIgnoreCase("1")) {
            if (StringUtils.isEmpty(line[C_ENSENKANA])) {
                String[] msg = { lineNumber, "沿線名称かな" };
                throw new ApplicationException("WARN.M.MASTER.0032", msg);
            }
        } else if (line[C_ENSENTYPE].equalsIgnoreCase("2")) {
            if (StringUtils.isEmpty(line[C_ENSENKANA])) {
                String[] msg = { lineNumber, "沿線名称かな" };
                throw new ApplicationException("WARN.M.MASTER.0032", msg);
            }
        } else if (line[C_ENSENTYPE].equalsIgnoreCase("3")) {
            if (StringUtils.isEmpty(line[C_ENSENKANA])) {
                String[] msg = { lineNumber, "沿線名称かな" };
                throw new ApplicationException("WARN.M.MASTER.0032", msg);
            }
        }

        // 鉄道会社番号
        if (line[C_RAILWAYCO_NO].length() > 5) {
            String[] msg = { lineNumber, "鉄道会社番号", line[C_RAILWAYCO_NO] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (!StringUtils.isNumeric(line[C_RAILWAYCO_NO])) {
            String[] msg = { lineNumber, "鉄道会社番号", line[C_RAILWAYCO_NO] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        // 沿線シーケンス
        if (line[C_ENSENSEQ].length() > 6) {
            String[] msg = { lineNumber, "沿線シーケンス", line[C_ENSENSEQ] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (!StringUtils.isNumeric(line[C_ENSENSEQ])) {
            String[] msg = { lineNumber, "沿線シーケンス", line[C_ENSENSEQ] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        // 統一駅番号
        if (line[C_EKINO].length() > 5) {
            String[] msg = { lineNumber, "統一駅番号", line[C_EKINO] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (!StringUtils.isNumeric(line[C_EKINO])) {
            String[] msg = { lineNumber, "統一駅番号", line[C_EKINO] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if ("1".equals(line[C_ENSENTYPE]) || "2".equals(line[C_ENSENTYPE]) || "3".equals(line[C_ENSENTYPE])) {
        	//沿線タイプが1,2,3のとき、統一駅番号は必須。
        	if(StringUtils.isEmpty(line[C_EKINO])){
        		String[] msg = { lineNumber, "統一駅番号", line[C_EKINO] };
                throw new ApplicationException("WARN.M.MASTER.0032", msg);
        	}
        }

        // 始発駅フラグ
        if (line[C_STARTEKI_FLG].length() > 1) {

            String[] msg = { lineNumber, "始発駅フラグ", line[C_STARTEKI_FLG] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        } else if (line[C_ENSENTYPE].equalsIgnoreCase("1")) {
            if (StringUtils.isEmpty(line[C_STARTEKI_FLG])) {
                String[] msg = { lineNumber, "始発駅フラグ" };
                throw new ApplicationException("WARN.M.MASTER.0032", msg);
            }
        } else if (line[C_ENSENTYPE].equalsIgnoreCase("2")) {
            if (StringUtils.isEmpty(line[C_STARTEKI_FLG])) {
                String[] msg = { lineNumber, "始発駅フラグ" };
                throw new ApplicationException("WARN.M.MASTER.0032", msg);
            }
        } else if (line[C_ENSENTYPE].equalsIgnoreCase("3")) {
            if (StringUtils.isEmpty(line[C_STARTEKI_FLG])) {
                String[] msg = { lineNumber, "始発駅フラグ" };
                throw new ApplicationException("WARN.M.MASTER.0032", msg);
            }
        }

        if (!StringUtils.isNumeric(line[C_STARTEKI_FLG])) {
            String[] msg = { lineNumber, "始発駅フラグ", line[C_STARTEKI_FLG] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        // 駅シーケンス
        if (line[C_EKISEQ].length() > 8) {
            String[] msg = { lineNumber, "駅シーケンス", line[C_EKISEQ] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        if (!StringUtils.isNumeric(line[C_EKISEQ])) {
            String[] msg = { lineNumber, "駅シーケンス", line[C_EKISEQ] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        // 沿線略称
        if (line[C_ENSENNAME_SHORT].length() > 64) {
            String[] msg = { lineNumber, "沿線略称", line[C_ENSENNAME_SHORT] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

        // 沿線略称かな
        if (line[C_ENSENKANA_SHORT].length() > 64) {
            String[] msg = { lineNumber, "沿線略称かな", line[C_ENSENKANA_SHORT] };
            throw new ApplicationException("WARN.M.MASTER.0028", msg);
        }

    }

    /**
     * 沿線データの各行の間で矛盾がないかどうかチェックする内部メソッド。
     * @param ensen 比較元沿線データ
     * @param line csv行データ
     * @return 問題なし: true, 問題あり: false
     */
    private boolean isValidEnsenData(EnsenDomain ensen, String[] line) {

        if (!ensen.getEnsenCd().equals(line[C_ENSENCD])) {
            return false;
        }

        if (!ensen.getEnsenName().equals(line[C_ENSENNAME])) {
            return false;
        }

        if (!ensen.getEnsenType().equals(line[C_ENSENTYPE])) {
            return false;
        }

        if (!ensen.getAreaCd().equals(line[C_AREACD])) {
            return false;
        }

        if (!ensen.getEnsenKana().equals(line[C_ENSENKANA])) {
            return false;
        }

        if (!ensen.getRailwaycoNo().equals(line[C_RAILWAYCO_NO])) {
            return false;
        }

        if (!ensen.getEnsenSeq().equals(line[C_ENSENSEQ])) {
            return false;
        }
        // sortkey が null の場合をチェック
        if (StringUtils.isEmpty(ensen.getEnsenSortKey()) && !StringUtils.isEmpty(line[C_ENSEN_SORT_KEY])) {
            return false;
        }

        // sortkey が null でない場合をチェック
        if (!ensen.getEnsenSortKey().equals(line[C_ENSEN_SORT_KEY])) {
            return false;
        }

        if (!ensen.getEnsenUseStopFlg().equals(line[C_ENSEN_USE_STOP_FLG])) {
            return false;
        }

        return true;
    }

    // ----- Beanデータ生成 --------------------
    /**
     * CSV行データから沿線Beanを生成する内部メソッド。
     * @param line csv行データ
     * @param inServiceBean CSV取得したデータ
     * @param lineNumber CSVファイルの処理対象行番号
     * @return 生成されたEnsenDomain
     */
    private EnsenDomain arrayToEnsenBean(String[] line, RosenUpdateCommitInServiceBean inServiceBean, String lineNumber) {
        EnsenDomain ensen = new EnsenDomain();

        ensen.setEnsenCd(line[C_ENSENCD]);
        ensen.setEnsenName(line[C_ENSENNAME]);
        ensen.setAreaCd(line[C_AREACD]);
        ensen.setEnsenType(line[C_ENSENTYPE]);
        ensen.setEnsenSortKey(line[C_ENSEN_SORT_KEY]);
        ensen.setEnsenUseStopFlg(line[C_ENSEN_USE_STOP_FLG]);
        ensen.setEnsenKana(line[C_ENSENKANA]);
        ensen.setRailwaycoNo(line[C_RAILWAYCO_NO]);
        ensen.setEnsenSeq(line[C_ENSENSEQ]);
        ensen.setEnsennameShort(StringUtils.isNotEmpty(line[C_ENSENNAME_SHORT])? line[C_ENSENNAME_SHORT]: line[C_ENSENNAME]);
        ensen.setEnsenkanaShort(StringUtils.isNotEmpty(line[C_ENSENKANA_SHORT])? line[C_ENSENKANA_SHORT]: line[C_ENSENKANA]);
        ensen.setOperUserId(inServiceBean.getOperUserId());
        ensen.setPgName(inServiceBean.getPgName());
        ensen.setLineNumber(lineNumber);
        return ensen;
    }

    /**
     * CSV行データから駅Beanを生成する内部メソッド。
     * @param line csv行データ
     * @param inServiceBean CSV取得したデータ
     * @return 生成されたEkiDomain
     */
    private EkiDomain arrayToEkiBean(String[] line, RosenUpdateCommitInServiceBean inServiceBean) {
        EkiDomain eki = new EkiDomain();

        eki.setEkiCd(line[C_EKICD]);
        eki.setEkiName(line[C_EKINAME]);
        eki.setEnsenCd(line[C_ENSENCD]);
        eki.setEkiSortKey(line[C_EKI_SORT_KEY]);
        eki.setStopFlg(line[C_STOP_FLG]);
        eki.setEkiUseStopFlg(line[C_EKI_USE_STOP_FLG]);
        eki.setEkiNo(line[C_EKINO]);
        if("4".equals(line[C_ENSENTYPE])){
        	eki.setStartekiFlg("0");
        }else{
        	eki.setStartekiFlg(line[C_STARTEKI_FLG]);
        }
        eki.setEkiSeq(line[C_EKISEQ]);
        eki.setOperUserId(inServiceBean.getOperUserId());
        eki.setPgName(inServiceBean.getPgName());
        return eki;
    }

    /**
     * 駅Mapのキー文字列を生成する内部メソッド。
     * @param ensenCode 沿線コード
     * @param ekiCode 駅コード
     * @return 駅Map用キーコード
     */
    private String generateEkiKey(String ensenCode, String ekiCode) {
        StringBuilder sb = new StringBuilder();
        sb.append(ensenCode);
        sb.append("-");
        sb.append(ekiCode);
        return sb.toString();
    }

    // ----- 沿線マスタ更新処理 --------------------
    /**
     * ensenMap の全レコードを沿線マスタ, および沿線マスタ除外テーブルに反映する。
     * @param ensenMap 沿線データMap
     * @throws ApplicationException
     */
    private void setAllEnsenRecords(Map<String, EnsenDomain> ensenMap) throws ApplicationException {

        Map<String, EnsenDomain> ensenMasterCache = getEnsenMasterCache(new ArrayList<String>(ensenMap.keySet()));

        for (EnsenDomain ensen : ensenMap.values()) {
            try {
                upsertEnsenRecord(ensen, ensenMasterCache);
                processEnsenUseStopFlgRecord(ensen, ensenMasterCache);

            } catch (DataAccessException e) {
                String[] msg = { "沿線", ensen.getLineNumber(), "沿線コード", ensen.getEnsenCd() };
                throw new ApplicationException("WARN.M.MASTER.0027", msg);
            }
        }
    }

    /**
     * 沿線マスタのキャッシュを取得する内部メソッド。
     */
    private Map<String, EnsenDomain> getEnsenMasterCache(List<String> ensenCodeList) {
        return rosenUpdateCommitDao.selectEnsenMaster(ensenCodeList);
    }

    /**
     * 沿線データが既に存在すれば更新、存在しなければ追加を行う内部メソッド。
     * @param ensen 沿線データ
     * @param ensenMasterCache 沿線マスタのキャッシュ
     */
    private void upsertEnsenRecord(EnsenDomain ensen, Map<String, EnsenDomain> ensenMasterCache) {
        if (existsCodeForEnsenMaster(ensen.getEnsenCd(), ensenMasterCache)) {
            rosenUpdateCommitDao.ensenUpdate(ensen);
        } else {
            rosenUpdateCommitDao.ensenInsert(ensen);
        }
    }

    /**
     * 指定した沿線が沿線マスタにすでに存在するかどうかチェックする内部メソッド。
     * @param ensenCode 沿線コード
     * @param ensenMasterCache 沿線マスタのキャッシュ
     * @return 沿線マスタに存在する: true, 存在しない: false
     */
    private boolean existsCodeForEnsenMaster(String ensenCode, Map<String, EnsenDomain> ensenMasterCache) {
        return ensenMasterCache.containsKey(ensenCode);
    }

    /**
     * 沿線配布区分の状態をチェックし、必要であれば追加/削除を行う内部メソッド。
     * @param ensen 沿線データ
     * @param ensenMasterCache 沿線マスタのキャッシュ
     */
    private void processEnsenUseStopFlgRecord(EnsenDomain ensen, Map<String, EnsenDomain> ensenMasterCache) {
        if (shouldDeleteMaterEnsenUseStopFlg(ensen, ensenMasterCache)) {
            rosenUpdateCommitDao.ensenUseStopFlgDelete(ensen);
        } else if (shouldInsertMasterEnsenUseStopFlg(ensen, ensenMasterCache)) {
            rosenUpdateCommitDao.ensenUseStopFlgInsert(ensen);
        }
    }

    /**
     * 沿線マスタ配布停止テーブルから該当データを削除すべきかを判断する内部メソッド。
     * @param ensen 沿線データ
     * @param ensenMasterCache 沿線マスタのキャッシュ
     * @return 削除すべき: true, 削除不要: false
     */
    private boolean shouldDeleteMaterEnsenUseStopFlg(EnsenDomain ensen, Map<String, EnsenDomain> ensenMasterCache) {
        // 削除すべきデータが配布停止テーブルに存在していれば削除を実行すべき。
        // 元々テーブルに存在しないデータなら、削除実行は無駄なコストになるので行うべきでない。
        return ensen.getEnsenUseStopFlg().equals("0")
                && getMasterEnsenUseStopFlg(ensen.getEnsenCd(), ensenMasterCache).equals("1");
    }

    /**
     * 沿線マスタ配布停止テーブルに該当データを追加すべきかを判断する内部メソッド。
     * @param ensen 沿線データ
     * @param ensenMasterCache 沿線マスタのキャッシュ
     * @return 追加すべき: true, 追加不要: false
     */
    private boolean shouldInsertMasterEnsenUseStopFlg(EnsenDomain ensen, Map<String, EnsenDomain> ensenMasterCache) {
        // 追加すべきデータが配布停止テーブルに存在しなければ、追加すべき。
        // 元々テーブルに存在するデータなら、追加操作は制約違反になるので行うべきでない。
        return ensen.getEnsenUseStopFlg().equals("1")
                && getMasterEnsenUseStopFlg(ensen.getEnsenCd(), ensenMasterCache).equals("0");
    }

    /**
     * 沿線マスタの沿線配布停止区分を取得する内部メソッド。
     * @param ensenCode 沿線コード
     * @param ensenMasterCache 沿線マスタのキャッシュ
     * @return 沿線配布停止区分(0 or 1)
     */
    private String getMasterEnsenUseStopFlg(String ensenCode, Map<String, EnsenDomain> ensenMasterCache) {
        EnsenDomain ensen = ensenMasterCache.get(ensenCode);
        return (ensen == null) ? "0" : ensen.getEnsenUseStopFlg();
    }

    // ----- 駅マスタ更新処理 --------------------
    /**
     * ekiMap の全レコードを駅マスタ/駅マスタ除外テーブルに反映する。
     * @param ekiMap 駅データMap
     * @throws ApplicationException
     */
    private void setAllEkiRecords(Map<String, EkiDomain> ekiMap) throws ApplicationException {

        Map<String, EkiDomain> ekiMasterCache = getEkiMasterCache(new ArrayList<EkiDomain>(ekiMap.values()));

        int lineNumber = 0;
        for (EkiDomain eki : ekiMap.values()) {
            lineNumber++;
            try {
                upsertEkiRecord(eki, ekiMasterCache);
                processEkiUseStopRecord(eki, ekiMasterCache);

            } catch (DataAccessException e) {
                String[] msg = { "駅", String.valueOf(lineNumber), "駅コード", eki.getEkiCd() };
                throw new ApplicationException("WARN.M.MASTER.0027", msg);
            }
        }
    }

    /**
     * 駅マスタキャッシュを取得する内部メソッド。<br>
     * キー文字列は沿線コードと駅コードをハイフンでつないだもの。
     */
    private Map<String, EkiDomain> getEkiMasterCache(List<EkiDomain> ekiList) {
        return rosenUpdateCommitDao.selectEkiMaster(ekiList);
    }

    /**
     * 駅データが既に存在すれば更新、存在しなければ追加を行う内部メソッド。
     * @param eki 駅データ
     * @param ekiMasterCache 駅マスタのキャッシュ
     */
    private void upsertEkiRecord(EkiDomain eki, Map<String, EkiDomain> ekiMasterCache) {
        if (existsCodeForEkiMaster(eki.getEnsenCd(), eki.getEkiCd(), ekiMasterCache)) {
            rosenUpdateCommitDao.ekiUpdate(eki);
        } else {
            rosenUpdateCommitDao.ekiInsert(eki);
        }
    }

    /**
     * 指定した駅が駅マスタにすでに存在するかどうかチェックする内部メソッド。
     * @param ensenCode 沿線コード
     * @param ekiCode 駅コード
     * @param ekiMasterCache 駅マスタのキャッシュ
     * @return 存在する: true, 存在しない: false
     */
    private boolean existsCodeForEkiMaster(String ensenCode, String ekiCode, Map<String, EkiDomain> ekiMasterCache) {
        return ekiMasterCache.containsKey(generateEkiKey(ensenCode, ekiCode));
    }

    /**
     * 駅配布区分の状態をチェックし、必要であれば追加/削除を行う内部メソッド。
     * @param eki 駅データ
     * @param ekiMasterCache 駅マスタのキャッシュ
     */
    private void processEkiUseStopRecord(EkiDomain eki, Map<String, EkiDomain> ekiMasterCache) {
        if (shouldDeleteMasterEkiUseStopFlg(eki, ekiMasterCache)) {
            rosenUpdateCommitDao.ekiUseStopFlgDelete(eki);
        } else if (shouldInsertMasterEkiUseStopFlg(eki, ekiMasterCache)) {
            rosenUpdateCommitDao.ekiUseStopFlgInsert(eki);
        }
    }

    /**
     * 駅マスタ配布停止テーブルから該当データを削除すべきかを判断する内部メソッド。
     * @param eki 駅データ
     * @param ekiMasterCache 駅マスタのキャッシュ
     * @return 削除すべき: true, 削除不要: false
     */
    private boolean shouldDeleteMasterEkiUseStopFlg(EkiDomain eki, Map<String, EkiDomain> ekiMasterCache) {
        // 削除すべきデータが配布停止テーブルに存在していれば削除を実行すべき。
        // 元々テーブルに存在しないデータなら、削除実行は無駄なコストになるので行うべきでない。
        return eki.getEkiUseStopFlg().equals("0")
                && getMasterEkiUseStopFlg(eki.getEnsenCd(), eki.getEkiCd(), ekiMasterCache).equals("1");
    }

    /**
     * 駅マスタ配布停止テーブルに該当データを追加すべきかを判断する内部メソッド。
     * @param eki 駅データ
     * @param ekiMasterCache 駅マスタのキャッシュ
     * @return 追加すべき: true, 追加不要: false
     */
    private boolean shouldInsertMasterEkiUseStopFlg(EkiDomain eki, Map<String, EkiDomain> ekiMasterCache) {
        // 追加すべきデータが配布停止テーブルに存在しなければ、追加すべき。
        // 元々テーブルに存在するデータなら、追加操作は制約違反になるので行うべきでない。
        return eki.getEkiUseStopFlg().equals("1")
                && getMasterEkiUseStopFlg(eki.getEnsenCd(), eki.getEkiCd(), ekiMasterCache).equals("0");
    }

    /**
     * 駅マスタの駅配布停止区分を取得する内部メソッド。
     * @param ensenCode 沿線コード
     * @param ekiCode 駅コード
     * @param ekiMasterCache 駅マスタのキャッシュ
     * @return 駅配布停止区分(0 or 1)
     */
    private String getMasterEkiUseStopFlg(String ensenCode, String ekiCode, Map<String, EkiDomain> ekiMasterCache) {
        EkiDomain eki = ekiMasterCache.get(generateEkiKey(ensenCode, ekiCode));
        return (eki == null) ? "0" : eki.getEkiUseStopFlg();
    }
}
