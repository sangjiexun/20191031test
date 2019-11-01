/*
 * $Id: ReviewShopInfoService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import net.chintai.backend.sysadmin.review.service.bean.ReviewShopInfoInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopInfoOutServiceBean;

/**
 * 店舗詳細情報サービスを提供します。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewShopInfoService {

    /**
     * Web審査関連店舗詳細情報を検索
     * @param inBean 検索パラメータ
     * @return Web審査関連店舗情報
     */
    public ReviewShopInfoOutServiceBean selectShopInfo(ReviewShopInfoInServiceBean inBean);

}
