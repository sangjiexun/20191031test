/*
 * $Id: CjnUserAuthorityUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAuthorityUpdatePageDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnUserAuthorityUpdateInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAuthorityUpdatePageService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAuthorityUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAuthorityUpdatePageOutServiceBean;

/**
 * CjnUserAuthorityUpdatePageServiceの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAuthorityUpdatePageServiceImpl implements CjnUserAuthorityUpdatePageService {

    /** 問い合わせ閲覧可能リストを取得するDao */
    private CjnUserAuthorityUpdatePageDao cjnUserAuthorityUpdatePageDao;

    /**
     * 問い合わせ閲覧可能リストを取得するDaoを設定する。
     * @param cjnUserAuthorityUpdatePageDao
     */
    public void setCjnUserAuthorityUpdatePageDao(
            CjnUserAuthorityUpdatePageDao cjnUserAuthorityUpdatePageDao) {
        this.cjnUserAuthorityUpdatePageDao = cjnUserAuthorityUpdatePageDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAuthorityUpdatePageService#selectCjnAccountLevel()
     */
    public List<CjnUserAuthorityUpdatePageOutServiceBean> selectCjnAccountLevel(
            CjnUserAuthorityUpdatePageInServiceBean inServiceBean) {

        // 検索パラメターを取得
        String cjnAccountSeq = inServiceBean.getCjnAccountSeq();

        // 権限リストをドメインに
        List<CjnUserAuthorityUpdateInfo> domainList =
                cjnUserAuthorityUpdatePageDao.selectCjnAccountLevelList(cjnAccountSeq);

        List<CjnUserAuthorityUpdatePageOutServiceBean> outList =
                new ArrayList<CjnUserAuthorityUpdatePageOutServiceBean>();

        for (int i = 0; i < domainList.size(); i++) {
            try {
                CjnUserAuthorityUpdatePageOutServiceBean outServiceBean =
                        new CjnUserAuthorityUpdatePageOutServiceBean();
                BeanUtils.copyProperties(outServiceBean, domainList.get(i));
                outList.add(outServiceBean);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        return outList;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserAuthorityUpdatePageService#selectLastUpdateDt(CjnUserAuthorityUpdatePageInServiceBean inServiceBean)
     */
    public String selectLastUpdateDt(CjnUserAuthorityUpdatePageInServiceBean inServiceBean) {
        String cjnAccountSeq = inServiceBean.getCjnAccountSeq();
        return cjnUserAuthorityUpdatePageDao.selectLastUpdateDt(cjnAccountSeq);
    }
}
