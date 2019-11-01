package net.chintai.backend.sysadmin.dataoutput.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.service.bean.MstEnsenOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingSearchInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingSearchOutServiceBean;

import org.apache.commons.lang.StringUtils;

/**
 * データ元出力設定機能のユーティリティクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4823 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class RosenClientSettingUtils {

    /**
     * ensenCdに紐づくクライアントシステムを取得する。 更新画面の表示時に使用
     *
     *
     * @param clientSystemTypeDataList
     * @param ensenCd
     * @return
     */
    public static List<String> getEnsenClientList(
            List<RosenClientSettingSearchOutServiceBean> clientSystemTypeDataList, String ensenCd) {

        List<String> clientList = setEnsenClientList(clientSystemTypeDataList, ensenCd);

        return ClientSettingUtils.getAllClientsystemTypeList(clientList);

    }

    /**
     * ensenCdに紐づくクライアントシステムを取得する。 更新画面表示時、 更新確認画面から更新画面に戻るとき、 更新処理のとき使用
     *
     * @param clientSystemTypeDataList
     * @param ensenCd
     * @return
     */
    public static List<String> getEnsenClientReverseList(
            List<RosenClientSettingSearchOutServiceBean> clientSystemTypeDataList, String ensenCd) {

        List<String> clientList = setEnsenClientList(clientSystemTypeDataList, ensenCd);

        return ClientSettingUtils.getAllReverseClientsystemTypeList(clientList);

    }

    /**
     * ensenCdに紐づくクライアントシステムタイプデータ（複数or一つ）を取得
     *
     * @param clientSystemTypeDataList
     * @param ensenCd
     * @return
     */
    private static List<String> setEnsenClientList(
            List<RosenClientSettingSearchOutServiceBean> clientSystemTypeDataList, String ensenCd) {

        List<String> clientList = new ArrayList<String>();

        for (RosenClientSettingSearchOutServiceBean ensenClientData : clientSystemTypeDataList) {
            if (StringUtils.equals(ensenClientData.getEnsenCd(), ensenCd)) {
                clientList.add(ensenClientData.getClientsystemType());
            }
        }
        return clientList;
    }

    /**
     * 配列のデータ（ensenCd + clientsystemType）をArrayListに入れてあげる処理
     *
     * @param formPrefClientList
     * @return
     */
    public static List<RosenClientSettingSearchOutServiceBean> convertEnsenClientSystemList(
            String[] formEnsenClientList) {

        List<RosenClientSettingSearchOutServiceBean> resultList =
                new ArrayList<RosenClientSettingSearchOutServiceBean>();

        for (String formEnsenAndClient : formEnsenClientList) {

            String[] ensenClientArray = StringUtils.split(formEnsenAndClient, "_");

            RosenClientSettingSearchOutServiceBean ensenClientBean =
                    new RosenClientSettingSearchOutServiceBean();
            ensenClientBean.setEnsenCd(ensenClientArray[0]);
            ensenClientBean.setClientsystemType(ensenClientArray[1]);
            resultList.add(ensenClientBean);
        }

        return resultList;

    }

    /**
     * 配列のデータ(ensenCd + ensenname)をArrayListに入れてあげる処理
     *
     * @param formBean
     * @return
     */
    public static List<MstEnsenOutBean> convertMstEnsenList(
            RosenClientSettingSearchInServiceBean inServiceBean) {

        List<MstEnsenOutBean> resultList = new ArrayList<MstEnsenOutBean>();
        for (int i = 0; i < inServiceBean.getEnsenCdArray().length; i++) {

            String ensenCd = inServiceBean.getEnsenCdArray()[i];
            String ensenName = inServiceBean.getEnsenNameArray()[i];
            String ensenKana = inServiceBean.getEnsenKanaArray()[i];

            MstEnsenOutBean bean = new MstEnsenOutBean();
            bean.setEnsenCd(ensenCd);
            bean.setEnsenName(ensenName);
            bean.setEnsenKana(ensenKana);

            resultList.add(bean);
        }

        return resultList;
    }

}