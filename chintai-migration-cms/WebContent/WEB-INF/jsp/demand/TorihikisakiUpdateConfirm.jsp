<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="取引先情報更新" />
<c:set var="view"  value="${TorihikisakiUpdateView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--
 var newWin;

 function openFudousanSearch() {
   newWin = window.open("","FudousanSearchForUpdate", "width=800,height=600,scrollbars=yes,toolbar=no,menubar=no,resizable=yes,status=yes");
   newWin.document.location.href="FudousanSearchForRefPage.do";
 }


 function closeChildWindow(obj){

  disableSubmit(obj);

  try{
    if(newWin) { // newWinがObjectだったら以下を実行
      newWin.window.close()
    };
  } catch(e) {
  }
 }

addEvent('load', window, function(){document.getElementsByName('backButton')[0].focus();});
-->
</script>

<!-- メイン -->
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="demand/TorihikisakiInfo.do" paramId="torihikisakiSeq" paramName="view" paramProperty="torihikisakiSeq">取引先詳細</html:link>
      &gt;<c:out value="${title}"></c:out>
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <html:form action="demand/TorihikisakiUpdateCommit.do" onsubmit="closeChildWindow(this);">
    <p class="section_header">取引先情報</p>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="20%">
        <col span="1" width="*">
      </colgroup>
      <tr>
       <th>不動産会社名</th>
       <td><c:out value="${view.fudousanName}"/></td>
      </tr>
      <tr>
       <th>取引先名</th>
       <td><c:out value="${view.torihikisakiName}"/></td>
      </tr>
      <tr>
       <th rowspan="4">住所</th>
       <td>
         <c:if test="${not empty view.zipCd1}">
           〒<c:out value="${view.zipCd1}"/>-<c:out value="${view.zipCd2}"/>
         </c:if>
         &nbsp;
       </td>
      </tr>
      <tr>
       <td ><c:out value="${view.prefName}"/>&nbsp;</td>
      </tr>
      <tr>
       <td ><c:out value="${view.address1}"/>&nbsp;</td>
      </tr>
      <tr>
       <td ><c:out value="${view.address2}"/>&nbsp;</td>
      </tr>
      <tr>
       <th>電話番号</th>
       <td><c:out value="${view.tel}"/></td>
      </tr>
      <tr>
       <th>FAX番号</th>
       <td><c:out value="${view.fax}"/></td>
      </tr>
      <tr>
       <th>担当者名</th>
       <td ><c:out value="${view.tantou}"/></td>
      </tr>
      <tr>
       <th>取引担当支社</th>
       <td ><c:out value="${view.shisyaName}"/></td>
      </tr>
    </table>
  <div class="add_form">
    <input type="hidden" name="fudousanName"     value="${fn:escapeXml(view.fudousanName)}" >
    <input type="hidden" name="fudousanCd"       value="${view.fudousanCd}" >
    <input type="hidden" name="oldFudousanCd"   value="${view.oldFudousanCd}">
    <input type="hidden" name="torihikisakiName" value="${fn:escapeXml(view.torihikisakiName)}" >
    <input type="hidden" name="torihikisakiCd"   value="${view.torihikisakiCd}" >
    <input type="hidden" name="torihikisakiSeq"  value="${view.torihikisakiSeq}">
    <input type="hidden" name="zipCd1"           value="${view.zipCd1}" >
    <input type="hidden" name="zipCd2"           value="${view.zipCd2}" >
    <input type="hidden" name="prefCd"           value="${view.prefCd}" >
    <input type="hidden" name="prefName"         value="${fn:escapeXml(view.prefName)}" >
    <input type="hidden" name="address1"         value="${fn:escapeXml(view.address1)}" >
    <input type="hidden" name="address2"         value="${fn:escapeXml(view.address2)}" >
    <input type="hidden" name="tel"              value="${view.tel}" >
    <input type="hidden" name="fax"              value="${view.fax}" >
    <input type="hidden" name="tantou"           value="${fn:escapeXml(view.tantou)}" >
    <input type="hidden" name="shisyaName"       value="${fn:escapeXml(view.shisyaName)}" >
    <input type="hidden" name="shisyaCd"         value="${view.shisyaCd}" >
    <input type="hidden" name="updDt"            value="${view.updDt}" >
    <input type="submit" value="更新" >
    <input type="button" name="backButton" value="戻る" onClick="_submit('TorihikisakiUpdatePageBack.do');">
  </div>
  </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>