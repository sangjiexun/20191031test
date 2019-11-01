<%@page import="net.chintai.backend.sysadmin.common.properties.ServerProperties"%>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../../parts/ContentsImport.jsp" %>
    <table class="type_detail">
			<colgroup>
		        <col width="2%">
		        <col width="10%">
		        <col width="58%">
		        <col width="35%">
      		</colgroup>
			<tbody>
				<tr>
					<th colspan="3">スタッフ紹介内容</th>
					<th>スタッフ紹介写真</th>
				</tr>
				<c:set var="rirekiStaffMap" value="${masterService.toKeyObject(view.shopRirekiStaffs,'entryNo') }"/>
				<c:forEach var="i" begin="1" end="${masterService.selectMstImgKbnByShopBukkenKbnAndImgCategory('1','10').size()}" varStatus="stat">
					<c:set var="rirekiStaff" value="${rirekiStaffMap[i.shortValue()]}" />
					<c:set var="rirekiImg" value="${rirekiImgMap[rirekiStaff.imgKbn]}" />
					<c:choose>
						<c:when test="${empty rirekiStaff }">
							<tr>
					          <th class="text-left" colspan="2">${i}</th>
					          <td>登録がありません。</td>
					          <td>画像がありません。</td>
					        </tr>
						</c:when>
						<c:otherwise>
							<tr>
								<th class="text-left" rowspan="11">${i}</th>
								<th class="text-left">スタッフ名</th>
								<td><c:out value="${rirekiStaff.staffName}" /></td>
								<td rowspan="11">
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
							</tr>
							<tr>
								<th class="text-left">性別</th>
								<td><c:out value="${rirekiStaff.staffSex}" /></td>
							</tr>
							<tr>
								<th class="text-left">業界経験</th>
								<td><c:out value="${rirekiStaff.staffExperience}" /></td>
							</tr>
							<tr>
								<th class="text-left">年齢</th>
								<td><c:out value="${rirekiStaff.staffAge}" /></td>
							</tr>
							<tr>
								<th class="text-left">得意エリア</th>
								<td><c:out value="${rirekiStaff.staffProudArea}" /></td>
							</tr>
							<tr>
								<th class="text-left">得意分野</th>
								<td><c:out value="${rirekiStaff.staffProudField}" /></td>
							</tr>
							<tr>
								<th class="text-left">出身地</th>
								<td><c:out value="${rirekiStaff.staffHometown}" /></td>
							</tr>
							<tr>
								<th class="text-left">資格</th>
								<td><c:out value="${rirekiStaff.staffQualification}" /></td>
							</tr>
							<tr>
								<th class="text-left">対応言語</th>
								<td><c:out value="${rirekiStaff.staffLanguage}" /></td>
							</tr>
							<tr>
								<th class="text-left">キャッチ</th>
								<td><c:out value="${rirekiStaff.staffCatch}" /></td>
							</tr>
							<tr>
								<th class="text-left">コメント</th>
								<td><chintai:filter filter="false" changeNL2BR="true"><c:out value="${rirekiStaff.staffComment}" /></chintai:filter></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tbody>
		</table>