<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="駅別データ元除外設定更新 " />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<%@ include file="../parts/PopUpContentsHeadline.jsp"%>
<%@ page import = "java.net.URLDecoder"%>

<c:set var="view" value="${EkiClientSettingInfoView}" />

<div id="main">

  <div class="popup_layout">
    <div class="topic_path">
    <html:link href="#" onclick="_submit('EkiClientSettingInfo.do');">駅一覧</html:link>&gt;
      ${title}
    </div>

    <h1>${title}</h1>

    <p class="section_header">
      駅別データ元除外設定更新
      (
      <c:out value="${view.ensenName}"/>
      )：
      <c:out value="${view.dcoName}"/>
    </p>

    <html:form action="/dataoutput/EkiClientSettingUpdateConfirm" method="post" >
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
              <td><c:out value="${ekiList.ekiName}" /></td>
              <td align="left">
              	<c:set var="crsChecked" value="" />
				<c:if test="${clientsystemTypeMap[ekiList.ekiCd][0] ne '0'}">
					<c:set var="crsChecked" value="checked" />
				</c:if>

				<c:set var="ansChecked" value="" />
				<c:if test="${clientsystemTypeMap[ekiList.ekiCd][1] ne '0'}">
					<c:set var="ansChecked" value="checked" />
				</c:if>

				<c:set var="ableChecked" value="" />
				<c:if test="${clientsystemTypeMap[ekiList.ekiCd][2] ne '0'}">
					<c:set var="ableChecked" value="checked" />
				</c:if>

				<c:set var="magazineChecked" value="" />
				<c:if test="${clientsystemTypeMap[ekiList.ekiCd][3] ne '0'}">
					<c:set var="magazineChecked" value="checked" />
				</c:if>

				<span id="allCheck">
              	<label><input type="checkbox" name="clientsystemTypeArray" id="checkArray_1_${i.index}" value="${ekiList.ekiCd}_1" onclick="changeCheck(${i.index})"${crsChecked}>CRS</label>　　
              	<label><input type="checkbox" name="clientsystemTypeArray" id="checkArray_2_${i.index}" value="${ekiList.ekiCd}_2" onclick="changeCheck(${i.index})"${ansChecked}>ANS</label>　　
              	<label><input type="checkbox" name="clientsystemTypeArray" id="checkArray_3_${i.index}" value="${ekiList.ekiCd}_3" onclick="changeCheck(${i.index})"${ableChecked}>エイブル直営店</label>　　
              	<label><input type="checkbox" name="clientsystemTypeArray" id="checkArray_4_${i.index}" value="${ekiList.ekiCd}_4" onclick="changeCheck(${i.index})"${magazineChecked}>手書き</label>
              	</span>

              	<label><input type="checkbox" id="all_${i.index}"  onClick="allChange(${i.index});" />全て</label>


              </td>
            </tr>
</c:forEach>
        </table>
        </div>
      </div>

      <div class="add_form">
      	<c:forEach items="${view.ekiNameList}" var="ekiList" varStatus="i">
      		<input type="hidden" name="ekiCdArray" value="${ekiList.ekiCd}" />
      		<input type="hidden" name="ekiNameArray" value="${ekiList.ekiName}" />
      	</c:forEach>
        <input type="submit" value="確認画面へ">
        <input type="button" value="戻る" onClick="_submit('EkiClientSettingInfo.do')">
        <input type="hidden"  name="dcoType" value="${view.dcoType}">
        <input type="hidden"  name="dcoName" value="${view.dcoName}">
        <input type="hidden" name="ensenCd" Value="${view.ensenCd}" >
        <input type="hidden" name="ensenName" Value="${view.ensenName}" >
        <input type="hidden" name="ensenType" Value="${view.ensenType}" >
        <input type="hidden" name="parentalType" Value="${view.parentalType}" >

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
    var prefCount = ${fn:length(view.ekiNameList)};
    for(var i = 0; i < prefCount; i++){
        changeCheck(i);
    }
}

//「全て」チェックボックス初期設定
addEvent('load', window, firstChangeCheck);

//-->
</script>
