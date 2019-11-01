/*
 * $Id: AspUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.crnwl.aop.IdHolder;
import net.chintai.backend.sysadmin.crnwl.dto.ShopImage;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupAddCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.AspUpdateCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspUpdateCommitInServiceBean;
import net.chintai.batch.common.ImgUpdateKbn;
import net.chintai.batch.common.aop.PgHolder;
import net.chintai.batch.common.domain.ShopKanri;
import net.chintai.batch.common.domain.ShopRireki;
import net.chintai.batch.common.domain.ShopRirekiImg;
import net.chintai.batch.common.persistence.mapper.ShopKanriMapper;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * AspUpdateCommitServiceの実装クラス
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspUpdateCommitServiceImpl implements AspUpdateCommitService {

    /** 不動産ASP設定の都道府県のリクエストパラメータ名 */
    private static final String C_PREF_PARAM = "pref";

    /** 不動産ASP設定の検索条件付加項目 : 画面パラメータは0。 */
    private static final String C_SEARCH_ITEM0 = "0";

    /** 不動産ASP設定の検索条件付加項目 : 画面パラメータは1。 */
    private static final String C_SEARCH_ITEM1 = "1";

    /** 不動産ASP設定の検索条件付加項目 : 画面パラメータは2。 */
    private static final String C_SEARCH_ITEM2 = "2";

    /** 不動産ASP設定の検索条件付加項目 : 画面パラメータは3。 */
    private static final String C_SEARCH_ITEM3 = "3";

    /** ロゴフラグ表示*/
    private static final String LOG_FLG_HYOJI = "1";

    /** 不動産ASP設定情報登録DAO */
    private AspUpdateCommitDao aspUpdateCommitDao = null;

    // 排他制御用処理追加
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopKanriMapper shopKanrilMapper;

    /**
     * aspUpdateCommitDaoを設定する
     *
     * @param aspUpdateCommitDao
     *            不動産ASP設定情報登録DAO
     */
    public void setAspUpdateCommitDao(AspUpdateCommitDao aspUpdateCommitDao) {
        this.aspUpdateCommitDao = aspUpdateCommitDao;
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_bukken.service.AspUpdateCommitService#updateAspUpdateCommit(net.chintai.backend.sysadmin.shop_bukken
     * .service.bean.AspUpdateCommitInServiceBean)
     */
    public void updateAspUpdateCommit(AspUpdateCommitInServiceBean inServiceBean) throws Exception {

        // 不動産ASP登録情報をDomainに設定
        AspInfo aspInfo = new AspInfo();
        BeanUtils.copyProperties(aspInfo, inServiceBean);

        // upload
        final ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(inServiceBean.getShopCd());
        AspShopInfoParamBean param = new AspShopInfoParamBean();
        shopRireki.setImgId(inServiceBean.getImgId());
        param.setShopCd(inServiceBean.getShopCd());
        AspInfo chkAsp = (AspInfo)aspUpdateCommitDao.selectAspRegisteredInfo(param);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
            Date startDate = sdf.parse(aspInfo.getShopKanriUpdDt());

            // イメージ表示区分が変更されているか、画像がアップロードされている場合、
            // 契約解除状態で画像がアップロードされていた場合
            if (!StringUtils.isEmpty(inServiceBean.getImgRealPath())
                    || !inServiceBean.getLogoFlg().equals(chkAsp.getLogoFlg())) {

                shopRireki.setImgId(inServiceBean.getImgId());
                ShopImage dto = new ShopImage();
                dto.setShopRireki(shopRireki);
                final List<Path> images = new ArrayList<>();

                final ShopRirekiImg shopRirekiImg = new ShopRirekiImg();
                if (LOG_FLG_HYOJI.equals(inServiceBean.getLogoFlg())) {
                    dto.getShopRirekiImgs().add(shopRirekiImg);
                    shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.NO_UPDATE.getValue());
                    shopRirekiImg.setImgKbn(inServiceBean.getImgKbn());
                    if (inServiceBean.getImgUrlPath().startsWith("/tmp/img/")) {
                        images.add(Paths.get(inServiceBean.getImgRealPath() + File.separator
                                + inServiceBean.getImgFileNm()));
                        shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.UPDATE.getValue());
                    }
                } else {
                    inServiceBean.setImgFileType("");
                }

                dto.setShopcd(inServiceBean.getShopCd());
                dto.setShopKanriUpdDt(startDate);

                PgHolder.setPg(inServiceBean.getInsPg());
                IdHolder.setId(inServiceBean.getInsId());

                if (!CollectionUtils.isEmpty(images)) {
                    this.shopService.uploadShopImage(images);
                }
                final Integer pkShopRireki = this.shopService.updateAspShopImage(dto);
            } else {
                //画像に操作がない場合は履歴を作成しない。（排他のみ）
                shopService.checkAndLockShopKanri(inServiceBean.getShopCd(),startDate);
            }
        } catch (InProcessingException e) {
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0029", e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // 検索条件付加項目
        String searchItem = inServiceBean.getSearchItem();
        if (C_SEARCH_ITEM0.equals(searchItem)) {
            aspInfo.setSearchItem1("0");
            aspInfo.setSearchItem2("0");
        } else if(C_SEARCH_ITEM3.equals(searchItem)){
            aspInfo.setSearchItem1("0");
            aspInfo.setSearchItem2("1");
        } else if (C_SEARCH_ITEM1.equals(searchItem)) {
            aspInfo.setSearchItem1("1");
            aspInfo.setSearchItem2("0");
        } else if (C_SEARCH_ITEM2.equals(searchItem)) {
            aspInfo.setSearchItem1("1");
            aspInfo.setSearchItem2("1");
        }

        aspInfo.setLogoImageType(inServiceBean.getImgFileType());

        // 登録された不動産ASP設定情報を取得
        Map<String, String[]> requestMap = inServiceBean.getRequestMap();

        // 都道府県のリスト
        List<AspPrefInfo> aspPrefInfoList = new ArrayList<AspPrefInfo>();

        // Mapから都道府県、沿線タイプを区別して、リスト化する。
        Iterator it = requestMap.entrySet().iterator();
        Entry entry = null;
        String key = null;
        while (it.hasNext()) {
            entry = (Entry)it.next();
            key = (String)entry.getKey();

            if (key.length() == 6) {
                if (C_PREF_PARAM.equals(key.substring(0, 4))) {
                    String prefCode = key.substring(4, 6);
                    String prefSortKey = requestMap.get(key)[0];

                    if (prefSortKey != null && prefSortKey.length() > 0) {
                        AspPrefInfo aspPrefInfo = new AspPrefInfo();

                        aspPrefInfo.setShopCd(inServiceBean.getShopCd());
                        aspPrefInfo.setPrefCd(prefCode);
                        aspPrefInfo.setSortKey(prefSortKey);
                        aspPrefInfo.setInsId(inServiceBean.getInsId());
                        aspPrefInfo.setInsPg(inServiceBean.getInsPg());
                        aspPrefInfo.setAspShopSeq(chkAsp.getAspShopSeq());

                        aspPrefInfoList.add(aspPrefInfo);
                    }
                }
            }

        }

        // 未約済→契約済（登録）
        List<AspGroupAddCommitParamBean> aspGroupAddList
                =  aspUpdateCommitDao.selectAspGroupByShopCd(inServiceBean.getShopCd());

        // 不動産ASP情報
        Long aspShopSeq = aspUpdateCommitDao.insertAsp(aspInfo);

        //不動産ASP都道府県
        for (AspPrefInfo aspPrefInfo : aspPrefInfoList) {
            aspPrefInfo.setAspShopSeq(aspShopSeq);
            aspUpdateCommitDao.insertAspPref(aspPrefInfo);
        }

        //不動産ASPグループ
        for (AspGroupAddCommitParamBean aspGroupAddCommitParamBean : aspGroupAddList) {
            aspGroupAddCommitParamBean.setInsId(inServiceBean.getInsId());
            aspGroupAddCommitParamBean.setInsPg(inServiceBean.getInsPg());
            aspGroupAddCommitParamBean.setAspShopSeq(aspShopSeq);
            aspGroupAddCommitParamBean.setShopStatus(aspGroupAddCommitParamBean.getShopStatus());
            aspUpdateCommitDao.insertAspGroup(aspGroupAddCommitParamBean);
        }

        //画像がない場合は、店舗管理テーブルを更新して排他解除をする。
        if (StringUtils.isEmpty(inServiceBean.getImgRealPath())
                && chkAsp.getLogoFlg().equals(inServiceBean.getLogoFlg())) {

            ShopKanri shopKanri = shopService.selectShopKanriByPrimaryKey(aspInfo.getShopCd());
            shopKanri.setAdminUpdDt(new Timestamp(System.currentTimeMillis()));
            shopKanri.setUpdDt(new Timestamp(System.currentTimeMillis()));
            shopKanri.setUpdId(inServiceBean.getInsId());
            shopKanri.setUpdPg(inServiceBean.getInsPg());
            shopKanrilMapper.updateByPrimaryKey(shopKanri);
        }
    }
}
