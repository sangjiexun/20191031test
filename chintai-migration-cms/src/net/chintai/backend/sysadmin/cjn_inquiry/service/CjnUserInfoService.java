/*
 * $Id: CjnUserInfoService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAccountOutServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserInfoInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserInfoOutServiceBean;

/**
 * 問い合せユーザ詳細Service
 * 
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnUserInfoService {

    /**
     * 問い合せユーザ詳細情報を取得します。
     * @param inServiceBean
     */
    public CjnUserInfoOutServiceBean selectCjnUser(CjnUserInfoInServiceBean inServiceBean);

    /**
     * 問い合せユーザ権限情報を取得します。
     * @param inServiceBean
     */
    public List<CjnUserAccountOutServiceBean> cjnAccountLevelList(CjnUserInfoInServiceBean inServiceBean);

}
