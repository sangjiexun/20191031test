<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="都道府県別データ元出力設定" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<c:set var="view" value="${PrefClientSettingInfoView}" />

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/dataoutput/DataoutputIndex">他社データ連携出力設定</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:messages id ="msg" header="info.header" footer="info.footer" message="true">
      <c:out value="${msg}"></c:out>
    </html:messages>
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />



	<html:form action="/dataoutput/PrefClientUpdatePage" method="post">
    <p class="section_header">都道府県別データ元出力設定</p>

    連携対象一覧
    <select name="dcoType" style="width: 80px" id="dcoType">
    </select>

    <input type="button" value="選択" onclick="_submit('PrefClientSettingInfo.do');">

    <c:if test="${not empty PrefClientSettingInfoView.prefNameList}">

    <p>
      <html:link href="#" onclick="_submit('PrefClientUpdatePage.do');">
        &gt;&gt; 都道府県別データ元出力設定を更新する
      </html:link>
    </p>
    <div  class="annotation_left">※■は、出力する設定となっているデータ元です</div>
    <table class="type_list_pre">
      <colgroup>
        <col width="30%">
        <col width="70%">
      </colgroup>
      <tr>
        <th>都道府県</th>
        <th>設定値(※)</th>
      </tr>

<c:set var="clientsystemTypeMap" value="${view.clientsystemTypeMap}" />
<c:forEach items="${view.prefNameList}" var="prefNameList" varStatus="i">
      <tr>
        <td><c:out value="${prefNameList.prefname}" /></td>

		<c:set var="crs" value="" />
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][0] eq '0'}">
			<c:set var="crs" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][0] ne '0'}">
			<c:set var="crs" value="■" />
		</c:if>

		<c:set var="ans" value="" />
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][1] eq '0'}">
			<c:set var="ans" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][1] ne '0'}">
			<c:set var="ans" value="■" />
		</c:if>

		<c:set var="able" value="" />
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][2] eq '0'}">
			<c:set var="able" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][2] ne '0'}">
			<c:set var="able" value="■" />
		</c:if>

		<c:set var="magazine" value="" />
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][3] eq '0'}">
			<c:set var="magazine" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][3] ne '0'}">
			<c:set var="magazine" value="■" />
		</c:if>

        <td align="left">${crs}CRS　　　　${ans}ANS　　　　${able}エイブル直営店　　　　${magazine}手書き</td>
      </tr>
</c:forEach>

    </table>

    </c:if>

	</html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>

<script src="${pageContext.request.contextPath}/dwr/interface/AddressEnsenManager.js"></script>
<script src="${pageContext.request.contextPath}/dwr/interface/DcoTypeManager.js"></script>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>

<fmt:setBundle basename="resources.SystemProperties" var="resource" />

<fmt:message bundle="${resource}" key="PREF_DCO_TYPE_VALUE"  var="docTypes"/>

<%
   String dcoType = request.getParameter("dcoType");
%>
<script language="JavaScript" type="text/javascript">
<!--

function loadDcoTypeList(){
	DcoTypeManager.getDcoTypeList("${docTypes}", function(ret) {
	       dwr.util.removeAllOptions("dcoType");
	       dwr.util.addOptions("dcoType", ret, "dcoType", "dcoName");
	       dwr.util.setValue("dcoType", "<%=dcoType%>");
	   });
}
addEvent('load', window, loadDcoTypeList);
//-->
</script>