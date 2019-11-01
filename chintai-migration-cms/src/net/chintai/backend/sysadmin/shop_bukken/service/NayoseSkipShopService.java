package net.chintai.backend.sysadmin.shop_bukken.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.NayoseSkipShopSearchOutServiceBean;


/**
 * 名寄せ対象外店舗一覧取得サービスクラス
 * @author e-ishii
 * @version $Revision: 4567 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface NayoseSkipShopService {


    /**
     * 名寄せ対象外店舗一覧取得
     *
     * @param condition ページング用パラメータ
     * @return 名寄せ対象外店舗一
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public List<NayoseSkipShopSearchOutServiceBean> selectNayoseSkipShop(BasePagerCondition condition )
                    throws IllegalAccessException, InvocationTargetException;

}
