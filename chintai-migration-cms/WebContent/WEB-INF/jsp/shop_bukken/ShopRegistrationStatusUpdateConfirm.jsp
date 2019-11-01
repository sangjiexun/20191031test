<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="契約状況更新"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<script type="text/javascript">
addEvent('load', window, function(){document.getElementsByName('commit')[0].focus();});
</script>
<style>
table th{
	text-align: left;
}
</style>
<c:set var="view" value="${ShopRegistrationStautsUpdateConfirmView}"/>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_bukken/ShopInfo">
        <html:param name="shopCd" value="${view.shopCd}" />
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
        <td><c:out value="${view.company}"/> / <c:out value="${view.bumon}"/></td>
      </tr>
      <tr>
        <th>店舗コード</th>
        <td><c:out value="${view.shopCd}"/></td>
      </tr>
      <tr>
        <th>お客様設定パスワード</th>
        <td><c:out value="${crnwl:decypt(view.password)}" /></td>
      </tr>
    </table>

<%--
    <!-- 紐付先取引先設定 -->
    <p class="section_header"><a name="3">紐付先取引先設定内容の確認</a></p>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>取引先コード</th>
        <td><c:out value="${view.torihikisakiCd}"/></td>
      </tr>
      <tr>
        <th>取引先名</th>
        <td><c:out value="${view.torihikisakiName}"/></td>
      </tr>
    </table>
 --%>
    <!-- 登録状況更新 -->
    <p class="section_header"><a name="3">契約状況更新内容の確認</a></p>
    <table class="type_detail_pre">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>システム利用状態</th>
        <td>
          <c:if test="${view.shopStatus == '0'}"><font color="#FF3333"></c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_STATUS_NAME" valueKey="SHOPBUKKEN_SHOP_STATUS_VALUE" code="${view.shopStatus}"/>
          <c:if test="${view.shopStatus == '0'}"></font></c:if>
        </td>
      </tr>
      <tr>
        <th>CHINTAIに掲載</th>
        <td>
          <chintai:CodePrint nameKey="SHOPBUKKEN_CT_FLG_NAME" valueKey="SHOPBUKKEN_CT_FLG_VALUE" code="${view.ctFlg}"/>
        </td>
      </tr>
      <tr>
        <th>エイブルに掲載</th>
        <td>
          <chintai:CodePrint nameKey="SHOPBUKKEN_ABL_FLG_NAME" valueKey="SHOPBUKKEN_ABL_FLG_VALUE" code="${view.ablFlg}"/>
        </td>
      </tr>
<%--
      <tr>
        <th>送信元アプリケーション</th>
        <td>
          <chintai:CodePrint nameKey="CLIENTSYSTEM_NAME" valueKey="CLIENTSYSTEM_VALUE" code="${view.clientSystemType}"/>
        </td>
      </tr>

      <tr>
        <th>店舗サイト権限</th>
        <td>
          <chintai:CodePrint nameKey="SHOP_SITE_ROLE_NAME" valueKey="SHOP_SITE_ROLE_VALUE" code="${view.shopSiteRole}"/>
        </td>
      </tr>
      <tr>
        <th>店舗名ひらがな名称</th>
        <td><c:out value="${view.bumonKana}"/></td>
      </tr>
 --%>
      <!-- 2009/03/23 李昊燮 「地図上の店舗アイコン表示状態」削除処理 -->
      <tr>
        <th>備考</th>
        <td><chintai:filter filter="false" changeNL2BR="true"><c:out value="${view.adminNote}"/></chintai:filter></td>
      </tr>
    </table>

    <html:form method="post" action="/shop_bukken/ShopRegistrationStatusUpdateCommit" onsubmit="disableSubmit(this)">
      <p>
        <input type="hidden" name="company" value="${fn:escapeXml(view.company)}">
        <input type="hidden" name="bumon" value="${fn:escapeXml(view.bumon)}">
        <input type="hidden" name="shopCd" value="${fn:escapeXml(view.shopCd)}">
        <input type="hidden" name="password" value="${fn:escapeXml(view.password)}">
        <input type="hidden" name="torihikisakiCd" value="${fn:escapeXml(view.torihikisakiCd)}">
        <input type="hidden" name="torihikisakiName" value="${fn:escapeXml(view.torihikisakiName)}">
        <input type="hidden" name="certifyFlg" value="${fn:escapeXml(view.certifyFlg)}">
        <input type="hidden" name="shopStatus" value="${fn:escapeXml(view.shopStatus)}">
        <input type="hidden" name="ctFlg" value="${fn:escapeXml(view.ctFlg)}">
        <input type="hidden" name="ablFlg" value="${fn:escapeXml(view.ablFlg)}">
        <input type="hidden" name="shopSiteRole" value="${fn:escapeXml(view.shopSiteRole)}">
        <input type="hidden" name="updDt" value="${fn:escapeXml(view.updDt)}">
        <input type="hidden" name="adminNote" value="${fn:escapeXml(view.adminNote)}">
        <input type="hidden" name="bumonKana" value="${fn:escapeXml(view.bumonKana)}">
   　   <!-- 2009/03/23 李昊燮 「地図上の店舗アイコン表示状態」削除処理 -->
        <input type="submit" value="更新" name="commit">
        <input type="button" value="戻る" onClick="_submit('ShopRegistrationStatusUpdateConfirmBack.do');">
      </p>
    </html:form>

  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
