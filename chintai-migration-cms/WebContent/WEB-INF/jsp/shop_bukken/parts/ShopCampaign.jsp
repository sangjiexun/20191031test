<%@page import="net.chintai.backend.sysadmin.common.properties.ServerProperties"%>
<%@ include file="../../parts/ContentsImport.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
    <table class="type_detail">
			<colgroup>
		        <col width="2%">
		        <col width="10%">
		        <col width="58%">
		        <col width="35%">
      		</colgroup>
			<tbody>
				<tr>
					<th colspan="3">キャンペーン内容</th>
					<th>キャンペーン画像</th>
				</tr>
				<c:set var="rirekiCampaignMap" value="${masterService.toKeyObject(view.shopRirekiCampaigns,'entryNo') }"/>
				<c:forEach var="i" begin="1" end="${masterService.selectMstImgKbnByShopBukkenKbnAndImgCategory('1','11').size()}" varStatus="stat">
					<c:set var="rirekiCampaign" value="${rirekiCampaignMap[i.shortValue()]}" />
					<c:set var="rirekiImg" value="${rirekiImgMap[rirekiCampaign.imgKbn]}" />
					<c:choose>
						<c:when test="${empty rirekiCampaign }">
							<tr>
					          <th class="text-left" colspan="2">${i}</th>
					          <td>登録がありません。</td>
					          <td>画像がありません。</td>
					        </tr>
						</c:when>
						<c:otherwise>
							<tr>
								<th class="text-left" rowspan="5">${i}</th>
								<th class="text-left">キャンペーン期間</th>
								<td><c:if test="${!empty rirekiCampaign.campaignStartYmd}"
							>${rirekiCampaign.campaignStartYmd.substring(0,4)
							}年${rirekiCampaign.campaignStartYmd.substring(4,6)
							}月${rirekiCampaign.campaignStartYmd.substring(6)
							}日</c:if>～<c:if test="${!empty rirekiCampaign.campaignEndYmd && rirekiCampaign.campaignEndYmd != '99999999'}"
						    >${rirekiCampaign.campaignEndYmd.substring(0,4)
						    }年${rirekiCampaign.campaignEndYmd.substring(4,6)
						    }月${rirekiCampaign.campaignEndYmd.substring(6)
						    }日</c:if></td>
								<td rowspan="5">
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
								<th class="text-left">利用対象</th>
								<td><c:out value="${rirekiCampaign.campaignRiyouTaisyo}" /></td>
							</tr>
							<tr>
								<th class="text-left">特典</th>
								<td><c:out value="${rirekiCampaign.campaignTokuten}" /></td>
							</tr>
							<tr>
								<th class="text-left">提示条件</th>
								<td><c:out value="${rirekiCampaign.campaignJouken}" /></td>
							</tr>
							<tr>
								<th class="text-left">コメント</th>
								<td><c:out value="${rirekiCampaign.campaignComment}" /></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tbody>
		</table>
		<table class="type_detail">
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
		      	<c:forEach items="${mstCmtKbns}" var="cmtKbn">
		      		<c:if test="${cmtKbn.commentKbn == '09' || cmtKbn.commentKbn == '10' || cmtKbn.commentKbn == '11'}">
						<tr>
					        <th class="text-left"><c:out value="${cmtKbn.commentKbnName}"/></th>
					        <td>
					        	<c:out value="${cmtMap[cmtKbn.commentKbn].commentText}"/>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>