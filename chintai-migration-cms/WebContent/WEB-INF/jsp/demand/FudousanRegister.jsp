<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="不動産会社新規登録" />
<c:set var="view"  value="${FudousanRegisterView}" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<script type="text/javascript">
<!--
addEvent('load', window, function(){document.getElementsByName('fudousanName')[0].focus();});
-->
</script>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ </html:link>
      &gt;<html:link action="/demand/FudousanSearchPaging.do">不動産会社メンテナンス</html:link>
      &gt;${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}" />
    </html:messages>
    <p class="section_header">不動産会社情報</p>
    <html:form action="demand/FudousanRegisterConfirm.do">
      <div class="add_form">
        <div class="add_form_title">不動産会社名<span class="caution">*</span></div>
        <div class="annotation">不動産会社名を記述します。法人種別は全て全角「(株)・(有)」で入力してください。</div>
          <div class="form_space">
            <input type="text" name="fudousanName" maxlength="30" size="30" value="${fn:escapeXml(param.fudousanName)}">
          </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">住所</div>
        <div class="annotation">不動産会社住所を設定します。</div>
        <div class="form_space">
          〒<input type="text" name="zipCode1" maxlength="3" size="3" value="${param.zipCode1}">－<input type="text" name="zipCode2" maxlength="4" size="4" value="${param.zipCode2}">(半角)<br>
          <chintai:Todofuken name="prefCd" fixValue="${param.prefCd}"/><br>
          <input type="text" name="address1" maxlength="60" size="50" value="${fn:escapeXml(param.address1)}">(市区町村名、番地)<br>
          <input type="text" name="address2" maxlength="51" size="50" value="${fn:escapeXml(param.address2)}">(ビル名等)
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">電話番号</div>
        <div class="annotation">電話番号を記述します。（例：03-1234-5678）</div>
        <div class="form_space">
          <input type="text" name="tel" maxlength="13" size="13" value="${param.tel}">(半角)
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">FAX番号</div>
        <div class="annotation">FAX番号を記述します。（例：03-1234-5678）</div>
        <div class="form_space">
          <input type="text" name="fax" maxlength="13" size="13" value="${param.fax}">(半角)
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">担当者名</div>
        <div class="annotation">担当者名を記述します。</div>
        <div class="form_space">
          <input type="text" name="tantou" maxlength="25" size="25" value="${fn:escapeXml(param.tantou)}">
        </div>
      </div>

      <div class="add_form">
        <input type="submit" value="確認画面へ">
        <input type="button" value="戻る"  onclick="_submit('FudousanSearchPaging.do');">
      </div>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
