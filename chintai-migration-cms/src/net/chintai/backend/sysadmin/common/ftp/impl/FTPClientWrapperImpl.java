/*
 * $Id: FTPClientWrapperImpl.java 3577 2007-12-14 11:49:08Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/25   BGT)児島      新規作成(chintai-imagetool より拝借)
 *
 */
package net.chintai.backend.sysadmin.common.ftp.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import net.chintai.backend.sysadmin.common.ftp.CommonsFtpClientFactory;
import net.chintai.backend.sysadmin.common.ftp.FTPClientException;
import net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 * FTPClientWrapper の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3577 $
 * @see FTPClientWrapper
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FTPClientWrapperImpl implements FTPClientWrapper {

    /** Logger */
    private static Log log = LogFactory.getLog(FTPClientWrapperImpl.class);

    /** FTPクライアント */
    private FTPClient _ftpClient;

    /** 接続先ホスト名 */
    private String hostName;

    /** 接続ユーザ名 */
    private String userName;

    /** 接続パスワード */
    private String password;

    /** カレントディレクトリ */
    private String workingDirectory;

    /**
     * コンストラクター
     * @param hostname FTPサーバのホスト名
     * @param username FTPアカウント
     * @param password FTPパスワード
     * @param workingDirectory 初期ディレクトリ
     * @throws FTPClientException 異常発生時にスローされる
     */
    public FTPClientWrapperImpl(String hostname, String username, String password, String workingDirectory)
            throws FTPClientException {

        this.hostName = hostname;
        this.userName = username;
        this.password = password;
        this.workingDirectory = workingDirectory;

        getFtpClient(); // fail-fast

        try {
            log.debug("ログイン時のルート:" + getFtpClient().printWorkingDirectory());
        } catch (IOException e) {
            throw new FTPClientException(e);
        }
    }

    /**
     * FTPサーバに接続します。
     * @return FTPクライアント
     * @throws FTPClientException 異常発生時にスローされる
     */
    private FTPClient createClient() throws FTPClientException {
        return CommonsFtpClientFactory.createConnection(this.hostName, this.userName, this.password, null);
    }

    /**
     * FTPクライアントオブジェクトを取得します。
     * @return FTPクライアント
     * @throws FTPClientException 異常発生時にスローされる
     */
    public FTPClient getFtpClient() throws FTPClientException {
        if (_ftpClient == null) {
            _ftpClient = createClient();
        }
        return _ftpClient;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#isConnected()
     */
    public boolean isConnected() {
        return _ftpClient != null && _ftpClient.isConnected();
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#disconnect()
     */
    public void disconnect() throws FTPClientException {
        try {
            try {

                getFtpClient().disconnect();

            } catch (IOException e1) {
                throw new FTPClientException(e1);
            }
        } finally {
            _ftpClient = null;
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#listFiles(java.lang.String)
     */
    public FTPFile[] listFiles(String relPath) throws FTPClientException {
        try {
            return getFtpClient().listFiles(relPath);
        } catch (IOException e) {
            disconnect();
            try {
                return getFtpClient().listFiles(relPath);
            } catch (IOException e1) {
                throw new FTPClientException(e1);
            }
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#removeDirectory(java.lang.String)
     */
    public boolean removeDirectory(String relPath) throws FTPClientException {
        try {
            return getFtpClient().removeDirectory(relPath);
        } catch (IOException e) {
            disconnect();
            try {
                return getFtpClient().removeDirectory(relPath);
            } catch (IOException e1) {
                throw new FTPClientException(e1);
            }
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#deleteFile(java.lang.String)
     */
    public boolean deleteFile(String relPath) throws FTPClientException {
        try {
            return getFtpClient().deleteFile(relPath);
        } catch (IOException e) {
            disconnect();
            try {
                return getFtpClient().deleteFile(relPath);
            } catch (IOException e1) {
                throw new FTPClientException(e1);
            }
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#rename(java.lang.String,
     *      java.lang.String)
     */
    public boolean rename(String oldName, String newName) throws FTPClientException {
        try {
            return getFtpClient().rename(oldName, newName);
        } catch (IOException e) {
            disconnect();
            try {
                return getFtpClient().rename(oldName, newName);
            } catch (IOException e1) {
                throw new FTPClientException(e1);

            }
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#makeDirectory(java.lang.String)
     */
    public final void makeDirectory(String path) throws FTPClientException {
        String pathName = getPath(path);
        receursiveDir(pathName, 1);
    }

    /**
     * 再帰的にディレクトリを作成する
     * @param pathName 作成するディレクトリ
     * @param index 再帰開始位置
     * @throws FTPClientException 異常発生時にスローされる
     */
    private final void receursiveDir(String pathName, int index) throws FTPClientException {

        String path = pathName;
        String temp = "";

        // 指定したindex以降の"/"がはじめに出現するindex2を取得
        int index2 = path.indexOf("/", index);

        temp = path.substring(0, index2 + 1);

        try {
            getFtpClient().makeDirectory(temp);

        } catch (IOException e) {
            // 同じタイミングでmkdirコマンドを発生させたときにの処理を追加
            log.error("mkdirにてエラーが発生 :" + getFtpClient().getReplyString());

            try {
                Thread.sleep(300);

                try {
                    _ftpClient.disconnect();
                    _ftpClient = null;
                } catch (Exception e3) {
                    getFtpClient();
                }

                getFtpClient().makeDirectory(temp);
                log.error("２回目のmkdir :" + getFtpClient().getReplyString());

            } catch (Exception e2) {
                log.error("２回目のmkdirでも失敗");
                log.error(e2);

                e2.printStackTrace();
                throw new FTPClientException(e2);
            }

            if ((index2 + 1) != path.length()) {
                receursiveDir(path, index2 + 1);
            }
        }

        if ((index2 + 1) != path.length()) {
            receursiveDir(path, index2 + 1);
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#completePendingCommand()
     */
    public boolean completePendingCommand() throws FTPClientException {
        if (_ftpClient != null) {
            try {
                return getFtpClient().completePendingCommand();
            } catch (IOException e1) {
                throw new FTPClientException(e1);
            }
        }

        return true;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#retrieveFileStream(java.lang.String)
     */
    public InputStream retrieveFileStream(String relPath) throws FTPClientException {
        try {
            return getFtpClient().retrieveFileStream(relPath);
        } catch (IOException e) {
            disconnect();
            try {
                return getFtpClient().retrieveFileStream(relPath);
            } catch (IOException e1) {
                throw new FTPClientException(e1);
            }
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#retrieveFileStream(java.lang.String,
     *      long)
     */
    public InputStream retrieveFileStream(String relPath, long restartOffset) throws FTPClientException {
        try {
            FTPClient client = getFtpClient();
            client.setRestartOffset(restartOffset);
            return client.retrieveFileStream(relPath);
        } catch (IOException e) {
            disconnect();

            FTPClient client = getFtpClient();
            client.setRestartOffset(restartOffset);
            try {
                return client.retrieveFileStream(relPath);
            } catch (IOException e1) {
                throw new FTPClientException(e1);
            }
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#appendFileStream(java.lang.String)
     */
    public OutputStream appendFileStream(String relPath) throws FTPClientException {
        try {
            return getFtpClient().appendFileStream(relPath);
        } catch (IOException e) {

            disconnect();
            try {
                return getFtpClient().appendFileStream(relPath);
            } catch (IOException e1) {
                throw new FTPClientException(e1);
            }
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#storeFileStream(java.lang.String)
     */
    public OutputStream storeFileStream(String relPath) throws FTPClientException {
        try {
            return getFtpClient().storeFileStream(relPath);
        } catch (IOException e) {

            disconnect();
            try {
                return getFtpClient().storeFileStream(relPath);
            } catch (IOException e1) {
                throw new FTPClientException(e1);
            }
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#storeFileStream(java.lang.String,
     *      java.io.InputStream)
     */
    public boolean storeFile(String relPath, InputStream input) throws FTPClientException {

        boolean flg = false;

        try {
            flg = getFtpClient().storeFile(relPath, input);
        } catch (Exception e) {

            disconnect();
            try {
                flg = getFtpClient().storeFile(relPath, input);
            } catch (Exception e1) {
                throw new FTPClientException(e1);
            }
        }
        return flg;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#abort()
     */
    public boolean abort() throws FTPClientException {
        try {
            // imario@apache.org: 2005-02-14
            // it should be better to really "abort" the transfer, but
            // currently I didnt manage to make it work - so lets "abort" the
            // hard way.
            // return getFtpClient().abort();
            disconnect();

        } catch (FTPClientException e) {
            disconnect();
        }
        return true;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.ftp.FTPClientWrapper#getReplyString()
     */
    public String getReplyString() throws FTPClientException {
        return getFtpClient().getReplyString();
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.common.util.ftp.impl.FTPClientService#isFileExist(java.lang.String)
     */
    public final boolean isFileExist(String serverFilePath) throws FTPClientException {

        FTPFile[] ftpfiles;

        try {
            ftpfiles = getFtpClient().listFiles(serverFilePath);
        } catch (IOException e) {
            throw new FTPClientException(e);
        }
        return (ftpfiles != null && ftpfiles.length > 0);
    }

    /**
     * ファイル名まで含んだパス名から、ファイル名をはずしたパス名を取得します。<br>
     * 例) test/common/sample.txt なら test/common/ という文字列を取得します。
     * @param filePathAndFileName ファイル名まで含んだパス名
     * @return path ファイル名をはずしたパス名
     */
    private final String getPath(String filePathAndFileName) {
        int index = filePathAndFileName.lastIndexOf("/");
        return filePathAndFileName.substring(0, index + 1);
    }

    /**
     * 接続先ホスト名を取得します。
     * @return 接続先ホスト名
     */
    public final String getHostName() {
        return hostName;
    }

    /**
     * 接続先ホスト名を設定します。
     * @param hostname 接続先ホスト名
     */
    public final void setHostName(String hostname) {
        this.hostName = hostname;
    }

    /**
     * 接続ユーザ名を取得します。
     * @return 接続ユーザ名
     */
    public final String getUserName() {
        return userName;
    }

    /**
     * 接続ユーザ名を設定します。
     * @param username 接続ユーザ名
     */
    public final void setUserName(String username) {
        this.userName = username;
    }

    /**
     * 接続パスワードを取得します。
     * @return 接続パスワード
     */
    public final String getPassword() {
        return password;
    }

    /**
     * 接続パスワードを設定します。
     * @param password 接続パスワード
     */
    public final void setPassword(String password) {
        this.password = password;
    }

    /**
     * カレントディレクトリを取得します。
     * @return カレントディレクトリ
     */
    public final String getWorkingDirectory() {
        return workingDirectory;
    }

    /**
     * カレントディレクトリを設定します。
     * @param workingDirectory カレントディレクトリ
     */
    public final void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

}