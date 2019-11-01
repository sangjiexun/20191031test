<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value=" 問い合せ状況変更" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<c:set var="view" value="${CjnInquiryStatusUpdateView}" />

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnInquiryTypeList">問い合せ種別一覧</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnInquirySearch?offSet=${view.offSet}">問い合せ検索</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnInquiryInfo">
        <html:param name="cjnInqId" value="${view.cjnInqId}" />
        <html:param name="cjnInqKindSeq" value="${view.cjnInqKindSeq}" />
        <html:param name="offSet" value="${view.offSet}" />
        問い合せ詳細
      </html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <p class="section_header">問い合せ情報</p>
    <table class="type_detail_pre">
      <colgroup>
        <col width="20%">
        <col width="70%">
      </colgroup>
      <tr>
        <th class="text-left">問い合せ日時</th>
        <td><c:out value="${view.insDt}" /></td>
      </tr>
      <tr>
        <th class="text-left">問い合せID</th>
        <td><c:out value="${view.cjnInqId}" /></td>
      </tr>

      <tr>
        <th class="text-left">PC/モバイル</th>
        <td><chintai:CodePrint code="${view.carrierType}" nameKey="SEARCHPARAM_PC_MOBILE_NAME" valueKey="SEARCHPARAM_PC_MOBILE_VALUE"/><br/></td>
      </tr>
      <tr>
        <th class="text-left">取引番号</th>
        <td><c:out value="${view.fregiTorihikiNo}" /></td>
      </tr>
      <tr>
        <th class="text-left">伝票番号</th>
        <td><c:out value="${view.fregiDenpyoNo}" /></td>
      </tr>
      <tr>
        <th class="text-left">処理状況</th>
        <td><c:out value="${view.inquiryStatusName}" /></td>
      </tr>
      <tr>
        <th class="text-left">最終処理日時<br>(最終処理ユーザ)</th>
        <td>
          <c:out value="${view.lastOpeDt}" />
          <br>
          <c:if test="${not empty view.lastOpeUser}">(</c:if>
            <c:out value="${view.lastOpeUser}" />
          <c:if test="${not empty view.lastOpeUser}">)</c:if>
        </td>
      </tr>
      <tr>
        <th class="text-left">最終閲覧日時<br>(最終閲覧ユーザ)</th>
        <td>
          <c:out value="${view.lastRefDt}" />
          <br>
          <c:if test="${not empty view.lastRefUser}">(</c:if>
            <c:out value="${view.lastRefUser}" />
          <c:if test="${not empty view.lastRefUser}">)</c:if>
          </td>
      </tr>
      <tr>
        <th class="text-left">問い合せ内容</th>
        <td class="left">
          <chintai:filter changeNL2BR="true"><c:out value="${view.inqContents}" /></chintai:filter>
        </td>
      </tr>
    </table>

    <p class="section_header">${title}</p>
    <html:form method="post" action="/cjn_inquiry/CjnInquiryStatusUpdateConfirm" onsubmit="disableSubmit(this)">
    <div class="add_form">
      <input type="hidden" name="cjnInqId" value="${view.cjnInqId}" >
      <div class="add_form_title">処理状況<span class="caution">*</span></div>
      <div class="annotation">問い合せ処理状況を設定します。</div>
      <div class="form_space">
        <c:choose>
          <c:when test="${view.inquiryStatus == 1}">
            <label><input type="radio" name="inquiryStatus" value="0" >未処理</label>
            <label><input type="radio" name="inquiryStatus" value="1" checked>処理済</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="inquiryStatus" value="0" checked>未処理</label>
            <label><input type="radio" name="inquiryStatus" value="1" >処理済</label>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
      <p>
        <input type="hidden" name="cjnInqKindSeq" value="${view.cjnInqKindSeq}">
        <input type="hidden" name="cjnInqId" value="${view.cjnInqId}">
        <input type="hidden" name="insDt" value="${view.insDt}">
        <input type="hidden" name="lastOpeUser" value="${fn:escapeXml(view.lastOpeUser)}">
        <input type="hidden" name="lastRefUser" value="${fn:escapeXml(view.lastRefUser)}">
        <input type="hidden" name="lastRefDt" value="${view.lastRefDt}">
        <input type="hidden" name="lastOpeDt" value="${view.lastOpeDt}">
        <input type="hidden" name="inqContents" value="${fn:escapeXml(view.inqContents)}">
        <input type="hidden" name="inquiryStatus" value="${view.inquiryStatus}">
        <input type="hidden" name="updDt" value="${view.updDt}">
        <input type="hidden" name="offSet" value="${view.offSet}">

        <%-- 2008.07.11雑誌・ザガット対応 start --%>
        <input type="hidden" name="carrierType" value="${view.carrierType}">
        <input type="hidden" name="fregiDenpyoNo" value="${view.fregiDenpyoNo}">
        <input type="hidden" name="fregiTorihikiNo" value="${view.fregiTorihikiNo}">
        <%-- 2008.07.11雑誌・ザガット対応 end --%>

        <input type="hidden" name="carrierTypeName" value="${fn:escapeXml(view.carrierTypeName)}">
        <input type="hidden" name="inquiryStatusName" value="${fn:escapeXml(view.inquiryStatusName)}">

        <input type="submit" value="確認画面へ" >
        <input type="button" name="back" value="戻る" onclick="_submit('CjnInquiryInfo.do?cjnInqId=${view.cjnInqId}&cjnInqKindSeq=${view.cjnInqKindSeq}&offSet=${view.offSet}')">
      </p>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
