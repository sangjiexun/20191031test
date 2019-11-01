/*
 * $Id: ShopBasicInfoUpdateCommitService.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopBasicInfoUpdateCommitInServiceBean;


/**
 * 店舗基本情報更新完了サービス。
 *
 * @author Lee Hosup
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopBasicInfoUpdateCommitService {

    /**
     * 店舗基本情報を更新します。
     *
     * @param inBean
     * @return なし
     */
    public void doCommit(ShopBasicInfoUpdateCommitInServiceBean inBean);

}
