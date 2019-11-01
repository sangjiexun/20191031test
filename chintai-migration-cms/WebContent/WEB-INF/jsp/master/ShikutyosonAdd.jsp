<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="市区町村登録 " />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<!-- メイン -->
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/master/ShikutyosonIndexPage">市区町村メンテナンス </html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">CSV ファイルアップロード</p>
    <html:form action="/master/ShikutyosonAdd.do" method="post" enctype="multipart/form-data" onsubmit="disableSubmit(this)">
      <p>郵政公社よりダウンロードした差分CSVファイルをアップロードします。データの更新はできますが、削除はできません。</p>
      <p><input type="file" name="fileUp" size="50"></p>
      <p><input type="submit" value="アップロード"></p>
    </html:form>

  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
