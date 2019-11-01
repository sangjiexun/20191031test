/*
 * $Id: BukkenRirekiInfoDaoImpl.java 3916 2008-05-27 08:34:12Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/05/27  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.BukkenRirekiInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.MstInsPg;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.MstInsPgInServiceBean;

/**
 * BukkenRirekiInfoDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 3916 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenRirekiInfoDaoImpl extends SqlMapClientDaoSupport implements BukkenRirekiInfoDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoDao#getbukkenRirekiInfo(net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<BukkenRirekiInfo> getbukkenRirekiInfo(BukkenRirekiInfoParamBean paramBean) {

        return getSqlMapClientTemplate().queryForList("shopBukken.bukkenRirekiInfo", paramBean);
    }

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenRirekiInfoDao#selectMstInsPg(net.chintai.backend.sysadmin.shop_bukken.service.bean.MstInsPgInServiceBean)
	 */
	public List<MstInsPg> selectMstInsPg(MstInsPgInServiceBean bean) {
		return (List<MstInsPg>)getSqlMapClientTemplate().queryForList("shopBukken.selectMstInsPg", bean);
	}

}
