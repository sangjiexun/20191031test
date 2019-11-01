/*
 * $Id: RosenSearchDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao;

import java.util.List;

/**
 * 沿線・駅を変更するDao
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface RosenNameSearchDao {

    /**
     * エリアコードや沿線タイプの条件で沿線を検索して、 その結果をリストで渡す。
     * @param paramBean 検索条件(エリアコード, 沿線タイプ)
     * @return 沿線リスト
     */
    public List selectEnsenByEnsenEkiName(RosenNameSearchParamBean paramBean);

}
