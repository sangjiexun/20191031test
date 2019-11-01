<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="view"  value="${ContractAmountUpdateView}" />
<c:set var="title" value="${ContractAmountUpdateView.keiyakuName}更新" />
<c:set var="keiyakuName" value="${ContractAmountUpdateView.keiyakuName}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--

 function checkBukkenCnt(obj){
   if (obj.value == '-1') {
     enableText('wakuCntNote');
   } else {
     disableText('wakuCntNote');
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
   wakuCntChecker = numCheck(document.forms[0].wakuCntNote.value);

   document.forms[0].wakuCntChecker.value = wakuCntChecker;
 }

 function setSubmit(){
   fieldChecker();
 }


 function init(){
   var wakuElements = document.getElementsByName('wakuCnt');
   var flg = 0;
   var cnt = 0;
   for (var i = 0; i < wakuElements.length; i++) {
     if (wakuElements[i].checked) {
       checkBukkenCnt(wakuElements[i]);
       flg = 1;
     }
     if (wakuElements[i].value != '-1') {
       cnt++;
     }
   }
   if (flg == 0) {
     wakuElements[0].checked=true;
     checkBukkenCnt(wakuElements[0]);
   }
   if (cnt ==0) {
       wakuElements[0].style.display = "none";
   }
 }

 addEvent('load', window,  function(){init();});
-->
</script>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_bukken/ShopInfo.do">
      <html:param name="shopCd" value="${view.shopCd}" />
        店舗・契約詳細
      </html:link> &gt;
      <html:link action="/shop_bukken/ContractAmountInfo.do">
        <html:param name="shopCd" value="${view.shopCd}" />
        <html:param name="keiyakuCd" value="${view.keiyakuCd}" />
        <html:param name="keiyakuSubCd" value="${view.keiyakuSubCd}" />
        ${keiyakuName}
      </html:link> &gt;
        ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">店舗コード</p>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>店舗名</th>
        <td>
          <c:out value="${view.company}" />
          <c:if test="${not empty view.company and not empty view.bumon}"> / </c:if>
          <c:out value="${view.bumon}" />
        </td>
      </tr>
      <tr>
        <th>店舗コード</th>
        <td> <c:out value="${view.shopCd}" /></td>
      </tr>
      <tr>
        <th>お客様設定パスワード</th>
        <td>
          <c:out value="${view.password}" />
        </td>
      </tr>
    </table>

  <p class="section_header">${keiyakuName}設定情報</p>
  <html:form action="/shop_bukken/ContractAmountUpdateConfirm.do" onsubmit="setSubmit();">
    <div class="add_form">
      <div class="add_form_title">適用開始日時<span class="caution">*</span></div>
      <div class="annotation">適用月の変更は行えません。</div>
      <div class="form_space">
        <c:out value="${view.startYmdh}"></c:out>～
      </div>
    </div>
    <div class="add_form">
      <div class="add_form_title">${keiyakuName}<span class="caution">*</span></div>
      <div class="annotation">${keiyakuName}として設定する件数を選択します。
        <br>その他を選択することで、件数の自由記入を行うことができます。
        <br>※${view.maxNum}件は無制限と同じ扱いになります。
      </div>
      <div class="form_space">
       <c:set var="wakuFlg"  value="0" />
        <c:forEach items="${view.listAmount}" var="amount"  varStatus="status">
          <c:if test="${status.index  mod 3   == 0}" >
            <br/>
          </c:if>

          <c:choose>
            <c:when test="${view.wakuCnt eq amount }">
              <c:set var="wakuFlg"  value="1" />
              <label><input type="radio" name="wakuCnt"  size="3" value="${amount}" onclick="checkBukkenCnt(this);" checked>${amount}件</label>
            </c:when>
            <c:otherwise>
              <label><input type="radio" name="wakuCnt"  size="3" value="${amount}" onclick="checkBukkenCnt(this);">${amount}件</label>
            </c:otherwise>
          </c:choose>
        </c:forEach>

        <c:if test="${listAmount.size()  mod 3   == 0}" >
          </br>
        </c:if>

        <c:choose>
          <c:when test="${view.textBoxFlg == 'on'}">
            <c:choose>
              <c:when test="${view.wakuCnt != null}">
                <c:choose>
                  <c:when test="${view.wakuCnt eq -1}">
                    <label><input type="radio" name="wakuCnt" size="3" value="-1" onclick="checkBukkenCnt(this);" checked>${view.textBoxName}</label>
                    <input type="text" name="wakuCntNote"  size="4" maxlength="${view.amountLenth}" value="${view.wakuCntNote}">件
                  </c:when>
                  <c:otherwise>
                    <label><input type="radio" name="wakuCnt" size="3" value="-1" onclick="checkBukkenCnt(this);">${view.textBoxName}</label>
                    <input type="text" name="wakuCntNote"  size="4" maxlength="${view.amountLenth}" value="${view.wakuCntNote}">件
                  </c:otherwise>
                </c:choose>
              </c:when>
              <c:otherwise>
                <label><input type="radio" name="wakuCnt" size="3" value="-1" onclick="checkBukkenCnt(this);">${view.textBoxName}</label>
                <input type="text" name="wakuCntNote" size="4" maxlength="${view.amountLenth}" value="${view.wakuCntNote}">件
              </c:otherwise>
            </c:choose>
         </c:when>
       </c:choose>
      </div>
    </div>
    <div class="add_from">
      <input type="hidden" name="shopCd"   value="${view.shopCd}">
      <input type="hidden" name="keiyakuCd"   value="${view.keiyakuCd}">
      <input type="hidden" name="keiyakuSubCd"   value="${view.keiyakuSubCd}">
      <input type="hidden" name="wakuCntChecker"  value="" >
      <input type="hidden" name="amountLenth"  value="${view.amountLenth}" >
      <input type="hidden" name="appStartDt"  value="${view.appStartDt}" >
      <input type="hidden" name="startYmdh"  value="${view.startYmdh}" >
      <input type="hidden" name="updateAppStartDt"  value="${view.updateAppStartDt}" >
      <input type="hidden" name="maxNum"  value="${view.maxNum}" >
      <input type="hidden" name="keiyakuName"  value="${view.keiyakuName}" >
      <input type="hidden" name="shopKanriUpdDt" value="${view.shopKanriUpdDt}">
      <input type="submit" value="確認画面へ">
      <input type="button" value="戻る" onClick="_submit('ContractAmountInfo.do?shopCd=${view.shopCd}&keiyakuCd=${view.keiyakuCd}&keiyakuSubCd=${view.keiyakuSubCd}')">
    </div>
  </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
