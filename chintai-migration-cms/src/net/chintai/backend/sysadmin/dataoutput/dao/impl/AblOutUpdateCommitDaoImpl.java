/*
 * $Id: AblOutUpdateCommitDaoImpl.java 4718 2013-11-05 07:47:20Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.dataoutput.dao.AblOutUpdateCommitDao;
import net.chintai.backend.sysadmin.dataoutput.dao.AblOutUpdateParamBean;

/**
 * AblOutUpdateCommitDao実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4718 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AblOutUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements
        AblOutUpdateCommitDao {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.dataoutput.dao.AblOutUpdateCommitDao#
     * AblOutUpdate
     * (net.chintai.backend.sysadmin.dataoutput.dao.AblOutUpdateParamBean)
     */
    public int ablOutUpdate(AblOutUpdateParamBean paramBean) {
        return getSqlMapClientTemplate().update("dataoutput.ablOutUpdate", paramBean);
    }

}
