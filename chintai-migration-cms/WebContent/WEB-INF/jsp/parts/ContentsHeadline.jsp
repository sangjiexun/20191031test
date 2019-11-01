<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
  <div id="headline">
    <a href="${pageContext.request.contextPath}/profile/ProfileInfo.do"><c:out value="${SessionBean.userName}" /></a> /
    <a href="${pageContext.request.contextPath}/Logout.do">ログアウト</a>
  </div>