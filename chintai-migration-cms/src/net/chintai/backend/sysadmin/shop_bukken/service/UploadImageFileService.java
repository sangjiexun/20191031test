/*
 * $Id: UploadImageFileService.java 3851 2008-03-10 05:41:34Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/30  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.io.IOException;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.UploadImageFileInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.UploadImageFileOutServiceBean;

/**
 * 画像ファイルをアップロード機能を提供するService。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3851 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UploadImageFileService {

    /**
     * 画像ファイルをアップロードする。
     * @param uploadInServiceBean アップロードする画像ファイル。
     * @throws IOException 画像のアップロード時にI/O例外が発生した場合スローされます。
     */
    public UploadImageFileOutServiceBean uploadImageFile(UploadImageFileInServiceBean uploadInServiceBean) throws IOException;
}
