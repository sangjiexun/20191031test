<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="閲覧可能ユーザ変更" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<script type="text/javascript">

 addEvent('load', window, function(){document.getElementsByName('commit')[0].focus();});

</script>
<c:set var="view" value="${CjnUserAvailabilityUpdateView}" scope="page" />

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnInquiryTypeList">問い合せ種別一覧</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnInquiryTypeInfo">
        <html:param name="cjnInqKindSeq" value="${view.cjnInqKindSeq}" />
        問い合せ種別詳細
      </html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <p class="section_header">問い合せ種別基本情報</p>
    <table class="type_detail">
      <colgroup>
          <col width="20%">
          <col width="80%">
      </colgroup>
      <tr>
        <th class="text-left">問い合せ種別シーケンス</th>
        <td><c:out value="${view.cjnInqKindSeq}" /></td>
      </tr>
      <tr>
        <th class="text-left">問い合せタイトル</th>
        <td><c:out value="${view.inqTitle}" /></td>
      </tr>
      <tr>
        <th class="text-left">問い合せ説明</th>
        <td><c:out value="${view.inqComment}" /></td>
      </tr>
    </table>

    <p class="section_header">閲覧可能ユーザ変更内容確認</p>
    <html:form method="post" action="/cjn_inquiry/CjnUserAvailabilityUpdateCommit" onsubmit="disableSubmit(this)">
      <table class="type_list">
        <colgroup>
          <col width="10%">
          <col width="90%">
        </colgroup>
        <tr>
          <th>閲覧可否</th>
          <th>名前</th>
        </tr>
        <c:forEach items="${view.userList}" var="user">
          <tr>
            <td>
              <label>
                <c:choose>
                  <c:when test="${user.exists}">
                    ○
                    <input type="hidden" name="cjnAccountSeq" value="${user.cjnAccountSeq}">
                    <input type="hidden" name="exists" value="${user.exists}">
                  </c:when>
                  <c:otherwise>
                    ×
                    <input type="hidden" name="cjnAccountSeq" value="${user.cjnAccountSeq}">
                    <input type="hidden" name="exists" value="${user.exists}">
                  </c:otherwise>
                </c:choose>
              </label>
            </td>
            <td class="left">
              <c:out value="${user.userName}" />
              <input type="hidden" name="userName" value="${user.userName}">
            </td>
          </tr>
        </c:forEach>
      </table>

      <p>
        <input type="hidden" name="cjnInqKindSeq" value="${view.cjnInqKindSeq}">
        <input type="hidden" name="inqTitle" value="${fn:escapeXml(view.inqTitle)}">
        <input type="hidden" name="inqComment" value="${fn:escapeXml(view.inqComment)}">
        <input type="hidden" name="lastUpdateTime" value="${view.lastUpdateTime}">
        <input type="submit" name="commit" value="更新">
        <input type="button" name="back" value="戻る" onclick="_submit('CjnUserAvailabilityUpdatePageBack.do')">
      </p>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
