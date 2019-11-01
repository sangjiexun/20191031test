/*
 * $Id: OperationServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.dwr.dao.OperationDao;
import net.chintai.backend.sysadmin.common.dwr.domain.Operation;
import net.chintai.backend.sysadmin.common.dwr.service.OperationService;
import net.chintai.backend.sysadmin.common.dwr.service.bean.OperationBean;

/**
 * OperationService の実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class OperationServiceImpl implements OperationService {

    private OperationDao operationDao = null;

    public void setOperationDao(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dwr.service.OperationService#getOperationList(java.lang.String)
     */
    public List<OperationBean> getOperationList(String authorityId) {
        List<Operation> rsList = operationDao.selectOperationList(authorityId);
        List<OperationBean> beanList = new ArrayList<OperationBean>();

        if(rsList != null) {

            for(int i = 0; i<rsList.size(); i++) {
                OperationBean operationBean =
                    new OperationBean(rsList.get(i).getOperationId(), 
                            rsList.get(i).getOperationName());
                beanList.add(operationBean);
            }           
        }
        return beanList;
    }
}