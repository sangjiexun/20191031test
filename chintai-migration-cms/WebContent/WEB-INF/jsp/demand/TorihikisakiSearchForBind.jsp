<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="取引先検索" />
<c:set var="view"  value="${TorihikisakiSearchForBindView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--
function setTorihikisakiInfo(fudousanCd,torihikisakiCd,fudousanName,torihikisakiName,torihikisakiSeq){
  //alert(torihikisakiSeq+"-"+updDt);
  if (opener && !opener.closed) {
    opener.document.getElementById('torihikisakiCd').value = fudousanCd + "-" + torihikisakiCd;
    opener.document.getElementById('torihikisakiName').value = fudousanName + torihikisakiName;
    opener.document.getElementById('torihikisakiSeq').value = torihikisakiSeq;
  }
  self.close();
}

function page(offSet){
  document.forms[0].offSet.value = offSet;
  _submit('TorihikisakiSearchForBindPaging.do');

}

addEvent('load', window, function(){document.getElementsByName('shisyaCd')[0].focus();});
-->
</script>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="msg"/>
    </html:messages>

    <p class="section_header">検索条件</p>
    <html:form action="demand/TorihikisakiSearchForBind" method="get">
      <table class="type_searchbox">
        <tr>
          <td>担当支社</td>
          <td>
            <chintai:ShisyaInfo name="shisyaCd" fixValue="${view.shisyaCd}"/>
          </td>
        </tr>
        <tr>
          <td>取引先コード</td>
          <td>
            <input type="text" name="torihikisakiCd1" maxlength="5" size="6" value="${view.torihikisakiCd1}">
            &nbsp;－&nbsp;
            <input type="text" name="torihikisakiCd2" maxlength="4" size="5" value="${view.torihikisakiCd2}">
          </td>
        </tr>
        <tr>
          <td>不動産会社名</td>
          <td><input type="text" name="fudousanName" maxlength="30" size="30" value="${fn:escapeXml(view.fudousanName)}"></td>
        </tr>
        <tr>
          <td>取引先名</td>
          <td><input type="text" name="torihikisakiName" maxlength="60" size="50" value="${fn:escapeXml(view.torihikisakiName)}"></td>
        </tr>
      </table>
      <p>
        <input type="hidden" name="shopCd" value="${view.shopCd}">
        <input type="hidden" name="offSet" value="">
        <input type="submit" value="検索">
        <input type="reset" value="クリア">
      </p>
    </html:form>
    <c:if test="${not empty view.detailList}">
    <c:set var="helper" value="${view}"/>
      <p class="section_header">検索結果</p>
      <%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
      <table class="type_list">
        <colgroup>
          <col span="1" width="12%">
          <col span="1" width="25%">
          <col span="1" width="28%">
          <col span="1" width="30%">
          <col span="1" width="5%">
        </colgroup>
        <tr>
          <th>取引先コード</th>
          <th>不動産会社名</th>
          <th>取引先名</th>
          <th>住所</th>
          <th>選択</th>
        </tr>
        <c:forEach items="${view.detailList}" var="detail">
          <tr>
            <c:set var="torihikisakiCd" value="${detail.torihikisakiCd1}-${detail.torihikisakiCd2}"></c:set>
            <td>
              <html:link action="demand/TorihikisakiInfoForBind.do" paramId="torihikisakiSeq" paramName="detail" paramProperty="torihikisakiSeq">
                <c:out value="${detail.torihikisakiCd1}" />-<c:out value="${detail.torihikisakiCd2}" />
              </html:link>
            </td>
            <td align="left"><c:out value="${detail.fudousanName}" /></td>
            <td align="left"><c:out value="${detail.torihikisakiName}" /></td>
            <td align="left"><c:out value="${detail.prefName}" /><c:out value="${detail.address1}" /><c:out value="${detail.address2}" /></td>
            <td>
              <input type="button" value="選択"
                     onClick="setTorihikisakiInfo('${detail.torihikisakiCd1}','${detail.torihikisakiCd2}',
                                                '${detail.fudousanName}','${detail.torihikisakiName}',
                                                '${detail.torihikisakiSeq}','${detail.updDt}');">
            </td>
          </tr>
        </c:forEach>
      </table>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    </c:if>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
