<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗コード紐付" />
<c:set var="view"  value="${ShopBindSearchView}" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<script type="text/javascript">
<!--
 function page(offSet){
    document.forms[0].offSet.value  = offSet;
    _submit('ShopBindSearchPaging.do');
 }

 addEvent('load', window, function(){document.getElementsByName('shopCd')[0].focus();});
-->
</script>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link>&gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <!-- 検索フォーム -->
    <p class="section_header">検索条件</p>
    <html:form action="demand/ShopBindSearch.do" method="get">
      <table class="type_searchbox">
        <tr>
          <td>店舗コード</td>
          <td colspan="2">
            <input type="text" name="shopCd" maxlength="9" size="10" value="${view.shopCd}">
          </td>
        </tr>
        <tr>
          <td>会社名</td>
          <td>
            <input type="text" name="company" maxlength="30" size="30" value="${fn:escapeXml(view.company)}">
          </td>
        </tr>
        <tr>
          <td>事務所名</td>
          <td>
            <input type="text" name="bumon" maxlength="30" size="30" value="${fn:escapeXml(view.bumon)}">
          </td>
        </tr>
      </table>
      <p>
        <input type="hidden" name="offSet" value="">
        <input type="submit" value="検索">
        <input type="reset"  value="クリア">
      </p>
    </html:form>

    <!-- 検索結果 -->
    <c:if test="${not empty view.detailList}">
    <c:set var="helper" value="${view}"/>
      <p class="section_header">検索結果</p>
      <%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
      <table class="type_list">
        <colgroup>
          <col width="10%"/>
          <col width="30%"/>
          <col width="20%"/>
          <col width="15%"/>
          <col width="25%"/>
        </colgroup>
        <tr>
          <th rowspan="2">店舗コード</th>
          <th rowspan="2">会社名</th>
          <th rowspan="2">事務所名</th>
          <th colspan="2">紐付先</th>
        </tr>
        <tr>
          <th >取引先コード</th>
          <th >取引先名</th>
        </tr>
        <c:forEach items="${view.detailList}" var="detail">
          <tr>
            <td>
              <html:link action="demand/ShopBindUpdatePage" paramId="shopCd" paramName="detail" paramProperty="shopCd" target="_blank">
                <c:out value="${detail.shopCd}" />
              </html:link>
            </td>
            <td align="left"><c:out value="${detail.company}" /></td>
            <td align="left"><c:out value="${detail.bumon}" /></td>
            <td><c:out value="${detail.fudousanCd}" />-<c:out value="${detail.torihikisakiCd}" /></td>
            <td align="left"><c:out value="${detail.fudousanName}" /><c:out value="${detail.torihikisakiName}" /></td>
        </tr>
        </c:forEach>
      </table>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    </c:if>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
