<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗対象外設定変更" />
<c:set var="view"  value="${ReviewShopStatusUpdateView}"/>
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
      <html:link action="/review/ReviewShopInfo" paramId="shopCd" paramName="view" paramProperty="shopCd">
        店舗詳細
      </html:link>&gt;${title}
    </div>
    <h1>${title}</h1>
    <html:errors />

    <p class="section_header">店舗情報</p>
    <%@ include file="parts/ShopInfoPart.jsp" %>

    <p class="section_header"><c:out value="${title}" /></p>
    <html:form action="/review/ReviewShopStatusUpdateConfirm" method="post">
      <div class="add_form">
        <div class="add_form_title">店舗対象外設定</div>
        <div class="annotation">店舗に対して、対象外とする項目を選択してください。</div>
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
                <c:when test="${view.mailSendSkipFlg eq '1'}">
                  <label><input name="mailSendSkipFlg" type="checkbox" value="1" checked>メール送信対象外</label><br>
                </c:when>
                <c:otherwise>
                  <label><input name="mailSendSkipFlg" type="checkbox" value="1">メール送信対象外</label><br>
                </c:otherwise>
              </c:choose>
            </td>
          </tr>
          <tr>
            <td>
              <c:choose>
                <c:when test="${view.autoDelSkipFlg eq '1'}">
                  <label><input name="autoDelSkipFlg" type="checkbox" value="1" checked>自動削除対象外</label><br>
                </c:when>
                <c:otherwise>
                  <label><input name="autoDelSkipFlg" type="checkbox" value="1">自動削除対象外</label><br>
                </c:otherwise>
              </c:choose>
            </td>
          </tr>
          <tr>
            <td>
              <div class="add_form_title">備考</div>
              <textarea name="shinsaSkipBikou" cols="50" rows="5"><c:out value="${view.shinsaSkipBikou}"/></textarea>
            </td>
          </tr>
        </table>
      </div>
      <p>
        <input type="hidden" name="updDt"  value="${view.updDt}" />
        <input type="hidden" name="shopCd" value="${view.shopCd}" />
        <input type="submit" value="確認画面へ">
        <input type="button" value="戻る" onClick="javascript:location.href='ReviewShopInfo.do?shopCd=${view.shopCd}'">
      </p>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
