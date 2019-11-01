/*
 * $Id: AspUpdateCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.domain.AspContractInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo;

/**
 * 不動産ASP設定情報を更新するDao
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspUpdateCommitDao {

    /**
     * 更新されたデータ(エリア)が登録されているかどうかをチェックする。
     * @param aspPrefInfo 検索パラメータ(店舗コード、都道府県コード)
     * @return 検索結果件数
     */
    public int selectAspPrefCountByShopCdPrefCd(AspPrefInfo aspPrefInfo);

    /**
     * データ(エリア)を登録する。 条件:更新されたデータ(エリア)が登録されていない場合。
     * @param aspPrefInfo 登録する不動産ASPエリア情報
     */
    public void insertAspPref(AspPrefInfo aspPrefInfo);

    /**
     * データ(エリア)を更新する。 条件:更新されたデータ(エリア)が登録されている場合。
     * @param aspPrefInfo 更新するエリア情報
     */
    public void updateAspPrefByShopCd(AspPrefInfo aspPrefInfo);

    /**
     * 最新更新日付を照会する。 条件:更新されたデータ(エリア)が登録されている場合。
     * @param aspPrefInfo 検索パラメータ(店舗コード、都道府県コード)
     * @return 最新更新日付
     */
    public String selectAspPrefUpdDtByShopCd(AspPrefInfo aspPrefInfo);

    /**
     * 不動産ASP設定基本情報を更新する。
     * @param aspInfo 更新する不動産ASP設定基本情報
     * @return 更新結果件数
     */
    public int updateAspByShopCd(AspInfo aspInfo);

    /**
     * 不動産ASP設定の都道府県情報を削除する。
     * @param paramBean 検索パラメータ(店舗コード、不動産ASPの都道府県コードリスト)
     */
    public void deleteAspPrefByShopCdAndPrefCd(AspPrefDeleteCommitParamBean paramBean);

    /**
     * 不動産ASP設定の店舗契約管理を論理削除する。（契約終了日時を設定）
     * @param paramBean 検索パラメータ(契約管理番号)
     */
    public int updateAspShopContracLogicalDeleteByKeiyakuNo(AspContractInfo aspContractInfo);

    /**
     * 不動産ASP設定の店舗契約管理を登録する。
     * @param paramBean 検索パラメータ(契約管理番号)
     */
    public void insertAspShopContract(AspContractInfo aspContractInfo);

    /**
     * 不動産ASP設定基本情報を更新する。
     * @param aspInfo 不動産ASP設定基本情報
     * @return 不動産ASP連番
     */
    public Long insertAsp(AspInfo aspInfo);

    /**
     * 登録する不動産ASP設定基本情報に、グループが登録されているかをチェックする。
     * @param aspPrefInfo 検索パラメータ(店舗コード)
     * @return 最新更新日付
     */
    public List<AspGroupAddCommitParamBean> selectAspGroupByShopCd(String shopCd);

    /**
     * グループを複写する。
     * @param paramBean 不動産ASPグループ情報
     */
    public void insertAspGroup(AspGroupAddCommitParamBean paramBean);

    /**
     * 不動産ASPを設定するときに登録された不動産ASP情報を照会する。
     *
     * @param paramBean 店舗コード
     * @return 不動産ASP情報
     */
    public Object selectAspRegisteredInfo(AspShopInfoParamBean aspShopInfoParamBean);

    /**
     * 契約情報の登録をする。
     *
     * @param aspContractInfo 契約登録内容
     */
   public void insertAspContractAddCommit(AspContractInfo aspContractInfo);

}
