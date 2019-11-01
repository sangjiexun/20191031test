<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="掲載状態変更" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<script type="text/javascript">

 addEvent('load', window, function(){document.getElementsByName('commit')[0].focus();});

</script>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_bukken/BukkenInfo.do">
      <html:param name="roomKey" value="${BukkenInfoView.roomKey}" />
             物件詳細</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <p class="section_header">物件情報</p>

      <c:set var="view" value="${BukkenInfoView}" />
      <%@ include file="parts/BukkenInfoPart.jsp" %>

    <p class="section_header">掲載状態変更</p>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="20%">
        <col span="1" width="80%">
      </colgroup>
      <tr>
        <th>掲載状態</th>
        <td>
          <chintai:CodePrint nameKey="STATUS_NAME" valueKey="STATUS_VALUE" code="${param.bukkenStatus}" />
        </td>
      </tr>
    </table>
    <html:form method="post" action="/shop_bukken/BukkenPublishStatusUpdateCommit.do" onsubmit="disableSubmit(this)">
    <input type="hidden" name="bukkenKanriLastUpdate" value="${BukkenInfoView.bukkenKanriLastUpdate}">
    <input type="hidden" name="roomKey" value="${BukkenInfoView.roomKey}" />
    <input type="hidden" name="bukkenStatus" value="${param.bukkenStatus}" />
    <input type="hidden" name="kanriCd" value="${BukkenInfoView.shopCd}-${BukkenInfoView.bkCd}-${BukkenInfoView.roomNo}" />
      <p>
        <input type="submit" value="更新" name="commit">
        <input type="button" value="戻る" onClick="_submit('BukkenPublishStatusUpdatePageBack.do')" />
      </p>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>