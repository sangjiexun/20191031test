<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<table class="type_detail">
  <colgroup>
    <col span="1" width="20%">
    <col span="1" width="79%">
  </colgroup>
  <tr>
    <th class="text-left">店舗名</th>
    <td>
      <c:out value="${view.company}" />
      <c:if test="${not empty view.company and not empty view.bumon}"> / </c:if>
      <c:out value="${view.bumon}" />
    </td>
  </tr>
  <tr>
    <th class="text-left">店舗コード</th>
    <td><c:out value="${view.shopCd}" /></td>
  </tr>
  <tr>
    <th class="text-left">お客様設定パスワード</th>
    <td><c:out value="${view.password}" /></td>
  </tr>
</table>