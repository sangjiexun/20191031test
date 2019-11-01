/*
 * $Id: TorihikisakiListService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiListInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiListOutServiceBean;

/**
 * 取引先一覧CSV出力サービス
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiListService {

    /**
     * CSV出力用データを検索
     * @param inBean 検索パラメータ
     * @param condition ページング情報
     * @return 検索結果
     */
    public List<TorihikisakiListOutServiceBean> getTorihikisakiList(
            TorihikisakiListInServiceBean inBean, BasePagerCondition condition);
}
