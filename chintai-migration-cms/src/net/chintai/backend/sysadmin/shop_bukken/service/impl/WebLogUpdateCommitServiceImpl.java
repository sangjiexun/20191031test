/*
 * $Id: WebLogUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.dao.WebLogUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.WebLogUpdateCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.service.WebLogUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.WebLogUpdateCommitInServiceBean;

/**
 * WebLogUpdateCommitService の実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class WebLogUpdateCommitServiceImpl implements WebLogUpdateCommitService {

    /** Webログ利用可否完了DAO */
    WebLogUpdateCommitDao webLogUpdateCommitDao = null;

    /**
     * webLogUpdateCommitDaoを設定する
     * @param webLogUpdateCommitDao
     */
    public void setWebLogUpdateCommitDao(WebLogUpdateCommitDao webLogUpdateCommitDao) {
        this.webLogUpdateCommitDao = webLogUpdateCommitDao;
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.WebLogUpdateCommitService#webLogUpdateCommit(net.chintai.backend.sysadmin.shop_bukken.service.bean.WebLogUpdateCommitInServiceBean)
     */
    public void webLogUpdateCommit(WebLogUpdateCommitInServiceBean inServiceBean)
            throws ApplicationException {

        WebLogUpdateCommitParamBean paramBean = new WebLogUpdateCommitParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // Webログ利用可否完了DAOを行う
        int affected = webLogUpdateCommitDao.webLogUpdateCommit(paramBean);

        if (affected == 0){
            throw new ApplicationException("ERROR.M.USER.0002"); // 別のエラーメッセージが必要
        }
    }
}