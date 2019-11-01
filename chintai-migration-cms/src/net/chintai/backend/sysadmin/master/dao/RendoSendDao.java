package net.chintai.backend.sysadmin.master.dao;

import java.util.List;

import net.chintai.backend.sysadmin.master.domain.RendoSendInfoDomain;
import net.chintai.backend.sysadmin.master.domain.RendoSendListDomain;

public interface RendoSendDao {
	/**
	 * 全連動元の出稿許可区分を取得
	 * @param paramBeanList
	 * @return
	 */
	public List<RendoSendListDomain> selectRendoSendKanriList(RendoSendParamBean paramBean);
	/**
	 * 対象の連動元･契約の出稿許可情報を取得
	 * @param paramBean
	 * @return
	 */
	public List<RendoSendInfoDomain> selectRendoSendKanri(RendoSendParamBean paramBean);
	/**
	 * 出稿許可期間が重複する件数を取得
	 * @param paramBean
	 * @return
	 */
	public int countRendoSendDtInvalid(RendoSendParamBean paramBean);
	/**
	 * 連動元出稿管理テーブル更新
	 * @param paramBean
	 * @return
	 */
	public int updateRendoSend(RendoSendParamBean paramBean);
	/**
	 * 連動元出稿管理テーブル登録
	 * @param paramBean
	 */
	public void insertRendoSend(RendoSendParamBean paramBean);
}
