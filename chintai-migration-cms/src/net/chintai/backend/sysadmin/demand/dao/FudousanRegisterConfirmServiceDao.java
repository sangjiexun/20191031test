/*
 * $Id: FudousanRegisterConfirmServiceDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;


/**
 * 不動産会社登録確認DAO
 *
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanRegisterConfirmServiceDao {

    /**
     * 同一会社名、電話番号の会社が既に登録されていないか確認
     * @param paramBean 検索パラメータ
     * @return int 検索結果件数
     */
    public int confirmCompanyInfo(FudousanConfirmCompanyInfoParamBean paramBean);


    /**
     * SEQ_FUDOUSAN_KAISYA_CDのNext値を取得する
     * @return String 新しい不動産会社コード（SEQ_FUDOUSAN_KAISYA_CD.NextVal）
     */
    public String getNextFudousanCd();
}
