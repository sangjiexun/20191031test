<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="警告対象物件一覧" />
<c:set var="view" value="${ReviewBukkenAlertCountView}" />
<%@ include file="../parts/ContentsHeader.jsp"%>
<%@ include file="../parts/ContentsSidebar.jsp"%>

<script type="text/javascript">
<!--
  function joinDate(){
    var thisForm = document.forms[0];
    var sDate = thisForm.fromYear.value + thisForm.fromMonth.value + thisForm.fromDay.value;
    var eDate = thisForm.toYear.value + thisForm.toMonth.value + thisForm.toDay.value;
    thisForm.sendDtFrom.value = sDate;
    thisForm.sendDtTo.value = eDate;
    //alert(sDate + "-" + eDate);
  }

 function page(offSet){
    document.forms[0].offSet.value=offSet;
    joinDate();
    _submit('ReviewBukkenAlertCountPaging.do');
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
<!-- 警告対象条件 -->
<p class="section_header">店舗情報から検索</p>

<html:form action="review/ReviewBukkenAlertCount.do" onsubmit="joinDate();"  method="get">
<table class="type_searchbox">
  <tr>
    <td>店舗コード</td>
    <td>
      <input type="text" name="shopCd" size="9" maxlength="9" value="${view.shopCd}"> &nbsp;
        会社名/事務所名
      <input type="text" name="companyBumon" size="40" maxlength="400" value="${fn:escapeXml(view.companyBumon)}">
    </td>
  </tr>
  <tr>
    <td>都道府県</td>
    <td><chintai:Todofuken name="prefCd" fixValue="${view.prefCd}"/></td>
  </tr>
</table>

<p class="section_header">審査情報から検索</p>
<table class="type_searchbox">
  <tr>
    <td>警告日</td>
    <td>
      <chintai:DateTag name="fromYear"  type="year"  fixValue="${view.fromYear}"/>年
      <chintai:DateTag name="fromMonth" type="month" fixValue="${view.fromMonth}"/>月
      <chintai:DateTag name="fromDay"   type="day"   fixValue="${view.fromDay}"/>日
      &nbsp;～&nbsp;
      <chintai:DateTag name="toYear"    type="year"  fixValue="${view.toYear}"/>年
      <chintai:DateTag name="toMonth"   type="month" fixValue="${view.toMonth}"/>月
      <chintai:DateTag name="toDay"     type="day"   fixValue="${view.toDay}"/>日
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <label>
        <c:choose>
          <c:when test="${view.warningCd0 eq '0' or view.warningCd0 eq '0'}">
            <input type="checkbox" name="warningCd0" value="0" checked />
          </c:when>
          <c:otherwise>
            <input type="checkbox" name="warningCd0" value="0"/>
          </c:otherwise>
        </c:choose>
        平均家賃基準該当物件
      </label>
      <label>
        <c:choose>
          <c:when test="${view.warningCd1 eq '1' or view.warningCd1 eq '1'}">
            <input type="checkbox" name="warningCd1" value="1" checked />
          </c:when>
          <c:otherwise>
            <input type="checkbox" name="warningCd1" value="1"/>
          </c:otherwise>
        </c:choose>
        連続掲載該当物件
      </label>
      <label>
        <c:choose>
          <c:when test="${view.warningCd2 eq '2' or view.warningCd2 eq '2'}">
            <input type="checkbox" name="warningCd2" value="2" checked />
          </c:when>
          <c:otherwise>
            <input type="checkbox" name="warningCd2" value="2"/>
          </c:otherwise>
        </c:choose>
        連続掲載かつ問合せ数該当物件
      </label>
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
                              nameKey="WEB_BUKKEN_ALERT_COUNT_SORT_NAME"
                              valueKey="WEB_BUKKEN_ALERT_COUNT_SORT_VALUE"
                              fixValue="${view.sortKey}"/>
      順序
      <chintai:PropertyOptions name="orderBy"
                              nameKey="WEB_ORDER_BY_NAME"
                              valueKey="WEB_ORDER_BY_VALUE"
                              fixValue="${view.orderBy}"/>
    </td>
    <td>
      出力先
      <chintai:PropertyOptions name="outPut"
                              nameKey="DISPLAY_TYPE_NAME"
                              valueKey="DISPLAY_TYPE_VALUE"
                              fixValue="${view.outPut}"/>
    </td>
  </tr>
</table>
<br>
<p>
  <input type="hidden" name="sendDtFrom" />
  <input type="hidden" name="sendDtTo" />
  <input type="hidden" name="offSet"/>
  <input type="submit" value="検索"" />
  <input type="reset" value="クリア">
</p>
</html:form>
<!-- 集計結果 -->
<c:if test="${not empty view.bukkenAlertList}">
<c:set var="helper" value="${view}"/>
<p class="section_header">集計結果</p>
<%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
<%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
<table class="type_list_nomargin">
  <tr>
    <th>警告日</th>
    <th>店舗コード<br>状態（店舗ステータス）</th>
    <th>会社名<br>事務所名</th>
    <th>CHINTAI掲載<br>エイブル掲載<br>連動元</th>
    <th>管理コード<br>状態（WEB審査区分）</th>
    <th>警告内容</th>
  </tr>
  <c:forEach items="${view.bukkenAlertList}" var="alertList">
    <tr>
      <td><label><c:out value="${alertList.warningDt}" /></label></td>
      <td>
        <label><c:out value="${alertList.shopCd}" /><br>
          <chintai:CodePrint code="${alertList.shopStatus}" nameKey="WEB_SHOP_STATUS_NAME" valueKey="WEB_SHOP_STATUS_VALUE"/>
        </label>
      </td>
      <td class="left"><label><c:out value="${alertList.company}" /><br><c:out value="${alertList.bumon}" /></label></td>
        <td>
          <label>
            <chintai:CodePrint nameKey="SHOPBUKKEN_CT_FLG_NAME" valueKey="SHOPBUKKEN_CT_FLG_VALUE" code="${alertList.ctStatus}"/><br>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ABL_FLG_NAME" valueKey="SHOPBUKKEN_ABL_FLG_VALUE" code="${alertList.ablStatus}"/><br>
            <c:out value="${alertList.rendoName}" />
          </label>
        </td>
        <td>
          <label>
            <c:out value="${alertList.shopCd}" />-<c:out value="${alertList.bkCd}" />-<c:out value="${alertList.roomCd}" /><br>
            <chintai:CodePrint code="${alertList.statusKbn}" nameKey="WEB_STATUS_KBN_NAME" valueKey="WEB_STATUS_KBN_VALUE"/>
          </label>
        </td>
        <td><label><c:out value="${alertList.warningName}" /></label></td>
      </tr>
    </c:forEach>
  </table>
<%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
</c:if>
</div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>
