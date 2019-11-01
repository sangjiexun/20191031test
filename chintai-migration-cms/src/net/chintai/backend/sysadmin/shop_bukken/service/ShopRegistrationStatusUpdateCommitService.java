/*
 * $Id: ShopRegistrationStatusUpdateCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopRegistrationStautsUpdateCommitInServiceBean;
import net.chintai.batch.support.ppc.PpcException;

/**
 * 登録状況更新完了サービスクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopRegistrationStatusUpdateCommitService {

    /**
     * 変更された登録状況を更新完了する。
     *
     * @param inServiceBean 変更された登録状況
     * @throws ApplicationException
     * @throws PpcException
     */
    public boolean shopRegistrationStautsUpdateCommit(
            ShopRegistrationStautsUpdateCommitInServiceBean inServiceBean)
            throws ApplicationException, PpcException;

}
