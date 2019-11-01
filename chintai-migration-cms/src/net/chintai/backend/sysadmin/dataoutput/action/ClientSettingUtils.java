package net.chintai.backend.sysadmin.dataoutput.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.dataoutput.ClientSystemTypeConst;

import org.apache.commons.lang.StringUtils;

/**
 * データ元出力設定機能のユーティリティクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4776 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class ClientSettingUtils {

    /**
     * SYSTEMCLIENTTYPEのマップ(Key=SYSTEMCLIENTTYPE_KEY
     * value=SYSTEMCLIENTTYPE_VALUE)
     */
    private static final Map<String, String> typeMap = new HashMap<String, String>();

    static {
        String[] outNames = (SystemProperties.getProperty("SYSTEMCLIENTTYPE_VALUE")).split(",");
        String[] outValues = (SystemProperties.getProperty("SYSTEMCLIENTTYPE_KEY")).split(",");

        for (int i = 0; i < outValues.length; i++) {
            typeMap.put(outValues[i], outNames[i]);
        }

    }

    /**
     * 子他社データ元出力設定更新時に親他社データ連携除外設定に削除対象のデータが存在するかチェックする
     * @param clientsystemTypeMap
     * @param parentalClientType
     * @return 削除対象リスト
     */
    public static List<String> getDeliteParentalList(Map<String, List<String>> clientsystemTypeMap,
            List<String> parentalClientType) {

        List<String> commitTypeList = new ArrayList<String>();

        // 親他社データ元出力設定分繰り返す
        for (String clientType : parentalClientType) {
            // 子他社データ元出力設定分繰り返す
            for (List<String> typeList : clientsystemTypeMap.values()) {

                // 親、子データ元出力設定が一致する場合("1"or"2"or"3"or"4"or"5"がある場合)返却用リストに文字列("1"or"2"o"3"or"4"or"5")を格納する
                if (typeList.contains(clientType)){
                    commitTypeList.add(clientType);
                    break;
                }
            }
        }

        return commitTypeList;

    }

    /**
     * 親、他社データ連携除外設定に削除対象データのメッセージを作成する
     * @param parentalTypeList
     * @return メッセージ用削除対象名
     */
    public static String getParentalDeleteMsg(List<String> parentalTypeList) {

        StringBuilder typeMsg = new StringBuilder();
        // 親データのリスト分繰り返す
        for (String type : parentalTypeList) {
            typeMsg.append(typeMap.get(type));
            typeMsg.append(",");
        }
        // 削除用メッセージがあった場合、文字列最後に","がついてしまうため削除する
        if (StringUtils.isNotEmpty(typeMsg.toString())) {
            typeMsg = typeMsg.delete(typeMsg.length() - 1, typeMsg.length());
        }

        return typeMsg.toString();
    }

    /**
     * 更新確認画面の表示時に使用
     *
     * DBから取得したデータを画面用にセットする。 DBにあるということは、出力対象外。
     * DBにあるデータ（出力対象外）のクライアントシステムタイムは0をセットする。
     * DBにないデータ（出力対象）は、net.chintai.backend
     * .sysadmin.dataoutput.ClientSystemTypeConstの値をセットする。 crs:1 ans:2 able:3
     * magazine:4 campus:5
     *
     * ここで、DBにensenCd=1のレコードが2件しかなくても、5件にしてあげて、
     * それぞれのクライアントタイプが、出力対象外（0）か出力対象（1～5）の値をセットする。
     *
     * @param clientsystemTypelist
     * @return
     */
    public static List<String> getAllClientsystemTypeList(List<String> clientsystemTypelist) {

        List<String> resultList = new ArrayList<String>();

        // constList("1","2","3","4","5")分繰り返す
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
     * 更新確認画面から、更新画面に戻るときと 更新処理のとき使用
     *
     * 画面上（form）のデータを、更新画面に戻るときや、DB更新処理に使用する。
     * つまり画面でチェックがついているデータ（出力対象）は、再度画面に表示させる場合は、逆にしなければならない。
     * 出力対象なら、net.chintai.backend
     * .sysadmin.dataoutput.ClientSystemTypeConstの値をセットする。 出力対象外には、0をセットする。
     *
     * @param clientsystemTypelist
     * @return
     */
    public static List<String> getAllReverseClientsystemTypeList(List<String> clientsystemTypelist) {

        List<String> resultList = new ArrayList<String>();

        //
        for (String constClientsystemType : ClientSystemTypeConst.constList) {

            if (clientsystemTypelist.contains(constClientsystemType)) {
                // 対象なら、数値1,2,3,4,5（クライアントシステムタイプ）をセット
                resultList.add(constClientsystemType);
            } else {
                resultList.add("0");
            }
        }
        return resultList;
    }

}