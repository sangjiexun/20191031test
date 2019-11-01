/*
 * $Id: OperationService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.dwr.service.bean.OperationBean;

/**
 * 「操作内容」プルダウンリストを取得するサービスクラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface OperationService {

    /**
     * 操作内容のリストを取得します。
     * @return 操作内容のリスト
     */
    public List<OperationBean> getOperationList(String authorityId);
}