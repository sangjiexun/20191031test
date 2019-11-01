package net.chintai.backend.sysadmin.dataoutput.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.service.bean.MstCityOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoOutServiceBean;

import org.apache.commons.lang.StringUtils;

/**
 * データ元出力設定機能のユーティリティクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4787 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class ShikutyosonClientSettingUtils {

    /**
     * cityCdに紐づくクライアントシステムを取得する。 更新画面の表示時に使用
     *
     *
     * @param clientSystemTypeDataList
     * @param cityCd
     * @return
     */
    public static List<String> getShikutyosonClientList(
            List<ShikutyosonClientSettingInfoOutServiceBean> clientSystemTypeDataList, String cityCd) {

        List<String> clientList = setShikutyosonClientList(clientSystemTypeDataList, cityCd);

        return ClientSettingUtils.getAllClientsystemTypeList(clientList);

    }

    /**
     * cityCdに紐づくクライアントシステムを取得する。 更新画面表示時、 更新確認画面から更新画面に戻るとき、 更新処理のとき使用
     *
     * @param clientSystemTypeDataList
     * @param cityCd
     * @return
     */
    public static List<String> getShikutyosonClientReverseList(
            List<ShikutyosonClientSettingInfoOutServiceBean> clientSystemTypeDataList, String cityCd) {

        List<String> clientList = setShikutyosonClientList(clientSystemTypeDataList, cityCd);

        return ClientSettingUtils.getAllReverseClientsystemTypeList(clientList);

    }

    /**
     * cityCdに紐づくクライアントシステムタイプデータ（複数or一つ）を取得
     *
     * @param clientSystemTypeDataList
     * @param cityCd
     * @return
     */
    private static List<String> setShikutyosonClientList(
            List<ShikutyosonClientSettingInfoOutServiceBean> clientSystemTypeDataList, String cityCd) {

        List<String> clientList = new ArrayList<String>();

        for (ShikutyosonClientSettingInfoOutServiceBean shikutyosonClientData : clientSystemTypeDataList) {
            if (StringUtils.equals(shikutyosonClientData.getCityCd(), cityCd)) {
                clientList.add(shikutyosonClientData.getClientsystemType());
            }
        }
        return clientList;
    }

    /**
     * 配列のデータ（cityCd + clientsystemType）をArrayListに入れてあげる処理
     *
     * @param formPrefClientList
     * @return
     */
    public static List<ShikutyosonClientSettingInfoOutServiceBean> convertShikutyosonClientSystemList(
            String[] formShikutyosonClientList) {

        List<ShikutyosonClientSettingInfoOutServiceBean> resultList =
                new ArrayList<ShikutyosonClientSettingInfoOutServiceBean>();

        for (String formShikutyosonAndClient : formShikutyosonClientList) {

            String[] shikutyosonClientArray = StringUtils.split(formShikutyosonAndClient, "_");

            ShikutyosonClientSettingInfoOutServiceBean shikutyosonClientBean =
                    new ShikutyosonClientSettingInfoOutServiceBean();
            shikutyosonClientBean.setCityCd(shikutyosonClientArray[0]);
            shikutyosonClientBean.setClientsystemType(shikutyosonClientArray[1]);
            resultList.add(shikutyosonClientBean);
        }

        return resultList;

    }

    /**
     * 配列のデータ(cityCd + shikutyosonname)をArrayListに入れてあげる処理
     *
     * @param formBean
     * @return
     */
    public static List<MstCityOutBean> convertMstCityList(
            ShikutyosonClientSettingInfoInServiceBean inServiceBean) {

        List<MstCityOutBean> resultList = new ArrayList<MstCityOutBean>();
        for (int i = 0; i < inServiceBean.getCityCdArray().length; i++) {

            String cityCd = inServiceBean.getCityCdArray()[i];
            String cityName = inServiceBean.getCityNameArray()[i];

            MstCityOutBean bean = new MstCityOutBean();
            bean.setCityCd(cityCd);
            bean.setCityName(cityName);

            resultList.add(bean);
        }

        return resultList;
    }

}