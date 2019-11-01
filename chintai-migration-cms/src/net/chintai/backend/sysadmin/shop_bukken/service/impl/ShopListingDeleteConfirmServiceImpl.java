package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDeleteConfirmDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDeleteConfirmParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopListingDetailDomain;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingDeleteConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingDeleteConfirmOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ShopListingDeleteConfrimServiceの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDeleteConfirmServiceImpl implements
        ShopListingDeleteConfirmService {

    /** 店舗リスティング設定情報削除確認DAO */
    ShopListingDeleteConfirmDao shopListingDeleteConfirmDao;

    /**
     * 店舗リスティング設定情報削除確認DAOを設定します。
     * @param shopListingDeleteConfirmDao 店舗リスティング設定情報削除確認DAO
     */
    public void setShopListingDeleteConfirmDao(ShopListingDeleteConfirmDao shopListingDeleteConfirmDao) {
        this.shopListingDeleteConfirmDao = shopListingDeleteConfirmDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.serviec.ShopListingDeleteConfrimService#getShopListingForDelete(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingDeleteConfirmInServiceBean)
     */
    public List<ShopListingDeleteConfirmOutServiceBean> getShopListingForDelete(
            ShopListingDeleteConfirmInServiceBean inBean) {

        ShopListingDeleteConfirmParamBean paramBean =
                new ShopListingDeleteConfirmParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        List<ShopListingDetailDomain> rsList =
                shopListingDeleteConfirmDao
                        .getShopListingForDelete(paramBean);

        List<ShopListingDeleteConfirmOutServiceBean> returnList =
                new ArrayList<ShopListingDeleteConfirmOutServiceBean>();

        ShopListingDeleteConfirmOutServiceBean outBean;
        for (int i=0; i<rsList.size(); i++ ) {
            outBean = new ShopListingDeleteConfirmOutServiceBean();
            try {
                BeanUtils.copyProperties(outBean, rsList.get(i));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            returnList.add(outBean);
        }


        return returnList;
    }
}
