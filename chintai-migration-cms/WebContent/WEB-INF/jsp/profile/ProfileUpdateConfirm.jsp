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
      <html:link action="/profile/ProfileInfo.do">プロフィール</html:link> &gt;
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
          <td><c:out value="${ProfileUpdateView.userId}" /></td>
        </tr>
        <tr>
          <th class="text-left">名前</th>
          <td><c:out value="${ProfileUpdateView.userName}" /></td>
        </tr>
        <tr>
          <th class="text-left">グループ</th>
          <td><c:out value="${ProfileUpdateView.groupName}" /></td>
        </tr>
        <tr>
          <th class="text-left">説明</th>
          <td><chintai:filter changeNL2BR="true"><c:out value="${ProfileUpdateView.userNote}" /></chintai:filter></td>
        </tr>
      </table>

      <html:form method="post" action="/profile/ProfileUpdateCommit.do" onsubmit="disableSubmit(this)">
      <p>
        <input type="hidden" name="userId" value="${fn:escapeXml(ProfileUpdateView.userId)}" />
        <input type="hidden" name="userName" value="${fn:escapeXml(ProfileUpdateView.userName)}" />
        <input type="hidden" name="groupId" value="${fn:escapeXml(ProfileUpdateView.groupId)}" />
        <input type="hidden" name="userNote" value="${fn:escapeXml(ProfileUpdateView.userNote)}" />
        <input type="hidden" name="updDt" value="${fn:escapeXml(ProfileUpdateView.updDt)}" />
        <input type="hidden" name="groupName" value="${fn:escapeXml(ProfileUpdateView.groupName)}" />
        <input type="submit" value="更新" />
        <input type="button" value="戻る" onClick="_submit('ProflieUpdatePageBack.do')" />
      </p>
      </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>