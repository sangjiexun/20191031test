<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="出稿情報（仮保存）編集確認" />
<c:set var="view" value="${MediaInfoUpdateView}" />
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

    <html:form action="/shop_listing/MediaInfoUpdateComplete">
    <!-- 店舗コード -->
    <p class="section_header"><a name="1">店舗コード</a></p>
<%@ include file="parts/ShopBasicInfo.jsp" %>

    <!-- 出稿情報 -->
    <p class="section_header">出稿情報</p>
    <form action="KeiyakuShopinfo.vm" method="post">
      <table class="type_detail">
        <colgroup>
          <col width="9%">
          <col width="11%">
          <col width="80%">
        </colgroup>
        <tr>
          <th colspan="2" class="text-left">出稿対象駅指定</th>
          <td>
<c:forEach items="${view.selectEkiName}" var="ekiName" begin="0" varStatus="i">
  <c:if test="${i.index ne 0}">/</c:if>
            <c:out value="${ekiName}" />
</c:forEach>
          </td>
        </tr>
        <tr>
          <th colspan="2" class="text-left">出稿対象市区町村指定</th>
          <td>
<c:forEach items="${view.selectCityName}" var="cityName" begin="0" varStatus="i">
  <c:if test="${i.index ne 0}">/</c:if>
             <c:out value="${cityName}" />
</c:forEach>
          </td>
        </tr>
        <tr>
           <th colspan="2" class="text-left">キャッチフレーズ</th>
           <td><chintai:filter changeNL2BR="true"><c:out value="${view.catchPhrase}" /></chintai:filter></td>
        </tr>
        <tr>
          <th colspan="2" class="text-left">アピールコメント</th>
          <td><chintai:filter changeNL2BR="true"><c:out value="${view.appealComment}" /></chintai:filter></td>
        </tr>
        <tr>
          <th rowspan="4" class="text-left">店舗画像</th>
          <th class="text-left">画像</th>
          <td>
<c:choose>
  <c:when test="${view.picFlg eq 0}">
          表示しない
  </c:when>
  <c:when test="${view.picFlg eq 1 and not empty view.shopImgLeft}">
           <img src="${view.shopImgLeft}" id="img" onload="setImageInfo('img', 'picSize','fileSize','rate');" />
  </c:when>
  <c:when test="${view.picFlg eq 2 and not empty view.shopImgRight}">
           <img src="${view.shopImgRight}" id="img" onload="setImageInfo('img', 'picSize','fileSize','rate');" />
  </c:when>
  <c:otherwise>
          「画像が登録されていません。」
  </c:otherwise>
</c:choose>
          </td>
        </tr>
        <tr>
          <th nowrap="nowrap" class="text-left">大きさ(横×縦)</th>
              <td id="picSize"></td>
        </tr>
        <tr>
          <th class="text-left">サイズ</th>
              <td id="fileSize"></td>
        </tr>
        <tr>
          <th class="text-left">比率(横：縦)</th>
          <td>
              <label id="rate"></label>&nbsp;
          </td>
        </tr>
        <tr>
        <th colspan="2" class="text-left">アピールアイコン選択</th>
        <td>
<c:forEach items="${view.appealIconInfos}" var="appeal">
          <img alt="${appeal.iconName}" src="${appeal.iconImgPath}" />
          <input type="hidden" name="chkAppeal" value="${appeal.iconId}" />
</c:forEach>
        </td>
        </tr>
        <tr>
        <th colspan="2" nowrap="nowrap" class="text-left">リスティングアイコン選択</th>
          <td>
<c:forEach items="${view.listingIconInfos}" var="listing">
            <img alt="${listing.iconName}" src="${listing.iconImgPath}" />
            <input type="hidden" name="chkListing" value="${listing.iconId}" />
</c:forEach>
          </td>
        </tr>
        <tr>
          <th rowspan="3" align="center">注釈</th>
          <th class="text-left">①</th>
          <td><c:out value="${view.couponComment1}" /></td>
        </tr>
        <tr>
          <th class="text-left">②</th>
          <td><c:out value="${view.couponComment2}" /></td>
        </tr>
        <tr>
          <th class="text-left">③</th>
          <td><c:out value="${view.couponComment3}" /></td>
        </tr>
        <tr>
          <th colspan="2" class="text-left">備考</th>
          <td><chintai:filter changeNL2BR="true"><c:out value="${view.note}" /></chintai:filter></td>
        </tr>
      </table>

      <span class="caution">*WEBへ反映する場合は、契約店舗詳細画面より、本番反映処理を行ってください。</span>
      <p>
        <input type="hidden" name="shopCd"            value="${view.shopCd}" />
        <input type="hidden" name="areaCd"            value="${view.areaCd}" />
        <input type="hidden" name="ensenTypeCd"       value="${view.ensenTypeCd}" />
        <input type="hidden" name="ensenCd"           value="${view.ensenCd}" />
        <input type="hidden" name="ekiCd"             value="${view.ekiCd}" />
        <input type="hidden" name="selectEki"         value="${view.selectEki}" />
        <input type="hidden" name="selectEkiValue"    value="${view.selectEkiValue}" />
        <input type="hidden" name="cityAreaCd"        value="${view.cityAreaCd}" />
        <input type="hidden" name="prefCd"            value="${view.prefCd}" />
        <input type="hidden" name="cityCd"            value="${view.cityCd}" />
        <input type="hidden" name="selectCity"        value="${view.selectCity}" />
        <input type="hidden" name="selectCityValue"   value="${view.selectCityValue}" />
        <input type="hidden" name="catchPhrase"       value="${fn:escapeXml(view.catchPhrase)}" />
        <input type="hidden" name="appealComment"     value="${fn:escapeXml(view.appealComment)}" />
        <input type="hidden" name="shopImgRight"      value="${view.shopImgRight}" />
        <input type="hidden" name="shopImgLeft"       value="${view.shopImgLeft}" />
        <input type="hidden" name="clientSystemType"  value="${view.clientSystemType}"/>
        <input type="hidden" name="picFlg"            value="${view.picFlg}" />
        <input type="hidden" name="couponComment1"    value="${view.couponComment1}" />
        <input type="hidden" name="couponComment2"    value="${view.couponComment2}" />
        <input type="hidden" name="couponComment3"    value="${view.couponComment3}" />
        <input type="hidden" name="note"              value="${fn:escapeXml(view.note)}" />
        <input type="hidden" name="updDt"             value="${view.updDt}" />
        <input type="submit" value="更新">
        <input type="button" name="back" value="戻る" onclick="_submit('MediaInfoUpdatePageBack.do')">
      </p>
    </html:form>

  </div><!-- popup_layout END -->
</div><!-- main END -->

<%@ include file="../parts/ContentsFooter.jsp" %>