<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="沿線・駅検索" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<script src="${pageContext.request.contextPath}/dwr/interface/AddressEnsenManager.js"></script>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>
<%
   String ensenEkiName = request.getParameter("ensenEkiName");
	String areaCd = request.getParameter("areaCd");
%>
<script type="text/javascript">
function loadAreaEnsenList() {
   AddressEnsenManager.getAreaList( function(ret) {
       dwr.util.removeAllOptions("areaCd");
       dwr.util.addOptions("areaCd", ret, "areaCode", "areaName");
       dwr.util.setValue("areaCd", "<%=areaCd%>");
   });
}

function resetAreaEnsenList() {
	loadAreaEnsenList();
}

addEvent('load', window, loadAreaEnsenList);
addEvent('load', window, function(){document.getElementsByName('areaCd')[0].focus();});
</script>
<!-- メイン -->
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ </html:link> &gt;
      <html:link action="/master/RosenIndex.do">沿線・駅メンテナンス</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">名称から検索</p>
    <form action="RosenNameSearch.do" method="get">
      <p>
        沿線名／沿線名かな<input type="text" name="ensenNameParam" value="${fn:escapeXml(param.ensenNameParam)}" maxlength="64" ><br>
        駅名／駅名かな&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="ekiNameParam" value="${fn:escapeXml(param.ekiNameParam)}" maxlength="64" >
        <input type="hidden" name="searchFlg" value="1">
        <input type="submit" value="検索">
        <input type="reset" value="クリア">
      </p>
    </form>

	<p class="section_header">エリア・沿線タイプ選択</p>
    <form action="RosenSearch.do" method="get">
      <p>
        エリア
        <select name="areaCd" style="width: 80px" id="areaCd">
        </select>
        沿線タイプ
        <chintai:PropertyOptions name="ensenType" fixValue="${param.ensenType}" nameKey="MASTER_ENSENTYPE_NAME" valueKey="MASTER_ENSENTYPE_VALUE"/>
        <input type="hidden" name="ensenCd" value="${fn:escapeXml(rosenList.ensenCd)}">
        <input type="hidden" name="ensenName" value="${fn:escapeXml(rosenList.ensenName)}">
        <input type="hidden" name="areaName" value="${fn:escapeXml(rosenList.areaName)}">
        <input type="hidden" name="searchFlg" value="1">
        <input type="submit" value="検索">
        <input type="reset" value="クリア" onClick="resetAreaEnsenList()">
      </p>
    </form>

    <%@ include file="parts/RosenList.jsp" %>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
