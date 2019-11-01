package net.chintai.backend.sysadmin.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.master.dao.RendoSendDao;
import net.chintai.backend.sysadmin.master.dao.RendoSendParamBean;
import net.chintai.backend.sysadmin.master.domain.RendoSendInfoDomain;
import net.chintai.backend.sysadmin.master.domain.RendoSendListDomain;
import net.chintai.backend.sysadmin.master.service.RendoSendService;
import net.chintai.backend.sysadmin.master.service.bean.RendoSendInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.RendoSendInfoOutServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.RendoSendListOutServiceBean;
import net.chintai.batch.common.GenericFlg;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

public class RendoSendServiceImpl implements RendoSendService {

	/** 連動元リスト取得 DAO */
	private RendoSendDao rendoSendDao;

	/**
	 * RendoListDaoを設定する
	 * @param rendoSendDao
	 */
	public void setRendoSendDao(RendoSendDao rendoSendDao) {
		this.rendoSendDao = rendoSendDao;
	}

    @Autowired
    private PlatformTransactionManager txManager;

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.master.service.RendoSendListService#rendoSendList()
	 */
	@Override
	public List<RendoSendListOutServiceBean> getRendoSendList(RendoSendInServiceBean inBean) throws Exception {
		// パラメータ生成
		RendoSendParamBean paramBean= new RendoSendParamBean();
		if (inBean != null){
			BeanUtils.copyProperties(paramBean, inBean);
		}
		// 全連動元の出稿許可区分を取得する
		List<RendoSendListDomain> domainList = rendoSendDao.selectRendoSendKanriList(paramBean);

		// 戻り値生成
		List<RendoSendListOutServiceBean> outBeanList = new ArrayList<RendoSendListOutServiceBean>();
		for(RendoSendListDomain domain : domainList) {
			RendoSendListOutServiceBean outBean = new RendoSendListOutServiceBean();
			BeanUtils.copyProperties(outBean, domain);
			outBeanList.add(outBean);
		}
		return outBeanList;
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.master.service.RendoSendService#getRendoSendInfo(net.chintai.backend.sysadmin.master.service.bean.RendoSendInServiceBean)
	 */
	@Override
	public List<RendoSendInfoOutServiceBean> getRendoSendInfo(RendoSendInServiceBean inBean) throws Exception {
		// パラメータ生成
		RendoSendParamBean paramBean = new RendoSendParamBean();
		BeanUtils.copyProperties(paramBean, inBean);

		// 許可情報取得
		List<RendoSendInfoDomain> domainList = rendoSendDao.selectRendoSendKanri(paramBean);
		// 許可番号が指定されていて、情報が取得できなければエラー
		if (!StringUtils.isEmpty(paramBean.getRendoSendNo()) && domainList.size() != 1) {
			throw new ApplicationException("FETAL.M.SYSTEM.0001");
		}

		// 戻り値作成
		List<RendoSendInfoOutServiceBean> outBeanList = new ArrayList<RendoSendInfoOutServiceBean>();
		for (RendoSendInfoDomain domain : domainList) {
			RendoSendInfoOutServiceBean outBean = new RendoSendInfoOutServiceBean();
			BeanUtils.copyProperties(outBean, domain);
			if (outBean.getPermitEndDt().equals(SystemProperties.getProperty("LAST_DT"))) {
				outBean.setPermitEndDt("");
			}
			outBeanList.add(outBean);
		}
		return outBeanList;
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.master.service.RendoSendService#chkRendoSendDt(net.chintai.backend.sysadmin.master.service.bean.RendoSendInServiceBean)
	 */
	public void chkRendoSendDt(RendoSendInServiceBean inBean) throws Exception {
		// パラメータ生成
		RendoSendParamBean paramBean = new RendoSendParamBean();
		BeanUtils.copyProperties(paramBean, inBean);
		if (StringUtils.isEmpty(paramBean.getRendoSendNo())) {
			paramBean.setRendoSendNo("0");
		}

		// 期間不正チェック
		int resultCnt = rendoSendDao.countRendoSendDtInvalid(paramBean);
		if (resultCnt != 0) {
			String[] msg = {ApplicationResources.getProperty("master.permitDt"),
							ApplicationResources.getProperty("master.permitKikan"),
							ApplicationResources.getProperty("master.permitDuplicate")};
			throw new ApplicationException("WARN.M.MASTER.0059", msg);
		}
	}

	public void updateRendoSend(RendoSendInServiceBean inBean) throws Exception {
		RendoSendParamBean paramBean = new RendoSendParamBean();
		paramBean.setUpdId(inBean.getUserId());
		paramBean.setInsId(inBean.getUserId());
		paramBean.setUpdPg(inBean.getPgName());
		paramBean.setInsPg(inBean.getPgName());

		// 期間不正チェック
		chkRendoSendDt(inBean);

		// 値補完
		BeanUtils.copyProperties(paramBean, inBean);
		if (paramBean.getPermitEndDt().equals("")) {
			paramBean.setPermitEndDt(SystemProperties.getProperty("LAST_DT"));
		}
		if (inBean.getProcKbn().equals("delete")) {
			paramBean.setDelKbn(GenericFlg.ON.getValue());
		}

		// 更新処理
		if (inBean.getProcKbn().equals("insert")) {
			rendoSendDao.insertRendoSend(paramBean);
		} else if (inBean.getProcKbn().equals("update") || inBean.getProcKbn().equals("delete")){
			List<RendoSendInfoDomain> domainList = rendoSendDao.selectRendoSendKanri(paramBean);
			if (domainList == null || domainList.size() == 0) {
				throw new ApplicationException("ERROR.M.COUNT.0005");
			}
			rendoSendDao.updateRendoSend(paramBean);
		}
	}
}
