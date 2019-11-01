/*
 * $Id: ContractAmountMaintenanceUploadServiceImpl.java 4704 2013-10-28 01:15:40Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.common.util.ValidatorUtils;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao;
import net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceKikanChkBean;
import net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceUploadParamBean;
import net.chintai.backend.sysadmin.demand.domain.ContractAmountMaintenanceShopDomain;
import net.chintai.backend.sysadmin.demand.domain.ContractAmountMaintenanceUploadDomain;
import net.chintai.backend.sysadmin.demand.service.ContractAmountMaintenanceUploadService;
import net.chintai.backend.sysadmin.demand.service.bean.ContractAmountMaintenanceUploadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingKikanChkBean;
import net.chintai.batch.common.domain.ShopKanri;
import net.chintai.batch.common.persistence.mapper.ShopKanriMapper;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

/**
 * ContractAmountMaintenanceUploadService実装クラス
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountMaintenanceUploadServiceImpl implements
        ContractAmountMaintenanceUploadService {

    // CSVの項目名とカラム位置の対応

	/** 契約管理番号カラム位置番号 */
	private static final int KEIYAKUNOCOUNT = 0;

    /** 店舗コードカラム位置番号 */
    private static final int SHOPCDCOUNT = 1;

    /** 契約名称カラム位置番号 */
    private static final int KEIYAKUKUMEICOUNT = 4;

    /** 契約管理コードカラム位置番号 */
    private static final int KEIYAKUKANRICODECOUNT = 5;

    /** 契約管理オプションコードカラム位置番号 */
    private static final int KEIYAKUKANRISUBCODECOUNT = 6;

    /** 契約開始日時カラム位置番号 */
    private static final int STARTYMCOUNT = 7;

    /** 契約終了日時カラム位置番号 */
    private static final int ENDYMCOUNT = 8;

    /** 枠カラム位置番号 */
    private static final int WAKUCOUNT = 9;

    /** 削除フラグカラム位置番号 */
    private static final int DELKBNCOUNT = 10;

    // 削除フラグ用定数
    /** 削除フラグ(削除対象) */
    private static final String ONDELKBN = "1";

    /** 処理区分＿削除 */
    private static final String SYORI_DEL = "1";

    /** 処理区分＿更新 */
    private static final String SYORI_KOSHIN = "2";

    /** 処理区分＿登録 */
    private static final String SYORI_TOUROKU = "3";

    // 条件式用Number
    /** DB更新結果0件 */
    private static final int RESULTSNULL = 0;

    /** 行番号用カウント */
    private static final int INCREMENTCOUNT = 1;

    /** 店舗コード桁数 */
    private static final int SHOPCDLEN = 9;

    /** 契約管理コード桁数 */
    private static final int KEIYAKUKANRI_LEN  = 5;

    /** 契約管理オプションコード桁数 */
    private static final int KEIYAKUKANRISUB_LEN= 3;

    /** 契約名桁数 */
    private static final int KEIYAKUMEI_LEN= 20;

    /** 契約開始日時 */
    private static final int STARTYMLEN = 14;

    /** 契約終了日時 */
    private static final int ENDYMLEN = 14;

    /** カラム数 */
    private static final int LINELEN = 11;

    /** 日付フォーマット(yyyyMM) */
    private static final String STARTYMFORMAT = "yyyyMMddHHmmss";

    /** 日付フォーマット(yyyyMM) */
    private static final String ENDYMFORMAT = "yyyyMMddHHmmss";

    /** 日付フォーマット(yyyyMM) */
    private static final String STARTYMCOMPAREFORMAT = "yyyyMMddHHmmss";

    /** 日付フォーマット(yyyyMM) */
    private static final String YYYYMMDDHHFORMAT = "yyyyMMddHH";

    /** 物件リスティング空文字用設定値 */
    private static final String TOKUSENCOUNTSET = "0";

    /** MST_SHOP_KEIYAKU_KANRI(店舗契約管理マスタ) */
    private  List<HashMap<String,Object>> lstMstSHopKeiyakuKanri;

    /** MST_SHOP_KEIYAKU_KANRI(店舗契約管理マスタ) */
    private  List<ContractAmountMaintenanceShopDomain> lstMstShopCode;


    /** 物件枠・リスティング枠メンテナンスCsvファイル情報取得DAO */
    private ContractAmountMaintenanceDao contractAmountMaintenanceDao = null;

    // 排他制御用処理追加
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopKanriMapper shopKanrilMapper;

    // 排他制御用処理追加

    /**
     * contractAmountMaintenanceDaoを設定する
     * @param contractAmountMaintenanceDao
     */
    public void setContractAmountMaintenanceDao(
            ContractAmountMaintenanceDao contractAmountMaintenanceDao) {
        this.contractAmountMaintenanceDao = contractAmountMaintenanceDao;
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.demand.service.
     * ContractAmountMaintenanceUploadService
     * #ContractAmountMaintenanceUploadCommit
     * (net.chintai.backend.sysadmin.demand
     * .service.bean.ContractAmountMaintenanceUploadInServiceBean)
     */
    public void contractAmountMaintenanceUploadCommit(
            ContractAmountMaintenanceUploadInServiceBean inServiceBean)
            throws ApplicationException {

        //店舗契約管理マスタ
        lstMstSHopKeiyakuKanri =
                (List<HashMap<String,Object>>)contractAmountMaintenanceDao.getMstSHopKeiyakuKanri();


        // DB更新用レコードの構築
        Map<String, ContractAmountMaintenanceUploadDomain> uploadMap =
                new LinkedHashMap<String, ContractAmountMaintenanceUploadDomain>();

        List<String[]> csvList = inServiceBean.getUploadList();

        // Csvから店舗のマップを作成する。
        HashMap<String, Object> paramMap = getShopListing(csvList);


        //店舗契約管理マスタ
        lstMstShopCode =
                contractAmountMaintenanceDao.getShopKanri(paramMap);

        //店舗全データに関して排他処理
        for (ContractAmountMaintenanceShopDomain shopDomain : lstMstShopCode) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
                Date startDate = sdf.parse(shopDomain.getShopKanriUpdDt());

                shopService.checkAndLockShopKanri(shopDomain.getShopCd(),startDate);
            } catch (InProcessingException e) {
                throw new ApplicationException("ERROR.M.REVIEW.0083", e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
           }
        }

        // CSVファイル行数分繰返す(カラム名の行1行目は除く)
        for (int i = 0; i < csvList.size(); i++) {
            String[] line = csvList.get(i);

            String lineNumber = String.valueOf(i + INCREMENTCOUNT);

            // 行全体のカラム数
            if (line.length != LINELEN) {
                String[] msg = { lineNumber };
                throw new ApplicationException("WARN.M.DEMAND.0013", msg);
            }

            // 項目の空文字チェック
            if (ignoreCheck(line)) {

                // 物件リスティングが空文字の場合"0"を設定
                if (StringUtils.isEmpty(line[WAKUCOUNT])) {
                    line[WAKUCOUNT] = TOKUSENCOUNTSET;
                }

                HashMap<String,Object> mstShopKeiyakuKanriData = null;

                // 契約コード・契約オプションコードチェック
                mstShopKeiyakuKanriData = checkDataExist(line, lineNumber);

                // フォーマットチェック
                validate(line, lineNumber,mstShopKeiyakuKanriData);

                // 内容チェック
                check(line, lineNumber, uploadMap);

                if (!ONDELKBN.equals(line[DELKBNCOUNT])) {
	                ContractAmountMaintenanceUploadParamBean paramBean = new ContractAmountMaintenanceUploadParamBean();
	                paramBean.setShopCd(line[SHOPCDCOUNT]);
	                paramBean.setKeiyakuCd(line[KEIYAKUKANRICODECOUNT]);
	                paramBean.setKeiyakuSubCd(line[KEIYAKUKANRISUBCODECOUNT]);
	                paramBean.setKeiyakuStartDt(line[STARTYMCOUNT]);
	                paramBean.setKeiyakuEndDt(line[ENDYMCOUNT]);
	                paramBean.setKeiyakuNo(line[KEIYAKUNOCOUNT]);
	                countApplyYmdh(paramBean);
                }

                // データ存在チェック
                ContractAmountMaintenanceUploadDomain contractAmountlBean =
                        checkExists(line, lineNumber);

                uploadMap.put(line[SHOPCDCOUNT] + line[KEIYAKUKANRICODECOUNT] + line[KEIYAKUKANRISUBCODECOUNT] + line[STARTYMCOUNT] ,
                        arrayToTorihikiBean(line, inServiceBean, lineNumber, contractAmountlBean));

            }
        }

        if (uploadMap.isEmpty()){
            String[] msg = { "更新対象データ" };
            throw new ApplicationException("WARN.M.DEMAND.0155", msg);
        }

        // DB更新実行
        for (ContractAmountMaintenanceUploadDomain uploadDomain : uploadMap.values()) {
            try {

                ContractAmountMaintenanceUploadParamBean paramBean =
                        new ContractAmountMaintenanceUploadParamBean();
                try {
                    BeanUtils.copyProperties(paramBean, uploadDomain);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                dataBaseAccess(uploadDomain, paramBean);
             } catch (DataAccessException e) {
                throw new ApplicationException("ERROR.M.DEMAND.0002");
            }
        }

        contractAmountMaintenanceDao.shopKanriUpdateCommit(paramMap);

        for (ContractAmountMaintenanceShopDomain shopDomain : lstMstShopCode) {

            ShopKanri shopKanri = shopService.selectShopKanriByPrimaryKey(shopDomain.getShopCd());
            shopKanri.setAdminUpdDt(new Timestamp(System.currentTimeMillis()));
            shopKanri.setUpdDt(new Timestamp(System.currentTimeMillis()));
            shopKanri.setUpdPg(inServiceBean.getPgName());
            shopKanri.setUpdId(inServiceBean.getOperUserId());
            shopKanrilMapper.updateByPrimaryKey(shopKanri);
        }
    }


    /**
     * 契約情報のチェック契約管理マスタと比較して、契約コード、契約オプションコード、契約名をチェックする。
     * 店舗コードのチェック店舗管理マスタと比較して店舗コードをチェックする。
     *
     * @param csvList CSVファイルリスト
     * @param countNumber 行番号
     * @param lineNumber
     */
    private HashMap<String,Object> checkDataExist(String[] line, String lineNumber) throws ApplicationException {

        HashMap<String,Object> ret = null;
        String shopCd = null;

        // 契約コードと契約オプションコードと契約名でマスタからデータ取得
        for (HashMap<String,Object> mstShopKeiyakuKanri :  lstMstSHopKeiyakuKanri) {
            if (line[KEIYAKUKANRICODECOUNT].equals(mstShopKeiyakuKanri.get("KEIYAKU_CD"))
                    && line[KEIYAKUKANRISUBCODECOUNT].equals(mstShopKeiyakuKanri.get("KEIYAKU_SUB_CD"))
                    && line[KEIYAKUKUMEICOUNT].equals(mstShopKeiyakuKanri.get("KEIYAKU_NAME"))){
                ret = mstShopKeiyakuKanri;
            }
        }

        if (ret == null) {
            String[] msg = { lineNumber, "契約名称、契約管理コード、契約管理オプションコード"};
            throw new ApplicationException("WARN.M.DEMAND.0014", msg);
        }

        // 店舗コードの確認
        for (ContractAmountMaintenanceShopDomain mstShopCode :  lstMstShopCode) {
            if (line[SHOPCDCOUNT].equals(mstShopCode.getShopCd())){
                shopCd = mstShopCode.getShopCd();
            }
        }

        if (shopCd == null) {
            String[] msg = { lineNumber, "店舗コード"};
            throw new ApplicationException("WARN.M.DEMAND.0011", msg);
        }

        return ret;
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
        if (StringUtils.isEmpty(line[SHOPCDCOUNT]) || StringUtils.isEmpty(line[KEIYAKUKUMEICOUNT])
                || StringUtils.isEmpty(line[KEIYAKUKANRICODECOUNT]) || StringUtils.isEmpty(line[KEIYAKUKANRISUBCODECOUNT])
                || StringUtils.isEmpty(line[STARTYMCOUNT]) || StringUtils.isEmpty(line[WAKUCOUNT])
                ) {
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
    private void validate(String[] line, String lineNumber,HashMap<String,Object> mstShopKeiyakuKanriData) throws ApplicationException {

    	// 契約管理番号(NULL値許容)
        if (StringUtils.isNotEmpty(line[KEIYAKUNOCOUNT]) && ValidatorUtils.isNotHalfSizeNumber(line[KEIYAKUNOCOUNT])) {
            String[] msg = { lineNumber, "契約管理番号"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }
/*
        // 店舗コード
        if (line[SHOPCDCOUNT].length() > SHOPCDLEN || ValidatorUtils.isNotHalfSizeNumber(line[SHOPCDCOUNT])) {
            String[] msg = { lineNumber, "店舗コード"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }
*/
        // 契約コード
        if (line[KEIYAKUKANRICODECOUNT].length() != KEIYAKUKANRI_LEN || ValidatorUtils.isNotHalfSizeNumber(line[KEIYAKUKANRICODECOUNT])) {
            String[] msg = { lineNumber, "契約管理コード"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // 契約オプションコード
        if (line[KEIYAKUKANRISUBCODECOUNT].length() != KEIYAKUKANRISUB_LEN || ValidatorUtils.isNotHalfSizeNumber(line[KEIYAKUKANRISUBCODECOUNT])) {
            String[] msg = { lineNumber, "契約管理オプションコード"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // 契約名
        if (line[KEIYAKUKUMEICOUNT].length() > KEIYAKUMEI_LEN  ) {
            String[] msg = { lineNumber, "契約名"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // 契約開始日時
        if (line[STARTYMCOUNT].length() > STARTYMLEN || ValidatorUtils.isNotHalfSizeNumber(line[STARTYMCOUNT])) {
            String[] msg = { lineNumber, "契約開始日時"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        if (!DemandUtils.isDataFormat(line[STARTYMCOUNT], STARTYMFORMAT)) {
            String[] msg = { lineNumber, "契約開始日時" };
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // 契約終了日時(NULL値許容)
        if (StringUtils.isNotEmpty(line[ENDYMCOUNT]) && (line[ENDYMCOUNT].length() > ENDYMLEN || ValidatorUtils.isNotHalfSizeNumber(line[ENDYMCOUNT]))) {
            String[] msg = { lineNumber, "契約終了日時"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        if (StringUtils.isNotEmpty(line[ENDYMCOUNT]) && !DemandUtils.isDataFormat(line[ENDYMCOUNT], ENDYMFORMAT)) {
            String[] msg = { lineNumber, "契約終了日時" };
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // 物件枠
        BigDecimal bigLength = (BigDecimal)mstShopKeiyakuKanriData.get("KEIYAKU_AMOUNT_LENGTH");
        int length = bigLength.intValue();
        if (line[WAKUCOUNT].length() > length
                || ValidatorUtils.isNotHalfSizeNumber(line[WAKUCOUNT])) {
            String[] msg = { lineNumber, "契約数量" };
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // 削除フラグ
        if (!StringUtils.isEmpty(line[DELKBNCOUNT]) && !line[DELKBNCOUNT].equals(ONDELKBN)) {
            String[] msg = { lineNumber, "削除フラグ" };
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);

        }

    }

    // ----- Beanデータ生成 --------------------
    /**
     * CSV行データからBeanを生成する内部メソッド。
     * @param line csv行データ
     * @param inServiceBean CSV取得したデータ
     * @param lineNumber CSVファイルの処理対象行番号
     * @return 生成されたContractAmountMaintenanceUploadList
     */
    private ContractAmountMaintenanceUploadDomain arrayToTorihikiBean(String[] line,
            ContractAmountMaintenanceUploadInServiceBean inServiceBean, String lineNumber,
            ContractAmountMaintenanceUploadDomain contractAmountBean) {
        ContractAmountMaintenanceUploadDomain contractAmount =
                new ContractAmountMaintenanceUploadDomain();

        contractAmount.setShopCd(line[SHOPCDCOUNT]);
        contractAmount.setKeiyakuCd(line[KEIYAKUKANRICODECOUNT]);
        contractAmount.setKeiyakuSubCd(line[KEIYAKUKANRISUBCODECOUNT]);
        contractAmount.setKeiyakuName(line[KEIYAKUKUMEICOUNT]);
        contractAmount.setKeiyakuStartDt(line[STARTYMCOUNT]);
        contractAmount.setKeiyakuEndDt(line[ENDYMCOUNT]);
        contractAmount.setKeiyakuAmount(line[WAKUCOUNT]);
        contractAmount.setLineNumber(lineNumber);
        contractAmount.setPgName(inServiceBean.getPgName());
        contractAmount.setOperUserId(inServiceBean.getOperUserId());
        contractAmount.setKeiyakuNo(line[KEIYAKUNOCOUNT]);

        if (contractAmountBean == null) {

            if (!ONDELKBN.equals(line[DELKBNCOUNT])) {
                contractAmount.setSyoriKbn(SYORI_TOUROKU);
            }
        } else {
            if (ONDELKBN.equals(line[DELKBNCOUNT])){
                contractAmount.setSyoriKbn(SYORI_DEL);
            } else {
                contractAmount.setSyoriKbn(SYORI_KOSHIN);
            }
        }
        return contractAmount;
    }

    /**
     * CSVファイル内容チェック用内部メソッド
     * @param line データ1行分を表すString配列
     * @param lineNumber 行番号
     * @param uploadMap 重複チェック用データ登録用MAP
     * @throws ApplicationException
     */
    private void check(String[] line, String lineNumber,
            Map<String, ContractAmountMaintenanceUploadDomain> uploadMap)
            throws ApplicationException {

        String containsKey = line[SHOPCDCOUNT] + line[KEIYAKUKANRICODECOUNT] + line[KEIYAKUKANRISUBCODECOUNT] + line[STARTYMCOUNT];
        // CSVファイル内重複チェック
        if (uploadMap.containsKey(containsKey)) {
            String[] msg = {lineNumber, uploadMap.get(containsKey).getLineNumber()};
            throw new ApplicationException("WARN.M.DEMAND.0012", msg);
        }
//
//        // 取引先テーブルの、取引先シーケンス存在チェック
//        ContractAmountMaintenanceUploadParamBean paramBean =
//                new ContractAmountMaintenanceUploadParamBean();
//        paramBean.setTorihikisakiSeq(line[TORIHIKISAKISEQ]);
//        ContractAmountMaintenanceUploadDomain torihikiSakiSeqCheck =
//                contractAmountMaintenanceDao.getTorihikiSakiSeq(paramBean);
//        if (torihikiSakiSeqCheck == null) {
//            String[] msg = { lineNumber, "取引先" };
//            throw new ApplicationException("WARN.M.DEMAND.0143", msg);
//        }
    }

    /**
     * 店舗契約管理テーブルにデータ存在確認メソッド
     * @param paramBean 検索用リスト
     * @param line CSVファイル内容文字列配列
     * @return 検索結果リスト
     */
    private ContractAmountMaintenanceUploadDomain updDtAdd(String[] line) {
        ContractAmountMaintenanceUploadParamBean paramBean =
                new ContractAmountMaintenanceUploadParamBean();
        paramBean.setShopCd(line[SHOPCDCOUNT]);
        paramBean.setKeiyakuCd(line[KEIYAKUKANRICODECOUNT]);
        paramBean.setKeiyakuSubCd(line[KEIYAKUKANRISUBCODECOUNT]);
        paramBean.setKeiyakuStartDt(line[STARTYMCOUNT]);
        paramBean.setKeiyakuEndDt(line[ENDYMCOUNT]);
        paramBean.setKeiyakuNo(line[KEIYAKUNOCOUNT]);
        ContractAmountMaintenanceUploadDomain updDtAddChech =
                contractAmountMaintenanceDao.getExistData(paramBean);

        return updDtAddChech;

    }

    /**
     * DB登録、更新、削除判定処理メソッド
     * @param contractAmount CSVファイル内容情報リスト
     * @param paramBean 検索用リスト
     * @throws ApplicationException
     */
    private void dataBaseAccess(ContractAmountMaintenanceUploadDomain contractAmount,
            ContractAmountMaintenanceUploadParamBean paramBean) throws ApplicationException {

        if (SYORI_DEL.equals(contractAmount.getSyoriKbn())) {
            // 削除処理Delete
            if (contractAmountMaintenanceDao.contractAmountMaintenanceDelete(paramBean) == RESULTSNULL) {
                String[] msg = { contractAmount.getLineNumber() };
                throw new ApplicationException("ERROR.M.DEMAND.0005", msg);
            }

        } else {

            if (!SYORI_KOSHIN.equals(contractAmount.getSyoriKbn())) {
                // 登録処理Insert
            	contractAmountMaintenanceDao.contractAmountMaintenanceHeaderInsert(paramBean);

/*2014年12月対応でコメントアウト
                // 契約管理テーブルにデータが存在しない場合は登録
                try {
                    if (contractAmountMaintenanceDao.existsKeiyakuKanri(paramBean) == 0) {
                        contractAmountMaintenanceDao.contractAmountMaintenanceHeaderInsert(paramBean);
                    }
                } catch (DataIntegrityViolationException e) {
                    String[] msg = { contractAmount.getLineNumber() };
                    throw new ApplicationException("ERROR.M.DEMAND.0004", msg);
                }

                try {
                    contractAmountMaintenanceDao.contractAmountMaintenanceInsert(paramBean);
                } catch (DataIntegrityViolationException e) {
                    String[] msg = { contractAmount.getLineNumber() };
                    throw new ApplicationException("ERROR.M.DEMAND.0004", msg);
                }
*/
            } else {
                // 更新処理Update
                if (contractAmountMaintenanceDao.contractAmountMaintenanceUpdate(paramBean) == RESULTSNULL) {
                    String[] msg = { contractAmount.getLineNumber() };
                    throw new ApplicationException("ERROR.M.DEMAND.0005", msg);
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
    private ContractAmountMaintenanceUploadDomain checkExists(String[] line, String lineNumber)
            throws ApplicationException {

        // 過去日、未来日確認用、CSVファイル適用日
        long startYmCheck = Long.parseLong(line[STARTYMCOUNT]);
        long endYmCheck = StringUtils.isNotEmpty(line[ENDYMCOUNT]) ? Long.parseLong(line[ENDYMCOUNT]): 0;
        // 過去日、未来日確認用、現在日
        long toMonth = Long.parseLong(DateUtil.getToday(STARTYMCOMPAREFORMAT));
        long nowDate = Long.parseLong(DateUtil.getToday(YYYYMMDDHHFORMAT) + "0000");

        ContractAmountMaintenanceUploadDomain retVal = updDtAdd(line);

        if (line[DELKBNCOUNT].equals(ONDELKBN)) {

            // 削除時、削除対象データが無い場合
        	// (「契約管理番号」「店舗コード」「契約管理コード」「契約管理オプションコード」「契約開始日時」が、店舗契約管理テーブルに無い場合)チェック
            if (retVal == null) {
                String[] msg = { lineNumber, "削除対象" };
                throw new ApplicationException("WARN.M.DEMAND.0010", msg);

            }

            // 削除時（「削除フラグ」が「1」の場合）に「適用日」が翌日以降チェック
            if (startYmCheck < toMonth) {
                String[] msg = { lineNumber, "適用中", "削除" };
                throw new ApplicationException("WARN.M.DEMAND.0016", msg);
            }

            //201412月対応で追加
            if (endYmCheck > 0 && endYmCheck < startYmCheck) {
                String[] msg = { lineNumber, "削除", "契約終了日時", "契約開始日時以降" };
                throw new ApplicationException("WARN.M.DEMAND.0009", msg);
            }

        } else {
        	String errorMsg = null;
            if (retVal == null){
                errorMsg = "登録";
            } else {
                errorMsg = "更新";
            }

            if (retVal == null){//新規登録のとき
	            if (startYmCheck < nowDate) {
	                String[] msg = { lineNumber, errorMsg, "契約開始日時", "現在日時以降" };
	                throw new ApplicationException("WARN.M.DEMAND.0008", msg);
	            }
            }

            if (retVal != null){//更新のとき
            	if ((startYmCheck < toMonth) && !retVal.getKeiyakuAmount().equals(line[WAKUCOUNT])) {
            		//適用中の場合、数量変更不可
            		String[] msg = { lineNumber, "契約数量" };
                    throw new ApplicationException("WARN.M.DEMAND.0007", msg);
	            }
            }

            //201412月対応で追加
            if (endYmCheck > 0 && endYmCheck < startYmCheck) {
                String[] msg = { lineNumber, errorMsg, "契約終了日時", "契約開始日時以降" };
                throw new ApplicationException("WARN.M.DEMAND.0008", msg);
            }
        }

        return retVal;

    }


    /**
     * 検索条件用のMAPを作成する。
     *
     * CSVから店舗の一覧から一意のshopCdの一覧を作成する。
     *
     */
    private  HashMap<String,Object> getShopListing(List<String[]> csvList) {

        //Csvの一覧から店舗コードを一意にする
        HashMap<String,String> mapShopCd = new HashMap<String,String>();

        for (String[] csvArray:  csvList) {
            mapShopCd.put(csvArray[SHOPCDCOUNT], "true");
        }

        List<String> lstShopCd = new ArrayList<String>();
        for(Map.Entry<String, String> e : mapShopCd.entrySet()) {
            lstShopCd.add(e.getKey());
        }

        if (lstShopCd.size() == 0) {
            lstShopCd.add("");
        }

        HashMap<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("arrayShopCd", lstShopCd);

        return paramMap;

    }

    public void countApplyYmdh(ContractAmountMaintenanceUploadParamBean paramBean)
            throws ApplicationException {

        List<ContractAmountMaintenanceKikanChkBean> list = contractAmountMaintenanceDao.checkKeiyakuEndDt(paramBean);

        // 入力された開始日と終了日
        String inputStartDt = paramBean.getKeiyakuStartDt();
        String inputEndDt = paramBean.getKeiyakuEndDt();

        boolean isError = chk(inputStartDt, inputEndDt, list);
/*
        int cnt = 0;

        for(ContractAmountMaintenanceKikanChkBean chkList: list){
        	chkList.setKeiyakuStartYMDH(paramBean.getKeiyakuStartDt());
        	chkList.setKeiyakuEndYMDH(paramBean.getKeiyakuEndDt());

        	cnt = cnt + contractAmountMaintenanceDao.checkAppliyYmdh(chkList);
        }
*/
        if (isError) {
            throw new ApplicationException("WARN.M.SHOP_BUKKEN.0269", new String[] {
                    ApplicationResources.getProperty("shop_bukken.keiyakuYm"),
                    ApplicationResources.getProperty("shop_bukken.keiyakuKikan"),
                    ApplicationResources.getProperty("shop_bukken.keiyakuDuplicate")});
        }

        boolean isDateError = false;
        //契約開始日<VSKK.KEIYAKU_START_DT（YYYYMMDDHH0000）の場合、エラー
        ContractAmountMaintenanceKikanChkBean data = contractAmountMaintenanceDao.viewCheck(paramBean);
        if(data != null){
        	String viewStartDt = data.getKeiyakuStartDt();
        	if(inputStartDt.compareTo(viewStartDt) <= 0){
        		isDateError = true;
        	}
        }

        if (isDateError) {
            throw new ApplicationException("WARN.M.SHOP_BUKKEN.0260", new String[] {
                    ApplicationResources.getProperty("shop_bukken.keiyakuYm"),
                    ApplicationResources.getProperty("shop_bukken.keiyakuApply")});
        }
    }

    public boolean chk(String inputStartDt, String inputEndDt, List<ContractAmountMaintenanceKikanChkBean> list){
    	boolean isError = false;

    	for(int i = 0; i < list.size(); i++){
    		ContractAmountMaintenanceKikanChkBean data = list.get(i);

        	String keiyakuStartDt = data.getKeiyakuStartDt();
        	String keiyakuEndDt = data.getKeiyakuEndDt();

            if(StringUtils.isNotEmpty(inputEndDt)){//開始日・終了日ともに入力ありの場合
            	if(SystemProperties.getProperty("LAST_DT").equals(keiyakuEndDt)){
            		if(i > 0){
            			keiyakuEndDt = list.get(i - 1).getKeiyakuStartDt();
            		}else{
            			keiyakuEndDt = keiyakuStartDt;
            		}

                	if((inputStartDt.compareTo(keiyakuStartDt) <= 0 && inputEndDt.compareTo(keiyakuStartDt) >= 0) || (inputStartDt.compareTo(keiyakuEndDt) <= 0 && inputEndDt.compareTo(keiyakuEndDt) >= 0)){
                		isError = true;
                	}
                }else{
	            	if((inputStartDt.compareTo(keiyakuStartDt) >= 0 && inputStartDt.compareTo(keiyakuEndDt) <= 0) || (inputEndDt.compareTo(keiyakuStartDt) >= 0 && inputEndDt.compareTo(keiyakuEndDt) <= 0) || (inputStartDt.compareTo(keiyakuStartDt) <= 0 && inputEndDt.compareTo(keiyakuEndDt) >= 0)){
	            		isError = true;
	            	}
                }
            }else{
            	//開始日のみ入力の場合
            	if(SystemProperties.getProperty("LAST_DT").equals(keiyakuEndDt)){
                	if(inputStartDt.equals(keiyakuStartDt)){
                		isError = true;
                	}
                }else{
	            	if((inputStartDt.compareTo(keiyakuStartDt) >= 0 && inputStartDt.compareTo(keiyakuEndDt) <= 0)){
	            		isError = true;
	            	}
                }
            }
        }
    	return isError;
    }

}
