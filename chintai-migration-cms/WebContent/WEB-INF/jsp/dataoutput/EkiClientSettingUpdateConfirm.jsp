<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="駅別データ元除外設定更新確認" />
<c:set var="view" value="${EkiClientSettingInfoView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<%@ include file="../parts/PopUpContentsHeadline.jsp"%>
<%@ page import = "java.net.URLDecoder"%>

<div id="main">
<html:form action="/dataoutput/EkiClientSettingUpdateCommit" method="post" onsubmit="disableSubmit(this)">
  <div class="popup_layout">
    <div class="topic_path">
    <html:link href="#" onclick="_submit('EkiClientSettingInfo.do');">駅一覧</html:link>&gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">
      駅別データ元除外設定更新確認
      (
      <c:out value="${view.ensenName}"/>
      )：
      <c:out value="${view.dcoName}"/>
    </p>
    <div class="add_form">
        <div class="form_space">
          <div  class="annotation_left">※■は、出力する設定となっているデータ元です</div>
          <table class="type_list" style="width: 99%;">
            <colgroup>
              <col width="40%">
              <col width="60%">
            </colgroup>

            <tr>
              <th>駅名</th>
              <th>設定値(※)</th>
            </tr>

<c:set var="clientsystemTypeMap" value="${view.clientsystemTypeMap}" />
<c:forEach items="${view.ekiNameList}" var="ekiList" varStatus="i">
      <tr>
        <td>${ekiList.ekiName}</td>
        <td align="left">
        <c:set var="crs" value="" />
		<c:if test="${clientsystemTypeMap[ekiList.ekiCd][0] eq '0'}">
			<c:set var="crs" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[ekiList.ekiCd][0] ne '0'}">
			<c:set var="crs" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${ekiList.ekiCd}_${clientsystemTypeMap[ekiList.ekiCd][0]}" />
		</c:if>

		<c:set var="ans" value="" />
		<c:if test="${clientsystemTypeMap[ekiList.ekiCd][1] eq '0'}">
			<c:set var="ans" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[ekiList.ekiCd][1] ne '0'}">
			<c:set var="ans" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${ekiList.ekiCd}_${clientsystemTypeMap[ekiList.ekiCd][1]}" />
		</c:if>

		<c:set var="able" value="" />
		<c:if test="${clientsystemTypeMap[ekiList.ekiCd][2] eq '0'}">
			<c:set var="able" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[ekiList.ekiCd][2] ne '0'}">
			<c:set var="able" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${ekiList.ekiCd}_${clientsystemTypeMap[ekiList.ekiCd][2]}" />
		</c:if>

		<c:set var="magazine" value="" />
		<c:if test="${clientsystemTypeMap[ekiList.ekiCd][3] eq '0'}">
			<c:set var="magazine" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[ekiList.ekiCd][3] ne '0'}">
			<c:set var="magazine" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${ekiList.ekiCd}_${clientsystemTypeMap[ekiList.ekiCd][3]}" />
		</c:if>

        	${crs}CRS　　　　${ans}ANS　　　　${able}エイブル直営店　　　　${magazine}手書き
        </td>
      </tr>
</c:forEach>
    </table>
  </div>
  </div>
    <p>
      <c:forEach items="${view.ekiNameList}" var="ekiList" varStatus="i">
      	<input type="hidden" name="ekiCdArray" value="${ekiList.ekiCd}" />
      	<input type="hidden" name="ekiNameArray" value="${ekiList.ekiName}" />
      </c:forEach>

      <input type="submit" value="更新" />
      <input type="button" value="戻る" onClick="_submit('EkiClientSettingUpdateBack.do');"/>
      <input type="hidden"  name="dcoType" value="${view.dcoType}">
      <input type="hidden"  name="dcoName" value="${view.dcoName}">
      <input type="hidden" name="ensenCd" Value="${view.ensenCd}" >
      <input type="hidden" name="ensenName" Value="${view.ensenName}" >
      <input type="hidden" name="ensenType" Value="${view.ensenType}" >
      <input type="hidden" name="parentalType" Value="${view.parentalType}" >

    </p>

  </div>
    </html:form>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>