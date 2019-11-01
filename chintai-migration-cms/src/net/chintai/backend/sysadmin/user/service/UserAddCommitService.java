/*
 * $Id: UserAddCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.user.service.bean.UserAddCommitInServiceBean;

/**
 * ユーザ登録完了処理サービスクラス
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserAddCommitService {

    /**
     * ユーザ登録完了
     * @param inServiceBean 新規ユーザデータ
     * @throws InvocationTargetException, IllegalAccessException
     */
    public void userAddCommit(UserAddCommitInServiceBean inServiceBean) throws InvocationTargetException,
            IllegalAccessException;
}
