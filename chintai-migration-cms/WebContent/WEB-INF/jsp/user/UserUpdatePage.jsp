<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="ユーザ情報編集" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
<script type="text/javascript">
  addEvent('load', window, function(){document.getElementsByName('userName')[0].focus();});
</script>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link> &gt;
      <html:link action="/user/UserList.do">ユーザ管理</html:link> &gt;
      <html:link action="/user/UserInfo.do">
      <html:param name="userId" value="${UserUpdateView.userId}" />ユーザ情報</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:messages id ="msg" header="info.header" footer="info.footer" message="true">
      <c:out value="${msg}"></c:out>
    </html:messages>
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />

    <p class="section_header">${title}</p>
    <html:form action="/user/UserUpdateConfirm.do" method="post"  onsubmit="disableSubmit(this)">
    <input type="hidden" name="userId" value="${fn:escapeXml(UserUpdateView.userId)}" />
    <input type="hidden" name="updDt" value="${fn:escapeXml(UserUpdateView.updDt)}" />
    <input type="hidden" name="cjnAccountSeq" value="${fn:escapeXml(UserUpdateView.cjnAccountSeq)}" />
      <div class="add_form">
        <div class="add_form_title">ユーザID</div>
        <div class="annotation">ユーザIDを設定します。</div>
        <div class="form_space">
          <c:out value="${UserUpdateView.userId}" /> <span class="caution">(※変更できません)</span>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">名前 <span class="caution">*</span></div>
        <div class="annotation">ユーザ名を設定します。</div>
        <div class="form_space">
          <input type="text" name="userName" size="20" maxlength="20" value="${fn:escapeXml(UserUpdateView.userName)}">
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">グループ <span class="caution">*</span></div>
        <div class="annotation">ユーザのグループを設定します。</div>
        <div class="form_space">
          <chintai:UserGroup name="groupId" fixValue="${UserUpdateView.groupId}"/>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">説明</div>
        <div class="annotation">このユーザについての説明です。</div>
        <div class="form_space">
          <textarea name="userNote" cols="80" rows="4">${fn:escapeXml(UserUpdateView.userNote)}</textarea>
        </div>
      </div>

      <p>
        <input type="submit" value="確認画面へ" />
        <input type="button" value="戻る" onClick="_submit('UserInfoPageBack.do')">
      </p>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>