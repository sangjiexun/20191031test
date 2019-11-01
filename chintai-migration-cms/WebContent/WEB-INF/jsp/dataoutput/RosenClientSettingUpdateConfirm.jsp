<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="沿線別データ元除外設定更新確認" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
<html:form action="/dataoutput/RosenClientSettingUpdateCommit" method="post" onsubmit="disableSubmit(this)">
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/dataoutput/DataoutputIndex">他社データ連携出力設定</html:link> &gt;
      <html:link href="#" onclick="_submit('RosenClientSettingSearch.do');">沿線・駅検索</html:link> &gt;
      ${title}
    </div>

    <h1>${title}</h1>

    <c:set var="view" value="${RosenClientSettingSearchView}" />
    <p class="section_header">
      ${title}：
      <c:out value="${view.dcoName}"/>
    </p>
    <div class="add_form">
        <div class="form_space">
          <div  class="annotation_left">※■は、出力する設定となっているデータ元です</div>
          <table class="type_list" style="width: 99%;">
            <colgroup>
              <col width="7%">
              <col width="7%">
              <col width="20%">
              <col width="66%">
            </colgroup>

            <tr>
              <th>エリア</th>
              <th>タイプ</th>
              <th>沿線名<br>かな</th>
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
          <c:out value="${rosenList.ensenName}"/><BR><c:out value="${rosenList.ensenKana}" />
        </td>
        <td align="left">
        <c:set var="crs" value="" />
		<c:if test="${clientsystemTypeMap[rosenList.ensenCd][0] eq '0'}">
			<c:set var="crs" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[rosenList.ensenCd][0] ne '0'}">
			<c:set var="crs" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${rosenList.ensenCd}_${clientsystemTypeMap[rosenList.ensenCd][0]}" />
		</c:if>

		<c:set var="ans" value="" />
		<c:if test="${clientsystemTypeMap[rosenList.ensenCd][1] eq '0'}">
			<c:set var="ans" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[rosenList.ensenCd][1] ne '0'}">
			<c:set var="ans" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${rosenList.ensenCd}_${clientsystemTypeMap[rosenList.ensenCd][1]}" />
		</c:if>

		<c:set var="able" value="" />
		<c:if test="${clientsystemTypeMap[rosenList.ensenCd][2] eq '0'}">
			<c:set var="able" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[rosenList.ensenCd][2] ne '0'}">
			<c:set var="able" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${rosenList.ensenCd}_${clientsystemTypeMap[rosenList.ensenCd][2]}" />
		</c:if>

		<c:set var="magazine" value="" />
		<c:if test="${clientsystemTypeMap[rosenList.ensenCd][3] eq '0'}">
			<c:set var="magazine" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[rosenList.ensenCd][3] ne '0'}">
			<c:set var="magazine" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${rosenList.ensenCd}_${clientsystemTypeMap[rosenList.ensenCd][3]}" />
		</c:if>

        	${crs}CRS　　　　${ans}ANS　　　　${able}エイブル直営店　　　　${magazine}手書き
        </td>
      </tr>
</c:forEach>
    </table>
  </div>
  </div>
    <p>
      <c:forEach items="${view.rosenSearchList}" var="rosenList" varStatus="i">
      	<input type="hidden" name="ensenCdArray" value="${rosenList.ensenCd}" />
      	<input type="hidden" name="ensenNameArray" value="${rosenList.ensenName}" />
      	<input type="hidden" name="ensenKanaArray"  value="${rosenList.ensenKana}" />
      </c:forEach>

      <input type="submit" value="更新" />
      <input type="button" value="戻る" onClick="_submit('RosenClientSettingUpdateBack.do');"/>
      <input type="hidden"  name="areaCd" value="${view.areaCd}">
      <input type="hidden"  name="ensenType" value="${view.ensenType}">
      <input type="hidden"  name="dcoType" value="${view.dcoType}">
      <input type="hidden"  name="areaName" value="${view.areaName}">
      <input type="hidden"  name="dcoName" value="${view.dcoName}">
    </p>

  </div>
    </html:form>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>