/*
 * $Id: ShikutyosonPostSearchDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao;

import java.util.List;

import net.chintai.backend.sysadmin.master.domain.ShikutyosonSearchInfo;

/**
 * 市区町村郵便番号から検索DAO
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShikutyosonPostSearchDao {

    /**
     * 市区町村郵便番号から検索情報を取得します。
     * @param param 検索パラメータ(郵便番号)
     * @return 市区町村と郵便番号の検索結果
     */
    public List<ShikutyosonSearchInfo> selectShikutyosonListByZipcode(ShikutyosonSearchParamBean param);

}
