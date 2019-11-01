/*
 * $Id: PrefNameSearchService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.demand.service.bean.PrefNameSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.PrefNameSearchOutServiceBean;


/**
 * 都道府県名称を取得するサービス。<Br>
 * 物件枠機能で共通で使われるサービス
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface PrefNameSearchService {

    /**
     * 都道府県名を取得します。
     * @param inBean 検索パラメータ（都道府県コード）
     * @return 都道府県名
     */
    public PrefNameSearchOutServiceBean getPrefName(PrefNameSearchInServiceBean inBean);
}
