package net.chintai.backend.sysadmin.shop_bukken.service;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractNormalUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractNormalUpdatePageOutServiceBean;

/**
 * 契約明細設定（数量なし）に遷移サービス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractNormalUpdatePageService {

    /**
     * 物件詳細情報
     * @return ContractNormalUpdatePageOutServiceBean
     * @param inServiceBean
     * @throws InvocationTargetException, IllegalAccessException
     */
    public ContractNormalUpdatePageOutServiceBean contractUpdatePage(ContractNormalUpdatePageInServiceBean inServiceBean)
            throws InvocationTargetException, IllegalAccessException;
}