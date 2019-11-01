/*
 * $Id: AdDataUpdateCommitServiceImpl.java 4450 2010-02-09 15:02:14Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/24     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.chintai.backend.sysadmin.addata_matching.action.AdDataUploadAction;
import net.chintai.backend.sysadmin.addata_matching.dao.AdDataAddParamBean;
import net.chintai.backend.sysadmin.addata_matching.dao.AdDataUpdateCommitDao;
import net.chintai.backend.sysadmin.addata_matching.service.AdDataUpdateCommitService;
import net.chintai.backend.sysadmin.addata_matching.service.bean.AdDataUpdateInServiceBean;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.common.validator.ValidatorByteLengthCheck;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.GenericValidator;



/**
 * AdDataUpdateCommitServiceImplの実装クラス
 * @author e-ishii
 * @version $Revision: 4450 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
/**
 *
 * @author e-ishii
 * @version $Revision: 4450 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
/**
 *
 * @author e-ishii
 * @version $Revision: 4450 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AdDataUpdateCommitServiceImpl implements AdDataUpdateCommitService{

    private static Log log = LogFactory.getLog(AdDataUploadAction.class);

    // CSVの項目名とカラム位置の対応
    private static final int C_GROUPNAME = 0;
    private static final int C_AREACD = 1;
    private static final int C_AREANAME = 2;
    private static final int C_SHOPCD = 3;
    private static final int C_BUMON = 4;
    private static final int C_TORIHIKI_NO = 5;
    private static final int C_BKCD = 6;
    private static final int C_ROOMCD = 7;
    private static final int C_ROOMTYPE = 8;
    private static final int C_TORIHIKI_SHUBETSU = 9;
    private static final int C_TORIHIKI_NAME = 10;
    private static final int C_CHINRYO = 11;
    private static final int C_TORIHIKI_SAKUSEI_DATE = 12;
    private static final int C_CM_INS_GAKU = 13;
    private static final int C_CM_INS_DT = 14;
    private static final int C_AD_INS_CNT_ = 15;
    private static final int C_AD_INS_GAKU = 16;
    private static final int C_AD_INS_DT = 17;
    private static final int C_KASHI_CM = 18;
    private static final int C_KARI_CM = 19;
    private static final int C_CM_MITSU = 20;
    private static final int C_CM_MITSU_AD = 21;
    private static final int C_TANTOU_CD = 22;
    private static final int C_TANTOU_NAME = 23;
    private static final int C_KASHI_CD = 24;
    private static final int C_DATA_TYPE = 25;


    /** ADデータ登録DAO取得 */
    private AdDataUpdateCommitDao adDataUpdateCommitDao;

    /**
     * ADデータ登録DAOを設定
     * @param shikutyosonAddDao
     */
    public void setAdDataUpdateCommitDao(AdDataUpdateCommitDao adDataUpdateCommitDao) {
        this.adDataUpdateCommitDao = adDataUpdateCommitDao;
    }


    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.addata_matching.service.
     * AdDataUpdateCommitService#adDataUpdateCommit(net.chintai.backend.sysadmin.
     * addata_matching.service.bean.AdDataUpdateServiceBean)
     */
    public void adDataUpdateCommit(AdDataUpdateInServiceBean inServiceBean)
                                                                throws ApplicationException {

        //CVSリストの取得
        List<String[]> csvList = inServiceBean.getUploadList();

        AdDataAddParamBean delParamBean = new AdDataAddParamBean();

        //対象年月のセット
        String taisyoYm = inServiceBean.getUploadYear() + inServiceBean.getUploadMonth();

        BeanUtilsWrapper.copyProperties(delParamBean, inServiceBean);

        delParamBean.setTaisyoYm(taisyoYm);

        //AD_DATA_KANRIテーブルの削除区分を１にセットする。
        adDataUpdateCommitDao.deleteAdData(delParamBean);

        // DAOに渡す引数リスト
        List<AdDataAddParamBean> paramList = new ArrayList<AdDataAddParamBean>();

        // バッチ処理単位
        int defaultExecuteBatch
            = Integer.parseInt(SystemProperties.getProperty("C_DEFAULT_EXECUTE_BATCH"));

        // 現在日付の取得
        java.sql.Timestamp timestamp = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());


        StopWatch stopWatch = new StopWatch();
        stopWatch = new StopWatch();

        stopWatch.start();

        //CSVファイルデータのインサート
        for (int i = 0; i < csvList.size(); i++) {

            String[] line = csvList.get(i);

            String lineNumber = String.valueOf(i + 2);

            validate(line, lineNumber);

            AdDataAddParamBean paramBean = new AdDataAddParamBean();

            //insertにSQLで文字列操作を行うと、速度が遅くなるため、
            //java側でゼロ埋め等の処理を行う。
            //店舗コードのゼロ埋め処理
            String shopCd = StringUtils.isNotEmpty(line[C_SHOPCD]) ?
                                        "000" + line[C_SHOPCD]: line[C_SHOPCD];

            //物件コードを15バイトで'0'埋めを行う。
            String bkCd = StringUtils.isNotEmpty(line[C_BKCD]) ?
                              StringUtils.leftPad(line[C_BKCD],15,'0') : line[C_BKCD];
 //                           StringUtils.substring(line[C_BKCD], 3, 9) : line[C_BKCD];

            paramBean.setShopCDforMatching(shopCd);
            paramBean.setBkCdforMatching(bkCd);
            paramBean.setTaisyoYmforMatching(taisyoYm + "01");

            paramBean.setGroupName(line[C_GROUPNAME]);
            paramBean.setAreaCd(line[C_AREACD]);
            paramBean.setAreaName(line[C_AREANAME]);
            paramBean.setShopCd(line[C_SHOPCD]);
            paramBean.setBumon(line[C_BUMON]);
            paramBean.setTorihikiNo(line[C_TORIHIKI_NO]);
            paramBean.setBkCd(line[C_BKCD]);
            paramBean.setRoomCd(line[C_ROOMCD]);
            paramBean.setRoomtType(line[C_ROOMTYPE]);
            paramBean.setTorihikiShubetsu(line[C_TORIHIKI_SHUBETSU]);
            paramBean.setTorihikiName(line[C_TORIHIKI_NAME]);
            paramBean.setChinryo(line[C_CHINRYO]);
            paramBean.setTorihikiSakuseiDate(line[C_TORIHIKI_SAKUSEI_DATE]);
            paramBean.setCmInsGaku(line[C_CM_INS_GAKU]);
            paramBean.setCmInsDt(line[C_CM_INS_DT]);
            paramBean.setAdInsCnt(line[C_AD_INS_CNT_]);
            paramBean.setAdInsGaku(line[C_AD_INS_GAKU]);
            paramBean.setAdInsDt(line[C_AD_INS_DT]);
            paramBean.setKashiCm(line[C_KASHI_CM]);
            paramBean.setKariCm(line[C_KARI_CM]);
            paramBean.setCmMitsu(line[C_CM_MITSU]);
            paramBean.setCmMitsuAd(line[C_CM_MITSU_AD]);
            paramBean.setTantouCd(line[C_TANTOU_CD]);
            paramBean.setTantouName(line[C_TANTOU_NAME]);
            paramBean.setKashiCd(line[C_KASHI_CD]);
            paramBean.setDataType(line[C_DATA_TYPE]);
            paramBean.setTaisyoYm(taisyoYm);
            paramBean.setOperUserId(inServiceBean.getOperUserId());
            paramBean.setPgName(inServiceBean.getPgName());
            paramBean.setInsDt(timestamp);
            paramBean.setUpdDt(timestamp);
            /*
            try {
                adDataUpdateCommitDao.AdDatainsert(paramBean);

            } catch (DataAccessException e) {

                //String[] msg = { "ADデータ", lineNumber, "エリア", "" };
                throw new ApplicationException("WARN.M.MASTER.0027", msg);
            }
            */
            paramList.add(paramBean);

            // 設定ファイルの指定件数単位でバッチ処理を行う
            // 六万件などのデータを一気にDBに追加すると、OutOfMemoryになるため
            if ( ((i+1) % defaultExecuteBatch == 0) || (i + 1 == csvList.size()) ) {
                adDataUpdateCommitDao.adDatainsertByBatch(paramList); // batch方式
                paramList =  new ArrayList<AdDataAddParamBean>();
            }
        }

        //adDataUpdateCommitDao.adDatainsert(paramList);        // 既存方式

        stopWatch.stop();

        log.info("ADデータのアップロード時間：" + stopWatch);

    }
    /**
     * DBに登録するデータの形式をチェックする内部メソッド。
     * @param line データ1行分を表すString配列
     * @throws ApplicationException データ形式が不正な場合にスローされる
     */
    private void validate(String[] line, String lineNumber) throws ApplicationException {

        // null チェック
        if (line == null) {
            throw new ApplicationException("ERROR.M.ADDATA_MATCHING.0001");
        }

        // 行全体のカラム数
        if (!Integer.toString(line.length).
                equals(SystemProperties.getProperty("AdDataMatching.Cvs.Colum.Size"))) {

            String[] msg = { lineNumber };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0005", msg);
        }

        // グループ桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_GROUPNAME],
                SystemProperties.getProperty("AdDataMatching.Cvs.GroupName.Size"))) {

            String[] msg = { lineNumber, "グループ" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }


        // エリアコード桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_AREACD],
                SystemProperties.getProperty("AdDataMatching.Cvs.EreaCd.Size"))) {

            String[] msg = { lineNumber, "エリアコード" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }

        // エリア名桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_AREANAME],
                SystemProperties.getProperty("AdDataMatching.Cvs.EreaName.Size"))) {

            String[] msg = { lineNumber, "エリア名" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);

        }

        // 店舗コード・物件コード・部屋番号必須チェック
        if(StringUtils.isBlank(StringUtils.trimToEmpty(line[C_SHOPCD])) ||
                StringUtils.isBlank(StringUtils.trimToEmpty(line[C_BKCD])) ||
                StringUtils.isBlank(StringUtils.trimToEmpty(line[C_ROOMCD])) ) {
            String[] msg = { lineNumber,
                            "取込必須項目（店舗コード、物件No、部屋番号）のいずれか" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0007", msg);
        }

        // 店舗コード桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_SHOPCD],
                SystemProperties.getProperty("AdDataMatching.Cvs.ShopCd.Size"))) {

            String[] msg = { lineNumber, "店舗コード" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);

        }

        // 店舗名桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_BUMON],
                SystemProperties.getProperty("AdDataMatching.Cvs.Bumon.Size"))) {

            String[] msg = { lineNumber, "店舗名" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);

        }

        // 取引No桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_TORIHIKI_NO],
                SystemProperties.getProperty("AdDataMatching.Cvs.TorihikiNo.Size"))) {

            String[] msg = { lineNumber, "取引No" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);

        }

        // 物件No桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_BKCD],
                SystemProperties.getProperty("AdDataMatching.Cvs.Bkcd.Size"))) {

            String[] msg = { lineNumber, "物件No" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);

        }

        // 部屋番号桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_ROOMCD],
                SystemProperties.getProperty("AdDataMatching.Cvs.RoomCd.Size"))) {

            String[] msg = { lineNumber, "部屋番号" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);

        }

        // 部屋タイプ桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_ROOMTYPE],
                SystemProperties.getProperty("AdDataMatching.Cvs.RoomType.Size"))) {

             String[] msg = { lineNumber, "部屋タイプ" };
             throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);

        }

        // 取引管理種別桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_TORIHIKI_SHUBETSU],
                SystemProperties.getProperty("AdDataMatching.Cvs.TorihikiShubetsu.Size"))) {

             String[] msg = { lineNumber, "取引管理種別" };
             throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }

        // 取引管理種別名桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_TORIHIKI_NAME],
                SystemProperties.getProperty("AdDataMatching.Cvs.TorihikiName.Size"))) {

             String[] msg = { lineNumber, "取引管理種別名" };
             throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }

        // 家賃桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_CHINRYO],
                SystemProperties.getProperty("AdDataMatching.Cvs.Chinryo.Size"))) {

            String[] msg = { lineNumber, "家賃" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);

        }
        // 家賃数値チェック
        if(StringUtils.isNotEmpty(line[C_CHINRYO])) {
            if(!StringUtils.isNumeric(StringUtils.replace(line[C_CHINRYO], ",", "")) ) {
                String[] msg = { lineNumber, "家賃" };
                throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
            }
        }

        // 取引台帳作成日桁数チェック
        /*
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_TORIHIKI_SAKUSEI_DATE],
                SystemProperties.getProperty("AdDataMatching.Cvs.TorihikiSakuseiDate.Size"))) {

            String[] msg = { lineNumber, "取引台帳作成日" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }*/

        // 取引台帳作成日桁数チェック
        if(StringUtils.isNotEmpty(line[C_TORIHIKI_SAKUSEI_DATE])) {

            if(!ValidatorByteLengthCheck.byteLengthforCsv(line[C_TORIHIKI_SAKUSEI_DATE],
                    SystemProperties.getProperty("AdDataMatching.Cvs.TorihikiSakuseiDate.Size"))) {
                String[] msg = { lineNumber, "取引台帳作成日" };
                throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
            }
            if(!isDateCheck(line[C_TORIHIKI_SAKUSEI_DATE])) {
                String[] msg = { lineNumber, "取引台帳作成日" };
                System.out.println("2");
                throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
            }
        }

        // 手数料入金額税込桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_CM_INS_GAKU],
                SystemProperties.getProperty("AdDataMatching.Cvs.CmInsGaku.Size"))) {

            String[] msg = { lineNumber, "手数料入金額税込" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }

        // 手数料入金日桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_CM_INS_DT],
                SystemProperties.getProperty("AdDataMatching.Cvs.CmInsDt.Size"))) {

            String[] msg = { lineNumber, "手数料入金日" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }

        // 手数料入金日日付チェック
        if(StringUtils.isNotEmpty(line[C_CM_INS_DT])){
        	if(!isDateCheck(line[C_CM_INS_DT])) {
                String[] msg = { lineNumber, "手数料入金日" };
                throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
            }
        }

        // 広告料入金回数桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_AD_INS_CNT_],
                SystemProperties.getProperty("AdDataMatching.Cvs.AdInsCnt.Size"))) {

            String[] msg = { lineNumber, "広告料入金回数" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }

        // 広告料入金額税込桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_AD_INS_GAKU],
                SystemProperties.getProperty("AdDataMatching.Cvs.AdInsGaku.Size"))) {

            String[] msg = { lineNumber, "広告料入金額税込" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }

        // 広告料入金日桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_AD_INS_DT],
                SystemProperties.getProperty("AdDataMatching.Cvs.AdInsDt.Size"))) {

            String[] msg = { lineNumber, "広告料入金日" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }

        // 広告料入金日日付チェック
        if(StringUtils.isNotEmpty(line[C_AD_INS_DT])){
        	if(!isDateCheck(line[C_AD_INS_DT])) {
                String[] msg = { lineNumber, "広告料入金日" };
                throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
            }
        }

        // 借主手数料（追加）桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_KASHI_CM],
                SystemProperties.getProperty("AdDataMatching.Cvs.KashiCm.Size"))) {

            String[] msg = { lineNumber, "借主手数料（追加）" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }

        // 貸主手数料（追加）桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_KARI_CM],
                SystemProperties.getProperty("AdDataMatching.Cvs.KariCm.Size"))) {

            String[] msg = { lineNumber, "貸主手数料（追加）" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }

        // 借主･貸主手数料の見積額桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_CM_MITSU],
                SystemProperties.getProperty("AdDataMatching.Cvs.CmMitsu.Size"))) {

            String[] msg = { lineNumber, "借主･貸主手数料の見積額" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }

        // 借主･貸主手数料の見積AD額桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_CM_MITSU_AD],
                SystemProperties.getProperty("AdDataMatching.Cvs.CmMitsuAd.Size"))) {

            String[] msg = { lineNumber, "借主･貸主手数料の見積AD額" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }

        // 営業担当社員コード桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_TANTOU_CD],
                SystemProperties.getProperty("AdDataMatching.Cvs.TanouCd.Size"))) {

            String[] msg = { lineNumber, "営業担当社員コード" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }

        // 営業担当社員名桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_TANTOU_NAME],
                SystemProperties.getProperty("AdDataMatching.Cvs.TanouName.Size"))) {

            String[] msg = { lineNumber, "営業担当社員名" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }

        // 貸主コード桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_KASHI_CD],
                SystemProperties.getProperty("AdDataMatching.Cvs.KashiCd.Size"))) {

            String[] msg = { lineNumber, "貸主コード" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);

        }

        // データ種類桁数チェック
        if(!ValidatorByteLengthCheck.byteMaxLengthforCsv(line[C_DATA_TYPE],
                SystemProperties.getProperty("AdDataMatching.Cvs.DataType.Size"))) {

            String[] msg = { lineNumber, "データ種類" };
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0006", msg);
        }
    }

    /**
     * 正しい日付チェック
     * @param value
     * @return
     */
    public static boolean isDateCheck(String value) {

        String[] val = StringUtils.split(value, "/");

        if(val.length != 3) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(val[0]);
        sb.append(val[1]);
        sb.append(val[2]);

        return GenericValidator.isDate(sb.toString(), "yyyyMMdd", true);
    }
}
