<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="問い合せ種別一覧" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}" />
    </html:messages>
    
    <c:if test="${CjnInquiryTypeListView.cjnAccountType == 1}">
      <p><html:link action="/cjn_inquiry/CjnInquiryTypeAddPage">&gt;&gt; 新しい問い合せ種別を登録する</html:link></p>
    </c:if>
    <p class="section_header">問い合せ種別一覧</p>
    
    <table class="type_list">
      <colgroup>
        <col width="5%">
        <col width="30%">
        <col width="35%">
        <col width="6%">
        <col width="6%">
        <col width="6%">
        <col width="6%">
        <col width="6%">
      </colgroup>
      <tr>
        <th rowspan="2">No</th>
        <th rowspan="2">問い合せタイトル<br>問い合せグループ<br>問い合せ説明</th>
        <th rowspan="2">閲覧可能ユーザ</th>
        <th colspan="3">処理状況</th>
        <th rowspan="2">閲覧</th>
        <th rowspan="2">詳細</th>
      </tr>
      <tr>
        <th>総数</th>
        <th>未読</th>
        <th>未処理</th>
      </tr>
      <c:forEach items="${CjnInquiryTypeListView.inquiryTypeList}" var="list">
        <tr>
          <td><c:out value="${list.cjnInqKindSeq}" /></td>
          <td class="left">
            <a href="${list.inqUrl}" target="_blank"><c:out value="${list.inqTitle}" /></a>
            <hr class="sharp">
            <chintai:CodePrint code="${list.inqGroupType}"
                    nameKey="CJN_INQ_GROUP_TYPE_NAME" valueKey="CJN_INQ_GROUP_TYPE_VALUE" />
            <br>
            <c:out value="${list.inqComment}" />
          </td>
          <td class="left"><c:out value="${list.readableUserList}" /></td>
          <td><c:out value="${list.totalCount}" /></td>
          <td><span class="caution"><c:out value="${list.noReadCount}" /></span></td>
          <td><span class="caution"><c:out value="${list.noShoriCount}" /></span></td>
          <td>
            <c:choose>
              <c:when test="${list.enabled}">
                <input type=button value="閲覧" onclick="location.href='CjnInquirySearchPage.do?cjnInqKindSeq=${list.cjnInqKindSeq}'">
              </c:when>
              <c:otherwise>
                --
              </c:otherwise>
            </c:choose>
          </td>
          <td>
            <c:choose>
              <c:when test="${CjnInquiryTypeListView.cjnAccountType == 1}">
                <input type=button value="詳細" onclick="location.href='CjnInquiryTypeInfo.do?cjnInqKindSeq=${list.cjnInqKindSeq}'">
              </c:when>
              <c:otherwise>
                --
              </c:otherwise>
            </c:choose>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>