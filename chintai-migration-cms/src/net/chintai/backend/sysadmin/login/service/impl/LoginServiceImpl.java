/*
 * LoginServiceImpl.java
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/15  BGT)児島   新規作成
 * 2007/07/31  BGT)児島   user オブジェクトの null チェックを追加
 * 2007/08/08  BGT)児島   グループIDをセットする処理を削除
 */
package net.chintai.backend.sysadmin.login.service.impl;

import net.chintai.backend.sysadmin.common.session.SessionBean;
import net.chintai.backend.sysadmin.common.util.CryptUtil;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.login.dao.LoginDao;
import net.chintai.backend.sysadmin.login.domain.User;
import net.chintai.backend.sysadmin.login.service.LoginService;
import net.chintai.backend.sysadmin.login.service.bean.LoginServiceBean;

import org.apache.commons.lang.StringUtils;

/**
 * LoginService の実装クラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LoginServiceImpl implements LoginService {

    /** ユーザーデータ取得用 DAO */
    private LoginDao loginDao = null;

    /**
     * LoginDao を設定します。
     * @param loginDao
     */
    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.login.service.LoginService#login(net.chintai.backend.sysadmin.login.service.bean.LoginServiceBean)
     */
    public LoginServiceBean login(LoginServiceBean inBean) {
        User user = loginDao.selectUser(inBean.getUserId());

        // ユーザID存在チェック
        if (user == null || StringUtils.isEmpty(user.getUserId())) {
            return null;
        }

        // パスワードチェック
        if (!StringUtils.equals(CryptUtil.md5digest(inBean.getPassword()), user.getPassword())) {
            return null;
        }

        // 返却用 Bean 作成
        LoginServiceBean outBean = new LoginServiceBean();
        outBean.setUserId(user.getUserId());
        outBean.setUserName(user.getUserName());
        return outBean;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.login.service.LoginService#getUserInfo(java.lang.String,
     *      java.lang.String)
     */
    public LoginServiceBean getUserInfo(String userId, String postDate) {

        // 日付の検証
        if (!DateUtil.isValidDate(postDate)) {
            return null;
        }

        // ユーザ情報取得
        User user = loginDao.selectUser(userId);

        // ユーザID存在チェック
        if (user == null || StringUtils.isEmpty(user.getUserId())) {
            return null;
        }

        // 返却用 Bean 作成
        LoginServiceBean outBean = new LoginServiceBean();
        outBean.setUserId(user.getUserId());
        outBean.setUserName(user.getUserName());
        return outBean;
    }



}
