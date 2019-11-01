<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="取引先新規登録" />
<c:set var="view"  value="${TorihikisakiRegisterView}" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<script type="text/javascript">
<!--
 var newWin;

 function openFudousanSearch() {
   newWin = window.open("","FudousanSearch", "width=800,height=600,scrollbars=yes,toolbar=no,menubar=no,resizable=yes,status=yes");
   newWin.document.location.href="FudousanSearchForRefPage.do";
 }

 function closeChildWindow(){
  try{
    if(newWin) { // newWinがObjectだったら以下を実行
      newWin.window.close()
    };
  }catch(e){
  }
 }

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

 function editApplyDate(){
   document.forms[0].inputDate.value = document.forms[0].applyYear.value
                                     + document.forms[0].applyMonth.value;

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
   closeChildWindow();
   editApplyDate();
   fieldChecker();
 }

addEvent('load', window, function(){document.getElementsByName('referBut')[0].focus();});
-->
</script>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link>&gt;
      <html:link action="/demand/TorihikisakiSearchPaging.do">取引先メンテナンス</html:link>&gt;
      <c:out value="${title}"/>
    </div>
    <h1><c:out value="${title}"/></h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">取引先情報</p>
    <html:form action="demand/TorihikisakiRegisterConfirm.do" onsubmit="setSubmit();">
      <div class="add_form">
        <div class="add_form_title">不動産会社名<span class="caution">*</span></div>
        <div class="annotation">参照ボタンクリック後に表示される不動産会社検索画面から不動産会社を選択します。</div>
        <div class="form_space">
          <input type="text" name="fudousanName" maxlength="30" size="30" value="${fn:escapeXml(view.fudousanName)}" style="background-color:#CCCCCC" readonly>
          <input type="button" name="referBut" value="参照" onclick="openFudousanSearch();">
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">取引先名<span class="caution">*</span></div>
        <div class="annotation">取引先名を記述します。</div>
        <div class="form_space">
          <input type="text" name="torihikisakiName" maxlength="60" size="50" value="${fn:escapeXml(view.torihikisakiName)}">
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">住所</div>
        <div class="annotation">取引先住所を設定します。</div>
        <div class="form_space">
          〒<input type="text" name="zipCd1" maxlength="3" size="3" value="${view.zipCd1}">－<input type="text" name="zipCd2" maxlength="4" size="4" value="${view.zipCd2}"> (半角)<br>
          <chintai:Todofuken name="prefCd" fixValue="${param.prefCd}"/><span class="caution">*</span><br>
          <input type="text" name="address1" maxlength="60" size="50" value="${fn:escapeXml(view.address1)}"><span class="caution">*</span>(市区町村名、番地)<br>
          <input type="text" name="address2" maxlength="51" size="50" value="${fn:escapeXml(view.address2)}">(ビル名等)
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">電話番号</div>
        <div class="annotation">電話番号を記述します。（例：03-1234-5678）</div>
        <div class="form_space">
          <input type="text" name="tel" maxlength="13" size="13" value="${view.tel}">(半角)
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">FAX番号</div>
        <div class="annotation">FAX番号を記述します。（例：03-1234-5678）</div>
        <div class="form_space">
          <input type="text" name="fax" maxlength="13" size="13" value="${view.fax}">(半角)
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">担当者名</div>
        <div class="annotation">担当者名を記述します。</div>
        <div class="form_space">
          <input type="text" name="tantou" maxlength="25" size="25" value="${fn:escapeXml(view.tantou)}">
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">取引担当支社<span class="caution">*</span></div>
        <div class="annotation">取引担当支社を選択します。</div>
        <div class="form_space">
          <chintai:ShisyaInfo name="shisyaCd" fixValue="${view.shisyaCd}"/>
        </div>
      </div>

    <p class="section_header">物件枠設定情報</p>
    <div class="add_form">
      <div class="add_form_title">適用月<span class="caution">*</span></div>
      <div class="annotation">物件枠設定情報を適用する月を選択します。</div>
      <div class="form_space">
        <chintai:SelectBox name="applyYear" valuesList="${view.applyYearList}" fixValue="${view.applyYear}"/>年&nbsp;
        <chintai:SelectBox name="applyMonth" valuesList="${view.applyMonthList}" fixValue="${view.applyMonth}"/>月
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
            <label><input type="radio" name="bukkenCnt" size="3" value="100" onclick="checkBukkenCnt(this);" checked>１００件</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="bukkenCnt" size="3" value="100" onclick="checkBukkenCnt(this);">１００件</label>
          </c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${view.bukkenCnt eq '200'}">
            <label><input type="radio" name="bukkenCnt" size="3" value="200" onclick="checkBukkenCnt(this);" checked>２００件</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="bukkenCnt" size="3" value="200" onclick="checkBukkenCnt(this);">２００件</label>
          </c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${view.bukkenCnt eq '300'}">
            <label><input type="radio" name="bukkenCnt" size="3" value="300" onclick="checkBukkenCnt(this);" checked>３００件</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="bukkenCnt" size="3" value="300" onclick="checkBukkenCnt(this);">３００件</label>
          </c:otherwise>
        </c:choose>
        <br>
        <c:choose>
          <c:when test="${view.bukkenCnt eq '400'}">
            <label><input type="radio" name="bukkenCnt" size="3" value="400" onclick="checkBukkenCnt(this);" checked>４００件</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="bukkenCnt" size="3" value="400" onclick="checkBukkenCnt(this);">４００件</label>
          </c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${view.bukkenCnt eq '500'}">
            <label><input type="radio" name="bukkenCnt" size="3" value="500" onclick="checkBukkenCnt(this);" checked>５００件</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="bukkenCnt" size="3" value="500" onclick="checkBukkenCnt(this);">５００件</label>
          </c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${view.bukkenCnt eq '999999'}">
            <label><input type="radio" name="bukkenCnt" size="3" value="999999" onclick="checkBukkenCnt(this);" checked>その他</label>
            <input type="text" name="bukkenCntNote" maxlength="4" size="4" value="${view.bukkenCntNote}">件
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="bukkenCnt" size="3" value="999999" onclick="checkBukkenCnt(this);">その他</label>
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
      <input type="hidden" name="fudousanCd" value="${view.fudousanCd}" >
      <input type="hidden" name="nowDate"    value="${view.nowDate}" >
      <input type="hidden" name="tokusenCntChecker" value="" >
      <input type="hidden" name="bukkenCntChecker"  value="" >
      <input type="hidden" name="inputDate"         value="" >
      <input type="submit" value="確認画面へ">
      <input type="button" value="戻る" onClick="_submit('TorihikisakiSearchPaging.do')">
    </div>
   </html:form>
  </div>
</div>


<%@ include file="../parts/ContentsFooter.jsp" %>
