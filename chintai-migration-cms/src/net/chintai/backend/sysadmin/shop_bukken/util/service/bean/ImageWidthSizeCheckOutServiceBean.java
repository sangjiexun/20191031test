/*
 * $Id: ImageWidthSizeCheckOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service.bean;

import java.util.Map;

/**
 * 画像別幅サイズのチェック用OutServiceBean
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ImageWidthSizeCheckOutServiceBean {

    /** 画像別実行させるServletマップ : 作業コード, 実行Servlet */
    private Map<String, String> executeServletMap;

    /**
     * 画像別実行させるServletマップを取得します。
     * @return executeServletMap 画像別実行させるServletマップ
     */
    public Map<String, String> getExecuteServletMap() {
        return executeServletMap;
    }

    /**
     * 画像別実行させるServletマップを設定します。
     * @param executeServletMap 画像別実行させるServletマップ
     */
    public void setExecuteServletMap(Map<String, String> executeServletMap) {
        this.executeServletMap = executeServletMap;
    }

}
