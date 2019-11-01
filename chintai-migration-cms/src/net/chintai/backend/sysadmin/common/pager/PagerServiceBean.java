/*
 * $Id: PagerServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/07/27  BGT)劉俊秀   新規作成
 * 2007/08/03  BGT)児島     コメント、フォーマット修正
 */
package net.chintai.backend.sysadmin.common.pager;

/**
 * ページング条件を考慮した ServiceBean です。<br>
 * ページング条件を必要とする ServiceBean は、このクラスを継承します。
 * 
 * @author yoo-junsu
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PagerServiceBean implements PagerCondition {

    /** 一度に取得する件数が無制限であることを示すフラグ */
    public static final int C_UNLIMITED = -1;

    /** ページング条件オブジェクト */
    private PagerCondition condition;

    /**
     * コンストラクタ
     */
    public PagerServiceBean() {
    }

    /**
     * コンストラクタ
     * @param condition ページング条件オブジェクト
     */
    public PagerServiceBean(PagerCondition condition) {
        this.condition = condition;
    }

    /**
     * 検索結果の総件数を取得します。
     * @return 検索結果総件数
     */
    public int getCount() {
        return this.condition.getCount();
    }

    /**
     * 検索結果の総件数を設定します。
     * @param count 検索結果総件数
     */
    public void setCount(int count) {
        this.condition.setCount(count);
    }

    /**
     * 検索結果から一度に取得する最大件数を取得します。
     * @return 一度に取得する最大件数
     */
    public int getLimit() {
        return this.condition.getLimit();
    }

    /**
     * 検索結果から一度に取得する最大件数を設定します。
     * @param limit 一度に取得する最大件数
     */
    public void setLimit(int limit) {
        this.condition.setLimit(limit);
    }

    /**
     * 検索結果の取得開始位置を取得します。
     * @return 取得開始位置
     */
    public int getOffset() {
        return this.condition.getOffset();
    }

    /**
     * 検索結果の取得開始位置を設定します。
     * @param offset 取得開始位置
     */
    public void setOffset(int offset) {
        this.condition.setOffset(offset);
    }
}
