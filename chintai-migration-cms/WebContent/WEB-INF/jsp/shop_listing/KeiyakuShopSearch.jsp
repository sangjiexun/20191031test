<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="契約店舗検索" />
<c:set var="view" value="${KeiyakuShopSearchView}" />
<%@ include file="../parts/ContentsHeader.jsp"%>
<%@ include file="../parts/ContentsSidebar.jsp"%>

<script type="text/javascript">
<!--
 function page(offSet){
    var thisForm = document.forms[0];
    if (thisForm.output.value=='csv') {
    	thisForm.output.value = 'gamen';
    }
    thisForm.offSet.value = offSet;
    _submit('KeiyakuShopSearchPaging.do');

 }

 addEvent('load', window, function(){document.getElementsByName('shopCd')[0].focus();});

-->
</script>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp"%>
<div class="main_layout">
  <div class="topic_path">
    <html:link action="/Index.do">トップページ </html:link>&nbsp;&gt;&nbsp;${title}
  </div>

  <h1>${title}</h1>
  <html:errors />
  <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
    <c:out value="${msg}"/>
  </html:messages>
  <!-- 警告対象条件 -->
  <p class="section_header">検索条件</p>

  <html:form action="shop_listing/KeiyakuShopSearch.do" method="get">
    <table class="type_searchbox">
      <tr>
        <td>店舗コード</td>
        <td><input type="text" name="shopCd" size="9" maxlength="9" value="${view.shopCd}"></td>
        <td>会社名/事務所名</td>
        <td><input type="text" name="companyBumon" size="40" maxlength="60" value="${view.companyBumon}"></td>
      </tr>
      <tr>
        <td>都道府県</td>
        <td colspan="3">
          <chintai:Todofuken name="prefCd" fixValue="${view.prefCd}"/>
        </td>
      </tr>
      <tr>
        <td>データ元</td>
        <td><chintai:PropertyOptions name="clientSystemType" fixValue="${view.clientSystemType}" nameKey="CLIENTSYSTEM_SEARCH_NAME" valueKey="CLIENTSYSTEM_SEARCH_VALUE"/></td>
        <td align="right">状態</td>
        <td>
          <chintai:PropertyOptions name="shopStatus" fixValue="${view.shopStatus}" nameKey="SHOP_LISTING_SHOP_STATUS_NAME" valueKey="SHOP_LISTING_SHOP_STATUS_VALUE"/>
        </td>
      </tr>
      <tr>
        <td>基本契約</td>
        <td colspan="3">
          <input type="checkbox" name="keiyaku" value="1" <c:if test="${not empty view.keiyaku}">checked="checked"</c:if> />契約中&nbsp;
          <input type="checkbox" name="mikeiyaku" value="1" <c:if test="${not empty view.mikeiyaku}">checked="checked"</c:if> />未契約&nbsp;
          <input type="checkbox" name="kigengire" value="1" <c:if test="${not empty view.kigengire}">checked="checked"</c:if> />契約期限切れ&nbsp;
        </td>
      </tr>
    </table>

    <!-- 出力方法 -->
    <p class="section_header">検索結果の出力方法</p>
    <table class="type_searchbox">
      <tr>
        <td>
          ソートキー
        </td>
        <td>
          <chintai:PropertyOptions name="sortKey"
                                   fixValue="${view.sortKey}"
                                   nameKey="SHOP_LISTING_SORT_NAME"
                                   valueKey="SHOP_LISTING_SORT_VALUE"/>
        </td>
        <td>
          順序
        </td>
        <td>
          <chintai:PropertyOptions name="orderBy"
                                   fixValue="${view.orderBy}"
                                   nameKey="ORDER_BY_NAME"
                                   valueKey="ORDER_BY_VALUE"/>
        </td>
        <td>
          表示件数
        </td>
        <td>
          <chintai:PropertyOptions name="displayNum"
                                   fixValue="${view.displayNum}"
                                   nameKey="DISPLAY_NUM_NAME"
                                   valueKey="DISPLAY_NUM_VALUE"/>
        </td>
        <td>
          出力先
        </td>
        <td>
          <chintai:PropertyOptions name="output"
                                   fixValue="${view.output}"
                                   nameKey="DISPLAY_TYPE_NAME"
                                   valueKey="DISPLAY_TYPE_VALUE"/>
        </td>
      </tr>
    </table>

    <p>
      <input type="hidden" name="offSet">
      <input type="submit" value="検索"/>
      <input type="reset" value ="クリア"/>
    </p>
  </html:form>

  <!-- 検索結果 -->
<c:if test="${not empty KeiyakuShopSearchView.shopList}">
  <p class="section_header">検索結果</p>
  <p class="caution">背景が黄色の店舗は、CHINTAI店舗リスティングには参加せずに店舗情報が登録されている店舗です。</p>
  <c:set var="helper" value="${KeiyakuShopSearchView}"/>
<%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
<%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>

  <table class="type_list">
    <!--
    <colgroup>
      <col width="10%">
      <col width="30%">
      <col width="20%">
      <col width="20%">
      <col width="20%">
      <col width="20%">
      <col width="20%">
    </colgroup>
     -->
      <tr>
      <th rowspan="4">店舗<br>コード</th>
      <th rowspan="4">会社名<br>事務所名</th>
      <th colspan="5">契約内容（<label><fmt:formatDate value="${KeiyakuShopSearchView.nowDate}" pattern="yyyy年MM月dd日 HH:mm" /></label>時点）</th>
    </tr>
    <tr>
      <th rowspan="3">基本契約期間</th>
      <th colspan="4">オプション契約</th>
    </tr>
    <tr>
      <th colspan="3">クーポン発行</th>
      <th rowspan="2">外部リンク表示</th>
    </tr>
    <tr>
      <th>クーポン1</th>
      <th>クーポン2</th>
      <th>クーポン3</th>
    </tr>

<c:forEach items="${KeiyakuShopSearchView.shopList}" var="shop">
<c:choose>
  <c:when test="${shop.keiyakuShubetsu eq '0' and (not empty shop.coupon1StartYmd or not empty shop.coupon2StartYmd or not empty shop.coupon3StartYmd)}">
    <c:set var="spanValue" value="2" />
  </c:when>
  <c:otherwise>
    <c:set var="spanValue" value="1" />
  </c:otherwise>
</c:choose>
<c:choose>
  <c:when test="${shop.keiyakuShubetsu eq 1}"><c:set var="trBgColor" value="#FAFAD2" /></c:when>
  <c:otherwise><c:set var="trBgColor" value="#ffffff" /></c:otherwise>
</c:choose>
    <tr bgcolor="${trBgColor}">
      <td rowspan="${spanValue}">
        <label>
<c:choose>
  <c:when test="${shop.shopStatus eq '0'}">
            <c:out value="${shop.shopCd}" />
  </c:when>
  <c:otherwise>
          <html:link action="shop_listing/KeiyakuShopInfo.do" paramId="shopCd" paramName="shop" paramProperty="shopCd" target="_blank">
            <c:out value="${shop.shopCd}" />
          </html:link>
  </c:otherwise>
</c:choose>
        </label>
      </td>
      <td rowspan="${spanValue}">
        <c:out value="${shop.company}" /><br><c:out value="${shop.bumon}" />
      </td>
<c:choose>
  <c:when test="${shop.keiyakuShubetsu eq 1 or empty shop.keiyakuStartYm}">
      <td colspan="5">-</td>
  </c:when>
  <c:otherwise>
      <td rowspan="${spanValue}">
        <fmt:parseDate value="${shop.keiyakuStartYm}" var="startYm" pattern="yyyyMM"/>
        <fmt:formatDate  value="${startYm}" pattern="yyyy年MM月" />
        ～
        <fmt:parseDate value="${shop.keiyakuEndYm}" var="endYm" pattern="yyyyMM"/>
        <fmt:formatDate  value="${endYm}" pattern="yyyy年MM月" />
      </td>
      <td colspan="3">
    <c:choose>
      <c:when test="${not empty shop.couponStartYm}">
        <fmt:parseDate value="${shop.couponStartYm}" var="startYm" pattern="yyyyMM"/>
        <fmt:formatDate  value="${startYm}" pattern="yyyy年MM月" />～
        <fmt:parseDate value="${shop.couponEndYm}" var="startYm" pattern="yyyyMM"/>
        <fmt:formatDate  value="${startYm}" pattern="yyyy年MM月" />
      </c:when>
      <c:otherwise>
        <span class="caution">未契約</span>
      </c:otherwise>
    </c:choose>
      </td>
      <td rowspan="${spanValue}" >
    <c:choose>
      <c:when test="${empty shop.linkStartYm}">
        <span class="caution">未契約</span>
      </c:when>
      <c:otherwise>
        <fmt:parseDate value="${shop.linkStartYm}" var="startYm" pattern="yyyyMM"/>
        <fmt:formatDate  value="${startYm}" pattern="yyyy年MM月" />
        ～
        <fmt:parseDate value="${shop.linkEndYm}" var="endYm" pattern="yyyyMM"/>
        <fmt:formatDate  value="${endYm}" pattern="yyyy年MM月" />
      </c:otherwise>
    </c:choose>
      </td>
  </c:otherwise>
</c:choose>
    </tr>
<c:if test="${shop.keiyakuShubetsu eq '0' and (not empty shop.coupon1StartYmd or not empty shop.coupon2StartYmd or not empty shop.coupon3StartYmd)}">
    <tr>
      <td>
  <c:choose>
    <c:when test="${not empty shop.coupon1StartYmd}">
      <fmt:formatDate  value="${shop.coupon1StartYmd}" pattern="yyyy年MM月dd日" />
      ～<fmt:formatDate  value="${shop.coupon1EndYmd}" pattern="yyyy年MM月dd日" />
    </c:when>
    <c:otherwise>
      -
    </c:otherwise>
  </c:choose>
      </td>
      <td>
  <c:choose>
    <c:when test="${not empty shop.coupon2StartYmd}">
      <fmt:formatDate  value="${shop.coupon2StartYmd}" pattern="yyyy年MM月dd日" />
      ～<fmt:formatDate  value="${shop.coupon2EndYmd}" pattern="yyyy年MM月dd日" />
    </c:when>
    <c:otherwise>
      -
    </c:otherwise>
  </c:choose>
      </td>
      <td>
  <c:choose>
    <c:when test="${not empty shop.coupon3StartYmd}">
      <fmt:formatDate  value="${shop.coupon3StartYmd}" pattern="yyyy年MM月dd日" />
      ～<fmt:formatDate  value="${shop.coupon3EndYmd}" pattern="yyyy年MM月dd日" />
    </c:when>
    <c:otherwise>
      -
    </c:otherwise>
  </c:choose>
      </td>
    </tr>
</c:if>
</c:forEach>
  </table>
<%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
</c:if>
</div><!-- main_layout -->
</div><!-- main -->
<%@ include file="../parts/ContentsFooter.jsp"%>