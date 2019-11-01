<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="国土地理協会住所データアップロード" />
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
    <form action="JgdcShikutyosonAdd.do" method="post" enctype="multipart/form-data" onsubmit="disableSubmit(this)">
      <p>国土地理協会より提供されたファイルをアップする際は（ZIP形式）で圧縮し、<br>中身のファイルはカンマ区切りでファイル種別はテキスト形式（.txt）でアップしてください。<br>また、アップロードするファイル名は「maf4c.txt.zip」としてください。</p>
      <p><input type="file" name="fileUp" size="50"></p>
      <p><input type="submit" value="アップロード"></p>
    </form>

  </div>
</div>
<script type="text/javascript">
<!--//

// TBD
function setEisabled(){
    var thisForm = document.forms[0];
    if(thisForm.fileUp.value.length != 0) {
       thisForm.fileUp.disabled = false;
    } else {
       thisForm.fileUp.disabled = true;
    }
  }

//-->
</script>
<%@ include file="../parts/ContentsFooter.jsp" %>
