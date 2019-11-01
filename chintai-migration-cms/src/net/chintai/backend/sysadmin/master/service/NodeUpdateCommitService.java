package net.chintai.backend.sysadmin.master.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.master.service.bean.NodeUpdateCommitInServiceBean;

/**
 * 統一駅登録処理サービスクラス
 * 
 * @author M.Ono
 * @version $Revision: 4087 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public interface NodeUpdateCommitService {

    /**
     * 統一駅登録する
     * 
     * @param inServiceBean CSV取得したデータ
     * @throws ApplicationException エラー
     */
    public void nodeUpdateCommit(NodeUpdateCommitInServiceBean inServiceBean) throws ApplicationException;
}