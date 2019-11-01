package net.chintai.backend.sysadmin.master.service.impl;


import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.validator.ValidatorByteLengthCheck;
import net.chintai.backend.sysadmin.master.dao.SchoolMaintenanceDao;
import net.chintai.backend.sysadmin.master.dao.SchoolMaintenanceParamBean;
import net.chintai.backend.sysadmin.master.service.SchoolMaintenanceService;
import net.chintai.backend.sysadmin.master.service.bean.SchoolMaintenanceInServiceBean;


/**
 * SchoolMaintenanceServiceの実装クラス
 * @author e-ishii
 * @version $Revision: 4471 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class SchoolMaintenanceServiceImpl implements SchoolMaintenanceService{

    // CSVの項目名とカラム位置の対応
    private static final int C_SCHOOL_ID = 0;
    private static final int C_SCHOOL_NAME = 1;

    /** 大学マスタメンテナンスデータ取得DAO */
    private SchoolMaintenanceDao schoolMaintenanceDao;

    /**
     * 大学マスタメンテナンスデータ取得DAOを設定します。
     * @param schoolMaintenanceDao 大学マスタメンテナンスデータ取得DAO
     */
    public void setSchoolMaintenanceDao(SchoolMaintenanceDao schoolMaintenanceDao) {
        this.schoolMaintenanceDao = schoolMaintenanceDao;
    }



    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.SchoolMaintenanceService#schoolCsvUpload(net.chintai.backend.sysadmin.master.service.bean.SchoolMaintenanceInServiceBean)
     */
    public void schoolCsvUpload(SchoolMaintenanceInServiceBean inSerivceBean)
            throws ApplicationException {

        // 現在日付の取得
        java.sql.Timestamp timestamp = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());

        List<String[]> csvList  = inSerivceBean.getUploadList();

        Map<String, SchoolMaintenanceParamBean> schoolMap = new LinkedHashMap<String, SchoolMaintenanceParamBean>();

        //CSVファイルの項目チェックと、重複チェック
        for(int i=0; i<csvList.size(); i++) {

            String[] line = csvList.get(i);

            String lineNumber = String.valueOf(i+1);

            validate(line,lineNumber);

            if(schoolMap.containsKey(line[C_SCHOOL_ID])) {
                String[] msg = { lineNumber, "大学ID", line[C_SCHOOL_ID]};
                throw new ApplicationException("WARN.M.MASTER.0050", msg);
            } else {
                SchoolMaintenanceParamBean paramBean = new SchoolMaintenanceParamBean();

                paramBean.setSchoolId(line[C_SCHOOL_ID]);
                paramBean.setSchoolName(line[C_SCHOOL_NAME]);
                paramBean.setOperUserId(inSerivceBean.getOperUserId());
                paramBean.setPgName(inSerivceBean.getPgName());
                paramBean.setInsDt(timestamp);
                paramBean.setUpdDt(timestamp);

                schoolMap.put(line[C_SCHOOL_ID], paramBean);
            }
        }

        try {

            //全件削除
            schoolMaintenanceDao.deleteAllSchoolLists();

            //インサート
            for(SchoolMaintenanceParamBean bean : schoolMap.values()) {
                schoolMaintenanceDao.insertSchoolMaintenanceCsvForUpload(bean);
            }

        } catch(DataAccessException e) {
            throw e;
        }
    }




    /**
     * DBに登録するデータの形式をチェックする内部メソッド。
     * @param line データ1行分を表すString配列
     * @throws ApplicationException データ形式が不正な場合にスローされる
     */
    private void validate(String[] line, String lineNumber) throws ApplicationException {

        // null チェック
        if (line == null) {
            throw new ApplicationException("ERROR.M.MASTER.0019");
        }

        // 行全体のカラム数
        if (line.length != 2) {
            String[] msg = {lineNumber};
            throw new ApplicationException("WARN.M.MASTER.0047", msg);
        }

        //Nullチェック
        if(StringUtils.isEmpty(line[C_SCHOOL_ID]) || StringUtils.isEmpty(line[C_SCHOOL_NAME])) {
            String[] msg = {lineNumber ,"取込必須項目（大学ID、大学名）のいずれか"};
            throw new ApplicationException("WARN.M.MASTER.0049", msg);
        }

        //大学IDのサイズチェック
        if(line[C_SCHOOL_ID].length() >
                Integer.parseInt(SystemProperties.getProperty("School.Cvs.SchoolId.Size"))
            || !StringUtils.isNumeric(line[C_SCHOOL_ID])) {
            String[] msg = {lineNumber ,"大学ID" };
            throw new ApplicationException("WARN.M.MASTER.0048", msg);
        }

        //大学名のサイズチェック
        if(line[C_SCHOOL_NAME].length() > 100) {
            String[] msg = {lineNumber ,"大学名"};
            throw new ApplicationException("WARN.M.MASTER.0048", msg);
        }

    }

}
