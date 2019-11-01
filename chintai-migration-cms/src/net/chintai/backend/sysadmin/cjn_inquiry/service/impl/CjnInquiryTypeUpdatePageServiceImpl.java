/*
 * $Id: CjnInquiryTypeUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeUpdatePageDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeUpdatePageParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeUpdatePageService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeUpdatePageOutServiceBean;

/**
 * CjnInquiryTypeUpdatePageService の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeUpdatePageServiceImpl implements CjnInquiryTypeUpdatePageService {

    /** 問い合せ種別更新情報取得DAO */
    CjnInquiryTypeUpdatePageDao typeUpdatePageDao;

    /**
     * 問い合せ種別更新情報取得DAOを設定します。
     * @param dao
     */
    public void setCjnInquiryTypeUpdatePageDao(CjnInquiryTypeUpdatePageDao dao) {
        typeUpdatePageDao = dao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeUpdatePageService#selectTypeUpdatePage(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeUpdatePageInServiceBean)
     */
    public CjnInquiryTypeUpdatePageOutServiceBean selectTypeUpdatePage(
            CjnInquiryTypeUpdatePageInServiceBean inBean) {

        // DAO用パラメータ生成
        CjnInquiryTypeUpdatePageParamBean param = new CjnInquiryTypeUpdatePageParamBean();
        param.setCjnInqKindSeq(inBean.getCjnInqKindSeq());
        
        // データ取得DAO実行
        CjnInquiryTypeInfo domain = typeUpdatePageDao.selectTypeUpdatePage(param);
        CjnInquiryTypeUpdatePageOutServiceBean outBean =
                new CjnInquiryTypeUpdatePageOutServiceBean();

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
}
