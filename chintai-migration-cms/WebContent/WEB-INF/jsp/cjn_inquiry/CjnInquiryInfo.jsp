<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="問い合せ詳細" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<c:set var="view" value="${CjnInquiryInfoView}" />

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnInquiryTypeList">問い合せ種別一覧</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnInquirySearch">
        <html:param name="offSet" value="${view.offSet}" />
        <html:param name="cjnInqKindSeq" value="${view.cjnInqKindSeq}" />
        問い合せ検索
      </html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">${title}</p>
    <p>
      <html:link action="/cjn_inquiry/CjnInquiryStatusUpdatePage">
        <html:param name="cjnInqId" value="${view.cjnInqId}"/>
        <html:param name="cjnInqKindSeq" value="${view.cjnInqKindSeq}" />
        <html:param name="offSet" value="${view.offSet}" />
        &gt;&gt;  問い合せ状況変更
      </html:link>
    </p>

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
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
