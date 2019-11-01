<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="メールアドレス抽出" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<!-- メイン -->
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ </html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
    
    <p class="section_header">メールマガジン用メールアドレス</p>
    <form action="MailMagazineDownload.do" method="post">
      <input type="submit" name="download" value="ダウンロード">
    </form>
    
    <p class="section_header">不動産会社メールアドレス</p>
    <form action="ShopMailAddressListDownload.do" method="post">
      <input type="submit" name="download" value="ダウンロード">
    </form>
    
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>