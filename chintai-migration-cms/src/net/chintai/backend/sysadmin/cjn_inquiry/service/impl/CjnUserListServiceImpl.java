/*
 * $Id: CjnUserListServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserListDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnUserList;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserListService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserListOutServiceBean;

/**
 * CjnUserListServiceの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserListServiceImpl implements CjnUserListService {

    /** 問い合せユーザ一覧取得DAO */
    private CjnUserListDao userListDao;

    /**
     * 問い合せユーザ一覧取得DAOを設定します。
     * @param userListDao
     */
    public void setCjnUserListDao(CjnUserListDao userListDao) {
        this.userListDao = userListDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserListService#selectCjnUserList()
     */
    public List<CjnUserListOutServiceBean> selectCjnUserList() {

        List<CjnUserList> domainList = userListDao.selectCjnUserList();
        List<CjnUserListOutServiceBean> outList = new ArrayList<CjnUserListOutServiceBean>();

        if (domainList != null) {
            try {
                for (int i = 0; i < domainList.size(); i++) {
                    CjnUserListOutServiceBean outServiceBean = new CjnUserListOutServiceBean();
                    BeanUtils.copyProperties(outServiceBean, domainList.get(i));
                    outList.add(outServiceBean);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }
        return outList;
    }

}
