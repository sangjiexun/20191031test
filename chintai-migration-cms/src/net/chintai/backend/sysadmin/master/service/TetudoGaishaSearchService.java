/*
 * $Id: TetudoGaishaSearchService.java 4076 2008-11-19 09:33:13Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/10/08  BGT)長谷川正一 新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.master.service.bean.TetudoGaishaInSearchrviceBean;
import net.chintai.backend.sysadmin.master.service.bean.TetudoGaishaOutSearchServiceBean;

/**
 * 鉄道会社情報照会Service。
 * 
 * @author S.HASEGAWA
 * @version $Revision: 4076 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public interface TetudoGaishaSearchService {

    /**
     * 鉄道会社検索条件Beanを元に鉄道会社情報を取得するメソッド。
     * 
     * @param inServiceBean 鉄道会社検索条件Bean
     * @param condition ページングデータ
     * @return 検索結果の鉄道会社情報Beanリスト
     * @throws Exception
     */
    public List<TetudoGaishaOutSearchServiceBean> tetudoGaishaSearch(TetudoGaishaInSearchrviceBean inServiceBean,
            BasePagerCondition condition) throws Exception;

}