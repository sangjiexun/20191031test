<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="パスワード変更" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
<script type="text/javascript">
  addEvent('load', window, function(){document.getElementsByName('oldPasswd')[0].focus();});
</script>
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
    <html:form action="/profile/ProfilePasswordChangeCommit.do" method="post" onsubmit="disableSubmit(this)">
    <input type="hidden" name="updDt" value="${fn:escapeXml(ProfilePasswordChangePageView.updDt)}" />
      <div class="add_form">
        <div class="add_form_title">現在のパスワード <span class="caution">*</span></div>
        <div class="annotation">現在使用しているパスワードを入力します。</div>
        <div class="form_space">
          <input type="password" name="oldPasswd" size="15" maxlength="12">
        </div>
      </div>
      <div class="add_form">
        <div class="add_form_title">新しいパスワード <span class="caution">*</span></div>
        <div class="annotation">新しいパスワードを入力します。</div>
        <div class="form_space">
          <input type="password" name="passwd" size="15" maxlength="12">
        </div>
      </div>
      <div class="add_form">
        <div class="add_form_title">新しいパスワード(確認入力) <span class="caution">*</span></div>
        <div class="annotation">確認のため、新しいパスワードをもう一度入力します。</div>
        <div class="form_space">
          <input type="password" name="passwdConfirm" size="15" maxlength="12">
        </div>
      </div>

      <p>
        <input type="submit" value="変更" />
        <input type="button" value="戻る" onClick="_submit('ProfileInfoPageBack.do')">
      </p>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>