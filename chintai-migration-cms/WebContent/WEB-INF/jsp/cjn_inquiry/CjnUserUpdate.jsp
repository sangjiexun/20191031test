<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="問い合せユーザ情報編集" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<script type="text/javascript">
<!--
addEvent('load', window, function(){document.getElementsByName('email1')[0].focus();});
//-->
</script>

<c:set var="view" value="${CjnUserInfoView}" />
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
    <p class="section_header">ユーザ基本情報</p>
    <table class="type_detail">
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
    </table>

    <p class="section_header">ユーザ情報編集</p>
    <html:form action="/cjn_inquiry/CjnUserUpdateConfirm.do" method="post" onsubmit="disableSubmit(this)">
    <div class="add_form">
      <div class="add_form_title">お知らせ送付メールアドレス<span class="caution">*</span></div>
      <div class="annotation">問い合せのお知らせ送付先メールアドレスを設定します。送信を選択した場合は、送信先メールアドレスを入力してください。</div>
      <div class="form_space">
        <label>(1)</label>
        <c:choose>
          <c:when test="${view.emailStatus1 == 1}">
            <label><input type="radio" name="emailStatus1" value="1" checked>送信</label>
            <label><input type="radio" name="emailStatus1" value="0">未送信</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="emailStatus1" value="1">送信</label>
            <label><input type="radio" name="emailStatus1" value="0" checked >未送信</label>
          </c:otherwise>
        </c:choose>
        <label><input type="text" name="email1" size="50" maxlength="255" value="${fn:escapeXml(view.email1)}"></label>
      </div>
      <div class="form_space">
        <label>(2)</label>
        <c:choose>
          <c:when test="${view.emailStatus2 == 1}">
            <label><input type="radio" name="emailStatus2" value="1" checked>送信</label>
            <label><input type="radio" name="emailStatus2" value="0">未送信</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="emailStatus2" value="1">送信</label>
            <label><input type="radio" name="emailStatus2" value="0" checked>未送信</label>
          </c:otherwise>
        </c:choose>
        <label><input type="text" name="email2" size="50" maxlength="255" value="${fn:escapeXml(view.email2)}"></label>
      </div>
      <div class="form_space">
        <label>(3)</label>
        <c:choose>
          <c:when test="${view.emailStatus3 == 1}">
            <label><input type="radio" name="emailStatus3" value="1" checked>送信</label>
            <label><input type="radio" name="emailStatus3" value="0">未送信</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="emailStatus3" value="1">送信</label>
            <label><input type="radio" name="emailStatus3" value="0" checked>未送信</label>
          </c:otherwise>
        </c:choose>
        <label><input type="text" name="email3" size="50"  maxlength="255" value="${fn:escapeXml(view.email3)}"></label>
      </div>
    </div>

    <div class="add_form">
      <div class="add_form_title">レベル<span class="caution">*</span></div>
      <div class="annotation">問い合せユーザの利用レベルを設定します。</div>
      <div class="form_space">
        <chintai:PropertyOptions name="accountLevel" nameKey="CJN_ACCOUNT_TYPE_NAME" valueKey="CJN_ACCOUNT_TYPE_VALUE" fixValue="${view.accountLevel}"/>
      </div>
    </div>

    <div class="add_form">
      <div class="add_form_title">管理メモ</div>
      <div class="annotation">問い合せユーザの管理メモを設定します。</div>
      <div class="form_space">
        <textarea rows="5" cols="60" name="adminNote">${fn:escapeXml(view.adminNote)}</textarea>
      </div>
    </div>

    <p>
      <input type="hidden" name="cjnAccountSeq" value="${view.cjnAccountSeq}" >
      <input type="hidden" name="userId" value="${view.userId}">
      <input type="hidden" name="userName" value="${fn:escapeXml(view.userName)}">
      <input type="hidden" name="updDt" value="${view.updDt}" >
      <input type="hidden" name="insDt" value="${view.insDt}" >
      <input type="submit" value="確認画面へ">
      <input type="button" name="" value="戻る" onClick="_submit('CjnUserInfo.do?cjnAccountSeq=${view.cjnAccountSeq}')">
    </p>

    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
