<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="出稿情報本番反映確認" />
<c:set var="view" value="${MediaInfoWebRegisterView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_listing/KeiyakuShopInfo" paramId="shopCd" paramName="view" paramProperty="shopCd">
        契約店舗詳細
      </html:link>
      &gt;&nbsp;${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="msg"/>
    </html:messages>

    <!-- 店舗コード -->
    <p class="section_header"><a name="1">店舗コード</a></p>
<%@ include file="parts/ShopBasicInfo.jsp" %>

<p><span class="caution">以下の出稿情報（仮保存）を本番へ反映します。</span></p>
<div class="add_form"><div class="annotation">反映後、出稿情報（仮保存）は削除となります。</div>

  <html:form action="/shop_listing/MediaInfoWebRegisterComplete.do">
    <!-- 出稿情報 -->
    <p class="section_header">出稿情報（仮保存）</p>
    <table class="type_detail">
      <colgroup>
        <col width="11%">
        <col width="11%">
        <col width="77%">
      </colgroup>
      <tr>
        <th colspan="2">出稿対象駅指定</th>
          <td><c:out value="${view.eki}" /></td>
        </tr>
        <tr>
          <th colspan="2">出稿対象市区町村指定</th>
          <td><c:out value="${view.city}" /></td>
        </tr>
        <tr>
          <th colspan="2">キャッチフレーズ</th>
          <td><chintai:filter changeNL2BR="true"><c:out value="${view.catchPhrase}" /></chintai:filter></td>
        </tr>
        <tr>
          <th colspan="2">アピールコメント</th>
          <td><chintai:filter changeNL2BR="true"><c:out value="${view.appealComment}" /></chintai:filter></td>
        </tr>
        <tr>
          <th rowspan="4">店舗画像</th>
          <th>画像</th>
          <td>
<c:choose>
  <c:when test="${empty view.imgUrl}">
          画像が登録されていません
  </c:when>
  <c:when test="${'0' eq view.imgUrl}">
          画像が選択されていません
  </c:when>
  <c:when test="${'-1' eq view.imgUrl}">
          選択された画像区分が不正です
  </c:when>
  <c:otherwise>
          <img src="${view.imgUrl}" id="img1" onload="setImageInfo('img1', 'picSize1','fileSize1','rate1');" >
  </c:otherwise>
</c:choose>
          </td>
        </tr>
        <tr>
          <th nowrap="nowrap">大きさ(横×縦)</th>
          <td id="picSize1"></td>
        </tr>
        <tr>
          <th>サイズ</th>
          <td id="fileSize1"></td>
        </tr>
        <tr>
          <th>比率(横：縦)</th>
          <td>
              <label id="rate1"></label>&nbsp;
          </td>
        </tr>
        <tr>
         <th colspan="2">アピールアイコン選択</th>
         <td>
<c:forEach items="${view.appealIcon}" var="appealIconInfo">
           <img src="${appealIconInfo.iconImgPath}" alt="${appealIconInfo.iconName}" title="${appealIconInfo.iconName}">&nbsp;
</c:forEach>
           </td>
         </tr>
         <tr>
           <th colspan="2" nowrap="nowrap">リスティングアイコン選択</th>
           <td>
<c:forEach items="${view.listingIcon}" var="listingInfo">
           <img src="${listingInfo.iconImgPath}" alt="${listingInfo.iconName}" title="${listingInfo.iconName}">&nbsp;
</c:forEach>
           </td>
         </tr>
         <tr>
           <th rowspan="3" align="center">注釈</th>
           <th>①</th>
           <td><c:out value="${view.couponComment1}" /></td>
         </tr>
         <tr>
           <th>②</th>
           <td><c:out value="${view.couponComment2}" /></td>
         </tr>
         <tr>
           <th>③</th>
           <td><c:out value="${view.couponComment3}" /></td>
         </tr>
         <tr>
           <th colspan="2">備考</th>
           <td><chintai:filter changeNL2BR="true"><c:out value="${view.note}" /></chintai:filter></td>
         </tr>
    </table>

    <p>
        <input type="hidden" name="shopCd" value="${view.shopCd}" >
        <input type="hidden" name="updDt"  value="${view.updDt}" >
        <input type="submit" value="反映" >
        <input type="button" name="back" value="戻る" onClick="_submit('KeiyakuShopInfo.do')">
    </p>
    </html:form>

  </div><!-- popup_layout END -->
</div><!-- main END -->

<%@ include file="../parts/ContentsFooter.jsp" %>