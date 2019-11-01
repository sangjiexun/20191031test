/*
 * $Id: ShikutyosonAddServiceImpl.java 4294 2009-07-07 12:42:15Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/14  BGT)楊恩美     新規作成
 * 2007/12/09  BGT)児島       CSVフォーマットチェック処理を追加
 */
package net.chintai.backend.sysadmin.master.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.master.dao.ShikutyosonAddDao;
import net.chintai.backend.sysadmin.master.dao.ShikutyosonAddParamBean;
import net.chintai.backend.sysadmin.master.service.ShikutyosonAddService;
import net.chintai.backend.sysadmin.master.service.bean.ShikutyosonAddInServiceBean;

/**
 * ShikutyosonAddServiceの実装クラス
 *
 * @author Yang-EunMi
 * @author KOJIMA Takanori
 * @version $Revision: 4294 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonAddServiceImpl implements ShikutyosonAddService {

    // CSVの項目名とカラム位置の対応
    private static final int C_CITYCD = 0;
    private static final int C_OLD_ZIPCD = 1;
    private static final int C_ZIPCD = 2;
    private static final int C_PREFNAME = 6;
    private static final int C_CITYNAME = 7;
    private static final int C_ADDRESS = 8;
    private static final int C_REASON = 14;

    // 変更理由:削除
    private static final String C_REASON_IS_DELETE = "6";

    /** 市区町村登録DAO取得 */
    private ShikutyosonAddDao shikutyosonAddDao;

    /**
     * 市区町村登録DAOを設定
     * @param shikutyosonAddDao
     */
    public void setShikutyosonAddDao(ShikutyosonAddDao shikutyosonAddDao) {
        this.shikutyosonAddDao = shikutyosonAddDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.ShikutyosonAddService#insertShikutyosonAdd(net.chintai.backend.sysadmin.master.service.bean.ShikutyosonAddInServiceBean)
     */
    public void insertShikutyosonAdd(ShikutyosonAddInServiceBean inServiceBean) throws ApplicationException {
/*
        List<String[]> arrList = inServiceBean.getUploadList();

        for (int i = 0; i < arrList.size(); i++) {
            String[] arrParam = arrList.get(i);
            validate(arrParam);

            ShikutyosonAddParamBean paramBean = new ShikutyosonAddParamBean();
            paramBean.setCityCd(arrParam[C_CITYCD]);
            paramBean.setCityName(arrParam[C_CITYNAME]);
            paramBean.setOldZipCd(arrParam[C_OLD_ZIPCD]);
            paramBean.setZipCd(arrParam[C_ZIPCD]);
            paramBean.setAddress(arrParam[C_ADDRESS]);
            paramBean.setInsId(inServiceBean.getOperUserId());
            paramBean.setInsPg(inServiceBean.getClassName());
            paramBean.setUpdId(inServiceBean.getOperUserId());
            paramBean.setUpdPg(inServiceBean.getClassName());

            try {
                // MST_CITYテーブルのデータチェック
                int cityCnt = shikutyosonAddDao.selectMstCity(paramBean);
                if (cityCnt == 0) {
                    shikutyosonAddDao.insertMstCity(paramBean);
                }

                // MST_ZIPCODEテーブルデータチェック
                int zipCnt = shikutyosonAddDao.selectMstZipCode(paramBean);

                // 一致すればupdate、一致しなければinsertする
                if (zipCnt == 0) {
                    shikutyosonAddDao.insertMstZipCode(paramBean);
                } else {
                    shikutyosonAddDao.updateMstZipCode(paramBean);
                }
            } catch (DataAccessException dae) {
                throw dae;
            }
        }
*/
    	// 2008.12.01 同一ZIPで町域が違うデータの場合、１つのレコードでUpdateされてしまう不具合を修正
        List<String[]> arrList = inServiceBean.getUploadList();

        // 1度目のループで対象データを全て削除する
        for (int i = 0; i < arrList.size(); i++) {
            String[] arrParam = arrList.get(i);

            ShikutyosonAddParamBean paramBean = new ShikutyosonAddParamBean();
            paramBean.setCityCd(arrParam[C_CITYCD]);
            paramBean.setZipCd(arrParam[C_ZIPCD]);
            try {
                shikutyosonAddDao.deleteMstZipCode(paramBean);
            } catch (DataAccessException dae) {
                throw dae;
            }
        }
        // 2度目のループで対象データを全て登録する
        for (int i = 0; i < arrList.size(); i++) {
            String[] arrParam = arrList.get(i);
            validate(arrParam);

            ShikutyosonAddParamBean paramBean = new ShikutyosonAddParamBean();
            paramBean.setCityCd(arrParam[C_CITYCD]);
            paramBean.setCityName(arrParam[C_CITYNAME]);
            paramBean.setOldZipCd(arrParam[C_OLD_ZIPCD]);
            paramBean.setZipCd(arrParam[C_ZIPCD]);
            paramBean.setAddress(arrParam[C_ADDRESS]);
            paramBean.setInsId(inServiceBean.getOperUserId());
            paramBean.setInsPg(inServiceBean.getClassName());
            paramBean.setUpdId(inServiceBean.getOperUserId());
            paramBean.setUpdPg(inServiceBean.getClassName());

            try {
                // MST_CITYテーブルのデータチェック
                int cityCnt = shikutyosonAddDao.selectMstCity(paramBean);
                if (cityCnt == 0) {
                    shikutyosonAddDao.insertMstCity(paramBean);
                }
                // 2009.06.04 追加開始 市区町村名が変更された場合、反映されない不具合修正-Lee Hosup
                else {
                    shikutyosonAddDao.updateMstCity(paramBean);
                }
                // 2009.06.04 追加開始 市区町村名が変更された場合、反映されない不具合修正-Lee Hosup

                shikutyosonAddDao.insertMstZipCode(paramBean);
            } catch (DataAccessException dae) {
                throw dae;
            }
        }

    }

    /**
     * DBに登録するデータの形式をチェックする内部メソッド。
     * @param line データ1行分を表すString配列
     * @throws ApplicationException データ形式が不正な場合にスローされる
     */
    private void validate(String[] line) throws ApplicationException {

        final String ERROR_ID = "ERROR.M.MASTER.0005";

        // null チェック
        if (line == null) {
            throw new ApplicationException(ERROR_ID);
        }

        // 行全体のカラム数
        if (line.length != 15) {
            throw new ApplicationException(ERROR_ID);
        }

        if (StringUtils.isEmpty(line[C_CITYCD]) || line[C_CITYCD].length() != 5) {
            throw new ApplicationException(ERROR_ID);
        }

        if (!StringUtils.isNumeric(line[C_CITYCD])) {
            throw new ApplicationException(ERROR_ID);
        }

        if (StringUtils.isEmpty(line[C_OLD_ZIPCD]) || line[C_OLD_ZIPCD].length() > 6) {
            throw new ApplicationException(ERROR_ID);
        }

        if (!StringUtils.isNumeric(StringUtils.trim(line[C_OLD_ZIPCD]))) {
            throw new ApplicationException(ERROR_ID);
        }

        if (StringUtils.isEmpty(line[C_ZIPCD]) || line[C_ZIPCD].length() != 7) {
            throw new ApplicationException(ERROR_ID);
        }

        if (!StringUtils.isNumeric(line[C_ZIPCD])) {
            throw new ApplicationException(ERROR_ID);
        }

        if (StringUtils.isEmpty(line[C_PREFNAME])) {
            throw new ApplicationException(ERROR_ID);
        }

        if (StringUtils.isEmpty(line[C_CITYNAME])) {
            throw new ApplicationException(ERROR_ID);
        }

        if (line[C_CITYNAME].length() > 24) {
        	throw new ApplicationException(ERROR_ID);
        }

        if (line[C_ADDRESS].length() > 100) {
        	throw new ApplicationException(ERROR_ID);
        }

        // 変更理由 = 削除のデータは受け付けない
        if (StringUtils.isEmpty(line[C_REASON]) || StringUtils.equals(line[C_REASON], C_REASON_IS_DELETE)) {
            throw new ApplicationException(ERROR_ID);
        }
    }

}
