<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<%@ include file="../parts/ContentsImport.jsp"%>
<c:set var="view" value="${RendoSendUpdateView}" />
<c:choose>
  <c:when test="${view.procKbn == 'delete'}"> <c:set var="procName" value="削除"/> </c:when>
  <c:when test="${view.procKbn == 'update'}"> <c:set var="procName" value="更新"/> </c:when>
  <c:when test="${view.procKbn == 'insert'}"> <c:set var="procName" value="登録"/> </c:when>
</c:choose>
<c:set var="title" value="${view.keiyakuName}${procName}確認" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp"%>
<script type="text/javascript">
</script>
<style>
table th {
	text-align: left;
}
</style>
<div id="main">
  <%@ include file="../parts/PopUpContentsHeadline.jsp"%>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/master/RendoSendList.do">連動元別出稿管理 </html:link>&gt;
      <html:link action="/master/RendoSendInfo.do">
        <html:param name="rendoCd" value="${view.rendoCd}" />
        <html:param name="keiyakuCd" value="${view.keiyakuCd}" />
        <html:param name="keiyakuSubCd" value="${view.keiyakuSubCd}" />${view.keiyakuName}情報
      </html:link>&gt; ${view.keiyakuName}${procName}確認
    </div>
    <h1>${view.keiyakuName}${procName}確認</h1>
    <html:errors />
    <html:messages id="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}" />
    </html:messages>
    <p class="section_header">連動元コード</p>
    <table class="type_detail_pre">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>連動元コード</th>
        <td>
          <c:out value="${view.rendoCd}" />
        </td>
      </tr>
      <tr>
        <th>連動元名称</th>
        <td>
          <c:out value="${view.rendoName}" />
        </td>
      </tr>
      <tr>
        <th>連動元会社名</th>
        <td>
          <c:out value="${view.rendoCompany}" />
        </td>
      </tr>
    </table>
    <!--${keiyakuName}設定情報-->
    <p class="section_header">${view.keiyakuName}情報</p>
    <table class="type_detail_pre">
      <colgroup>
        <col span="1" width="20%" class="type_detail_head">
        <col span="1" width="80%" class="type_detail_body">
      </colgroup>
      <tr>
        <th>出稿許可期間</th>
        <td>
          <c:out value="${view.permitStartDtForDisplay}" />&nbsp;～
          <c:if test="${!empty view.permitEndDt}">
            <c:out value="${view.permitEndDtForDisplay}" />
          </c:if>
        </td>
      </tr>
      <tr>
        <th>備考</th>
        <td>
          <chintai:filter filter="false" changeNL2BR="true"><c:out value="${view.note}" /></chintai:filter>
        </td>
      </tr>
    </table>
    <html:form action="/master/RendoSendUpdateCommit.do" onsubmit="disableSubmit(this);">
      <div class="add_from">
        <input type="hidden" name="rendoCd" value="${view.rendoCd}">
        <input type="hidden" name="keiyakuCd" value="${view.keiyakuCd}">
        <input type="hidden" name="keiyakuSubCd" value="${view.keiyakuSubCd}">
        <input type="hidden" name="note" value="${view.note}">
        <input type="hidden" name="rendoSendNo" value="${view.rendoSendNo}">
        <input type="hidden" name="permitStartDt" value="${view.permitStartDt}">
        <input type="hidden" name="permitEndDt" value="${view.permitEndDt}">
        <input type="hidden" name="procKbn" value="${view.procKbn}">
        <input type="hidden" name="repeatFlg" value="1">
        <input type="submit" value="${procName}">
        <c:choose>
          <c:when test="${view.procKbn == 'delete'}">
            <input type="button" name="backButton" value="戻る" onclick="_submit('RendoSendInfo.do?rendoCd=${view.rendoCd}&keiyakuCd=${view.keiyakuCd}&keiyakuSubCd=${view.keiyakuSubCd}')">
          </c:when>
          <c:otherwise>
            <input type="button" name="backButton" value="戻る" onclick="_submit('RendoSendUpdatePage.do')">
          </c:otherwise>
        </c:choose>
      </div>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>