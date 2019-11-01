<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="物件詳細" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"></c:out>
    </html:messages>
    <!-- 物件情報 1 -->
    <p class="section_header">物件情報</p>
      <p>
        <fmt:setBundle basename="resources.server" var="resource" />
        <fmt:message bundle="${resource}" key="chintai.bukkenDetailUrl" var="chintaiBukkenDetailUrl">
          <fmt:param><c:out value="${BukkenInfoView.shopCd}${BukkenInfoView.bkCd}${BukkenInfoView.roomNo}" /></fmt:param>
          <fmt:param><c:out value="${BukkenInfoView.prefKey}" /></fmt:param>
        </fmt:message>
        <fmt:message bundle="${resource}" key="chintai.bukkenDetailUrl.tn" var="chintaiBukkenDetailUrlTr">
          <fmt:param><c:out value="${BukkenInfoView.shopCd}${BukkenInfoView.bkCd}${BukkenInfoView.roomNo}" /></fmt:param>
          <fmt:param><c:out value="${BukkenInfoView.prefKey}" /></fmt:param>
        </fmt:message>
        <c:choose>
          <c:when test="${BukkenInfoView.shubetsuCd eq '07' or BukkenInfoView.shubetsuCd eq '08' or BukkenInfoView.shubetsuCd eq '09' or BukkenInfoView.shubetsuCd eq '10' or BukkenInfoView.shubetsuCd eq '99'}" >
            <a href="${chintaiBukkenDetailUrlTr}" target="_blank">&gt;&gt; この物件の CHINTAI.NET での表示を確認する</a>
          </c:when>
          <c:otherwise>
            <a href="${chintaiBukkenDetailUrl}" target="_blank">&gt;&gt; この物件の CHINTAI.NET での表示を確認する</a>
          </c:otherwise>
        </c:choose>
      </p>
      <p>
        <fmt:message bundle="${resource}" key="able.bukkenDetailUrl" var="ableBukkenDetailUrl">
          <fmt:param><c:out value="${BukkenInfoView.shopCd}${BukkenInfoView.bkCd.substring(9,15)}${BukkenInfoView.roomNo.substring(1,4)}" /></fmt:param>
          <fmt:param><c:out value="${BukkenInfoView.prefKey}" /></fmt:param>
        </fmt:message>
        <a href="${ableBukkenDetailUrl}" target="_blank">&gt;&gt; この物件の エイブルでの表示を確認する</a>
      </p>
      <p><a href="<c:url value="BukkenPublishStatusUpdatePage.do">
         <c:param name="roomKey" value="${BukkenInfoView.roomKey}" />
         </c:url>">
      &gt;&gt; この物件の掲載状態を変更する</a></p>

    <form action="hoge.vm" method="post">

      <c:set var="view" value="${BukkenInfoView}" />
      <%@ include file="parts/BukkenInfoPart.jsp" %>


      <!-- 入稿履歴確認ページ表示用リンク 2008.5.16 李昊燮 追加-->
      <p style="margin-bottom: 5px;">
        <a href="
          <c:url value="BukkenRirekiInfo.do">
            <c:param name="roomKey" value="${BukkenInfoView.roomKey}" />
          </c:url>" target="_blank">
          &gt;&gt;入稿履歴を確認する
        </a>
      </p>

    <!-- 店舗情報 -->
    <p class="section_header">店舗情報</p>
    <p>
       <fmt:message bundle="${resource}" key="chintai.shopDetailUrl" var="chintaiShopDetailUrl">
         <fmt:param><c:out value="${BukkenInfoView.shopCd}" /></fmt:param>
       </fmt:message>
       <a href="${chintaiShopDetailUrl}" target="_blank">&gt;&gt; この店舗の CHINTAI.NET での表示を確認する</a>
    </p>
    <p>
       <fmt:message bundle="${resource}" key="able.shopDetailUrl" var="ableShopDetailUrl">
         <fmt:param><c:out value="${BukkenInfoView.shopCd}" /></fmt:param>
       </fmt:message>
       <a href="${ableShopDetailUrl}" target="_blank">&gt;&gt; この店舗の エイブルでの表示を確認する</a>
    </p>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="20%">
        <col span="1" width="80%">
      </colgroup>
      <tr>
        <th class="text-left">店舗名</th>
        <td>
          <c:out value="${BukkenInfoView.company}" />/
          <c:out value="${BukkenInfoView.bumon}" />
        </td>
      </tr>
      <tr>
        <th class="text-left">店舗コード</th>
        <td>
          <c:out value="${BukkenInfoView.shopCd}" />
        </td>
      </tr>
      <tr>
        <th class="text-left">お客様設定パスワード</th>
        <td>
          <c:out value="${BukkenInfoView.password}" />
        </td>
      </tr>
      <tr>
        <th class="text-left">承認状態</th>
        <td>
          <chintai:CodePrint nameKey="CERTIFY_FLG_NAME" valueKey="CERTIFY_FLG_VALUE" code="${BukkenInfoView.certifyFlg}" />
        </td>
      </tr>
      <tr>
        <th class="text-left">店舗状態</th>
        <td>
          <chintai:CodePrint nameKey="STATUS_NAME" valueKey="STATUS_VALUE" code="${BukkenInfoView.shopStatus}" />
        </td>
      </tr>
      <tr>
        <th class="text-left">備考</th>
        <td>
          <chintai:filter filter="false" changeNL2BR="true"><c:out value="${BukkenInfoView.adminNote}" /></chintai:filter>
        </td>
      </tr>
      <tr>
        <th class="text-left">管理最終更新日時</th>
        <td>
          <c:out value="${BukkenInfoView.shopAdminUpdDt}" />
        </td>
      </tr>
      <tr>
        <th class="text-left">取扱店</th>
        <td>
          <c:if test="${BukkenInfoView.tantouShopList != null}">
            <c:forEach items="${BukkenInfoView.tantouShopList}" var="tantouShop">
              <c:if test="${tantouShop.shopcd != BukkenInfoView.shopCd}">
                <c:out value="${tantouShop.shopcd}" />：
                <c:out value="${tantouShop.company}" />/
                <c:out value="${tantouShop.bumon}" /><br>
              </c:if>
            </c:forEach>
          </c:if>
        </td>
      </tr>
    </table>
    </form>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>