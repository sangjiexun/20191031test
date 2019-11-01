package net.chintai.backend.sysadmin.master.dao.impl;

import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.master.dao.NodeUpdateCommitDao;
import net.chintai.backend.sysadmin.master.domain.NodeDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * NodeUpdateCommitDao インターフェースの実装クラス
 * 
 * @author M.Ono
 * @version $Revision: 4029 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class NodeUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements NodeUpdateCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao#selectEkiMaster(java.util.List)
     */
    @SuppressWarnings("unchecked")
    public Map<String, NodeDomain> selectNodeMaster(List<NodeDomain> nodeEkiList) {
        return getSqlMapClientTemplate().queryForMap("master.selectNodeMaster", nodeEkiList, "ekiNo");
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao#ekiInsert(net.chintai.backend.sysadmin.master.domain.EkiDomain)
     */
    public void nodeInsert(NodeDomain nodeEki) {
        getSqlMapClientTemplate().insert("master.nodeInsert", nodeEki);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao#ekiUpdate(net.chintai.backend.sysadmin.master.domain.EkiDomain)
     */
    public int nodeUpdate(NodeDomain nodeEki) {
        return getSqlMapClientTemplate().update("master.nodeUpdate", nodeEki);
    }

}
