package net.chintai.backend.sysadmin.master.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.master.dao.NodeUpdateCommitDao;
import net.chintai.backend.sysadmin.master.domain.NodeDomain;
import net.chintai.backend.sysadmin.master.service.NodeUpdateCommitService;
import net.chintai.backend.sysadmin.master.service.bean.NodeUpdateCommitInServiceBean;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;

/**
 * NodeUpdateCommitServiceの実装クラス。
 * 
 * @author M.Ono
 * @version $Revision: 4087 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class NodeUpdateCommitServiceImpl implements NodeUpdateCommitService {

    // CSVの項目名とカラム位置の対応
    private static final int C_EKINO = 0;

    private static final int C_EKINAME = 1;

    private static final int C_EKIKANA = 2;

    private static final int C_PREFCD = 3;

    private static final int C_CITYCD = 4;

    private static final int C_EKIADDRESS = 5;

    private static final int C_LOCATIONX = 6;

    private static final int C_LOCATIONY = 7;

    private static final int C_DELKBN = 8;

    /** 統一駅の登録処理 DAO */
    private NodeUpdateCommitDao nodeUpdateCommitDao = null;

    /**
     * RosenUpdateCommitDaoを設定する。
     * @param rosenUpdateCommitDao
     */
    public void setNodeUpdateCommitDao(NodeUpdateCommitDao nodeUpdateCommitDao) {
        this.nodeUpdateCommitDao = nodeUpdateCommitDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.RosenUpdateCommService#rosenUpdateCommit(net.chintai.backend.sysadmin.master.service.bean.NodeUpdateCommitInServiceBean)
     */
    public void nodeUpdateCommit(NodeUpdateCommitInServiceBean inServiceBean) throws ApplicationException {

        // DB更新用レコードの構築
        Map<String, NodeDomain> nodeMap = new LinkedHashMap<String, NodeDomain>();

        List<String[]> csvList = inServiceBean.getUploadList();

        for (int i = 0; i < csvList.size(); i++) {
            String[] line = csvList.get(i);

            String lineNumber = String.valueOf(i + 1);

            validate(line, lineNumber);

            if (nodeMap.containsKey(line[C_EKINO])) {
                if (!isValidNodeData(nodeMap.get(line[C_EKINO]), line)) {
                    String[] msg = { lineNumber, "統一駅番号", line[C_EKINO] };
                    throw new ApplicationException("WARN.M.MASTER.0036", msg);
                }

                // 重複チェック
                String nodeKey = generateNodeKey(line[C_EKINO]);

                if (nodeMap.containsKey(nodeKey)) {
                    String[] msg = { lineNumber, "統一駅番号", nodeKey };
                    throw new ApplicationException("WARN.M.MASTER.0035", msg);
                }
            } else {
                nodeMap.put(line[C_EKINO], arrayToNodeBean(line, inServiceBean, lineNumber));
            }

        }

        // DB更新実行
        Map<String, NodeDomain> nodeMasterCache = getNodeMasterCache(new ArrayList<NodeDomain>(nodeMap.values()));
        for (NodeDomain node : nodeMap.values()) {
            try {
                upsertNodeRecord(node, nodeMasterCache);

            } catch (DataAccessException e) {
                String[] msg = { "統一駅", node.getLineNumber(), "統一駅番号", node.getEkiNo() };
                throw new ApplicationException("WARN.M.MASTER.0033", msg);
            }
        }

    }

    /*
     * private methods
     */

    // ----- データチェック --------------------
    /**
     * DBに登録するデータの形式をチェックする内部メソッド。
     * @param line データ1行分を表すString配列
     * @param lineNumber 行番号
     * @throws ApplicationException データ形式が不正な場合にスローされる
     */
    private void validate(String[] line, String lineNumber) throws ApplicationException {

        // null チェック
        if (line == null) {
            throw new ApplicationException("ERROR.M.MASTER.0016");
        }

        // 行全体のカラム数
        if (line.length != 9) {
            String[] msg = { lineNumber };
            throw new ApplicationException("WARN.M.MASTER.0037", msg);
        }

        // 統一駅番号
        if (StringUtils.isEmpty(line[C_EKINO])) {
            String[] msg = { lineNumber, "統一駅番号" };
            throw new ApplicationException("WARN.M.MASTER.0038", msg);
        }

        if (line[C_EKINO].length() > 5 || !StringUtils.isNumeric(line[C_EKINO])) {
            String[] msg = { lineNumber, "統一駅番号", line[C_EKINO] };
            throw new ApplicationException("WARN.M.MASTER.0034", msg);
        }

        // 統一駅名称
        if (StringUtils.isEmpty(line[C_EKINAME])) {
            String[] msg = { lineNumber, "統一駅名称" };
            throw new ApplicationException("WARN.M.MASTER.0038", msg);
        }

        if (line[C_EKINAME].length() > 64) {
            String[] msg = { lineNumber, "統一駅名称", line[C_EKINAME] };
            throw new ApplicationException("WARN.M.MASTER.0034", msg);
        }

        // 統一駅名称かな
        if (StringUtils.isEmpty(line[C_EKIKANA])) {
            String[] msg = { lineNumber, "統一駅名称かな" };
            throw new ApplicationException("WARN.M.MASTER.0038", msg);
        }

        if (line[C_EKIKANA].length() > 64) {
            String[] msg = { lineNumber, "統一駅名称かな", line[C_EKIKANA] };
            throw new ApplicationException("WARN.M.MASTER.0034", msg);
        }

        // 都道府県コード
        if (line[C_PREFCD].length() > 2 || !StringUtils.isNumeric(line[C_PREFCD])) {
            String[] msg = { lineNumber, "都道府県コード", line[C_PREFCD] };
            throw new ApplicationException("WARN.M.MASTER.0034", msg);
        }

        // 市区町村コード（JIS）
        if (line[C_CITYCD].length() > 5 || !StringUtils.isNumeric(line[C_CITYCD])) {
            String[] msg = { lineNumber, "市区町村コード（JIS）", line[C_CITYCD] };
            throw new ApplicationException("WARN.M.MASTER.0034", msg);
        }

        // 駅住所（都道府県名＋市区町村名）
        if (line[C_EKIADDRESS].length() > 32) {
            String[] msg = { lineNumber, "駅住所", line[C_EKIADDRESS] };
            throw new ApplicationException("WARN.M.MASTER.0034", msg);
        }

        // 経度
        char[] mozi = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.' };
        char[] dot = { '.' };

        if (line[C_LOCATIONX].length() > 11) {
            String[] msg = { lineNumber, "経度", line[C_LOCATIONX] };
            throw new ApplicationException("WARN.M.MASTER.0034", msg);

        } else if (!StringUtils.isEmpty(line[C_LOCATIONX]) && StringUtils.containsOnly(line[C_LOCATIONX], dot)) {
            String[] msg = { lineNumber, "経度", line[C_LOCATIONX] };// [.]のみの場合
            throw new ApplicationException("WARN.M.MASTER.0034", msg);

        } else if (!StringUtils.isEmpty(line[C_LOCATIONX]) && StringUtils.countMatches(line[C_LOCATIONX], ".") > 1) {
            String[] msg = { lineNumber, "経度", line[C_LOCATIONX] };// [.]が複数混在している場合
            throw new ApplicationException("WARN.M.MASTER.0034", msg);

        } else if (!StringUtils.isEmpty(line[C_LOCATIONX]) && line[C_LOCATIONX].length() > 2
                && line[C_LOCATIONX].charAt(0) == '.') {

            String[] msg = { lineNumber, "経度", line[C_LOCATIONX] };// [.]が先頭に位置している場合
            throw new ApplicationException("WARN.M.MASTER.0034", msg);

        } else if (!StringUtils.isEmpty(line[C_LOCATIONX]) && !StringUtils.containsOnly(line[C_LOCATIONX], mozi)) {
            String[] msg = { lineNumber, "経度", line[C_LOCATIONX] };// 数字と[.]以外の文字の場合
            throw new ApplicationException("WARN.M.MASTER.0034", msg);

        } else if ((!StringUtils.isEmpty(line[C_LOCATIONX]) && line[C_LOCATIONX].indexOf(".") > 4)
                || (!StringUtils.isEmpty(line[C_LOCATIONX]) && line[C_LOCATIONX].indexOf(".") < 0)) {

            String[] msg = { lineNumber, "経度", line[C_LOCATIONX] };// 整数域が5桁以上の場合
            throw new ApplicationException("WARN.M.MASTER.0034", msg);

        }

        // 緯度
        if (line[C_LOCATIONY].length() > 11) {
            String[] msg = { lineNumber, "緯度", line[C_LOCATIONY] };
            throw new ApplicationException("WARN.M.MASTER.0034", msg);

        } else if (!StringUtils.isEmpty(line[C_LOCATIONY]) && StringUtils.containsOnly(line[C_LOCATIONY], dot)) {
            String[] msg = { lineNumber, "緯度", line[C_LOCATIONY] };// [.]のみの場合
            throw new ApplicationException("WARN.M.MASTER.0034", msg);

        } else if (!StringUtils.isEmpty(line[C_LOCATIONY]) && StringUtils.countMatches(line[C_LOCATIONY], ".") > 1) {
            String[] msg = { lineNumber, "緯度", line[C_LOCATIONY] };// [.]が複数混在している場合
            throw new ApplicationException("WARN.M.MASTER.0034", msg);

        } else if (!StringUtils.isEmpty(line[C_LOCATIONY]) && line[C_LOCATIONY].length() > 2
                && line[C_LOCATIONY].charAt(0) == '.') {

            String[] msg = { lineNumber, "緯度", line[C_LOCATIONY] };// [.]が先頭に位置している場合
            throw new ApplicationException("WARN.M.MASTER.0034", msg);

        } else if (!StringUtils.isEmpty(line[C_LOCATIONY]) && !StringUtils.containsOnly(line[C_LOCATIONY], mozi)) {
            String[] msg = { lineNumber, "緯度", line[C_LOCATIONY] };// 数字と[.]以外の文字の場合
            throw new ApplicationException("WARN.M.MASTER.0034", msg);

        } else if ((!StringUtils.isEmpty(line[C_LOCATIONY]) && line[C_LOCATIONY].indexOf(".") > 4)
                || (!StringUtils.isEmpty(line[C_LOCATIONY]) && line[C_LOCATIONY].indexOf(".") < 0)) {

            String[] msg = { lineNumber, "経度", line[C_LOCATIONY] };// 整数域が5桁以上の場合
            throw new ApplicationException("WARN.M.MASTER.0034", msg);

        }

        // 削除区分
        if (StringUtils.isEmpty(line[C_DELKBN])) {
            String[] msg = { lineNumber, "削除区分" };
            throw new ApplicationException("WARN.M.MASTER.0038", msg);
        }

        if (!StringUtils.isNumeric(line[C_DELKBN])) {
            String[] msg = { lineNumber, "削除区分", line[C_DELKBN] };
            throw new ApplicationException("WARN.M.MASTER.0034", msg);
        }

        if (line[C_DELKBN].length() > 1) {
            String[] msg = { lineNumber, "削除区分", line[C_DELKBN] };
            throw new ApplicationException("WARN.M.MASTER.0034", msg);

        } else if (!line[C_DELKBN].equalsIgnoreCase("1")) {
            line[C_DELKBN] = "0"; // 値が１以外に設定されていた場合は強制的に「0:有効なレコード」に読み替え
        }
    }

    /**
     * 統一駅データの各行の間で矛盾がないかどうかチェックする内部メソッド。
     * @param nodeEki 比較元統一駅データ
     * @param line csv行データ
     * @return 問題なし: true, 問題あり: false
     */
    private boolean isValidNodeData(NodeDomain nodeEki, String[] line) {

        if (!nodeEki.getEkiNo().equals(line[C_EKINO])) {
            return false;
        }

        if (!nodeEki.getEkiName().equals(line[C_EKINAME])) {
            return false;
        }

        if (!nodeEki.getEkiKana().equals(line[C_EKIKANA])) {
            return false;
        }

        if (!nodeEki.getPrefCd().equals(line[C_PREFCD])) {
            return false;
        }

        if (!nodeEki.getCityCd().equals(line[C_CITYCD])) {
            return false;
        }

        if (!nodeEki.getEkiAddress().equals(line[C_EKIADDRESS])) {
            return false;
        }

        if (!nodeEki.getLocationX().equals(line[C_LOCATIONX])) {
            return false;
        }

        if (!nodeEki.getLocationY().equals(line[C_LOCATIONY])) {
            return false;
        }

        if (!nodeEki.getDelKbn().equals(line[C_DELKBN])) {
            return false;
        }
        return true;
    }

    // ----- Beanデータ生成 --------------------
    /**
     * CSV行データから統一駅Beanを生成する内部メソッド。
     * @param line csv行データ
     * @param inServiceBean CSV取得したデータ
     * @param lineNumber CSVファイルの処理対象行番号
     * @return 生成されたNodeDomain
     */
    private NodeDomain arrayToNodeBean(String[] line, NodeUpdateCommitInServiceBean inServiceBean, String lineNumber) {
        NodeDomain node = new NodeDomain();

        node.setEkiNo(line[C_EKINO]);
        node.setEkiName(line[C_EKINAME]);
        node.setEkiKana(line[C_EKIKANA]);
        node.setPrefCd(line[C_PREFCD]);
        node.setCityCd(line[C_CITYCD]);
        node.setEkiAddress(line[C_EKIADDRESS]);
        node.setLocationX(line[C_LOCATIONX]);
        node.setLocationY(line[C_LOCATIONY]);
        node.setDelKbn(line[C_DELKBN]);
        node.setOperUserId(inServiceBean.getOperUserId());
        node.setPgName(inServiceBean.getPgName());
        node.setLineNumber(lineNumber);
        return node;
    }

    /**
     * 統一駅マスタのキャッシュを取得する内部メソッド。
     */
    private Map<String, NodeDomain> getNodeMasterCache(List<NodeDomain> nodeCodeList) {
        return nodeUpdateCommitDao.selectNodeMaster(nodeCodeList);
    }

    /**
     * 統一駅データが既に存在すれば更新、存在しなければ追加を行う内部メソッド。
     * @param node 沿線データ
     * @param nodeMasterCache 沿線マスタのキャッシュ
     */
    private void upsertNodeRecord(NodeDomain node, Map<String, NodeDomain> nodeMasterCache) {
        if (existsCodeForNodeMaster(node.getEkiNo(), nodeMasterCache)) {
            nodeUpdateCommitDao.nodeUpdate(node);
        } else {
            nodeUpdateCommitDao.nodeInsert(node);
        }
    }

    /**
     * 指定した沿線が沿線マスタにすでに存在するかどうかチェックする内部メソッド。
     * @param ekiNo 統一駅番号
     * @param nodeMasterCache 沿線マスタのキャッシュ
     * @return 沿線マスタに存在する: true, 存在しない: false
     */
    private boolean existsCodeForNodeMaster(String ekiNo, Map<String, NodeDomain> nodeMasterCache) {
        return nodeMasterCache.containsKey(ekiNo);
    }

    /**
     * Mapのキー文字列を生成する内部メソッド。
     * @param node 沿線データ
     * @return Map用キーコード
     */
    private String generateNodeKey(String node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node);
        return sb.toString();
    }
}
