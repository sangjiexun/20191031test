<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="都道府県別出稿状況集計" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<script type="text/javascript">
  addEvent('load', window, function(){document.getElementsByName('sumYmdFromYear')[0].focus();});
</script>
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ </html:link>&gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <p class="section_header">都道府県別出稿状況集計</p>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
    <html:form action="/review/ReviewTodofukenMediaCount"  method="get">
    <p class="caution">開始年月より12ヶ月間が集計対象となります。</p>
    <table class="type_searchbox">
      <tr>
        <td>開始年月</td>
        <td>
          <chintai:DateTag name="sumYmdFromYear" type="year" todayFix="true" fixValue="${param.sumYmdFromYear}"/>年&nbsp;
          <chintai:DateTag name="sumYmdFromMonth" type="month" todayFix="true" fixValue="${param.sumYmdFromMonth}"/>月&nbsp;
        </td>
      </tr>
      <tr>
        <td>都道府県</td>
        <td>
          <chintai:Todofuken name="prefCd" fixValue="${param.prefCd}"/>
          &nbsp;出力先
          <chintai:PropertyOptions name="outPut" nameKey="DISPLAY_TYPE_NAME" valueKey="DISPLAY_TYPE_VALUE" fixValue="${param.outPut}"/>
        </td>
      </tr>
    </table>
    <p><input type="submit" value="集計"></p>
    <c:if test="${not empty ReviewTodofukenMediaCountView.cntTime}">
    <p class="section_header">集計結果（<c:out value="${ReviewTodofukenMediaCountView.cntTime}" />時点）</p>
    </c:if>

  <!-- 集計結果 -->
  <c:if test="${not empty ReviewTodofukenMediaCountView.todofukenMediaCntList}">
    <div class="pager">
      単位：件
    </div>

    <table class="type_list">
      <tr>
        <th align="center">都道府県<br>名称</th>
        <th colspan="2">種別</th>
        <c:forEach items="${ReviewTodofukenMediaCountView.dateList}" var="dates">
        <th align="center"><label>${dates}</label></th>
        </c:forEach>
      </tr>
      <c:forEach items="${ReviewTodofukenMediaCountView.todofukenMediaCntList}" var="detailList">
        <tr>
          <td rowspan="5"><c:out value="${detailList.prefName}" /></td>
          <td rowspan="3">初回</td>
          <td class="left">警告対象</td>
          <c:forEach items="${detailList.syokaiShinsaCntList}" var="sCntList">
            <td class="right"><label><c:out value="${sCntList}" /></label></td>
          </c:forEach>
        </tr>
        <tr>
          <td class="left">警告対象外</td>
          <c:forEach items="${detailList.syokaiShinsaSkipList}" var="sSkipList">
            <td class="right"><c:out value="${sSkipList}" /></td>
          </c:forEach>
        </tr>
        <tr>
          <td class="left">停止</td>
          <c:forEach items="${detailList.syokaiAutoDelList}" var="sAutoDelList">
          <td class="right"><c:out value="${sAutoDelList}" /></td>
        </c:forEach>
      </tr>
      <tr>
        <td rowspan="2">定期</td>
        <td class="left">警告対象</td>
        <c:forEach items="${detailList.teikiShinsaList}" var="tCntList">
        <td class="right"><c:out value="${tCntList}" /></td>
        </c:forEach>
      </tr>
      <tr>
        <td class="left">停止</td>
        <c:forEach items="${detailList.teikiAutoDelList}" var="tAutoDelList">
        <td class="right"><c:out value="${tAutoDelList}" /></td>
        </c:forEach>
      </tr>
      </c:forEach>
    </table>
  </c:if>
</div>
</html:form>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
