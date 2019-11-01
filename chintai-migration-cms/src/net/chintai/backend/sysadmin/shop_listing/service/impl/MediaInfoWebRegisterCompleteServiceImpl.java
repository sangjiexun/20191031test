/*
 * $Id: MediaInfoWebRegisterCompleteServiceImpl.java 4251 2009-03-24 06:53:28Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/15     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDao;
import net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDaoParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoWebRegisterCompleteDao;
import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoWebRegisterCompleteParamBean;
import net.chintai.backend.sysadmin.shop_listing.service.MediaInfoWebRegisterCompleteService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoWebRegisterCompleteInServiceBean;

/**
 * MediaInfoWebRegisterCompleteServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4251 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoWebRegisterCompleteServiceImpl implements MediaInfoWebRegisterCompleteService {

    /** 出稿情報本番反映DAO */
    MediaInfoWebRegisterCompleteDao mediaInfoWebRegisterCompleteDao;

    /** プロシージャDAO */
    private CallProcedureDao callProcedureDao;

    /*
     * (非 Javadoc)
     *
     * @seenet.chintai.backend.sysadmin.shop_listing.service.
     * MediaInfoWebRegisterCompleteService
     * #updateWebMediaInfo(net.chintai.backend
     * .sysadmin.shop_listing.service.bean
     * .MediaInfoWebRegisterCompleteInServiceBean)
     */
    public void updateWebMediaInfo(MediaInfoWebRegisterCompleteInServiceBean inBean) {

        MediaInfoWebRegisterCompleteParamBean paramBean =
                new MediaInfoWebRegisterCompleteParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inBean);

        // 既存Web表示中のデータを論理削除
        mediaInfoWebRegisterCompleteDao.logicalDeleteMediaInfoData(paramBean);
        mediaInfoWebRegisterCompleteDao.logicalDeleteMediaInfoEki(paramBean);
        mediaInfoWebRegisterCompleteDao.logicalDeleteMediaInfoCity(paramBean);
        mediaInfoWebRegisterCompleteDao.logicalDeleteMediaInfoIcon(paramBean);

        // 出稿データテーブル更新
        mediaInfoWebRegisterCompleteDao.updateMediaInfoData(paramBean);

        // 出稿駅テーブル更新
        mediaInfoWebRegisterCompleteDao.updateMediaInfoEki(paramBean);

        // 出稿市区町村テーブル更新
        mediaInfoWebRegisterCompleteDao.updateMediaInfoCity(paramBean);

        // アイコンテーブル更新
        mediaInfoWebRegisterCompleteDao.updateMediaInfoIcon(paramBean);

        // プロシージャを呼び出す。
        CallProcedureDaoParamBean procedureParamBean = new CallProcedureDaoParamBean();
        BeanUtilsWrapper.copyProperties(procedureParamBean, paramBean);
        callProcedureDao.callKihonYukoFlgUpdate(procedureParamBean);
        callProcedureDao.callCouponYukoFlgUpdate(procedureParamBean);
        callProcedureDao.callLinkYukoFlgUpdate(procedureParamBean);
    }

    /**
     * 出稿情報本番反映DAOを設定します。
     * @param mediaInfoWebRegisterCompleteDao 出稿情報本番反映DAO
     */
    public void setMediaInfoWebRegisterCompleteDao(
            MediaInfoWebRegisterCompleteDao mediaInfoWebRegisterCompleteDao) {
        this.mediaInfoWebRegisterCompleteDao = mediaInfoWebRegisterCompleteDao;
    }

    /**
     * プロシージャDAOを設定します。
     * @param callProcedureDao プロシージャDAO
     */
    public void setCallProcedureDao(CallProcedureDao callProcedureDao) {
        this.callProcedureDao = callProcedureDao;
    }

}
