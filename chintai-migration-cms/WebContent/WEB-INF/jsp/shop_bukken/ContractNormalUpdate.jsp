<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="${ContractNormalUpdateView.keiyakuName}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

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
        <td>
          <c:out value="${ContractNormalUpdateView.shopCd}" />
        </td>
      </tr>
      <tr>
        <th>お客様設定パスワード</th>
        <td>
          <c:out value="${ContractNormalUpdateView.password}" />
        </td>
      </tr>
    </table>

    <!-- Contract Detail  -->
    <p class="section_header">${ContractNormalUpdateView.keiyakuName}</p>
    <html:form method="post" action="/shop_bukken/ContractNormalUpdateConfirm" onsubmit="disableSubmit(this)">
      <input type="hidden" name="shopCd" value="${ContractNormalUpdateView.shopCd}" />
      <input type="hidden" name="company" value="${ContractNormalUpdateView.company}" />
      <input type="hidden" name="bumon" value="${ContractNormalUpdateView.bumon}" />
      <input type="hidden" name="password" value="${ContractNormalUpdateView.password}" />
      <input type="hidden" name="updDt" value="${ContractNormalUpdateView.updDt}" />
      <input type="hidden" name="keiyakuName" value="${ContractNormalUpdateView.keiyakuName}" />
      <input type="hidden" name="keiyakuComment" value="${ContractNormalUpdateView.keiyakuComment}" />
      <input type="hidden" name="keiyakuCd" value="${ContractNormalUpdateView.keiyakuCd}" />
      <input type="hidden" name="keiyakuSubCd" value="${ContractNormalUpdateView.keiyakuSubCd}" />
      <input type="hidden" name="shopKanriUpdDt" value="${ContractNormalUpdateView.shopKanriUpdDt}">
      <div class="add_form">
        <div class="add_form_title">${ContractNormalUpdateView.keiyakuName}設定 <span class="caution">*</span></div>
        <div class="annotation">${ContractNormalUpdateView.keiyakuComment}</div>
        <div class="form_space">
        <c:choose>
          <c:when test="${ContractNormalUpdateView.keiyakuFlag == 0}">
           <label>
              <input type="radio" name="keiyakuFlag" value="1">契約済
            </label>
            <label>
              <input type="radio" name="keiyakuFlag" value="0" checked>未契約
            </label>
           </c:when>
          <c:otherwise>
             <label>
              <input type="radio" name="keiyakuFlag" value="1" checked>契約済
            </label>
            <label>
              <input type="radio" name="keiyakuFlag" value="0">未契約
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