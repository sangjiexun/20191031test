/*
 * $Id: ShisyaNameSearchService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/03  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.demand.service.bean.ShisyaNameSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.ShisyaNameSearchOutServiceBean;


/**
 * 支社名を取得します
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShisyaNameSearchService {

    /**
     * 取引先担当支社名を取得します。
     * @param inBean 検索条件（支社コード）
     * @return 支社名称
     */
    public ShisyaNameSearchOutServiceBean getShisyaName(ShisyaNameSearchInServiceBean inBean);
}
