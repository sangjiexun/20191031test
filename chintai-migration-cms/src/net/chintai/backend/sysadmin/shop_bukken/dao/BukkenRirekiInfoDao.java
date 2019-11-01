/*
 * $Id: BukkenRirekiInfoDao.java 3918 2008-05-27 08:52:02Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/05/27  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.domain.BukkenRirekiInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.MstInsPg;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.MstInsPgInServiceBean;

/**
 * 入稿履歴検索DAO
 *
 * @author Lee Hosup
 * @version $Revision: 3918 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface BukkenRirekiInfoDao {

    /**
     * 入稿履歴検索
     * @param paramBean 検索条件
     * @return 入稿履歴情報
     */
    public List<BukkenRirekiInfo> getbukkenRirekiInfo(BukkenRirekiInfoParamBean paramBean);

    /**
     * 登録機能マスタ検索
     * @param bean
     * @return 登録機能マスタ情報
     */
    public List<MstInsPg> selectMstInsPg(MstInsPgInServiceBean bean);
}
