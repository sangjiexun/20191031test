<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="不動産会社削除確認" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<script type="text/javascript">
<!--
addEvent('load', window, function(){document.getElementsByName('backButton')[0].focus();});
-->
</script>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link>
      &gt;<html:link action="/demand/FudousanSearchPaging.do">不動産会社メンテナンス</html:link>
      &gt;${title}
    </div>
    <h1>${title}</h1>

      <p class="section_header">削除不動産会社</p>
      <html:form action="/demand/FudousanDeleteCommit.do" onsubmit="disableSubmit(this)">
        <table class="type_list">
          <colgroup>
            <col width="15%"/>
            <col width="30%"/>
            <col width="50%"/>
          </colgroup>
          <tr>
            <th>不動産会社コード</th>
            <th>不動産会社名</th>
            <th>住所</th>
          </tr>
          <c:forEach items="${FudousanDeleteView.fudousanDeleteList}" var="detail">
            <tr>
              <td>
                <c:out value="${detail.fudousanCd}" />
                <input type="hidden" name="fudousanCd" value="${detail.fudousanCd}">
		        <input type="hidden" name="updDt" value="${detail.updDt}">
              </td>
              <td align="left">
                <c:out value="${detail.fudousanName}" />
              </td>
              <td align="left">
                <c:out value="${detail.prefName}" /><c:out value="${detail.address1}" /><c:out value="${detail.address2}" />
              </td>
            </tr>
          </c:forEach>
        </table>
        <p>
          <input type="submit" value="削除" />
          <input type="button" value="戻る" name="backButton" onClick="_submit('FudousanDeleteBack.do')">
        </p>
      </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
