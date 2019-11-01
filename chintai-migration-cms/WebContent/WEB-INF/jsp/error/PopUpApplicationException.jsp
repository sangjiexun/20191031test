<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="エラー" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <p><html:errors/></p>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
