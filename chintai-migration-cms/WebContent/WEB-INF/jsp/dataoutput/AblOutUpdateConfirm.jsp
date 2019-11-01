<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="エイブル担当店/取扱店出力情報設定更新確認" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
<html:form action="/dataoutput/AblOutupdateCommit" method="post" onsubmit="disableSubmit(this)">
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/dataoutput/DataoutputIndex">他社データ連携出力設定</html:link> &gt;
      <html:link action="/dataoutput/AblOutSettingInfo">エイブル担当店/取扱店出力情報設定</html:link> &gt;
      エイブル担当店/取扱店出力情報設定更新確認
    </div>

    <h1>${title}</h1>

    <c:set var="view" value="${AblOutSettingView}" />
    <p class="section_header">更新内容確認</p>
    <div class="add_form">
      <div class="form_space">
        <table class="type_list" style="width: 99%;">
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
              <td>
                <c:out value="${ablSettingViewList.dcoName}"/>
                <input type="hidden" name="dcoTypeArray" value="${ablSettingViewList.dcoType}">
                <input type="hidden" name="dcoNameArray" value="${ablSettingViewList.dcoName}">
              </td>
              <td>
                <chintai:CodePrint nameKey="BUKKEN_OUT_KBN_NAME" valueKey="BUKKEN_OUT_KBN_VALUE" code="${ablSettingViewList.bukkenOutKbn}"/>
                <input type="hidden" name="bukkenOutKbnArray" value="${ablSettingViewList.bukkenOutKbn}">
                <input type="hidden" name="updDtArray" value="${ablSettingViewList.updDt}">
              </td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>

    <input type="submit" value="更新" />
    <input type="button" value="戻る" onClick="_submit('AblOutUpdateBack.do');"/>

  </div>
</html:form>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>