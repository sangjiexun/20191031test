<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<%@ include file="../parts/ContentsImport.jsp"%>
<c:set var="title" value="連動元別出稿管理" />
<c:set var="view" value="${RendoSendListView}" />
<%@ include file="../parts/ContentsHeader.jsp"%>
<%@ include file="../parts/ContentsSidebar.jsp"%>
<%@ page import="java.util.*"%>
<div id="main">
  <%@ include file="../parts/ContentsHeadline.jsp"%>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link>&gt; ${title}
    </div>
    <h1>${title}</h1>
    <html:messages id="msg" header="info.header" footer="info.footer" message="true">
      <c:out value="${msg}"></c:out>
    </html:messages>
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />
    <p class="section_header">連動元一覧</p>
    <table id="rendo_table" class="type_list">
      <tr>
        <th>連動元コード</th>
        <th>連動元</th>
        <th>連動会社名</th>
        <c:forEach items="${RendoSendListView.keiyakuNameMap}" var="keiyaku">
          <th nowrap>${keiyaku.value}</th>
        </c:forEach>
      </tr>
      <c:forEach items="${RendoSendListView.rendoSendDetailMap}" var="rendo">
        <tr>
          <td nowrap>${rendo.key}</td>
          <td nowrap>${rendo.value.rendoName}</td>
          <td nowrap>${rendo.value.rendoCompany}</td>
          <c:forEach items="${rendo.value.permitInfoMap}" var="keiyaku">
            <td nowrap>
              <a href="#" onclick="clickProc('${rendo.key}', '${keiyaku.key}')">
                <c:choose>
                  <c:when test="${keiyaku.value[0] == '1'}">■ 許可 (予約数:${keiyaku.value[1]}件)</c:when>
                  <c:otherwise>□不許可(予約数:${keiyaku.value[1]}件)</c:otherwise>
                </c:choose>
              </a>
            </td>
          </c:forEach>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
<script>
function clickProc(rendoCd, keiyakuJoinCd){
	window.open("RendoSendInfo.do?rendoCd=" + rendoCd + "&keiyakuCd=" + keiyakuJoinCd.substr(0,5) + "&keiyakuSubCd=" + keiyakuJoinCd.substr(5,7));
};
// 表の列サイズ調整
function loadProc() {
	var table = document.getElementById("rendo_table");
	var clmMax = table.rows[0].cells.length;
	var colWidth = ["8%","21%","21%"];
	var colgroup = document.createElement("colgroup");
	for (var i = 1; i < clmMax; i++) {
		var col = document.createElement('col');
		if (i <= colWidth.length) {
			col.width = colWidth[i - 1];
		} else {
			col.width = (50 / (clmMax - colWidth.length)) + "%";
		}
		colgroup.appendChild(col);
	}
	table.appendChild(colgroup);
}
addEvent('load', window, loadProc);
</script>