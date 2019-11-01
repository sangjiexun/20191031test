<%@page import="net.chintai.backend.sysadmin.common.properties.ServerProperties"%>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗画像更新"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <a href ="#" onclick="$('#shopImageUpdateForm').attr('action','ShopImageUpdateConfirm.admin');$('#_cancelBtn').click();">
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
	<form:errors path="shopImageUpdateForm.*" element="p" cssClass="notify"/>

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
		table td{ height: 100%;}
		table td table{width:100%}
		table td table tr td{ border: 0px solid !important;}
	</style>
    <!-- 更新画像確認 -->
    <p class="section_header">店舗画像の更新確認</p>
    <c:set var="tmpPath" value="/tmp/img/"/>

			<table class="type_detail">
				<colgroup>
			        <col width="9%">
			        <col width="91%">
			        <%-- <col width="46%">--%>
				</colgroup>
				<tbody>
					<tr>
						<th>画像名</th>
						<th>店舗画像</th>
						<%-- <th>アップロードファイル<br>画像コメント</th> --%>
					</tr>
					<c:set var="headerCnt"  value="${masterService.selectMstImgKbnByShopBukkenKbnAndImgCategory('1','07','08').size() - 1}"/>
					<c:forEach var="img" items="${shopImageUpdateForm.imgs}"  varStatus="status"  begin="0" step="${headerCnt}" end="1">
						<c:set var="d" value=""/>
						<c:if test="${img.del}">
							<c:set var="d" value="del_data"/>
						</c:if>
						<c:if test="${imgCate == img.imgCategory}">
							<tr>
								<th class="${d}"><c:out value="${img.imgCategoryName}"/></th>
								<td class="${d}">
									<table>
										<tr>
											<td>
												<p>
													<c:choose>
														<c:when test="${img.del}">
															<div style="color:#FF3333;">この画像は削除されます。</div>
														</c:when>
														<c:when test="${! empty img.imgOuterUrl}">
															<a href="${img.imgOuterUrl}" target="_blank">${img.imgOuterUrl}</a>
														</c:when>
														<c:when test="${! empty img && ! empty img.imgFileNm}">
															<c:choose>
																<c:when test="${img.imgUrlPath.startsWith(tmpPath)}">
																	<img src="<c:url value="${img.imgUrlPath}${img.imgFileNm}"/>" width="227">
																</c:when>
																<c:otherwise>
																	<img src="https://${img.imgUrlPath}${img.imgFileNm}?resize=227:*">
																</c:otherwise>
															</c:choose>
														</c:when>
														<c:otherwise>
															画像がありません。
														</c:otherwise>
													</c:choose>
												</p>
											<c:if test="${! empty img.imgOuterUrl}">
												<br>サムネイル<br><a href="${img.imgThumbnailUrl}" target="_blank">${img.imgThumbnailUrl}</a>
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
																<th class="text-left ${d}">コメント</th>
																<td class="${d}"><chintai:filter filter="false" changeNL2BR="true"><c:out value="${img.imgComment}" /></chintai:filter></td>
															</tr>
														</tbody>
													</table>
												</c:if>
											</td>
										</tr>
									</table>
								</td>
								<%--
								<td>
									<c:if test="${!img.del}">
										外部URL
										<p style="padding-left:2em"><c:out value="${shopImageUpdateForm.imgs[mst.imgKbn].imgOuterUrl }"/></p>
										キャッチ
										<p style="padding-left:2em"><c:out value="${shopImageUpdateForm.imgs[mst.imgKbn].imgCatch }"/></p>
										コメント
										<p style="padding-left:2em"><c:out value="${shopImageUpdateForm.imgs[mst.imgKbn].imgComment }"/></p>
									</c:if>
								</td>
								 --%>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>

			<table class="type_detail">
				<colgroup>
			        <col width="9%">
			        <col width="90%">
			        <col width="1%">
				</colgroup>
				<tbody>
					<tr>
						<th>画像名</th>
						<th>店舗画像</th>
						<th>優先<br>順位</th>
					</tr>
					<c:forEach var="img" items="${shopImageUpdateForm.imgs}" varStatus="status" begin="${headerCnt + 1}" step="1">
						<c:set var="d" value=""/>
						<c:if test="${img.del}">
							<c:set var="d" value="del_data"/>
						</c:if>
						<tr>
							<th class="${d}"><c:out value="${img.imgCategoryName}"/></th>
							<td class="${d}">
								<table>
									<tr>
										<td>
											<p>
												<c:choose>
													<c:when test="${img.del}">
														<div style="color:#FF3333;">この画像は削除されます。</div>
													</c:when>
													<c:when test="${! empty img.imgOuterUrl}">
														<a href="${img.imgOuterUrl}" target="_blank">${img.imgOuterUrl}</a>
													</c:when>
													<c:when test="${! empty img && ! empty img.imgFileNm}">
														<c:choose>
															<c:when test="${img.imgUrlPath.startsWith(tmpPath)}">
																<img src="<c:url value="${img.imgUrlPath}${img.imgFileNm}"/>" width="227">
															</c:when>
															<c:otherwise>
																<img src="https://${img.imgUrlPath}${img.imgFileNm}?resize=227:*">
															</c:otherwise>
														</c:choose>
													</c:when>
													<c:otherwise>
														画像がありません。
													</c:otherwise>
												</c:choose>
											</p>
											<c:if test="${! empty img.imgOuterUrl}">
												<br>サムネイル <br><a href="${img.imgThumbnailUrl}" target="_blank">${img.imgThumbnailUrl}</a>
											</c:if>
										</td>
									</tr>
									<tr>
										<td>
											<table class="type_none">
												<colgroup>
													<col span="1" width="10%">
													<col span="1" width="90%">
												</colgroup>
												<tbody>
													<tr>
														<th class="text-left ${d}" >コメント</th>
														<td class="${d}"><chintai:filter filter="false" changeNL2BR="true"><c:out value="${img.imgComment}" /> </chintai:filter> </td>
													</tr>
												</tbody>
											</table>
										</td>
									</tr>
								</table>
							</td>
							<td class="${d}">
								<c:if test="${!img.del}">
									<c:out value="${shopImageUpdateForm.imgs[status.index].imgPriority }"/>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		<form:form action="ShopImageUpdateCommit.admin" commandName="shopImageUpdateForm" onsubmit="disableSubmit(this)">
			<tags:token/>
		<p>
		<c:forEach items="${shopImageUpdateForm.getClass().getDeclaredFields()}" var="f">
			<c:if test="${f.name != 'imgs'}">
				<form:hidden path="${f.name}"/>
			</c:if>
		</c:forEach>
		<c:forEach items="${shopImageUpdateForm.imgs}" var="e"  varStatus="status">
			<c:forEach items="${e.getClass().getDeclaredFields()}" var="f">
				<c:if test="${f.name != 'file'}">
					<form:hidden path="imgs[${status.index}].${f.name}"/>
				</c:if>
			</c:forEach>
		</c:forEach>
		<input type="submit" value="更新" name="commit">
		<input type="submit" name="${BaseController.CANCEL_KEY}" value="戻る" id="_cancelBtn">
		</p>
		</form:form>

  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
