<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗検索" />
<c:set var="view"  value="${ReviewShopSearchView}" />
<%@ include file="../parts/ContentsHeader.jsp"%>
<%@ include file="../parts/ContentsSidebar.jsp"%>
<script type="text/javascript">
<!--
 function page(offSet){
   var thisForm = document.forms[0];
   thisForm.offSet.value           = offSet;

   _submit('ReviewShopSearchPaging.do');
 }

 addEvent('load', window, function(){document.getElementsByName('shopCd')[0].focus();});

-->
</script>
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp"%>
<div class="main_layout">
<div class="topic_path">
  <html:link action="/Index.do">トップページ </html:link>&gt;
  ${title}
</div>
<h1>${title}</h1>
<html:errors />
<html:messages id ="msg" message="true" header="info.header" footer="info.footer">
  <c:out value="${msg}"/>
</html:messages>
<html:form action="review/ReviewShopSearch.do"  method="get">
<!-- Web審査 店舗検索 -->
<p class="section_header">店舗情報から検索</p>
<table class="type_searchbox">
  <tr>
    <td>店舗コード</td>
    <td><input type="text" name="shopCd" value="${view.shopCd}" size="10" maxlength="9"></td>
    <td>会社名/事務所名</td>
    <td colspan="2"><input type="text" name="companyBumon" value="${fn:escapeXml(view.companyBumon)}" size="40" maxlength="400"></td>
  </tr>
  <tr>
    <td>都道府県</td>
    <td><chintai:Todofuken name="prefCd" fixValue="${view.prefCd}"/></td>
    <td>有効物件数</td>
    <td colspan="2">
      <input type="text" name="bukkenCntFrom" value="${view.bukkenCntFrom}" size="6" maxlength="4" /> 件以上&nbsp;～&nbsp;
      <input type="text" name="bukkenCntTo" value="${view.bukkenCntTo}" size="6" maxlength="4" /> 件以内&nbsp;
    </td>
  </tr>
  <tr>
    <td>状態</td>
    <td>
      <chintai:PropertyOptions name="shopStatus" fixValue="${view.shopStatus}" nameKey="STATUS_NAME" valueKey="STATUS_VALUE"/>
    </td>
    <td colspan="2">連動元<chintai:MstRendo name="rendoCd" fixValue="${param.rendoCd}"/></td>
  </tr>
  <tr>
    <td>免許証番号</td>
    <td><input type="text" name="licNum" value="${fn:escapeXml(view.licNum)}" size="15" maxlength="120"></td>
  </tr>
</table>

<!-- 審査情報から検索 -->
<p class="section_header">審査情報から検索</p>
<table class="type_searchbox">
  <tr>
    <td colspan="2">
      <label>
        <c:choose>
          <c:when test="${not empty view.syokaiShinsaCnt or not empty defaultFlag}">
            <input type="checkbox" name="syokaiShinsaCnt" value="1" checked/>
          </c:when>
          <c:otherwise>
            <input type="checkbox" name="syokaiShinsaCnt" value="1" />
          </c:otherwise>
        </c:choose>
        初回審査返信待ち物件を１件以上保持している店舗
      </label>
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <label>
        <c:choose>
          <c:when test="${not empty view.teikiShinsaCnt or not empty defaultFlag}">
            <input type="checkbox" name="teikiShinsaCnt" value="1" checked/>
          </c:when>
          <c:otherwise>
            <input type="checkbox" name="teikiShinsaCnt" value="1" />
          </c:otherwise>
        </c:choose>
        定期審査返信待ち物件を１件以上保持している店舗
      </label>
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <label>
        <c:choose>
          <c:when test="${not empty view.shinsaNoCnt or not empty defaultFlag}">
            <input type="checkbox" name="shinsaNoCnt" value="1" checked/>
          </c:when>
          <c:otherwise>
            <input type="checkbox" name="shinsaNoCnt" value="1" />
          </c:otherwise>
        </c:choose>
        初回、定期審査返信待ち物件を保持していない店舗
      </label>
    </td>
  </tr>
  <tr>
    <td>返信待ち率（初回、定期審査返信待ち物件／有効物件数&nbsp;*&nbsp;100）</td>
    <td>
      <chintai:PropertyOptions name="returnRateFrom" nameKey="WEB_RETURN_RATE_NAME" valueKey="WEB_RETURN_RATE_VALUE" fixValue="${view.returnRateFrom}"/>
       ～
      <chintai:PropertyOptions name="returnRateTo" nameKey="WEB_RETURN_RATE_NAME" valueKey="WEB_RETURN_RATE_VALUE" fixValue="${view.returnRateTo}"/>
    </td>
  </tr>
</table>

<!-- 出力方法 -->
<p class="section_header">検索結果の出力方法</p>
<table class="type_searchbox">
  <tr>
    <td>
      ソートキー
      <chintai:PropertyOptions name="sortKey"
                               fixValue="${view.sortKey}"
                               nameKey="WEB_SHOP_SEARCH_SORT_NAME"
                               valueKey="WEB_SHOP_SEARCH_SORT_VALUE"/>
    </td>
    <td>
      順序
      <chintai:PropertyOptions name="orderBy"
                               fixValue="${view.orderBy}"
                               nameKey="WEB_ORDER_BY_NAME"
                               valueKey="WEB_ORDER_BY_VALUE"/>
    </td>
    <td>
      表示件数
      <chintai:PropertyOptions name="displayNum"
                               fixValue="${view.displayNum}"
                               nameKey="DISPLAY_NUM_NAME"
                               valueKey="DISPLAY_NUM_VALUE"/>
    </td>
  </tr>
</table><br>

<p>
  <input type="hidden" name="offSet">
  <input type="submit" value="検索">
  <input type="reset" value="クリア">
  </p>
</html:form>

<!-- 検索結果表示部分 -->
<c:if test="${not empty ReviewShopSearchView.shopList}">
  <p class="section_header">検索結果</p>
<c:set var="helper" value="${ReviewShopSearchView}"/>
<%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
<%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
      <table  class="type_list" >
        <tr>
          <th rowspan="2">店舗コード<br>状態</th>
          <th rowspan="2">会社名<br>事務所名</th>
          <th rowspan="2">CHINTAI掲載<br>エイブル掲載<br>連動元</th>
          <th rowspan="2">連絡<br>方法</th>
          <th rowspan="2">店舗対象外設定</th>
          <th rowspan="2">有効<br>物件数</th>
          <th colspan="2">返信待ち物件数</th>
          <th rowspan="2">返信待ち率</th>
          <th rowspan="2">返信待ち物件</th>
        </tr>
        <tr>
          <th>初回審査</th>
          <th>定期審査</th>
        </tr>

        <c:forEach items="${ReviewShopSearchView.shopList}" var="shop">
        <tr>
          <td>
            <a href="<c:url value="ReviewShopInfo.do">
                       <c:param name="shopCd" value="${shop.shopCd}"/>
                     </c:url>" target="_blank">
              <c:out value="${shop.shopCd}" />
            </a><br>
            <chintai:CodePrint code="${shop.shopStatus}" nameKey="STATUS_NAME" valueKey="STATUS_VALUE"/>
          </td>
          <td class="left"><c:out value="${shop.company}" /><br><c:out value="${shop.bumon}" /></td>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_CT_FLG_NAME" valueKey="SHOPBUKKEN_CT_FLG_VALUE" code="${shop.ctStatus}"/><br>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ABL_FLG_NAME" valueKey="SHOPBUKKEN_ABL_FLG_VALUE" code="${shop.ablStatus}"/><br>
            <c:out value="${shop.rendoName}" />
          </td>
          <td><chintai:CodePrint code="${shop.fmKbn}" nameKey="WEB_FM_KBN_NAME" valueKey="WEB_FM_KBN_VALUE"/></td>
          <td>
            初回審査
            <chintai:CodePrint code="${shop.syokaiShinsaSkipFlg}" nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/><br>
            定期審査
            <chintai:CodePrint code="${shop.teikiShinsaSkipFlg}"  nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/><br>
            メール送信
            <chintai:CodePrint code="${shop.mailSendSkipFlg}"  nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/><br>
            自動削除
            <chintai:CodePrint code="${shop.autoDelSkipFlg}"  nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/><br>
          </td>
          <td class="right"><c:out value="${shop.bukkenCnt}" /></td>
          <td class="right"><c:out value="${shop.syokaiShinsaCnt}" /></td>
          <td class="right"><c:out value="${shop.teikiShinsaCnt}" /></td>
          <td class="right"><c:out value="${shop.returnRate}" />%</td>
          <td><input type="button" value="一覧表示" onClick="javascript:location.href='ReviewShopBukkenSearch.do?shopCd=${shop.shopCd}&chkFlg=ok'"></td>
        </tr>
        </c:forEach>
      </table>
<%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
</c:if>


</div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>
