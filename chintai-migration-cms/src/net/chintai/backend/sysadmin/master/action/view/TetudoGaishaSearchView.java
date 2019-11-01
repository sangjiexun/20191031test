/*
 * $Id: TetudoGaishaSearchView.java 4076 2008-11-19 09:33:13Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/10/08  BGT)長谷川正一 新規作成
 *
 */
package net.chintai.backend.sysadmin.master.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.PagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;

/**
 * 鉄道会社検索結果Bean
 * 
 * @author S.HASEGAWA
 * @version $Revision: 4076 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class TetudoGaishaSearchView extends PagerViewHelper {

    public TetudoGaishaSearchView(PagerCondition condition) {
        super(condition);
    }

    /** 検索条件・鉄道会社番号 */
    private String railwaycoNo;

    /** 検索条件・鉄道会社名称 */
    private String railwaycoName;

    /** 検索条件・配布停止区分 */
    private String delKbn;

    /** ソートキー（表示検索用） */
    private String dispSortKey;

    /** 順序 */
    private String orderBy;

    /** 表示件数 */
    private String displayNum;

    /** 出力先 */
    private String outputMode;

    /** 鉄道会社検索結果リスト */
    private List<TetudoGaishaSearchDetailView> tetudoGaishaSearchList;

    /**
     * 沿線検索結果リストを設定します。
     * @param rosenSearchList 沿線検索結果リスト
     */
    public void setTetudoGaishaSearchList(List<TetudoGaishaSearchDetailView> tetudoGaishaSearchList) {
        this.tetudoGaishaSearchList = tetudoGaishaSearchList;
    }

    /**
     * 鉄道会社検索結果リストを取得します。
     * @return 鉄道会社結果リスト
     */
    public List<TetudoGaishaSearchDetailView> getTetudoGaishaSearchList() {
        return tetudoGaishaSearchList;
    }

    /**
     * 鉄道会社検索結果Bean
     * 
     * @author S.HASEGAWA
     */
    public class TetudoGaishaSearchDetailView {

        /** 鉄道会社番号 */
        private String railwaycoNo;

        /** 鉄道会社名称 */
        private String railwaycoName;

        /** 鉄道会社名称かな */
        private String railwaycoKana;

        /** 鉄道会社シーケンス（Webソートキー） */
        private String railwaycoSeq;

        /** 削除区分 */
        private int delKbn;

        /**
         * 鉄道会社番号を取得します。
         * @return 鉄道会社番号
         */
        public String getRailwaycoNo() {
            return railwaycoNo;
        }

        /**
         * 鉄道会社番号を設定します。
         * @param railwaycoNo 鉄道会社番号
         */
        public void setRailwaycoNo(String railwaycoNo) {
            this.railwaycoNo = railwaycoNo;
        }

        /**
         * 鉄道会社名称を取得します。
         * @return 鉄道会社名称
         */
        public String getRailwaycoName() {
            return railwaycoName;
        }

        /**
         * 鉄道会社名称を設定します。
         * @param railwaycoName 鉄道会社名称
         */
        public void setRailwaycoName(String railwaycoName) {
            this.railwaycoName = railwaycoName;
        }

        /**
         * 鉄道会社名称かなを取得します。
         * @return 鉄道会社名称かな
         */
        public String getRailwaycoKana() {
            return railwaycoKana;
        }

        /**
         * 鉄道会社名称かなを設定します。
         * @param railwaycoKana 鉄道会社名称かな
         */
        public void setRailwaycoKana(String railwaycoKana) {
            this.railwaycoKana = railwaycoKana;
        }

        /**
         * 鉄道会社シーケンス（Webソートキー）を取得します。
         * @return 鉄道会社シーケンス（Webソートキー）
         */
        public String getRailwaycoSeq() {
            return railwaycoSeq;
        }

        /**
         * 鉄道会社シーケンス（Webソートキー）を設定します。
         * @param railwaycoSeq 鉄道会社シーケンス（Webソートキー）
         */
        public void setRailwaycoSeq(String railwaycoSeq) {
            this.railwaycoSeq = railwaycoSeq;
        }

        /**
         * 削除区分を取得します。
         * @return 削除区分
         */
        public int getDelKbn() {
            return delKbn;
        }

        /**
         * 削除区分を設定します。
         * @param delKbn 削除区分
         */
        public void setDelKbn(int delKbn) {
            this.delKbn = delKbn;
        }

    }

    /**
     * 検索条件・鉄道会社番号を取得します。
     * @return 検索条件・鉄道会社番号
     */
    public String getRailwaycoNo() {
        return railwaycoNo;
    }

    /**
     * 検索条件・鉄道会社番号を設定します。
     * @param railwaycoNo 検索条件・鉄道会社番号
     */
    public void setRailwaycoNo(String railwaycoNo) {
        this.railwaycoNo = railwaycoNo;
    }

    /**
     * 検索条件・鉄道会社名称を取得します。
     * @return 検索条件・鉄道会社名称
     */
    public String getRailwaycoName() {
        return railwaycoName;
    }

    /**
     * 検索条件・鉄道会社名称を設定します。
     * @param railwaycoName 検索条件・鉄道会社名称
     */
    public void setRailwaycoName(String railwaycoName) {
        this.railwaycoName = railwaycoName;
    }

    /**
     * 検索条件・配布停止区分を取得します。
     * @return 検索条件・配布停止区分
     */
    public String getDelKbn() {
        return delKbn;
    }

    /**
     * 検索条件・配布停止区分を設定します。
     * @param delKbn 検索条件・配布停止区分
     */
    public void setDelKbn(String delKbn) {
        this.delKbn = delKbn;
    }

    /**
     * ソートキー（表示検索用）を取得します。
     * @return ソートキー（表示検索用）
     */
    public String getDispSortKey() {
        return dispSortKey;
    }

    /**
     * ソートキー（表示検索用）を設定します。
     * @param dispSortKey ソートキー（表示検索用）
     */
    public void setDispSortKey(String dispSortKey) {
        this.dispSortKey = dispSortKey;
    }

    /**
     * 順序を取得します。
     * @return 順序
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 順序を設定します。
     * @param orderBy 順序
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 表示件数を取得します。
     * @return 表示件数
     */
    public String getDisplayNum() {
        return displayNum;
    }

    /**
     * 表示件数を設定します。
     * @param displayNum 表示件数
     */
    public void setDisplayNum(String displayNum) {
        this.displayNum = displayNum;
    }

    /**
     * 出力先を取得します。
     * @return 出力先
     */
    public String getOutputMode() {
        return outputMode;
    }

    /**
     * 出力先を設定します。
     * @param outputMode 出力先
     */
    public void setOutputMode(String outputMode) {
        this.outputMode = outputMode;
    }
}
