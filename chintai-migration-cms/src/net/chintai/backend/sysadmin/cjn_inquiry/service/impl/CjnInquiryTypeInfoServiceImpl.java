/*
 * $Id: CjnInquiryTypeInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeInfoDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeInfoParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfoUsers;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeInfoService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeInfoInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeInfoOutServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeInfoUsersOutServiceBean;

/**
 * CjnInquiryTypeInfoService の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeInfoServiceImpl implements CjnInquiryTypeInfoService {

    /** 問い合せ種別詳細取得DAO */
    CjnInquiryTypeInfoDao typeInfoDao;

    /**
     * 問い合せ種別詳細取得DAOを設定します。
     * @param dao
     */
    public void setCjnInquiryTypeInfoDao(CjnInquiryTypeInfoDao dao) {
        typeInfoDao = dao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeInfoService#selectTypeInfo(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeInfoInServiceBean)
     */
    public CjnInquiryTypeInfoOutServiceBean selectTypeInfo(CjnInquiryTypeInfoInServiceBean inBean) {

        // DAO用パラメータ生成
        CjnInquiryTypeInfoParamBean param = new CjnInquiryTypeInfoParamBean();
        param.setCjnInqKindSeq(inBean.getCjnInqKindSeq());

        // データ取得DAO実行
        CjnInquiryTypeInfo domain = typeInfoDao.selectTypeInfo(param);
        CjnInquiryTypeInfoOutServiceBean outBean = new CjnInquiryTypeInfoOutServiceBean();
        
        if (domain != null) {
            try {
                BeanUtils.copyProperties(outBean, domain);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return outBean;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeInfoService#selectTypeInfoUsers(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeInfoInServiceBean)
     */
    public List<CjnInquiryTypeInfoUsersOutServiceBean>
                selectTypeInfoUsers(CjnInquiryTypeInfoInServiceBean inBean) {
        
        // DAO用パラメータ生成
        CjnInquiryTypeInfoParamBean param = new CjnInquiryTypeInfoParamBean();
        param.setCjnInqKindSeq(inBean.getCjnInqKindSeq());
        
        // データ取得DAO実行
        List<CjnInquiryTypeInfoUsers> domainList = typeInfoDao.selectTypeInfoUsers(param);
        List<CjnInquiryTypeInfoUsersOutServiceBean> outBeanList =
                new ArrayList<CjnInquiryTypeInfoUsersOutServiceBean>();
        
        if (domainList != null) {
            for (int i = 0; i < domainList.size(); i++) {
                CjnInquiryTypeInfoUsersOutServiceBean outBean =
                        new CjnInquiryTypeInfoUsersOutServiceBean();
                try {
                    BeanUtils.copyProperties(outBean, domainList.get(i));
                    outBeanList.add(outBean);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return outBeanList;
    }
}
