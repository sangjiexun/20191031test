/*
 * $Id: AspGroupUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/25  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupSearchParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupUpdatePageDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspGroupInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.AspGroupUpdatePageService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * AspGroupUpdatePageServiceの実装クラス
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupUpdatePageServiceImpl implements AspGroupUpdatePageService {

    /** 不動産ASPグループ情報更新ページDao */
    private AspGroupUpdatePageDao aspGroupUpdatePageDao;

    /**
     * 不動産ASPグループ情報更新ページDaoを取得します。
     * @param aspGroupUpdatePageDao 不動産ASPグループ情報更新ページDao
     */
    public void setAspGroupUpdatePageDao(AspGroupUpdatePageDao aspGroupUpdatePageDao) {
        this.aspGroupUpdatePageDao = aspGroupUpdatePageDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.AspGroupUpdatePageService#AspGroupUpdatePage(net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoInServiceBean)
     */
    public AspGroupInfoOutServiceBean aspGroupUpdatePage(AspGroupInfoInServiceBean inServiceBean) {

        AspGroupSearchParamBean paramBean = new AspGroupSearchParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        AspGroupInfo groupDomain = aspGroupUpdatePageDao.selectGroupUpdatePage(paramBean);

        AspGroupInfoOutServiceBean outBean = new AspGroupInfoOutServiceBean();
        try {
            BeanUtils.copyProperties(outBean, groupDomain);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return outBean;
    }

}
