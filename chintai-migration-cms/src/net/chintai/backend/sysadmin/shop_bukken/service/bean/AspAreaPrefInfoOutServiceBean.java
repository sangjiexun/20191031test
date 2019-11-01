/*
 * $Id: AspAreaPrefInfoOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)沈鍾沿       新規作成
 * 
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

import java.util.List;

/**
 * 不動産ASP設定で使用するエリアと都道府県用OutServiceBean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspAreaPrefInfoOutServiceBean {

    /** エリアコード */
    private String areaCd;

    /** エリア名 */
    private String areaName;

    /** 都道府県リスト */
    private List<AspAreaPrefInfoOutServiceDetailBean> prefList;

    /** エリア別都道府県の最大件数 */
    private List indexMaxCount;

    /**
     * エリア別都道府県の最大件数を取得します。
     * @return エリア別都道府県の最大件数
     */
    public List getIndexMaxCount() {
        return indexMaxCount;
    }

    /**
     * エリア別都道府県の最大件数を設定します。
     * @param indexMaxCount エリア別都道府県の最大件数
     */
    public void setIndexMaxCount(List indexMaxCount) {
        this.indexMaxCount = indexMaxCount;
    }

    /**
     * エリアコードを取得します。
     * @return エリアコード
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * エリアコードを設定します。
     * @param areaCd エリアコード
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    /**
     * エリア名を取得します。
     * @return エリア名
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * エリア名を設定します。
     * @param areaName エリア名
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 都道府県リストを取得します。
     * @return 都道府県リスト
     */
    public List<AspAreaPrefInfoOutServiceDetailBean> getPrefList() {
        return prefList;
    }

    /**
     * 都道府県リストを設定します。
     * @param prefList 都道府県リスト
     */
    public void setPrefList(List<AspAreaPrefInfoOutServiceDetailBean> prefList) {
        this.prefList = prefList;
    }

    public class AspAreaPrefInfoOutServiceDetailBean {

        /** 都道府県コード */
        private String prefCd;

        /** 都道府県名 */
        private String prefName;

        /** エリア都道府県のコード名 */
        private String prefCodeName;

        /** 入力されたソートキー */
        private String prefSortKey;

        /** 不動産ASP設定(エリア)情報の最終更新日付 */
        private String updDt;

        /**
         * 都道府県コードを取得します。
         * @return 都道府県コード
         */
        public String getPrefCd() {
            return prefCd;
        }

        /**
         * 都道府県コードを設定します。
         * @param prefCd 都道府県コード
         */
        public void setPrefCd(String prefCd) {
            this.prefCd = prefCd;
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
         * エリア都道府県のコード名を取得します。
         * @return エリア都道府県のコード名
         */
        public String getPrefCodeName() {
            return prefCodeName;
        }

        /**
         * エリア都道府県のコード名を設定します。
         * @param prefCodeName エリア都道府県のコード名
         */
        public void setPrefCodeName(String prefCodeName) {
            this.prefCodeName = prefCodeName;
        }

        /**
         * 入力されたソートキーを取得します。
         * @return 入力されたソートキー
         */
        public String getPrefSortKey() {
            return prefSortKey;
        }

        /**
         * 入力されたソートキーを設定します。
         * @param prefSortKey 入力されたソートキー
         */
        public void setPrefSortKey(String prefSortKey) {
            this.prefSortKey = prefSortKey;
        }

        /**
         * 不動産ASP設定(エリア)情報の最終更新日付を取得します。
         * @return 不動産ASP設定(エリア)情報の最終更新日付
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * 不動産ASP設定(エリア)情報の最終更新日付を設定します。
         * @param updDt 不動産ASP設定(エリア)情報の最終更新日付
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }

    }
}
