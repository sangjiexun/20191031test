package net.chintai.backend.sysadmin.shop_bukken.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;


public class NayoseSkipShopSearchInServiceBean implements SessionSearchCondition {


    /** */
    private static final long serialVersionUID = -7676230741444440385L;
    private int offSet;

    /**
     * offSetを取得します。
     * @return offSet
     */
    public int getOffSet() {
        return offSet;
    }

    /**
     * offSetを設定します。
     * @param offSet offSet
     */
    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }



}
