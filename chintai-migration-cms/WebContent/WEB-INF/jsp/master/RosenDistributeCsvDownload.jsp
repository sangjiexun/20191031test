<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="配布用CSVダウンロード" />
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
    
    <p class="section_header">配布用沿線マスタ</p>
    <html:form action="/master/EnsenDistributeCsvDownload" method="post">
      <input type="submit" name="download" value="ダウンロード">
    </html:form>
    
    <p class="section_header">配布用駅マスタ</p>
    <html:form action="/master/EkiDistributeCsvDownload" method="post">
      <input type="submit" name="download" value="ダウンロード">
    </html:form>
    
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>