<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="入稿履歴一覧" />
<c:set var="view"  value="${BukkenRirekiInfoView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      ${title}
    </div>
    <h1>${title}</h1>
    <p class="section_header">${title}</p>
    <table class="type_list">
    <!--
	  <colgroup>
        <col width="8%">
        <col width="5%">
        <col width="8%">
        <col width="8%">
        <col width="8%">
        <col width="8%">
        <col width="8%">
        <col width="8%">
        <col width="5%">
        <col width="5%">
        <col width="6%">
        <col width="6%">
        <col width="17%">

      </colgroup>
 -->


      <tr>
        <th rowspan="2">物件履歴連番</th>
        <th rowspan="2">入稿登録<br>日時</th>
        <th rowspan="2">入稿状況</th>
        <th rowspan="2">フロント反映状況</th>
        <th rowspan="2">CHINTAI<br>フロント配信結果</th>
        <th rowspan="2">エイブル<br>フロント配信結果</th>
        <th rowspan="2">システム分類</th>
        <th rowspan="2">登録機能</th>
        <th rowspan="2">部屋止め<br>フラグ</th>
        <th rowspan="2">部屋状況</th>
        <th rowspan="2">取引</th>
        <th rowspan="2">取引形態</th>
        <c:if test="${not empty view.imgCategoryList}"><th colspan="${ fn:length(view.imgCategoryList) }">写真枚数(掲載枚数/出稿枚数)</th></c:if>
        <th rowspan="2">座標情報</th>
      </tr>
      <tr>
		<c:forEach items="${view.imgCategoryList}" var="imgCategoryName"><th><c:out value="${imgCategoryName}" /></th></c:forEach>
      </tr>

      <c:forEach items="${view.detailList}" var="detail">
      <tr>
        <td ><c:out value="${detail.pkBukkenRireki}"/></td>
        <td ><c:out value="${detail.insDt}" /></td>
        <td ><c:if test="${detail.isNyukoSystem == 'true'}"><chintai:CodePrint code="${detail.insKbn}" nameKey="INS_KBN_NAME" valueKey="INS_KBN_VALUE" /></c:if></td>
        <td >
        	<c:choose>
              <c:when test="${(detail.recSendStatus eq '10' or detail.recSendStatus eq '11') and not empty detail.imgBaseDt}">
                画像同期待ち
              </c:when>
              <c:otherwise>
                <chintai:CodePrint nameKey="REC_SEND_STATUS_NAME" valueKey="REC_SEND_STATUS_VALUE" code="${detail.recSendStatus}" />
              </c:otherwise>
            </c:choose>
        </td>
        <td ><chintai:CodePrint code="${detail.ctFrontSendResultKbn}" nameKey="CT_FRONT_SEND_RESULT_KBN_NAME" valueKey="CT_FRONT_SEND_RESULT_KBN_VALUE" /> </td>
        <td ><chintai:CodePrint code="${detail.ablFrontSendResultKbn}" nameKey="ABL_FRONT_SEND_RESULT_KBN_NAME" valueKey="ABL_FRONT_SEND_RESULT_KBN_VALUE" /> </td>
		<td ><c:out value="${detail.categoryName}"/></td>
		<td ><c:out value="${detail.systemName}"/></td>
        <td ><chintai:CodePrint code="${detail.heyadomeKbn}" nameKey="HEYADOME_KBN_NAME" valueKey="HEYADOME_KBN_VALUE" /></td>
        <td style="text-align: left;"><c:out value="${detail.heyaJokyo}"></c:out> </td>
        <td >${detail.torihiki}</td>
        <td ><chintai:CodePrint code="${detail.torihikiKeitai}" nameKey="WEB_TORIHIKI_NAME" valueKey="WEB_TORIHIKI_VALUE"/></td>

        <c:forEach items="${detail.imgCategoryCntList}" var="imgCategoryCnt">
        	<td ><c:out value="${imgCategoryCnt}"/></td>
        </c:forEach>

        <td >
          <c:choose>
            <c:when test="${not empty detail.locY and not empty detail.locX}">
              付与済
            </c:when>
            <c:otherwise>
              －
            </c:otherwise>
          </c:choose>
        </td>

      </tr>
      </c:forEach>
    </table>

    <p class="section_header">CSV出力する物件属性を選択</p>

    <form action="BukkenRirekiInfoCsvDownloadAction.do" method="get" name="bukkenRirekiInfoCsvDownloadForm">
      <table class="type_searchbox">
      <colgroup>
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
      </colgroup>

     	<c:forEach items="${view.tableMap}" var="table" varStatus="status">
	     	<c:if test="${status.index == 0 || status.index == 8}"><tr></c:if>
	          <td><label><input type="checkbox" name="tableNo" value="${table.key}" />&nbsp;<c:out value="${table.value}"/></label></td>
	          <c:if test="${status.index == 12}"><td></td><td></td><td></td></c:if>
	          <c:if test="${status.index == 15}"><td></td><td></td><td></td><td></td><td></td></c:if>
	        <c:if test="${status.index == 7 || status.index == 12 || status.last}"></tr></c:if>
        </c:forEach>
        <input type="hidden" name="roomKey" value="${param.roomKey}">
      </table>
      <p style="text-align: right;">
        <input type="submit" value="CSVをダウンロードする" >
      </p>
    </form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
