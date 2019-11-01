/*
 * $Id: CjnLogOperationSearchService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnLogOperationSearchInServiceBean;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;

/**
 * システム操作履歴の取得処理を提供するサービスクラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnLogOperationSearchService {

    /**
     * システム操作履歴一覧を取得します。
     * @param inServiceBean 検索条件(ユーザID、ユーザ名、処理区分、問い合せID、処理日時)
     * @return システム操作履歴リスト
     * @throws ApplicationException
     */
    public List getCjnLogList(CjnLogOperationSearchInServiceBean inServiceBean, BasePagerCondition condition);
}
