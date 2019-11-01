/*
 * $Id: FudousanInfoView.java 3870 2008-03-12 09:39:50Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/29     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;
import net.chintai.backend.sysadmin.common.pager.PagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;

/**
 * 不動産会社詳細
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3870 $ 
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanInfoView extends PagerViewHelper {

    /** 不動産会社名 */
    private String fudousanName;

    /** 不動産会社コード */
    private String fudousanCd;

    /** 郵便番号（前3桁） */
    private String zipCode1;

    /** 郵便番号（後4桁） */
    private String zipCode2;

    /** 都道府県名 */
    private String prefName;

    /** 住所１ */
    private String address1;

    /** 住所２ */
    private String address2;

    /** 電話番号 */
    private String tel;

    /** FAX番号 */
    private String fax;

    /** 担当者名 */
    private String tantou;

    /** 登録日 */
    private String insDt;

    /** 更新日 */
    private String updDt;

    /** 現在位置 */
    private int offSet;

    /**
     * スーパークラスからのコンストラクター
     * @param condition
     */
    public FudousanInfoView(PagerCondition condition) {
        super(condition);
    }

    /** 取引先検索結果リスト */
    private List detailList;

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
     * FAX番号を取得します。
     * @return FAX番号
     */
    public String getFax() {
        return fax;
    }

    /**
     * FAX番号を設定します。
     * @param fax FAX番号
     */
    public void setFax(String fax) {
        this.fax = fax;
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
     * 登録日を取得します。
     * @return 登録日
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * 登録日を設定します。
     * @param insDt 登録日
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
    }

    /**
     * 担当者名を取得します。
     * @return 担当者名
     */
    public String getTantou() {
        return tantou;
    }

    /**
     * 担当者名を設定します。
     * @param tantou 担当者名
     */
    public void setTantou(String tantou) {
        this.tantou = tantou;
    }

    /**
     * 電話番号を取得します。
     * @return 電話番号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 電話番号を設定します。
     * @param tel 電話番号
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 更新日を取得します。
     * @return 更新日
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 更新日を設定します。
     * @param updDt 更新日
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
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
     * 郵便番号（前3桁）を取得します。
     * @return 郵便番号（前3桁）
     */
    public String getZipCode1() {
        return zipCode1;
    }

    /**
     * 郵便番号（前3桁）を設定します。
     * @param zipCode1 郵便番号（前3桁）
     */
    public void setZipCode1(String zipCode1) {
        this.zipCode1 = zipCode1;
    }

    /**
     * 郵便番号（後4桁）を取得します。
     * @return 郵便番号（後4桁）
     */
    public String getZipCode2() {
        return zipCode2;
    }

    /**
     * 郵便番号（後4桁）を設定します。
     * @param zipCode2 郵便番号（後4桁）
     */
    public void setZipCode2(String zipCode2) {
        this.zipCode2 = zipCode2;
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
     * 現在位置を取得します。
     * @return 現在位置
     */
    public int getOffSet() {
        return offSet;
    }

    /**
     * 現在位置を設定します。
     * @param offSet 現在位置
     */
    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

}
