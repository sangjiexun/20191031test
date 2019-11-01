<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="都道府県別データ元出力設定更新" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
<html:form action="/dataoutput/PrefClientupdateCommit" method="post" onsubmit="disableSubmit(this)">
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/dataoutput/DataoutputIndex">他社データ連携出力設定</html:link> &gt;
      <html:link href="#" onclick="_submit('PrefClientSettingInfo.do');">都道府県別データ元出力設定</html:link> &gt;
      都道府県別データ元出力設定更新
    </div>

    <h1>${title}</h1>

    <c:set var="view" value="${PrefClientSettingInfoView}" />
    <p class="section_header">
      更新内容確認：
      <c:out value="${view.dcoName}"/>
    </p>
    <div class="add_form">
        <div class="form_space">
          <div  class="annotation_left">※■は、出力する設定となっているデータ元です</div>
          <table class="type_list" style="width: 99%;">
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
        <td>${prefNameList.prefname}</td>
        <td align="left">
        <c:set var="crs" value="" />
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][0] eq '0'}">
			<c:set var="crs" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][0] ne '0'}">
			<c:set var="crs" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${prefNameList.prefcd}_${clientsystemTypeMap[prefNameList.prefcd][0]}" />
		</c:if>

		<c:set var="ans" value="" />
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][1] eq '0'}">
			<c:set var="ans" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][1] ne '0'}">
			<c:set var="ans" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${prefNameList.prefcd}_${clientsystemTypeMap[prefNameList.prefcd][1]}" />
		</c:if>

		<c:set var="able" value="" />
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][2] eq '0'}">
			<c:set var="able" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][2] ne '0'}">
			<c:set var="able" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${prefNameList.prefcd}_${clientsystemTypeMap[prefNameList.prefcd][2]}" />
		</c:if>

		<c:set var="magazine" value="" />
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][3] eq '0'}">
			<c:set var="magazine" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[prefNameList.prefcd][3] ne '0'}">
			<c:set var="magazine" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${prefNameList.prefcd}_${clientsystemTypeMap[prefNameList.prefcd][3]}" />
		</c:if>

        	${crs}CRS　　　　${ans}ANS　　　　${able}エイブル直営店　　　　${magazine}手書き
        </td>
      </tr>
</c:forEach>
    </table>
  </div>
  </div>
    <p>
      <c:forEach items="${view.prefNameList}" var="prefNameList" varStatus="i">
      	<input type="hidden" name="prefcdArray" value="${prefNameList.prefcd}" />
      	<input type="hidden" name="prefnameArray" value="${prefNameList.prefname}" />
      </c:forEach>

      <input type="submit" value="更新" />
      <input type="button" value="戻る" onClick="_submit('PrefClientUpdateBack.do');"/>
      <input type="hidden"  name="dcoType" value="${view.dcoType}">
      <input type="hidden"  name="dcoName" value="${view.dcoName}">
    </p>

  </div>
    </html:form>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>