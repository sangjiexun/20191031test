/*
 * $Id: FudousanUpdateConfirmServiceDao.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/04     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;


/**
 * 不動産会社更新確認DAO
 * @author TAKAHASHI Yuki
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanUpdateConfirmServiceDao {

    /**
     * 同一会社名、電話番号の会社が既に登録されていないか確認
     * @param paramBean 検索パラメータ（会社名、電話番号）
     * @return 検索結果件数
     */
    public int confirmCompanyInfo(FudousanConfirmCompanyInfoParamBean paramBean);
}
