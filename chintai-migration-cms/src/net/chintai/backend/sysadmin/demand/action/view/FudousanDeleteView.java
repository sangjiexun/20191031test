/*
 * $Id: FudousanDeleteView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/04     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action.view;

import java.util.List;
import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 不動産会社削除確認Bean
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanDeleteView implements ViewHelper {

    /** 削除対象不動産会社リスト */
    private List<FudousanDeleteDetailView> fudousanDeleteList;

    public class FudousanDeleteDetailView {

        /** 不動産会社コード */
        private String fudousanCd;

        /** 不動産会社名 */
        private String fudousanName;

        /** 都道府県 */
        private String prefName;

        /** 住所1 */
        private String address1;

        /** 住所2 */
        private String address2;

        /** 更新日 */
        private String updDt;

        /**
         * @return address1
         */
        public String getAddress1() {
            return address1;
        }

        /**
         * @param address1 設定する address1
         */
        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        /**
         * @return address2
         */
        public String getAddress2() {
            return address2;
        }

        /**
         * @param address2 設定する address2
         */
        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        /**
         * @return fudousanCd
         */
        public String getFudousanCd() {
            return fudousanCd;
        }

        /**
         * @param fudousanCd 設定する fudousanCd
         */
        public void setFudousanCd(String fudousanCd) {
            this.fudousanCd = fudousanCd;
        }

        /**
         * @return fudousanName
         */
        public String getFudousanName() {
            return fudousanName;
        }

        /**
         * @param fudousanName 設定する fudousanName
         */
        public void setFudousanName(String fudousanName) {
            this.fudousanName = fudousanName;
        }

        /**
         * @return prefName
         */
        public String getPrefName() {
            return prefName;
        }

        /**
         * @param prefName 設定する prefName
         */
        public void setPrefName(String prefName) {
            this.prefName = prefName;
        }

        /**
         * @return updDt
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * @param updDt 設定する updDt
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }

    }

    
    /**
     * @return fudousanDeleteList
     */
    public List<FudousanDeleteDetailView> getFudousanDeleteList() {
        return fudousanDeleteList;
    }

    
    /**
     * @param fudousanDeleteList 設定する fudousanDeleteList
     */
    public void setFudousanDeleteList(List<FudousanDeleteDetailView> fudousanDeleteList) {
        this.fudousanDeleteList = fudousanDeleteList;
    }
}
