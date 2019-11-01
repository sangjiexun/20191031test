<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="グループ一覧" />
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
    
    <p class="section_header">${title}</p>
    <p><html:link action="/user/GroupAddPage">&gt;&gt; 新しいグループを登録する</html:link></p>
    <form action="GroupDeleteConfirm.do" method="post">
    <table class="type_list">
      <colgroup>
        <col width="17%">
        <col span="11" width="7%">
        <col width="6%">
      </colgroup>
      <tr>
        <th></th>
        <c:forEach items="${GroupListView.authorityList}" var="authority" varStatus="i">
          <th><c:out value="${authority.authorityName}"></c:out></th>
        </c:forEach>
        <th>削除</th>
      </tr>
      <tr>
      <c:set var="currentGroupId" value=""/>
      <c:forEach items="${GroupListView.groupList}" var="groupList" varStatus="groupCnt">
        <c:choose>
        <c:when test="${groupList.groupId == 0}">
        <td>
            <c:out value="${groupList.groupName}" />
        </td>
        </c:when>
        <c:otherwise>
        <td>
          <a href ="<c:url value="GroupUpdatePage.do"><c:param name="groupId" value="${groupList.groupId}"/></c:url>">
            <c:out value="${groupList.groupName}" />
          </a>
        </td>
        </c:otherwise>
        </c:choose>
        <c:forEach items="${groupList.groupByAuthorityList}" var="authorityIdList" varStatus="authorityCnt">
          <c:set var="authorityExist" value="${authorityIdList.authorityExist}"/>
          <c:if test="${authorityExist == '1'}">
            <td>○</td>
          </c:if>
          <c:if test="${authorityExist == null}">
            <td></td>
          </c:if>
        </c:forEach>
        <td>
          <c:choose>
          <c:when test="${groupList.groupId == 0}">
            <input type="checkbox" name="groupId" disabled="disabled">
          </c:when>
          <c:otherwise>
          <c:if test="${groupList.groupDeleteCheck == '1'}">
            <input type="checkbox" name="groupId" value="${groupList.groupId}" checked="checked"><br>
          </c:if>
          <c:if test="${groupList.groupDeleteCheck == null}">
            <input type="checkbox" name="groupId" value="${groupList.groupId}"><br>
          </c:if>
          </c:otherwise>
          </c:choose>
        </td>
        <c:if test="${currentGroupId != groupList.groupId && i.count != 1}">
          </tr>
        </c:if>
        <c:set var="currentGroupId" value="${groupList.groupId}"/>
      </c:forEach>
    </table>
    <p class="under_table"><input type="submit" value="チェックしたグループを削除"></p>
    </form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
