package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.common.util.ValidatorUtils;
import net.chintai.backend.sysadmin.crnwl.aop.IdHolder;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.shop_bukken.ShopBukkenUtils;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopBukkenUploadService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopBukkenUploadInServiceBean;
import net.chintai.batch.common.PpcUseKbn;
import net.chintai.batch.common.aop.PgHolder;
import net.chintai.batch.common.domain.ShopReserve;
import net.chintai.batch.common.domain.ShopRireki;
import net.chintai.batch.support.ppc.PpcException;
import net.chintai.batch.support.ppc.PpcSupportService;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

/**
 * ShopBukkenUploadService実装クラス
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBukkenUploadServiceImpl implements
        ShopBukkenUploadService {

    // CSVの項目名とカラム位置の対応
	private static final int RESERVE_NO = 0;
	private static final int RESERVE_KBN = 1;
	private static final int SHOPCD = 2;
	//private static final int CLIENTSYSTEM_TYPE = 3;
	//private static final int COMPANY = 4;
	//private static final int BUMON = 5;
	//private static final int PREFNAME = 6;
	//private static final int CITYNAME = 7;
	//private static final int ADDRESS_1 = 8;
	private static final int DEL_FLG = 9;
	private static final int APPLY_DT = 10;
	private static final int BUSINESS_HOURS = 11;
	private static final int HOLIDAY = 12;
	private static final int CERTIFY_FLG = 13;
	private static final int CT_STATUS = 14;
	private static final int ABL_STATUS = 15;
	private static final int SHOP_STATUS = 16;
	private static final int RENDO_CD = 17;

    /** 行番号用カウント */
    private static final int INCREMENTCOUNT = 1;

    /** カラム数 */
    private static final int LINELEN = 18;

    /** 日付フォーマット */
    private static final String DATEFORMAT = "yyyyMMddHHmmss";

    /** メールコード */
    private static final String MAILCD = "SHOP_APPROVAL_API";

    @Autowired
    private ShopService shopService;

    @Autowired
    private PpcSupportService ppcSupportService;

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_bukken.service.
     * ShopBukkenUploadService
     * #ShopBukkenUploadCommit
     * (net.chintai.backend.sysadmin.shop_bukken
     * .service.bean.ShopBukkenUploadInServiceBean)
     */

    public void shopBukkenUploadCommit(
    		ShopBukkenUploadInServiceBean inServiceBean)
            throws ApplicationException, PpcException {

        List<String[]> csvList = inServiceBean.getUploadList();

        // DB更新用レコードの構築
        //登録用 <店舗コード+適用日時, VO>
        Map<String, ShopReserve> shopReserveInsertMap = new LinkedHashMap<String, ShopReserve>();
        //削除用 <予約管理番号, 店舗コード>
        Map<Integer, ShopReserve> shopReserveDeleteMap = new LinkedHashMap<Integer, ShopReserve>();

        //String nowTimestamp = DateUtil.getToday("yyyyMMddHH") + "0000";
        String nowTimestamp = new DateTime().toString("yyyyMMddHH") + "0000";
        // CSVファイル行数分繰返す(カラム名の行1行目は除く)
        for (int i = 0; i < csvList.size(); i++) {
            String[] line = csvList.get(i);

            String lineNumber = String.valueOf(i + INCREMENTCOUNT);

            // フォーマットチェック
            validate(line, lineNumber);

            if(!"1".equals(line[DEL_FLG])){
	            // 重複チェック（「店舗コード」「適用日時」）
	            if (shopReserveInsertMap.containsKey(line[SHOPCD] + line[APPLY_DT])) {
	                String[] msg = { lineNumber, "店舗コード,適用日時"};
	                throw new ApplicationException("WARN.M.DEMAND.0007", msg);
	            } else {
	            	shopReserveInsertMap.put(line[SHOPCD] + line[APPLY_DT], arrayToShopBukkenUploadBean(line, inServiceBean, lineNumber));
	            }

	            //「適用日時」が当日より過去の場合エラー
	            if(line[APPLY_DT].compareTo(nowTimestamp) < 0){
	            	String[] msg = { lineNumber, "適用日時"};
	                throw new ApplicationException("WARN.M.DEMAND.0007", msg);
	            }

	            // 存在チェック(店舗管理)
	            if(shopService.selectShopKanriByPrimaryKey(line[SHOPCD]) == null){
	            	String[] msg = { lineNumber, "店舗コード"};
	                throw new ApplicationException("WARN.M.DEMAND.0007", msg);
	            }

	            // 存在チェック(店舗予約)
	            List<ShopReserve> ShopReserveList = shopService.selectShopReserveByShopcdAndApplyDt(line[SHOPCD], line[APPLY_DT]);
	            if(!CollectionUtils.isEmpty(ShopReserveList)){
	            	String[] msg = { lineNumber, "店舗コード,適用日時"};
	                throw new ApplicationException("WARN.M.DEMAND.0007", msg);
	            }

            }else{
            	// 存在チェック(店舗予約)
            	List<ShopReserve> ShopReserveList = shopService.selectShopReserveByShopcd(Integer.valueOf(line[RESERVE_NO]), line[SHOPCD]);
            	if(CollectionUtils.isEmpty(ShopReserveList)){
	            	String[] msg = { lineNumber, "予約管理番号"};
	                throw new ApplicationException("WARN.M.DEMAND.0007", msg);
	            }else{
	            	shopReserveDeleteMap.put(Integer.valueOf(line[RESERVE_NO]), ShopReserveList.get(0));
	            }
            }
        }

        if (shopReserveInsertMap.isEmpty() && shopReserveDeleteMap.isEmpty()){
            String[] msg = { "更新対象データ" };
            throw new ApplicationException("WARN.M.DEMAND.0155", msg);
        }

        for (ShopReserve shopReserve: shopReserveInsertMap.values()){

        	try {
        		PgHolder.setPg(inServiceBean.getPgName());
    			IdHolder.setId(inServiceBean.getOperUserId());

        		final ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(shopReserve.getShopcd());

        		if("0".equals(shopRireki.getCertifyFlg()) && "1".equals(shopReserve.getCertifyFlg())){
        			shopReserve.setMailcd(MAILCD);
        		}

        		if("1".equals(shopReserve.getShopStatus())){
        			//フリーコール登録
        			if ("1".equals(shopReserve.getCtStatus())) {
	        			if(StringUtils.isNotEmpty(shopRireki.getTelFreeCt())){
	        				shopReserve.setTelFreeCt(this.ppcSupportService.getPpcNum(shopRireki, PpcUseKbn.CHINTAI));
	        			}
        			}
        			if ("1".equals(shopReserve.getAblStatus())) {
	        			if(StringUtils.isNotEmpty(shopRireki.getTelFreeAbl())){
	        				shopReserve.setTelFreeAbl(this.ppcSupportService.getPpcNum(shopRireki, PpcUseKbn.ABLE));
	        			}
        			}
        			if(StringUtils.isNotEmpty(shopRireki.getTelMagazine())){
        				shopReserve.setTelMagazine(this.ppcSupportService.getPpcNum(shopRireki, PpcUseKbn.MAGAZINE));
        			}
        		}

        		//店舗予約登録
        		shopService.insertShopReserve(shopReserve);

        		PgHolder.resetPg();
    			IdHolder.resetId();
        	} catch (DataAccessException e) {
                throw new ApplicationException("ERROR.M.DEMAND.0002");
            } catch (PpcException e) {
            	throw new PpcException("INFO.M.SHOP_BUKKEN.0031");
			}
        }

        for (Integer reserveNo: shopReserveDeleteMap.keySet()){
        	//店舗予約削除
    		shopService.deleteShopReserve(reserveNo);
        }
    }

    /**
     * DBに登録するデータの形式をチェックする内部メソッド。
     * @param line データ1行分を表すString配列
     * @param lineNumber 行番号
     * @throws ApplicationException データ形式が不正な場合にスローされる
     */
    private void validate(String[] line, String lineNumber) throws ApplicationException {

    	// 行全体のカラム数
    	if (line.length != LINELEN) {
            String[] msg = { lineNumber };
            throw new ApplicationException("WARN.M.DEMAND.0013", msg);
        }

    	if("1".equals(line[DEL_FLG])){//削除時 必須
	    	//予約管理番号
	    	if (StringUtils.isEmpty(line[RESERVE_NO]) || line[RESERVE_NO].length() > 9 || ValidatorUtils.isNotHalfSizeNumber(line[RESERVE_NO])) {
	            String[] msg = { lineNumber, "予約管理番号"};
	            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
	        }

	    	//予約元区分
	    	if (StringUtils.isEmpty(line[RESERVE_KBN]) || line[RESERVE_KBN].length() != 1 || ValidatorUtils.isNotHalfSizeNumber(line[RESERVE_KBN])) {
	            String[] msg = { lineNumber, "予約元区分"};
	            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
	        }
    	}

        // 店舗コード 必須
        if (StringUtils.isEmpty(line[SHOPCD]) || line[SHOPCD].length() != 9) {
            String[] msg = { lineNumber, "店舗コード"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // 適用日時 必須
        if (StringUtils.isEmpty(line[APPLY_DT]) || !ShopBukkenUtils.isDataFormat(line[APPLY_DT], DATEFORMAT)) {
            String[] msg = { lineNumber, "適用日時"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // 営業時間
        if (line[BUSINESS_HOURS].length() > 50) {
            String[] msg = { lineNumber, "営業時間"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // 定休日
        if (line[HOLIDAY].length() > 50) {
            String[] msg = { lineNumber, "定休日"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // ユーザ承認フラグ
        if (StringUtils.isEmpty(line[CERTIFY_FLG]) || (!"0".equals(line[CERTIFY_FLG]) && !"1".equals(line[CERTIFY_FLG]))) {
            String[] msg = { lineNumber, "ユーザ承認フラグ"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // CHINTAIステータス
        if (StringUtils.isEmpty(line[CT_STATUS]) || (!"0".equals(line[CT_STATUS]) && !"1".equals(line[CT_STATUS]))) {
            String[] msg = { lineNumber, "CHINTAIステータス"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // エイブルステータス
        if (StringUtils.isEmpty(line[ABL_STATUS]) || (!"0".equals(line[ABL_STATUS]) && !"1".equals(line[ABL_STATUS]))) {
            String[] msg = { lineNumber, "エイブルステータス"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // 店舗ステータス
        if (StringUtils.isEmpty(line[SHOP_STATUS]) || (!"0".equals(line[SHOP_STATUS]) && !"1".equals(line[SHOP_STATUS]))) {
            String[] msg = { lineNumber, "店舗ステータス"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // 連動元コード
        if (StringUtils.isEmpty(line[RENDO_CD])) {
            String[] msg = { lineNumber, "連動元コード"};
            throw new ApplicationException("WARN.M.DEMAND.0007", msg);
        }

        // 削除フラグ
        if (!StringUtils.isEmpty(line[DEL_FLG]) && !line[DEL_FLG].equals("1")) {
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
     * @return 生成されたShopBukkenUploadList
     */

    private ShopReserve arrayToShopBukkenUploadBean(String[] line,
            ShopBukkenUploadInServiceBean inServiceBean, String lineNumber) {
    	ShopReserve shopReserve = new ShopReserve();
    	Date timeStamp = new Timestamp(System.currentTimeMillis());

    	if(StringUtils.isNotEmpty(line[RESERVE_NO])){
    		shopReserve.setReserveNo(Integer.valueOf(line[RESERVE_NO]));
    	}
        shopReserve.setReserveKbn("2");//2:CMS
        shopReserve.setReserveStartDt(new DateTime().toString("yyyyMMddHHmmss"));
        shopReserve.setApplyDt(line[APPLY_DT]);
        shopReserve.setSfaKanriNo(null);
        shopReserve.setShopcd(line[SHOPCD]);
        shopReserve.setBusinessHours(line[BUSINESS_HOURS]);
        shopReserve.setHoliday(line[HOLIDAY]);
        shopReserve.setCtStatus(line[CT_STATUS]);
        shopReserve.setAblStatus(line[ABL_STATUS]);
        shopReserve.setCertifyFlg(line[CERTIFY_FLG]);
        shopReserve.setShopStatus(line[SHOP_STATUS]);
        shopReserve.setPkShopRireki(null);
        shopReserve.setRendoCd(line[RENDO_CD]);

        if("0".equals(line[SHOP_STATUS]) || "1".equals(line[CERTIFY_FLG])){
        	shopReserve.setMailSendStatus("0");//0：未送信
        }else{
        	shopReserve.setMailSendStatus("2");//2：送信不要
        }
        shopReserve.setResultKbn("0");//0：正常終了
        shopReserve.setInsDt(timeStamp);
        shopReserve.setInsPg(inServiceBean.getPgName());
        shopReserve.setInsId(inServiceBean.getOperUserId());
        shopReserve.setUpdDt(timeStamp);
        shopReserve.setUpdPg(inServiceBean.getPgName());
        shopReserve.setUpdId(inServiceBean.getOperUserId());

        return shopReserve;
    }
}
