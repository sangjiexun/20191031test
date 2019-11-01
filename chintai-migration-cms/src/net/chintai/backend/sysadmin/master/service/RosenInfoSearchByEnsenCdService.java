/*
 * $Id: RosenInfoSearchByEnsenCdService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/14  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service;

import java.util.List;

import net.chintai.backend.sysadmin.master.service.bean.RosenInfoInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.RosenInfoOutServiceBean;

/**
 * 沿線詳細を検索するService。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface RosenInfoSearchByEnsenCdService {

    /**
     * 沿線コードで、沿線詳細を検索する。
     * 
     * @param inServiceBean 沿線コード
     * @return 沿線詳細
     * @throws Exception
     */
    public List<RosenInfoOutServiceBean> rosenSearchByAreaCdRosenType(RosenInfoInServiceBean inServiceBean)
            throws Exception;

}
