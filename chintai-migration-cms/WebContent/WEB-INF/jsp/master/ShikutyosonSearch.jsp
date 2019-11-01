<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="市区町村検索 " />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<script src="${pageContext.request.contextPath}/dwr/interface/AddressEnsenManager.js"></script>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>
<script type="text/javascript">
<!--
 function putCityList() {
    var thisForm = document.forms[1];
    var cityBlankData = [ {  cityCode:"", cityName:"" } ];
    var prefCode = dwr.util.getValue("pref");
    if(prefCode != "") {
      thisForm.city.disabled = false;
      AddressEnsenManager.getCityList(prefCode, function(ret) {
        dwr.util.removeAllOptions("city");
        //dwr.util.addOptions("city", cityBlankData, "cityCode", "cityName");
        dwr.util.addOptions("city", ret, "cityCode", "cityName");
      });
    } else {
      thisForm.city.disabled = true;
    }
  }
 function loadCityList() {
   var thisForm = document.forms[1];
   var cityBlankData = [ {  cityCode:null, cityName:"" } ];
   var city = '${param.city}';
   var pref = '${param.pref}';

     if(city != "") {
        AddressEnsenManager.getCityList(pref, function(ret) {
          dwr.util.removeAllOptions("city");
          //dwr.util.addOptions("city", cityBlankData, "cityCode", "cityName");
          dwr.util.addOptions("city", ret, "cityCode", "cityName");
          dwr.util.setValue("city", city);
          });
     } else {
    	  dwr.util.removeAllOptions("city");
          thisForm.city.disabled = true;
     }
 }

 function resetCityList() {
	loadCityList();
	 /*
    var thisForm = document.forms[1];
    dwr.util.removeAllOptions("city");
    thisForm.city.disabled = true;
    thisForm.reset();
    */
 }

 addEvent('load', window, loadCityList);
 addEvent('load', window, function(){document.getElementsByName('zipCd')[0].focus();});
//-->
</script>

<!-- メイン -->
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/master/ShikutyosonIndexPage">市区町村メンテナンス </html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
    <p class="section_header">郵便番号から検索</p>
    <html:form action="/master/ShikutyosonPostSearch" method="get">
      <table class="type_searchbox">
        <tr>
          <td>
            郵便番号
            <input type="text" name="zipCd" size="7" maxlength="7" value="${param.zipCd}">&nbsp;&nbsp;
            <input type="submit" value="検索">
            <input type="reset" value="クリア">
          </td>
        </tr>
      </table>
    </html:form>
    <html:form action="/master/ShikutyosonAddressSearch" method="get">
    <p class="section_header">名称から検索</p>
      <table class="type_searchbox">
        <tr>
          <td>
            住所
            <chintai:Todofuken name="pref" onChange="putCityList();" fixValue="${param.pref}"/>
            <select name="city" style="width:150px" id="city">
            </select>
            &nbsp;
            <input type="submit" value="検索">
            <input type="reset" value="クリア" onClick="resetCityList()">
          </td>
        </tr>
      </table>
    </html:form>

   <c:if test="${not empty ShikutyosonSearchListView.shikutyosonList}" >
     <p class="section_header">検索結果一覧</p>
       <table class="type_list">
         <colgroup>
           <col width="8%">
           <col width="8%">
           <col width="8%">
           <col width="8%">
           <col width="26%">
           <col width="42%">
         </colgroup>
         <tr>
           <th>郵便番号</th>
           <th>都道府県<br>コード</th>
           <th>都道府県</th>
           <th>市区町村<br>コード</th>
           <th>市区町村</th>
           <th>町域</th>
         </tr>
       <c:forEach items="${ShikutyosonSearchListView.shikutyosonList}" var="list">
         <tr>
           <td><c:out value="${list.zipCd}" /></td>
           <td><c:out value="${list.prefcd}" /></td>
           <td class="left"><c:out value="${list.prefName}" /></td>
           <td><c:out value="${list.citycd}" /></td>
           <td class="left"><c:out value="${list.cityName}" /></td>
           <td class="left"><c:out value="${list.machiikiName}" /></td>
         </tr>
       </c:forEach>
       </table>
    </c:if>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
