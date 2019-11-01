<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="操作履歴検索" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<c:set var="view" value="${InquiryLogOperationListView}" />
<script type="text/javascript">
<!--//
function joinDate(){
	var thisForm = document.forms[0];
	thisForm.insDtFrom.value = thisForm.fromYear.value + thisForm.fromMonth.value + thisForm.fromDay.value + thisForm.fromTime.value;
	thisForm.insDtTo.value = thisForm.toYear.value + thisForm.toMonth.value + thisForm.toDay.value + thisForm.toTime.value;    
}

function page(offSet){
	document.forms[0].offSet.value = offSet;
	_submit('InquiryLogOperationSearchPaging.do');
}

function search(){
	document.forms[0].offSet.value = "";
	joinDate();
}

addEvent('load', window, function(){document.getElementsByName('shopCd')[0].focus();}); 
//-->
</script>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"></c:out>
    </html:messages>
    
      <p class="section_header">検索条件</p>
      <form action="InquiryLogOperationSearch.do" method="get" onsubmit="disableSubmit(this)">
        <table class="type_searchbox">
         <colgroup>
          <col width="10%" align="left">
          <col width="50%" align="left">
          <col width="15%" align="left">
          <col width="25%" align="left">
         </colgroup>
         <tr>
          <td>店舗コード</td>
          <td>
           <input type="text" name="shopCd" size="20" maxlength="9" value="${view.shopCd}" />
          </td>
          <td>会社名/事務所名</td>
          <td>
           <input type="text" name="companyBumonName" size="20" maxlength="60" value="${view.companyBumonName}" />
          </td>
         </tr>
         <tr>
          <td>処理区分</td>
          <td>
            <chintai:PropertyOptions name="sessionStatus" nameKey="SESSION_STATUS_NAME" valueKey="SESSION_STATUS_VALUE" fixValue="${view.sessionStatus}"/>
          </td>
          <td>問い合せID</td>
          <td>
           <input type="text" name="inqId" size="20" maxlength="16" value="${view.inqId}">
          </td>
         </tr>
         <tr>
          <td>処理日時 </td>
          <td colspan="3">
            <chintai:DateTag name="fromYear" type="year" fixValue="${view.fromYear}"/> 年
            <chintai:DateTag name="fromMonth" type="month" fixValue="${view.fromMonth}"/> 月
            <chintai:DateTag name="fromDay" type="day" fixValue="${view.fromDay}"/> 日 
            <chintai:DateTag name="fromTime" type="time" fixValue="${view.fromTime}"/> 時 から
            <chintai:DateTag name="toYear" type="year" fixValue="${view.toYear}"/> 年
            <chintai:DateTag name="toMonth" type="month" fixValue="${view.toMonth}"/> 月
            <chintai:DateTag name="toDay" type="day" fixValue="${view.toDay}"/> 日 
            <chintai:DateTag name="toTime" type="time" fixValue="${view.toTime}"/> 時 まで
          </td>
         </tr>
      </table>
      <p>
        <input type="hidden" name="offSet" />
        <input type="hidden" name="insDtFrom" />
        <input type="hidden" name="insDtTo" />
        <input type="submit" value="検索" onclick="search();">
        <input type="reset" value="クリア">
      </p>
    </form>
    
    <!-- 検索結果 -->
    <c:if test="${not empty InquiryLogOperationListView.inquiryLogOperationList}">
    <c:set var="helper" value="${InquiryLogOperationListView}"/>
    <p class="section_header">検索結果</p>
    <%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
    <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    <table class="type_list_nomargin">
      <colgroup>
      </colgroup>
      <tr>
        <th>店舗コード</th>
        <th>会社名<br>事務所名</th>
        <th>処理区分<br>問い合せID</th>
        <th>入稿状態</th>
      </tr>
      <c:forEach items="${view.inquiryLogOperationList}" var="inquiryLog">
      <tr>
        <td>
          <c:out value="${inquiryLog.shopCd}" />
        </td>
        <td class="left">
          <c:choose>
            <c:when test="${not empty inquiryLog.company}">${inquiryLog.company}</c:when>
            <c:otherwise>--</c:otherwise>
          </c:choose>
          <br>
          <c:choose>
            <c:when test="${not empty inquiryLog.bumon}">${inquiryLog.bumon}</c:when>
            <c:otherwise>--</c:otherwise>
          </c:choose>
        </td>
        <td>
          <chintai:CodePrint nameKey="SESSION_STATUS_NAME" valueKey="SESSION_STATUS_VALUE" code="${inquiryLog.sessionStatus}" /><br>
          <c:choose>
            <c:when test="${not empty inquiryLog.inqId}">${inquiryLog.inqId}</c:when>
            <c:otherwise>--</c:otherwise>
          </c:choose>
        </td>
        <td class="right">
          <c:out value="${inquiryLog.updDt}" />
        </td>
      </tr>
      </c:forEach>
    </table>
    <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    </c:if>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>