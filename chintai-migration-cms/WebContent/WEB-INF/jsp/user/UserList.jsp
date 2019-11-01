<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="ユーザ管理" />
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
    
    <html:messages id ="msg" header="info.header" footer="info.footer" message="true">
      <c:out value="${msg}"></c:out>
    </html:messages>
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />
    
    <p><a href="UserAddPage.do">&gt;&gt; 新規ユーザを登録する</a></p>
    
    <p class="section_header">ユーザ一覧</p>
    <html:form action="/user/UserDeleteConfirm.do" method="post">
      <table class="type_list">
        <colgroup>
          <col width="12%">
          <col width="15%">
          <col width="11%">
          <col width="55%">
          <col width="7%">
        </colgroup>
        <tr>
          <th>ユーザID</th>
          <th>名前</th>
          <th>グループ</th>
          <th>説明</th>
          <th>削除</th>
        </tr>
        <c:forEach items="${UserListView.userList}" var="user">
        <tr>
          <td class="left">
            <a href ="<c:url value="UserInfo.do">
              <c:param name="userId" value="${user.userId}"/>
              </c:url>">
              <c:out value="${user.userId}" />
            </a>
          </td>
          <td class="left"><c:out value="${user.userName}" /></td>
          <td><c:out value="${user.groupName}" /></td>
          <td class="left"><c:out value="${user.userNote}" /></td>
          <td>
          <c:choose>
            <c:when test="${user.disabled != null}">
              <input type="checkbox" name="userCheckId" value="${user.userId}" disabled="disabled" />
            </c:when>
            <c:when test="${user.check != null}">
              <input type="checkbox" name="userCheckId" value="${user.userId}" checked="checked" >
            </c:when>
            <c:otherwise>
              <input type="checkbox" name="userCheckId" value="${user.userId}" >
            </c:otherwise>
          </c:choose>
          </td>
        </tr>
        </c:forEach>  
      </table>
      <p class="under_table"><input type="submit" value="チェックしたユーザを削除"></p>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>