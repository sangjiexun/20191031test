<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="審査設定内容表示" />
<%@ include file="../parts/ContentsHeader.jsp"%>
<%@ include file="../parts/ContentsSidebar.jsp"%>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp"%>
<div class="main_layout">
<div class="topic_path">
  <html:link action="/Index.do">トップページ </html:link>&gt;
  ${title}
</div>
<h1>${title}</h1>

<p class="section_header">審査内容表示</p>
下記、条件に該当する物件を警告物件とする。<br>
<br>

<table class="type_list">
  <colgroup>
    <col width="30%">
    <col width="35%">
    <col width="*">
  </colgroup>
  <tr>
    <th>審査設定名称</th>
    <th>審査条件</th>
    <th>審査除外条件</th>
  </tr>
  <c:forEach items="${ReviewConfigView.shinsaDetailList}" var="shinsaInfo" >
  <tr>
    <td class="left"><label>${shinsaInfo.shinsaName}</label></td>
    <td class="left"><label>${shinsaInfo.jouken}</label></td>
    <td class="left"><label>${shinsaInfo.jogai}</label></td>
  </tr>
  </c:forEach>
</table>

<!-- 間取りタイプ設定 -->
<p class="section_header">間取りタイプ設定内容</p>
<table class="type_list">
  <tr>
    <th>分類</th>
    <th>抽出範囲</th>
    <th>有効件数</th>
    <th>有効範囲</th>
  </tr>
  <c:forEach items="${ReviewConfigView.madoriDetailList}" var="madoriInfo">
  <tr>
    <td class="left"><label><c:out value="${madoriInfo.madoriTypeName}" /></label></td>
    <td class="left"><label><c:out value="${madoriInfo.madori}" /></label></td>
    <td class="left"><label><c:out value="${madoriInfo.minBukkenCnt}" />以上</label></td>
    <td class="left">
      <label><c:out value="${madoriInfo.minChinryo}" />万円～<c:out value="${madoriInfo.maxChinryo}" />万円</label>
    </td>
  </tr>
  </c:forEach>
</table>

<!-- 自動削除設定 -->
<p class="section_header">自動削除設定内容</p>
<table class="type_detail">
  <colgroup>
    <col width="30%">
    <col width="*">
  </colgroup>
  <c:forEach items="${ReviewConfigView.autoDelDetailList}" var="delInfo">
  <tr>
    <th class="text-left"><label><c:out value="${delInfo.shinsaName}" />自動削除期間</label></th>
    <td><label><c:out value="${delInfo.autoDelKikan}" />日間以上</label></td>
  </tr>
  </c:forEach>
</table>

<!-- 市区町村別平均家賃比較対象設定 -->
<p class="section_header">市区町村別比較対象設定内容</p>
<table class="type_detail">
  <c:forEach items="${ReviewConfigView.prefDetailList}" var="prefInfo">
    <tr>
      <th class="text-left"><label><c:out value="${prefInfo.areaName}" /></label></th>
        <td>
        <c:forEach items="${prefInfo.prefInfoList}" var="prefDetail">
          <a href="
            <c:url value = "ReviewConfigCity.do">
              <c:param name="prefCd" value="${prefDetail[1]}"></c:param>
            </c:url>">
          ${prefDetail[0]}
          </a>
        </c:forEach>
        </td>
    </tr>
  </c:forEach>
</table>
</div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>