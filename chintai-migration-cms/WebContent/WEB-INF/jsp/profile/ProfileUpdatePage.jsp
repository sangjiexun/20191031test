<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="ユーザ情報編集" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<script type="text/javascript">
  addEvent('load', window, function(){document.getElementsByName('userName')[0].focus();});
</script>
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link> &gt;
      <html:link action="/profile/ProfileInfo.do">プロフィール</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"></c:out>
    </html:messages>
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />

    <p class="section_header">${title}</p>
    <html:form method="post" action="/profile/ProfileUpdateConfirm.do" onsubmit="disableSubmit(this)">
    <input type="hidden" name="userId" value="${fn:escapeXml(ProfileUpdateView.userId)}" />
    <input type="hidden" name="updDt" value="${fn:escapeXml(ProfileUpdateView.updDt)}" />
    <input type="hidden" name="groupId" value="${fn:escapeXml(ProfileUpdateView.groupId)}" />
      <div class="add_form">
        <div class="add_form_title">ユーザID</div>
        <div class="annotation">ユーザIDを設定します。</div>
        <div class="form_space">
          <c:out value="${ProfileUpdateView.userId}" /> <span class="caution">(※変更できません)</span>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">名前 <span class="caution">*</span></div>
        <div class="annotation">ユーザ名を設定します。</div>
        <div class="form_space">
          <input type="text" name="userName" size="20" maxlength="20" value="${fn:escapeXml(ProfileUpdateView.userName)}">
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">グループ <span class="caution">*</span></div>
        <div class="annotation">ユーザに与えられた、管理者ユーザの操作機能です。 グループは変更できません。</div>
        <div class="form_space">
          <c:out value="${ProfileUpdateView.groupName}" /> <span class="caution">(※変更できません)</span>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">説明</div>
        <div class="annotation">このユーザについての説明です。</div>
        <div class="form_space">
          <textarea name="userNote" cols="80" rows="4">${fn:escapeXml(ProfileUpdateView.userNote)}</textarea>
        </div>
      </div>

      <p>
        <input type="submit" value="確認画面へ" />
        <input type="button" value="戻る" onClick="_submit('ProfileInfoPageBack.do')">
      </p>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>