<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="CHINTAI NET掲載状態変更" />
<c:set var="view" value="${ReviewBukkenWebStatusUpdateView}"/>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<script type="text/javascript">
<!--
 addEvent('load', window, function(){document.getElementsByName('bukkenStatusShinsaInput')[0].focus();});
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
    <!-- 物件情報 1 -->
    <p class="section_header">物件情報</p>
    <%@ include file="parts/WebStatusUpdateBukkenInfoPart.jsp" %>

    <p class="section_header">${title}</p>
    <html:form action="/review/ReviewBukkenWebStatusUpdateConfirm">
      <div class="add_form">
        <div class="add_form_title">CHINTAI NET掲載状態<span class="caution">*</span></div>
        <div class="annotation">物件のCHINTAI NET掲載状態を切り替えます。</div>
        <div class="form_space">
          <c:choose>
            <c:when test="${not empty param.bukkenStatusShinsaInput}">
              <c:set var="validBukkenStatusShinsa" value="${param.bukkenStatusShinsaInput}"/>
            </c:when>
            <c:otherwise>
              <c:if test="${view.ctStopDt != null}"><c:set var="validBukkenStatusShinsa" value="0"></c:set></c:if>
              <c:if test="${view.ctStopDt == null}"><c:set var="validBukkenStatusShinsa" value="1"></c:set></c:if>
            </c:otherwise>
          </c:choose>

          <c:if test="${view.ctStopDt != null && view.changeSourceKbn == '1'}"><c:set var="validDisableControl" value="1"></c:set></c:if>
          <c:if test="${view.ctStopDt == null || view.changeSourceKbn != '1'}"><c:set var="validDisableControl" value="0"></c:set></c:if>

          <c:choose>
            <c:when test="${validBukkenStatusShinsa eq '1'}">
              <label><input type="radio" name="bukkenStatusShinsaInput" value="1" checked>通常</label>
              <label><input type="radio" name="bukkenStatusShinsaInput" value="0">停止</label>
            </c:when>
            <c:otherwise>
              <c:if test="${validDisableControl == '1' }">
                <c:set var="radioControl" value="disabled"></c:set>
                <input type="hidden" name="bukkenStatusShinsaInput" value="0" />
              </c:if>
              <label><input type="radio" name="bukkenStatusShinsaInput" value="1"  ${radioControl} >通常</label>
              <label><input type="radio" name="bukkenStatusShinsaInput" value="0"  ${radioControl} checked>停止</label>
            </c:otherwise>
          </c:choose>
        </div>
        <div class="add_form_title">備考<span class="caution">*</span></div>
        <div class="annotation">CHINTAI NET掲載状態を切り替える理由を必ず入力してください。</div>
        <div class="form_space">
          <textarea name="shinsaBukkenStatusBikou" cols="50" rows="5"><c:out value="${view.shinsaBukkenStatusBikou}" /></textarea>
        </div>
      </div>
      <p>
        <input type="hidden" name="updDt"   value="${view.updDt}">
        <input type="hidden" name="roomKey" value="${view.roomKey}">
        <input type="hidden" name="kanriCd" value="${view.kanriCd}">
        <input type="submit" value="確認画面へ">
        <input type="button" value="戻る" onClick="javascript:location.href='ReviewBukkenInfo.do?roomKey=${param.roomKey}'">
      </p>
    </html:form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
