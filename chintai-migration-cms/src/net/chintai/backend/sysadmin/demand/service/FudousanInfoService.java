/*
 * $Id: FudousanInfoService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/28     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanInfoInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanInfoOutServiceBean;

/**
 * 不動産会社詳細情報サービスを提供します。
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanInfoService {

    /**
     * 不動産会社詳細情報
     * @param inServiceBean 検索パラメータ
     * @return FudousanInfoOutServiceBean 不動産会社詳細情報
     * @throws ApplicationException
     */
    public FudousanInfoOutServiceBean fudousanInfo(FudousanInfoInServiceBean inServiceBean)
            throws ApplicationException;
}
