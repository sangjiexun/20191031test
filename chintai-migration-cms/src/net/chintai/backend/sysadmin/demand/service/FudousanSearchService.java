/*
 * $Id: FudousanSearchService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/21  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanSearchOutServiceBean;

/**
 * 不動産会社検索サービス
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanSearchService {

    /**
     * 不動産会社一覧情報を検索します。
     * @param inBean 検索パラーメタ
     * @param condition ページング情報
     * @return 検索結果
     */
    List<FudousanSearchOutServiceBean> getFudousanList(FudousanSearchInServiceBean inBean,
            BasePagerCondition condition);
}
