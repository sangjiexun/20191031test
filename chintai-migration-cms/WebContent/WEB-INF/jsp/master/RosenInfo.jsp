<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="沿線詳細" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<!-- メイン -->
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ </html:link> &gt;
      <html:link action="/master/RosenIndex.do">沿線・駅メンテナンス</html:link> &gt;
      <c:if test="${not empty param.ensenNameParam or not empty param.ekiNameParam}">
      <a href="javascript:_submit('RosenNameSearch.do')">沿線・駅検索</a> &gt;
      </c:if>
      <c:if test="${empty param.ensenNameParam and empty param.ekiNameParam}">
      <a href="javascript:_submit('RosenSearch.do')">沿線・駅検索</a> &gt;
      </c:if>
      ${title}
    </div>
    <h1>${title}</h1>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <!-- 沿線詳細 -->
    <p class="section_header">沿線詳細</p>
     <form method="post">
       <input type="hidden" name="areaCd" value="${fn:escapeXml(RosenInfoView.areaCd)}">
       <input type="hidden" name="ensenType" value="${fn:escapeXml(RosenInfoView.ensenType)}">
       <input type="hidden" name="ensenNameParam" value="${fn:escapeXml(param.ensenNameParam)}">
       <input type="hidden" name="ekiNameParam" value="${fn:escapeXml(param.ekiNameParam)}">
     </form>
     <table class="type_detail">
       <colgroup>
          <col width="20%">
          <col width="80%">
        </colgroup>
       <tr>
         <th class="text-left">沿線タイプ</th>
         <td>
           <chintai:CodePrint nameKey="MASTER_ENSENTYPE_NAME" valueKey="MASTER_ENSENTYPE_VALUE" code="${RosenInfoView.ensenType}"/>
         </td>
       </tr>
       <tr>
         <th class="text-left">沿線コード</th>
         <td><c:out value="${param.ensenCd}"/></td>
       </tr>
       <tr>
         <th class="text-left">沿線名<BR>かな</th>
         <td><c:out value="${RosenInfoView.ensenName}"/><BR><c:out value="${RosenInfoView.ensenKana}"/></td>
       </tr>
       <tr>
         <th class="text-left">沿線略称<BR>略称かな</th>
         <td><c:out value="${RosenInfoView.ensennameShort}"/><BR><c:out value="${RosenInfoView.ensenkanaShort}"/></td>
       </tr>
       <tr>
         <th class="text-left">沿線シーケンス番号</th>
         <td><c:out value="${RosenInfoView.ensenSeq}"/></td>
       </tr>
       <tr>
         <th class="text-left">エリア</th>
         <td><c:out value="${RosenInfoView.areaName}"/></td>
       </tr>
       <tr>
         <th class="text-left">会社名</th>
         <td><c:out value="${RosenInfoView.railwaycoName}"/></td>
       </tr>
     </table>

     <!-- 駅情報一覧 -->
     <c:if test="${not empty RosenInfoView.rosenInfoList}">
     <p class="section_header">駅情報一覧</p>
     <table class="type_list">
       <colgroup>
        <col width="10%">
        <col width="10%">
        <col width="5%">
        <col width="5%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="15%">
        <col width="5%">
        <col width="10%">
        <col width="5%">
        <col width="5%">
       </colgroup>
       <tr>
        <th>駅コード</th>
        <th>駅名</th>
        <th>始発駅</th>
        <th>急行停車（※）</th>
        <th>駅シーケンス番号</th>
        <th>統一駅コード</th>
        <th>統一駅名称<BR>かな</th>
        <th>駅住所</th>
        <th>緯度<BR>経度</th>
        <th>最終更新日</th>
        <th>削除</th>
        <th>配布停止</th>
       </tr>
       <c:forEach items="${RosenInfoView.rosenInfoList}" var="rosenInfoList" varStatus="i">
         <tr>
          <td><c:out value="${rosenInfoList.ekiCd}"/></td>
          <td><c:out value="${rosenInfoList.ekiName}"/></td>
          <td><c:if test="${rosenInfoList.startekiFlg == '1'}">○</c:if></td>
          <td><c:if test="${rosenInfoList.stopFlg == '2'}">★</c:if></td>
          <td><c:out value="${rosenInfoList.ekiSeq}"/></td>
          <td><c:out value="${rosenInfoList.ekiNo}"/></td>
          <td><c:out value="${rosenInfoList.unionEkiName}"/><BR><c:out value="${rosenInfoList.unionEkiKana}"/></td>
          <td><c:out value="${rosenInfoList.ekiAddress}"/></td>
          <td><c:out value="${rosenInfoList.locationY}"/><BR><c:out value="${rosenInfoList.locationX}"/></td>
          <td><c:out value="${rosenInfoList.updDt}"/></td>
          <td><c:if test="${rosenInfoList.delKbn == '1'}"><font color="Red">○</font></c:if></td>
          <td><c:if test="${rosenInfoList.ekiUseStopFlg == '1'}"><font color="Red">○</font></c:if></td>
         </tr>
        </c:forEach>
      </table>
      <div align="right">※ ★がついている駅は急行等の列車が停車する駅です </div>
    </c:if>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
