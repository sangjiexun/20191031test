/*
 * $Id: AspGroupUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/24  BGT)楊恩美        新規作成
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
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupUpdateCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.service.AspGroupUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupUpdateCommitInServiceBean;
import net.chintai.batch.common.domain.ShopKanri;
import net.chintai.batch.common.persistence.mapper.ShopKanriMapper;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AspGroupUpdateCommitServiceの実装クラス
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupUpdateCommitServiceImpl implements AspGroupUpdateCommitService {

    /** 不動産ASPグループ編集更新情報取得 */
    private AspGroupUpdateCommitDao aspGroupUpdateCommitDao;

    // 排他制御用処理追加
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopKanriMapper shopKanrilMapper;

    // 排他制御用処理追加

    /**
     * 不動産ASPグループ編集更新情報設定する
     *
     * @param aspGroupUpdateCommitDao
     */
    public void setAspGroupUpdateCommitDao(AspGroupUpdateCommitDao aspGroupUpdateCommitDao) {
        this.aspGroupUpdateCommitDao = aspGroupUpdateCommitDao;
    }


    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.AspGroupUpdateCommitService#aspGroupUpdate(net.chintai.backend.sysadmin.shop_bukken.service.bean.AspGroupUpdateCommitInServiceBean)
     */
    public void aspGroupUpdate(AspGroupUpdateCommitInServiceBean inServiceBean)
            throws ApplicationException {

        AspGroupUpdateCommitParamBean paramBean = new AspGroupUpdateCommitParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
            Date startDate = sdf.parse(inServiceBean.getShopKanriUpdDt());

            shopService.checkAndLockShopKanri(inServiceBean.getShopCd(),startDate);
        } catch (InProcessingException e) {
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0003", e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        int cnt = aspGroupUpdateCommitDao.aspGroupUpdateCommit(paramBean);

        if (cnt == 0) {
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0003");
        }
        ShopKanri shopKanri = shopService.selectShopKanriByPrimaryKey(inServiceBean.getShopCd());
        shopKanri.setAdminUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdId(inServiceBean.getInsId());
        shopKanri.setUpdPg(inServiceBean.getInsPg());
        shopKanrilMapper.updateByPrimaryKey(shopKanri);


    }

}
