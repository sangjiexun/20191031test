<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="ユーザ登録" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<script type="text/javascript"> 
  addEvent('load', window, function(){document.getElementsByName('userId')[0].focus();}); 
</script> 
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
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />
    
    <p class="section_header">${title}</p>
    <form method="post" action="UserAddConfirm.do" onsubmit="disableSubmit(this)">
      <div class="add_form">
        <div class="add_form_title">ユーザID <span class="caution">*</span></div>
        <div class="annotation">ユーザIDを設定します。</div>
        <div class="form_space">
          <input type="text" name="userId" size="20" maxlength="12" value="${fn:escapeXml(UserAddView.userId)}">
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">パスワード <span class="caution">*</span></div>
        <div class="annotation">パスワードを設定します。</div>
        <div class="form_space">
          <input type="password" name="passwd" size="15" maxlength="12">
        </div>
      </div>
      <div class="add_form">
        <div class="add_form_title">パスワード(確認入力) <span class="caution">*</span></div>
        <div class="annotation">確認のため、パスワードをもう一度入力します。</div>
        <div class="form_space">
          <input type="password" name="passwdConfirm" size="15" maxlength="12">
        </div>
      </div>
      <div class="add_form">
        <div class="add_form_title">名前 <span class="caution">*</span></div>
        <div class="annotation">ユーザ名を設定します。</div>
        <div class="form_space">
          <input type="text" name="userName" size="20" maxlength="20" value="${fn:escapeXml(UserAddView.userName)}">
        </div>
      </div>
      
      <div class="add_form">
        <div class="add_form_title">グループ <span class="caution">*</span></div>
        <div class="annotation">ユーザのグループを設定します。</div>
        <div class="form_space">
          <chintai:UserGroup name="groupId" fixValue="${UserAddView.groupId}"/>
        </div>
      </div>
      
      <div class="add_form">
        <div class="add_form_title">説明</div>
        <div class="annotation">このユーザについての説明です。</div>
        <div class="form_space">
          <textarea cols="80" rows="4" name="userNote">${fn:escapeXml(UserAddView.userNote)}</textarea>
        </div>
      </div>
      
      <div class="add_form">
        <input type="submit" value="確認画面へ" />
        <input type="button" value="戻る" onClick="_submit('UserList.do')">
      </div>
    </form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>