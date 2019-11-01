package net.chintai.backend.sysadmin.review.dao;


/**
 *  物件ステータス管理登録ParamBean
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenStatusAddParamBean {

    /** 物件履歴連番 */
    private Long pkBukkenRireki;

    /** 部屋キー */
    private String roomKey;

    /** 更新プログラム */
    private String updPg;

    /** 更新者ID */
    private String updId;

    /**
     * 物件履歴連番を返します。
     * @return 物件履歴連番
     */
    public Long getPkBukkenRireki() {
        return pkBukkenRireki;
    }

    /**
     * 物件履歴連番を設定します。
     * @param pkBukkenRireki  物件履歴連番
     */
    public void setPkBukkenRireki(Long pkBukkenRireki) {
        this.pkBukkenRireki = pkBukkenRireki;
    }

    /**
     * 部屋キーを返します。
     * @return 部屋キー
     */
    public String getRoomKey() {
        return roomKey;
    }

    /**
     * 部屋キーを設定します。
     * @param roomKey  部屋キー
     */
    public void setRoomKey(String roomKey) {
        this.roomKey = roomKey;
    }

    /**
     * 作成プログラムＩＤを返します。
     * @return 作成プログラムＩＤ
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 作成プログラムＩＤを設定します。
     * @param updPg  作成プログラムＩＤ
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

    /**
     * 更新者IDを返します。
     * @return 更新者ID
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * 更新者IDを設定します。
     * @param updId  更新者ID
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

}
