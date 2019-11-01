<%@page import="net.chintai.backend.sysadmin.common.properties.ServerProperties"%>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="キャンペーン情報更新"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>


<div id="main">
  <div class="popup_layout">
    <div class="topic_path">
      <a href ="#" onclick="$('#shopImageCampaignUpdateForm').attr('action','ShopImageCampaignUpdateConfirm.admin');$('#_cancelBtn').click();">
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
	  	<c:set var="imgKbnMap" value="${masterService.toKeyObject(masterService.selectMstImgKbn(),'imgKbn') }"/>
	  	<p class="notify">
		    <c:forEach var="error" items="${status.errors.allErrors}">
		    	<c:out value="${imgKbnMap[fn:substring( error.field , 5 , 8 )].imgDispName}"/>:
		    	<spring:message message="${error}"></spring:message><br>
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

   		<p class="section_header">キャンペーン情報</p>
   		<c:set var="tmpPath" value="/tmp/img/"/>


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
					<c:forEach var="e" items="${shopImageCampaignUpdateForm.campaigns}" varStatus="stat">
						<c:set var="campaign" value="${e.value }"/>
						<c:set var="i" value="${e.key}"/>
						<c:set var="d" value=""/>
						<c:if test="${campaign.del}">
							<c:set var="d" value="del_data"/>
						</c:if>
							<tr>
								<th rowspan="5"  class="${d}">${i}</th>
								<th class="${d}">キャンペーン期間</th>
								<td class="${d}"><c:if test="${!empty campaign.campaignStartYmd}"
							>${campaign.campaignStartYmd.substring(0,4)
							}年${campaign.campaignStartYmd.substring(4,6)
							}月${campaign.campaignStartYmd.substring(6)
							}日～</c:if><c:if test="${!empty campaign.campaignEndYmd}"
						    >${campaign.campaignEndYmd.substring(0,4)
						    }年${campaign.campaignEndYmd.substring(4,6)
						    }月${campaign.campaignEndYmd.substring(6)
						    }日</c:if>
						    <c:if test="${campaign.del}"><div style="color:#FF3333;">このデータは削除されます。</div></c:if>
						    </td>
								<td rowspan="5" class="${d}">
									<c:if test="${!campaign.del}">
										<c:choose>
											<c:when test="${! empty campaign.imgOuterUrl}">
												<a href="${campaign.imgOuterUrl}" target="_blank">${campaign.imgOuterUrl}</a>
												<c:if test="${!empty campaign.imgThumbnailUrl}">
													<br>サムネイル<br><a href="${campaign.imgThumbnailUrl}" target="_blank">${campaign.imgThumbnailUrl}</a>
												</c:if>
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
											</c:when>
											<c:otherwise>
												画像がありません。
											</c:otherwise>
										</c:choose>
									</c:if>
								</td>
							</tr>
							<tr>
								<th class="${d}">利用対象</th>
								<td class="${d}"><c:out value="${campaign.campaignRiyouTaisyo}" /></td>
							</tr>
							<tr>
								<th class="${d}">特典</th>
								<td class="${d}"><c:out value="${campaign.campaignTokuten}" /></td>
							</tr>
							<tr>
								<th class="${d}">提示条件</th>
								<td class="${d}"><c:out value="${campaign.campaignJouken}" /></td>
							</tr>
							<tr>
								<th class="${d}">コメント</th>
								<td class="${d}"><chintai:filter filter="false" changeNL2BR="true"><c:out value="${campaign.campaignComment}" /></chintai:filter></td>
							</tr>

					</c:forEach>

			</tbody>
		</table>
		<c:set var="mstCmtKbns" value="${masterService.selectMstCommentKbnByDataKbn(MstCommentKbn.DATA_KBN_SHOP)}"/>
		<table class="type_detail">
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
		      	<c:forEach items="${mstCmtKbns}" var="cmtKbn">
		      		<c:if test="${cmtKbn.commentKbn == '09' || cmtKbn.commentKbn == '10' || cmtKbn.commentKbn == '11'}">
						<tr>
					        <th><c:out value="${cmtKbn.commentKbnName}"/></th>
					        <td>
					        	<chintai:filter changeNL2BR="true" filter="false"><c:out value="${shopImageCampaignUpdateForm.comments[cmtKbn.commentKbn].commentText}"/></chintai:filter>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>


	    <form:form action="ShopImageCampaignUpdateCommit.admin" commandName="shopImageCampaignUpdateForm" onsubmit="disableSubmit(this)">
	    	<tags:token/>
	      <p>
		      <c:forEach items="${shopImageCampaignUpdateForm.getClass().getDeclaredFields()}" var="f">
		      	<c:if test="${f.name != 'campaigns' && f.name != 'comments'}">
		      		<form:hidden path="${f.name}"/>
		      	</c:if>
		      </c:forEach>
		      <c:forEach items="${shopImageCampaignUpdateForm.campaigns}" var="e">
		      	<c:forEach items="${e.value.getClass().getDeclaredFields()}" var="f">
		      		<c:if test="${f.name != 'file'}">
		      			<form:hidden path="campaigns[${e.key}].${f.name}"/>
		      		</c:if>
		      	</c:forEach>
		      </c:forEach>
		      <c:forEach items="${shopImageCampaignUpdateForm.comments}" var="e">
		      	<c:forEach items="${e.value.getClass().getDeclaredFields()}" var="f">
		      		<c:if test="${f.name != 'file'}">
		      			<form:hidden path="comments[${e.key}].${f.name}"/>
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
