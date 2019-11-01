<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗対象外設定変更" />
<c:set var="view"  value="${ReviewShopStatusUpdateView}"/>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/review/ReviewShopInfo" paramId="shopCd" paramName="view" paramProperty="shopCd">
        店舗詳細
      </html:link>&gt;${title}
    </div>
    <h1>${title}</h1>

    <p class="section_header">店舗情報</p>
    <%@ include file="parts/ShopInfoPart.jsp" %>

    <p class="section_header">${title}内容の確認</p>
    <html:form action="/review/ReviewShopStatusUpdateCommit" onsubmit="disableSubmit(this)">
      <table class="type_detail">
        <colgroup>
          <col width="22%">
          <col width="78%">
        </colgroup>
        <tr>
          <th class="text-left">店舗対象外設定</th>
          <td>
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
              <th>メール送信</th>
              <td><chintai:CodePrint code="${view.mailSendSkipFlg}"  nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/></td>
            </tr>
            <tr>
              <th>自動削除</th>
              <td><chintai:CodePrint code="${view.autoDelSkipFlg}"  nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/><br></td>
            </tr>
          </table>
          </td>
        </tr>
        <tr>
          <th class="text-left">備考</th>
          <td><chintai:filter changeNL2BR="true"><c:out value="${view.shinsaSkipBikou}"/></chintai:filter></td>
        </tr>
      </table>
      <p>
        <input type="hidden" name="shopCd"              value="${view.shopCd}">
        <input type="hidden" name="syokaiShinsaSkipFlg" value="${view.syokaiShinsaSkipFlg}">
        <input type="hidden" name="teikiShinsaSkipFlg"  value="${view.teikiShinsaSkipFlg}">
        <input type="hidden" name="mailSendSkipFlg"     value="${view.mailSendSkipFlg}">
        <input type="hidden" name="autoDelSkipFlg"      value="${view.autoDelSkipFlg}">
        <input type="hidden" name="shinsaSkipBikou"     value="${fn:escapeXml(view.shinsaSkipBikou)}">
        <input type="hidden" name="updDt"               value="${view.updDt}">
        <input type="submit" value="更新" >
        <input type="button" value="戻る" onClick="_submit('ReviewShopStatusUpdatePageBack.do');">
      </p>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
