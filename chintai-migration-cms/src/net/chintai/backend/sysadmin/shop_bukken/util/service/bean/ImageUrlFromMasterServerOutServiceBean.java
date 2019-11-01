/*
 * $Id: ImageUrlFromMasterServerOutServiceBean.java 3754 2008-01-11 11:10:51Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.util.service.bean;

import java.util.List;

/**
 * 画像配信サーバ上の画像URLパスを取得する時に使用するOutServiceBean。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3754 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ImageUrlFromMasterServerOutServiceBean {

    /** 画像別の作業コード */
    private List<String> workCdList;

    /** 画像配信サーバ上の画像URLパス */
    private List<String> imageUrlPathList;

    /**
     * 画像別の作業コードを取得します。
     * @return workCdList 画像別の作業コード
     */
    public List<String> getWorkCdList() {
        return workCdList;
    }

    /**
     * 画像別の作業コードを設定します。
     * @param workCdList 画像別の作業コード
     */
    public void setWorkCdList(List<String> workCdList) {
        this.workCdList = workCdList;
    }

    /**
     * 画像配信サーバ上の画像URLパスを取得します。
     * @return imageUrlPathList 画像配信サーバ上の画像URLパス
     */
    public List<String> getImageUrlPathList() {
        return imageUrlPathList;
    }

    /**
     * 画像配信サーバ上の画像URLパスを設定します。
     * @param imageUrlPathList 画像配信サーバ上の画像URLパス
     */
    public void setImageUrlPathList(List<String> imageUrlPathList) {
        this.imageUrlPathList = imageUrlPathList;
    }

}
