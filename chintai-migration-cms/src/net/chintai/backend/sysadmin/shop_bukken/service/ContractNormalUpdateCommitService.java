package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractNormalUpdateCommitInServiceBean;

/**
 * 契約明細設定（数量なし）完了サービスクラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractNormalUpdateCommitService {

    /**
     * 契約明細設定（数量なし）完了
     * @param inServiceBean
     * @throws ApplicationException
     */
    public void contractNormalkUpdateCommit(ContractNormalUpdateCommitInServiceBean inServiceBean)
        throws ApplicationException;
}