/*
 * $Id: MediaInfoConfirmServiceImpl.java 4306 2009-07-13 11:54:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.chintai.backend.sysadmin.common.properties.ServerProperties;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_listing.dao.EkiInfoSearchParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoConfirmDao;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingIconDao;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingCityDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingEkiDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingIconDomain;
import net.chintai.backend.sysadmin.shop_listing.service.MediaInfoConfirmService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoConfirmOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopListingIconBean;

import org.apache.commons.lang.StringUtils;

/**
 * MediaInfoRegisterConfirmServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4306 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoConfirmServiceImpl implements MediaInfoConfirmService {

    /** 出稿情報確認DAO */
    private MediaInfoConfirmDao mediaInfoConfirmDao;

    /** アイコンマスタDAO */
    private ShopListingIconDao shopListingIconDao;

    /*
     * (非 Javadoc)
     *
     * @seenet.chintai.backend.sysadmin.shop_listing.service.
     * MediaInfoRegisterConfirmService
     * #searchConfirmInfo(net.chintai.backend.sysadmin
     * .shop_listing.service.bean.MediaInfoRegisterConfirmInServiceBean)
     */
    public MediaInfoConfirmOutServiceBean searchConfirmInfo(MediaInfoConfirmInServiceBean inBean) {

        // 選択された駅コードを確認画面表示のため文字列か
        MediaInfoConfirmOutServiceBean outBean = new MediaInfoConfirmOutServiceBean();
        if (StringUtils.isNotEmpty(inBean.getSelectEkiValue())) {
            String[] params = inBean.getSelectEkiValue().split(",");

            List<String> ekiNames = new ArrayList<String>();

            for (int i = 0; i < params.length; i++) {
                EkiInfoSearchParamBean paramBean = new EkiInfoSearchParamBean();
                paramBean.setEnsenCd(params[i].substring(0, 6));
                paramBean.setEkiCd(params[i].substring(6));

                ShopListingEkiDomain ekiDomain = mediaInfoConfirmDao.searchEkiInfo(paramBean);
                ekiNames.add(ekiDomain.getEnsenName() + " " + ekiDomain.getEkiName());
            }
            outBean.setSelectEkiName(ekiNames);
        }

        // 選択された市区町村コードを確認画面表示のため文字列か
        if (StringUtils.isNotEmpty(inBean.getSelectCityValue())) {
            List<String> cityNames = new ArrayList<String>();
            String[] cityCds = inBean.getSelectCityValue().split(",");

            for (int i = 0; i < cityCds.length; i++) {
                ShopListingCityDomain domain = mediaInfoConfirmDao.searchCityInfo(cityCds[i]);
                cityNames.add(domain.getPrefName() + " " + domain.getCityName());
            }

            outBean.setSelectCityName(cityNames);
        }

        // 選択されたアピールアイコンの画像URLを生成。
        if (inBean.getChkAppeal() != null && inBean.getChkAppeal().length > 0) {
            List<ShopListingIconDomain> chkAppealInfos =
                    shopListingIconDao.searchIconMasterInfoByIconId(Arrays.asList(inBean
                            .getChkAppeal()));
            List<ShopListingIconBean> appealIconInfo = new ArrayList<ShopListingIconBean>();

            for (ShopListingIconDomain iconInfo : chkAppealInfos) {
                ShopListingIconBean detailBean = new ShopListingIconBean();
                BeanUtilsWrapper.copyProperties(detailBean, iconInfo);
                detailBean.setIconImgPath(this.createIconImgUrl(iconInfo.getIconId()));

                appealIconInfo.add(detailBean);
            }
            outBean.setAppealIconInfos(appealIconInfo);
        }

        // 選択されたリスティングアイコンの画像URLを生成します。
        if (inBean.getChkListing() != null && inBean.getChkListing().length > 0) {
            List<ShopListingIconDomain> chkListingInfos =
                    shopListingIconDao.searchIconMasterInfoByIconId(Arrays.asList(inBean
                            .getChkListing()));
            List<ShopListingIconBean> listingIconInfo = new ArrayList<ShopListingIconBean>();
            for (ShopListingIconDomain iconInfo : chkListingInfos) {
                ShopListingIconBean detailBean = new ShopListingIconBean();
                BeanUtilsWrapper.copyProperties(detailBean, iconInfo);
                detailBean.setIconImgPath(this.createIconImgUrl(iconInfo.getIconId()));
                listingIconInfo.add(detailBean);
            }
            outBean.setListingIconInfos(listingIconInfo);
        }

        return outBean;
    }

    /**
     * アイコン画像URLを生成します。
     * @param iconId
     * @return
     */
    private String createIconImgUrl(String iconId) {
        // アイコン画像Url生成
        MessageFormat formatter =
                new MessageFormat(ServerProperties.getProperty("shopListing.appealIconImgPath"));

        return formatter.format(new String[] { iconId });
    }

    /**
     * 出稿情報確認DAOを設定します。
     * @param mediaInfoConfirmDao 出稿情報確認DAO
     */
    public void setMediaInfoConfirmDao(MediaInfoConfirmDao mediaInfoConfirmDao) {
        this.mediaInfoConfirmDao = mediaInfoConfirmDao;
    }

    /**
     * アイコンマスタDAOを設定します。
     * @param shopListingIconDao アイコンマスタDAO
     */
    public void setShopListingIconDao(ShopListingIconDao shopListingIconDao) {
        this.shopListingIconDao = shopListingIconDao;
    }

}
