/*
 * $Id: ShikutyosonAddressSearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/12  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.master.dao.ShikutyosonAddressSearchDao;
import net.chintai.backend.sysadmin.master.dao.ShikutyosonSearchParamBean;
import net.chintai.backend.sysadmin.master.domain.ShikutyosonSearchInfo;
import net.chintai.backend.sysadmin.master.service.ShikutyosonAddressSearchService;
import net.chintai.backend.sysadmin.master.service.bean.ShikutyosonAddressSearchInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.ShikutyosonAddressSearchOutServiceBean;

/**
 * ShikutyosonAddressSearchServiceの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonAddressSearchServiceImpl implements ShikutyosonAddressSearchService {

    /** 市区町村住所から検索結果取得DAO */
    private ShikutyosonAddressSearchDao shikutyosonAddressSearchDao;

    /**
     * 市区町村住所から検索結果取得DAOを設定します。
     * 
     * @param shikutyosonAddressSearchDao
     */
    public void setShikutyosonAddressSearchDao(
            ShikutyosonAddressSearchDao shikutyosonAddressSearchDao) {
        this.shikutyosonAddressSearchDao = shikutyosonAddressSearchDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.ShikutyosonAddressSearchService#selectShikutyosonListByAddress(net.chintai.backend.sysadmin.master.service.bean.ShikutyosonAddressSearchInServiceBean)
     */
    public List<ShikutyosonAddressSearchOutServiceBean> selectShikutyosonListByAddress(
            ShikutyosonAddressSearchInServiceBean inServiceBean) throws ApplicationException {

        ShikutyosonSearchParamBean param = new ShikutyosonSearchParamBean();

        try {
            BeanUtils.copyProperties(param, inServiceBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        List<ShikutyosonSearchInfo> infoList =
                shikutyosonAddressSearchDao.selectShikutyosonListByAddress(param);
        List<ShikutyosonAddressSearchOutServiceBean> outList =
                new ArrayList<ShikutyosonAddressSearchOutServiceBean>();

        if (infoList.size() > 0) {
            for (int i = 0; i < infoList.size(); i++) {
                ShikutyosonAddressSearchOutServiceBean outBean =
                        new ShikutyosonAddressSearchOutServiceBean();
                try {
                    BeanUtils.copyProperties(outBean, infoList.get(i));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                outList.add(outBean);
            }
        }

        return outList;
    }

}
