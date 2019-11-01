<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="ユーザ削除" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link> &gt;
      <html:link action="/user/UserList.do">ユーザ管理</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    
    <!-- ユーザ削除 -->
    <p class="section_header">ユーザ削除確認</p>
    <p>
      以下のユーザを削除します。
    </p>
    <html:form method="post" action="/user/UserDeleteCommit.do" onsubmit="disableSubmit(this)">
    <ul class="normal">

    <c:forEach items="${UserDeleteView.userDeleteList}" var="user">
      <li><c:out value="${user.userId}"></c:out></li>
      <input type="hidden" name="userCheckId" value="${fn:escapeXml(user.userId)}">
      <input type="hidden" name="updDt" value="${fn:escapeXml(user.updDt)}">
     </c:forEach>
    </ul>
      <p>
        <input type="submit" value="削除" />
        <input type="button" value="戻る" onClick="_submit('UserListPageBack.do')">
      </p>
    </html:form>
    
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>