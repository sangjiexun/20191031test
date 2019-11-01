/*
 * $Id: FudousanDeleteConfirmService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/04     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanDeleteConfirmOutServiceBean;

/**
 * 不動産会社の削除リストを取得するサービスクラス
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3671 $ Copyright:
 * (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanDeleteConfirmService {

    /**
     * 不動産会社の削除リストを取得します。
     * @param inServiceBean 検索パラメータ
     * @return 削除する不動産会社の情報
     * @throws ApplicationException
     */
    public List<FudousanDeleteConfirmOutServiceBean> fudousanDeleteConfirm(
            FudousanDeleteConfirmInServiceBean inServiceBean) throws ApplicationException;

}
