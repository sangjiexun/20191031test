<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="契約店舗詳細" />
<c:set var="view" value="${KeiyakuShopInfoView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <!-- ショートカット -->
    <p>
      <a href="#1">[店舗コード]</a>
      <a href="#2">[契約情報]</a>
      <a href="#3">[出稿情報]</a>
      <a href="#4">[クーポン情報]</a>
    </p>
    <!-- 店舗コード -->
    <p class="section_header"><a name="1">店舗コード (変更不可)</a></p>
<%@ include file="parts/ShopBasicInfo.jsp" %>

    <!-- 契約状況 -->
    <p class="section_header"><a name="2">契約情報</a></p>
<c:if test="${view.yukouKihonKeiyakuFlg eq '1'}">
    <p>
      <html:link action="shop_listing/KeiyakuRegisterPage.do" paramId="shopCd" paramName="view" paramProperty="shopCd">
        &gt;&gt;新しい契約情報を登録する
      </html:link>
    </p>
</c:if>

<c:if test="${not empty view.kihonKeiyakuInfoList}">
    <div class="add_form"><div class="annotation">※現在適用されている契約情報は黄色で表示されます。</div></div>
    <table class="type_list_pre">
      <colgroup>
        <col width="20%">
        <col width="20%">
        <col width="20%">
        <col width="39%" align="left"  style="word-break:break-all;word-wrap:break-word;">
      </colgroup>
      <tr>
        <th rowspan="2">基本契約</th>
        <th colspan="2">オプション契約</th>
        <th rowspan="2" align="center">備考</th>
      </tr>
      <tr>
        <th>クーポン発行</th>
        <th>外部リンク表示</th>
      </tr>
  <c:forEach items="${view.kihonKeiyakuInfoList}" var="keiyakuInfo" varStatus="statsu">
    <c:choose>
      <c:when test="${keiyakuInfo.keiyakuChuuFlg eq '1' and statsu.index eq '0'}"><c:set var="trBgColor" value="#FFFF99" /></c:when>
      <c:otherwise><c:set var="trBgColor" value="#ffffff" /></c:otherwise>
    </c:choose>
      <tr bgcolor="${trBgColor}">
    <c:choose>
      <c:when test="${ statsu.index eq '0' and keiyakuInfo.linkFlg eq '1'}">
        <td>
          <a href="
            <c:url value="KeiyakuUpdatePage.do">
              <c:param name="shopCd" value="${view.shopCd}" />
              <c:param name="pkShopListingSeq" value="${keiyakuInfo.pkShopListingSeq}" />
            </c:url>" >
            <fmt:parseDate value="${keiyakuInfo.keiyakuStartYm}" var="startYm" pattern="yyyyMM"/>
            <fmt:formatDate  value="${startYm}" pattern="yyyy年MM月" />
            ～
            <fmt:parseDate value="${keiyakuInfo.keiyakuEndYm}" var="endYm" pattern="yyyyMM"/>
            <fmt:formatDate  value="${endYm}" pattern="yyyy年MM月" />
          </a>
        </td>
      </c:when>
      <c:otherwise>
        <td>
            <fmt:parseDate value="${keiyakuInfo.keiyakuStartYm}" var="startYm" pattern="yyyyMM"/>
            <fmt:formatDate  value="${startYm}" pattern="yyyy年MM月" />
            ～
            <fmt:parseDate value="${keiyakuInfo.keiyakuEndYm}" var="endYm" pattern="yyyyMM"/>
            <fmt:formatDate  value="${endYm}" pattern="yyyy年MM月" />
        </td>
      </c:otherwise>
    </c:choose>

    <c:choose>
      <c:when test="${'1' eq keiyakuInfo.keiyakuShubetsu}">
        <td colspan="2">-</td>
      </c:when>
      <c:when test="${not empty keiyakuInfo.couponStartYm}">
        <td>
          <fmt:parseDate value="${keiyakuInfo.couponStartYm}" var="startYm" pattern="yyyyMM"/>
          <fmt:formatDate  value="${startYm}" pattern="yyyy年MM月" />
          ～
          <fmt:parseDate value="${keiyakuInfo.couponEndYm}" var="endYm" pattern="yyyyMM"/>
          <fmt:formatDate  value="${endYm}" pattern="yyyy年MM月" />
        </td>
      </c:when>

      <c:otherwise>
          <td><span class="caution">未契約</span></td>
      </c:otherwise>
    </c:choose>

    <c:choose>
      <c:when test="${'1' eq keiyakuInfo.keiyakuShubetsu}"></c:when>
      <c:when test="${not empty keiyakuInfo.linkStartYm}">
        <td>
          <fmt:parseDate value="${keiyakuInfo.linkStartYm}" var="startYm" pattern="yyyyMM"/>
          <fmt:formatDate  value="${startYm}" pattern="yyyy年MM月" />
          ～
          <fmt:parseDate value="${keiyakuInfo.linkEndYm}" var="endYm" pattern="yyyyMM"/>
          <fmt:formatDate  value="${endYm}" pattern="yyyy年MM月" />
        </td>
      </c:when>
      <c:otherwise>
          <td><span class="caution">未契約</span></td>
      </c:otherwise>
    </c:choose>
        <td><chintai:filter changeNL2BR="true"><c:out value="${keiyakuInfo.note}" /></chintai:filter></td>
      </tr>
  </c:forEach>
    </table>
</c:if>

    <!-- 出稿情報 -->
    <p class="section_header"><a name="3">出稿情報</a></p>
<c:if test="${not empty view.kihonKeiyakuInfoList and not empty view.mediaInfo and not empty view.mediaInfo.catchPhraseTmp}">
    <p>&gt;&gt;
      <html:link action="shop_listing/MediaInfoWebRegisterConfirm.do"  paramId="shopCd" paramName="view" paramProperty="shopCd">
        出稿情報（仮保存）をWEBへ反映する
      </html:link>
    </p>
</c:if>

<c:if test="${not empty view.kihonKeiyakuInfoList and empty view.mediaInfo.catchPhraseTmp}">
    <p>
      <html:link action="shop_listing/MediaInfoRegisterPage.do" paramId="shopCd" paramName="view" paramProperty="shopCd">
        &gt;&gt;出稿情報（仮保存）を登録する
      </html:link>
    </p>
</c:if>
<c:if test="${not empty view.kihonKeiyakuInfoList and not empty view.mediaInfo.catchPhraseTmp}">
    <p>
      <html:link action="shop_listing/MediaInfoUpdatePage.do" paramId="shopCd" paramName="view" paramProperty="shopCd">
        &gt;&gt;出稿情報（仮保存）を編集する
      </html:link>
    </p>
</c:if>

    <div style="font-size:13px;color:#555555;">WEB表示確認</div>
    <p>
      &nbsp;&nbsp;&nbsp;&gt;&gt;
      <fmt:setBundle basename="resources.server" var="resource" />
      <fmt:message bundle="${resource}" key="chintai.shopDetailUrl" var="chintaiShopDetailUrl">
        <fmt:param><c:out value="${view.shopCd}" /></fmt:param>
      </fmt:message>
      <a href="${chintaiShopDetailUrl}" target="blank">CHINTAI.netの店舗詳細画面を確認する</a>
    </p>
<c:if test="${(not empty view.mediaInfo.locationX) and (not empty view.mediaInfo.locationX) and (not empty view.mediaInfo.prefKey)}">
    <p>
      &nbsp;&nbsp;&nbsp;&gt;&gt;
      <fmt:message bundle="${resource}" key="chintai.mapsearchUrl" var="mapsearchUrl">
        <fmt:param><c:out value="${view.mediaInfo.locationX}" /></fmt:param>
        <fmt:param><c:out value="${view.mediaInfo.locationY}" /></fmt:param>
        <fmt:param><c:out value="${view.mediaInfo.prefKey}" /></fmt:param>
      </fmt:message>
      <a href="${mapsearchUrl}" target="blank">CHINTAI.netの地図検索画面を確認する</a>
    </p>
</c:if>

<c:if test="${(not empty view.mediaInfo.catchPhraseWeb) or (not empty view.mediaInfo.catchPhraseTmp)}">
<c:set var="mediaInfo" value="${view.mediaInfo}" />
    <table class="type_detail_pre">
      <colgroup>
        <col width="9%">
        <col width="10%">
        <col width="40%" style="word-break:break-all;word-wrap:break-word;">
        <col width="40%" style="word-break:break-all;word-wrap:break-word;">
      </colgroup>
  <c:choose>
    <c:when test="${empty mediaInfo.catchPhraseWeb}">
      <tr>
      	<th colspan="2">&nbsp;</th>
      	<th align="center">WEB表示中</th>
      	<th align="center">仮保存中</th>
      </tr>
      <tr>
        <th colspan="2" class="text-left">出稿対象駅</th>
        <td rowspan="11" bgcolor="#FFFF99">Web表示中のデータがありません。</td>
        <td><c:out value="${mediaInfo.ekiTmp}" /></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">出稿対象市区町村</th>
        <td><c:out value="${mediaInfo.cityTmp}" /></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">キャッチフレーズ</th>
        <td><chintai:filter changeNL2BR="true"><c:out value="${mediaInfo.catchPhraseTmp}" /></chintai:filter></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">アピールコメント</th>
        <td><chintai:filter changeNL2BR="true"><c:out value="${mediaInfo.appealCommentTmp}" /></chintai:filter></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">店舗画像</th>
        <td>
<c:choose>
  <c:when test="${empty mediaInfo.imgUrlTmp}">
          画像が登録されていません
  </c:when>
  <c:when test="${'0' eq mediaInfo.imgUrlTmp}">
          画像が選択されていません
  </c:when>
  <c:when test="${'-1' eq mediaInfo.imgUrlTmp}">
          選択された画像区分が不正です
  </c:when>
  <c:otherwise>
          <img src="${mediaInfo.imgUrlTmp}">
  </c:otherwise>
</c:choose>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">アピールアイコン選択</th>
        <td>
<c:forEach items="${mediaInfo.appealIconTmp}" var="tmpIconInfo">
          <img src="${tmpIconInfo.iconImgPath}" alt="${tmpIconInfo.iconName}" title="${tmpIconInfo.iconName}">
</c:forEach>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">リスティングアイコン選択</th>
        <td>
<c:forEach items="${mediaInfo.listingIconTmp}" var="tmpListingInfo">
          <img src="${tmpListingInfo.iconImgPath}" alt="${tmpListingInfo.iconName}" title="${tmpListingInfo.iconName}">&nbsp;
</c:forEach>
        </td>
      </tr>
      <tr>
        <th rowspan="3" align="center">注釈</th>
        <th class="text-left">①</th>
        <td><c:out value="${mediaInfo.couponComment1Tmp}" /></td>
      </tr>
      <tr>
        <th class="text-left">②</th>
        <td><c:out value="${mediaInfo.couponComment2Tmp}" /></td>
      </tr>
      <tr>
        <th class="text-left">③</th>
        <td><c:out value="${mediaInfo.couponComment3Tmp}" /></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">備考</th>
        <td><chintai:filter changeNL2BR="true"><c:out value="${mediaInfo.noteTmp}" /></chintai:filter></td>
      </tr>
    </c:when>
    <c:when test="${empty mediaInfo.catchPhraseTmp}">
      <tr>
      	<th colspan="2">&nbsp;</th>
      	<th align="center">WEB表示中</th>
      	<th align="center">仮保存中</th>
      </tr>
      <tr>
        <th colspan="2" class="text-left">出稿対象駅</th>
        <td bgcolor="#FFFF99"><c:out value="${mediaInfo.ekiWeb}" /></td>
        <td rowspan="11">仮保存中のデータがありません。</td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">出稿対象市区町村</th>
        <td bgcolor="#FFFF99"><c:out value="${mediaInfo.cityWeb}" /></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">キャッチフレーズ</th>
        <td bgcolor="#FFFF99"><chintai:filter changeNL2BR="true"><c:out value="${mediaInfo.catchPhraseWeb}" /></chintai:filter></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">アピールコメント</th>
        <td bgcolor="#FFFF99"><chintai:filter changeNL2BR="true"><c:out value="${mediaInfo.appealCommentWeb}" /></chintai:filter></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">店舗画像</th>
        <td bgcolor="#FFFF99">
<c:choose>
  <c:when test="${empty mediaInfo.imgUrlWeb}">
          画像が登録されていません
  </c:when>
  <c:when test="${'0' eq mediaInfo.imgUrlWeb}">
          画像が選択されていません
  </c:when>
<c:when test="${'-1' eq mediaInfo.imgUrlWeb}">
          選択された画像区分が不正です
  </c:when>
  <c:otherwise>
          <img src="${mediaInfo.imgUrlWeb}">
  </c:otherwise>
</c:choose>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">アピールアイコン選択</th>
        <td bgcolor="#FFFF99">
<c:forEach items="${mediaInfo.appealIconWeb}" var="webIconInfo">
          <img src="${webIconInfo.iconImgPath}" alt="${webIconInfo.iconName}" title="${webIconInfo.iconName}">&nbsp;
</c:forEach>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">リスティングアイコン選択</th>
        <td bgcolor="#FFFF99">
<c:forEach items="${mediaInfo.listingIconWeb}" var="webListingInfo">
          <img src="${webListingInfo.iconImgPath}" alt="${webListingInfo.iconName}" title="${webListingInfo.iconName}">&nbsp;
</c:forEach>
        </td>

      </tr>
      <tr>
        <th rowspan="3" align="center">注釈</th>
        <th class="text-left">①</th>
        <td bgcolor="#FFFF99"><c:out value="${mediaInfo.couponComment1Web}" /></td>
      </tr>
      <tr>
        <th class="text-left">②</th>
        <td bgcolor="#FFFF99"><c:out value="${mediaInfo.couponComment2Web}" /></td>
      </tr>
      <tr>
        <th class="text-left">③</th>
        <td bgcolor="#FFFF99"><c:out value="${mediaInfo.couponComment3Web}" /></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">備考</th>
        <td bgcolor="#FFFF99"><chintai:filter changeNL2BR="true"><c:out value="${mediaInfo.noteWeb}" /></chintai:filter></td>
      </tr>
    </c:when>


    <c:otherwise>
      <tr>
      	<th colspan="2">&nbsp;</th>
      	<th align="center">WEB表示中</th>
      	<th align="center">仮保存中</th>
      </tr>
      <tr>
        <th colspan="2" class="text-left">出稿対象駅</th>
        <td bgcolor="#FFFF99"><c:out value="${mediaInfo.ekiWeb}" /></td>
        <td><c:out value="${mediaInfo.ekiTmp}" /></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">出稿対象市区町村</th>
        <td bgcolor="#FFFF99"><c:out value="${mediaInfo.cityWeb}" /></td>
        <td><c:out value="${mediaInfo.cityTmp}" /></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">キャッチフレーズ</th>
        <td bgcolor="#FFFF99"><chintai:filter changeNL2BR="true"><c:out value="${mediaInfo.catchPhraseWeb}" /></chintai:filter></td>
        <td><chintai:filter changeNL2BR="true"><c:out value="${mediaInfo.catchPhraseTmp}" /></chintai:filter></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">アピールコメント</th>
        <td bgcolor="#FFFF99"><chintai:filter changeNL2BR="true"><c:out value="${mediaInfo.appealCommentWeb}" /></chintai:filter></td>
        <td><chintai:filter changeNL2BR="true"><c:out value="${mediaInfo.appealCommentTmp}" /></chintai:filter></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">店舗画像</th>
        <td bgcolor="#FFFF99">
<c:choose>
  <c:when test="${empty mediaInfo.imgUrlWeb}">
          画像が登録されていません
  </c:when>
  <c:when test="${'0' eq mediaInfo.imgUrlWeb}">
          画像が選択されていません
  </c:when>
  <c:when test="${'-1' eq mediaInfo.imgUrlWeb}">
          選択された画像区分が不正です
  </c:when>
  <c:otherwise>
          <img src="${mediaInfo.imgUrlWeb}">
  </c:otherwise>
</c:choose>
        </td>
        <td>
<c:choose>
  <c:when test="${empty mediaInfo.imgUrlTmp}">
          画像が登録されていません
  </c:when>
  <c:when test="${'0' eq mediaInfo.imgUrlTmp}">
          画像が選択されていません
  </c:when>
  <c:when test="${'-1' eq mediaInfo.imgUrlTmp}">
          選択された画像区分が不正です
  </c:when>
  <c:otherwise>
          <img src="${mediaInfo.imgUrlTmp}">
  </c:otherwise>
</c:choose>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">アピールアイコン選択</th>
        <td bgcolor="#FFFF99">
<c:forEach items="${mediaInfo.appealIconWeb}" var="webIconInfo">
          <img src="${webIconInfo.iconImgPath}" alt="${webIconInfo.iconName}" title="${webIconInfo.iconName}">&nbsp;
</c:forEach>
        </td>
        <td>
<c:forEach items="${mediaInfo.appealIconTmp}" var="tmpIconInfo">
          <img src="${tmpIconInfo.iconImgPath}" alt="${tmpIconInfo.iconName}" title="${tmpIconInfo.iconName}">&nbsp;
</c:forEach>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">リスティングアイコン選択</th>
        <td bgcolor="#FFFF99">
<c:forEach items="${mediaInfo.listingIconWeb}" var="webListingInfo">
          <img src="${webListingInfo.iconImgPath}" alt="${webListingInfo.iconName}" title="${listingIconWeb.iconName}">
</c:forEach>
        </td>
        <td>
<c:forEach items="${mediaInfo.listingIconTmp}" var="tmpListingInfo">
          <img src="${tmpListingInfo.iconImgPath}" alt="${tmpListingInfo.iconName}" title="${tmpListingInfo.iconName}">
</c:forEach>
        </td>
      </tr>
      <tr>
        <th rowspan="3" align="center">注釈</th>
        <th class="text-left">①</th>
        <td bgcolor="#FFFF99"><c:out value="${mediaInfo.couponComment1Web}" /></td>
        <td><c:out value="${mediaInfo.couponComment1Tmp}" /></td>
      </tr>
      <tr>
        <th class="text-left">②</th>
        <td bgcolor="#FFFF99"><c:out value="${mediaInfo.couponComment2Web}" /></td>
        <td><c:out value="${mediaInfo.couponComment2Tmp}" /></td>
      </tr>
      <tr>
        <th class="text-left">③</th>
        <td bgcolor="#FFFF99"><c:out value="${mediaInfo.couponComment3Web}" /></td>
        <td><c:out value="${mediaInfo.couponComment3Tmp}" /></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">備考</th>
        <td bgcolor="#FFFF99"><chintai:filter changeNL2BR="true"><c:out value="${mediaInfo.noteWeb}" /></chintai:filter></td>
        <td><chintai:filter changeNL2BR="true"><c:out value="${mediaInfo.noteTmp}" /></chintai:filter></td>
      </tr>
    </c:otherwise>
  </c:choose>
    </table>


</c:if>

    <!-- クーポン情報 -->
    <p class="section_header"><a name="4">クーポン情報</a></p>
<c:if test="${not empty view.kihonKeiyakuInfoList}">
    <p>
      <html:link action="shop_listing/CouponEditPage.do" paramId="shopCd" paramName="view" paramProperty="shopCd">
        &gt;&gt;クーポン情報を編集する
      </html:link>
    </p>
</c:if>

<c:if test="${not empty view.couponSeqs[0]}">

    <table class="type_detail">
      <colgroup>
        <col width="19%" align="center">
        <col width="20%">
        <col width="40%">
        <col width="10%" align="center">
        <col width="10%" align="center">
      </colgroup>
      <tr>
        <th align="center">項番</th>
        <th align="center" colspan="2">内容</th>
        <th>ソート順</th>
        <th>非表示</th>
      </tr>

<c:forEach items="${view.couponSeqs}" varStatus="i" >
<c:if test="${not empty view.couponSeqs[i.index]}">
      <tr>
        <th rowspan="4">クーポン<c:out value="${i.index +1}" /></th>
        <th class="text-left">開始年月日～終了年月日</th>
        <td>
          <c:out value="${view.startYears[i.index]}" />年
          <c:out value="${view.startMonths[i.index]}" />月
          <c:out value="${view.startDays[i.index]}" />日～
<c:if test="${not empty view.endYears[i.index]}">
          <c:out value="${view.endYears[i.index]}" />年
          <c:out value="${view.endMonths[i.index]}" />月
          <c:out value="${view.endDays[i.index]}" />日
</c:if>
        </td>
        <td rowspan="4"><c:out value="${view.sortKeys[i.index]}" /></td>
        <td rowspan="4">
<c:choose>
  <c:when test="${view.delFlgs[i.index] eq '1'}">
          非表示
  </c:when>
  <c:otherwise>
          表示
  </c:otherwise>
</c:choose>
        </td>
      </tr>
      <tr>
        <th class="text-left">利用対象</th>
<c:choose>
  <c:when test="${view.riyouTaisyoType[i.index] eq '1'}">
        <td><c:out value="${view.riyouTaisyo[i.index]}" /></td>
  </c:when>
  <c:when test="${view.riyouTaisyoType[i.index] eq '2'}">
        <td><c:out value="${view.riyouTaisyoCustom[i.index]}" /></td>
  </c:when>
  <c:otherwise><td></td></c:otherwise>
</c:choose>
      </tr>
      <tr>
        <th class="text-left">特典</th>
<c:choose>
  <c:when test="${view.tokutenType[i.index] eq '1'}">
        <td><c:out value="${view.tokuten[i.index]}" /></td>
  </c:when>
  <c:when test="${view.tokutenType[i.index] eq '2'}">
        <td><c:out value="${view.tokutenCustom[i.index]}" /></td>
  </c:when>
  <c:otherwise><td></td></c:otherwise>
</c:choose>
      </tr>
      <tr>
        <th class="text-left">提示条件</th>
<c:choose>
  <c:when test="${view.joukenType[i.index] eq '1'}">
        <td><c:out value="${view.jouken[i.index]}" /></td>
  </c:when>
  <c:when test="${view.joukenType[i.index] eq '2'}">
        <td><c:out value="${view.joukenCustom[i.index]}" /></td>
  </c:when>
  <c:otherwise><td></td></c:otherwise>
</c:choose>
      </tr>

</c:if>
</c:forEach>
    </table>
</c:if>

  </div><!-- popup_layout END -->
</div><!-- main END -->

<%@ include file="../parts/ContentsFooter.jsp" %>
