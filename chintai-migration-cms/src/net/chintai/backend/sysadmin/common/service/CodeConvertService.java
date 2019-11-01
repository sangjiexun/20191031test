/*
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 * $Id: CodeConvertService.java 3841 2008-02-27 07:01:05Z t-kojima $
 */
package net.chintai.backend.sysadmin.common.service;

import java.util.Map;

/**
 * リソースファイルのコードを対応する値に置き換えるロジックです。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3841 $
 */
public interface CodeConvertService {

    /**
     * コードマップを構築します。
     * <p>
     * (key, value) = (コード, 対応値) の形となります。
     * </p>
     * @param codeKey コードが定義されたリソース名
     * @param valueKey コード対応値が定義されたリソース名
     * @return コードマップ
     */
    public Map<String, String> getCodeMap(String codeKey, String valueKey);

    /**
     * 値からコードを取得します。
     * @param codeKey コードが定義されたリソース名
     * @param valueKey コード対応値が定義されたリソース名
     * @param value コード対応値
     * @return 対応するコード
     */
    public String getCode(String codeKey, String valueKey, String value);

    /**
     * コードから値を取得します。
     * @param codeKey コードが定義されたリソース名
     * @param valueKey コード対応値が定義されたリソース名
     * @param code コード
     * @return 対応する値
     */
    public String getValue(String codeKey, String valueKey, String code);

}
