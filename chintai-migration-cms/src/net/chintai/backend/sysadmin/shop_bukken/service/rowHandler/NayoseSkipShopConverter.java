package net.chintai.backend.sysadmin.shop_bukken.service.rowHandler;

import net.chintai.backend.sysadmin.common.rowhandler.StringArrayConverter;
import net.chintai.backend.sysadmin.shop_bukken.domain.NayoseSkipShopDomain;


/**
 * 名寄せ対象外店舗のコンバータ
 *
 * @author e-ishii
 * @version $Revision: 4571 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class NayoseSkipShopConverter  implements StringArrayConverter {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.rowhandler.StringArrayConverter#toStringArray(java.lang.Object)
     */
    public String[] toStringArray(Object obj) {
        NayoseSkipShopDomain domain = (NayoseSkipShopDomain) obj;

        if (domain.getCompany() == null) {
            domain.setCompany("");
        }

        if (domain.getBumon() == null) {
            domain.setBumon("");
        }

        return new String[] {
                domain.getShopcd(),
                domain.getCompany(),
                domain.getBumon(),
                domain.getInsDt()
                };
    }

}
