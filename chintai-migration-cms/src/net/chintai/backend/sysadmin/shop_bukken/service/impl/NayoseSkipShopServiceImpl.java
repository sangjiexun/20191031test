package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_bukken.dao.NayoseSkipShopDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.NayoseSkipShopDomain;
import net.chintai.backend.sysadmin.shop_bukken.service.NayoseSkipShopService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.NayoseSkipShopSearchOutServiceBean;


/**
 * NayoseSkipShopServiceの実装クラス
 *
 * @author e-ishii
 * @version $Revision: 4567 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class NayoseSkipShopServiceImpl implements NayoseSkipShopService {

    /** 名寄せ処理対象外店舗取得Dao*/
    private NayoseSkipShopDao nayoseSkipShopDao;


    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.NayoseSkipShopService#selectNayoseSkipShop(net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    public List<NayoseSkipShopSearchOutServiceBean> selectNayoseSkipShop( BasePagerCondition condition)
            throws IllegalAccessException, InvocationTargetException {

        int resultCount = nayoseSkipShopDao.selectNayoseSkipShopCount();

        condition.setCount(resultCount);

        // offset が総件数より大きい場合、offset-limit を設定
        if (resultCount <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        List<NayoseSkipShopDomain> resultList = nayoseSkipShopDao.selectNayoseSkipShop(condition);

        List<NayoseSkipShopSearchOutServiceBean> outbeanList = new ArrayList<NayoseSkipShopSearchOutServiceBean>();

        for (int i = 0; i < resultList.size(); i++) {
            NayoseSkipShopSearchOutServiceBean outbean = new NayoseSkipShopSearchOutServiceBean();
            BeanUtils.copyProperties(outbean, resultList.get(i));
            outbeanList.add(outbean);
        }
        return outbeanList;
    }


    /**
     * nayoseSkipShopDaoを設定します。
     * @param nayoseSkipShopDao nayoseSkipShopDao
     */
    public void setNayoseSkipShopDao(NayoseSkipShopDao nayoseSkipShopDao) {
        this.nayoseSkipShopDao = nayoseSkipShopDao;
    }

}
