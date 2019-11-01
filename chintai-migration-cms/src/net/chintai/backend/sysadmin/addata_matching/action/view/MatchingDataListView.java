/*
 * $Id: MatchingDataListView.java 4367 2009-09-01 05:37:54Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/26     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;
import net.chintai.backend.sysadmin.common.pager.PagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;

/**
 * 照合結果一覧ページ用ViewHelper
 * @author e-ishii
 * @version $Revision: 4367 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MatchingDataListView extends PagerViewHelper {

    /** 照合結果リスト */
    private List<MatchingDataListDetailView> matchingDataList;

    /**
     * コンストラクタ
     */
    public MatchingDataListView(PagerCondition condition) {
        super(condition);
    }

    /**
     * 照合結果リストを取得します。
     * @return 照合結果リスト
     */
    public List<MatchingDataListDetailView> getMatchingDataList() {
        return matchingDataList;
    }

    /**
     * 照合結果リストを設定します。
     * @param matchingDataList 照合結果リスト
     */
    public void setMatchingDataList(List<MatchingDataListDetailView> matchingDataList) {
        this.matchingDataList = matchingDataList;
    }

    /**
     * 一覧リスト格納用innerClass
     */
    public class MatchingDataListDetailView implements ViewHelper{

        /** 対象年月 */
        private String taisyoYm;

        /** 処理日 */
        private String insDt;

        /**
         * 対象年月を取得します。
         * @return 対象年月
         */
        public String getTaisyoYm() {
            return taisyoYm;
        }

        /**
         * 対象年月を設定します。
         * @param taisyoYm 対象年月
         */
        public void setTaisyoYm(String taisyoYm) {
            this.taisyoYm = taisyoYm;
        }

        /**
         * 処理日を取得します。
         * @return 処理日
         */
        public String getInsDt() {
            return insDt;
        }

        /**
         * 処理日を設定します。
         * @param insDt 処理日
         */
        public void setInsDt(String insDt) {
            this.insDt = insDt;
        }

    }
}
