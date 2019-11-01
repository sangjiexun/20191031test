/*
 * $Id: BukkenRirekiInfoAction.java 3960 2008-06-06 05:47:05Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/05/27     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.BukkenRirekiInfoView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.BukkenRirekiInfoView.BukkenRirekiDetailView;
import net.chintai.backend.sysadmin.shop_bukken.domain.ImgCntEachCategory;
import net.chintai.backend.sysadmin.shop_bukken.domain.SystemNameBean;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenRirekiInfoCsvDownloadService;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenRirekiInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenRirekiInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenRirekiInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ImgCntEachCategoryInServiceBean;
import net.chintai.batch.common.domain.MstFormatType;
import net.chintai.batch.common.domain.MstImgCategory;

/**
 * 入稿履歴一覧アクション
 *
 * @author Lee Hosup
 * @version $Revision: 3960 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenRirekiInfoAction extends BaseActionSupport {
	@Autowired
	private MasterService masterService;

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データを取得
        //String shopCd = context.getRequest().getParameter("shopCd");
        //String bkCd = context.getRequest().getParameter("bkCd");
        //String roomNo = context.getRequest().getParameter("roomNo");
        String roomKey = context.getRequest().getParameter("roomKey");

        BukkenRirekiInfoInServiceBean inBean = new BukkenRirekiInfoInServiceBean();
        //inBean.setShopCd(shopCd);
        //inBean.setBkCd(bkCd);
        //inBean.setRoomNo(roomNo);
        inBean.setRoomKey(roomKey);

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        BukkenRirekiInfoService bukkenInfoService =
            (BukkenRirekiInfoService)ac.getBean("bukkenRirekiInfoService");

        BukkenRirekiInfoCsvDownloadService service =
                (BukkenRirekiInfoCsvDownloadService) ac
                        .getBean("bukkenRirekiInfoCsvDownloadService");

        BukkenRirekiInfoView view = new BukkenRirekiInfoView();
        List<BukkenRirekiDetailView> detailList = new ArrayList<BukkenRirekiDetailView>();
        List<BukkenRirekiInfoOutServiceBean> resultList = new ArrayList<BukkenRirekiInfoOutServiceBean>();
        resultList = bukkenInfoService.getBukkenRirekiInfo(inBean);

        //写真 ヘッダーに表示するカテゴリー名
        final List<MstImgCategory> imgCategoryList = masterService.selectMstImgCategoryByShopBukkenKbn("2");
        final List<String> imgCategoryNameList = new ArrayList<String>();
        for(final MstImgCategory data: imgCategoryList){
        	imgCategoryNameList.add(data.getImgCategoryName());
        }
        view.setImgCategoryList(imgCategoryNameList);

        //登録機能が「項目補完」かどうかの判定用
        final List<MstFormatType> mstFormatTypeList = masterService.selectMstFormatTypeByItemComplementHasshinFlgOn();
        final List<String> formatTypeCdList = new ArrayList<String>();
        for(final MstFormatType mstFormatType: mstFormatTypeList){
        	formatTypeCdList.add(mstFormatType.getFormatTypeCd());
        }

        for (int i=0; i < resultList.size(); i++) {

            BukkenRirekiInfoOutServiceBean outBean = resultList.get(i);
            BukkenRirekiDetailView detailView = view.new BukkenRirekiDetailView();
            BeanUtils.copyProperties(detailView, outBean);

            final SystemNameBean systemNameBean = bukkenInfoService.getSystemName(detailView.getBrInsPg(), detailView.getBskInsPg(), detailView.getBrUpdPg(), detailView.getBskUpdPg(), formatTypeCdList.contains(detailView.getFormatTypeCd()), detailView.getRendoName());

            detailView.setSystemName(systemNameBean.getSystemName());
            detailView.setCategoryName(systemNameBean.getCategoryName());

            detailView.setIsNyukoSystem(bukkenInfoService.isNyukoSystem(detailView.getBrInsPg(), detailView.getBskInsPg(), detailView.getBrUpdPg(), detailView.getBskUpdPg()));

            //カテゴリー毎の写真枚数検索
            final List<String> imgCategoryCntList = new ArrayList<String>();
            if(StringUtils.isNotEmpty(detailView.getPkBukkenRireki())){
            	final ImgCntEachCategoryInServiceBean imgCntBean = new ImgCntEachCategoryInServiceBean();
            	imgCntBean.setPkBukkenRireki(detailView.getPkBukkenRireki());
            	final List<ImgCntEachCategory> imgCntFileNmNotEmptyList = service.selectImgCntEachCategory(imgCntBean);

            	for(final ImgCntEachCategory data: imgCntFileNmNotEmptyList){
            		imgCategoryCntList.add(data.getKeisaiCnt() + "/" + data.getAllCnt());
            	}
            }else{
            	for(int j = 0; j < imgCategoryNameList.size(); j++){
            		imgCategoryCntList.add("0/0");
            	}
            }
            detailView.setImgCategoryCntList(imgCategoryCntList);

            detailList.add(detailView);
        }
        view.setDetailList(detailList);

        //CSVダウンロードテーブル
        final Map<String, String> tableMap = new LinkedHashMap<String, String>();

        final String[] names = SystemProperties.getProperties("CSV_DOWNLOAD_TABLE_JPN_NAME");
        final String[] values = SystemProperties.getProperties("CSV_DOWNLOAD_TABLE_VALUE");

        for (int i = 0; i < values.length; i++) {
        	tableMap.put(values[i], names[i]);
        }
        view.setTableMap(tableMap);

        context.setForward("success",view);
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        // 権限チェック
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return (auth.authenticate(userId, AuthorityId.SHOP_BUKKEN)
                || auth.authenticate(userId, AuthorityId.REVIEW));
    }

}
