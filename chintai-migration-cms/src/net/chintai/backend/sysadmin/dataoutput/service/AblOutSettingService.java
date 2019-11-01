/*
 * $Id: AblOutSettingService.java 4721 2013-11-05 07:52:31Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/11     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service;

import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.service.bean.AblOutSettingOutServiceBean;


/**
 * エイブル担当店/取扱店出力情報取得用Service
 * @author KAMEDA Takuma
 * @version $Revision: 4721 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AblOutSettingService {

    /**
     * エイブル担当店/取扱店出力情報を取得する
     * @return　エイブル担当店/取扱店出力情報List
     */
    public List<AblOutSettingOutServiceBean> getAblOutDateList();

}
