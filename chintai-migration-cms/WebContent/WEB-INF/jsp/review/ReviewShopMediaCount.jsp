<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<%@ include file="../parts/ContentsImport.jsp"%>
<c:set var="title" value="店舗別出稿状況集計" />
<c:set var="view" value="${ReviewShopMediaCountView}"/>
<%@ include file="../parts/ContentsHeader.jsp"%>
<%@ include file="../parts/ContentsSidebar.jsp"%>
<script type="text/javascript">
<!--
 function page(offSet){
   document.forms[0].offSet.value=offSet;
   _submit('ReviewShopMediaCountPaging.do');
 }

 addEvent('load', window, function(){document.getElementsByName('sumYmdFromYear')[0].focus();});
-->
</script>
<div id="main"><%@ include file="../parts/ContentsHeadline.jsp"%>
<div class="main_layout">
<div class="topic_path">
  <html:link action="/Index.do">トップページ </html:link>&gt;
  ${title}
</div>
<h1>${title}</h1>
<html:errors />
<html:messages id ="msg" message="true" header="info.header" footer="info.footer">
  <c:out value="${msg}" />
</html:messages>
<p class="section_header">${title}</p>
<html:form action="/review/ReviewShopMediaCount"  method="get">
  <p class="caution">開始年月より12ヶ月間が集計対象となります。</p>
  <table class="type_searchbox">
    <tr>
      <td>開始年月</td>
      <td>
        <chintai:DateTag name="sumYmdFromYear" type="year" todayFix="true" fixValue="${param.sumYmdFromYear}" />年
        <chintai:DateTag name="sumYmdFromMonth" type="month" todayFix="true" fixValue="${param.sumYmdFromMonth}" />月
      </td>
    </tr>
    <tr>
      <td>店舗コード</td>
      <td>
        <input name="shopCd" type="text" size="9" maxlength="9" value="${param.shopCd}">&nbsp;&nbsp;
        会社名/事務所名
        <input name="companyBumon" type="text" size="40" maxlength="400" value="${fn:escapeXml(param.companyBumon)}">
      </td>
    </tr>
    <tr>
      <td>都道府県</td>
      <td>
        <chintai:Todofuken name="prefCd" fixValue="${param.prefCd}"/> &nbsp;
        出力先
        <chintai:PropertyOptions name="outPut" nameKey="DISPLAY_TYPE_NAME" valueKey="DISPLAY_TYPE_VALUE" fixValue="${param.outPut}"/>
      </td>
    </tr>
  </table>
  <input type="hidden" name="offSet"/>
  <p><input type="submit" value="集計"></p>
</html:form>
<!-- 集計結果 -->
<c:if test="${not empty view.cntTime}">
<p class="section_header">集計結果（${view.cntTime}時点）</p>
</c:if>
<c:if test="${view.shopMediaCntList != null}">
<c:set var="helper" value="${view}"/>
<%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
<%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
<div class="pager">単位：件</div>
  <table class="type_list">
    <tr>
      <th>店舗<br>
      コード</th>
      <th>会社名<br>
      事務所名</th>
      <th colspan="2">種別</th>
      <c:forEach items="${view.dateList}" var="date">
        <th align="center"><label>${date}</label></th>
      </c:forEach>
    </tr>

    <c:forEach items="${view.shopMediaCntList}" var="cntList" >
      <tr>
        <td rowspan="5"><label>${cntList.shopCd}</label></td>
        <td rowspan="5" class="left">
          <label><c:out value="${cntList.company}" /></label>
          <c:if test="${not empty cntList.bumon}">
            <br><label><c:out value="${cntList.bumon}" /></label>
          </c:if>
        </td>
        <td rowspan="3">初回</td>
        <td class="left">警告対象</td>
        <c:forEach items="${cntList.syokaiCntList}" var="syokaiCnt">
          <td class="right"><label><c:out value="${syokaiCnt}" /></label></td>
        </c:forEach>
      </tr>
      <tr>
        <td class="left">警告対象外</td>
        <c:forEach items="${cntList.syokaiSkipList}" var="syokaiSkipCnt">
          <td class="right"><label><c:out value="${syokaiSkipCnt}" /></label></td>
        </c:forEach>
      </tr>
      <tr>
        <td class="left">停止</td>
        <c:forEach items="${cntList.syokaiAutoDelList}" var="syokaiDelCnt">
          <td class="right"><label><c:out value="${syokaiDelCnt}" /></label></td>
        </c:forEach>
      <tr>
        <td rowspan="2">定期</td>
        <td class="left">警告対象</td>
        <c:forEach items="${cntList.teikiCntList}" var="tCntList">
          <td class="right"><label><c:out value="${tCntList}" /></label></td>
        </c:forEach>
      </tr>
      <tr>
        <td class="left">停止</td>
        <c:forEach items="${cntList.teikiAutoDelList}" var="tAutoDelList">
        <td class="right"><label><c:out value="${tAutoDelList}" /></label></td>
        </c:forEach>
      </tr>
    </c:forEach>
  </table>
  <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
</c:if>
</div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>