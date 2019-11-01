package net.chintai.backend.sysadmin.crnwl.service;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import net.chintai.backend.sysadmin.common.properties.ServerProperties;
import net.chintai.backend.sysadmin.crnwl.MstCommentKbn;
import net.chintai.backend.sysadmin.crnwl.aop.IdHolder;
import net.chintai.backend.sysadmin.crnwl.dto.BukkenCount;
import net.chintai.backend.sysadmin.crnwl.dto.Shop;
import net.chintai.backend.sysadmin.crnwl.dto.ShopAppendInfo;
import net.chintai.backend.sysadmin.crnwl.dto.ShopBasicInfo;
import net.chintai.backend.sysadmin.crnwl.dto.ShopImage;
import net.chintai.backend.sysadmin.crnwl.dto.ShopImageCampaign;
import net.chintai.backend.sysadmin.crnwl.dto.ShopImageStaff;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.shop_bukken.ShopBukkenUtils;
import net.chintai.batch.common.Cmdcd;
import net.chintai.batch.common.GenericFlg;
import net.chintai.batch.common.ImgCategory;
import net.chintai.batch.common.ImgUpdateKbn;
import net.chintai.batch.common.InsKbn;
import net.chintai.batch.common.PpcUseKbn;
import net.chintai.batch.common.ReceiveFormatKbn;
import net.chintai.batch.common.ShopBukkenKbn;
import net.chintai.batch.common.aop.PgHolder;
import net.chintai.batch.common.domain.CtNayoseSkipShop;
import net.chintai.batch.common.domain.MngGroupAuthority;
import net.chintai.batch.common.domain.MngGroupAuthorityExample;
import net.chintai.batch.common.domain.MngUsers;
import net.chintai.batch.common.domain.MstImgKbn;
import net.chintai.batch.common.domain.MstImgKbnExample;
import net.chintai.batch.common.domain.PpcInfo;
import net.chintai.batch.common.domain.PpcInfoExample;
import net.chintai.batch.common.domain.ShopKanri;
import net.chintai.batch.common.domain.ShopKanriExample;
import net.chintai.batch.common.domain.ShopKeiyakuKanri;
import net.chintai.batch.common.domain.ShopKeiyakuKanriExample;
import net.chintai.batch.common.domain.ShopReceiveExample;
import net.chintai.batch.common.domain.ShopReserve;
import net.chintai.batch.common.domain.ShopReserveExample;
import net.chintai.batch.common.domain.ShopRireki;
import net.chintai.batch.common.domain.ShopRirekiCampaign;
import net.chintai.batch.common.domain.ShopRirekiCampaignExample;
import net.chintai.batch.common.domain.ShopRirekiCharacter;
import net.chintai.batch.common.domain.ShopRirekiCharacterExample;
import net.chintai.batch.common.domain.ShopRirekiComment;
import net.chintai.batch.common.domain.ShopRirekiCommentExample;
import net.chintai.batch.common.domain.ShopRirekiCreReqExample;
import net.chintai.batch.common.domain.ShopRirekiEki;
import net.chintai.batch.common.domain.ShopRirekiEkiExample;
import net.chintai.batch.common.domain.ShopRirekiExample;
import net.chintai.batch.common.domain.ShopRirekiImg;
import net.chintai.batch.common.domain.ShopRirekiImgExample;
import net.chintai.batch.common.domain.ShopRirekiProudArea;
import net.chintai.batch.common.domain.ShopRirekiProudAreaExample;
import net.chintai.batch.common.domain.ShopRirekiProudEki;
import net.chintai.batch.common.domain.ShopRirekiProudEkiExample;
import net.chintai.batch.common.domain.ShopRirekiStaff;
import net.chintai.batch.common.domain.ShopRirekiStaffExample;
import net.chintai.batch.common.domain.VAspGroupShop;
import net.chintai.batch.common.domain.VAspGroupShopExample;
import net.chintai.batch.common.domain.VShopKeiyakuDetail;
import net.chintai.batch.common.domain.VShopKeiyakuDetailExample;
import net.chintai.batch.common.persistence.mapper.CtNayoseSkipShopMapper;
import net.chintai.batch.common.persistence.mapper.MngGroupAuthorityMapper;
import net.chintai.batch.common.persistence.mapper.MngUsersMapper;
import net.chintai.batch.common.persistence.mapper.MstImgKbnMapper;
import net.chintai.batch.common.persistence.mapper.PpcInfoMapper;
import net.chintai.batch.common.persistence.mapper.ShopKanriMapper;
import net.chintai.batch.common.persistence.mapper.ShopKeiyakuKanriMapper;
import net.chintai.batch.common.persistence.mapper.ShopReceiveMapper;
import net.chintai.batch.common.persistence.mapper.ShopReserveMapper;
import net.chintai.batch.common.persistence.mapper.ShopRirekiCampaignMapper;
import net.chintai.batch.common.persistence.mapper.ShopRirekiCharacterMapper;
import net.chintai.batch.common.persistence.mapper.ShopRirekiCommentMapper;
import net.chintai.batch.common.persistence.mapper.ShopRirekiCreReqMapper;
import net.chintai.batch.common.persistence.mapper.ShopRirekiEkiMapper;
import net.chintai.batch.common.persistence.mapper.ShopRirekiImgMapper;
import net.chintai.batch.common.persistence.mapper.ShopRirekiMapper;
import net.chintai.batch.common.persistence.mapper.ShopRirekiProudAreaMapper;
import net.chintai.batch.common.persistence.mapper.ShopRirekiProudEkiMapper;
import net.chintai.batch.common.persistence.mapper.ShopRirekiStaffMapper;
import net.chintai.batch.common.persistence.mapper.VAspGroupShopMapper;
import net.chintai.batch.common.persistence.mapper.VShopKeiyakuDetailMapper;
import net.chintai.batch.dist.BatchException;
import net.chintai.batch.dist.master.dto.ShopHaishinDto;
import net.chintai.batch.dist.master.service.CmsDistributionProcessService;
import net.chintai.batch.gazohaisin.support.S3Utils;
import net.chintai.batch.support.ppc.PpcSupportService;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.jdbc.SqlRunner;
import org.apache.ibatis.session.SqlSession;
import org.joda.time.DateTime;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.services.s3.AmazonS3;

/**
 * <pre>
 * ShopService
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2019-05-10 14:10:45 +0900 (金, 10 5 2019) $ by $Author: yasushi.kamitani $
 * @version $Revision: 7889 $
 * @since 1.0
 */
@Service
@Transactional(readOnly = true)
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShopService {
	protected final Log logger = LogFactory.getLog(getClass());

	// private static final MimeTypes ALL_TYPES = MimeTypes.getDefaultMimeTypes();
	//
	// @Autowired
	// private Tika tika;
	@Autowired
	private ApplicationContext context;

	@Autowired
	private ShopRirekiEkiMapper shopRirekiEkiMapper;

	@Autowired
	private ShopRirekiMapper shopRirekiMapper;

	@Autowired
	private ShopKanriMapper shopKanriMapper;

	@Autowired
	private VAspGroupShopMapper vAspGroupShopMapper;

	@Autowired
	private VShopKeiyakuDetailMapper vShopKeiyakuDetailMapper;

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private ShopRirekiImgMapper shopRirekiImgMapper;

	@Autowired
	private ShopRirekiCommentMapper shopRirekiCommentMapper;

	@Autowired
	private ShopRirekiProudAreaMapper shopRirekiProudAreaMapper;

	@Autowired
	private ShopRirekiProudEkiMapper shopRirekiProudEkiMapper;

	@Autowired
	private ShopRirekiCharacterMapper shopRirekiCharacterMapper;

	@Autowired
	private ShopRirekiStaffMapper shopRirekiStaffMapper;

	@Autowired
	private ShopRirekiCampaignMapper shopRirekiCampaignMapper;

	@Autowired
	private ShopReceiveMapper shopReceiveMapper;

	@Autowired
	private ShopRirekiCreReqMapper shopRirekiCreReqMapper;

	@Autowired
	private ShopKeiyakuKanriMapper shopKeiyakuKanriMapper;

	@Autowired
	private PpcInfoMapper ppcInfoMapper;

	@Autowired
    private ShopReserveMapper shopReserveMapper;

	private final String s3Bucket = ServerProperties.getProperty("s3Bucket");

	private final String proxyHost = ServerProperties.getProperty("proxyHost");

	private final int proxyPort = Integer.valueOf(ServerProperties.getProperty("proxyPort"));

	private final String proxyUsername = ServerProperties.getProperty("proxyUsername");

	private final String proxyPassword = ServerProperties.getProperty("proxyPassword");

	@Autowired
	private CmsDistributionProcessService cmsDistributionProcessService;

	@Qualifier("crsplusShopService")
	@Autowired
	private net.chintai.receive.crsplus.service.ShopService crsplusShopService;

	@Autowired
	private MasterService masterService;

	@Autowired
	private CtNayoseSkipShopMapper ctNayoseSkipShopMapper;

	@Autowired
	private MngGroupAuthorityMapper mngGroupAuthorityMapper;

	@Autowired
	private MngUsersMapper mngUsersMapper;

	@Autowired
	private MstImgKbnMapper mstImgKbnMapper;

	@Autowired
	private PpcSupportService ppcSupportService;

	/**
	 * @param example
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.MngGroupAuthorityMapper#selectByExample(net.chintai.batch.common.domain.MngGroupAuthorityExample)
	 */
	public MngGroupAuthority selectMngGroupAuthorityByUserIdAndAuthorityId(final String userId, final String authorityId) {
		final MngUsers user = this.mngUsersMapper.selectByPrimaryKey(userId);
		if (user == null) {
			return null;
		}
		final MngGroupAuthorityExample example = new MngGroupAuthorityExample();
		example.createCriteria().andAuthorityIdEqualTo(authorityId).andGroupIdEqualTo(user.getGroupId());
		final List<MngGroupAuthority> list = this.mngGroupAuthorityMapper.selectByExample(example);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	/**
	 * @param images
	 */
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public void uploadShopImage(final List<Path> images) {

        // S3の署名バージョンにV4を指定
        System.setProperty(SDKGlobalConfiguration.ENABLE_S3_SIGV4_SYSTEM_PROPERTY, "true");

        final ExecutorService pool = Executors.newFixedThreadPool(images.size());
		final List<Future<Boolean>> futures = new ArrayList<>();
		try {
			final AmazonS3 s3 = S3Utils.getAmazonS3(images.size(), proxyHost, proxyPort, proxyUsername, proxyPassword);
			for (final Path image : images) {
				final Callable<Boolean> uploader = (Callable<Boolean>) this.context.getBean("shopImageUploader", s3,
						this.s3Bucket, image, PgHolder.getPg(), IdHolder.getId());
				futures.add(pool.submit(uploader));
			}
		}
		catch (final Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			try {
				for (final Future<Boolean> future : futures) {
					try {
						future.get();
					}
					catch (InterruptedException | ExecutionException e) {
						throw new RuntimeException(e.getMessage(), e);
						// this.logger.warn(e.getMessage(), e);
					}
				}
			}
			finally {
				pool.shutdown();
			}
		}
	}

	/**
	 * @param shopcd
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.CtNayoseSkipShopMapper#selectByPrimaryKey(java.lang.String)
	 */
	public CtNayoseSkipShop selectCtNayoseSkipShopByPrimaryKey(final String shopcd) {
		return this.ctNayoseSkipShopMapper.selectByPrimaryKey(shopcd);
	}

	/**
	 * @param dto
	 * @return
	 * @throws InProcessingException
	 */
	public Integer updateShopAppendInfo(final ShopAppendInfo dto) throws InProcessingException {
		// add other comment
		final List<String> values = new ArrayList<>();
		for (final net.chintai.batch.common.domain.MstCommentKbn cmtKbn : this.masterService
				.selectMstCommentKbnByDataKbn(MstCommentKbn.DATA_KBN_SHOP.getValue())) {
			if (!"09".equals(cmtKbn.getCommentKbn()) && !"10".equals(cmtKbn.getCommentKbn())
					&& !"11".equals(cmtKbn.getCommentKbn())) {

			}
			else {
				values.add(cmtKbn.getCommentKbn());
			}
		}
		final ShopRirekiCommentExample example = new ShopRirekiCommentExample();
		example.createCriteria()
				.andPkShopRirekiEqualTo(selectShopKanriByPrimaryKey(dto.getShopcd()).getPkShopRirekiLast())
				.andCommentKbnIn(values);
		for (final ShopRirekiComment shopRirekiComment : this.shopRirekiCommentMapper.selectByExample(example)) {
			dto.getShopRirekiComments().add(shopRirekiComment);
		}
		final Integer pkShopRireki = updateShopRireki(dto);
		return pkShopRireki;
	}

	/**
	 * @param dto
	 * @return
	 * @throws InProcessingException
	 */
	@Transactional(rollbackFor = Exception.class)
	public Integer updateShopImageCampaign(final ShopImageCampaign dto) throws InProcessingException {
		{
			// add not Campaign
			final List<String> values = new ArrayList<>();
			{
				final MstImgKbnExample example = new MstImgKbnExample();
				example.createCriteria().andDelKbnEqualTo(GenericFlg.OFF.getValue())
						.andShopBukkenKbnEqualTo(ShopBukkenKbn.SHOP.getValue())
						.andImgCategoryNotIn(Arrays.asList(ImgCategory.CAMPAIGN.getValue()));
				for (final MstImgKbn mstImgKbn : this.mstImgKbnMapper.selectByExample(example)) {
					values.add(mstImgKbn.getImgKbn());
				}
			}
			final ShopRirekiImgExample example = new ShopRirekiImgExample();
			example.createCriteria()
					.andPkShopRirekiEqualTo(selectShopKanriByPrimaryKey(dto.getShopcd()).getPkShopRirekiLast())
					.andImgKbnIn(values);
			for (final ShopRirekiImg shopRirekiImg : this.shopRirekiImgMapper.selectByExample(example)) {
				shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.NO_UPDATE.getValue());
				dto.getShopRirekiImgs().add(shopRirekiImg);
			}
		}
		{
			// add other comment
			final List<String> values = new ArrayList<>();
			for (final net.chintai.batch.common.domain.MstCommentKbn cmtKbn : this.masterService
					.selectMstCommentKbnByDataKbn(MstCommentKbn.DATA_KBN_SHOP.getValue())) {
				if (!"09".equals(cmtKbn.getCommentKbn()) && !"10".equals(cmtKbn.getCommentKbn())
						&& !"11".equals(cmtKbn.getCommentKbn())) {
					values.add(cmtKbn.getCommentKbn());
				}
			}
			final ShopRirekiCommentExample example = new ShopRirekiCommentExample();
			example.createCriteria()
					.andPkShopRirekiEqualTo(selectShopKanriByPrimaryKey(dto.getShopcd()).getPkShopRirekiLast())
					.andCommentKbnIn(values);
			for (final ShopRirekiComment shopRirekiComment : this.shopRirekiCommentMapper.selectByExample(example)) {
				dto.getShopRirekiComments().add(shopRirekiComment);
			}
		}
		final Integer pkShopRireki = updateShopRireki(dto);
		return pkShopRireki;
	}

	/**
	 * @param dto
	 * @return
	 * @throws InProcessingException
	 */
	@Transactional(rollbackFor = Exception.class)
	public Integer updateShopImageStaff(final ShopImageStaff dto) throws InProcessingException {
		// add not staff
		final List<String> values = new ArrayList<>();
		{
			final MstImgKbnExample example = new MstImgKbnExample();
			example.createCriteria().andDelKbnEqualTo(GenericFlg.OFF.getValue())
					.andShopBukkenKbnEqualTo(ShopBukkenKbn.SHOP.getValue())
					.andImgCategoryNotIn(Arrays.asList(ImgCategory.STAFF.getValue()));
			for (final MstImgKbn mstImgKbn : this.mstImgKbnMapper.selectByExample(example)) {
				values.add(mstImgKbn.getImgKbn());
			}
		}
		final ShopRirekiImgExample example = new ShopRirekiImgExample();
		example.createCriteria()
				.andPkShopRirekiEqualTo(selectShopKanriByPrimaryKey(dto.getShopcd()).getPkShopRirekiLast())
				.andImgKbnIn(values);
		for (final ShopRirekiImg shopRirekiImg : this.shopRirekiImgMapper.selectByExample(example)) {
			shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.NO_UPDATE.getValue());
			dto.getShopRirekiImgs().add(shopRirekiImg);
		}
		final Integer pkShopRireki = updateShopRireki(dto);
		return pkShopRireki;
	}

	/**
	 * @param dto
	 * @return
	 * @throws InProcessingException
	 */
	@Transactional(rollbackFor = Exception.class)
	public Integer updateShopImage(final ShopImage dto) throws InProcessingException {
		// add staff and campaign
		final List<String> values = new ArrayList<>();
		{
			final MstImgKbnExample example = new MstImgKbnExample();
			example.createCriteria()
					.andDelKbnEqualTo(GenericFlg.OFF.getValue())
					.andShopBukkenKbnEqualTo(ShopBukkenKbn.SHOP.getValue())
					.andImgCategoryNotIn(
							Arrays.asList(ImgCategory.COMPANY_LOGO.getValue(), ImgCategory.INFORMATION.getValue(),
									ImgCategory.GAIKAN.getValue(), ImgCategory.NAIKAN.getValue(),
									ImgCategory.STAFF_GROUP_PHOTO.getValue(), ImgCategory.OTHER.getValue(), ImgCategory.STAFF_CUSTOMER_PHOTO.getValue()));
			for (final MstImgKbn mstImgKbn : this.mstImgKbnMapper.selectByExample(example)) {
				values.add(mstImgKbn.getImgKbn());
			}
		}
		final ShopRirekiImgExample example = new ShopRirekiImgExample();
		example.createCriteria()
				.andPkShopRirekiEqualTo(selectShopKanriByPrimaryKey(dto.getShopcd()).getPkShopRirekiLast())
				.andImgKbnIn(values);
		for (final ShopRirekiImg shopRirekiImg : this.shopRirekiImgMapper.selectByExample(example)) {
			shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.NO_UPDATE.getValue());
			dto.getShopRirekiImgs().add(shopRirekiImg);
		}
		final Integer pkShopRireki = updateShopRireki(dto);
		return pkShopRireki;
	}

	/**
	 * @param dto
	 * @return
	 * @throws InProcessingException
	 */
	@Transactional(rollbackFor = Exception.class)
	public Integer updateAspShopImage(final ShopImage dto) throws InProcessingException {
		// add staff and campaign
		final List<String> values = new ArrayList<>();
		{
			final MstImgKbnExample example = new MstImgKbnExample();
			example.createCriteria().andDelKbnEqualTo(GenericFlg.OFF.getValue())
					.andShopBukkenKbnEqualTo(ShopBukkenKbn.SHOP.getValue())
					.andImgCategoryNotIn(Arrays.asList(ImgCategory.ASP_LOGO.getValue()));
			for (final MstImgKbn mstImgKbn : this.mstImgKbnMapper.selectByExample(example)) {
				values.add(mstImgKbn.getImgKbn());
			}
		}
		final ShopRirekiImgExample example = new ShopRirekiImgExample();
		example.createCriteria()
				.andPkShopRirekiEqualTo(selectShopKanriByPrimaryKey(dto.getShopcd()).getPkShopRirekiLast())
				.andImgKbnIn(values);
		for (final ShopRirekiImg shopRirekiImg : this.shopRirekiImgMapper.selectByExample(example)) {
			shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.NO_UPDATE.getValue());
			dto.getShopRirekiImgs().add(shopRirekiImg);
		}
		final Integer pkShopRireki = updateShopRireki(dto);
		return pkShopRireki;
	}

	/**
	 * @param dto
	 * @return
	 * @throws InProcessingException
	 */
	@Transactional(rollbackFor = Exception.class)
	public Integer updateShopBasicInfo(final ShopBasicInfo dto) throws InProcessingException {
		final Integer pkShopRireki = updateShopRireki(dto);
		// 名寄せ除外設定
		if (dto.isNayoseSkip()) {
			final CtNayoseSkipShop record = new CtNayoseSkipShop();
			record.setShopcd(dto.getShopRireki().getShopcd());
			if (this.ctNayoseSkipShopMapper.updateByPrimaryKeySelective(record) == 0) {
				this.ctNayoseSkipShopMapper.insert(record);
			}
			;
		}
		else {
			this.ctNayoseSkipShopMapper.deleteByPrimaryKey(dto.getShopRireki().getShopcd());
		}

		return pkShopRireki;
	}

	/**
	 * @param shop
	 * @return
	 * @throws InProcessingException
	 */
	@Transactional(rollbackFor = Exception.class)
	public <T extends Shop> Integer updateShopRireki(final T shop) throws InProcessingException {
		if (StringUtils.hasText(shop.getShopcd())) {
			checkAndLockShopKanri(shop.getShopcd(), shop.getShopKanriUpdDt());
		}

		final Integer currentPkShopRireki = this.crsplusShopService.getPkShopRireki();
		final ShopHaishinDto dto = createInitializedShopHaishinDto(shop.getShopRireki().getShopcd(),
				currentPkShopRireki);

		final BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(shop);
		final BeanWrapper bwDto = PropertyAccessorFactory.forBeanPropertyAccess(dto);
		try {
			for (final PropertyDescriptor pd : bw.getPropertyDescriptors()) {
				final Class<?> clazz = pd.getPropertyType();
				// private ShopRireki currentShopRireki;
				if (clazz.equals(ShopRireki.class)) {
					final Object value = pd.getReadMethod().invoke(shop);
					initCurrent(value, currentPkShopRireki);
					if (!dto.isNewShopKanri()) {
						shopRirekiCurrent(value, currentPkShopRireki);
					}
					bwDto.setPropertyValue("currentShopRireki", value);
				}
				else if (clazz.equals(List.class)) {
					final Method m = pd.getReadMethod();
					final ParameterizedType gType = (ParameterizedType) m.getGenericReturnType();
					final Type gClazz = gType.getActualTypeArguments()[0];
					// private List<ShopRirekiCampaign> currentShopRirekiCampaign;
					if (gClazz.equals(ShopRirekiCampaign.class)) {
						final Object value = pd.getReadMethod().invoke(shop);
						initCurrent(value, currentPkShopRireki);
						bwDto.setPropertyValue("currentShopRirekiCampaign", value);
					}
					// private List<ShopRirekiComment> currentShopRirekiComment;
					else if (gClazz.equals(ShopRirekiComment.class)) {
						final Object value = pd.getReadMethod().invoke(shop);
						initCurrent(value, currentPkShopRireki);
						bwDto.setPropertyValue("currentShopRirekiComment", value);
					}
					// private List<ShopRirekiStaff> currentShopRirekiStaff;
					else if (gClazz.equals(ShopRirekiStaff.class)) {
						final Object value = pd.getReadMethod().invoke(shop);
						initCurrent(value, currentPkShopRireki);
						bwDto.setPropertyValue("currentShopRirekiStaff", value);
					}
					// private List<ShopRirekiEki> currentShopRirekiEki;
					else if (gClazz.equals(ShopRirekiEki.class)) {
						final Object value = pd.getReadMethod().invoke(shop);
						initCurrent(value, currentPkShopRireki);
						bwDto.setPropertyValue("currentShopRirekiEki", value);
					}
					// private List<ShopRirekiImg> currentShopRirekiImg;
					else if (gClazz.equals(ShopRirekiImg.class)) {
						final Object value = pd.getReadMethod().invoke(shop);
						initCurrent(value, currentPkShopRireki);
						bwDto.setPropertyValue("currentShopRirekiImg", value);
					}
					// private List<ShopRirekiProudArea> currentShopRirekiProudArea;
					else if (gClazz.equals(ShopRirekiProudArea.class)) {
						final Object value = pd.getReadMethod().invoke(shop);
						initCurrent(value, currentPkShopRireki);
						bwDto.setPropertyValue("currentShopRirekiProudArea", value);
					}
					// private List<ShopRirekiProudEki> currentShopRirekiProudEki;
					else if (gClazz.equals(ShopRirekiProudEki.class)) {
						final Object value = pd.getReadMethod().invoke(shop);
						initCurrent(value, currentPkShopRireki);
						bwDto.setPropertyValue("currentShopRirekiProudEki", value);
					}
					// private List<ShopRirekiCharacter> currentShopRirekiCharacter;
					else if (gClazz.equals(ShopRirekiCharacter.class)) {
						final Object value = pd.getReadMethod().invoke(shop);
						initCurrent(value, currentPkShopRireki);
						bwDto.setPropertyValue("currentShopRirekiCharacter", value);
					}
				}
			}
		}
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		try {
			this.cmsDistributionProcessService.execute(dto);
		}
		catch (final BatchException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		return currentPkShopRireki;
	}

	/**
	 * @param shopcd
	 * @param currentPkShopRireki
	 * @return
	 */
	public ShopHaishinDto createInitializedShopHaishinDto(final String shopcd, final Integer currentPkShopRireki) {

		final ShopHaishinDto dto = new ShopHaishinDto();

		if (StringUtils.hasText(shopcd)) {
			dto.setShopKanri(selectShopKanriByPrimaryKey(shopcd));
			if (dto.getShopKanri() != null) {
				final Integer pkShopRireki = dto.getShopKanri().getPkShopRirekiLast();

				final ShopKanri shopKanri = dto.getShopKanri();

				shopKanri.setPkShopRirekiLast(currentPkShopRireki);
				shopKanri.setAdminUpdDt(new DateTime().toDate());
				shopKanri.setUpdDt(null);
				shopKanri.setUpdId(null);
				shopKanri.setUpdPg(null);

				dto.setPreviousShopRireki(selectShopRirekiByPrimaryKey(pkShopRireki));
				dto.setPreviousShopRirekiCampaign(selectShopRirekiCampaignByPkShopRireki(pkShopRireki));
				dto.setPreviousShopRirekiCharacter(selectShopRirekiCharacterByPkShopRireki(pkShopRireki));
				dto.setPreviousShopRirekiComment(selectShopRirekiCommentByPkShopRireki(pkShopRireki));
				dto.setPreviousShopRirekiEki(selectShopRirekiEkiByPkShopRireki(pkShopRireki));
				dto.setPreviousShopRirekiImg(selectShopRirekiImgByPkShopRireki(pkShopRireki));
				dto.setPreviousShopRirekiProudArea(selectShopRirekiProudAreaByPkShopRireki(pkShopRireki));
				dto.setPreviousShopRirekiProudEki(selectShopRirekiProudEkiByPkShopRireki(pkShopRireki));
				dto.setPreviousShopRirekiStaff(selectShopRirekiStaffByPkShopRireki(pkShopRireki));

				dto.setCurrentShopRireki(toCurrent(dto.getPreviousShopRireki(), currentPkShopRireki));
				dto.setCurrentShopRirekiCampaign(toCurrent(dto.getPreviousShopRirekiCampaign(), currentPkShopRireki));
				dto.setCurrentShopRirekiCharacter(toCurrent(dto.getPreviousShopRirekiCharacter(), currentPkShopRireki));
				dto.setCurrentShopRirekiComment(toCurrent(dto.getPreviousShopRirekiComment(), currentPkShopRireki));
				dto.setCurrentShopRirekiEki(toCurrent(dto.getPreviousShopRirekiEki(), currentPkShopRireki));
				dto.setCurrentShopRirekiImg(toCurrent(dto.getPreviousShopRirekiImg(), currentPkShopRireki));
				for (final ShopRirekiImg shopRirekiImg : dto.getCurrentShopRirekiImg()) {
					shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.NO_UPDATE.getValue());
				}
				dto.setCurrentShopRirekiProudArea(toCurrent(dto.getPreviousShopRirekiProudArea(), currentPkShopRireki));
				dto.setCurrentShopRirekiProudEki(toCurrent(dto.getPreviousShopRirekiProudEki(), currentPkShopRireki));
				dto.setCurrentShopRirekiStaff(toCurrent(dto.getPreviousShopRirekiStaff(), currentPkShopRireki));

				/*
				 * ここでセットしても上書きされてしまう。 final ShopRireki shopRireki = dto.getCurrentShopRireki();
				 * shopRireki.setCmdcdShop(Cmdcd.UPDATE.getValue()); shopRireki.setInsKbn(InsKbn.UPDATE.getValue());
				 * shopRireki.setHasshinTm(new DateTime().toDate());
				 */
			}
			else {
				final ShopKanri shopKanri = new ShopKanri();
				shopKanri.setPkShopRirekiLast(currentPkShopRireki);
				shopKanri.setShopcd(shopcd);
				shopKanri.setAblKeisaiFlg(GenericFlg.OFF.getValue());
				shopKanri.setCtKeisaiFlg(GenericFlg.OFF.getValue());
				shopKanri.setAdminUpdDt(new DateTime().toDate());
				dto.setShopKanri(shopKanri);
				dto.setNewShopKanri(true);
			}
		}
		return dto;
	}

	/**
	 * @param t
	 * @param currentPkShopRireki
	 * @return
	 */
	private <T> T toCurrent(final T t, final Integer currentPkShopRireki) {
		@SuppressWarnings("unchecked")
		final T current = (T) SerializationUtils.clone((Serializable) t);
		return initCurrent(current, currentPkShopRireki);
	}

	/**
	 * @param current
	 * @param currentPkShopRireki
	 * @return
	 */
	private <T> T initCurrent(final T current, final Integer currentPkShopRireki) {
		if (current instanceof List) {
			final List<?> list = (List<?>) current;
			for (final Object object : list) {
				final BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(object);
				bw.setPropertyValue("insDt", null);
				bw.setPropertyValue("insPg", null);
				bw.setPropertyValue("insId", null);
				bw.setPropertyValue("updDt", null);
				bw.setPropertyValue("updPg", null);
				bw.setPropertyValue("updId", null);
				bw.setPropertyValue("pkShopRireki", currentPkShopRireki);
			}
		}
		else {
			final BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(current);
			bw.setPropertyValue("insDt", null);
			bw.setPropertyValue("insPg", null);
			bw.setPropertyValue("insId", null);
			bw.setPropertyValue("updDt", null);
			bw.setPropertyValue("updPg", null);
			bw.setPropertyValue("updId", null);
			bw.setPropertyValue("pkShopRireki", currentPkShopRireki);
		}
		return current;
	}

	/**
	 * @param current
	 * @param currentPkShopRireki
	 * @return
	 */
	private <T> T shopRirekiCurrent(final T current, final Integer currentPkShopRireki) {
		if (current instanceof List) {
			final List<?> list = (List<?>) current;
			for (final Object object : list) {
				final BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(object);
				bw.setPropertyValue("hasshinTm", new DateTime().toDate());
				bw.setPropertyValue("cmdcdShop", Cmdcd.UPDATE.getValue());
				bw.setPropertyValue("insKbn", InsKbn.UPDATE.getValue());
				bw.setPropertyValue("receiveFormatKbn", ReceiveFormatKbn.NEW_AND_OLD.getValue());
			}
		}
		else {
			final BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(current);
			bw.setPropertyValue("hasshinTm", new DateTime().toDate());
			bw.setPropertyValue("cmdcdShop", Cmdcd.UPDATE.getValue());
			bw.setPropertyValue("insKbn", InsKbn.UPDATE.getValue());
			bw.setPropertyValue("receiveFormatKbn", ReceiveFormatKbn.NEW_AND_OLD.getValue());
		}
		return current;
	}

	/**
	 * @param shopcd
	 * @param imgKbn
	 * @param imgId
	 */
	public String toShopImgName(final String shopcd, final String imgKbn, final String imgId,
			final String originalFilename) {
		final StringBuilder sb = new StringBuilder();

		String ext = FilenameUtils.getExtension(originalFilename);
		if (!StringUtils.hasText(ext)) {
			ext = "JPG";
		}
		ext = ext.toUpperCase();
		if ("JPEG".equals(ext)) {
			ext = "JPG";
		}
		// {SHOPCD}_{画像区分}_店舗コード+_{yyyyMMddHHmmssSSS}_{トークン}.JPG
		sb.append(shopcd).append("_").append(imgKbn).append("_").append(shopcd).append("_")
				.append(new DateTime().toString("yyyyMMddHHmmssSSS")).append("_").append(imgId).append(".").append(ext);
		return sb.toString();
	}

	/**
	 * @param shopCd
	 * @return
	 */
	public String getImgId(final String shopCd) {
		return shopCd + RandomStringUtils.randomAlphanumeric(23);
	}

	/**
	 * @param shopcd
	 * @param updDt
	 * @throws InProcessingException
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public void checkAndLockShopKanri(final String shopcd, final Date updDt) throws InProcessingException {
		{
			final ShopKanriExample example = new ShopKanriExample();
			example.createCriteria().andShopcdEqualTo(shopcd);
			example.setForUpdate(true);
			List<ShopKanri> shopKanris;
			try {
				shopKanris = this.shopKanriMapper.selectByExample(example);
			}
			catch (final CannotAcquireLockException e) {
				throw new InProcessingException();
			}
			if (shopKanris.size() != 1) {
				throw new InProcessingException();
			}
			if (!shopKanris.get(0).getUpdDt().equals(updDt)) {
				throw new InProcessingException();
			}
		}
		{
			final ShopRirekiCreReqExample example = new ShopRirekiCreReqExample();
			example.createCriteria().andShopcdEqualTo(shopcd);
			if (this.shopRirekiCreReqMapper.countByExample(example) != 0) {
				throw new InProcessingException();
			}
		}
		{
			final ShopReceiveExample example = new ShopReceiveExample();
			example.createCriteria().andShopcdEqualTo(shopcd);
			if (this.shopReceiveMapper.countByExample(example) != 0) {
				throw new InProcessingException();
			}
		}

	}

	/**
	 * @param pkShopRireki
	 * @return
	 */
	public List<ShopRirekiCampaign> selectShopRirekiCampaignByPkShopRireki(final Integer pkShopRireki) {
		final ShopRirekiCampaignExample example = new ShopRirekiCampaignExample();
		example.createCriteria().andPkShopRirekiEqualTo(pkShopRireki);
		example.setOrderByClause(ShopRirekiStaffExample.ENTRY_NO);
		return this.shopRirekiCampaignMapper.selectByExample(example);
	}

	/**
	 * @param pkShopRireki
	 * @return
	 */
	public List<ShopRirekiStaff> selectShopRirekiStaffByPkShopRireki(final Integer pkShopRireki) {
		final ShopRirekiStaffExample example = new ShopRirekiStaffExample();
		example.createCriteria().andPkShopRirekiEqualTo(pkShopRireki);
		example.setOrderByClause(ShopRirekiStaffExample.ENTRY_NO);
		return this.shopRirekiStaffMapper.selectByExample(example);
	}

	/**
	 * @param pkShopRireki
	 * @return
	 */
	public List<ShopRirekiProudEki> selectShopRirekiProudEkiByPkShopRireki(final Integer pkShopRireki) {
		final ShopRirekiProudEkiExample example = new ShopRirekiProudEkiExample();
		example.createCriteria().andPkShopRirekiEqualTo(pkShopRireki);
		example.setOrderByClause(ShopRirekiProudEkiExample.ENTRY_NO);
		return this.shopRirekiProudEkiMapper.selectByExample(example);
	}

	/**
	 * @param pkShopRireki
	 * @return
	 */
	public List<ShopRirekiImg> selectShopRirekiImgByPkShopRireki(final Integer pkShopRireki) {
		final ShopRirekiImgExample example = new ShopRirekiImgExample();
		example.createCriteria().andPkShopRirekiEqualTo(pkShopRireki);
		return this.shopRirekiImgMapper.selectByExample(example);
	}

	/**
	 * @param pkShopRireki
	 * @return
	 */
	public List<ShopRirekiComment> selectShopRirekiCommentByPkShopRireki(final Integer pkShopRireki) {
		final ShopRirekiCommentExample example = new ShopRirekiCommentExample();
		example.createCriteria().andPkShopRirekiEqualTo(pkShopRireki);
		return this.shopRirekiCommentMapper.selectByExample(example);
	}

	/**
	 * @param pkShopRireki
	 * @return
	 */
	public List<ShopRirekiProudArea> selectShopRirekiProudAreaByPkShopRireki(final Integer pkShopRireki) {
		final ShopRirekiProudAreaExample example = new ShopRirekiProudAreaExample();
		example.createCriteria().andPkShopRirekiEqualTo(pkShopRireki);
		example.setOrderByClause(ShopRirekiProudAreaExample.ENTRY_NO);
		return this.shopRirekiProudAreaMapper.selectByExample(example);
	}

	/**
	 * @param pkShopRireki
	 * @return
	 */
	public List<ShopRirekiCharacter> selectShopRirekiCharacterByPkShopRireki(final Integer pkShopRireki) {
		final ShopRirekiCharacterExample example = new ShopRirekiCharacterExample();
		example.createCriteria().andPkShopRirekiEqualTo(pkShopRireki);
		return this.shopRirekiCharacterMapper.selectByExample(example);
	}

	/**
	 * @param shopcd
	 * @return
	 */
	public BukkenCount getBukkenCountByShopcd(final String shopcd) {
		final BukkenCount ret = new BukkenCount();
		try {
			final SqlRunner runner = new SqlRunner(this.sqlSession.getConnection());

			BigDecimal count = (BigDecimal) runner
					.selectOne(
							"SELECT COUNT(*) COUNT FROM ( ( SELECT DISTINCT CKB.PK_BUKKEN_RIREKI FROM CT_KEISAI_BUKKEN CKB ,BUKKEN_RIREKI_SHOP BRS WHERE CKB.PK_BUKKEN_RIREKI = BRS.PK_BUKKEN_RIREKI(+) AND CKB.SHOPCD = ? ) UNION ( SELECT DISTINCT CKB.PK_BUKKEN_RIREKI FROM CT_KEISAI_BUKKEN CKB ,BUKKEN_RIREKI_SHOP BRS WHERE CKB.PK_BUKKEN_RIREKI = BRS.PK_BUKKEN_RIREKI(+) AND BRS.AGENCY_SHOPCD = ? ) )",
							shopcd, shopcd).get("COUNT");
			ret.setYukoCt(count.intValue());

			count = (BigDecimal) runner
					.selectOne(
							"SELECT COUNT(*) COUNT FROM ( ( SELECT DISTINCT CKB.PK_BUKKEN_RIREKI FROM ABL_KEISAI_BUKKEN CKB ,BUKKEN_RIREKI_SHOP BRS WHERE CKB.PK_BUKKEN_RIREKI = BRS.PK_BUKKEN_RIREKI(+) AND CKB.SHOPCD = ? ) UNION ( SELECT DISTINCT CKB.PK_BUKKEN_RIREKI FROM ABL_KEISAI_BUKKEN CKB ,BUKKEN_RIREKI_SHOP BRS WHERE CKB.PK_BUKKEN_RIREKI = BRS.PK_BUKKEN_RIREKI(+) AND BRS.AGENCY_SHOPCD = ? ) )",
							shopcd, shopcd).get("COUNT");
			ret.setYukoAbl(count.intValue());

			count = (BigDecimal) runner
					.selectOne(
							"SELECT COUNT(*) COUNT FROM ( ( SELECT DISTINCT CKB.PK_BUKKEN_RIREKI FROM CT_KEISAI_BUKKEN CKB ,BUKKEN_RIREKI_SHOP BRS ,BUKKEN_RIREKI BR WHERE CKB.PK_BUKKEN_RIREKI = BRS.PK_BUKKEN_RIREKI(+) AND ( CKB.SHOPCD = ? ) AND CKB.PK_BUKKEN_RIREKI = BR.PK_BUKKEN_RIREKI AND BR.KEIYAKU_KBN = '1' ) UNION ( SELECT DISTINCT CKB.PK_BUKKEN_RIREKI FROM CT_KEISAI_BUKKEN CKB ,BUKKEN_RIREKI_SHOP BRS ,BUKKEN_RIREKI BR WHERE CKB.PK_BUKKEN_RIREKI = BRS.PK_BUKKEN_RIREKI(+) AND ( BRS.AGENCY_SHOPCD = ? ) AND CKB.PK_BUKKEN_RIREKI = BR.PK_BUKKEN_RIREKI AND BR.KEIYAKU_KBN = '1' ) )",
							shopcd, shopcd).get("COUNT");
			ret.setTeishakuCt(count.intValue());

			count = (BigDecimal) runner
					.selectOne(
							"SELECT COUNT(*) COUNT FROM ( ( SELECT DISTINCT CKB.PK_BUKKEN_RIREKI FROM ABL_KEISAI_BUKKEN CKB ,BUKKEN_RIREKI_SHOP BRS ,BUKKEN_RIREKI BR WHERE CKB.PK_BUKKEN_RIREKI = BRS.PK_BUKKEN_RIREKI(+) AND ( CKB.SHOPCD = ? ) AND CKB.PK_BUKKEN_RIREKI = BR.PK_BUKKEN_RIREKI AND BR.KEIYAKU_KBN = '1' ) UNION ( SELECT DISTINCT CKB.PK_BUKKEN_RIREKI FROM ABL_KEISAI_BUKKEN CKB ,BUKKEN_RIREKI_SHOP BRS ,BUKKEN_RIREKI BR WHERE CKB.PK_BUKKEN_RIREKI = BRS.PK_BUKKEN_RIREKI(+) AND ( BRS.AGENCY_SHOPCD = ? ) AND CKB.PK_BUKKEN_RIREKI = BR.PK_BUKKEN_RIREKI AND BR.KEIYAKU_KBN = '1' ) )",
							shopcd, shopcd).get("COUNT");
			ret.setTeishakuAbl(count.intValue());

			count = (BigDecimal) runner
					.selectOne(
							"SELECT COUNT(*) COUNT FROM ( ( SELECT DISTINCT CKB.PK_BUKKEN_RIREKI FROM CT_KEISAI_BUKKEN CKB ,BUKKEN_RIREKI_SHOP BRS ,BUKKEN_RIREKI BR WHERE CKB.PK_BUKKEN_RIREKI = BRS.PK_BUKKEN_RIREKI(+) AND ( CKB.SHOPCD = ? ) AND CKB.PK_BUKKEN_RIREKI = BR.PK_BUKKEN_RIREKI AND BR.SHUBETSUCD IN ( '07' ,'08' ,'09' ,'10' ,'99' ) ) UNION ( SELECT DISTINCT CKB.PK_BUKKEN_RIREKI FROM CT_KEISAI_BUKKEN CKB ,BUKKEN_RIREKI_SHOP BRS ,BUKKEN_RIREKI BR WHERE CKB.PK_BUKKEN_RIREKI = BRS.PK_BUKKEN_RIREKI(+) AND ( BRS.AGENCY_SHOPCD = ? ) AND CKB.PK_BUKKEN_RIREKI = BR.PK_BUKKEN_RIREKI AND BR.SHUBETSUCD IN ( '07' ,'08' ,'09' ,'10' ,'99' ) ) )",
							shopcd, shopcd).get("COUNT");
			ret.setTenantCt(count.intValue());

			count = (BigDecimal) runner
					.selectOne(
							"SELECT COUNT(*) COUNT FROM ( ( SELECT DISTINCT CKB.PK_BUKKEN_RIREKI FROM ABL_KEISAI_BUKKEN CKB ,BUKKEN_RIREKI_SHOP BRS ,BUKKEN_RIREKI BR WHERE CKB.PK_BUKKEN_RIREKI = BRS.PK_BUKKEN_RIREKI(+) AND ( CKB.SHOPCD = ? ) AND CKB.PK_BUKKEN_RIREKI = BR.PK_BUKKEN_RIREKI AND BR.SHUBETSUCD IN ( '07' ,'08' ,'09' ,'10' ,'99' ) ) UNION ( SELECT DISTINCT CKB.PK_BUKKEN_RIREKI FROM ABL_KEISAI_BUKKEN CKB ,BUKKEN_RIREKI_SHOP BRS ,BUKKEN_RIREKI BR WHERE CKB.PK_BUKKEN_RIREKI = BRS.PK_BUKKEN_RIREKI(+) AND ( BRS.AGENCY_SHOPCD = ? ) AND CKB.PK_BUKKEN_RIREKI = BR.PK_BUKKEN_RIREKI AND BR.SHUBETSUCD IN ( '07' ,'08' ,'09' ,'10' ,'99' ) ) )",
							shopcd, shopcd).get("COUNT");
			ret.setTenantAbl(count.intValue());
		}
		catch (final Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		return ret;
	}

	/**
	 * @param shopcd
	 * @return
	 */
	public ShopRireki selectShopRirekiByShopcd(final String shopcd) {
		final ShopKanri shopKanri = selectShopKanriByPrimaryKey(shopcd);
		if (shopKanri == null) {
			return null;
		}

		return this.shopRirekiMapper.selectByPrimaryKey(shopKanri.getPkShopRirekiLast());
	}

	/**
	 * @param shopcd
	 * @return
	 * @see net.chintai.batch.common.persistence.mapper.ShopKanriMapper#selectByPrimaryKey(java.lang.String)
	 */
	public ShopKanri selectShopKanriByPrimaryKey(final String shopcd) {
		return this.shopKanriMapper.selectByPrimaryKey(shopcd);
	}

	/**
	 * @param value
	 * @return
	 * @see net.chintai.backend.sysadmin.crnwl.mapper.gen.VAspGroupShopMapper#selectByExample(net.chintai.backend.sysadmin.crnwl.model.gen.VAspGroupShopExample)
	 */
	public List<VAspGroupShop> selectVAspGroupShopByGroupShopcd(final String value) {
		final VAspGroupShopExample example = new VAspGroupShopExample();
		example.createCriteria().andGroupShopcdEqualTo(value);
		return this.vAspGroupShopMapper.selectByExample(example);
	}

	/**
	 * @param value
	 * @return
	 */
	public List<VShopKeiyakuDetail> selectVShopKeiyakuDetailCmsDispByShopcd(final String value) {
		final VShopKeiyakuDetailExample example = new VShopKeiyakuDetailExample();
		example.createCriteria().andShopcdEqualTo(value).andCmsDispFlgEqualTo("1");
		example.setOrderByClause(VShopKeiyakuDetailExample.SORT_KEY);
		return this.vShopKeiyakuDetailMapper.selectByExample(example);
	}

	/**
	 * @param pkShopRireki
	 * @return
	 */
	public List<ShopRirekiEki> selectShopRirekiEkiByPkShopRireki(final Integer pkShopRireki) {
		final ShopRirekiEkiExample example = new ShopRirekiEkiExample();
		example.createCriteria().andPkShopRirekiEqualTo(pkShopRireki);
		example.setOrderByClause(ShopRirekiEkiExample.ENTRY_NO);
		return this.shopRirekiEkiMapper.selectByExample(example);
	}

	/**
	 * @param pkShopRireki
	 * @return
	 * @see net.chintai.backend.sysadmin.crnwl.mapper.gen.ShopRirekiMapper#selectByPrimaryKey(java.lang.Integer)
	 */
	public ShopRireki selectShopRirekiByPrimaryKey(final Integer pkShopRireki) {
		return this.shopRirekiMapper.selectByPrimaryKey(pkShopRireki);
	}

	/**
	 * @param shopcd
	 * @param keiyakuCd
	 * @param keiyakuSubCd
	 * @param nowDate
	 * @return
	 */
	public List<ShopKeiyakuKanri> selectShopKeiyakuKanriList(final String shopcd, final String keiyakuCd, final String keiyakuSubCd, final String nowDate) {
		final ShopKeiyakuKanriExample example = new ShopKeiyakuKanriExample();
		example.createCriteria().andShopcdEqualTo(shopcd).andKeiyakuCdEqualTo(keiyakuCd).andKeiyakuSubCdEqualTo(keiyakuSubCd).andKeiyakuStartDtGreaterThan(nowDate);
		return this.shopKeiyakuKanriMapper.selectByExample(example);
	}

	/**
	 * @param shopcd
	 * @param ppcUseKbn
	 * @return
	 */
	public PpcInfo selectPpcInfoChintaiDateEditByPrimaryKey(final String shopcd) {
		PpcInfo ppcInfo = this.ppcInfoMapper.selectByPrimaryKey(shopcd, PpcUseKbn.CHINTAI.getValue());
		if(ppcInfo != null){
    		if(StringUtils.hasText(ppcInfo.getPpcStartDt())){
    			ppcInfo.setPpcStartDt(ShopBukkenUtils.convertDateAll(ppcInfo.getPpcStartDt()));
    		}
    		if(StringUtils.hasText(ppcInfo.getPpcEndDt())){
    			ppcInfo.setPpcEndDt(ShopBukkenUtils.convertDateAll(ppcInfo.getPpcEndDt()));
    		}
    		if(StringUtils.hasText(ppcInfo.getPpcRecycleDt())){
    			ppcInfo.setPpcRecycleDt(ShopBukkenUtils.convertDateAll(ppcInfo.getPpcRecycleDt()));
    		}
    	}
		return ppcInfo;
	}

	/**
	 * @param shopcd
	 * @param ppcUseKbn
	 * @return
	 */
	public PpcInfo selectPpcInfoAblDateEditByPrimaryKey(final String shopcd) {
		PpcInfo ppcInfo = this.ppcInfoMapper.selectByPrimaryKey(shopcd, PpcUseKbn.ABLE.getValue());
		if(ppcInfo != null){
    		if(StringUtils.hasText(ppcInfo.getPpcStartDt())){
    			ppcInfo.setPpcStartDt(ShopBukkenUtils.convertDateAll(ppcInfo.getPpcStartDt()));
    		}
    		if(StringUtils.hasText(ppcInfo.getPpcEndDt())){
    			ppcInfo.setPpcEndDt(ShopBukkenUtils.convertDateAll(ppcInfo.getPpcEndDt()));
    		}
    		if(StringUtils.hasText(ppcInfo.getPpcRecycleDt())){
    			ppcInfo.setPpcRecycleDt(ShopBukkenUtils.convertDateAll(ppcInfo.getPpcRecycleDt()));
    		}
    	}
		return ppcInfo;
	}

	/**
	 * @param shopcd
	 * @return
	 */
	public PpcInfo selectPpcInfoMagazineDateEditByPrimaryKey(final String shopcd) {
		PpcInfo ppcInfo = this.ppcInfoMapper.selectByPrimaryKey(shopcd, PpcUseKbn.MAGAZINE.getValue());
		if(ppcInfo != null){
    		if(StringUtils.hasText(ppcInfo.getPpcStartDt())){
    			ppcInfo.setPpcStartDt(ShopBukkenUtils.convertDateAll(ppcInfo.getPpcStartDt()));
    		}
    		if(StringUtils.hasText(ppcInfo.getPpcEndDt())){
    			ppcInfo.setPpcEndDt(ShopBukkenUtils.convertDateAll(ppcInfo.getPpcEndDt()));
    		}
    		if(StringUtils.hasText(ppcInfo.getPpcRecycleDt())){
    			ppcInfo.setPpcRecycleDt(ShopBukkenUtils.convertDateAll(ppcInfo.getPpcRecycleDt()));
    		}
    	}
		return ppcInfo;
	}

	/**
	 * @param shopcd
	 * @param ppcUseKbn
	 * @return
	 */
	public PpcInfo selectPpcInfoByPrimaryKey(final String shopcd, final String ppcUseKbn) {
		return this.ppcInfoMapper.selectByPrimaryKey(shopcd, ppcUseKbn);
	}

	/**
	 * @param shopcd
	 * @return
	 */
	public List<PpcInfo> selectPpcInfoByShopcd(final String shopcd) {
		final PpcInfoExample example = new PpcInfoExample();
		example.createCriteria().andShopcdEqualTo(shopcd);
		return this.ppcInfoMapper.selectByExample(example);
	}

	/**
	 * @param reserveNo
	 * @return
	 */
	public ShopReserve selectShopReserveByPrimaryKey(final Integer reserveNo) {
		return this.shopReserveMapper.selectByPrimaryKey(reserveNo);
	}

	/**
	 * @param reserveNo
	 * @param shopcd
	 * @return
	 */
	public List<ShopReserve> selectShopReserveByShopcd(final Integer reserveNo, final String shopcd) {
		final ShopReserveExample example = new ShopReserveExample();
		example.createCriteria().andReserveNoEqualTo(reserveNo).andShopcdEqualTo(shopcd);
		return this.shopReserveMapper.selectByExample(example);
	}

	/**
	 * @param shopcd
	 * @return
	 */
	public List<ShopReserve> selectShopReserveByShopcd(final String shopcd) {
		final ShopReserveExample example = new ShopReserveExample();
		example.createCriteria().andShopcdEqualTo(shopcd);
		return this.shopReserveMapper.selectByExample(example);
	}

	/**
	 * @param shopcd
	 * @return
	 */
	public boolean isExistsShopReserve(final String shopcd) {
		List<ShopReserve> shopReserveList = selectShopReserveByShopcd(shopcd);
		boolean isExistsShopReserve = false;
		if(!CollectionUtils.isEmpty(shopReserveList)){
			isExistsShopReserve = true;
		}
		return isExistsShopReserve;
	}

	/**
	 * @param shopcd
	 * @param reserveStartDt
	 * @return
	 */
	public List<ShopReserve> selectShopReserveByShopcdAndApplyDt(final String shopcd, final String applyDt) {
		final ShopReserveExample example = new ShopReserveExample();
		example.createCriteria().andShopcdEqualTo(shopcd).andApplyDtEqualTo(applyDt);
		return this.shopReserveMapper.selectByExample(example);
	}

	/**
	 * @param shopReserve
	 */
	public void insertShopReserve(final ShopReserve shopReserve){
		shopReserveMapper.insert(shopReserve);
	}

	/**
	 * @param reserveNo
	 */
	public void deleteShopReserve(final Integer reserveNo){
		shopReserveMapper.deleteByPrimaryKey(reserveNo);
	}

	/**
	 * @param shopcd
	 * @return
	 */
	public boolean isDispRegistrationStatusUpdateLink(final String shopcd) {
		boolean isExists = false;
		final ShopRirekiExample example = new ShopRirekiExample();
		example.createCriteria().andShopcdEqualTo(shopcd);

		List<ShopRireki> shopRirekiList = this.shopRirekiMapper.selectByExample(example);
		for(final ShopRireki shopRireki: shopRirekiList){
			if(StringUtils.isEmpty(shopRireki.getReceiveFormatKbn()) || "1".equals(shopRireki.getReceiveFormatKbn())){
				isExists = true;
				break;
			}
		}
		return isExists;
	}

}
