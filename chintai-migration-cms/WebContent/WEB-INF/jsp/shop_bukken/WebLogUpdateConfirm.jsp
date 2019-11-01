<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="Webログ利用可否"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<script type="text/javascript">

 addEvent('load', window, function(){document.getElementsByName('commit')[0].focus();});
 
</script>
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
    <p class="section_header">Webログ利用可否確認</p>
      <table class="type_detail">
        <colgroup>
          <col span="1" width="22%">
          <col span="1" width="78%">
        </colgroup>
        <tr>
          <th>Webログ利用可否</th>
          <td>
            <chintai:CodePrint code="${WebLogUpdateView.webLogFlg}" nameKey="WEB_LOG_FLG_NAME" valueKey="WEB_LOG_FLG_VALUE" />          
          </td>
        </tr>
      </table>
      <p>
        <html:form action="/shop_bukken/WebLogUpdateCommit" method="post" onsubmit="disableSubmit(this)">
          <input type="hidden" name="shopCd" value="${WebLogUpdateView.shopCd}" />
          <input type="hidden" name="company" value="${WebLogUpdateView.company}" />
          <input type="hidden" name="bumon" value="${WebLogUpdateView.bumon}" />
          <input type="hidden" name="password" value="${WebLogUpdateView.password}" />
          <input type="hidden" name="updDt" value="${WebLogUpdateView.updDt}" />
          <input type="hidden" name="webLogFlg" value="${WebLogUpdateView.webLogFlg}" />
          <input type="submit" value="更新" name="commit">
          <input type="button" value="戻る" onClick="_submit('WebLogUpdatePageBack.do')">
        </html:form>
      </p>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>