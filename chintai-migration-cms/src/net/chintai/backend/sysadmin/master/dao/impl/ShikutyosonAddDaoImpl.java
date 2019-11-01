/*
 * $Id: ShikutyosonAddDaoImpl.java 4294 2009-07-07 12:42:15Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/14  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao.impl;

import net.chintai.backend.sysadmin.master.dao.ShikutyosonAddParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ShikutyosonAddDaoの実装クラス
 *
 * @author Yang-EunMi
 * @version $Revision: 4294 $ Copyright:
 * (C) CHINTAI Corporation All RightS Reserved.
 */
public class ShikutyosonAddDaoImpl extends SqlMapClientDaoSupport implements
        net.chintai.backend.sysadmin.master.dao.ShikutyosonAddDao {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.master.dao.ShikutyosonAddDao#insertMstCity
     * (net.chintai.backend.sysadmin.master.dao.ShikutyosonAddParamBean)
     */
    public void insertMstCity(ShikutyosonAddParamBean paramBean) {
        getSqlMapClientTemplate().insert("master.insertMstCity", paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.master.dao.ShikutyosonAddDao#insertMstZipCode
     * (net.chintai.backend.sysadmin.master.dao.ShikutyosonAddParamBean)
     */
    public void insertMstZipCode(ShikutyosonAddParamBean paramBean) {
        getSqlMapClientTemplate().insert("master.insertMstZipCode", paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.master.dao.ShikutyosonAddDao#selectMstZipCode
     * (net.chintai.backend.sysadmin.master.dao.ShikutyosonAddParamBean)
     */
    public int selectMstZipCode(ShikutyosonAddParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("master.selectMstZipCode",
                paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.master.dao.ShikutyosonAddDao#selectMstCity
     * (net.chintai.backend.sysadmin.master.dao.ShikutyosonAddParamBean)
     */
    public int selectMstCity(ShikutyosonAddParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate()
                .queryForObject("master.selectMstCity", paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.master.dao.ShikutyosonAddDao#updateMstZipCode
     * (net.chintai.backend.sysadmin.master.dao.ShikutyosonAddParamBean)
     */
    public void updateMstZipCode(ShikutyosonAddParamBean paramBean) {
        getSqlMapClientTemplate().update("master.updateMstZipCode", paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.master.dao.ShikutyosonAddDao#deleteMstZipCode
     * (net.chintai.backend.sysadmin.master.dao.ShikutyosonAddParamBean)
     */
    public void deleteMstZipCode(ShikutyosonAddParamBean paramBean) {
        getSqlMapClientTemplate().delete("master.deleteMstZipCode", paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.master.dao.ShikutyosonAddDao#updateMstCity
     * (net.chintai.backend.sysadmin.master.dao.ShikutyosonAddParamBean)
     */
    public void updateMstCity(ShikutyosonAddParamBean paramBean) {
        getSqlMapClientTemplate().update("master.updateMstCity", paramBean, 1);
    }

}
