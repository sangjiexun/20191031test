<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="ログイン" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
  addEvent('load', window, function(){document.getElementsByName('userId')[0].focus();});
</script>

<html:form action="/Login">
  <div id="login">
    <html:errors />
    <p>
      ユーザID<br>
      <html:text property="userId" size="15" maxlength="50" />
    </p>
    <p>
      パスワード<br>
      <html:password property="password" size="15" maxlength="50" redisplay="false" />
    </p>
    <p><html:submit value="ログイン"/></p>
  </div>
</html:form>

<%@ include file="../parts/ContentsFooter.jsp" %>