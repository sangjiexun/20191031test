<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="掲載状態変更" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_bukken/BukkenInfo.do">
      <html:param name="roomKey" value="${BukkenInfoView.roomKey}" />
             物件詳細</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"></c:out>
    </html:messages>
    <p class="section_header">物件情報</p>

      <c:set var="view" value="${BukkenInfoView}" />
      <%@ include file="parts/BukkenInfoPart.jsp" %>

    <p class="section_header">掲載状態変更</p>
    <html:form method="post">
    <input type="hidden" name="roomKey" value="${BukkenInfoView.roomKey}" />
      <div class="add_form">
        <div class="add_form_title">掲載状態の変更<span class="caution">*</span></div>
        <div class="annotation">物件の掲載状態を切り替えます。掲載状態を停止にした場合、CHINTAI、エイブルへの掲載が停止されます。</div>
        <div class="form_space">
        <c:choose>
          <c:when test="${not empty param.bukkenStatus}">
            <c:set var="validBukkenStatus" value="${param.bukkenStatus}"></c:set>
          </c:when>
          <c:otherwise>
            <c:if test="${BukkenInfoView.ctStopDt != null && BukkenInfoView.ablStopDt != null}"><c:set var="validBukkenStatus" value="0"></c:set></c:if>
            <c:if test="${view.ctStopDt == null || view.ablStopDt == null}"><c:set var="validBukkenStatus" value="1"></c:set></c:if>
          </c:otherwise>
        </c:choose>
        <c:choose>

          <c:when test="${validBukkenStatus eq '1'}">
            <label><input type="radio" name="bukkenStatus" value="1" checked>通常</label>
            <label><input type="radio" name="bukkenStatus" value="0">停止</label>
          </c:when>
          <c:otherwise>
            <label><input type="radio" name="bukkenStatus" value="1">通常</label>
            <label><input type="radio" name="bukkenStatus" value="0" checked>停止</label>
          </c:otherwise>
        </c:choose>
        </div>
      </div>
      <div class="add_form">
        <input type="hidden" name="bukkenKanriLastUpdate" value="${BukkenInfoView.bukkenKanriLastUpdate}">
        <input type="button" value="確認画面へ" onClick="_submit('BukkenPublishStatusUpdateConfirm.do')">
        <input type="button" value="戻る" onClick="_submit('BukkenInfoPageBack.do')">
      </div>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>