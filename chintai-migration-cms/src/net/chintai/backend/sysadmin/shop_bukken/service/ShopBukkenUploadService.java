/*
 * $Id: ContractAmountMaintenanceUploadService.java 4663 2013-10-09 08:37:05Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.ContractAmountMaintenanceUploadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopBukkenUploadInServiceBean;
import net.chintai.batch.support.ppc.PpcException;


/**
 * CSVアップロード処理サービスクラス
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopBukkenUploadService {

    /**
     * 入力CSVファイル内容で登録、更新、削除処理をする
     * @param inServiceBean
     * @throws ApplicationException
     * @throws PpcException
     */
    public void shopBukkenUploadCommit(ShopBukkenUploadInServiceBean inServiceBean) throws ApplicationException, PpcException;

}
