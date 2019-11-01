/*
 * $Id: ImageWidthSizeCheckInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service.bean;

import java.util.Map;

/**
 * 画像別幅サイズのチェック用InServiceBean
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ImageWidthSizeCheckInServiceBean {

    /** 画像別物理パスマップ : 作業コード, 画像物理パス */
    private Map<String, String> imgLogicalPathMap;

    /**
     * 画像別物理パスマップを取得します。
     * @return imgLogicalPathMap 画像別物理パスマップ
     */
    public Map<String, String> getImgLogicalPathMap() {
        return imgLogicalPathMap;
    }

    /**
     * 画像別物理パスマップを設定します。
     * @param imgLogicalPathMap 画像別物理パスマップ
     */
    public void setImgLogicalPathMap(Map<String, String> imgLogicalPathMap) {
        this.imgLogicalPathMap = imgLogicalPathMap;
    }

}
