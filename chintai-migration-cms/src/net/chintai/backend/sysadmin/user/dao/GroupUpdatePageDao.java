/*
 * $Id: GroupUpdatePageDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

import java.util.List;



/**
 * グループ更新ページの DAO です。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface GroupUpdatePageDao {

    /**
     * 照会するグループのグループIDを設定します。
     * @return paramBean グループID
     */
    public List selectUpdateGroup(GroupUpdatePageParamBean paramBean);

}
