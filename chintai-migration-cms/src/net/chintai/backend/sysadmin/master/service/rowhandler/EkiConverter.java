/*
 * $Id: EkiConverter.java 3802 2008-02-20 00:34:49Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/12/26   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.rowhandler;

import net.chintai.backend.sysadmin.common.rowhandler.StringArrayConverter;
import net.chintai.backend.sysadmin.master.domain.EkiDomain;

/**
 * 駅CSVコンバータ。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3802 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EkiConverter implements StringArrayConverter {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.rowhandler.StringArrayConverter#toStringArray(java.lang.Object)
     */
    public String[] toStringArray(Object obj) {
        EkiDomain eki = (EkiDomain) obj;
        
        return new String[] {
                eki.getEnsenCd(),
                eki.getEkiCd(),
                null,
                eki.getEkiName()
                };
    }
}
