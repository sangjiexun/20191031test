<%@page import="net.chintai.backend.sysadmin.common.properties.ServerProperties"%>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="キャンペーン情報更新"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>


<div id="main">
  <div class="popup_layout">
    <div class="topic_path">
      <a href ="#" onclick="$('#_cancelBtn').click();">
        店舗・契約詳細
      </a>&gt;
        ${title}
    </div>
    <h1>${title}</h1>
    <html:messages id ="errmsg" header="errors.header" footer="errors.footer">
      <c:out value="${errmsg}"></c:out>
    </html:messages>
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"></c:out>
    </html:messages>
	<spring:bind path="shopImageCampaignUpdateForm.*">
	  <c:if test="${status.errors.errorCount > 0}">
	  	<p class="notify">
	  		<c:forEach var="sortError" items="${sortErrorsList}">
			    <c:forEach var="error" items="${status.errors.allErrors}">
			    	<c:if test="${sortError == error.field}">
				    	<c:if test="${!error.field.startsWith('comments')}">
					    	キャンペーン内容<c:out value="${fn:substring( error.field , 10 , fn:indexOf(error.field ,']') )}"/>:
					    </c:if>
				    	<spring:message message="${error}"></spring:message><br>
			    	</c:if>
			    </c:forEach>
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
    <!-- 店舗画像 -->
		<form:form action="ShopImageCampaignUpdateConfirm.admin" commandName="shopImageCampaignUpdateForm" enctype="multipart/form-data">
    		<p class="section_header">キャンペーン情報</p>
    		<c:set var="tmpPath" value="/tmp/img/"/>
			<table class="type_detail">
				<colgroup>
			        <col width="1%">
			        <col width="1%">
			        <col width="64%">
			        <col width="34%">
		      	</colgroup>
				<tbody>
					<tr>
						<th>削除</th>
						<th colspan="2">キャンペーン内容</th>
						<th>キャンペーン画像<br>アップロードファイル</th>
					</tr>
						<jsp:useBean id="now" class="org.joda.time.DateTime"/>
						<c:forEach var="e" items="${shopImageCampaignUpdateForm.campaigns}" varStatus="stat">
							<c:set var="campaign" value="${e.value}"/>
							<c:set var="i" value="${e.key}"/>
							<tr>
								<th><form:checkbox path="campaigns[${i}].del"/> </th>
								<th><c:out value="${i}"/></th>
								<td>
									<table class="type_none">
										<tbody>
											<tr>
												<td colspan="2">
													<table class="type_none">
														<tbody>
															<tr>
																<td>キャンペーン開始日<span class="caution">*</span></td>
																<td>
																	<select id="startY${i}">
																		<option value="" selected="selected"></option>
																		<c:forEach var="j" begin="2007" end="${now.year + 3}">
																			<option value="${j}">${j}</option>
																		</c:forEach>
																	</select>年
																	<select id="startM${i}">
																		<option value="" selected="selected"></option>
																		<c:forEach var="j" begin="1" end="12">
																			<option value="${j<10?'0':''}${j}">${j}</option>
																		</c:forEach>
																	</select>月
																	<select id="startD${i}">
																		<option value="" selected="selected"></option>
																		<c:forEach var="j" begin="1" end="31">
																			<option value="${j<10?'0':''}${j}">${j}</option>
																		</c:forEach>
																	</select>日
																	&nbsp;～&nbsp;
																	キャンペーン終了日&nbsp;
																	<select id="endY${i}">
																		<option value="" selected="selected"></option>
																		<c:forEach var="j" begin="2007" end="${now.year + 3}">
																			<option value="${j}">${j}</option>
																		</c:forEach>
																	</select>年
																	<select id="endM${i}">
																		<option value="" selected="selected"></option>
																		<c:forEach var="j" begin="1" end="12">
																			<option value="${j<10?'0':''}${j}">${j}</option>
																		</c:forEach>
																	</select>月
																	<select id="endD${i}">
																		<option value="" selected="selected"></option>
																		<c:forEach var="j" begin="1" end="31">
																			<option value="${j<10?'0':''}${j}">${j}</option>
																		</c:forEach>
																	</select>日
																	<form:hidden path="campaigns[${i}].campaignStartYmd"/>
																	<form:hidden path="campaigns[${i}].campaignEndYmd"/>
																	<script>
																		$(function(){
																			var s = $('#campaigns${i}\\.campaignStartYmd').val();
																			var e = $('#campaigns${i}\\.campaignEndYmd').val();
																			if(s != ''){
																				$('#startY${i}').val(s.substring(0,4));
																				$('#startM${i}').val(s.substring(4,6));
																				$('#startD${i}').val(s.substring(6));
																			}
																			if(e != ''){
																				$('#endY${i}').val(e.substring(0,4));
																				$('#endM${i}').val(e.substring(4,6));
																				$('#endD${i}').val(e.substring(6));
																			}
																			$('#shopImageCampaignUpdateForm').submit(function(){
																				if(!$('#campaigns${i}\\.del1').prop('checked')){
																					$('#campaigns${i}\\.campaignStartYmd').val($('#startY${i}').val() + $('#startM${i}').val() + $('#startD${i}').val());
																					$('#campaigns${i}\\.campaignEndYmd').val($('#endY${i}').val() + $('#endM${i}').val() + $('#endD${i}').val());
																				}else{
																					$('#campaigns${i}\\.campaignStartYmd').val('');
																					$('#campaigns${i}\\.campaignEndYmd').val('');
																				}
																			});
																		});
																	</script>
																</td>
															</tr>
															<tr>
																<td>利用対象<span class="caution">*</span></td>
																<td>
																	<input type="radio" value="1" name="target${i}_1" checked="checked">
																	<select id="campaignRiyouTaisyo${i}">
																		<option></option>
																		<c:forEach var="v" items="${refData.campaignRiyoutaisyos}">
																			<option value="${v}"><c:out value="${v}"></c:out></option>
																		</c:forEach>
																	</select>
																</td>
															</tr>
															<tr>
																<td></td>
																<td>
																	<input type="radio" value="2" name="target${i}_1">
																	<chintai:inputResolveMaxLength path="campaigns[${i}].campaignRiyouTaisyo"/>
																	<script>
																		$(function(){
																        	$(':radio[name=target${i}_1]').click(function(){
																				var radio = $(this);
																				$('#campaignRiyouTaisyo${i},#campaigns${i}\\.campaignRiyouTaisyo').prop('disabled',true);
																				var e = radio.next();
																				if(radio.prop('checked')){
																					e.prop('disabled',false);
																				}
																        	}).triggerHandler('click');
																			var select = $('#campaignRiyouTaisyo${i}');
																			var input = $('#campaigns${i}\\.campaignRiyouTaisyo');
																			select.val(input.val());
																			if(select.val() && input.val() != ''){
																				input.val('');
																				$(':radio[name=target${i}_1][value=1]').prop('checked', true).trigger('click');
																			}else if(input.val() != ''){

																				$(':radio[name=target${i}_1][value=2]').prop('checked', true).trigger('click');
																			}
																			$('#shopImageCampaignUpdateForm').submit(function(){
																				if(!$('#campaigns${i}\\.del1').prop('checked')){
																					if($(':radio[name=target${i}_1]:checked').val() == '1'){
																						$('#campaigns${i}\\.campaignRiyouTaisyo').val($('#campaignRiyouTaisyo${i}').val()).prop('disabled',false);
																					}
																				}
																			});
																		});
																	</script>
																</td>
															</tr>
															<tr>
																<td>特典<span class="caution">*</span></td>
																<td>
																	<input type="radio" value="1" name="target${i}_2" checked="checked">
																	<select id="campaignTokuten${i }">
																		<option value=""></option>
																		<c:forEach var="v" items="${refData.campaignTokutens}">
																			<option value="${v}"><c:out value="${v}"></c:out></option>
																		</c:forEach>
																	</select>
																</td>
															</tr>
															<tr>
																<td></td>
																<td>
																	<input type="radio" value="2" name="target${i}_2">
																	<chintai:inputResolveMaxLength path="campaigns[${i}].campaignTokuten"/>
																	<script>
																		$(function(){
																        	$(':radio[name=target${i}_2]').click(function(){
																				var radio = $(this);
																				$('#campaignTokuten${i},#campaigns${i}\\.campaignTokuten').prop('disabled',true);
																				var e = radio.next();
																				if(radio.prop('checked')){
																					e.prop('disabled',false);
																				}
																        	}).triggerHandler('click');
																			var select = $('#campaignTokuten${i}');
																			var input = $('#campaigns${i}\\.campaignTokuten');
																			select.val(input.val());
																			if(select.val() && input.val() != ''){
																				input.val('');
																				$(':radio[name=target${i}_2][value=1]').prop('checked', true).trigger('click');
																			}else if(input.val() != ''){

																				$(':radio[name=target${i}_2][value=2]').prop('checked', true).trigger('click');
																			}
																			$('#shopImageCampaignUpdateForm').submit(function(){
																				if(!$('#campaigns${i}\\.del1').prop('checked')){
																					if($(':radio[name=target${i}_2]:checked').val() == '1'){
																						$('#campaigns${i}\\.campaignTokuten').val($('#campaignTokuten${i}').val()).prop('disabled',false);
																					}
																				}
																			});
																		});
																	</script>
																</td>
															</tr>
															<tr>
																<td>提示条件<span class="caution">*</span></td>
																<td>
																	<input type="radio" value="1" name="target${i}_3" checked="checked">
																	<select id="campaignJouken${i}">
																		<option value=""></option>
																		<c:forEach var="v" items="${refData.campaignJoukens}">
																			<option value="${v}"><c:out value="${v}"></c:out></option>
																		</c:forEach>
																	</select>
																</td>
															</tr>
															<tr>
																<td></td>
																<td>
																	<input type="radio" value="2" name="target${i}_3">
																	<chintai:inputResolveMaxLength path="campaigns[${i}].campaignJouken"/>
																	<script>
																		$(function(){
																        	$(':radio[name=target${i}_3]').click(function(){
																				var radio = $(this);
																				$('#campaignJouken${i},#campaigns${i}\\.campaignJouken').prop('disabled',true);
																				var e = radio.next();
																				if(radio.prop('checked')){
																					e.prop('disabled',false);
																				}
																        	}).triggerHandler('click');
																			var select = $('#campaignJouken${i}');
																			var input = $('#campaigns${i}\\.campaignJouken');
																			select.val(input.val());
																			if(select.val() && input.val() != ''){
																				input.val('');
																				$(':radio[name=target${i}_3][value=1]').prop('checked', true).trigger('click');
																			}else if(input.val() != ''){
																				$(':radio[name=target${i}_3][value=2]').prop('checked', true).trigger('click');
																			}
																			$('#shopImageCampaignUpdateForm').submit(function(){
																				if(!$('#campaigns${i}\\.del1').prop('checked')){
																					if($(':radio[name=target${i}_3]:checked').val() == '1'){
																						$('#campaigns${i}\\.campaignJouken').val($('#campaignJouken${i}').val()).prop('disabled',false);
																					}
																				}
																			});
																		});
																	</script>
																</td>
															</tr>
															<tr>
																<td>キャンペーンコメント</td>
																<td>
																	<chintai:inputResolveMaxLength size="100" path="campaigns[${i}].campaignComment"/>
																</td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
								<td>
									<p>
										<c:choose>
											<c:when test="${! empty campaign.imgOuterUrl}">
												<a href="${campaign.imgOuterUrl}" target="_blank">${campaign.imgOuterUrl}</a>
											</c:when>
											<c:when test="${! empty campaign.imgUrlPath}">
												<c:choose>
													<c:when test="${campaign.imgUrlPath.startsWith(tmpPath)}">
														<img src="<c:url value="${campaign.imgUrlPath}${campaign.imgFileNm}"/>" width="227">
													</c:when>
													<c:otherwise>
														<img src="https://${campaign.imgUrlPath}${campaign.imgFileNm}?resize=227:*">
													</c:otherwise>
												</c:choose>
												<button type="button" onclick="
													$(this).prev().remove();
													$(this).hide();
													$('#campaigns${i}\\.imgUrlPath,#campaigns${i}\\.imgFileNm').val('');
													$(this).before('画像がありません。');
													">画像削除</button>
											</c:when>
											<c:otherwise>
												画像がありません。
											</c:otherwise>
										</c:choose>
									</p>
									<c:if test="${! empty campaign.imgOuterUrl}">
										<br><br>サムネイル <a href="${campaign.imgThumbnailUrl}" target="_blank">${campaign.imgThumbnailUrl}</a>
									</c:if>
									<p>
										アップロードファイル
										<input type="file" name="campaigns[${i}].file" accept="image/jpeg"/>
									</p>
									<form:hidden path="campaigns[${i}].imgKbn"/>
									<form:hidden path="campaigns[${i}].imgUrlPath"/>
									<form:hidden path="campaigns[${i}].imgFileNm"/>
									<form:hidden path="campaigns[${i}].existCurrentShopRirekiCampaign"/>
								</td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
			<script>
				$(function(){
					$('[name*=del]:checkbox').click(function(){
						var chk = $(this);
						chk.parent().nextAll().find('*:not(:hidden)').prop('disabled',chk.prop('checked'));
					});
					$('[name*=del]:checkbox').each(function(){
						var chk = $(this);
						if(chk.prop('checked')){
							chk.parent().nextAll().find('*:not(:hidden)').prop('disabled',true);
						}
					});
					$('input[type=file]').change(function(e){
						var ok = /\.(jpe?g|gif|png)$/i.test($(e.target).val());
						if(!ok){
							$(e.target).val('');
						}
					});
					$('#shopImageCampaignUpdateForm').submit(function(){
						$('input[type=file]').each(function(){
							if($(this).val() != ''){
							}else{
								$(this).prop('disabled',true);
							}
						});
					});
					var accepts =[];
					<c:forEach var="mstContentTypes" items="${masterService.getReceiveMstContentType()}">
					accepts.push('${mstContentTypes.contentType}');
					</c:forEach>
					$('input[type=file]').attr('accept',accepts.join(','));
				});
			</script>
			<c:set var="mstCmtKbns" value="${masterService.selectMstCommentKbnByDataKbn(MstCommentKbn.DATA_KBN_SHOP)}"/>
			<table class="type_detail">
				<colgroup>
					<col width="25%">
					<col width="75%">
				</colgroup>
				<tbody>
			      	<c:forEach items="${mstCmtKbns}" var="cmtKbn">
			      		<c:if test="${cmtKbn.commentKbn == '09' || cmtKbn.commentKbn == '10' || cmtKbn.commentKbn == '11'}">
							<tr>
						        <th><c:out value="${cmtKbn.commentKbnName}"/></th>
						        <td>
						        	<chintai:inputResolveMaxLength path="comments[${cmtKbn.commentKbn}].commentText" maxlength="${cmtKbn.commentMaxLength}" data-displength="true"/>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>

			<p>
				<form:hidden path="shopcd"/>
				<form:hidden path="shopKanriUpdDt"/>
				<form:hidden path="imgId"/>
	        	<input type="submit" value="確認画面へ">
	        	<input type="submit" name="${BaseController.CANCEL_KEY}" value="戻る" id="_cancelBtn">
    		</p>
		</form:form>
	</div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
