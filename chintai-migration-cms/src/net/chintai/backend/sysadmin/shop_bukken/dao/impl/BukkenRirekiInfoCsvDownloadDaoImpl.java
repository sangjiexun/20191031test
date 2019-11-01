/*
 * $Id: BukkenRirekiInfoCsvDownloadDaoImpl.java 3916 2008-05-27 08:34:12Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/05/27  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadParamBean;
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
 * BukkenRirekiInfoCsvDownloadDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 3916 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenRirekiInfoCsvDownloadDaoImpl extends SqlMapClientDaoSupport implements
        BukkenRirekiInfoCsvDownloadDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#getbukkenRirekiInfo(net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<BukkenRirekiInfoCsvDownload> getbukkenRirekiInfo(
            BukkenRirekiInfoCsvDownloadParamBean paramBean) {

        return getSqlMapClientTemplate().queryForList("shopBukken.bukkenRirekiInfoCsvDownload",
                paramBean);
    }

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectColumnComments(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadColumnInServiceBean)
	 */
	public List<ColumnComments> selectColumnComments(CsvDownloadColumnInServiceBean bean) {
		return getSqlMapClientTemplate().queryForList("shopBukken.selectColumnComments", bean);
	}


	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectBukkenRireki(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectBukkenRireki(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectBukkenRireki", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectBukkenRirekiComment(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectBukkenRirekiComment(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectBukkenRirekiComment", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectBukkenRirekiEki(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectBukkenRirekiEki(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectBukkenRirekiEki", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectBukkenRirekiImg(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectBukkenRirekiImg(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectBukkenRirekiImg", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectBukkenRirekiMadori(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectBukkenRirekiMadori(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectBukkenRirekiMadori", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectBukkenRirekiShop(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectBukkenRirekiShop(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectBukkenRirekiShop", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectBukkenRirekiAround(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectBukkenRirekiAround(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectBukkenRirekiAround", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectBukkenRirekiRoad(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectBukkenRirekiRoad(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectBukkenRirekiRoad", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectBukkenRirekiChusha(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectBukkenRirekiChusha(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectBukkenRirekiChusha", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectBukkenRirekiFeature(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectBukkenRirekiFeature(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectBukkenRirekiFeature", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectBukkenRirekiCharacter(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectBukkenRirekiCharacter(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectBukkenRirekiCharacter", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectBukkenRirekiHiyou(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectBukkenRirekiHiyou(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectBukkenRirekiHiyou", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectBukkenRirekiZoning(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectBukkenRirekiZoning(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectBukkenRirekiZoning", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectShopInquiry(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectShopInquiry(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectShopInquiry", bean);
	}


	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectAblShopInquiry(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean)
	 */
	public List<HashMap<String, String>> selectAblShopInquiry(CsvDownloadInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectAblShopInquiry", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectShopRireki(net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadShopInServiceBean)
	 */
	public List<HashMap<String, String>> selectShopRireki(CsvDownloadShopInServiceBean bean) {
		return (List<HashMap<String, String>>)getSqlMapClientTemplate().queryForList("shopBukken.selectShopRireki", bean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao#selectImgCntEachCategory(net.chintai.backend.sysadmin.shop_bukken.service.bean.ImgCntEachCategoryInServiceBean)
	 */
	public List<ImgCntEachCategory> selectImgCntEachCategory(ImgCntEachCategoryInServiceBean bean) {
		return (List<ImgCntEachCategory>)getSqlMapClientTemplate().queryForList("shopBukken.selectImgCntEachCategory", bean);
	}

}
