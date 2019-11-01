/*
 * $Id: LicenseExpiredShopView.java 3861 2008-03-10 06:27:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/06     BGT)劉俊秀       新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 免許有効期限切れ店舗一覧View
 * @author yoo-junsu
 * @version $Revision: 3861 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LicenseExpiredShopView implements ViewHelper {

    /** 店舗一覧 */
    public List<ShopInner> shopList;

    /** 店舗件数 */
    public int count;

    public class ShopInner {

        /** 店舗コード */
        private String shopCd;

        /** 会社名 */
        private String company;

        /** 事務所名 */
        private String bumon;

        /** 店舗メールアドレス */
        private String email1;

        /** 店舗メールアドレス */
        private String email2;

        /** 店舗メールアドレス */
        private String email3;

        /** 店舗メールアドレス */
        private String email4;

        /** 店舗メールアドレス */
        private String email5;

        /** 代表者名 */
        private String licTrust;

        /** 代表Tel */
        private String tel;

        /** 代表Fax */
        private String fax;

        /** 承認 */
        private String certifyFlg;

        /** 状態 */
        private String shopStatus;

        /** CHINTAI掲載 */
        private String ctKeisaiFlg;

        /** エイブル掲載 */
        private String ablKeisaiFlg;

        /** データ元 */
        private String clientsystemType;

        /** 免許有効期限 */
        private String licValid;

        private String email;

        private String rendoName;

        /**
         * 事務所名を取得します。
         * @return 事務所名
         */
        public String getBumon() {
            return bumon;
        }

        /**
         * 事務所名を設定します。
         * @param bumon 事務所名
         */
        public void setBumon(String bumon) {
            this.bumon = bumon;
        }

        /**
         * 承認を取得します。
         * @return 承認
         */
        public String getCertifyFlg() {
            return certifyFlg;
        }

        /**
         * 承認を設定します。
         * @param certifyFlg 承認
         */
        public void setCertifyFlg(String certifyFlg) {
            this.certifyFlg = certifyFlg;
        }

        /**
         * データ元を取得します。
         * @return データ元
         */
        public String getClientsystemType() {
            return clientsystemType;
        }

        /**
         * データ元を設定します。
         * @param clientsystemType データ元
         */
        public void setClientsystemType(String clientsystemType) {
            this.clientsystemType = clientsystemType;
        }

        /**
         * 会社名を取得します。
         * @return 会社名
         */
        public String getCompany() {
            return company;
        }

        /**
         * 会社名を設定します。
         * @param company 会社名
         */
        public void setCompany(String company) {
            this.company = company;
        }

        /**
         * 代表者名を取得します。
         * @return 代表者名
         */
        public String getLicTrust() {
            return licTrust;
        }

        /**
         * 代表者名を設定します。
         * @param licTrust 代表者名
         */
        public void setLicTrust(String licTrust) {
            this.licTrust = licTrust;
        }

        /**
         * 免許有効期限を取得します。
         * @return 免許有効期限
         */
        public String getLicValid() {
            return licValid;
        }

        /**
         * 免許有効期限を設定します。
         * @param licValid 免許有効期限
         */
        public void setLicValid(String licValid) {
            this.licValid = licValid;
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
         * 代表Faxを取得します。
         * @return 代表Fax
         */
        public String getFax() {
            return fax;
        }

        /**
         * 代表Faxを設定します。
         * @param fax 代表Fax
         */
        public void setFax(String fax) {
            this.fax = fax;
        }

        /**
         * 状態を取得します。
         * @return 状態
         */
        public String getShopStatus() {
            return shopStatus;
        }

        /**
         * 状態を設定します。
         * @param shopStatus 状態
         */
        public void setShopStatus(String shopStatus) {
            this.shopStatus = shopStatus;
        }

        /**
         * 代表Telを取得します。
         * @return 代表Tel
         */
        public String getTel() {
            return tel;
        }

        /**
         * 代表Telを設定します。
         * @param tel 代表Tel
         */
        public void setTel(String tel) {
            this.tel = tel;
        }

		/**
		 * @return email1
		 */
		public String getEmail1() {
			return email1;
		}

		/**
		 * @param email1 セットする email1
		 */
		public void setEmail1(String email1) {
			this.email1 = email1;
		}

		/**
		 * @return email2
		 */
		public String getEmail2() {
			return email2;
		}

		/**
		 * @param email2 セットする email2
		 */
		public void setEmail2(String email2) {
			this.email2 = email2;
		}

		/**
		 * @return email3
		 */
		public String getEmail3() {
			return email3;
		}

		/**
		 * @param email3 セットする email3
		 */
		public void setEmail3(String email3) {
			this.email3 = email3;
		}

		/**
		 * @return email4
		 */
		public String getEmail4() {
			return email4;
		}

		/**
		 * @param email4 セットする email4
		 */
		public void setEmail4(String email4) {
			this.email4 = email4;
		}

		/**
		 * @return email5
		 */
		public String getEmail5() {
			return email5;
		}

		/**
		 * @param email5 セットする email5
		 */
		public void setEmail5(String email5) {
			this.email5 = email5;
		}

		/**
		 * @return ctKeisaiFlg
		 */
		public String getCtKeisaiFlg() {
			return ctKeisaiFlg;
		}

		/**
		 * @param ctKeisaiFlg セットする ctKeisaiFlg
		 */
		public void setCtKeisaiFlg(String ctKeisaiFlg) {
			this.ctKeisaiFlg = ctKeisaiFlg;
		}

		/**
		 * @return ablKeisaiFlg
		 */
		public String getAblKeisaiFlg() {
			return ablKeisaiFlg;
		}

		/**
		 * @param ablKeisaiFlg セットする ablKeisaiFlg
		 */
		public void setAblKeisaiFlg(String ablKeisaiFlg) {
			this.ablKeisaiFlg = ablKeisaiFlg;
		}

		/**
		 * @return email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email セットする email
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * @return rendoName
		 */
		public String getRendoName() {
			return rendoName;
		}

		/**
		 * @param rendoName セットする rendoName
		 */
		public void setRendoName(String rendoName) {
			this.rendoName = rendoName;
		}

    }

    /**
     * 店舗件数を取得します。
     * @return 店舗件数
     */
    public int getCount() {
        return count;
    }

    /**
     * 店舗件数を設定します。
     * @param count 店舗件数
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 店舗一覧を取得します。
     * @return 店舗一覧
     */
    public List<ShopInner> getShopList() {
        return shopList;
    }

    /**
     * 店舗一覧を設定します。
     * @param shopList 店舗一覧
     */
    public void setShopList(List<ShopInner> shopList) {
        this.shopList = shopList;
    }
}
