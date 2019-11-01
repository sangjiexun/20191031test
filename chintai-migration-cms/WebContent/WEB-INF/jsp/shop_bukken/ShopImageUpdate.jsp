<%@page import="net.chintai.backend.sysadmin.common.properties.ServerProperties"%>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗画像更新"></c:set>
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
	<spring:bind path="shopImageUpdateForm.*">
	  <c:if test="${status.errors.errorCount > 0}">
	  	<c:set var="imgKbnMap" value="${masterService.toKeyObject(masterService.selectMstImgKbn(),'imgKbn') }"/>
	  	<p class="notify">
	  		<c:forEach var="sortError" items="${sortErrorsList}">
			    <c:forEach var="error" items="${status.errors.allErrors}">
			    	<c:if test="${sortError == error.field}">
				    	<c:choose>
				    		<c:when test="${fn:substring( error.field , 5 , fn:indexOf(error.field ,']') ) == 0}">
				    			インフォメーション:
				    		</c:when>
				    		<c:when test="${fn:substring( error.field , 5 , fn:indexOf(error.field ,']') ) == 1}">
				    			会社ロゴ:
				    		</c:when>
				    		<c:otherwise>
				    			店舗更新画像<c:out value="${fn:substring( error.field , 5 , fn:indexOf(error.field ,']') ) 	 - 1}"/>:
				    		</c:otherwise>
				    	</c:choose>
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
	<style>
		table{ height: 100%;}
		table td{ height: 100%}
		table td table{width:100%}
		table td table tr td{ border: 0px solid !important}
	</style>
    <!-- 店舗画像 -->
		<form:form action="ShopImageUpdateConfirm.admin" commandName="shopImageUpdateForm" enctype="multipart/form-data">
    		<p class="section_header">現在の店舗画像</p>
    		<c:set var="tmpPath" value="/tmp/img/"/>
			<table class="type_detail">
				<colgroup>
					<col width="1%">
			        <col width="8%">
			        <col width="45%">
			        <col width="46%">
		      	</colgroup>
				<tbody>
					<tr>
						<th>削除</th>
						<th>画像名</th>
						<th>店舗画像</th>
						<th>アップロードファイル<br>画像コメント</th>
					</tr>
					<c:set var="increment" value="0" />
					<c:set var="headerCnt"  value="${masterService.selectMstImgKbnByShopBukkenKbnAndImgCategory('1','07','08').size() - 1}"/>
					<c:forEach var="img" items="${shopImageUpdateForm.imgs}"  varStatus="status"  begin="0" step="1" end="${headerCnt}">
						<tr>
							<th><form:checkbox path="imgs[${status.index}].del"/> </th>
							<th>
								<c:out value="${img.imgCategoryName}"/>
							</th>
							<td>
								<table>
									<tr>
										<td>
											<c:choose>
												<c:when test="${! empty img.imgOuterUrl}">
													<a href="${img.imgOuterUrl}" target="_blank">${img.imgOuterUrl}</a>
												</c:when>
												<c:when test="${! empty img.imgUrlPath}">
													<c:choose>
														<c:when test="${img.imgUrlPath.startsWith(tmpPath)}">
															<img src="<c:url value="${img.imgUrlPath}${img.imgFileNm}"/>" width="227">
														</c:when>
														<c:otherwise>
															<img src="https://${img.imgUrlPath}${img.imgFileNm}?resize=227:*">
														</c:otherwise>
													</c:choose>
													<button type="button" onclick="
														$(this).prev().remove();
														$(this).hide();
														$('#imgs${increment}\\.imgUrlPath,#imgs${increment}\\.imgFileNm').val('');
														$(this).before('画像がありません。');
														">画像削除</button>
												</c:when>
												<c:otherwise>
													画像がありません。
												</c:otherwise>
											</c:choose>
											<c:if test="${! empty img.imgOuterUrl}">
												<br><br>サムネイル <a href="${img.imgThumbnailUrl}" target="_blank">${img.imgThumbnailUrl}</a>
											</c:if>
										</td>
									</tr>
									<tr>
										<td>
											<c:if test="${img.imgKbn != '840'}">
												<table class="type_none">
													<colgroup>
														<col span="1" width="10%">
														<col span="1" width="90%">
													</colgroup>
													<tbody>
														<tr>
															<th class="text-left">コメント</th>
															<td><c:out value="${img.imgComment}" /></td>
														</tr>
													</tbody>
												</table>
											</c:if>
										</td>
									</tr>
								</table>
							</td>
							<td>
								<c:if test="${img.imgKbn == '840'}">
									<p>
										アップロードファイル
										<input type="file" name="imgs[${increment}].file" accept="image/jpeg"/>
									</p>
								</c:if>
								<c:if test="${img.imgKbn != '840'}">
								外部URL
								<p style="padding-left:2em"><chintai:inputResolveMaxLength path="imgs[${increment}].imgOuterUrl" size="80" /></p>
								サムネイル外部URL
								<p style="padding-left:2em"><chintai:inputResolveMaxLength path="imgs[${increment}].imgThumbnailUrl" size="80"/></p>
								</c:if>
								<c:if test="${img.imgKbn != '840'}">
									動画コメント
									<p style="padding-left:2em"><chintai:inputResolveMaxLength path="imgs[${increment}].imgComment" size="80"/></p>
								</c:if>
								<input type="hidden" name="imgs[${increment}].imgPriority" value="<%=Short.MIN_VALUE%>"/>
								<form:hidden path="imgs[${increment}].imgKbn" />
								<form:hidden  path="imgs[${increment}].imgUrlPath"/>
								<form:hidden path="imgs[${increment}].imgFileNm"/>
								<form:hidden path="imgs[${increment}].imgCategoryName"/>
								<form:hidden path="imgs[${increment}].existCurrentShopRirekiImg"/>
							</td>
						</tr>
						<c:set var="increment" value="${increment + 1}"/>
					</c:forEach>
				</tbody>
			</table>

			<table class="type_detail">
				<colgroup>
					<col width="1%">
					<col width="8%">
					<col width="44%">
					<col width="45%">
					<col width="2%">
				</colgroup>
				<tbody>
					<tr>
						<th>削除</th>
						<th>画像名</th>
						<th>店舗画像</th>
						<th>アップロードファイル<br>画像コメント</th>
						<th>優先<br>順位</th>
					</tr>
					<c:forEach var="img" items="${shopImageUpdateForm.imgs}" varStatus="status" begin="${headerCnt + 1}" step="1">
						<tr>
							<th><form:checkbox path="imgs[${increment}].del"/> </th>
							<th>
								<form:select path="imgs[${increment}].imgCategory" style="width:200px">
									<form:option value=""></form:option>
									<form:options items="${masterService.selectMstImgCategoryByShopBukkenKbnAndImgCategory('1','02','03','09','13','06')}" itemValue="imgCategory" itemLabel="imgCategoryName"/>
								</form:select>
							</th>
							<td>
								<table>
									<tr>
										<td>
											<c:choose>
												<c:when test="${! empty img.imgOuterUrl}">
													<a href="${img.imgOuterUrl}" target="_blank">${img.imgOuterUrl}</a>
												</c:when>
												<c:when test="${! empty img.imgUrlPath}">
													<c:choose>
														<c:when test="${img.imgUrlPath.startsWith(tmpPath)}">
															<img src="<c:url value="${img.imgUrlPath}${img.imgFileNm}"/>" width="227">
														</c:when>
														<c:otherwise>
															<img src="https://${img.imgUrlPath}${img.imgFileNm}?resize=227:*">
														</c:otherwise>
													</c:choose>
													<button type="button" onclick="
														$(this).prev().remove();
														$(this).hide();
														$('#imgs${increment}\\.imgUrlPath,#imgs${increment}\\.imgFileNm').val('');
														$(this).before('画像がありません。');
														">画像削除</button>
												</c:when>
												<c:otherwise>
													画像がありません。
												</c:otherwise>
											</c:choose>
											<c:if test="${! empty img.imgOuterUrl}">
												<br><br>サムネイル <a href="${img.imgThumbnailUrl}" target="_blank">${img.imgThumbnailUrl}</a>
											</c:if>
										</td>
									</tr>
									<tr>
										<td>
											<c:if test="${img.imgKbn != '840'}">
												<table class="type_none">
													<colgroup>
														<col span="1" width="10%">
														<col span="1" width="90%">
													</colgroup>
													<tbody>
														<tr>
															<th class="text-left">コメント</th>
															<td><c:out value="${img.imgComment}" /></td>
														</tr>
													</tbody>
												</table>
											</c:if>
										</td>
									</tr>
								</table>
							</td>
							<td>
								<p>
									アップロードファイル
									<input type="file" name="imgs[${increment}].file" accept="image/jpeg"/>
								</p>
								画像コメント
								<p style="padding-left:2em"><chintai:inputResolveMaxLength path="imgs[${increment}].imgComment"  size="80"/></p>
								<form:hidden path="imgs[${increment}].imgKbn" />
								<form:hidden path="imgs[${increment}].imgUrlPath"/>
								<form:hidden path="imgs[${increment}].imgFileNm"/>
								<form:hidden path="imgs[${increment}].existCurrentShopRirekiImg"/>
							</td>
							<td>
								<chintai:inputResolveMaxLength path="imgs[${increment}].imgPriority" size="1" maxlength="2" cssClass="integer"/>
							</td>
						</tr>
						<c:set var="increment" value="${increment + 1}"/>
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
						chk.parent().nextAll().find('*:not(:hidden)').prop('disabled',chk.prop('checked'));
					});
					$('[name*=imgCategory]select').change(function() {
						var select = $(this);
						select.parent().nextAll().find('input,textarea').each(function(){
							if($(this).attr('name').indexOf('existCurrentShopRirekiImg') == -1){
								$(this).val('');
							}
						});
						select.parent().nextAll().find('textarea').each(function(){
							$(this).val('');
							$(this).click();
						});
						select.parent().nextAll().find('button').each(function(){
							$(this).click();
							$(this).remove();
						});
					});
					$('input[type=file]').change(function(e){
						var ok = /\.(jpe?g|gif|png)$/i.test($(e.target).val());
						if(!ok){
							$(e.target).val('');
						}
					});
					$('#shopImageUpdateForm').submit(function(){
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
