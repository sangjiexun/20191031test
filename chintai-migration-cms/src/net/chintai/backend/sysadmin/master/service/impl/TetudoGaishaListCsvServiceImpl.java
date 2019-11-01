/*
 * $Id: TetudoGaishaListCsvServiceImpl.java 4076 2008-11-19 09:33:13Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/10/08  BGT)長谷川正一 新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.master.service.TetudoGaishaListCsvService;
import net.chintai.backend.sysadmin.master.service.bean.TetudoGaishaOutSearchServiceBean;

/**
 * TetudoGaishaListCsvServiceの実装クラス
 * 
 * @author S.HASEGAWA
 * @version $Revision: 4076 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class TetudoGaishaListCsvServiceImpl implements TetudoGaishaListCsvService {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.TetudoGaishaListCsvService#createTetudoGaishaListCsv(java.util.List)
     */
    public List<String[]> createTetudoGaishaListCsv(List<TetudoGaishaOutSearchServiceBean> tetudoGaishaList) {
        List<String[]> csvList = new ArrayList<String[]>();

        // CSVのHeaderを設定する。
        csvList.add(SystemProperties.getProperties("TetudoGaishaSearch.Header"));

        // 鉄道会社上h号をCSVフォーマットに変換する。
        for (TetudoGaishaOutSearchServiceBean tmp : tetudoGaishaList) {
            String delKbn = "";
            if (tmp.getDelKbn() == 1) {
                delKbn = "○";
            }
            csvList.add(new String[] { tmp.getRailwaycoNo(), tmp.getRailwaycoName(), tmp.getRailwaycoKana(),
                    tmp.getRailwaycoSeq(), delKbn });
        }
        return csvList;
    }
}
