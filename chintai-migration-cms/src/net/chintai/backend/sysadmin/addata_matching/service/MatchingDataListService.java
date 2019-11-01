/*
 * $Id: MatchingDataListService.java 4398 2009-09-11 00:48:54Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/25     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.service;


import java.util.List;

import net.chintai.backend.sysadmin.addata_matching.service.bean.MatchingDataListInServiceBean;
import net.chintai.backend.sysadmin.addata_matching.service.bean.MatchingDataListOutServiceBean;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;



/**
 * 照合結果一覧の取得処理を提供するサービスクラス。
 * @author e-ishii
 * @version $Revision: 4398 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MatchingDataListService {

    /**
     * 照合結果一覧を取得します。
     * @param inServiceBean パラメータ
     * @param condition ページング条件
     * @return 照合結果一覧
     */
    public List<MatchingDataListOutServiceBean> getMatchingDataList
        (MatchingDataListInServiceBean inServiceBean,BasePagerCondition condition);

}
