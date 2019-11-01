/*
 * $Id: FudousanRegisterCommitService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.demand.service.bean.FudousanRegisterCommitInServiceBean;


/**
 * 不動産会社新規登録サービス
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanRegisterCommitService {

    /**
     * 新しい不動産会社情報を登録します
     * @param inBean 登録パラメータ
     * */
    public void insertFudousanCompanyInfo(FudousanRegisterCommitInServiceBean inBean);
}
