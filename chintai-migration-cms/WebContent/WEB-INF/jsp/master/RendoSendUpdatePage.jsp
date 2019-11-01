<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="view" value="${RendoSendUpdateView}" />
<c:choose>
  <c:when test="${view.procKbn == 'delete'}"> <c:set var="procName" value="削除"/> </c:when>
  <c:when test="${view.procKbn == 'update'}"> <c:set var="procName" value="更新"/> </c:when>
  <c:when test="${view.procKbn == 'insert'}"> <c:set var="procName" value="登録"/> </c:when>
</c:choose>
<c:set var="title" value="${view.keiyakuName}${procName}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<jsp:useBean id="date" class="java.util.Date"/>
<div id="main">
  <%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/master/RendoSendList.do">連動元別出稿管理 </html:link>&gt;
      <html:link action="/master/RendoSendInfo.do">
        <html:param name="rendoCd" value="${view.rendoCd}" />
        <html:param name="keiyakuCd" value="${view.keiyakuCd}" />
        <html:param name="keiyakuSubCd" value="${view.keiyakuSubCd}" />${view.keiyakuName}情報
      </html:link>&gt; ${view.keiyakuName}${procName}
    </div>
    <h1>${view.keiyakuName}${procName}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
    <p class="section_header">連動元コード</p>
    <table class="type_detail_pre">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>連動元コード</th><td><c:out value="${view.rendoCd}" /></td>
      </tr>
      <tr>
        <th>連動元名称</th><td><c:out value="${view.rendoName}" /></td>
      </tr>
      <tr>
        <th>連動元会社名</th><td><c:out value="${view.rendoCompany}" /></td>
      </tr>
    </table>
    <p class="section_header">${view.keiyakuName}情報</p>
    <html:form action="/master/RendoSendUpdateConfirm.do" onsubmit="submitProc();">
      <div class="add_form">
        <div class="add_form_title">出稿許可期間</div>
        <div class="annotation">出稿許可期間を選択します。終了日時を指定しない場合、無期限となります。</div>
        <div class="form_space">開始日時
          <c:choose>
            <c:when test="${view.permitStartEditFlg == '1'}">
              <chintai:SelectBox name="permitStartYear" valuesList="${view.applyYearList}" />年
              <chintai:DateTag name="permitStartMonth" type="month"/>月
              <chintai:DateTag name="permitStartDay" type="day" />日
              <chintai:DateTag name="permitStartHour" type="time" />時
              <chintai:DateTag name="permitStartMinute" type="minute" />分
              <chintai:DateTag name="permitStartSecond" type="second" />秒
              <span class="caution">*</span>
            </c:when>
            <c:otherwise>
              ${view.permitStartDtForDisplay}
            </c:otherwise>
          </c:choose>～ 終了日時
          <chintai:SelectBox name="permitEndYear" valuesList="${view.applyYearList}"/>年
          <chintai:DateTag name="permitEndMonth" type="month"/>月
          <chintai:DateTag name="permitEndDay" type="day" />日
          <chintai:DateTag name="permitEndHour" type="time" />時
          <chintai:DateTag name="permitEndMinute" type="minute" />分
          <chintai:DateTag name="permitEndSecond" type="second" />秒
        </div>
        <br/>
        <div class="add_form">
          <div class="add_form_title">備考</div>
          <div class="form_space">
            <div class="annotation">この連動元の出稿許可情報に関するメモなどを入力します。</div>
            <textarea name="note" cols="50" rows="5"><c:out value="${view.note}" /></textarea>
          </div>
        </div>
      </div>
      <input type="hidden" name="rendoCd" value="${view.rendoCd}">
      <input type="hidden" name="keiyakuCd" value="${view.keiyakuCd}">
      <input type="hidden" name="keiyakuSubCd" value="${view.keiyakuSubCd}">
      <input type="hidden" name="rendoSendNo" value="${view.rendoSendNo}">
      <input type="hidden" name="permitStartDt" value="">
      <input type="hidden" name="permitEndDt" value="">
      <input type="hidden" name="repeatFlg" value="1">
      <input type="hidden" name="procKbn" value="${view.procKbn}">
      <input type="hidden" name="nowDate" value="${view.nowDate}">
      <div class="add_from">
        <input type="submit" value="確認画面へ">
        <input type="button" value="戻る" onClick="_submit('RendoSendInfo.do?rendoCdCd=${view.rendoCd}&keiyakuCd=${view.keiyakuCd}&keiyakuSubCd=${view.keiyakuSubCd}')">
      </div>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
<script type="text/javascript">
var formObj = document.forms[0];
function submitProc(){
	// リクエスト用に日時を合成
	if ("<c:out value='${view.permitStartEditFlg}' />" == "1") {
		formObj.permitStartDt.value = ("    " + formObj.permitStartYear.value).slice(-4) + ("  " + formObj.permitStartMonth.value).slice(-2)
									+ ("  " + formObj.permitStartDay.value).slice(-2) + ("  " + formObj.permitStartHour.value).slice(-2)
									+ ("  " + formObj.permitStartMinute.value).slice(-2) + ("  " + formObj.permitStartSecond.value).slice(-2);
	} else {
		// 開始日時を編集していなければ、現在日付チェックをスキップするように
		formObj.permitStartDt.value = "<c:out value='${view.permitStartDt}' />";
		formObj.nowDate.value = "";
	}
	formObj.permitEndDt.value = ("    " + formObj.permitEndYear.value).slice(-4) + ("  " + formObj.permitEndMonth.value).slice(-2)
								+ ("  " + formObj.permitEndDay.value).slice(-2) + ("  " + formObj.permitEndHour.value).slice(-2)
								+ ("  " + formObj.permitEndMinute.value).slice(-2) + ("  " + formObj.permitEndSecond.value).slice(-2);
	if (formObj.permitEndDt.value.trim() == "") {
		formObj.permitEndDt.value = "";
	}
	formObj.submit();
}

function loadProc(){
	// 表示、編集用に日時を分解
	if ("<c:out value='${view.permitStartEditFlg}' />" == "1") {
		formObj.permitStartYear.value = "<c:out value='${view.permitStartDt}' />".slice(0,4);
		formObj.permitStartMonth.value = "<c:out value='${view.permitStartDt}' />".slice(4,6);
		formObj.permitStartDay.value = "<c:out value='${view.permitStartDt}' />".slice(6,8);
		formObj.permitStartHour.value = "<c:out value='${view.permitStartDt}' />".slice(8,10);
		formObj.permitStartMinute.value = "<c:out value='${view.permitStartDt}' />".slice(10,12);
		formObj.permitStartSecond.value = "<c:out value='${view.permitStartDt}' />".slice(12,14);
	}
	formObj.permitEndYear.value = "<c:out value='${view.permitEndDt}' />".slice(0,4);
	formObj.permitEndMonth.value = "<c:out value='${view.permitEndDt}' />".slice(4,6);
	formObj.permitEndDay.value = "<c:out value='${view.permitEndDt}' />".slice(6,8);
	formObj.permitEndHour.value = "<c:out value='${view.permitEndDt}' />".slice(8,10);
	formObj.permitEndMinute.value = "<c:out value='${view.permitEndDt}' />".slice(10,12);
	formObj.permitEndSecond.value = "<c:out value='${view.permitEndDt}' />".slice(12,14);
}
addEvent('load', window, loadProc);
</script>