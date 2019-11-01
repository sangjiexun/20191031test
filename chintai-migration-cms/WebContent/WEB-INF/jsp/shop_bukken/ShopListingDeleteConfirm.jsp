<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="view"  value="${ShopListingDeleteView}" />
<c:set var="mstShopKeiyakuKanri" value="${masterService.selectMstShopKeiyakuKanriByPrimaryKey(view.keiyakuCd, view.keiyakuSubCd)}"/>
<c:set var="keiyakuName" value=""/>
<c:if test="${mstShopKeiyakuKanri != null}">
	<c:set var="keiyakuName" value="${mstShopKeiyakuKanri.keiyakuName}"/>
</c:if>
<c:set var="delFlgList" value=""/>
<c:set var="title" value="${keiyakuName}削除確認" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--
 addEvent('load', window, function(){document.getElementsByName('backButton')[0].focus();});
-->
</script>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_bukken/ShopInfo.do">
      <html:param name="shopCd" value="${view.shopCd}" />
        店舗・契約詳細
      </html:link> &gt;
      <html:link action="/shop_bukken/ContractInfo.do">
        <html:param name="shopCd" value="${view.shopCd}" />
        <html:param name="keiyakuCd" value="${view.keiyakuCd}" />
        <html:param name="keiyakuSubCd" value="${view.keiyakuSubCd}" />
       ${keiyakuName}詳細
      </html:link> &gt;
      ${keiyakuName}削除確認
    </div>
    <h1>${keiyakuName}削除確認</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">店舗コード</p>
    <table class="type_detail_pre">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>店舗名</th>
        <td>
          <c:out value="${view.company}" />
          <c:if test="${not empty view.company and not empty view.bumon}"> / </c:if>
          <c:out value="${view.bumon}" />
        </td>
     </tr>
      <tr>
        <th>店舗コード</th>
        <td> <c:out value="${view.shopCd}" /></td>
      </tr>
      <tr>
        <th>お客様設定パスワード</th>
        <td>
          <c:out value="${view.password}" />
        </td>
      </tr>
    </table>

    <!--物件枠設定情報-->
    <p class="section_header">${keiyakuName}（削除）</p>
    <html:form action="/shop_bukken/ContractDeleteCommit.do" onsubmit="disableSubmit(this);">
      <table class="type_list_pre">
        <colgroup>
        	<c:if test="${view.isWakuDisp == 'true'}">
	          <col width="30%">
	          <col width="10%">
	          <col width="40%">
	          <col width="10%">
	          <col width="10%">
          	</c:if>
          	<c:if test="${view.isWakuDisp == 'false'}">
          	  <col width="30%">
	          <col width="40%">
	          <col width="20%">
	          <col width="10%">
          	</c:if>
        </colgroup>
        <tr>
          <th>契約期間</th>
          <c:if test="${view.isWakuDisp == 'true'}"><th>${keiyakuName}</th></c:if>
          <th>備考</th>
          <th>更新日</th>
          <th>予約元</th>
        </tr>
        <c:forEach items="${view.detailList}" var="detail">
          <tr>
            <td>
              <c:out value="${detail.keiyakuStartYmForDisplay}"/>～
              <c:if test="${detail.keiyakuEndDt != '99999999999999' && detail.keiyakuEndDt != '99991231235959'}" >
                <c:out value="${detail.keiyakuEndYmForDisplay}"/>
              </c:if>
            </td>
            <c:if test="${view.isWakuDisp == 'true'}"><td class="right"><c:out value="${detail.wakuCnt}" />件</td></c:if>
            <td align="left"><c:out value="${detail.keiyakuNote}" /></td>
            <td><c:out value="${detail.updDt}" />
            <input type="hidden" name="delFlgList" value="${detail.keiyakuNo}" />
            </td>
			<td>
              <chintai:CodePrint nameKey="RESERVE_KBN_NAME" valueKey="RESERVE_KBN_VALUE" code="${detail.reserveKbn}"/>
            </td>
          </tr>
          <c:set var="delFlgList" value="${delFlgList}&delFlgList=${detail.keiyakuNo}"/>
        </c:forEach>
      </table>
      <div class="add_from">
        <input type="hidden" name="keiyakuCd"      value="${view.keiyakuCd}">
        <input type="hidden" name="shopCd"         value="${view.shopCd}">
        <input type="hidden" name="keiyakuSubCd"   value="${view.keiyakuSubCd}">
        <input type="hidden" name="keiyakuName"   value="${view.keiyakuName}">
        <input type="hidden" name="shopKanriUpdDt" value="${view.shopKanriUpdDt}">
        <input type="submit" value="削除" >
        <input type="button" name="backButton" value="戻る" onclick="_submit('ContractInfo.do?shopCd=${view.shopCd}&keiyakuCd=${view.keiyakuCd}&keiyakuSubCd=${view.keiyakuSubCd}${delFlgList}');">
      </div>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>