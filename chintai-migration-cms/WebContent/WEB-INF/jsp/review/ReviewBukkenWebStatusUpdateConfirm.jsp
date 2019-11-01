<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="CHINTAI NET掲載状態変更" />
<c:set var="view" value="${ReviewBukkenWebStatusUpdateView}"/>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/review/ReviewBukkenInfo" paramId="roomKey" paramName="view" paramProperty="roomKey">
        物件詳細
      </html:link>&gt;${title}
    </div>
    <h1>${title}</h1>

    <p class="section_header">物件情報</p>
    <%@ include file="parts/WebStatusUpdateBukkenInfoPart.jsp" %>

    <p class="section_header">${title}内容の確認</p>
    <table class="type_detail">
    <colgroup>
      <col span="1" width="20%">
      <col span="1" width="80%">
    </colgroup>
      <tr >
        <th class="text-left">CHINTAI NET掲載状態</th>
        <td class="annotation">
          <chintai:CodePrint code="${view.bukkenStatusShinsaInput}" nameKey="WEB_BUKKEN_STATUS_SHINSA_NAME" valueKey="WEB_BUKKEN_STATUS_SHINSA_VALUE"/>
        </td>
      </tr>
      <tr >
        <th class="text-left">備考</th>
        <td class="annotation"><chintai:filter changeNL2BR="true"><c:out value="${view.shinsaBukkenStatusBikou}" /></chintai:filter></td>
      </tr>
    </table>
    <html:form action="/review/ReviewBukkenWebStatusUpdateCommit" onsubmit="disableSubmit(this)">
      <p>
        <input type="hidden" name="kanriCd"                 value="${view.kanriCd}">
        <input type="hidden" name="updDt"                   value="${view.updDt}">
        <input type="hidden" name="bukkenStatusShinsaInput" value="${view.bukkenStatusShinsaInput}">
        <input type="hidden" name="shinsaBukkenStatusBikou" value="${fn:escapeXml(view.shinsaBukkenStatusBikou)}">
        <input type="hidden" name="roomKey"                 value="${view.roomKey}">
        <input type="submit" value="更新">
        <input type="button" value="戻る" onClick="_submit('ReviewBukkenWebStatusUpdatePageBack.do');">
      </p>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>