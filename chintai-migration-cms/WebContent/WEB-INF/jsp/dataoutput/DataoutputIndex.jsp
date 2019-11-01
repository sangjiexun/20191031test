<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="他社データ連携出力設定" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
    <html:link action="/Index.do">トップページ</html:link> &gt;
    ${title}
    </div>
    <h1>${title}</h1>
    <p class="section_header">管理メニュー</p>
    <ul class="menu1">
      <li><a href="PrefClientSettingInfoPage.do">都道府県別データ元出力設定</a>
        <ul class="menu2">
          <li>都道府県別にデータ元に対して出力するしないを設定します。</li>
        </ul>
      </li>
      <li><a href="ShikutyosonClientSettingSearchPage.do">市区町村別データ元出力設定</a>
        <ul class="menu2">
          <li>市区町村別にデータ元に対して出力するしないを設定します。</li>
        </ul>
      </li>
      <li><a href="RosenClientSettingSearchPage.do">沿線、駅別データ元出力設定</a>
        <ul class="menu2">
          <li>沿線、駅別にデータ元に対して出力するしないを設定します。</li>
        </ul>
      </li>
      <li><a href="AblOutSettingInfo.do">エイブル担当店/取扱店出力情報設定</a>
        <ul class="menu2">
          <li>エイブルの担当店のみまたは、担当店/取扱店全てを出力するかを設定をします。</li>
        </ul>
      </li>
      <li><a href="ShopSkipSettingInfo.do">店舗別出力設定</a>
        <ul class="menu2">
          <li>店舗別に出力するしないを設定します。</li>
        </ul>
      </li>
    </ul>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>