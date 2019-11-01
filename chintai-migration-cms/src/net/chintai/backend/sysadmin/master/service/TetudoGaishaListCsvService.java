/*
 * $Id: TetudoGaishaListCsvService.java 4076 2008-11-19 09:33:13Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/10/08  BGT)長谷川正一 新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service;

import java.util.List;

import net.chintai.backend.sysadmin.master.service.bean.TetudoGaishaOutSearchServiceBean;

/**
 * 鉄道会社情報をCSV出力形式に変換するサービス。
 * 
 * @author S.HASEGAWA
 * @version $Revision: 4076 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public interface TetudoGaishaListCsvService {

    /**
     * 鉄道会社情報をCSV出力形式に変換します。
     * @param tetudoGaishaList {@link List} -
     *        {@link TetudoGaishaOutSearchServiceBean} のリスト
     * @return {@link List} - String[]のリスト
     */
    public List<String[]> createTetudoGaishaListCsv(List<TetudoGaishaOutSearchServiceBean> tetudoGaishaList);
}
