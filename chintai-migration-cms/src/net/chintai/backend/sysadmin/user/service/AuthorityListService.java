/*
 * $Id: AuthorityListService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/19  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import java.util.List;


/**
 * グループの権限一覧の取得処理を提供するサービスクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AuthorityListService {

    /**
     * グループの権限一覧を取得します。
     * @return グループの権限一覧
     * @throws Exception
     */
    public List getAuthorityList() throws Exception;

}
