<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="取引先 物件枠設定情報更新" />
<c:set var="view"  value="${TorihikisakiWakuInfoUpdateView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--
 addEvent('load', window, function(){document.getElementsByName('backButton')[0].focus();});
-->
</script>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="demand/TorihikisakiInfo.do" paramId="torihikisakiSeq" paramName="view" paramProperty="torihikisakiSeq">取引先詳細</html:link>
      &gt;<c:out value="${title}"></c:out>
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}" />
    </html:messages>

    <p class="section_header">取引先情報</p>

    <table class="type_detail">
      <colgroup>
        <col span="1" width="20%" class="type_detail_head" >
        <col span="1" width="30%" class="type_detail_body" >
        <col span="1" width="20%" class="type_detail_head" >
        <col span="1" width="30%" class="type_detail_body" >
      </colgroup>
      <tr>
        <th>不動産会社名</th>
        <td colspan="3"><c:out value="${view.fudousanName}" /></td>
      </tr>
      <tr>
        <th>取引先名</th>
        <td><c:out value="${view.torihikisakiName}" /></td>
        <th>取引先コード</th>
        <td><c:out value="${view.fudousanCd}" />-<c:out value="${view.torihikisakiCd}" /></td>
      </tr>
      <tr>
        <th rowspan="4">住所</th>
        <td colspan="3">
          <c:if test="${not empty view.zipCd}">
            〒<c:out value="${view.zipCd}"/>
          </c:if>&nbsp;
        </td>
      </tr>
      <tr>
        <td colspan="3"><c:out value="${view.prefName}" />&nbsp;</td>
      </tr>
      <tr>
        <td colspan="3"><c:out value="${view.address1}" />&nbsp;</td>
      </tr>
      <tr>
        <td colspan="3"><c:out value="${view.address2}" />&nbsp;</td>
      </tr>
      <tr>
        <th>電話番号</th>
        <td><c:out value="${view.tel}" /></td>
        <th>FAX番号</th>
        <td><c:out value="${view.fax}" /></td>
      </tr>
      <tr>
        <th>担当者名</th>
        <td colspan="3"><c:out value="${view.tantou}" /></td>
      </tr>
      <tr>
        <th>取引担当支社</th>
        <td colspan="3"><c:out value="${view.shisya}" /></td>
      </tr>
      <tr>
        <th>登録日</th>
        <td><c:out value="${view.insDt}" /></td>
        <th>更新日</th>
        <td><c:out value="${view.updDt}" /></td>
      </tr>
    </table>

    <!--物件枠設定情報-->
    <p class="section_header">物件枠設定情報</p>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="20%" class="type_detail_head">
        <col span="1" width="80%" class="type_detail_body" >
      </colgroup>
      <tr>
        <th>適用月</th>
        <td><c:out value="${view.startYmForDisplay}"></c:out></td>
      </tr>
      <tr>
        <th>物件枠</th>
        <td>
          <c:choose>
            <c:when test="${view.bukkenCnt eq '999999'}">
              <c:out value="${view.bukkenCntNote}"/>件
            </c:when>
            <c:otherwise>
              <c:out value="${view.bukkenCnt}"/>件
            </c:otherwise>
          </c:choose>
        </td>
      </tr>
      <tr>
        <th>リスティング枠</th>
        <td>
          <c:choose>
            <c:when test="${view.tokusenCnt eq '999999'}">
              <c:out value="${view.tokusenCntNote}"/>件
            </c:when>
            <c:otherwise>
              <c:out value="${view.tokusenCnt}"/>件
            </c:otherwise>
          </c:choose>
        </td>
      </tr>
    </table>

    <html:form action="demand/TorihikisakiWakuInfoUpdateCommit.do" onsubmit="disableSubmit(this);">
      <div class="add_from">
        <input type="hidden" name="torihikisakiSeq"   value="${view.torihikisakiSeq}">
        <input type="hidden" name="torihikisakiUpdDt" value="${view.torihikisakiUpdDt}">
        <input type="hidden" name="bukkenCnt"         value="${view.bukkenCnt}">
        <input type="hidden" name="bukkenCntNote"     value="${view.bukkenCntNote}">
        <input type="hidden" name="tokusenCnt"        value="${view.tokusenCnt}">
        <input type="hidden" name="tokusenCntNote"    value="${view.tokusenCntNote}">
        <input type="hidden" name="startYmForDisplay" value="${view.startYmForDisplay}">
        <input type="hidden" name="startYm"            value="${view.startYm}">
        <input type="hidden" name="updDt"             value="${view.updDt}">
        <input type="submit" value="更新" >
        <input type="button" name="backButton" value="戻る" onclick="_submit('TorihikisakiWakuInfoUpdatePageBack.do')">
      </div>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>