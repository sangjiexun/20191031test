/*
 * $Id: ShopRegistrationStatusUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.crnwl.aop.IdHolder;
import net.chintai.backend.sysadmin.crnwl.dto.Shop;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopRegistrationStatusUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopRegistrationStatusUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopRegistrationStautsUpdateCommitInServiceBean;
import net.chintai.batch.common.PpcUseKbn;
import net.chintai.batch.common.aop.PgHolder;
import net.chintai.batch.common.domain.ShopRireki;
import net.chintai.batch.support.ppc.PpcException;
import net.chintai.batch.support.ppc.PpcSupportService;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ShopRegistrationStatusUpdateCommitServiceの実装クラス
 *
 * @author Sim-JongYeon
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopRegistrationStatusUpdateCommitServiceImpl implements
        ShopRegistrationStatusUpdateCommitService {

    /** 登録状況更新完了DAO */
    private ShopRegistrationStatusUpdateCommitDao shopRegistrationStatusUpdateCommitDao = null;

    @Autowired
    private ShopService shopService;

    @Autowired
	private PpcSupportService ppcSupportService;

    /**
     * shopRegistrationStatusUpdateCommitDaoを設定する
     * @param shopRegistrationStatusUpdateCommitDao
     */
    public void setShopRegistrationStatusUpdateCommitDao(
            ShopRegistrationStatusUpdateCommitDao shopRegistrationStatusUpdateCommitDao) {
        this.shopRegistrationStatusUpdateCommitDao = shopRegistrationStatusUpdateCommitDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopRegistrationStatusUpdateCommitService#shopRegistrationStautsUpdateCommit(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopRegistrationStautsUpdateCommitInServiceBean)
     */
    public boolean shopRegistrationStautsUpdateCommit(
            ShopRegistrationStautsUpdateCommitInServiceBean inServiceBean)
            throws ApplicationException, PpcException {
/*
        ShopRegistrationStauts paramBean = new ShopRegistrationStauts();

        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 紐付設定処理
        int UpdateCntFirst = shopRegistrationStatusUpdateCommitDao.updateShopBindInfo(paramBean);

        if (UpdateCntFirst != 1) {
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0009");
        }

        // 元紐付情報がある場合、初期化
        int updateCntSecond = shopRegistrationStatusUpdateCommitDao.updateShopBindInfo2(paramBean);

        if (!(updateCntSecond == 0 || updateCntSecond == 1)) {
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0003");
        }

        // 登録状況更新完了処理を行う
        int affected =
                shopRegistrationStatusUpdateCommitDao.updateShopRegistrationStatus(paramBean);*/

    	Shop shop = new Shop();
		ShopRireki shopRireki = shopService.selectShopRirekiByShopcd(inServiceBean.getShopCd());
		shopRireki.setCtStatus(inServiceBean.getCtFlg());
		shopRireki.setAblStatus(inServiceBean.getAblFlg());
		shopRireki.setShopStatus(inServiceBean.getShopStatus());
		shopRireki.setAdminNote(inServiceBean.getAdminNote());

		shop.setShopcd(inServiceBean.getShopCd());
		shop.setShopKanriUpdDt(DateTimeFormat.forPattern("yyyyMMddHHmmssSSS").parseDateTime(inServiceBean.getUpdDt()).toDate());

		try {
			PgHolder.setPg(inServiceBean.getUpdPg());
			IdHolder.setId(inServiceBean.getOperId());

			// フリーコール ※SHOP_RESERVEに予約がある場合はPPCを取りにいかない。
			boolean isExistsShopReserve = shopService.isExistsShopReserve(shopRireki.getShopcd());
			if(!isExistsShopReserve){
				//システム利用状態：「通常 」
				if("1".equals(inServiceBean.getShopStatus())){
					//登録
					if(StringUtils.isNotEmpty(shopRireki.getTelFreeCt()) && "1".equals(shopRireki.getCtStatus())){
						shopRireki.setTelFreeCt(this.ppcSupportService.getPpcNum(shopService.selectShopRirekiByShopcd(inServiceBean.getShopCd()), PpcUseKbn.CHINTAI));
					}
					if(StringUtils.isNotEmpty(shopRireki.getTelMagazine())){
						shopRireki.setTelMagazine(this.ppcSupportService.getPpcNum(shopService.selectShopRirekiByShopcd(inServiceBean.getShopCd()), PpcUseKbn.MAGAZINE));
					}
					if(StringUtils.isNotEmpty(shopRireki.getTelFreeAbl()) && "1".equals(shopRireki.getAblStatus())){
						shopRireki.setTelFreeAbl(this.ppcSupportService.getPpcNum(shopService.selectShopRirekiByShopcd(inServiceBean.getShopCd()), PpcUseKbn.ABLE));
					}
				}
			}

			boolean isDispPccMsg = false;
			if(isExistsShopReserve){
				isDispPccMsg = true;
			}

			shop.setShopRireki(shopRireki);

			shopService.updateShopRireki(shop);
			PgHolder.resetPg();
			IdHolder.resetId();

			return isDispPccMsg;
		} catch (InProcessingException e) {
			throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0003");
		} catch (PpcException e1) {
			throw new PpcException();
		}
    }

}
