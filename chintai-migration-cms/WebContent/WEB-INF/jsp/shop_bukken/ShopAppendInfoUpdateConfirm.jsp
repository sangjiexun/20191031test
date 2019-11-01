<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗付加情報更新確認" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<%@ include file="../parts/PopUpContentsHeadline.jsp"%>
<c:set var="view" value="${ShopBasicInfoUpdateView}" />

<script src="${pageContext.request.contextPath}/dwr/interface/AddressEnsenManager.js"></script>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>

<div id="main">
  <div class="popup_layout">
    <div class="topic_path">
      <a href ="<c:url value="ShopInfo.do"><c:param name="shopCd" value="${refData.shopRireki.shopcd}"/></c:url>">
        店舗・契約詳細
      </a>&gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <!-- エラーメッセージ -->
    <html:messages id ="errmsg" header="errors.header" footer="errors.footer">
      <c:out value="${errmsg}"></c:out>
    </html:messages>
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"></c:out>
    </html:messages>
	<form:errors path="shopAppendInfoUpdateForm.*" element="p" cssClass="notify"/>

    <!-- 店舗コード -->
    <p class="section_header"><a name="1">店舗コード</a></p>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th class="text-left">店舗名</th>
      <td>
        <c:out value="${refData.shopRireki.company}" />
        <c:if test="${not empty refData.shopRireki.company and not empty refData.shopRireki.bumon}"> / </c:if>
        <c:out value="${refData.shopRireki.bumon}" />
      </td>
      </tr>
      <tr>
        <th class="text-left">店舗コード</th>
        <td><c:out value="${refData.shopRireki.shopcd}" /></td>
      </tr>
      <tr>
        <th class="text-left">お客様設定パスワード</th>
        <td><c:out value="${crnwl:decypt(refData.shopRireki.passwordEnc)}" /></td>
      </tr>
    </table>

		<!-- 利用可能機能情報 -->
		<p class="section_header">
			<a name="2">付加情報更新確認</a>
		</p>

	<table class="type_detail_pre">
		<colgroup>
	        <col span="1" width="5%">
	        <col span="1" width="15%">
	        <col span="1" width="80%">
      	</colgroup>
	    <tbody>
	      	<c:set var="mstCmtKbns" value="${masterService.selectMstCommentKbnByDataKbn(MstCommentKbn.DATA_KBN_SHOP)}"/>
	      	<c:forEach items="${mstCmtKbns}" var="cmtKbn">
	      		<c:if test="${cmtKbn.commentKbn != '09' && cmtKbn.commentKbn != '10' && cmtKbn.commentKbn != '11'}">
					<tr>
						<th data-hoge>コメント</th>
				        <th><c:out value="${cmtKbn.commentKbnName}"/></th>
				        <td>
				        	<chintai:filter filter="false" changeNL2BR="true"><c:out value="${shopAppendInfoUpdateForm.comments[cmtKbn.commentKbn].commentText}"/></chintai:filter>
				        	<!--
							<c:if test="${cmtKbn.commentKbn == '08' }">
								<fmt:setBundle basename="resources.SystemProperties" var="resource" />
								<fmt:message bundle="${resource}" key="BUSY_COMMEN_SUFFIXT"	var="suffuixt" />
								<c:out value="${suffuixt}" />
							</c:if>
							 -->
						</td>
		    		</tr>
		    	</c:if>
		    </c:forEach>
	      <tr>
	         <th colspan="2">得意エリア</th>
	         <td>
	         	<ul class="list-unstyled list-inline list-sep">
		         	<c:forEach items="${shopAppendInfoUpdateForm.areas }" var="e" varStatus="stat">
						<c:set var="area" value="${e.value}"/>
						<c:set var="mstPref" value="${masterService.selectMstPrefByPrimaryKey(area.prefcd)}"/>
						<c:set var="mstCity" value="${masterService.selectMstCityByPrimaryKey(area.prefcd,area.citycd)}"/>
		         		<li>
							<c:out value="${masterService.selectMstPrefByPrimaryKey(area.prefcd).prefname}"/>
							<c:out value="${masterService.selectMstCityByPrimaryKey(area.prefcd,area.citycd).cityname}"/>
						</li>
		           </c:forEach>
	           </ul>
	         </td>
	      </tr>
	      <tr>
	         <th colspan="2">得意駅</th>
	         <td>
	         	<ul class="list-unstyled list-inline list-sep">
		         	<c:forEach items="${shopAppendInfoUpdateForm.ekis }" var="e" varStatus="stat">
						<c:set var="eki" value="${e.value}"/>
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

	<table class="type_detail_pre">
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
            <c:set var="charMap" value="${shopAppendInfoUpdateForm.charComments}"/>
         	<c:forEach items="${masterService.selectMstShopCharacter()}" var="mstChar">
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
	<form:form action="ShopAppendInfoUpdateCommit.admin" commandName="shopAppendInfoUpdateForm" onsubmit="disableSubmit(this)">
		<tags:token/>
		<p>
	      <c:forEach items="${shopAppendInfoUpdateForm.getClass().getDeclaredFields()}" var="f">
	      	<c:if test="${f.name != 'comments' && f.name != 'ekis' && f.name != 'charComments' && f.name != 'areas'}">
	      		<form:hidden path="${f.name}"/>
	      	</c:if>
	      </c:forEach>
	      <c:forEach items="${shopAppendInfoUpdateForm.comments}" var="e">
	      	<c:forEach items="${e.value.getClass().getDeclaredFields()}" var="f">
	      		<form:hidden path="comments[${e.key}].${f.name}"/>
	      	</c:forEach>
      	  </c:forEach>
	      <c:forEach items="${shopAppendInfoUpdateForm.ekis}" var="e">
	      	<c:forEach items="${e.value.getClass().getDeclaredFields()}" var="f">
	      		<form:hidden path="ekis[${e.key}].${f.name}"/>
	      	</c:forEach>
      	  </c:forEach>
	      <c:forEach items="${shopAppendInfoUpdateForm.areas}" var="e">
	      	<c:forEach items="${e.value.getClass().getDeclaredFields()}" var="f">
	      		<form:hidden path="areas[${e.key}].${f.name}"/>
	      	</c:forEach>
      	  </c:forEach>
	      <c:forEach items="${shopAppendInfoUpdateForm.charComments}" var="e">
	      	<c:forEach items="${e.value.getClass().getDeclaredFields()}" var="f">
	      		<form:hidden path="charComments[${e.key}].${f.name}"/>
	      	</c:forEach>
	      </c:forEach>
        	<input type="submit" value="更新">
        	<input type="submit" name="${BaseController.CANCEL_KEY}" value="戻る">
    	</p>
	</form:form>
  </div><!-- popup_layout END -->
</div><!-- main END -->
<%@ include file="../parts/ContentsFooter.jsp" %>