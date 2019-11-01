<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="グループ設定変更" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<script type="text/javascript">
  addEvent('load', window, function(){document.getElementsByName('groupName')[0].focus();});
</script>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link> &gt;
      <a href="GroupList.do">グループ一覧</a> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:messages id ="msg" header="info.header" footer="info.footer" message="true">
      <c:out value="${msg}"></c:out>
    </html:messages>
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />

    <p class="section_header">グループ設定</p>
    <html:form method="post" action="/user/GroupUpdateConfirm">
      <div class="add_form">
        <div class="add_form_title">グループ名</div>
        <div class="annotation">グループの名前を指定します。</div>
        <div class="form_space"><input type="text" name="groupName" size="20" maxlength="20"  value="${GroupUpdatePageView.groupName}"></div>
      </div>

      <div class="add_form">
        <div class="add_form_title">利用可能な機能</div>
        <div class="annotation">このグループが利用可能な機能にチェックをしてください。</div>
        <table class="type_none">
          <tr>
          <c:forEach items="${GroupUpdatePageView.groupAuthorityList}" var="groupAuthority" varStatus="i">
            <td>
            <c:if test="${groupAuthority.authorityExist == '1'}">
              <input type="checkbox" name="authorityId" value="${groupAuthority.authorityId}" checked="checked"><c:out value="${groupAuthority.authorityName}" />
            </c:if>
            <c:if test="${groupAuthority.authorityExist == null}">
              <input type="checkbox" name="authorityId" value="${groupAuthority.authorityId}"><c:out value="${groupAuthority.authorityName}" />
            </c:if>
            </td>
            <c:if test="${((i.count) mod 3) == 0}">
               </tr>
               <tr>
            </c:if>
          </c:forEach>
          <c:if test="${((i.count) mod 3) != 0}">
             </tr>
          </c:if>
        </table>
      </div>
      <p>
        <input type="hidden" name="groupId" value="${GroupUpdatePageView.groupId}">
        <input type="hidden" name="groupUpdDt" value="${GroupUpdatePageView.groupUpdDt}">
        <input type="submit" value="確認画面へ">
        <input type="button" value="戻る" onclick="_submit('GroupList.do');">
      </p>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
