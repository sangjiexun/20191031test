<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗画像削除"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<!-- 2009/06 李昊燮追加 -->
<c:set var="view" value="${ShopImageDeleteView}" />

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <a href ="<c:url value="ShopInfo.do"><c:param name="shopCd" value="${ShopImageDeleteView.shopCd}"/></c:url>">
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

    <!-- 店舗画像 -->
    <p class="section_header">削除する画像の選択</p>
    <p>削除する画像をチェックしてください。</p>
    <html:form method="post">

    <table class="type_detail">
      <colgroup>
        <col width="25%">
        <col width="25%">
        <col width="25%">
        <col width="25%">
      </colgroup>
      <tr>
        <th colspan="2">
<c:choose>
  <c:when test="${view.shopMapPctFlgOrg ne '1'}"></c:when>
  <c:when test="${not empty view.shopMapPctFileDeleteCheck}">
          <input type="checkbox" name="shopMapPctFileDeleteCheck" checked="checked"><br>
  </c:when>
  <c:otherwise>
          <input type="checkbox" name="shopMapPctFileDeleteCheck" ><br>
  </c:otherwise>
</c:choose>
          店舗地図
        </th>
        <th colspan="2">店舗地図コメント</th>
      </tr>
      <tr>
<c:choose>
  <c:when test="${view.shopMapPctFlgOrg eq '1'}">
        <td colspan="2"><img src="${ShopImageDeleteView.shopMapPctFilePath}" alt="店舗地図" title="店舗地図"></td>
  </c:when>
  <c:otherwise>
        <td colspan="2">画像がありません。</td>
  </c:otherwise>
</c:choose>
        <td colspan="2"><c:out value="${view.shopMapPctComment}" /></td>
      </tr>

      <tr>
        <th>
<c:choose>
  <c:when test="${view.shopPhoto1FlgOrg ne '1'}"></c:when>
  <c:when test="${not empty view.shopPhoto1FileDeleteCheck}">
          <input type="checkbox" name="shopPhoto1FileDeleteCheck" checked="checked"><br>
  </c:when>
  <c:otherwise>
          <input type="checkbox" name="shopPhoto1FileDeleteCheck" ><br>
  </c:otherwise>
</c:choose>
            店舗画像１(店外写真)
        </th>
        <th>店舗画像１(店外写真)コメント</th>
        <th>
<c:choose>
  <c:when test="${view.shopPhoto2FlgOrg ne '1'}"></c:when>
  <c:when test="${not empty view.shopPhoto2FileDeleteCheck}">
          <input type="checkbox" name="shopPhoto2FileDeleteCheck" checked="checked"><br>
  </c:when>
  <c:otherwise>
          <input type="checkbox" name="shopPhoto2FileDeleteCheck" ><br>
  </c:otherwise>
</c:choose>
            店舗画像２(スタッフ写真)
        </th>
        <th>店舗画像２(スタッフ写真)コメント</th>
      </tr>

      <tr>
<c:choose>
  <c:when test="${view.shopPhoto1FlgOrg eq '1'}">
        <td><img src="${view.shopPhoto1FilePath}" alt="店舗画像１(店外写真)" title="店舗画像１(店外写真)"></td>
  </c:when>
  <c:otherwise>
        <td>画像がありません。</td>
  </c:otherwise>
</c:choose>
        <td><c:out value="${view.shopPhoto1Comment}" /></td>
<c:choose>
  <c:when test="${view.shopPhoto2FlgOrg == '1'}">
        <td><img src="${view.shopPhoto2FilePath}" alt="店舗画像２(スタッフ写真)" title="店舗画像２(スタッフ写真)"></td>
  </c:when>
  <c:otherwise>
        <td>画像がありません。</td>
  </c:otherwise>
</c:choose>
        <td><c:out value="${view.shopPhoto2Comment}" /></td>
      </tr>

      <tr>
        <th>
<c:choose>
  <c:when test="${view.shopPhoto3FlgOrg ne '1'}"></c:when>
  <c:when test="${not empty view.shopPhoto3FileDeleteCheck}">
          <input type="checkbox" name="shopPhoto3FileDeleteCheck" checked="checked"><br>
  </c:when>
  <c:otherwise>
          <input type="checkbox" name="shopPhoto3FileDeleteCheck"><br>
  </c:otherwise>
</c:choose>
            店舗画像３(店内写真)
        </th>
        <th>店舗画像３(店内写真)コメント</th>
        <th>
<c:choose>
  <c:when test="${view.shopPhoto4FlgOrg ne '1'}"></c:when>
  <c:when test="${not empty view.shopPhoto4FileDeleteCheck}">
          <input type="checkbox" name="shopPhoto4FileDeleteCheck" checked="checked"><br>
  </c:when>
  <c:otherwise>
          <input type="checkbox" name="shopPhoto4FileDeleteCheck"><br>
  </c:otherwise>
</c:choose>
            店舗画像４(スタッフ接客写真)
        </th>
        <th>店舗画像４(スタッフ接客写真)コメント</th>
      </tr>

      <tr>
<c:choose>
  <c:when test="${view.shopPhoto3FlgOrg eq '1'}">
        <td><img src="${view.shopPhoto3FilePath}" alt="店舗画像３(店内写真)" title="店舗画像３(店内写真)"></td>
  </c:when>
  <c:otherwise>
        <td>画像がありません。</td>
  </c:otherwise>
</c:choose>
        <td><c:out value="${view.shopPhoto3Comment}" /></td>
<c:choose>
  <c:when test="${view.shopPhoto4FlgOrg == '1'}">
        <td><img src="${view.shopPhoto4FilePath}" alt="店舗画像４(スタッフ接客写真)" title="店舗画像４(スタッフ接客写真)"></td>
  </c:when>
  <c:otherwise>
        <td>画像がありません。</td>
  </c:otherwise>
</c:choose>
        <td><c:out value="${view.shopPhoto4Comment}" /></td>
      </tr>
    </table>

      <p>
        <input type="hidden" name="company"              value="${view.company}">
        <input type="hidden" name="bumon"                value="${view.bumon}">
        <input type="hidden" name="shopCd"               value="${view.shopCd}">
        <input type="hidden" name="password"             value="${view.password}">
        <input type="hidden" name="shopMapPctFlgOrg"     value="${view.shopMapPctFlgOrg}">
        <input type="hidden" name="shopPhoto1FlgOrg"     value="${view.shopPhoto1FlgOrg}">
        <input type="hidden" name="shopPhoto2FlgOrg"     value="${view.shopPhoto2FlgOrg}">
        <input type="hidden" name="shopPhoto3FlgOrg"     value="${view.shopPhoto3FlgOrg}">
        <input type="hidden" name="shopPhoto4FlgOrg"     value="${view.shopPhoto4FlgOrg}">

        <input type="hidden" name="shopMapPctFilePath"   value="${view.shopMapPctFilePath}">
        <input type="hidden" name="shopPhoto1FilePath"   value="${view.shopPhoto1FilePath}">
        <input type="hidden" name="shopPhoto2FilePath"   value="${view.shopPhoto2FilePath}">
        <input type="hidden" name="shopPhoto3FilePath"   value="${view.shopPhoto3FilePath}">
        <input type="hidden" name="shopPhoto4FilePath"   value="${view.shopPhoto4FilePath}">

        <input type="hidden" name="shopMapPctComment"    value="${view.shopMapPctComment}">
        <input type="hidden" name="shopPhoto1Comment"    value="${view.shopPhoto1Comment}">
        <input type="hidden" name="shopPhoto2Comment"    value="${view.shopPhoto2Comment}">
        <input type="hidden" name="shopPhoto3Comment"    value="${view.shopPhoto3Comment}">
        <input type="hidden" name="shopPhoto4Comment"    value="${view.shopPhoto4Comment}">

        <input type="hidden" name="updDt" value="${view.updDt}">
        <input type="hidden" name="updId" value="${view.updId}">
        <input type="submit" value="確認画面へ" onClick="_submit('ShopImageDeleteConfirm.do')">
        <input type="button" name="" value="戻る" onClick="javascript:location.href='ShopInfo.do?shopCd=${ShopImageDeleteView.shopCd}'">
      </p>
    </html:form>

  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
