<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗付加情報更新" />
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
	<spring:bind path="shopAppendInfoUpdateForm.*">
	  <c:if test="${status.errors.errorCount > 0}">
	  	<c:set var="charMap" value="${masterService.toKeyObject(masterService.selectMstShopCharacter(),'charKbn') }"/>
	  	<c:set var="commentMap" value="${masterService.toKeyObject(masterService.selectMstCommentKbnByDataKbn(MstCommentKbn.DATA_KBN_SHOP),'commentKbn') }"/>
	  	<p class="notify">
		    <c:forEach var="error" items="${status.errors.allErrors}">
		    	<c:choose>
		    		<c:when test="${fn:indexOf(error.field ,'charComments') > -1 }">
		    			<c:set var="charKbn" value="${fn:substring( error.field ,  fn:indexOf(error.field ,'[') + 1 , fn:indexOf(error.field ,']') )}"/>
		    			<c:set var="hoge">
		    				<spring:message message="${error}"></spring:message>
		    			</c:set>
		    			<c:out value="${hoge.replaceAll('特徴条件',charMap[charKbn].charKbnDispName.concat('の')) }"/>
		    		</c:when>
		    		<c:when test="${fn:indexOf(error.field ,'comments') > -1 }">
		    			<c:set var="commentKbn" value="${fn:substring( error.field ,  fn:indexOf(error.field ,'[') + 1 , fn:indexOf(error.field ,']') )}"/>
		    			<c:set var="hoge">
		    				<spring:message message="${error}"></spring:message>
		    			</c:set>
		    			<c:out value="${hoge.replaceAll('コメント内容',commentMap[commentKbn].commentKbnName) }"/>
		    		</c:when>
		    		<c:otherwise>
		    			<spring:message message="${error}"></spring:message>
		    		</c:otherwise>
		    	</c:choose>
		    	<br>
		    </c:forEach>
	    </p>
	  </c:if>
	</spring:bind>
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

    <form:form action="ShopAppendInfoUpdateConfirm.admin" commandName="shopAppendInfoUpdateForm">
		<!-- 利用可能機能情報 -->
		<p class="section_header">
			<a name="2">付加情報更新</a>
		</p>
			<div class="caution">※店舗からの発信で上書きされる可能性があります。</div>
			<div class="add_form">
				<table class="type_detail">
					<colgroup>
						<col width="25%">
						<col width="75%">
					</colgroup>
					<tbody>
						<c:forEach items="${masterService.selectMstCommentKbnByDataKbn(MstCommentKbn.DATA_KBN_SHOP)}" var="mst">
							<c:if test="${mst.commentKbn != '09' && mst.commentKbn != '10' && mst.commentKbn != '11'}">
								<tr>
									<th>
										<c:out value="${mst.commentKbnName}"/>
										<%--
										<c:if test="${mst.commentRequiredFlg == '1' }">
											<span class="caution">*</span>
										</c:if>
										 --%>
									</th>
									<td>
										<c:if test="${mst.commentMaxLength <= 100 }">
											<chintai:inputResolveMaxLength style="width:50%" path="comments[${mst.commentKbn}].commentText" size="${mst.commentMaxLength}" maxlength="${mst.commentMaxLength}" />
										</c:if>
										<c:if test="${mst.commentMaxLength > 100 }">
											<chintai:textareaResolveMaxLength path="comments[${mst.commentKbn}].commentText" rows="5" cols="120" maxlength="${mst.commentMaxLength}" data-displength="true"/>
										</c:if>
										<!--
										<c:if test="${mst.commentKbn == '08' }">
											<fmt:setBundle basename="resources.SystemProperties" var="resource" />
											<fmt:message bundle="${resource}" key="BUSY_COMMEN_SUFFIXT"	var="suffuixt" />
											&nbsp;&nbsp;<c:out value="${suffuixt}" />
										</c:if>
										 -->
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="add_form">
				<div class="add_form_title">得意エリア設定</div>
				<div class="annotation">得意エリア（最大１０市区町村）と物件数を設定します。</div>
				<tags:prefCitySelectUI/>
			</div>
			<c:if test="${!empty shopAppendInfoUpdateForm.areas}">
				<c:set var="json">
					<json:array items="${shopAppendInfoUpdateForm.areas}" var="item">
						<c:set var="mstPref" value="${masterService.selectMstPrefByPrimaryKey(item.prefcd)}"/>
						<c:set var="mstCity" value="${masterService.selectMstCityByPrimaryKey(item.prefcd,item.citycd)}"/>
						<c:set var="isValid" value="${false}"/>
						<c:if test="${mstPref != null && mstCity.delKbn == 0 && mstCity.fuyouFlg == 0}">
							<c:set var="isValid" value="${true}"/>
						</c:if>
						<c:if test="${isValid}">
							<json:object>
								<json:property name="prefcd" value="${item.prefcd}"/>
								<json:property name="citycd" value="${item.citycd}"/>
								<json:property name="prefname" value="${mstPref.prefname}"/>
								<json:property name="cityname" value="${mstCity.cityname}"/>
							</json:object>
						</c:if>
					</json:array>
				</c:set>
				<script type="text/javascript">
					var _selectEki = $('#__selectedCity');
					var list = $.grep(${json},function(e){return e;});
					$.each(list,function(){
						_selectEki.append($('<option />').html(this.prefname + this.cityname).data('area',this));
					});
				</script>
			</c:if>
			<script type="text/javascript">
				$('#shopAppendInfoUpdateForm').submit(function(){
					$('#__selectedCity').children().each(function(i){
						var area = $(this).data('area');
						var idx = i + 1;
						$('<input>').attr({type: 'hidden',name: 'areas['+ idx +'].prefcd',value : area.prefcd}).appendTo('#shopAppendInfoUpdateForm');
						$('<input>').attr({type: 'hidden',name: 'areas['+ idx +'].citycd',value : area.citycd}).appendTo('#shopAppendInfoUpdateForm');
					});
				});
			</script>
			<div class="add_form">
				<div class="add_form_title">
					得意沿線/駅設定
				</div>
				<div class="annotation">得意沿線/駅（最大１０駅）を設定します。</div>
				<tags:ensenEkiSelectUI/>
			</div>
		<c:if test="${!empty shopAppendInfoUpdateForm.ekis}">
			<c:set var="json">
				<json:array items="${shopAppendInfoUpdateForm.ekis}" var="item">
					<c:set var="mstEnsen" value="${masterService.selectMstEnsenByPrimaryKey(item.ensencd)}"/>
					<c:set var="mstEki" value="${masterService.selectMstEkiByPrimaryKey(item.ensencd,item.ekicd)}"/>
					<c:set var="isValid" value="${false}"/>
					<c:if test="${mstEnsen.delKbn == 0 && mstEki.delKbn == 0}">
						<c:set var="isValid" value="${true}"/>
					</c:if>
					<c:if test="${isValid}">
						<json:object>
							<json:property name="ensencd" value="${item.ensencd}"/>
							<json:property name="ekicd" value="${item.ekicd}"/>
							<json:property name="ensenname" value="${mstEnsen.ensenname}"/>
							<json:property name="ekiname" value="${mstEki.ekiname}"/>
						</json:object>
					</c:if>
				</json:array>
			</c:set>
			<script type="text/javascript">
				var _selectEki = $('#_selectEki');
				var list = $.grep(${json},function(e){return e;});
				$.each(list,function(){
					_selectEki.append($('<option />').html(this.ensenname + this.ekiname).data('eki',this));
				});
			</script>
		</c:if>
		<script type="text/javascript">
			$(':radio[name=_searchType][value=3]').parents('tr').hide();
			$('#shopAppendInfoUpdateForm').submit(function(){
				$('#_selectEki').children().each(function(i){
					var eki = $(this).data('eki');
					var idx = i + 1;
					$('<input>').attr({type: 'hidden',name: 'ekis['+ idx +'].ensencd',value : eki.ensencd}).appendTo('#shopAppendInfoUpdateForm');
					$('<input>').attr({type: 'hidden',name: 'ekis['+ idx +'].ekicd',value : eki.ekicd}).appendTo('#shopAppendInfoUpdateForm');
				});
			});
		</script>
<%--
			<div class="add_form">
				<div class="add_form_title">一覧アイコン表示</div>
				<div class="annotation">一覧アイコンを設定します。</div>
				<div class="form_space">
					<ul class="list-unstyled list-inline">
						<li>
							<label><form:checkbox path="listIconFlgMovie" value="1"/>動画</label>
						</li>
						<li>
							<label><form:checkbox path="listIconFlgCampaign" value="1"/>キャンペーン</label>
						</li>
						<li>
							<label><form:checkbox path="listIconFlgShop" value="1"/>オススメ店舗</label>
						</li>
					</ul>
				</div>
			</div>
--%>
			<div class="add_form">
				<div class="add_form_title">特徴アイコン</div>
				<div class="annotation">特徴アイコンを指定します。優先表示は最大３個まで選択可能。</div>
					<div class="form_space">
					<table class="type_list" style="width: 99%;">
						<colgroup>
			              <!-- <col width="15%"> -->
			              <col width="25%" align="left">
			              <col width="30%" align="left">
			              <col width="6%">
			              <col width="5%">
			              <col width="6%">
			              <col width="28%">
			            </colgroup>
						<tbody>
							<tr>
				              <!-- <th>特徴アイコン</th> -->
				              <th>特徴アイコン名</th>
				              <th>内容</th>
				              <th>WEB</th>
				              <th>選択</th>
				              <th>優先表示選択</th>
				              <th>コメント</th>
				            </tr>
				         	<c:forEach items="${masterService.selectMstShopCharacter()}" var="mst">
				         		<c:set var="checked" value="${empty shopAppendInfoUpdateForm.charComments[mst.charKbn] ? '':'checked'}"/>
								<tr>
									<!--
									<td>
										<c:if test="${! empty mst.charImgUrl }">
											<img src="${mst.charImgUrl}">
										</c:if>
									</td>
									 -->
									<td><c:out value="${mst.charKbnDispName}"/> </td>
									<td><c:out value="${mst.charExplain}"/> </td>
									<td>
										<c:choose>
											<c:when test="${mst.charSiteFlg == '0'}">
												CHINTAI<br>エイブル
											</c:when>
											<c:when test="${mst.charSiteFlg == '1'}">
												CHINTAI
											</c:when>
											<c:when test="${mst.charSiteFlg == '2'}">
												エイブル
											</c:when>
										</c:choose>
									</td>
									<td>
										<input ${checked } type="checkbox" name="charCommentsSelect" onclick="
											$('#charComments${mst.charKbn}_charComment').prop('disabled',!this.checked);
											$('#charComments${mst.charKbn}_priorityDispFlg').prop('disabled',!this.checked);
										">
									</td>
									<td>
										<c:if test="${ mst.charSiteFlg != '2'}">
											<form:checkbox id="charComments${mst.charKbn}_priorityDispFlg" path="charComments[${mst.charKbn}].priorityDispFlg" value="1" disabled="true"/>
										</c:if>
									</td>
									<td>
										<chintai:textareaResolveMaxLength id="charComments${mst.charKbn}_charComment" rows="2" cols="50" path="charComments[${mst.charKbn}].charComment" maxlength="${mst.charCommentMaxLength}" data-displength="true"/>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<script type="text/javascript">
						$(function(){
							$(':checkbox[name=charCommentsSelect]').each(function(){
								$(this).triggerHandler('click');
							});
							$(':checkbox[name*=priorityDispFlg]').each(function(){
								$(this).click(function(){
									var i = $(':checkbox[name*=priorityDispFlg]:checked').length;
									if(i > 3){
										this.checked = false;
									}
								});
							});
						});
					</script>
				</div>
			</div>

			<p>
			<form:hidden path="shopcd"/>
			<form:hidden path="shopKanriUpdDt"/>
        	<input type="submit" value="確認画面へ">
        	<input type="submit" name="${BaseController.CANCEL_KEY}" value="戻る">
    	</p>
	</form:form>
  </div><!-- popup_layout END -->
</div><!-- main END -->
<%@ include file="../parts/ContentsFooter.jsp" %>