/*
 * $Id: MatchingDataDownloadServiceImpl.java 4441 2010-01-26 07:11:52Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/27     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.service.impl;

import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.addata_matching.dao.MatchingDataDownloadDao;
import net.chintai.backend.sysadmin.addata_matching.dao.MatchingDataDownloadParamBean;
import net.chintai.backend.sysadmin.addata_matching.domain.MatchingDataDownloadDomain;
import net.chintai.backend.sysadmin.addata_matching.service.MatchingDataDownloadService;
import net.chintai.backend.sysadmin.addata_matching.service.bean.MatchingDataDownloadInServiceBean;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import net.chintai.backend.sysadmin.addata_matching.service.bean.MatchingDataDownloadOutServiceBean;

/**
 * MatchingDataDownloadServiceの実装クラス
 * @author e-ishii
 * @version $Revision: 4441 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MatchingDataDownloadServiceImpl implements MatchingDataDownloadService {

    /** DAO */
    MatchingDataDownloadDao matchingDataDao;

    /**
     * コンストラクタ
     * @param dao DBオブジェクト
     */
    public void setMatchingDataDownloadDao(MatchingDataDownloadDao dao) {
        matchingDataDao = dao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.addata_matching.
     * service.MatchingDataDownloadService#matchingDataCsvDownload
     * (net.chintai.backend.sysadmin.addata_matching.service.bean.MatchingDataDownloadInServiceBean)
     */
    public List<MatchingDataDownloadOutServiceBean> matchingDataCsvDownload(
            MatchingDataDownloadInServiceBean paramBean) throws ApplicationException {

        // パラメータの設定
        MatchingDataDownloadParamBean param = new MatchingDataDownloadParamBean();
        param.setTaisyoYm(paramBean.getTaisyoYm());

        // マッチング結果
        List<MatchingDataDownloadDomain> domainList =
                (List<MatchingDataDownloadDomain>) matchingDataDao.selectMatchingDataToCsv(param);

        List<MatchingDataDownloadOutServiceBean> outList =
                new ArrayList<MatchingDataDownloadOutServiceBean>();

        if (domainList == null) {
            throw new ApplicationException("WARN.M.ADDATA_MATCHING.0004");
        }

        BigDecimal chinryoSum = new BigDecimal("0"); // 広告料

        for (MatchingDataDownloadDomain matchingData : domainList) {

            MatchingDataDownloadOutServiceBean outBean = new MatchingDataDownloadOutServiceBean();

            BeanUtilsWrapper.copyProperties(outBean, matchingData);

            // 最終家賃がnullで無い場合
            if (StringUtils.isNotEmpty(matchingData.getLastChinryo())) {

                // AD家賃（CSV）が空で無い場合
                if (StringUtils.isNotEmpty(matchingData.getChinryo())) {

                    String chinryo = matchingData.getChinryo().replace(",", "");
                    String lastChinryo = matchingData.getLastChinryo();

                    // AD家賃（CSV）と最終家賃が一致しない場合●をセットする。
                    if (!StringUtils.equals(chinryo, lastChinryo)) {
                        outBean.setUnMatchiFlg(SystemProperties
                                .getProperty("AdDataMatching.UmMatchFlg"));
                    }
                }
                else {
                    outBean.setUnMatchiFlg(SystemProperties
                            .getProperty("AdDataMatching.UmMatchFlg"));
                }
            }
            //最終家賃が空の場合、12行目の家賃を最終家賃とする。
            //13行目の取引台帳作成日を、最終発信日とする。
            else {
                outBean.setLastChinryo(matchingData.getChinryo());
                outBean.setLastHassinDate(matchingData.getTorihikiSakuseiDate());
            }

            // 広告料にプラスする。
            if(StringUtils.isNotEmpty(outBean.getLastChinryo())) {
                BigDecimal chinryoBigDecimal = new BigDecimal(outBean.getLastChinryo());
                chinryoSum = chinryoSum.add(chinryoBigDecimal);
            }

            /*
            //2010/01/25 キャンペーン情報を追加
            if(StringUtils.equals(matchingData.getOpenFlg(), "1")) {
                outBean.setCampaignNameSimple(matchingData.getCampaignNameSimple());
            } else {
                outBean.setCampaignNameSimple(null);
            }
            */
            outBean.setCampaignNameSimple(null);

            outList.add(outBean);
        }
        // 広告料の算出
        // (マッチングした物件の家賃額合計×0.525) + (マッチングしなかった物件の家賃額合計)
        // +（物件数 × 18900）
        BigDecimal cluc = new BigDecimal(SystemProperties.getProperty("AdDataMatching.Calc1"));
        BigDecimal chinryoSumKakeruCluc = chinryoSum.multiply(cluc); //掛け算

        BigDecimal cluc1 = new BigDecimal(domainList.size());
        BigDecimal cluc2 = new BigDecimal(SystemProperties.getProperty("AdDataMatching.Calc2"));
        BigDecimal cluc1KakeruCluc2 = cluc1.multiply(cluc2);

        String result = (chinryoSumKakeruCluc.add(cluc1KakeruCluc2)).toString(); //足し算

        if (StringUtils.isNotEmpty(result)) {
            int num = result.indexOf(".");
            result = result.substring(0, num);
        }

        MatchingDataDownloadOutServiceBean outBeanSum = new MatchingDataDownloadOutServiceBean();

        outBeanSum.setKoukokuSum(result);
        // リストの最終行に、広告料をセットする。
        outList.add(outBeanSum);
        return outList;
    }

}
