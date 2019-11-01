/*
 * $Id: CjnUserAvailabilityUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/27   BGT)児島      新規作成
 * 2007/09/28   BGT)児島      インターフェースの修正に伴いメソッド追加
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeInfoDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeInfoParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfoUsers;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAvailabilityUpdatePageService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAvailabilityUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAvailabilityUpdatePageOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 閲覧可能ユーザの情報(変更画面用)を取得するサービス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAvailabilityUpdatePageServiceImpl
            implements CjnUserAvailabilityUpdatePageService {

    /** 問い合せ種別詳細取得DAO */
    private CjnInquiryTypeInfoDao typeInfodao;

    /**
     * 問い合せ種別詳細取得DAOを設定します。
     * @param dao
     */
    public void setCjnInquiryTypeInfoDao(CjnInquiryTypeInfoDao dao) {
        typeInfodao = dao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAvailabilityUpdatePageService#selectTypeInfoUsers(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAvailabilityUpdatePageInServiceBean)
     */
    public CjnUserAvailabilityUpdatePageOutServiceBean
            selectTypeInfoUsers(CjnUserAvailabilityUpdatePageInServiceBean inBean) {

        // 問い合せ詳細情報取得
        CjnInquiryTypeInfoParamBean param = new CjnInquiryTypeInfoParamBean();
        param.setCjnInqKindSeq(inBean.getCjnInqKindSeq());
        CjnInquiryTypeInfo domain = typeInfodao.selectTypeInfo(param);

        // 閲覧可否情報取得
        List<CjnInquiryTypeInfoUsers> userList = typeInfodao.selectTypeInfoUsers(param);

        // userList の構築
        CjnUserAvailabilityUpdatePageOutServiceBean outBean =
                new CjnUserAvailabilityUpdatePageOutServiceBean();
        List<CjnUserAvailabilityUpdatePageOutServiceBean.ReadableUserBean> rsList =
                new ArrayList<CjnUserAvailabilityUpdatePageOutServiceBean.ReadableUserBean>();

        if (userList != null) {
            for (int i = 0; i < userList.size(); i++) {
                try {
                    CjnUserAvailabilityUpdatePageOutServiceBean.ReadableUserBean userBean =
                            outBean.new ReadableUserBean();
                    BeanUtils.copyProperties(userBean, userList.get(i));
                    rsList.add(userBean);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // プロパティをセット
        outBean.setReadableUserList(rsList);
        outBean.setCjnInqKindSeq(domain.getCjnInqKindSeq());
        outBean.setInqTitle(domain.getInqTitle());
        outBean.setInqComment(domain.getInqComment());
        return outBean;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAvailabilityUpdatePageService#selectLastUpdateTime(int)
     */
    public String selectLastUpdateTime(int cjnInqKindSeq) {
        return typeInfodao.selectLastUpdateTimeForReadableUsers(cjnInqKindSeq);
    }
}
