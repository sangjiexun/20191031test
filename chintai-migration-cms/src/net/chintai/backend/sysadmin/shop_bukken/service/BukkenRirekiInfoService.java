/*
 * $Id: BukkenRirekiInfoService.java 3922 2008-05-27 09:38:05Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/05/27  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.domain.ImgCntEachCategory;
import net.chintai.backend.sysadmin.shop_bukken.domain.SystemNameBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenRirekiInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenRirekiInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ImgCntEachCategoryInServiceBean;

/**
 * 入稿履歴一覧サービス
 *
 * @author Lee Hosup
 * @version $Revision: 3922 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface BukkenRirekiInfoService {

    /**
     * 入稿履歴情報を取得します。
     *
     * @param inBean 検索条件
     * @return 入稿履歴情報
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public List<BukkenRirekiInfoOutServiceBean> getBukkenRirekiInfo(
            BukkenRirekiInfoInServiceBean inBean) throws InvocationTargetException,
            IllegalAccessException;

    /**
     * @param brInsPg
     * @param bskInsPg
     * @param brUpdPg
     * @param bskUpdPg
     * @param formatTypeCd
     * @param isKoumokuHokanSystem
     * @param rendoName
     * @return
     */
    public SystemNameBean getSystemName(final String brInsPg, final String bskInsPg, final String brUpdPg, final String bskUpdPg, final boolean isKoumokuHokanSystem, final String rendoName);

    /**
     * @param brInsPg
     * @param bskInsPg
     * @param brUpdPg
     * @param bskUpdPg
     * @return
     */
    public String isNyukoSystem(final String brInsPg, final String bskInsPg, final String brUpdPg, final String bskUpdPg);

}
