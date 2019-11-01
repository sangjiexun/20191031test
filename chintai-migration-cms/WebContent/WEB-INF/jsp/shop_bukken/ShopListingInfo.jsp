<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="view"  value="${ShopListingInfoView}" />
<c:set var="mstShopKeiyakuKanri" value="${masterService.selectMstShopKeiyakuKanriByPrimaryKey(view.keiyakuCd, view.keiyakuSubCd)}"/>
<c:set var="keiyakuName" value=""/>
<c:if test="${mstShopKeiyakuKanri != null}">
	<c:set var="keiyakuName" value="${mstShopKeiyakuKanri.keiyakuName}"/>
</c:if>
<c:set var="title" value="${keiyakuName}詳細" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--
	//addEvent('load', window, function(){document.getElementsByName('')[0].focus();});
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
        ${keiyakuName}詳細
    </div>
    <h1>${keiyakuName}詳細</h1>
    <c:if test="${view.keiyakuCd == '00005' && view.keiyakuSubCd == '000'}">
		<p align="right">
		<a href ="<c:url value="AspShopInfo.do"><c:param name="shopCd" value="${view.shopCd}"/><c:param name="keiyakuCd" value="${view.keiyakuCd}"/><c:param name="keiyakuSubCd" value="${view.keiyakuSubCd}"/></c:url>">
		&gt;&gt; 不動産ASP設定情報を閲覧する
		</a>
		</p>
	</c:if>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">店舗コード（変更不可）</p>
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
    <c:set var="linkFlg"  value="" />
    <c:forEach items="${view.lstShopListingDetail}" var="detailLink">
      <c:if test="${not empty detailLink.delFlg}">
        <c:set var="linkFlg"  value="1" />
      </c:if>
    </c:forEach>

    <!--${keiyakuName}設定情報-->
    <p class="section_header">${keiyakuName}</p>
    <html:form action="/shop_bukken/ContractDeleteConfirm.do">
    <p>&gt;&gt;<a href="ContractAddPage.do?shopCd=${view.shopCd}&keiyakuCd=${view.keiyakuCd}&keiyakuSubCd=${view.keiyakuSubCd}">新しい契約情報を登録する</a></p>
    <div class="add_form">
        <div class="form_space"><div class="annotation">※現在適用されている契約情報は黄色で表示されます。</div>
    </div>
    <p></p>
      <table class="type_list_pre">
        <colgroup>
          <c:if test="${view.isWakuDisp == 'true'}">
	          <col width="30%">
	          <col width="15%">
	          <col width="25%">
	          <col width="10%">
	          <col width="10%">
	          <col width="10%">
          </c:if>
          <c:if test="${view.isWakuDisp == 'false'}">
	          <col width="30%">
	          <col width="30%">
	          <col width="20%">
	          <col width="10%">
	          <col width="10%">
          </c:if>
        </colgroup>
        <tr>
          <th>契約期間</th>
          <c:if test="${view.isWakuDisp == 'true'}"><th>${keiyakuName}</th></c:if>
          <th>備考</th>
          <th>更新日</th>
          <th>削除</th>
          <th>予約元</th>
        </tr>
        <c:forEach items="${view.lstShopListingDetail}" var="detail">
          <tr bgcolor="${detail.appliedFlg}">
            <td>
              <c:choose>
                <c:when test="${not empty detail.linkFlg}">
                  <a href="ContractUpdatePage.do?keiyakuNo=${detail.keiyakuNo}">${detail.keiyakuStartYmForDisplay}～
                  <c:if test="${detail.keiyakuEndDt != '99999999999999' && detail.keiyakuEndDt != '99991231235959'}" >
                    <c:out value="${detail.keiyakuEndYmForDisplay}"/>
                  </c:if>
                  </a>
                </c:when>
                <c:otherwise>
                  <c:out value="${detail.keiyakuStartYmForDisplay}"/>～
                  <c:if test="${detail.keiyakuEndDt != '99999999999999' && detail.keiyakuEndDt != '99991231235959'}" >
                    <c:out value="${detail.keiyakuEndYmForDisplay}"/>
                  </c:if>
                </c:otherwise>
              </c:choose>
            </td>
            <c:if test="${view.isWakuDisp == 'true'}"><td class="right"><c:out value="${detail.wakuCnt}" />件</td></c:if>
            <td align="left">
              <c:out value="${detail.keiyakuNote}" />
            </td>
            <td>
              <c:out value="${detail.updDt}"/>
            </td>
            <td>
            <c:choose>
              <c:when test="${not empty detail.delFlg}">
                <c:choose>
                  <c:when test="${not empty detail.checkFlg}">
                    <input type="checkbox" name="delFlgList" value="${detail.keiyakuNo}" checked="checked" />
                  </c:when>
                  <c:otherwise>
                    <input type="checkbox" name="delFlgList" value="${detail.keiyakuNo}" />
                  </c:otherwise>
                </c:choose>
              </c:when>
              <c:otherwise>
                -
              </c:otherwise>
            </c:choose>
            </td>
            <td>
              <chintai:CodePrint nameKey="RESERVE_KBN_NAME" valueKey="RESERVE_KBN_VALUE" code="${detail.reserveKbn}"/>
            </td>
          </tr>
        </c:forEach>
        <c:if test="${empty view.lstShopListingDetail}">
          <tr>
          <c:if test="${view.isWakuDisp == 'true'}"><td colspan="6" class="center">契約情報が登録されていません。</td></c:if>
          <c:if test="${view.isWakuDisp == 'false'}"><td colspan="5" class="center">契約情報が登録されていません。</td></c:if>
          </tr>
        </c:if>
      </table>
      <div class="add_from">
        <input type="hidden" name="keiyakuCd"   value="${view.keiyakuCd}">
        <input type="hidden" name="shopCd"   value="${view.shopCd}">
        <input type="hidden" name="keiyakuSubCd"   value="${view.keiyakuSubCd}">
        <c:if test="${not empty view.lstShopListingDetail}">
          <p align="right"><input type="submit" value="チェックした契約情報を削除"></p>
        </c:if>
      </div>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
