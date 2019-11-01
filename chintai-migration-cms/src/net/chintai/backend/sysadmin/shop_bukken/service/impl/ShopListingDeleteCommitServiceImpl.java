package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDeleteCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDeleteCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingDeleteCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingDeleteCommitInServiceBean;
import net.chintai.batch.common.domain.ShopKanri;
import net.chintai.batch.common.persistence.mapper.ShopKanriMapper;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * ShopListingDeleteCommitServiceの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDeleteCommitServiceImpl implements
        ShopListingDeleteCommitService {

    /** 店舗リスティング設定情報削除DAO */
    ShopListingDeleteCommitDao shopListingDeleteCommitDao;

    // 排他制御用処理追加
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopKanriMapper shopKanrilMapper;

    // 排他制御用処理追加

    /**
     * 店舗リスティング設定情報削除DAOを設定します。
     * @param shopListingDeleteCommitDao 店舗リスティング)設定情報削除DAO
     */
    public void setShopListingDeleteCommitDao(
            ShopListingDeleteCommitDao shopListingDeleteCommitDao) {
        this.shopListingDeleteCommitDao = shopListingDeleteCommitDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopListingDeleteCommitService#deleteWakuInfo(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingDeleteCommitInServiceBean)
     */
    public void deleteKeiyakuInfo(ShopListingDeleteCommitInServiceBean inBean)
            throws ApplicationException {

         String[] delFlgList = inBean.getDelFlgList();
         try {
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
             Date startDate = sdf.parse(inBean.getShopKanriUpdDt());

             shopService.checkAndLockShopKanri(inBean.getShopCd(),startDate);
         } catch (InProcessingException e) {
             throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0022", e);
         } catch (ParseException e) {
             throw new RuntimeException(e);
         }

        for (int i = 0; i < delFlgList.length; i++) {
            ShopListingDeleteCommitParamBean paramBean =
                    new ShopListingDeleteCommitParamBean();
            paramBean.setKeiyakuNo(delFlgList[i]);
            int deleteCnt = shopListingDeleteCommitDao.deleteKeiyakuInfo(paramBean);

            if (deleteCnt == 0) {
                throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0022");
            }
        }

        ShopKanri shopKanri = shopService.selectShopKanriByPrimaryKey(inBean.getShopCd());
        shopKanri.setAdminUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdId(inBean.getUpdId());
        shopKanri.setUpdPg(inBean.getUpdPg());
        shopKanrilMapper.updateByPrimaryKey(shopKanri);

    }
}
