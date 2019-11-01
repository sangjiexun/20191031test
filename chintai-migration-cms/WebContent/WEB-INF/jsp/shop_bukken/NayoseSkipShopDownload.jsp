<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="名寄せ処理対象外店舗一覧" />

<%@ include file="../parts/ContentsHeader.jsp"%>
<%@ include file="../parts/ContentsSidebar.jsp"%>

<c:set var="view" value="${NayoseSkipShopView}" />


<script type="text/javascript">
<!--
function page(offSet){
    var thisForm = document.forms[0];
    thisForm.offSet.value=offSet;
    _submit('NayoseSkipShopDownloadPage.do');
}

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


<!-- 集計結果 -->

<p class="section_header">対象外店舗一覧</p>

<html:form action="/shop_bukken/NayoseSkipShopDownloadPage.do" method="post" enctype="multipart/form-data" >
	<input type="hidden" name="offSet" value=""/>
</html:form>


<c:if test="${not empty view.nayoseSkipShopList}">
<p align="reft">
	<html:form method="post" action="/shop_bukken/NayoseSkipShopCsvDownload.do" >
		<html:submit property="download" value="ダウンロード"/><br />
	</html:form>
</p>


<c:set var="helper" value="${view}"/>
<%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
<%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>

<table class="type_list_nomargin">
  <tr>
    <th>店舗コード</th>
    <th>会社名<br>事務所名</th>
    <th>登録日</th>
  </tr>


  <c:forEach items="${view.nayoseSkipShopList}" var="list" varStatus="i">
    <tr>
      <td><label><c:out value="${list.shopcd}" /></label></td>
      <td>
		<label><c:out value="${list.company}" /></label><br>
		<label><c:out value="${list.bumon}" /></label>
      </td>
      <td><label><c:out value="${list.insDt}" /></label></td>
      </tr>
  </c:forEach>


</table>
</c:if>


<%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>


</div>
</div>



<%@ include file="../parts/ContentsFooter.jsp"%>
