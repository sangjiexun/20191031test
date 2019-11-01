<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="${ContractNormalUpdateView.keiyakuName}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<script type="text/javascript">

 addEvent('load', window, function(){document.getElementsByName('commit')[0].focus();});

</script>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_bukken/ShopInfo.do">
      <html:param name="shopCd" value="${ContractNormalUpdateView.shopCd}" />
        店舗・契約詳細
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
          <c:out value="${ContractNormalUpdateView.company}" />
          <c:if test="${not empty ContractNormalUpdateView.company and not empty ContractNormalUpdateView.bumon}"> / </c:if>
          <c:out value="${ContractNormalUpdateView.bumon}" />
        </td>
      </tr>
      <tr>
        <th>店舗コード</th>
        <td><c:out value="${ContractNormalUpdateView.shopCd}" /></td>
      </tr>
      <tr>
        <th>お客様設定パスワード</th>
        <td><c:out value="${ContractNormalUpdateView.password}" /></td>
      </tr>
    </table>

    <!-- ContractNormal -->
    <p class="section_header">${ContractNormalUpdateView.keiyakuName}確認</p>
      <table class="type_detail">
        <colgroup>
          <col span="1" width="22%">
          <col span="1" width="78%">
        </colgroup>
        <tr>
          <th>${ContractNormalUpdateView.keiyakuName}</th>
          <td>
          <c:choose>
            <c:when test="${ContractNormalUpdateView.keiyakuFlag == '1'}">
              契約済
            </c:when>
            <c:when test="${ContractNormalUpdateView.keiyakuFlag == '0'}">
              未契約
            </c:when>
          </c:choose>
          </td>
        </tr>
      </table>
      <p>
        <html:form action="/shop_bukken/ContractNormalUpdateCommit.do" method="post" onsubmit="disableSubmit(this)">
          <input type="hidden" name="shopCd" value="${ContractNormalUpdateView.shopCd}" />
          <input type="hidden" name="company" value="${ContractNormalUpdateView.company}" />
          <input type="hidden" name="bumon" value="${ContractNormalUpdateView.bumon}" />
          <input type="hidden" name="password" value="${ContractNormalUpdateView.password}" />
          <input type="hidden" name="updDt" value="${ContractNormalUpdateView.updDt}" />
          <input type="hidden" name="keiyakuName" value="${ContractNormalUpdateView.keiyakuName}" />
          <input type="hidden" name="keiyakuComment" value="${ContractNormalUpdateView.keiyakuComment}" />
          <input type="hidden" name="keiyakuCd" value="${ContractNormalUpdateView.keiyakuCd}" />
          <input type="hidden" name="keiyakuSubCd" value="${ContractNormalUpdateView.keiyakuSubCd}" />
          <input type="hidden" name="keiyakuFlag" value="${ContractNormalUpdateView.keiyakuFlag}" />
          <input type="hidden" name="shopKanriUpdDt" value="${ContractNormalUpdateView.shopKanriUpdDt}">
          <input type="submit" value="更新" name="commit">
          <input type="button" value="戻る" onClick="_submit('ContractNormalUpdatePageBack.do')">
        </html:form>
      </p>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>