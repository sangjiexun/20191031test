package net.chintai.backend.sysadmin.dataoutput.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstEkiOutBean;

import org.apache.commons.lang.StringUtils;

/**
 * データ元出力設定機能のユーティリティクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4779 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class EkiClientSettingUtils {


    /**
     * ekiCdに紐づくクライアントシステムを取得する。 更新画面の表示時に使用
     *
     *
     * @param clientSystemTypeDataList
     * @param ekiCd
     * @return
     */
    public static List<String> getEkiClientList(
            List<EkiClientSettingInfoOutServiceBean> clientSystemTypeDataList, String ekiCd) {

        List<String> ekiClientList = setEkiClientList(clientSystemTypeDataList, ekiCd);

        return ClientSettingUtils.getAllClientsystemTypeList(ekiClientList);

    }

    /**
     * ekiCdに紐づくクライアントシステムタイプデータ（複数or一つ）を取得
     *
     * @param clientSystemTypeDataList
     * @param prefcd
     * @return
     */
    private static List<String> setEkiClientList(
            List<EkiClientSettingInfoOutServiceBean> clientSystemTypeDataList, String ekiCd) {

        List<String> clientList = new ArrayList<String>();

        for (EkiClientSettingInfoOutServiceBean ekiClientData : clientSystemTypeDataList) {
            if (StringUtils.equals(ekiClientData.getEkiCd(), ekiCd)) {
                clientList.add(ekiClientData.getClientsystemType());
            }
        }
        return clientList;
    }

    /**
     * 配列のデータ（ekiCd + clientsystemType）をArrayListに入れてあげる処理
     *
     * @param formEkiClientList
     * @return
     */
    public static List<EkiClientSettingInfoOutServiceBean> convertEkiClientSystemList(
            String[] formEkiClientList) {

        List<EkiClientSettingInfoOutServiceBean> resultList =
                new ArrayList<EkiClientSettingInfoOutServiceBean>();

        for (String formEkiAndClient : formEkiClientList) {

            String[] ekiClientArray = StringUtils.split(formEkiAndClient, "_");

            EkiClientSettingInfoOutServiceBean ensenClientBean =
                    new EkiClientSettingInfoOutServiceBean();
            ensenClientBean.setEkiCd(ekiClientArray[0]);
            ensenClientBean.setClientsystemType(ekiClientArray[1]);
            resultList.add(ensenClientBean);
        }

        return resultList;

    }

    /**
     * 配列のデータ(ekiCd + ekiName)をArrayListに入れてあげる処理
     *
     * @param formBean
     * @return
     */
    public static List<MstEkiOutBean> convertMstEkiList(
            EkiClientSettingInfoInServiceBean inServiceBean) {

        List<MstEkiOutBean> resultList = new ArrayList<MstEkiOutBean>();
        for (int i = 0; i < inServiceBean.getEkiCdArray().length; i++) {

            String ensenCd = inServiceBean.getEkiCdArray()[i];
            String ensenName = inServiceBean.getEkiNameArray()[i];

            MstEkiOutBean bean = new MstEkiOutBean();
            bean.setEkiCd(ensenCd);
            bean.setEkiName(ensenName);

            resultList.add(bean);
        }

        return resultList;
    }

    /**
     * ekiCdに紐づくクライアントシステムを取得する。 更新画面表示時、 更新確認画面から更新画面に戻るとき、 更新処理のとき使用
     * @param clientSystemTypeDataList
     * @param ekiCd
     * @return
     */
    public static List<String> getEkiClientReverseList(
            List<EkiClientSettingInfoOutServiceBean> clientSystemTypeDataList, String ekiCd) {

        List<String> clientList = setEkiClientList(clientSystemTypeDataList, ekiCd);

        return ClientSettingUtils.getAllReverseClientsystemTypeList(clientList);

    }


}