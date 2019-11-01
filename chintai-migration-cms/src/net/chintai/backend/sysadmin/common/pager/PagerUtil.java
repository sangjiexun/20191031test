/*
 * $Id: PagerUtil.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/07/18  BGT)児島   新規作成
 *
 */
package net.chintai.backend.sysadmin.common.pager;

/**
 * ページャユーティリティクラスです。<br>
 * このクラスは状態を保持しないため、<br>
 * 状態を保持するビューヘルパクラスなどから<br>
 * 必要に応じて呼び出される形で利用されます。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class PagerUtil {

    /**
     * 「次へ」リンクが表示できるかどうかを判定します。<br>
     * 表示できる場合は true を返します。
     * @param condition ページング条件
     * @return 表示できる場合 true, 表示できない場合 false
     */
    public static boolean hasNext(PagerCondition condition) {
        boolean next =
                (condition.getCount() > 0 && condition.getOffset() + condition.getLimit() < condition.getCount());
        return next;
    }

    /**
     * 「前へ」リンクが表示できるかどうかを判定します。<br>
     * 表示できる場合は true を返します。
     * @param condition ページング条件
     * @return 表示できる場合 true, 表示できない場合 false
     */
    public static boolean hasPrev(PagerCondition condition) {
        boolean prev = condition.getOffset() > 0;
        return prev;
    }

    /**
     * 現在表示中の一覧の最後の offset を取得します。
     * @param condition ページング条件
     * @return 現在表示中の一覧の最後の offset
     */
    public static int getCurrentLastOffset(PagerCondition condition) {
        int nextOffset = getNextOffset(condition);
        if (nextOffset <= 0 || condition.getCount() <= 0) {
            return 0;
        } else {
            return (nextOffset < condition.getCount()) ? nextOffset - 1 : condition.getCount() - 1;
        }
    }

    /**
     * 「次へ」リンクの offset を返します。
     * @param condition ページング条件
     * @return 「次へ」リンクの offset
     */
    public static int getNextOffset(PagerCondition condition) {
        return condition.getOffset() + condition.getLimit();
    }

    /**
     * 「前へ」リンクの offset を返します。
     * @param condition ページング条件
     * @return 「前へ」リンクの offset
     */
    public static int getPrevOffset(PagerCondition condition) {
        int prevOffset = condition.getOffset() - condition.getLimit();
        return (prevOffset > 0) ? prevOffset : 0;
    }

    /**
     * 現在ページのインデックスを返します。
     * @param condition ページング条件
     * @return 現在ページのインデックス
     */
    public static int getCurrentPageIndex(PagerCondition condition) {
        if (condition.getLimit() == 0) {
            return 1;
        } else {
            return condition.getOffset() / condition.getLimit();
        }
    }

    /**
     * 現在ページのカウント (インデックス+1) を返します。
     * @param condition ページング条件
     * @return 現在ページのカウント
     */
    public static int getCurrentPageCount(PagerCondition condition) {
        return getCurrentPageIndex(condition) + 1;
    }

    /**
     * 最終ページのインデックスを返します。
     * @param condition ページング条件
     * @return 最終ページのインデックス
     */
    public static int getLastPageIndex(PagerCondition condition) {
        if (condition.getLimit() == 0) {
            return 0;
        } else {
            return (condition.getCount() - 1) / condition.getLimit();
        }
    }

    /**
     * ページリンクの表示上限を元に、ページ番号リンクの表示開始位置を返します。
     * @param condition ページング条件
     * @param displayPageMax 一度に表示する最大件数
     * @return ページ番号リンクの表示開始位置
     */
    public static int getDisplayPageIndexBegin(PagerCondition condition, int displayPageMax) {

        int lastPageIndex = getLastPageIndex(condition);

        /*
         * ページ番号を一度に全部表示できる場合は、全部表示する。
         * 一度に全部表示できない場合は、現在ページが真ん中に来るよう
         * ページ番号リンクの開始位置 (=左端に来るページ番号) を調整する。
         */
        if (lastPageIndex < displayPageMax) {
            return 0;
        } else {
            int currentPageIndex = getCurrentPageIndex(condition);
            int displayPageIndexBegin = currentPageIndex - ((int) Math.floor(displayPageMax / 2.0));
            if(lastPageIndex - currentPageIndex < ((int) Math.floor(displayPageMax / 2.0))){
            	displayPageIndexBegin = lastPageIndex - displayPageMax + 1;
            }else{
            	displayPageIndexBegin = currentPageIndex - ((int) Math.floor(displayPageMax / 2.0));
            }
            return (displayPageIndexBegin < 0) ? 0 : displayPageIndexBegin;
        }
    }

    /**
     * ページリンクの表示上限を元に、ページ番号リンクの表示終了位置を返します。
     * @param condition ページング条件
     * @param displayPageMax 一度に表示する最大件数
     * @return ページ番号リンクの表示終了位置
     */
    public static int getDisplayPageIndexEnd(PagerCondition condition, int displayPageMax) {

        int lastPageIndex = getLastPageIndex(condition);
        int displayPageIndexBegin = getDisplayPageIndexBegin(condition, displayPageMax);

        /*
         * ページ番号リンクの表示終了位置を調整する。
         * 最後まで表示できるのであれば、"表示終了位置 == 最終ページインデックス" となる。
         * 表示できなければ、最大表示件数分までで打ち切りとなる。
         */
        int displayPageRange = lastPageIndex - displayPageIndexBegin;
        if (displayPageRange < displayPageMax) {
            return lastPageIndex;
        } else {
            return displayPageIndexBegin + displayPageMax - 1;
        }
    }
}
