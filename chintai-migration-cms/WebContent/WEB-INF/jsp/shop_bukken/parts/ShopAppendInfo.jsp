<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../../parts/ContentsImport.jsp" %>
    <table class="type_detail_pre">
		<colgroup>
	        <col span="1" width="5%">
	        <col span="1" width="15%">
	        <col span="1" width="80%">
      	</colgroup>
	    <tbody>
	      	<c:set var="cmtMap" value="${masterService.toKeyObject(view.shopRirekiComments,'commentKbn') }"/>
	      	<c:set var="mstCmtKbns" value="${masterService.selectMstCommentKbnByDataKbn(MstCommentKbn.DATA_KBN_SHOP)}"/>
	      	<c:forEach items="${mstCmtKbns}" var="cmtKbn">
	      		<c:if test="${cmtKbn.commentKbn != '09' && cmtKbn.commentKbn != '10' && cmtKbn.commentKbn != '11'}">
					<tr>
						<th class="text-left" data-hoge>コメント</th>
				        <th class="text-left"><c:out value="${cmtKbn.commentKbnName}"/></th>
				        <td>
				        	<chintai:filter filter="false" changeNL2BR="true"><c:out value="${cmtMap[cmtKbn.commentKbn].commentText}"/></chintai:filter>
							<c:if test="${cmtKbn.commentKbn == '08' }">
								<c:out value="${suffuixt}" />
							</c:if>
						</td>
		    		</tr>
		    	</c:if>
		    </c:forEach>
	      <tr>
	         <th class="text-left" colspan="2">得意エリア</th>
	         <td>
	         	<ul class="list-unstyled list-inline list-sep">
		         	<c:forEach items="${view.shopRirekiProudAreas }" var="area" varStatus="stat">
		         		<li>
							<c:out value="${masterService.selectMstPrefByPrimaryKey(area.prefcd).prefname}"/>
							<c:out value="${masterService.selectMstCityByPrimaryKey(area.prefcd,area.citycd).cityname}"/>
						</li>
		           </c:forEach>
	           </ul>
	         </td>
	      </tr>
	      <tr>
	         <th class="text-left" colspan="2">得意駅</th>
	         <td>
	         	<ul class="list-unstyled list-inline list-sep">
		         	<c:forEach items="${view.shopRirekiProudEkis }" var="eki" varStatus="stat">
		         		<li>
							<c:out value="${masterService.selectMstEnsenByPrimaryKey(eki.ensencd).ensenname}"/>
							<c:out value="${masterService.selectMstEkiByPrimaryKey(eki.ensencd,eki.ekicd).ekiname}"/>
						</li>
		         	</c:forEach>
		         </ul>
	         </td>
	      </tr>
	    </tbody>
	</table>
	<script type="text/javascript">
		var trs = $('[data-hoge]');
		$(trs.get(0)).attr('rowspan',trs.length);
		for(var i = 1;i < trs.length ; i++){
			$(trs.get(i)).remove();
		}
	</script>
	<c:if test="${!empty view.shopRirekiCharacters}">
		<table class="type_list">
			<colgroup>
	              <!-- <col width="15%"> -->
	              <col width="30%">
	              <col width="30%">
	              <col width="5%">
	              <col width="5%">
	              <col width="30%">
	      	</colgroup>
	      <tbody>
	            <tr>
	              <!-- <th>特徴アイコン</th> -->
	              <th>特徴アイコン名</th>
	              <th>内容</th>
	              <th>WEB</th>
	              <th>優先表示</th>
	              <th>コメント</th>
	            </tr>
				<c:set var="charMap" value="${masterService.toKeyObject(view.shopRirekiCharacters,'charKbn') }"/>
	      		<c:forEach items="${masterService.selectMstShopCharacter()}" var="mstChar" varStatus="stat">
	      			<c:if test="${! empty charMap[mstChar.charKbn]}">
			            <tr>
			              <!--
			              <td>
			              	<c:if test="${! empty mstChar.charImgUrl }">
			              		<img src="${mstChar.charImgUrl}">
			              	</c:if>
			              </td>
			              -->
			              <td class="text-left"><c:out value="${mstChar.charKbnName}"/></td>
			              <td class="text-left"><c:out value="${mstChar.charExplain}"/></td>
			              <td>
			              		<c:choose>
			              			<c:when test="${mstChar.charSiteFlg == '0' }">
			              				CHINTAI<br>エイブル
			              			</c:when>
			              			<c:when test="${mstChar.charSiteFlg == '1' }">
			              				CHINTAI
			              			</c:when>
			              			<c:when test="${mstChar.charSiteFlg == '2' }">
			              				エイブル
			              			</c:when>
			              		</c:choose>
			              </td>
			              <td>${charMap[mstChar.charKbn].priorityDispFlg == '1' ? '優先' :''}</td>
			              <td class="text-left">
			              	<chintai:filter filter="false" changeNL2BR="true"><c:out value="${charMap[mstChar.charKbn].charComment}"/></chintai:filter>
			              </td>
			            </tr>
		            </c:if>
	            </c:forEach>
	    	</tbody>
	    </table>
	</c:if>