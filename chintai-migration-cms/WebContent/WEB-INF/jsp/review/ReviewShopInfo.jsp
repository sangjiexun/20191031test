<%@page import="net.chintai.backend.sysadmin.common.properties.ServerProperties"%>
<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<%@ include file="../parts/ContentsImport.jsp"%>
<c:set var="title" value="店舗詳細" />
<c:set var="view" value="${ReviewShopInfoView}"></c:set>
<c:set var="isReviewFlg" value="true" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp"%>
<%@ include file="../parts/PopUpContentsHeadline.jsp"%>

<!-- メイン -->
<div id="main">
<div class="popup_layout">
<div class="topic_path">${title}</div>
<h1>${title}</h1>
<html:errors />
<html:messages id ="msg" message="true" header="info.header" footer="info.footer">
  <c:out value="${msg}"/>
</html:messages>
<!-- ショートカット -->
<p>
  <a href="#1">[店舗コード]</a>
  <a href="#2">[Web審査状況]</a>
  <a href="#3">[基本情報]</a>
  <a href="#4">[登録状況]</a>
  <a href="#5">[契約状況]</a>
  <a href="#6">[付加情報]</a>
  <a href="#7">[店舗画像]</a>
  <a href="#8">[スタッフ紹介]</a>
  <a href="#9">[キャンペーン]</a>
</p>

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
      <c:if test="${not empty view.bumon}"> / </c:if>
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

<!-- Web審査状況 -->
<p class="section_header"><a name="2">Web審査状況</a></p>
<p><html:link action="/review/ReviewShopStatusUpdatePage" paramId="shopCd" paramName="view" paramProperty="shopCd">
        &gt;&gt;店舗対象外設定を変更する
      </html:link></p>
<table class="type_detail">
  <colgroup>
    <col span="1" width="22%">
    <col span="1" width="78%">
  </colgroup>
  <tr>
    <th class="text-left">店舗対象外設定</th>
    <td><!-- inline table -->
    <table class="type_none">
      <tr>
        <th class="text-left">初回審査</th>
        <td><chintai:CodePrint code="${view.syokaiShinsa}"  nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/></td>
      </tr>
      <tr>
        <th class="text-left">定期審査</th>
        <td><chintai:CodePrint code="${view.teikiShinsa}"  nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/></td>
      </tr>
      <tr>
        <th class="text-left">メール送信</th>
        <td><chintai:CodePrint code="${view.mailSend}"  nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/></td>
      </tr>
      <tr>
        <th class="text-left">自動削除</th>
        <td><chintai:CodePrint code="${view.autoDelete}"  nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/></td>
      </tr>
    </table>
    <hr>
    <table class="type_none">
      <tr>
        <th class="text-left">備 考</th>
        <td><chintai:filter changeNL2BR="true"><c:out value="${view.bikou}" /></chintai:filter></td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <th class="text-left">有効物件数</th>
    <td><c:out value="${view.shinsaBukkenCnt}" /></td>
  </tr>
  <tr>
    <th class="text-left">初回審査返信持ち物件数</th>
    <td><c:out value="${view.syokaiCnt}" /></td>
  </tr>
  <tr>
    <th class="text-left">定期審査返信持ち物件数</th>
    <td><c:out value="${view.teikiCnt}" /></td>
  </tr>
  <tr>
    <th class="text-left">返信待ち率</th>
    <td><c:out value="${view.returnRate}" />%</td>
  </tr>
</table>

<!-- 2009/06 基本情報パーツ化 李昊燮-->
<p class="section_header"><a name="3">基本情報 (変更不可)</a></p>
<%@ include file="../shop_bukken/parts/ShopBasicInfoDetailPart.jsp" %>

<!-- 登録状況 -->
<p class="section_header"><a name="4">登録状況 (変更不可)</a></p>
<%@ include file="../shop_bukken/parts/ShopRegistStatus.jsp" %>

<!-- 契約状況 -->
<p class="section_header"><a name="5">契約状況 (変更不可)</a></p>
<%@ include file="../shop_bukken/parts/ShopKeiyakuDetail.jsp" %>

<!-- 付加情報 -->
<p class="section_header"><a name="6">付加情報 (変更不可)</a></p>
<%@ include file="../shop_bukken/parts/ShopAppendInfo.jsp" %>

<!-- 店舗画像 -->
<p class="section_header"><a name="7">店舗画像 (変更不可)</a></p>
<%@ include file="../shop_bukken/parts/ShopImage.jsp" %>

<!-- スタッフ紹介 -->
<p class="section_header"><a name="8">スタッフ紹介 (変更不可)</a></p>
<%@ include file="../shop_bukken/parts/ShopStaff.jsp" %>

<!-- キャンペーン -->
<p class="section_header"><a name="9">キャンペーン (変更不可)</a></p>
<%@ include file="../shop_bukken/parts/ShopCampaign.jsp" %>


<%@ include file="../parts/ContentsFooter.jsp"%>
