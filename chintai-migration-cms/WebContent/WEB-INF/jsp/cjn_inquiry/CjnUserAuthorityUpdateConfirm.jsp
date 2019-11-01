<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="閲覧可能問い合せ権限変更" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<script type="text/javascript">

 addEvent('load', window, function(){document.getElementsByName('commit')[0].focus();});

</script>
<c:set value="${CjnUserAuthorityUpdateView}" var="view" />

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnUserList">問い合せユーザ一覧</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnUserInfo">
        <html:param name="cjnAccountSeq" value="${view.cjnAccountSeq}" />
        問い合せユーザ情報
      </html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

   <p class="section_header">ユーザ基本情報</p>
    <table class="type_detail">
      <colgroup>
          <col width="20%">
          <col width="80%">
      </colgroup>
      <tr>
        <th class="text-left">ユーザシーケンス</th>
        <td><c:out value="${view.cjnAccountSeq}" /></td>
      </tr>
      <tr>
        <th class="text-left">ユーザID</th>
        <td><c:out value="${view.userId}" /></td>
      </tr>
      <tr>
        <th class="text-left">名前</th>
        <td><c:out value="${view.userName}" /></td>
      </tr>
    </table>

    <p class="section_header">閲覧可能問い合せ権限変更内容確認</p>
    <c:if test="${not empty CjnUserAuthorityUpdateView.userAccountList}">
    <html:form  method="post" action="/cjn_inquiry/CjnUserAuthorityUpdateCommit" onsubmit="disableSubmit(this)">
      <table class="type_list">
        <colgroup>
          <col width="10%">
          <col width="55%">
          <col width="25%">
        <colgroup>
        <tr>
          <th>閲覧可否</th>
          <th>問い合せタイトル</th>
          <th>問い合せ説明</th>
        </tr>
        <c:forEach items="${CjnUserAuthorityUpdateView.userAccountList}" var="list" >
          <tr>
            <td>
              <c:choose>
                <c:when test="${list.cnt == 1}" >
                ○
                <input type="hidden" name="cjnInqKindSeq" value="${list.cjnInqKindSeq}">
                <input type="hidden" name="cnt" value="${list.cnt}">
                </c:when>
                <c:otherwise>
                ×
                </c:otherwise>
              </c:choose>
            </td>
            <td class="left"><c:out value="${list.inqTitle}" /></td>
            <td class="left"><c:out value="${list.inqComment}" /></td>
            <input type="hidden" name="inqTitle" value="${list.inqTitle}">
            <input type="hidden" name="inqComment" value="${list.inqComment}">
          </tr>
        </c:forEach>
      </table>
      <p>
        <input type="hidden" name="cjnAccountSeq" value="${view.cjnAccountSeq}">
        <input type="hidden" name="userId" value="${view.userId}">
        <input type="hidden" name="userName" value="${view.userName}">
        <input type="hidden" name="updDt" value="${view.updDt}">
        <input type="submit" value="更新" name="commit" >
        <input type="button" name="back" value="戻る" onClick="_submit('CjnUserAuthorityUpdatePageBack.do')">
      </p>
    </html:form>
    </c:if>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
