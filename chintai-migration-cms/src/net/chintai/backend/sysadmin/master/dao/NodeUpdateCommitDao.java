package net.chintai.backend.sysadmin.master.dao;

import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.master.domain.NodeDomain;

/**
 * 統一駅登録DAO
 * 
 * @author M.Ono
 * @version $Revision: 4087 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public interface NodeUpdateCommitDao {

    /**
     * 統一駅情報を登録します。
     * @param nodeEki 入力データ
     */
    public void nodeInsert(NodeDomain nodeEki);

    /**
     * 統一駅情報を更新します。
     * @param nodeEki 入力データ
     * @return 処理結果(0:失敗, 1:成功)
     */
    public int nodeUpdate(NodeDomain nodeEki);

    /**
     * 指定された削除区分データを削除します。
     * @param nodeEki 駅データ
     */
    // public void nodeEkiDelete(NodeDomain nodeEki);
    /**
     * 統一駅マスタの情報(削除区分情報込み)を取得します。
     * @return 統一駅マスタ一覧(削除区分情報込み)
     */
    public Map<String, NodeDomain> selectNodeMaster(List<NodeDomain> nodeEkiList);
}