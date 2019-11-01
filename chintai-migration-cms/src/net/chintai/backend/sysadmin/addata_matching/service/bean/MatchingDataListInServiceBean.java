/*
 * $Id: MatchingDataListInServiceBean.java 4367 2009-09-01 05:37:54Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/26     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;


/**
 * 照合結果一覧InServiceBean
 * @author e-ishii
 * @version $Revision: 4367 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MatchingDataListInServiceBean implements SessionSearchCondition {

    /** serialVersionUID */
    private static final long serialVersionUID = 7808204204211553833L;

    /** 開始位置 */
    private int offSet;

    /**
     * 開始位置を取得します。
     * @return 開始位置
     */
    public int getOffSet() {
        return offSet;
    }

    /**
     * 開始位置を設定します。
     * @param offSet 開始位置
     */
    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

}
