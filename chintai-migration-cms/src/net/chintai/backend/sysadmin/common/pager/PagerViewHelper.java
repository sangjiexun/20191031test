/*
 * $Id: PagerViewHelper.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/07/17  BGT)児島     新規作成
 * 2007/08/13  BGT)児島     C_DEFAULT_DISPLAY_PAGE_MAX の定義を
 *                          SystemProperties クラスに移動
 */
package net.chintai.backend.sysadmin.common.pager;

import net.chintai.backend.sysadmin.common.ViewHelper;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;

/**
 * Pager 表示用のビューヘルパです。<br>
 * 一覧ページ、検索結果ページなどで共通的に使用される<br>
 * ページング用の情報を処理します。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PagerViewHelper implements PagerCondition, ViewHelper {

    /** ページング条件オブジェクト */
    private final PagerCondition condition;

    /** 画面上でのページ番号の最大表示件数 */
    private final int displayPageMax;

    /**
     * ページ番号の最大表示件数を指定せずに PagerViewHelper を初期化します。<br>
     * ページ番号の最大表示件数は、デフォルト値で初期化されます。
     * @param condition
     */
    public PagerViewHelper(PagerCondition condition) {
        this(condition, new Integer(SystemProperties
                .getProperty("C_DEFAULT_DISPLAY_PAGE_MAX")));
    }

    /**
     * ページ番号の最大表示件数を指定して PagerViewHelper を初期化します。
     * @param condition ページング条件オブジェクト
     * @param displayPageMax ページ番号の最大表示件数
     */
    public PagerViewHelper(PagerCondition condition, int displayPageMax) {
        this.condition = condition;
        this.displayPageMax = displayPageMax;
    }

    /**
     * 検索結果の総件数を取得します。
     * @return 検索結果総件数
     */
    public int getCount() {
        return condition.getCount();
    }

    /**
     * 検索結果の総件数を設定します。
     * @param count 検索結果総件数
     */
    public void setCount(int count) {
        condition.setCount(count);
    }

    /**
     * 検索結果から一度に取得する最大件数を取得します。
     * @return 一度に取得する最大件数
     */
    public int getLimit() {
        return condition.getLimit();
    }

    /**
     * 検索結果から一度に取得する最大件数を設定します。
     * @param limit 一度に取得する最大件数
     */
    public void setLimit(int limit) {
        condition.setLimit(limit);
    }

    /**
     * 検索結果の取得開始位置を取得します。
     * @return 取得開始位置
     */
    public int getOffset() {
        return condition.getOffset();
    }

    /**
     * 検索結果の取得開始位置を設定します。
     * @param offset 取得開始位置
     */
    public void setOffset(int offset) {
        condition.setOffset(offset);
    }

    /**
     * 「次へ」リンクが表示できるかどうかを判定します。<br>
     * 表示できる場合は true を返します。
     * @return 表示できる場合 true, 表示できない場合 false
     */
    public boolean isNext() {
        return PagerUtil.hasNext(condition);
    }

    /**
     * 「前へ」リンクが表示できるかどうかを判定します。<br>
     * 表示できる場合は true を返します。
     * @return 表示できる場合 true, 表示できない場合 false
     */
    public boolean isPrev() {
        return PagerUtil.hasPrev(condition);
    }

    /**
     * 現在表示中の一覧の最後の offset を取得します。
     * @return offset の値
     */
    public int getCurrentLastOffset() {
        return PagerUtil.getCurrentLastOffset(condition);
    }

    /**
     * 「次へ」リンクの offset を返します。
     * @return offset の値
     */
    public int getNextOffset() {
        return PagerUtil.getNextOffset(condition);
    }

    /**
     * 「前へ」リンクの offset を返します。
     * @return offset の値
     */
    public int getPrevOffset() {
        return PagerUtil.getPrevOffset(condition);
    }

    /**
     * 現在ページのインデックスを返します。
     * @return ページインデックス
     */
    public int getCurrentPageIndex() {
        return PagerUtil.getCurrentPageIndex(condition);
    }

    /**
     * 現在ページのカウント (インデックス+1) を返します。
     * @return ページカウント (インデックス+1)
     */
    public int getCurrentPageCount() {
        return PagerUtil.getCurrentPageCount(condition);
    }

    /**
     * 最終ページのインデックスを返します。
     * @return ページインデックス
     */
    public int getLastPageIndex() {
        return PagerUtil.getLastPageIndex(condition);
    }

    /**
     * ページリンクの表示上限を元に、ページ番号リンクの表示開始位置を返します。
     * @return ページ番号リンク (先頭)
     */
    public int getDisplayPageIndexBegin() {
        return PagerUtil.getDisplayPageIndexBegin(condition, displayPageMax);
    }

    /**
     * ページリンクの表示上限を元に、ページ番号リンクの表示終了位置を返します。
     * @return ページ番号リンク (末尾)
     */
    public int getDisplayPageIndexEnd() {
        return PagerUtil.getDisplayPageIndexEnd(condition, displayPageMax);
    }
}
