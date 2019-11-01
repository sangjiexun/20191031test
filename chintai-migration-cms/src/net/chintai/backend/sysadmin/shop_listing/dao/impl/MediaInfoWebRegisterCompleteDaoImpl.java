/*
 * $Id: MediaInfoWebRegisterCompleteDaoImpl.java 4251 2009-03-24 06:53:28Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/15     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoWebRegisterCompleteDao;
import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoWebRegisterCompleteParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * MediaInfoWebRegisterCompleteDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4251 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoWebRegisterCompleteDaoImpl extends SqlMapClientDaoSupport implements
        MediaInfoWebRegisterCompleteDao {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoWebRegisterCompleteDao
     * #
     * logicalDeleteMediaInfoCity(net.chintai.backend.sysadmin.shop_listing.dao.
     * MediaInfoWebRegisterCompleteParamBean)
     */
    public void logicalDeleteMediaInfoCity(MediaInfoWebRegisterCompleteParamBean paramBean) {
        getSqlMapClientTemplate().update("shopListing.logicalDeleteMediaInfoCity", paramBean);

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoWebRegisterCompleteDao
     * #
     * logicalDeleteMediaInfoData(net.chintai.backend.sysadmin.shop_listing.dao.
     * MediaInfoWebRegisterCompleteParamBean)
     */
    public void logicalDeleteMediaInfoData(MediaInfoWebRegisterCompleteParamBean paramBean) {
        getSqlMapClientTemplate().update("shopListing.logicalDeleteMediaInfoData", paramBean);

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoWebRegisterCompleteDao
     * #logicalDeleteMediaInfoEki(net.chintai.backend.sysadmin.shop_listing.dao.
     * MediaInfoWebRegisterCompleteParamBean)
     */
    public void logicalDeleteMediaInfoEki(MediaInfoWebRegisterCompleteParamBean paramBean) {
        getSqlMapClientTemplate().update("shopListing.logicalDeleteMediaInfoEki", paramBean);

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoWebRegisterCompleteDao
     * #
     * logicalDeleteMediaInfoIcon(net.chintai.backend.sysadmin.shop_listing.dao.
     * MediaInfoWebRegisterCompleteParamBean)
     */
    public void logicalDeleteMediaInfoIcon(MediaInfoWebRegisterCompleteParamBean paramBean) {
        getSqlMapClientTemplate().update("shopListing.logicalDeleteMediaInfoIcon", paramBean);

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoWebRegisterCompleteDao
     * #updateMediaInfoCity(net.chintai.backend.sysadmin.shop_listing.dao.
     * MediaInfoWebRegisterCompleteParamBean)
     */
    public void updateMediaInfoCity(MediaInfoWebRegisterCompleteParamBean paramBean) {
        getSqlMapClientTemplate().update("shopListing.updateMediaInfoCity", paramBean);

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoWebRegisterCompleteDao
     * #updateMediaInfoData(net.chintai.backend.sysadmin.shop_listing.dao.
     * MediaInfoWebRegisterCompleteParamBean)
     */
    public void updateMediaInfoData(MediaInfoWebRegisterCompleteParamBean paramBean) {
        getSqlMapClientTemplate().update("shopListing.updateMediaInfoData", paramBean, 1);

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoWebRegisterCompleteDao
     * #updateMediaInfoEki(net.chintai.backend.sysadmin.shop_listing.dao.
     * MediaInfoWebRegisterCompleteParamBean)
     */
    public void updateMediaInfoEki(MediaInfoWebRegisterCompleteParamBean paramBean) {
        getSqlMapClientTemplate().update("shopListing.updateMediaInfoEki", paramBean);

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoWebRegisterCompleteDao
     * #updateMediaInfoIcon(net.chintai.backend.sysadmin.shop_listing.dao.
     * MediaInfoWebRegisterCompleteParamBean)
     */
    public void updateMediaInfoIcon(MediaInfoWebRegisterCompleteParamBean paramBean) {
        getSqlMapClientTemplate().update("shopListing.updateMediaInfoIcon", paramBean);

    }

}
