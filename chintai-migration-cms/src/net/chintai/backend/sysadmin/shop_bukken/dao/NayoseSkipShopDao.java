package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.List;

import com.ibatis.sqlmap.client.event.RowHandler;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_bukken.domain.NayoseSkipShopDomain;


public interface NayoseSkipShopDao {

    public List<NayoseSkipShopDomain> selectNayoseSkipShop(BasePagerCondition condition);

    public int selectNayoseSkipShopCount();

    public void selectNayoseSkipShopCsv(RowHandler handler);

}
