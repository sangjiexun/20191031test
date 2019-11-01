/*
 * $Id: KeiyakuUpdatePageServiceImpl.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/25     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuUpdatePageDao;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuUpdatePageParamBean;
import net.chintai.backend.sysadmin.shop_listing.domain.KihonKeiyakuInfoDomin;
import net.chintai.backend.sysadmin.shop_listing.service.KeiyakuUpdatePageService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuUpdatePageOutServiceBean;

/**
 * KeiyakuUpdatePageServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuUpdatePageServiceImpl implements KeiyakuUpdatePageService {

    /** 既存契約情報取得DAO */
    private KeiyakuUpdatePageDao keiyakuUpdatePageDao;

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.service.KeiyakuUpdatePageService
     * # searchKeiyakuInfo(
     * net.chintai.backend.sysadmin.shop_listing.service.bean
     * .KeiyakuUpdatePageInServiceBean)
     */
    public KeiyakuUpdatePageOutServiceBean searchKeiyakuInfo(KeiyakuUpdatePageInServiceBean inBean) {

        KeiyakuUpdatePageParamBean paramBean = new KeiyakuUpdatePageParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inBean);

        // 既存契約情報を取得します。
        KihonKeiyakuInfoDomin domain = keiyakuUpdatePageDao.selectKeiyakuInfo(paramBean);
        KeiyakuUpdatePageOutServiceBean outBean = new KeiyakuUpdatePageOutServiceBean();
        BeanUtilsWrapper.copyProperties(outBean, domain);

        return outBean;
    }

    /**
     * 既存契約情報取得DAOを設定します。
     * @param keiyakuUpdatePageDao 既存契約情報取得DAO
     */
    public void setKeiyakuUpdatePageDao(KeiyakuUpdatePageDao keiyakuUpdatePageDao) {
        this.keiyakuUpdatePageDao = keiyakuUpdatePageDao;
    }
}
