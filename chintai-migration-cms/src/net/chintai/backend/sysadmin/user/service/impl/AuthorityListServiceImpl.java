/*
 * $Id: AuthorityListServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/19  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.dao.AuthorityListDao;
import net.chintai.backend.sysadmin.user.domain.Authority;
import net.chintai.backend.sysadmin.user.service.AuthorityListService;
import net.chintai.backend.sysadmin.user.service.bean.AuthorityListOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;


/**
 * AuthorityListService の実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AuthorityListServiceImpl implements AuthorityListService {

    /** AuthorityList取得用 DAO */
    private AuthorityListDao authorityListDao = null;

    /**
     * authorityListDaoを設定する
     * @param authorityListDao
     */
    public void setAuthorityListDao(AuthorityListDao authorityListDao) {
        this.authorityListDao = authorityListDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.AuthorityListService#getAuthorityList()
     */
    public List getAuthorityList() throws ApplicationException {
        List rsList = authorityListDao.getAuthorityList();
        List<AuthorityListOutServiceBean> authorityList = new ArrayList<AuthorityListOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            Authority authority = (Authority) rsList.get(i);

            AuthorityListOutServiceBean authorityBean = new AuthorityListOutServiceBean();
            try {
                BeanUtils.copyProperties(authorityBean, authority);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            authorityList.add(authorityBean);
        }
        return authorityList;
    }

}
