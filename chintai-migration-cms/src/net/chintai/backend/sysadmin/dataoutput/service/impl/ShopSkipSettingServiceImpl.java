package net.chintai.backend.sysadmin.dataoutput.service.impl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.dataoutput.dao.ShopSkipSettingDao;
import net.chintai.backend.sysadmin.dataoutput.dao.ShopSkipSettingParamBean;
import net.chintai.backend.sysadmin.dataoutput.domain.ShopSkipSettingDomain;
import net.chintai.backend.sysadmin.dataoutput.service.ShopSkipSettingService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShopSkipSettingDownloadInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShopSkipSettingDownloadOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShopSkipSettingUploadInServiceBean;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 店舗別除外設定サービス実装クラス
 * @author watanabe
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSkipSettingServiceImpl implements ShopSkipSettingService{

	private static final int INCREMENTCOUNT = 1;

	@Autowired
	private ShopService shopService;

	private ShopSkipSettingDao shopSkipSettingDao;

	public void setShopSkipSettingDao(ShopSkipSettingDao shopSkipSettingDao){
		this.shopSkipSettingDao = shopSkipSettingDao;
	}

	@Autowired
	private PlatformTransactionManager txManager;

	private static final int RETRY_MAX = 10;

	/**
	 * CSVファイルの内容の列挙クラス
	 * @author watanabe
	 */
	private enum ShopSkipSettingEnum {
		SHOPCD("店舗コード", "shopCd"),
		COMPANY("会社名", "company"),
		BUMON("店舗名称", "bumon"),
		LIC_NUM("免許証番号", "licNum"),
		PREFNAME("都道府県名", "prefName");

		private String name;
		private String physName;

		ShopSkipSettingEnum(String name, String physName){
			this.name = name;
			this.physName = physName;
		}


		/**
		 * 日本語名を取得します。
		 * @return name
		 */
		public String getName(){
			return name;
		}

		/**
		 * 日本語名の配列を取得します。
		 * @return names
		 */
		public static String[] names(){
			int i = 0;
			String[] names = new String[ShopSkipSettingEnum.values().length];
			for (ShopSkipSettingEnum e : ShopSkipSettingEnum.values()){
				names[i] = e.getName();
				i++;
			}
			return names;
		}

		/**
		 * domainに存在するCSV出力に必要な要素の値を配列にして返します。
		 * @param domain
		 * @return domains
		 * @throws ApplicationException
		 */
		public static String[] domains(ShopSkipSettingDomain domain) throws ApplicationException{
			PropertyDescriptor nameProp;
			int i = 0;
			String[] domains = new String[ShopSkipSettingEnum.values().length];

			try {
				for (ShopSkipSettingEnum e : ShopSkipSettingEnum.values()){
					// 取得するfield
					nameProp = new PropertyDescriptor(e.physName, domain.getClass());
					// domainのgetterから値を取得する。
					domains[i] = (String) nameProp.getReadMethod().invoke(domain, (Object[]) null);
					i++;
				}
			} catch (Exception e) {
				throw new ApplicationException("FETAL.M.SYSTEM.0001");
			}
			return domains;
		}
	}


    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.service.ShopSkipSettingService#selectShopSkipSetting(net.chintai.backend.sysadmin.dataoutput.service.bean.ShopSkipSettingDownloadInServiceBean)
     */
    @Override
    public  ShopSkipSettingDownloadOutServiceBean selectShopSkipSetting(ShopSkipSettingDownloadInServiceBean inServiceBean) throws ApplicationException{
		ShopSkipSettingParamBean paramBean = new ShopSkipSettingParamBean();
		BeanUtilsWrapper.copyProperties(paramBean, inServiceBean);
        List<ShopSkipSettingDomain> shopSkipList = shopSkipSettingDao.getShopSkipSetting(paramBean);

        // 店舗別出力設定検索結果リスト分繰り返し、返却用のリストを作成する
        List<String[]> resultList = new ArrayList<String[]>();
        if (shopSkipList.size() > 0){
        	resultList.add(ShopSkipSettingEnum.names());
	        for (ShopSkipSettingDomain domain : shopSkipList){
	            resultList.add(ShopSkipSettingEnum.domains(domain));
	        }
        }

        ShopSkipSettingDownloadOutServiceBean outServiceBean = new ShopSkipSettingDownloadOutServiceBean();
        outServiceBean.setDownloadList(resultList);
        return outServiceBean;
    }

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.dataoutput.service.ShopSkipSettingService#commitShopSkipSetting(net.chintai.backend.sysadmin.dataoutput.service.bean.ShopSkipSettingUploadInServiceBean)
	 */
	@Override
	public void commitShopSkipSetting(
			ShopSkipSettingUploadInServiceBean inServiceBean) throws ApplicationException {

		List<String[]> csvList = inServiceBean.getUploadList();

		// DB削除用パラメータ
		ShopSkipSettingParamBean deleteParam = new ShopSkipSettingParamBean();
		BeanUtilsWrapper.copyProperties(deleteParam, inServiceBean);

		// DB挿入用パラメータ
		Map<String, ShopSkipSettingParamBean> insertParamMap = new LinkedHashMap<String, ShopSkipSettingParamBean>();
		// CSVファイル行数分繰返す(カラム名の行1行目は除く)
		for (int i = 0; i < csvList.size(); i++) {
			String[] line = csvList.get(i);
			String shopCd = line[ShopSkipSettingEnum.SHOPCD.ordinal()];
			String lineNumber = String.valueOf(i + INCREMENTCOUNT);

			// 行全体のカラム数チェック
			if (line.length != ShopSkipSettingEnum.values().length) {
				String[] msg = { lineNumber };
				throw new ApplicationException("WARN.M.DATAOUTPUT.0008", msg);
			}

			// 店舗コードの文字数チェック
			if (!shopCd.matches("[a-zA-Z0-9]{9}")) {
				String[] msg = { lineNumber, ShopSkipSettingEnum.SHOPCD.getName(), shopCd};
				throw new ApplicationException("WARN.M.DATAOUTPUT.0009", msg);
			// 店舗コードの重複チェック
			} else if (insertParamMap.containsKey(shopCd)) {
				String[] msg = { lineNumber, ShopSkipSettingEnum.SHOPCD.getName(), shopCd};
				throw new ApplicationException("WARN.M.DATAOUTPUT.0010", msg);
			// 店舗コードの存在チェック
			} else if (shopService.selectShopKanriByPrimaryKey(shopCd) == null){
				String[] msg = { lineNumber, ShopSkipSettingEnum.SHOPCD.getName(), shopCd};
				throw new ApplicationException("WARN.M.DATAOUTPUT.0011", msg);
			}

			// パラメータ挿入
			ShopSkipSettingParamBean insertParam = new ShopSkipSettingParamBean();
			insertParam.setShopCd(shopCd);
			BeanUtilsWrapper.copyProperties(insertParam, inServiceBean);
			insertParamMap.put(shopCd, insertParam);
		}

		// DB更新
		updateShopSkipSetting(deleteParam, insertParamMap.values());
	}

	/**
	 * DBの更新を行います。
	 * @param deleteParam 削除時の検索条件
	 * @param insertParamCol 挿入時のパラメータ
	 * @throws ApplicationException
	 */
	private void updateShopSkipSetting(ShopSkipSettingParamBean deleteParam, Collection<ShopSkipSettingParamBean> insertParamCol) throws ApplicationException {
		// transacion管理
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setTimeout(Integer.parseInt(ApplicationResources.getProperty("dataoutput.dbTimeout")));
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		def.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);

		// バックアップテーブルのデータ削除基準日
		Date deletePeriod = DateUtils.addDays(new Date(), -Integer.parseInt(ApplicationResources.getProperty("dataoutput.deleteBkTableDays")));

		// DB処理
		for (int retryCnt = 1; retryCnt <= RETRY_MAX; retryCnt++) {
			TransactionStatus status = txManager.getTransaction(def);
			try {
				shopSkipSettingDao.deleteBkShopSkipConfig(deletePeriod);
				shopSkipSettingDao.insertBkShopSkipConfig(deleteParam);
				shopSkipSettingDao.deleteShopSkipConfig(deleteParam);
				for (ShopSkipSettingParamBean insertParam : insertParamCol) {
					shopSkipSettingDao.insertShopSkipConfig(insertParam);
				}
				txManager.commit(status);
				break;
			} catch (RuntimeException e) {
				txManager.rollback(status);
				if (retryCnt >= RETRY_MAX) {
					throw new ApplicationException("ERROR.M.DATAOUTPUT.0003", e);
				}
			} catch (Exception e) {
				txManager.rollback(status);
				throw new ApplicationException("FETAL.M.SYSTEM.0001", e);
			}
		}
	}
}