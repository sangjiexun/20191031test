/*
 * $Id: AspGroupDeleteConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupDeleteConfirmDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupSearchParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspGroupInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.AspGroupDeleteConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoOutServiceBean;

/**
 * AspGroupDeleteConfirmServiceの実装クラス
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupDeleteConfirmServiceImpl implements AspGroupDeleteConfirmService {

    /** 不動産ASPグループ設定確認Dao */
    private AspGroupDeleteConfirmDao aspGroupDeleteConfirmDao;

    /**
     * 不動産ASPグループ設定確認情報を取得します。
     * @param aspGroupDeleteConfirmDao 不動産ASPグループ設定確認Dao
     */
    public void setAspGroupDeleteConfirmDao(AspGroupDeleteConfirmDao aspGroupDeleteConfirmDao) {
        this.aspGroupDeleteConfirmDao = aspGroupDeleteConfirmDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.AspGroupDeleteConfirmService#selectGroupInfo(net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoInServiceBean)
     */
    public AspGroupInfoOutServiceBean selectGroupInfo(AspGroupInfoInServiceBean inServiceBean)
            throws ApplicationException {

        AspGroupSearchParamBean paramBean = new AspGroupSearchParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        AspGroupInfo groupDomain = aspGroupDeleteConfirmDao.selectGroup(paramBean);

        if (groupDomain != null) {
            AspGroupInfoOutServiceBean outBean = new AspGroupInfoOutServiceBean();
            try {
                BeanUtils.copyProperties(outBean, groupDomain);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            return outBean;
        } else {
            return null;
        }
    }

}
