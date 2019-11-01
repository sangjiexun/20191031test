<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="view"  value="${ContractAmountDeleteView}" />
<c:set var="title" value="${ContractAmountDeleteView.keiyakuName}削除確認" />
<c:set var="keiyakuName" value="${ContractAmountDeleteView.keiyakuName}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--
 addEvent('load', window, function(){document.getElementsByName('backButton')[0].focus();});
-->
</script>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_bukken/ShopInfo.do">
      <html:param name="shopCd" value="${view.shopCd}" />
        店舗・契約詳細
      </html:link> &gt;
      <html:link action="/shop_bukken/ContractAmountInfo.do">
        <html:param name="shopCd" value="${view.shopCd}" />
        <html:param name="keiyakuCd" value="${view.keiyakuCd}" />
        <html:param name="keiyakuSubCd" value="${view.keiyakuSubCd}" />
        ${keiyakuName}
      </html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">店舗コード</p>
    <table class="type_detail">
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

    <!--物件枠設定情報-->
    <p class="section_header">削除${keiyakuName}設定情報</p>
    <html:form action="/shop_bukken/ContractAmountDeleteCommit.do" onsubmit="disableSubmit(this);">
      <table class="type_list">
        <colgroup>
          <col width="20%">
          <col width="25%">
          <col width="20%">
        </colgroup>
        <tr>
          <th>適用開始日時</th>
          <th>${keiyakuName}</th>
          <th>更新日</th>
        </tr>
        <c:forEach items="${view.detailList}" var="detail">
          <tr>
            <td>
              <c:out value="${detail.startYmdh}"/>～
            </td>
            <td class="right"><c:out value="${detail.wakuCnt}" />件</td>
            <td class="right"><c:out value="${detail.updDt}" />
            <input type="hidden" name="delFlgList" value="${detail.appStartDt}" />
            </td>

          </tr>
        </c:forEach>
      </table>
      <div class="add_from">
        <input type="hidden" name="keiyakuCd"      value="${view.keiyakuCd}">
        <input type="hidden" name="shopCd"         value="${view.shopCd}">
        <input type="hidden" name="keiyakuSubCd"   value="${view.keiyakuSubCd}">
        <input type="hidden" name="keiyakuName"    value="${view.keiyakuName}" >
        <input type="hidden" name="shopKanriUpdDt" value="${view.shopKanriUpdDt}">
        <input type="submit" value="削除" >
        <input type="button" name="backButton" value="戻る" onclick="_submit('ContractAmountDeleteBack.do');">
      </div>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>