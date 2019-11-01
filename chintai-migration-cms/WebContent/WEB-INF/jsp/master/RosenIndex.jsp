<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="沿線・駅メンテナンス" />
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

    <p class="section_header">管理メニュー</p>
    <ul class="menu1">
      <li>
        <html:link action="/master/RosenSearchPage">
          沿線・駅検索
        </html:link>
        <ul class="menu2">
          <li>沿線・駅を検索します。</li>
        </ul>
      </li>
    </ul>
    <ul class="menu1">
      <li>
        <html:link action="/master/RosenUpdatePage">
          沿線・駅登録 / 変更 / 削除
        </html:link>
        <ul class="menu2">
          <li>CSV による沿線・駅の登録、変更、削除を行います。</li>
        </ul>
      </li>
    </ul>
    <ul class="menu1">
      <li>
        <html:link action="/master/RosenDistributeCsvDownloadPage">
          配布用CSVダウンロード
        </html:link>
        <ul class="menu2">
          <li>配布用CSVデータをダウンロードします。</li>
        </ul>
      </li>
    </ul>
    <ul class="menu1">
      <li>
        <html:link action="/master/NodeUpdatePage">
          統一駅登録(NODE)
        </html:link>
        <ul class="menu2">
          <li>CSV による統一駅の登録を行います。</li>
        </ul>
      </li>
    </ul>
 		<%-- <!-- 鉄道会社検索 -->
    <ul class="menu1">
      <li>
        <html:link action="/master/TetudoGaishaSearchPage">
          鉄道会社検索
        </html:link>
        <ul class="menu2">
          <li>鉄道会社を検索します。</li>
        </ul>
      </li>
    </ul>
    --%>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>