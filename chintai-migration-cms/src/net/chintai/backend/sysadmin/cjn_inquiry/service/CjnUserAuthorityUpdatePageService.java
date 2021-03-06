/*
 * $Id: CjnUserAuthorityUpdatePageService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAuthorityUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAuthorityUpdatePageOutServiceBean;

/**
 * 閲覧可能権限を取得するサービス。
 * 
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnUserAuthorityUpdatePageService {

    /**
     * 問い合せ閲覧権限を取得します。
     * @param inServiceBean 検索条件
     * @return 権限リスト
     */
    public List<CjnUserAuthorityUpdatePageOutServiceBean> selectCjnAccountLevel(
            CjnUserAuthorityUpdatePageInServiceBean inServiceBean);

    /**
     * 最終更新日時を取得します。
     * @param inServiceBean 検索条件
     * @return 最終更新日時
     */
    public String selectLastUpdateDt(CjnUserAuthorityUpdatePageInServiceBean inServiceBean);

}
