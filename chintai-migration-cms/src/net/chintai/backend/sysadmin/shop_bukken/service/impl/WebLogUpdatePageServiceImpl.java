/*
 * $Id: WebLogUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.shop_bukken.dao.WebLogUpdatePageDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.WebLogUpdatePageParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopDetailInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.WebLogUpdatePageService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.WebLogUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.WebLogUpdatePageOutServiceBean;

/**
 * WebLogUpdatePageServiceの実装クラス
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class WebLogUpdatePageServiceImpl implements WebLogUpdatePageService {

    /** Webログ利用可否画面に遷移DAO */
    private WebLogUpdatePageDao webLogUpdatePageDao = null;

    /**
     * WebLogUpdatePageDaoを設定する
     * @param webLogUpdatePageDao
     */
    public void setWebLogUpdatePageDao(WebLogUpdatePageDao webLogUpdatePageDao) {
        this.webLogUpdatePageDao = webLogUpdatePageDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.WebLogUpdatePageService#webLogUpdatePage(net.chintai.backend.sysadmin.shop_bukken.service.bean.WebLogUpdatePageInServiceBean)
     */
    public WebLogUpdatePageOutServiceBean webLogUpdatePage(WebLogUpdatePageInServiceBean inServiceBean)
            throws InvocationTargetException, IllegalAccessException {

        // 店舗コードをParamBeanに設定
        WebLogUpdatePageParamBean paramBean = new WebLogUpdatePageParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // アドパーク詳細情報を取得
        ShopDetailInfo shop = webLogUpdatePageDao.webLogUpdatePage(paramBean);

        // 取得した情報をOutServiceBeanに設定
        WebLogUpdatePageOutServiceBean outServiceBean = new WebLogUpdatePageOutServiceBean();
        BeanUtils.copyProperties(outServiceBean, shop);

        return outServiceBean;
    }
}