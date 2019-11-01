<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="問い合せ検索" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<script type="text/javascript">
<!--
function joinDate() {
	var thisForm = document.forms[0];
	var fromDate = thisForm.insDtFromYear.value + thisForm.insDtFromMonth.value + thisForm.insDtFromDay.value + thisForm.insDtFromTime.value;
	var toDate = thisForm.insDtToYear.value + thisForm.insDtToMonth.value + thisForm.insDtToDay.value + thisForm.insDtToTime.value;
	thisForm.insDateFromSearch.value = fromDate;
	thisForm.insDateToSearch.value = toDate;
}

function page(offSet) {
	document.forms[0].offSet.value = offSet;
	_submit('CjnInquirySearchPaging.do');
}

function search() {
	document.forms[0].offSet.value = "";
	document.forms[0].searchFlg.value = "1";
	joinDate();
}

addEvent('load', window, function(){document.getElementsByName('cjnInqId')[0].focus();});
-->
</script>
<c:set var="view" value="${CjnInquirySearchListView}" />

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnInquiryTypeList">問い合せ種別一覧</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">処理件数</p>
    <table class="type_list">
      <colgroup>
        <col width="10%">
        <col width="30%">
        <col width="30%">
        <col width="30%">
      </colgroup>
      <tr>
        <th rowspan="2">件数</th>
        <td><span>総件数 ${view.totalCount}件</span></td>
        <td><span class="caution">未読件数 ${view.noReadCount} 件</span></td>
        <td><span class="caution">未処理件数 ${view.noShoriCount} 件</span></td>
      </tr>
      <tr>
        <td colspan="3">
          <span class="caution">※&nbsp;お問い合せ日時より180日を経過いたしますと自動的に削除されます。</span>
        </td>
      </tr>
    </table>

    <html:form action="/cjn_inquiry/CjnInquirySearch" method="get" onsubmit="search();">
    <p class="section_header">問い合せ検索</p>
    <table class="type_searchbox">
      <tr>
        <td>
          問い合せID
        </td>
        <td>
          <input type="text" name="cjnInqId" value="${view.cjnInqId}" size="20" maxlength="16">
        </td>
      </tr>
      <tr>
        <td>
          キーワード
        </td>
        <td>
          <input type="text" name="keywords" value="${fn:escapeXml(view.keywords)}"size="40" maxlength="250">
          <chintai:PropertyOptions name="modeAndOr" nameKey="AND_OR_NAME" valueKey="AND_OR_VALUE" fixValue="${view.modeAndOr}" />
          ※複数入力の場合は単語を半角スペースで区切って下さい。
        </td>
      </tr>
      <tr>
        <td>
          閲覧状況
        </td>
        <td>
          <chintai:MstInquiryKbn name="refFlg" fixValue="${view.refFlg}" inqKbnColName="REF_FLG"/>&nbsp;&nbsp;
        </td>
      </tr>
      <tr>
        <td>
          処理状況
        </td>
        <td>
          <chintai:MstInquiryKbn name="inquiryStatus" fixValue="${view.inquiryStatus}" inqKbnColName="INQUIRY_STATUS"/>
        </td>
      </tr>
      <tr>
        <td>
          問い合せ日時
        </td>
        <td>
          <chintai:DateTag name="insDtFromYear" todayFix="2001" type="year" fixValue="${view.insDtFromYear}"/>年
          <chintai:DateTag name="insDtFromMonth" type="month" fixValue="${view.insDtFromMonth}"/>月
          <chintai:DateTag name="insDtFromDay" type="day" fixValue="${view.insDtFromDay}"/>日
          <chintai:DateTag name="insDtFromTime" type="time" fixValue="${view.insDtFromTime}"/>時 ～
          <chintai:DateTag name="insDtToYear" todayFix="2001" type="year" fixValue="${view.insDtToYear}"/>年
          <chintai:DateTag name="insDtToMonth" type="month" fixValue="${view.insDtToMonth}"/>月
          <chintai:DateTag name="insDtToDay" type="day" fixValue="${view.insDtToDay}"/>日
          <chintai:DateTag name="insDtToTime" type="time" fixValue="${view.insDtToTime}"/>時
        </td>
      </tr>
      <tr>
      	<td>PC/モバイル</td>
      	<td><chintai:PropertyOptions name="pcMobileStatus" nameKey="SEARCHPARAM_PC_MOBILE_NAME" valueKey="SEARCHPARAM_PC_MOBILE_VALUE" fixValue="${view.pcMobileStatus}"/>&nbsp;&nbsp;</td>
      </tr>
      <tr>
      	<td>取引番号</td>
      	<td><input type="text" name="dealNumber" value="${fn:escapeXml(view.dealNumber)}"size="20" maxlength="20"></td>
      </tr>

      <tr>
      	<td>伝票番号</td>
      	<td><input type="text" name="slipNumber" value="${fn:escapeXml(view.slipNumber)}"size="20" maxlength="20"></td>
      </tr>

    </table>

    <p class="section_header">検索結果の出力方法</p>
    <table>
      <tr>
        <td>
          ソートキー
          <chintai:PropertyOptions name="sortKey" nameKey="CJN_INQ_SORTKEY_NAME" valueKey="CJN_INQ_SORTKEY_VALUE" fixValue="${view.sortKey}"/>&nbsp;&nbsp;
          順序
          <chintai:PropertyOptions name="orderBy" nameKey="ORDER_BY_NAME" valueKey="ORDER_BY_VALUE" fixValue="${view.orderBy}"/>&nbsp;&nbsp;
          表示件数
          <c:choose>
            <c:when test="${view.displayNum == 0}">
              <chintai:PropertyOptions name="displayNum" nameKey="DISPLAY_NUM_NAME" valueKey="DISPLAY_NUM_VALUE" fixValue="50"/>
            </c:when>
            <c:otherwise>
              <chintai:PropertyOptions name="displayNum" nameKey="DISPLAY_NUM_NAME" valueKey="DISPLAY_NUM_VALUE" fixValue="${view.displayNum}"/>
            </c:otherwise>
          </c:choose>
        </td>
      </tr>
    </table>
    <p>
      <input type="hidden" name="cjnInqKindSeq" value="${view.cjnInqKindSeq}">
      <input type="hidden" name="offSet">
      <input type="hidden" name="insDateFromSearch">
      <input type="hidden" name="insDateToSearch">
      <input type="hidden" name="searchFlg">
      <input type="submit" value="検索">
      <input type="reset" value="クリア">
    </p>
    </html:form>

    <!-- 問い合せ検索結果部分 -->
    <c:if test="${not empty view.inquirySearchList}">
      <p class="section_header">検索結果</p>
      <c:set var="helper" value="${CjnInquirySearchListView}"/>
      <%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
        <table class="type_list">
          <tr>
            <th>問い合せID</th>
            <th>PC/モバイル<br/>取引番号<br/>伝票番号<br/></th>
            <th>問い合せ日時</th>
            <th>最終閲覧日時<br>(最終閲覧ユーザ)</th>
            <th>閲覧状況<br>処理状況</th>
            <th>最終処理日時<br>(最終処理ユーザ)</th>
          </tr>
          <c:forEach items="${view.inquirySearchList}" var="list">
          <tr>
            <td><a href="<c:url value="CjnInquiryInfo.do">
                  <c:param name="cjnInqId" value="${list.cjnInqId}"/>
                  <c:param name="cjnInqKindSeq" value="${list.cjnInqKindSeq}"/>
                  <c:param name="cjnAccountSeq" value="${list.cjnAccountSeq}" />
                  <c:param name="sessionStatus" value="9" />
                  <c:param name="logFlg" value="1" />
                  <c:param name="offSet" value="${list.offSet}" />
                  </c:url>">
                <c:out value="${list.cjnInqId}"/></a>
            </td>
            <!-- pc_モバイル_取引番号_伝票番号 -->
            <td>
            	<chintai:CodePrint code="${list.carrierType}" nameKey="SEARCHPARAM_PC_MOBILE_NAME" valueKey="SEARCHPARAM_PC_MOBILE_VALUE"/><br/>
            	<c:out value="${list.fregiTorihikiNo}"/><br/>
            	<c:out value="${list.fregiDenpyoNo}"/><br/>

            </td>
            <td><c:out value="${list.insDt}"/></td>
            <td>
                <c:out value="${list.lastRefDt}"/>
                <br>
                <c:if test="${not empty list.lastRefUser}">(</c:if>
                  <c:out value="${list.lastRefUser}"/>
                <c:if test="${not empty list.lastRefUser}">)</c:if>
            </td>
            <td>
              <c:out value="${list.refFlgName}" />
              <br>
              <c:out value="${list.inquiryStatusName}" />
            </td>
            <td>
              <c:out value="${list.lastOpeDt}"/>
              <br>
              <c:if test="${not empty list.lastOpeUser}">(</c:if>
                <c:out value="${list.lastOpeUser}"/>
              <c:if test="${not empty list.lastOpeUser}">)</c:if>
              </td>
          </tr>
          </c:forEach>
        </table>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    </c:if>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
