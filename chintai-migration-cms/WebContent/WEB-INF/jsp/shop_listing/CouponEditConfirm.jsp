<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="クーポン情報編集確認" />
<c:set var="view" value="${CouponEditView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
      <html:link action="/shop_listing/KeiyakuShopInfo" paramId="shopCd" paramName="view" paramProperty="shopCd">
        契約店舗詳細
      </html:link>
      &gt;&nbsp;${title}
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="msg"/>
    </html:messages>

    <!-- 店舗コード -->
    <p class="section_header"><a name="1">店舗コード</a></p>
<%@ include file="parts/ShopBasicInfo.jsp" %>

    <p class="section_header"><a name="1">クーポン情報</a></p>
    <html:form action="/shop_listing/CouponEditComplete.do">
      <div class="add_form">
        <table class="type_detail">
          <colgroup>
            <col width="19%" align="center">
            <col width="12%">
            <col width="48%">
            <col width="10%" align="center">
            <col width="10%" align="center">
          </colgroup>
          <tr>
            <th>項番</th>
            <th colspan="2" align="center">内容</th>
            <th>ソート順</th>
            <th>非表示</th>
          </tr>

<c:forEach begin="1" end="${view.displayLimit}" varStatus="i">
  <input type="hidden" name="couponSeqs"        value="${view.couponSeqs[i.index -1]}" >
  <input type="hidden" name="startYears"        value="${view.startYears[i.index -1]}" >
  <input type="hidden" name="startMonths"       value="${view.startMonths[i.index -1]}" >
  <input type="hidden" name="startDays"         value="${view.startDays[i.index -1]}" >
  <input type="hidden" name="endYears"          value="${view.endYears[i.index -1]}" >
  <input type="hidden" name="endMonths"         value="${view.endMonths[i.index -1]}" >
  <input type="hidden" name="endDays"           value="${view.endDays[i.index -1]}" >
  <input type="hidden" name="riyouTaisyoType"   value="${view.riyouTaisyoType[i.index -1]}" >
  <input type="hidden" name="riyouTaisyo"       value="${view.riyouTaisyo[i.index -1]}" >
  <input type="hidden" name="riyouTaisyoCustom" value="${view.riyouTaisyoCustom[i.index -1]}" >
  <input type="hidden" name="tokutenType"       value="${view.tokutenType[i.index -1]}" >
  <input type="hidden" name="tokuten"           value="${view.tokuten[i.index -1]}" >
  <input type="hidden" name="tokutenCustom"     value="${view.tokutenCustom[i.index -1]}" >
  <input type="hidden" name="joukenType"        value="${view.joukenType[i.index -1]}" >
  <input type="hidden" name="jouken"            value="${view.jouken[i.index -1]}" >
  <input type="hidden" name="joukenCustom"      value="${view.joukenCustom[i.index -1]}" >
  <input type="hidden" name="sortKeys"          value="${view.sortKeys[i.index -1]}" >
  <input type="hidden" name="delFlgs"           value="${view.delFlgs[i.index -1]}" >
  <input type="hidden" name="updDt"             value="${view.updDt[i.index -1]}" >

  <c:if test="${not empty view.startYears[i.index -1]}">
      <tr>
        <th rowspan="4">クーポン<c:out value="${i.index}" /></th>
        <th>開始年月日～終了年月日</th>
        <td>
          <c:out value="${view.startYears[i.index -1]}" />年
          <c:out value="${view.startMonths[i.index -1]}" />月
          <c:out value="${view.startDays[i.index -1]}" />日 ～

<c:if test="${not empty view.endYears[i.index -1]}">
          <c:out value="${view.endYears[i.index -1]}" />年
          <c:out value="${view.endMonths[i.index -1]}" />月
          <c:out value="${view.endDays[i.index -1]}" />日
</c:if>
        </td>
        <td rowspan="4"><c:out value="${view.sortKeys[i.index - 1]}" /></td>
        <td rowspan="4">
<c:choose>
  <c:when test="${not empty view.delFlgs[i.index - 1]}">
          非表示
  </c:when>
  <c:otherwise>
          表示
  </c:otherwise>
</c:choose>
        </td>
      </tr>
      <tr>
        <th>利用対象</th>
<c:choose>
  <c:when test="${view.riyouTaisyoType[i.index - 1] eq '1'}">
        <td><c:out value="${view.riyouTaisyo[i.index - 1]}" /></td>
  </c:when>
  <c:when test="${view.riyouTaisyoType[i.index - 1] eq '2'}">
        <td><c:out value="${view.riyouTaisyoCustom[i.index - 1]}" /></td>
  </c:when>
  <c:otherwise><td></td></c:otherwise>
</c:choose>
      </tr>
      <tr>
        <th>特典</th>
<c:choose>
  <c:when test="${view.tokutenType[i.index - 1] eq '1'}">
        <td><c:out value="${view.tokuten[i.index - 1]}" /></td>
  </c:when>
  <c:when test="${view.tokutenType[i.index - 1] eq '2'}">
        <td><c:out value="${view.tokutenCustom[i.index - 1]}" /></td>
  </c:when>
  <c:otherwise><td></td></c:otherwise>
</c:choose>
      </tr>
      <tr>
        <th>提示条件</th>
<c:choose>
  <c:when test="${view.joukenType[i.index - 1] eq '1'}">
        <td><c:out value="${view.jouken[i.index - 1]}" /></td>
  </c:when>
  <c:when test="${view.joukenType[i.index - 1] eq '2'}">
        <td><c:out value="${view.joukenCustom[i.index - 1]}" /></td>
  </c:when>
  <c:otherwise><td></td></c:otherwise>
</c:choose>
      </tr>
  </c:if>
</c:forEach>
        </table>

        <p>
          <input type="hidden" name="shopCd"  value="${view.shopCd}" >
          <input type="submit" value="編集する">
          <input type="button" value="戻る" onClick="_submit('CouponEditPageBack.do');">
        </p>
      </div>
    </html:form>

  </div><!-- popup_layout END -->
</div><!-- main END -->

<%@ include file="../parts/ContentsFooter.jsp" %>