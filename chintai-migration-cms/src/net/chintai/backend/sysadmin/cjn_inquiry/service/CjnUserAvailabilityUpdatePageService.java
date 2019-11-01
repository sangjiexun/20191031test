/*
 * $Id: CjnUserAvailabilityUpdatePageService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27   BGT)児島       新規作成
 * 2007/09/28   BGT)児島       selectLastUpdateTime メソッドを追加
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAvailabilityUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserAvailabilityUpdatePageOutServiceBean;

/**
 * 閲覧可能ユーザ情報を取得するサービス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnUserAvailabilityUpdatePageService {

    /**
     * 閲覧可能ユーザ情報の一覧を取得します。
     * @param bean 検索パラメータ
     * @return 閲覧可能ユーザ情報
     */
    public CjnUserAvailabilityUpdatePageOutServiceBean
                selectTypeInfoUsers(CjnUserAvailabilityUpdatePageInServiceBean bean);
    
    /**
     * 閲覧可能ユーザ情報の最終更新日時を取得します。<br>
     * 対象となる複数件のデータのうち、最も直近に更新されたデータの日時を取得します。
     * @param cjnInqKindSeq 対象とする問い合せ種別
     * @return 最終更新日時
     */
    public String selectLastUpdateTime(int cjnInqKindSeq);
}
