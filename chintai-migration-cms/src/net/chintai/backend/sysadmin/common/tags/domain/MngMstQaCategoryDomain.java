/*
 * $Id: MngMstQaCategoryDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/02     BGT)劉俊秀       新規作成
 *
 */
package net.chintai.backend.sysadmin.common.tags.domain;

/**
 * Q&Aカテゴリカスタムタグ用
 * @author yoo-junsu
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MngMstQaCategoryDomain {

    /** Q&AカテゴリID（大分類+小分類) */
    private String categoryId = null;

    /** Q&AカテゴリID（大分類） */
    private String categoryId1 = null;

    /** Q&AカテゴリID（小分類） */
    private String categoryId2 = null;

    /** カテゴリ名 */
    private String categoryName = null;

    /**
     * Q&AカテゴリID（大分類+小分類)を取得します。
     * @return Q&AカテゴリID（大分類+小分類)
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * Q&AカテゴリID（大分類+小分類)を設定します。
     * @param categoryId Q&AカテゴリID（大分類+小分類)
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Q&AカテゴリID（大分類）を取得します。
     * @return Q&AカテゴリID（大分類）
     */
    public String getCategoryId1() {
        return categoryId1;
    }

    /**
     * Q&AカテゴリID（大分類）を設定します。
     * @param categoryId1 Q&AカテゴリID（大分類）
     */
    public void setCategoryId1(String categoryId1) {
        this.categoryId1 = categoryId1;
    }

    /**
     * Q&AカテゴリID（小分類）を取得します。
     * @return Q&AカテゴリID（小分類）
     */
    public String getCategoryId2() {
        return categoryId2;
    }

    /**
     * Q&AカテゴリID（小分類）を設定します。
     * @param categoryId2 Q&AカテゴリID（小分類）
     */
    public void setCategoryId2(String categoryId2) {
        this.categoryId2 = categoryId2;
    }

    /**
     * カテゴリ名を取得します。
     * @return カテゴリ名
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * カテゴリ名を設定します。
     * @param categoryName カテゴリ名
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
