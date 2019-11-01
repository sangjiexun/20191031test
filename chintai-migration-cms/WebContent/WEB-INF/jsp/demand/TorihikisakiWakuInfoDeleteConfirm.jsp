<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="取引先 物件枠設定情報削除確認" />
<c:set var="view"  value="${TorihikisakiWakuInfoDeleteView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--
 addEvent('load', window, function(){document.getElementsByName('backButton')[0].focus();});
-->
</script>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="demand/TorihikisakiInfo.do" paramId="torihikisakiSeq" paramName="view" paramProperty="torihikisakiSeq">取引先詳細</html:link>
      &gt;<c:out value="${title}"></c:out>
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>


    <!--物件枠設定情報-->
    <p class="section_header">削除物件枠設定情報</p>
    <html:form action="demand/TorihikisakiWakuInfoDeleteCommit.do" onsubmit="disableSubmit(this);">
      <table class="type_list">
        <colgroup>
          <col width="30%">
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
        <c:forEach var="detail" items="${view.detailList}">
          <tr>
            <td><c:out value="${detail.startYmForDisplay}"></c:out>
                <input type="hidden" name="delFlgList" value="${detail.startYm}" />
            </td>
            <td class="right"><c:out value="${detail.bukkenCnt}" />件</td>
            <td class="right"><c:out value="${detail.tokusenCnt}" />件</td>
            <td class="right">
              <c:out value="${detail.updDt}" />
              <input type="hidden" name="updDt" value="${detail.updDt}" />
            </td>
          </tr>
        </c:forEach>
      </table>

      <div class="add_from">
        <input type="hidden" name="torihikisakiUpdDt" value="${view.torihikisakiUpdDt}">
        <input type="hidden" name="torihikisakiSeq"  value="${view.torihikisakiSeq}">
        <input type="submit" value="削除" >
        <input type="button" name="backButton" value="戻る" onclick="_submit('TorihikisakiWakuInfoDeleteBack.do');">
      </div>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>