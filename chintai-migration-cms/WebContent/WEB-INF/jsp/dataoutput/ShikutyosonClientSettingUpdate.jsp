<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="市区町村別データ元除外設定更新" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<c:set var="view" value="${ShikutyosonClientSettingInfoView}" />

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>


  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/dataoutput/DataoutputIndex">他社データ連携出力設定</html:link> &gt;
      <html:link href="#" onclick="_submit('ShikutyosonClientSettingSearch.do');">市区町村検索</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <p class="section_header">
      ${title}：
      <c:out value="${view.dcoName}"></c:out>
    </p>

    <html:form action="/dataoutput/ShikutyosonClientSettingUpdateConfirm.do" method="post" >
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
              	<c:set var="crsChecked" value="" />
				<c:if test="${clientsystemTypeMap[cityList.cityCd][0] ne '0'}">
					<c:set var="crsChecked" value="checked" />
				</c:if>

				<c:set var="ansChecked" value="" />
				<c:if test="${clientsystemTypeMap[cityList.cityCd][1] ne '0'}">
					<c:set var="ansChecked" value="checked" />
				</c:if>

				<c:set var="ableChecked" value="" />
				<c:if test="${clientsystemTypeMap[cityList.cityCd][2] ne '0'}">
					<c:set var="ableChecked" value="checked" />
				</c:if>

				<c:set var="magazineChecked" value="" />
				<c:if test="${clientsystemTypeMap[cityList.cityCd][3] ne '0'}">
					<c:set var="magazineChecked" value="checked" />
				</c:if>

				<span id="allCheck">
              	<label><input type="checkbox" name="clientsystemTypeArray" id="checkArray_1_${i.index}" value="${cityList.cityCd}_1" onclick="changeCheck(${i.index})"${crsChecked}>CRS</label>　　
              	<label><input type="checkbox" name="clientsystemTypeArray" id="checkArray_2_${i.index}" value="${cityList.cityCd}_2" onclick="changeCheck(${i.index})"${ansChecked}>ANS</label>　　
              	<label><input type="checkbox" name="clientsystemTypeArray" id="checkArray_3_${i.index}" value="${cityList.cityCd}_3" onclick="changeCheck(${i.index})"${ableChecked}>エイブル直営店</label>　　
              	<label><input type="checkbox" name="clientsystemTypeArray" id="checkArray_4_${i.index}" value="${cityList.cityCd}_4" onclick="changeCheck(${i.index})"${magazineChecked}>手書き</label>
              	</span>

              	<label><input type="checkbox" id="all_${i.index}"  onClick="allChange(${i.index});" />全て</label>


              </td>
            </tr>
</c:forEach>
        </table>
        </div>
      </div>

      <div class="add_form">
      	<c:forEach items="${view.shikutyosonSearchList}" var="cityList" varStatus="i">
      		<input type="hidden" name="cityCdArray" value="${cityList.cityCd}" />
      		<input type="hidden" name="cityNameArray" value="${cityList.cityName}" />
      	</c:forEach>
        <input type="submit" value="確認画面へ">
        <input type="button" value="戻る" onClick="_submit('ShikutyosonClientSettingSearch.do')">
        <input type="hidden"  name="dcoType" value="${view.dcoType}">
        <input type="hidden"  name="dcoName" value="${view.dcoName}">
        <input type="hidden"  name="pref" value="${view.pref}">
        <input type="hidden"  name="city" value="${view.city}">
        <input type="hidden"  name="prefName" value="${view.prefName}">
        <input type="hidden"  name="parentalType" value="${view.parentalType}">
      </div>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>


<script language="JavaScript" type="text/javascript">
<!--

function allChange(checkArrayNumber){
    // 都道府県別のチェックボックスを全選択/全解除する処理
    var all = "all_" + checkArrayNumber;
    var check = document.getElementById(all).checked;
    var allCount = document.getElementById("allCheck").children.length;

    for (var index = 1; index <= allCount; index++){
        var checkArray = "checkArray_"+ index +"_" + checkArrayNumber;
        var elem = document.getElementById(checkArray);
        elem.checked = check;
    }
}

function changeCheck(checkArrayNumber){
    // 各要素のチェックボックスを判別し、「全て」のチェックボックスをON、OFFする処理
    var all = "all_" + checkArrayNumber;
    var allCheck = document.getElementById(all);
    var allCount = document.getElementById("allCheck").children.length;
    var checkBox = true;

    for (var index = 1; index <= allCount; index++){
        var checkArray = "checkArray_"+ index +"_" + checkArrayNumber;
        var elem = document.getElementById(checkArray);
        if(elem.checked == false){
            checkBox = false;
            break;
        }
    }
    allCheck.checked = checkBox;
}

function firstChangeCheck(){
    //「全て」チェックボックスの初期設定処理
    var cityCount = ${fn:length(view.shikutyosonSearchList)};
    for(var i = 0; i < cityCount; i++){
        changeCheck(i);
    }
}

//「全て」チェックボックス初期設定
addEvent('load', window, firstChangeCheck);

//-->
</script>
