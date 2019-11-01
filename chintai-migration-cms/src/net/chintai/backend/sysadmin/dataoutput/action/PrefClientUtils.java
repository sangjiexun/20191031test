package net.chintai.backend.sysadmin.dataoutput.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.ClientSystemTypeConst;
import net.chintai.backend.sysadmin.dataoutput.action.view.PrefClientUpdateBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstPrefOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.PrefClientDataOutServiceBean;

import org.apache.commons.lang.StringUtils;


/**
 * 都道府県別データ元出力設定機能のユーティリティクラス
 *
 * @author e-ishii
 * @version $Revision: 4585 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class PrefClientUtils {



    /**
     * prefcdに紐づくクライアントシステムを取得する。
     * 更新画面の表示時に使用
     *
     *
     * @param clientSystemTypeDataList
     * @param prefcd
     * @return
     */
    public static List<String> getClientList(List<PrefClientDataOutServiceBean> clientSystemTypeDataList, String prefcd) {

        List<String> clientList = setClientList(clientSystemTypeDataList, prefcd);

        return getAllClientsystemTypeList(clientList);

    }

    /**
     * prefcdに紐づくクライアントシステムを取得する。
     * 更新画面表示時、
     * 更新確認画面から更新画面に戻るとき、
     * 更新処理のとき使用
     *
     * @param clientSystemTypeDataList
     * @param prefcd
     * @return
     */
    public static List<String> getClientReverseList(List<PrefClientDataOutServiceBean> clientSystemTypeDataList, String prefcd) {

        List<String> clientList = setClientList(clientSystemTypeDataList, prefcd);

        return getAllReverseClientsystemTypeList(clientList);

    }

    /**
     * prefcdに紐づくクライアントシステムタイプデータ（複数or一つ）を取得
     *
     * @param clientSystemTypeDataList
     * @param prefcd
     * @return
     */
    private static List<String> setClientList(List<PrefClientDataOutServiceBean> clientSystemTypeDataList, String prefcd) {

        List<String> clientList = new ArrayList<String>();

        for (PrefClientDataOutServiceBean prefClientData :clientSystemTypeDataList) {
            if (StringUtils.equals(prefClientData.getPrefcd(), prefcd)) {
                clientList.add(prefClientData.getClientsystemType());
            }
        }
        return clientList;
    }

    /**
     * 更新確認画面の表示時に使用
     *
     * DBから取得したデータを画面用にセットする。
     * DBにあるということは、出力対象外。
     * DBにあるデータ（出力対象外）のクライアントシステムタイムは0をセットする。
     * DBにないデータ（出力対象）は、net.chintai.backend.sysadmin.dataoutput.ClientSystemTypeConstの値をセットする。
     * crs:1 ans:2 able:3 magazine:4 campus:5
     *
     * ここで、DBにprefcd=1のレコードが2件しかなくても、5件にしてあげて、
     * それぞれのクライアントタイプが、出力対象外（0）か出力対象（1～5）の値をセットする。
     *
     * @param clientsystemTypelist
     * @return
     */
    private static List<String> getAllClientsystemTypeList(List<String> clientsystemTypelist) {

        List<String> resultList = new ArrayList<String>();

        for (String constClientsystemType : ClientSystemTypeConst.constList) {

            if (clientsystemTypelist.contains(constClientsystemType)) {
                // 0は対象外という意味
                resultList.add("0");
            } else {
                resultList.add(constClientsystemType);
            }
        }
        return resultList;
    }

    /**
     * 更新確認画面から、更新画面に戻るときと
     * 更新処理のとき使用
     *
     * 画面上（form）のデータを、更新画面に戻るときや、DB更新処理に使用する。
     * つまり画面でチェックがついているデータ（出力対象）は、再度画面に表示させる場合は、逆にしなければならない。
     * 出力対象なら、net.chintai.backend.sysadmin.dataoutput.ClientSystemTypeConstの値をセットする。
     * 出力対象外には、0をセットする。
     *
     * @param clientsystemTypelist
     * @return
     */
    private static List<String> getAllReverseClientsystemTypeList(List<String> clientsystemTypelist) {

        List<String> resultList = new ArrayList<String>();

        for (String constClientsystemType : ClientSystemTypeConst.constList) {

            if (clientsystemTypelist.contains(constClientsystemType)) {
                // 対象なら、数値1,2,3,4,5,6（クライアントシステムタイプ）をセット
                resultList.add(constClientsystemType);
            } else {
                resultList.add("0");
            }
        }
        return resultList;
    }




    /**
     * 配列のデータ（prefcd + clientsystemType）をArrayListに入れてあげる処理
     *
     * @param formPrefClientList
     * @return
     */
    public static List<PrefClientDataOutServiceBean> convertClientSystemList(String[] formPrefClientList) {

        List<PrefClientDataOutServiceBean> resultList= new ArrayList<PrefClientDataOutServiceBean>();

        for (String formPrefAndClient : formPrefClientList) {

            String[] prefClientArray = StringUtils.split(formPrefAndClient, "_");

            PrefClientDataOutServiceBean prefClientBean = new PrefClientDataOutServiceBean();
            prefClientBean.setPrefcd(prefClientArray[0]);
            prefClientBean.setClientsystemType(prefClientArray[1]);
            resultList.add(prefClientBean);
        }

        return resultList;

    }

    /**
     * 配列のデータ(prefcd + prefname)をArrayListに入れてあげる処理
     *
     * @param formBean
     * @return
     */
    public static List<MstPrefOutBean> convertMstPrefList(PrefClientUpdateBean formBean) {

        List<MstPrefOutBean> resultList = new ArrayList<MstPrefOutBean>();
        for (int i=0; i<formBean.getPrefcdArray().length; i++) {

            String prefcd = formBean.getPrefcdArray()[i];
            String prefname = formBean.getPrefnameArray()[i];

            MstPrefOutBean bean = new MstPrefOutBean();
            bean.setPrefcd(prefcd);
            bean.setPrefname(prefname);

            resultList.add(bean);
        }

        return resultList;
    }




}
