package net.chintai.backend.sysadmin.crnwl.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import jp.co.interoffice.util.Utils;
import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.crnwl.CacheConst;
import net.chintai.batch.common.DelKbn;
import net.chintai.batch.common.GenericFlg;
import net.chintai.batch.common.domain.MstArea;
import net.chintai.batch.common.domain.MstAreaExample;
import net.chintai.batch.common.domain.MstCity;
import net.chintai.batch.common.domain.MstCityExample;
import net.chintai.batch.common.domain.MstCommentKbn;
import net.chintai.batch.common.domain.MstCommentKbnExample;
import net.chintai.batch.common.domain.MstContentType;
import net.chintai.batch.common.domain.MstContentTypeExample;
import net.chintai.batch.common.domain.MstCtShisya;
import net.chintai.batch.common.domain.MstCtShisyaExample;
import net.chintai.batch.common.domain.MstEki;
import net.chintai.batch.common.domain.MstEnsen;
import net.chintai.batch.common.domain.MstFormatType;
import net.chintai.batch.common.domain.MstFormatTypeExample;
import net.chintai.batch.common.domain.MstImgCategory;
import net.chintai.batch.common.domain.MstImgCategoryExample;
import net.chintai.batch.common.domain.MstImgKbn;
import net.chintai.batch.common.domain.MstImgKbnExample;
import net.chintai.batch.common.domain.MstPref;
import net.chintai.batch.common.domain.MstRendo;
import net.chintai.batch.common.domain.MstRendoExample;
import net.chintai.batch.common.domain.MstShopCharacter;
import net.chintai.batch.common.domain.MstShopCharacterExample;
import net.chintai.batch.common.domain.MstShopCharacterExclGroup;
import net.chintai.batch.common.domain.MstShopKeiyakuKanri;
import net.chintai.batch.common.domain.MstShopKeiyakuKanriExample;
import net.chintai.batch.common.domain.MstZipcode;
import net.chintai.batch.common.domain.MstZipcodeExample;
import net.chintai.batch.common.persistence.mapper.MstAreaMapper;
import net.chintai.batch.common.persistence.mapper.MstCityMapper;
import net.chintai.batch.common.persistence.mapper.MstCommentKbnMapper;
import net.chintai.batch.common.persistence.mapper.MstContentTypeMapper;
import net.chintai.batch.common.persistence.mapper.MstCtShisyaMapper;
import net.chintai.batch.common.persistence.mapper.MstEkiMapper;
import net.chintai.batch.common.persistence.mapper.MstEnsenMapper;
import net.chintai.batch.common.persistence.mapper.MstFormatTypeMapper;
import net.chintai.batch.common.persistence.mapper.MstImgCategoryMapper;
import net.chintai.batch.common.persistence.mapper.MstImgKbnMapper;
import net.chintai.batch.common.persistence.mapper.MstPrefMapper;
import net.chintai.batch.common.persistence.mapper.MstRendoMapper;
import net.chintai.batch.common.persistence.mapper.MstShopCharacterExclGroupMapper;
import net.chintai.batch.common.persistence.mapper.MstShopCharacterMapper;
import net.chintai.batch.common.persistence.mapper.MstShopKeiyakuKanriMapper;
import net.chintai.batch.common.persistence.mapper.MstZipcodeMapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.jdbc.SqlRunner;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * <pre>
 * MasterService
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2015-02-02 19:58:26 +0900 (月, 02 2 2015) $ by $Author: kentaro.araya $
 * @version $Revision: 6747 $
 * @since 1.0
 */
@Service
@Transactional(readOnly = true)
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MasterService {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private MstRendoMapper mstRendoMapper;

	@Autowired
	private MstShopKeiyakuKanriMapper mstShopKeiyakuKanriMapper;

	@Autowired
	private MstEnsenMapper mstEnsenMapper;

	@Autowired
	private MstEkiMapper mstEkiMapper;

	@Autowired
	private MstCtShisyaMapper uskMstCtShisyaMapper;

	@Autowired
	private MstCommentKbnMapper mstCommentKbnMapper;

	@Autowired
	private MstPrefMapper mstPrefMapper;

	@Autowired
	private MstCityMapper mstCityMapper;

	@Autowired
	private MstShopCharacterMapper mstShopCharacterMapper;

	@Autowired
	private MstAreaMapper mstAreaMapper;

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private MstZipcodeMapper mstZipcodeMapper;

	@Autowired
	private MstImgKbnMapper mstImgKbnMapper;

	@Autowired
	private MstShopCharacterExclGroupMapper mstShopCharacterExclGroupMapper;

	@Autowired
	private MstContentTypeMapper mstContentTypeMapper;

	@Autowired
	private MstImgCategoryMapper mstImgCategoryMapper;

	@Autowired
	private MstFormatTypeMapper mstFormatTypeMapper;

	/**
	 * @param value
	 * @param example
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.MstCityMapper#selectByExample(net.chintai.batch.common.domain.MstCityExample)
	 */
	public List<MstCity> getValidMstCityByPrefcd(final String value) {
		final MstCityExample example = new MstCityExample();
		example.createCriteria().andPrefcdEqualTo(value).andDelKbnEqualTo(DelKbn.VALID.getValue())
				.andFuyouFlgEqualTo(GenericFlg.OFF.getValue());
		example.setOrderByClause(MstCityExample.CITYCD);
		return this.mstCityMapper.selectByExample(example);
	}

	/**
	 * @param contentType
	 * @return
	 */
	public MstContentType getMstContentTypeByPrimaryKey(final String contentType) {
		final List<MstContentType> list;
		{
			final MstContentTypeExample example = new MstContentTypeExample();
			example.createCriteria().andContentTypeEqualTo(contentType).andReceiveFlgEqualTo(GenericFlg.ON.getValue())
					.andDelKbnEqualTo(DelKbn.VALID.getValue());
			list = this.mstContentTypeMapper.selectByExample(example);
		}
		if (list.size() > 0) {
			return list.get(0);
		}
		else {
			return null;
		}
	}

	/**
	 * @param example
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.MstContentTypeMapper#selectByExample(net.chintai.batch.common.domain.MstContentTypeExample)
	 */
	public List<MstContentType> getReceiveMstContentType() {
		final MstContentTypeExample example = new MstContentTypeExample();
		example.createCriteria().andDelKbnEqualTo(ConstValues.FLG_OFF).andReceiveFlgEqualTo(GenericFlg.ON.getValue());
		return this.mstContentTypeMapper.selectByExample(example);
	}

	/**
	 * @param charExclusiveGroupKbn
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.MstShopCharacterExclGroupMapper#selectByPrimaryKey(java.lang.String)
	 */
	public MstShopCharacterExclGroup selectMstShopCharacterExclGroupByPrimaryKey(final String charExclusiveGroupKbn) {
		return this.mstShopCharacterExclGroupMapper.selectByPrimaryKey(charExclusiveGroupKbn);
	}

	/**
	 * @param commentKbn
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.MstCommentKbnMapper#selectByPrimaryKey(java.lang.String)
	 */
	@Cacheable(CacheConst.MASTER_CACHE)
	public MstCommentKbn selectMstCommentKbnByPrimaryKey(final String commentKbn) {
		return this.mstCommentKbnMapper.selectByPrimaryKey(commentKbn);
	}

	/**
	 * @param example
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.MstImgKbnMapper#selectByExample(net.chintai.batch.common.domain.MstImgKbnExample)
	 */
	public List<MstImgKbn> selectMstImgKbnByShopBukkenKbnAndImgCategory(final String shopBukkenKbn,
			final String... imgCategories) {
		final MstImgKbnExample example = new MstImgKbnExample();
		example.createCriteria().andDelKbnEqualTo(ConstValues.FLG_OFF).andShopBukkenKbnEqualTo(shopBukkenKbn)
				.andImgCategoryIn(Arrays.asList(imgCategories));
		example.setOrderByClause(MstImgKbnExample.IMG_KBN);
		return this.mstImgKbnMapper.selectByExample(example);
	}

	/**
	 * @param example
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.MstImgKbnMapper#selectByExample(net.chintai.batch.common.domain.MstImgKbnExample)
	 */
	public List<MstImgKbn> selectMstImgKbnByShopBukkenKbnAndImgKbn(final String shopBukkenKbn,
			final String... imgKbns) {
		final MstImgKbnExample example = new MstImgKbnExample();
		example.createCriteria().andDelKbnEqualTo(ConstValues.FLG_OFF).andShopBukkenKbnEqualTo(shopBukkenKbn)
				.andImgKbnIn(Arrays.asList(imgKbns));
		example.setOrderByClause(MstImgKbnExample.IMG_KBN);
		return this.mstImgKbnMapper.selectByExample(example);
	}

	/**
	 * @param example
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.MstImgKbnMapper#selectByExample(net.chintai.batch.common.domain.MstImgKbnExample)
	 */
	// @Cacheable(CacheConst.MASTER_CACHE)
	public List<MstImgKbn> selectMstImgKbn() {
		final MstImgKbnExample example = new MstImgKbnExample();
		example.createCriteria().andDelKbnEqualTo(ConstValues.FLG_OFF);
		example.setOrderByClause(MstImgKbnExample.IMG_KBN);
		return this.mstImgKbnMapper.selectByExample(example);
	}

	/**
	 * @param example
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.MstImgKbnMapper#selectByExample(net.chintai.batch.common.domain.MstImgKbnExample)
	 */
	public List<MstImgCategory> selectMstImgCategoryByShopBukkenKbn(final String shopBukkenKbn) {
		final MstImgCategoryExample example = new MstImgCategoryExample();
		example.createCriteria().andDelKbnEqualTo(ConstValues.FLG_OFF).andShopBukkenKbnEqualTo(shopBukkenKbn);
		example.setOrderByClause(MstImgCategoryExample.IMG_CATEGORY);
		return this.mstImgCategoryMapper.selectByExample(example);
	}

	/**
	 * @param example
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.MstImgKbnMapper#selectByExample(net.chintai.batch.common.domain.MstImgKbnExample)
	 */
	public List<MstImgCategory> selectMstImgCategoryByShopBukkenKbnAndImgCategory(final String shopBukkenKbn,
			final String... imgCategories) {
		final MstImgCategoryExample example = new MstImgCategoryExample();
		example.createCriteria().andDelKbnEqualTo(ConstValues.FLG_OFF).andShopBukkenKbnEqualTo(shopBukkenKbn)
				.andImgCategoryIn(Arrays.asList(imgCategories));
		example.setOrderByClause(MstImgCategoryExample.IMG_CATEGORY);
		return this.mstImgCategoryMapper.selectByExample(example);
	}

	/**
	 * @param areacd
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.MstAreaMapper#selectByPrimaryKey(java.lang.String)
	 */
	public MstArea selectMstAreaByPrimaryKey(final String areacd) {
		return this.mstAreaMapper.selectByPrimaryKey(areacd);
	}

	/**
	 * @param example
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.MstZipcodeMapper#selectByExample(net.chintai.batch.common.domain.MstZipcodeExample)
	 */
	public Map<String, String> getAddress(final String zipcd) {
		final Map<String, String> map = new HashMap<>();
		map.put("address", "");
		map.put("prefname", "");
		map.put("cityname", "");
		final MstZipcodeExample example = new MstZipcodeExample();
		example.createCriteria().andZipcdEqualTo(zipcd).andDelKbnEqualTo(GenericFlg.OFF.getValue());
		example.setOrderByClause(MstZipcodeExample.ZIP_SEQ);
		// example.or().andOldZipcdEqualTo(zipcd);
		final List<MstZipcode> mstZipcodes = this.mstZipcodeMapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(mstZipcodes)) {
			for(final MstZipcode mstZipcode: mstZipcodes){
				final MstCityExample mstCityExample = new MstCityExample();
				mstCityExample.createCriteria()
					.andPrefcdEqualTo(mstZipcode.getPrefcd())
					.andCitycdEqualTo(mstZipcode.getCitycd())
					.andDelKbnEqualTo(GenericFlg.OFF.getValue())
					.andFuyouFlgEqualTo(GenericFlg.OFF.getValue());

				final List<MstCity> mstCityList = this.mstCityMapper.selectByExample(mstCityExample);
				if(mstCityList != null && mstCityList.size() > 0){
					final MstCity mstCity = mstCityList.get(0);
					map.put("cityname", mstCity.getCityname());
					map.put("citycd", mstCity.getCitycd());

					map.put("address", mstZipcode.getAddress());

					final MstPref mstPref = this.mstPrefMapper.selectByPrimaryKey(mstZipcode.getPrefcd());
					if (mstPref != null) {
						map.put("prefname", mstPref.getPrefname());
						map.put("prefcd", mstPref.getPrefcd());
						map.put("areacd", mstPref.getAreacd());
						map.put("areaname", this.mstAreaMapper.selectByPrimaryKey(mstPref.getAreacd()).getAreaname());
					}
					break;
				}
			}
		}
		return map;
	}

	/**
	 * @param word
	 * @return
	 */
	public List<Map<String, Object>> getPrefCity(final String word) {
		final SqlRunner runner = new SqlRunner(this.sqlSession.getConnection());
		List<Map<String, Object>> ret;
		try {
			ret = runner.selectAll(new SQL() {
				{
					SELECT("EN.PREFCD,EN.PREFNAME,EK.CITYCD,EK.CITYNAME");
					FROM("MST_PREF EN,MST_CITY EK");
					WHERE("EN.PREFCD = EK.PREFCD");
					WHERE("(EK.CITYNAME LIKE '%'||?||'%')");
					WHERE("EK.DEL_KBN = '0'");
					WHERE("EK.FUYOU_FLG = '0'");
					ORDER_BY("EN.SORT_KEY,EK.CITYCD");
				}
			}.toString(), word);
		}
		catch (final SQLException e) {
			return null;
		}

		return ret;
	}

	/**
	 * @param word
	 * @return
	 */
	public List<Map<String, Object>> getEnsenEki(final String word) {
		final SqlRunner runner = new SqlRunner(this.sqlSession.getConnection());
		List<Map<String, Object>> ret;
		try {
			ret = runner.selectAll(new SQL() {
				{
					SELECT("EN.ENSENCD,EN.ENSENNAME,EK.EKICD,EK.EKINAME");
					FROM("MST_ENSEN EN,MST_EKI EK, MST_UNION_EKI UE");
					WHERE("EN.ENSENCD = EK.ENSENCD");
					WHERE("EK.EKINO = UE.EKINO(+)");
					WHERE("(EK.EKINAME LIKE '%'||?||'%' or UE.EKIKANA LIKE '%'||?||'%')");
					WHERE("EN.DEL_KBN = '0'");
					WHERE("EK.DEL_KBN = '0'");
					WHERE("EN.ENSENTYPE != '4'");
					ORDER_BY("EN.SORT_KEY,EK.SORT_KEY");
				}
			}.toString(), word, word);
		}
		catch (final SQLException e) {
			return null;
		}

		return ret;
	}

	/**
	 * @param example
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.MstAreaMapper#selectByExample(net.chintai.batch.common.domain.MstAreaExample)
	 */
	// @Cacheable(CacheConst.MASTER_CACHE)
	public List<MstArea> selectMstArea() {
		final MstAreaExample example = new MstAreaExample();
		example.setOrderByClause(MstAreaExample.SORT_KEY);
		return this.mstAreaMapper.selectByExample(example);
	}

	/**
	 * @param example
	 * @return
	 * @see net.chintai.backend.sysadmin.crnwl.mapper.gen.MstShopCharacterMapper#selectByExample(net.chintai.backend.sysadmin.crnwl.model.gen.MstShopCharacterExample)
	 */
	public List<MstShopCharacter> selectMstShopCharacter() {
		final MstShopCharacterExample example = new MstShopCharacterExample();
		example.createCriteria().andDelKbnEqualTo(ConstValues.FLG_OFF);
		example.setOrderByClause(MstShopCharacterExample.SORT_KEY);
		return this.mstShopCharacterMapper.selectByExample(example);
	}

	/**
	 * @param prefcd
	 * @return
	 * @see net.chintai.backend.sysadmin.crnwl.mapper.gen.MstPrefMapper#selectByPrimaryKey(java.lang.String)
	 */
	public MstPref selectMstPrefByPrimaryKey(final String prefcd) {
		return this.mstPrefMapper.selectByPrimaryKey(prefcd);
	}

	/**
	 * @param prefcd
	 * @param citycd
	 * @return
	 * @see net.chintai.backend.sysadmin.crnwl.mapper.gen.MstCityMapper#selectByPrimaryKey(java.lang.String,
	 * java.lang.String)
	 */
	public MstCity selectMstCityByPrimaryKey(final String prefcd, final String citycd) {
		return this.mstCityMapper.selectByPrimaryKey(prefcd, citycd);
	}

	/**
	 * @param example
	 * @return
	 * @see net.chintai.backend.sysadmin.crnwl.mapper.gen.MstCommentKbnMapper#selectByExample(net.chintai.backend.sysadmin.crnwl.model.gen.MstCommentKbnExample)
	 */
	public List<MstCommentKbn> selectMstCommentKbnByDataKbn(final String dataKbn) {
		final MstCommentKbnExample example = new MstCommentKbnExample();
		example.createCriteria().andShopBukkenKbnEqualTo(dataKbn).andDelKbnEqualTo(ConstValues.FLG_OFF);
		example.setOrderByClause(MstCommentKbnExample.COMMENT_KBN);
		return this.mstCommentKbnMapper.selectByExample(example);
	}

	/**
	 * @param ctShisyaCd
	 * @return
	 * @see net.chintai.backend.sysadmin.crnwl.mapper.gen.MstCtShisyaMapper#selectByPrimaryKey(java.lang.String)
	 */
	public MstCtShisya selectMstCtShisyaByPrimaryKey(final String ctShisyaCd) {
		return this.uskMstCtShisyaMapper.selectByPrimaryKey(ctShisyaCd);
	}

	/**
	 * @param example
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.MstCtShisyaMapper#selectByExample(net.chintai.batch.common.domain.MstCtShisyaExample)
	 */
	public List<MstCtShisya> selectMstCtShisya() {
		final MstCtShisyaExample example = new MstCtShisyaExample();
		example.createCriteria().andDelKbnEqualTo(ConstValues.FLG_OFF);
		example.setOrderByClause(MstCtShisyaExample.CT_SHISYA_CD);
		return this.uskMstCtShisyaMapper.selectByExample(example);
	}

	/**
	 * @param ensencd
	 * @return
	 * @see net.chintai.backend.sysadmin.crnwl.mapper.gen.MstEnsenMapper#selectByPrimaryKey(java.lang.String)
	 */
	public MstEnsen selectMstEnsenByPrimaryKey(final String ensencd) {
		return this.mstEnsenMapper.selectByPrimaryKey(ensencd);
	}

	/**
	 * @param ensencd
	 * @param ekicd
	 * @return
	 * @see net.chintai.backend.sysadmin.crnwl.mapper.gen.MstEkiMapper#selectByPrimaryKey(java.lang.String,
	 * java.lang.String)
	 */
	public MstEki selectMstEkiByPrimaryKey(final String ensencd, final String ekicd) {
		return this.mstEkiMapper.selectByPrimaryKey(ensencd, ekicd);
	}

	/**
	 * @param keiyakuCd
	 * @param keiyakuSubCd
	 * @return
	 */
	public MstShopKeiyakuKanri selectMstShopKeiyakuKanriByPrimaryKey(final String keiyakuCd, final String keiyakuSubCd) {
		return this.mstShopKeiyakuKanriMapper.selectByPrimaryKey(keiyakuCd, keiyakuSubCd);
	}

	/**
	 * @param example
	 * @return
	 * @see net.chintai.backend.sysadmin.crnwl.mapper.gen.MstShopKeiyakuKanriMapper#selectByExample(net.chintai.backend.sysadmin.crnwl.model.gen.MstShopKeiyakuKanriExample)
	 */
	public List<MstShopKeiyakuKanri> selectMstShopKeiyakuKanriCmsSearch() {
		final MstShopKeiyakuKanriExample example = new MstShopKeiyakuKanriExample();
		example.createCriteria().andDelKbnEqualTo(ConstValues.FLG_OFF).andCmsSearchFlgEqualTo("1");
		example.setOrderByClause(MstShopKeiyakuKanriExample.SORT_KEY);
		return this.mstShopKeiyakuKanriMapper.selectByExample(example);
	}

	/**
	 * @param example
	 * @return
	 * @see net.chintai.backend.sysadmin.crnwl.mapper.gen.MstRendoMapper#selectByExample(net.chintai.backend.sysadmin.crnwl.model.gen.MstRendoExample)
	 */
	public List<MstRendo> selectMstRendo() {
		final MstRendoExample example = new MstRendoExample();
		example.createCriteria().andDelKbnEqualTo(DelKbn.VALID.getValue());
		example.setOrderByClause(MstRendoExample.RENDO_CD);
		return this.mstRendoMapper.selectByExample(example);
	}

	/**
	 * @return
	 */
	public List<MstRendo> selectMstRendoInsFlg() {
		final MstRendoExample example = new MstRendoExample();
		example.createCriteria().andDelKbnEqualTo(DelKbn.VALID.getValue()).andRendoInsFlgEqualTo("1");
		example.setOrderByClause(MstRendoExample.RENDO_CD);
		return this.mstRendoMapper.selectByExample(example);
	}

	/**
	 * @return
	 */
	public List<MstRendo> selectMstRendoUpdFlg() {
		final MstRendoExample example = new MstRendoExample();
		example.createCriteria().andDelKbnEqualTo(DelKbn.VALID.getValue()).andRendoUpdFlgEqualTo("1");
		example.setOrderByClause(MstRendoExample.RENDO_CD);
		return this.mstRendoMapper.selectByExample(example);
	}

	/**
	 * @param rendoCd
	 * @return
	 * @see net.chintai.backend.sysadmin.crnwl.mapper.gen.MstRendoMapper#selectByPrimaryKey(java.lang.String)
	 */
	public MstRendo selectMstRendoByPrimaryKey(final String rendoCd) {
		return this.mstRendoMapper.selectByPrimaryKey(rendoCd);
	}

	/**
	 * @param itemComplementHasshinFlg
	 * @return
	 */
	public List<MstFormatType> selectMstFormatTypeByItemComplementHasshinFlgOn() {
		final MstFormatTypeExample example = new MstFormatTypeExample();
		example.createCriteria().andDelKbnEqualTo(ConstValues.FLG_OFF).andItemComplementHasshinFlgEqualTo(ConstValues.FLG_ON);
		example.setOrderByClause(MstFormatTypeExample.FORMAT_TYPE_CD);
		return this.mstFormatTypeMapper.selectByExample(example);
	}

	/**
	 * @param list
	 * @param keyName
	 * @return
	 */
	public Map<Object, Object> toKeyObject(final List<Object> list, final String keyName) {
		try {
			return Utils.toKeyObject(list, keyName);
		}
		catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * @param list
	 * @param keyName
	 * @param valueName
	 * @return
	 */
	public Map<Object, Object> toKeyValue(final List<Object> list, final String keyName, final String valueName) {
		try {
			return Utils.toKeyValue(list, keyName, valueName);
		}
		catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@PostConstruct
	protected void init() {
		this.logger
				.info("************************************************* init ****************************************");
	}
}
