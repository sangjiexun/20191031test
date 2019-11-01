/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.chintai.backend.sysadmin.common.ftp;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPFile;

/**
 * Commons FTPClient のラッパークラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FTPClientWrapper {

    /**
     * コネクションの状態を返します。
     * @return 接続されている場合 true, 切断されている場合 false
     */
    public boolean isConnected();

    /**
     * コネクションを切断します。
     * @throws FTPClientException 切断に失敗した場合にスローされる
     */
    public void disconnect() throws FTPClientException;

    /**
     * サーバ側のファイルリストを取得します。
     * @param relPath FTPサーバ上のディレクトリ相対パス
     * @return ファイルオブジェクトの配列
     * @throws FTPClientException ファイルリストが取得できなかった場合にスローされる
     */
    public FTPFile[] listFiles(String relPath) throws FTPClientException;

    /**
     * サーバ側のディレクトリを削除します(ディレクトリが空の場合)。
     * @param relPath FTPサーバ上のディレクトリ相対パス
     * @return 成功: true, 失敗: false
     * @throws FTPClientException 削除に失敗した場合にスローされる
     */
    public boolean removeDirectory(String relPath) throws FTPClientException;

    /**
     * サーバ側のファイルを削除します。
     * @param relPath FTPサーバ上のディレクトリ相対パス
     * @return 成功: true, 失敗: false
     * @throws FTPClientException 削除に失敗した場合にスローされる
     */
    public boolean deleteFile(String relPath) throws FTPClientException;

    /**
     * サーバ側ファイルの名前を変更します。
     * @param oldName ファイル名
     * @param newName 新しいファイル名
     * @return 成功: true, 失敗: false
     * @throws FTPClientException リネームできなかった場合にスローされる
     */
    public boolean rename(String oldName, String newName) throws FTPClientException;

    /**
     * サーバ側にディレクトリを作成します。
     * @param relPath FTPサーバ上のディレクトリ相対パス
     * @throws FTPClientException 作成に失敗した場合にスローされる
     */
    public void makeDirectory(String relPath) throws FTPClientException;

    /**
     * サーバ側の処理が完了しているかどうかを判定します。<br>
     * FTP通信を終了する前に、このメソッドを実行して、その結果により<br>
     * 適切なクローズ処理を行う必要があります。
     * @return 完了: true, 未完了: false
     * @throws FTPClientException 異常が発生した場合にスローされる
     */
    public boolean completePendingCommand() throws FTPClientException;

    /**
     * サーバ側ファイルの InputStream を取得します。<br>
     * InputStream は、不要になったら必ずクローズ処理を行ってください。
     * @param relPath FTPサーバ上のディレクトリ相対パス
     * @return 入力ストリーム
     * @throws FTPClientException 異常が発生した場合にスローされる
     */
    public InputStream retrieveFileStream(String relPath) throws FTPClientException;

    /**
     * サーバ側ファイルの InputStream を取得します。<br>
     * InputStream は、不要になったら必ずクローズ処理を行ってください。
     * @param relPath FTPサーバ上のディレクトリ相対パス
     * @param restartOffset
     * @return 入力ストリーム
     * @throws FTPClientException 異常が発生した場合にスローされる
     */
    public InputStream retrieveFileStream(String relPath, long restartOffset) throws FTPClientException;

    /**
     * サーバ側ファイルの OutputStream (追記モード) を取得します。<br>
     * OutputStream は、不要になったら必ずクローズ処理を行ってください。
     * @param relPath FTPサーバ上のディレクトリ相対パス
     * @return 入力ストリーム
     * @throws FTPClientException 異常が発生した場合にスローされる
     */
    public OutputStream appendFileStream(String relPath) throws FTPClientException;

    /**
     * サーバ側にファイルを転送します。
     * @param relPath FTPサーバ上のディレクトリ相対パス
     * @return 出力ストリーム
     * @throws FTPClientException 異常が発生した場合にスローされる
     */
    public OutputStream storeFileStream(String relPath) throws FTPClientException;

    /**
     * サーバ側にファイルを転送します。
     * @param relPath FTPサーバ上のディレクトリ相対パス
     * @param inputStream 入力ストリーム
     * @return 成功: true, 失敗: false
     * @throws FTPClientException 異常が発生した場合にスローされる
     */
    public boolean storeFile(String relPath, InputStream inputStream) throws FTPClientException;

    /**
     * 転送処理を中断します。
     * @return 成功: true, 失敗: false
     * @throws FTPClientException 異常が発生した場合にスローされる
     */
    public boolean abort() throws FTPClientException;

    /**
     * サーバからのレスポンスメッセージを取得します。
     * @return FTPレスポンスメッセージ
     * @throws FTPClientException 異常が発生した場合にスローされる
     */
    public String getReplyString() throws FTPClientException;

    /**
     * サーバ側ファイルの有無を判定します。
     * @param serverFilePath
     * @return 存在する:true, 存在しない:false
     * @throws FTPClientException 異常が発生した場合にスローされる
     */
    public boolean isFileExist(String serverFilePath) throws FTPClientException;

    /**
     * サーバ側のカレントディレクトリのパスを取得します。
     * @return カレントディレクトリ絶対パス
     */
    public String getWorkingDirectory();
}