/*
 * $Id: BukkenRirekiInfoCsvDownloadDao.java 3918 2008-05-27 08:52:02Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/05/23     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.HashMap;
import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.domain.BukkenRirekiInfoCsvDownload;
import net.chintai.backend.sysadmin.shop_bukken.domain.ColumnComments;
import net.chintai.backend.sysadmin.shop_bukken.domain.ImgCntEachCategory;
import net.chintai.backend.sysadmin.shop_bukken.domain.MstInsPg;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadColumnInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadShopInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ImgCntEachCategoryInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.MstInsPgInServiceBean;

/**
 * 入稿履歴検索DAO(CSV出力用)
 *
 * @author Lee Hosup
 * @version $Revision: 3918 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface BukkenRirekiInfoCsvDownloadDao {

    /**
     * 入稿履歴検索
     * @param paramBean 検索条件
     * @return 入稿履歴情報
     */
    public List<BukkenRirekiInfoCsvDownload> getbukkenRirekiInfo(
            BukkenRirekiInfoCsvDownloadParamBean paramBean);

    /**
     * カラムコメント取得
     * @param tableName
     * @return カラムコメント情報
     */
    public List<ColumnComments> selectColumnComments(CsvDownloadColumnInServiceBean bean);

    /**
     * 物件履歴検索
     * @param bean
     * @return 物件履歴情報
     */
    public List<HashMap<String, String>> selectBukkenRireki(CsvDownloadInServiceBean bean);

    /**
     * 物件履歴コメント検索
     * @param bean
     * @return 物件履歴コメント情報
     */
    public List<HashMap<String, String>> selectBukkenRirekiComment(CsvDownloadInServiceBean bean);

    /**
     * 物件履歴駅検索
     * @param bean
     * @return 物件履歴駅情報
     */
    public List<HashMap<String, String>> selectBukkenRirekiEki(CsvDownloadInServiceBean bean);

    /**
     * 物件履歴画像検索
     * @param bean
     * @return 物件履歴画像情報
     */
    public List<HashMap<String, String>> selectBukkenRirekiImg(CsvDownloadInServiceBean bean);

    /**
     * 物件履歴間取検索
     * @param bean
     * @return 物件履歴間取情報
     */
    public List<HashMap<String, String>> selectBukkenRirekiMadori(CsvDownloadInServiceBean bean);

    /**
     * 物件履歴取扱店検索
     * @param bean
     * @return 物件履歴取扱店情報
     */
    public List<HashMap<String, String>> selectBukkenRirekiShop(CsvDownloadInServiceBean bean);

    /**
     * 物件履歴周辺環境検索
     * @param bean
     * @return 物件履歴周辺環境情報
     */
    public List<HashMap<String, String>> selectBukkenRirekiAround(CsvDownloadInServiceBean bean);

    /**
     * 物件履歴前面道路検索
     * @param bean
     * @return 物件履歴前面道路情報
     */
    public List<HashMap<String, String>> selectBukkenRirekiRoad(CsvDownloadInServiceBean bean);

    /**
     * 物件履歴駐車場検索
     * @param bean
     * @return 物件履歴駐車場情報
     */
    public List<HashMap<String, String>> selectBukkenRirekiChusha(CsvDownloadInServiceBean bean);

    /**
     * 物件履歴特集検索
     * @param bean
     * @return 物件履歴特集情報
     */
    public List<HashMap<String, String>> selectBukkenRirekiFeature(CsvDownloadInServiceBean bean);

    /**
     * 物件履歴特徴条件検索
     * @param bean
     * @return 物件履歴特徴条件情報
     */
    public List<HashMap<String, String>> selectBukkenRirekiCharacter(CsvDownloadInServiceBean bean);

    /**
     * 物件履歴費用検索
     * @param bean
     * @return 物件履歴費用情報
     */
    public List<HashMap<String, String>> selectBukkenRirekiHiyou(CsvDownloadInServiceBean bean);

    /**
     * 物件履歴用途地域検索
     * @param bean
     * @return 物件履歴用途地域情報
     */
    public List<HashMap<String, String>> selectBukkenRirekiZoning(CsvDownloadInServiceBean bean);

    /**
     * 店舗用問合せ検索
     * @param bean
     * @return 店舗用問合せ情報
     */
    public List<HashMap<String, String>> selectShopInquiry(CsvDownloadInServiceBean bean);

    /**
     * エイブル店舗用問合せ検索
     * @param bean
     * @return エイブル店舗用問合せ情報
     */
    public List<HashMap<String, String>> selectAblShopInquiry(CsvDownloadInServiceBean bean);

    /**
     * 店舗履歴検索
     * @param bean
     * @return 店舗履歴情報
     */
    public List<HashMap<String, String>> selectShopRireki(CsvDownloadShopInServiceBean bean);

    /**
     * カテゴリー毎の写真枚数検索
     * @param bean
     * @return カテゴリー毎の写真枚数情報
     */
    public List<ImgCntEachCategory> selectImgCntEachCategory(ImgCntEachCategoryInServiceBean bean);

}
