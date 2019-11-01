<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="ADデータアップロード" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>



<c:set var="view" value="${AdDataUploadView}" />

<script src="${pageContext.request.contextPath}/dwr/interface/AdDataMatchingManager.js"></script>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>

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

    <p class="section_header">ADデータアップロード</p>
    <html:form action="/addata_matching/AdDataUpload.do" method="post" enctype="multipart/form-data" >
      <input type="hidden" name="displayFlg" value="">
      <p>
        <chintai:DateTag name="uploadYear" type="year" fixValue="${view.uploadYear}" required="true" startYear="2009"/>年
      	<chintai:DateTag name="uploadMonth" type="month" fixValue="${view.uploadMonth}" required="true"/>月
	   </p>
	<p>
      <input type="file" name="fileUp" size="50">
    </p>
    <span class="caution">*アップロードCSVファイルの１行目は、ヘッダーとして扱い、２行目からデータが登録されます。</br>
   					      *既に対象年月のADデータが登録されている場合は、全件入れ替えとなります。
    </span>
    <p>
      <input type="button" value="アップロード" name="aploadbtn" onclick="chechTaisyoYm();">
    </p>
    </html:form>
  </div>
</div>
<script type="text/javascript">
<!--//
window.onload = function() {
	document.forms[0].aploadbtn.disabled = false;
}

function chechTaisyoYm(){
    var thisForm = document.forms[0];
	var taisyoYm = thisForm.uploadYear.value + thisForm.uploadMonth.value;

	thisForm.aploadbtn.disabled = true;
	AdDataMatchingManager.countMonthyAdData(taisyoYm, doValidate);
}

function doValidate(cnt){
	var thisForm = document.forms[0];
	if (cnt == '0') {
		thisForm.submit();
	}
	else {
		if((confirm(" 対象年月のADデータが既に登録されています。再アップロードしますか？"))){
			thisForm.submit();
		}
		else {
			thisForm.aploadbtn.disabled = false;
		}
	}

}
//-->
</script>
<%@ include file="../parts/ContentsFooter.jsp" %>
