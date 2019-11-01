package net.chintai.backend.sysadmin.master.service;

import java.util.List;

import net.chintai.backend.sysadmin.master.service.bean.RendoSendInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.RendoSendInfoOutServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.RendoSendListOutServiceBean;

public interface RendoSendService {
	/**
	 * 全連動元の出稿許可区分を取得
	 * @param inBeanList
	 * @return
	 * @throws Exception
	 */
	public List<RendoSendListOutServiceBean> getRendoSendList(RendoSendInServiceBean inBean) throws Exception;
	/**
	 * 対象の連動元･契約の出稿許可情報を取得
	 * @param inBean
	 * @return
	 * @throws Exception
	 */
	public List<RendoSendInfoOutServiceBean> getRendoSendInfo(RendoSendInServiceBean inBean) throws Exception;
	/**
	 * 出稿許可期間の不正チェック
	 * @param inBean
	 * @throws Exception
	 */
	public void chkRendoSendDt(RendoSendInServiceBean inBean) throws Exception;
	/**
	 * 連動元出稿管理を更新
	 * @param inBean
	 * @throws Exception
	 */
	public void updateRendoSend(RendoSendInServiceBean inBean) throws Exception;
}
