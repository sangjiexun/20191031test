<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="view"  value="${ShopListingAddView}" />
<c:set var="mstShopKeiyakuKanri" value="${masterService.selectMstShopKeiyakuKanriByPrimaryKey(view.keiyakuCd, view.keiyakuSubCd)}"/>
<c:set var="keiyakuName" value=""/>
<c:if test="${mstShopKeiyakuKanri != null}">
	<c:set var="keiyakuName" value="${mstShopKeiyakuKanri.keiyakuName}"/>
</c:if>
<c:set var="title" value="${keiyakuName}登録確認" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--
 addEvent('load', window, function(){document.getElementsByName('backButton')[0].focus();});
-->
</script>
<style>
table th{
	text-align: left;
}
</style>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_bukken/ShopInfo.do">
        <html:param name="shopCd" value="${view.shopCd}" />
        店舗・契約詳細
      </html:link> &gt;
      <html:link action="/shop_bukken/ContractInfo.do">
        <html:param name="shopCd" value="${view.shopCd}" />
        <html:param name="keiyakuCd" value="${view.keiyakuCd}" />
        <html:param name="keiyakuSubCd" value="${view.keiyakuSubCd}" />
       ${keiyakuName}詳細
      </html:link> &gt;
        ${keiyakuName}登録確認
    </div>
    <h1>${keiyakuName}登録確認</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">店舗コード</p>
    <table class="type_detail_pre">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>店舗名</th>
        <td>
          <c:out value="${view.company}" />
          <c:if test="${not empty view.company and not empty view.bumon}"> / </c:if>
          <c:out value="${view.bumon}" />
        </td>
      </tr>
      <tr>
        <th>店舗コード</th>
        <td> <c:out value="${view.shopCd}" /></td>
      </tr>
      <tr>
        <th>お客様設定パスワード</th>
        <td>
          <c:out value="${view.password}" />
        </td>
      </tr>
    </table>

    <!--${keiyakuName}設定情報-->
    <p class="section_header">${keiyakuName}</p>
    <table class="type_detail_pre">
      <colgroup>
        <col span="1" width="20%" class="type_detail_head">
        <col span="1" width="80%" class="type_detail_body" >
      </colgroup>
      <tr>
        <th>契約期間</th>
        <td>
          <c:out value="${view.keiyakuStartYear}"/>年
          <c:out value="${view.keiyakuStartMonth}"/>月
          <c:out value="${view.keiyakuStartDay}"/>日
          <c:out value="${view.keiyakuStartHour}"/>時
          <c:out value="${view.keiyakuStartMinute}"/>分
          <c:out value="${view.keiyakuStartSecond}"/>秒&nbsp;～
          <c:choose>
            <c:when test="${!empty view.keiyakuEndYear}">
              <c:out value="${view.keiyakuEndYear}"/>年
              <c:out value="${view.keiyakuEndMonth}"/>月
              <c:out value="${view.keiyakuEndDay}"/>日
              <c:out value="${view.keiyakuEndHour}"/>時
              <c:out value="${view.keiyakuEndMinute}"/>分
              <c:out value="${view.keiyakuEndSecond}"/>秒
            </c:when>
          </c:choose>
        </td>
      </tr>
      <c:if test="${view.isWakuDisp == 'true'}">
      <tr>
        <th>${keiyakuName}</th>
        <td>
          <c:choose>
            <c:when test="${view.wakuCnt eq '-1'}">
              <c:out value="${view.wakuCntNote}"/>件
            </c:when>
            <c:otherwise>
              <c:out value="${view.wakuCnt}"/>件
            </c:otherwise>
          </c:choose>
        </td>
      </tr>
      </c:if>
      <tr>
        <th>備考</th>
        <td>
          <chintai:filter filter="false" changeNL2BR="true"><c:out value="${view.keiyakuNote}" /></chintai:filter>
        </td>
      </tr>
    </table>

    <html:form action="/shop_bukken/ContractAddCommit.do" onsubmit="disableSubmit(this);">
      <div class="add_from">
      <input type="hidden" name="shopCd"   value="${view.shopCd}">
      <input type="hidden" name="keiyakuCd"   value="${view.keiyakuCd}">
      <input type="hidden" name="keiyakuSubCd"   value="${view.keiyakuSubCd}">
      <input type="hidden" name="keiyakuNote"  value="${view.keiyakuNote}" >
      <input type="hidden" name="keiyakuStartYear"  value="${view.keiyakuStartYear}" >
      <input type="hidden" name="keiyakuStartMonth"  value="${view.keiyakuStartMonth}" >
      <input type="hidden" name="keiyakuStartDay"  value="${view.keiyakuStartDay}" >
      <input type="hidden" name="keiyakuStartHour"  value="${view.keiyakuStartHour}" >
      <input type="hidden" name="keiyakuStartMinute"  value="${view.keiyakuStartMinute}" >
      <input type="hidden" name="keiyakuStartSecond"  value="${view.keiyakuStartSecond}" >
      <input type="hidden" name="keiyakuEndYear"  value="${view.keiyakuEndYear}" >
      <input type="hidden" name="keiyakuEndMonth"  value="${view.keiyakuEndMonth}" >
      <input type="hidden" name="keiyakuEndDay"  value="${view.keiyakuEndDay}" >
      <input type="hidden" name="keiyakuEndHour"  value="${view.keiyakuEndHour}" >
      <input type="hidden" name="keiyakuEndMinute"  value="${view.keiyakuEndMinute}" >
      <input type="hidden" name="keiyakuEndSecond"  value="${view.keiyakuEndSecond}" >
      <input type="hidden" name="keiyakuName" value="${view.keiyakuName}">
      <input type="hidden" name="shopKanriUpdDt" value="${view.shopKanriUpdDt}">

      <input type="hidden" name="wakuCntChecker"  value="${view.wakuCntChecker}" >
      <input type="hidden" name="amountLenth"  value="${view.amountLenth}" >
      <input type="hidden" name="wakuCnt"  value="${view.wakuCnt}" >
      <input type="hidden" name="wakuCntNote"  value="${view.wakuCntNote}" >
      <input type="hidden" name="maxNum" value="${view.maxNum}">
      <input type="hidden" name="isWakuDisp"  value="${view.isWakuDisp}" >

      <input type="submit" value="登録" >
      <input type="button" name="backButton" value="戻る" onclick="_submit('ContractAddPage.do')">
      </div>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
