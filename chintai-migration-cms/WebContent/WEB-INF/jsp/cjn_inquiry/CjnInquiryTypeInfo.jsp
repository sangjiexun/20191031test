<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="問い合せ種別詳細" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<c:set var="view" value="${CjnInquiryTypeInfoView}" />

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnInquiryTypeList">問い合せ種別一覧</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}" />
    </html:messages>

    <p class="section_header">問い合せ種別情報</p>
    <p>
      <html:link action="/cjn_inquiry/CjnInquiryTypeUpdatePage">
        <html:param name="cjnInqKindSeq" value="${view.cjnInqKindSeq}" />
        &gt;&gt; 問い合せ種別を編集
      </html:link>
    </p>
    <table class="type_detail">
      <colgroup>
        <col width="20%">
        <col width="80%">
      </colgroup>
      <tr>
        <th class="text-left">問い合せ種別シーケンス</th>
        <td><c:out value="${view.cjnInqKindSeq}" /></td>
      </tr>
      <tr>
        <th class="text-left">タイトル</th>
        <td><c:out value="${view.inqTitle}" /></td>
      </tr>
      <tr>
        <th class="text-left">説明文</th>
        <td><c:out value="${view.inqComment}" /></td>
      </tr>
      <tr>
        <th class="text-left">問い合せURL</th>
        <td><c:out value="${view.inqUrl}" /></td>
      </tr>
      <tr>
        <th class="text-left">表示用タイトル</th>
        <td><c:out value="${view.dispTitle}" /></td>
      </tr>
      <tr>
        <th class="text-left">表示用ソートキー</th>
        <td><c:out value="${view.dispSortKey}" /></td>
      </tr>
      <tr>
        <th class="text-left">問い合せグループ</th>
        <td>
          <chintai:CodePrint code="${view.inqGroupType}"
              nameKey="CJN_INQ_GROUP_TYPE_NAME"
              valueKey="CJN_INQ_GROUP_TYPE_VALUE" />
        </td>
      </tr>
      <tr>
        <th height="80" class="text-left">管理メモ</th>
        <td><c:out value="${view.adminNote}" /></td>
      </tr>
      <tr>
        <th class="text-left">登録日時<br>最終更新日時</th>
        <td><c:out value="${view.insDt}" /><br><c:out value="${view.updDt}" /></td>
      </tr>
    </table>

    <p class="section_header">閲覧可能ユーザ一覧</p>
    <p>
      <html:link action="/cjn_inquiry/CjnUserAvailabilityUpdatePage">
        <html:param name="cjnInqKindSeq" value="${view.cjnInqKindSeq}" />
        &gt;&gt; 閲覧可能ユーザを変更
      </html:link>
    </p>

    <table class="type_list">
      <colgroup>
        <col width="10%">
        <col width="90%">
      </colgroup>
      <tr>
        <th>閲覧可否</th>
        <th>名前</th>
      </tr>
      <c:forEach items="${CjnInquiryTypeInfoView.readableUserList}" var="users">
        <tr>
          <td><c:out value="${users.exists}" /></td>
          <td class="left"><c:out value="${users.userName}" /></td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
