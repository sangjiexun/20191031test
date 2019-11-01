/*
 * $Id: AspUpdateCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateCommitInServiceBean;

/**
 * 不動産ASP設定情報を更新するService。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspUpdateCommitService {

    /**
     * 不動産ASP設定情報を更新する
     * 
     * @param inServiceBean 更新する不動産ASP設定情報
     * @throws Exception
     */
    public void updateAspUpdateCommit(AspUpdateCommitInServiceBean inServiceBean) throws Exception;

}
