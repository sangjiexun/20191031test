<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
    <table class="type_detail_pre">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th class="text-left">承認状態</th>
        <td>
          <chintai:CodePrint nameKey="SHOPBUKKEN_CERTIFY_FLG_NAME" valueKey="SHOPBUKKEN_CERTIFY_FLG_VALUE" code="${view.certifyFlg}"/>
        </td>
      </tr>
    </table>
	<table class="type_detail">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tbody>
          <c:set var="ctZeroFlg" value="" />
          <c:set var="ablZeroFlg" value="" />
          <c:if test="${view.shopRireki.shopStatus == '0' or view.shopRireki.ctStatus == '0'}"><c:set var="ctZeroFlg" value="1" /></c:if>
          <c:if test="${view.shopRireki.shopStatus == '0' or view.shopRireki.ablStatus == '0'}"><c:set var="ablZeroFlg" value="1" /></c:if>
      	  <c:set var="bukkenCount" value="${view.bukkenCount}"/>
	      <tr>
	        <th class="text-left">現在の有効物件数</th>
	        <td>CHINTAI <c:choose><c:when test="${ctZeroFlg == '1'}">0 件</c:when><c:otherwise>${bukkenCount.yukoCt} 件</c:otherwise></c:choose> / エイブル <c:choose><c:when test="${ablZeroFlg == '1'}">0 件</c:when><c:otherwise>${bukkenCount.yukoAbl} 件</c:otherwise></c:choose></td>
	      </tr>
	      <tr>
	        <th class="text-left">定借物件掲載数</th>
	        <td>CHINTAI <c:choose><c:when test="${ctZeroFlg == '1'}">0 件</c:when><c:otherwise>${bukkenCount.teishakuCt} 件</c:otherwise></c:choose> / エイブル <c:choose><c:when test="${ablZeroFlg == '1'}">0 件</c:when><c:otherwise>${bukkenCount.teishakuAbl} 件</c:otherwise></c:choose></td>
	      </tr>
	      <tr>
	        <th class="text-left">テナント物件掲載数</th>
	        <td>CHINTAI <c:choose><c:when test="${ctZeroFlg == '1'}">0 件</c:when><c:otherwise>${bukkenCount.tenantCt} 件</c:otherwise></c:choose> / エイブル <c:choose><c:when test="${ablZeroFlg == '1'}">0 件</c:when><c:otherwise>${bukkenCount.tenantAbl} 件</c:otherwise></c:choose></td>
	      </tr>
      </tbody>
    </table>