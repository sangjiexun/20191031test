<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
    <p class="section_header">契約種別</p>
    <table class="type_detail_pre">
        <colgroup>
          <col width="22%">
          <col width="78%">
        </colgroup>
        <tr>
          <th>契約種別</th>
          <td><chintai:CodePrint nameKey="KEIYAKU_SHUBETSU_NAME" valueKey="KEIYAKU_SHUBETSU_VALUE" code="${view.keiyakuShubetsu}"/></td>
        </tr>
    </table>


    <p class="section_header">契約情報</p>
    <table class="type_detail_pre">
        <colgroup>
          <col width="22%">
          <col width="30%" style="word-break:break-all;word-wrap:break-word;">
          <col width="48%">
        </colgroup>
        <tr>
            <th>&nbsp;</th>
            <th>契約有無</th>
            <th>契約期間</th>
        </tr>
        <tr>
            <th>基本契約</th>
            <td>
<c:choose>
  <c:when test="${view.keiyakuShubetsu eq '1'}">
                <label>-</label>
  </c:when>
  <c:when test="${view.kihonKeiyakuFlg eq '1'}">
                <label>契約開始する</label>
  </c:when>
  <c:otherwise>
                <label>契約終了する</label>
  </c:otherwise>
</c:choose>
            </td>
            <td>
              <label>
<c:choose>
  <c:when test="${view.keiyakuShubetsu eq '1'}">
            <fmt:parseDate value="${view.today}" var="today" pattern="yyyyMM"/>
            <fmt:formatDate  value="${today}" pattern="yyyy年MM月" />
            ～ 無期限
  </c:when>
  <c:when test="${view.kihonKeiyakuFlg eq '0'}">
                <label>-</label>
  </c:when>
  <c:when test="${not empty view.keiyakuStartYm and not empty view.keiyakuEndYm}">
            <fmt:parseDate value="${view.keiyakuStartYm}" var="startYm" pattern="yyyyMM"/>
            <fmt:formatDate  value="${startYm}" pattern="yyyy年MM月" />
            ～
            <fmt:parseDate value="${view.keiyakuEndYm}" var="endYm" pattern="yyyyMM"/>
            <fmt:formatDate  value="${endYm}" pattern="yyyy年MM月" />
  </c:when>
  <c:otherwise>
            <fmt:parseDate value="${view.keiyakuStartYm}" var="startYm" pattern="yyyyMM"/>
            <fmt:formatDate  value="${startYm}" pattern="yyyy年MM月" />
            ～ 無期限
  </c:otherwise>
</c:choose>
              </label>
            </td>
        </tr>
        <tr>
            <th>クーポン発行(オプション契約)</th>
            <td>
<c:choose>
  <c:when test="${view.keiyakuShubetsu eq '1'}">
                <label>-</label>
  </c:when>
  <c:when test="${view.kihonKeiyakuFlg eq '0'}">
                <label>-</label>
  </c:when>
  <c:when test="${view.couponKeiyakuFlg eq '1'}">
              <label>契約する</label>
  </c:when>
  <c:otherwise>
              <label>契約しない</label>
  </c:otherwise>
</c:choose>
            </td>
            <td>
<c:choose>
  <c:when test="${view.keiyakuShubetsu eq '1'}">
                <label>-</label>
  </c:when>
  <c:when test="${view.kihonKeiyakuFlg eq '0' or view.couponKeiyakuFlg eq '0'}">
                -
  </c:when>
  <c:when test="${not empty view.couponStartYm and not empty view.couponEndYm}">
            <fmt:parseDate value="${view.couponStartYm}" var="startYm" pattern="yyyyMM"/>
            <fmt:formatDate  value="${startYm}" pattern="yyyy年MM月" />
            ～
            <fmt:parseDate value="${view.couponEndYm}" var="endYm" pattern="yyyyMM"/>
            <fmt:formatDate  value="${endYm}" pattern="yyyy年MM月" />
  </c:when>
  <c:otherwise>
            <fmt:parseDate value="${view.couponStartYm}" var="startYm" pattern="yyyyMM"/>
            <fmt:formatDate  value="${startYm}" pattern="yyyy年MM月" />
            ～ 無期限
  </c:otherwise>
</c:choose>
            </td>
        </tr>
        <tr>
           <th>外部リンク表示(オプション契約)</th>
           <td>
<c:choose>
  <c:when test="${view.keiyakuShubetsu eq '1'}">
                <label>-</label>
  </c:when>
  <c:when test="${view.kihonKeiyakuFlg eq '0'}">
                -
  </c:when>
  <c:when test="${view.linkKeiyakuFlg eq '1'}">
              <label>契約する</label>
  </c:when>
  <c:otherwise>
              <label>契約しない</label>
  </c:otherwise>
</c:choose>
           </td>
           <td>
<c:choose>
  <c:when test="${view.keiyakuShubetsu eq '1'}">
                <label>-</label>
  </c:when>
  <c:when test="${view.kihonKeiyakuFlg eq '0' or view.linkKeiyakuFlg eq '0'}">
                -
  </c:when>
  <c:when test="${not empty view.linkStartYm and not empty view.linkEndYm}">
            <fmt:parseDate value="${view.linkStartYm}" var="startYm" pattern="yyyyMM"/>
            <fmt:formatDate  value="${startYm}" pattern="yyyy年MM月" />
            ～
            <fmt:parseDate value="${view.linkEndYm}" var="endYm" pattern="yyyyMM"/>
            <fmt:formatDate  value="${endYm}" pattern="yyyy年MM月" />
  </c:when>
  <c:otherwise>
            <fmt:parseDate value="${view.linkStartYm}" var="startYm" pattern="yyyyMM"/>
            <fmt:formatDate  value="${startYm}" pattern="yyyy年MM月" />
            ～ 無期限
  </c:otherwise>
</c:choose>
           </td>
        </tr>
        <tr>
           <th>備考</th>
           <td colspan="2"><label><chintai:filter changeNL2BR="true"><c:out value="${view.note}" /></chintai:filter></label></td>
        </tr>
    </table>

    <p class="section_header">出稿対象駅／市区町村数上限設定</p>
    <table class="type_detail_pre">
        <colgroup>
          <col width="22%">
          <col width="78%">
        </colgroup>
        <tr>
          <th>出稿対象駅上限数</th>
<c:choose>
  <c:when test="${not empty view.ekiCnt}">
          <td><label><c:out value="${view.ekiCnt}" />駅</label></td>
  </c:when>
  <c:otherwise>
          <td><label>-</label></td>
  </c:otherwise>
</c:choose>
        </tr>
        <tr>
          <th>出稿対象市区町村上限数</th>
<c:choose>
  <c:when test="${not empty view.cityCnt}">
          <td><label><c:out value="${view.cityCnt}" />市区町村</label></td>
  </c:when>
  <c:otherwise>
          <td><label>-</label></td>
  </c:otherwise>
</c:choose>
        </tr>
    </table>
