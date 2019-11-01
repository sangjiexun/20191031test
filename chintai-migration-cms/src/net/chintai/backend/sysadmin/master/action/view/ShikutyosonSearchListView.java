/*
 * $Id: ShikutyosonSearchListView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.master.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 市区町村検索結果Bean
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonSearchListView implements ViewHelper {

    /** 市区町村リスト */
    private List<ShikutyosonListDetailView> shikutyosonList;

    /**
     * 市区町村リストを取得します。
     * @return 市区町村リスト
     */
    public List<ShikutyosonListDetailView> getShikutyosonList() {
        return shikutyosonList;
    }

    /**
     * 市区町村リストを設定します。
     * @param shikutyosonList 市区町村リスト
     */
    public void setShikutyosonList(List<ShikutyosonListDetailView> shikutyosonList) {
        this.shikutyosonList = shikutyosonList;
    }

    /**
     * 市区町村検索結果リストDetail
     *
     * @author Yang-EunMi
     */
    public class ShikutyosonListDetailView {

        /** ソート番号 */
        private String sortNo;

        /** 郵便番号 */
        private String zipCd;

        /** 都道府県 */
        private String prefName;

        /** 市区町村 */
        private String cityName;

        /** 町域 */
        private String machiikiName;

        /** 都道府県コード */
        private String prefcd;

        /** 市区町村コード */
        private String citycd;

        /**
         * ソート番号を取得します。
         * @return ソート番号
         */
        public String getSortNo() {
            return sortNo;
        }

        /**
         * ソート番号を設定します。
         * @param sortNo ソート番号
         */
        public void setSortNo(String sortNo) {
            this.sortNo = sortNo;
        }

        /**
         * 郵便番号を取得します。
         * @return 郵便番号
         */
        public String getZipCd() {
            return zipCd;
        }

        /**
         * 郵便番号を設定します。
         * @param zipCd 郵便番号
         */
        public void setZipCd(String zipCd) {
            this.zipCd = zipCd;
        }

        /**
         * 都道府県を取得します。
         * @return 都道府県
         */
        public String getPrefName() {
            return prefName;
        }

        /**
         * 都道府県を設定します。
         * @param prefName 都道府県
         */
        public void setPrefName(String prefName) {
            this.prefName = prefName;
        }

        /**
         * 市区町村を取得します。
         * @return 市区町村
         */
        public String getCityName() {
            return cityName;
        }

        /**
         * 市区町村を設定します。
         * @param cityName 市区町村
         */
        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        /**
         * 町域を取得します。
         * @return 町域
         */
        public String getMachiikiName() {
            return machiikiName;
        }

        /**
         * 町域を設定します。
         * @param machiikiName 町域
         */
        public void setMachiikiName(String machiikiName) {
            this.machiikiName = machiikiName;
        }

		/**
		 * @return prefcd
		 */
		public String getPrefcd() {
			return prefcd;
		}

		/**
		 * @param prefcd セットする prefcd
		 */
		public void setPrefcd(String prefcd) {
			this.prefcd = prefcd;
		}

		/**
		 * @return citycd
		 */
		public String getCitycd() {
			return citycd;
		}

		/**
		 * @param citycd セットする citycd
		 */
		public void setCitycd(String citycd) {
			this.citycd = citycd;
		}
    }
}
