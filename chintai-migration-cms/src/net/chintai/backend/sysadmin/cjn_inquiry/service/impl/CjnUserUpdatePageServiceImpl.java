/*
 * $Id: CjnUserUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserInfoParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserUpdatePageDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnUserInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserUpdatePageService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserUpdatePageOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * CjnUserUpdatePageServiceの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserUpdatePageServiceImpl implements CjnUserUpdatePageService {

    /** 問い合せユーザ情報を取得するDAO */
    private CjnUserUpdatePageDao cjnUserUpdatePageDao;

    /**
     * 問い合せユーザ情報を取得するDAOを設定。
     * @param cjnUserUpdatePageDao
     */
    public void setCjnUserUpdatePageDao(CjnUserUpdatePageDao cjnUserUpdatePageDao) {
        this.cjnUserUpdatePageDao = cjnUserUpdatePageDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserUpdatePageService#selectUpdateCjnUser(java.lang.String)
     */
    public CjnUserUpdatePageOutServiceBean selectUpdateCjnUser(
            CjnUserUpdatePageInServiceBean inServiceBean) {

        // paramBeanにCopy
        CjnUserInfoParamBean paramBean = new CjnUserInfoParamBean();
        paramBean.setCjnAccountSeq(inServiceBean.getCjnAccountSeq());

        // DAOからデータ取得
        String cjnAccountSeq = paramBean.getCjnAccountSeq();
        CjnUserInfo infoDomain = cjnUserUpdatePageDao.selectUpdateCjnUser(cjnAccountSeq);

        CjnUserUpdatePageOutServiceBean outServiceBean = new CjnUserUpdatePageOutServiceBean();
        try {
            BeanUtils.copyProperties(outServiceBean, infoDomain);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return outServiceBean;
    }
}
