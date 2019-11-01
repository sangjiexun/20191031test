<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="" />
<c:set var="view"  value="" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<script type="text/javascript">
<!--
  function win_close(){
        top.window.opener = top;
        top.window.open('','_parent', '');
        top.window.close();
  }
  document.onload=win_close();
-->
</script>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
    </div>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
