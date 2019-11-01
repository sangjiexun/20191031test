/*
 * $Id: ImageResizeCopyToMasterServerOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service.bean;

/**
 * マスタサーバへの画像リサイズServletを実行するServiceのOutServiceBean。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ImageResizeCopyToMasterServerOutServiceBean {

    private boolean sendSuccessFlg;

    /**
     * 画像配信サーバの画像UrlPathを取得します。
     * @return sendSuccessFlg 画像配信サーバの画像UrlPath
     */
    public boolean getSendSuccessFlg() {
        return sendSuccessFlg;
    }

    /**
     * 画像配信サーバの画像UrlPathを設定します。
     * @param sendSuccessFlg 画像配信サーバの画像UrlPath
     */
    public void setSendSuccessFlg(boolean sendSuccessFlg) {
        this.sendSuccessFlg = sendSuccessFlg;
    }

}
