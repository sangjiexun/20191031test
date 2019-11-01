/*
 * $Id: BukkenRirekiInfoCsvDownloadService.java 3922 2008-05-27 09:38:05Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/05/27  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.shop_bukken.domain.ImgCntEachCategory;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenRirekiInfoCsvDownloadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenRirekiInfoCsvDownloadOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadShopInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ImgCntEachCategoryInServiceBean;

/**
 * CSV出力用、入稿履歴情報取得サービス
 *
 * @author Lee Hosup
 * @version $Revision: 3922 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface BukkenRirekiInfoCsvDownloadService {

    /**
     * CSV出力用、入稿履歴情報を取得します。
     *
     * @param inBean 検索条件
     * @return 入稿履歴情報
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public List<BukkenRirekiInfoCsvDownloadOutServiceBean> getBukkenRirekiInfo(
            BukkenRirekiInfoCsvDownloadInServiceBean inBean) throws InvocationTargetException,
            IllegalAccessException;


    /**
     * @param tableName
     * @param bean
     * @param shopBean
     * @return
     */
    public List<String[]> getCsvDownloadTable(final String tableName, final CsvDownloadInServiceBean bean, final CsvDownloadShopInServiceBean shopBean);

    /**
     * @param bean
     * @return
     */
    public List<ImgCntEachCategory> selectImgCntEachCategory(final ImgCntEachCategoryInServiceBean bean);
}
