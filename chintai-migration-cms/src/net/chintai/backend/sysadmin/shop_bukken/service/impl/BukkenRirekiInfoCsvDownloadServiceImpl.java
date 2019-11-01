/*
 * $Id: BukkenRirekiInfoCsvDownloadServiceImpl.java 3922 2008-05-27 09:38:05Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/05/27  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoCsvDownloadParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.BukkenRirekiInfoCsvDownload;
import net.chintai.backend.sysadmin.shop_bukken.domain.ColumnComments;
import net.chintai.backend.sysadmin.shop_bukken.domain.ImgCntEachCategory;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenRirekiInfoCsvDownloadService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenRirekiInfoCsvDownloadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenRirekiInfoCsvDownloadOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadColumnInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadShopInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ImgCntEachCategoryInServiceBean;

/**
 * BukkenRirekiInfoCsvDownloadServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 3922 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenRirekiInfoCsvDownloadServiceImpl implements BukkenRirekiInfoCsvDownloadService {

    /** 入稿履歴検索DAO(CVS出力用) */
    BukkenRirekiInfoCsvDownloadDao bukkenRirekiInfoCsvDownloadDao;

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.BukkenRirekiInfoCsvDownloadInService#getBukkenRirekiInfo(net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenRirekiInfoCsvDownloadInServiceBean)
     */
    public List<BukkenRirekiInfoCsvDownloadOutServiceBean> getBukkenRirekiInfo(
            BukkenRirekiInfoCsvDownloadInServiceBean inBean) throws InvocationTargetException,
            IllegalAccessException {

        BukkenRirekiInfoCsvDownloadParamBean paramBean = new BukkenRirekiInfoCsvDownloadParamBean();
        BeanUtils.copyProperties(paramBean, inBean);

        List<BukkenRirekiInfoCsvDownload> rsList = new ArrayList<BukkenRirekiInfoCsvDownload>();
        List<BukkenRirekiInfoCsvDownloadOutServiceBean> returnList =
                new ArrayList<BukkenRirekiInfoCsvDownloadOutServiceBean>();
        rsList = bukkenRirekiInfoCsvDownloadDao.getbukkenRirekiInfo(paramBean);

        BukkenRirekiInfoCsvDownload domain;
        for (int i = 0; i < rsList.size(); i++) {
            domain = rsList.get(i);

            BukkenRirekiInfoCsvDownloadOutServiceBean outBean =
                    new BukkenRirekiInfoCsvDownloadOutServiceBean();
            BeanUtils.copyProperties(outBean, domain);
            returnList.add(outBean);
        }

        return returnList;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.BukkenRirekiInfoCsvDownloadService#getCsvDownloadTable(java.lang.String, net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadInServiceBean, net.chintai.backend.sysadmin.shop_bukken.service.bean.CsvDownloadShopInServiceBean)
     */
    public List<String[]> getCsvDownloadTable(final String tableName, final CsvDownloadInServiceBean bean, final CsvDownloadShopInServiceBean shopBean){
    	final List<String[]> csvList = new ArrayList<String[]>();

    	final CsvDownloadColumnInServiceBean csvDownloadColumnInServiceBean = new CsvDownloadColumnInServiceBean();
    	csvDownloadColumnInServiceBean.setTableName(tableName);

    	//暗号化されているカラムは除外
    	if("SHOP_INQUIRY".equals(tableName)){
    		csvDownloadColumnInServiceBean.setExcludeColumns(SystemProperties.getProperties("EXCLUDE_COLUMN_SHOP_INQUIRY"));
    	}else if("ABL_SHOP_INQUIRY".equals(tableName)){
    		csvDownloadColumnInServiceBean.setExcludeColumns(SystemProperties.getProperties("EXCLUDE_COLUMN_ABL_SHOP_INQUIRY"));
    	}

    	final List<ColumnComments> ColumnCommentsList = bukkenRirekiInfoCsvDownloadDao.selectColumnComments(csvDownloadColumnInServiceBean);
    	if(CollectionUtils.isEmpty(ColumnCommentsList)){
    		return null;
    	}

    	final List<String> columnNameList = new ArrayList<String>();
    	final List<String> commentsList = new ArrayList<String>();
    	for(final ColumnComments data: ColumnCommentsList){
    		columnNameList.add(data.getColumnName());
			commentsList.add(StringUtils.isNotEmpty(data.getComments()) ? data.getComments(): data.getColumnName());//コメントが空だったらカラム名をいれる
    	}

    	//CSVのヘッダー作成
    	csvList.add(commentsList.toArray(new String[0]));

    	List<HashMap<String, String>> mapList = new ArrayList<HashMap<String, String>>();

    	if("BUKKEN_RIREKI".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectBukkenRireki(bean);
    	}else if("BUKKEN_RIREKI_COMMENT".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectBukkenRirekiComment(bean);
    	}else if("BUKKEN_RIREKI_EKI".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectBukkenRirekiEki(bean);
    	}else if("BUKKEN_RIREKI_IMG".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectBukkenRirekiImg(bean);
    	}else if("BUKKEN_RIREKI_MADORI".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectBukkenRirekiMadori(bean);
    	}else if("BUKKEN_RIREKI_SHOP".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectBukkenRirekiShop(bean);
    	}else if("BUKKEN_RIREKI_AROUND".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectBukkenRirekiAround(bean);
    	}else if("BUKKEN_RIREKI_ROAD".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectBukkenRirekiRoad(bean);
    	}else if("BUKKEN_RIREKI_CHUSHA".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectBukkenRirekiChusha(bean);
    	}else if("BUKKEN_RIREKI_FEATURE".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectBukkenRirekiFeature(bean);
    	}else if("BUKKEN_RIREKI_CHARACTER".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectBukkenRirekiCharacter(bean);
    	}else if("BUKKEN_RIREKI_HIYOU".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectBukkenRirekiHiyou(bean);
    	}else if("BUKKEN_RIREKI_ZONING".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectBukkenRirekiZoning(bean);
    	}else if("SHOP_INQUIRY".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectShopInquiry(bean);
    	}else if("ABL_SHOP_INQUIRY".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectAblShopInquiry(bean);
    	}else if("SHOP_RIREKI".equals(tableName)){
    		mapList = bukkenRirekiInfoCsvDownloadDao.selectShopRireki(shopBean);
    	}

    	for(final HashMap<String, String> map: mapList){
    		final List<String> sortList = new ArrayList<String>();
    		for(final String columnName: columnNameList){
    			final Object obj = map.get(columnName);
    			if(obj instanceof java.sql.Clob){
    				try {
    					java.sql.Clob clob = (java.sql.Clob)obj;
    					if(clob != null){
    						final String clobStr = clob.getSubString(1, (int)clob.length());
    						sortList.add(clobStr != null ? replaceAll(clobStr): "");
    					}
					} catch (SQLException e) {
						e.printStackTrace();
					}
    			}else{
    				sortList.add(obj != null ? replaceAll(obj.toString()) : "");
    			}
    		}
    		csvList.add(sortList.toArray(new String[0]));
		}

    	return csvList;
    }

    private String replaceAll(final String str){
    	return str.replaceAll("\r\n|\n|\r", "#BR#").replaceAll("\t", "#TAB#");
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.BukkenRirekiInfoCsvDownloadService#selectImgCntEachCategory(net.chintai.backend.sysadmin.shop_bukken.service.bean.ImgCntEachCategoryInServiceBean)
     */
    public List<ImgCntEachCategory> selectImgCntEachCategory(ImgCntEachCategoryInServiceBean bean) {
		return this.bukkenRirekiInfoCsvDownloadDao.selectImgCntEachCategory(bean);
	}

    /**
     * @return bukkenRirekiInfoCsvDownloadDao
     */
    public BukkenRirekiInfoCsvDownloadDao getBukkenRirekiInfoCsvDownloadDao() {
        return bukkenRirekiInfoCsvDownloadDao;
    }

    /**
     * @param bukkenRirekiInfoCsvDownloadDao 設定する bukkenRirekiInfoCsvDownloadDao
     */
    public void setBukkenRirekiInfoCsvDownloadDao(
            BukkenRirekiInfoCsvDownloadDao bukkenRirekiInfoCsvDownloadDao) {
        this.bukkenRirekiInfoCsvDownloadDao = bukkenRirekiInfoCsvDownloadDao;
    }

}
