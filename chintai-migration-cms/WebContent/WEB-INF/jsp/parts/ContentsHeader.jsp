<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="Content-Style-Type" content="text/css">
  <meta http-equiv="Content-Script-Type" content="text/javascript">
  <meta http-equiv="Cache-Control" content="no-cache">
  <meta http-equiv="Expires" content="0">
  <meta http-equiv="Pragma" content="no-cache">
  <title>CHINTAI.NET Management System<c:if test="${not empty title}"> - </c:if>${title}</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css?20141009">
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.numeric.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/util.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/menu.do?u=${sessionScope.SessionBean.encryptedUserId}&t=${sessionScope.SessionBean.encryptedToday}&type=1"></script>
</head>
<body>
<div id="container">
<div id="header">
  <p><html:link action="/Index">CHINTAI.NET Management System</html:link></p>
</div>
<!-- Release-Version: $Name$ -->
