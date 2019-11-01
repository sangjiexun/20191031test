<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="市区町村メンテナンス" />
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

    <p class="section_header">管理メニュー</p>
    <ul class="menu1">
      <li><html:link action="/master/ShikutyosonSearchPage">市区町村検索</html:link>
        <ul class="menu2">
          <li>市区町村を検索します。</li>
        </ul>
      </li>
    </ul>
    <ul class="menu1">
      <li><html:link action="/master/ShikutyosonAddPage">市区町村登録</html:link>
        <ul class="menu2">
          <li>CSV による市区町村の登録を行います。変更、削除はできません。</li>
        </ul>
      </li>
    </ul>
    <ul class="menu1">
      <li><html:link action="/master/JgdcShikutyosonAddPage">国土地理協会住所データアップロード</html:link>
        <ul class="menu2">
          <li>国土地理協会住所データ（TXTファイルをZIP形式）をアップロードします。※ファイル名は「maf4c.txt.zip」としてください。</li>
        </ul>
      </li>
    </ul>

  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
