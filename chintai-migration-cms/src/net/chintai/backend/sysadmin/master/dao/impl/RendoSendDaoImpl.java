package net.chintai.backend.sysadmin.master.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.master.dao.RendoSendDao;
import net.chintai.backend.sysadmin.master.dao.RendoSendParamBean;
import net.chintai.backend.sysadmin.master.domain.RendoSendInfoDomain;
import net.chintai.backend.sysadmin.master.domain.RendoSendListDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class RendoSendDaoImpl extends SqlMapClientDaoSupport implements RendoSendDao {

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.master.dao.RendoSendDao#selectRendoSendKanriList(java.util.List)
	 */
	@Override
	public List<RendoSendListDomain> selectRendoSendKanriList(RendoSendParamBean paramBean) {
		return getSqlMapClientTemplate().queryForList("master.selectRendoSendKanriList", paramBean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.master.dao.RendoSendDao#selectRendoSendKanri(net.chintai.backend.sysadmin.master.dao.RendoSendParamBean)
	 */
	@Override
	public List<RendoSendInfoDomain> selectRendoSendKanri( RendoSendParamBean paramBean) {
		return getSqlMapClientTemplate().queryForList("master.selectRendoSendKanri", paramBean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.master.dao.RendoSendDao#countRendoSendDtInvalid(net.chintai.backend.sysadmin.master.dao.RendoSendParamBean)
	 */
	@Override
	public int countRendoSendDtInvalid(RendoSendParamBean paramBean) {
		return (int) getSqlMapClientTemplate().queryForObject("master.countRendoSendDtInvalid", paramBean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.master.dao.RendoSendDao#updateRendoSend(net.chintai.backend.sysadmin.master.dao.RendoSendParamBean)
	 */
	@Override
	public int updateRendoSend(RendoSendParamBean paramBean) {
		return (int) getSqlMapClientTemplate().update("master.updateRendoSend", paramBean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.master.dao.RendoSendDao#insertRendoSend(net.chintai.backend.sysadmin.master.dao.RendoSendParamBean)
	 */
	@Override
	public void insertRendoSend(RendoSendParamBean paramBean) {
		getSqlMapClientTemplate().insert("master.insertRendoSend", paramBean);
	}
}
