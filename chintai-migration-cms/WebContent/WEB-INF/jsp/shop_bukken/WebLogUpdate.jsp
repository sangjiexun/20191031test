<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="Webログ利用可否"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_bukken/ShopInfo.do">
      <html:param name="shopCd" value="${WebLogUpdateView.shopCd}" />
        店舗詳細
      </html:link> &gt;
        ${title}
    </div>
    <h1>${title}</h1>
    
    <!-- 店舗コード -->
    <p class="section_header">店舗コード</p>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>店舗名</th>
        <td>
          <c:out value="${WebLogUpdateView.company}" /> /
          <c:out value="${WebLogUpdateView.bumon}" />
        </td>
      </tr>
      <tr>
        <th>店舗コード</th>
        <td>
          <c:out value="${WebLogUpdateView.shopCd}" />
        </td>
      </tr>
      <tr>
        <th>お客様設定パスワード</th>
        <td>
          <c:out value="${WebLogUpdateView.password}" />
        </td>
      </tr>
    </table>
    
    <!-- weblog -->
    <p class="section_header">Webログ利用可否</p>
    <html:form method="post" action="/shop_bukken/WebLogUpdateConfirm" onsubmit="disableSubmit(this)">
      <input type="hidden" name="shopCd" value="${WebLogUpdateView.shopCd}" />
      <input type="hidden" name="company" value="${WebLogUpdateView.company}" />
      <input type="hidden" name="bumon" value="${WebLogUpdateView.bumon}" />
      <input type="hidden" name="password" value="${WebLogUpdateView.password}" />
      <input type="hidden" name="updDt" value="${WebLogUpdateView.updDt}" />
      <div class="add_form">
        <div class="add_form_title">Webログの利用可否</div>
        <div class="annotation">Webログを利用可能にするかどうかを設定します。</div>
        <div class="form_space">
        <c:choose>
          <c:when test="${WebLogUpdateView.webLogFlg == 1}">
            <label>
              <input type="radio" name="webLogFlg" value="1" checked>
              <chintai:CodePrint code="1" nameKey="WEB_LOG_FLG_NAME" valueKey="WEB_LOG_FLG_VALUE" />
            </label>
            <label>
              <input type="radio" name="webLogFlg" value="0">
              <chintai:CodePrint code="0" nameKey="WEB_LOG_FLG_NAME" valueKey="WEB_LOG_FLG_VALUE" />
            </label>
          </c:when>
          <c:otherwise>
            <label>
              <input type="radio" name="webLogFlg" value="1">
              <chintai:CodePrint code="1" nameKey="WEB_LOG_FLG_NAME" valueKey="WEB_LOG_FLG_VALUE" />
            </label>
            <label>
              <input type="radio" name="webLogFlg" value="0" checked>
              <chintai:CodePrint code="0" nameKey="WEB_LOG_FLG_NAME" valueKey="WEB_LOG_FLG_VALUE" />
            </label>
          </c:otherwise>
        </c:choose>
        </div>
      </div>
      
      <div class="add_form">
        <input type="submit" value="確認画面へ">
        <input type="button" value="戻る" onClick="_submit('ShopInfo.do')">
      </div>
    </html:form>
    
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
