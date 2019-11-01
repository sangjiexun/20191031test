<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="エイブル担当店/取扱店出力情報設定" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<c:set var="view" value="${AblOutSettingView}" />

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/dataoutput/DataoutputIndex">他社データ連携出力設定</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:messages id ="msg" header="info.header" footer="info.footer" message="true">
      <c:out value="${msg}"></c:out>
    </html:messages>
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />



    <html:form action="/dataoutput/AblOutSettingInfo" method="post">
    <p class="section_header">エイブル担当店/取扱店出力情報設定</p>
    <p>
      <html:link action="/dataoutput/AblOutUpdatePage">
        &gt;&gt; エイブル担当店/取扱店出力情報設定を更新する
      </html:link>
    </p>
    <table class="type_list_pre">
      <colgroup>
        <col width="40%">
        <col width="60%">
      </colgroup>
      <tr>
        <th>データ連携対象</th>
        <th>設定値</th>
      </tr>

      <c:forEach items="${view.ablSettingViewList}" var="ablSettingViewList" varStatus="i">
        <tr>
          <td><c:out value="${ablSettingViewList.dcoName}"/></td>
          <td><chintai:CodePrint nameKey="BUKKEN_OUT_KBN_NAME" valueKey="BUKKEN_OUT_KBN_VALUE" code="${ablSettingViewList.bukkenOutKbn}"/></td>
        </tr>
      </c:forEach>
    </table>

    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>