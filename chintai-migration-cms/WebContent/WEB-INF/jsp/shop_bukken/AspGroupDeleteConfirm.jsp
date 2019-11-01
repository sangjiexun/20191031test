<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="グループから外す"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<script type="text/javascript">

 addEvent('load', window, function(){document.getElementsByName('commit')[0].focus();});

</script>
<c:set value="${AspGroupDeleteInfoView.deleteGroupList[0]}" var="shop"/>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <a href ="<c:url value="ShopInfo.do"><c:param name="shopCd" value="${shop.shopCd}"/></c:url>">
        店舗・契約詳細
      </a> &gt;
      <a href ="<c:url value="AspShopInfo.do"><c:param name="shopCd" value="${shop.shopCd}"/></c:url>">
      不動産ASP設定情報</a> &gt;
        ${title}
    </div>
    <h1>${title}</h1>

    <p class="section_header">グループ解除の確認</p>
    <p>
      以下の店舗をグループから外します。
    </p>
      <c:if test="${not empty AspGroupDeleteInfoView.deleteGroupList}">
      <html:form action="/shop_bukken/AspGroupDeleteCommit" method="post" onsubmit="disableSubmit(this);">
          <table class="type_list">
            <tr>
              <th>店舗コード</th>
              <th>会社名<br>事務所名</th>
              <th>店舗状態</th>
              <th>不動産ASP状態</th>
            </tr>
            <c:forEach items="${AspGroupDeleteInfoView.deleteGroupList}" var="view">
            <tr>
              <td><c:out value="${view.groupshopCd}" /></td>
              <input type="hidden" name="groupshopCd" value="${view.groupshopCd}">
              <input type="hidden" name="shopCd" value="${view.shopCd}">
              <input type="hidden" name="aspShopSeq" value="${view.aspShopSeq}">
              <input type="hidden" name="shopKanriUpdDt" value="${view.shopKanriUpdDt}">
              <td><c:out value="${view.company}" /><br><c:out value="${view.bumon}"/></td>
              <td>
               <c:if test="${view.shopStatus == '0'}"><font color="#FF3333"></c:if>
                 <chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_STATUS_NAME" valueKey="SHOPBUKKEN_SHOP_STATUS_VALUE" code="${view.shopStatus}"/>
               <c:if test="${view.shopStatus == '0'}"></font></c:if>
               </span>
             </td>
             <td>
               <c:if test="${view.aspFlg == '1'}"><font color="#FF3333"></c:if>
                 <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_SHOP_STATUS_NAME" valueKey="SHOPBUKKEN_ASP_SHOP_STATUS_VALUE" code="${view.aspFlg}"/>
               <c:if test="${view.aspFlg == '1'}"></font></c:if>
             </td>
            </tr>
            </c:forEach>
          </table>
      <p>
        <input type="submit" value="グループから外す" name="commit">
        <input type="button" name="back" value="戻る" onClick="_submit('AspShopInfo.do?shopCd=${shop.shopCd}&delFlg=${view.delFlg}')">
        <input type="hidden" name="shopKanriUpdDt" value="${view.shopKanriUpdDt}">
      </p>
    </html:form>
    </c:if>

  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
