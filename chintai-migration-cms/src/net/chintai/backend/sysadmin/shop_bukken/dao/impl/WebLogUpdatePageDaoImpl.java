/*
 * $Id: WebLogUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.WebLogUpdatePageDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.WebLogUpdatePageParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopDetailInfo;

/**
 * WebLogUpdatePageDaoインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class WebLogUpdatePageDaoImpl extends SqlMapClientDaoSupport 
    implements WebLogUpdatePageDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.WebLogUpdatePageDao#webLogUpdatePage(net.chintai.backend.sysadmin.shop_bukken.dao.WebLogUpdatePageParamBean)
     */
    public ShopDetailInfo webLogUpdatePage(WebLogUpdatePageParamBean paramBean) {

        return (ShopDetailInfo) getSqlMapClientTemplate().queryForObject("shopBukken.webLogUpdatePage",
                paramBean);
    }
}