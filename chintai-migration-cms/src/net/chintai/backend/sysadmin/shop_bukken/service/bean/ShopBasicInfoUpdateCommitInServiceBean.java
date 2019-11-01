/*
 * $Id: ShopBasicInfoUpdateCommitInServiceBean.java 4590 2013-08-02 08:31:23Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 * 2013/08/02  BGT)亀田拓真   店舗電話番号表示変更にて3項目追加
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 店舗基本情報更新InServiceBean
 *
 * @author Lee Hosup
 * @version $Revision: 4590 $ Copyright:
 * (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBasicInfoUpdateCommitInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 店舗名(会社名) */
    private String company;

    /** 店舗名(事務所名) */
    private String bumon;

    /** お客様設定パスワード */
    private String password;

    /** 所属団体名 */
    private String dantai;

    /** 代表者名 */
    private String licTrust;

    /** グループ名 */
    private String groupName;

    /** 郵便番号 */
    private String zipCd;

    /** 住所（都道府県、市区町村） */
    private String address1;

    /** 住所（地先） */
    private String address2;

    /** TEL */
    private String tel;


    // 2013/07/26 店舗電話番号変更対応２次リリース分 ３項目追加
    /** フリーコール用TEL */
    private String shopTelFree;

    /** 電話番号選択 */
    private String shopTelKbn;

    /** 雑誌用TEL */
    private String shopTelMagazine;
    // 2013/7/26 end


    /** FAX */
    private String fax;

    /** エリアコード */
    private String areaCd;

    /** 地域(エリア) */
    private String areaName;

    /** 都道府県コード */
    private String prefCd;

    /** 地域(都道府県) */
    private String prefName;

    /** 市区町村コード */
    private String cityCd;

    /** 地域(市区町村) */
    private String cityName;

    /** 沿線タイプ */
    private String ensenType;

    /** 沿線コード */
    private String ensenCd;

    /** 沿線(沿線) */
    private String ensenName;

    /** 駅名コード */
    private String ekiCd;

    /** 沿線(駅名) */
    private String ekiName;

    /** 免許証番号 */
    private String licNum;

    /** 免許証登録日 */
    private String licEntry;

    /** 免許証有効期限 */
    private String licValid;

    /** 宅建取引主任者名 */
    private String licChief;

    /** 担当者名 */
    private String tantou;

    /** ホームページリンク名称 */
    private String hpName;

    /** 自社ホームページURL */
    private String hpUrl;

    /** メールアドレス */
    private String email;

    /** 連絡方法 */
    private String fmKbn;

    /** 営業時間入力タイプ */
    private String businessHoursType;

    /** 営業時間(自由入力) */
    private String businessHoursCustom;

    /** 営業開始時(プルダウン作用) */
    private String fromHour;

    /** 営業開始分(プルダウン作用) */
    private String fromMin;

    /** 営業終了時(プルダウン作用) */
    private String toHour;

    /** 営業終了分(プルダウン作用) */
    private String toMin;

    /** 定休日入力タイプ */
    private String holidayType;

    /** 定休日(固定) */
    private String holidayOption;

    /** 定休日(自由) */
    private String holidayCustom;

    /** 混雑時間帯 */
    private String busyComment;

    /** 最終更新日時 */
    private String updDt;

    /** 更新者ID */
    private String updId;

    /** 更新プログラム */
    private String updPg;

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd 店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 店舗名(会社名)を取得します。
     * @return 店舗名(会社名)
     */
    public String getCompany() {
        return company;
    }

    /**
     * 店舗名(会社名)を設定します。
     * @param company 店舗名(会社名)
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 店舗名(事務所名)を取得します。
     * @return 店舗名(事務所名)
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 店舗名(事務所名)を設定します。
     * @param bumon 店舗名(事務所名)
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * お客様設定パスワードを取得します。
     * @return お客様設定パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * お客様設定パスワードを設定します。
     * @param password お客様設定パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 所属団体名を取得します。
     * @return 所属団体名
     */
    public String getDantai() {
        return dantai;
    }

    /**
     * 所属団体名を設定します。
     * @param dantai 所属団体名
     */
    public void setDantai(String dantai) {
        this.dantai = dantai;
    }

    /**
     * 代表者名を取得します。
     * @return 代表者名
     */
    public String getLicTrust() {
        return licTrust;
    }

    /**
     * 代表者名を設定します。
     * @param licTrust 代表者名
     */
    public void setLicTrust(String licTrust) {
        this.licTrust = licTrust;
    }

    /**
     * グループ名を取得します。
     * @return グループ名
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * グループ名を設定します。
     * @param groupName グループ名
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 郵便番号を取得します。
     * @return 郵便番号
     */
    public String getZipCd() {
        return zipCd;
    }

    /**
     * 郵便番号を設定します。
     * @param zipCd 郵便番号
     */
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    /**
     * 住所（都道府県、市区町村）を取得します。
     * @return 住所（都道府県、市区町村）
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * 住所（都道府県、市区町村）を設定します。
     * @param address1 住所（都道府県、市区町村）
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * 住所（地先）を取得します。
     * @return 住所（地先）
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * 住所（地先）を設定します。
     * @param address2 住所（地先）
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * TELを取得します。
     * @return TEL
     */
    public String getTel() {
        return tel;
    }

    /**
     * TELを設定します。
     * @param tel TEL
     */
    public void setTel(String tel) {
        this.tel = tel;
    }


    // 2013/07/25 店舗電話番号変更対応２次リリース分 ３項目追加
    /**
     * フリーコール用TELを取得します。
     * @return SHOP_TEL_FREE
     */
    public String getShopTelFree(){
        return shopTelFree;
    }

    /**
     * フリーコール用TELを設定します。
     * @param shopTelFree SHOP_TEL_FREE
     */
    public void setShopTelFree(String shopTelFree){
        this.shopTelFree = shopTelFree;
    }

    /**
     * 電話番号選択を取得します。
     * @return SHOP_TEL_KBN
     */
    public String getShopTelKbn(){
        return shopTelKbn;
    }

    /**
     * 電話番号選択を設定します。
     * @param shopTelKbn SHOP_TEL_KBN
     */
    public void setShopTelKbn(String shopTelKbn){
        this.shopTelKbn = shopTelKbn;
    }

    /**
     * 雑誌用TELを取得します。
     * @return SHOP_TEL_MAGAZINE
     */
    public String getShopTelMagazine(){
        return shopTelMagazine;
    }

    /**
     * 雑誌用TELを設定します。
     * @param shopTelMagazine SHOP_TEL_MAGAZINE
     */
    public void setShopTelMagazine(String shopTelMagazine){
        this.shopTelMagazine = shopTelMagazine;
    }
    // 2013/7/25 end


    /**
     * FAXを取得します。
     * @return FAX
     */
    public String getFax() {
        return fax;
    }

    /**
     * FAXを設定します。
     * @param fax FAX
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * エリアコードを取得します。
     * @return エリアコード
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * エリアコードを設定します。
     * @param areaCd エリアコード
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    /**
     * 地域(エリア)を取得します。
     * @return 地域(エリア)
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 地域(エリア)を設定します。
     * @param areaName 地域(エリア)
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 都道府県コードを取得します。
     * @return 都道府県コード
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県コードを設定します。
     * @param prefCd 都道府県コード
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

    /**
     * 地域(都道府県)を取得します。
     * @return 地域(都道府県)
     */
    public String getPrefName() {
        return prefName;
    }

    /**
     * 地域(都道府県)を設定します。
     * @param prefName 地域(都道府県)
     */
    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }

    /**
     * 市区町村コードを取得します。
     * @return 市区町村コード
     */
    public String getCityCd() {
        return cityCd;
    }

    /**
     * 市区町村コードを設定します。
     * @param cityCd 市区町村コード
     */
    public void setCityCd(String cityCd) {
        this.cityCd = cityCd;
    }

    /**
     * 地域(市区町村)を取得します。
     * @return 地域(市区町村)
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 地域(市区町村)を設定します。
     * @param cityName 地域(市区町村)
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 沿線タイプを取得します。
     * @return 沿線タイプ
     */
    public String getEnsenType() {
        return ensenType;
    }

    /**
     * 沿線タイプを設定します。
     * @param ensenType 沿線タイプ
     */
    public void setEnsenType(String ensenType) {
        this.ensenType = ensenType;
    }

    /**
     * 沿線コードを取得します。
     * @return 沿線コード
     */
    public String getEnsenCd() {
        return ensenCd;
    }

    /**
     * 沿線コードを設定します。
     * @param ensenCd 沿線コード
     */
    public void setEnsenCd(String ensenCd) {
        this.ensenCd = ensenCd;
    }

    /**
     * 沿線(沿線)を取得します。
     * @return 沿線(沿線)
     */
    public String getEnsenName() {
        return ensenName;
    }

    /**
     * 沿線(沿線)を設定します。
     * @param ensenName 沿線(沿線)
     */
    public void setEnsenName(String ensenName) {
        this.ensenName = ensenName;
    }

    /**
     * 駅名コードを取得します。
     * @return 駅名コード
     */
    public String getEkiCd() {
        return ekiCd;
    }

    /**
     * 駅名コードを設定します。
     * @param ekiCd 駅名コード
     */
    public void setEkiCd(String ekiCd) {
        this.ekiCd = ekiCd;
    }

    /**
     * 沿線(駅名)を取得します。
     * @return 沿線(駅名)
     */
    public String getEkiName() {
        return ekiName;
    }

    /**
     * 沿線(駅名)を設定します。
     * @param ekiName 沿線(駅名)
     */
    public void setEkiName(String ekiName) {
        this.ekiName = ekiName;
    }

    /**
     * 免許証番号を取得します。
     * @return 免許証番号
     */
    public String getLicNum() {
        return licNum;
    }

    /**
     * 免許証番号を設定します。
     * @param licNum 免許証番号
     */
    public void setLicNum(String licNum) {
        this.licNum = licNum;
    }

    /**
     * 免許証登録日を取得します。
     * @return 免許証登録日
     */
    public String getLicEntry() {
        return licEntry;
    }

    /**
     * 免許証登録日を設定します。
     * @param licEntry 免許証登録日
     */
    public void setLicEntry(String licEntry) {
        this.licEntry = licEntry;
    }

    /**
     * 免許証有効期限を取得します。
     * @return 免許証有効期限
     */
    public String getLicValid() {
        return licValid;
    }

    /**
     * 免許証有効期限を設定します。
     * @param licValid 免許証有効期限
     */
    public void setLicValid(String licValid) {
        this.licValid = licValid;
    }

    /**
     * 宅建取引主任者名を取得します。
     * @return 宅建取引主任者名
     */
    public String getLicChief() {
        return licChief;
    }

    /**
     * 宅建取引主任者名を設定します。
     * @param licChief 宅建取引主任者名
     */
    public void setLicChief(String licChief) {
        this.licChief = licChief;
    }

    /**
     * 担当者名を取得します。
     * @return 担当者名
     */
    public String getTantou() {
        return tantou;
    }

    /**
     * 担当者名を設定します。
     * @param tantou 担当者名
     */
    public void setTantou(String tantou) {
        this.tantou = tantou;
    }

    /**
     * ホームページリンク名称を取得します。
     * @return ホームページリンク名称
     */
    public String getHpName() {
        return hpName;
    }

    /**
     * ホームページリンク名称を設定します。
     * @param hpName ホームページリンク名称
     */
    public void setHpName(String hpName) {
        this.hpName = hpName;
    }

    /**
     * 自社ホームページURLを取得します。
     * @return 自社ホームページURL
     */
    public String getHpUrl() {
        return hpUrl;
    }

    /**
     * 自社ホームページURLを設定します。
     * @param hpUrl 自社ホームページURL
     */
    public void setHpUrl(String hpUrl) {
        this.hpUrl = hpUrl;
    }

    /**
     * メールアドレスを取得します。
     * @return メールアドレス
     */
    public String getEmail() {
        return email;
    }

    /**
     * メールアドレスを設定します。
     * @param email メールアドレス
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 連絡方法を取得します。
     * @return 連絡方法
     */
    public String getFmKbn() {
        return fmKbn;
    }

    /**
     * 連絡方法を設定します。
     * @param fmKbn 連絡方法
     */
    public void setFmKbn(String fmKbn) {
        this.fmKbn = fmKbn;
    }

    /**
     * 営業時間入力タイプを取得します。
     * @return 営業時間入力タイプ
     */
    public String getBusinessHoursType() {
        return businessHoursType;
    }

    /**
     * 営業時間入力タイプを設定します。
     * @param businessHoursType 営業時間入力タイプ
     */
    public void setBusinessHoursType(String businessHoursType) {
        this.businessHoursType = businessHoursType;
    }

    /**
     * 営業時間(自由入力)を取得します。
     * @return 営業時間(自由入力)
     */
    public String getBusinessHoursCustom() {
        return businessHoursCustom;
    }

    /**
     * 営業時間(自由入力)を設定します。
     * @param businessHoursCustom 営業時間(自由入力)
     */
    public void setBusinessHoursCustom(String businessHoursCustom) {
        this.businessHoursCustom = businessHoursCustom;
    }

    /**
     * 営業開始時(プルダウン作用)を取得します。
     * @return 営業開始時(プルダウン作用)
     */
    public String getFromHour() {
        return fromHour;
    }

    /**
     * 営業開始時(プルダウン作用)を設定します。
     * @param fromHour 営業開始時(プルダウン作用)
     */
    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    /**
     * 営業開始分(プルダウン作用)を取得します。
     * @return 営業開始分(プルダウン作用)
     */
    public String getFromMin() {
        return fromMin;
    }

    /**
     * 営業開始分(プルダウン作用)を設定します。
     * @param fromMin 営業開始分(プルダウン作用)
     */
    public void setFromMin(String fromMin) {
        this.fromMin = fromMin;
    }

    /**
     * 営業終了時(プルダウン作用)を取得します。
     * @return 営業終了時(プルダウン作用)
     */
    public String getToHour() {
        return toHour;
    }

    /**
     * 営業終了時(プルダウン作用)を設定します。
     * @param toHour 営業終了時(プルダウン作用)
     */
    public void setToHour(String toHour) {
        this.toHour = toHour;
    }

    /**
     * 営業終了分(プルダウン作用)を取得します。
     * @return 営業終了分(プルダウン作用)
     */
    public String getToMin() {
        return toMin;
    }

    /**
     * 営業終了分(プルダウン作用)を設定します。
     * @param toMin 営業終了分(プルダウン作用)
     */
    public void setToMin(String toMin) {
        this.toMin = toMin;
    }

    /**
     * 定休日入力タイプを取得します。
     * @return 定休日入力タイプ
     */
    public String getHolidayType() {
        return holidayType;
    }

    /**
     * 定休日入力タイプを設定します。
     * @param holidayType 定休日入力タイプ
     */
    public void setHolidayType(String holidayType) {
        this.holidayType = holidayType;
    }

    /**
     * 定休日(固定)を取得します。
     * @return 定休日(固定)
     */
    public String getHolidayOption() {
        return holidayOption;
    }

    /**
     * 定休日(固定)を設定します。
     * @param holidayOption 定休日(固定)
     */
    public void setHolidayOption(String holidayOption) {
        this.holidayOption = holidayOption;
    }

    /**
     * 定休日(自由)を取得します。
     * @return 定休日(自由)
     */
    public String getHolidayCustom() {
        return holidayCustom;
    }

    /**
     * 定休日(自由)を設定します。
     * @param holidayCustom 定休日(自由)
     */
    public void setHolidayCustom(String holidayCustom) {
        this.holidayCustom = holidayCustom;
    }

    /**
     * 混雑時間帯を取得します。
     * @return 混雑時間帯
     */
    public String getBusyComment() {
        return busyComment;
    }

    /**
     * 混雑時間帯を設定します。
     * @param busyComment 混雑時間帯
     */
    public void setBusyComment(String busyComment) {
        this.busyComment = busyComment;
    }

    /**
     * 最終更新日時を取得します。
     * @return 最終更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日時を設定します。
     * @param updDt 最終更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 更新者IDを取得します。
     * @return 更新者ID
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * 更新者IDを設定します。
     * @param updId 更新者ID
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

    /**
     * 更新プログラムを取得します。
     * @return 更新プログラム
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新プログラムを設定します。
     * @param updPg 更新プログラム
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

}
