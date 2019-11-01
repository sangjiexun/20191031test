package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import static net.chintai.backend.sysadmin.common.properties.SystemProperties.getProperty;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopListingInfoDomain;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingInfoOutServiceBean;
import net.chintai.batch.common.domain.MstShopKeiyakuKanri;
import net.chintai.batch.common.util.CryptUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 契約情報詳細
 *
 * @author
 * @version $Revision: $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingInfoServiceImpl implements ShopListingInfoService {

    /** 契約情報取得DAO */
    private ShopListingInfoDao shopListingInfoDao;

    /**
     * 契約情報取得DAOを設定します。
     *
     * @param shopListingInfoDao
     *            店舗リスティング取得DAO
     */
    public void setShopListingInfoDao(ShopListingInfoDao shopListingInfoDao) {
        this.shopListingInfoDao = shopListingInfoDao;
    }

    @Autowired
	private MasterService masterService;

    /*
     * (non-Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_bukken.service.ShopListingInfoService#getContractInfo(net.chintai.backend.sysadmin.shop_bukken.
     * service.bean.ShopListingInfoInServiceBean)
     */
    public ShopListingInfoOutServiceBean getContractInfo(
            ShopListingInfoInServiceBean inBean) throws ApplicationException {

        // 検索条件設定
        ShopListingInfoParamBean paramBean = new ShopListingInfoParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 契約詳細検索開始
        ShopListingInfoDomain domain = (ShopListingInfoDomain) shopListingInfoDao
                .getContractInfo(paramBean);

        List<String> lstAmount = new ArrayList<String>();

        // 戻り値設定
        ShopListingInfoOutServiceBean outBean = new ShopListingInfoOutServiceBean();

        if (domain.getStrAmountList() != null) {
            String[] arrayStrAmount = domain.getStrAmountList().split("\\,",-1);
            for (String str  :arrayStrAmount) {
                if ("".equals(str.trim())) {
                    outBean.setTextBoxFlg("on");
                }

                //数値変換してエラーにならなければリストに追加（エラーになった場合は、テキストボックスに登録）
                try {
                    Integer.parseInt(str);
                    lstAmount.add(str);
                } catch (Exception e) {
                    //数値じゃなかったら、その他項目を設定
                    outBean.setTextBoxFlg("on");
                    outBean.setTextBoxName(str);
                }
            }
        } else {
            outBean.setTextBoxFlg("on");
        }

        try {
            BeanUtils.copyProperties(outBean, domain);
            outBean.setPassword(CryptUtils.decypt(outBean.getPassword()));
            outBean.setListAmount(lstAmount);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return outBean;
    }

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopListingInfoService#isWakuDisp(java.lang.String, java.lang.String)
	 */
	public String isWakuDisp(String keiyakuCd, String keiyakuSubCd) {
		MstShopKeiyakuKanri mstShopKeiyakuKanri = masterService.selectMstShopKeiyakuKanriByPrimaryKey(keiyakuCd, keiyakuSubCd);

		if(mstShopKeiyakuKanri != null){
			if("1".equals(mstShopKeiyakuKanri.getKeiyakuDetailKbn())){
				return "true";
			}
		}

		return "false";

		/*
		String[] array = StringUtils.split(getProperty("WAKU_DISP_TAISHO_KEIYAKUCD"), ",");

        List<String> list = Arrays.asList(array);

        if(list.contains(keiyakuCd)) {
            return "true";
        }

        return "false";
        */
	}

}
