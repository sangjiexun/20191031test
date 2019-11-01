<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="統一駅登録(NODE)" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<!-- メイン -->
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ </html:link> &gt;
      <html:link action="/master/RosenIndex.do">沿線・駅メンテナンス</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
    <p class="section_header">CSV ファイルアップロード</p>
    <html:form action="/master/NodeUpdateCommit.do" method="post" enctype="multipart/form-data" onsubmit="disableSubmit(this)">
      <input type="file" name="uploadFile" size="50"><br>
      <input type="submit" value="アップロード">
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
