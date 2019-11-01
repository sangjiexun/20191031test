/*
 * $Id: AspGroupDeleteCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/25  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupDeleteCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupDeleteCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.service.AspGroupDeleteCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupDeleteCommitInServiceBean;
import net.chintai.batch.common.domain.ShopKanri;
import net.chintai.batch.common.persistence.mapper.ShopKanriMapper;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AspGroupDeleteCommitServiceの実装クラス
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupDeleteCommitServiceImpl implements AspGroupDeleteCommitService {

    /** 不動産ASPグループから外す(削除)Dao */
    private AspGroupDeleteCommitDao aspGroupDeleteCommitDao;

    // 排他制御用処理追加
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopKanriMapper shopKanrilMapper;

    // 排他制御用処理追加


    /**
     * 不動産ASPグループから外す(削除)Dao設定する
     * @param aspGroupDeleteCommitDao
     */
    public void setAspGroupDeleteCommitDao(AspGroupDeleteCommitDao aspGroupDeleteCommitDao) {
        this.aspGroupDeleteCommitDao = aspGroupDeleteCommitDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.AspGroupDeleteCommitService#aspGroupDelete(net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupDeleteCommitInServiceBean)
     */
    public void aspGroupDelete(AspGroupDeleteCommitInServiceBean inBean)
            throws ApplicationException {

        AspGroupDeleteCommitParamBean paramBean = new AspGroupDeleteCommitParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
            Date startDate = sdf.parse(inBean.getShopKanriUpdDt());

            shopService.checkAndLockShopKanri(inBean.getShopCd(),startDate);
        } catch (InProcessingException e) {
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0004", e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        int cnt = aspGroupDeleteCommitDao.aspGroupDeleteCommit(paramBean);

        if (inBean.getDelShop().size() > cnt ) {
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0004");
        }

        ShopKanri shopKanri = shopService.selectShopKanriByPrimaryKey(inBean.getShopCd());
        shopKanri.setAdminUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdId(inBean.getUpdId());
        shopKanri.setUpdPg(inBean.getUpdPg());
        shopKanrilMapper.updateByPrimaryKey(shopKanri);

    }

}
