<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="取引先削除確認" />
<c:set var="view"  value="${TorihikisakiDeleteConfirmView}" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<script type="text/javascript">
<!--
addEvent('load', window, function(){document.getElementsByName('back')[0].focus();});
-->
</script>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link>&gt;
      <html:link action="/demand/TorihikisakiSearchPaging.do">取引先メンテナンス</html:link>&gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">削除取引先</p>
    <html:form action="demand/TorihikisakiDeleteCommit" onsubmit="disableSubmit(this);">
    <table class="type_list">
      <tr>
        <th>取引先コード</th>
        <th>不動産会社名</th>
        <th>取引先名</th>
        <th>住所</th>
      </tr>
      <c:forEach var="detail" items="${view.delelteConfrimList}">
        <tr>
          <td><c:out value="${detail.fudousanCd}"/>-<c:out value="${detail.torihikisakiCd}"/></td>
          <td align="left"><c:out value="${detail.fudousanName}"/></td>
          <td align="left"><c:out value="${detail.torihikisakiName}"/></td>
          <td align="left">
            <c:out value="${detail.prefName}"/><c:out value="${detail.address1}"/><c:out value="${detail.address2}"/>
            <input type="hidden" name="delFlgList" value="${detail.torihikisakiSeq}"/>
            <input type="hidden" name="updDt" value="${detail.updDt}"/>
          </td>
        </tr>
      </c:forEach>
    </table>
    <p align="left">
      <input type="submit" value="削除">
      <input type="button" name="back" value="戻る" onClick="_submit('TorihikisakiDeleteBack.do')">
    </p>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>