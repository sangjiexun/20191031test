<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<%@ include file="../parts/ContentsImport.jsp"%>
<c:set var="title" value="店舗別出力設定" />
<%@ include file="../parts/ContentsHeader.jsp"%>
<%@ include file="../parts/ContentsSidebar.jsp"%>

<!-- メイン -->
<div id="main">
	<%@ include file="../parts/ContentsHeadline.jsp"%>
	<div class="main_layout">
		<div class="topic_path">
			<html:link action="/Index">トップページ</html:link>
			&gt;
			<html:link action="/dataoutput/DataoutputIndex">他社データ連携出力設定</html:link>
			&gt; ${title}
		</div>
		<h1>${title}</h1>

		<p id="mess">
			<html:errors />
			<html:messages id="msg" message="true" header="info.header" footer="info.footer">
				<c:out value="${msg}" />
			</html:messages>
		</p>

		<p class="section_header">除外店舗ダウンロード</p>
		<html:form action="/dataoutput/ShopSkipSettingDownload" method="post">
			<table class="type_searchbox">
				<tr>
					<td>連携対象</td>
					<td><select name="dcoType" style="width: 100px" id="dcoType1">
					</select>
				</tr>
			</table>
			<p><input type="button" name="download" id="download" value="ダウンロード" onclick="submitForm(this);"></p>
			<input type="hidden" name="dcoName">
			<input type="hidden" name="procName">
		</html:form>

		<p class="section_header">除外店舗アップロード</p>
		<html:form action="/dataoutput/ShopSkipSettingUpload.do" method="post" enctype="multipart/form-data">
			<table class="type_searchbox">
				<tr>
					<td>連携対象</td>
					<td><select name="dcoType" style="width: 100px" id="dcoType2">
					</select>
				</tr>
			</table>
   			<p><input type="file" name="uploadFile" size="50" ></p>
			<p><input type="button" name="upload" id="upload" value="アップロード" onclick="submitForm(this);"></p>
			<input type="hidden" name="dcoName">
			<input type="hidden" name="procName">
			<input type="hidden" name="acceptFlg" id="acceptFlg">
		</html:form>
	</div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>

<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>
<script src="${pageContext.request.contextPath}/dwr/interface/DcoTypeManager.js"></script>
<fmt:setBundle basename="resources.SystemProperties" var="resource" />
<fmt:message bundle="${resource}" key="SHOP_DCO_TYPE_VALUE" var="dcoTypes" />

<script type="text/javascript">

// ダウンロード、またはアップロード実行時に呼び出される。
function submitForm(buttonObj){
	// メッセージ削除
	var messObj = document.getElementById("mess");
	if (messObj != null) {
		var messObjParent = messObj.parentNode;
		for (var i = messObjParent.childNodes.length - 1; i >= 0; i--) {
			var child = messObjParent.childNodes[i];
			if (child.className == "notify" || child.className == "message") {
				messObjParent.removeChild(child);
				break;
			}
		}
	}
	
	// ダブルクリック防止
	if (buttonObj.name == "upload"){
		document.getElementById("download").disabled = true;
		document.getElementById("upload").disabled = true;
	};
	
	// リクエストパラメータ追加
	var formObj = buttonObj.form;
	formObj.procName.value = buttonObj.name;
	if (formObj.dcoType.selectedIndex > 0) {
		buttonObj.form.dcoName.value = formObj.dcoType.options[formObj.dcoType.selectedIndex].text;
	};
	buttonObj.form.submit();
}

<%
String dcoType = request.getParameter("dcoType");
String procName = request.getParameter("procName");
String acceptFlg = (String)request.getAttribute("acceptFlg");
%>

<!-- ページ読み込み時に実行 -->
function loadProc(){
	DcoTypeManager.getDcoTypeList("${dcoTypes}", function(ret) {
		dwr.util.removeAllOptions("dcoType1");
		dwr.util.removeAllOptions("dcoType2");
		dwr.util.addOptions("dcoType1", ret, "dcoType", "dcoName");
		dwr.util.addOptions("dcoType2", ret, "dcoType", "dcoName");
		if("<%=procName%>" == "download"){
			dwr.util.setValue("dcoType1", "<%=dcoType%>");    	   
		} else if("<%=procName%>" == "upload"){
			dwr.util.setValue("dcoType2", "<%=dcoType%>");
		};
		
		var acceptFlg = document.getElementById("acceptFlg")
		if ("<%=acceptFlg%>" == "0") {
			if (window.confirm("ファイルに更新データが存在しないため、対象の連携先のデータは全て削除されます。本当によろしいですか？")) {
				acceptFlg.value = "1";
				document.getElementById("upload").click();	
			}
		}
		acceptFlg.value = "";
	}); 
};
addEvent('load', window, loadProc);
</script>
