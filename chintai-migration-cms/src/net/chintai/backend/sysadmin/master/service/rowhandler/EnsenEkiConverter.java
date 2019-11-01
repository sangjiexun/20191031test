/*
 * $Id: EnsenEkiConverter.java 4027 2008-10-30 06:25:26Z m-ono $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/12/26   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.rowhandler;

import net.chintai.backend.sysadmin.common.rowhandler.StringArrayConverter;
import net.chintai.backend.sysadmin.master.domain.EnsenEkiDomain;

/**
 * 沿線駅コンバータ。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 4027 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class EnsenEkiConverter implements StringArrayConverter {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.rowhandler.StringArrayConverter#toStringArray(java.lang.Object)
     */
    public String[] toStringArray(Object obj) {
        EnsenEkiDomain ensenEki = (EnsenEkiDomain) obj;

        return new String[] {
                ensenEki.getEnsenCd(),
                ensenEki.getEnsenName(),
                ensenEki.getEnsenType(),
                ensenEki.getAreaCd(),
                ensenEki.getEnsenSortKey(),
                ensenEki.getEnsenUseStopFlg(),
                ensenEki.getEkiCd(),
                ensenEki.getEkiName(),
                ensenEki.getEkiSortKey(),
                ensenEki.getStopFlg(),
                ensenEki.getEkiUseStopFlg(),
                ensenEki.getEnsenKana(),
                ensenEki.getRailwaycoNo(),
                ensenEki.getEnsenSeq(),
                ensenEki.getEkiNo(),
                ensenEki.getStartekiFlg(),
                ensenEki.getEkiSeq(),
                ensenEki.getEnsennameShort(),
                ensenEki.getEnsenkanaShort()
                };
    }
}
