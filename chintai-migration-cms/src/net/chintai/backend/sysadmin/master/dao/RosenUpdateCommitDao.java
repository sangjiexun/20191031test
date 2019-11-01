/*
 * $Id: RosenUpdateCommitDao.java 3731 2008-01-10 08:34:32Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/11/21   BGT)金東珍    新規作成
 * 2007/01/09   BGT)児島      アーキテクチャ変更をうけ全面的に書き直し
 */
package net.chintai.backend.sysadmin.master.dao;

import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.master.domain.EkiDomain;
import net.chintai.backend.sysadmin.master.domain.EnsenDomain;

/**
 * 沿線・駅の登録 / 変更 / 削除DAO
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3731 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface RosenUpdateCommitDao {

    /**
     * 沿線情報を登録します。
     * @param ensen 入力データ
     */
    public void ensenInsert(EnsenDomain ensen);

    /**
     * 駅情報を登録します。
     * @param eki 入力データ
     */
    public void ekiInsert(EkiDomain eki);

    /**
     * 沿線情報を更新します。
     * @param ensen 入力データ
     * @return 処理結果(0:失敗, 1:成功)
     */
    public int ensenUpdate(EnsenDomain ensen);

    /**
     * 駅情報を更新します。
     * @param eki 入力データ
     * @return 処理結果(0:失敗, 1:成功)
     */
    public int ekiUpdate(EkiDomain eki);
    
    /**
     * 駅配布停止データを追加します。
     * @param eki 駅データ
     */
    public void ekiUseStopFlgInsert(EkiDomain eki);
    
    /**
     * 指定された駅配布停止データを削除します。
     * @param eki 駅データ
     */
    public void ekiUseStopFlgDelete(EkiDomain eki);

    /**
     * 沿線配布停止データを追加します。
     * @param ensen 沿線データ
     */
    public void ensenUseStopFlgInsert(EnsenDomain ensen);
    
    /**
     * 指定された沿線配布停止データを削除します。
     * @param ensen 沿線データ
     */
    public void ensenUseStopFlgDelete(EnsenDomain ensen);
    
    /**
     * 沿線マスタの情報(配布区分情報込み)を取得します。
     * @return 沿線マスタ一覧(配布区分情報込み)
     */
    public Map<String, EnsenDomain> selectEnsenMaster(List<String> ensenCodeList);

    /**
     * 駅マスタの情報(配布区分情報込み)を取得します。
     * @return 駅マスタ一覧(配布区分情報込み)
     */
    public Map<String, EkiDomain> selectEkiMaster(List<EkiDomain> ekiList);
}