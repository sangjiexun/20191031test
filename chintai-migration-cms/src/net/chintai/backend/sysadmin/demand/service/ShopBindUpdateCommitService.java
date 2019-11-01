/*
 * $Id: ShopBindUpdateCommitService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/16  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.ShopBindUpdateCommitInServiceBean;

/**
 * 店舗紐付先更新サービス
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopBindUpdateCommitService{

    /**
     * 店舗紐付先更新を更新します。
     * @param inBean 更新パラメータ
     * @throws ApplicationException
     */
    public void updateShopBindInfo(ShopBindUpdateCommitInServiceBean inBean)
        throws ApplicationException;
}
