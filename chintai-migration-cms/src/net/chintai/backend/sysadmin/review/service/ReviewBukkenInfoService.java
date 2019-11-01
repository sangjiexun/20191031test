/*
 * $Id: ReviewBukkenInfoService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service;

import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenInfoInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenInfoOutServiceBean;

/**
 * Web審査物件詳細情報サービスを提供します。
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ReviewBukkenInfoService {

    /**
     * Web審査情報を取得します。<br>
     * @param inBean 検索パラメータ
     * @return Web審査状況
     */
    public ReviewBukkenInfoOutServiceBean getBukkenInfo(ReviewBukkenInfoInServiceBean inBean);

}
