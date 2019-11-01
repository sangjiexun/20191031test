/*
 * $Id: AspAddCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)沈鍾沿     新規作成
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
import net.chintai.backend.sysadmin.shop_bukken.dao.AspAddCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopContractInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopContractInfoParameterBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspAreaInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspContractInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.AspAddCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspAddCommitInServiceBean;
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
 * AspAddCommitServiceの実装クラス
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspAddCommitServiceImpl implements AspAddCommitService {

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

    /** 不動産ASP設定情報登録DAO */
    private AspAddCommitDao aspAddCommitDao = null;

    /** 不動産ASP契約情報取得DAO */
    private AspShopContractInfoDao aspShopContractInfoDao = null;

    // 排他制御用処理追加
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopKanriMapper shopKanrilMapper;


    // 排他制御用処理追加


    /**
     * aspAddCommitDaoを設定する
     * @param aspAddCommitDao
     */
    public void setAspAddCommitDao(AspAddCommitDao aspAddCommitDao) {
        this.aspAddCommitDao = aspAddCommitDao;
    }

    /**
     * aspShopContractInfoDaoを設定する
     *
     * @param aspShopContractInfoDao
     */
    public void setAspShopContractInfoDao(
            AspShopContractInfoDao aspShopContractInfoDao) {
        this.aspShopContractInfoDao = aspShopContractInfoDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.AspAddCommitService#insertAspAddCommit(net.chintai.backend.sysadmin.shop_bukken.service.bean.AspAddCommitInServiceBean)
     */
    public void insertAspAddCommit(AspAddCommitInServiceBean inServiceBean) throws Exception {

        // 不動産ASP登録情報をDomainに設定
        AspInfo aspInfo = new AspInfo();
        BeanUtils.copyProperties(aspInfo, inServiceBean);

        // upload
        final ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(inServiceBean.getShopCd());
        shopRireki.setImgId(inServiceBean.getImgId());

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
            Date startDate = sdf.parse(aspInfo.getShopKanriUpdDt());

            if ("1".equals(inServiceBean.getLogoFlg())) {
                ShopImage dto = new ShopImage();
                dto.setShopRireki(shopRireki);
                final List<Path> images = new ArrayList<>();
                final ShopRirekiImg shopRirekiImg = new ShopRirekiImg();
                dto.getShopRirekiImgs().add(shopRirekiImg);
                shopRirekiImg.setImgKbn(inServiceBean.getImgKbn());
                shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.NO_UPDATE.getValue());

                if (inServiceBean.getImgUrlPath().startsWith("/tmp/img/")) {
                    images.add(Paths.get(inServiceBean.getImgRealPath() + File.separator
                            + inServiceBean.getImgFileNm()));
                    shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.UPDATE.getValue());
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
        List<AspAreaInfo> aspAreaInfoList = new ArrayList<AspAreaInfo>();

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
                        AspAreaInfo aspAreaInfo = new AspAreaInfo();

                        aspAreaInfo.setShopCd(inServiceBean.getShopCd());
                        aspAreaInfo.setPrefCd(prefCode);
                        aspAreaInfo.setSortKey(prefSortKey);
                        aspAreaInfo.setInsId(inServiceBean.getInsId());
                        aspAreaInfo.setInsPg(inServiceBean.getInsPg());

                        aspAreaInfoList.add(aspAreaInfo);
                    }
                }
            }
        }

        // 不動産ASP連番取得
        Long aspShopSeq = aspAddCommitDao.insertAspAddCommit(aspInfo);

        for (int i = 0; i < aspAreaInfoList.size(); i++) {
            aspAreaInfoList.get(i).setAspShopSeq(aspShopSeq);
            aspAddCommitDao.insertAspAreaAddCommit(aspAreaInfoList.get(i));
        }

        //過去契約情報が取得
        AspShopContractInfoParameterBean bean = new AspShopContractInfoParameterBean();
        bean.setShopCd(inServiceBean.getShopCd());

        AspContractInfo aspContractInfo = (AspContractInfo)
                aspShopContractInfoDao.selectAspShopContractInfo(bean);

//        if (aspContractInfo.getKeiyakuNo() != null) {
//            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0029");
//        }

        aspContractInfo.setInsId(inServiceBean.getInsId());
        aspContractInfo.setInsPg(inServiceBean.getInsPg());
        aspContractInfo.setShopCd(inServiceBean.getShopCd());

/*
 SHOP_KEIYAKU_KANRI更新処理削除

        //過去契約情報が取得できた場合、レコードを無効な状態にする。(契約終了日時を設定)
        if (aspContractInfo.getKeiyakuNo() != null){
            aspAddCommitDao.updateAspContractModifyCommit(aspContractInfo);
        }

        // 新しい契約情報を登録する。
        aspAddCommitDao.insertAspContractAddCommit(aspContractInfo);
*/
        //画像がない場合は、店舗管理テーブルを更新して排他解除をする。
        if (!StringUtils.hasText(inServiceBean.getImgRealPath())) {
            ShopKanri shopKanri = shopService.selectShopKanriByPrimaryKey(aspInfo.getShopCd());
            shopKanri.setAdminUpdDt(new Timestamp(System.currentTimeMillis()));
            shopKanri.setUpdDt(new Timestamp(System.currentTimeMillis()));
            shopKanri.setUpdPg(inServiceBean.getInsPg());
            shopKanri.setUpdId(inServiceBean.getInsId());
            shopKanrilMapper.updateByPrimaryKey(shopKanri);
        }
    }
}
