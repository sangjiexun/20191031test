<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="照合結果ダウンロード" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>


<!-- メイン -->
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">照合結果ダウンロード</p>

    <html:form action="/addata_matching/MatchingDataDownloadPaging.do" method="get">
    	<input type="hidden" name="offSet" value=""/>

    </html:form>

    	<c:if test="${not empty MatchingDataListView.matchingDataList}">
    		<c:set var="helper" value="${MatchingDataListView}"/>

    		<%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
    		<%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
			<table class="type_list">
        		<colgroup>
          			<col width="40%">
          			<col width="40%">
          			<col width="20%">
        		</colgroup>
        		<tr>
          			<th>対象年月</th>
          			<th>処理日</th>
          			<th></th>
        		</tr>
        		<c:forEach items="${MatchingDataListView.matchingDataList}" var="matchingDataList" varStatus="i">
          			<tr>
            			<td>
            				<fmt:parseDate value="${matchingDataList.taisyoYm}" var="taisyoYm" pattern="yyyyMM"/>
        					<fmt:formatDate  value="${taisyoYm}" pattern="yyyy年MM月" />
            			</td>
            			<td>
            				<c:out value="${matchingDataList.insDt}"/>
            			</td>
            			<td>
            				<c:set var="createURL1" value="/addata_matching/MatchingDataDownload.do?taisyoYm=" />
							<c:set var="createURL2" value="${createURL1}${matchingDataList.taisyoYm}" scope="page"/>
							<html:form method="post" action="${createURL2}" >
								<html:submit property="download" value="ダウンロード"/><br />
							</html:form>
            			</td>
            		</tr>
            	</c:forEach>
        	</table>
        	<%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    	</c:if>

  </div>
</div>



<script type="text/javascript">
<!--

function page(offSet){
	document.forms[0].offSet.value = offSet;
	_submit('MatchingDataDownloadPaging.do');
}

//-->
</script>

<%@ include file="../parts/ContentsFooter.jsp" %>
