/*
 * $Id: ShikutyosonAddService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/14  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.master.service.bean.ShikutyosonAddInServiceBean;

/**
 * 市区町村登録Service
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShikutyosonAddService {

    /**
     * 市区町村登録
     * @param inServiceBean
     * @throws ApplicationException
     */
    public void insertShikutyosonAdd(ShikutyosonAddInServiceBean inServiceBean) throws ApplicationException;

}
