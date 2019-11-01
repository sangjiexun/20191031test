/*
 * $Id: ImageUtils.java 4308 2009-07-14 06:46:43Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.validator.DynaValidatorForm;


/**
 * 画像処理関連Utilityクラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4308 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ImageUtils {

    /**
     * 転送完了後の臨時ファイルを削除します。
     *
     * @param form
     */
    public static void deleteTmpImg(DynaValidatorForm form) {

        List<String> tmpImgPathList = ImageUtils.getTmpImgPathList(form);

        for (String path : tmpImgPathList) {
            File file = new File(path);
            file.delete();
        }
    }

    /**
     * 臨時保管中のイメージファイルパスリストを取得
     *
     * @param form
     * @return 臨時保管中のイメージファイルパスリスト
     */
    public static List<String> getTmpImgPathList(DynaValidatorForm form) {

        List<String> returnList = new ArrayList<String>();

        String shopMapPctFileLogicalPath = (String) form.get("shopMapPctFileLogicalPath");
        String shopPhoto1FileLogicalPath = (String) form.get("shopPhoto1FileLogicalPath");
        String shopPhoto2FileLogicalPath = (String) form.get("shopPhoto2FileLogicalPath");
        String shopPhoto3FileLogicalPath = (String) form.get("shopPhoto3FileLogicalPath");
        String shopPhoto4FileLogicalPath = (String) form.get("shopPhoto4FileLogicalPath");

        if (StringUtils.isNotEmpty(shopMapPctFileLogicalPath)) {
            returnList.add(shopMapPctFileLogicalPath);
        }
        if (StringUtils.isNotEmpty(shopPhoto1FileLogicalPath)) {
            returnList.add(shopPhoto1FileLogicalPath);
        }
        if (StringUtils.isNotEmpty(shopPhoto2FileLogicalPath)) {
            returnList.add(shopPhoto2FileLogicalPath);
        }
        if (StringUtils.isNotEmpty(shopPhoto3FileLogicalPath)) {
            returnList.add(shopPhoto3FileLogicalPath);
        }
        if (StringUtils.isNotEmpty(shopPhoto4FileLogicalPath)) {
            returnList.add(shopPhoto4FileLogicalPath);
        }

        return returnList;
    }
}
