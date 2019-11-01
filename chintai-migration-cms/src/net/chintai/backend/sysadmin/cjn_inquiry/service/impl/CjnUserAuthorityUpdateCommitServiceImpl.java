/*
 * $Id: CjnUserAuthorityUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAuthorityUpdateCommitDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAuthorityUpdateParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAuthorityUpdateCommitService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAuthorityUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;

/**
 * CjnUserAuthorityUpdateCommitServiceの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAuthorityUpdateCommitServiceImpl implements CjnUserAuthorityUpdateCommitService {

    /** 閲覧可能問い合せ権限更新情報DAO宣言 */
    private CjnUserAuthorityUpdateCommitDao commitDao;

    /**
     * 閲覧可能問い合せ権限更新情報DAOを設定
     * @param commitDao
     */
    public void setCjnUserAuthorityUpdateCommitDao(CjnUserAuthorityUpdateCommitDao commitDao) {
        this.commitDao = commitDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAuthorityUpdateCommitService#updateUserAuthority(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAuthorityUpdateCommitInServiceBean)
     */
    public void updateUserAuthority(CjnUserAuthorityUpdateCommitInServiceBean inServiceBean)
            throws ApplicationException {

        // ParamBeanにセット
        CjnUserAuthorityUpdateParamBean paramBean = new CjnUserAuthorityUpdateParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        
        String lastDt = commitDao.selectUserAuthorityLastUpdateDt(paramBean);
        String updDt = inServiceBean.getUpdDt();        

        if(updDt.equals(StringUtils.defaultString(lastDt))){
            // 全データ削除
            commitDao.deleteUserAuthority(paramBean);

            // 新しい権限情報Insert
            Integer[] count = inServiceBean.getCjnInqKindSeq();
            for (int i = 0; i < count.length; i++) {
                paramBean.setCjnInqKindSeq(count[i]);
                commitDao.insertUserAuthority(paramBean);
            }
        }else {
            throw new ApplicationException("ERROR.M.CJN_INQUIRY.0005");
        }

    }
}
