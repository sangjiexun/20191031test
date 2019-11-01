<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<%@ include file="../parts/ContentsImport.jsp"%>
<c:set var="title" value="不動産会社詳細" />
<c:set var="view" value="${FudousanInfoView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp"%>

<script type="text/javascript">
<!--
function page(offSet){
  document.forms[0].offSet.value = offSet;
  _submit('FudousanInfoPaging.do');
}
-->
</script>

<div id="main">
<%@ include	file="../parts/PopUpContentsHeadline.jsp"%>
  <div class="popup_layout">
    <div class="topic_path">${title}</div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id="msg" message="true" header="info.header" footer="info.footer">
	  <c:out value="${msg}" />
    </html:messages>

    <p class="section_header">不動産会社情報</p>
    <p>
      <html:link action="/demand/FudousanUpdatePage.do">
        <html:param name="fudousanCd" value="${view.fudousanCd}" />
        <html:param name="offSet" value="${view.offSet}" />
        &gt;&gt;不動産会社情報を変更する
      </html:link>
    </p>
    <table class="type_detail">
	<colgroup>
		<col span="1" width="20%" class="type_detail_head">
		<col span="1" width="30%" class="type_detail_body">
		<col span="1" width="20%" class="type_detail_head">
		<col span="1" width="30%" class="type_detail_body">
	</colgroup>
	<tr>
		<th>不動産会社名</th>
		<td><c:out value="${view.fudousanName}" /></td>
		<th>不動産会社コード</th>
		<td><c:out value="${view.fudousanCd}" /></td>
	</tr>
	<tr>
		<th rowspan="4">住所</th>
		<td colspan="3"><c:choose>
			<c:when test="${not empty view.zipCode1}">
              〒<c:out value="${view.zipCode1}" />-<c:out value="${view.zipCode2}" />
            </c:when>
			<c:otherwise>
              &nbsp;
            </c:otherwise>
		</c:choose></td>
	</tr>
	<tr>
		<td colspan="3"><c:out value="${view.prefName}" />&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3"><c:out value="${view.address1}" />&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3"><c:out value="${view.address2}" />&nbsp;</td>
	</tr>
	<tr>
		<th>電話番号</th>
		<td><c:out value="${view.tel}" /></td>
		<th>FAX番号</th>
		<td><c:out value="${view.fax}" /></td>
	</tr>
	<tr>
		<th>担当者名</th>
		<td colspan="3"><c:out value="${view.tantou}" /></td>
	</tr>
	<tr>
		<th>登録日</th>
		<td><c:out value="${view.insDt}" /></td>
		<th>更新日</th>
		<td><c:out value="${view.updDt}" /></td>
	</tr>
    </table>

    <html:form action="/demand/FudousanInfoPaging.do" method="get">
    <input type="hidden" name="fudousanCd" value="${view.fudousanCd}">
    <input type="hidden" name="offSet" value="${view.offset}">
      <c:if test="${not empty view.detailList}">
    	<c:set var="helper" value="${view}" />
    	<p class="section_header">取引先情報</p>
    	<%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp"%>
    	<%@ include file="/WEB-INF/jsp/parts/Pager.jsp"%>
    	<table class="type_list">
    	  <colgroup>
    		<col width="20%" />
    		<col width="40%" />
    		<col width="40%" />
    	  </colgroup>
    	  <tr>
	    	<th>取引先コード</th>
    		<th>取引先名</th>
	    	<th>住所</th>
	      </tr>
	    <c:forEach items="${view.detailList}" var="detail">
		  <tr>
			<td><html:link action="demand/TorihikisakiInfoForList.do"
				paramId="torihikisakiSeq" paramName="detail" paramProperty="torihikisakiSeq" target="_blank">${detail.torihikisakiCd1}-${detail.torihikisakiCd2}</html:link></td>
			<td align="left"><c:out value="${detail.torihikisakiName}" /></td>
			<td align="left"><c:out value="${detail.prefName}" /><c:out value="${detail.address1}" /><c:out value="${detail.address2}" /></td>
		  </tr>
		</c:forEach>
	    </table>
	  <%@ include file="/WEB-INF/jsp/parts/Pager.jsp"%>
    </c:if>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>