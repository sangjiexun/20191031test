<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗情報詳細" />
<c:set var="view"  value="${ShopBindUpdateView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<script type="text/javascript">
<!--
  addEvent('load', window, function(){document.getElementsByName('back')[0].focus();});
-->
</script>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="msg"/>
    </html:messages>
    <p class="section_header">${title}</p>
    <table class="type_detail">
      <colgroup>
        <col width="20%">
        <col width="30%">
        <col width="20%">
        <col width="30%">
      </colgroup>
      <tr>
        <th>店舗コード</th>
        <td><c:out value="${view.shopCd}" /></td>
        <th>地区コード</th>
        <td><c:out value="${view.areaCd}" /></td>
      </tr>
      <tr>
        <th>会社名</th>
        <td><c:out value="${view.company}" /></td>
        <th>事務所名</th>
        <td><c:out value="${view.bumon}" /></td>
      </tr>
      <tr>
        <th rowspan="3">住所</th>
        <td colspan="3">
          <c:if test="${not empty view.zip}">
            〒<c:out value="${view.zip}"/>
          </c:if>&nbsp;
        </td>
      </tr>
      <tr>
        <td colspan="3"><c:out value="${view.address1}" />&nbsp;</td>
      </tr>
      <tr>
        <td colspan="3"><c:out value="${view.address2}" />&nbsp;</td>
      </tr>
      <tr>
        <th>メールアドレス</th>
        <td><c:out value="${view.email}" /></td>
        <th>担当者</th>
        <td><c:out value="${view.tantou}" /></td>
      </tr>
      <tr>
        <th>電話番号</th>
        <td><c:out value="${view.tel}" /></td>
        <th>FAX番号</th>
        <td><c:out value="${view.fax}" /></td>
      </tr>
    </table>

    <p class="section_header">紐付先情報</p>
    <table class="type_detail">
      <colgroup>
        <col width="20%">
        <col width="80%">
      </colgroup>
      <tr>
        <th>取引先コード</th>
        <td><c:out value="${param.torihikisakiCd}" /></td>
      </tr>
      <tr>
        <th>取引先名</th>
        <td><c:out value="${param.torihikisakiName}" /></td>
      </tr>
    </table>
    <html:form action="demand/ShopBindUpdateCommit" onsubmit="disableSubmit(this);">
      <p>
        <input type="hidden" name="shopCd"           value="${param.shopCd}">
        <input type="hidden" name="updDt"            value="${param.updDt}">
        <input type="hidden" name="torihikisakiSeq"  value="${param.torihikisakiSeq}">
        <input type="hidden" name="torihikisakiCd"   value="${param.torihikisakiCd}">
        <input type="hidden" name="torihikisakiName" value="${fn:escapeXml(param.torihikisakiName)}">
        <input type="submit" value="更新">
        <input type="button" name="back" value="戻る" onClick="_submit('ShopBindUpdatePageBack.do');">
      </p>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
