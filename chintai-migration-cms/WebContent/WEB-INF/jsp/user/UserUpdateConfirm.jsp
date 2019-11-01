<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="ユーザ情報編集" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link> &gt;
      <html:link action="/user/UserList.do">ユーザ管理</html:link> &gt;
      <html:link action="/user/UserInfo.do">
      <html:param name="userId" value="${UserUpdateView.userId}" />ユーザ情報</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <p class="section_header">編集内容確認</p>
      <table class="type_detail_pre">
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th class="text-left">ユーザID</th>
          <td><c:out value="${UserUpdateView.userId}" /></td>
        </tr>
        <tr>
          <th class="text-left">名前</th>
          <td><c:out value="${UserUpdateView.userName}" /></td>
        </tr>
        <tr>
          <th class="text-left">グループ</th>
          <td><c:out value="${UserUpdateView.groupName}" /></td>
        </tr>
        <tr>
          <th class="text-left">説明</th>
          <td><chintai:filter changeNL2BR="true"><c:out value="${UserUpdateView.userNote}" /></chintai:filter></td>
        </tr>
      </table>
      <html:form method="post" action="/user/UserUpdateCommit.do" onsubmit="disableSubmit(this)">
      <p>
        <input type="hidden" name="userId" value="${fn:escapeXml(UserUpdateView.userId)}" />
        <input type="hidden" name="userName" value="${fn:escapeXml(UserUpdateView.userName)}" />
        <input type="hidden" name="groupId" value="${fn:escapeXml(UserUpdateView.groupId)}" />
        <input type="hidden" name="userNote" value="${fn:escapeXml(UserUpdateView.userNote)}" />
        <input type="hidden" name="updDt" value="${fn:escapeXml(UserUpdateView.updDt)}" />
        <input type="hidden" name="cjnAccountSeq" value="${fn:escapeXml(UserUpdateView.cjnAccountSeq)}" />
        <input type="submit" value="更新" />
        <input type="button" value="戻る" onClick="_submit('UserUpdatePageBack.do')" />
      </p>
      </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>