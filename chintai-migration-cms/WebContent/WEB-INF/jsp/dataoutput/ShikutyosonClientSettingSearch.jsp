<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="市区町村検索 " />
<c:set var="view" value="${ShikutyosonClientSettingInfoView}"/>
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<script src="${pageContext.request.contextPath}/dwr/interface/AddressEnsenManager.js"></script>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>
<script src="${pageContext.request.contextPath}/dwr/interface/DcoTypeManager.js"></script>

<fmt:setBundle basename="resources.SystemProperties" var="resource" />

<fmt:message bundle="${resource}" key="SHIKUTYOSON_DCO_TYPE_VALUE"  var="docTypes"/>

<%
	String dcoType = request.getParameter("dcoType");
%>

<script type="text/javascript">
<!--
 function putCityList() {
    var thisForm = document.forms[0];
    var cityBlankData = [ {  cityCode:"", cityName:"" } ];
    var prefCode = dwr.util.getValue("pref");
    if(prefCode != "") {
      thisForm.city.disabled = false;
      AddressEnsenManager.getCityList(prefCode, function(ret) {
        dwr.util.removeAllOptions("city");
        dwr.util.addOptions("city", cityBlankData, "cityCode", "cityName");
        dwr.util.addOptions("city", ret, "cityCode", "cityName");
      });
    } else {
      thisForm.city.disabled = true;
    }
  }
 function loadCityList() {
   var thisForm = document.forms[0];
   var cityBlankData = [ {  cityCode:"", cityName:"" } ];
   var city = '${param.city}';
   var pref = '${param.pref}';

     if(pref != "") {
        AddressEnsenManager.getCityList(pref, function(ret) {
          dwr.util.setValue("pref", pref);

          dwr.util.removeAllOptions("city");
          dwr.util.addOptions("city", cityBlankData, "cityCode", "cityName");
          dwr.util.addOptions("city", ret, "cityCode", "cityName");
          dwr.util.setValue("city", city);
          });
     } else {
    	 dwr.util.removeAllOptions("city");
     }
 }

 function initCityList() {
	 putCityList();
 }

 var paramPref = '${param.pref}';

 function resetCityList() {
	 if(paramPref != ""){//一度検索したとき
		 loadDcoTypeList();
		 loadCityList();
	 }else{//検索ボタンを押していないとき
		 loadDcoTypeList();
		 dwr.util.setValue("pref", "");
		 dwr.util.removeAllOptions("city");

		 var thisForm = document.forms[0];
		 thisForm.city.disabled = true;
	 }
 }

 function loadDcoTypeList(){
		DcoTypeManager.getDcoTypeList("${docTypes}", function(ret) {
		       dwr.util.removeAllOptions("dcoType");
		       dwr.util.addOptions("dcoType", ret, "dcoType", "dcoName");
		       dwr.util.setValue("dcoType", "<%=dcoType%>");
		   });
	}

 addEvent('load', window, loadDcoTypeList);

 if(paramPref != ""){//一度検索したとき
 	addEvent('load', window, loadCityList);
 }else{//検索ボタンを押していないとき
	addEvent('load', window, initCityList);
 }

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

    <html:form action="/dataoutput/ShikutyosonClientSettingSearch" method="post">
    <p class="section_header">検索条件設定</p>
      <table class="type_searchbox">
        <tr>
          <td>
            連携対象一覧
            <select name="dcoType" style="width: 80px" id="dcoType">
            </select>
          </td>
          <td>
            住所
            <chintai:Todofuken name="pref" onChange="putCityList();" fixValue="${param.pref}"/>
            <select name="city" style="width:150px" id="city">
            </select>
            &nbsp;
            <input type="submit" value="検索">
            <input type="button" value="クリア" onClick="resetCityList()">
          </td>
        </tr>
      </table>
    </html:form>


   <c:if test="${not empty view.shikutyosonSearchList}" >

     <p class="section_header">検索結果一覧</p>
     <p>
      <html:link href="#" onclick="_submit('ShikutyosonClientSettingUpdate.do');">
        &gt;&gt; 市区町村別データ元出力設定を更新する
      </html:link>
     </p>

     <div  class="annotation_left">※■は、出力する設定となっているデータ元です</div>
       <table class="type_list">
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
       <c:forEach items="${view.shikutyosonSearchList}" var="cityList">
         <tr>
           <td ><c:out value="${view.prefName}" /></td>
           <td class="left"><c:out value="${cityList.cityName}" /></td>
            <c:set var="crs" value="" />
            <c:if test="${clientsystemTypeMap[cityList.cityCd][0] eq '0'}">
                <c:set var="crs" value="□" />
            </c:if>
            <c:if test="${clientsystemTypeMap[cityList.cityCd][0] ne '0'}">
                <c:set var="crs" value="■" />
            </c:if>

            <c:set var="ans" value="" />
            <c:if test="${clientsystemTypeMap[cityList.cityCd][1] eq '0'}">
                <c:set var="ans" value="□" />
            </c:if>
            <c:if test="${clientsystemTypeMap[cityList.cityCd][1] ne '0'}">
                <c:set var="ans" value="■" />
            </c:if>

            <c:set var="able" value="" />
            <c:if test="${clientsystemTypeMap[cityList.cityCd][2] eq '0'}">
                <c:set var="able" value="□" />
            </c:if>
            <c:if test="${clientsystemTypeMap[cityList.cityCd][2] ne '0'}">
                <c:set var="able" value="■" />
            </c:if>

            <c:set var="magazine" value="" />
            <c:if test="${clientsystemTypeMap[cityList.cityCd][3] eq '0'}">
                <c:set var="magazine" value="□" />
            </c:if>
            <c:if test="${clientsystemTypeMap[cityList.cityCd][3] ne '0'}">
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

