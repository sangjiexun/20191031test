/*
 * $Id: MobileMaintenanceServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)楊恩美     新規作成
 * 2007/12/09  BGT)児島       CSVフォーマットチェック処理を追加
 */
package net.chintai.backend.sysadmin.master.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.master.dao.MobileMaintenanceDao;
import net.chintai.backend.sysadmin.master.dao.MobileMaintenanceParamBean;
import net.chintai.backend.sysadmin.master.domain.MobileMaintenanceListInfo;
import net.chintai.backend.sysadmin.master.service.MobileMaintenanceService;
import net.chintai.backend.sysadmin.master.service.bean.MobileMaintenanceInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.MobileMaintenanceOutServiceBean;

/**
 * MobileMaintenanceServiceの実装クラス
 * 
 * @author Yang-EunMi
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MobileMaintenanceServiceImpl implements MobileMaintenanceService {

    // CSVの項目名とカラム位置の対応
    private static final int C_DL_SEQ = 0;
    private static final int C_ITEM_CD = 1;
    private static final int C_CARRIER_TYPE = 2;
    private static final int C_USER_AGENT = 3;
    private static final int C_FILE_NAME = 4;
    private static final int C_DISCRIPTION = 5;
    private static final int C_UPD_DT = 6;

    /** 携帯ゲーム対応機種メンテナンスデータ取得DAO */
    private MobileMaintenanceDao mobileMaintenanceDao;

    /**
     * 携帯ゲーム対応機種メンテナンスデータ取得DAOを設定
     * @param mobileMaintenanceDao
     */
    public void setMobileMaintenanceDao(MobileMaintenanceDao mobileMaintenanceDao) {
        this.mobileMaintenanceDao = mobileMaintenanceDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.MobileMaintenanceService#MobileCsvDownLoad()
     */
    public List<MobileMaintenanceOutServiceBean> mobileCsvDownLoad() throws ApplicationException {

        // データ取得
        List<MobileMaintenanceListInfo> listInfo = mobileMaintenanceDao.selectMobileMaintenanceCsvForDownload();

        List<MobileMaintenanceOutServiceBean> outList = new ArrayList<MobileMaintenanceOutServiceBean>();

        if (listInfo == null) {
            throw new ApplicationException("WARN.M.MASTER.0017");
        }
        
        for (int i = 0; i < listInfo.size(); i++) {

            MobileMaintenanceOutServiceBean outBean = new MobileMaintenanceOutServiceBean();
            MobileMaintenanceListInfo mobileInfo = listInfo.get(i);

            try {
                BeanUtils.copyProperties(outBean, mobileInfo);
                outList.add(outBean);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

        return outList;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.MobileMaintenanceService#MobileCsvUpload(net.chintai.backend.sysadmin.master.serivce.bean.MobileMaintenanceInServiceBean)
     */
    public void mobileCsvUpload(MobileMaintenanceInServiceBean inSerivceBean) throws ApplicationException {

        // 全件削除
        mobileMaintenanceDao.deleteAllMobileLists();
        
        // 1件ずつ挿入
        List<String[]> arrlist = inSerivceBean.getUploadList();
        for (int i = 0; i < arrlist.size(); i++) {
            String[] arrParam = arrlist.get(i);
            validate(arrParam);

            MobileMaintenanceParamBean paramBean = new MobileMaintenanceParamBean();
            paramBean.setDlSeq(arrParam[C_DL_SEQ]);
            paramBean.setItemCd(arrParam[C_ITEM_CD]);
            paramBean.setCarrierType(arrParam[C_CARRIER_TYPE]);
            paramBean.setUserAgent(arrParam[C_USER_AGENT]);
            paramBean.setFileName(arrParam[C_FILE_NAME]);
            paramBean.setDiscription(arrParam[C_DISCRIPTION]);
            paramBean.setUpdDt(arrParam[C_UPD_DT]);

            try {
                mobileMaintenanceDao.insertMobileMaintenanceCsvForUpload(paramBean);
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

        final String ERROR_ID = "ERROR.M.MASTER.0008";

        // null チェック
        if (line == null) {
            throw new ApplicationException(ERROR_ID);
        }

        // 行全体のカラム数
        if (line.length != 7) {
            throw new ApplicationException(ERROR_ID);
        }

        if (StringUtils.isEmpty(line[C_DL_SEQ]) || line[C_DL_SEQ].length() > 6
                || (!StringUtils.isNumeric(line[C_DL_SEQ]))) {
            throw new ApplicationException(ERROR_ID);
        }

        if (StringUtils.isEmpty(line[C_ITEM_CD]) || line[C_ITEM_CD].length() > 2) {
            throw new ApplicationException(ERROR_ID);
        }

        if (StringUtils.isEmpty(line[C_CARRIER_TYPE]) || line[C_CARRIER_TYPE].length() != 1) {
            throw new ApplicationException(ERROR_ID);
        }

        if (StringUtils.isEmpty(line[C_USER_AGENT]) || line[C_USER_AGENT].length() > 20) {
            throw new ApplicationException(ERROR_ID);
        }

        if (StringUtils.isEmpty(line[C_FILE_NAME]) || line[C_FILE_NAME].length() > 20) {
            throw new ApplicationException(ERROR_ID);
        }

        if (line[C_DISCRIPTION] != null && line[C_DISCRIPTION].length() > 20) {
            throw new ApplicationException(ERROR_ID);
        }

        if (StringUtils.isEmpty(line[C_UPD_DT])) {
            throw new ApplicationException(ERROR_ID);
        }
    }

}
