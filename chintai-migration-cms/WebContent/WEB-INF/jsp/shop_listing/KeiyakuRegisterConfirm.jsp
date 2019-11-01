<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="契約情報登録確認" />
<c:set var="view" value="${KeiyakuRegisterView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_listing/KeiyakuShopInfo" paramId="shopCd" paramName="view" paramProperty="shopCd">
        契約店舗詳細
      </html:link>
      &gt;&nbsp;${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <html:form action="/shop_listing/KeiyakuRegisterComplete">
    <!-- 店舗コード -->
    <p class="section_header"><a name="1">店舗コード</a></p>
<%@ include file="parts/ShopBasicInfo.jsp" %>

    <!-- 契約情報 -->
<%@ include file="parts/KeiyakuInfoConfirm.jsp" %>

      <p>
        <input type="hidden" name="shopCd"            value="${view.shopCd}" />
        <input type="hidden" name="keiyakuShubetsu"   value="${view.keiyakuShubetsu}">
        <input type="hidden" name="kihonKeiyakuFlg"   value="${view.kihonKeiyakuFlg}">
        <input type="hidden" name="keiyakuStartYear"  value="${view.keiyakuStartYear}">
        <input type="hidden" name="keiyakuStartMonth" value="${view.keiyakuStartMonth}">
        <input type="hidden" name="keiyakuStartYm"    value="${view.keiyakuStartYm}">
        <input type="hidden" name="keiyakuEndYear"    value="${view.keiyakuEndYear}">
        <input type="hidden" name="keiyakuEndMonth"   value="${view.keiyakuEndMonth}">
        <input type="hidden" name="keiyakuEndYm"      value="${view.keiyakuEndYm}">
        <input type="hidden" name="couponKeiyakuFlg"  value="${view.couponKeiyakuFlg}">
        <input type="hidden" name="couponStartYear"   value="${view.couponStartYear}">
        <input type="hidden" name="couponStartMonth"  value="${view.couponStartMonth}">
        <input type="hidden" name="couponStartYm"     value="${view.couponStartYm}">
        <input type="hidden" name="couponEndYear"     value="${view.couponEndYear}">
        <input type="hidden" name="couponEndMonth"    value="${view.couponEndMonth}">
        <input type="hidden" name="couponEndYm"       value="${view.couponEndYm}">
        <input type="hidden" name="linkKeiyakuFlg"    value="${view.linkKeiyakuFlg}">
        <input type="hidden" name="linkStartYear"     value="${view.linkStartYear}">
        <input type="hidden" name="linkStartMonth"    value="${view.linkStartMonth}">
        <input type="hidden" name="linkStartYm"       value="${view.linkStartYm}">
        <input type="hidden" name="linkEndYear"       value="${view.linkEndYear}">
        <input type="hidden" name="linkEndMonth"      value="${view.linkEndMonth}">
        <input type="hidden" name="linkEndYm"         value="${view.linkEndYm}">
        <input type="hidden" name="today"             value="${view.today}">
        <input type="hidden" name="note"              value="${fn:escapeXml(view.note)}">
        <input type="hidden" name="ekiCnt"            value="${view.ekiCnt}">
        <input type="hidden" name="cityCnt"           value="${view.cityCnt}">
        <input type="hidden" name="updDt"             value="${view.updDt}">
        <input type="submit" value="登録">
        <input type="button" name="back" value="戻る" onClick="_submit('KeiyakuRegisterPageBack.do')">
      </p>
    </html:form>
  </div><!-- popup_layout END -->
</div><!-- main END -->

<%@ include file="../parts/ContentsFooter.jsp" %>
