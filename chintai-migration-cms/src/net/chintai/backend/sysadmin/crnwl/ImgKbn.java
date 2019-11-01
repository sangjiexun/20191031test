package net.chintai.backend.sysadmin.crnwl;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * ImgKbn
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-06-19 18:59:40 +0900 (木, 19 6 2014) $ by $Author: hasegawa $
 * @version $Revision: 2246 $
 * @since 1.0
 */
@Deprecated
public enum ImgKbn {
	/** 間取り */
	MADORI01("011", Group.MADORI),
	/** 外観1 */
	GAIKAN01("021", Group.GAIKAN),
	/** 外観2 */
	GAIKAN02("031", Group.GAIKAN),
	/** 外観3 */
	GAIKAN03("071", Group.GAIKAN),
	/** 外観4 */
	GAIKAN04("072", Group.GAIKAN),
	/** 外観5 */
	GAIKAN05("073", Group.GAIKAN),
	/** 外観6 */
	GAIKAN06("074", Group.GAIKAN),
	/** 外観7 */
	GAIKAN07("075", Group.GAIKAN),
	/** 外観8 */
	GAIKAN08("076", Group.GAIKAN),
	/** 外観9 */
	GAIKAN09("077", Group.GAIKAN),
	/** 外観10 */
	GAIKAN10("078", Group.GAIKAN),
	/** 内観1 */
	NAIKAN01("041", Group.NAIKAN),
	/** 内観2 */
	NAIKAN02("051", Group.NAIKAN),
	/** 内観3 */
	NAIKAN03("061", Group.NAIKAN),
	/** 内観4 */
	NAIKAN04("081", Group.NAIKAN),
	/** 内観5 */
	NAIKAN05("091", Group.NAIKAN),
	/** 内観6 */
	NAIKAN06("101", Group.NAIKAN),
	/** 内観7 */
	NAIKAN07("111", Group.NAIKAN),
	/** 内観8 */
	NAIKAN08("121", Group.NAIKAN),
	/** 内観9 */
	NAIKAN09("131", Group.NAIKAN),
	/** 内観10 */
	NAIKAN10("141", Group.NAIKAN),
	/** 内観11 */
	NAIKAN11("142", Group.NAIKAN),
	/** 内観12 */
	NAIKAN12("143", Group.NAIKAN),
	/** 内観13 */
	NAIKAN13("144", Group.NAIKAN),
	/** 内観14 */
	NAIKAN14("145", Group.NAIKAN),
	/** 内観15 */
	NAIKAN15("146", Group.NAIKAN),
	/** 内観16 */
	NAIKAN16("147", Group.NAIKAN),
	/** 内観17 */
	NAIKAN17("148", Group.NAIKAN),
	/** 内観18 */
	NAIKAN18("149", Group.NAIKAN),
	/** 内観19 */
	NAIKAN19("150", Group.NAIKAN),
	/** 周辺環境1 */
	SYUHEN01("170", Group.SYUHEN),
	/** 周辺環境2 */
	SYUHEN02("171", Group.SYUHEN),
	/** 周辺環境3 */
	SYUHEN03("172", Group.SYUHEN),
	/** 周辺環境4 */
	SYUHEN04("173", Group.SYUHEN),
	/** 周辺環境5 */
	SYUHEN05("174", Group.SYUHEN),
	/** 周辺環境6 */
	SYUHEN06("175", Group.SYUHEN),
	/** 周辺環境7 */
	SYUHEN07("176", Group.SYUHEN),
	/** 周辺環境8 */
	SYUHEN08("177", Group.SYUHEN),
	/** 周辺環境9 */
	SYUHEN09("178", Group.SYUHEN),
	/** 周辺環境10 */
	SYUHEN10("179", Group.SYUHEN),
	/** 店舗画像１（店外写真） */
	TENPO_01("811", Group.TENPO),
	/** 店舗画像２（スタッフ写真） */
	TENPO_02("812", Group.TENPO),
	/** 店舗画像３（店内写真） */
	TENPO_03("813", Group.TENPO),
	/** 店舗画像４（スタッフ接客写真） */
	TENPO_04("814", Group.TENPO),
	/** 店舗地図画像 */
	TENPO_MAP("821", Group.TENPO),
	/** 不動産ASPロゴ画像 */
	ASP_LOGO("841", Group.ASP),
	/** 店舗外観1 */
	TENPO_GAIKAN01("600", Group.TENPO),
	/** 店舗外観2 */
	TENPO_GAIKAN02("601", Group.TENPO),
	/** 店舗外観3 */
	TENPO_GAIKAN03("602", Group.TENPO),
	/** 店舗外観4 */
	TENPO_GAIKAN04("603", Group.TENPO),
	/** 店舗外観5 */
	TENPO_GAIKAN05("604", Group.TENPO),
	/** 店舗内観1 */
	TENPO_NAIKAN01("620", Group.TENPO),
	/** 店舗内観2 */
	TENPO_NAIKAN02("621", Group.TENPO),
	/** 店舗内観3 */
	TENPO_NAIKAN03("622", Group.TENPO),
	/** 店舗内観4 */
	TENPO_NAIKAN04("623", Group.TENPO),
	/** 店舗内観5 */
	TENPO_NAIKAN05("624", Group.TENPO),
	/** スタッフ紹介写真1 */
	TENPO_STAFF_SYOKAI01("640", Group.TENPO),
	/** スタッフ紹介写真2 */
	TENPO_STAFF_SYOKAI02("641", Group.TENPO),
	/** スタッフ紹介写真3 */
	TENPO_STAFF_SYOKAI03("642", Group.TENPO),
	/** スタッフ紹介写真4 */
	TENPO_STAFF_SYOKAI04("643", Group.TENPO),
	/** スタッフ紹介写真5 */
	TENPO_STAFF_SYOKAI05("644", Group.TENPO),
	/** スタッフ紹介写真6 */
	TENPO_STAFF_SYOKAI06("645", Group.TENPO),
	/** スタッフ紹介写真7 */
	TENPO_STAFF_SYOKAI07("646", Group.TENPO),
	/** スタッフ紹介写真8 */
	TENPO_STAFF_SYOKAI08("647", Group.TENPO),
	/** スタッフ紹介写真9 */
	TENPO_STAFF_SYOKAI09("648", Group.TENPO),
	/** スタッフ紹介写真10 */
	TENPO_STAFF_SYOKAI10("649", Group.TENPO),
	/** スタッフ写真1 */
	TENPO_STAFF01("660", Group.TENPO),
	/** スタッフ写真2 */
	TENPO_STAFF02("661", Group.TENPO),
	/** インフォメーション動画1 */
	TENPO_INFO_MV01("680", Group.TENPO),

	;

	private String value;

	private Group group;

	/**
	 * @param value
	 */
	private ImgKbn(final String value, final Group group) {
		this.value = value;
		this.group = group;
	}

	/**
	 * @return
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * @return group
	 */
	public Group getGroup() {
		return this.group;
	}

	/**
	 * @return
	 */
	public static String[] getValuesByGroup(final Group group) {
		final List<String> list = new ArrayList<>();
		for (final ImgKbn kbn : values()) {
			if (kbn.getGroup() == group) {
				list.add(kbn.getValue());
			}
		}
		return list.toArray(new String[0]);
	}

	public enum Group {
		MADORI, GAIKAN, NAIKAN, SYUHEN, TENPO, ASP
	};
}
