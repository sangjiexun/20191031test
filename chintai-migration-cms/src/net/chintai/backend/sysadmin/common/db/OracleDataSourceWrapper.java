/*
 * $Id: OracleDataSourceWrapper.java 3898 2008-05-13 09:18:33Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2008/05/13   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.db;

import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

import oracle.jdbc.pool.OracleDataSource;

/**
 * {@link OracleDataSource} のラッパークラス。<br>
 * 無効なコネクションキャッシュを拾った際に、最大 maxLimit 回までリトライする。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3898 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class OracleDataSourceWrapper implements DataSource, Serializable, InitializingBean {

    /** serialVersionUID */
    private static final long serialVersionUID = 3231986188041093448L;

    /**
     * キャッシュの失効を検出するためのエラーメッセージ。<br>
     * <strong>注意</strong> JDBCドライバのバージョンが上がると、対応するメッセージが変わってしまうかもしれません。
     * Oracleはエラーメッセージに対して何ら保証をしていないと思います。注意して下さい。
     * 検証した環境 : ojdbc14.jar (Thin) / Oracle 10g R2
     */
    private static final String RETRY_MESSAGE = "無効または失効している接続が接続キャッシュ内に見つかりました";

    /** Logger */
    private static Log log = LogFactory.getLog(OracleDataSourceWrapper.class);


    //----- インスタンス変数 -----

    /** ラップする OracleDataSource */
    private OracleDataSource ds = new OracleDataSource();

    /** リトライ回数上限 */
    private int maxLimit;

    /**
     * コンストラクター
     * @throws SQLException OracleDataSource の生成で問題が発生した場合にスローされます。
     */
    public OracleDataSourceWrapper() throws SQLException {
        if (log.isInfoEnabled()) {
            log.info("OracleDataSource の代わりに OracleDataSourceWrrapper を使用します");
        }
    }

    /*
     * (非 Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception {
        // コンストラクターで実行すると、MaxLimit などのプロパティがセットされていない可能性があり
        // タイミング的に危ないので、念のため afterPropertiesSet() のタイミングで実行するようにしておく
        this.maxLimit = getMaxLimit();
    }

    /**
     * キャッシュ失効時のリトライ回数の上限を求めます。
     * @return リトライ回数の上限。リトライしない場合は -1 を戻します。
     */
    private int getMaxLimit() {
        try {
            return Integer.valueOf(ds.getConnectionCacheProperties().getProperty("MaxLimit", "-1"));
        } catch (SQLException se) {
            return -1;
        } catch (NumberFormatException ne) {
            return -1;
        }
    }


    //---------- 委譲メソッド ----------

    public Connection getConnection() throws SQLException {
        return getConnectionInternal(null, null, null, 0, 0);
    }

    public Connection getConnection(Properties props) throws SQLException {
        return getConnectionInternal(null, null, props, 1, 0);
    }

    public Connection getConnection(String user, String password) throws SQLException {
        return getConnectionInternal(user, password, null, 2, 0);
    }

    public Connection getConnection(String user, String password, Properties props) throws SQLException {
        return getConnectionInternal(user, password, props, 3, 0);
    }

    /**
     * getConnection の内部実装。<br>
     * もとの getConnection の引数に対応する委譲メソッドを呼び出すように設計している。
     *
     * 接続に失敗した場合、メッセージがコネクションキャッシュの無効を意味するものであれば、
     * DataSource に指定した maxLimit の回数 +1 回までリトライを試みる。
     * (maxLimit 回だと、コネクションキャッシュが全部NGだったときに、
     * キャッシュを枯らすだけで終わってしまうため。
     * +1 しておくことで、無効なキャッシュをすべて破棄した上で
     * 確実に1回以上の接続試行が可能)
     *
     * @param user ユーザ名
     * @param password パスワード
     * @param props その他設定
     * @param argc 有効な引数の数
     * @param retryCount リトライ回数 (再帰で呼び出す場合以外は 0 を指定すること)
     * @return 取得したコネクション
     * @throws SQLException コネクションの取得に失敗した場合スローされます。
     */
    private Connection getConnectionInternal(String user, String password, Properties props, int argc, int retryCount)
            throws SQLException {
        try {
            if (argc == 3) {
                return ds.getConnection(user, password, props);
            } else if (argc == 2) {
                return ds.getConnection(user, password);
            } else if (argc == 1) {
                return ds.getConnection(props);
            } else if (argc == 0) {
                return ds.getConnection();
            } else {
                throw new IllegalArgumentException("パラメータ argc が不正です。argc=" + String.valueOf(argc));
            }

        } catch (SQLException e) {
            // retryCount は 0 から開始なので、この条件で OK
            if (retryCount <= this.maxLimit && e.getMessage().contains(RETRY_MESSAGE)) {
                if (log.isInfoEnabled()) {
                    log.info("無効な接続を検出しました。再接続します retryCount=" + String.valueOf(retryCount));
                }
                return getConnectionInternal(user, password, props, argc, ++retryCount);
            } else {
                throw e;
            }
        }
    }

    // ---------- 委譲メソッド ----------

    public void close() throws SQLException {
        ds.close();
    }

    public boolean equals(Object obj) {
        return ds.equals(obj);
    }


    public String getConnectionCacheName() throws SQLException {
        return ds.getConnectionCacheName();
    }

    public Properties getConnectionCacheProperties() throws SQLException {
        return ds.getConnectionCacheProperties();
    }

    public boolean getConnectionCachingEnabled() throws SQLException {
        return ds.getConnectionCachingEnabled();
    }

    public Properties getConnectionProperties() throws SQLException {
        return ds.getConnectionProperties();
    }

    public String getDatabaseName() {
        return ds.getDatabaseName();
    }

    public String getDataSourceName() {
        return ds.getDataSourceName();
    }

    public String getDescription() {
        return ds.getDescription();
    }

    public String getDriverType() {
        return ds.getDriverType();
    }

    public boolean getExplicitCachingEnabled() throws SQLException {
        return ds.getExplicitCachingEnabled();
    }

    public boolean getFastConnectionFailoverEnabled() throws SQLException {
        return ds.getFastConnectionFailoverEnabled();
    }

    public boolean getImplicitCachingEnabled() throws SQLException {
        return ds.getImplicitCachingEnabled();
    }

    public int getLoginTimeout() {
        return ds.getLoginTimeout();
    }

    public PrintWriter getLogWriter() {
        return ds.getLogWriter();
    }

    public int getMaxStatements() throws SQLException {
        return ds.getMaxStatements();
    }

    public String getNetworkProtocol() {
        return ds.getNetworkProtocol();
    }

    public String getONSConfiguration() throws SQLException {
        return ds.getONSConfiguration();
    }

    public int getPortNumber() {
        return ds.getPortNumber();
    }

    public Reference getReference() throws NamingException {
        return ds.getReference();
    }

    public String getServerName() {
        return ds.getServerName();
    }

    public String getServiceName() {
        return ds.getServiceName();
    }

    public String getTNSEntryName() {
        return ds.getTNSEntryName();
    }

    public String getURL() throws SQLException {
        return ds.getURL();
    }

    public String getUser() {
        return ds.getUser();
    }

    public int hashCode() {
        return ds.hashCode();
    }

    public void setConnectionCacheName(String arg0) throws SQLException {
        ds.setConnectionCacheName(arg0);
    }

    public void setConnectionCacheProperties(Properties arg0) throws SQLException {
        ds.setConnectionCacheProperties(arg0);
    }

    public void setConnectionCachingEnabled(boolean arg0) throws SQLException {
        ds.setConnectionCachingEnabled(arg0);
    }

    public void setConnectionProperties(Properties arg0) throws SQLException {
        ds.setConnectionProperties(arg0);
    }

    public void setDatabaseName(String arg0) {
        ds.setDatabaseName(arg0);
    }

    public void setDataSourceName(String arg0) {
        ds.setDataSourceName(arg0);
    }

    public void setDescription(String arg0) {
        ds.setDescription(arg0);
    }

    public void setDriverType(String arg0) {
        ds.setDriverType(arg0);
    }

    public void setExplicitCachingEnabled(boolean arg0) throws SQLException {
        ds.setExplicitCachingEnabled(arg0);
    }

    public void setFastConnectionFailoverEnabled(boolean arg0) throws SQLException {
        ds.setFastConnectionFailoverEnabled(arg0);
    }

    public void setImplicitCachingEnabled(boolean arg0) throws SQLException {
        ds.setImplicitCachingEnabled(arg0);
    }

    public void setLoginTimeout(int arg0) {
        ds.setLoginTimeout(arg0);
    }

    public void setLogWriter(PrintWriter arg0) {
        ds.setLogWriter(arg0);
    }

    @Deprecated
    public void setMaxStatements(int arg0) throws SQLException {
        ds.setMaxStatements(arg0);
    }

    public void setNetworkProtocol(String arg0) {
        ds.setNetworkProtocol(arg0);
    }

    public void setONSConfiguration(String arg0) throws SQLException {
        ds.setONSConfiguration(arg0);
    }

    public void setPassword(String arg0) {
        ds.setPassword(arg0);
    }

    public void setPortNumber(int arg0) {
        ds.setPortNumber(arg0);
    }

    public void setServerName(String arg0) {
        ds.setServerName(arg0);
    }

    public void setServiceName(String arg0) {
        ds.setServiceName(arg0);
    }

    public void setTNSEntryName(String arg0) {
        ds.setTNSEntryName(arg0);
    }

    public void setURL(String arg0) {
        ds.setURL(arg0);
    }

    public void setUser(String arg0) {
        ds.setUser(arg0);
    }

    public String toString() {
        return ds.toString();
    }

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return ds.getParentLogger();
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return ds.unwrap(iface);
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return ds.isWrapperFor(iface);
	}

}
