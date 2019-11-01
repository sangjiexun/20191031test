/*
 * $Id: CjnUserUpdatePageService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserUpdatePageOutServiceBean;

/**
 * 問い合せユーザ更新情報取得Service
 * 
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnUserUpdatePageService {

    /**
     * 問い合せユーザ情報を取得します。
     * @param inServiceBean 検索条件
     * @return 問い合せユーザ情報
     */
    public CjnUserUpdatePageOutServiceBean selectUpdateCjnUser(CjnUserUpdatePageInServiceBean inServiceBean);
}
