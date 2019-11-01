/*
 * $Id: ReviewConfigAction.java 3909 2008-05-27 06:14:27Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 * 2008/05/27  BGT)李昊燮     setLowHighメッソドの改修
 */
package net.chintai.backend.sysadmin.review.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.review.action.view.ReviewConfigView;
import net.chintai.backend.sysadmin.review.action.view.ReviewConfigView.AutoDelDetailView;
import net.chintai.backend.sysadmin.review.action.view.ReviewConfigView.MadoriDetailView;
import net.chintai.backend.sysadmin.review.action.view.ReviewConfigView.PrefDetailView;
import net.chintai.backend.sysadmin.review.action.view.ReviewConfigView.ShinsaDatailView;
import net.chintai.backend.sysadmin.review.service.ReviewConfigService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigOutServiceBean.AutoDelDetailBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigOutServiceBean.MadoriDetailBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigOutServiceBean.PrefDetailBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewConfigOutServiceBean.ShinsaDatailBean;

/**
 * 審査設定内容表示アクション
 * @author Lee Hosup
 * @version $Revision: 3909 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewConfigAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.REVIEW);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        ReviewConfigService service = (ReviewConfigService) ac
                .getBean("reviewConfigService");

        ReviewConfigView view = new ReviewConfigView();

        // 審査設定内容情報を取得、ViewHelperにコピー
        List<ShinsaDatailBean> shinsaBeanList = service.getReviewConfigInfo();
        if (shinsaBeanList != null && shinsaBeanList.size() > 0) {
            List<ShinsaDatailView> shinsaViewList = new ArrayList<ShinsaDatailView>();

            // 審査設定名称別にbeanを編集するための変数
            String shinsaName = shinsaBeanList.get(0).getShinsaName();
            String jouken = this.setLowHigh(shinsaBeanList.get(0).getJouken(),
                    shinsaBeanList.get(0).getJoukenFlg());
            String jogai = this.setLowHigh(shinsaBeanList.get(0).getJogai(),
                    shinsaBeanList.get(0).getJogaiFlg());

            for (int i = 1; i < shinsaBeanList.size(); i++) {
                ShinsaDatailBean shinsaBean = shinsaBeanList.get(i);
                if (shinsaName.equals(shinsaBean.getShinsaName())) {

                    if (!(shinsaBean.getJouken().equals(shinsaBeanList.get(
                            i - 1).getJouken()))) {
                        jouken = jouken
                                + "<br>"
                                + this.setLowHigh(shinsaBean.getJouken(),
                                        shinsaBean.getJoukenFlg());
                    }

                    if (shinsaBean.getJogai() != null) {
                        jogai = jogai
                                + "<br>"
                                + this.setLowHigh(shinsaBean.getJogai(),
                                        shinsaBean.getJogaiFlg());
                    }

                } else {
                    ShinsaDatailView shinsaView = view.new ShinsaDatailView();
                    shinsaView.setShinsaName(shinsaName);
                    shinsaView.setJouken(jouken);
                    shinsaView.setJogai(jogai);

                    shinsaViewList.add(shinsaView);

                    shinsaName = shinsaBeanList.get(i).getShinsaName();
                    jouken = this.setLowHigh(shinsaBean.getJouken(), shinsaBean
                            .getJoukenFlg());
                    jogai = this.setLowHigh(shinsaBean.getJogai(), shinsaBean
                            .getJogaiFlg());
                }
            }
            ShinsaDatailView shinsaView = view.new ShinsaDatailView();
            shinsaView.setShinsaName(shinsaName);
            shinsaView.setJouken(jouken);
            shinsaView.setJogai(jogai);

            shinsaViewList.add(shinsaView);

            view.setShinsaDetailList(shinsaViewList);
        }

        // 間取りタイプ設定内容情報を取得、ViewHelperにコピー
        List<MadoriDetailBean> madoriBeanList = service.getMadoriConfigInfo();


        if (madoriBeanList != null && madoriBeanList.size() > 0) {
            List<MadoriDetailView> madoriViewList = new ArrayList<MadoriDetailView>();
            String type = madoriBeanList.get(0).getMadoriTypeName();
            String madori = madoriBeanList.get(0).getMadori();
            for (int i = 1; i < madoriBeanList.size(); i++) {
                if (type.equals(madoriBeanList.get(i).getMadoriTypeName())) {
                    madori = madori + "/" + madoriBeanList.get(i).getMadori();
                }
                if (!(type.equals(madoriBeanList.get(i).getMadoriTypeName()))
                        || i + 1 == madoriBeanList.size()) {
                    MadoriDetailView madoriView = view.new MadoriDetailView();
                    madoriView.setMadoriTypeName(type);
                    type = madoriBeanList.get(i).getMadoriTypeName();
                    madoriView.setMadori(madori);
                    madori = madoriBeanList.get(i).getMadori();
                    madoriView.setMinBukkenCnt(madoriBeanList.get(i-1).getMinBukkenCnt());
                    madoriView.setMinChinryo(madoriBeanList.get(i-1).getMinChinryo());
                    madoriView.setMaxChinryo(madoriBeanList.get(i-1).getMaxChinryo());
                    madoriViewList.add(madoriView);
                }

                if ((i + 1 == madoriBeanList.size()) && !(madoriBeanList.get(i-1).getMadoriTypeName().equals(madoriBeanList.get(i).getMadoriTypeName()))) {
                	MadoriDetailView madoriView = view.new MadoriDetailView();
                    madoriView.setMadoriTypeName(type);
                    madoriView.setMadori(madori);
                    madoriView.setMinBukkenCnt(madoriBeanList.get(i).getMinBukkenCnt());
                    madoriView.setMinChinryo(madoriBeanList.get(i).getMinChinryo());
                    madoriView.setMaxChinryo(madoriBeanList.get(i).getMaxChinryo());
                    madoriViewList.add(madoriView);
                }

            }
            view.setMadoriDetailList(madoriViewList);
        }

        // 自動削除設定内容情報を取得、ViewHelperにコピー
        List<AutoDelDetailBean> autoDelBeanList = service
                .getAutoDelConfigInfo();
        if (autoDelBeanList != null && autoDelBeanList.size() > 0) {
            List<AutoDelDetailView> autoDelViewList = new ArrayList<AutoDelDetailView>();
            for (int i = 0; i < autoDelBeanList.size(); i++) {
                AutoDelDetailView autoDelView = view.new AutoDelDetailView();
                BeanUtils.copyProperties(autoDelView, autoDelBeanList.get(i));
                autoDelViewList.add(autoDelView);
            }
            view.setAutoDelDetailList(autoDelViewList);
        }

        // 市区町村別比較対象設定内容情報を取得、ViewHelperにコピー
        List<PrefDetailBean> prefBeanList = service.getPrefConfigInfo();
        if (prefBeanList != null && prefBeanList.size() > 0) {
            List<PrefDetailView> prefViewList = new ArrayList<PrefDetailView>();

            for (int i = 0; i < prefBeanList.size(); i++) {
                if (i == 0
                        || !(prefBeanList.get(i - 1).getAreaName()
                                .equals(prefBeanList.get(i).getAreaName()))) {
                    String areaName = prefBeanList.get(i).getAreaName();
                    List<String[]> prefList = new ArrayList<String[]>();

                    for (int j = 0; j < prefBeanList.size(); j++) {
                        if (areaName.equals(prefBeanList.get(j).getAreaName())) {
                            prefList.add(new String[] {
                                    prefBeanList.get(j).getPrefName(),
                                    prefBeanList.get(j).getPrefCd() });
                        }
                    }
                    PrefDetailView prefView = view.new PrefDetailView();
                    prefView.setAreaName(areaName);
                    prefView.setPrefInfoList(prefList);
                    prefViewList.add(prefView);
                }
            }
            view.setPrefDetailList(prefViewList);
        }

        context.setForward("success", view);
    }

    /**
     * 条件フラグを文字列に変換
     * @param name 審査条件
     * @param code 条件フラグ
     * @return
     */
    private String setLowHigh(String name, String code) {

        String returnCode = "";
        if (name == null) {
            name = "";
            return name;
        }

        if (code == null) {
            return name;
        }

        if (code.equals("0")) {
            returnCode = name + "以下";
        } else {
            returnCode = name + "以上";
        }
        return returnCode;
    }

}
