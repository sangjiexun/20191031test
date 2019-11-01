<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="問い合せユーザ情報" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<c:set var="view" value="${CjnUserInfoView}" />

<!-- メイン -->
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnUserList">問い合せユーザ一覧</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">ユーザ情報</p>
    <p>
      <html:link action="/cjn_inquiry/CjnUserUpdatePage">
        <html:param name="cjnAccountSeq" value="${view.cjnAccountSeq}" />
        &gt;&gt; ユーザ情報を編集
      </html:link>
    </p>
    <p>
      <html:link action="/cjn_inquiry/CjnUserPrint" target="_blank">
        <html:param name="cjnAccountSeq" value="${view.cjnAccountSeq}" />
        &gt;&gt; 印刷画面表示
      </html:link>
    </p>
    <table class="type_detail_pre">
      <colgroup>
        <col width="20%">
        <col width="80%">
      </colgroup>
      <tr>
        <th class="text-left">ユーザシーケンス</th>
        <td><c:out value="${view.cjnAccountSeq}" /></td>
      </tr>
      <tr>
        <th class="text-left">ユーザID</th>
        <td><c:out value="${view.userId}" /></td>
      </tr>
      <tr>
        <th class="text-left">名前</th>
        <td><c:out value="${view.userName}" /></td>
      </tr>
      <tr>
        <th class="text-left">お知らせ送付メール<br>アドレス</th>
        <td class="left">
                (1)<c:if test="${view.emailStatus1 == 0}"><font color="#ff0000"></c:if>
                   <chintai:CodePrint code="${view.emailStatus1}" nameKey="CJN_EMAIL_STATUS_NAME" valueKey="CJN_EMAIL_STATUS_VALUE" />
                   <c:if test="${view.emailStatus1 == 0}"></font></c:if>
                                    ： <c:out value="${view.email1}" /><br>
                (2)<c:if test="${view.emailStatus2 == 0}"><font color="#ff0000"></c:if>
                   <chintai:CodePrint code="${view.emailStatus2}" nameKey="CJN_EMAIL_STATUS_NAME" valueKey="CJN_EMAIL_STATUS_VALUE" />
                   <c:if test="${view.emailStatus2 == 0}"></font></c:if>
                                    ： <c:out value="${view.email2}" /><br>
                (3)<c:if test="${view.emailStatus3 == 0}"><font color="#ff0000"></c:if>
                   <chintai:CodePrint code="${view.emailStatus3}" nameKey="CJN_EMAIL_STATUS_NAME" valueKey="CJN_EMAIL_STATUS_VALUE" />
                   <c:if test="${view.emailStatus3 == 0}"></font></c:if>
                                    ： <c:out value="${view.email3}" /><br>
          </td>
       </tr>
      <tr>
        <th class="text-left">レベル</th>
        <td>
          <c:if test="${view.accountLevel == 1}"><font color="#ff0000"></c:if>
          <chintai:CodePrint code="${view.accountLevel}" nameKey="CJN_ACCOUNT_TYPE_NAME" valueKey="CJN_ACCOUNT_TYPE_VALUE"/>
          <c:if test="${view.accountLevel == 1}"></font></c:if>
        </td>
      </tr>
      <tr>
        <th class="text-left">管理メモ</th>
        <td><chintai:filter changeNL2BR="true"><c:out value="${view.adminNote}" /></chintai:filter></td>
      </tr>
      <tr>
        <th class="text-left">登録日時<br>最終更新日時</th>
        <td>${view.insDt}<br>${view.updDt}</td>
      </tr>
    </table>

    <c:if test="${not empty CjnUserInfoView.userAccountList}">
    <p class="section_header">閲覧可能問い合せ権限</p>
    <p>
      <html:link action="/cjn_inquiry/CjnUserAuthorityUpdatePage">
        <html:param name="cjnAccountSeq" value="${view.cjnAccountSeq}" />
        &gt;&gt; 閲覧可能問い合せ権限変更
      </html:link>
    </p>
    <table class="type_list">
      <colgroup>
        <col width="10%">
        <col width="55%">
        <col width="25%">
      <colgroup>
      <tr>
        <th>閲覧可否</th>
        <th>問い合せタイトル</th>
        <th>問い合せ説明</th>
      </tr>
      <c:forEach items="${CjnUserInfoView.userAccountList}" var="list">
      <tr>
        <td>
          <c:choose>
            <c:when test="${list.cnt == 1}" >○</c:when>
            <c:otherwise>×</c:otherwise>
          </c:choose>
        </td>
        <td class="left"><c:out value="${list.inqTitle}" /></td>
        <td class="left"><c:out value="${list.inqComment}" /></td>
      </tr>
      </c:forEach>
    </table>
    </c:if>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
