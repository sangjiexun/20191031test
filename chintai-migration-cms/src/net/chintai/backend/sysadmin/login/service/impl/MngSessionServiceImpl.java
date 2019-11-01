/*
 * LoginServiceImpl.java
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/15  BGT)児島   新規作成
 * 2007/07/31  BGT)児島   user オブジェクトの null チェックを追加
 * 2007/08/08  BGT)児島   グループIDをセットする処理を削除
 */
package net.chintai.backend.sysadmin.login.service.impl;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.util.CryptUtil;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.login.dao.MngSessionDao;
import net.chintai.backend.sysadmin.login.dao.MngSessionParamBean;
import net.chintai.backend.sysadmin.login.service.MngSessionService;
import net.chintai.backend.sysadmin.login.service.bean.MngSessionInServiceBean;
import net.chintai.backend.sysadmin.login.service.bean.MngSessionOutServiceBean;

/**
 * MngSession の実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MngSessionServiceImpl implements MngSessionService {

    /** URLエンコーディングキャラクタ */
    private static final String C_URL_ENCODING = "UTF-8";

    /** セッション情報 DAO */
    private MngSessionDao mngSessionDao = null;

    /**
     * セッション情報 DAOを設定します。
     * @param mngSessionDao  セッション情報 DAO
     */
    public void setMngSessionDao(MngSessionDao mngSessionDao) {
        this.mngSessionDao = mngSessionDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.login.service.MngSessionService#insertMngSession(net.chintai.backend.sysadmin.login.dao.MngSessionParamBean)
     */
    public MngSessionOutServiceBean insertMngSession(MngSessionInServiceBean inBean) {

        MngSessionParamBean paramBean = new MngSessionParamBean();
        String loginKey = null;

        try {
            // ログインキー生成(userid + 日付(yyyyMMddHHmmss)の暗号化)
            loginKey = URLEncoder.encode(CryptUtil.blowfishEncrypt(
                    inBean.getUserId() + DateUtil.getToday("yyyyMMddHHmmss")), C_URL_ENCODING);

            BeanUtils.copyProperties(paramBean, inBean);
            paramBean.setLoginKey(loginKey);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        Long sidId = mngSessionDao.insertMngSession(paramBean);

        MngSessionOutServiceBean outBean = new MngSessionOutServiceBean();
        outBean.setSid(sidId);
        outBean.setLoginKey(loginKey);

        return outBean;

    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.login.service.MngSessionService#deleteMngSession(java.lang.String)
     */
   public void deleteMngSession(Long sidId) {

       mngSessionDao.deleteMngSession(sidId);
    }

}
