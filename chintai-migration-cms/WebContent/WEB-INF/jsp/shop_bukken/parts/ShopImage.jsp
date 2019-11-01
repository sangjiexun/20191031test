<%@page import="net.chintai.backend.sysadmin.common.properties.ServerProperties"%>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
    <c:set var="rirekiImgMap" value="${masterService.toKeyObject(view.shopRirekiImgs,'imgKbn') }"/>
    <c:set var="shopImgCnt" value="0"/>
		<table class="type_detail">
			<colgroup>
				<col width="10%">
				<col width="20%">
				<col width="70%">
			</colgroup>
			<tbody>
				<tr>
					<th>画像名</th>
					<th>店舗画像</th>
					<th>店舗画像コメント</th>
				</tr>
				<c:set var="imgCates" value="07,08"/>
				<c:forTokens var="imgCate" items="${imgCates}" delims=",">
					<c:forEach var="mst" items="${masterService.selectMstImgKbnByShopBukkenKbnAndImgCategory('1',imgCate)}">
						<c:set var="rirekiImg" value="${rirekiImgMap[mst.imgKbn]}" />
						<tr>
							<th class="text-left"><c:out value="${mst.imgDispName}"/></th>
							<td>
								<c:choose>
									<c:when test="${! empty rirekiImg.imgOuterUrl}">
										<a href="${rirekiImg.imgOuterUrl}" target="_blank">${rirekiImg.imgOuterUrl}</a>
										<c:if test="${!empty rirekiImg.imgThumbnailUrl}">
											<br>サムネイル<br><a href="${rirekiImg.imgThumbnailUrl}" target="_blank">${rirekiImg.imgThumbnailUrl}</a>
										</c:if>
									</c:when>
									<c:when test="${! empty rirekiImg}">
										<img src="https://${rirekiImg.imgUrlPath}${rirekiImg.imgFileNm}?resize=227:*">
									</c:when>
									<c:otherwise>
										画像がありません。
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<chintai:filter filter="false" changeNL2BR="true"><c:out value="${rirekiImg.imgComment}"/></chintai:filter>
							</td>
						</tr>
					</c:forEach>
				</c:forTokens>
			</tbody>
		</table>
		<table class="type_detail">
			<colgroup>
		        <col width="10%">
		        <col width="20%">
		        <col width="65%">
		        <col width="5%">
			</colgroup>
			<tbody>
				<tr>
					<th>画像名</th>
					<th>店舗画像</th>
					<th>店舗画像コメント</th>
					<th>優先順位</th>
				</tr>
				<c:set var="imgCates" value="02,03,06,09,13"/>
				<c:forTokens var="imgCate" items="${imgCates}" delims=",">
					<c:forEach var="mst" items="${masterService.selectMstImgKbnByShopBukkenKbnAndImgCategory('1',imgCate)}">
						<c:set var="rirekiImg" value="${rirekiImgMap[mst.imgKbn]}" />
						<c:if test="${!empty rirekiImg}"><c:set var="shopImgCnt" value="${shopImgCnt + 1}"/>
							<tr>
								<th class="text-left"><c:out value="${mst.imgDispName}"/></th>
								<td>
									<c:choose>
										<c:when test="${mst.imgShubetsu == '3' }">
											<c:out value="${mst.imgDispName}"/>があります。
										</c:when>
										<c:when test="${! empty rirekiImg.imgOuterUrl}">
											<a href="${rirekiImg.imgOuterUrl}" target="_blank">${rirekiImg.imgOuterUrl}</a>
											<c:if test="${!empty rirekiImg.imgThumbnailUrl}">
												<br>サムネイル<br><a href="${rirekiImg.imgThumbnailUrl}" target="_blank">${rirekiImg.imgThumbnailUrl}</a>
											</c:if>
										</c:when>
										<c:when test="${! empty rirekiImg}">
											<img src="https://${rirekiImg.imgUrlPath}${rirekiImg.imgFileNm}?resize=227:*">
										</c:when>
										<c:otherwise>
											画像がありません。
										</c:otherwise>
									</c:choose>
								</td>
								<td>
									<chintai:filter filter="false" changeNL2BR="true"><c:out value="${rirekiImg.imgComment}"/></chintai:filter>
								</td>
								<td>
									${rirekiImg.imgPriority}
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</c:forTokens>
				<c:forEach var="loop" begin="${shopImgCnt + 1}" end="10" step="1">
					<tr>
						<th class="text-left"></th>
						<td>画像がありません。</td>
						<td></td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>