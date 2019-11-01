/*
 * $Id: ShopBasicInfoUpdateCommitServiceImpl.java 4319 2009-07-16 01:46:26Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopBasicInfoUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopBasicInfoUpdateCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopBasicInfoUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopBasicInfoUpdateCommitInServiceBean;

/**
 * {@link ShopBasicInfoUpdateCommitService}の実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4319 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBasicInfoUpdateCommitServiceImpl implements ShopBasicInfoUpdateCommitService {

    /** 入力タイプ固定 */
    private static final String INPUT_TYPE_OPTION = "0";

    /** コロン */
    private static final String COLON = ":";

    /** 波マーク */
    private static final String WAVE_MARK = "～";

    /** 店舗基本情報更新DAO */
    private ShopBasicInfoUpdateCommitDao shopBasicInfoUpdateCommitDao;

    /**
     * 店舗基本情報更新DAOを設定します。
     * @param shopBasicInfoUpdateCommitDao 店舗基本情報更新DAO
     */
    public void setShopBasicInfoUpdateCommitDao(
            ShopBasicInfoUpdateCommitDao shopBasicInfoUpdateCommitDao) {
        this.shopBasicInfoUpdateCommitDao = shopBasicInfoUpdateCommitDao;
    }

    /*
     * (非 Javadoc)
     *
     * @seenet.chintai.backend.sysadmin.shop_bukken.service.
     * ShopBasicInfoUpdateCommitService#
     * doCommit(net.chintai.backend.sysadmin.shop_bukken
     * .service.bean.ShopBasicInfoUpdateCommitInServiceBean)
     */
    public void doCommit(ShopBasicInfoUpdateCommitInServiceBean inBean) {

        // パラメータ編集
        ShopBasicInfoUpdateCommitParamBean paramBean = new ShopBasicInfoUpdateCommitParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inBean);

        // 営業時間編集
        if (INPUT_TYPE_OPTION.equals(inBean.getBusinessHoursType())
                && StringUtils.isNotEmpty(inBean.getFromHour())) {

            // 営業時間
            StringBuilder businessHours = new StringBuilder();
            businessHours.append(inBean.getFromHour());
            businessHours.append(COLON);
            businessHours.append(inBean.getFromMin());
            businessHours.append(WAVE_MARK);
            businessHours.append(inBean.getToHour());
            businessHours.append(COLON);
            businessHours.append(inBean.getToMin());

            paramBean.setBusinessHours(businessHours.toString());
        } else {
            paramBean.setBusinessHours(inBean.getBusinessHoursCustom());
        }

        // 定休日編集
        if (INPUT_TYPE_OPTION.equals(inBean.getHolidayType())) {
            paramBean.setHoliday(inBean.getHolidayOption());
        } else {
            paramBean.setHoliday(inBean.getHolidayCustom());
        }

        // 混雑時間帯コメント編集
        if (StringUtils.isNotEmpty(inBean.getBusyComment())) {
            paramBean.setBusyComment(inBean.getBusyComment()
                    + SystemProperties.getProperty("BUSY_COMMEN_SUFFIXT"));
        }

        // 店舗基本情報更新を行う。
        shopBasicInfoUpdateCommitDao.updateShopBasicInfo(paramBean);
    }

}
