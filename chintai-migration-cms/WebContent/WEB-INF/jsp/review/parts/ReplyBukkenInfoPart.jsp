<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.Date"
%>
      <table class="type_list">
        <tr>
          <th>沿線/駅<br>所在地</th>
          <th>所要時間</th>
          <th>家賃<br>管理費・共益費</th>
          <th>敷金<br>礼金</th>
          <th>保証金<br>解約金/償却金</th>
          <th>間取<br>面積</th>
          <th>建物種別<br>構造</th>
          <th>築年</th>
          <th>取引形態</th>
        </tr>
        <tr>
          <td>
            <label>
            <c:choose>
            	<c:when test="${view.otherTransName != null}">
            		<c:out value="${view.otherTransName}" />/
            		<c:out value="${view.otherTransPlatform}" /><br>
           	    </c:when>
           	    <c:otherwise>
	              	<c:if test="${view.ensenName != null}">
            			<c:out value="${view.ensenName}" />
            		</c:if>
            		<c:if test="${view.ensenName == null}">
            			--
            		</c:if>
            		/
            		<c:if test="${view.ekiName != null}">
            			<c:out value="${view.ekiName}" />
            		</c:if>
            		<c:if test="${view.ekiName == null}">
            			--
            		</c:if>
            		<br>
	            </c:otherwise>
            </c:choose>
            </label>
            <c:choose>
              <c:when test="${empty view.shozaichi}">
                --
              </c:when>
              <c:otherwise>
                <c:out value="${view.shozaichi}" />
              </c:otherwise>
            </c:choose>
          </td>
          <td>
            <c:if test="${view.ekiToho ne '0' and not empty view.ekiToho}">
              徒歩<c:out value="${view.ekiToho}" />分<br>
            </c:if>
            <c:if test="${view.bus ne '0' and not empty view.bus}">
              バス<c:out value="${view.bus}" />分　<c:out value="${view.busTei}"/>下車：停歩<c:out value="${view.busTeiho}" />分<br>
            </c:if>
            <c:if test="${view.car ne '0' and not empty view.car}">
              車移動　<c:out value="${view.car}" />分<c:out value="${view.carKyori}" />km
            </c:if>
          </td>
          <td>
            <c:choose>
              <c:when test="${view.chinryo eq 0}">
                --<br>
              </c:when>
              <c:otherwise>
                <fmt:formatNumber pattern="###,###,###,###円" type="number" value="${view.chinryo}" /><br>
              </c:otherwise>
            </c:choose>
            <c:choose>
              <c:when test="${not empty view.kanriKin and view.kanriKin ne 0}">
                <fmt:formatNumber pattern="###,###,###,###円" type="number" value="${view.kanriKin}" />
              </c:when>
              <c:otherwise>
                <label>--</label>
              </c:otherwise>
             </c:choose>
          </td>
          <td>
            <c:choose>
              <c:when test="${not empty view.shikiKin and view.shikiKin ne '0'}">
                <label><fmt:formatNumber maxFractionDigits="6" value="${view.shikiKin}" /><c:out value="${view.shikiTan}" /></label>
              </c:when>
              <c:otherwise>
                <label>--</label>
              </c:otherwise>
            </c:choose>
            <br>
            <c:choose>
              <c:when test="${not empty view.reiKin and view.reiKin ne '0'}">
                <label><fmt:formatNumber maxFractionDigits="6" value="${view.reiKin}" /><c:out value="${view.reiTan}" /></label>
              </c:when>
              <c:otherwise>
                <label>--</label>
              </c:otherwise>
            </c:choose>
          </td>
          <td>
            <c:choose>
              <c:when test="${not empty view.hoshoKin and view.hoshoKin ne '0'}">
                <label><fmt:formatNumber maxFractionDigits="6" value="${view.hoshoKin}" /><c:out value="${view.hoshoTan}" /></label>
              </c:when>
              <c:otherwise>
                <label>--</label>
              </c:otherwise>
            </c:choose>
            <br>
            <c:choose>
              <c:when test="${not empty view.kaiyakuKin and view.kaiyakuKin ne '0'}">
                <label><fmt:formatNumber maxFractionDigits="6" value="${view.kaiyakuKin}" /><c:out value="${view.kaiyakuTan}" /></label>
              </c:when>
              <c:otherwise>
                <label>--</label>
              </c:otherwise>
            </c:choose>
             /
            <c:choose>
              <c:when test="${not empty view.shoukyakuKin and view.shoukyakuKin != 0}">
                <fmt:formatNumber maxFractionDigits="6" value="${view.shoukyakuKin}" /><c:out value="${view.shoukyakuTan}" />
              </c:when>
              <c:otherwise>
              --
              </c:otherwise>
            </c:choose>
          </td>
          <td>
            <label>
	            <c:if test="${view.madori != null}">
	                <c:out value="${view.madori}" />
	            </c:if>
	            <c:if test="${view.madori == null}">
	                --
	            </c:if>
            </label><br>
            <label><c:out value="${view.senMenseki}" />平米</label>
          </td>
          <td>
            <label>
	            <c:if test="${view.shubetsu != null}">
	                <c:out value="${view.shubetsu}" />
	            </c:if>
	            <c:if test="${view.shubetsu == null}">
	                --
	            </c:if>
            </label>
            <br>
            <label>
	            <c:if test="${view.kouzou != null}">
	                <c:out value="${view.kouzou}" />
	            </c:if>
	            <c:if test="${view.kouzou == null}">
	                --
	            </c:if>
            </label>
          </td>
          <td>
            <label>
            	<c:if test="${view.chikunen != null}">
                	<c:out value="${view.chikunen}" />
	            </c:if>
	            <c:if test="${view.chikunen == null}">
	                --
	            </c:if>
            </label>
          </td>
          <td>
            <c:choose>
              <c:when test="${empty view.torihikikeitai}">
                --
              </c:when>
              <c:otherwise>
                <label><chintai:CodePrint code="${view.torihikikeitai}" nameKey="WEB_TORIHIKI_NAME" valueKey="WEB_TORIHIKI_VALUE"/></label>
              </c:otherwise>
            </c:choose>
          </td>

        </tr>
      </table>