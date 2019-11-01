/*
 * $Id: TetudoGaishaSearchDaoImpl.java 4076 2008-11-19 09:33:13Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/10/08  BGT)長谷川正一 新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.master.dao.TetudoGaishaSearchDao;
import net.chintai.backend.sysadmin.master.dao.TetudoGaishaSearchParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * TetudoGaishaSearchDaoの実装クラス
 * 
 * @author S.HASEGAWA
 * @version $Revision: 4076 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class TetudoGaishaSearchDaoImpl extends SqlMapClientDaoSupport implements TetudoGaishaSearchDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.TetudoGaishaSearchDao#selectTetudoGaishaCount(net.chintai.backend.sysadmin.master.dao.TetudoGaishaSearchParamBean)
     */
    public int selectTetudoGaishaCount(TetudoGaishaSearchParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("master.selectTetudoGaishaCount", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.TetudoGaishaSearchDao#selectTetudoGaishaList(net.chintai.backend.sysadmin.master.dao.TetudoGaishaSearchParamBean,
     *      net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    public List selectTetudoGaishaList(TetudoGaishaSearchParamBean paramBean, BasePagerCondition condition) {
        return getSqlMapClientTemplate().queryForList("master.selectTetudoGaishaList", paramBean,
                condition.getOffset(), condition.getLimit());
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.TetudoGaishaSearchDao#selectTetudoGaishaForCsv(net.chintai.backend.sysadmin.master.dao.TetudoGaishaSearchParamBean)
     */
    public List selectTetudoGaishaForCsv(TetudoGaishaSearchParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("master.selectTetudoGaishaList", paramBean);
    }
}
