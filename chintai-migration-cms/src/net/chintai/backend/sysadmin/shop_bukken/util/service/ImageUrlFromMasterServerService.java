/*
 * $Id: ImageUrlFromMasterServerService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service;

import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUrlFromMasterServerInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageUrlFromMasterServerOutServiceBean;

/**
 * 画像マスタサーバ上の画像URLパスを提供するService。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ImageUrlFromMasterServerService {

    /**
     * 画像マスタサーバ上の画像URLパスを取得する。
     * @param inServiceBean 店舗コード、作業コード
     * @return 画像マスタサーバ上の画像URLパス
     * @throws Exception
     */
    public ImageUrlFromMasterServerOutServiceBean imageUrlFromMasterServer(
            ImageUrlFromMasterServerInServiceBean inServiceBean);

}
