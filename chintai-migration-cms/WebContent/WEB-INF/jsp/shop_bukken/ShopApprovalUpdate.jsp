<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗承認"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<c:set var="view" value="${ShopRegistrationStautsUpdatePageView}" />
<style>
table th{
	text-align: left;
}
</style>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_bukken/ShopInfo">
        <html:param name="shopCd" value="${refData.shopRireki.shopcd}" />
        店舗・契約詳細
      </html:link> &gt;
      ${title}
    </div>

    <h1>${title}</h1>

    <html:messages id ="errmsg" header="errors.header" footer="errors.footer">
      <c:out value="${errmsg}"></c:out>
    </html:messages>
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
	<form:errors path="shopApprovalUpdateForm.*" element="p" cssClass="notify"/>

    <!-- 店舗コード -->
    <p class="section_header"><a name="1">店舗コード</a></p>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>店舗名</th>
        <td><c:out value="${refData.shopRireki.company}"/>
        <c:if test="${not empty refData.shopRireki.company and not empty refData.shopRireki.bumon}"> / </c:if>
        <c:out value="${refData.shopRireki.bumon}"/></td>
      </tr>
      <tr>
        <th>店舗コード</th>
        <td>${refData.shopRireki.shopcd}</td>
      </tr>
      <tr>
        <th>お客様設定パスワード</th>
        <td>${crnwl:decypt(refData.shopRireki.passwordEnc)}</td>
      </tr>
    </table>

    <!-- 登録状況更新 -->
    <p class="section_header"><a name="3">店舗承認</a></p>
    <form:form action="ShopApprovalUpdateConfirm.admin" commandName="shopApprovalUpdateForm">
      <div class="add_form">
        <div class="add_form_title">承認状態 <span class="caution">*</span></div>
        <div class="annotation">一度「承認済」にすると、「未承認」へ戻すことはできません。店舗状態「停止」をご利用ください。</div>
        <div class="form_space">
        	<label><form:radiobutton path="certifyFlg" value="0" id="certifyFlg0"/>未承認</label>
        	<label><form:radiobutton path="certifyFlg" value="1"/>承認済</label>
        	<c:if test="${refData.shopRireki.certifyFlg == '1' }">
        		<script type="text/javascript">
        			$('#certifyFlg0').attr("disabled", "disabled");
        		</script>
        	</c:if>
        </div>
      </div>

      <div class="add_form">
		<form:hidden path="shopcd"/>
		<form:hidden path="shopKanriUpdDt"/>
        <input type="submit" value="確認画面へ">
        <input type="submit" name="${BaseController.CANCEL_KEY}" value="戻る">
      </div>
	</form:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
