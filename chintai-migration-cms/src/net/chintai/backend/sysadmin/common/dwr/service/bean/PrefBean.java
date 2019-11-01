/*
 * $Id: PrefBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.service.bean;

/**
 * 店舗検索の地域・沿線から検索するときに使用する都道府県Bean
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefBean {

    /** 都道府県コード */
    private String prefCode;

    /** 都道府県名称 */
    private String prefName;

    /**
     * 都道府県BeanのConstructor
     * @param prefCode 都道府県コード
     * @param prefName 都道府県名称
     */
    public PrefBean(String prefCode, String prefName) {
        this.prefCode = prefCode;
        this.prefName = prefName;
    }

    /**
     * 都道府県コードを取得する。
     * @return prefCode 都道府県コード
     */
    public String getPrefCode() {
        return prefCode;
    }

    /**
     * 都道府県コードを設定する。
     * @param prefCode 都道府県コード
     */
    public void setPrefCode(String prefCode) {
        this.prefCode = prefCode;
    }

    /**
     * 都道府県名称を取得する。
     * @return prefName 都道府県名称
     */
    public String getPrefName() {
        return prefName;
    }

    /**
     * 都道府県名称を設定する。
     * @param prefName 都道府県名称
     */
    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }
}
