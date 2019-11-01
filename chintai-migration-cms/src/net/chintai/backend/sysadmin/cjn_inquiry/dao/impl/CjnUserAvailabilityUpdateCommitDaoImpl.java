/*
 * $Id: CjnUserAvailabilityUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAvailabilityUpdateCommitDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfoUsers;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;

import org.apache.commons.lang.StringUtils;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnUserAvailabilityUpdateCommitDao の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAvailabilityUpdateCommitDaoImpl
            extends SqlMapClientDaoSupport implements CjnUserAvailabilityUpdateCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAvailabilityUpdateCommitDao#updateUsersAvailability(java.util.List, int, java.lang.String)
     */
    public void updateUsersAvailability(List<CjnInquiryTypeInfoUsers> usersList,
                int cjnInqKindSeq, String lastUpdateTime) throws ApplicationException {

        SqlMapClientTemplate smc = getSqlMapClientTemplate();

        /*
         * 1. 前回のデータ取得時から更新があったかどうかチェック(更新があった場合エラーとする)
         * 2. 該当する問い合せ種別に紐付く閲覧可能ユーザ情報をすべて DELETE
         * 3. 画面から渡ってきた閲覧可能ユーザ情報を新規にINSERT
         */
        String serverLastUpdateTime =
                (String) smc.queryForObject("cjn_inquiry.selectUsersAvailabilityLastUpdateTime", cjnInqKindSeq);

        // serverLastUpdateTime が null 値である可能性を考慮(null のとき、空文字列にする)。
        // 例えば、閲覧可能問い合せが 0 件のとき null が返ってくる。
        // なお lastUpdateTime は null でないことが保証されている。
        if (!lastUpdateTime.equals(StringUtils.defaultString(serverLastUpdateTime))) {
            throw new ApplicationException("ERROR.M.CJN_INQUIRY.0002");
        }

        smc.delete("cjn_inquiry.deleteUsersAvailability", cjnInqKindSeq);

        if (usersList != null && usersList.size() > 0) {
            for (int i = 0; i < usersList.size(); i++) {
                smc.insert("cjn_inquiry.insertUsersAvailability", usersList.get(i));
            }
        }
    }
}
