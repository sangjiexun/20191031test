<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="大学マスタメンテナンス" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<!-- メイン -->
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">CSV ファイルアップロード</p>
    <html:form action="/master/SchoolMaintenanceCsvUpload.do" method="post" enctype="multipart/form-data" onsubmit="disableSubmit(this)">
      <p>アップロード時に、既存のデータはすべて削除されます。</p>
      <p><input type="file" name="fileUp" size="50" ></p>
      <p><input type="submit" name="upload" value="アップロード" ></p>
    </html:form>

  </div>
</div>



<%@ include file="../parts/ContentsFooter.jsp" %>
