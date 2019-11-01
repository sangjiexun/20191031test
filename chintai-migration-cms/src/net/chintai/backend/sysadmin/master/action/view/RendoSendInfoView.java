package net.chintai.backend.sysadmin.master.action.view;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 連動元出稿管理リスト
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RendoSendInfoView implements ViewHelper {
    /** 連動元コード */
    private String rendoCd;

    /** 連動元名称 */
    private String rendoName;

    /** 連動会社名 */
    private String rendoCompany;

    /** 契約管理コード */
    private String keiyakuCd;

    /** 契約管理オプションコード */
    private String keiyakuSubCd;

    /** 契約名称 */
    private String keiyakuName;

    /** 連動元出稿情報 */
    private List<RendoSendInfo> rendoSendDetailList;

    /**
     * 連動元コードを取得します。
     * @return 連動元コード
     */
    public String getRendoCd() {
        return rendoCd;
    }

    /**
     * 連動元コードを設定します。
     * @param rendoCd 連動元コード
     */
    public void setRendoCd(String rendoCd) {
        this.rendoCd = rendoCd;
    }

    /**
     * 連動元名称を取得します。
     * @return 連動元名称
     */
    public String getRendoName() {
        return rendoName;
    }

    /**
     * 連動元名称を設定します。
     * @param rendoName 連動元名称
     */
    public void setRendoName(String rendoName) {
        this.rendoName = rendoName;
    }

    /**
     * 連動会社名を取得します。
     * @return 連動会社名
     */
    public String getRendoCompany() {
        return rendoCompany;
    }

    /**
     * 連動会社名を設定します。
     * @param rendoCompany 連動会社名
     */
    public void setRendoCompany(String rendoCompany) {
        this.rendoCompany = rendoCompany;
    }

    /**
     * 契約管理コードを取得します。
     * @return 契約管理コード
     */
    public String getKeiyakuCd() {
        return keiyakuCd;
    }

    /**
     * 契約管理コードを設定します。
     * @param keiyakuCd 契約管理コード
     */
    public void setKeiyakuCd(String keiyakuCd) {
        this.keiyakuCd = keiyakuCd;
    }

    /**
     * 契約管理オプションコードを取得します。
     * @return 契約管理オプションコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     * 契約管理オプションコードを設定します。
     * @param keiyakuSubCd 契約管理オプションコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }

    /**
     * 契約名称を取得します。
     * @return 契約名称
     */
    public String getKeiyakuName() {
        return keiyakuName;
    }

    /**
     * 契約名称を設定します。
     * @param keiyakuName 契約名称
     */
    public void setKeiyakuName(String keiyakuName) {
        this.keiyakuName = keiyakuName;
    }

    /**
     * 連動元出稿情報を取得します。
     * @return 連動元出稿情報
     */
    public List<RendoSendInfo> getRendoSendDetailList() {
        return rendoSendDetailList;
    }

    /**
     * 連動元出稿情報を設定します。
     * @param rendoSendDetailList 連動元出稿情報
     */
    public void setRendoSendDetailList(List<RendoSendInfo> rendoSendDetailList) {
        this.rendoSendDetailList = rendoSendDetailList;
    }

    /**
     * 連動元出稿情報を設定します。
     * @param rendoSend 連動元出稿情報
     */
    public void setRendoSendDetailList(RendoSendInfo rendoSendInfo) {
    	if (this.rendoSendDetailList == null) {
    		this.rendoSendDetailList = new ArrayList<RendoSendInfo>();
    	}
    	this.rendoSendDetailList.add(rendoSendInfo);
    }


    // 連動元出稿情報格納用InnerClass
    public class RendoSendInfo {

        /** 契約番号 */
        private Long rendoSendNo;

        /** 出稿許可開始日時 */
        private String permitStartDt;

        /** 出稿許可終了日時 */
        private String permitEndDt;

        /** 出稿許可開始日時表示用 */
        private String permitStartYmForDisplay;

        /** 出稿許可終了日時表示用 */
        private String permitEndYmForDisplay;

        /** 備考 */
        private String note;

        /** 更新日時 */
        private String updDt;

        /** 適用フラグ */
        private String appliedFlg;

        /** 削除可能判断フラグ */
        private String delFlg;

        /** リンク表示フラグ */
        private String linkFlg;

        /** 画面戻り先の削除チェック*/
        private String checkFlg;

        /**
         * 契約番号を返します。
         * @return rendoSendNo
         */
        public Long getRendoSendNo() {
            return rendoSendNo;
        }

        /**
         * 契約番号を設定します。
         * @param rendoSendNo  契約番号
         */
        public void setRendoSendNo(Long rendoSendNo) {
            this.rendoSendNo = rendoSendNo;
        }

        /**
         * 出稿許可開始日時を返します。
         * @return 出稿許可開始日時
         */
        public String getPermitStartDt() {
            return permitStartDt;
        }

        /**
         * 出稿許可開始日時を設定します。
         * @param permitStartDt  出稿許可開始日時
         */
        public void setPermitStartDt(String permitStartDt) {
            this.permitStartDt = permitStartDt;
        }

        /**
         * 出稿許可終了日時を返します。
         * @return 出稿許可終了日時
         */
        public String getPermitEndDt() {
            return permitEndDt;
        }

        /**
         * 出稿許可終了日時を設定します。
         * @param permitEndDt  permitEndDt
         */
        public void setPermitEndDt(String permitEndDt) {
            this.permitEndDt = permitEndDt;
        }

        /**
         * 出稿許可開始日時表示用を返します。
         * @return 出稿許可開始日時表示用
         */
        public String getPermitStartYmForDisplay() {
            return permitStartYmForDisplay;
        }

        /**
         * 出稿許可開始日時表示用を設定します。
         * @param permitStartYmForDisplay  出稿許可開始日時表示用
         */
        public void setPermitStartYmForDisplay(String permitStartYmForDisplay) {
            this.permitStartYmForDisplay = permitStartYmForDisplay;
        }

        /**
         * 出稿許可終了日時表示用を返します。
         * @return 出稿許可終了日時表示用
         */
        public String getPermitEndYmForDisplay() {
            return permitEndYmForDisplay;
        }

        /**
         * 出稿許可終了日時表示用を設定します。
         * @param permitEndYmForDisplay  出稿許可終了日時表示用
         */
        public void setPermitEndYmForDisplay(String permitEndYmForDisplay) {
            this.permitEndYmForDisplay = permitEndYmForDisplay;
        }

        /**
         * 備考を返します。
         * @return 備考
         */
        public String getNote() {
            return note;
        }

        /**
         * 備考を設定します。
         * @param note  備考
         */
        public void setNote(String note) {
            this.note = note;
        }

        /**
         * 最終更新日を取得します。
         * @return 最終更新日
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * 最終更新日を設定します。
         * @param updDt 最終更新日
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }

        /**
         * 適用月フラグを取得します。
         * @return 適用月フラグ
         */
        public String getAppliedFlg() {
            return appliedFlg;
        }

        /**
         * 適用月フラグを設定します。
         * @param appliedFlg 適用月フラグ
         */
        public void setAppliedFlg(String appliedFlg) {
            this.appliedFlg = appliedFlg;
        }

        /**
         * 削除可能判断フラグを取得します。
         * @return 削除可能判断フラグ
         */
        public String getDelFlg() {
            return delFlg;
        }

        /**
         * 削除可能判断フラグを設定します。
         * @param delFlg 削除可能判断フラグ
         */
        public void setDelFlg(String delFlg) {
            this.delFlg = delFlg;
        }

        /**
         * リンク表示フラグを取得します。
         * @return リンク表示フラグ
         */
        public String getLinkFlg() {
            return linkFlg;
        }

        /**
         * リンク表示フラグを設定します。
         * @param linkFlg リンク表示フラグ
         */
        public void setLinkFlg(String linkFlg) {
            this.linkFlg = linkFlg;
        }

        /**
         * 画面戻り先の削除フラグを返します。
         * @return 画面戻り先の削除フラグ
         */
        public String getCheckFlg() {
            return checkFlg;
        }

        /**
         * 画面戻り先の削除フラグを設定します。
         * @param checkFlg  画面戻り先の削除フラグ
         */
        public void setCheckFlg(String checkFlg) {
            this.checkFlg = checkFlg;
        }
    }
}
