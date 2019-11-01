/*
 * $Id: AdDataUpdateCommitDao.java 4367 2009-09-01 05:37:54Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/24     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.dao;

import java.util.List;


/**
 * ADデータ登録DAO
 * @author e-ishii
 * @version $Revision: 4367 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AdDataUpdateCommitDao {

    /**
     * ADデータテーブルにCVSファイルデータをインサートします。
     * @param paramList パラメータ
     */
    public void adDatainsert(List<AdDataAddParamBean> paramList);

    /**
     * ADデータテーブルにCVSファイルデータをインサートします。(バッチ方式)
     * @param paramList パラメータ
     */
    public int adDatainsertByBatch(List<AdDataAddParamBean> paramList);

    /**
     * ADデータテーブルの削除フラグを1（削除）にします。
     * @param paramBean パラメータ
     */
    public void deleteAdData(AdDataAddParamBean paramBean);

}
