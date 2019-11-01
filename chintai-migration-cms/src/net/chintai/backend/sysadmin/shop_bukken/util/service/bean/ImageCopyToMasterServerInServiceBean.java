/*
 * $Id: ImageCopyToMasterServerInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service.bean;

/**
 * 画像ファイルをマスタサーバにコピーする時に使用するInServiceBean。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ImageCopyToMasterServerInServiceBean {

    /** FTPサーバーに送信されたファイルのパス */
    private String masterPath;

    /**
     * FTPサーバーに送信されたファイルのパスを取得します。
     * @return masterPath FTPサーバーに送信されたファイルのパス
     */
    public String getMasterPath() {
        return masterPath;
    }

    /**
     * FTPサーバーに送信されたファイルのパスを設定します。
     * @param masterPath FTPサーバーに送信されたファイルのパス
     */
    public void setMasterPath(String masterPath) {
        this.masterPath = masterPath;
    }

}
