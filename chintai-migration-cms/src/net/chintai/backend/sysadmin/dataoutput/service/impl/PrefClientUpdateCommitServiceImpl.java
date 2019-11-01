/*
 * $Id: PrefClientUpdateCommitServiceImpl.java 4753 2013-11-05 09:17:52Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/23     BGT)亀田       E-0070 建物名表示に関する改修
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.dataoutput.dao.PrefClientSettingParamBean;
import net.chintai.backend.sysadmin.dataoutput.dao.PrefClientUpdateCommitDao;
import net.chintai.backend.sysadmin.dataoutput.dao.PrefClientUpdateParamBean;
import net.chintai.backend.sysadmin.dataoutput.service.PrefClientUpdateCommitService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.PrefClientSettingInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.PrefClientSystemCommitInServiceBean;


/**
 * PrefClientUpdateCommitServiceの実装クラス
 *
 * @author e-ishii
 * @version $Revision: 4753 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientUpdateCommitServiceImpl implements PrefClientUpdateCommitService {

    private PrefClientUpdateCommitDao prefClientUpdateCommitDao;

    public void prefClientUpdateCommit(PrefClientSettingInServiceBean inServiceBean) {

        List<PrefClientUpdateParamBean> list = new ArrayList<PrefClientUpdateParamBean>();

        List<PrefClientSystemCommitInServiceBean> commitList = inServiceBean.getCommitList();

        for (PrefClientSystemCommitInServiceBean serviceBean :commitList) {

            PrefClientUpdateParamBean paramBean = new PrefClientUpdateParamBean();
            BeanUtilsWrapper.copyProperties(paramBean, serviceBean);
            list.add(paramBean);
        }

        // 全件削除
        // 選択された他社データ連携種類のデータを削除 2013/10/24 追加
        PrefClientSettingParamBean dcoTypeParamBean = new PrefClientSettingParamBean();
        dcoTypeParamBean.setDcoType(inServiceBean.getDcoType());
        prefClientUpdateCommitDao.deletePrefSkipConfig(dcoTypeParamBean);
        // 対象外データのinsert
        prefClientUpdateCommitDao.insertPrefSkipConfig(list);
    }

    /**
     * prefClientUpdateCommitDaoを設定します。
     * @param prefClientUpdateCommitDao prefClientUpdateCommitDao
     */
    public void setPrefClientUpdateCommitDao(PrefClientUpdateCommitDao prefClientUpdateCommitDao) {
        this.prefClientUpdateCommitDao = prefClientUpdateCommitDao;
    }

}
