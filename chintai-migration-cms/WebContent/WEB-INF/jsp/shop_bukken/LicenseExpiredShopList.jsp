<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="免許証有効期限切れ店舗一覧" />
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
    <p class="section_header">対象店舗一覧</p>
<c:choose>
<c:when test="${!empty LicenseExpiredShopView.shopList}">
    <p>${LicenseExpiredShopView.count}件のデータを表示しています。</p>
    <table class="type_list">
      <tr>
        <th>店舗コード</th>
        <th>会社名<br>事務所名<br>店舗メールアドレス</th>
        <th>代表者名<br>代表TEL<br>代表FAX</th>
        <th>承認<br>状態</th>
        <th>CHINTAI掲載<br>エイブル掲載<br>連動元</th>
        <th>免許証有効期限（終了）</th>
      </tr>
<c:forEach items="${LicenseExpiredShopView.shopList}" var="shopList" varStatus="i">
      <tr>
        <td>
          <a href ="<c:url value="ShopInfo.do"><c:param name="shopCd" value="${shopList.shopCd}"/></c:url>" target="_blank">
            <c:out value="${shopList.shopCd}"></c:out>
          </a>
        </td>
        <td class="left">
        ${shopList.company}<br>
        ${shopList.bumon}<br>
        <c:if test="${shopList.email != null}">
          <c:out value="${shopList.email}" />
        </c:if>
        </td>
        <td class="left">${shopList.licTrust}<br>${shopList.tel}<br>${shopList.fax}</td>
        <td>
          <chintai:CodePrint nameKey="CERTIFY_FLG_NAME" valueKey="CERTIFY_FLG_VALUE" code="${shopList.certifyFlg}"/><br>
          <chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_STATUS_NAME" valueKey="SHOPBUKKEN_SHOP_STATUS_VALUE" code="${shopList.shopStatus}"/>
        </td>
        <td>
          <chintai:CodePrint nameKey="SHOPBUKKEN_CT_FLG_NAME" valueKey="SHOPBUKKEN_CT_FLG_VALUE" code="${shopList.ctKeisaiFlg}"/><br>
          <chintai:CodePrint nameKey="SHOPBUKKEN_ABL_FLG_NAME" valueKey="SHOPBUKKEN_ABL_FLG_VALUE" code="${shopList.ablKeisaiFlg}"/><br>
          <c:out value="${shopList.rendoName}" />
        </td>
        <td class="right">${shopList.licValid}</td>
      </tr>
</c:forEach>
    </table>
</c:when>
<c:otherwise><p>対象店舗がありません。</p></c:otherwise>
</c:choose>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
