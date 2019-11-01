/*
 * $Id: TetudoGaishaSearchParamBean.java 4076 2008-11-19 09:33:13Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/10/08  BGT)長谷川正一 新規作成
 *
 */package net.chintai.backend.sysadmin.master.dao;

/**
 * 鉄道会社検索ParamBean
 * 
 * @author S.HASEGAWA
 * @version $Revision: 4076 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class TetudoGaishaSearchParamBean {

    /** 検索条件・鉄道会社番号 */
    private String railwaycoNo;

    /** 検索条件・鉄道会社名称 */
    private String railwaycoName;

    /** 検索条件・配布停止区分 */
    private int delKbn;

    /** ソートキー（表示検索用） */
    private String dispSortKey;

    /** 順序 */
    private String orderBy;

    /** 表示件数 */
    private String displayNum;

    /** 出力先 */
    private String outputMode;

    /**
     * 検索条件・鉄道会社番号を取得します。
     * @return 検索条件・鉄道会社番号
     */
    public String getRailwaycoNo() {
        return railwaycoNo;
    }

    /**
     * 検索条件・鉄道会社番号を設定します。
     * @param railwaycoNo 検索条件・鉄道会社番号
     */
    public void setRailwaycoNo(String railwaycoNo) {
        this.railwaycoNo = railwaycoNo;
    }

    /**
     * 検索条件・鉄道会社名称を取得します。
     * @return 検索条件・鉄道会社名称
     */
    public String getRailwaycoName() {
        return railwaycoName;
    }

    /**
     * 検索条件・鉄道会社名称を設定します。
     * @param railwaycoName 検索条件・鉄道会社名称
     */
    public void setRailwaycoName(String railwaycoName) {
        this.railwaycoName = railwaycoName;
    }

    /**
     * 検索条件・配布停止区分を取得します。
     * @return 検索条件・配布停止区分
     */
    public int getDelKbn() {
        return delKbn;
    }

    /**
     * 検索条件・配布停止区分を設定します。
     * @param delKbn 検索条件・配布停止区分
     */
    public void setDelKbn(int delKbn) {
        this.delKbn = delKbn;
    }

    /**
     * ソートキー（表示検索用）を取得します。
     * @return ソートキー（表示検索用）
     */
    public String getDispSortKey() {
        return dispSortKey;
    }

    /**
     * ソートキー（表示検索用）を設定します。
     * @param dispSortKey ソートキー（表示検索用）
     */
    public void setDispSortKey(String dispSortKey) {
        this.dispSortKey = dispSortKey;
    }

    /**
     * 順序を取得します。
     * @return 順序
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 順序を設定します。
     * @param orderBy 順序
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 表示件数を取得します。
     * @return 表示件数
     */
    public String getDisplayNum() {
        return displayNum;
    }

    /**
     * 表示件数を設定します。
     * @param displayNum 表示件数
     */
    public void setDisplayNum(String displayNum) {
        this.displayNum = displayNum;
    }

    /**
     * 出力先を取得します。
     * @return 出力先
     */
    public String getOutputMode() {
        return outputMode;
    }

    /**
     * 出力先を設定します。
     * @param outputMode 出力先
     */
    public void setOutputMode(String outputMode) {
        this.outputMode = outputMode;
    }
}
