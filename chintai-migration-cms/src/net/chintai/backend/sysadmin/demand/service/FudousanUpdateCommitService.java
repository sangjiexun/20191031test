/*
 * $Id: FudousanUpdateCommitService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/01     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanUpdateCommitInServiceBean;

/**
 * 不動産会社更新サービス
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanUpdateCommitService {

    /**
     * 不動産会社情報を更新します。
     * @param inBean 更新パラメータ
     * @throws ApplicationException
     */
    public void updateFudousan(FudousanUpdateCommitInServiceBean inBean)
            throws ApplicationException;

}
