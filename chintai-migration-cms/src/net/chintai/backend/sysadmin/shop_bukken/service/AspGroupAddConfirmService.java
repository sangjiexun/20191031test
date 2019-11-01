/*
 * $Id: AspGroupAddConfirmService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoOutServiceBean;

/**
 * 不動産ASPグループ設定確認Service
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspGroupAddConfirmService {

    /**
     * グループ化する店舗の情報を取得します。
     * @param inServiceBean 検索条件
     * @return グループ化する店舗の情報
     */
    public List<AspGroupInfoOutServiceBean> selectAspGroupAdd(AspGroupInfoInServiceBean inServiceBean);
    
    
    /**
     * 店舗がグループで登録されているかどうかを調べます。
     * @param inServiceBean 検索条件
     * @return 検索結果カウント件数
     */
    public int selectAspGroupShopSearch(AspGroupInfoInServiceBean inServiceBean);

}
