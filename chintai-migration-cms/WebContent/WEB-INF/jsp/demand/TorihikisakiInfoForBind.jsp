<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="取引先詳細" />
<c:set var="view"  value="${TorihikisakiInfoForBindView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--
function setTorihikisakiInfo(fudousanCd,torihikisakiCd,fudousanName,torihikisakiName,torihikisakiSeq){
  //alert(torihikisakiSeq+"-"+updDt);
  try {
    if (opener && !opener.closed) {
      opener.document.getElementById('torihikisakiCd').value = fudousanCd + "-" + torihikisakiCd;
      opener.document.getElementById('torihikisakiName').value = fudousanName + torihikisakiName;
      opener.document.getElementById('torihikisakiSeq').value = torihikisakiSeq;
    }
    self.close();
  } catch(e) {
    self.close();
  }
}

 addEvent('load', window, function(){document.getElementsByName('back')[0].focus();});

-->
</script>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/demand/TorihikisakiSearchForBindPaging.do">取引先検索</html:link>&gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>


    <form name="cumstomerInfoFrm" method="post" action="">
      <table class="type_none" width="100%">
        <tr>
          <td align="left">
           <input type="button" value="選択"
                     onClick="setTorihikisakiInfo('${view.fudousanCd}','${view.torihikisakiCd}',
                                                '${fn:escapeXml(view.fudousanName)}','${fn:escapeXml(view.torihikisakiName)}',
                                                '${view.torihikisakiSeq}','${view.updDt}');">
            <input type="button" name="back" value="戻る" onClick="_submit('TorihikisakiSearchForBindPaging.do')">
          </td>
        </tr>
      </table>
      <p class="section_header">取引先情報</p>
      <table class="type_detail">
        <colgroup>
          <col span="1" width="20%" class="type_detail_head" >
          <col span="1" width="30%" class="type_detail_body" >
          <col span="1" width="20%" class="type_detail_head" >
          <col span="1" width="30%" class="type_detail_body" >
        </colgroup>
        <tr>
          <th>不動産会社名</th>
          <td colspan="3"><c:out value="${view.fudousanName}" /></td>
        </tr>
        <tr>
          <th>取引先名</th>
          <td><c:out value="${view.torihikisakiName}" /></td>
          <th>取引先コード</th>
          <td><c:out value="${view.fudousanCd}" />-<c:out value="${view.torihikisakiCd}" /></td>
        </tr>
        <tr>
          <th rowspan="4">住所</th>
          <td colspan="3">
            <c:if test="${not empty view.zipCd}">
              〒<c:out value="${view.zipCd}"/>
            </c:if>&nbsp;
          </td>
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
          <th>取引担当支社</th>
          <td colspan="3"><c:out value="${view.shisya}" /></td>
        </tr>
        <tr>
          <th>登録日</th>
          <td><c:out value="${view.insDt}" /></td>
          <th>更新日</th>
          <td><c:out value="${view.updDt}" /></td>
        </tr>
      </table>
      <!--物件枠設定情報-->
      <p class="section_header">物件枠設定情報</p>
      <p>※現在適用されている物件枠設定情報は黄色で表示されます。</p>
      <table class="type_list">
        <colgroup>
          <col width="20%">
          <col width="25%">
          <col width="25%">
          <col width="20%">
        </colgroup>
        <tr>
          <th>適用月</th>
          <th>物件枠</th>
          <th>リスティング枠</th>
          <th>更新日</th>
        </tr>
        <c:forEach items="${view.wakuInfoList}" var="detail">
          <c:choose>
            <c:when test="${not empty detail.appliedFlg}">
              <tr bgcolor="FFFF99">
                <td>${detail.startYm}</td>
                <td class="right"><c:out value="${detail.bukkenCnt}" />件</td>
                <td class="right"><c:out value="${detail.tokusenCnt}" />件</td>
                <td class="right"><c:out value="${detail.updDt}" /></td>
              </tr>
            </c:when>
            <c:otherwise>
              <tr>
                <td>${detail.startYm}</td>
                <td class="right"><c:out value="${detail.bukkenCnt}" />件</td>
                <td class="right"><c:out value="${detail.tokusenCnt}" />件</td>
                <td class="right"><c:out value="${detail.updDt}" /></td>
              </tr>
            </c:otherwise>
          </c:choose>
        </c:forEach>
        <c:if test="${empty view.wakuInfoList}">
          <tr><td colspan="5" class="center">物件枠設定情報が登録されていません。</td></tr>
        </c:if>
      </table>
    </form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
