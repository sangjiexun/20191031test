<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="ユーザ情報" />
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

    <html:messages id ="msg" header="info.header" footer="info.footer" message="true">
      <c:out value="${msg}"></c:out>
    </html:messages>

    <p class="section_header">${title}</p>
    <table class="type_detail">
      <colgroup>
        <col width="15%">
        <col width="85%">
      </colgroup>
      <tr>
        <th class="text-left">ユーザID</th>
        <td><c:out value="${UserInfoView.userId}" /></td>
      </tr>
      <tr>
        <th class="text-left">名前</th>
        <td><c:out value="${UserInfoView.userName}" /></td>
      </tr>
      <tr>
        <th class="text-left">グループ</th>
        <td><c:out value="${UserInfoView.groupName}" /></td>
      </tr>
      <tr>
        <th class="text-left">説明</th>
        <td><c:out value="${UserInfoView.userNote}" /></td>
      </tr>
    </table>
    <p>
      <a href ="<c:url value="UserUpdatePage.do">
                <c:param name="userId" value="${UserInfoView.userId}"/>
                </c:url>">
      &gt;&gt; ユーザ情報を編集
      </a>
    </p>
    <p>
      <a href ="<c:url value="UserPasswordChangePage.do">
                <c:param name="userId" value="${UserInfoView.userId}"/>
                </c:url>">
      &gt;&gt; パスワードを変更
      </a>
    </p>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>