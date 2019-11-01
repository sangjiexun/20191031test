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

import java.io.IOException;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * CommonsFtpClientFactory (Jakarta Commons Net 1.4.1)
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CommonsFtpClientFactory {

    private CommonsFtpClientFactory() {
    }

    /**
     * Creates a new connection to the server.
     */
    public static FTPClient createConnection(String hostname, String username, String password, String workingDirectory)
            throws FTPClientException {

        final FTPClient client = new FTPClient();
        // ここらへん設定したい方は直してね
        // FTPClientConfig config = new FTPClientConfig();
        // config.setServerLanguageCode(serverLanguageCode);
        // config.setDefaultDateFormatStr(defaultDateFormat);
        // config.setRecentDateFormatStr(recentDateFormat);
        // config.setServerTimeZoneId(serverTimeZoneId);

        // client.configure(config);

        try {

            // そのうちポートの設定したい
            // client.connect(hostname, port);
            client.connect(hostname);

            int reply = client.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                throw new FTPClientException("接続失敗：" + hostname);
            }

            // Login
            if (!client.login(username, password)) {
                throw new FTPClientException("ログイン失敗：username:" + username);
            }

            // ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            // Set binary mode
            if (!client.setFileType(FTP.BINARY_FILE_TYPE)) {
                throw new FTPClientException("バイナリモード設定失敗");
            }

            // 転送時のタイムアウト時間
            // Integer dataTimeout =
            // if (dataTimeout != null)
            // {
            // client.setDataTimeout(dataTimeout.intValue());
            // }

            // そこがrootなのかどうかとか判定が必要な気もする
            if (workingDirectory != null) {

                if (!client.changeWorkingDirectory(workingDirectory)) {

                    if (client.makeDirectory(workingDirectory)) {

                        if (!client.changeWorkingDirectory(workingDirectory)) {
                            throw new FTPClientException("ディレクトリ移動に失敗" + workingDirectory);
                        }
                    }
                    throw new FTPClientException("作成に失敗" + workingDirectory);
                }
            }

            // あとで直す！
            boolean passiveMode = true;

            if (passiveMode) {
                client.enterLocalPassiveMode();
            }

        } catch (final IOException e) {
            if (client.isConnected()) {
                try {
                    client.disconnect();
                } catch (IOException e1) {
                    throw new FTPClientException("接続エラー:" + hostname, e);
                }
            }
            throw new FTPClientException("接続エラー:" + hostname, e);
        }

        return client;
    }

}