/*
 * $Id: BasePagerCondition.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/07/18  BGT)児島   新規作成
 * 
 */
package net.chintai.backend.sysadmin.common.pager;

/**
 * ページング条件実装クラスの基底クラスです。<br>
 * 他のすべてのページング実装クラスは、このクラスを継承します。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BasePagerCondition implements PagerCondition {

    /** 総件数 */
    private int count;

    /** 一度に取得する最大件数 */
    private int limit = C_UNLIMITED;

    /** 現在位置 */
    private int offset;

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.PagerCondition#getCount()
     */
    public int getCount() {
        return count;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.PagerCondition#getLimit()
     */
    public int getLimit() {
        return limit;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.PagerCondition#getOffset()
     */
    public int getOffset() {
        return offset;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.PagerCondition#setCount(int)
     */
    public void setCount(int count) {
        this.count = count;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.PagerCondition#setLimit(int)
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.PagerCondition#setOffset(int)
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }
}
