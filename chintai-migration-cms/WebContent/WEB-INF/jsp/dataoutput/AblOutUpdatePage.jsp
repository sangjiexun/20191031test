<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="エイブル担当店/取扱店出力情報設定更新 " />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<c:set var="view" value="${AblOutSettingView}" />

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>


  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/dataoutput/DataoutputIndex">他社データ連携出力設定</html:link> &gt;
      <html:link action="/dataoutput/AblOutSettingInfo">エイブル担当店/取扱店出力情報設定</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:messages id ="msg" header="info.header" footer="info.footer" message="true">
      <c:out value="${msg}"></c:out>
    </html:messages>
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />

    <p class="section_header">エイブル担当店/取扱店出力情報設定更新</p>

    <form action="AblOutUpdateConfirm.do" method="post" >
      <div class="add_form">
        <div class="form_space">
          <table class="type_list" style="width: 99%;" id="viewTeble">
            <colgroup>
              <col width="40%">
              <col width="60%">
            </colgroup>

            <tr>
              <th>データ連携対象</th>
              <th>設定値</th>
            </tr>

            <c:forEach items="${view.ablSettingViewList}" var="ablSettingViewList" varStatus="i">
              <tr>
                <c:set var="onlyChecked" value="" />
                <c:set var="allChecked" value="" />
                <c:if test="${ablSettingViewList.bukkenOutKbn == '1'}">
                  <c:set var="onlyChecked" value="checked" />
                </c:if>
                <c:if test="${ablSettingViewList.bukkenOutKbn != '1'}">
                  <c:set var="allChecked" value="checked" />
                </c:if>
                <td>
                  <c:out value="${ablSettingViewList.dcoName}"/>
                  <input type="hidden" name="dcoTypeArray" value="${ablSettingViewList.dcoType}">
                  <input type="hidden" name="updDtArray" value="${ablSettingViewList.updDt}">
                  <input type="hidden" name="dcoNameArray" value="${ablSettingViewList.dcoName}">
                </td>
                <td>
                  <label><input type="radio" name="bukkenOutKbn_${i.index}" value="0" ${allChecked}><chintai:CodePrint nameKey="BUKKEN_OUT_KBN_NAME" valueKey="BUKKEN_OUT_KBN_VALUE" code="0"/></label>
                  <label><input type="radio" name="bukkenOutKbn_${i.index}" value="1" ${onlyChecked}><chintai:CodePrint nameKey="BUKKEN_OUT_KBN_NAME" valueKey="BUKKEN_OUT_KBN_VALUE" code="1"/></label>
                </td>
              </tr>
            </c:forEach>
          </table>
        </div>
        <input type="submit" value="確認画面へ" onclick="radioGet()">
        <input type="button" value="戻る" onClick="_submit('AblOutSettingInfo.do')">
        <input type="hidden" name="bukkenOutKbnArray" value="">
      </div>
    </form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>


<script language="JavaScript" type="text/javascript">
<!--

function radioGet(){
    // bukkenOutKbnの値を取得し、配列に設定する
    var bukkenOutKbnList = new Array();
    var i = 0;

    while(true){
        var kbnName = "bukkenOutKbn_" + i;
        var bukkenOutKbn = document.getElementsByName(kbnName);
        if (bukkenOutKbn.length == 0){
            break;
        } else {
            for (var r = 0 ; r < bukkenOutKbn.length; r++){
                if (bukkenOutKbn[r].checked){
                    bukkenOutKbnList.push(bukkenOutKbn[r].value);
                }
            }
        }
        i++;
    }

    document.forms[0].bukkenOutKbnArray.value = bukkenOutKbnList;
}
//-->
</script>


