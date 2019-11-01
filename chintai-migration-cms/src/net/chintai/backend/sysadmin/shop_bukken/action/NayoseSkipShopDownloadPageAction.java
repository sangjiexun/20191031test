/*
 * $Id: NayoseSkipShopDownloadPageAction.java 4567 2013-01-28 04:43:59Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/24     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;


import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.NayoseSkipShopView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.NayoseSkipShopView.NayoseSkipShopInner;
import net.chintai.backend.sysadmin.shop_bukken.service.NayoseSkipShopService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.NayoseSkipShopSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.NayoseSkipShopSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;


/**
 * 名寄せ処理対象外店舗一覧画面表示アクション
 * @author e-ishii
 * @version $Revision: 4567 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class NayoseSkipShopDownloadPageAction extends BaseActionSupport {


    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.
     * BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        NayoseSkipShopSearchInServiceBean inBean = new NayoseSkipShopSearchInServiceBean();
        BeanUtils.copyProperties(inBean, form);


        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.valueOf(SystemProperties.getProperty("C_NAYOSE_SKIP_SHOP_DOWNLOAD_LIMIT")));

        condition.setOffset(inBean.getOffSet());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        NayoseSkipShopService nayoseSkipShopServiceImpl = (NayoseSkipShopService) ac.getBean("nayoseSkipShopService");

        List<NayoseSkipShopSearchOutServiceBean> outBeanList = nayoseSkipShopServiceImpl.selectNayoseSkipShop(condition);

        NayoseSkipShopView view = new NayoseSkipShopView(condition);
        List<NayoseSkipShopInner> nayoseSkipShopList = new ArrayList<NayoseSkipShopInner>();


        if (CollectionUtils.isEmpty(outBeanList)) {
            context.setError("WARN.M.NAYOSESKIPDOWNLOAD.0001","表示するデータ");
        } else {

            for (NayoseSkipShopSearchOutServiceBean outBean :outBeanList) {

                NayoseSkipShopInner inner = view.new NayoseSkipShopInner();
                BeanUtils.copyProperties(inner, outBean);

                nayoseSkipShopList.add(inner);

            }
        }
        view.setNayoseSkipShopList(nayoseSkipShopList);

        context.setForward("success", view);

    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.
     * BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

}
