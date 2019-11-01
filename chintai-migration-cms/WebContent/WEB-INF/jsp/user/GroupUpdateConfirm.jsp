<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="グループ設定変更" />
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

    <p class="section_header">グループ設定変更内容確認</p>
    <html:form action="/user/GroupUpdateCommit" method="post" onsubmit="disableSubmit(this)">
      <table class="type_detail">
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th class="text-left">グループ名</th>
          <td><c:out value="${GroupUpdateConfirmPageView.groupName}" /></td>
        </tr>
        <tr>
          <th class="text-left">利用可能な機能</th>
          <td>
            <table class="tdNoBorder">
              <c:forEach items="${GroupUpdateConfirmPageView.groupByAuthorityList}" var="authorityList" varStatus="i">
                <tr>
                  <td><c:out value="${authorityList.authorityName}" /></td>
                </tr>
              </c:forEach>
            </table>
          </td>
        </tr>
      </table>

      <p>
        <input type="hidden" name="groupId" value="${GroupUpdateConfirmPageView.groupId}">
        <input type="hidden" name="groupName" value="${GroupUpdateConfirmPageView.groupName}">
        <input type="hidden" name="groupUpdDt" value="${GroupUpdateConfirmPageView.groupUpdDt}">
        <c:forEach items="${GroupUpdateConfirmPageView.groupByAuthorityList}" var="authorityList" varStatus="i">
          <input type="hidden" name="authorityId" value="${authorityList.authorityId}">
        </c:forEach>
        <input type="submit" value="更新">
        <input type="button" value="戻る" onClick="_submit('GroupUpdateConfirmPageBack.do');">
      </p>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
