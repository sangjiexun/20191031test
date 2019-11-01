<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="問い合せユーザ情報編集" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<script type="text/javascript">

 addEvent('load', window, function(){document.getElementsByName('commit')[0].focus();});

</script>
<c:set var="view" value="${CjnUserUpdateView}" />
<!-- メイン -->
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnUserList">問い合せユーザ一覧</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnUserInfo?cjnAccountSeq=${view.cjnAccountSeq}">問い合せユーザ情報</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
    <br>
    <p class="section_header">ユーザ基本情報</p>
    <html:form  method="post" action="/cjn_inquiry/CjnUserUpdateCommit" onsubmit="disableSubmit(this)">
      <table class="type_detail">
        <colgroup>
          <col width="20%">
          <col width="80%">
        </colgroup>
        <tr>
          <th class="text-left">ユーザシーケンス</th>
          <td><c:out value="${view.cjnAccountSeq}"/></td>
        </tr>
        <tr>
          <th class="text-left">ユーザID</th>
          <td><c:out value="${view.userId}"/></td>
        </tr>
        <tr>
          <th class="text-left">名前</th>
          <td><c:out value="${view.userName}"/></td>
        </tr>
      </table>

      <p class="section_header">ユーザ情報編集内容確認</p>
      <table class="type_detail_pre">
        <colgroup>
          <col width="20%">
          <col width="80%">
        </colgroup>
        <tr>
          <th class="text-left">お知らせ送付メール<br>アドレス</th>
          <td class="left">
                (1)<c:if test="${view.emailStatus1==0}"><font color="#ff0000"></c:if>
                   <chintai:CodePrint code="${view.emailStatus1}" nameKey="CJN_EMAIL_STATUS_NAME" valueKey="CJN_EMAIL_STATUS_VALUE" />
                   <c:if test="${view.emailStatus1==0}"></font></c:if>
                                    ： <c:out value="${view.email1}" /><br>
                (2)<c:if test="${view.emailStatus2==0}"><font color="#ff0000"></c:if>
                   <chintai:CodePrint code="${view.emailStatus2}" nameKey="CJN_EMAIL_STATUS_NAME" valueKey="CJN_EMAIL_STATUS_VALUE" />
                   <c:if test="${view.emailStatus2==0}"></font></c:if>
                                    ： <c:out value="${view.email2}" /><br>
                (3)<c:if test="${view.emailStatus3==0}"><font color="#ff0000"></c:if>
                   <chintai:CodePrint code="${view.emailStatus3}" nameKey="CJN_EMAIL_STATUS_NAME" valueKey="CJN_EMAIL_STATUS_VALUE" />
                   <c:if test="${view.emailStatus3==0}"></font></c:if>
                                    ： <c:out value="${view.email3}" /><br>
          </td>
        </tr>
        <tr>
          <th class="text-left">レベル</th>
          <td>
          <c:if test="${view.accountLevel==1}"><font color="#ff0000"></c:if>
          <chintai:CodePrint code="${view.accountLevel}" nameKey="CJN_ACCOUNT_TYPE_NAME" valueKey="CJN_ACCOUNT_TYPE_VALUE"/>
          <c:if test="${view.accountLevel==1}"></font></c:if>
        </td>
        </tr>
        <tr>
          <th class="text-left">管理メモ</th>
          <td><chintai:filter changeNL2BR="true"><c:out value="${view.adminNote}" /></chintai:filter></td>
        </tr>
        <tr>
          <th class="text-left">登録日時<br>最終更新日時</th>
          <td>
            <c:out value="${view.insDt}" />
            <br>
            <c:out value="${view.updDt}" />
          </td>
        </tr>
      </table>

      <p>
        <input type="hidden" name="email1" value="${fn:escapeXml(view.email1)}">
        <input type="hidden" name="emailStatus1" value="${view.emailStatus1}">
        <input type="hidden" name="email2" value="${fn:escapeXml(view.email2)}">
        <input type="hidden" name="emailStatus2" value="${view.emailStatus2}">
        <input type="hidden" name="email3" value="${fn:escapeXml(view.email3)}">
        <input type="hidden" name="emailStatus3" value="${view.emailStatus3}">
        <input type="hidden" name="accountLevel" value="${view.accountLevel}">
        <input type="hidden" name="adminNote" value="${fn:escapeXml(view.adminNote)}">
        <input type="hidden" name="cjnAccountSeq" value="${view.cjnAccountSeq}">
        <input type="hidden" name="updDt" value="${view.updDt}">
        <input type="hidden" name="userId" value="${view.userId}">
        <input type="hidden" name="userName" value="${fn:escapeXml(view.userName)}">
        <input type="submit" value="更新" name="commit">
        <input type="button" name="back" value="戻る" onClick="_submit('CjnUserUpdatePageBack.do')">
      </p>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
