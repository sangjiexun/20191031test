/*
 * $Id: MailMagazineSearchForCsvServiceImpl.java 3705 2007-12-26 05:39:16Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.master.dao.MailMagazineSearchForCsvDao;
import net.chintai.backend.sysadmin.master.domain.MagazineMailDomain;
import net.chintai.backend.sysadmin.master.service.MailMagazineSearchForCsvService;
import net.chintai.backend.sysadmin.master.service.bean.MailMagazineSearchForCsvOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * MailMagazineSearchForCsvServiceの実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3705 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MailMagazineSearchForCsvServiceImpl implements MailMagazineSearchForCsvService {

    /** メールマガジン用メールアドレスを検索するDAO */
    private MailMagazineSearchForCsvDao mailMagazineSearchForCsvDao = null;

    /**
     * mailMagazineSearchForCsvDaoを設定する
     * @param mailMagazineSearchForCsvDao
     */
    public void setMailMagazineSearchForCsvDao(MailMagazineSearchForCsvDao mailMagazineSearchForCsvDao) {
        this.mailMagazineSearchForCsvDao = mailMagazineSearchForCsvDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.MailMagazineSearchForCsvService#mailMagazineSearchForCsv()
     */
    public List<MailMagazineSearchForCsvOutServiceBean> mailMagazineSearchForCsv() throws Exception {

        // メールマガジン用メールアドレスを検索
        List rsList = mailMagazineSearchForCsvDao.selectMagazineMailForCsv();
        List<MailMagazineSearchForCsvOutServiceBean> mailMagazineList =
                new ArrayList<MailMagazineSearchForCsvOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            MagazineMailDomain magazineMailInfo = (MagazineMailDomain) rsList.get(i);

            MailMagazineSearchForCsvOutServiceBean mailMagazineSearchForCsvOutServiceBean =
                    new MailMagazineSearchForCsvOutServiceBean();
            BeanUtils.copyProperties(mailMagazineSearchForCsvOutServiceBean, magazineMailInfo);

            mailMagazineList.add(mailMagazineSearchForCsvOutServiceBean);
        }

        return mailMagazineList;

    }

}
