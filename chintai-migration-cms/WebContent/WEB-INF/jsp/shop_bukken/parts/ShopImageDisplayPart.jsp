<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
    <table class="type_detail">
      <colgroup>
        <col width="25%">
        <col width="25%">
        <col width="25%">
        <col width="25%">
      </colgroup>
      <tr>
        <th colspan="2" class="text-left">店舗地図</th>
        <th colspan="2" class="text-left">店舗地図コメント</th>
      </tr>
      <tr>
<c:choose>
  <c:when test="${view.shopMapPctFlgOrg eq '1'}">
        <td colspan="2"><img src="${view.shopMapPctFilePath}" alt="店舗地図" title="店舗地図"></td>
  </c:when>
  <c:otherwise>
        <td colspan="2">画像がありません。</td>
  </c:otherwise>
</c:choose>
        <td colspan="2"><c:out value="${view.shopMapPctComment}" /></td>
      </tr>
      <tr>
        <th class="text-left">店舗画像１(店外写真)</th>
        <th class="text-left">店舗画像１(店外写真)コメント</th>
        <th class="text-left">店舗画像２(スタッフ写真)</th>
        <th class="text-left">店舗画像２(スタッフ写真)コメント</th>
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
       <td><c:out value="${view.shopPhoto1Comment}"/></td>
<c:choose>
  <c:when test="${view.shopPhoto2FlgOrg eq '1'}">
        <td><img src="${view.shopPhoto2FilePath}" alt="店舗画像２(スタッフ写真)" title="店舗画像２(スタッフ写真)"></td>
  </c:when>
  <c:otherwise>
        <td>画像がありません。</td>
  </c:otherwise>
</c:choose>
        <td><c:out value="${view.shopPhoto2Comment}"/></td>
      </tr>

      <tr>
        <th class="text-left">店舗画像３(店内写真)</th>
        <th class="text-left">店舗画像３(店内写真)コメント</th>
        <th class="text-left">店舗画像４(スタッフ接客写真)</th>
        <th class="text-left">店舗画像４(スタッフ接客写真)コメント</th>
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
       <td><c:out value="${view.shopPhoto3Comment}"/></td>
<c:choose>
  <c:when test="${view.shopPhoto4FlgOrg eq '1'}">
        <td><img src="${view.shopPhoto4FilePath}" alt="店舗画像４(スタッフ接客写真)" title="店舗画像４(スタッフ接客写真)"></td>
  </c:when>
  <c:otherwise>
        <td>画像がありません。</td>
  </c:otherwise>
</c:choose>
        <td><c:out value="${view.shopPhoto4Comment}"/></td>
      </tr>
    </table>

