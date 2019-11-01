<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.Date"
%>
      <td>
          <c:choose>
            <c:when test="${empty view.warningCd}">
              なし
            </c:when>
            <c:when test="${view.warningCd eq '0'}">
              初回審査警告対象
            </c:when>
            <c:otherwise>
              定期審査警告対象
            </c:otherwise>
          </c:choose>
        </td>
        <td>
          <c:choose>
                  <c:when test="${empty view.warningCd}">
                    なし
                  </c:when>
                  <c:when test="${view.warningCd eq '0'}">
                    <c:choose>
                      <c:when test="${view.statusKbn eq '0'}">
	                    未送信
	                  </c:when>
                      <c:when test="${view.statusKbn eq '1'}">
	                    <c:out value="${view.syokaiAutoDelDt}" />&nbsp;削除予定
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '2' and  view.syoriKbn eq '3'}">
	                    問題なし
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '2' and  view.syoriKbn ne '3'}">
	                    問題あり
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '3'}">
	                    自動削除
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '4'}">
	                    警告無効(再発信）
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '5'}">
	                    警告無効（掲載落ち）
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '6'}">
	                    警告無効（最新警告回答済）
	                  </c:when>
	                </c:choose>
                  </c:when>
                  <c:otherwise>
                    <c:choose>
                      <c:when test="${view.statusKbn eq '0'}">
	                    未送信
	                  </c:when>
                      <c:when test="${view.statusKbn eq '1'}">
	                    <c:out value="${view.teikiAutoDelDt}" />&nbsp;削除予定
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '2' and  view.syoriKbn eq '3'}">
	                    問題なし
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '2' and  view.syoriKbn ne '3'}">
	                    問題あり
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '3'}">
	                    自動削除
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '4'}">
	                    警告無効(再発信）
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '5'}">
	                    警告無効（掲載落ち）
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '6'}">
	                    警告無効（最新警告回答済）
	                  </c:when>
	                </c:choose>
                  </c:otherwise>
                </c:choose>
        </td>