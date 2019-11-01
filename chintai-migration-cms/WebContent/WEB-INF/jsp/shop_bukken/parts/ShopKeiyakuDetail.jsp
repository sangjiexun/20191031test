<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ include file="../../parts/ContentsImport.jsp" %>
<%
final Date nowDate = new Date();
final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
final String str = sdf.format(nowDate).toString();
request.setAttribute("nowDate", str);
%>
<table class="type_detail_pre">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tbody>
	      <tr>
	        <th class="text-left">システム利用状態</th>
	<c:choose>
	    <c:when test="${view.shopStatus == '0'}">
	        <td><font color="#FF3333"><chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_STATUS_NAME" valueKey="SHOPBUKKEN_SHOP_STATUS_VALUE" code="${view.shopStatus}"/></font></td>
	    </c:when>
	    <c:otherwise>
	        <td><chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_STATUS_NAME" valueKey="SHOPBUKKEN_SHOP_STATUS_VALUE" code="${view.shopStatus}"/></td>
	    </c:otherwise>
	</c:choose>
	      </tr>
	      <tr>
	        <th class="text-left">CHNTAIに掲載</th>
	        <td>
				<chintai:CodePrint nameKey="SHOPBUKKEN_CT_FLG_NAME" valueKey="SHOPBUKKEN_CT_FLG_VALUE" code="${view.shopRireki.ctStatus}"/>
	            <fmt:setBundle basename="resources.server" var="resource" />
	            <c:if test="${view.shopRireki.ctStatus == '1'}">
	              <fmt:message bundle="${resource}" key="chintai.shopDetailUrl" var="chintaiShopDetailUrl">
	                <fmt:param><c:out value="${view.shopCd}" /></fmt:param>
	              </fmt:message>
	              (<a href="${chintaiShopDetailUrl}" target="_blank">この店舗のCHINTAI.NETでの表示を確認</a>)
	            </c:if>
	        </td>
	      </tr>
	      <tr>
	        <th class="text-left">エイブルに掲載</th>
	        <td>
				<chintai:CodePrint nameKey="SHOPBUKKEN_ABL_FLG_NAME" valueKey="SHOPBUKKEN_ABL_FLG_VALUE" code="${view.shopRireki.ablStatus}"/>
	               <c:if test="${view.shopRireki.ablStatus == '1'}">
	                 <fmt:message bundle="${resource}" key="able.shopDetailUrl" var="ableShopDetailUrl">
	                   <fmt:param><c:out value="${view.shopCd}" /></fmt:param>
	                 </fmt:message>
	                 (<a href="${ableShopDetailUrl}" target="_blank">この店舗のエイブルでの表示を確認</a>)
	               </c:if>
			</td>
	      </tr>
	      <tr>
	        <th class="text-left">備考</th>
	        <td><chintai:filter filter="false" changeNL2BR="true"><c:out value="${view.shopRireki.adminNote}"/></chintai:filter></td>
	      </tr>
	    </tbody>
    </table>
	<c:if test="${!empty view.vShopKeiyakuDetails }">
		<table class="type_detail">
	      <colgroup>
	        <col span="1" width="25%">
	        <col span="1" width="65%">
	        <col span="1" width="10%">
	      </colgroup>
	      <tbody>
		      <tr>
		        <th>契約種類</th>
		        <th>契約状況</th>
		        <th>予約件数</th>
		      </tr>
		      <c:set var="hasAuth" value="${!empty shopService.selectMngGroupAuthorityByUserIdAndAuthorityId(userId,'20')}"/>
		      <c:forEach items="${view.vShopKeiyakuDetails }" var="vShopKeiyakuDetail">
			      <tr>
			        <td>
			        	<c:choose>
			        		<c:when test="${!hasAuth}">
								<c:out value="${vShopKeiyakuDetail.keiyakuName }"/>
			        		</c:when>
			        		<c:when test="${vShopKeiyakuDetail.keiyakuCd == '00001' && vShopKeiyakuDetail.keiyakuSubCd == '000' && view.shopRireki.rendoCd == '0003'}">
								<c:out value="${vShopKeiyakuDetail.keiyakuName }"/>
			        		</c:when>
			        		<c:otherwise>
			        			<c:set var="url" value="ContractInfo.do"/>
			        			<a href ="<c:url value="${url}"><c:param name="shopCd" value="${view.shopCd}"/><c:param name="keiyakuCd" value="${vShopKeiyakuDetail.keiyakuCd}"/><c:param name="keiyakuSubCd" value="${vShopKeiyakuDetail.keiyakuSubCd}"/></c:url>">
			        				<c:out value="${vShopKeiyakuDetail.keiyakuName }"/>
			        			</a>
			        			<c:if test="${vShopKeiyakuDetail.keiyakuCd == '00005' && vShopKeiyakuDetail.keiyakuSubCd == '000'}">
			        				<a href ="<c:url value="AspShopInfo.do"><c:param name="shopCd" value="${view.shopCd}"/><c:param name="keiyakuCd" value="${vShopKeiyakuDetail.keiyakuCd}"/><c:param name="keiyakuSubCd" value="${vShopKeiyakuDetail.keiyakuSubCd}"/></c:url>">
			        				&nbsp;&nbsp;&nbsp;&nbsp;&gt;&gt; 不動産ASP設定情報を閲覧する
			        				</a>
			        			</c:if>
			        		</c:otherwise>
			        	</c:choose>
			        </td>
			        <td>
			        	<c:choose>
			        		<c:when test="${vShopKeiyakuDetail.keiyakuFlg == '1' }">
			        			<c:choose>
			        				<c:when test="${vShopKeiyakuDetail.keiyakuDetailKbn == '1' }">
			        					<c:out value="${vShopKeiyakuDetail.keiyakuAmount }"/> 件
			        				</c:when>
			        				<c:otherwise>
			        					契約済
			        				</c:otherwise>
			        			</c:choose>
			        		</c:when>
			        		<c:otherwise>
								<c:choose>
				        			<c:when test="${shopService.selectShopKeiyakuKanriList(view.shopCd,vShopKeiyakuDetail.keiyakuCd,vShopKeiyakuDetail.keiyakuSubCd,nowDate).size() > 0}">
				        				契約済
				        			</c:when>
									<c:otherwise>
				        			<div style="color:#FF3333;">未契約</div>
			        				<c:if test="${vShopKeiyakuDetail.keiyakuCd == '00005' && vShopKeiyakuDetail.keiyakuSubCd == '000' }">
			        					<c:forEach items="${view.vAspGroupShops }" var="vAspGroupShop">
				        					<div>
				        						<c:set var="aspShopRireki" value="${shopService.selectShopRirekiByShopcd(vAspGroupShop.shopcd) }"/>
				        						[代表店舗]
				        						<c:choose>
					        						<c:when test="${isReviewFlg == 'true'}">
														<c:out value="${vAspGroupShop.shopcd}:${aspShopRireki.company} / ${aspShopRireki.bumon}"/>
									        		</c:when>
					        						<c:otherwise>
					        							<a href ="<c:url value="/shop_bukken/ShopInfo.do"><c:param name="shopCd" value="${vAspGroupShop.shopcd}"/></c:url>" target="_blank">
					        								<c:out value="${vAspGroupShop.shopcd}:${aspShopRireki.company} / ${aspShopRireki.bumon}"/>
					        							</a>
					        						</c:otherwise>
				        						</c:choose>
				        					</div>
				        				</c:forEach>
			        				</c:if>
			        				</c:otherwise>
		        				</c:choose>
			        		</c:otherwise>
			        	</c:choose>
			        </td>
			        <td>
			        	<c:out value="${shopService.selectShopKeiyakuKanriList(view.shopCd,vShopKeiyakuDetail.keiyakuCd,vShopKeiyakuDetail.keiyakuSubCd,nowDate).size()}"/>
			        </td>
			      </tr>
		      </c:forEach>
	    	</tbody>
	    </table>
	</c:if>