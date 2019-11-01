/*
 * $Id: CjnInquiryTypeListServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島       新規作成
 * 2007/10/21   BGT)児島       新規メソッド追加
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeListDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryReadableUser;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeList;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeListService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeListOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * CjnInquiryTypeListService の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeListServiceImpl implements CjnInquiryTypeListService {

    /** 問い合せ種別一覧取得DAO */
    private CjnInquiryTypeListDao typeListDao;

    /**
     * 問い合せ種別一覧取得DAOを設定します。
     * @param dao
     */
    public void setCjnInquiryTypeListDao(CjnInquiryTypeListDao dao) {
        typeListDao = dao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeListService#selectTypeList()
     */
    public List<CjnInquiryTypeListOutServiceBean> selectTypeList() {
        List<CjnInquiryTypeList> domainList = typeListDao.selectTypeList();
        List<CjnInquiryTypeListOutServiceBean> beanList = new ArrayList<CjnInquiryTypeListOutServiceBean>();

        if (domainList != null) {
            try {
                for (int i = 0; i < domainList.size(); i++) {
                    CjnInquiryTypeListOutServiceBean bean = new CjnInquiryTypeListOutServiceBean();
                    BeanUtils.copyProperties(bean, domainList.get(i));
                    beanList.add(bean);
                }
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return beanList;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeListService#selectReadableUsersListsMap()
     */
    public Map<Integer, List<String>> selectReadableUsersListsMap() {
        List<CjnInquiryReadableUser> rsList = typeListDao.selectReadableUsersList();

        if (rsList != null) {

            // Select 結果セットを cjnInqKindSeq 単位で List に分割する。
            // 各 List は、Map に入れておく。
            Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

            for (int i = 0; i < rsList.size(); i++) {
                int kindSeq = rsList.get(i).getCjnInqKindSeq();

                if (map.containsKey(kindSeq)) {
                    // すでに cjnInqKindSeq が存在する場合は、
                    // map 内の該当する List の内容を更新する
                    map.get(kindSeq).add(rsList.get(i).getUserName());
                } else {
                    // 新規 cjnInqKindSeq の場合は、新たに List を作成して Map に登録
                    List<String> usersListBySeq = new ArrayList<String>();
                    usersListBySeq.add(rsList.get(i).getUserName());
                    map.put(kindSeq, usersListBySeq);
                }
            }
            return map;
        }
        return null;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeListService#selectAccountType(java.lang.String)
     */
    public String selectAccountType(String userId) {
        return typeListDao.selectAccountType(userId);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeListService#selectKindSeqList(java.lang.String)
     */
    public List<Integer> selectKindSeqList(String userId) {
        return typeListDao.selectKindSeqList(userId);
    }
}
