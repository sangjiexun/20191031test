/*
 * $Id: ShikutyosonPostSearchService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.master.service.bean.ShikutyosonPostSearchInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.ShikutyosonPostSearchOutServiceBean;

/**
 * 市区町村郵便番号から検索Service
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShikutyosonPostSearchService {

    /**
     * 市区町村郵便番号から検索結果リストを取得します。
     * @param inServiceBean 検索パラメータ(郵便番号)
     * @return 市区町村メンテナンス検索結果(郵便番号、都道府県、市区町村、町域)
     * @throws ApplicationException
     */
    public List<ShikutyosonPostSearchOutServiceBean> selectShikutyosonListByPost(
            ShikutyosonPostSearchInServiceBean inServiceBean) throws ApplicationException;

}
