/*
 * $Id: DcoTypeService.java 4773 2014-01-09 08:06:59Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/11/08     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.dwr.service.bean.DcoTypeBean;


/**
 * 連携対象一覧のプルダウンを取得するサービスクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4773 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface DcoTypeService {
    public List<DcoTypeBean> getDcoTypeList(String dcoTypes);

}
