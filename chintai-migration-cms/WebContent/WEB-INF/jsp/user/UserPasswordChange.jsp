<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="パスワード変更" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<script type="text/javascript"> 
  addEvent('load', window, function(){document.getElementsByName('passwd')[0].focus();}); 
</script> 
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link> &gt;
      <html:link action="/user/UserList.do">ユーザ管理</html:link> &gt;
      <html:link action="/user/UserInfo.do">
      <html:param name="userId" value="${UserPasswordChangePageView.userId}" />ユーザ情報</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    
    <html:messages id ="msg" header="info.header" footer="info.footer" message="true">
      <c:out value="${msg}"></c:out>
    </html:messages>
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />
    
    <p class="section_header">${title}</p>
    <html:form method="post" action="/user/UserPasswordChangeCommit.do" onsubmit="disableSubmit(this)">
    <input type="hidden" name="userId" value="${UserPasswordChangePageView.userId}" />
    <input type="hidden" name="updDt" value="${UserPasswordChangePageView.updDt}" />
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
        <input type="button" value="戻る" onClick="_submit('UserInfoPageBack.do')">
      </p>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>