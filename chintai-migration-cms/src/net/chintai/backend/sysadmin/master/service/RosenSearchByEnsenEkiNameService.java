/*
 * $Id: RosenSearchByAreaCdRosenTypeService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service;

import java.util.List;

import net.chintai.backend.sysadmin.master.service.bean.RosenNameSearchInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.RosenNameSearchOutServiceBean;

/**
 * 沿線・駅照会するService。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface RosenSearchByEnsenEkiNameService {

    /**
     * エリアコード、沿線タイプの条件で沿線を検索する。
     *
     * @param inServiceBean 検索条件(エリアコード, 沿線タイプ)
     * @return 検索結果の沿線リスト
     * @throws Exception
     */
    public List<RosenNameSearchOutServiceBean> rosenSearchByEnsenEkiName(RosenNameSearchInServiceBean inServiceBean)
            throws Exception;

}
