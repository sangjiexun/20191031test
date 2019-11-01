/*
 * $Id: AspUpdateServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.util.HashMap;
import java.util.Map;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.AspUpdateService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateOutServiceBean;
import net.chintai.batch.common.util.CryptUtils;

import org.apache.commons.beanutils.BeanUtils;

/**
 * AspUpdateServiceの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspUpdateServiceImpl implements AspUpdateService {

    /** 検索条件付加項目1のコード名 */
    private static final String C_SEARCH_ITEM_CODE_0 = "0";

    /** 検索条件付加項目2のコード名 */
    private static final String C_SEARCH_ITEM_CODE_1 = "1";

    /** 不動産ASPの店舗情報DAO */
    private AspUpdateDao aspUpdateDao = null;

    /**
     * 不動産ASPの店舗情報DAOを設定する
     * @param aspUpdateDao 不動産ASPの店舗情報DAO
     */
    public void setAspUpdateDao(AspUpdateDao aspUpdateDao) {
        this.aspUpdateDao = aspUpdateDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.AspUpdateService#aspShopInfoSearchByShopCd(net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateInServiceBean)
     */
    public AspUpdateOutServiceBean aspShopInfoSearchByShopCd(AspUpdateInServiceBean inServiceBean) throws Exception {

        // 店舗コードをParamBeanに設定
        AspShopInfoParamBean paramBean = new AspShopInfoParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // 取得した店舗情報をOutServiceBeanに設定
        AspUpdateOutServiceBean outServiceBean = new AspUpdateOutServiceBean();

        // 不動産ASP情報を取得
        AspInfo rsAspRegisteredInfo = (AspInfo) aspUpdateDao.selectAspRegisteredInfo(paramBean);

        // 取得した不動産ASP情報をOutServiceBeanに設定
        if (rsAspRegisteredInfo != null) {
            BeanUtils.copyProperties(outServiceBean, rsAspRegisteredInfo);

            // 検索条件付加項目をOutServiceBeanに設定
            String searchItemResult = null;
            String searchItem1 = rsAspRegisteredInfo.getSearchItem1();
            String searchItem2 = rsAspRegisteredInfo.getSearchItem2();

            if (C_SEARCH_ITEM_CODE_0.equals(searchItem1) && C_SEARCH_ITEM_CODE_0.equals(searchItem2)) {
                searchItemResult = "0";
            } else if (C_SEARCH_ITEM_CODE_1.equals(searchItem1) && C_SEARCH_ITEM_CODE_0.equals(searchItem2)) {
                searchItemResult = "1";
            } else if (C_SEARCH_ITEM_CODE_1.equals(searchItem1) && C_SEARCH_ITEM_CODE_1.equals(searchItem2)) {
                searchItemResult = "2";
            } else if (C_SEARCH_ITEM_CODE_0.equals(searchItem1) && (C_SEARCH_ITEM_CODE_1.equals(searchItem2))) {
                searchItemResult = "3";
            }

            outServiceBean.setSearchItem(searchItemResult);

            // 沿線タイプ1,2,3,4を設定
            // DBにはフロントでの表示順序として格納されているので
            // 管理画面での表示フォーマットに変換
            Map<String, String> ensenTypeMap = new HashMap<String, String>();
            ensenTypeMap.put(rsAspRegisteredInfo.getEnsenType1(), "1");
            ensenTypeMap.put(rsAspRegisteredInfo.getEnsenType2(), "2");
            ensenTypeMap.put(rsAspRegisteredInfo.getEnsenType3(), "3");

            outServiceBean.setEnsenCd1(ensenTypeMap.get("1"));
            outServiceBean.setEnsenCd2(ensenTypeMap.get("2"));
            outServiceBean.setEnsenCd3(ensenTypeMap.get("3"));

        }

        // 店舗情報を取得及び設定
        Object rsAspShopInfo = aspUpdateDao.selectAspShopInfo(paramBean);
        BeanUtils.copyProperties(outServiceBean, rsAspShopInfo);

        // パスワード複合化
        outServiceBean.setPassword(CryptUtils.decypt(outServiceBean.getPassword()));

        return outServiceBean;

    }

}
