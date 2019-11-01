/*
 * $Id: BukkenPublishStatusUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/02  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdatePageDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdatePageParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.Bukken;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenPublishStatusUpdatePageService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenPublishStatusUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenPublishStatusUpdatePageOutServiceBean;

/**
 * BukkenInfoServiceの実装クラス
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenPublishStatusUpdatePageServiceImpl implements BukkenPublishStatusUpdatePageService {

    /** 物件掲載状態変更画面に遷移DAO */
    private BukkenPublishStatusUpdatePageDao bukkenPublishStatusUpdatePageDao = null;

    /**
     * BukkenPublishStatusUpdatePageDaoを設定する
     * @param bukkenPublishStatusUpdatePageDao
     */
    public void setBukkenPublishStatusUpdatePageDao(BukkenPublishStatusUpdatePageDao bukkenPublishStatusUpdatePageDao) {
        this.bukkenPublishStatusUpdatePageDao = bukkenPublishStatusUpdatePageDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.BukkenPublishStatusUpdatePageService#bukkenPublishStatusUpdatePage(net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenPublishStatusUpdatePageInServiceBean)
     */
    public BukkenPublishStatusUpdatePageOutServiceBean bukkenPublishStatusUpdatePage(
            BukkenPublishStatusUpdatePageInServiceBean inServiceBean) throws InvocationTargetException,
            IllegalAccessException {
        
        // 管理コードをParamBeanに設定
        BukkenPublishStatusUpdatePageParamBean paramBean = new BukkenPublishStatusUpdatePageParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // 物件詳細情報を取得
        Bukken bukken = bukkenPublishStatusUpdatePageDao.bukkenPublishStatusUpdatePage(paramBean);

        // 取得した情報をOutServiceBeanに設定
        BukkenPublishStatusUpdatePageOutServiceBean outServiceBean = new BukkenPublishStatusUpdatePageOutServiceBean();
        BeanUtils.copyProperties(outServiceBean, bukken);

        return outServiceBean;
    }
}