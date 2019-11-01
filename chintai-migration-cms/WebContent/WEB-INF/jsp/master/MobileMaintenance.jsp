<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="携帯ゲーム対応機種メンテナンス" />
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
    
    <p class="section_header">CSV ファイルダウンロード</p>
    <form action="MobileMaintenanceCsvDownload.do" method="post">
      <p><input type="submit" name="download" value="ダウンロード"></p>
    </form>
    
    <p class="section_header">CSV ファイルアップロード</p>
    <form action="MobileMaintenanceCsvUpload.do" method="post" enctype="multipart/form-data">
      <p>アップロード時に、既存のデータはすべて削除されます。</p>
      <p><input type="file" name="fileUp" size="50" ></p>
      <p><input type="submit" name="upload" value="アップロード"></p>
    </form>
    
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
