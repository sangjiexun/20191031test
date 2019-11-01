/*
 * $Id: SideBarContext.java 3747 2008-01-10 12:45:23Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/25   BGT)児島      新規作成
 * 2008/01/10   BGT)児島      ステージング環境での表示に対応
 */
package net.chintai.backend.sysadmin.common.velocity;

import java.io.Serializable;
import java.util.List;

/**
 * サイドバー構築のための情報を管理するコンテキストクラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3747 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class SideBarContext implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -6108776120211063101L;

    /** 権限リスト */
    private List<String> authList;

    /** CHINTAI問い合せ管理表示制御 */
    private String cjnAccountType;

    /** コンテキストパス */
    private String contextPath;

    /** 暗号化済ユーザID */
    private String encryptedUserId;

    /** 暗号化済日付 */
    private String encryptedDate;

    /** 暗号化済Webログユーザフラグ */
    private String encryptedWeblogUserFlag;

    /** ベースURL(広告-Web統合間の遷移で利用) */
    private String baseUrl;

    /** ログ解析APサーバURL */
    private String logapUrl;

    private String weblogUrl;

    private String loginKey;


    /**
     * コンストラクタ
     */
    public SideBarContext() {
    }

    /**
     * コンストラクタ
     * @param authorityList 権限リスト
     */
    public SideBarContext(List<String> authorityList) {
        this.authList = authorityList;
    }

    /**
     * 指定された権限IDが許可されているかどうか判定します。
     * @param authorityId 権限ID
     * @return 許可されている場合 true, 許可されていない場合 false
     */
    public boolean isAuthorized(String authorityId) {
        return authList.contains(authorityId);
    }

    /**
     * 権限リストを取得します。
     * @return 権限リスト
     */
    public List<String> getAuthList() {
        return authList;
    }

    /**
     * 権限リストを設定します。
     * @param authList 権限リスト
     */
    public void setAuthList(List<String> authList) {
        this.authList = authList;
    }

    /**
     * CHINTAI問い合せ管理表示制御を取得します。
     * @return CHINTAI問い合せ管理表示制御
     */
    public String getCjnAccountType() {
        return cjnAccountType;
    }

    /**
     * CHINTAI問い合せ管理表示制御を設定します。
     * @param cjnAccountType CHINTAI問い合せ管理表示制御
     */
    public void setCjnAccountType(String cjnAccountType) {
        this.cjnAccountType = cjnAccountType;
    }

    /**
     * コンテキストパスを取得します。
     * @return コンテキストパス
     */
    public String getContextPath() {
        return contextPath;
    }

    /**
     * コンテキストパスを設定します。
     * @param contextPath コンテキストパス
     */
    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
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
    public String getEncryptedDate() {
        return encryptedDate;
    }

    /**
     * 暗号化済日付を設定します。
     * @param encryptedDate 暗号化済日付
     */
    public void setEncryptedDate(String encryptedDate) {
        this.encryptedDate = encryptedDate;
    }

    /**
     * 暗号化済Webログユーザフラグを取得します。
     * @return 暗号化済Webログユーザフラグ
     */
    public String getEncryptedWeblogUserFlag() {
        return encryptedWeblogUserFlag;
    }

    /**
     * 暗号化済Webログユーザフラグを設定します。
     * @param encryptedWeblogUserFlag 暗号化済Webログユーザフラグ
     */
    public void setEncryptedWeblogUserFlag(String encryptedWeblogUserFlag) {
        this.encryptedWeblogUserFlag = encryptedWeblogUserFlag;
    }

    /**
     * ベースURL(広告-Web統合間の遷移で利用)を取得します。
     * @return ベースURL(広告-Web統合間の遷移で利用)
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * ベースURL(広告-Web統合間の遷移で利用)を設定します。
     * @param baseUrl ベースURL(広告-Web統合間の遷移で利用)
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * ログ解析APサーバURLを取得します。
     * @return ログ解析APサーバURL
     */
    public String getLogapUrl() {
        return logapUrl;
    }

    /**
     * ログ解析APサーバURLを設定します。
     * @param logapUrl ログ解析APサーバURL
     */
    public void setLogapUrl(String logapUrl) {
        this.logapUrl = logapUrl;
    }

	public String getWeblogUrl() {
		return weblogUrl;
	}

	public void setWeblogUrl(String weblogUrl) {
		this.weblogUrl = weblogUrl;
	}

	public String getLoginKey() {
		return loginKey;
	}

	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
	}
}
