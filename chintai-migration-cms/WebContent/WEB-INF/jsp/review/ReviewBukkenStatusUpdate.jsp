<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="物件対象外設定変更" />
<c:set var="view" value="${ReviewBukkenStatusUpdateView}"/>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<script type="text/javascript">
<!--
 addEvent('load', window, function(){document.getElementsByName('syokaiShinsaSkipFlg')[0].focus();});
-->
</script>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/review/ReviewBukkenInfo" paramId="roomKey" paramName="view" paramProperty="roomKey">
        物件詳細
      </html:link>&gt;${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
    <c:out value="${msg}"/>
  </html:messages>
    <p class="section_header">物件情報</p>
    <%@ include file="parts/BukkenInfoPart.jsp" %>

    <p class="section_header">${title}</p>
    <html:form action="/review/ReviewBukkenStatusUpdateConfirm">
      <div class="add_form">
        <div class="add_form_title">物件対象外設定</div>
        <div class="annotation">物件に対して、対象外とする項目を選択してください。</div>
        <table class="type_none">
          <tr>
            <td>
              <c:choose>
                <c:when test="${view.syokaiShinsaSkipFlg eq '1'}">
                  <label><input name="syokaiShinsaSkipFlg" type="checkbox" value="1" checked/>初回審査対象外</label><br>
                </c:when>
                <c:otherwise>
                  <label><input name="syokaiShinsaSkipFlg" type="checkbox" value="1"/>初回審査対象外</label><br>
                </c:otherwise>
              </c:choose>
            </td>
          </tr>
          <tr>
            <td>
              <c:choose>
                <c:when test="${view.teikiShinsaSkipFlg eq '1'}">
                  <label><input name="teikiShinsaSkipFlg" type="checkbox" value="1" checked/>定期審査対象外</label><br>
                </c:when>
                <c:otherwise>
                  <label><input name="teikiShinsaSkipFlg" type="checkbox" value="1"/>定期審査対象外</label><br>
                </c:otherwise>
              </c:choose>
            </td>
          </tr>
          <tr>
            <td>
              <c:choose>
                <c:when test="${view.autoDelSkipFlg eq '1'}">
                  <label><input name="autoDelSkipFlg" type="checkbox" value="1" checked/>自動削除対象外</label><br>
                </c:when>
                <c:otherwise>
                  <label><input name="autoDelSkipFlg" type="checkbox" value="1"/>自動削除対象外</label><br>
                </c:otherwise>
              </c:choose>
            </td>
          </tr>
        </table>
        <br>
      <div class="add_form_title">備考</div>
        <table class="type_none">
          <tr>
            <td>
              <textarea name="shinsaSkipBikou" cols="50" rows="5"><c:out value="${view.shinsaSkipBikou}" /></textarea>
            </td>
          </tr>
        </table><br>
        <input type="hidden" name="updDt"   value="${view.updDt}">
        <input type="hidden" name="roomKey" value="${view.roomKey}">
        <input type="hidden" name="kanriCd" value="${view.kanriCd}">
        <input type="submit" value="確認画面へ">
        <input type="button" value="戻る" onClick="javascript:location.href='ReviewBukkenInfo.do?roomKey=${param.roomKey}'">
      </div>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
