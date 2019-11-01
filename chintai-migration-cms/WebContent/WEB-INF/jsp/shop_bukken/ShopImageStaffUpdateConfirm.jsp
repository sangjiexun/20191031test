<%@page import="net.chintai.backend.sysadmin.common.properties.ServerProperties"%>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="スタッフ紹介更新"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>


<div id="main">
  <div class="popup_layout">
    <div class="topic_path">
      <a href ="#" onclick="$('#shopImageStaffUpdateForm').attr('action','ShopImageStaffUpdateConfirm.admin');$('#_cancelBtn').click();">
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

   		<p class="section_header">スタッフ紹介</p>
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
					<th colspan="3">スタッフ紹介内容</th>
					<th>スタッフ紹介写真</th>
				</tr>
					<c:forEach var="e" items="${shopImageStaffUpdateForm.staffs}" varStatus="stat">
						<c:set var="staff" value="${e.value }"/>
						<c:set var="i" value="${e.key}"/>
						<c:set var="d" value=""/>
						<c:if test="${staff.del}">
							<c:set var="d" value="del_data"/>
						</c:if>
							<tr>
								<th rowspan="11" class="${d}"><c:out value="${i}"/></th>
								<th class="${d}">スタッフ名</th>
								<td class="${d}"><c:out value="${staff.staffName}"/><c:if test="${staff.del}"><div style="color:#FF3333;">このデータは削除されます。</div></c:if></td>
								<td rowspan="11" class="${d}">
									<c:if test="${!staff.del}">
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
												</c:when>
												<c:otherwise>
													画像がありません。
												</c:otherwise>
											</c:choose>
										</p>
										<c:if test="${! empty staff.imgOuterUrl}">
											<br>サムネイル <br><a href="${staff.imgThumbnailUrl}" target="_blank">${staff.imgThumbnailUrl}</a>
										</c:if>
									</c:if>
								</td>
							</tr>
							<tr>
								<th class="${d}">性別</th>
								<td class="${d}"><c:out value="${staff.staffSex}" /></td>
							</tr>
							<tr>
								<th class="${d}">業界経験</th>
								<td class="${d}"><c:out value="${staff.staffExperience}" /></td>
							</tr>
							<tr>
								<th class="${d}">年齢</th>
								<td class="${d}"><c:out value="${staff.staffAge}" /></td>
							</tr>
							<tr>
								<th class="${d}">得意エリア</th>
								<td class="${d}"><c:out value="${staff.staffProudArea}" /></td>
							</tr>
							<tr>
								<th class="${d}">得意分野</th>
								<td class="${d}"><c:out value="${staff.staffProudField}" /></td>
							</tr>
							<tr>
								<th class="${d}">出身地</th>
								<td class="${d}"><c:out value="${staff.staffHometown}" /></td>
							</tr>
							<tr>
								<th class="${d}">資格</th>
								<td class="${d}"><c:out value="${staff.staffQualification}" /></td>
							</tr>
							<tr>
								<th class="${d}">対応言語</th>
								<td class="${d}"><c:out value="${staff.staffLanguage}" /></td>
							</tr>
							<tr>
								<th class="${d}">キャッチ</th>
								<td class="${d}"><c:out value="${staff.staffCatch}" /></td>
							</tr>
							<tr>
								<th class="${d}">コメント</th>
								<td class="${d}"><chintai:filter filter="false" changeNL2BR="true"><c:out value="${staff.staffComment}" /></chintai:filter></td>
							</tr>
					</c:forEach>

			</tbody>
		</table>
	    <form:form action="ShopImageStaffUpdateCommit.admin" commandName="shopImageStaffUpdateForm" onsubmit="disableSubmit(this)">
	    	<tags:token/>
	      <p>
		      <c:forEach items="${shopImageStaffUpdateForm.getClass().getDeclaredFields()}" var="f">
		      	<c:if test="${f.name != 'staffs'}">
		      		<form:hidden path="${f.name}"/>
		      	</c:if>
		      </c:forEach>
		      <c:forEach items="${shopImageStaffUpdateForm.staffs}" var="e">
		      	<c:forEach items="${e.value.getClass().getDeclaredFields()}" var="f">
		      		<c:if test="${f.name != 'file'}">
		      			<form:hidden path="staffs[${e.key}].${f.name}"/>
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
