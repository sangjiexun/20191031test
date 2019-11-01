<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="物件対象外設定変更" />
<c:set var="view" value="${ReviewBukkenStatusUpdateView}"/>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/review/ReviewBukkenInfo" paramId="roomKey" paramName="view" paramProperty="roomKey">
        物件詳細
      </html:link>&gt;${title}
    </div>
    <h1>${title}</h1>
    <p class="section_header">物件情報</p>
    <%@ include file="parts/BukkenInfoPart.jsp" %>

    <p class="section_header">${title}内容の確認</p>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="20%">
        <col span="1" width="80%">
      </colgroup>
      <tr>
        <th class="text-left">物件対象外設定</th>
        <td class="annotation">
          <!-- inline table -->
          <table class="type_none">
            <tr>
              <th>初回審査</th>
              <td><chintai:CodePrint code="${view.syokaiShinsaSkipFlg}" nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/></td>
            </tr>
            <tr>
              <th>定期審査</th>
              <td><chintai:CodePrint code="${view.teikiShinsaSkipFlg}"  nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/></td>
            </tr>
            <tr>
              <th>自動削除</th>
              <td><chintai:CodePrint code="${view.autoDelSkipFlg}"  nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/></td>
            </tr>
          </table>
        </td>
      </tr>
      <tr>
        <th class="text-left">備考</th>
        <td><chintai:filter changeNL2BR="true"><c:out value="${view.shinsaSkipBikou}" /></chintai:filter></td>
      </tr>
    </table>

    <html:form action="/review/ReviewBukkenStatusUpdateCommit" onsubmit="disableSubmit(this)">
      <p>
        <input type="hidden" name="kanriCd"             value="${view.kanriCd}">
        <input type="hidden" name="syokaiShinsaSkipFlg" value="${view.syokaiShinsaSkipFlg}">
        <input type="hidden" name="teikiShinsaSkipFlg"  value="${view.teikiShinsaSkipFlg}">
        <input type="hidden" name="autoDelSkipFlg"      value="${view.autoDelSkipFlg}">
        <input type="hidden" name="shinsaSkipBikou"     value="${fn:escapeXml(view.shinsaSkipBikou)}">
        <input type="hidden" name="updDt"               value="${view.updDt}">
        <input type="hidden" name="roomKey"             value="${view.roomKey}">
        <input type="submit" value="更新">
        <input type="button" value="戻る" onClick="_submit('ReviewBukkenStatusUpdatePageBack.do');">
      </p>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
