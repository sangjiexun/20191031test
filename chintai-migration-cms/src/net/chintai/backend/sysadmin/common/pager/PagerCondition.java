/*
 * $Id: PagerCondition.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/07/17  BGT)児島   新規作成
 * 
 */
package net.chintai.backend.sysadmin.common.pager;

/**
 * ページング条件を取り扱うインターフェースです。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface PagerCondition {

    /** 一度に取得する件数が無制限であることを示すフラグ */
    public static final int C_UNLIMITED = -1;

    /**
     * 検索結果の総件数を取得します。
     * @return 検索結果総件数
     */
    public int getCount();

    /**
     * 検索結果の総件数を設定します。
     * @param count 検索結果総件数
     */
    public void setCount(int count);

    /**
     * 検索結果から一度に取得する最大件数を取得します。
     * @return 一度に取得する最大件数
     */
    public int getLimit();

    /**
     * 検索結果から一度に取得する最大件数を設定します。
     * @param limit 一度に取得する最大件数
     */
    public void setLimit(int limit);

    /**
     * 検索結果の取得開始位置を取得します。
     * @return 取得開始位置
     */
    public int getOffset();

    /**
     * 検索結果の取得開始位置を設定します。
     * @param offset 取得開始位置
     */
    public void setOffset(int offset);

}
