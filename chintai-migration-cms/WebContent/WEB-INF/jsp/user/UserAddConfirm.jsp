<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="ユーザ登録" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
<script type="text/javascript">
	function setSubmit(uri){
		var thisForm = document.forms[0];
		thisForm.action = uri;
		thisForm.submit();
	}
</script>
<!-- メイン -->
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link> &gt;
      <html:link action="/user/UserList.do">ユーザ管理</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <p class="section_header">登録内容確認</p>
    <html:form method="post" action="/user/UserAddCommit.do" onsubmit="disableSubmit(this)">
      <table class="type_detail_pre">
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th class="text-left">ユーザID</th>
          <td><c:out value="${UserAddView.userId}" /></td>
        </tr>
        <tr>
          <th class="text-left">パスワード</th>
          <td><c:out value="${UserAddView.passwdDp}" /></td>
        </tr>
        <tr>
          <th class="text-left">名前</th>
          <td><c:out value="${UserAddView.userName}" /></td>
        </tr>
        <tr>
          <th class="text-left">グループ</th>
          <td><c:out value="${UserAddView.groupName}" /></td>
        </tr>
        <tr>
          <th class="text-left">説明</th>
          <td><chintai:filter changeNL2BR="true"><c:out value="${UserAddView.userNote}" /></chintai:filter></td>
        </tr>
      </table>
      <p>
        <input type="hidden" name="userId" value="${fn:escapeXml(UserAddView.userId)}" />
        <input type="hidden" name="passwd" value="${fn:escapeXml(UserAddView.passwd)}" />
        <input type="hidden" name="userName" value="${fn:escapeXml(UserAddView.userName)}" />
        <input type="hidden" name="groupId" value="${fn:escapeXml(UserAddView.groupId)}" />
        <input type="hidden" name="userNote" value="${fn:escapeXml(UserAddView.userNote)}" />
        <input type="submit" value="登録" />
        <input type="button" value="戻る" onClick="_submit('UserAddPageBack.do')">
      </p>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>