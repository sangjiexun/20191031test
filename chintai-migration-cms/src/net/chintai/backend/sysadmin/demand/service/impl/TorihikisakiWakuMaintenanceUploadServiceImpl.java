/*
 * $Id: TorihikisakiWakuMaintenanceUploadServiceImpl.java 4704 2013-10-28 01:15:40Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/01     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.common.util.ValidatorUtils;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceUploadParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiWakuMaintenanceUploadDomain;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuMaintenanceUploadService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuMaintenanceUploadInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * TorihikisakiWakuMaintenanceUploadService実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4704 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuMaintenanceUploadServiceImpl implements
        TorihikisakiWakuMaintenanceUploadService {

    // CSVの項目名とカラム位置の対応
    /** 取引先シーケンスカラム位置番号 */
    private static final int TORIHIKISAKISEQ = 0;

    /** 適用月カラム位置番号 */
    private static final int STARTYM = 4;

    /** 物件枠カラム位置番号 */
    private static final int BUKKENCOUNT = 5;

    /** 物件リスティングカラム位置番号 */
    private static final int TOKUSENCOUNT = 6;

    /** 削除フラグカラム位置番号 */
    private static final int DELKBN = 7;

    // 削除フラグ用定数
    /** 削除フラグ(削除対象) */
    private static final String ONDELKBN = "1";

    // 条件式用Number
    /** DB更新結果0件 */
    private static final int RESULTSNULL = 0;

    /** 行番号用カウント */
    private static final int INCREMENTCOUNT = 1;

    /** 物件枠桁数 */
    private static final int BUKKENCOUNTLEN = 4;

    /** 物件リスティング桁数 */
    private static final int TOKUSENCOUNTLEN = 4;

    /** 取引先シーケンス桁数 */
    private static final int TORIHIKISAKISEQLEN = 5;

    /** 適用月桁数 */
    private static final int STARTYMLEN = 6;

    /** カラム数 */
    private static final int LINELEN = 8;

    /** 日付フォーマット(yyyyMM) */
    private static final String STARTYMFORMAT = "yyyyMM";

    /** 物件リスティング空文字用設定値 */
    private static final String TOKUSENCOUNTSET = "0";

    /** 物件枠・リスティング枠メンテナンスCsvファイル情報取得DAO */
    private TorihikisakiWakuMaintenanceDao torihikisakiWakuMaintenanceDao = null;

    /**
     * torihikisakiWakuMaintenanceDaoを設定する
     * @param torihikisakiWakuMaintenanceDao
     */
    public void setTorihikisakiWakuMaintenanceDao(
            TorihikisakiWakuMaintenanceDao torihikisakiWakuMaintenanceDao) {
        this.torihikisakiWakuMaintenanceDao = torihikisakiWakuMaintenanceDao;
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.demand.service.
     * TorihikisakiWakuMaintenanceUploadService
     * #TorihikisakiWakuMaintenanceUploadCommit
     * (net.chintai.backend.sysadmin.demand
     * .service.bean.TorihikisakiWakuMaintenanceUploadInServiceBean)
     */
    public void torihikisakiWakuMaintenanceUploadCommit(
            TorihikisakiWakuMaintenanceUploadInServiceBean inServiceBean)
            throws ApplicationException {

        // DB更新用レコードの構築
        Map<String, TorihikisakiWakuMaintenanceUploadDomain> uploadMap =
                new LinkedHashMap<String, TorihikisakiWakuMaintenanceUploadDomain>();

        List<String[]> csvList = inServiceBean.getUploadList();

        // CSVファイル行数分繰返す(カラム名の行1行目は除く)
        for (int i = 0; i < csvList.size(); i++) {
            String[] line = csvList.get(i);

            String lineNumber = String.valueOf(i + INCREMENTCOUNT);

            // 行全体のカラム数
            if (line.length != LINELEN) {
                String[] msg = { lineNumber };
                throw new ApplicationException("WARN.M.DEMAND.0154", msg);
            }


            // 項目の空文字チェック
            if (ignoreCheck(line)) {

                // 物件リスティングが空文字の場合"0"を設定
                if (StringUtils.isEmpty(line[TOKUSENCOUNT])) {
                    line[TOKUSENCOUNT] = TOKUSENCOUNTSET;
                }

                // フォーマットチェック
                validate(line, lineNumber);

                // 内容チェック
                check(line, lineNumber, uploadMap);

                // データ存在チェック
                TorihikisakiWakuMaintenanceUploadDomain torihikiWakuBean =
                        checkExists(line, lineNumber);

                uploadMap.put(line[TORIHIKISAKISEQ] + line[STARTYM],
                        arrayToTorihikiBean(line, inServiceBean, lineNumber, torihikiWakuBean));

            }
        }

        if (uploadMap.isEmpty()){
            String[] msg = { "更新対象データ" };
            throw new ApplicationException("WARN.M.DEMAND.0155", msg);
        }

        // DB更新実行
        for (TorihikisakiWakuMaintenanceUploadDomain torihiki : uploadMap.values()) {
            try {

                TorihikisakiWakuMaintenanceUploadParamBean paramBean =
                        new TorihikisakiWakuMaintenanceUploadParamBean();
                try {
                    BeanUtils.copyProperties(paramBean, torihiki);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                dataBaseAccess(torihiki, paramBean);

            } catch (DataAccessException e) {
                throw new ApplicationException("ERROR.M.DEMAND.0145");
            }
        }

    }

    /*
     * private methods
     */

    /**
     * CSVファイル必須項目の空文字チェック
     * @param csvList CSVファイルリスト
     * @param countNumber 行番号
     * @return 空文字が無い場合 true; 空文字がある場合false;
     */
    private boolean ignoreCheck(String[] line) {
        if (StringUtils.isEmpty(line[TORIHIKISAKISEQ]) || StringUtils.isEmpty(line[STARTYM])
                || StringUtils.isEmpty(line[BUKKENCOUNT])) {
            return false;
        }
        return true;

    }

    /**
     * DBに登録するデータの形式をチェックする内部メソッド。
     * @param line データ1行分を表すString配列
     * @param lineNumber 行番号
     * @throws ApplicationException データ形式が不正な場合にスローされる
     */
    private void validate(String[] line, String lineNumber) throws ApplicationException {

        // 取引先シーケンス
        if (line[TORIHIKISAKISEQ].length() > TORIHIKISAKISEQLEN
                || ValidatorUtils.isNotHalfSizeNumber(line[TORIHIKISAKISEQ])) {
            String[] msg = { lineNumber, "取引先シーケンス" };
            throw new ApplicationException("WARN.M.DEMAND.0139", msg);
        }

        // 適用月
        if (line[STARTYM].length() > STARTYMLEN || ValidatorUtils.isNotHalfSizeNumber(line[STARTYM])) {
            String[] msg = { lineNumber, "適用月"};
            throw new ApplicationException("WARN.M.DEMAND.0139", msg);
        }

        if (!DemandUtils.isDataFormat(line[STARTYM], STARTYMFORMAT)) {
            String[] msg = { lineNumber, "適用月" };
            throw new ApplicationException("WARN.M.DEMAND.0139", msg);
        }

        // 物件枠
        if (line[BUKKENCOUNT].length() > BUKKENCOUNTLEN
                || ValidatorUtils.isNotHalfSizeNumber(line[BUKKENCOUNT])) {
            String[] msg = { lineNumber, "物件枠" };
            throw new ApplicationException("WARN.M.DEMAND.0139", msg);
        }

        // 物件リスティング
        if (line[TOKUSENCOUNT].length() > TOKUSENCOUNTLEN
                || ValidatorUtils.isNotHalfSizeNumber(line[TOKUSENCOUNT])) {
            String[] msg = { lineNumber, "物件リスティング" };
            throw new ApplicationException("WARN.M.DEMAND.0139", msg);
        }

        // 削除フラグ
        if (!StringUtils.isEmpty(line[DELKBN]) && !line[DELKBN].equals(ONDELKBN)) {
            String[] msg = { lineNumber, "削除フラグ" };
            throw new ApplicationException("WARN.M.DEMAND.0139", msg);

        }
    }

    // ----- Beanデータ生成 --------------------
    /**
     * CSV行データからBeanを生成する内部メソッド。
     * @param line csv行データ
     * @param inServiceBean CSV取得したデータ
     * @param lineNumber CSVファイルの処理対象行番号
     * @return 生成されたTorihikisakiWakuMaintenanceUploadList
     */
    private TorihikisakiWakuMaintenanceUploadDomain arrayToTorihikiBean(String[] line,
            TorihikisakiWakuMaintenanceUploadInServiceBean inServiceBean, String lineNumber,
            TorihikisakiWakuMaintenanceUploadDomain torihikiWakuBean) {
        TorihikisakiWakuMaintenanceUploadDomain torihiki =
                new TorihikisakiWakuMaintenanceUploadDomain();

        torihiki.setTorihikisakiSeq(line[TORIHIKISAKISEQ]);
        torihiki.setStartYm(line[STARTYM]);
        torihiki.setBukkenCount(line[BUKKENCOUNT]);
        torihiki.setTokusenCount(line[TOKUSENCOUNT]);
        torihiki.setDelKbn(line[DELKBN]);
        torihiki.setOperUserId(inServiceBean.getOperUserId());
        torihiki.setPgName(inServiceBean.getPgName());
        torihiki.setLineNumber(lineNumber);
        if (torihikiWakuBean != null) {
            torihiki.setUpdDt(torihikiWakuBean.getUpdDt());
        }
        return torihiki;
    }

    /**
     * CSVファイル内容チェック用内部メソッド
     * @param line データ1行分を表すString配列
     * @param lineNumber 行番号
     * @param uploadMap 重複チェック用データ登録用MAP
     * @throws ApplicationException
     */
    private void check(String[] line, String lineNumber,
            Map<String, TorihikisakiWakuMaintenanceUploadDomain> uploadMap)
            throws ApplicationException {
        // CSVファイル内重複チェック
        if (uploadMap.containsKey(line[TORIHIKISAKISEQ] + line[STARTYM])) {
            String[] msg = {lineNumber, uploadMap.get(line[TORIHIKISAKISEQ] + line[STARTYM]).getLineNumber()};
            throw new ApplicationException("WARN.M.DEMAND.0153", msg);
        }

        // 取引先テーブルの、取引先シーケンス存在チェック
        TorihikisakiWakuMaintenanceUploadParamBean paramBean =
                new TorihikisakiWakuMaintenanceUploadParamBean();
        paramBean.setTorihikisakiSeq(line[TORIHIKISAKISEQ]);
        TorihikisakiWakuMaintenanceUploadDomain torihikiSakiSeqCheck =
                torihikisakiWakuMaintenanceDao.getTorihikiSakiSeq(paramBean);
        if (torihikiSakiSeqCheck == null) {
            String[] msg = { lineNumber, "取引先" };
            throw new ApplicationException("WARN.M.DEMAND.0143", msg);
        }
    }

    /**
     * 取引先料金テーブルにデータ存在確認メソッド
     * @param paramBean 検索用リスト
     * @param line CSVファイル内容文字列配列
     * @return 検索結果リスト
     */
    private TorihikisakiWakuMaintenanceUploadDomain updDtAdd(String[] line) {
        TorihikisakiWakuMaintenanceUploadParamBean paramBean =
                new TorihikisakiWakuMaintenanceUploadParamBean();
        paramBean.setTorihikisakiSeq(line[TORIHIKISAKISEQ]);
        paramBean.setStartYm(line[STARTYM]);
        TorihikisakiWakuMaintenanceUploadDomain updDtAddChech =
                torihikisakiWakuMaintenanceDao.getExistData(paramBean);

        return updDtAddChech;

    }

    /**
     * DB登録、更新、削除判定処理メソッド
     * @param torihiki CSVファイル内容情報リスト
     * @param paramBean 検索用リスト
     * @throws ApplicationException
     */
    private void dataBaseAccess(TorihikisakiWakuMaintenanceUploadDomain torihiki,
            TorihikisakiWakuMaintenanceUploadParamBean paramBean) throws ApplicationException {

        if (torihiki.getDelKbn().equals(ONDELKBN)) {
            // 削除処理Delete
            if (torihikisakiWakuMaintenanceDao.torihikisakiWakuMaintenanceDelete(paramBean) == RESULTSNULL) {
                String[] msg = { torihiki.getLineNumber() };
                throw new ApplicationException("ERROR.M.DEMAND.0148", msg);
            }

        } else {

            if (paramBean.getUpdDt() == null) {
                // 登録処理Insert
                try {
                    torihikisakiWakuMaintenanceDao.torihikisakiWakuMaintenanceInsert(paramBean);
                } catch (DataIntegrityViolationException e) {
                    String[] msg = { torihiki.getLineNumber() };
                    throw new ApplicationException("ERROR.M.DEMAND.0147", msg);
                }

            } else {
                // 更新処理Update
                if (torihikisakiWakuMaintenanceDao.torihikisakiWakuMaintenanceUpdate(paramBean) == RESULTSNULL) {
                    String[] msg = { torihiki.getLineNumber() };
                    throw new ApplicationException("ERROR.M.DEMAND.0148", msg);
                }
            }
        }

    }

    /**
     * データ存在チェックメソッド
     * @param line CSVファイル内容文字列配列
     * @param lineNumber 行番号
     * @return 更新対象データ
     * @throws ApplicationException
     */
    private TorihikisakiWakuMaintenanceUploadDomain checkExists(String[] line, String lineNumber)
            throws ApplicationException {

        // 過去日、未来日確認用、CSVファイル適用月
        int startYmCheck = Integer.parseInt(line[STARTYM]);
        // 過去日、未来日確認用、現在月
        int toMonth = Integer.parseInt(DateUtil.getToday(STARTYMFORMAT));

        TorihikisakiWakuMaintenanceUploadDomain retVal = null;

        // 削除時（「削除フラグ」が「1」の場合）に「適用月」が当月以前(当月を含む)チェック
        if (line[DELKBN].equals(ONDELKBN)) {
            if (startYmCheck <= toMonth) {
                String[] msg = { lineNumber, "削除", "適用月", "未来" };
                throw new ApplicationException("WARN.M.DEMAND.0141", msg);
            }

            // 削除時、削除対象データが無い場合(「取引先SEQ」、「適用月」が取引先料金テーブルに無い場合)チェック
            retVal = updDtAdd(line);
            if (retVal == null) {
                String[] msg = { lineNumber, "削除対象" };
                throw new ApplicationException("WARN.M.DEMAND.0142", msg);

            }

            // 登録・更新時（「削除フラグ」が「1」でない場合）に「適用月」が当月より過去(当月は含まない)チェック
        } else {
            retVal = updDtAdd(line);

            if (startYmCheck < toMonth) {
                String errorMsg = null;
                if (retVal == null){
                    errorMsg = "登録";
                } else {
                    errorMsg = "更新";
                }
                String[] msg = { lineNumber, errorMsg, "適用月", "当月か未来" };
                throw new ApplicationException("WARN.M.DEMAND.0140", msg);
            }
        }

        return retVal;

    }
}
