/*
 * $Id: ShikutyosonPostSearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.master.dao.ShikutyosonPostSearchDao;
import net.chintai.backend.sysadmin.master.dao.ShikutyosonSearchParamBean;
import net.chintai.backend.sysadmin.master.domain.ShikutyosonSearchInfo;
import net.chintai.backend.sysadmin.master.service.ShikutyosonPostSearchService;
import net.chintai.backend.sysadmin.master.service.bean.ShikutyosonPostSearchInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.ShikutyosonPostSearchOutServiceBean;

/**
 * ShikutyosonPostSearchServiceの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonPostSearchServiceImpl implements ShikutyosonPostSearchService {

    
    /** 市区町村郵便番号から検索DAOを宣言 */
    private ShikutyosonPostSearchDao shikutyosonPostSearchDao;

    /**
     * 市区町村郵便番号から検索DAOを設定
     * 
     * @param shikutyosonPostSearchDao
     */
    public void setShikutyosonPostSearchDao(ShikutyosonPostSearchDao shikutyosonPostSearchDao) {
        this.shikutyosonPostSearchDao = shikutyosonPostSearchDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.ShikutyosonPostSearchService#selectShikutyosonList(net.chintai.backend.sysadmin.master.service.bean.ShikutyosonPostSearchOutServiceBean)
     */
    public List<ShikutyosonPostSearchOutServiceBean> selectShikutyosonListByPost(
            ShikutyosonPostSearchInServiceBean inServiceBean) throws ApplicationException {

        ShikutyosonSearchParamBean param = new ShikutyosonSearchParamBean();

        try {
            
            //パラメータBEANに検索条件コピー
            BeanUtils.copyProperties(param, inServiceBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        //検索結果リスト取得
        List<ShikutyosonSearchInfo> infoList =
                shikutyosonPostSearchDao.selectShikutyosonListByZipcode(param);
        List<ShikutyosonPostSearchOutServiceBean> outList =
                new ArrayList<ShikutyosonPostSearchOutServiceBean>();

        //OutServiceBeanにDomainの結果をコピー
        if (infoList != null) {

            for (int i = 0; i < infoList.size(); i++) {
                ShikutyosonPostSearchOutServiceBean outServiceBean =
                        new ShikutyosonPostSearchOutServiceBean();
                try {
                    BeanUtils.copyProperties(outServiceBean, infoList.get(i));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                outList.add(outServiceBean);
            }
        }

        return outList;
    }

}
