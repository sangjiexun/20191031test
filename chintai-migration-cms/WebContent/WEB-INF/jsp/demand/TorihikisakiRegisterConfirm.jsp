<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="取引先新規登録" />
<c:set var="view"  value="${TorihikisakiRegisterView}" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<script type="text/javascript">
<!--
addEvent('load', window, function(){document.getElementsByName('back')[0].focus();});
-->
</script>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link>&gt;
      <html:link action="/demand/TorihikisakiSearchPaging.do">取引先メンテナンス</html:link>&gt;
      <c:out value="${title}"/>
    </div>
    <h1><c:out value="${title}"/></h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="msg"/>
    </html:messages>

   <p class="section_header">取引先情報</p>
   <html:form action="demand/TorihikisakiRegisterCommit.do" onsubmit="disableSubmit(this);">
    <table class="type_detail">
      <colgroup>
        <col span="1" width="20%" class="type_detail_head">
        <col span="1" width="80%" class="type_detail_body">
      </colgroup>
      <tr>
        <th>不動産会社名</th>
        <td colspan="3"><c:out value="${view.fudousanName}"/></td>
      </tr>
      <tr>
        <th>取引先名</th>
        <td><c:out value="${view.torihikisakiName}"/></td>
      </tr>
      <tr>
        <th rowspan="4">住所</th>
        <td colspan="3">
          <c:if test="${not empty view.zipCd1}">
            〒<c:out value="${view.zipCd1}"/>-<c:out value="${view.zipCd2}"/>
          </c:if>&nbsp;
        </td>
      </tr>
      <tr>
        <td colspan="3"><c:out value="${view.prefName}"/>&nbsp;</td>
      </tr>
      <tr>
        <td colspan="3"><c:out value="${view.address1}"/>&nbsp;</td>
      </tr>
      <tr>
        <td colspan="3"><c:out value="${view.address2}"/>&nbsp;</td>
      </tr>
      <tr>
        <th>電話番号</th>
        <td><c:out value="${view.tel}"/></td>
      </tr>
      <tr>
        <th>FAX番号</th>
        <td><c:out value="${view.fax}"/></td>
      </tr>
      <tr>
        <th>担当者名</th>
        <td><c:out value="${view.tantou}"/></td>
      </tr>
      <tr>
        <th>取引担当支社</th>
        <td colspan="3"><c:out value="${view.shisyaName}"/></td>
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
        <td><c:out value="${view.applyYear}"/>年<c:out value="${view.applyMonth}"/>月</td>
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
    <p>
      <input type="hidden" name="fudousanName"     value="${fn:escapeXml(view.fudousanName)}">
      <input type="hidden" name="fudousanCd"       value="${view.fudousanCd}">
      <input type="hidden" name="torihikisakiName" value="${fn:escapeXml(view.torihikisakiName)}">
      <input type="hidden" name="zipCd1"           value="${view.zipCd1}">
      <input type="hidden" name="zipCd2"           value="${view.zipCd2}">
      <input type="hidden" name="prefCd"           value="${view.prefCd}">
      <input type="hidden" name="address1"         value="${fn:escapeXml(view.address1)}">
      <input type="hidden" name="address2"         value="${fn:escapeXml(view.address2)}">
      <input type="hidden" name="tel"              value="${view.tel}">
      <input type="hidden" name="fax"              value="${view.fax}">
      <input type="hidden" name="tantou"           value="${fn:escapeXml(view.tantou)}">
      <input type="hidden" name="shisyaCd"         value="${view.shisyaCd}">
      <input type="hidden" name="applyYear"        value="${view.applyYear}">
      <input type="hidden" name="applyMonth"       value="${view.applyMonth}">
      <input type="hidden" name="bukkenCnt"        value="${view.bukkenCnt}">
      <input type="hidden" name="bukkenCntNote"    value="${view.bukkenCntNote}">
      <input type="hidden" name="tokusenCnt"       value="${view.tokusenCnt}">
      <input type="hidden" name="tokusenCntNote"   value="${view.tokusenCntNote}">
      <input type="submit" value="登録" >
      <input type="button" name="back" value="戻る" onClick="_submit('TorihikisakiRegisterPageBack.do')">
    </p>
   </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
