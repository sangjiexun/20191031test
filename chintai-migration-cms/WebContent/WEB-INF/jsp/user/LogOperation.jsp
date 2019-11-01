<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="操作ログ" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<c:set var="view" value="${LogOperationListView}" />
<script src="${pageContext.request.contextPath}/dwr/interface/Operation.js"></script>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>

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
    <html:form action="/user/LogOperationSearch" method="get" onsubmit="search();">
      <input type="hidden" name="offSet" />
      <input type="hidden" name="insDtFrom" />
      <input type="hidden" name="insDtTo" />
    <table>
      <tr>
        <td>ユーザID</td>
        <td>
          <input type="text" name="userIdSearch" size="20" maxlength="12" value="${view.userIdSearch}" />
        </td>
      </tr>
      <tr>
        <td>名前</td>
        <td>
          <input type="text" name="userNameSearch" size="20" maxlength="20" value="${view.userNameSearch}" />
        </td>
      </tr>
      <tr>
        <td>操作内容</td>
        <td>
          <chintai:Authority name="authority" fixValue="${view.authority}" onChange="putOperationList();" />
          <select name="operationIdSearch" style="width: 300px" id="operationIdSearch">
          </select>
        </td>
      </tr>
      <tr>
        <td>処理日時</td>
        <td>
          <chintai:DateTag name="fromYear" type="year" fixValue="${view.fromYear}"/> 年
          <chintai:DateTag name="fromMonth" type="month" fixValue="${view.fromMonth}"/> 月
          <chintai:DateTag name="fromDay" type="day" fixValue="${view.fromDay}"/> 日
          <chintai:DateTag name="fromTime" type="time" fixValue="${view.fromTime}"/> 時 から
          <chintai:DateTag name="toYear" type="year" fixValue="${view.toYear}"/> 年
          <chintai:DateTag name="toMonth" type="month" fixValue="${view.toMonth}"/> 月
          <chintai:DateTag name="toDay" type="day" fixValue="${view.toDay}"/> 日
          <chintai:DateTag name="toTime" type="time" fixValue="${view.toTime}"/> 時 まで
        </td>
    </table>

    <!-- 検索結果の出力方法 -->
    <p class="section_header">検索結果の出力方法</p>
      <table>
        <tr>
          <td>ソートキー</td>
          <td>
            <chintai:PropertyOptions name="sortKey" nameKey="LOG_SORT_NAME" valueKey="LOG_SORT_VALUE" fixValue="${view.sortKey}" />
          </td>
          <td>順序</td>
          <td>
            <chintai:PropertyOptions name="orderBy" nameKey="ORDER_BY_NAME" valueKey="ORDER_BY_VALUE" fixValue="${view.orderBy}" />
          </td>
          <td>表示件数</td>
          <td>
            <c:choose>
              <c:when test="${empty view.displayNum}">
                <chintai:PropertyOptions name="displayNum" nameKey="DISPLAY_NUM_NAME" valueKey="DISPLAY_NUM_VALUE" fixValue="50" />
              </c:when>
              <c:otherwise>
                <chintai:PropertyOptions name="displayNum" nameKey="DISPLAY_NUM_NAME" valueKey="DISPLAY_NUM_VALUE" fixValue="${view.displayNum}" />
              </c:otherwise>
            </c:choose>
          </td>
        </tr>
      </table>
      <br>
      <input type="submit" value="検索" >&nbsp;
      <input type="button" value="クリア" onClick="resetOperation()">
    </html:form>

    <!-- 検索結果 -->
    <c:if test="${not empty view.logOperationList}">
    <c:set var="helper" value="${LogOperationListView}"/>

    <p class="section_header">検索結果</p>
    <%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
    <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    <table class="type_list_nomargin">
      <colgroup>
        <col width="10%">
        <col width="10%">
        <col width="30%">
        <col width="10%">
        <col width="25%">
        <col width="15%">
      </colgroup>
      <tr>
        <th>ユーザID</th>
        <th>名前</th>
        <th>操作</th>
        <th>成功／失敗</th>
        <th>変更対象</th>
        <th>時刻</th>
      </tr>
      <c:forEach items="${view.logOperationList}" var="log">
      <tr>
        <td class="center"><c:out value="${log.userId}" /></td>
        <td class="center"><c:out value="${log.userName}" /></td>
        <td class="left"><c:out value="${log.operationName}" /></td>
        <td class="center"><chintai:CodePrint nameKey="LOG_SESSION_STATUS_NAME" valueKey="LOG_SESSION_STATUS_VALUE" code="${log.sessionStatus}"/></td>
        <td class="left"><c:out value="${log.target}" /></td>
        <td class="right"><c:out value="${log.insDt}" /></td>
      </tr>
      </c:forEach>
    </table>
    <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    </c:if>
  </div>
</div>

<script type="text/javascript">
<!--
function joinDate(){
	var thisForm = document.forms[0];
	thisForm.insDtFrom.value = thisForm.fromYear.value + thisForm.fromMonth.value + thisForm.fromDay.value + thisForm.fromTime.value;
	thisForm.insDtTo.value = thisForm.toYear.value + thisForm.toMonth.value + thisForm.toDay.value + thisForm.toTime.value;
}

function page(offSet){
	document.forms[0].offSet.value = offSet;
	joinDate();
	_submit('LogOperationSearchPaging.do');
}

function search(){
	document.forms[0].offSet.value = "";
	joinDate();
}

function putOperationList() {
	var thisForm = document.forms[0];
	thisForm.operationIdSearch.disabled = false;

	var authorityId = dwr.util.getValue("authority");
	if(authorityId != "") {
		Operation.getOperationList(authorityId, function(ret) {
			dwr.util.removeAllOptions("operationIdSearch");
			dwr.util.addOptions("operationIdSearch", ret, "operationId", "operationName");
		});
	} else {
		dwr.util.removeAllOptions("operationIdSearch");
		thisForm.operationIdSearch.disabled = true;
     }
 }

function loadOperationList() {
	var thisForm = document.forms[0];

	var authorityId = '${view.authority}'
	if(authorityId != "") {
		var operationId = '${view.operationIdSearch}';
		if(operationId != "") {
			Operation.getOperationList(authorityId, function(ret) {
				dwr.util.removeAllOptions("operationIdSearch");
				dwr.util.addOptions("operationIdSearch", ret, "operationId", "operationName");
				dwr.util.setValue("operationIdSearch", operationId);
			});
		} else {
			thisForm.operationIdSearch.disabled = true;
		}
	} else {
		thisForm.operationIdSearch.disabled = true;
	}
}

function resetOperation() {
	var thisForm = document.forms[0];

	var authorityId = '${view.authority}';
	if(authorityId == "") {
		dwr.util.removeAllOptions("operationIdSearch");
		thisForm.operationIdSearch.disabled = true;
	}
	thisForm.reset();
}
addEvent('load', window, loadOperationList);
addEvent('load', window, function(){document.getElementsByName('userIdSearch')[0].focus();});
//-->
</script>

<%@ include file="../parts/ContentsFooter.jsp"%>