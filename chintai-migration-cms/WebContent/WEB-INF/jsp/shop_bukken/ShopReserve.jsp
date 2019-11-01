<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗予約" />
<c:set var="view" value="${ShopReserveView}" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<!-- メイン -->
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <p id="mess">
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
    </p>

    <p class="section_header">店舗予約ダウンロード</p>
    <form action="ShopDownload.do" method="post" name="ShopDownloadForm" >
     <table class="type_searchbox">
        <tr>
          <td>適用日時</td>
          <td>
            <chintai:DateTag name="applyDtFromYear" fixValue="${view.applyDtFromYear}" type="year" startYear="${view.startYear}" addYear="3"/> 年
			<chintai:DateTag name="applyDtFromMonth" fixValue="${view.applyDtFromMonth}" type="month" /> 月
			<chintai:DateTag name="applyDtFromDay" fixValue="${view.applyDtFromDay}"  type="day" /> 日
			<chintai:DateTag name="applyDtFromTime" fixValue="${view.applyDtFromTime}"  type="time" /> 時&nbsp;&nbsp;～
			<chintai:DateTag name="applyDtToYear" fixValue="${view.applyDtToYear}"  type="year" startYear="${view.startYear}" addYear="3"/> 年
			<chintai:DateTag name="applyDtToMonth" fixValue="${view.applyDtToMonth}"  type="month" /> 月
			<chintai:DateTag name="applyDtToDay" fixValue="${view.applyDtToDay}"  type="day" /> 日
			<chintai:DateTag name="applyDtToTime" fixValue="${view.applyDtToTime}"  type="time" /> 時&nbsp;&nbsp;
          </td>
        </tr>
        <tr>
          <td>予約登録日時</td>
          <td>
            <chintai:DateTag name="reserveDtFromYear" fixValue="${view.reserveDtFromYear}" type="year" startYear="${view.startYear}" addYear="3"/> 年
			<chintai:DateTag name="reserveDtFromMonth" fixValue="${view.reserveDtFromMonth}" type="month" /> 月
			<chintai:DateTag name="reserveDtFromDay" fixValue="${view.reserveDtFromDay}"  type="day" /> 日
			<chintai:DateTag name="reserveDtFromTime" fixValue="${view.reserveDtFromTime}"  type="time" /> 時&nbsp;&nbsp;～
			<chintai:DateTag name="reserveDtToYear" fixValue="${view.reserveDtToYear}"  type="year" startYear="${view.startYear}" addYear="3"/> 年
			<chintai:DateTag name="reserveDtToMonth" fixValue="${view.reserveDtToMonth}"  type="month" /> 月
			<chintai:DateTag name="reserveDtToDay" fixValue="${view.reserveDtToDay}"  type="day" /> 日
			<chintai:DateTag name="reserveDtToTime" fixValue="${view.reserveDtToTime}"  type="time" /> 時&nbsp;&nbsp;
          </td>
        </tr>
        <tr>
          <td>店舗コード</td>
          <td>
            <input type="text" name="shopCd" maxlength="9" size="9" value="${view.shopCd}">
          </td>
        </tr>
        <tr>
          <td>登録元</td>
          <td>
            <chintai:PropertyOptions name="reserveKbn" fixValue="${view.reserveKbn}" nameKey="RESERVE_KBN_NAME" valueKey="RESERVE_KBN_VALUE" style="width:70px"/>
          </td>
        </tr>
      </table>

      <p>
      	<input type="hidden" name="reserveFlg"   value="1">
      	<input type="hidden" name="applyFrom"   value="">
      	<input type="hidden" name="applyTo"   value="">
      	<input type="hidden" name="reserveFrom"   value="">
      	<input type="hidden" name="reserveTo"   value="">
        <input type="submit" name="download" value="ダウンロード" onclick="return downloadCheck()">
        <input type="reset" name="reset" value="クリア">
      </p>
    </form>

    <p class="section_header">店舗ダウンロード</p>
    <form action="ShopDownload.do" method="post" name="checkFrom">
     <table class="type_searchbox">
        <tr>
          <td>連動元</td>
          <td>
            <form:select path="ShopReserveView.rendoCd" style="width:170px">
           		<form:option value=""></form:option>
           		<form:options items="${masterService.selectMstRendo()}" itemValue="rendoCd" itemLabel="rendoName"/>
           	</form:select>
          </td>
        </tr>
        <tr>
          <td>店舗コード</td>
          <td>
            <input type="text" name="shopCd" maxlength="9" size="9" value="${view.shopCd}">
          </td>
        </tr>
        <tr>
          <td>会社名／事務所名</td>
          <td><input type="text" name="kaishaMeiBushoMei" maxlength="400" size="30" value="${view.kaishaMeiBushoMei}"></td>
        </tr>
      </table>

      <p>
        <input type="submit" name="download" value="ダウンロード" onclick="return check()">
        <input type="reset" name="reset" value="クリア">
      </p>
    </form>

    <p class="section_header">店舗予約アップロード</p>
    <html:form action="/shop_bukken/ShopUpload.do" method="post" enctype="multipart/form-data">
      <p><input type="file" name="uploadFile" size="50" ></p>
      <p><input type="button" name="upload" value="アップロード" onclick="uploadDisabled();"></p>
    </html:form>

  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>



<script type="text/javascript">
<!--

function errorMsgCheck(){
    var dom_obj = document.getElementById("mess");

    if (dom_obj != null){

        var dom_obj_parent = dom_obj.parentNode;

        for (var i =dom_obj_parent.childNodes.length-1; i>=0; i--) {

            var child = dom_obj_parent.childNodes[i];

            if (child.className == "notify") {
                dom_obj_parent.removeChild(child);
                break;
            }
        }
    }

}

function search(){
	var thisForm = document.forms[0];

	var sApplyDate = thisForm.applyDtFromYear.value + thisForm.applyDtFromMonth.value + thisForm.applyDtFromDay.value + thisForm.applyDtFromTime.value;
	var eApplyDate = thisForm.applyDtToYear.value + thisForm.applyDtToMonth.value + thisForm.applyDtToDay.value + thisForm.applyDtToTime.value;
	thisForm.applyFrom.value = sApplyDate;
	thisForm.applyTo.value = eApplyDate;

	var sReserveDate = thisForm.reserveDtFromYear.value + thisForm.reserveDtFromMonth.value + thisForm.reserveDtFromDay.value + thisForm.reserveDtFromTime.value;
	var eReserveDate = thisForm.reserveDtToYear.value + thisForm.reserveDtToMonth.value + thisForm.reserveDtToDay.value + thisForm.reserveDtToTime.value;
	thisForm.reserveFrom.value = sReserveDate;
	thisForm.reserveTo.value = eReserveDate;
}

function downloadCheck(){
	search();

    var flag = 0;

    //画面のエラーメッセージ削除処理
    errorMsgCheck();

    var thisForm = document.forms[0];

    //検索条件が未入力の場合確認ダイアログを表示させる
    if (thisForm.applyFrom.value == "" &&
    	thisForm.applyTo.value == "" &&
    	thisForm.reserveFrom.value == "" &&
    	thisForm.reserveTo.value == "" &&
    	thisForm.shopCd.value == "" &&
    	thisForm.reserveKbn.value == ""){

        flag = 1;

    }
    if(flag){

        return confirm('適用日時、予約登録日時、店舗コード、登録元を指定しない\n場合、大量のデータがダウンロードされます。よろしいですか？');

    }
    else{

        return true ;

    }
}

function check(){

    var flag = 0;

    //画面のエラーメッセージ削除処理
    errorMsgCheck();

    //検索条件が未入力の場合確認ダイアログを表示させる
    if (document.checkFrom.rendoCd.value == "" &&
    	document.checkFrom.shopCd.value == "" &&
    	document.checkFrom.kaishaMeiBushoMei.value == ""){

        flag = 1;

    }
    if(flag){

        return confirm('連動元、店舗コード、会社/事務所名を指定しない\n場合、大量のデータがダウンロードされます。よろしいですか？');

    }
    else{

        return true ;

    }
}

function uploadDisabled(){
	// アップロードボタンが押下されたら、ボタンを無効にする
    var thisForm = document.forms[2];

	thisForm.upload.disabled = true;

	thisForm.submit();
}

addEvent('load', window, function(){document.getElementsByName('applyDtFromYear')[0].focus();});
// -->
</script>
