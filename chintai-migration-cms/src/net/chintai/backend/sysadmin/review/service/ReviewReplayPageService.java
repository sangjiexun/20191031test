/*
 * $Id: ReviewReplayPageService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import net.chintai.backend.sysadmin.review.service.bean.ReviewReplayPageInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewReplayPageOutServiceBean;


/**
 * 返信入力対象物件情報取得サービス
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewReplayPageService {

    /**
     * 返信入力対象物件情報を取得します。
     * @param inBean 検索パラメータ
     * @return 物件情報
     */
    public ReviewReplayPageOutServiceBean getReturnMailInfo(ReviewReplayPageInServiceBean inBean);
}
