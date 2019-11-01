<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="不動産会社情報更新" />
<c:set var="view"  value="${FudousanUpdateView}" />
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
      <html:link action="/demand/FudousanInfoPaging.do">
        <html:param name="fudousanCd" value="${view.fudousanCd}" />
        <html:param name="offSet" value="${view.offSet}" />
        不動産会社詳細
      </html:link>
      &gt;${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
    <p class="section_header">不動産会社情報</p>
      <table class="type_detail">
       <colgroup>
        <col span="1" width="20%" class="type_detail_head">
        <col span="1" width="*" class="type_detail_body" >
       </colgroup>
       <tr>
        <th>不動産会社名</th>
        <td><c:out value="${view.fudousanName}" /></td>
       </tr>
       <tr>
        <th rowspan="4">住所</th>
        <td colspan="3">
          <c:choose>
            <c:when test="${not empty view.zipCode1}">
              〒<c:out value="${view.zipCode1}" />-<c:out value="${view.zipCode2}" />
            </c:when>
            <c:otherwise>
              &nbsp;
            </c:otherwise>
          </c:choose>
		</td>
       </tr>
       <tr>
        <td colspan="3"><c:out value="${view.prefName}" />&nbsp;</td>
       </tr>
       <tr>
        <td colspan="3"><c:out value="${view.address1}" />&nbsp;</td>
       </tr>
       <tr>
        <td colspan="3"><c:out value="${view.address2}" />&nbsp;</td>
       </tr>
       <tr>
        <th>電話番号</th>
        <td><c:out value="${view.tel}" /></td>
       </tr>
       <tr>
        <th>FAX番号</th>
        <td><c:out value="${view.fax}" /></td>
       </tr>
       <tr>
        <th>担当者名</th>
        <td colspan="3"><c:out value="${view.tantou}" /></td>
       </tr>
      </table>
	<html:form action="/demand/FudousanUpdateCommit.do" onsubmit="disableSubmit(this);">
      <p>
        <input type="hidden" name="fudousanName" value="${fn:escapeXml(view.fudousanName)}">
        <input type="hidden" name="fudousanCd"   value="${view.fudousanCd}">
        <input type="hidden" name="zipCode1"     value="${view.zipCode1}">
        <input type="hidden" name="zipCode2"     value="${view.zipCode2}">
        <input type="hidden" name="prefCd"       value="${view.prefCd}">
        <input type="hidden" name="prefName"     value="${view.prefName}">
        <input type="hidden" name="address1"     value="${fn:escapeXml(view.address1)}">
        <input type="hidden" name="address2"     value="${fn:escapeXml(view.address2)}">
        <input type="hidden" name="tel"          value="${view.tel}">
        <input type="hidden" name="fax"          value="${view.fax}">
        <input type="hidden" name="tantou"       value="${fn:escapeXml(view.tantou)}">
        <input type="hidden" name="updDt"        value="${view.updDt}">
        <input type="hidden" name="offSet"       value="${view.offSet}">
        <input type="submit" value="更新" >
        <input type="button" value="戻る" name="backButton" onClick="_submit('FudousanUpdatePageBackAction.do');">
      </p>
	</html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
