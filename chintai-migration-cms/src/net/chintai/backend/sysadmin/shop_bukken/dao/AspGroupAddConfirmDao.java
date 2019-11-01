/*
 * $Id: AspGroupAddConfirmDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.domain.AspGroupInfo;

/**
 * 不動産ASPグループ設定確認Dao
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspGroupAddConfirmDao {

    /**
     * 指定した店舗が登録されているかどうかを検索します。
     * @param paramBean 検索パラメータ(店舗コード、グループ店舗コード)
     * @return 検索結果件数
     */
    public int selectGroupShopCount(AspGroupSearchParamBean paramBean);

    /**
     * 店舗コードでグループに追加する店舗検索します。
     * @param paramBean 検索パラメータ(店舗コード)
     * @return 不動産ASPグループ情報
     */
    public List<AspGroupInfo> selectGroupShopSearch(AspGroupSearchParamBean paramBean);

    /**
     * グループに登録されるASP連番を取得します。
     * @param paramBean 検索パラメータ(店舗コード)
     * @return 不動産ASP連番
     */
    public Long selectAspShopSeq(String shopCd);
}
