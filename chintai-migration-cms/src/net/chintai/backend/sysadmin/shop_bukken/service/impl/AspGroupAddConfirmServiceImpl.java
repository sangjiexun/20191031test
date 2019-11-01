/*
 * $Id: AspGroupAddConfirmServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupAddConfirmDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupSearchParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspGroupInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.AspGroupAddConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * AspGroupAddConfirmServiceの実装クラス
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupAddConfirmServiceImpl implements AspGroupAddConfirmService {

    /** 不動産ASPグループ設定する店舗情報を取得 */
    private AspGroupAddConfirmDao aspGroupAddConfirmDao;

    /**
     * 不動産ASPグループ設定する店舗情報を取得
     * @param aspGroupAddConfirmDao
     */
    public void setAspGroupAddConfirmDao(AspGroupAddConfirmDao aspGroupAddConfirmDao) {
        this.aspGroupAddConfirmDao = aspGroupAddConfirmDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.AspGroupAddConfirmService#selectAspGroupAdd(net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupInfoInServiceBean)
     */
    public List<AspGroupInfoOutServiceBean> selectAspGroupAdd(
            AspGroupInfoInServiceBean inServiceBean) {

        AspGroupSearchParamBean paramBean = new AspGroupSearchParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // グループ化する店舗取得
        List<AspGroupInfo> shopDomain = aspGroupAddConfirmDao.selectGroupShopSearch(paramBean);
        List<AspGroupInfoOutServiceBean> groupList = new ArrayList<AspGroupInfoOutServiceBean>();

        //不動産ASP連番取得
        Long aspShopSeq = aspGroupAddConfirmDao.selectAspShopSeq(paramBean.getShopCd());

        // グループ化する店舗取得設定
        if (shopDomain != null) {
            for (int i = 0; i < shopDomain.size(); i++) {
                try {
                    AspGroupInfoOutServiceBean outBean = new AspGroupInfoOutServiceBean();
                    BeanUtils.copyProperties(outBean, shopDomain.get(i));
                    outBean.setAspShopSeq(aspShopSeq);
                    groupList.add(outBean);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return groupList;
    }

    public int selectAspGroupShopSearch(AspGroupInfoInServiceBean inServiceBean) {

        AspGroupSearchParamBean paramBean = new AspGroupSearchParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        int count = aspGroupAddConfirmDao.selectGroupShopCount(paramBean);

        return count;
    }

}
