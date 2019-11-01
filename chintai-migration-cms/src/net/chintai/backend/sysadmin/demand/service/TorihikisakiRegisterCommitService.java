/*
 * $Id: TorihikisakiRegisterCommitService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/04  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiRegisterCommitInServiceBean;

/**
 * 取引先新規登録
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiRegisterCommitService {

    /**
     * 新しい取引先情報を登録します。（取引先テーブル）
     * @param inBean 登録パラメータ
     * @return 取引先シーケンス番号
     * @throws Exception
     */
    public String insertTorihikisaki(TorihikisakiRegisterCommitInServiceBean inBean)
            throws Exception;
}
