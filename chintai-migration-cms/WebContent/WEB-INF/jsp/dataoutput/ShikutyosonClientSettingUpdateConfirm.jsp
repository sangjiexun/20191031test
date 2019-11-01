<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="市区町村別データ元除外設定更新確認" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
<html:form action="/dataoutput/ShikutyosonClientSettingUpdateCommit" method="post" onsubmit="disableSubmit(this)">
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/dataoutput/DataoutputIndex">他社データ連携出力設定</html:link> &gt;
      <html:link href="#" onclick="_submit('ShikutyosonClientSettingSearch.do');">市区町村検索</html:link> &gt;
      ${title}
    </div>

    <h1>${title}</h1>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <c:set var="view" value="${ShikutyosonClientSettingInfoView}" />
    <p class="section_header">
      ${title}：
      <c:out value="${view.dcoName}"></c:out>
    </p>
    <div class="add_form">
        <div class="form_space">
          <div  class="annotation_left">※■は、出力する設定となっているデータ元です</div>
          <table class="type_list" style="width: 99%;">
            <colgroup>
              <col width="10%">
              <col width="25%">
              <col width="65%">
            </colgroup>

            <tr>
              <th>都道府県</th>
              <th>市区町村</th>
              <th>設定値(※)</th>
            </tr>

<c:set var="clientsystemTypeMap" value="${view.clientsystemTypeMap}" />
<c:forEach items="${view.shikutyosonSearchList}" var="cityList" varStatus="i">
      <tr>
        <td><c:out value="${view.prefName}" /></td>
        <td class="left"><c:out value="${cityList.cityName}" /></td>
        <td align="left">
        <c:set var="crs" value="" />
		<c:if test="${clientsystemTypeMap[cityList.cityCd][0] eq '0'}">
			<c:set var="crs" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[cityList.cityCd][0] ne '0'}">
			<c:set var="crs" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${cityList.cityCd}_${clientsystemTypeMap[cityList.cityCd][0]}" />
		</c:if>

		<c:set var="ans" value="" />
		<c:if test="${clientsystemTypeMap[cityList.cityCd][1] eq '0'}">
			<c:set var="ans" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[cityList.cityCd][1] ne '0'}">
			<c:set var="ans" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${cityList.cityCd}_${clientsystemTypeMap[cityList.cityCd][1]}" />
		</c:if>

		<c:set var="able" value="" />
		<c:if test="${clientsystemTypeMap[cityList.cityCd][2] eq '0'}">
			<c:set var="able" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[cityList.cityCd][2] ne '0'}">
			<c:set var="able" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${cityList.cityCd}_${clientsystemTypeMap[cityList.cityCd][2]}" />
		</c:if>

		<c:set var="magazine" value="" />
		<c:if test="${clientsystemTypeMap[cityList.cityCd][3] eq '0'}">
			<c:set var="magazine" value="□" />
		</c:if>
		<c:if test="${clientsystemTypeMap[cityList.cityCd][3] ne '0'}">
			<c:set var="magazine" value="■" />
			<input type="hidden" name="clientsystemTypeArray" value="${cityList.cityCd}_${clientsystemTypeMap[cityList.cityCd][3]}" />
		</c:if>

        	${crs}CRS　　　　${ans}ANS　　　　${able}エイブル直営店　　　　${magazine}手書き
        </td>
      </tr>
</c:forEach>
    </table>
  </div>
  </div>
    <p>
      <c:forEach items="${view.shikutyosonSearchList}" var="cityList" varStatus="i">
      	<input type="hidden" name="cityCdArray" value="${cityList.cityCd}" />
      	<input type="hidden" name="cityNameArray" value="${cityList.cityName}" />
      </c:forEach>

      <input type="submit" value="更新" />
      <input type="button" value="戻る" onClick="_submit('ShikutyosonClientSettingUpdateBack.do');"/>
      <input type="hidden"  name="dcoType" value="${view.dcoType}">
      <input type="hidden"  name="dcoName" value="${view.dcoName}">
      <input type="hidden"  name="pref" value="${view.pref}">
      <input type="hidden"  name="city" value="${view.city}">
      <input type="hidden"  name="prefName" value="${view.prefName}">
      <input type="hidden"  name="parentalType" value="${view.parentalType}">
    </p>

  </div>
    </html:form>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>