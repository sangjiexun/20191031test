<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="沿線別データ元除外設定更新" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<c:set var="view" value="${RosenClientSettingSearchView}" />

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>


  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/dataoutput/DataoutputIndex">他社データ連携出力設定</html:link> &gt;
      <html:link href="#" onclick="_submit('RosenClientSettingSearch.do');">沿線・駅検索</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:messages id ="msg" header="info.header" footer="info.footer" message="true">
      <c:out value="${msg}"></c:out>
    </html:messages>
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />

    <p class="section_header">
      ${title}：
      <c:out value="${view.dcoName}"/>
    </p>

    <form action="RosenClientSettingUpdateConfirm.do" method="post" >
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
                <c:out value="${rosenList.ensenName}" /><BR><c:out value="${rosenList.ensenKana}" />
              </td>
              <td align="left">
                  <c:set var="crsChecked" value="" />
                <c:if test="${clientsystemTypeMap[rosenList.ensenCd][0] ne '0'}">
                    <c:set var="crsChecked" value="checked" />
                </c:if>

                <c:set var="ansChecked" value="" />
                <c:if test="${clientsystemTypeMap[rosenList.ensenCd][1] ne '0'}">
                    <c:set var="ansChecked" value="checked" />
                </c:if>

                <c:set var="ableChecked" value="" />
                <c:if test="${clientsystemTypeMap[rosenList.ensenCd][2] ne '0'}">
                    <c:set var="ableChecked" value="checked" />
                </c:if>

                <c:set var="magazineChecked" value="" />
                <c:if test="${clientsystemTypeMap[rosenList.ensenCd][3] ne '0'}">
                    <c:set var="magazineChecked" value="checked" />
                </c:if>

                <span id="allCheck">
                  <label><input type="checkbox" name="clientsystemTypeArray" id="checkArray_1_${i.index}" value="${rosenList.ensenCd}_1" onclick="changeCheck(${i.index})"${crsChecked}>CRS</label>　　
                  <label><input type="checkbox" name="clientsystemTypeArray" id="checkArray_2_${i.index}" value="${rosenList.ensenCd}_2" onclick="changeCheck(${i.index})"${ansChecked}>ANS</label>　　
                  <label><input type="checkbox" name="clientsystemTypeArray" id="checkArray_3_${i.index}" value="${rosenList.ensenCd}_3" onclick="changeCheck(${i.index})"${ableChecked}>エイブル直営店</label>　　
                  <label><input type="checkbox" name="clientsystemTypeArray" id="checkArray_4_${i.index}" value="${rosenList.ensenCd}_4" onclick="changeCheck(${i.index})"${magazineChecked}>手書き</label>
                  </span>

                  <label><input type="checkbox" id="all_${i.index}"  onClick="allChange(${i.index});" />全て</label>


              </td>
            </tr>
          </c:forEach>
        </table>
        </div>
      </div>

      <div class="add_form">
          <c:forEach items="${view.rosenSearchList}" var="rosenList" varStatus="i">
              <input type="hidden" name="ensenCdArray" value="${rosenList.ensenCd}" />
              <input type="hidden" name="ensenNameArray" value="${rosenList.ensenName}" />
              <input type="hidden" name="ensenKanaArray"  value="${rosenList.ensenKana}" />
          </c:forEach>
        <input type="submit" value="確認画面へ">
        <input type="button" value="戻る" onClick="_submit('RosenClientSettingSearch.do')">
        <input type="hidden"  name="areaCd" value="${view.areaCd}">
        <input type="hidden"  name="ensenType" value="${view.ensenType}">
        <input type="hidden"  name="dcoType" value="${view.dcoType}">
        <input type="hidden"  name="areaName" value="${view.areaName}">
        <input type="hidden"  name="dcoName" value="${view.dcoName}">
      </div>
    </form>
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
    var ensenCount = ${fn:length(view.rosenSearchList)};
    for(var i = 0; i < ensenCount; i++){
        changeCheck(i);
    }
}

//「全て」チェックボックス初期設定
addEvent('load', window, firstChangeCheck);

//-->
</script>
