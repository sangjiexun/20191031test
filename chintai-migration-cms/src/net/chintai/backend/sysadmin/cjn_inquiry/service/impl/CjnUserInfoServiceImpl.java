/*
 * $Id: CjnUserInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserInfoDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserInfoParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnUserAccountInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnUserInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserInfoService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAccountOutServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserInfoInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserInfoOutServiceBean;

/**
 * CjnUserInfoServiceの実行クラス
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserInfoServiceImpl implements CjnUserInfoService {

    /** 問い合せユーザ情報取得DAO */
    private CjnUserInfoDao cjnUserInfoDao;

    /**
     * 問い合せユーザ情報取得DAO設定
     * @param cjnUserInfoDao
     */
    public void setCjnUserInfoDao(CjnUserInfoDao cjnUserInfoDao) {
        this.cjnUserInfoDao = cjnUserInfoDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserInfoService#cjnAccountLevelList(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserInfoInServiceBean)
     */
    public List<CjnUserAccountOutServiceBean> cjnAccountLevelList(
            CjnUserInfoInServiceBean inServiceBean) {

        // paramBeanにCopy
        CjnUserInfoParamBean paramBean = new CjnUserInfoParamBean();
        paramBean.setCjnAccountSeq(inServiceBean.getCjnAccountSeq());

        // 問い合せユーザ権限取得
        String cjnAccountSeq = paramBean.getCjnAccountSeq();
        List<CjnUserAccountInfo> domainList = cjnUserInfoDao.cjnAccountLevelList(cjnAccountSeq);
        List<CjnUserAccountOutServiceBean> outList = new ArrayList<CjnUserAccountOutServiceBean>();

        if (domainList != null) {
            for (int i = 0; i < domainList.size(); i++) {
                try {
                    CjnUserAccountOutServiceBean outService = new CjnUserAccountOutServiceBean();
                    BeanUtils.copyProperties(outService, domainList.get(i));
                    outList.add(outService);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } 
            }

        }
        return outList;

    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserInfoService#selectCjnUser(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserInfoInServiceBean)
     */
    public CjnUserInfoOutServiceBean selectCjnUser(CjnUserInfoInServiceBean inServiceBean) {

        // paramBeanにCopy
        CjnUserInfoParamBean paramBean = new CjnUserInfoParamBean();
        paramBean.setCjnAccountSeq(inServiceBean.getCjnAccountSeq());

        // 問い合せユーザ権限取得
        String cjnAccountSeq = paramBean.getCjnAccountSeq();
        CjnUserInfo domainInfo = cjnUserInfoDao.selectCjnUser(cjnAccountSeq);

        CjnUserInfoOutServiceBean outServiceBean = new CjnUserInfoOutServiceBean();
        try {
            BeanUtils.copyProperties(outServiceBean, domainInfo);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return outServiceBean;
    }

}
