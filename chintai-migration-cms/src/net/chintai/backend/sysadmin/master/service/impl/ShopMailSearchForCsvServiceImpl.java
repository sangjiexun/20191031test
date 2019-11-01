/*
 * $Id: ShopMailSearchForCsvServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.master.dao.ShopMailSearchForCsvDao;
import net.chintai.backend.sysadmin.master.domain.ShopMailDomain;
import net.chintai.backend.sysadmin.master.service.ShopMailSearchForCsvService;
import net.chintai.backend.sysadmin.master.service.bean.ShopMailSearchForCsvOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ShopMailSearchForCsvServiceの実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopMailSearchForCsvServiceImpl implements ShopMailSearchForCsvService {

    /** 不動産会社メールアドレスを検索するDAO */
    private ShopMailSearchForCsvDao shopMailSearchForCsvDao = null;

    /**
     * shopMailSearchForCsvDaoを設定する
     * @param shopMailSearchForCsvDao
     */
    public void setShopMailSearchForCsvDao(ShopMailSearchForCsvDao shopMailSearchForCsvDao) {
        this.shopMailSearchForCsvDao = shopMailSearchForCsvDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.ShopMailSearchForCsvService#shopMailSearchForCsv()
     */
    public List<ShopMailSearchForCsvOutServiceBean> shopMailSearchForCsv() throws Exception {

        // 不動産会社メールアドレスを検索
        List rsList = shopMailSearchForCsvDao.selectShopMailForCsv();
        List<ShopMailSearchForCsvOutServiceBean> shopMailList =
                new ArrayList<ShopMailSearchForCsvOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            ShopMailDomain shopMailInfo = (ShopMailDomain) rsList.get(i);

            ShopMailSearchForCsvOutServiceBean shopMailSearchForCsvOutServiceBean =
                    new ShopMailSearchForCsvOutServiceBean();
            BeanUtils.copyProperties(shopMailSearchForCsvOutServiceBean, shopMailInfo);

            shopMailList.add(shopMailSearchForCsvOutServiceBean);
        }

        return shopMailList;
    }

}
