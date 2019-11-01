/*
 * $Id: AblOutUpdateCommitServiceImpl.java 4726 2013-11-05 08:01:59Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.impl;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.dataoutput.dao.AblOutUpdateCommitDao;
import net.chintai.backend.sysadmin.dataoutput.dao.AblOutUpdateParamBean;
import net.chintai.backend.sysadmin.dataoutput.service.AblOutUpdateCommitService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.AblOutUpdateCommitInServiceBean;


/**
 * AblOutUpdateCommitService実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4726 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AblOutUpdateCommitServiceImpl implements AblOutUpdateCommitService {

    /** エイブル担当店/取扱店出力情報設定Dao */
    private AblOutUpdateCommitDao ablOutUpdateCommitDao;

    /**
     * ablOutUpdateCommitDaoを設定
     * @param ablOutUpdateCommitDao
     */
    public void setAblOutUpdateCommitDao(AblOutUpdateCommitDao ablOutUpdateCommitDao){
        this.ablOutUpdateCommitDao = ablOutUpdateCommitDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.AblOutUpdateCommitService#ablOutUpdateCommit(net.chintai.backend.sysadmin.dataoutput.service.bean.AblOutUpdateCommitInServiceBean)
     */
    public void ablOutUpdateCommit(AblOutUpdateCommitInServiceBean inServiceBean) throws ApplicationException {

        // 取得した他社データ連携種類分繰り返す
        for (int i = 0; i < inServiceBean.getDcoTypeArray().length; i++){
            // 入力用Beanの作成
            AblOutUpdateParamBean paramBean = new AblOutUpdateParamBean();
            paramBean.setDcoType(inServiceBean.getDcoTypeArray()[i]);
            paramBean.setBukkenOutKbn(inServiceBean.getBukkenOutKbnArray()[i]);
            paramBean.setUserId(inServiceBean.getUserId());
            paramBean.setPgName(inServiceBean.getPgName());
            paramBean.setUpdDt(inServiceBean.getUpdDtArray()[i]);

            // 更新処理Update
            if (ablOutUpdateCommitDao.ablOutUpdate(paramBean) == 0) {
                throw new ApplicationException("ERROR.M.DATAOUTPUT.0001");
            }

        }


    }

}
