package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDeleteCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDeleteCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountDeleteCommitService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountDeleteCommitInServiceBean;
import net.chintai.batch.common.domain.ShopKanri;
import net.chintai.batch.common.persistence.mapper.ShopKanriMapper;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * ContractAmountDeleteCommitServiceの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountDeleteCommitServiceImpl implements
        ContractAmountDeleteCommitService {

    /** 契約明細詳細(契約数量あり)設定情報削除DAO */
    ContractAmountDeleteCommitDao contractAmountDeleteCommitDao;


    // 排他制御用処理追加
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopKanriMapper shopKanrilMapper;

    // 排他制御用処理追加

    /**
     * 契約明細詳細(契約数量あり)設定情報削除DAOを設定します。
     * @param contractAmountDeleteCommitDao 契約明細詳細(契約数量あり)設定情報削除DAO
     */
    public void setContractAmountDeleteCommitDao(
            ContractAmountDeleteCommitDao contractAmountDeleteCommitDao) {
        this.contractAmountDeleteCommitDao = contractAmountDeleteCommitDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ContractAmountDeleteCommitService#deleteWakuInfo(net.chintai.backend.sysadmin.shop_bukken.service.bean.ContractAmountDeleteCommitInServiceBean)
     */
    public void deleteWakuInfo(ContractAmountDeleteCommitInServiceBean inBean)
            throws ApplicationException {

        ContractAmountDeleteCommitParamBean paramBean =
                new ContractAmountDeleteCommitParamBean();
        String[] delFlgList = inBean.getDelFlgList();


        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
            Date startDate = sdf.parse(inBean.getShopKanriUpdDt());

            shopService.checkAndLockShopKanri(inBean.getShopCd(),startDate);
        } catch (InProcessingException e) {
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0015", e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        for (int i = 0; i < delFlgList.length; i++) {
            paramBean.setDelFlg(delFlgList[i]);
            paramBean.setShopCd(inBean.getShopCd());
            paramBean.setKeiyakuCd(inBean.getKeiyakuCd());
            paramBean.setKeiyakuSubCd(inBean.getKeiyakuSubCd());

            int deleteCnt = contractAmountDeleteCommitDao.deleteWakuInfo(paramBean);

            if (deleteCnt == 0) {
                throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0015");
            }
        }

        ShopKanri shopKanri = shopService.selectShopKanriByPrimaryKey(inBean.getShopCd());
        shopKanri.setAdminUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdDt(new Timestamp(System.currentTimeMillis()));
        shopKanri.setUpdId(inBean.getUpdId());
        shopKanri.setUpdPg(inBean.getUpdPg());

        shopKanrilMapper.updateByPrimaryKey(shopKanri);
    }
}
