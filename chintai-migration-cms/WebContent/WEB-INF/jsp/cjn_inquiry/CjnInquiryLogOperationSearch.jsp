<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="システム操作履歴検索 (CHINTAIへの問い合せ管理)" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<c:set var="view" value="${CjnLogOperationSearchView}" />
<script type="text/javascript">
function joinDate(){
    var thisForm = document.forms[0];
    var sDate = thisForm.updDtFromYear.value + thisForm.updDtFromMonth.value + thisForm.updDtFromDay.value + thisForm.updDtFromTime.value;
    var eDate = thisForm.updDtToYear.value + thisForm.updDtToMonth.value + thisForm.updDtToDay.value + thisForm.updDtToTime.value;
    var searchTypeValue;
    thisForm.updDtFrom.value = sDate;
    thisForm.updDtTo.value = eDate;
}

function page(offSet){
    document.forms[0].offSet.value = offSet;
    joinDate();
    _submit('CjnLogOperationSearchPaging.do');
}

function search(){
    document.forms[0].offSet.value = "";
    joinDate();
}

addEvent('load', window, function(){document.getElementsByName('userId')[0].focus();});
</script>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
    
    <!-- 検索条件 -->
    <p class="section_header">検索条件</p>
    <html:form method="get" onsubmit="search();" action="/cjn_inquiry/CjnLogOperationSearch">
      <table class="type_searchbox">
        <colgroup>
          <col span="1" width="10%" align="left">
          <col span="1" width="40%" align="left">
          <col span="1" width="10%" align="left">
          <col span="1" width="40%" align="left">
        </colgroup>
        <tr>
          <td>ユーザID</td>
          <td><input type="text" name="userId" value="${fn:escapeXml(view.userId)}" size="20" maxlength="12"></td>
          <td>ユーザ名</td>
          <td><input type="text" name="userName" value="${fn:escapeXml(view.userName)}" size="20" maxlength="20"></td>
        </tr>
        <tr>
          <td>処理区分</td>
          <td>
            <chintai:PropertyOptions name="processStatus"
                  fixValue="${view.processStatus}"
                  nameKey="CJN_INQ_PROCESS_STATUS_NAME"
                  valueKey="CJN_INQ_PROCESS_STATUS_VALUE"/>
          </td>
          <td>問い合せID</td>
          <td><input type="text" name="cjnInqId" value="${fn:escapeXml(view.cjnInqId)}" size="20" maxlength="16"></td>
        </tr>
        <tr>
          <td>問い合せ種別</td>
          <td colspan="3">
            <chintai:InquiryInfo name="cjnInqKindSeq" fixValue="${view.cjnInqKindSeq}" />
          </td>
        </tr>
        <tr>
          <td>処理日時</td>
          <td colspan="3">
            <chintai:DateTag name="updDtFromYear" fixValue="${view.updDtFromYear}" type="year" />年
            <chintai:DateTag name="updDtFromMonth" fixValue="${view.updDtFromMonth}" type="month" />月
            <chintai:DateTag name="updDtFromDay" fixValue="${view.updDtFromDay}"  type="day" />日
            <chintai:DateTag name="updDtFromTime" fixValue="${view.updDtFromTime}"  type="time" />時
            &nbsp;から
            <chintai:DateTag name="updDtToYear" fixValue="${view.updDtToYear}"  type="year" />年
            <chintai:DateTag name="updDtToMonth" fixValue="${view.updDtToMonth}"  type="month" />月
            <chintai:DateTag name="updDtToDay" fixValue="${view.updDtToDay}"  type="day" />日
            <chintai:DateTag name="updDtToTime" fixValue="${view.updDtToTime}"  type="time" />時
            &nbsp;まで
          </td>
        </tr>
      </table>
      <p>
        <input type="hidden" name="updDtFrom">
        <input type="hidden" name="updDtTo">
        <input type="hidden" name="offSet">
        <input type="submit" value="検索">
        <input type="reset" value="クリア">
      </p>
    </html:form>
    
    <!-- 検索結果 -->
    <c:if test="${not empty view.cjnLogOperationList}">
      <p class="section_header">検索結果</p>
      <c:set var="helper" value="${view}"/>
      <%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
      <table class="type_list_nomargin">
        <colgroup>
          <col span="1" width="15%">
          <col span="1" width="45%">
          <col span="1" width="20%">
          <col span="1" width="20%">
        </colgroup>
        <tr>
          <th>ユーザID<br>ユーザ名</th>
          <th>処理区分</th>
          <th>問い合せID<br>問い合せ種別</th>
          <th>処理日時</th>
        </tr>
        <c:forEach items="${view.cjnLogOperationList}" var="log">
          <tr>
            <td class="left">
              <c:choose>
                <c:when test="${not empty log.cjnAccountSeq and not empty log.userId and log.userId == log.authUserId}">
                  <html:link action="/cjn_inquiry/CjnUserInfo.do">
                    <html:param name="cjnAccountSeq" value="${log.cjnAccountSeq}" />
                    <c:out value="${log.userId}" />
                  </html:link>
                </c:when>
                <c:when test="${not empty log.cjnAccountSeq and not empty log.userId and log.userId != log.authUserId}">
                  <c:out value="${log.userId}" />
                </c:when>
                <c:otherwise>--</c:otherwise>
              </c:choose>
              <br>
              <c:out value="${log.userName}" />
            </td>
            <td>
              <chintai:CodePrint code="${log.sessionStatus}"
                    nameKey="CJN_INQ_PROCESS_STATUS_NAME" valueKey="CJN_INQ_PROCESS_STATUS_VALUE" />
            </td>
            <td class="left">
                <c:out value="${log.cjnInqId}" />
              <br />
              <c:choose>
                <c:when test="${not empty log.cjnInqKindSeq}">
                  <html:link action="/cjn_inquiry/CjnInquirySearchPage.do">
                    <html:param name="cjnInqKindSeq" value="${log.cjnInqKindSeq}" />
                    <c:out value="${log.inqTitle}" />
                  </html:link>
                </c:when>
                <c:otherwise><c:out value="${log.inqTitle}" /></c:otherwise>
              </c:choose>
            </td>
            <td class="right"><c:out value="${log.updDt}" /></td>
          </tr>
        </c:forEach>
      </table>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    </c:if>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
