<%@page import="net.chintai.backend.sysadmin.common.properties.ServerProperties"%>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗・契約詳細" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<%@ include file="../parts/PopUpContentsHeadline.jsp"%>
<c:set var="view" value="${ShopDetailInfoSearchView}" />
<div id="main">
  <div class="popup_layout">
    <div class="topic_path">
      ${title}
    </div>
    <h1>${title}</h1>
    <!-- ショートカット -->
		<p>
			<a href="#1">[店舗コード]</a>
			<a href="#2">[基本情報]</a>
			<a href="#3">[登録状況]</a>
			<a href="#4">[契約状況]</a>
			<a href="#5">[付加情報]</a>
			<a href="#6">[店舗画像]</a>
			<a href="#7">[スタッフ紹介]</a>
			<a href="#8">[キャンペーン]</a>
		</p>
    <html:messages id ="errmsg" header="errors.header" footer="errors.footer">
      <c:out value="${errmsg}"></c:out>
    </html:messages>
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"></c:out><br>
    </html:messages>
    <!-- 店舗コード -->
    <p class="section_header"><a name="1">店舗コード (変更不可)</a></p>

    <table class="type_detail">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th class="text-left">店舗名</th>
      <td>
        <c:out value="${view.company}" />
        <c:if test="${not empty view.company and not empty view.bumon}"> / </c:if>
        <c:out value="${view.bumon}" />
      </td>
      </tr>
      <tr>
        <th class="text-left">店舗コード</th>
        <td><c:out value="${view.shopCd}" /></td>
      </tr>
      <tr>
        <th class="text-left">お客様設定パスワード</th>
        <td><c:out value="${crnwl:decypt(view.shopRireki.passwordEnc)}" /></td>
      </tr>
    </table>

	<c:if test="${view.shopRireki.certifyFlg == '0' }">
      <p>
        <c:forEach items="${view.vShopKeiyakuDetails }" var="vShopKeiyakuDetail">
          <c:if test="${vShopKeiyakuDetail.keiyakuCd=='00001' && vShopKeiyakuDetail.keiyakuSubCd=='000'}">
            <c:choose>
              <c:when test="${vShopKeiyakuDetail.keiyakuFlg=='1' && not empty view.shopRireki.rendoCd && not empty view.shopRireki.ctShisyaCd && not empty view.shopRireki.noticeEmail}">
              </c:when>
              <c:otherwise>
                  <p style="font-weight:bold; font-size:120%; color:red;">※契約情報を登録してください。</p>
              </c:otherwise>
            </c:choose>
          </c:if>
        </c:forEach>
      </p>
    </c:if>

    <!-- 基本情報 -->
    <p class="section_header"><a name="2">基本情報(一部変更不可)</a></p>
    <p>
      <a href ="<c:url value="ShopBasicInfoUpdate.admin"><c:param name="shopcd" value="${view.shopCd}"/></c:url>">
        &gt;&gt; 基本情報を更新する
      </a>
    </p>
    <!-- 2009/06 基本情報パーツ化 李昊燮-->
    <%@ include file="parts/ShopBasicInfoDetailPart.jsp" %>

    <!-- 登録状況 -->
    <p class="section_header"><a name="3">登録状況</a></p>

    <c:if test="${view.shopRireki.certifyFlg == '0' }">
      <p>
        <c:forEach items="${view.vShopKeiyakuDetails }" var="vShopKeiyakuDetail">
          <c:if test="${vShopKeiyakuDetail.keiyakuCd=='00001' && vShopKeiyakuDetail.keiyakuSubCd=='000'}">
            <c:choose>
              <c:when test="${vShopKeiyakuDetail.keiyakuFlg=='1' && not empty view.shopRireki.rendoCd && not empty view.shopRireki.ctShisyaCd && not empty view.shopRireki.noticeEmail}">
                <c:choose>
                  <c:when test="${view.certifyChkFlg=='1'}">
					<c:choose>
					  <c:when test="${shopService.isDispRegistrationStatusUpdateLink(view.shopCd)}">
					    <a href ="<c:url value="ShopApprovalUpdate.admin"><c:param name="shopcd" value="${view.shopCd}"/></c:url>">
		                  &gt;&gt; 登録状況を更新する
		                </a>
					  </c:when>
					  <c:otherwise>
					    &gt;&gt; 登録状況を更新する  （承認には、連動元、CHINTAI支社、通知先、物件枠の設定が必要です。）
					  </c:otherwise>
					</c:choose>
                  </c:when>
                  <c:otherwise>
                    <a href ="<c:url value="ShopApprovalUpdate.admin"><c:param name="shopcd" value="${view.shopCd}"/></c:url>">
	                  &gt;&gt; 登録状況を更新する
	                </a>
                  </c:otherwise>
                </c:choose>
              </c:when>
              <c:otherwise>
                  &gt;&gt; 登録状況を更新する  （承認には、連動元、CHINTAI支社、通知先、物件枠の設定が必要です。）
              </c:otherwise>
            </c:choose>
          </c:if>
        </c:forEach>
      </p>
    </c:if>

    <%@ include file="../shop_bukken/parts/ShopRegistStatus.jsp" %>
	<!-- 契約状況 -->
    <p class="section_header"><a name="4">契約状況</a></p>
    <p>
      <a href ="<c:url value="ShopRegistrationStatusUpdatePage.do"><c:param name="shopCd" value="${view.shopCd}"/></c:url>">
        &gt;&gt; 契約状況を更新する
      </a>
    </p>
	<%@ include file="../shop_bukken/parts/ShopKeiyakuDetail.jsp" %>

	<!-- 付加情報 -->
    <p class="section_header"><a name="5">付加情報</a></p>
    <p>
      <a href ="<c:url value="ShopAppendInfoUpdate.admin"><c:param name="shopcd" value="${view.shopCd}"/></c:url>">
        &gt;&gt; 付加情報を更新する
      </a>
    </p>
	<%@ include file="../shop_bukken/parts/ShopAppendInfo.jsp" %>


    <!-- 店舗画像 -->
    <p class="section_header"><a name="6">店舗画像</a></p>
    <p>
      <a href="<c:url value="ShopImageUpdate.admin"><c:param name="shopcd" value="${view.shopCd}"/></c:url>">
        &gt;&gt; 店舗画像を更新する
      </a>
    </p>
    	<%@ include file="../shop_bukken/parts/ShopImage.jsp" %>

		<p class="section_header"><a name="7">スタッフ紹介</a></p>
	    <p>
	      <a href="<c:url value="ShopImageStaffUpdate.admin"><c:param name="shopcd" value="${view.shopCd}"/></c:url>">
	        &gt;&gt; スタッフ紹介を更新する
	      </a>
	    </p>
		<%@ include file="../shop_bukken/parts/ShopStaff.jsp" %>

		<p class="section_header"><a name="8">キャンペーン</a></p>
	    <p>
	      <a href="<c:url value="ShopImageCampaignUpdate.admin"><c:param name="shopcd" value="${view.shopCd}"/></c:url>">
	        &gt;&gt; キャンペーンを更新する
	      </a>
	    </p>
		<%@ include file="../shop_bukken/parts/ShopCampaign.jsp" %>

<%--
		<!-- アプリケーション利用状況 -->
    <p class="section_header"><a name="4">アプリケーション利用状況</a></p>
    <p>
      <a href ="<c:url value="AspShopInfo.do"><c:param name="shopCd" value="${view.shopCd}"/></c:url>">
        &gt;&gt; 不動産ASP設定情報を閲覧する
      </a>
    </p>
    <p>
      <a href="<c:url value="AdparkUpdatePage.do"><c:param name="shopCd" value="${view.shopCd}"/></c:url>">
        &gt;&gt; アドパーク送信を更新する
      </a>
    </p>
    <p>
      <a href="<c:url value="WebLogUpdatePage.do"><c:param name="shopCd" value="${view.shopCd}"/></c:url>">
        &gt;&gt; Webログ利用可否を更新する
      </a>
    </p>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th class="text-left">Pickup不動産</th>
        <td>
          <chintai:CodePrint nameKey="SHOPBUKKEN_PICKUP_STATUS_FLG_NAME" valueKey="SHOPBUKKEN_PICKUP_STATUS_FLG_VALUE" code="${view.pickUpCnt}"/>
        </td>
      </tr>
      <tr>
        <th class="text-left">不動産ASP</th>
<c:choose>
    <c:when test="${view.aspCnt == '0'}">
        <td><font color="#FF3333"><chintai:CodePrint nameKey="SHOPBUKKEN_ASP_FLG_NAME" valueKey="SHOPBUKKEN_ASP_FLG_VALUE" code="${view.aspCnt}"/></font></td>
    </c:when>
    <c:otherwise>
        <td><chintai:CodePrint nameKey="SHOPBUKKEN_ASP_FLG_NAME" valueKey="SHOPBUKKEN_ASP_FLG_VALUE" code="${view.aspCnt}"/></td>
    </c:otherwise>
</c:choose>
      </tr>
      <tr>
        <th class="text-left">売買(アドパーク送信)</th>
        <td>
          <chintai:CodePrint nameKey="SHOPBUKKEN_ADPARK_SEND_FLG_NAME" valueKey="SHOPBUKKEN_ADPARK_SEND_FLG_VALUE" code="${view.adparkSendFlg}"/>
        </td>
      </tr>
      <tr>
        <th class="text-left">Webログ</th>
          <td>
            <chintai:CodePrint nameKey="WEB_LOG_FLG_NAME" valueKey="WEB_LOG_FLG_VALUE" code="${view.webLogFlg}"/>
          </td>
      </tr>

    </table>
 --%>

  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
