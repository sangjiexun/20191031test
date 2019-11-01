/*
 * $Id: FudousanSearchView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/21  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.PagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;

/**
 * 不動産会社検索
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanSearchView extends PagerViewHelper {

    /** 不動産会社コード */
    private String fudousanCd;

    /** 不動産会社名 */
    private String fudousanName;

    /** 検索結果リスト */
    private List<FudousanSearchDetailView> detailList;

    /**
     * スーパークラスからのコンストラクター
     * @param condition
     */
    public FudousanSearchView(PagerCondition condition) {
        super(condition);
    }

    public class FudousanSearchDetailView {

        /** 不動産会社コード */
        private String fudousanCd;

        /** 不動産会社名 */
        private String fudousanName;

        /** 都道府県名 */
        private String prefName;

        /** 住所1 */
        private String address1;

        /** 住所2 */
        private String address2;

        /** 削除可能フラグ */
        private String delFlg;

        /** 削除区分（チェック可否） */
        private String delKbn;
        
        /**
         * 不動産会社コードを取得します。
         * @return 不動産会社コード
         */
        public String getFudousanCd() {
            return fudousanCd;
        }

        /**
         * 不動産会社コードを設定します。
         * @param fudousanCd 不動産会社コード
         */
        public void setFudousanCd(String fudousanCd) {
            this.fudousanCd = fudousanCd;
        }

        /**
         * 不動産会社名を取得します。
         * @return 不動産会社名
         */
        public String getFudousanName() {
            return fudousanName;
        }

        /**
         * 不動産会社名を設定します。
         * @param fudousanName 不動産会社名
         */
        public void setFudousanName(String fudousanName) {
            this.fudousanName = fudousanName;
        }

        /**
         * 都道府県名を取得します。
         * @return 都道府県名
         */
        public String getPrefName() {
            return prefName;
        }

        /**
         * 都道府県名を設定します。
         * @param prefName 都道府県名
         */
        public void setPrefName(String prefName) {
            this.prefName = prefName;
        }

        /**
         * 住所1を取得します。
         * @return 住所1
         */
        public String getAddress1() {
            return address1;
        }

        /**
         * 住所1を設定します。
         * @param address1 住所1
         */
        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        /**
         * 住所2を取得します。
         * @return 住所2
         */
        public String getAddress2() {
            return address2;
        }

        /**
         * 住所2を設定します。
         * @param address2 住所2
         */
        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        /**
         * 削除可能フラグを取得します。
         * @return 削除可能フラグ
         */
        public String getDelFlg() {
            return delFlg;
        }

        /**
         * 削除可能フラグを設定します。
         * @param delFlg 削除可能フラグ
         */
        public void setDelFlg(String delFlg) {
            this.delFlg = delFlg;
        }

        
        /**
         * @return delKbn
         */
        public String getDelKbn() {
            return delKbn;
        }

        
        /**
         * @param delKbn 設定する delKbn
         */
        public void setDelKbn(String delKbn) {
            this.delKbn = delKbn;
        }
    }

    /**
     * 不動産会社コードを取得します。
     * @return 不動産会社コード
     */
    public String getFudousanCd() {
        return fudousanCd;
    }

    /**
     * 不動産会社コードを設定します。
     * @param fudousanCd 不動産会社コード
     */
    public void setFudousanCd(String fudousanCd) {
        this.fudousanCd = fudousanCd;
    }

    /**
     * 不動産会社名を取得します。
     * @return 不動産会社名
     */
    public String getFudousanName() {
        return fudousanName;
    }

    /**
     * 不動産会社名を設定します。
     * @param fudousanName 不動産会社名
     */
    public void setFudousanName(String fudousanName) {
        this.fudousanName = fudousanName;
    }

    /**
     * 検索結果リストを取得します。
     * @return 検索結果リスト
     */
    public List<FudousanSearchDetailView> getDetailList() {
        return detailList;
    }

    /**
     * 検索結果リストを設定します。
     * @param detailList 検索結果リスト
     */
    public void setDetailList(List<FudousanSearchDetailView> detailList) {
        this.detailList = detailList;
    }
}
