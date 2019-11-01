<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.Date"
%>
      <table class="type_list" style="margin-bottom: 0">
      <tr>
        <th>店舗コード<br>状態</th>
        <th>会社名<br>事務所名</th>
        <th>CHINTAI掲載<br>エイブル掲載<br>データ元</th>
        <th>連絡<br>方法</th>
        <th>有効物件数</th>
        <th>初回審査<br>返信持ち物件数</th>
        <th>定期審査<br>返信持ち物件数</th>
        <th>返信持ち率</th>
      </tr>
      <tr>
        <td>
          ${view.shopCd}<br>
          <chintai:CodePrint code="${view.shopStatus}"  nameKey="STATUS_NAME" valueKey="STATUS_VALUE"/>
        </td>
        <td align="left"><c:out value="${view.company}" /><br><c:out value="${view.bumon}" /></td>
        <td>
          <chintai:CodePrint nameKey="SHOPBUKKEN_CT_FLG_NAME" valueKey="SHOPBUKKEN_CT_FLG_VALUE" code="${view.ctStatus}"/><br>
          <chintai:CodePrint nameKey="SHOPBUKKEN_ABL_FLG_NAME" valueKey="SHOPBUKKEN_ABL_FLG_VALUE" code="${view.ablStatus}"/><br>
          <chintai:CodePrint code="${view.clientSystemType}" nameKey="CLIENTSYSTEM_NAME"   valueKey="CLIENTSYSTEM_VALUE"/>
        </td>
        <td><chintai:CodePrint code="${view.fmKbn}" nameKey="WEB_FM_KBN_NAME" valueKey="WEB_FM_KBN_VALUE"/></td>
          <td class="right"><c:out value="${view.bukkenCnt}" /></td>
          <td class="right"><c:out value="${view.syokaiShinsaCnt}" /></td>
          <td class="right"><c:out value="${view.teikiShinsaCnt}" /></td>
          <td class="right"><c:out value="${view.returnRate}" />%</td>
      </tr>
    </table>