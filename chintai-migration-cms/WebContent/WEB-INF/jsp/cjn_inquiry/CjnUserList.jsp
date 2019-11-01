<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="問い合せユーザ一覧" />
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
    
    <p class="section_header">ユーザ一覧</p>
    <c:if test="${not empty CjnUserListView.userList}">
    <form  method="post">
      <table class="type_list">
        <colgroup>
          <col width="12%">
          <col width="15%">
          <col width="30%">
          <col width="9%">
          <col width="20%">
        </colgroup>
        <tr>
          <th>ユーザID</th>
          <th>名前</th>
          <th>お知らせ送付メールアドレス</th>
          <th>レベル</th>
          <th>登録日時<br>更新日時</th>
        </tr>
        <c:forEach items="${CjnUserListView.userList}" var="view">
          <tr>
            <td class="left">
            <a href="<c:url value="CjnUserInfo.do">
                  <c:param name="cjnAccountSeq" value="${view.cjnAccountSeq}"/>
                  </c:url>">${view.userId}</a></td>
            <td class="left">${view.userName}</td>
            <td class="left">
              (1)<c:if test="${view.emailStatus1==0}"><font color="#ff0000"></c:if>
                 <chintai:CodePrint code="${view.emailStatus1}" nameKey="CJN_EMAIL_STATUS_NAME" valueKey="CJN_EMAIL_STATUS_VALUE" /> 
                 <c:if test="${view.emailStatus1==0}"></font></c:if>
                                                ： ${view.email1}<br>
              (2)<c:if test="${view.emailStatus2==0}"><font color="#ff0000"></c:if>
                 <chintai:CodePrint code="${view.emailStatus2}" nameKey="CJN_EMAIL_STATUS_NAME" valueKey="CJN_EMAIL_STATUS_VALUE" /> 
                 <c:if test="${view.emailStatus2==0}"></font></c:if>
                                                ： ${view.email2}<br>
              (3)<c:if test="${view.emailStatus3==0}"><font color="#ff0000"></c:if>
                 <chintai:CodePrint code="${view.emailStatus3}" nameKey="CJN_EMAIL_STATUS_NAME" valueKey="CJN_EMAIL_STATUS_VALUE" /> 
                 <c:if test="${view.emailStatus3==0}"></font></c:if>
                                                ： ${view.email3}<br>
            </td>
            <td>
              <c:if test="${view.accountLevel==1}"><font color="#ff0000"></c:if>
              <chintai:CodePrint code="${view.accountLevel}" nameKey="CJN_ACCOUNT_TYPE_NAME" valueKey="CJN_ACCOUNT_TYPE_VALUE"/>
              <c:if test="${view.accountLevel==1}"></font></c:if>
            </td>
            <td class="right">
              <c:out value="${view.insDt}" />
              <br>
              <c:out value="${view.updDt}" />
            </td>
          </tr>
        </c:forEach>
      </table>
    </form>
    </c:if>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
