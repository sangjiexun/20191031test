/*
 * $Id: UserPasswordChangePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.dao.UserPasswordChangePageDao;
import net.chintai.backend.sysadmin.user.dao.UserPasswordChangePageParamBean;
import net.chintai.backend.sysadmin.user.domain.UserDomain;
import net.chintai.backend.sysadmin.user.service.UserPasswordChangePageService;
import net.chintai.backend.sysadmin.user.service.bean.UserPasswordChangePageInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.UserPasswordChangePageOutServiceBean;

/**
 * UserPasswordChangePageServiceインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserPasswordChangePageServiceImpl implements
        UserPasswordChangePageService {

    /** プロフィールパスワード変更画面に遷移DAO */
    private UserPasswordChangePageDao userPasswordChangePageDao = null;

    /**
     * UserPasswordChangePageDaoを設定する
     * @param userPasswordChangePageDao
     */
    public void setUserPasswordChangePageDao(
            UserPasswordChangePageDao userPasswordChangePageDao) {
        this.userPasswordChangePageDao = userPasswordChangePageDao;
    }
    
    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.UserPasswordChangePageService#userPasswordChangePage(net.chintai.backend.sysadmin.user.service.bean.UserPasswordChangePageInServiceBean)
     */
    public UserPasswordChangePageOutServiceBean userPasswordChangePage(
            UserPasswordChangePageInServiceBean inServiceBean) throws ApplicationException {

        UserPasswordChangePageParamBean paramBean = new UserPasswordChangePageParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 日時情報を取得
        UserDomain user = userPasswordChangePageDao.userPasswordChangePage(paramBean);

        if(user == null) {
            throw new ApplicationException("ERROR.M.USER.0002");
        }
        UserPasswordChangePageOutServiceBean outServiceBean =
            new UserPasswordChangePageOutServiceBean();

        try {
            BeanUtils.copyProperties(outServiceBean, user);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return outServiceBean;
    }
}