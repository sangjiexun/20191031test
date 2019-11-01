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
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingUpdateCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingUpdateCommitInServiceBean;
import net.chintai.batch.common.domain.ShopKanri;
import net.chintai.batch.common.persistence.mapper.ShopKanriMapper;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * ShopListingUpdateCommitServiceの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingUpdateCommitServiceImpl implements
        ShopListingUpdateCommitService {

    /** 店舗リスティング設定情報更新DAO */
    ShopListingUpdateCommitDao shopListingUpdateCommitDao;

    // 排他制御用処理追加
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopKanriMapper shopKanrilMapper;

    // 排他制御用処理追加


    /**
     * 店舗リスティング設定情報更新DAOを設定します。
     * @param shopListingUpdateCommitDao 店舗リスティング設定情報更新DAO
     */
    public void setShopListingUpdateCommitDao(ShopListingUpdateCommitDao shopListingUpdateCommitDao) {
        this.shopListingUpdateCommitDao = shopListingUpdateCommitDao;
    }


    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopListingUpdateCommitService#updateShopListing(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingUpdateCommitInServiceBean)
     */
    public void updateShopListing(ShopListingUpdateCommitInServiceBean inBean)
            throws ApplicationException {

        ShopListingUpdateCommitParamBean paramBean =
                new ShopListingUpdateCommitParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
            String keiyakuStartDt =inBean.getKeiyakuStartYear()
                        + inBean.getKeiyakuStartMonth()
                        + inBean.getKeiyakuStartDay()
                        + inBean.getKeiyakuStartHour()
                        + inBean.getKeiyakuStartMinute()
                        + inBean.getKeiyakuStartSecond();

            //終了日時の設定
            //契約終了が選択された場合は終了日に現在日付、契約終了日が指定されていなかった場合は
            //99999999999999を設定する。それ以外は、選択された項目をyyyyMMddHHmmss形式で設定する。
            String keiyakuEndDt = null;
            keiyakuEndDt = inBean.getKeiyakuEndYear()
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
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0018", e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        int updateCnt = shopListingUpdateCommitDao.updateShopListing(paramBean);

        if (updateCnt != 1) {
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
