<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="グループ削除" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link> &gt;
      <a href="GroupList.do">グループ一覧</a> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <!-- グループ削除 -->
    <p class="section_header">グループ削除確認</p>
    <p>以下のグループを削除します。</p>
    <ul class="normal">
      <c:forEach items="${GroupDeleteConfirmView.groupList}" var="group" varStatus="i">
        <li><c:out value="${group.groupName}" /></li>
      </c:forEach>
    </ul>
    <html:form action="/user/GroupDeleteCommit" method="post" onsubmit="disableSubmit(this)">
      <p>
        <c:forEach items="${GroupDeleteConfirmView.groupList}" var="group" varStatus="i">
          <input type="hidden" name="groupId" value="${group.groupId}">
          <input type="hidden" name="groupName" value="${group.groupName}">
          <input type="hidden" name="updDt" value="${group.updDt}">
        </c:forEach>
        <input type="submit" value="削除">
        <input type="button" value="戻る" onClick="_submit('GroupDeleteConfirmPageBack.do');">
      </p>
    </html:form>

  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
