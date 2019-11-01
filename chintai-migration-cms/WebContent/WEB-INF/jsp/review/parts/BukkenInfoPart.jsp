<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.Date"
%>
      <table class="type_list">
      <tr>
        <th rowspan="2">店舗コード<br>状態</th>
        <th rowspan="2">会社名<br>事務所名</th>
        <th rowspan="2">CHINTAI掲載<br>エイブル掲載<br>連動元</th>
        <th rowspan="2">管理コード<br>状態</th>
        <th rowspan="2">物件名称</th>
        <th rowspan="2">CHINTAI NET<br>掲載状態</th>
        <th colspan="2">Web審査状態</th>
      </tr>
      <tr>
        <th>警告対象</th>
        <th>返信内容</th>
      </tr>
      <tr>
        <td>
          <c:out value="${view.shopCd}" /><br>
          <chintai:CodePrint code="${view.shopStatus}" nameKey="STATUS_NAME" valueKey="STATUS_VALUE"/>
        </td>
        <td class="left"><c:out value="${view.company}" /><br><c:out value="${view.bumon}" /></td>
        <td>
          <chintai:CodePrint nameKey="SHOPBUKKEN_CT_FLG_NAME" valueKey="SHOPBUKKEN_CT_FLG_VALUE" code="${view.ctStatus}"/><br>
          <chintai:CodePrint nameKey="SHOPBUKKEN_ABL_FLG_NAME" valueKey="SHOPBUKKEN_ABL_FLG_VALUE" code="${view.ablStatus}"/><br>
          <c:out value="${view.rendoName}" />
        </td>
        <td>
          ${view.kanriCd}<br>
          <c:if test="${view.ctStopDt != null && view.ablStopDt != null}">停止</c:if>
          <c:if test="${view.ctStopDt == null || view.ablStopDt == null}">通常</c:if>
        </td>
        <td class="left"><c:out value="${view.bkName}" /></td>
        <td>
          <c:if test="${view.changeSourceKbn == '2' && view.ctStopDt != null}">停止</c:if>
          <c:if test="${view.changeSourceKbn != '2' || view.ctStopDt == null}">通常</c:if>
        </td>
        <%@ include file="Shinsa.jsp" %>
      </tr>
    </table>