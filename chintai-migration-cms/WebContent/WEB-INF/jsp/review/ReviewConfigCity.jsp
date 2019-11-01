<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="市区町村別比較対象設定内容表示" />
<%@ include file="../parts/ContentsHeader.jsp"%>
<%@ include file="../parts/ContentsSidebar.jsp"%>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp"%>
<div class="main_layout">
<div class="topic_path">
  <html:link action="/Index.do">トップページ </html:link>&gt;
  <html:link action="/review/ReviewConfig.do">審査設定内容表示</html:link>&gt;
  ${title}
</div>
<h1>${title}</h1>
<!-- 市区町村別対象外設定1 -->
<p class="section_header">市区町村別比較対象設定内容</p>
<table class="type_list">
  <tr>
    <th>都道府県</th>
    <td><label>${ReviewConfigCityView.areaName}</label></td>
  </tr>
</table>

<table class="type_list">
  <colgroup>
    <col width=40%>
    <col width=30%>
    <col width=30%>
  </colgroup>

  <tr align="center">
    <th>市区町村名</th>
    <th>市区町村</th>
    <th>最寄駅</th>
  </tr>
  <c:forEach items="${ReviewConfigCityView.prefInfoList}" var="prefInfo">
  <tr>
    <td><label><c:out value="${prefInfo.cityName}" /></label></td>
    <td><label><c:out value="${prefInfo.shikutyoson}" /></label></td>
    <td><label><c:out value="${prefInfo.moyorieki}" /></label></td>
  </tr>
  </c:forEach>
</table>
</div>
</div>

<%@ include file="../parts/ContentsFooter.jsp"%>
