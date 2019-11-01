<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="返信入力" />
<c:set var="view" value="${ReviewReplayView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp"%>

<!-- メイン -->
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp"%>
<div class="popup_layout">
  <div class="topic_path">
    <c:set var="roomKey" value="${param.roomKey}" />
    <html:link action="/review/ReviewBukkenInfo" paramId="roomKey" paramName="roomKey">
      物件詳細
    </html:link>&gt;${title}
  </div>
<h1>${title}</h1>

<!-- 物件情報  -->
<p class="section_header">物件情報</p>
<%@ include file="parts/ReplyBukkenInfoPart.jsp" %>

<!-- 物件確認入力内容 -->
<p class="section_header">物件確認入力内容確認</p>
<table class="type_detail">
  <colgroup>
    <col width="20%">
    <col width="10%">
    <col width="*">
  </colgroup>
  <tr>
    <th colspan="2" class="text-left">お問い合せ番号</th>
    <td><c:out value="${view.uketsukeCd}" /></td>
  </tr>
  <tr>
    <th colspan="2" class="text-left">管理コード</th>
    <td><c:out value="${view.kanriCd}" /></td>
  </tr>
  <tr>
    <th rowspan="2" class="text-left">物件名</th>
    <th class="text-left">名前</th>
    <td><c:out value="${view.bkName}" /></td>
  </tr>
    <tr>
    <th class="text-left">フリガナ</th>
    <td><c:out value="${view.bkKana}" /></td>
  </tr>
  <tr>
    <th colspan="2" class="text-left">空室となった年月日又は空室予定日<br>(新築の場合は完成年月日)</th>
    <td>
      <c:choose>
        <c:when test="${not empty view.vacantYear}">
          <c:out value="${view.vacantYear}" />年<c:out value="${view.vacantMonth}" />月<c:out value="${view.vacantDay}" />日
        </c:when>
        <c:otherwise>
          --
        </c:otherwise>
      </c:choose>
      <c:if test="${view.shinchikuFlg eq '1' }">(新築)</c:if>
    </td>
  </tr>
  <tr>
    <th colspan="2" class="text-left">最終条件確認年月日</th>
    <td>
      <c:out value="${view.lastConfirmYear}" />年<c:out value="${view.lastConfirmMonth}" />月<c:out value="${view.lastConfirmDay}" />日
    </td>
  </tr>
  <tr>
    <th colspan="2" class="text-left">処理内容</th>
    <td><chintai:CodePrint code="${view.syoriKbn}" nameKey="WEB_SYORI_KBN_NAME" valueKey="WEB_SYORI_KBN_VALUE"/> </td>
  </tr>

  <tr>
    <th colspan="2" class="text-left">その他ご意見など</th>
    <td><chintai:filter changeNL2BR="true"><c:out value="${view.bikou}" /></chintai:filter></td>
  </tr>
</table>
<html:form action="review/ReviewReplayCommit.do" onsubmit="disableSubmit(this)">
<p>
  <input type="hidden" name="kanriCd"          value="${view.kanriCd}">
  <input type="hidden" name="shinchikuFlg"     value="${view.shinchikuFlg}">
  <input type="hidden" name="vacantYear"       value="${view.vacantYear}">
  <input type="hidden" name="vacantMonth"      value="${view.vacantMonth}">
  <input type="hidden" name="vacantDay"        value="${view.vacantDay}">
  <input type="hidden" name="vacantYmd"        value="${view.vacantYmd}">
  <input type="hidden" name="lastConfirmYear"  value="${view.lastConfirmYear}">
  <input type="hidden" name="lastConfirmMonth" value="${view.lastConfirmMonth}">
  <input type="hidden" name="lastConfirmDay"   value="${view.lastConfirmDay}">
  <input type="hidden" name="lastConfirmYmd"   value="${view.lastConfirmYmd}">
  <input type="hidden" name="syoriKbn"         value="${view.syoriKbn}">
  <input type="hidden" name="bikou"            value="${fn:escapeXml(view.bikou)}">
  <input type="hidden" name="updDt"            value="${view.updDt}">
  <input type="hidden" name="kanriUpdDt"       value="${view.kanriUpdDt}">
  <input type="hidden" name="warningCd"        value="${view.warningCd}">
  <input type="hidden" name="roomKey"          value="${param.roomKey}">
  <input type="submit" value="登録">
  <input type="button" name="" value="戻る" onClick="_submit('ReviewReplayPageBack.do')">
</p>
</html:form>
</div>
</div>

<%@ include file="../parts/ContentsFooter.jsp"%>
