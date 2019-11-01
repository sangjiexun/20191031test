/*
 * $Id: BukkenInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/01  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.RandomStringUtils;

import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.Bukken;
import net.chintai.backend.sysadmin.shop_bukken.domain.TantouShop;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenInfoTantouShopOutServiceBean;
import net.chintai.batch.common.util.CryptUtils;

/**
 * BukkenInfoServiceの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenInfoServiceImpl implements BukkenInfoService {

    /** 物件詳細処理DAO */
    private BukkenInfoDao bukkenInfoDao = null;

    /**
     * BukkenInfoDaoを設定する
     * @param bukkenInfoDao
     */
    public void setBukkenInfoDao(BukkenInfoDao bukkenInfoDao) {
        this.bukkenInfoDao = bukkenInfoDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.BukkenInfoService#bukkenInfo(net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenInfoInServiceBean)
     */
    public BukkenInfoOutServiceBean bukkenInfo(BukkenInfoInServiceBean inServiceBean) throws InvocationTargetException,
            IllegalAccessException {

        // 管理コードをParamBeanに設定
        BukkenInfoParamBean paramBean = new BukkenInfoParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // 物件詳細情報を取得
        Bukken bukken = bukkenInfoDao.bukkenInfo(paramBean);
        //複合化
        bukken.setPassword(CryptUtils.decypt(bukken.getPassword()));

/*
        String random = RandomStringUtils.randomAlphanumeric(8);
        System.out.println(random);
        System.out.println(CryptUtils.encypt(random));
*/
        // 取得した情報をOutServiceBeanに設定
        BukkenInfoOutServiceBean outServiceBean = new BukkenInfoOutServiceBean();
        BeanUtils.copyProperties(outServiceBean, bukken);

        return outServiceBean;
    }

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.service.BukkenInfoService#bukkenInfoTantouShop(net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenInfoInServiceBean)
	 */
	public List bukkenInfoTantouShop(BukkenInfoInServiceBean inServiceBean) throws InvocationTargetException, IllegalAccessException {
		// 管理コードをParamBeanに設定
        BukkenInfoParamBean paramBean = new BukkenInfoParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // 担当店情報を取得
        List tantouShopList = bukkenInfoDao.bukkenInfoTantouShop(paramBean);
        List<BukkenInfoTantouShopOutServiceBean> newList = new ArrayList<BukkenInfoTantouShopOutServiceBean>();

        // Domainにある検索結果をOutServiceBeanに設定
        for (int i = 0; i < tantouShopList.size(); i++) {
        	BukkenInfoTantouShopOutServiceBean outServiceBean = new BukkenInfoTantouShopOutServiceBean();
        	TantouShop tantouShop = (TantouShop) tantouShopList.get(i);
            BeanUtils.copyProperties(outServiceBean, tantouShop);

            newList.add(outServiceBean);
        }
        return newList;
	}
}