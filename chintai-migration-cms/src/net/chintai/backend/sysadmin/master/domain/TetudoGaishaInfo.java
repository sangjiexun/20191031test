/*
 * $Id: TetudoGaishaInfo.java 4076 2008-11-19 09:33:13Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/10/08  BGT)長谷川正一 新規作成
 *
 */
package net.chintai.backend.sysadmin.master.domain;

/**
 * 鉄道会社照会Domain
 * 
 * @author S.HASEGAWA
 * @version $Revision: 4076 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class TetudoGaishaInfo {

    /** 鉄道会社番号 */
    private String railwaycoNo;

    /** 鉄道会社名称 */
    private String railwaycoName;

    /** 鉄道会社名称かな */
    private String railwaycoKana;

    /** 鉄道会社シーケンス（Webソートキー） */
    private String railwaycoSeq;

    /** 削除区分 */
    private int delKbn;

    /**
     * 鉄道会社番号を取得します。
     * @return 鉄道会社番号
     */
    public String getRailwaycoNo() {
        return railwaycoNo;
    }

    /**
     * 鉄道会社番号を設定します。
     * @param railwaycoNo 鉄道会社番号
     */
    public void setRailwaycoNo(String railwaycoNo) {
        this.railwaycoNo = railwaycoNo;
    }

    /**
     * 鉄道会社名称を取得します。
     * @return 鉄道会社名称
     */
    public String getRailwaycoName() {
        return railwaycoName;
    }

    /**
     * 鉄道会社名称を設定します。
     * @param railwaycoName 鉄道会社名称
     */
    public void setRailwaycoName(String railwaycoName) {
        this.railwaycoName = railwaycoName;
    }

    /**
     * 鉄道会社名称かなを取得します。
     * @return 鉄道会社名称かな
     */
    public String getRailwaycoKana() {
        return railwaycoKana;
    }

    /**
     * 鉄道会社名称かなを設定します。
     * @param railwaycoKana 鉄道会社名称かな
     */
    public void setRailwaycoKana(String railwaycoKana) {
        this.railwaycoKana = railwaycoKana;
    }

    /**
     * 鉄道会社シーケンス（Webソートキー）を取得します。
     * @return 鉄道会社シーケンス（Webソートキー）
     */
    public String getRailwaycoSeq() {
        return railwaycoSeq;
    }

    /**
     * 鉄道会社シーケンス（Webソートキー）を設定します。
     * @param railwaycoSeq 鉄道会社シーケンス（Webソートキー）
     */
    public void setRailwaycoSeq(String railwaycoSeq) {
        this.railwaycoSeq = railwaycoSeq;
    }

    /**
     * 削除区分を取得します。
     * @return 削除区分
     */
    public int getDelKbn() {
        return delKbn;
    }

    /**
     * 削除区分を設定します。
     * @param delKbn 削除区分
     */
    public void setDelKbn(int delKbn) {
        this.delKbn = delKbn;
    }
}
