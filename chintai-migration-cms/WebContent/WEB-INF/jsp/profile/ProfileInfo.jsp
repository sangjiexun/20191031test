<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="プロフィール" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"></c:out>
    </html:messages>
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />

    <p class="section_header">ユーザ情報</p>
    <table class="type_detail">
      <colgroup>
        <col width="15%">
        <col width="85%">
      </colgroup>
      <tr>
        <th class="text-left">ユーザID</th>
        <td>
          <c:out value="${ProfileInfoView.userId}" />
        </td>
      </tr>
      <tr>
        <th class="text-left">名前</th>
        <td>
          <c:out value="${ProfileInfoView.userName}" />
        </td>
      </tr>
      <tr>
        <th class="text-left">グループ</th>
        <td>
          <c:out value="${ProfileInfoView.groupName}" />
        </td>
      </tr>
      <tr>
        <th class="text-left">説明</th>
        <td>
          <c:out value="${ProfileInfoView.userNote}" />
        </td>
      </tr>
    </table>
    <p><a href="ProfileUpdatePage.do">&gt;&gt; ユーザ情報を編集</a></p>
    <p><a href="ProfilePasswordChangePage.do">&gt;&gt; パスワードを変更</a></p>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>