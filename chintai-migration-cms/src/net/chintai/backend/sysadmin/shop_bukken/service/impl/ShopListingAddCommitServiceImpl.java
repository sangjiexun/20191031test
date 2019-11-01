package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingAddCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingAddCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingAddCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingAddCommitInServiceBean;
import net.chintai.batch.common.domain.ShopKanri;
import net.chintai.batch.common.persistence.mapper.ShopKanriMapper;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * ShopListingAddCommitServiceの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingAddCommitServiceImpl implements
        ShopListingAddCommitService {

    /** 店舗リスティング設定情報更新DAO */
    ShopListingAddCommitDao shopListingAddCommitDao;

    /**
     * 店舗リスティング設定情報更新DAOを設定します。
     * @param shopListingAddCommitDao 店舗リスティング設定情報更新DAO
     */
    public void setShopListingAddCommitDao(
            ShopListingAddCommitDao shopListingAddCommitDao) {
        this.shopListingAddCommitDao = shopListingAddCommitDao;
    }

    // 排他制御用処理追加
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopKanriMapper shopKanrilMapper;

    // 排他制御用処理追加

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopListingAddCommitService#insertShopListing(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingAddCommitInServiceBean)
     */
    public void insertShopListing(ShopListingAddCommitInServiceBean inBean)
            throws ApplicationException {

        ShopListingAddCommitParamBean paramBean =
                new ShopListingAddCommitParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
            String keiyakuStartDt =inBean.getKeiyakuStartYear()
                        + inBean.getKeiyakuStartMonth()
                        + inBean.getKeiyakuStartDay()
                        + inBean.getKeiyakuStartHour()
                        + inBean.getKeiyakuStartMinute()
                        + inBean.getKeiyakuStartSecond();

            String keiyakuEndDt = inBean.getKeiyakuEndYear()
                        + inBean.getKeiyakuEndMonth()
                        + inBean.getKeiyakuEndDay()
                        + inBean.getKeiyakuEndHour()
                        + inBean.getKeiyakuEndMinute()
                        + inBean.getKeiyakuEndSecond();

            if (StringUtils.isEmpty(keiyakuEndDt)) {
                //keiyakuEndDt = "99999999999999";
            	keiyakuEndDt = SystemProperties.getProperty("LAST_DT");
            }

            paramBean.setKeiyakuStartDt(keiyakuStartDt);
            paramBean.setKeiyakuEndDt(keiyakuEndDt);

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
            throw new ApplicationException("ERROR.M.REVIEW.0083", e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        try {
            shopListingAddCommitDao.insertShopListing(paramBean);
        } catch (Exception e) {
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0018");
        }

        ShopKanri shopKanri = shopService.selectShopKanriByPrimaryKey(inBean.getShopCd());
        shopKanri.setAdminUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdId(inBean.getUserId());
        shopKanri.setUpdPg(inBean.getPgName());

        shopKanrilMapper.updateByPrimaryKey(shopKanri);

    }
}
