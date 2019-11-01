<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="取引先 物件枠設定情報更新" />
<c:set var="view"  value="${TorihikisakiWakuInfoUpdateView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--

 function checkBukkenCnt(obj){
   if (obj.value == '999999') {
     enableText('bukkenCntNote');
   } else {
     disableText('bukkenCntNote');
   }
 }

 function chechTokusenCnt(obj){
   if (obj.value == '999999') {
     enableText('tokusenCntNote');
   } else {
     disableText('tokusenCntNote');
   }
 }

 function disableText(objName){
     obj = document.getElementsByName(objName)[0]
     obj.readOnly = true;
     obj.style.background="#cccccc";
 }

 function enableText(objName){
     obj = document.getElementsByName(objName)[0]
     obj.readOnly = false;
     obj.style.background="#ffffff";
     obj.focus();
 }

 function numCheck(input){
   var filter = /^[0-9]*$/;
   if (filter.test(input)) {
      return true;
   } else {
      return false;
   }
 }

 function fieldChecker(){
   bukkenChecker = numCheck(document.forms[0].bukkenCntNote.value);
   tokusenChecker = numCheck(document.forms[0].tokusenCntNote.value);
   document.forms[0].bukkenCntChecker.value = bukkenChecker;
   document.forms[0].tokusenCntChecker.value = tokusenChecker;

 }

 function setSubmit(){
   fieldChecker();
 }

 addEvent('load', window, function(){document.getElementsByName('bukkenCnt')[0].focus();});
-->
</script>

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

    <p class="section_header">取引先情報</p>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="20%" class="type_detail_head" >
        <col span="1" width="30%" class="type_detail_body" >
        <col span="1" width="20%" class="type_detail_head" >
        <col span="1" width="30%" class="type_detail_body" >
      </colgroup>
      <tr>
        <th>不動産会社名</th>
        <td colspan="3"><c:out value="${view.fudousanName}" /></td>
      </tr>
      <tr>
        <th>取引先名</th>
        <td><c:out value="${view.torihikisakiName}" /></td>
        <th>取引先コード</th>
        <td><c:out value="${view.fudousanCd}" />-<c:out value="${view.torihikisakiCd}" /></td>
      </tr>
      <tr>
        <th rowspan="4">住所</th>
        <td colspan="3">
          <c:if test="${not empty view.zipCd}">
            〒<c:out value="${view.zipCd}"/>
          </c:if>&nbsp;
        </td>
      </tr>
      <tr>
        <td colspan="3"><c:out value="${view.prefName}" />&nbsp;</td>
      </tr>
      <tr>
        <td colspan="3"><c:out value="${view.address1}" />&nbsp;</td>
      </tr>
      <tr>
        <td colspan="3"><c:out value="${view.address2}" />&nbsp;</td>
      </tr>
      <tr>
        <th>電話番号</th>
        <td><c:out value="${view.tel}" /></td>
        <th>FAX番号</th>
        <td><c:out value="${view.fax}" /></td>
      </tr>
      <tr>
        <th>担当者名</th>
        <td colspan="3"><c:out value="${view.tantou}" /></td>
      </tr>
      <tr>
        <th>取引担当支社</th>
        <td colspan="3"><c:out value="${view.shisya}" /></td>
      </tr>
      <tr>
        <th>登録日</th>
        <td><c:out value="${view.insDt}" /></td>
        <th>更新日</th>
        <td><c:out value="${view.updDt}" /></td>
      </tr>
    </table>

  <p class="section_header">物件枠設定情報</p>
  <html:form action="demand/TorihikisakiWakuInfoUpdateConfirm.do" onsubmit="setSubmit();">
    <div class="add_form">
      <div class="add_form_title">適用月<span class="caution">*</span></div>
      <div class="annotation">適用月の変更は行えません。</div>
      <div class="form_space">
        <c:out value="${view.startYmForDisplay}"></c:out>
      </div>
    </div>
    <div class="add_form">
      <div class="add_form_title">物件枠<span class="caution">*</span></div>
      <div class="annotation">物件枠として設定する件数を選択します。
        <br>その他を選択することで、件数の自由記入を行うことができます。
      </div>
      <div class="form_space">
        <c:choose>
          <c:when test="${empty view.bukkenCnt or view.bukkenCnt eq '100'}">
            <label><input type="radio" name="bukkenCnt" maxlength="5" size="3" value="100" onclick="checkBukkenCnt(this);" checked>１００件</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="bukkenCnt" maxlength="5" size="3" value="100" onclick="checkBukkenCnt(this);">１００件</label>
          </c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${view.bukkenCnt eq '200'}">
            <label><input type="radio" name="bukkenCnt" maxlength="5" size="3" value="200" onclick="checkBukkenCnt(this);" checked>２００件</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="bukkenCnt" maxlength="5" size="3" value="200" onclick="checkBukkenCnt(this);">２００件</label>
          </c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${view.bukkenCnt eq '300'}">
            <label><input type="radio" name="bukkenCnt" maxlength="5" size="3" value="300" onclick="checkBukkenCnt(this);" checked>３００件</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="bukkenCnt" maxlength="5" size="3" value="300" onclick="checkBukkenCnt(this);">３００件</label>
          </c:otherwise>
        </c:choose>
        <br>
        <c:choose>
          <c:when test="${view.bukkenCnt eq '400'}">
            <label><input type="radio" name="bukkenCnt" maxlength="5" size="3" value="400" onclick="checkBukkenCnt(this);" checked>４００件</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="bukkenCnt" maxlength="5" size="3" value="400" onclick="checkBukkenCnt(this);">４００件</label>
          </c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${view.bukkenCnt eq '500'}">
            <label><input type="radio" name="bukkenCnt" maxlength="5" size="3" value="500" onclick="checkBukkenCnt(this);" checked>５００件</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="bukkenCnt" maxlength="5" size="3" value="500" onclick="checkBukkenCnt(this);">５００件</label>
          </c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${view.bukkenCnt eq '999999'}">
            <label><input type="radio" name="bukkenCnt" maxlength="5" size="3" value="999999" onclick="checkBukkenCnt(this);" checked>その他</label>
            <input type="text" name="bukkenCntNote" maxlength="4" size="4" value="${view.bukkenCntNote}">件
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="bukkenCnt" maxlength="5" size="3" value="999999" onclick="checkBukkenCnt(this);">その他</label>
            <input type="text" name="bukkenCntNote" maxlength="4" size="4" value="${view.bukkenCntNote}" style="background-color:#CCCCCC" readonly>件
          </c:otherwise>
        </c:choose>
      </div>
    </div>
    <div class="add_form">
      <div class="add_form_title">リスティング枠<span class="caution">*</span></div>
      <div class="annotation">物件リスティングとして設定する件数を選択します。
        <br>その他を選択することで、件数の自由記入を行うことができます。
      </div>
      <div>
        <c:choose>
          <c:when test="${empty view.tokusenCnt or view.tokusenCnt eq '0'}">
            <label><input type="radio" name="tokusenCnt" size="3" value="0"  onclick="chechTokusenCnt(this);" checked>０件</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="tokusenCnt" size="3" value="0"  onclick="chechTokusenCnt(this);">０件</label>
          </c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${view.tokusenCnt eq '10'}">
            <label><input type="radio" name="tokusenCnt" size="3" value="10" onclick="chechTokusenCnt(this);" checked>１０件</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="tokusenCnt" size="3" value="10" onclick="chechTokusenCnt(this);">１０件</label>
          </c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${view.tokusenCnt eq '20'}">
            <label><input type="radio" name="tokusenCnt" size="3" value="20" onclick="chechTokusenCnt(this);" checked>２０件</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="tokusenCnt" size="3" value="20" onclick="chechTokusenCnt(this);">２０件</label>
          </c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${view.tokusenCnt eq '50'}">
            <label><input type="radio" name="tokusenCnt" size="3" value="50" onclick="chechTokusenCnt(this);" checked>５０件</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="tokusenCnt" size="3" value="50" onclick="chechTokusenCnt(this);">５０件</label>
          </c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${view.tokusenCnt eq '999999'}">
            <label><input type="radio" name="tokusenCnt" size="3" value="999999" onclick="chechTokusenCnt(this);" checked>その他</label>
            <input type="text" name="tokusenCntNote" maxlength="4" size="4" value="${view.tokusenCntNote}">件
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="tokusenCnt" size="3" value="999999" onclick="chechTokusenCnt(this);">その他</label>
            <input type="text" name="tokusenCntNote" maxlength="4" size="4" value="${view.tokusenCntNote}" style="background-color:#CCCCCC" readonly>件
          </c:otherwise>
        </c:choose>
      </div>
    </div>
    <div class="add_from">
      <input type="hidden" name="torihikisakiSeq"    value="${view.torihikisakiSeq}">
      <input type="hidden" name="torihikisakiUpdDt" value="${view.torihikisakiUpdDt}">
      <input type="hidden" name="startYmForDisplay"  value="${view.startYmForDisplay}">
      <input type="hidden" name="startYm"            value="${view.startYm}">
      <input type="hidden" name="torihikisakiUpdDt"   value="${view.torihikisakiUpdDt}">
      <input type="hidden" name="tokusenCntChecker" value="" >
      <input type="hidden" name="bukkenCntChecker"  value="" >
      <input type="submit" value="確認画面へ">
      <input type="button" value="戻る" onClick="_submit('TorihikisakiInfo.do?torihikisakiSeq=${view.torihikisakiSeq}')">
    </div>
  </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>