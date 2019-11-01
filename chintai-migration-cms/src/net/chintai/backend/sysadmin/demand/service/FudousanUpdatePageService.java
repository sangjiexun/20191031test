/*
 * $Id: FudousanUpdatePageService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/29     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanUpdatePageOutServiceBean;

/**
 * 不動産会社更新画面
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanUpdatePageService {

    /**
     * 不動産会社更新画面に表示する情報を取得
     * @param inServiceBean 検索パラメータ
     * @return 更新内容
     * @throws ApplicationException
     */
    public FudousanUpdatePageOutServiceBean fudousanUpdatePage(
            FudousanUpdatePageInServiceBean inServiceBean) throws ApplicationException;

}
