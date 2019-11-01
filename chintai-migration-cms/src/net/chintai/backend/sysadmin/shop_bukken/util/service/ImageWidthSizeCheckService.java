/*
 * $Id: ImageWidthSizeCheckService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service;

import java.io.IOException;

import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageWidthSizeCheckInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.util.service.bean.ImageWidthSizeCheckOutServiceBean;

/**
 * 画像別幅サイズをチェックして、実行させるServletを決めるインタフェース
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ImageWidthSizeCheckService {

    /**
     * 画像別幅サイズをチェックして、実行させるServletを決めて、 その結果をマップにいれて渡す。
     * 
     * @param inServiceBean 画像別の物理パスのInServiceBean
     * @return ImageWidhtHeightOutServiceBean 画像別実行させるServletのOutServiceBean
     */
    public ImageWidthSizeCheckOutServiceBean getWidthHeight(ImageWidthSizeCheckInServiceBean inServiceBean)
            throws IOException;
}
