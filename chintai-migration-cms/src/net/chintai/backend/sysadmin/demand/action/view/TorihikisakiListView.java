/*
 * $Id: TorihikisakiListView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;
import net.chintai.backend.sysadmin.common.pager.PagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;


/**
 * 取引先一覧画面用ビュー
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiListView extends PagerViewHelper {

    /** 店舗コード */
    private String shopCd;

    /** 担当支社コード */
    private String shisyaCd;

    /** 取引先コード1(不動産会社コード) */
    private String torihikisakiCd1;

    /** 取引先コード2(取引先コード) */
    private String torihikisakiCd2;

    /** 不動産会社名 */
    private String fudousanName;

    /** 取引先名 */
    private String torihikisakiName;

    /** 出力先 */
    private String outPut;

    /** 取引先検索結果リスト */
    private List detailList;

    /**
     * スーパークラスからのコンストラクター
     * @param condition
     */
    public TorihikisakiListView(PagerCondition condition) {
        super(condition);
    }

    // 検索結果格納用InnerClass
    public class TorihikisakiListDetailView implements ViewHelper {

        /** 取引先コード１(不動産会社コード) */
        private String torihikisakiCd1;

        /** 取引先コード２(取引先コード) */
        private String torihikisakiCd2;

        /** 不動産会社名 */
        private String fudousanName;

        /** 取引先名 */
        private String torihikisakiName;

        /** 地域名 */
        private String prefName;

        /** 住所１ */
        private String address1;

        /** 住所２ */
        private String address2;

        /** 取引先テーブルシーケンス */
        private String torihikisakiSeq;

        /** 取引先テーブル最終更新日時 */
        private String updDt;

        /**
         * 取引先コード１(不動産会社コード)を取得します。
         * @return 取引先コード１(不動産会社コード)
         */
        public String getTorihikisakiCd1() {
            return torihikisakiCd1;
        }

        /**
         * 取引先コード１(不動産会社コード)を設定します。
         * @param torihikisakiCd1 取引先コード１(不動産会社コード)
         */
        public void setTorihikisakiCd1(String torihikisakiCd1) {
            this.torihikisakiCd1 = torihikisakiCd1;
        }

        /**
         * 取引先コード２(取引先コード)を取得します。
         * @return 取引先コード２(取引先コード)
         */
        public String getTorihikisakiCd2() {
            return torihikisakiCd2;
        }

        /**
         * 取引先コード２(取引先コード)を設定します。
         * @param torihikisakiCd2 取引先コード２(取引先コード)
         */
        public void setTorihikisakiCd2(String torihikisakiCd2) {
            this.torihikisakiCd2 = torihikisakiCd2;
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
         * 取引先名を取得します。
         * @return 取引先名
         */
        public String getTorihikisakiName() {
            return torihikisakiName;
        }

        /**
         * 取引先名を設定します。
         * @param torihikisakiName 取引先名
         */
        public void setTorihikisakiName(String torihikisakiName) {
            this.torihikisakiName = torihikisakiName;
        }

        /**
         * 地域名を取得します。
         * @return 地域名
         */
        public String getPrefName() {
            return prefName;
        }

        /**
         * 地域名を設定します。
         * @param prefName 地域名
         */
        public void setPrefName(String prefName) {
            this.prefName = prefName;
        }

        /**
         * 住所１を取得します。
         * @return 住所１
         */
        public String getAddress1() {
            return address1;
        }

        /**
         * 住所１を設定します。
         * @param address1 住所１
         */
        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        /**
         * 住所２を取得します。
         * @return 住所２
         */
        public String getAddress2() {
            return address2;
        }

        /**
         * 住所２を設定します。
         * @param address2 住所２
         */
        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        /**
         * 取引先テーブルシーケンスを取得します。
         * @return 取引先テーブルシーケンス
         */
        public String getTorihikisakiSeq() {
            return torihikisakiSeq;
        }

        /**
         * 取引先テーブルシーケンスを設定します。
         * @param torihikisakiSeq 取引先テーブルシーケンス
         */
        public void setTorihikisakiSeq(String torihikisakiSeq) {
            this.torihikisakiSeq = torihikisakiSeq;
        }

        /**
         * 取引先テーブル最終更新日時を取得します。
         * @return 取引先テーブル最終更新日時
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * 取引先テーブル最終更新日時を設定します。
         * @param updDt 取引先テーブル最終更新日時
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }
    }

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd 店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 担当支社コードを取得します。
     * @return 担当支社コード
     */
    public String getShisyaCd() {
        return shisyaCd;
    }

    /**
     * 担当支社コードを設定します。
     * @param shisyaCd 担当支社コード
     */
    public void setShisyaCd(String shisyaCd) {
        this.shisyaCd = shisyaCd;
    }

    /**
     * 取引先コード1(不動産会社コード)を取得します。
     * @return 取引先コード1(不動産会社コード)
     */
    public String getTorihikisakiCd1() {
        return torihikisakiCd1;
    }

    /**
     * 取引先コード1(不動産会社コード)を設定します。
     * @param torihikisakiCd1 取引先コード1(不動産会社コード)
     */
    public void setTorihikisakiCd1(String torihikisakiCd1) {
        this.torihikisakiCd1 = torihikisakiCd1;
    }

    /**
     * 取引先コード2(取引先コード)を取得します。
     * @return 取引先コード2(取引先コード)
     */
    public String getTorihikisakiCd2() {
        return torihikisakiCd2;
    }

    /**
     * 取引先コード2(取引先コード)を設定します。
     * @param torihikisakiCd2 取引先コード2(取引先コード)
     */
    public void setTorihikisakiCd2(String torihikisakiCd2) {
        this.torihikisakiCd2 = torihikisakiCd2;
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
     * 取引先名を取得します。
     * @return 取引先名
     */
    public String getTorihikisakiName() {
        return torihikisakiName;
    }

    /**
     * 取引先名を設定します。
     * @param torihikisakiName 取引先名
     */
    public void setTorihikisakiName(String torihikisakiName) {
        this.torihikisakiName = torihikisakiName;
    }

    /**
     * 取引先検索結果リストを取得します。
     * @return 取引先検索結果リスト
     */
    public List getDetailList() {
        return detailList;
    }

    /**
     * 取引先検索結果リストを設定します。
     * @param detailList 取引先検索結果リスト
     */
    public void setDetailList(List detailList) {
        this.detailList = detailList;
    }

    /**
     * 出力先を取得します。
     * @return 出力先
     */
    public String getOutPut() {
        return outPut;
    }

    /**
     * 出力先を設定します。
     * @param outPut 出力先
     */
    public void setOutPut(String outPut) {
        this.outPut = outPut;
    }
}