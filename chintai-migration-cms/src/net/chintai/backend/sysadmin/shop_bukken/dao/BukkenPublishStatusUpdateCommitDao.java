/*
 * $Id: BukkenPublishStatusUpdateCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.HashMap;

/**
 * 物件掲載状態変更完了DAO
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface BukkenPublishStatusUpdateCommitDao {

    /**
     * 物件掲載状態変更完了
     *
     * @param paramBean
     * @return int
     */
    public int bukkenPublishStatusUpdateCommit(
            BukkenPublishStatusUpdateCommitParamBean paramBean);

    /**
     * 物件履歴登録完了
     *
     * @param paramBean 物件履歴登録情報
     * @return int
     */
    public int bukkenPublishStatuRirekiAddCommit(
            BukkenPublishStatusRirekiAddCommitParamBean paramBean);


    /**
     * 物件掲載状態変更前チェック
     * @param paramBean
     * @return 更新前検索結果
     */
    public HashMap<String,Object> selectBukkenPublishStatusUpdateCheck(
            BukkenPublishStatusUpdateCommitParamBean paramBean);

    /**
     * 物件履歴PK取得
     * @param paramBean
     * @return 更新前検索結果
     */
    public Long selectSeqBUkkenRireki();

    /**
     * 物件ステータス管理登録
     */
    public void bukkenStatuKanriAddCommit(
            BukkenPublishStatusUpdateCommitParamBean paramBean);
}