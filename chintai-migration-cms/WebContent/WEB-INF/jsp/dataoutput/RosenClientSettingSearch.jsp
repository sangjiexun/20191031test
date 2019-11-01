<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="沿線・駅検索" />
<c:set var="view" value="${RosenClientSettingSearchView}" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<script src="${pageContext.request.contextPath}/dwr/interface/AddressEnsenManager.js"></script>
<script src="${pageContext.request.contextPath}/dwr/interface/DcoTypeManager.js"></script>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>

<fmt:setBundle basename="resources.SystemProperties" var="resource" />

<fmt:message bundle="${resource}" key="ROSEN_DCO_TYPE_VALUE"  var="docTypes"/>

<%
   String areaCd = request.getParameter("areaCd");
   String dcoType = request.getParameter("dcoType");
%>


<script language="JavaScript" type="text/javascript">
<!--
function loadAreaEnsenList() {
   AddressEnsenManager.getAreaList( function(ret) {
       dwr.util.removeAllOptions("areaCd");
       dwr.util.addOptions("areaCd", ret, "areaCode", "areaName");
       dwr.util.setValue("areaCd", "<%=areaCd%>");
   });
}

function loadDcoTypeList(){
	DcoTypeManager.getDcoTypeList("${docTypes}", function(ret) {
	       dwr.util.removeAllOptions("dcoType");
	       dwr.util.addOptions("dcoType", ret, "dcoType", "dcoName");
	       dwr.util.setValue("dcoType", "<%=dcoType%>");
	   });
}

function resetEnsenList() {
	loadDcoTypeList();
	loadAreaEnsenList();
}

addEvent('load', window, loadAreaEnsenList);
addEvent('load', window, loadDcoTypeList);
//-->
</script>

<!-- メイン -->
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/dataoutput/DataoutputIndex">他社データ連携出力設定</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">エリア・沿線タイプ選択</p>
    <html:form action="/dataoutput/RosenClientSettingSearch" method="post" >
      <p>
        連携対象一覧
        <select name="dcoType" style="width: 80px" id="dcoType">
        </select>
        エリア
        <select name="areaCd" style="width: 80px" id="areaCd">
        </select>
        沿線タイプ
        <chintai:PropertyOptions name="ensenType" fixValue="${param.ensenType}" nameKey="ENSENTYPE_NAME" valueKey="ENSENTYPE_VALUE"/>
        <input type="submit" value="検索" >
        <input type="reset" value="クリア" onClick="resetEnsenList()">
      </p>
    </html:form>

    <c:if test="${not empty view.rosenSearchList}">
      <p class="section_header">
          検索結果一覧：
          <c:out value="${view.dcoName}"/>
      </p>
      <p>
        <html:link href="#" onclick="_submit('RosenClientSettingUpdate.do');">
          &gt;&gt; 沿線別データ元除外設定を更新する
        </html:link>
      </p>
      <div  class="annotation_left">※■は、出力する設定となっているデータ元です</div>

      <table class="type_list">
        <colgroup>
          <col width="7%">
          <col width="7%">
          <col width="20%">
          <col width="66%">
        </colgroup>
        <tr>
          <th>エリア</th>
          <th>タイプ</th>
          <th>沿線名<BR>かな</th>
          <th>設定値(※)</th>
        </tr>
        <c:set var="clientsystemTypeMap" value="${view.clientsystemTypeMap}" />
        <c:forEach items="${view.rosenSearchList}" var="rosenList" varStatus="i">
          <tr>
            <td>
              <c:out value="${view.areaName}"/>
            </td>
            <td>
              <chintai:CodePrint nameKey="ENSENTYPE_NAME" valueKey="ENSENTYPE_VALUE" code="${view.ensenType}"/>
            </td>
            <td class="left">
              <a href ="<c:url value="EkiClientSettingInfo.do" >
                <c:param name="ensenCd" value="${rosenList.ensenCd}"/>
                <c:param name="ensenName" value="${rosenList.ensenName}"/>
                <c:param name="dcoType" value="${view.dcoType}"/>
                <c:param name="dcoName" value="${view.dcoName}"/>
              </c:url>" target="_blank">
                <c:out value="${rosenList.ensenName}" /><BR><c:out value="${rosenList.ensenKana}" />
              </a>
            </td>
            <c:set var="crs" value="" />
            <c:if test="${clientsystemTypeMap[rosenList.ensenCd][0] eq '0'}">
                <c:set var="crs" value="□" />
            </c:if>
            <c:if test="${clientsystemTypeMap[rosenList.ensenCd][0] ne '0'}">
                <c:set var="crs" value="■" />
            </c:if>

            <c:set var="ans" value="" />
            <c:if test="${clientsystemTypeMap[rosenList.ensenCd][1] eq '0'}">
                <c:set var="ans" value="□" />
            </c:if>
            <c:if test="${clientsystemTypeMap[rosenList.ensenCd][1] ne '0'}">
                <c:set var="ans" value="■" />
            </c:if>

            <c:set var="able" value="" />
            <c:if test="${clientsystemTypeMap[rosenList.ensenCd][2] eq '0'}">
                <c:set var="able" value="□" />
            </c:if>
            <c:if test="${clientsystemTypeMap[rosenList.ensenCd][2] ne '0'}">
                <c:set var="able" value="■" />
            </c:if>

            <c:set var="magazine" value="" />
            <c:if test="${clientsystemTypeMap[rosenList.ensenCd][3] eq '0'}">
                <c:set var="magazine" value="□" />
            </c:if>
            <c:if test="${clientsystemTypeMap[rosenList.ensenCd][3] ne '0'}">
                <c:set var="magazine" value="■" />
            </c:if>

            <td align="left" class="section_header">${crs}CRS　　　　${ans}ANS　　　　${able}エイブル直営店　　　　${magazine}手書き</td>
          </tr>
        </c:forEach>
      </table>
    </c:if>
  </div>
</div>


<%@ include file="../parts/ContentsFooter.jsp" %>
