/*
 * $Id: BukkenRirekiInfoServiceImpl.java 3922 2008-05-27 09:38:05Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/05/27  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.BukkenRirekiInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.MstInsPg;
import net.chintai.backend.sysadmin.shop_bukken.domain.SystemNameBean;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenRirekiInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenRirekiInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenRirekiInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.MstInsPgInServiceBean;
import net.chintai.batch.common.domain.MstFormatType;
import net.chintai.batch.common.domain.MstRendo;


/**
 * BukkenRirekiInfoServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 3922 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenRirekiInfoServiceImpl implements BukkenRirekiInfoService {
   /** 入稿履歴検索DAO */
    BukkenRirekiInfoDao bukkenRirekiInfoDao;

    @Autowired
	private MasterService masterService;


    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.BukkenRirekiInfoService#getBukkenRirekiInfo(net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenRirekiInfoInServiceBean)
     */
    public List<BukkenRirekiInfoOutServiceBean> getBukkenRirekiInfo(BukkenRirekiInfoInServiceBean inBean)
        throws InvocationTargetException, IllegalAccessException{

        BukkenRirekiInfoParamBean paramBean = new BukkenRirekiInfoParamBean();
        BeanUtils.copyProperties(paramBean, inBean);

        List<BukkenRirekiInfo> rsList = new ArrayList<BukkenRirekiInfo>();
        List<BukkenRirekiInfoOutServiceBean> returnList = new ArrayList<BukkenRirekiInfoOutServiceBean>();
        rsList = bukkenRirekiInfoDao.getbukkenRirekiInfo(paramBean);

        BukkenRirekiInfo domain;
        for (int i=0; i < rsList.size(); i++) {
            domain = rsList.get(i);

            BukkenRirekiInfoOutServiceBean outBean = new BukkenRirekiInfoOutServiceBean();
            BeanUtils.copyProperties(outBean, domain);
            returnList.add(outBean);
        }
        return returnList;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.BukkenRirekiInfoService#getSystemName(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String)
     */
    public SystemNameBean getSystemName(String brInsPg, String bskInsPg, String brUpdPg, String bskUpdPg, boolean isKoumokuHokanSystem, String rendoName) {
    	final SystemNameBean bean = new SystemNameBean();

    	//参照優先順位1
    	final MstInsPgInServiceBean bukkenRirekiBean = new MstInsPgInServiceBean();
    	bukkenRirekiBean.setReferencePriority("1");
    	final List<MstInsPg> mstInsPgListByBukkenRireki = bukkenRirekiInfoDao.selectMstInsPg(bukkenRirekiBean);

    	for(final MstInsPg mstInsPg: mstInsPgListByBukkenRireki){
    		final String pg = mstInsPg.getPg();
    		if(pg.equals(brInsPg)){
    			bean.setSystemName(mstInsPg.getPgName());
    			bean.setCategoryName(mstInsPg.getSystemCategoryName());
    			return bean;
    		}
    	}

    	//参照優先順位2
    	final MstInsPgInServiceBean bukkenStatusKanriBean = new MstInsPgInServiceBean();
    	bukkenStatusKanriBean.setReferencePriority("2");
    	final List<MstInsPg> mstInsPgListByBukkenStatusKanri = bukkenRirekiInfoDao.selectMstInsPg(bukkenStatusKanriBean);

    	for(final MstInsPg mstInsPg: mstInsPgListByBukkenStatusKanri){
    		final String pg = mstInsPg.getPg();
    		if(pg.equals(bskInsPg)){
    			if("ChintaiEntry".equals(pg)){
    				bean.setSystemName(StringUtils.isNotEmpty(rendoName)? rendoName: mstInsPg.getPgName());
    			}else if("net.chintai.receive.crsplus.controller.BukkenController".equals(pg)){
    				if(isKoumokuHokanSystem){
    					bean.setSystemName("項目補完");
    				}else{
    					bean.setSystemName(StringUtils.isNotEmpty(rendoName)? rendoName: mstInsPg.getPgName());
    				}
    			}else{
    				bean.setSystemName(mstInsPg.getPgName());
    			}
    			bean.setCategoryName(mstInsPg.getSystemCategoryName());
    			return bean;
    		}
    	}

    	bean.setSystemName("その他");
		bean.setCategoryName("その他");
		return bean;
	}

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.BukkenRirekiInfoService#isNyukoSystem(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public String isNyukoSystem(String brInsPg, String bskInsPg, String brUpdPg, String bskUpdPg) {
    	//参照優先順位1
    	final MstInsPgInServiceBean bukkenRirekiBean = new MstInsPgInServiceBean();
    	bukkenRirekiBean.setReferencePriority("1");
    	final List<MstInsPg> mstInsPgListByBukkenRireki = bukkenRirekiInfoDao.selectMstInsPg(bukkenRirekiBean);

    	for(final MstInsPg mstInsPg: mstInsPgListByBukkenRireki){
    		final String pg = mstInsPg.getPg();
    		if(pg.equals(brInsPg)){
    			return "false";
    		}
    	}

    	//参照優先順位2
    	final MstInsPgInServiceBean bukkenStatusKanriBean = new MstInsPgInServiceBean();
    	bukkenStatusKanriBean.setReferencePriority("2");
    	final List<MstInsPg> mstInsPgListByBukkenStatusKanri = bukkenRirekiInfoDao.selectMstInsPg(bukkenStatusKanriBean);

    	for(final MstInsPg mstInsPg: mstInsPgListByBukkenStatusKanri){
    		final String pg = mstInsPg.getPg();
    		if(pg.equals(bskInsPg)){
	    		final String systemCategoryName = mstInsPg.getSystemCategoryName();
	    		if("入稿システム".equals(systemCategoryName)){
	    			return "true";
	    		}
    		}
    	}
    	return "false";
	}

    /**
     * @return bukkenRirekiInfoDao
     */
    public BukkenRirekiInfoDao getBukkenRirekiInfoDao() {
        return bukkenRirekiInfoDao;
    }

    /**
     * @param bukkenRirekiInfoDao 設定する bukkenRirekiInfoDao
     */
    public void setBukkenRirekiInfoDao(BukkenRirekiInfoDao bukkenRirekiInfoDao) {
        this.bukkenRirekiInfoDao = bukkenRirekiInfoDao;
    }

}
