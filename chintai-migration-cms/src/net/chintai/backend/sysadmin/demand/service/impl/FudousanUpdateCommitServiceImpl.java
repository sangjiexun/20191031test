/*
 * $Id: FudousanUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/01     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.dao.FudousanUpdateCommitDao;
import net.chintai.backend.sysadmin.demand.dao.FudousanUpdateCommitParamBean;
import net.chintai.backend.sysadmin.demand.service.FudousanUpdateCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanUpdateCommitInServiceBean;

/**
 * FudousanUpdateCommitServiceの実装クラス
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanUpdateCommitServiceImpl implements FudousanUpdateCommitService {

    // * 不動産会社更新Dao */
    FudousanUpdateCommitDao fudousanUpdateCommitDao;

    public void setFudousanUpdateCommitDao(FudousanUpdateCommitDao fudousanUpdateCommitDao) {
        this.fudousanUpdateCommitDao = fudousanUpdateCommitDao;
    }

    public void updateFudousan(FudousanUpdateCommitInServiceBean inBean)
            throws ApplicationException {

        // paramBean
        FudousanUpdateCommitParamBean paramBean = new FudousanUpdateCommitParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 更新処理
        int updCnt = fudousanUpdateCommitDao.updateFudousan(paramBean);

        if (updCnt < 1) {
            throw new ApplicationException("ERROR.M.REVIEW.0081");
        }

    }

}
