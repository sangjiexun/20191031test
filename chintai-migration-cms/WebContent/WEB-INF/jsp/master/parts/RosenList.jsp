<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.Date"
%>
	<c:if test="${not empty RosenSearchView.rosenSearchList}">
      <p class="section_header">検索結果</p>
      <table class="type_list">
        <colgroup>
          <col width="7%">
          <col width="20%">
          <col width="20%">
          <col width="5%">
          <col width="10%">
          <col width="7%">
          <col width="5%">
          <col width="16%">
          <col width="5%">
          <col width="5%">
         </colgroup>
        <tr>
          <th>沿線コード</th>
          <th>沿線名<BR>かな</th>
          <th>沿線略称<BR>略称かな</th>
          <th>タイプ</th>
          <th>沿線シーケンス番号</th>
          <th>エリアコード</th>
          <th>エリア</th>
          <th>会社名</th>
          <th>削除</th>
          <th>配布停止</th>
        </tr>
        <c:forEach items="${RosenSearchView.rosenSearchList}" var="rosenList" varStatus="i">
          <tr>
            <td>
              ${rosenList.ensenCd}
            </td>
            <td class="left">
              <a href ="<c:url value="RosenInfo.do">
                <c:param name="ensenCd" value="${rosenList.ensenCd}"/>
                <c:param name="ensenType" value="${rosenList.ensenType}"/>
                <c:param name="ensenName" value="${rosenList.ensenName}"/>
                <c:param name="ensenKana" value="${rosenList.ensenKana}"/>
                <c:param name="ensenSeq" value="${rosenList.ensenSeq}"/>
                <c:param name="railwaycoName" value="${rosenList.railwaycoName}"/>
                <c:param name="areaName" value="${rosenList.areaName}"/>
                <c:param name="areaCd" value="${rosenList.areaCd}"/>
                <c:param name="ensenType" value="${rosenList.ensenType}"/>
                <c:param name="ensenNameParam" value="${param.ensenNameParam}"/>
                <c:param name="ekiNameParam" value="${param.ekiNameParam}"/>
                <c:param name="ensennameShort" value="${rosenList.ensennameShort}"/>
                <c:param name="ensenkanaShort" value="${rosenList.ensenkanaShort}"/>
              </c:url>">
                <c:out value="${rosenList.ensenName}" /><BR><c:out value="${rosenList.ensenKana}" />
              </a>
            </td>
            <td class="left">
              <c:out value="${rosenList.ensennameShort}" /><BR><c:out value="${rosenList.ensenkanaShort}" />
            </td>
            <td>
              <chintai:CodePrint nameKey="MASTER_ENSENTYPE_NAME" valueKey="MASTER_ENSENTYPE_VALUE" code="${rosenList.ensenType}"/>
            </td>
            <td>
              <c:out value="${rosenList.ensenSeq}"/>
            </td>
            <td>
              <c:out value="${rosenList.areaCd}"/>
            </td>
            <td>
              <c:out value="${rosenList.areaName}"/>
            </td>
            <td>
              <c:out value="${rosenList.railwaycoName}"/>
            </td>
            <td>
              <c:if test="${rosenList.ensenDelFlg == '1'}"><font color="Red">○</font></c:if>
            </td>
            <td>
              <c:if test="${rosenList.ensenUseStopFlg == '1'}"><font color="Red">○</font></c:if>
            </td>
          </tr>
        </c:forEach>
      </table>
    </c:if>