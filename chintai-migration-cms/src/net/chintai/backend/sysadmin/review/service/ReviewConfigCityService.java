/*
 * $Id: ReviewConfigCityService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigCityInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigCityOutServiceBean;

/**
 * 市区町村別比較対象設定内容を取得するサービスクラス。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewConfigCityService {

    /**
     * 市区町村別比較対象設定内容を取得します。<br>
     * @param inBean 都道府県コード
     * @return 市区町村別比較対象設定内容情報
     */
    public ReviewConfigCityOutServiceBean getCityConfigInfo(
            ReviewConfigCityInServiceBean inBean);
}
