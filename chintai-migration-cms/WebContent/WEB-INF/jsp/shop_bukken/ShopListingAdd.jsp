<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="view"  value="${ShopListingAddView}" />
<c:set var="mstShopKeiyakuKanri" value="${masterService.selectMstShopKeiyakuKanriByPrimaryKey(view.keiyakuCd, view.keiyakuSubCd)}"/>
<c:set var="keiyakuName" value=""/>
<c:if test="${mstShopKeiyakuKanri != null}">
	<c:set var="keiyakuName" value="${mstShopKeiyakuKanri.keiyakuName}"/>
</c:if>
<c:set var="title" value="${keiyakuName}登録" />
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

 function editApplyDate(){
   document.forms[0].inputDateFrom.value = document.forms[0].keiyakuStartYear.value
                                     + document.forms[0].keiyakuStartMonth.value
                                     + document.forms[0].keiyakuStartDay.value
                                     + document.forms[0].keiyakuStartHour.value
                                     + document.forms[0].keiyakuStartMinute.value
                                     + document.forms[0].keiyakuStartSecond.value;
   document.forms[0].inputDateTo.value = document.forms[0].keiyakuEndYear.value
                                     + document.forms[0].keiyakuEndMonth.value
                                     + document.forms[0].keiyakuEndDay.value
                                     + document.forms[0].keiyakuEndHour.value
                                     + document.forms[0].keiyakuEndMinute.value
                                     + document.forms[0].keiyakuEndSecond.value;
   //if (document.forms[0].inputDateTo.value.length == '10') {
     //document.forms[0].inputDateTo.value =  document.forms[0].inputDateTo.value + "00"
   //}
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
   editApplyDate();
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
 addEvent('load', window, function(){document.getElementsByName('keiyakuStartYear')[0].focus();});

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
      <html:link action="/shop_bukken/ContractInfo.do">
        <html:param name="shopCd" value="${view.shopCd}" />
        <html:param name="keiyakuCd" value="${view.keiyakuCd}" />
        <html:param name="keiyakuSubCd" value="${view.keiyakuSubCd}" />
       ${keiyakuName}詳細
      </html:link> &gt;
       ${keiyakuName}登録
    </div>
    <h1>${keiyakuName}登録</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">店舗コード</p>
    <table class="type_detail_pre">
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


  <p class="section_header">${keiyakuName}</p>
  <html:form action="shop_bukken/ContractAddConfirm.do" onsubmit="setSubmit();">
    <div class="add_form">
      <div class="add_form_title">契約期間</div>
      <div class="annotation">契約期間を選択します。契約終了日時を指定しない場合、無期限となります。</div>
      <div class="form_space">
        契約開始日時
        <chintai:SelectBox name="keiyakuStartYear" valuesList="${view.applyYearList}" fixValue="${view.keiyakuStartYear}"/>年&nbsp;
        <chintai:DateTag name="keiyakuStartMonth"  fixValue="${view.keiyakuStartMonth}" type="month"/>月
        <chintai:DateTag name="keiyakuStartDay"    fixValue="${view.keiyakuStartDay}"   type="day" /> 日
        <chintai:DateTag name="keiyakuStartHour"  fixValue="${view.keiyakuStartHour}"   type="time" /> 時
        <chintai:DateTag name="keiyakuStartMinute"  fixValue="${view.keiyakuStartMinute}"   type="minute" /> 分
        <chintai:DateTag name="keiyakuStartSecond"  fixValue="${view.keiyakuStartSecond}"   type="second" /> 秒<span class="caution">*</span> ～
        契約終了日時
        <chintai:SelectBox name="keiyakuEndYear" valuesList="${view.applyYearList}" fixValue="${view.keiyakuEndYear}"/>年&nbsp;
        <chintai:DateTag name="keiyakuEndMonth"   fixValue="${view.keiyakuEndMonth}"   type="month"/>月
        <chintai:DateTag name="keiyakuEndDay"     fixValue="${view.keiyakuEndDay}"     type="day" /> 日
        <chintai:DateTag name="keiyakuEndHour"    fixValue="${view.keiyakuEndHour}"    type="time" /> 時
        <chintai:DateTag name="keiyakuEndMinute"    fixValue="${view.keiyakuEndMinute}"    type="minute" /> 分
        <chintai:DateTag name="keiyakuEndSecond"    fixValue="${view.keiyakuEndSecond}"    type="second" /> 秒
      </div>
      <br/>
    </div>


   <div class="add_form">
   	 <c:if test="${view.isWakuDisp == 'true'}">
	     <div class="add_form_title">${keiyakuName}<span class="caution">*</span></div>
	     <div class="annotation">${keiyakuName}として設定する件数を選択します。
	       <br>その他を選択することで、件数の自由記入を行うことができます。
	       <br>※${view.maxNum}件は無制限と同じ扱いになります。
	     </div>
	     <div class="form_space">
	       <c:forEach items="${view.listAmount}" var="amount"  varStatus="status">
	         <c:if test="${status.index  mod 3   == 0}" >
	           <br/>
	         </c:if>

	         <c:choose>
	           <c:when test="${view.wakuCnt eq amount }">
	             <label><input type="radio" name="wakuCnt" size="3" value="${amount}" onclick="checkBukkenCnt(this);" checked>${amount}件</label>
	           </c:when>
	           <c:otherwise>
	             <label><input type="radio" name="wakuCnt" size="3" value="${amount}" onclick="checkBukkenCnt(this);">${amount}件</label>
	           </c:otherwise>
	         </c:choose>
	       </c:forEach>

	       <c:if test="${listAmount.size()  mod 3   == 0}" >
	         </br>
	       </c:if>

	       <c:choose>
	         <c:when test="${view.textBoxFlg == 'on' && listAmount.size() != 0}">
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
	         <c:when test="${view.textBoxFlg == 'on' && listAmount.size() == 0}">
	                   <label><input type="radio" name="wakuCnt" size="3" value="-1" onclick="checkBukkenCnt(this);" checked >${view.textBoxName}</label>
	            <input type="text" name="wakuCntNote"  size="4" maxlength="${view.amountLenth}" value="${view.wakuCntNote}">件
	         </c:when>
	       </c:choose>
	     </div>
   	 </c:if>
     <div class="add_form_title">備考</div>
      <div class="form_space">
        <div class="annotation">この店舗の契約情報に関するメモなどを入力します。</div>
        <textarea name="keiyakuNote" cols="50" rows="5"><c:out value="${view.keiyakuNote}" /></textarea>
      </div>
  </div>



    <div class="add_from">
      <input type="hidden" name="shopCd"   value="${view.shopCd}">
      <input type="hidden" name="keiyakuCd"   value="${view.keiyakuCd}">
      <input type="hidden" name="keiyakuSubCd"   value="${view.keiyakuSubCd}">
      <input type="hidden" name="nowDate"  value="${view.nowDate}" >
      <input type="hidden" name="inputDateFrom"  value="" >
      <input type="hidden" name="inputDateTo"  value="" >
      <input type="hidden" name="keiyakuName" value="${ShopListingAddView.keiyakuName}">
      <input type="hidden" name="shopKanriUpdDt" value="${ShopListingAddView.shopKanriUpdDt}">

      <input type="hidden" name="wakuCntChecker"  value="${view.wakuCntChecker}" >
      <input type="hidden" name="amountLenth"  value="${view.amountLenth}" >
      <input type="hidden" name="maxNum"  value="${view.maxNum}" >
      <input type="hidden" name="isWakuDisp"  value="${view.isWakuDisp}" >

      <input type="submit" value="確認画面へ">
      <input type="button" value="戻る" onClick="_submit('ContractInfo.do?shopCd=${view.shopCd}&keiyakuCd=${view.keiyakuCd}&keiyakuSubCd=${view.keiyakuSubCd}')">
    </div>
  </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
