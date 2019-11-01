/*
 * $Id: CustomTagServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/11  BGT)李昊燮   新規作成
 * 2007/11/02  BGT)劉俊秀   Q&Aカテゴリ取得処理追加
 */
package net.chintai.backend.sysadmin.common.service.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.dao.CustomTagDao;
import net.chintai.backend.sysadmin.common.service.CustomTagService;

/**
 * カスタムタグ用のDAOです。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CustomTagServiceImpl implements CustomTagService {

    /** customTagDao */
    private CustomTagDao customTagDao = null;

    /**
     * customTagDao を設定します。
     * @param customTagDao
     */
    public void setCustomTagDao(CustomTagDao customTagDao) {
        this.customTagDao = customTagDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.service.CustomTagService#TodofukenListService()
     */
    public List todofukenListService() {
        return customTagDao.selectAreaTotal();
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.service.CustomTagService#userGroupListService()
     */
    public List userGroupListService() {
        return customTagDao.selectUserGroup();
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.service.CustomTagService#getOperationContentsListService()
     */
    public List getAuthorityService() {
        return customTagDao.selectAuthority();
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.service.CustomTagService#getgetAreaInfoService()
     */
    public List getAreaInfoService() {
        return customTagDao.selectAreaInfo();
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.service.CustomTagService#getgetAreaInfoService()
     */
    public List getMngMstQaCategoryService() {
        return customTagDao.selectQaCategory();
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.service.CustomTagService#getInquiryInfo()
     */
    public List getInquiryInfo() {
        return customTagDao.selectInquiryInfo();
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.service.CustomTagService#getShisyaInfo()
     */
    public List getShisyaInfo() {
        return customTagDao.selectShisyaInfo();
    }

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.common.service.CustomTagService#getMstInquiryKbn(java.lang.String)
	 */
	public List getMstInquiryKbn(final String inqKbnColName) {
		return customTagDao.selectMstInquiryKbn(inqKbnColName);
	}


	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.common.service.CustomTagService#getMstRendo()
	 */
	public List getMstRendo() {
		return customTagDao.selectMstRendo();
	}
}
