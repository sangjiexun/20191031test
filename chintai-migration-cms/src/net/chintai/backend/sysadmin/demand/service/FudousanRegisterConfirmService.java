/*
 * $Id: FudousanRegisterConfirmService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.demand.service.bean.FudousanRegisterConfirmInServiceBean;


/**
 * 不動産会社新規登録確認サービス
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanRegisterConfirmService {

    /**
     * 入力値に基づいて<br>
     * 同一会社名及び電話番号の会社が 登録されているか確認します
     * @param inBean 検索パラメータ（登録する会社名、電話番号）
     * @return 検索結果件数
     */
    public int confirmKaisyaInfo(FudousanRegisterConfirmInServiceBean inBean);

    /**
     * 不動産会社コードのNext値を取得
     * @return 不動産会社コードのNext値
     */
    public String getNextFudousanCd();
}
