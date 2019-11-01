<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<p>
  <c:out value="${helper.count}"/> 件中
  <c:out value="${helper.offset + 1}"/> 件目 ～
  <c:out value="${helper.currentLastOffset + 1}"/> 件目を表示中です。
</p>