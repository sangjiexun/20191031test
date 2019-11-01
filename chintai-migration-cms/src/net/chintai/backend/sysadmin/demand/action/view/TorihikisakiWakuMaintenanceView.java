/*
 * $Id: TorihikisakiWakuMaintenanceView.java 4654 2013-10-09 08:13:01Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/09/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action.view;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;


/**
 * 物件枠数・物件リスティング枠数のCSVダウンロード・アップロード画面表示用View
 * @author KAMEDA Takuma
 * @version $Revision: 4654 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuMaintenanceView extends PagerViewHelper {

    /** 担当支社コード */
    private String shisyaCd;

    /** 取引先コード1(不動産会社コード) */
    private String torihikisakiCd1;

    /** 取引先コード2(取引先コード) */
    private String torihikisakiCd2;

    /** 不動産会社名 */
    private String fudousanName;

    /**
     * スーパークラスからのコンストラクター
     * @param condition
     */
    public TorihikisakiWakuMaintenanceView(BasePagerCondition condition) {
        super(condition);    }

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



}
