<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗画像削除"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<!-- 2009/06 李昊燮追加 -->
<c:set var="view" value="${ShopImageDeleteConfirmView}" />

<script type="text/javascript">

 addEvent('load', window, function(){document.getElementsByName('commit')[0].focus();});

</script>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <a href ="<c:url value="ShopInfo.do"><c:param name="shopCd" value="${ShopImageDeleteConfirmView.shopCd}"/></c:url>">
        店舗・契約詳細
      </a>&gt;
        ${title}
    </div>
    <h1>${title}</h1>

    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"></c:out>
    </html:messages>

    <!-- 店舗コード -->
    <p class="section_header"><a name="1">店舗コード</a></p>
    <!-- 2009/06 店舗コードパーツ化 李昊燮 -->
    <%@ include file="parts/ShopBasicInfoPart.jsp" %>

    <!-- 更新画像確認 -->
    <p class="section_header">店舗画像の削除確認</p>

    <table class="type_detail">
      <colgroup>
        <col width="25%">
        <col width="25%">
        <col width="25%">
        <col width="25%">
      </colgroup>
      <tr>
        <th colspan="2">店舗地図</th>
        <th colspan="2">店舗地図コメント</th>
      </tr>
      <tr>
<c:choose>
  <c:when test="${view.shopMapPctFlgOrg eq '1'}">
        <td colspan="2">
    <c:if test="${view.shopMapPctFileDeleteCheck eq 'on'}">
          <span class="caution">この画像は削除されます。</span><br>
    </c:if>
          <img src="${view.shopMapPctFilePath}" alt="店舗地図" title="店舗地図">
        </td>
  </c:when>
  <c:otherwise>
        <td colspan="2">画像がありません。</td>
  </c:otherwise>
</c:choose>
        <td colspan="2"><c:out value="${view.shopMapPctComment}" /></td>
      </tr>
      <tr>
        <th>店舗画像１(店外写真)</th>
        <th>店舗画像１(店外写真)コメント</th>
        <th>店舗画像２(スタッフ写真)</th>
        <th>店舗画像２(スタッフ写真)コメント</th>
      </tr>

      <tr>
<c:choose>
  <c:when test="${view.shopPhoto1FlgOrg eq '1'}">
        <td>
    <c:if test="${view.shopPhoto1FileDeleteCheck eq 'on'}">
          <span class="caution">この画像は削除されます。</span><br>
    </c:if>
          <img src="${view.shopPhoto1FilePath}" alt="店舗画像１(店外写真)" title="店舗画像１(店外写真)">
        </td>
  </c:when>
  <c:otherwise>
        <td>画像がありません。</td>
  </c:otherwise>
</c:choose>
       <td><c:out value="${view.shopPhoto1Comment}"/></td>
<c:choose>
  <c:when test="${view.shopPhoto2FlgOrg eq '1'}">
        <td>
    <c:if test="${view.shopPhoto2FileDeleteCheck eq 'on'}">
          <span class="caution">この画像は削除されます。</span><br>
    </c:if>
          <img src="${view.shopPhoto2FilePath}" alt="店舗画像２(スタッフ写真)" title="店舗画像２(スタッフ写真)">
        </td>
  </c:when>
  <c:otherwise>
        <td>画像がありません。</td>
  </c:otherwise>
</c:choose>
        <td><c:out value="${view.shopPhoto2Comment}"/></td>
      </tr>

      <tr>
        <th>店舗画像３(店内写真)</th>
        <th>店舗画像３(店内写真)コメント</th>
        <th>店舗画像４(スタッフ接客写真)</th>
        <th>店舗画像４(スタッフ接客写真)コメント</th>
      </tr>

      <tr>
<c:choose>
  <c:when test="${view.shopPhoto3FlgOrg eq '1'}">
        <td>
    <c:if test="${view.shopPhoto3FileDeleteCheck eq 'on'}">
          <span class="caution">この画像は削除されます。</span><br>
    </c:if>
          <img src="${view.shopPhoto3FilePath}" alt="店舗画像３(店内写真)" title="店舗画像３(店内写真)">
        </td>
  </c:when>
  <c:otherwise>
        <td>画像がありません。</td>
  </c:otherwise>
</c:choose>
       <td><c:out value="${view.shopPhoto3Comment}"/></td>
<c:choose>
  <c:when test="${view.shopPhoto4FlgOrg eq '1'}">
        <td>
    <c:if test="${view.shopPhoto4FileDeleteCheck eq 'on'}">
          <span class="caution">この画像は削除されます。</span><br>
    </c:if>
          <img src="${view.shopPhoto4FilePath}" alt="店舗画像４(スタッフ接客写真)" title="店舗画像４(スタッフ接客写真)">
        </td>
  </c:when>
  <c:otherwise>
        <td>画像がありません。</td>
  </c:otherwise>
</c:choose>
        <td><c:out value="${view.shopPhoto4Comment}"/></td>
      </tr>
    </table>


    <html:form action="/shop_bukken/ShopImageDeleteCommit" method="post" onsubmit="disableSubmit(this)">
      <p>
        <!-- 2009/06 李昊燮追加開始 -->
        <input type="hidden" name="company"                     value="${view.company}">
        <input type="hidden" name="bumon"                       value="${view.bumon}">
        <input type="hidden" name="shopCd"                      value="${view.shopCd}">
        <input type="hidden" name="password"                    value="${view.password}">
        <input type="hidden" name="shopMapPctFileDeleteCheck"   value="${view.shopMapPctFileDeleteCheck}">
        <input type="hidden" name="shopPhoto1FileDeleteCheck"   value="${view.shopPhoto1FileDeleteCheck}">
        <input type="hidden" name="shopPhoto2FileDeleteCheck"   value="${view.shopPhoto2FileDeleteCheck}">
        <input type="hidden" name="shopPhoto3FileDeleteCheck"   value="${view.shopPhoto3FileDeleteCheck}">
        <input type="hidden" name="shopPhoto4FileDeleteCheck"   value="${view.shopPhoto4FileDeleteCheck}">

        <input type="hidden" name="shopMapPctFlgOrg"            value="${view.shopMapPctFlgOrg}">
        <input type="hidden" name="shopPhoto1FlgOrg"            value="${view.shopPhoto1FlgOrg}">
        <input type="hidden" name="shopPhoto2FlgOrg"            value="${view.shopPhoto2FlgOrg}">
        <input type="hidden" name="shopPhoto3FlgOrg"            value="${view.shopPhoto3FlgOrg}">
        <input type="hidden" name="shopPhoto4FlgOrg"            value="${view.shopPhoto4FlgOrg}">

        <input type="hidden" name="shopMapPctFilePath"          value="${view.shopMapPctFilePath}">
        <input type="hidden" name="shopPhoto1FilePath"          value="${view.shopPhoto1FilePath}">
        <input type="hidden" name="shopPhoto2FilePath"          value="${view.shopPhoto2FilePath}">
        <input type="hidden" name="shopPhoto3FilePath"          value="${view.shopPhoto3FilePath}">
        <input type="hidden" name="shopPhoto4FilePath"          value="${view.shopPhoto4FilePath}">

        <input type="hidden" name="shopMapPctComment"           value="${view.shopMapPctComment}">
        <input type="hidden" name="shopPhoto1Comment"           value="${view.shopPhoto1Comment}">
        <input type="hidden" name="shopPhoto2Comment"           value="${view.shopPhoto2Comment}">
        <input type="hidden" name="shopPhoto3Comment"           value="${view.shopPhoto3Comment}">
        <input type="hidden" name="shopPhoto4Comment"           value="${view.shopPhoto4Comment}">

        <input type="hidden" name="updDt"                       value="${view.updDt}">
        <input type="hidden" name="updId"                       value="${view.updId}">
        <input type="submit" value="削除" name="commit">
        <!-- 2009/06 李昊燮追加終了 -->

        <input type="button" name="" value="戻る" onClick="_submit('ShopImageDeleteConfirmBack.do')">
      </p>
    </html:form>

  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
