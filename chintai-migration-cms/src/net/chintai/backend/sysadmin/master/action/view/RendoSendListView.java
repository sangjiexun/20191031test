package net.chintai.backend.sysadmin.master.action.view;

import java.util.Map;
import java.util.TreeMap;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 連動元出稿情報
 * @author z2j0726
 */
public class RendoSendListView  implements ViewHelper {
	/** 連動元出稿許可マップ */
	private Map<String, RendoSendList> rendoSendDetailMap;

	/** 契約名称マップ */
	private Map<String, String> keiyakuNameMap;

	/**
	 * 連動元出稿許可マップを取得します。
	 * @return 連動元出稿許可マップ
	 */
	public Map<String, RendoSendList> getRendoSendDetailMap() {
		return this.rendoSendDetailMap;
	}

	/**
	 * 連動元出稿許可マップを設定します。
	 * @param rendoSendDetailList 連動元出稿許可マップ
	 */
	public void setRendokeiyakuDetailMap(Map<String, RendoSendList> rendoSendDetailList) {
		this.rendoSendDetailMap = rendoSendDetailList;
	}

	public void setRendoSendDetailMap(String rendoCd, RendoSendList rendoSendList) {
		if (this.rendoSendDetailMap == null) {
			this.rendoSendDetailMap = new TreeMap<String, RendoSendList>();
		}
		this.rendoSendDetailMap.put(rendoCd, rendoSendList);
	}

	/**
	 * 契約名称マップを取得します。
	 * @return 契約名称マップ
	 */
	public Map<String, String> getKeiyakuNameMap() {
		return this.keiyakuNameMap;
	}

	/**
	 * 契約名称マップを設定します。
	 * @param keiyakuNameMap 契約名称マップ
	 */
	public void setKeiyakuNameMap(Map<String, String> keiyakuNameMap) {
		this.keiyakuNameMap = keiyakuNameMap;
	}

	/**
	 * 契約名称マップを設定します。
	 * @param keiyakuNameMap 契約名称マップ
	 */
	public void setKeiyakuNameMap(String keiyakuCd, String keiyakuSubCd, String keiyakuName) {
		if (this.keiyakuNameMap == null) {
			this.keiyakuNameMap = new TreeMap<String,String>();
		}
		this.keiyakuNameMap.put(keiyakuCd + keiyakuSubCd, keiyakuName);
	}

	public class RendoSendList {

		/** 連動元名称 */
		private String rendoName;

		/** 連動会社名 */
		private String rendoCompany;

		/** 契約状況マップ */
		private Map<String,String[]> permitInfoMap;

		/**
		 * 連動元名称を取得します。
		 * @return 連動元名称
		 */
		public String getRendoName() {
			return rendoName;
		}

		/**
		 * 連動元名称を設定します。
		 * @param rendoName 連動元名称
		 */
		public void setRendoName(String rendoName) {
			this.rendoName = rendoName;
		}

		/**
		 * 連動会社名を取得します。
		 * @return 連動会社名
		 */
		public String getRendoCompany() {
			return rendoCompany;
		}

		/**
		 * 連動会社名を設定します。
		 * @param rendoCompany 連動会社名
		 */
		public void setRendoCompany(String rendoCompany) {
			this.rendoCompany = rendoCompany;
		}

		/**
		 * 契約状況マップを取得します。
		 * @return 契約状況マップ
		 */
		public Map<String,String[]> getPermitInfoMap() {
			return permitInfoMap;
		}

		/**
		 * 契約状況マップを設定します。
		 * @param permitInfoMap 契約状況マップ
		 */
		public void setPermitInfoMap(Map<String,String[]> permitInfoMap) {
			this.permitInfoMap = permitInfoMap;
		}

		/**
		 * 契約状況マップを設定します。
		 * @param keiyakuCd, keiyakuSubCd, permitInfo
		 */
		public void setPermitInfoMap(String keiyakuCd, String keiyakuSubCd, String[] permitInfo) {
			if (this.permitInfoMap == null) {
				this.permitInfoMap = new TreeMap<String,String[]>();
			}
			this.permitInfoMap.put(keiyakuCd + keiyakuSubCd, permitInfo);
		}
	}
}
