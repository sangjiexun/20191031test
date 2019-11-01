<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗承認"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<script type="text/javascript">
addEvent('load', window, function(){document.getElementsByName('commit')[0].focus();});
</script>
<c:set var="view" value="${ShopRegistrationStautsUpdateConfirmView}"/>
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
    <table class="type_detail_pre">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>承認状態</th>
        <td>
          <chintai:CodePrint nameKey="SHOPBUKKEN_CERTIFY_FLG_NAME" valueKey="SHOPBUKKEN_CERTIFY_FLG_VALUE" code="${shopApprovalUpdateForm.certifyFlg}"/>
        </td>
      </tr>
    </table>

    <form:form commandName="shopApprovalUpdateForm" action="ShopApprovalUpdateCommit.admin" onsubmit="disableSubmit(this)">
    	<tags:token/>
      <p>
	      <c:forEach items="${shopApprovalUpdateForm.getClass().getDeclaredFields()}" var="f">
      		<form:hidden path="${f.name}"/>
	      </c:forEach>
        <input type="submit" value="更新" name="commit">
        <input type="submit" name="${BaseController.CANCEL_KEY}" value="戻る">
      </p>
    </form:form>

  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
