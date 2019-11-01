/*
 * $Id: SessionBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/19  BGT)児島   新規作成
 *
 */
package net.chintai.backend.sysadmin.common.session;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import net.chintai.backend.sysadmin.common.util.CryptUtil;
import net.chintai.backend.sysadmin.common.util.DateUtil;

/**
 * セッション情報を保持するクラスです。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class SessionBean implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 3449540406646503373L;

    /** URLエンコーディングキャラクタ */
    private static final String C_URL_ENCODING = "UTF-8";

    /** ユーザID */
    private String userId;

    /** ユーザ名 */
    private String userName;

    /** 暗号化済ユーザID */
    private String encryptedUserId;

    /** 暗号化済日付 */
    private String encryptedToday;

    /** URLエンコード済コンテキストパス(UTF-8) */
    private String encodedContextPath;

    /** 検索条件Map */
    private Map<String, SessionSearchCondition> searchConditionMap;

    /** セッションテーブルの一意のキー */
    private Long sidId;

    /** WEBLOGリンクを作成するログインキー */
    private String loginKey;

    /**
     * コンストラクタ。<br>
     * SessionBeanManager から呼び出されることを想定しています。
     */
    protected SessionBean() {
    }

    /**
     * セッションビーンを初期化します。
     * @param userId ユーザID
     * @param userName ユーザ名
     * @param contextPath コンテキストパス
     */
    public void init(String userId, String userName, String contextPath, Long sidId,String loginKey) {
        setUserId(userId);
        setUserName(userName);

        if (searchConditionMap == null) {
            searchConditionMap = new HashMap<String, SessionSearchCondition>();
        }

        try {
            setEncryptedUserId(URLEncoder.encode(CryptUtil.blowfishEncrypt(userId), C_URL_ENCODING));
            setEncryptedToday(URLEncoder.encode(CryptUtil.blowfishEncrypt(DateUtil.getToday()), C_URL_ENCODING));
            setEncodedContextPath(URLEncoder.encode(contextPath, C_URL_ENCODING));
            setSidId(sidId);
            setLoginKey(loginKey);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定します。
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ユーザ名を取得します。
     * @return ユーザ名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザ名を設定します。
     * @param userName ユーザ名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 暗号化済ユーザIDを取得します。
     * @return 暗号化済ユーザID
     */
    public String getEncryptedUserId() {
        return encryptedUserId;
    }

    /**
     * 暗号化済ユーザIDを設定します。
     * @param encryptedUserId 暗号化済ユーザID
     */
    public void setEncryptedUserId(String encryptedUserId) {
        this.encryptedUserId = encryptedUserId;
    }

    /**
     * 暗号化済日付を取得します。
     * @return 暗号化済日付
     */
    public String getEncryptedToday() {
        return encryptedToday;
    }

    /**
     * 暗号化済日付を設定します。
     * @param encryptedToday 暗号化済日付
     */
    public void setEncryptedToday(String encryptedToday) {
        this.encryptedToday = encryptedToday;
    }

    /**
     * URLエンコード済コンテキストパス(UTF-8)を取得します。
     * @return URLエンコード済コンテキストパス(UTF-8)
     */
    public String getEncodedContextPath() {
        return encodedContextPath;
    }

    /**
     * URLエンコード済コンテキストパス(UTF-8)を設定します。
     * @param encodedContextPath URLエンコード済コンテキストパス(UTF-8)
     */
    public void setEncodedContextPath(String encodedContextPath) {
        this.encodedContextPath = encodedContextPath;
    }

    /**
     * 検索条件Mapを取得します。
     * @return 検索条件Map
     */
    public Map<String, SessionSearchCondition> getSearchConditionMap() {
        return searchConditionMap;
    }

    /**
     * 検索条件Mapを設定します。
     * @param searchConditionMap 検索条件Map
     */
    public void setSearchConditionMap(Map<String, SessionSearchCondition> searchConditionMap) {
        this.searchConditionMap = searchConditionMap;
    }

    /**
     * セッションテーブルの一意のキーを返します。
     * @return セッションテーブルの一意のキー
     */
    public Long getSidId() {
        return sidId;
    }

    /**
     * セッションテーブルの一意のキーを設定します。
     * @param sidId  セッションテーブルの一意のキー
     */
    public void setSidId(Long sidId) {
        this.sidId = sidId;
    }

    /**
     * WEBLOGリンクを作成するログインキーを返します。
     * @return WEBLOGリンクを作成するログインキー
     */
    public String getLoginKey() {
        return loginKey;
    }

    /**
     * WEBLOGリンクを作成するログインキーを設定します。
     * @param loginKey  WEBLOGリンクを作成するログインキー
     */
    public void setLoginKey(String loginKey) {
        this.loginKey = loginKey;
    }


}
