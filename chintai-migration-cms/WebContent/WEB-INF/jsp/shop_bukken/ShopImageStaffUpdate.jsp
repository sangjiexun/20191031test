<%@page import="net.chintai.backend.sysadmin.common.properties.ServerProperties"%>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="スタッフ紹介更新"></c:set>
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
	<spring:bind path="shopImageStaffUpdateForm.*">
	  <c:if test="${status.errors.errorCount > 0}">
	  	<p class="notify">
	  		<c:forEach var="sortError" items="${sortErrorsList}">
			    <c:forEach var="error" items="${status.errors.allErrors}">
			    	<c:if test="${sortError == error.field}">
				    	スタッフ紹介<c:out value="${fn:substring( error.field , 7 , fn:indexOf(error.field ,']') )}"/>:
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
		<form:form action="ShopImageStaffUpdateConfirm.admin" commandName="shopImageStaffUpdateForm" enctype="multipart/form-data">
    		<p class="section_header">スタッフ紹介</p>
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
						<th colspan="2">スタッフ紹介内容</th>
						<th>スタッフ紹介写真<br>アップロードファイル</th>
					</tr>


						<c:forEach var="e" items="${shopImageStaffUpdateForm.staffs}" varStatus="stat">
							<c:set var="staff" value="${e.value }"/>
							<c:set var="i" value="${e.key}"/>
							<tr>
								<th><form:checkbox path="staffs[${i}].del"/> </th>
								<th><c:out value="${i}"/></th>
								<td>

									<table class="type_none">
										<colgroup>
											<col width="33%">
											<col width="33%">
											<col width="34%">
										</colgroup>
										<tbody>
											<tr>
												<td colspan="3">スタッフ名<span class="caution">*</span><br>
													<chintai:inputResolveMaxLength path="staffs[${i}].staffName"/>
												</td>
											</tr>
											<tr>
												<td>性別<br>
													<chintai:inputResolveMaxLength path="staffs[${i}].staffSex"/>
												</td>
												<td>年齢<br>
													<chintai:inputResolveMaxLength path="staffs[${i}].staffAge"/>
												</td>
												<td>業界経験<br>
													<chintai:inputResolveMaxLength path="staffs[${i}].staffExperience"/>
												</td>
											</tr>
											<tr>
												<td colspan="3">得意エリア<br>
													<chintai:inputResolveMaxLength path="staffs[${i}].staffProudArea"/>
												</td>
											</tr>
											<tr>
												<td colspan="3">得意分野<br>
													<chintai:inputResolveMaxLength path="staffs[${i}].staffProudField"/>
												</td>
											</tr>
											<tr>
												<td colspan="3">出身地<br>
													<chintai:inputResolveMaxLength path="staffs[${i}].staffHometown"/>
												</td>
											</tr>
											<tr>
												<td>資格<br>
													<chintai:inputResolveMaxLength path="staffs[${i}].staffQualification"/>
												</td>
												<td colspan="2">対応言語<br>
													<chintai:inputResolveMaxLength path="staffs[${i}].staffLanguage"/>
												</td>
											</tr>
											<tr>
												<td colspan="3">キャッチ<br>
													<chintai:inputResolveMaxLength path="staffs[${i}].staffCatch"/>
												</td>
											</tr>
											<tr>
												<td colspan="3">コメント<br>
													<chintai:textareaResolveMaxLength path="staffs[${i}].staffComment" cols="80" rows="3" />
												</td>
											</tr>
										</tbody>
									</table>

								</td>
								<td>
									<p>
										<c:choose>
											<c:when test="${! empty staff.imgOuterUrl}">
												<a href="${staff.imgOuterUrl}" target="_blank">${staff.imgOuterUrl}</a>
											</c:when>
											<c:when test="${! empty staff.imgUrlPath}">
												<c:choose>
													<c:when test="${staff.imgUrlPath.startsWith(tmpPath)}">
														<img src="<c:url value="${staff.imgUrlPath}${staff.imgFileNm}"/>" width="227">
													</c:when>
													<c:otherwise>
														<img src="https://${staff.imgUrlPath}${staff.imgFileNm}?resize=227:*">
													</c:otherwise>
												</c:choose>
												<button type="button" onclick="
													$(this).prev().remove();
													$(this).hide();
													$('#staffs${i}\\.imgUrlPath,#staffs${i}\\.imgFileNm').val('');
													$(this).before('画像がありません。');
													">画像削除</button>
											</c:when>
											<c:otherwise>
												画像がありません。
											</c:otherwise>
										</c:choose>
									</p>
									<c:if test="${! empty staff.imgOuterUrl}">
										<br><br>サムネイル <a href="${staff.imgThumbnailUrl}" target="_blank">${staff.imgThumbnailUrl}</a>
									</c:if>
									<p>
										アップロードファイル
										<input type="file" name="staffs[${i}].file" accept="image/jpeg"/>
									</p>
									<form:hidden path="staffs[${i}].imgKbn"/>
									<form:hidden path="staffs[${i}].imgUrlPath"/>
									<form:hidden path="staffs[${i}].imgFileNm"/>
									<form:hidden path="staffs[${i}].existCurrentShopRirekiStaff"/>
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
						chk.parent().nextAll().find('*:not(:hidden)').prop('disabled',chk.prop('checked'));
					});
					$('input[type=file]').change(function(e){
						var ok = /\.(jpe?g|gif|png)$/i.test($(e.target).val());
						if(!ok){
							$(e.target).val('');
						}
					});
					$('#shopImageStaffUpdateForm').submit(function(){
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
